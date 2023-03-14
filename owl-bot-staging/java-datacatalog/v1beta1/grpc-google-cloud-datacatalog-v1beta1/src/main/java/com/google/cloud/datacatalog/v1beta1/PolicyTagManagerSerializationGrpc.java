package com.google.cloud.datacatalog.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Policy tag manager serialization API service allows clients to manipulate
 * their taxonomies and policy tags data with serialized format.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datacatalog/v1beta1/policytagmanagerserialization.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PolicyTagManagerSerializationGrpc {

  private PolicyTagManagerSerializationGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1beta1.PolicyTagManagerSerialization";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse> getImportTaxonomiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportTaxonomies",
      requestType = com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse> getImportTaxonomiesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest, com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse> getImportTaxonomiesMethod;
    if ((getImportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getImportTaxonomiesMethod) == null) {
      synchronized (PolicyTagManagerSerializationGrpc.class) {
        if ((getImportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getImportTaxonomiesMethod) == null) {
          PolicyTagManagerSerializationGrpc.getImportTaxonomiesMethod = getImportTaxonomiesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest, com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportTaxonomies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerSerializationMethodDescriptorSupplier("ImportTaxonomies"))
              .build();
        }
      }
    }
    return getImportTaxonomiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse> getExportTaxonomiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportTaxonomies",
      requestType = com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse> getExportTaxonomiesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest, com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse> getExportTaxonomiesMethod;
    if ((getExportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getExportTaxonomiesMethod) == null) {
      synchronized (PolicyTagManagerSerializationGrpc.class) {
        if ((getExportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getExportTaxonomiesMethod) == null) {
          PolicyTagManagerSerializationGrpc.getExportTaxonomiesMethod = getExportTaxonomiesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest, com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportTaxonomies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerSerializationMethodDescriptorSupplier("ExportTaxonomies"))
              .build();
        }
      }
    }
    return getExportTaxonomiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PolicyTagManagerSerializationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerSerializationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerSerializationStub>() {
        @java.lang.Override
        public PolicyTagManagerSerializationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTagManagerSerializationStub(channel, callOptions);
        }
      };
    return PolicyTagManagerSerializationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolicyTagManagerSerializationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerSerializationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerSerializationBlockingStub>() {
        @java.lang.Override
        public PolicyTagManagerSerializationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTagManagerSerializationBlockingStub(channel, callOptions);
        }
      };
    return PolicyTagManagerSerializationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PolicyTagManagerSerializationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerSerializationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerSerializationFutureStub>() {
        @java.lang.Override
        public PolicyTagManagerSerializationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTagManagerSerializationFutureStub(channel, callOptions);
        }
      };
    return PolicyTagManagerSerializationFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Policy tag manager serialization API service allows clients to manipulate
   * their taxonomies and policy tags data with serialized format.
   * </pre>
   */
  public static abstract class PolicyTagManagerSerializationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Imports all taxonomies and their policy tags to a project as new
     * taxonomies.
     * This method provides a bulk taxonomy / policy tag creation using nested
     * proto structure.
     * </pre>
     */
    public void importTaxonomies(com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportTaxonomiesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports all taxonomies and their policy tags in a project.
     * This method generates SerializedTaxonomy protos with nested policy tags
     * that can be used as an input for future ImportTaxonomies calls.
     * </pre>
     */
    public void exportTaxonomies(com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportTaxonomiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getImportTaxonomiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest,
                com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse>(
                  this, METHODID_IMPORT_TAXONOMIES)))
          .addMethod(
            getExportTaxonomiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest,
                com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse>(
                  this, METHODID_EXPORT_TAXONOMIES)))
          .build();
    }
  }

  /**
   * <pre>
   * Policy tag manager serialization API service allows clients to manipulate
   * their taxonomies and policy tags data with serialized format.
   * </pre>
   */
  public static final class PolicyTagManagerSerializationStub extends io.grpc.stub.AbstractAsyncStub<PolicyTagManagerSerializationStub> {
    private PolicyTagManagerSerializationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerSerializationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerSerializationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Imports all taxonomies and their policy tags to a project as new
     * taxonomies.
     * This method provides a bulk taxonomy / policy tag creation using nested
     * proto structure.
     * </pre>
     */
    public void importTaxonomies(com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportTaxonomiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports all taxonomies and their policy tags in a project.
     * This method generates SerializedTaxonomy protos with nested policy tags
     * that can be used as an input for future ImportTaxonomies calls.
     * </pre>
     */
    public void exportTaxonomies(com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportTaxonomiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Policy tag manager serialization API service allows clients to manipulate
   * their taxonomies and policy tags data with serialized format.
   * </pre>
   */
  public static final class PolicyTagManagerSerializationBlockingStub extends io.grpc.stub.AbstractBlockingStub<PolicyTagManagerSerializationBlockingStub> {
    private PolicyTagManagerSerializationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerSerializationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerSerializationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Imports all taxonomies and their policy tags to a project as new
     * taxonomies.
     * This method provides a bulk taxonomy / policy tag creation using nested
     * proto structure.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse importTaxonomies(com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportTaxonomiesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports all taxonomies and their policy tags in a project.
     * This method generates SerializedTaxonomy protos with nested policy tags
     * that can be used as an input for future ImportTaxonomies calls.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse exportTaxonomies(com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportTaxonomiesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Policy tag manager serialization API service allows clients to manipulate
   * their taxonomies and policy tags data with serialized format.
   * </pre>
   */
  public static final class PolicyTagManagerSerializationFutureStub extends io.grpc.stub.AbstractFutureStub<PolicyTagManagerSerializationFutureStub> {
    private PolicyTagManagerSerializationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerSerializationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerSerializationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Imports all taxonomies and their policy tags to a project as new
     * taxonomies.
     * This method provides a bulk taxonomy / policy tag creation using nested
     * proto structure.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse> importTaxonomies(
        com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportTaxonomiesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports all taxonomies and their policy tags in a project.
     * This method generates SerializedTaxonomy protos with nested policy tags
     * that can be used as an input for future ImportTaxonomies calls.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse> exportTaxonomies(
        com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportTaxonomiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IMPORT_TAXONOMIES = 0;
  private static final int METHODID_EXPORT_TAXONOMIES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PolicyTagManagerSerializationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PolicyTagManagerSerializationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_IMPORT_TAXONOMIES:
          serviceImpl.importTaxonomies((com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ImportTaxonomiesResponse>) responseObserver);
          break;
        case METHODID_EXPORT_TAXONOMIES:
          serviceImpl.exportTaxonomies((com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ExportTaxonomiesResponse>) responseObserver);
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

  private static abstract class PolicyTagManagerSerializationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolicyTagManagerSerializationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.v1beta1.PolicyTagManagerSerializationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PolicyTagManagerSerialization");
    }
  }

  private static final class PolicyTagManagerSerializationFileDescriptorSupplier
      extends PolicyTagManagerSerializationBaseDescriptorSupplier {
    PolicyTagManagerSerializationFileDescriptorSupplier() {}
  }

  private static final class PolicyTagManagerSerializationMethodDescriptorSupplier
      extends PolicyTagManagerSerializationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PolicyTagManagerSerializationMethodDescriptorSupplier(String methodName) {
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
      synchronized (PolicyTagManagerSerializationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PolicyTagManagerSerializationFileDescriptorSupplier())
              .addMethod(getImportTaxonomiesMethod())
              .addMethod(getExportTaxonomiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
