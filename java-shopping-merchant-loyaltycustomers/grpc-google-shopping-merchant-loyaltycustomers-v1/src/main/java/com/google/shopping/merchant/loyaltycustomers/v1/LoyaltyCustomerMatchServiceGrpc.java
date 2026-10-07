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
package com.google.shopping.merchant.loyaltycustomers.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages customer loyalty program memberships for merchants.
 * This service allows all merchants, including non-advertisers, to share their
 * first-party customer data of loyalty program members. Google uses this data
 * to personalize organic free listing shopping experiences, in compliance with
 * the [Merchant Center Terms of
 * Service](https://support.google.com/merchants/answer/160173).
 * The service follows a non-standard, imperative pattern,
 * exposing a single `ManageLoyaltyCustomerMatch` method rather than
 * conventional resource identifiers and CRUD operations. This design protects
 * user privacy by preventing the discovery of a customer's presence or
 * membership status through standard GET or LIST methods.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class LoyaltyCustomerMatchServiceGrpc {

  private LoyaltyCustomerMatchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.loyaltycustomers.v1.LoyaltyCustomerMatchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest,
          com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse>
      getManageLoyaltyCustomerMatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ManageLoyaltyCustomerMatch",
      requestType =
          com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest.class,
      responseType =
          com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest,
          com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse>
      getManageLoyaltyCustomerMatchMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest,
            com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse>
        getManageLoyaltyCustomerMatchMethod;
    if ((getManageLoyaltyCustomerMatchMethod =
            LoyaltyCustomerMatchServiceGrpc.getManageLoyaltyCustomerMatchMethod)
        == null) {
      synchronized (LoyaltyCustomerMatchServiceGrpc.class) {
        if ((getManageLoyaltyCustomerMatchMethod =
                LoyaltyCustomerMatchServiceGrpc.getManageLoyaltyCustomerMatchMethod)
            == null) {
          LoyaltyCustomerMatchServiceGrpc.getManageLoyaltyCustomerMatchMethod =
              getManageLoyaltyCustomerMatchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.loyaltycustomers.v1
                              .ManageLoyaltyCustomerMatchRequest,
                          com.google.shopping.merchant.loyaltycustomers.v1
                              .ManageLoyaltyCustomerMatchResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ManageLoyaltyCustomerMatch"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.loyaltycustomers.v1
                                  .ManageLoyaltyCustomerMatchRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.loyaltycustomers.v1
                                  .ManageLoyaltyCustomerMatchResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LoyaltyCustomerMatchServiceMethodDescriptorSupplier(
                              "ManageLoyaltyCustomerMatch"))
                      .build();
        }
      }
    }
    return getManageLoyaltyCustomerMatchMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LoyaltyCustomerMatchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceStub>() {
          @java.lang.Override
          public LoyaltyCustomerMatchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoyaltyCustomerMatchServiceStub(channel, callOptions);
          }
        };
    return LoyaltyCustomerMatchServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static LoyaltyCustomerMatchServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceBlockingV2Stub>() {
          @java.lang.Override
          public LoyaltyCustomerMatchServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoyaltyCustomerMatchServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return LoyaltyCustomerMatchServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoyaltyCustomerMatchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceBlockingStub>() {
          @java.lang.Override
          public LoyaltyCustomerMatchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoyaltyCustomerMatchServiceBlockingStub(channel, callOptions);
          }
        };
    return LoyaltyCustomerMatchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LoyaltyCustomerMatchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LoyaltyCustomerMatchServiceFutureStub>() {
          @java.lang.Override
          public LoyaltyCustomerMatchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LoyaltyCustomerMatchServiceFutureStub(channel, callOptions);
          }
        };
    return LoyaltyCustomerMatchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages customer loyalty program memberships for merchants.
   * This service allows all merchants, including non-advertisers, to share their
   * first-party customer data of loyalty program members. Google uses this data
   * to personalize organic free listing shopping experiences, in compliance with
   * the [Merchant Center Terms of
   * Service](https://support.google.com/merchants/answer/160173).
   * The service follows a non-standard, imperative pattern,
   * exposing a single `ManageLoyaltyCustomerMatch` method rather than
   * conventional resource identifiers and CRUD operations. This design protects
   * user privacy by preventing the discovery of a customer's presence or
   * membership status through standard GET or LIST methods.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Manages (inserts, updates, or removes) a customer's loyalty tier
     * information.
     * This method serves as a single interface for all changes to a customer's
     * loyalty status. The specific action (insert, update, or remove) is
     * determined by the current state of the merchant-to-customer association and
     * the `loyalty_tier` value provided in the request.
     * **Operation Logic:**
     * * **Upsert (Insert/Update):** Providing any valid tier other than
     * `NON_MEMBER` will associate the customer with that tier. If an association
     * already exists, it will be updated; otherwise, a new one will be created.
     * * **Removal:** Setting `loyalty_tier` to `NON_MEMBER` will remove any
     * existing loyalty association for the customer.
     * **Privacy Note:** To protect user privacy, this method consistently returns
     * a `200 OK` status with a default `LoyaltyCustomer` response if the
     * customer's identifier cannot be matched to a Google account or if the user
     * has not opted into loyalty personalization.
     * </pre>
     */
    default void manageLoyaltyCustomerMatch(
        com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getManageLoyaltyCustomerMatchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LoyaltyCustomerMatchService.
   *
   * <pre>
   * Manages customer loyalty program memberships for merchants.
   * This service allows all merchants, including non-advertisers, to share their
   * first-party customer data of loyalty program members. Google uses this data
   * to personalize organic free listing shopping experiences, in compliance with
   * the [Merchant Center Terms of
   * Service](https://support.google.com/merchants/answer/160173).
   * The service follows a non-standard, imperative pattern,
   * exposing a single `ManageLoyaltyCustomerMatch` method rather than
   * conventional resource identifiers and CRUD operations. This design protects
   * user privacy by preventing the discovery of a customer's presence or
   * membership status through standard GET or LIST methods.
   * </pre>
   */
  public abstract static class LoyaltyCustomerMatchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LoyaltyCustomerMatchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LoyaltyCustomerMatchService.
   *
   * <pre>
   * Manages customer loyalty program memberships for merchants.
   * This service allows all merchants, including non-advertisers, to share their
   * first-party customer data of loyalty program members. Google uses this data
   * to personalize organic free listing shopping experiences, in compliance with
   * the [Merchant Center Terms of
   * Service](https://support.google.com/merchants/answer/160173).
   * The service follows a non-standard, imperative pattern,
   * exposing a single `ManageLoyaltyCustomerMatch` method rather than
   * conventional resource identifiers and CRUD operations. This design protects
   * user privacy by preventing the discovery of a customer's presence or
   * membership status through standard GET or LIST methods.
   * </pre>
   */
  public static final class LoyaltyCustomerMatchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LoyaltyCustomerMatchServiceStub> {
    private LoyaltyCustomerMatchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoyaltyCustomerMatchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoyaltyCustomerMatchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages (inserts, updates, or removes) a customer's loyalty tier
     * information.
     * This method serves as a single interface for all changes to a customer's
     * loyalty status. The specific action (insert, update, or remove) is
     * determined by the current state of the merchant-to-customer association and
     * the `loyalty_tier` value provided in the request.
     * **Operation Logic:**
     * * **Upsert (Insert/Update):** Providing any valid tier other than
     * `NON_MEMBER` will associate the customer with that tier. If an association
     * already exists, it will be updated; otherwise, a new one will be created.
     * * **Removal:** Setting `loyalty_tier` to `NON_MEMBER` will remove any
     * existing loyalty association for the customer.
     * **Privacy Note:** To protect user privacy, this method consistently returns
     * a `200 OK` status with a default `LoyaltyCustomer` response if the
     * customer's identifier cannot be matched to a Google account or if the user
     * has not opted into loyalty personalization.
     * </pre>
     */
    public void manageLoyaltyCustomerMatch(
        com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getManageLoyaltyCustomerMatchMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LoyaltyCustomerMatchService.
   *
   * <pre>
   * Manages customer loyalty program memberships for merchants.
   * This service allows all merchants, including non-advertisers, to share their
   * first-party customer data of loyalty program members. Google uses this data
   * to personalize organic free listing shopping experiences, in compliance with
   * the [Merchant Center Terms of
   * Service](https://support.google.com/merchants/answer/160173).
   * The service follows a non-standard, imperative pattern,
   * exposing a single `ManageLoyaltyCustomerMatch` method rather than
   * conventional resource identifiers and CRUD operations. This design protects
   * user privacy by preventing the discovery of a customer's presence or
   * membership status through standard GET or LIST methods.
   * </pre>
   */
  public static final class LoyaltyCustomerMatchServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LoyaltyCustomerMatchServiceBlockingV2Stub> {
    private LoyaltyCustomerMatchServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoyaltyCustomerMatchServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoyaltyCustomerMatchServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages (inserts, updates, or removes) a customer's loyalty tier
     * information.
     * This method serves as a single interface for all changes to a customer's
     * loyalty status. The specific action (insert, update, or remove) is
     * determined by the current state of the merchant-to-customer association and
     * the `loyalty_tier` value provided in the request.
     * **Operation Logic:**
     * * **Upsert (Insert/Update):** Providing any valid tier other than
     * `NON_MEMBER` will associate the customer with that tier. If an association
     * already exists, it will be updated; otherwise, a new one will be created.
     * * **Removal:** Setting `loyalty_tier` to `NON_MEMBER` will remove any
     * existing loyalty association for the customer.
     * **Privacy Note:** To protect user privacy, this method consistently returns
     * a `200 OK` status with a default `LoyaltyCustomer` response if the
     * customer's identifier cannot be matched to a Google account or if the user
     * has not opted into loyalty personalization.
     * </pre>
     */
    public com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse
        manageLoyaltyCustomerMatch(
            com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getManageLoyaltyCustomerMatchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * LoyaltyCustomerMatchService.
   *
   * <pre>
   * Manages customer loyalty program memberships for merchants.
   * This service allows all merchants, including non-advertisers, to share their
   * first-party customer data of loyalty program members. Google uses this data
   * to personalize organic free listing shopping experiences, in compliance with
   * the [Merchant Center Terms of
   * Service](https://support.google.com/merchants/answer/160173).
   * The service follows a non-standard, imperative pattern,
   * exposing a single `ManageLoyaltyCustomerMatch` method rather than
   * conventional resource identifiers and CRUD operations. This design protects
   * user privacy by preventing the discovery of a customer's presence or
   * membership status through standard GET or LIST methods.
   * </pre>
   */
  public static final class LoyaltyCustomerMatchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LoyaltyCustomerMatchServiceBlockingStub> {
    private LoyaltyCustomerMatchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoyaltyCustomerMatchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoyaltyCustomerMatchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages (inserts, updates, or removes) a customer's loyalty tier
     * information.
     * This method serves as a single interface for all changes to a customer's
     * loyalty status. The specific action (insert, update, or remove) is
     * determined by the current state of the merchant-to-customer association and
     * the `loyalty_tier` value provided in the request.
     * **Operation Logic:**
     * * **Upsert (Insert/Update):** Providing any valid tier other than
     * `NON_MEMBER` will associate the customer with that tier. If an association
     * already exists, it will be updated; otherwise, a new one will be created.
     * * **Removal:** Setting `loyalty_tier` to `NON_MEMBER` will remove any
     * existing loyalty association for the customer.
     * **Privacy Note:** To protect user privacy, this method consistently returns
     * a `200 OK` status with a default `LoyaltyCustomer` response if the
     * customer's identifier cannot be matched to a Google account or if the user
     * has not opted into loyalty personalization.
     * </pre>
     */
    public com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse
        manageLoyaltyCustomerMatch(
            com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getManageLoyaltyCustomerMatchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * LoyaltyCustomerMatchService.
   *
   * <pre>
   * Manages customer loyalty program memberships for merchants.
   * This service allows all merchants, including non-advertisers, to share their
   * first-party customer data of loyalty program members. Google uses this data
   * to personalize organic free listing shopping experiences, in compliance with
   * the [Merchant Center Terms of
   * Service](https://support.google.com/merchants/answer/160173).
   * The service follows a non-standard, imperative pattern,
   * exposing a single `ManageLoyaltyCustomerMatch` method rather than
   * conventional resource identifiers and CRUD operations. This design protects
   * user privacy by preventing the discovery of a customer's presence or
   * membership status through standard GET or LIST methods.
   * </pre>
   */
  public static final class LoyaltyCustomerMatchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LoyaltyCustomerMatchServiceFutureStub> {
    private LoyaltyCustomerMatchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoyaltyCustomerMatchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LoyaltyCustomerMatchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Manages (inserts, updates, or removes) a customer's loyalty tier
     * information.
     * This method serves as a single interface for all changes to a customer's
     * loyalty status. The specific action (insert, update, or remove) is
     * determined by the current state of the merchant-to-customer association and
     * the `loyalty_tier` value provided in the request.
     * **Operation Logic:**
     * * **Upsert (Insert/Update):** Providing any valid tier other than
     * `NON_MEMBER` will associate the customer with that tier. If an association
     * already exists, it will be updated; otherwise, a new one will be created.
     * * **Removal:** Setting `loyalty_tier` to `NON_MEMBER` will remove any
     * existing loyalty association for the customer.
     * **Privacy Note:** To protect user privacy, this method consistently returns
     * a `200 OK` status with a default `LoyaltyCustomer` response if the
     * customer's identifier cannot be matched to a Google account or if the user
     * has not opted into loyalty personalization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse>
        manageLoyaltyCustomerMatch(
            com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getManageLoyaltyCustomerMatchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MANAGE_LOYALTY_CUSTOMER_MATCH = 0;

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
        case METHODID_MANAGE_LOYALTY_CUSTOMER_MATCH:
          serviceImpl.manageLoyaltyCustomerMatch(
              (com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.loyaltycustomers.v1
                          .ManageLoyaltyCustomerMatchResponse>)
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
            getManageLoyaltyCustomerMatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.loyaltycustomers.v1
                        .ManageLoyaltyCustomerMatchRequest,
                    com.google.shopping.merchant.loyaltycustomers.v1
                        .ManageLoyaltyCustomerMatchResponse>(
                    service, METHODID_MANAGE_LOYALTY_CUSTOMER_MATCH)))
        .build();
  }

  private abstract static class LoyaltyCustomerMatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoyaltyCustomerMatchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.loyaltycustomers.v1.LoyaltyCustomerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LoyaltyCustomerMatchService");
    }
  }

  private static final class LoyaltyCustomerMatchServiceFileDescriptorSupplier
      extends LoyaltyCustomerMatchServiceBaseDescriptorSupplier {
    LoyaltyCustomerMatchServiceFileDescriptorSupplier() {}
  }

  private static final class LoyaltyCustomerMatchServiceMethodDescriptorSupplier
      extends LoyaltyCustomerMatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LoyaltyCustomerMatchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LoyaltyCustomerMatchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LoyaltyCustomerMatchServiceFileDescriptorSupplier())
                      .addMethod(getManageLoyaltyCustomerMatchMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
