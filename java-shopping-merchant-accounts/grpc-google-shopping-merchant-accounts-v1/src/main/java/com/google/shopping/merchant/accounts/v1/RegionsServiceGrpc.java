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
 * Manages regions configuration.
 * This API defines the following resource model:
 * - [Region][google.shopping.merchant.accounts.v1.Region]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1/regions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegionsServiceGrpc {

  private RegionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1.RegionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetRegionRequest,
          com.google.shopping.merchant.accounts.v1.Region>
      getGetRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRegion",
      requestType = com.google.shopping.merchant.accounts.v1.GetRegionRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.Region.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetRegionRequest,
          com.google.shopping.merchant.accounts.v1.Region>
      getGetRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.GetRegionRequest,
            com.google.shopping.merchant.accounts.v1.Region>
        getGetRegionMethod;
    if ((getGetRegionMethod = RegionsServiceGrpc.getGetRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getGetRegionMethod = RegionsServiceGrpc.getGetRegionMethod) == null) {
          RegionsServiceGrpc.getGetRegionMethod =
              getGetRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.GetRegionRequest,
                          com.google.shopping.merchant.accounts.v1.Region>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.GetRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.Region.getDefaultInstance()))
                      .setSchemaDescriptor(new RegionsServiceMethodDescriptorSupplier("GetRegion"))
                      .build();
        }
      }
    }
    return getGetRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.CreateRegionRequest,
          com.google.shopping.merchant.accounts.v1.Region>
      getCreateRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRegion",
      requestType = com.google.shopping.merchant.accounts.v1.CreateRegionRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.Region.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.CreateRegionRequest,
          com.google.shopping.merchant.accounts.v1.Region>
      getCreateRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.CreateRegionRequest,
            com.google.shopping.merchant.accounts.v1.Region>
        getCreateRegionMethod;
    if ((getCreateRegionMethod = RegionsServiceGrpc.getCreateRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getCreateRegionMethod = RegionsServiceGrpc.getCreateRegionMethod) == null) {
          RegionsServiceGrpc.getCreateRegionMethod =
              getCreateRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.CreateRegionRequest,
                          com.google.shopping.merchant.accounts.v1.Region>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.CreateRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.Region.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("CreateRegion"))
                      .build();
        }
      }
    }
    return getCreateRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest,
          com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
      getBatchCreateRegionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateRegions",
      requestType = com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest,
          com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
      getBatchCreateRegionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest,
            com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
        getBatchCreateRegionsMethod;
    if ((getBatchCreateRegionsMethod = RegionsServiceGrpc.getBatchCreateRegionsMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getBatchCreateRegionsMethod = RegionsServiceGrpc.getBatchCreateRegionsMethod)
            == null) {
          RegionsServiceGrpc.getBatchCreateRegionsMethod =
              getBatchCreateRegionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest,
                          com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateRegions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("BatchCreateRegions"))
                      .build();
        }
      }
    }
    return getBatchCreateRegionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UpdateRegionRequest,
          com.google.shopping.merchant.accounts.v1.Region>
      getUpdateRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRegion",
      requestType = com.google.shopping.merchant.accounts.v1.UpdateRegionRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.Region.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UpdateRegionRequest,
          com.google.shopping.merchant.accounts.v1.Region>
      getUpdateRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.UpdateRegionRequest,
            com.google.shopping.merchant.accounts.v1.Region>
        getUpdateRegionMethod;
    if ((getUpdateRegionMethod = RegionsServiceGrpc.getUpdateRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getUpdateRegionMethod = RegionsServiceGrpc.getUpdateRegionMethod) == null) {
          RegionsServiceGrpc.getUpdateRegionMethod =
              getUpdateRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.UpdateRegionRequest,
                          com.google.shopping.merchant.accounts.v1.Region>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.UpdateRegionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.Region.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("UpdateRegion"))
                      .build();
        }
      }
    }
    return getUpdateRegionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest,
          com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
      getBatchUpdateRegionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateRegions",
      requestType = com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest,
          com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
      getBatchUpdateRegionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest,
            com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
        getBatchUpdateRegionsMethod;
    if ((getBatchUpdateRegionsMethod = RegionsServiceGrpc.getBatchUpdateRegionsMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getBatchUpdateRegionsMethod = RegionsServiceGrpc.getBatchUpdateRegionsMethod)
            == null) {
          RegionsServiceGrpc.getBatchUpdateRegionsMethod =
              getBatchUpdateRegionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest,
                          com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateRegions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("BatchUpdateRegions"))
                      .build();
        }
      }
    }
    return getBatchUpdateRegionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.DeleteRegionRequest, com.google.protobuf.Empty>
      getDeleteRegionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRegion",
      requestType = com.google.shopping.merchant.accounts.v1.DeleteRegionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.DeleteRegionRequest, com.google.protobuf.Empty>
      getDeleteRegionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.DeleteRegionRequest, com.google.protobuf.Empty>
        getDeleteRegionMethod;
    if ((getDeleteRegionMethod = RegionsServiceGrpc.getDeleteRegionMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getDeleteRegionMethod = RegionsServiceGrpc.getDeleteRegionMethod) == null) {
          RegionsServiceGrpc.getDeleteRegionMethod =
              getDeleteRegionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.DeleteRegionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRegion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.DeleteRegionRequest
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
          com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteRegionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteRegions",
      requestType = com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteRegionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest,
            com.google.protobuf.Empty>
        getBatchDeleteRegionsMethod;
    if ((getBatchDeleteRegionsMethod = RegionsServiceGrpc.getBatchDeleteRegionsMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getBatchDeleteRegionsMethod = RegionsServiceGrpc.getBatchDeleteRegionsMethod)
            == null) {
          RegionsServiceGrpc.getBatchDeleteRegionsMethod =
              getBatchDeleteRegionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchDeleteRegions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegionsServiceMethodDescriptorSupplier("BatchDeleteRegions"))
                      .build();
        }
      }
    }
    return getBatchDeleteRegionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ListRegionsRequest,
          com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
      getListRegionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRegions",
      requestType = com.google.shopping.merchant.accounts.v1.ListRegionsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.ListRegionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.ListRegionsRequest,
          com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
      getListRegionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.ListRegionsRequest,
            com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
        getListRegionsMethod;
    if ((getListRegionsMethod = RegionsServiceGrpc.getListRegionsMethod) == null) {
      synchronized (RegionsServiceGrpc.class) {
        if ((getListRegionsMethod = RegionsServiceGrpc.getListRegionsMethod) == null) {
          RegionsServiceGrpc.getListRegionsMethod =
              getListRegionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.ListRegionsRequest,
                          com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRegions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.ListRegionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.ListRegionsResponse
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

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static RegionsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegionsServiceBlockingV2Stub>() {
          @java.lang.Override
          public RegionsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegionsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return RegionsServiceBlockingV2Stub.newStub(factory, channel);
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
   * - [Region][google.shopping.merchant.accounts.v1.Region]
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
        com.google.shopping.merchant.accounts.v1.GetRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>
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
        com.google.shopping.merchant.accounts.v1.CreateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    default void batchCreateRegions(
        com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateRegionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    default void updateRegion(
        com.google.shopping.merchant.accounts.v1.UpdateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    default void batchUpdateRegions(
        com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateRegionsMethod(), responseObserver);
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
        com.google.shopping.merchant.accounts.v1.DeleteRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRegionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple regions by name from your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    default void batchDeleteRegions(
        com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteRegionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    default void listRegions(
        com.google.shopping.merchant.accounts.v1.ListRegionsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
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
   * - [Region][google.shopping.merchant.accounts.v1.Region]
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
   * - [Region][google.shopping.merchant.accounts.v1.Region]
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
        com.google.shopping.merchant.accounts.v1.GetRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>
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
        com.google.shopping.merchant.accounts.v1.CreateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>
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
     * Creates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public void batchCreateRegions(
        com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateRegionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public void updateRegion(
        com.google.shopping.merchant.accounts.v1.UpdateRegionRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>
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
     * Updates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public void batchUpdateRegions(
        com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateRegionsMethod(), getCallOptions()),
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
        com.google.shopping.merchant.accounts.v1.DeleteRegionRequest request,
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
     * Deletes multiple regions by name from your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public void batchDeleteRegions(
        com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteRegionsMethod(), getCallOptions()),
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
        com.google.shopping.merchant.accounts.v1.ListRegionsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
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
   * - [Region][google.shopping.merchant.accounts.v1.Region]
   * </pre>
   */
  public static final class RegionsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RegionsServiceBlockingV2Stub> {
    private RegionsServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a region defined in your Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.Region getRegion(
        com.google.shopping.merchant.accounts.v1.GetRegionRequest request) {
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
    public com.google.shopping.merchant.accounts.v1.Region createRegion(
        com.google.shopping.merchant.accounts.v1.CreateRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse batchCreateRegions(
        com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateRegionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.Region updateRegion(
        com.google.shopping.merchant.accounts.v1.UpdateRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse batchUpdateRegions(
        com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateRegionsMethod(), getCallOptions(), request);
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
        com.google.shopping.merchant.accounts.v1.DeleteRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple regions by name from your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteRegions(
        com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteRegionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.ListRegionsResponse listRegions(
        com.google.shopping.merchant.accounts.v1.ListRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRegionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service RegionsService.
   *
   * <pre>
   * Manages regions configuration.
   * This API defines the following resource model:
   * - [Region][google.shopping.merchant.accounts.v1.Region]
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
    public com.google.shopping.merchant.accounts.v1.Region getRegion(
        com.google.shopping.merchant.accounts.v1.GetRegionRequest request) {
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
    public com.google.shopping.merchant.accounts.v1.Region createRegion(
        com.google.shopping.merchant.accounts.v1.CreateRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse batchCreateRegions(
        com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateRegionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.Region updateRegion(
        com.google.shopping.merchant.accounts.v1.UpdateRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse batchUpdateRegions(
        com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateRegionsMethod(), getCallOptions(), request);
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
        com.google.shopping.merchant.accounts.v1.DeleteRegionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRegionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple regions by name from your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteRegions(
        com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteRegionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.ListRegionsResponse listRegions(
        com.google.shopping.merchant.accounts.v1.ListRegionsRequest request) {
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
   * - [Region][google.shopping.merchant.accounts.v1.Region]
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
            com.google.shopping.merchant.accounts.v1.Region>
        getRegion(com.google.shopping.merchant.accounts.v1.GetRegionRequest request) {
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
            com.google.shopping.merchant.accounts.v1.Region>
        createRegion(com.google.shopping.merchant.accounts.v1.CreateRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>
        batchCreateRegions(
            com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateRegionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a region definition in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.Region>
        updateRegion(com.google.shopping.merchant.accounts.v1.UpdateRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates one or more regions in your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>
        batchUpdateRegions(
            com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateRegionsMethod(), getCallOptions()), request);
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
        deleteRegion(com.google.shopping.merchant.accounts.v1.DeleteRegionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRegionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple regions by name from your Merchant Center account.
     * Executing this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteRegions(
            com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteRegionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the regions in your Merchant Center account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.ListRegionsResponse>
        listRegions(com.google.shopping.merchant.accounts.v1.ListRegionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRegionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REGION = 0;
  private static final int METHODID_CREATE_REGION = 1;
  private static final int METHODID_BATCH_CREATE_REGIONS = 2;
  private static final int METHODID_UPDATE_REGION = 3;
  private static final int METHODID_BATCH_UPDATE_REGIONS = 4;
  private static final int METHODID_DELETE_REGION = 5;
  private static final int METHODID_BATCH_DELETE_REGIONS = 6;
  private static final int METHODID_LIST_REGIONS = 7;

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
              (com.google.shopping.merchant.accounts.v1.GetRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>)
                  responseObserver);
          break;
        case METHODID_CREATE_REGION:
          serviceImpl.createRegion(
              (com.google.shopping.merchant.accounts.v1.CreateRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_REGIONS:
          serviceImpl.batchCreateRegions(
              (com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_REGION:
          serviceImpl.updateRegion(
              (com.google.shopping.merchant.accounts.v1.UpdateRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.Region>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_REGIONS:
          serviceImpl.batchUpdateRegions(
              (com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REGION:
          serviceImpl.deleteRegion(
              (com.google.shopping.merchant.accounts.v1.DeleteRegionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_REGIONS:
          serviceImpl.batchDeleteRegions(
              (com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_REGIONS:
          serviceImpl.listRegions(
              (com.google.shopping.merchant.accounts.v1.ListRegionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.ListRegionsResponse>)
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
                    com.google.shopping.merchant.accounts.v1.GetRegionRequest,
                    com.google.shopping.merchant.accounts.v1.Region>(service, METHODID_GET_REGION)))
        .addMethod(
            getCreateRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.CreateRegionRequest,
                    com.google.shopping.merchant.accounts.v1.Region>(
                    service, METHODID_CREATE_REGION)))
        .addMethod(
            getBatchCreateRegionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.BatchCreateRegionsRequest,
                    com.google.shopping.merchant.accounts.v1.BatchCreateRegionsResponse>(
                    service, METHODID_BATCH_CREATE_REGIONS)))
        .addMethod(
            getUpdateRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.UpdateRegionRequest,
                    com.google.shopping.merchant.accounts.v1.Region>(
                    service, METHODID_UPDATE_REGION)))
        .addMethod(
            getBatchUpdateRegionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsRequest,
                    com.google.shopping.merchant.accounts.v1.BatchUpdateRegionsResponse>(
                    service, METHODID_BATCH_UPDATE_REGIONS)))
        .addMethod(
            getDeleteRegionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.DeleteRegionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_REGION)))
        .addMethod(
            getBatchDeleteRegionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.BatchDeleteRegionsRequest,
                    com.google.protobuf.Empty>(service, METHODID_BATCH_DELETE_REGIONS)))
        .addMethod(
            getListRegionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.ListRegionsRequest,
                    com.google.shopping.merchant.accounts.v1.ListRegionsResponse>(
                    service, METHODID_LIST_REGIONS)))
        .build();
  }

  private abstract static class RegionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1.RegionsProto.getDescriptor();
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
                      .addMethod(getBatchCreateRegionsMethod())
                      .addMethod(getUpdateRegionMethod())
                      .addMethod(getBatchUpdateRegionsMethod())
                      .addMethod(getDeleteRegionMethod())
                      .addMethod(getBatchDeleteRegionsMethod())
                      .addMethod(getListRegionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
