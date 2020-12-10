/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.retail.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Service for ingesting [Product][google.cloud.retail.v2.Product] information
 * of the customer's website.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2/product_service.proto")
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.retail.v2.ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.CreateProductRequest, com.google.cloud.retail.v2.Product>
      getCreateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProduct",
      requestType = com.google.cloud.retail.v2.CreateProductRequest.class,
      responseType = com.google.cloud.retail.v2.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.CreateProductRequest, com.google.cloud.retail.v2.Product>
      getCreateProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.CreateProductRequest, com.google.cloud.retail.v2.Product>
        getCreateProductMethod;
    if ((getCreateProductMethod = ProductServiceGrpc.getCreateProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getCreateProductMethod = ProductServiceGrpc.getCreateProductMethod) == null) {
          ProductServiceGrpc.getCreateProductMethod =
              getCreateProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.CreateProductRequest,
                          com.google.cloud.retail.v2.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.CreateProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.Product.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("CreateProduct"))
                      .build();
        }
      }
    }
    return getCreateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.GetProductRequest, com.google.cloud.retail.v2.Product>
      getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = com.google.cloud.retail.v2.GetProductRequest.class,
      responseType = com.google.cloud.retail.v2.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.GetProductRequest, com.google.cloud.retail.v2.Product>
      getGetProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.GetProductRequest, com.google.cloud.retail.v2.Product>
        getGetProductMethod;
    if ((getGetProductMethod = ProductServiceGrpc.getGetProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getGetProductMethod = ProductServiceGrpc.getGetProductMethod) == null) {
          ProductServiceGrpc.getGetProductMethod =
              getGetProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.GetProductRequest,
                          com.google.cloud.retail.v2.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.GetProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.Product.getDefaultInstance()))
                      .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("GetProduct"))
                      .build();
        }
      }
    }
    return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.UpdateProductRequest, com.google.cloud.retail.v2.Product>
      getUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProduct",
      requestType = com.google.cloud.retail.v2.UpdateProductRequest.class,
      responseType = com.google.cloud.retail.v2.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.UpdateProductRequest, com.google.cloud.retail.v2.Product>
      getUpdateProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.UpdateProductRequest, com.google.cloud.retail.v2.Product>
        getUpdateProductMethod;
    if ((getUpdateProductMethod = ProductServiceGrpc.getUpdateProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUpdateProductMethod = ProductServiceGrpc.getUpdateProductMethod) == null) {
          ProductServiceGrpc.getUpdateProductMethod =
              getUpdateProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.UpdateProductRequest,
                          com.google.cloud.retail.v2.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.UpdateProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.Product.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("UpdateProduct"))
                      .build();
        }
      }
    }
    return getUpdateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProduct",
      requestType = com.google.cloud.retail.v2.DeleteProductRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.DeleteProductRequest, com.google.protobuf.Empty>
        getDeleteProductMethod;
    if ((getDeleteProductMethod = ProductServiceGrpc.getDeleteProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getDeleteProductMethod = ProductServiceGrpc.getDeleteProductMethod) == null) {
          ProductServiceGrpc.getDeleteProductMethod =
              getDeleteProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.DeleteProductRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.DeleteProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("DeleteProduct"))
                      .build();
        }
      }
    }
    return getDeleteProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ImportProductsRequest, com.google.longrunning.Operation>
      getImportProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportProducts",
      requestType = com.google.cloud.retail.v2.ImportProductsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ImportProductsRequest, com.google.longrunning.Operation>
      getImportProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.ImportProductsRequest, com.google.longrunning.Operation>
        getImportProductsMethod;
    if ((getImportProductsMethod = ProductServiceGrpc.getImportProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getImportProductsMethod = ProductServiceGrpc.getImportProductsMethod) == null) {
          ProductServiceGrpc.getImportProductsMethod =
              getImportProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.ImportProductsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ImportProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("ImportProducts"))
                      .build();
        }
      }
    }
    return getImportProductsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub>() {
          @java.lang.Override
          public ProductServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductServiceStub(channel, callOptions);
          }
        };
    return ProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub>() {
          @java.lang.Override
          public ProductServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductServiceBlockingStub(channel, callOptions);
          }
        };
    return ProductServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub>() {
          @java.lang.Override
          public ProductServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductServiceFutureStub(channel, callOptions);
          }
        };
    return ProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2.Product] information
   * of the customer's website.
   * </pre>
   */
  public abstract static class ProductServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void createProduct(
        com.google.cloud.retail.v2.CreateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void getProduct(
        com.google.cloud.retail.v2.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void updateProduct(
        com.google.cloud.retail.v2.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void deleteProduct(
        com.google.cloud.retail.v2.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
     * Request processing may be synchronous. No partial updating is supported.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2.Product]s to be successfully updated.
     * </pre>
     */
    public void importProducts(
        com.google.cloud.retail.v2.ImportProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getImportProductsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateProductMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.CreateProductRequest,
                      com.google.cloud.retail.v2.Product>(this, METHODID_CREATE_PRODUCT)))
          .addMethod(
              getGetProductMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.GetProductRequest,
                      com.google.cloud.retail.v2.Product>(this, METHODID_GET_PRODUCT)))
          .addMethod(
              getUpdateProductMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.UpdateProductRequest,
                      com.google.cloud.retail.v2.Product>(this, METHODID_UPDATE_PRODUCT)))
          .addMethod(
              getDeleteProductMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.DeleteProductRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_PRODUCT)))
          .addMethod(
              getImportProductsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.ImportProductsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_PRODUCTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2.Product] information
   * of the customer's website.
   * </pre>
   */
  public static final class ProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceStub> {
    private ProductServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void createProduct(
        com.google.cloud.retail.v2.CreateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void getProduct(
        com.google.cloud.retail.v2.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void updateProduct(
        com.google.cloud.retail.v2.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public void deleteProduct(
        com.google.cloud.retail.v2.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
     * Request processing may be synchronous. No partial updating is supported.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2.Product]s to be successfully updated.
     * </pre>
     */
    public void importProducts(
        com.google.cloud.retail.v2.ImportProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getImportProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2.Product] information
   * of the customer's website.
   * </pre>
   */
  public static final class ProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.cloud.retail.v2.Product createProduct(
        com.google.cloud.retail.v2.CreateProductRequest request) {
      return blockingUnaryCall(getChannel(), getCreateProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.cloud.retail.v2.Product getProduct(
        com.google.cloud.retail.v2.GetProductRequest request) {
      return blockingUnaryCall(getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.cloud.retail.v2.Product updateProduct(
        com.google.cloud.retail.v2.UpdateProductRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.protobuf.Empty deleteProduct(
        com.google.cloud.retail.v2.DeleteProductRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
     * Request processing may be synchronous. No partial updating is supported.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2.Product]s to be successfully updated.
     * </pre>
     */
    public com.google.longrunning.Operation importProducts(
        com.google.cloud.retail.v2.ImportProductsRequest request) {
      return blockingUnaryCall(getChannel(), getImportProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2.Product] information
   * of the customer's website.
   * </pre>
   */
  public static final class ProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2.Product>
        createProduct(com.google.cloud.retail.v2.CreateProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2.Product>
        getProduct(com.google.cloud.retail.v2.GetProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2.Product>
        updateProduct(com.google.cloud.retail.v2.UpdateProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProduct(com.google.cloud.retail.v2.DeleteProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2.Product]s.
     * Request processing may be synchronous. No partial updating is supported.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2.Product]s to be successfully updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importProducts(com.google.cloud.retail.v2.ImportProductsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getImportProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PRODUCT = 0;
  private static final int METHODID_GET_PRODUCT = 1;
  private static final int METHODID_UPDATE_PRODUCT = 2;
  private static final int METHODID_DELETE_PRODUCT = 3;
  private static final int METHODID_IMPORT_PRODUCTS = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PRODUCT:
          serviceImpl.createProduct(
              (com.google.cloud.retail.v2.CreateProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product>) responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct(
              (com.google.cloud.retail.v2.GetProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product>) responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT:
          serviceImpl.updateProduct(
              (com.google.cloud.retail.v2.UpdateProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Product>) responseObserver);
          break;
        case METHODID_DELETE_PRODUCT:
          serviceImpl.deleteProduct(
              (com.google.cloud.retail.v2.DeleteProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_IMPORT_PRODUCTS:
          serviceImpl.importProducts(
              (com.google.cloud.retail.v2.ImportProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private abstract static class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2.ProductServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
                      .addMethod(getCreateProductMethod())
                      .addMethod(getGetProductMethod())
                      .addMethod(getUpdateProductMethod())
                      .addMethod(getDeleteProductMethod())
                      .addMethod(getImportProductsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
