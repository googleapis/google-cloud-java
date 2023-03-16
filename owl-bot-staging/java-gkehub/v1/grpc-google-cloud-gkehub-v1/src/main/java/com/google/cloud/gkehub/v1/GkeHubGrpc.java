package com.google.cloud.gkehub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The GKE Hub service handles the registration of many Kubernetes clusters to
 * Google Cloud, and the management of multi-cluster features over those
 * clusters.
 * The GKE Hub service operates on the following resources:
 * * [Membership][google.cloud.gkehub.v1.Membership]
 * * [Feature][google.cloud.gkehub.v1.Feature]
 * GKE Hub is currently only available in the global region.
 * **Membership management may be non-trivial:** it is recommended to use one
 * of the Google-provided client libraries or tools where possible when working
 * with Membership resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkehub/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GkeHubGrpc {

  private GkeHubGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gkehub.v1.GkeHub";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.ListMembershipsRequest,
      com.google.cloud.gkehub.v1.ListMembershipsResponse> getListMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMemberships",
      requestType = com.google.cloud.gkehub.v1.ListMembershipsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.ListMembershipsRequest,
      com.google.cloud.gkehub.v1.ListMembershipsResponse> getListMembershipsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.ListMembershipsRequest, com.google.cloud.gkehub.v1.ListMembershipsResponse> getListMembershipsMethod;
    if ((getListMembershipsMethod = GkeHubGrpc.getListMembershipsMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListMembershipsMethod = GkeHubGrpc.getListMembershipsMethod) == null) {
          GkeHubGrpc.getListMembershipsMethod = getListMembershipsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.ListMembershipsRequest, com.google.cloud.gkehub.v1.ListMembershipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMemberships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.ListMembershipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListMemberships"))
              .build();
        }
      }
    }
    return getListMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.ListFeaturesRequest,
      com.google.cloud.gkehub.v1.ListFeaturesResponse> getListFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatures",
      requestType = com.google.cloud.gkehub.v1.ListFeaturesRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.ListFeaturesRequest,
      com.google.cloud.gkehub.v1.ListFeaturesResponse> getListFeaturesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.ListFeaturesRequest, com.google.cloud.gkehub.v1.ListFeaturesResponse> getListFeaturesMethod;
    if ((getListFeaturesMethod = GkeHubGrpc.getListFeaturesMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListFeaturesMethod = GkeHubGrpc.getListFeaturesMethod) == null) {
          GkeHubGrpc.getListFeaturesMethod = getListFeaturesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.ListFeaturesRequest, com.google.cloud.gkehub.v1.ListFeaturesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.ListFeaturesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.ListFeaturesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListFeatures"))
              .build();
        }
      }
    }
    return getListFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GetMembershipRequest,
      com.google.cloud.gkehub.v1.Membership> getGetMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembership",
      requestType = com.google.cloud.gkehub.v1.GetMembershipRequest.class,
      responseType = com.google.cloud.gkehub.v1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GetMembershipRequest,
      com.google.cloud.gkehub.v1.Membership> getGetMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GetMembershipRequest, com.google.cloud.gkehub.v1.Membership> getGetMembershipMethod;
    if ((getGetMembershipMethod = GkeHubGrpc.getGetMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetMembershipMethod = GkeHubGrpc.getGetMembershipMethod) == null) {
          GkeHubGrpc.getGetMembershipMethod = getGetMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.GetMembershipRequest, com.google.cloud.gkehub.v1.Membership>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.Membership.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetMembership"))
              .build();
        }
      }
    }
    return getGetMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GetFeatureRequest,
      com.google.cloud.gkehub.v1.Feature> getGetFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeature",
      requestType = com.google.cloud.gkehub.v1.GetFeatureRequest.class,
      responseType = com.google.cloud.gkehub.v1.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GetFeatureRequest,
      com.google.cloud.gkehub.v1.Feature> getGetFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GetFeatureRequest, com.google.cloud.gkehub.v1.Feature> getGetFeatureMethod;
    if ((getGetFeatureMethod = GkeHubGrpc.getGetFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetFeatureMethod = GkeHubGrpc.getGetFeatureMethod) == null) {
          GkeHubGrpc.getGetFeatureMethod = getGetFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.GetFeatureRequest, com.google.cloud.gkehub.v1.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.GetFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.Feature.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetFeature"))
              .build();
        }
      }
    }
    return getGetFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.CreateMembershipRequest,
      com.google.longrunning.Operation> getCreateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembership",
      requestType = com.google.cloud.gkehub.v1.CreateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.CreateMembershipRequest,
      com.google.longrunning.Operation> getCreateMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.CreateMembershipRequest, com.google.longrunning.Operation> getCreateMembershipMethod;
    if ((getCreateMembershipMethod = GkeHubGrpc.getCreateMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateMembershipMethod = GkeHubGrpc.getCreateMembershipMethod) == null) {
          GkeHubGrpc.getCreateMembershipMethod = getCreateMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.CreateMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateMembership"))
              .build();
        }
      }
    }
    return getCreateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.CreateFeatureRequest,
      com.google.longrunning.Operation> getCreateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeature",
      requestType = com.google.cloud.gkehub.v1.CreateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.CreateFeatureRequest,
      com.google.longrunning.Operation> getCreateFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.CreateFeatureRequest, com.google.longrunning.Operation> getCreateFeatureMethod;
    if ((getCreateFeatureMethod = GkeHubGrpc.getCreateFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateFeatureMethod = GkeHubGrpc.getCreateFeatureMethod) == null) {
          GkeHubGrpc.getCreateFeatureMethod = getCreateFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.CreateFeatureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.CreateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateFeature"))
              .build();
        }
      }
    }
    return getCreateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.DeleteMembershipRequest,
      com.google.longrunning.Operation> getDeleteMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembership",
      requestType = com.google.cloud.gkehub.v1.DeleteMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.DeleteMembershipRequest,
      com.google.longrunning.Operation> getDeleteMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.DeleteMembershipRequest, com.google.longrunning.Operation> getDeleteMembershipMethod;
    if ((getDeleteMembershipMethod = GkeHubGrpc.getDeleteMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteMembershipMethod = GkeHubGrpc.getDeleteMembershipMethod) == null) {
          GkeHubGrpc.getDeleteMembershipMethod = getDeleteMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.DeleteMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteMembership"))
              .build();
        }
      }
    }
    return getDeleteMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.DeleteFeatureRequest,
      com.google.longrunning.Operation> getDeleteFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeature",
      requestType = com.google.cloud.gkehub.v1.DeleteFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.DeleteFeatureRequest,
      com.google.longrunning.Operation> getDeleteFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.DeleteFeatureRequest, com.google.longrunning.Operation> getDeleteFeatureMethod;
    if ((getDeleteFeatureMethod = GkeHubGrpc.getDeleteFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteFeatureMethod = GkeHubGrpc.getDeleteFeatureMethod) == null) {
          GkeHubGrpc.getDeleteFeatureMethod = getDeleteFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.DeleteFeatureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.DeleteFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteFeature"))
              .build();
        }
      }
    }
    return getDeleteFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.UpdateMembershipRequest,
      com.google.longrunning.Operation> getUpdateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembership",
      requestType = com.google.cloud.gkehub.v1.UpdateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.UpdateMembershipRequest,
      com.google.longrunning.Operation> getUpdateMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.UpdateMembershipRequest, com.google.longrunning.Operation> getUpdateMembershipMethod;
    if ((getUpdateMembershipMethod = GkeHubGrpc.getUpdateMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateMembershipMethod = GkeHubGrpc.getUpdateMembershipMethod) == null) {
          GkeHubGrpc.getUpdateMembershipMethod = getUpdateMembershipMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.UpdateMembershipRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateMembership"))
              .build();
        }
      }
    }
    return getUpdateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.UpdateFeatureRequest,
      com.google.longrunning.Operation> getUpdateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeature",
      requestType = com.google.cloud.gkehub.v1.UpdateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.UpdateFeatureRequest,
      com.google.longrunning.Operation> getUpdateFeatureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.UpdateFeatureRequest, com.google.longrunning.Operation> getUpdateFeatureMethod;
    if ((getUpdateFeatureMethod = GkeHubGrpc.getUpdateFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateFeatureMethod = GkeHubGrpc.getUpdateFeatureMethod) == null) {
          GkeHubGrpc.getUpdateFeatureMethod = getUpdateFeatureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.UpdateFeatureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.UpdateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateFeature"))
              .build();
        }
      }
    }
    return getUpdateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
      com.google.cloud.gkehub.v1.GenerateConnectManifestResponse> getGenerateConnectManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateConnectManifest",
      requestType = com.google.cloud.gkehub.v1.GenerateConnectManifestRequest.class,
      responseType = com.google.cloud.gkehub.v1.GenerateConnectManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
      com.google.cloud.gkehub.v1.GenerateConnectManifestResponse> getGenerateConnectManifestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkehub.v1.GenerateConnectManifestRequest, com.google.cloud.gkehub.v1.GenerateConnectManifestResponse> getGenerateConnectManifestMethod;
    if ((getGenerateConnectManifestMethod = GkeHubGrpc.getGenerateConnectManifestMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGenerateConnectManifestMethod = GkeHubGrpc.getGenerateConnectManifestMethod) == null) {
          GkeHubGrpc.getGenerateConnectManifestMethod = getGenerateConnectManifestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkehub.v1.GenerateConnectManifestRequest, com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateConnectManifest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.GenerateConnectManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkehub.v1.GenerateConnectManifestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GenerateConnectManifest"))
              .build();
        }
      }
    }
    return getGenerateConnectManifestMethod;
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
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
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
    public void listMemberships(com.google.cloud.gkehub.v1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMembershipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public void listFeatures(com.google.cloud.gkehub.v1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFeaturesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeaturesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(com.google.cloud.gkehub.v1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(com.google.cloud.gkehub.v1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Feature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public void createMembership(com.google.cloud.gkehub.v1.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public void createFeature(com.google.cloud.gkehub.v1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public void deleteMembership(com.google.cloud.gkehub.v1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public void deleteFeature(com.google.cloud.gkehub.v1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(com.google.cloud.gkehub.v1.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMembershipMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public void updateFeature(com.google.cloud.gkehub.v1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public void generateConnectManifest(com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.GenerateConnectManifestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateConnectManifestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.ListMembershipsRequest,
                com.google.cloud.gkehub.v1.ListMembershipsResponse>(
                  this, METHODID_LIST_MEMBERSHIPS)))
          .addMethod(
            getListFeaturesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.ListFeaturesRequest,
                com.google.cloud.gkehub.v1.ListFeaturesResponse>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            getGetMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.GetMembershipRequest,
                com.google.cloud.gkehub.v1.Membership>(
                  this, METHODID_GET_MEMBERSHIP)))
          .addMethod(
            getGetFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.GetFeatureRequest,
                com.google.cloud.gkehub.v1.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            getCreateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.CreateMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_MEMBERSHIP)))
          .addMethod(
            getCreateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.CreateFeatureRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_FEATURE)))
          .addMethod(
            getDeleteMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.DeleteMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_MEMBERSHIP)))
          .addMethod(
            getDeleteFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.DeleteFeatureRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_FEATURE)))
          .addMethod(
            getUpdateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.UpdateMembershipRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_MEMBERSHIP)))
          .addMethod(
            getUpdateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.UpdateFeatureRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_FEATURE)))
          .addMethod(
            getGenerateConnectManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
                com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>(
                  this, METHODID_GENERATE_CONNECT_MANIFEST)))
          .build();
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
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
    public void listMemberships(com.google.cloud.gkehub.v1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public void listFeatures(com.google.cloud.gkehub.v1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFeaturesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(com.google.cloud.gkehub.v1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(com.google.cloud.gkehub.v1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Feature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public void createMembership(com.google.cloud.gkehub.v1.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public void createFeature(com.google.cloud.gkehub.v1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public void deleteMembership(com.google.cloud.gkehub.v1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public void deleteFeature(com.google.cloud.gkehub.v1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(com.google.cloud.gkehub.v1.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public void updateFeature(com.google.cloud.gkehub.v1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public void generateConnectManifest(com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.GenerateConnectManifestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
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
    public com.google.cloud.gkehub.v1.ListMembershipsResponse listMemberships(com.google.cloud.gkehub.v1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListFeaturesResponse listFeatures(com.google.cloud.gkehub.v1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Membership getMembership(com.google.cloud.gkehub.v1.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Feature getFeature(com.google.cloud.gkehub.v1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation createMembership(com.google.cloud.gkehub.v1.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.longrunning.Operation createFeature(com.google.cloud.gkehub.v1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembership(com.google.cloud.gkehub.v1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeature(com.google.cloud.gkehub.v1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembership(com.google.cloud.gkehub.v1.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMembershipMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeature(com.google.cloud.gkehub.v1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.GenerateConnectManifestResponse generateConnectManifest(com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateConnectManifestMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.ListMembershipsResponse> listMemberships(
        com.google.cloud.gkehub.v1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.ListFeaturesResponse> listFeatures(
        com.google.cloud.gkehub.v1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Membership> getMembership(
        com.google.cloud.gkehub.v1.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Feature> getFeature(
        com.google.cloud.gkehub.v1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
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
        com.google.cloud.gkehub.v1.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFeature(
        com.google.cloud.gkehub.v1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request);
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
        com.google.cloud.gkehub.v1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteFeature(
        com.google.cloud.gkehub.v1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateMembership(
        com.google.cloud.gkehub.v1.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFeature(
        com.google.cloud.gkehub.v1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.GenerateConnectManifestResponse> generateConnectManifest(
        com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MEMBERSHIPS = 0;
  private static final int METHODID_LIST_FEATURES = 1;
  private static final int METHODID_GET_MEMBERSHIP = 2;
  private static final int METHODID_GET_FEATURE = 3;
  private static final int METHODID_CREATE_MEMBERSHIP = 4;
  private static final int METHODID_CREATE_FEATURE = 5;
  private static final int METHODID_DELETE_MEMBERSHIP = 6;
  private static final int METHODID_DELETE_FEATURE = 7;
  private static final int METHODID_UPDATE_MEMBERSHIP = 8;
  private static final int METHODID_UPDATE_FEATURE = 9;
  private static final int METHODID_GENERATE_CONNECT_MANIFEST = 10;

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
          serviceImpl.listMemberships((com.google.cloud.gkehub.v1.ListMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipsResponse>) responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((com.google.cloud.gkehub.v1.ListFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFeaturesResponse>) responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP:
          serviceImpl.getMembership((com.google.cloud.gkehub.v1.GetMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Membership>) responseObserver);
          break;
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((com.google.cloud.gkehub.v1.GetFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Feature>) responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP:
          serviceImpl.createMembership((com.google.cloud.gkehub.v1.CreateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_FEATURE:
          serviceImpl.createFeature((com.google.cloud.gkehub.v1.CreateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP:
          serviceImpl.deleteMembership((com.google.cloud.gkehub.v1.DeleteMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE:
          serviceImpl.deleteFeature((com.google.cloud.gkehub.v1.DeleteFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP:
          serviceImpl.updateMembership((com.google.cloud.gkehub.v1.UpdateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FEATURE:
          serviceImpl.updateFeature((com.google.cloud.gkehub.v1.UpdateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_CONNECT_MANIFEST:
          serviceImpl.generateConnectManifest((com.google.cloud.gkehub.v1.GenerateConnectManifestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>) responseObserver);
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
      return com.google.cloud.gkehub.v1.ServiceProto.getDescriptor();
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
              .addMethod(getListFeaturesMethod())
              .addMethod(getGetMembershipMethod())
              .addMethod(getGetFeatureMethod())
              .addMethod(getCreateMembershipMethod())
              .addMethod(getCreateFeatureMethod())
              .addMethod(getDeleteMembershipMethod())
              .addMethod(getDeleteFeatureMethod())
              .addMethod(getUpdateMembershipMethod())
              .addMethod(getUpdateFeatureMethod())
              .addMethod(getGenerateConnectManifestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
