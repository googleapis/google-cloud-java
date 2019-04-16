package com.google.cloud.datacatalog;

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
 * Cloud Data Catalog is a service that allows clients to discover,
 * manage, and understand their Google Cloud data resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/datacatalog/v1beta1/datacatalog.proto")
public final class DataCatalogGrpc {

  private DataCatalogGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1beta1.DataCatalog";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLookupEntryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      METHOD_LOOKUP_ENTRY = getLookupEntryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      getLookupEntryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      getLookupEntryMethod() {
    return getLookupEntryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      getLookupEntryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
        getLookupEntryMethod;
    if ((getLookupEntryMethod = DataCatalogGrpc.getLookupEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getLookupEntryMethod = DataCatalogGrpc.getLookupEntryMethod) == null) {
          DataCatalogGrpc.getLookupEntryMethod =
              getLookupEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.LookupEntryRequest,
                          com.google.cloud.datacatalog.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "LookupEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.LookupEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("LookupEntry"))
                      .build();
        }
      }
    }
    return getLookupEntryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataCatalogStub newStub(io.grpc.Channel channel) {
    return new DataCatalogStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataCatalogBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new DataCatalogBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataCatalogFutureStub newFutureStub(io.grpc.Channel channel) {
    return new DataCatalogFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Data Catalog is a service that allows clients to discover,
   * manage, and understand their Google Cloud data resources.
   * </pre>
   */
  public abstract static class DataCatalogImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Cloud Data Catalog Entry.
     * </pre>
     */
    public void lookupEntry(
        com.google.cloud.datacatalog.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnimplementedUnaryCall(getLookupEntryMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getLookupEntryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.LookupEntryRequest,
                      com.google.cloud.datacatalog.Entry>(this, METHODID_LOOKUP_ENTRY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Data Catalog is a service that allows clients to discover,
   * manage, and understand their Google Cloud data resources.
   * </pre>
   */
  public static final class DataCatalogStub extends io.grpc.stub.AbstractStub<DataCatalogStub> {
    private DataCatalogStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataCatalogStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataCatalogStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataCatalogStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Cloud Data Catalog Entry.
     * </pre>
     */
    public void lookupEntry(
        com.google.cloud.datacatalog.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLookupEntryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Data Catalog is a service that allows clients to discover,
   * manage, and understand their Google Cloud data resources.
   * </pre>
   */
  public static final class DataCatalogBlockingStub
      extends io.grpc.stub.AbstractStub<DataCatalogBlockingStub> {
    private DataCatalogBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataCatalogBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataCatalogBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataCatalogBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Cloud Data Catalog Entry.
     * </pre>
     */
    public com.google.cloud.datacatalog.Entry lookupEntry(
        com.google.cloud.datacatalog.LookupEntryRequest request) {
      return blockingUnaryCall(
          getChannel(), getLookupEntryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Data Catalog is a service that allows clients to discover,
   * manage, and understand their Google Cloud data resources.
   * </pre>
   */
  public static final class DataCatalogFutureStub
      extends io.grpc.stub.AbstractStub<DataCatalogFutureStub> {
    private DataCatalogFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataCatalogFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataCatalogFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataCatalogFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Cloud Data Catalog Entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Entry>
        lookupEntry(com.google.cloud.datacatalog.LookupEntryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLookupEntryMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOOKUP_ENTRY = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataCatalogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataCatalogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOOKUP_ENTRY:
          serviceImpl.lookupEntry(
              (com.google.cloud.datacatalog.LookupEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry>) responseObserver);
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

  private abstract static class DataCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataCatalogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.Datacatalog.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataCatalog");
    }
  }

  private static final class DataCatalogFileDescriptorSupplier
      extends DataCatalogBaseDescriptorSupplier {
    DataCatalogFileDescriptorSupplier() {}
  }

  private static final class DataCatalogMethodDescriptorSupplier
      extends DataCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataCatalogMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataCatalogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataCatalogFileDescriptorSupplier())
                      .addMethod(getLookupEntryMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
