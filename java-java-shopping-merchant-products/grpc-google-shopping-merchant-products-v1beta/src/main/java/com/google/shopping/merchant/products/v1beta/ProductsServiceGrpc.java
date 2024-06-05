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
package com.google.shopping.merchant.products.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to use Product resource.
 * This service works for products with online channel only.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/products/v1beta/products.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductsServiceGrpc {

  private ProductsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.products.v1beta.ProductsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.GetProductRequest,
          com.google.shopping.merchant.products.v1beta.Product>
      getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = com.google.shopping.merchant.products.v1beta.GetProductRequest.class,
      responseType = com.google.shopping.merchant.products.v1beta.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.GetProductRequest,
          com.google.shopping.merchant.products.v1beta.Product>
      getGetProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.products.v1beta.GetProductRequest,
            com.google.shopping.merchant.products.v1beta.Product>
        getGetProductMethod;
    if ((getGetProductMethod = ProductsServiceGrpc.getGetProductMethod) == null) {
      synchronized (ProductsServiceGrpc.class) {
        if ((getGetProductMethod = ProductsServiceGrpc.getGetProductMethod) == null) {
          ProductsServiceGrpc.getGetProductMethod =
              getGetProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.products.v1beta.GetProductRequest,
                          com.google.shopping.merchant.products.v1beta.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.GetProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.Product
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductsServiceMethodDescriptorSupplier("GetProduct"))
                      .build();
        }
      }
    }
    return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.ListProductsRequest,
          com.google.shopping.merchant.products.v1beta.ListProductsResponse>
      getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = com.google.shopping.merchant.products.v1beta.ListProductsRequest.class,
      responseType = com.google.shopping.merchant.products.v1beta.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.ListProductsRequest,
          com.google.shopping.merchant.products.v1beta.ListProductsResponse>
      getListProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.products.v1beta.ListProductsRequest,
            com.google.shopping.merchant.products.v1beta.ListProductsResponse>
        getListProductsMethod;
    if ((getListProductsMethod = ProductsServiceGrpc.getListProductsMethod) == null) {
      synchronized (ProductsServiceGrpc.class) {
        if ((getListProductsMethod = ProductsServiceGrpc.getListProductsMethod) == null) {
          ProductsServiceGrpc.getListProductsMethod =
              getListProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.products.v1beta.ListProductsRequest,
                          com.google.shopping.merchant.products.v1beta.ListProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.ListProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.ListProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductsServiceMethodDescriptorSupplier("ListProducts"))
                      .build();
        }
      }
    }
    return getListProductsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProductsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductsServiceStub>() {
          @java.lang.Override
          public ProductsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductsServiceStub(channel, callOptions);
          }
        };
    return ProductsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductsServiceBlockingStub>() {
          @java.lang.Override
          public ProductsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductsServiceBlockingStub(channel, callOptions);
          }
        };
    return ProductsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductsServiceFutureStub>() {
          @java.lang.Override
          public ProductsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductsServiceFutureStub(channel, callOptions);
          }
        };
    return ProductsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to use Product resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the processed product from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    default void getProduct(
        com.google.shopping.merchant.products.v1beta.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.products.v1beta.Product>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed products in your Merchant Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated processed product can be retrieved.
     * </pre>
     */
    default void listProducts(
        com.google.shopping.merchant.products.v1beta.ListProductsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.products.v1beta.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductsService.
   *
   * <pre>
   * Service to use Product resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public abstract static class ProductsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProductsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductsService.
   *
   * <pre>
   * Service to use Product resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public static final class ProductsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductsServiceStub> {
    private ProductsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the processed product from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    public void getProduct(
        com.google.shopping.merchant.products.v1beta.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.products.v1beta.Product>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed products in your Merchant Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated processed product can be retrieved.
     * </pre>
     */
    public void listProducts(
        com.google.shopping.merchant.products.v1beta.ListProductsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.products.v1beta.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductsService.
   *
   * <pre>
   * Service to use Product resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public static final class ProductsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductsServiceBlockingStub> {
    private ProductsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the processed product from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    public com.google.shopping.merchant.products.v1beta.Product getProduct(
        com.google.shopping.merchant.products.v1beta.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed products in your Merchant Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated processed product can be retrieved.
     * </pre>
     */
    public com.google.shopping.merchant.products.v1beta.ListProductsResponse listProducts(
        com.google.shopping.merchant.products.v1beta.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductsService.
   *
   * <pre>
   * Service to use Product resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public static final class ProductsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductsServiceFutureStub> {
    private ProductsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the processed product from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.products.v1beta.Product>
        getProduct(com.google.shopping.merchant.products.v1beta.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed products in your Merchant Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the updated processed product can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.products.v1beta.ListProductsResponse>
        listProducts(com.google.shopping.merchant.products.v1beta.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT = 0;
  private static final int METHODID_LIST_PRODUCTS = 1;

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
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct(
              (com.google.shopping.merchant.products.v1beta.GetProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.products.v1beta.Product>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts(
              (com.google.shopping.merchant.products.v1beta.ListProductsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.products.v1beta.ListProductsResponse>)
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
            getGetProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.products.v1beta.GetProductRequest,
                    com.google.shopping.merchant.products.v1beta.Product>(
                    service, METHODID_GET_PRODUCT)))
        .addMethod(
            getListProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.products.v1beta.ListProductsRequest,
                    com.google.shopping.merchant.products.v1beta.ListProductsResponse>(
                    service, METHODID_LIST_PRODUCTS)))
        .build();
  }

  private abstract static class ProductsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.products.v1beta.ProductsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductsService");
    }
  }

  private static final class ProductsServiceFileDescriptorSupplier
      extends ProductsServiceBaseDescriptorSupplier {
    ProductsServiceFileDescriptorSupplier() {}
  }

  private static final class ProductsServiceMethodDescriptorSupplier
      extends ProductsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProductsServiceFileDescriptorSupplier())
                      .addMethod(getGetProductMethod())
                      .addMethod(getListProductsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
