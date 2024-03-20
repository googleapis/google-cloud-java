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
package com.google.shopping.merchant.quota.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to get method call quota information per Merchant API method.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/quota/v1beta/quota.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class QuotaServiceGrpc {

  private QuotaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.quota.v1beta.QuotaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest,
          com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
      getListQuotaGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQuotaGroups",
      requestType = com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest.class,
      responseType = com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest,
          com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
      getListQuotaGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest,
            com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
        getListQuotaGroupsMethod;
    if ((getListQuotaGroupsMethod = QuotaServiceGrpc.getListQuotaGroupsMethod) == null) {
      synchronized (QuotaServiceGrpc.class) {
        if ((getListQuotaGroupsMethod = QuotaServiceGrpc.getListQuotaGroupsMethod) == null) {
          QuotaServiceGrpc.getListQuotaGroupsMethod =
              getListQuotaGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest,
                          com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListQuotaGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new QuotaServiceMethodDescriptorSupplier("ListQuotaGroups"))
                      .build();
        }
      }
    }
    return getListQuotaGroupsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static QuotaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QuotaServiceStub>() {
          @java.lang.Override
          public QuotaServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QuotaServiceStub(channel, callOptions);
          }
        };
    return QuotaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QuotaServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QuotaServiceBlockingStub>() {
          @java.lang.Override
          public QuotaServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QuotaServiceBlockingStub(channel, callOptions);
          }
        };
    return QuotaServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static QuotaServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QuotaServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QuotaServiceFutureStub>() {
          @java.lang.Override
          public QuotaServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QuotaServiceFutureStub(channel, callOptions);
          }
        };
    return QuotaServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to get method call quota information per Merchant API method.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the daily call quota and usage per group for your Merchant
     * Center account.
     * </pre>
     */
    default void listQuotaGroups(
        com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQuotaGroupsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service QuotaService.
   *
   * <pre>
   * Service to get method call quota information per Merchant API method.
   * </pre>
   */
  public abstract static class QuotaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return QuotaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service QuotaService.
   *
   * <pre>
   * Service to get method call quota information per Merchant API method.
   * </pre>
   */
  public static final class QuotaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<QuotaServiceStub> {
    private QuotaServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the daily call quota and usage per group for your Merchant
     * Center account.
     * </pre>
     */
    public void listQuotaGroups(
        com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQuotaGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service QuotaService.
   *
   * <pre>
   * Service to get method call quota information per Merchant API method.
   * </pre>
   */
  public static final class QuotaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<QuotaServiceBlockingStub> {
    private QuotaServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the daily call quota and usage per group for your Merchant
     * Center account.
     * </pre>
     */
    public com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse listQuotaGroups(
        com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQuotaGroupsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service QuotaService.
   *
   * <pre>
   * Service to get method call quota information per Merchant API method.
   * </pre>
   */
  public static final class QuotaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<QuotaServiceFutureStub> {
    private QuotaServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QuotaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QuotaServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the daily call quota and usage per group for your Merchant
     * Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>
        listQuotaGroups(com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQuotaGroupsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_QUOTA_GROUPS = 0;

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
        case METHODID_LIST_QUOTA_GROUPS:
          serviceImpl.listQuotaGroups(
              (com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>)
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
            getListQuotaGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest,
                    com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse>(
                    service, METHODID_LIST_QUOTA_GROUPS)))
        .build();
  }

  private abstract static class QuotaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QuotaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.quota.v1beta.QuotaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QuotaService");
    }
  }

  private static final class QuotaServiceFileDescriptorSupplier
      extends QuotaServiceBaseDescriptorSupplier {
    QuotaServiceFileDescriptorSupplier() {}
  }

  private static final class QuotaServiceMethodDescriptorSupplier
      extends QuotaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    QuotaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (QuotaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new QuotaServiceFileDescriptorSupplier())
                      .addMethod(getListQuotaGroupsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
