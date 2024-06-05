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
 * Service to use ProductInput resource.
 * This service works for products with online channel only.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/products/v1beta/productinputs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductInputsServiceGrpc {

  private ProductInputsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.products.v1beta.ProductInputsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.InsertProductInputRequest,
          com.google.shopping.merchant.products.v1beta.ProductInput>
      getInsertProductInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertProductInput",
      requestType = com.google.shopping.merchant.products.v1beta.InsertProductInputRequest.class,
      responseType = com.google.shopping.merchant.products.v1beta.ProductInput.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.InsertProductInputRequest,
          com.google.shopping.merchant.products.v1beta.ProductInput>
      getInsertProductInputMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.products.v1beta.InsertProductInputRequest,
            com.google.shopping.merchant.products.v1beta.ProductInput>
        getInsertProductInputMethod;
    if ((getInsertProductInputMethod = ProductInputsServiceGrpc.getInsertProductInputMethod)
        == null) {
      synchronized (ProductInputsServiceGrpc.class) {
        if ((getInsertProductInputMethod = ProductInputsServiceGrpc.getInsertProductInputMethod)
            == null) {
          ProductInputsServiceGrpc.getInsertProductInputMethod =
              getInsertProductInputMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.products.v1beta.InsertProductInputRequest,
                          com.google.shopping.merchant.products.v1beta.ProductInput>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertProductInput"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.InsertProductInputRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.ProductInput
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductInputsServiceMethodDescriptorSupplier("InsertProductInput"))
                      .build();
        }
      }
    }
    return getInsertProductInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest,
          com.google.protobuf.Empty>
      getDeleteProductInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProductInput",
      requestType = com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest,
          com.google.protobuf.Empty>
      getDeleteProductInputMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest,
            com.google.protobuf.Empty>
        getDeleteProductInputMethod;
    if ((getDeleteProductInputMethod = ProductInputsServiceGrpc.getDeleteProductInputMethod)
        == null) {
      synchronized (ProductInputsServiceGrpc.class) {
        if ((getDeleteProductInputMethod = ProductInputsServiceGrpc.getDeleteProductInputMethod)
            == null) {
          ProductInputsServiceGrpc.getDeleteProductInputMethod =
              getDeleteProductInputMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProductInput"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductInputsServiceMethodDescriptorSupplier("DeleteProductInput"))
                      .build();
        }
      }
    }
    return getDeleteProductInputMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProductInputsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductInputsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductInputsServiceStub>() {
          @java.lang.Override
          public ProductInputsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductInputsServiceStub(channel, callOptions);
          }
        };
    return ProductInputsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductInputsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductInputsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductInputsServiceBlockingStub>() {
          @java.lang.Override
          public ProductInputsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductInputsServiceBlockingStub(channel, callOptions);
          }
        };
    return ProductInputsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductInputsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductInputsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductInputsServiceFutureStub>() {
          @java.lang.Override
          public ProductInputsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductInputsServiceFutureStub(channel, callOptions);
          }
        };
    return ProductInputsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to use ProductInput resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Uploads a product input to your Merchant Center account. If an input
     * with the same contentLanguage, offerId, and dataSource already exists,
     * this method replaces that entry.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    default void insertProductInput(
        com.google.shopping.merchant.products.v1beta.InsertProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.products.v1beta.ProductInput>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInsertProductInputMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product input from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    default void deleteProductInput(
        com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProductInputMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductInputsService.
   *
   * <pre>
   * Service to use ProductInput resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public abstract static class ProductInputsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProductInputsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductInputsService.
   *
   * <pre>
   * Service to use ProductInput resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public static final class ProductInputsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductInputsServiceStub> {
    private ProductInputsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductInputsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductInputsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a product input to your Merchant Center account. If an input
     * with the same contentLanguage, offerId, and dataSource already exists,
     * this method replaces that entry.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    public void insertProductInput(
        com.google.shopping.merchant.products.v1beta.InsertProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.products.v1beta.ProductInput>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertProductInputMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product input from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    public void deleteProductInput(
        com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProductInputMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductInputsService.
   *
   * <pre>
   * Service to use ProductInput resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public static final class ProductInputsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductInputsServiceBlockingStub> {
    private ProductInputsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductInputsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductInputsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a product input to your Merchant Center account. If an input
     * with the same contentLanguage, offerId, and dataSource already exists,
     * this method replaces that entry.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    public com.google.shopping.merchant.products.v1beta.ProductInput insertProductInput(
        com.google.shopping.merchant.products.v1beta.InsertProductInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertProductInputMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product input from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProductInput(
        com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductInputMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductInputsService.
   *
   * <pre>
   * Service to use ProductInput resource.
   * This service works for products with online channel only.
   * </pre>
   */
  public static final class ProductInputsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductInputsServiceFutureStub> {
    private ProductInputsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductInputsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductInputsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a product input to your Merchant Center account. If an input
     * with the same contentLanguage, offerId, and dataSource already exists,
     * this method replaces that entry.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.products.v1beta.ProductInput>
        insertProductInput(
            com.google.shopping.merchant.products.v1beta.InsertProductInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertProductInputMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a product input from your Merchant Center account.
     * After inserting, updating, or deleting a product input, it may take several
     * minutes before the processed product can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProductInput(
            com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductInputMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_PRODUCT_INPUT = 0;
  private static final int METHODID_DELETE_PRODUCT_INPUT = 1;

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
        case METHODID_INSERT_PRODUCT_INPUT:
          serviceImpl.insertProductInput(
              (com.google.shopping.merchant.products.v1beta.InsertProductInputRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.products.v1beta.ProductInput>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRODUCT_INPUT:
          serviceImpl.deleteProductInput(
              (com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getInsertProductInputMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.products.v1beta.InsertProductInputRequest,
                    com.google.shopping.merchant.products.v1beta.ProductInput>(
                    service, METHODID_INSERT_PRODUCT_INPUT)))
        .addMethod(
            getDeleteProductInputMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.products.v1beta.DeleteProductInputRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PRODUCT_INPUT)))
        .build();
  }

  private abstract static class ProductInputsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductInputsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.products.v1beta.ProductInputsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductInputsService");
    }
  }

  private static final class ProductInputsServiceFileDescriptorSupplier
      extends ProductInputsServiceBaseDescriptorSupplier {
    ProductInputsServiceFileDescriptorSupplier() {}
  }

  private static final class ProductInputsServiceMethodDescriptorSupplier
      extends ProductInputsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductInputsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductInputsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProductInputsServiceFileDescriptorSupplier())
                      .addMethod(getInsertProductInputMethod())
                      .addMethod(getDeleteProductInputMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
