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
package com.google.shopping.merchant.conversions.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing conversion sources for a merchant account.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/conversions/v1beta/conversionsources.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversionSourcesServiceGrpc {

  private ConversionSourcesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.conversions.v1beta.ConversionSourcesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getCreateConversionSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversionSource",
      requestType =
          com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest.class,
      responseType = com.google.shopping.merchant.conversions.v1beta.ConversionSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getCreateConversionSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest,
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        getCreateConversionSourceMethod;
    if ((getCreateConversionSourceMethod =
            ConversionSourcesServiceGrpc.getCreateConversionSourceMethod)
        == null) {
      synchronized (ConversionSourcesServiceGrpc.class) {
        if ((getCreateConversionSourceMethod =
                ConversionSourcesServiceGrpc.getCreateConversionSourceMethod)
            == null) {
          ConversionSourcesServiceGrpc.getCreateConversionSourceMethod =
              getCreateConversionSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.conversions.v1beta
                              .CreateConversionSourceRequest,
                          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConversionSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .CreateConversionSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta.ConversionSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversionSourcesServiceMethodDescriptorSupplier(
                              "CreateConversionSource"))
                      .build();
        }
      }
    }
    return getCreateConversionSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getUpdateConversionSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConversionSource",
      requestType =
          com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest.class,
      responseType = com.google.shopping.merchant.conversions.v1beta.ConversionSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getUpdateConversionSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest,
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        getUpdateConversionSourceMethod;
    if ((getUpdateConversionSourceMethod =
            ConversionSourcesServiceGrpc.getUpdateConversionSourceMethod)
        == null) {
      synchronized (ConversionSourcesServiceGrpc.class) {
        if ((getUpdateConversionSourceMethod =
                ConversionSourcesServiceGrpc.getUpdateConversionSourceMethod)
            == null) {
          ConversionSourcesServiceGrpc.getUpdateConversionSourceMethod =
              getUpdateConversionSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.conversions.v1beta
                              .UpdateConversionSourceRequest,
                          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConversionSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .UpdateConversionSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta.ConversionSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversionSourcesServiceMethodDescriptorSupplier(
                              "UpdateConversionSource"))
                      .build();
        }
      }
    }
    return getUpdateConversionSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest,
          com.google.protobuf.Empty>
      getDeleteConversionSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversionSource",
      requestType =
          com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest,
          com.google.protobuf.Empty>
      getDeleteConversionSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest,
            com.google.protobuf.Empty>
        getDeleteConversionSourceMethod;
    if ((getDeleteConversionSourceMethod =
            ConversionSourcesServiceGrpc.getDeleteConversionSourceMethod)
        == null) {
      synchronized (ConversionSourcesServiceGrpc.class) {
        if ((getDeleteConversionSourceMethod =
                ConversionSourcesServiceGrpc.getDeleteConversionSourceMethod)
            == null) {
          ConversionSourcesServiceGrpc.getDeleteConversionSourceMethod =
              getDeleteConversionSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.conversions.v1beta
                              .DeleteConversionSourceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConversionSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .DeleteConversionSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversionSourcesServiceMethodDescriptorSupplier(
                              "DeleteConversionSource"))
                      .build();
        }
      }
    }
    return getDeleteConversionSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getUndeleteConversionSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteConversionSource",
      requestType =
          com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest.class,
      responseType = com.google.shopping.merchant.conversions.v1beta.ConversionSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getUndeleteConversionSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest,
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        getUndeleteConversionSourceMethod;
    if ((getUndeleteConversionSourceMethod =
            ConversionSourcesServiceGrpc.getUndeleteConversionSourceMethod)
        == null) {
      synchronized (ConversionSourcesServiceGrpc.class) {
        if ((getUndeleteConversionSourceMethod =
                ConversionSourcesServiceGrpc.getUndeleteConversionSourceMethod)
            == null) {
          ConversionSourcesServiceGrpc.getUndeleteConversionSourceMethod =
              getUndeleteConversionSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.conversions.v1beta
                              .UndeleteConversionSourceRequest,
                          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeleteConversionSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .UndeleteConversionSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta.ConversionSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversionSourcesServiceMethodDescriptorSupplier(
                              "UndeleteConversionSource"))
                      .build();
        }
      }
    }
    return getUndeleteConversionSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getGetConversionSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversionSource",
      requestType =
          com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest.class,
      responseType = com.google.shopping.merchant.conversions.v1beta.ConversionSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest,
          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
      getGetConversionSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest,
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        getGetConversionSourceMethod;
    if ((getGetConversionSourceMethod = ConversionSourcesServiceGrpc.getGetConversionSourceMethod)
        == null) {
      synchronized (ConversionSourcesServiceGrpc.class) {
        if ((getGetConversionSourceMethod =
                ConversionSourcesServiceGrpc.getGetConversionSourceMethod)
            == null) {
          ConversionSourcesServiceGrpc.getGetConversionSourceMethod =
              getGetConversionSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest,
                          com.google.shopping.merchant.conversions.v1beta.ConversionSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetConversionSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .GetConversionSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta.ConversionSource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversionSourcesServiceMethodDescriptorSupplier(
                              "GetConversionSource"))
                      .build();
        }
      }
    }
    return getGetConversionSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest,
          com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>
      getListConversionSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversionSources",
      requestType =
          com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest.class,
      responseType =
          com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest,
          com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>
      getListConversionSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest,
            com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>
        getListConversionSourcesMethod;
    if ((getListConversionSourcesMethod =
            ConversionSourcesServiceGrpc.getListConversionSourcesMethod)
        == null) {
      synchronized (ConversionSourcesServiceGrpc.class) {
        if ((getListConversionSourcesMethod =
                ConversionSourcesServiceGrpc.getListConversionSourcesMethod)
            == null) {
          ConversionSourcesServiceGrpc.getListConversionSourcesMethod =
              getListConversionSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.conversions.v1beta
                              .ListConversionSourcesRequest,
                          com.google.shopping.merchant.conversions.v1beta
                              .ListConversionSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConversionSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .ListConversionSourcesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.conversions.v1beta
                                  .ListConversionSourcesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConversionSourcesServiceMethodDescriptorSupplier(
                              "ListConversionSources"))
                      .build();
        }
      }
    }
    return getListConversionSourcesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConversionSourcesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversionSourcesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversionSourcesServiceStub>() {
          @java.lang.Override
          public ConversionSourcesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversionSourcesServiceStub(channel, callOptions);
          }
        };
    return ConversionSourcesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversionSourcesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversionSourcesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversionSourcesServiceBlockingStub>() {
          @java.lang.Override
          public ConversionSourcesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversionSourcesServiceBlockingStub(channel, callOptions);
          }
        };
    return ConversionSourcesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConversionSourcesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversionSourcesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConversionSourcesServiceFutureStub>() {
          @java.lang.Override
          public ConversionSourcesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConversionSourcesServiceFutureStub(channel, callOptions);
          }
        };
    return ConversionSourcesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing conversion sources for a merchant account.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new conversion source.
     * </pre>
     */
    default void createConversionSource(
        com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversionSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information of an existing conversion source. Available only for
     * Merchant Center Destination conversion sources.
     * </pre>
     */
    default void updateConversionSource(
        com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConversionSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives an existing conversion source. If the conversion source is a
     * Merchant Center Destination, it will be recoverable for 30 days. If the
     * conversion source is a Google Analytics Link, it will be deleted
     * immediately and can be restored by creating a new one.
     * </pre>
     */
    default void deleteConversionSource(
        com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversionSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Re-enables an archived conversion source. Only Available for Merchant
     * Center Destination conversion sources.
     * </pre>
     */
    default void undeleteConversionSource(
        com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteConversionSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a conversion source.
     * </pre>
     */
    default void getConversionSource(
        com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversionSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of conversion sources the caller has access to.
     * </pre>
     */
    default void listConversionSources(
        com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversionSourcesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConversionSourcesService.
   *
   * <pre>
   * Service for managing conversion sources for a merchant account.
   * </pre>
   */
  public abstract static class ConversionSourcesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConversionSourcesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConversionSourcesService.
   *
   * <pre>
   * Service for managing conversion sources for a merchant account.
   * </pre>
   */
  public static final class ConversionSourcesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConversionSourcesServiceStub> {
    private ConversionSourcesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversionSourcesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversionSourcesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion source.
     * </pre>
     */
    public void createConversionSource(
        com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversionSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information of an existing conversion source. Available only for
     * Merchant Center Destination conversion sources.
     * </pre>
     */
    public void updateConversionSource(
        com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConversionSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Archives an existing conversion source. If the conversion source is a
     * Merchant Center Destination, it will be recoverable for 30 days. If the
     * conversion source is a Google Analytics Link, it will be deleted
     * immediately and can be restored by creating a new one.
     * </pre>
     */
    public void deleteConversionSource(
        com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversionSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Re-enables an archived conversion source. Only Available for Merchant
     * Center Destination conversion sources.
     * </pre>
     */
    public void undeleteConversionSource(
        com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteConversionSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a conversion source.
     * </pre>
     */
    public void getConversionSource(
        com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ConversionSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversionSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of conversion sources the caller has access to.
     * </pre>
     */
    public void listConversionSources(
        com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversionSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConversionSourcesService.
   *
   * <pre>
   * Service for managing conversion sources for a merchant account.
   * </pre>
   */
  public static final class ConversionSourcesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConversionSourcesServiceBlockingStub> {
    private ConversionSourcesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversionSourcesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversionSourcesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion source.
     * </pre>
     */
    public com.google.shopping.merchant.conversions.v1beta.ConversionSource createConversionSource(
        com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversionSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information of an existing conversion source. Available only for
     * Merchant Center Destination conversion sources.
     * </pre>
     */
    public com.google.shopping.merchant.conversions.v1beta.ConversionSource updateConversionSource(
        com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversionSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Archives an existing conversion source. If the conversion source is a
     * Merchant Center Destination, it will be recoverable for 30 days. If the
     * conversion source is a Google Analytics Link, it will be deleted
     * immediately and can be restored by creating a new one.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversionSource(
        com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversionSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Re-enables an archived conversion source. Only Available for Merchant
     * Center Destination conversion sources.
     * </pre>
     */
    public com.google.shopping.merchant.conversions.v1beta.ConversionSource
        undeleteConversionSource(
            com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteConversionSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a conversion source.
     * </pre>
     */
    public com.google.shopping.merchant.conversions.v1beta.ConversionSource getConversionSource(
        com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversionSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of conversion sources the caller has access to.
     * </pre>
     */
    public com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse
        listConversionSources(
            com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversionSourcesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConversionSourcesService.
   *
   * <pre>
   * Service for managing conversion sources for a merchant account.
   * </pre>
   */
  public static final class ConversionSourcesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConversionSourcesServiceFutureStub> {
    private ConversionSourcesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversionSourcesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversionSourcesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new conversion source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        createConversionSource(
            com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversionSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information of an existing conversion source. Available only for
     * Merchant Center Destination conversion sources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        updateConversionSource(
            com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConversionSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Archives an existing conversion source. If the conversion source is a
     * Merchant Center Destination, it will be recoverable for 30 days. If the
     * conversion source is a Google Analytics Link, it will be deleted
     * immediately and can be restored by creating a new one.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversionSource(
            com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversionSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Re-enables an archived conversion source. Only Available for Merchant
     * Center Destination conversion sources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        undeleteConversionSource(
            com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteConversionSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a conversion source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.conversions.v1beta.ConversionSource>
        getConversionSource(
            com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversionSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of conversion sources the caller has access to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>
        listConversionSources(
            com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversionSourcesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONVERSION_SOURCE = 0;
  private static final int METHODID_UPDATE_CONVERSION_SOURCE = 1;
  private static final int METHODID_DELETE_CONVERSION_SOURCE = 2;
  private static final int METHODID_UNDELETE_CONVERSION_SOURCE = 3;
  private static final int METHODID_GET_CONVERSION_SOURCE = 4;
  private static final int METHODID_LIST_CONVERSION_SOURCES = 5;

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
        case METHODID_CREATE_CONVERSION_SOURCE:
          serviceImpl.createConversionSource(
              (com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.conversions.v1beta.ConversionSource>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONVERSION_SOURCE:
          serviceImpl.updateConversionSource(
              (com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.conversions.v1beta.ConversionSource>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONVERSION_SOURCE:
          serviceImpl.deleteConversionSource(
              (com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNDELETE_CONVERSION_SOURCE:
          serviceImpl.undeleteConversionSource(
              (com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.conversions.v1beta.ConversionSource>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSION_SOURCE:
          serviceImpl.getConversionSource(
              (com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.conversions.v1beta.ConversionSource>)
                  responseObserver);
          break;
        case METHODID_LIST_CONVERSION_SOURCES:
          serviceImpl.listConversionSources(
              (com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.conversions.v1beta
                          .ListConversionSourcesResponse>)
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
            getCreateConversionSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest,
                    com.google.shopping.merchant.conversions.v1beta.ConversionSource>(
                    service, METHODID_CREATE_CONVERSION_SOURCE)))
        .addMethod(
            getUpdateConversionSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest,
                    com.google.shopping.merchant.conversions.v1beta.ConversionSource>(
                    service, METHODID_UPDATE_CONVERSION_SOURCE)))
        .addMethod(
            getDeleteConversionSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONVERSION_SOURCE)))
        .addMethod(
            getUndeleteConversionSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest,
                    com.google.shopping.merchant.conversions.v1beta.ConversionSource>(
                    service, METHODID_UNDELETE_CONVERSION_SOURCE)))
        .addMethod(
            getGetConversionSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest,
                    com.google.shopping.merchant.conversions.v1beta.ConversionSource>(
                    service, METHODID_GET_CONVERSION_SOURCE)))
        .addMethod(
            getListConversionSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest,
                    com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse>(
                    service, METHODID_LIST_CONVERSION_SOURCES)))
        .build();
  }

  private abstract static class ConversionSourcesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversionSourcesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.conversions.v1beta.ConversionSourcesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversionSourcesService");
    }
  }

  private static final class ConversionSourcesServiceFileDescriptorSupplier
      extends ConversionSourcesServiceBaseDescriptorSupplier {
    ConversionSourcesServiceFileDescriptorSupplier() {}
  }

  private static final class ConversionSourcesServiceMethodDescriptorSupplier
      extends ConversionSourcesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConversionSourcesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConversionSourcesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConversionSourcesServiceFileDescriptorSupplier())
                      .addMethod(getCreateConversionSourceMethod())
                      .addMethod(getUpdateConversionSourceMethod())
                      .addMethod(getDeleteConversionSourceMethod())
                      .addMethod(getUndeleteConversionSourceMethod())
                      .addMethod(getGetConversionSourceMethod())
                      .addMethod(getListConversionSourcesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
