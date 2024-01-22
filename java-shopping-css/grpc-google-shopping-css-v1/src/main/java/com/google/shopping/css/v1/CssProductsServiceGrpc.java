/*
 * Copyright 2023 Google LLC
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
package com.google.shopping.css.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for doing get and list on Css Products(a.k.a Aggregate Offers
 * internally).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/css/v1/css_products.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CssProductsServiceGrpc {

  private CssProductsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.shopping.css.v1.CssProductsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.GetCssProductRequest, com.google.shopping.css.v1.CssProduct>
      getGetCssProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCssProduct",
      requestType = com.google.shopping.css.v1.GetCssProductRequest.class,
      responseType = com.google.shopping.css.v1.CssProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.GetCssProductRequest, com.google.shopping.css.v1.CssProduct>
      getGetCssProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.css.v1.GetCssProductRequest, com.google.shopping.css.v1.CssProduct>
        getGetCssProductMethod;
    if ((getGetCssProductMethod = CssProductsServiceGrpc.getGetCssProductMethod) == null) {
      synchronized (CssProductsServiceGrpc.class) {
        if ((getGetCssProductMethod = CssProductsServiceGrpc.getGetCssProductMethod) == null) {
          CssProductsServiceGrpc.getGetCssProductMethod =
              getGetCssProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.css.v1.GetCssProductRequest,
                          com.google.shopping.css.v1.CssProduct>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCssProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.GetCssProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.CssProduct.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CssProductsServiceMethodDescriptorSupplier("GetCssProduct"))
                      .build();
        }
      }
    }
    return getGetCssProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.ListCssProductsRequest,
          com.google.shopping.css.v1.ListCssProductsResponse>
      getListCssProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCssProducts",
      requestType = com.google.shopping.css.v1.ListCssProductsRequest.class,
      responseType = com.google.shopping.css.v1.ListCssProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.css.v1.ListCssProductsRequest,
          com.google.shopping.css.v1.ListCssProductsResponse>
      getListCssProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.css.v1.ListCssProductsRequest,
            com.google.shopping.css.v1.ListCssProductsResponse>
        getListCssProductsMethod;
    if ((getListCssProductsMethod = CssProductsServiceGrpc.getListCssProductsMethod) == null) {
      synchronized (CssProductsServiceGrpc.class) {
        if ((getListCssProductsMethod = CssProductsServiceGrpc.getListCssProductsMethod) == null) {
          CssProductsServiceGrpc.getListCssProductsMethod =
              getListCssProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.css.v1.ListCssProductsRequest,
                          com.google.shopping.css.v1.ListCssProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCssProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.ListCssProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.css.v1.ListCssProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CssProductsServiceMethodDescriptorSupplier("ListCssProducts"))
                      .build();
        }
      }
    }
    return getListCssProductsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CssProductsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CssProductsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CssProductsServiceStub>() {
          @java.lang.Override
          public CssProductsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CssProductsServiceStub(channel, callOptions);
          }
        };
    return CssProductsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CssProductsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CssProductsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CssProductsServiceBlockingStub>() {
          @java.lang.Override
          public CssProductsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CssProductsServiceBlockingStub(channel, callOptions);
          }
        };
    return CssProductsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CssProductsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CssProductsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CssProductsServiceFutureStub>() {
          @java.lang.Override
          public CssProductsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CssProductsServiceFutureStub(channel, callOptions);
          }
        };
    return CssProductsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for doing get and list on Css Products(a.k.a Aggregate Offers
   * internally).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the processed CSS Product from your CSS Center account. After
     * inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    default void getCssProduct(
        com.google.shopping.css.v1.GetCssProductRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.CssProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCssProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed CSS Products in your CSS Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a CSS product input, it may
     * take several minutes before the updated processed CSS product can be
     * retrieved.
     * </pre>
     */
    default void listCssProducts(
        com.google.shopping.css.v1.ListCssProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListCssProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCssProductsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CssProductsService.
   *
   * <pre>
   * Service for doing get and list on Css Products(a.k.a Aggregate Offers
   * internally).
   * </pre>
   */
  public abstract static class CssProductsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CssProductsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CssProductsService.
   *
   * <pre>
   * Service for doing get and list on Css Products(a.k.a Aggregate Offers
   * internally).
   * </pre>
   */
  public static final class CssProductsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CssProductsServiceStub> {
    private CssProductsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CssProductsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CssProductsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the processed CSS Product from your CSS Center account. After
     * inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    public void getCssProduct(
        com.google.shopping.css.v1.GetCssProductRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.CssProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCssProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed CSS Products in your CSS Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a CSS product input, it may
     * take several minutes before the updated processed CSS product can be
     * retrieved.
     * </pre>
     */
    public void listCssProducts(
        com.google.shopping.css.v1.ListCssProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListCssProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCssProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CssProductsService.
   *
   * <pre>
   * Service for doing get and list on Css Products(a.k.a Aggregate Offers
   * internally).
   * </pre>
   */
  public static final class CssProductsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CssProductsServiceBlockingStub> {
    private CssProductsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CssProductsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CssProductsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the processed CSS Product from your CSS Center account. After
     * inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    public com.google.shopping.css.v1.CssProduct getCssProduct(
        com.google.shopping.css.v1.GetCssProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCssProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed CSS Products in your CSS Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a CSS product input, it may
     * take several minutes before the updated processed CSS product can be
     * retrieved.
     * </pre>
     */
    public com.google.shopping.css.v1.ListCssProductsResponse listCssProducts(
        com.google.shopping.css.v1.ListCssProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCssProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CssProductsService.
   *
   * <pre>
   * Service for doing get and list on Css Products(a.k.a Aggregate Offers
   * internally).
   * </pre>
   */
  public static final class CssProductsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CssProductsServiceFutureStub> {
    private CssProductsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CssProductsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CssProductsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the processed CSS Product from your CSS Center account. After
     * inserting, updating, or deleting a product input, it may take several
     * minutes before the updated final product can be retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.shopping.css.v1.CssProduct>
        getCssProduct(com.google.shopping.css.v1.GetCssProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCssProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the processed CSS Products in your CSS Center account. The response
     * might contain fewer items than specified by pageSize. Rely on pageToken to
     * determine if there are more items to be requested.
     * After inserting, updating, or deleting a CSS product input, it may
     * take several minutes before the updated processed CSS product can be
     * retrieved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.css.v1.ListCssProductsResponse>
        listCssProducts(com.google.shopping.css.v1.ListCssProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCssProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CSS_PRODUCT = 0;
  private static final int METHODID_LIST_CSS_PRODUCTS = 1;

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
        case METHODID_GET_CSS_PRODUCT:
          serviceImpl.getCssProduct(
              (com.google.shopping.css.v1.GetCssProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.CssProduct>)
                  responseObserver);
          break;
        case METHODID_LIST_CSS_PRODUCTS:
          serviceImpl.listCssProducts(
              (com.google.shopping.css.v1.ListCssProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.css.v1.ListCssProductsResponse>)
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
            getGetCssProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.css.v1.GetCssProductRequest,
                    com.google.shopping.css.v1.CssProduct>(service, METHODID_GET_CSS_PRODUCT)))
        .addMethod(
            getListCssProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.css.v1.ListCssProductsRequest,
                    com.google.shopping.css.v1.ListCssProductsResponse>(
                    service, METHODID_LIST_CSS_PRODUCTS)))
        .build();
  }

  private abstract static class CssProductsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CssProductsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.css.v1.CssProductsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CssProductsService");
    }
  }

  private static final class CssProductsServiceFileDescriptorSupplier
      extends CssProductsServiceBaseDescriptorSupplier {
    CssProductsServiceFileDescriptorSupplier() {}
  }

  private static final class CssProductsServiceMethodDescriptorSupplier
      extends CssProductsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CssProductsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CssProductsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CssProductsServiceFileDescriptorSupplier())
                      .addMethod(getGetCssProductMethod())
                      .addMethod(getListCssProductsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
