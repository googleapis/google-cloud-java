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
 * Service for managing partner links.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class PartnerLinkServiceGrpc {

  private PartnerLinkServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.ads.datamanager.v1.PartnerLinkService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreatePartnerLinkRequest,
          com.google.ads.datamanager.v1.PartnerLink>
      getCreatePartnerLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePartnerLink",
      requestType = com.google.ads.datamanager.v1.CreatePartnerLinkRequest.class,
      responseType = com.google.ads.datamanager.v1.PartnerLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.CreatePartnerLinkRequest,
          com.google.ads.datamanager.v1.PartnerLink>
      getCreatePartnerLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.CreatePartnerLinkRequest,
            com.google.ads.datamanager.v1.PartnerLink>
        getCreatePartnerLinkMethod;
    if ((getCreatePartnerLinkMethod = PartnerLinkServiceGrpc.getCreatePartnerLinkMethod) == null) {
      synchronized (PartnerLinkServiceGrpc.class) {
        if ((getCreatePartnerLinkMethod = PartnerLinkServiceGrpc.getCreatePartnerLinkMethod)
            == null) {
          PartnerLinkServiceGrpc.getCreatePartnerLinkMethod =
              getCreatePartnerLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.CreatePartnerLinkRequest,
                          com.google.ads.datamanager.v1.PartnerLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePartnerLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.CreatePartnerLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.PartnerLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PartnerLinkServiceMethodDescriptorSupplier("CreatePartnerLink"))
                      .build();
        }
      }
    }
    return getCreatePartnerLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.DeletePartnerLinkRequest, com.google.protobuf.Empty>
      getDeletePartnerLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePartnerLink",
      requestType = com.google.ads.datamanager.v1.DeletePartnerLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.DeletePartnerLinkRequest, com.google.protobuf.Empty>
      getDeletePartnerLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.DeletePartnerLinkRequest, com.google.protobuf.Empty>
        getDeletePartnerLinkMethod;
    if ((getDeletePartnerLinkMethod = PartnerLinkServiceGrpc.getDeletePartnerLinkMethod) == null) {
      synchronized (PartnerLinkServiceGrpc.class) {
        if ((getDeletePartnerLinkMethod = PartnerLinkServiceGrpc.getDeletePartnerLinkMethod)
            == null) {
          PartnerLinkServiceGrpc.getDeletePartnerLinkMethod =
              getDeletePartnerLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.DeletePartnerLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePartnerLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.DeletePartnerLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PartnerLinkServiceMethodDescriptorSupplier("DeletePartnerLink"))
                      .build();
        }
      }
    }
    return getDeletePartnerLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.SearchPartnerLinksRequest,
          com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
      getSearchPartnerLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchPartnerLinks",
      requestType = com.google.ads.datamanager.v1.SearchPartnerLinksRequest.class,
      responseType = com.google.ads.datamanager.v1.SearchPartnerLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.SearchPartnerLinksRequest,
          com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
      getSearchPartnerLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.SearchPartnerLinksRequest,
            com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
        getSearchPartnerLinksMethod;
    if ((getSearchPartnerLinksMethod = PartnerLinkServiceGrpc.getSearchPartnerLinksMethod)
        == null) {
      synchronized (PartnerLinkServiceGrpc.class) {
        if ((getSearchPartnerLinksMethod = PartnerLinkServiceGrpc.getSearchPartnerLinksMethod)
            == null) {
          PartnerLinkServiceGrpc.getSearchPartnerLinksMethod =
              getSearchPartnerLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.SearchPartnerLinksRequest,
                          com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchPartnerLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.SearchPartnerLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.SearchPartnerLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PartnerLinkServiceMethodDescriptorSupplier("SearchPartnerLinks"))
                      .build();
        }
      }
    }
    return getSearchPartnerLinksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PartnerLinkServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceStub>() {
          @java.lang.Override
          public PartnerLinkServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PartnerLinkServiceStub(channel, callOptions);
          }
        };
    return PartnerLinkServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static PartnerLinkServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceBlockingV2Stub>() {
          @java.lang.Override
          public PartnerLinkServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PartnerLinkServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return PartnerLinkServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PartnerLinkServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceBlockingStub>() {
          @java.lang.Override
          public PartnerLinkServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PartnerLinkServiceBlockingStub(channel, callOptions);
          }
        };
    return PartnerLinkServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PartnerLinkServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PartnerLinkServiceFutureStub>() {
          @java.lang.Override
          public PartnerLinkServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PartnerLinkServiceFutureStub(channel, callOptions);
          }
        };
    return PartnerLinkServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing partner links.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a partner link for the given account.
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
    default void createPartnerLink(
        com.google.ads.datamanager.v1.CreatePartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.PartnerLink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePartnerLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a partner link for the given account.
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
    default void deletePartnerLink(
        com.google.ads.datamanager.v1.DeletePartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePartnerLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for all partner links to and from a given account.
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
    default void searchPartnerLinks(
        com.google.ads.datamanager.v1.SearchPartnerLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchPartnerLinksMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PartnerLinkService.
   *
   * <pre>
   * Service for managing partner links.
   * </pre>
   */
  public abstract static class PartnerLinkServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PartnerLinkServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PartnerLinkService.
   *
   * <pre>
   * Service for managing partner links.
   * </pre>
   */
  public static final class PartnerLinkServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PartnerLinkServiceStub> {
    private PartnerLinkServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartnerLinkServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartnerLinkServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a partner link for the given account.
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
    public void createPartnerLink(
        com.google.ads.datamanager.v1.CreatePartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.PartnerLink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePartnerLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a partner link for the given account.
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
    public void deletePartnerLink(
        com.google.ads.datamanager.v1.DeletePartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePartnerLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for all partner links to and from a given account.
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
    public void searchPartnerLinks(
        com.google.ads.datamanager.v1.SearchPartnerLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchPartnerLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PartnerLinkService.
   *
   * <pre>
   * Service for managing partner links.
   * </pre>
   */
  public static final class PartnerLinkServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PartnerLinkServiceBlockingV2Stub> {
    private PartnerLinkServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartnerLinkServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartnerLinkServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a partner link for the given account.
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
    public com.google.ads.datamanager.v1.PartnerLink createPartnerLink(
        com.google.ads.datamanager.v1.CreatePartnerLinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a partner link for the given account.
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
    public com.google.protobuf.Empty deletePartnerLink(
        com.google.ads.datamanager.v1.DeletePartnerLinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for all partner links to and from a given account.
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
    public com.google.ads.datamanager.v1.SearchPartnerLinksResponse searchPartnerLinks(
        com.google.ads.datamanager.v1.SearchPartnerLinksRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSearchPartnerLinksMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service PartnerLinkService.
   *
   * <pre>
   * Service for managing partner links.
   * </pre>
   */
  public static final class PartnerLinkServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PartnerLinkServiceBlockingStub> {
    private PartnerLinkServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartnerLinkServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartnerLinkServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a partner link for the given account.
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
    public com.google.ads.datamanager.v1.PartnerLink createPartnerLink(
        com.google.ads.datamanager.v1.CreatePartnerLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a partner link for the given account.
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
    public com.google.protobuf.Empty deletePartnerLink(
        com.google.ads.datamanager.v1.DeletePartnerLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for all partner links to and from a given account.
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
    public com.google.ads.datamanager.v1.SearchPartnerLinksResponse searchPartnerLinks(
        com.google.ads.datamanager.v1.SearchPartnerLinksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchPartnerLinksMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PartnerLinkService.
   *
   * <pre>
   * Service for managing partner links.
   * </pre>
   */
  public static final class PartnerLinkServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PartnerLinkServiceFutureStub> {
    private PartnerLinkServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartnerLinkServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartnerLinkServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a partner link for the given account.
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
            com.google.ads.datamanager.v1.PartnerLink>
        createPartnerLink(com.google.ads.datamanager.v1.CreatePartnerLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePartnerLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a partner link for the given account.
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePartnerLink(com.google.ads.datamanager.v1.DeletePartnerLinkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePartnerLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for all partner links to and from a given account.
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
            com.google.ads.datamanager.v1.SearchPartnerLinksResponse>
        searchPartnerLinks(com.google.ads.datamanager.v1.SearchPartnerLinksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchPartnerLinksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PARTNER_LINK = 0;
  private static final int METHODID_DELETE_PARTNER_LINK = 1;
  private static final int METHODID_SEARCH_PARTNER_LINKS = 2;

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
        case METHODID_CREATE_PARTNER_LINK:
          serviceImpl.createPartnerLink(
              (com.google.ads.datamanager.v1.CreatePartnerLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ads.datamanager.v1.PartnerLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_PARTNER_LINK:
          serviceImpl.deletePartnerLink(
              (com.google.ads.datamanager.v1.DeletePartnerLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_PARTNER_LINKS:
          serviceImpl.searchPartnerLinks(
              (com.google.ads.datamanager.v1.SearchPartnerLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.SearchPartnerLinksResponse>)
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
            getCreatePartnerLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.CreatePartnerLinkRequest,
                    com.google.ads.datamanager.v1.PartnerLink>(
                    service, METHODID_CREATE_PARTNER_LINK)))
        .addMethod(
            getDeletePartnerLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.DeletePartnerLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PARTNER_LINK)))
        .addMethod(
            getSearchPartnerLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.SearchPartnerLinksRequest,
                    com.google.ads.datamanager.v1.SearchPartnerLinksResponse>(
                    service, METHODID_SEARCH_PARTNER_LINKS)))
        .build();
  }

  private abstract static class PartnerLinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PartnerLinkServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.PartnerLinkServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PartnerLinkService");
    }
  }

  private static final class PartnerLinkServiceFileDescriptorSupplier
      extends PartnerLinkServiceBaseDescriptorSupplier {
    PartnerLinkServiceFileDescriptorSupplier() {}
  }

  private static final class PartnerLinkServiceMethodDescriptorSupplier
      extends PartnerLinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PartnerLinkServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PartnerLinkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PartnerLinkServiceFileDescriptorSupplier())
                      .addMethod(getCreatePartnerLinkMethod())
                      .addMethod(getDeletePartnerLinkMethod())
                      .addMethod(getSearchPartnerLinksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
