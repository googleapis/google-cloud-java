package com.google.cloud.gkehub.v1alpha2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The GKE Hub service handles the registration of many Kubernetes
 * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1alpha2.Membership] resource.
 * GKE Hub is currently only available in the global region.
 * **Membership management may be non-trivial:** it is recommended to use one
 * of the Google-provided client libraries or tools where possible when working
 * with Membership resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkehub/v1alpha2/membership.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GkeHubGrpc {

  private GkeHubGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkehub.v1alpha2.GkeHub";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest,
      com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse> getListMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMemberships",
      requestType = com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest.class,
      responseType = com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest,
      com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse> getListMembershipsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest, com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse> getListMembershipsMethod;
    if ((getListMembershipsMethod = GkeHubGrpc.getListMembershipsMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListMembershipsMethod = GkeHubGrpc.getListMembershipsMethod) == null) {
          GkeHubGrpc.getListMembershipsMethod = getListMembershipsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest, com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMemberships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListMemberships"))
              .build();
        }
      }
    }
    return getListMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.GetMembershipRequest,
      com.google.cloud.gkehub.v1alpha2.Membership> getGetMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembership",
      requestType = com.google.cloud.gkehub.v1alpha2.GetMembershipRequest.class,
      responseType = com.google.cloud.gkehub.v1alpha2.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.GetMembershipRequest,
      com.google.cloud.gkehub.v1alpha2.Membership> getGetMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.GetMembershipRequest, com.google.cloud.gkehub.v1alpha2.Membership> getGetMembershipMethod;
    if ((getGetMembershipMethod = GkeHubGrpc.getGetMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetMembershipMethod = GkeHubGrpc.getGetMembershipMethod) == null) {
          GkeHubGrpc.getGetMembershipMethod = getGetMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.GetMembershipRequest, com.google.cloud.gkehub.v1alpha2.Membership>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.Membership.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetMembership"))
              .build();
        }
      }
    }
    return getGetMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest,
      com.google.longrunning.Operation> getCreateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembership",
      requestType = com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest,
      com.google.longrunning.Operation> getCreateMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest, com.google.longrunning.Operation> getCreateMembershipMethod;
    if ((getCreateMembershipMethod = GkeHubGrpc.getCreateMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateMembershipMethod = GkeHubGrpc.getCreateMembershipMethod) == null) {
          GkeHubGrpc.getCreateMembershipMethod = getCreateMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateMembership"))
              .build();
        }
      }
    }
    return getCreateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest,
      com.google.longrunning.Operation> getDeleteMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembership",
      requestType = com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest,
      com.google.longrunning.Operation> getDeleteMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest, com.google.longrunning.Operation> getDeleteMembershipMethod;
    if ((getDeleteMembershipMethod = GkeHubGrpc.getDeleteMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteMembershipMethod = GkeHubGrpc.getDeleteMembershipMethod) == null) {
          GkeHubGrpc.getDeleteMembershipMethod = getDeleteMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteMembership"))
              .build();
        }
      }
    }
    return getDeleteMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest,
      com.google.longrunning.Operation> getUpdateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembership",
      requestType = com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest,
      com.google.longrunning.Operation> getUpdateMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest, com.google.longrunning.Operation> getUpdateMembershipMethod;
    if ((getUpdateMembershipMethod = GkeHubGrpc.getUpdateMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateMembershipMethod = GkeHubGrpc.getUpdateMembershipMethod) == null) {
          GkeHubGrpc.getUpdateMembershipMethod = getUpdateMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateMembership"))
              .build();
        }
      }
    }
    return getUpdateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest,
      com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse> getGenerateConnectManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateConnectManifest",
      requestType = com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest.class,
      responseType = com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest,
      com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse> getGenerateConnectManifestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest, com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse> getGenerateConnectManifestMethod;
    if ((getGenerateConnectManifestMethod = GkeHubGrpc.getGenerateConnectManifestMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGenerateConnectManifestMethod = GkeHubGrpc.getGenerateConnectManifestMethod) == null) {
          GkeHubGrpc.getGenerateConnectManifestMethod = getGenerateConnectManifestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest, com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateConnectManifest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GenerateConnectManifest"))
              .build();
        }
      }
    }
    return getGenerateConnectManifestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.InitializeHubRequest,
      com.google.cloud.gkehub.v1alpha2.InitializeHubResponse> getInitializeHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitializeHub",
      requestType = com.google.cloud.gkehub.v1alpha2.InitializeHubRequest.class,
      responseType = com.google.cloud.gkehub.v1alpha2.InitializeHubResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.InitializeHubRequest,
      com.google.cloud.gkehub.v1alpha2.InitializeHubResponse> getInitializeHubMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1alpha2.InitializeHubRequest, com.google.cloud.gkehub.v1alpha2.InitializeHubResponse> getInitializeHubMethod;
    if ((getInitializeHubMethod = GkeHubGrpc.getInitializeHubMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getInitializeHubMethod = GkeHubGrpc.getInitializeHubMethod) == null) {
          GkeHubGrpc.getInitializeHubMethod = getInitializeHubMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1alpha2.InitializeHubRequest, com.google.cloud.gkehub.v1alpha2.InitializeHubResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitializeHub"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.InitializeHubRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1alpha2.InitializeHubResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("InitializeHub"))
              .build();
        }
      }
    }
    return getInitializeHubMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GkeHubStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubStub>() {
        @java.lang.Override
        public GkeHubStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubStub(channel, callOptions);
        }
      };
    return GkeHubStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GkeHubBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingStub>() {
        @java.lang.Override
        public GkeHubBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubBlockingStub(channel, callOptions);
        }
      };
    return GkeHubBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GkeHubFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubFutureStub>() {
        @java.lang.Override
        public GkeHubFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubFutureStub(channel, callOptions);
        }
      };
    return GkeHubFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1alpha2.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static abstract class GkeHubImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public void listMemberships(com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMembershipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(com.google.cloud.gkehub.v1alpha2.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public void createMembership(com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public void deleteMembership(com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public void generateConnectManifest(com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateConnectManifestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Initializes the Hub in this project, which includes creating the default
     * Hub Service Account and the Hub Workload Identity Pool. Initialization is
     * optional, and happens automatically when the first Membership is created.
     * InitializeHub should be called when the first Membership cannot be
     * registered without these resources. A common example is granting the Hub
     * Service Account access to another project, which requires the account to
     * exist first.
     * </pre>
     */
    public void initializeHub(com.google.cloud.gkehub.v1alpha2.InitializeHubRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.InitializeHubResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializeHubMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest,
                com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse>(
                  this, METHODID_LIST_MEMBERSHIPS)))
          .addMethod(
            getGetMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.GetMembershipRequest,
                com.google.cloud.gkehub.v1alpha2.Membership>(
                  this, METHODID_GET_MEMBERSHIP)))
          .addMethod(
            getCreateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_MEMBERSHIP)))
          .addMethod(
            getDeleteMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_MEMBERSHIP)))
          .addMethod(
            getUpdateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_MEMBERSHIP)))
          .addMethod(
            getGenerateConnectManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest,
                com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse>(
                  this, METHODID_GENERATE_CONNECT_MANIFEST)))
          .addMethod(
            getInitializeHubMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1alpha2.InitializeHubRequest,
                com.google.cloud.gkehub.v1alpha2.InitializeHubResponse>(
                  this, METHODID_INITIALIZE_HUB)))
          .build();
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1alpha2.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubStub extends io.grpc.stub.AbstractAsyncStub<GkeHubStub> {
    private GkeHubStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public void listMemberships(com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(com.google.cloud.gkehub.v1alpha2.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public void createMembership(com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public void deleteMembership(com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public void generateConnectManifest(com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Initializes the Hub in this project, which includes creating the default
     * Hub Service Account and the Hub Workload Identity Pool. Initialization is
     * optional, and happens automatically when the first Membership is created.
     * InitializeHub should be called when the first Membership cannot be
     * registered without these resources. A common example is granting the Hub
     * Service Account access to another project, which requires the account to
     * exist first.
     * </pre>
     */
    public void initializeHub(com.google.cloud.gkehub.v1alpha2.InitializeHubRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.InitializeHubResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeHubMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1alpha2.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubBlockingStub extends io.grpc.stub.AbstractBlockingStub<GkeHubBlockingStub> {
    private GkeHubBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse listMemberships(com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.cloud.gkehub.v1alpha2.Membership getMembership(com.google.cloud.gkehub.v1alpha2.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation createMembership(com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembership(com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembership(com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse generateConnectManifest(com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateConnectManifestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Initializes the Hub in this project, which includes creating the default
     * Hub Service Account and the Hub Workload Identity Pool. Initialization is
     * optional, and happens automatically when the first Membership is created.
     * InitializeHub should be called when the first Membership cannot be
     * registered without these resources. A common example is granting the Hub
     * Service Account access to another project, which requires the account to
     * exist first.
     * </pre>
     */
    public com.google.cloud.gkehub.v1alpha2.InitializeHubResponse initializeHub(com.google.cloud.gkehub.v1alpha2.InitializeHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeHubMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1alpha2.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubFutureStub extends io.grpc.stub.AbstractFutureStub<GkeHubFutureStub> {
    private GkeHubFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse> listMemberships(
        com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1alpha2.Membership> getMembership(
        com.google.cloud.gkehub.v1alpha2.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createMembership(
        com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteMembership(
        com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateMembership(
        com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse> generateConnectManifest(
        com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Initializes the Hub in this project, which includes creating the default
     * Hub Service Account and the Hub Workload Identity Pool. Initialization is
     * optional, and happens automatically when the first Membership is created.
     * InitializeHub should be called when the first Membership cannot be
     * registered without these resources. A common example is granting the Hub
     * Service Account access to another project, which requires the account to
     * exist first.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1alpha2.InitializeHubResponse> initializeHub(
        com.google.cloud.gkehub.v1alpha2.InitializeHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeHubMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MEMBERSHIPS = 0;
  private static final int METHODID_GET_MEMBERSHIP = 1;
  private static final int METHODID_CREATE_MEMBERSHIP = 2;
  private static final int METHODID_DELETE_MEMBERSHIP = 3;
  private static final int METHODID_UPDATE_MEMBERSHIP = 4;
  private static final int METHODID_GENERATE_CONNECT_MANIFEST = 5;
  private static final int METHODID_INITIALIZE_HUB = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GkeHubImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GkeHubImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_MEMBERSHIPS:
          serviceImpl.listMemberships((com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse>) responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP:
          serviceImpl.getMembership((com.google.cloud.gkehub.v1alpha2.GetMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.Membership>) responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP:
          serviceImpl.createMembership((com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP:
          serviceImpl.deleteMembership((com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP:
          serviceImpl.updateMembership((com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_CONNECT_MANIFEST:
          serviceImpl.generateConnectManifest((com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse>) responseObserver);
          break;
        case METHODID_INITIALIZE_HUB:
          serviceImpl.initializeHub((com.google.cloud.gkehub.v1alpha2.InitializeHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1alpha2.InitializeHubResponse>) responseObserver);
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

  private static abstract class GkeHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GkeHubBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkehub.v1alpha2.MembershipProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GkeHub");
    }
  }

  private static final class GkeHubFileDescriptorSupplier
      extends GkeHubBaseDescriptorSupplier {
    GkeHubFileDescriptorSupplier() {}
  }

  private static final class GkeHubMethodDescriptorSupplier
      extends GkeHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GkeHubMethodDescriptorSupplier(String methodName) {
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
      synchronized (GkeHubGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GkeHubFileDescriptorSupplier())
              .addMethod(getListMembershipsMethod())
              .addMethod(getGetMembershipMethod())
              .addMethod(getCreateMembershipMethod())
              .addMethod(getDeleteMembershipMethod())
              .addMethod(getUpdateMembershipMethod())
              .addMethod(getGenerateConnectManifestMethod())
              .addMethod(getInitializeHubMethod())
              .build();
        }
      }
    }
    return result;
  }
}
