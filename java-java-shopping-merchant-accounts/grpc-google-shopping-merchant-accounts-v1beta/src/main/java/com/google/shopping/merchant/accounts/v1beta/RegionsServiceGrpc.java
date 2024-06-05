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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages regions configuration.
 * This API defines the following resource model:
 * - [Region][google.shopping.merchant.accounts.v1main.Region]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/regions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegionsServiceGrpc {

  private RegionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.RegionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetRegionRequest,
          com.google.shopping.merchant.accounts.v1beta.Region>
      getGetRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRegion",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetRegionRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Region.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetRegionRequest,
          com.google.shopping.merchant.accounts.v1beta.Region>
      getGetRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetRegionRequest,
            com.google.shopping.merchant.accounts.v1beta.Region>
        getGetRegionMethod;
    if ((getGetRegionMethod = RegionsServiceGrpc.getGetRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getGetRegionMethod = RegionsServiceGrpc.getGetRegionMethod) == null) {
          RegionsServiceGrpc.getGetRegionMethod =
              getGetRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetRegionRequest,
                          com.google.shopping.merchant.accounts.v1beta.Region>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Region
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RegionsServiceMethodDescriptorSupplier("GetRegion"))
                      .build();
        }
      }
    }
    return getGetRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest,
          com.google.shopping.merchant.accounts.v1beta.Region>
      getCreateRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRegion",
      requestType = com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Region.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest,
          com.google.shopping.merchant.accounts.v1beta.Region>
      getCreateRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest,
            com.google.shopping.merchant.accounts.v1beta.Region>
        getCreateRegionMethod;
    if ((getCreateRegionMethod = RegionsServiceGrpc.getCreateRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getCreateRegionMethod = RegionsServiceGrpc.getCreateRegionMethod) == null) {
          RegionsServiceGrpc.getCreateRegionMethod =
              getCreateRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest,
                          com.google.shopping.merchant.accounts.v1beta.Region>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Region
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("CreateRegion"))
                      .build();
        }
      }
    }
    return getCreateRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest,
          com.google.shopping.merchant.accounts.v1beta.Region>
      getUpdateRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRegion",
      requestType = com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Region.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest,
          com.google.shopping.merchant.accounts.v1beta.Region>
      getUpdateRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest,
            com.google.shopping.merchant.accounts.v1beta.Region>
        getUpdateRegionMethod;
    if ((getUpdateRegionMethod = RegionsServiceGrpc.getUpdateRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getUpdateRegionMethod = RegionsServiceGrpc.getUpdateRegionMethod) == null) {
          RegionsServiceGrpc.getUpdateRegionMethod =
              getUpdateRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest,
                          com.google.shopping.merchant.accounts.v1beta.Region>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Region
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("UpdateRegion"))
                      .build();
        }
      }
    }
    return getUpdateRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest,
          com.google.protobuf.Empty>
      getDeleteRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRegion",
      requestType = com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest,
          com.google.protobuf.Empty>
      getDeleteRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest,
            com.google.protobuf.Empty>
        getDeleteRegionMethod;
    if ((getDeleteRegionMethod = RegionsServiceGrpc.getDeleteRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getDeleteRegionMethod = RegionsServiceGrpc.getDeleteRegionMethod) == null) {
          RegionsServiceGrpc.getDeleteRegionMethod =
              getDeleteRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("DeleteRegion"))
                      .build();
        }
      }
    }
    return getDeleteRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
      getListRegionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRegions",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
      getListRegionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest,
            com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
        getListRegionsMethod;
    if ((getListRegionsMethod = RegionsServiceGrpc.getListRegionsMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getListRegionsMethod = RegionsServiceGrpc.getListRegionsMethod) == null) {
          RegionsServiceGrpc.getListRegionsMethod =
              getListRegionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRegions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("ListRegions"))
                      .build();
        }
      }
    }
    return getListRegionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RegionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegionsServiceStub>() {
          @java.lang.Override
          public RegionsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegionsServiceStub(channel, callOptions);
          }
        };
    return RegionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegionsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegionsServiceBlockingStub>() {
          @java.lang.Override
          public RegionsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegionsServiceBlockingStub(channel, callOptions);
          }
        };
    return RegionsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RegionsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegionsServiceFutureStub>() {
          @java.lang.Override
          public RegionsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegionsServiceFutureStub(channel, callOptions);
          }
        };
    return RegionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages regions configuration.
   * This API defines the following resource model:
   * - [Region][google.shopping.merchant.accounts.v1main.Region]
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves a region defined in your Merchant Center account.
     * </pre>
     */
    default void getRegion(
        com.google.shopping.merchant.accounts.v1beta.GetRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    default void createRegion(
        com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    default void updateRegion(
        com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a region definition from your Merchant Center account. Executing
     * this method requires admin access.
     * </pre>
     */
    default void deleteRegion(
        com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    default void listRegions(
        com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRegionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RegionsService.
   *
   * <pre>
   * Manages regions configuration.
   * This API defines the following resource model:
   * - [Region][google.shopping.merchant.accounts.v1main.Region]
   * </pre>
   */
  public abstract static class RegionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RegionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RegionsService.
   *
   * <pre>
   * Manages regions configuration.
   * This API defines the following resource model:
   * - [Region][google.shopping.merchant.accounts.v1main.Region]
   * </pre>
   */
  public static final class RegionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RegionsServiceStub> {
    private RegionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a region defined in your Merchant Center account.
     * </pre>
     */
    public void getRegion(
        com.google.shopping.merchant.accounts.v1beta.GetRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRegionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    public void createRegion(
        com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRegionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    public void updateRegion(
        com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRegionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a region definition from your Merchant Center account. Executing
     * this method requires admin access.
     * </pre>
     */
    public void deleteRegion(
        com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRegionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    public void listRegions(
        com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRegionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RegionsService.
   *
   * <pre>
   * Manages regions configuration.
   * This API defines the following resource model:
   * - [Region][google.shopping.merchant.accounts.v1main.Region]
   * </pre>
   */
  public static final class RegionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegionsServiceBlockingStub> {
    private RegionsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a region defined in your Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Region getRegion(
        com.google.shopping.merchant.accounts.v1beta.GetRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Region createRegion(
        com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Region updateRegion(
        com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a region definition from your Merchant Center account. Executing
     * this method requires admin access.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRegion(
        com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse listRegions(
        com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRegionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RegionsService.
   *
   * <pre>
   * Manages regions configuration.
   * This API defines the following resource model:
   * - [Region][google.shopping.merchant.accounts.v1main.Region]
   * </pre>
   */
  public static final class RegionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegionsServiceFutureStub> {
    private RegionsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a region defined in your Merchant Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Region>
        getRegion(com.google.shopping.merchant.accounts.v1beta.GetRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Region>
        createRegion(com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account. Executing this
     * method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Region>
        updateRegion(com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a region definition from your Merchant Center account. Executing
     * this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRegion(com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>
        listRegions(com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRegionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REGION = 0;
  private static final int METHODID_CREATE_REGION = 1;
  private static final int METHODID_UPDATE_REGION = 2;
  private static final int METHODID_DELETE_REGION = 3;
  private static final int METHODID_LIST_REGIONS = 4;

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
        case METHODID_GET_REGION:
          serviceImpl.getRegion(
              (com.google.shopping.merchant.accounts.v1beta.GetRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>)
                  responseObserver);
          break;
        case METHODID_CREATE_REGION:
          serviceImpl.createRegion(
              (com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>)
                  responseObserver);
          break;
        case METHODID_UPDATE_REGION:
          serviceImpl.updateRegion(
              (com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Region>)
                  responseObserver);
          break;
        case METHODID_DELETE_REGION:
          serviceImpl.deleteRegion(
              (com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_REGIONS:
          serviceImpl.listRegions(
              (com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>)
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
            getGetRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetRegionRequest,
                    com.google.shopping.merchant.accounts.v1beta.Region>(
                    service, METHODID_GET_REGION)))
        .addMethod(
            getCreateRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest,
                    com.google.shopping.merchant.accounts.v1beta.Region>(
                    service, METHODID_CREATE_REGION)))
        .addMethod(
            getUpdateRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest,
                    com.google.shopping.merchant.accounts.v1beta.Region>(
                    service, METHODID_UPDATE_REGION)))
        .addMethod(
            getDeleteRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_REGION)))
        .addMethod(
            getListRegionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse>(
                    service, METHODID_LIST_REGIONS)))
        .build();
  }

  private abstract static class RegionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.RegionsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegionsService");
    }
  }

  private static final class RegionsServiceFileDescriptorSupplier
      extends RegionsServiceBaseDescriptorSupplier {
    RegionsServiceFileDescriptorSupplier() {}
  }

  private static final class RegionsServiceMethodDescriptorSupplier
      extends RegionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RegionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RegionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RegionsServiceFileDescriptorSupplier())
                      .addMethod(getGetRegionMethod())
                      .addMethod(getCreateRegionMethod())
                      .addMethod(getUpdateRegionMethod())
                      .addMethod(getDeleteRegionMethod())
                      .addMethod(getListRegionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
