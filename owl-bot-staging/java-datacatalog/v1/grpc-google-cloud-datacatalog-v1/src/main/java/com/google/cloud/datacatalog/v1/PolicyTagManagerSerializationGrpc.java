package com.google.cloud.datacatalog.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Policy Tag Manager Serialization API service allows you to manipulate
 * your policy tags and taxonomies in a serialized format.
 * Taxonomy is a hierarchical group of policy tags.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datacatalog/v1/policytagmanagerserialization.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PolicyTagManagerSerializationGrpc {

  private PolicyTagManagerSerializationGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1.PolicyTagManagerSerialization";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getReplaceTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceTaxonomy",
      requestType = com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest.class,
      responseType = com.google.cloud.datacatalog.v1.Taxonomy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getReplaceTaxonomyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy> getReplaceTaxonomyMethod;
    if ((getReplaceTaxonomyMethod = PolicyTagManagerSerializationGrpc.getReplaceTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerSerializationGrpc.class) {
        if ((getReplaceTaxonomyMethod = PolicyTagManagerSerializationGrpc.getReplaceTaxonomyMethod) == null) {
          PolicyTagManagerSerializationGrpc.getReplaceTaxonomyMethod = getReplaceTaxonomyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceTaxonomy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.Taxonomy.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerSerializationMethodDescriptorSupplier("ReplaceTaxonomy"))
              .build();
        }
      }
    }
    return getReplaceTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse> getImportTaxonomiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportTaxonomies",
      requestType = com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest.class,
      responseType = com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse> getImportTaxonomiesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest, com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse> getImportTaxonomiesMethod;
    if ((getImportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getImportTaxonomiesMethod) == null) {
      synchronized (PolicyTagManagerSerializationGrpc.class) {
        if ((getImportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getImportTaxonomiesMethod) == null) {
          PolicyTagManagerSerializationGrpc.getImportTaxonomiesMethod = getImportTaxonomiesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest, com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportTaxonomies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerSerializationMethodDescriptorSupplier("ImportTaxonomies"))
              .build();
        }
      }
    }
    return getImportTaxonomiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse> getExportTaxonomiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportTaxonomies",
      requestType = com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest.class,
      responseType = com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest,
      com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse> getExportTaxonomiesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest, com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse> getExportTaxonomiesMethod;
    if ((getExportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getExportTaxonomiesMethod) == null) {
      synchronized (PolicyTagManagerSerializationGrpc.class) {
        if ((getExportTaxonomiesMethod = PolicyTagManagerSerializationGrpc.getExportTaxonomiesMethod) == null) {
          PolicyTagManagerSerializationGrpc.getExportTaxonomiesMethod = getExportTaxonomiesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest, com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportTaxonomies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse.getDefaultInstance()))
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
   * Policy Tag Manager Serialization API service allows you to manipulate
   * your policy tags and taxonomies in a serialized format.
   * Taxonomy is a hierarchical group of policy tags.
   * </pre>
   */
  public static abstract class PolicyTagManagerSerializationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Replaces (updates) a taxonomy and all its policy tags.
     * The taxonomy and its entire hierarchy of policy tags must be
     * represented literally by `SerializedTaxonomy` and the nested
     * `SerializedPolicyTag` messages.
     * This operation automatically does the following:
     * - Deletes the existing policy tags that are missing from the
     *   `SerializedPolicyTag`.
     * - Creates policy tags that don't have resource names. They are considered
     *   new.
     * - Updates policy tags with valid resources names accordingly.
     * </pre>
     */
    public void replaceTaxonomy(com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReplaceTaxonomyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates new taxonomies (including their policy tags) in a given project
     * by importing from inlined or cross-regional sources.
     * For a cross-regional source, new taxonomies are created by copying
     * from a source in another region.
     * For an inlined source, taxonomies and policy tags are created in bulk using
     * nested protocol buffer structures.
     * </pre>
     */
    public void importTaxonomies(com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportTaxonomiesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports taxonomies in the requested type and returns them,
     * including their policy tags. The requested taxonomies must belong to the
     * same project.
     * This method generates `SerializedTaxonomy` protocol buffers with nested
     * policy tags that can be used as input for `ImportTaxonomies` calls.
     * </pre>
     */
    public void exportTaxonomies(com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportTaxonomiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReplaceTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest,
                com.google.cloud.datacatalog.v1.Taxonomy>(
                  this, METHODID_REPLACE_TAXONOMY)))
          .addMethod(
            getImportTaxonomiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest,
                com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse>(
                  this, METHODID_IMPORT_TAXONOMIES)))
          .addMethod(
            getExportTaxonomiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest,
                com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse>(
                  this, METHODID_EXPORT_TAXONOMIES)))
          .build();
    }
  }

  /**
   * <pre>
   * Policy Tag Manager Serialization API service allows you to manipulate
   * your policy tags and taxonomies in a serialized format.
   * Taxonomy is a hierarchical group of policy tags.
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
     * Replaces (updates) a taxonomy and all its policy tags.
     * The taxonomy and its entire hierarchy of policy tags must be
     * represented literally by `SerializedTaxonomy` and the nested
     * `SerializedPolicyTag` messages.
     * This operation automatically does the following:
     * - Deletes the existing policy tags that are missing from the
     *   `SerializedPolicyTag`.
     * - Creates policy tags that don't have resource names. They are considered
     *   new.
     * - Updates policy tags with valid resources names accordingly.
     * </pre>
     */
    public void replaceTaxonomy(com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReplaceTaxonomyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates new taxonomies (including their policy tags) in a given project
     * by importing from inlined or cross-regional sources.
     * For a cross-regional source, new taxonomies are created by copying
     * from a source in another region.
     * For an inlined source, taxonomies and policy tags are created in bulk using
     * nested protocol buffer structures.
     * </pre>
     */
    public void importTaxonomies(com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportTaxonomiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports taxonomies in the requested type and returns them,
     * including their policy tags. The requested taxonomies must belong to the
     * same project.
     * This method generates `SerializedTaxonomy` protocol buffers with nested
     * policy tags that can be used as input for `ImportTaxonomies` calls.
     * </pre>
     */
    public void exportTaxonomies(com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportTaxonomiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Policy Tag Manager Serialization API service allows you to manipulate
   * your policy tags and taxonomies in a serialized format.
   * Taxonomy is a hierarchical group of policy tags.
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
     * Replaces (updates) a taxonomy and all its policy tags.
     * The taxonomy and its entire hierarchy of policy tags must be
     * represented literally by `SerializedTaxonomy` and the nested
     * `SerializedPolicyTag` messages.
     * This operation automatically does the following:
     * - Deletes the existing policy tags that are missing from the
     *   `SerializedPolicyTag`.
     * - Creates policy tags that don't have resource names. They are considered
     *   new.
     * - Updates policy tags with valid resources names accordingly.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.Taxonomy replaceTaxonomy(com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReplaceTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates new taxonomies (including their policy tags) in a given project
     * by importing from inlined or cross-regional sources.
     * For a cross-regional source, new taxonomies are created by copying
     * from a source in another region.
     * For an inlined source, taxonomies and policy tags are created in bulk using
     * nested protocol buffer structures.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse importTaxonomies(com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportTaxonomiesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports taxonomies in the requested type and returns them,
     * including their policy tags. The requested taxonomies must belong to the
     * same project.
     * This method generates `SerializedTaxonomy` protocol buffers with nested
     * policy tags that can be used as input for `ImportTaxonomies` calls.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse exportTaxonomies(com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportTaxonomiesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Policy Tag Manager Serialization API service allows you to manipulate
   * your policy tags and taxonomies in a serialized format.
   * Taxonomy is a hierarchical group of policy tags.
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
     * Replaces (updates) a taxonomy and all its policy tags.
     * The taxonomy and its entire hierarchy of policy tags must be
     * represented literally by `SerializedTaxonomy` and the nested
     * `SerializedPolicyTag` messages.
     * This operation automatically does the following:
     * - Deletes the existing policy tags that are missing from the
     *   `SerializedPolicyTag`.
     * - Creates policy tags that don't have resource names. They are considered
     *   new.
     * - Updates policy tags with valid resources names accordingly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.Taxonomy> replaceTaxonomy(
        com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReplaceTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates new taxonomies (including their policy tags) in a given project
     * by importing from inlined or cross-regional sources.
     * For a cross-regional source, new taxonomies are created by copying
     * from a source in another region.
     * For an inlined source, taxonomies and policy tags are created in bulk using
     * nested protocol buffer structures.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse> importTaxonomies(
        com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportTaxonomiesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports taxonomies in the requested type and returns them,
     * including their policy tags. The requested taxonomies must belong to the
     * same project.
     * This method generates `SerializedTaxonomy` protocol buffers with nested
     * policy tags that can be used as input for `ImportTaxonomies` calls.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse> exportTaxonomies(
        com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportTaxonomiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPLACE_TAXONOMY = 0;
  private static final int METHODID_IMPORT_TAXONOMIES = 1;
  private static final int METHODID_EXPORT_TAXONOMIES = 2;

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
        case METHODID_REPLACE_TAXONOMY:
          serviceImpl.replaceTaxonomy((com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy>) responseObserver);
          break;
        case METHODID_IMPORT_TAXONOMIES:
          serviceImpl.importTaxonomies((com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse>) responseObserver);
          break;
        case METHODID_EXPORT_TAXONOMIES:
          serviceImpl.exportTaxonomies((com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse>) responseObserver);
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
      return com.google.cloud.datacatalog.v1.PolicyTagManagerSerializationProto.getDescriptor();
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
              .addMethod(getReplaceTaxonomyMethod())
              .addMethod(getImportTaxonomiesMethod())
              .addMethod(getExportTaxonomiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
