package com.google.cloud.privatecatalog.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * `PrivateCatalog` allows catalog consumers to retrieve `Catalog`, `Product`
 * and `Version` resources under a target resource context.
 * `Catalog` is computed based on the [Association][]s linked to the target
 * resource and its ancestors. Each association's
 * [google.cloud.privatecatalogproducer.v1beta.Catalog][] is transformed into a
 * `Catalog`. If multiple associations have the same parent
 * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are
 * de-duplicated into one `Catalog`. Users must have
 * `cloudprivatecatalog.catalogTargets.get` IAM permission on the resource
 * context in order to access catalogs. `Catalog` contains the resource name and
 * a subset of data of the original
 * [google.cloud.privatecatalogproducer.v1beta.Catalog][].
 * `Product` is child resource of the catalog. A `Product` contains the resource
 * name and a subset of the data of the original
 * [google.cloud.privatecatalogproducer.v1beta.Product][].
 * `Version` is child resource of the product. A `Version` contains the resource
 * name and a subset of the data of the original
 * [google.cloud.privatecatalogproducer.v1beta.Version][].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/privatecatalog/v1beta1/private_catalog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PrivateCatalogGrpc {

  private PrivateCatalogGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.privatecatalog.v1beta1.PrivateCatalog";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest,
      com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse> getSearchCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchCatalogs",
      requestType = com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest.class,
      responseType = com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest,
      com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse> getSearchCatalogsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest, com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse> getSearchCatalogsMethod;
    if ((getSearchCatalogsMethod = PrivateCatalogGrpc.getSearchCatalogsMethod) == null) {
      synchronized (PrivateCatalogGrpc.class) {
        if ((getSearchCatalogsMethod = PrivateCatalogGrpc.getSearchCatalogsMethod) == null) {
          PrivateCatalogGrpc.getSearchCatalogsMethod = getSearchCatalogsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest, com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchCatalogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrivateCatalogMethodDescriptorSupplier("SearchCatalogs"))
              .build();
        }
      }
    }
    return getSearchCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest,
      com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse> getSearchProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchProducts",
      requestType = com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest.class,
      responseType = com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest,
      com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse> getSearchProductsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest, com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse> getSearchProductsMethod;
    if ((getSearchProductsMethod = PrivateCatalogGrpc.getSearchProductsMethod) == null) {
      synchronized (PrivateCatalogGrpc.class) {
        if ((getSearchProductsMethod = PrivateCatalogGrpc.getSearchProductsMethod) == null) {
          PrivateCatalogGrpc.getSearchProductsMethod = getSearchProductsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest, com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrivateCatalogMethodDescriptorSupplier("SearchProducts"))
              .build();
        }
      }
    }
    return getSearchProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest,
      com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse> getSearchVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchVersions",
      requestType = com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest.class,
      responseType = com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest,
      com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse> getSearchVersionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest, com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse> getSearchVersionsMethod;
    if ((getSearchVersionsMethod = PrivateCatalogGrpc.getSearchVersionsMethod) == null) {
      synchronized (PrivateCatalogGrpc.class) {
        if ((getSearchVersionsMethod = PrivateCatalogGrpc.getSearchVersionsMethod) == null) {
          PrivateCatalogGrpc.getSearchVersionsMethod = getSearchVersionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest, com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchVersions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrivateCatalogMethodDescriptorSupplier("SearchVersions"))
              .build();
        }
      }
    }
    return getSearchVersionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrivateCatalogStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivateCatalogStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrivateCatalogStub>() {
        @java.lang.Override
        public PrivateCatalogStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrivateCatalogStub(channel, callOptions);
        }
      };
    return PrivateCatalogStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrivateCatalogBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivateCatalogBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrivateCatalogBlockingStub>() {
        @java.lang.Override
        public PrivateCatalogBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrivateCatalogBlockingStub(channel, callOptions);
        }
      };
    return PrivateCatalogBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrivateCatalogFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivateCatalogFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrivateCatalogFutureStub>() {
        @java.lang.Override
        public PrivateCatalogFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrivateCatalogFutureStub(channel, callOptions);
        }
      };
    return PrivateCatalogFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * `PrivateCatalog` allows catalog consumers to retrieve `Catalog`, `Product`
   * and `Version` resources under a target resource context.
   * `Catalog` is computed based on the [Association][]s linked to the target
   * resource and its ancestors. Each association's
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][] is transformed into a
   * `Catalog`. If multiple associations have the same parent
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are
   * de-duplicated into one `Catalog`. Users must have
   * `cloudprivatecatalog.catalogTargets.get` IAM permission on the resource
   * context in order to access catalogs. `Catalog` contains the resource name and
   * a subset of data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][].
   * `Product` is child resource of the catalog. A `Product` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Product][].
   * `Version` is child resource of the product. A `Version` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Version][].
   * </pre>
   */
  public static abstract class PrivateCatalogImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public void searchCatalogs(com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchCatalogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public void searchProducts(com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchProductsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public void searchVersions(com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchVersionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchCatalogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest,
                com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse>(
                  this, METHODID_SEARCH_CATALOGS)))
          .addMethod(
            getSearchProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest,
                com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse>(
                  this, METHODID_SEARCH_PRODUCTS)))
          .addMethod(
            getSearchVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest,
                com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse>(
                  this, METHODID_SEARCH_VERSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * `PrivateCatalog` allows catalog consumers to retrieve `Catalog`, `Product`
   * and `Version` resources under a target resource context.
   * `Catalog` is computed based on the [Association][]s linked to the target
   * resource and its ancestors. Each association's
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][] is transformed into a
   * `Catalog`. If multiple associations have the same parent
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are
   * de-duplicated into one `Catalog`. Users must have
   * `cloudprivatecatalog.catalogTargets.get` IAM permission on the resource
   * context in order to access catalogs. `Catalog` contains the resource name and
   * a subset of data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][].
   * `Product` is child resource of the catalog. A `Product` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Product][].
   * `Version` is child resource of the product. A `Version` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Version][].
   * </pre>
   */
  public static final class PrivateCatalogStub extends io.grpc.stub.AbstractAsyncStub<PrivateCatalogStub> {
    private PrivateCatalogStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivateCatalogStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivateCatalogStub(channel, callOptions);
    }

    /**
     * <pre>
     * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public void searchCatalogs(com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchCatalogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public void searchProducts(com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public void searchVersions(com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchVersionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * `PrivateCatalog` allows catalog consumers to retrieve `Catalog`, `Product`
   * and `Version` resources under a target resource context.
   * `Catalog` is computed based on the [Association][]s linked to the target
   * resource and its ancestors. Each association's
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][] is transformed into a
   * `Catalog`. If multiple associations have the same parent
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are
   * de-duplicated into one `Catalog`. Users must have
   * `cloudprivatecatalog.catalogTargets.get` IAM permission on the resource
   * context in order to access catalogs. `Catalog` contains the resource name and
   * a subset of data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][].
   * `Product` is child resource of the catalog. A `Product` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Product][].
   * `Version` is child resource of the product. A `Version` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Version][].
   * </pre>
   */
  public static final class PrivateCatalogBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrivateCatalogBlockingStub> {
    private PrivateCatalogBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivateCatalogBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivateCatalogBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse searchCatalogs(com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCatalogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse searchProducts(com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchProductsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse searchVersions(com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchVersionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * `PrivateCatalog` allows catalog consumers to retrieve `Catalog`, `Product`
   * and `Version` resources under a target resource context.
   * `Catalog` is computed based on the [Association][]s linked to the target
   * resource and its ancestors. Each association's
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][] is transformed into a
   * `Catalog`. If multiple associations have the same parent
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][], they are
   * de-duplicated into one `Catalog`. Users must have
   * `cloudprivatecatalog.catalogTargets.get` IAM permission on the resource
   * context in order to access catalogs. `Catalog` contains the resource name and
   * a subset of data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Catalog][].
   * `Product` is child resource of the catalog. A `Product` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Product][].
   * `Version` is child resource of the product. A `Version` contains the resource
   * name and a subset of the data of the original
   * [google.cloud.privatecatalogproducer.v1beta.Version][].
   * </pre>
   */
  public static final class PrivateCatalogFutureStub extends io.grpc.stub.AbstractFutureStub<PrivateCatalogFutureStub> {
    private PrivateCatalogFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivateCatalogFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivateCatalogFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Search [Catalog][google.cloud.privatecatalog.v1beta1.Catalog] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse> searchCatalogs(
        com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchCatalogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Search [Product][google.cloud.privatecatalog.v1beta1.Product] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse> searchProducts(
        com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchProductsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Search [Version][google.cloud.privatecatalog.v1beta1.Version] resources that consumers have access to, within the
     * scope of the consumer cloud resource hierarchy context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse> searchVersions(
        com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchVersionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_CATALOGS = 0;
  private static final int METHODID_SEARCH_PRODUCTS = 1;
  private static final int METHODID_SEARCH_VERSIONS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrivateCatalogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrivateCatalogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_CATALOGS:
          serviceImpl.searchCatalogs((com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse>) responseObserver);
          break;
        case METHODID_SEARCH_PRODUCTS:
          serviceImpl.searchProducts((com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse>) responseObserver);
          break;
        case METHODID_SEARCH_VERSIONS:
          serviceImpl.searchVersions((com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse>) responseObserver);
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

  private static abstract class PrivateCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrivateCatalogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.privatecatalog.v1beta1.PrivateCatalogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrivateCatalog");
    }
  }

  private static final class PrivateCatalogFileDescriptorSupplier
      extends PrivateCatalogBaseDescriptorSupplier {
    PrivateCatalogFileDescriptorSupplier() {}
  }

  private static final class PrivateCatalogMethodDescriptorSupplier
      extends PrivateCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrivateCatalogMethodDescriptorSupplier(String methodName) {
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
      synchronized (PrivateCatalogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrivateCatalogFileDescriptorSupplier())
              .addMethod(getSearchCatalogsMethod())
              .addMethod(getSearchProductsMethod())
              .addMethod(getSearchVersionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
