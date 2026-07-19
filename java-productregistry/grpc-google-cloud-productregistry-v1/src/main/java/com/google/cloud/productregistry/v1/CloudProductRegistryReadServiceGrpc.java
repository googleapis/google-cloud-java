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
package com.google.cloud.productregistry.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Product Registry Read Service provides capabilities to access all first
 * and third party Google Cloud products.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudProductRegistryReadServiceGrpc {

  private CloudProductRegistryReadServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.productregistry.v1.CloudProductRegistryReadService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.GetProductSuiteRequest,
          com.google.cloud.productregistry.v1.ProductSuite>
      getGetProductSuiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductSuite",
      requestType = com.google.cloud.productregistry.v1.GetProductSuiteRequest.class,
      responseType = com.google.cloud.productregistry.v1.ProductSuite.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.GetProductSuiteRequest,
          com.google.cloud.productregistry.v1.ProductSuite>
      getGetProductSuiteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.GetProductSuiteRequest,
            com.google.cloud.productregistry.v1.ProductSuite>
        getGetProductSuiteMethod;
    if ((getGetProductSuiteMethod = CloudProductRegistryReadServiceGrpc.getGetProductSuiteMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getGetProductSuiteMethod =
                CloudProductRegistryReadServiceGrpc.getGetProductSuiteMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getGetProductSuiteMethod =
              getGetProductSuiteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.GetProductSuiteRequest,
                          com.google.cloud.productregistry.v1.ProductSuite>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductSuite"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.GetProductSuiteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ProductSuite
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "GetProductSuite"))
                      .build();
        }
      }
    }
    return getGetProductSuiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.ListProductSuitesRequest,
          com.google.cloud.productregistry.v1.ListProductSuitesResponse>
      getListProductSuitesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProductSuites",
      requestType = com.google.cloud.productregistry.v1.ListProductSuitesRequest.class,
      responseType = com.google.cloud.productregistry.v1.ListProductSuitesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.ListProductSuitesRequest,
          com.google.cloud.productregistry.v1.ListProductSuitesResponse>
      getListProductSuitesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.ListProductSuitesRequest,
            com.google.cloud.productregistry.v1.ListProductSuitesResponse>
        getListProductSuitesMethod;
    if ((getListProductSuitesMethod =
            CloudProductRegistryReadServiceGrpc.getListProductSuitesMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getListProductSuitesMethod =
                CloudProductRegistryReadServiceGrpc.getListProductSuitesMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getListProductSuitesMethod =
              getListProductSuitesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.ListProductSuitesRequest,
                          com.google.cloud.productregistry.v1.ListProductSuitesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProductSuites"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ListProductSuitesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ListProductSuitesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "ListProductSuites"))
                      .build();
        }
      }
    }
    return getListProductSuitesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.GetLogicalProductRequest,
          com.google.cloud.productregistry.v1.LogicalProduct>
      getGetLogicalProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLogicalProduct",
      requestType = com.google.cloud.productregistry.v1.GetLogicalProductRequest.class,
      responseType = com.google.cloud.productregistry.v1.LogicalProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.GetLogicalProductRequest,
          com.google.cloud.productregistry.v1.LogicalProduct>
      getGetLogicalProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.GetLogicalProductRequest,
            com.google.cloud.productregistry.v1.LogicalProduct>
        getGetLogicalProductMethod;
    if ((getGetLogicalProductMethod =
            CloudProductRegistryReadServiceGrpc.getGetLogicalProductMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getGetLogicalProductMethod =
                CloudProductRegistryReadServiceGrpc.getGetLogicalProductMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getGetLogicalProductMethod =
              getGetLogicalProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.GetLogicalProductRequest,
                          com.google.cloud.productregistry.v1.LogicalProduct>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLogicalProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.GetLogicalProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.LogicalProduct
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "GetLogicalProduct"))
                      .build();
        }
      }
    }
    return getGetLogicalProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.ListLogicalProductsRequest,
          com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
      getListLogicalProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLogicalProducts",
      requestType = com.google.cloud.productregistry.v1.ListLogicalProductsRequest.class,
      responseType = com.google.cloud.productregistry.v1.ListLogicalProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.ListLogicalProductsRequest,
          com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
      getListLogicalProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.ListLogicalProductsRequest,
            com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
        getListLogicalProductsMethod;
    if ((getListLogicalProductsMethod =
            CloudProductRegistryReadServiceGrpc.getListLogicalProductsMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getListLogicalProductsMethod =
                CloudProductRegistryReadServiceGrpc.getListLogicalProductsMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getListLogicalProductsMethod =
              getListLogicalProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.ListLogicalProductsRequest,
                          com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListLogicalProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ListLogicalProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ListLogicalProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "ListLogicalProducts"))
                      .build();
        }
      }
    }
    return getListLogicalProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest,
          com.google.cloud.productregistry.v1.LogicalProductVariant>
      getGetLogicalProductVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLogicalProductVariant",
      requestType = com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest.class,
      responseType = com.google.cloud.productregistry.v1.LogicalProductVariant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest,
          com.google.cloud.productregistry.v1.LogicalProductVariant>
      getGetLogicalProductVariantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest,
            com.google.cloud.productregistry.v1.LogicalProductVariant>
        getGetLogicalProductVariantMethod;
    if ((getGetLogicalProductVariantMethod =
            CloudProductRegistryReadServiceGrpc.getGetLogicalProductVariantMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getGetLogicalProductVariantMethod =
                CloudProductRegistryReadServiceGrpc.getGetLogicalProductVariantMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getGetLogicalProductVariantMethod =
              getGetLogicalProductVariantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest,
                          com.google.cloud.productregistry.v1.LogicalProductVariant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetLogicalProductVariant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.LogicalProductVariant
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "GetLogicalProductVariant"))
                      .build();
        }
      }
    }
    return getGetLogicalProductVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest,
          com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
      getListLogicalProductVariantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLogicalProductVariants",
      requestType = com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest.class,
      responseType = com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest,
          com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
      getListLogicalProductVariantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest,
            com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
        getListLogicalProductVariantsMethod;
    if ((getListLogicalProductVariantsMethod =
            CloudProductRegistryReadServiceGrpc.getListLogicalProductVariantsMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getListLogicalProductVariantsMethod =
                CloudProductRegistryReadServiceGrpc.getListLogicalProductVariantsMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getListLogicalProductVariantsMethod =
              getListLogicalProductVariantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest,
                          com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListLogicalProductVariants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "ListLogicalProductVariants"))
                      .build();
        }
      }
    }
    return getListLogicalProductVariantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.LookupEntityRequest,
          com.google.cloud.productregistry.v1.LookupEntityResponse>
      getLookupEntityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupEntity",
      requestType = com.google.cloud.productregistry.v1.LookupEntityRequest.class,
      responseType = com.google.cloud.productregistry.v1.LookupEntityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.productregistry.v1.LookupEntityRequest,
          com.google.cloud.productregistry.v1.LookupEntityResponse>
      getLookupEntityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.productregistry.v1.LookupEntityRequest,
            com.google.cloud.productregistry.v1.LookupEntityResponse>
        getLookupEntityMethod;
    if ((getLookupEntityMethod = CloudProductRegistryReadServiceGrpc.getLookupEntityMethod)
        == null) {
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        if ((getLookupEntityMethod = CloudProductRegistryReadServiceGrpc.getLookupEntityMethod)
            == null) {
          CloudProductRegistryReadServiceGrpc.getLookupEntityMethod =
              getLookupEntityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.productregistry.v1.LookupEntityRequest,
                          com.google.cloud.productregistry.v1.LookupEntityResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupEntity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.LookupEntityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.productregistry.v1.LookupEntityResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceMethodDescriptorSupplier(
                              "LookupEntity"))
                      .build();
        }
      }
    }
    return getLookupEntityMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudProductRegistryReadServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceStub>() {
          @java.lang.Override
          public CloudProductRegistryReadServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudProductRegistryReadServiceStub(channel, callOptions);
          }
        };
    return CloudProductRegistryReadServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CloudProductRegistryReadServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceBlockingV2Stub>() {
          @java.lang.Override
          public CloudProductRegistryReadServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudProductRegistryReadServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CloudProductRegistryReadServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudProductRegistryReadServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceBlockingStub>() {
          @java.lang.Override
          public CloudProductRegistryReadServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudProductRegistryReadServiceBlockingStub(channel, callOptions);
          }
        };
    return CloudProductRegistryReadServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudProductRegistryReadServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudProductRegistryReadServiceFutureStub>() {
          @java.lang.Override
          public CloudProductRegistryReadServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudProductRegistryReadServiceFutureStub(channel, callOptions);
          }
        };
    return CloudProductRegistryReadServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Product Registry Read Service provides capabilities to access all first
   * and third party Google Cloud products.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get details of a ProductSuite.
     * </pre>
     */
    default void getProductSuite(
        com.google.cloud.productregistry.v1.GetProductSuiteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ProductSuite>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProductSuiteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSuites.
     * </pre>
     */
    default void listProductSuites(
        com.google.cloud.productregistry.v1.ListProductSuitesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ListProductSuitesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductSuitesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a LogicalProduct.
     * </pre>
     */
    default void getLogicalProduct(
        com.google.cloud.productregistry.v1.GetLogicalProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LogicalProduct>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLogicalProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProducts matching given criteria.
     * </pre>
     */
    default void listLogicalProducts(
        com.google.cloud.productregistry.v1.ListLogicalProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLogicalProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a LogicalProductVariant.
     * </pre>
     */
    default void getLogicalProductVariant(
        com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LogicalProductVariant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLogicalProductVariantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProductVariants matching given criteria.
     * </pre>
     */
    default void listLogicalProductVariants(
        com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLogicalProductVariantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up entities.
     * </pre>
     */
    default void lookupEntity(
        com.google.cloud.productregistry.v1.LookupEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LookupEntityResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLookupEntityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudProductRegistryReadService.
   *
   * <pre>
   * Cloud Product Registry Read Service provides capabilities to access all first
   * and third party Google Cloud products.
   * </pre>
   */
  public abstract static class CloudProductRegistryReadServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudProductRegistryReadServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * CloudProductRegistryReadService.
   *
   * <pre>
   * Cloud Product Registry Read Service provides capabilities to access all first
   * and third party Google Cloud products.
   * </pre>
   */
  public static final class CloudProductRegistryReadServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CloudProductRegistryReadServiceStub> {
    private CloudProductRegistryReadServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudProductRegistryReadServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudProductRegistryReadServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details of a ProductSuite.
     * </pre>
     */
    public void getProductSuite(
        com.google.cloud.productregistry.v1.GetProductSuiteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ProductSuite>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductSuiteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSuites.
     * </pre>
     */
    public void listProductSuites(
        com.google.cloud.productregistry.v1.ListProductSuitesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ListProductSuitesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductSuitesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a LogicalProduct.
     * </pre>
     */
    public void getLogicalProduct(
        com.google.cloud.productregistry.v1.GetLogicalProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LogicalProduct>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLogicalProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProducts matching given criteria.
     * </pre>
     */
    public void listLogicalProducts(
        com.google.cloud.productregistry.v1.ListLogicalProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLogicalProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a LogicalProductVariant.
     * </pre>
     */
    public void getLogicalProductVariant(
        com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LogicalProductVariant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLogicalProductVariantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProductVariants matching given criteria.
     * </pre>
     */
    public void listLogicalProductVariants(
        com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLogicalProductVariantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up entities.
     * </pre>
     */
    public void lookupEntity(
        com.google.cloud.productregistry.v1.LookupEntityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LookupEntityResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupEntityMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudProductRegistryReadService.
   *
   * <pre>
   * Cloud Product Registry Read Service provides capabilities to access all first
   * and third party Google Cloud products.
   * </pre>
   */
  public static final class CloudProductRegistryReadServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CloudProductRegistryReadServiceBlockingV2Stub> {
    private CloudProductRegistryReadServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudProductRegistryReadServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudProductRegistryReadServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details of a ProductSuite.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ProductSuite getProductSuite(
        com.google.cloud.productregistry.v1.GetProductSuiteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetProductSuiteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSuites.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ListProductSuitesResponse listProductSuites(
        com.google.cloud.productregistry.v1.ListProductSuitesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListProductSuitesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a LogicalProduct.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.LogicalProduct getLogicalProduct(
        com.google.cloud.productregistry.v1.GetLogicalProductRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetLogicalProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProducts matching given criteria.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ListLogicalProductsResponse listLogicalProducts(
        com.google.cloud.productregistry.v1.ListLogicalProductsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListLogicalProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a LogicalProductVariant.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.LogicalProductVariant getLogicalProductVariant(
        com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetLogicalProductVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProductVariants matching given criteria.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse
        listLogicalProductVariants(
            com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListLogicalProductVariantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Look up entities.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.LookupEntityResponse lookupEntity(
        com.google.cloud.productregistry.v1.LookupEntityRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getLookupEntityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * CloudProductRegistryReadService.
   *
   * <pre>
   * Cloud Product Registry Read Service provides capabilities to access all first
   * and third party Google Cloud products.
   * </pre>
   */
  public static final class CloudProductRegistryReadServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudProductRegistryReadServiceBlockingStub> {
    private CloudProductRegistryReadServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudProductRegistryReadServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudProductRegistryReadServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details of a ProductSuite.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ProductSuite getProductSuite(
        com.google.cloud.productregistry.v1.GetProductSuiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductSuiteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSuites.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ListProductSuitesResponse listProductSuites(
        com.google.cloud.productregistry.v1.ListProductSuitesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductSuitesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a LogicalProduct.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.LogicalProduct getLogicalProduct(
        com.google.cloud.productregistry.v1.GetLogicalProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLogicalProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProducts matching given criteria.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ListLogicalProductsResponse listLogicalProducts(
        com.google.cloud.productregistry.v1.ListLogicalProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLogicalProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a LogicalProductVariant.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.LogicalProductVariant getLogicalProductVariant(
        com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLogicalProductVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProductVariants matching given criteria.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse
        listLogicalProductVariants(
            com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLogicalProductVariantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Look up entities.
     * </pre>
     */
    public com.google.cloud.productregistry.v1.LookupEntityResponse lookupEntity(
        com.google.cloud.productregistry.v1.LookupEntityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupEntityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * CloudProductRegistryReadService.
   *
   * <pre>
   * Cloud Product Registry Read Service provides capabilities to access all first
   * and third party Google Cloud products.
   * </pre>
   */
  public static final class CloudProductRegistryReadServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudProductRegistryReadServiceFutureStub> {
    private CloudProductRegistryReadServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudProductRegistryReadServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudProductRegistryReadServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get details of a ProductSuite.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.ProductSuite>
        getProductSuite(com.google.cloud.productregistry.v1.GetProductSuiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductSuiteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSuites.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.ListProductSuitesResponse>
        listProductSuites(com.google.cloud.productregistry.v1.ListProductSuitesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductSuitesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a LogicalProduct.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.LogicalProduct>
        getLogicalProduct(com.google.cloud.productregistry.v1.GetLogicalProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLogicalProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProducts matching given criteria.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.ListLogicalProductsResponse>
        listLogicalProducts(
            com.google.cloud.productregistry.v1.ListLogicalProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLogicalProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a LogicalProductVariant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.LogicalProductVariant>
        getLogicalProductVariant(
            com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLogicalProductVariantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists LogicalProductVariants matching given criteria.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>
        listLogicalProductVariants(
            com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLogicalProductVariantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Look up entities.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.productregistry.v1.LookupEntityResponse>
        lookupEntity(com.google.cloud.productregistry.v1.LookupEntityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupEntityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT_SUITE = 0;
  private static final int METHODID_LIST_PRODUCT_SUITES = 1;
  private static final int METHODID_GET_LOGICAL_PRODUCT = 2;
  private static final int METHODID_LIST_LOGICAL_PRODUCTS = 3;
  private static final int METHODID_GET_LOGICAL_PRODUCT_VARIANT = 4;
  private static final int METHODID_LIST_LOGICAL_PRODUCT_VARIANTS = 5;
  private static final int METHODID_LOOKUP_ENTITY = 6;

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
        case METHODID_GET_PRODUCT_SUITE:
          serviceImpl.getProductSuite(
              (com.google.cloud.productregistry.v1.GetProductSuiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.ProductSuite>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCT_SUITES:
          serviceImpl.listProductSuites(
              (com.google.cloud.productregistry.v1.ListProductSuitesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.productregistry.v1.ListProductSuitesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOGICAL_PRODUCT:
          serviceImpl.getLogicalProduct(
              (com.google.cloud.productregistry.v1.GetLogicalProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.productregistry.v1.LogicalProduct>)
                  responseObserver);
          break;
        case METHODID_LIST_LOGICAL_PRODUCTS:
          serviceImpl.listLogicalProducts(
              (com.google.cloud.productregistry.v1.ListLogicalProductsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.productregistry.v1.ListLogicalProductsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOGICAL_PRODUCT_VARIANT:
          serviceImpl.getLogicalProductVariant(
              (com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.productregistry.v1.LogicalProductVariant>)
                  responseObserver);
          break;
        case METHODID_LIST_LOGICAL_PRODUCT_VARIANTS:
          serviceImpl.listLogicalProductVariants(
              (com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>)
                  responseObserver);
          break;
        case METHODID_LOOKUP_ENTITY:
          serviceImpl.lookupEntity(
              (com.google.cloud.productregistry.v1.LookupEntityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.productregistry.v1.LookupEntityResponse>)
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
            getGetProductSuiteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.GetProductSuiteRequest,
                    com.google.cloud.productregistry.v1.ProductSuite>(
                    service, METHODID_GET_PRODUCT_SUITE)))
        .addMethod(
            getListProductSuitesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.ListProductSuitesRequest,
                    com.google.cloud.productregistry.v1.ListProductSuitesResponse>(
                    service, METHODID_LIST_PRODUCT_SUITES)))
        .addMethod(
            getGetLogicalProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.GetLogicalProductRequest,
                    com.google.cloud.productregistry.v1.LogicalProduct>(
                    service, METHODID_GET_LOGICAL_PRODUCT)))
        .addMethod(
            getListLogicalProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.ListLogicalProductsRequest,
                    com.google.cloud.productregistry.v1.ListLogicalProductsResponse>(
                    service, METHODID_LIST_LOGICAL_PRODUCTS)))
        .addMethod(
            getGetLogicalProductVariantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest,
                    com.google.cloud.productregistry.v1.LogicalProductVariant>(
                    service, METHODID_GET_LOGICAL_PRODUCT_VARIANT)))
        .addMethod(
            getListLogicalProductVariantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest,
                    com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse>(
                    service, METHODID_LIST_LOGICAL_PRODUCT_VARIANTS)))
        .addMethod(
            getLookupEntityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.productregistry.v1.LookupEntityRequest,
                    com.google.cloud.productregistry.v1.LookupEntityResponse>(
                    service, METHODID_LOOKUP_ENTITY)))
        .build();
  }

  private abstract static class CloudProductRegistryReadServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudProductRegistryReadServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudProductRegistryReadService");
    }
  }

  private static final class CloudProductRegistryReadServiceFileDescriptorSupplier
      extends CloudProductRegistryReadServiceBaseDescriptorSupplier {
    CloudProductRegistryReadServiceFileDescriptorSupplier() {}
  }

  private static final class CloudProductRegistryReadServiceMethodDescriptorSupplier
      extends CloudProductRegistryReadServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudProductRegistryReadServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudProductRegistryReadServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new CloudProductRegistryReadServiceFileDescriptorSupplier())
                      .addMethod(getGetProductSuiteMethod())
                      .addMethod(getListProductSuitesMethod())
                      .addMethod(getGetLogicalProductMethod())
                      .addMethod(getListLogicalProductsMethod())
                      .addMethod(getGetLogicalProductVariantMethod())
                      .addMethod(getListLogicalProductVariantsMethod())
                      .addMethod(getLookupEntityMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
