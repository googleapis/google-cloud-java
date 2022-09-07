package com.google.cloud.gkehub.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The GKE Hub MembershipService handles the registration of many Kubernetes
 * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1beta1.Membership] resource.
 * GKE Hub is currently only available in the global region.
 * **Membership management may be non-trivial:** it is recommended to use one
 * of the Google-provided client libraries or tools where possible when working
 * with Membership resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkehub/v1beta1/membership.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GkeHubMembershipServiceGrpc {

  private GkeHubMembershipServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkehub.v1beta1.GkeHubMembershipService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.ListMembershipsRequest,
      com.google.cloud.gkehub.v1beta1.ListMembershipsResponse> getListMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMemberships",
      requestType = com.google.cloud.gkehub.v1beta1.ListMembershipsRequest.class,
      responseType = com.google.cloud.gkehub.v1beta1.ListMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.ListMembershipsRequest,
      com.google.cloud.gkehub.v1beta1.ListMembershipsResponse> getListMembershipsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.ListMembershipsRequest, com.google.cloud.gkehub.v1beta1.ListMembershipsResponse> getListMembershipsMethod;
    if ((getListMembershipsMethod = GkeHubMembershipServiceGrpc.getListMembershipsMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getListMembershipsMethod = GkeHubMembershipServiceGrpc.getListMembershipsMethod) == null) {
          GkeHubMembershipServiceGrpc.getListMembershipsMethod = getListMembershipsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.ListMembershipsRequest, com.google.cloud.gkehub.v1beta1.ListMembershipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMemberships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.ListMembershipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("ListMemberships"))
              .build();
        }
      }
    }
    return getListMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GetMembershipRequest,
      com.google.cloud.gkehub.v1beta1.Membership> getGetMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembership",
      requestType = com.google.cloud.gkehub.v1beta1.GetMembershipRequest.class,
      responseType = com.google.cloud.gkehub.v1beta1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GetMembershipRequest,
      com.google.cloud.gkehub.v1beta1.Membership> getGetMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GetMembershipRequest, com.google.cloud.gkehub.v1beta1.Membership> getGetMembershipMethod;
    if ((getGetMembershipMethod = GkeHubMembershipServiceGrpc.getGetMembershipMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getGetMembershipMethod = GkeHubMembershipServiceGrpc.getGetMembershipMethod) == null) {
          GkeHubMembershipServiceGrpc.getGetMembershipMethod = getGetMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.GetMembershipRequest, com.google.cloud.gkehub.v1beta1.Membership>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.Membership.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("GetMembership"))
              .build();
        }
      }
    }
    return getGetMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.CreateMembershipRequest,
      com.google.longrunning.Operation> getCreateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembership",
      requestType = com.google.cloud.gkehub.v1beta1.CreateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.CreateMembershipRequest,
      com.google.longrunning.Operation> getCreateMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.CreateMembershipRequest, com.google.longrunning.Operation> getCreateMembershipMethod;
    if ((getCreateMembershipMethod = GkeHubMembershipServiceGrpc.getCreateMembershipMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getCreateMembershipMethod = GkeHubMembershipServiceGrpc.getCreateMembershipMethod) == null) {
          GkeHubMembershipServiceGrpc.getCreateMembershipMethod = getCreateMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.CreateMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("CreateMembership"))
              .build();
        }
      }
    }
    return getCreateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest,
      com.google.longrunning.Operation> getDeleteMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembership",
      requestType = com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest,
      com.google.longrunning.Operation> getDeleteMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest, com.google.longrunning.Operation> getDeleteMembershipMethod;
    if ((getDeleteMembershipMethod = GkeHubMembershipServiceGrpc.getDeleteMembershipMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getDeleteMembershipMethod = GkeHubMembershipServiceGrpc.getDeleteMembershipMethod) == null) {
          GkeHubMembershipServiceGrpc.getDeleteMembershipMethod = getDeleteMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("DeleteMembership"))
              .build();
        }
      }
    }
    return getDeleteMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest,
      com.google.longrunning.Operation> getUpdateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembership",
      requestType = com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest,
      com.google.longrunning.Operation> getUpdateMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest, com.google.longrunning.Operation> getUpdateMembershipMethod;
    if ((getUpdateMembershipMethod = GkeHubMembershipServiceGrpc.getUpdateMembershipMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getUpdateMembershipMethod = GkeHubMembershipServiceGrpc.getUpdateMembershipMethod) == null) {
          GkeHubMembershipServiceGrpc.getUpdateMembershipMethod = getUpdateMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("UpdateMembership"))
              .build();
        }
      }
    }
    return getUpdateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest,
      com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse> getGenerateConnectManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateConnectManifest",
      requestType = com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest.class,
      responseType = com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest,
      com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse> getGenerateConnectManifestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest, com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse> getGenerateConnectManifestMethod;
    if ((getGenerateConnectManifestMethod = GkeHubMembershipServiceGrpc.getGenerateConnectManifestMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getGenerateConnectManifestMethod = GkeHubMembershipServiceGrpc.getGenerateConnectManifestMethod) == null) {
          GkeHubMembershipServiceGrpc.getGenerateConnectManifestMethod = getGenerateConnectManifestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest, com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateConnectManifest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("GenerateConnectManifest"))
              .build();
        }
      }
    }
    return getGenerateConnectManifestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest,
      com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse> getValidateExclusivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateExclusivity",
      requestType = com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest.class,
      responseType = com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest,
      com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse> getValidateExclusivityMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest, com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse> getValidateExclusivityMethod;
    if ((getValidateExclusivityMethod = GkeHubMembershipServiceGrpc.getValidateExclusivityMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getValidateExclusivityMethod = GkeHubMembershipServiceGrpc.getValidateExclusivityMethod) == null) {
          GkeHubMembershipServiceGrpc.getValidateExclusivityMethod = getValidateExclusivityMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest, com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateExclusivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("ValidateExclusivity"))
              .build();
        }
      }
    }
    return getValidateExclusivityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest,
      com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse> getGenerateExclusivityManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateExclusivityManifest",
      requestType = com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest.class,
      responseType = com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest,
      com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse> getGenerateExclusivityManifestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest, com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse> getGenerateExclusivityManifestMethod;
    if ((getGenerateExclusivityManifestMethod = GkeHubMembershipServiceGrpc.getGenerateExclusivityManifestMethod) == null) {
      synchronized (GkeHubMembershipServiceGrpc.class) {
        if ((getGenerateExclusivityManifestMethod = GkeHubMembershipServiceGrpc.getGenerateExclusivityManifestMethod) == null) {
          GkeHubMembershipServiceGrpc.getGenerateExclusivityManifestMethod = getGenerateExclusivityManifestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest, com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateExclusivityManifest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMembershipServiceMethodDescriptorSupplier("GenerateExclusivityManifest"))
              .build();
        }
      }
    }
    return getGenerateExclusivityManifestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GkeHubMembershipServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubMembershipServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubMembershipServiceStub>() {
        @java.lang.Override
        public GkeHubMembershipServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubMembershipServiceStub(channel, callOptions);
        }
      };
    return GkeHubMembershipServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GkeHubMembershipServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubMembershipServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubMembershipServiceBlockingStub>() {
        @java.lang.Override
        public GkeHubMembershipServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubMembershipServiceBlockingStub(channel, callOptions);
        }
      };
    return GkeHubMembershipServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GkeHubMembershipServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubMembershipServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GkeHubMembershipServiceFutureStub>() {
        @java.lang.Override
        public GkeHubMembershipServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GkeHubMembershipServiceFutureStub(channel, callOptions);
        }
      };
    return GkeHubMembershipServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The GKE Hub MembershipService handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1beta1.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static abstract class GkeHubMembershipServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public void listMemberships(com.google.cloud.gkehub.v1beta1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMembershipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(com.google.cloud.gkehub.v1beta1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.Membership> responseObserver) {
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
    public void createMembership(com.google.cloud.gkehub.v1beta1.CreateMembershipRequest request,
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
    public void deleteMembership(com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest request,
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
    public void generateConnectManifest(com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateConnectManifestMethod(), responseObserver);
    }

    /**
     * <pre>
     * ValidateExclusivity validates the state of exclusivity in the cluster.
     * The validation does not depend on an existing Hub membership resource.
     * </pre>
     */
    public void validateExclusivity(com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateExclusivityMethod(), responseObserver);
    }

    /**
     * <pre>
     * GenerateExclusivityManifest generates the manifests to update the
     * exclusivity artifacts in the cluster if needed.
     * Exclusivity artifacts include the Membership custom resource definition
     * (CRD) and the singleton Membership custom resource (CR). Combined with
     * ValidateExclusivity, exclusivity artifacts guarantee that a Kubernetes
     * cluster is only registered to a single GKE Hub.
     * The Membership CRD is versioned, and may require conversion when the GKE
     * Hub API server begins serving a newer version of the CRD and
     * corresponding CR. The response will be the converted CRD and CR if there
     * are any differences between the versions.
     * </pre>
     */
    public void generateExclusivityManifest(com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateExclusivityManifestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.ListMembershipsRequest,
                com.google.cloud.gkehub.v1beta1.ListMembershipsResponse>(
                  this, METHODID_LIST_MEMBERSHIPS)))
          .addMethod(
            getGetMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.GetMembershipRequest,
                com.google.cloud.gkehub.v1beta1.Membership>(
                  this, METHODID_GET_MEMBERSHIP)))
          .addMethod(
            getCreateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.CreateMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_MEMBERSHIP)))
          .addMethod(
            getDeleteMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_MEMBERSHIP)))
          .addMethod(
            getUpdateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_MEMBERSHIP)))
          .addMethod(
            getGenerateConnectManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest,
                com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse>(
                  this, METHODID_GENERATE_CONNECT_MANIFEST)))
          .addMethod(
            getValidateExclusivityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest,
                com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse>(
                  this, METHODID_VALIDATE_EXCLUSIVITY)))
          .addMethod(
            getGenerateExclusivityManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest,
                com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse>(
                  this, METHODID_GENERATE_EXCLUSIVITY_MANIFEST)))
          .build();
    }
  }

  /**
   * <pre>
   * The GKE Hub MembershipService handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1beta1.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubMembershipServiceStub extends io.grpc.stub.AbstractAsyncStub<GkeHubMembershipServiceStub> {
    private GkeHubMembershipServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubMembershipServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubMembershipServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public void listMemberships(com.google.cloud.gkehub.v1beta1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(com.google.cloud.gkehub.v1beta1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.Membership> responseObserver) {
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
    public void createMembership(com.google.cloud.gkehub.v1beta1.CreateMembershipRequest request,
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
    public void deleteMembership(com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest request,
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
    public void generateConnectManifest(com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ValidateExclusivity validates the state of exclusivity in the cluster.
     * The validation does not depend on an existing Hub membership resource.
     * </pre>
     */
    public void validateExclusivity(com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateExclusivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GenerateExclusivityManifest generates the manifests to update the
     * exclusivity artifacts in the cluster if needed.
     * Exclusivity artifacts include the Membership custom resource definition
     * (CRD) and the singleton Membership custom resource (CR). Combined with
     * ValidateExclusivity, exclusivity artifacts guarantee that a Kubernetes
     * cluster is only registered to a single GKE Hub.
     * The Membership CRD is versioned, and may require conversion when the GKE
     * Hub API server begins serving a newer version of the CRD and
     * corresponding CR. The response will be the converted CRD and CR if there
     * are any differences between the versions.
     * </pre>
     */
    public void generateExclusivityManifest(com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateExclusivityManifestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The GKE Hub MembershipService handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1beta1.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubMembershipServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GkeHubMembershipServiceBlockingStub> {
    private GkeHubMembershipServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubMembershipServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubMembershipServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1beta1.ListMembershipsResponse listMemberships(com.google.cloud.gkehub.v1beta1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.cloud.gkehub.v1beta1.Membership getMembership(com.google.cloud.gkehub.v1beta1.GetMembershipRequest request) {
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
    public com.google.longrunning.Operation createMembership(com.google.cloud.gkehub.v1beta1.CreateMembershipRequest request) {
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
    public com.google.longrunning.Operation deleteMembership(com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembership(com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest request) {
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
    public com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse generateConnectManifest(com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateConnectManifestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ValidateExclusivity validates the state of exclusivity in the cluster.
     * The validation does not depend on an existing Hub membership resource.
     * </pre>
     */
    public com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse validateExclusivity(com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateExclusivityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GenerateExclusivityManifest generates the manifests to update the
     * exclusivity artifacts in the cluster if needed.
     * Exclusivity artifacts include the Membership custom resource definition
     * (CRD) and the singleton Membership custom resource (CR). Combined with
     * ValidateExclusivity, exclusivity artifacts guarantee that a Kubernetes
     * cluster is only registered to a single GKE Hub.
     * The Membership CRD is versioned, and may require conversion when the GKE
     * Hub API server begins serving a newer version of the CRD and
     * corresponding CR. The response will be the converted CRD and CR if there
     * are any differences between the versions.
     * </pre>
     */
    public com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse generateExclusivityManifest(com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateExclusivityManifestMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The GKE Hub MembershipService handles the registration of many Kubernetes
   * clusters to Google Cloud, represented with the [Membership][google.cloud.gkehub.v1beta1.Membership] resource.
   * GKE Hub is currently only available in the global region.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubMembershipServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GkeHubMembershipServiceFutureStub> {
    private GkeHubMembershipServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubMembershipServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubMembershipServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1beta1.ListMembershipsResponse> listMemberships(
        com.google.cloud.gkehub.v1beta1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1beta1.Membership> getMembership(
        com.google.cloud.gkehub.v1beta1.GetMembershipRequest request) {
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
        com.google.cloud.gkehub.v1beta1.CreateMembershipRequest request) {
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
        com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateMembership(
        com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse> generateConnectManifest(
        com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ValidateExclusivity validates the state of exclusivity in the cluster.
     * The validation does not depend on an existing Hub membership resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse> validateExclusivity(
        com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateExclusivityMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GenerateExclusivityManifest generates the manifests to update the
     * exclusivity artifacts in the cluster if needed.
     * Exclusivity artifacts include the Membership custom resource definition
     * (CRD) and the singleton Membership custom resource (CR). Combined with
     * ValidateExclusivity, exclusivity artifacts guarantee that a Kubernetes
     * cluster is only registered to a single GKE Hub.
     * The Membership CRD is versioned, and may require conversion when the GKE
     * Hub API server begins serving a newer version of the CRD and
     * corresponding CR. The response will be the converted CRD and CR if there
     * are any differences between the versions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse> generateExclusivityManifest(
        com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateExclusivityManifestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MEMBERSHIPS = 0;
  private static final int METHODID_GET_MEMBERSHIP = 1;
  private static final int METHODID_CREATE_MEMBERSHIP = 2;
  private static final int METHODID_DELETE_MEMBERSHIP = 3;
  private static final int METHODID_UPDATE_MEMBERSHIP = 4;
  private static final int METHODID_GENERATE_CONNECT_MANIFEST = 5;
  private static final int METHODID_VALIDATE_EXCLUSIVITY = 6;
  private static final int METHODID_GENERATE_EXCLUSIVITY_MANIFEST = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GkeHubMembershipServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GkeHubMembershipServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_MEMBERSHIPS:
          serviceImpl.listMemberships((com.google.cloud.gkehub.v1beta1.ListMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.ListMembershipsResponse>) responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP:
          serviceImpl.getMembership((com.google.cloud.gkehub.v1beta1.GetMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.Membership>) responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP:
          serviceImpl.createMembership((com.google.cloud.gkehub.v1beta1.CreateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP:
          serviceImpl.deleteMembership((com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP:
          serviceImpl.updateMembership((com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_CONNECT_MANIFEST:
          serviceImpl.generateConnectManifest((com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_EXCLUSIVITY:
          serviceImpl.validateExclusivity((com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse>) responseObserver);
          break;
        case METHODID_GENERATE_EXCLUSIVITY_MANIFEST:
          serviceImpl.generateExclusivityManifest((com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse>) responseObserver);
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

  private static abstract class GkeHubMembershipServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GkeHubMembershipServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkehub.v1beta1.MembershipOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GkeHubMembershipService");
    }
  }

  private static final class GkeHubMembershipServiceFileDescriptorSupplier
      extends GkeHubMembershipServiceBaseDescriptorSupplier {
    GkeHubMembershipServiceFileDescriptorSupplier() {}
  }

  private static final class GkeHubMembershipServiceMethodDescriptorSupplier
      extends GkeHubMembershipServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GkeHubMembershipServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GkeHubMembershipServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GkeHubMembershipServiceFileDescriptorSupplier())
              .addMethod(getListMembershipsMethod())
              .addMethod(getGetMembershipMethod())
              .addMethod(getCreateMembershipMethod())
              .addMethod(getDeleteMembershipMethod())
              .addMethod(getUpdateMembershipMethod())
              .addMethod(getGenerateConnectManifestMethod())
              .addMethod(getValidateExclusivityMethod())
              .addMethod(getGenerateExclusivityManifestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
