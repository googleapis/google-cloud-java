package com.google.cloud.vmwareengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * VMwareEngine manages VMware's private clusters in the Cloud.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/vmwareengine/v1/vmwareengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VmwareEngineGrpc {

  private VmwareEngineGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.vmwareengine.v1.VmwareEngine";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
      com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse> getListPrivateCloudsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateClouds",
      requestType = com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
      com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse> getListPrivateCloudsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest, com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse> getListPrivateCloudsMethod;
    if ((getListPrivateCloudsMethod = VmwareEngineGrpc.getListPrivateCloudsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListPrivateCloudsMethod = VmwareEngineGrpc.getListPrivateCloudsMethod) == null) {
          VmwareEngineGrpc.getListPrivateCloudsMethod = getListPrivateCloudsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest, com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPrivateClouds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListPrivateClouds"))
              .build();
        }
      }
    }
    return getListPrivateCloudsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
      com.google.cloud.vmwareengine.v1.PrivateCloud> getGetPrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.PrivateCloud.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
      com.google.cloud.vmwareengine.v1.PrivateCloud> getGetPrivateCloudMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest, com.google.cloud.vmwareengine.v1.PrivateCloud> getGetPrivateCloudMethod;
    if ((getGetPrivateCloudMethod = VmwareEngineGrpc.getGetPrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetPrivateCloudMethod = VmwareEngineGrpc.getGetPrivateCloudMethod) == null) {
          VmwareEngineGrpc.getGetPrivateCloudMethod = getGetPrivateCloudMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest, com.google.cloud.vmwareengine.v1.PrivateCloud>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPrivateCloud"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.PrivateCloud.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetPrivateCloud"))
              .build();
        }
      }
    }
    return getGetPrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
      com.google.longrunning.Operation> getCreatePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
      com.google.longrunning.Operation> getCreatePrivateCloudMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest, com.google.longrunning.Operation> getCreatePrivateCloudMethod;
    if ((getCreatePrivateCloudMethod = VmwareEngineGrpc.getCreatePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreatePrivateCloudMethod = VmwareEngineGrpc.getCreatePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getCreatePrivateCloudMethod = getCreatePrivateCloudMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePrivateCloud"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("CreatePrivateCloud"))
              .build();
        }
      }
    }
    return getCreatePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
      com.google.longrunning.Operation> getUpdatePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
      com.google.longrunning.Operation> getUpdatePrivateCloudMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest, com.google.longrunning.Operation> getUpdatePrivateCloudMethod;
    if ((getUpdatePrivateCloudMethod = VmwareEngineGrpc.getUpdatePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdatePrivateCloudMethod = VmwareEngineGrpc.getUpdatePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getUpdatePrivateCloudMethod = getUpdatePrivateCloudMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePrivateCloud"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("UpdatePrivateCloud"))
              .build();
        }
      }
    }
    return getUpdatePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
      com.google.longrunning.Operation> getDeletePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
      com.google.longrunning.Operation> getDeletePrivateCloudMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest, com.google.longrunning.Operation> getDeletePrivateCloudMethod;
    if ((getDeletePrivateCloudMethod = VmwareEngineGrpc.getDeletePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeletePrivateCloudMethod = VmwareEngineGrpc.getDeletePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getDeletePrivateCloudMethod = getDeletePrivateCloudMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePrivateCloud"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("DeletePrivateCloud"))
              .build();
        }
      }
    }
    return getDeletePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
      com.google.longrunning.Operation> getUndeletePrivateCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeletePrivateCloud",
      requestType = com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
      com.google.longrunning.Operation> getUndeletePrivateCloudMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest, com.google.longrunning.Operation> getUndeletePrivateCloudMethod;
    if ((getUndeletePrivateCloudMethod = VmwareEngineGrpc.getUndeletePrivateCloudMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUndeletePrivateCloudMethod = VmwareEngineGrpc.getUndeletePrivateCloudMethod) == null) {
          VmwareEngineGrpc.getUndeletePrivateCloudMethod = getUndeletePrivateCloudMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeletePrivateCloud"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("UndeletePrivateCloud"))
              .build();
        }
      }
    }
    return getUndeletePrivateCloudMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListClustersRequest,
      com.google.cloud.vmwareengine.v1.ListClustersResponse> getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.vmwareengine.v1.ListClustersRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListClustersRequest,
      com.google.cloud.vmwareengine.v1.ListClustersResponse> getListClustersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListClustersRequest, com.google.cloud.vmwareengine.v1.ListClustersResponse> getListClustersMethod;
    if ((getListClustersMethod = VmwareEngineGrpc.getListClustersMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListClustersMethod = VmwareEngineGrpc.getListClustersMethod) == null) {
          VmwareEngineGrpc.getListClustersMethod = getListClustersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListClustersRequest, com.google.cloud.vmwareengine.v1.ListClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListClustersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListClusters"))
              .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetClusterRequest,
      com.google.cloud.vmwareengine.v1.Cluster> getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.vmwareengine.v1.GetClusterRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetClusterRequest,
      com.google.cloud.vmwareengine.v1.Cluster> getGetClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetClusterRequest, com.google.cloud.vmwareengine.v1.Cluster> getGetClusterMethod;
    if ((getGetClusterMethod = VmwareEngineGrpc.getGetClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetClusterMethod = VmwareEngineGrpc.getGetClusterMethod) == null) {
          VmwareEngineGrpc.getGetClusterMethod = getGetClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.GetClusterRequest, com.google.cloud.vmwareengine.v1.Cluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.GetClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.Cluster.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetCluster"))
              .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.vmwareengine.v1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateClusterRequest, com.google.longrunning.Operation> getCreateClusterMethod;
    if ((getCreateClusterMethod = VmwareEngineGrpc.getCreateClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateClusterMethod = VmwareEngineGrpc.getCreateClusterMethod) == null) {
          VmwareEngineGrpc.getCreateClusterMethod = getCreateClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.CreateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("CreateCluster"))
              .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.vmwareengine.v1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateClusterRequest, com.google.longrunning.Operation> getUpdateClusterMethod;
    if ((getUpdateClusterMethod = VmwareEngineGrpc.getUpdateClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateClusterMethod = VmwareEngineGrpc.getUpdateClusterMethod) == null) {
          VmwareEngineGrpc.getUpdateClusterMethod = getUpdateClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.UpdateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("UpdateCluster"))
              .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.vmwareengine.v1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteClusterRequest, com.google.longrunning.Operation> getDeleteClusterMethod;
    if ((getDeleteClusterMethod = VmwareEngineGrpc.getDeleteClusterMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteClusterMethod = VmwareEngineGrpc.getDeleteClusterMethod) == null) {
          VmwareEngineGrpc.getDeleteClusterMethod = getDeleteClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.DeleteClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("DeleteCluster"))
              .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
      com.google.cloud.vmwareengine.v1.ListSubnetsResponse> getListSubnetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubnets",
      requestType = com.google.cloud.vmwareengine.v1.ListSubnetsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListSubnetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
      com.google.cloud.vmwareengine.v1.ListSubnetsResponse> getListSubnetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListSubnetsRequest, com.google.cloud.vmwareengine.v1.ListSubnetsResponse> getListSubnetsMethod;
    if ((getListSubnetsMethod = VmwareEngineGrpc.getListSubnetsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListSubnetsMethod = VmwareEngineGrpc.getListSubnetsMethod) == null) {
          VmwareEngineGrpc.getListSubnetsMethod = getListSubnetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListSubnetsRequest, com.google.cloud.vmwareengine.v1.ListSubnetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubnets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListSubnetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListSubnetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListSubnets"))
              .build();
        }
      }
    }
    return getListSubnetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
      com.google.cloud.vmwareengine.v1.ListNodeTypesResponse> getListNodeTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodeTypes",
      requestType = com.google.cloud.vmwareengine.v1.ListNodeTypesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListNodeTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
      com.google.cloud.vmwareengine.v1.ListNodeTypesResponse> getListNodeTypesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListNodeTypesRequest, com.google.cloud.vmwareengine.v1.ListNodeTypesResponse> getListNodeTypesMethod;
    if ((getListNodeTypesMethod = VmwareEngineGrpc.getListNodeTypesMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListNodeTypesMethod = VmwareEngineGrpc.getListNodeTypesMethod) == null) {
          VmwareEngineGrpc.getListNodeTypesMethod = getListNodeTypesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListNodeTypesRequest, com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodeTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListNodeTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListNodeTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListNodeTypes"))
              .build();
        }
      }
    }
    return getListNodeTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
      com.google.cloud.vmwareengine.v1.NodeType> getGetNodeTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeType",
      requestType = com.google.cloud.vmwareengine.v1.GetNodeTypeRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.NodeType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
      com.google.cloud.vmwareengine.v1.NodeType> getGetNodeTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetNodeTypeRequest, com.google.cloud.vmwareengine.v1.NodeType> getGetNodeTypeMethod;
    if ((getGetNodeTypeMethod = VmwareEngineGrpc.getGetNodeTypeMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetNodeTypeMethod = VmwareEngineGrpc.getGetNodeTypeMethod) == null) {
          VmwareEngineGrpc.getGetNodeTypeMethod = getGetNodeTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.GetNodeTypeRequest, com.google.cloud.vmwareengine.v1.NodeType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.GetNodeTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.NodeType.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetNodeType"))
              .build();
        }
      }
    }
    return getGetNodeTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
      com.google.cloud.vmwareengine.v1.Credentials> getShowNsxCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowNsxCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Credentials.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
      com.google.cloud.vmwareengine.v1.Credentials> getShowNsxCredentialsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest, com.google.cloud.vmwareengine.v1.Credentials> getShowNsxCredentialsMethod;
    if ((getShowNsxCredentialsMethod = VmwareEngineGrpc.getShowNsxCredentialsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getShowNsxCredentialsMethod = VmwareEngineGrpc.getShowNsxCredentialsMethod) == null) {
          VmwareEngineGrpc.getShowNsxCredentialsMethod = getShowNsxCredentialsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest, com.google.cloud.vmwareengine.v1.Credentials>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ShowNsxCredentials"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.Credentials.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ShowNsxCredentials"))
              .build();
        }
      }
    }
    return getShowNsxCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
      com.google.cloud.vmwareengine.v1.Credentials> getShowVcenterCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShowVcenterCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.Credentials.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
      com.google.cloud.vmwareengine.v1.Credentials> getShowVcenterCredentialsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest, com.google.cloud.vmwareengine.v1.Credentials> getShowVcenterCredentialsMethod;
    if ((getShowVcenterCredentialsMethod = VmwareEngineGrpc.getShowVcenterCredentialsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getShowVcenterCredentialsMethod = VmwareEngineGrpc.getShowVcenterCredentialsMethod) == null) {
          VmwareEngineGrpc.getShowVcenterCredentialsMethod = getShowVcenterCredentialsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest, com.google.cloud.vmwareengine.v1.Credentials>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ShowVcenterCredentials"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.Credentials.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ShowVcenterCredentials"))
              .build();
        }
      }
    }
    return getShowVcenterCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
      com.google.longrunning.Operation> getResetNsxCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetNsxCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
      com.google.longrunning.Operation> getResetNsxCredentialsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest, com.google.longrunning.Operation> getResetNsxCredentialsMethod;
    if ((getResetNsxCredentialsMethod = VmwareEngineGrpc.getResetNsxCredentialsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getResetNsxCredentialsMethod = VmwareEngineGrpc.getResetNsxCredentialsMethod) == null) {
          VmwareEngineGrpc.getResetNsxCredentialsMethod = getResetNsxCredentialsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetNsxCredentials"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ResetNsxCredentials"))
              .build();
        }
      }
    }
    return getResetNsxCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
      com.google.longrunning.Operation> getResetVcenterCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetVcenterCredentials",
      requestType = com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
      com.google.longrunning.Operation> getResetVcenterCredentialsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest, com.google.longrunning.Operation> getResetVcenterCredentialsMethod;
    if ((getResetVcenterCredentialsMethod = VmwareEngineGrpc.getResetVcenterCredentialsMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getResetVcenterCredentialsMethod = VmwareEngineGrpc.getResetVcenterCredentialsMethod) == null) {
          VmwareEngineGrpc.getResetVcenterCredentialsMethod = getResetVcenterCredentialsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetVcenterCredentials"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ResetVcenterCredentials"))
              .build();
        }
      }
    }
    return getResetVcenterCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
      com.google.longrunning.Operation> getCreateHcxActivationKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHcxActivationKey",
      requestType = com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
      com.google.longrunning.Operation> getCreateHcxActivationKeyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest, com.google.longrunning.Operation> getCreateHcxActivationKeyMethod;
    if ((getCreateHcxActivationKeyMethod = VmwareEngineGrpc.getCreateHcxActivationKeyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateHcxActivationKeyMethod = VmwareEngineGrpc.getCreateHcxActivationKeyMethod) == null) {
          VmwareEngineGrpc.getCreateHcxActivationKeyMethod = getCreateHcxActivationKeyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHcxActivationKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("CreateHcxActivationKey"))
              .build();
        }
      }
    }
    return getCreateHcxActivationKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
      com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse> getListHcxActivationKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHcxActivationKeys",
      requestType = com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
      com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse> getListHcxActivationKeysMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest, com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse> getListHcxActivationKeysMethod;
    if ((getListHcxActivationKeysMethod = VmwareEngineGrpc.getListHcxActivationKeysMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListHcxActivationKeysMethod = VmwareEngineGrpc.getListHcxActivationKeysMethod) == null) {
          VmwareEngineGrpc.getListHcxActivationKeysMethod = getListHcxActivationKeysMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest, com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHcxActivationKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListHcxActivationKeys"))
              .build();
        }
      }
    }
    return getListHcxActivationKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
      com.google.cloud.vmwareengine.v1.HcxActivationKey> getGetHcxActivationKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHcxActivationKey",
      requestType = com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.HcxActivationKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
      com.google.cloud.vmwareengine.v1.HcxActivationKey> getGetHcxActivationKeyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest, com.google.cloud.vmwareengine.v1.HcxActivationKey> getGetHcxActivationKeyMethod;
    if ((getGetHcxActivationKeyMethod = VmwareEngineGrpc.getGetHcxActivationKeyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetHcxActivationKeyMethod = VmwareEngineGrpc.getGetHcxActivationKeyMethod) == null) {
          VmwareEngineGrpc.getGetHcxActivationKeyMethod = getGetHcxActivationKeyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest, com.google.cloud.vmwareengine.v1.HcxActivationKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHcxActivationKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.HcxActivationKey.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetHcxActivationKey"))
              .build();
        }
      }
    }
    return getGetHcxActivationKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
      com.google.cloud.vmwareengine.v1.NetworkPolicy> getGetNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.NetworkPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
      com.google.cloud.vmwareengine.v1.NetworkPolicy> getGetNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest, com.google.cloud.vmwareengine.v1.NetworkPolicy> getGetNetworkPolicyMethod;
    if ((getGetNetworkPolicyMethod = VmwareEngineGrpc.getGetNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetNetworkPolicyMethod = VmwareEngineGrpc.getGetNetworkPolicyMethod) == null) {
          VmwareEngineGrpc.getGetNetworkPolicyMethod = getGetNetworkPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest, com.google.cloud.vmwareengine.v1.NetworkPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNetworkPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.NetworkPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetNetworkPolicy"))
              .build();
        }
      }
    }
    return getGetNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
      com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse> getListNetworkPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNetworkPolicies",
      requestType = com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
      com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse> getListNetworkPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest, com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse> getListNetworkPoliciesMethod;
    if ((getListNetworkPoliciesMethod = VmwareEngineGrpc.getListNetworkPoliciesMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListNetworkPoliciesMethod = VmwareEngineGrpc.getListNetworkPoliciesMethod) == null) {
          VmwareEngineGrpc.getListNetworkPoliciesMethod = getListNetworkPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest, com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNetworkPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListNetworkPolicies"))
              .build();
        }
      }
    }
    return getListNetworkPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
      com.google.longrunning.Operation> getCreateNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
      com.google.longrunning.Operation> getCreateNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest, com.google.longrunning.Operation> getCreateNetworkPolicyMethod;
    if ((getCreateNetworkPolicyMethod = VmwareEngineGrpc.getCreateNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateNetworkPolicyMethod = VmwareEngineGrpc.getCreateNetworkPolicyMethod) == null) {
          VmwareEngineGrpc.getCreateNetworkPolicyMethod = getCreateNetworkPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNetworkPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("CreateNetworkPolicy"))
              .build();
        }
      }
    }
    return getCreateNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
      com.google.longrunning.Operation> getUpdateNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
      com.google.longrunning.Operation> getUpdateNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest, com.google.longrunning.Operation> getUpdateNetworkPolicyMethod;
    if ((getUpdateNetworkPolicyMethod = VmwareEngineGrpc.getUpdateNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateNetworkPolicyMethod = VmwareEngineGrpc.getUpdateNetworkPolicyMethod) == null) {
          VmwareEngineGrpc.getUpdateNetworkPolicyMethod = getUpdateNetworkPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNetworkPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("UpdateNetworkPolicy"))
              .build();
        }
      }
    }
    return getUpdateNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
      com.google.longrunning.Operation> getDeleteNetworkPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNetworkPolicy",
      requestType = com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
      com.google.longrunning.Operation> getDeleteNetworkPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest, com.google.longrunning.Operation> getDeleteNetworkPolicyMethod;
    if ((getDeleteNetworkPolicyMethod = VmwareEngineGrpc.getDeleteNetworkPolicyMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteNetworkPolicyMethod = VmwareEngineGrpc.getDeleteNetworkPolicyMethod) == null) {
          VmwareEngineGrpc.getDeleteNetworkPolicyMethod = getDeleteNetworkPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNetworkPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("DeleteNetworkPolicy"))
              .build();
        }
      }
    }
    return getDeleteNetworkPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
      com.google.longrunning.Operation> getCreateVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
      com.google.longrunning.Operation> getCreateVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest, com.google.longrunning.Operation> getCreateVmwareEngineNetworkMethod;
    if ((getCreateVmwareEngineNetworkMethod = VmwareEngineGrpc.getCreateVmwareEngineNetworkMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getCreateVmwareEngineNetworkMethod = VmwareEngineGrpc.getCreateVmwareEngineNetworkMethod) == null) {
          VmwareEngineGrpc.getCreateVmwareEngineNetworkMethod = getCreateVmwareEngineNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVmwareEngineNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("CreateVmwareEngineNetwork"))
              .build();
        }
      }
    }
    return getCreateVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
      com.google.longrunning.Operation> getUpdateVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
      com.google.longrunning.Operation> getUpdateVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest, com.google.longrunning.Operation> getUpdateVmwareEngineNetworkMethod;
    if ((getUpdateVmwareEngineNetworkMethod = VmwareEngineGrpc.getUpdateVmwareEngineNetworkMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getUpdateVmwareEngineNetworkMethod = VmwareEngineGrpc.getUpdateVmwareEngineNetworkMethod) == null) {
          VmwareEngineGrpc.getUpdateVmwareEngineNetworkMethod = getUpdateVmwareEngineNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVmwareEngineNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("UpdateVmwareEngineNetwork"))
              .build();
        }
      }
    }
    return getUpdateVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
      com.google.longrunning.Operation> getDeleteVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
      com.google.longrunning.Operation> getDeleteVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest, com.google.longrunning.Operation> getDeleteVmwareEngineNetworkMethod;
    if ((getDeleteVmwareEngineNetworkMethod = VmwareEngineGrpc.getDeleteVmwareEngineNetworkMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getDeleteVmwareEngineNetworkMethod = VmwareEngineGrpc.getDeleteVmwareEngineNetworkMethod) == null) {
          VmwareEngineGrpc.getDeleteVmwareEngineNetworkMethod = getDeleteVmwareEngineNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVmwareEngineNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("DeleteVmwareEngineNetwork"))
              .build();
        }
      }
    }
    return getDeleteVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
      com.google.cloud.vmwareengine.v1.VmwareEngineNetwork> getGetVmwareEngineNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVmwareEngineNetwork",
      requestType = com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.VmwareEngineNetwork.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
      com.google.cloud.vmwareengine.v1.VmwareEngineNetwork> getGetVmwareEngineNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest, com.google.cloud.vmwareengine.v1.VmwareEngineNetwork> getGetVmwareEngineNetworkMethod;
    if ((getGetVmwareEngineNetworkMethod = VmwareEngineGrpc.getGetVmwareEngineNetworkMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getGetVmwareEngineNetworkMethod = VmwareEngineGrpc.getGetVmwareEngineNetworkMethod) == null) {
          VmwareEngineGrpc.getGetVmwareEngineNetworkMethod = getGetVmwareEngineNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest, com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVmwareEngineNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.VmwareEngineNetwork.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("GetVmwareEngineNetwork"))
              .build();
        }
      }
    }
    return getGetVmwareEngineNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
      com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse> getListVmwareEngineNetworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVmwareEngineNetworks",
      requestType = com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest.class,
      responseType = com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
      com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse> getListVmwareEngineNetworksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest, com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse> getListVmwareEngineNetworksMethod;
    if ((getListVmwareEngineNetworksMethod = VmwareEngineGrpc.getListVmwareEngineNetworksMethod) == null) {
      synchronized (VmwareEngineGrpc.class) {
        if ((getListVmwareEngineNetworksMethod = VmwareEngineGrpc.getListVmwareEngineNetworksMethod) == null) {
          VmwareEngineGrpc.getListVmwareEngineNetworksMethod = getListVmwareEngineNetworksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest, com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVmwareEngineNetworks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VmwareEngineMethodDescriptorSupplier("ListVmwareEngineNetworks"))
              .build();
        }
      }
    }
    return getListVmwareEngineNetworksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VmwareEngineStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmwareEngineStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VmwareEngineStub>() {
        @java.lang.Override
        public VmwareEngineStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VmwareEngineStub(channel, callOptions);
        }
      };
    return VmwareEngineStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VmwareEngineBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmwareEngineBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VmwareEngineBlockingStub>() {
        @java.lang.Override
        public VmwareEngineBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VmwareEngineBlockingStub(channel, callOptions);
        }
      };
    return VmwareEngineBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VmwareEngineFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VmwareEngineFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VmwareEngineFutureStub>() {
        @java.lang.Override
        public VmwareEngineFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VmwareEngineFutureStub(channel, callOptions);
        }
      };
    return VmwareEngineFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static abstract class VmwareEngineImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public void listPrivateClouds(com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPrivateCloudsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public void getPrivateCloud(com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateCloud> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPrivateCloudMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds can only be created in zones, regional private clouds are
     * not supported.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public void createPrivateCloud(com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePrivateCloudMethod(), responseObserver);
    }

    /**
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updatePrivateCloud(com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePrivateCloudMethod(), responseObserver);
    }

    /**
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public void deletePrivateCloud(com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePrivateCloudMethod(), responseObserver);
    }

    /**
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public void undeletePrivateCloud(com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeletePrivateCloudMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public void listClusters(com.google.cloud.vmwareengine.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListClustersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListClustersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public void getCluster(com.google.cloud.vmwareengine.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public void createCluster(com.google.cloud.vmwareengine.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Modifies a `Cluster` resource. Only the following fields can be updated:
     * `node_type_configs.*.node_count`. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateCluster(com.google.cloud.vmwareengine.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public void deleteCluster(com.google.cloud.vmwareengine.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public void listSubnets(com.google.cloud.vmwareengine.v1.ListSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListSubnetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSubnetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists node types
     * </pre>
     */
    public void listNodeTypes(com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNodeTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public void getNodeType(com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NodeType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public void showNsxCredentials(com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowNsxCredentialsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public void showVcenterCredentials(com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowVcenterCredentialsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public void resetNsxCredentials(com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetNsxCredentialsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public void resetVcenterCredentials(com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetVcenterCredentialsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public void createHcxActivationKey(com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHcxActivationKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public void listHcxActivationKeys(com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListHcxActivationKeysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public void getHcxActivationKey(com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.HcxActivationKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHcxActivationKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public void getNetworkPolicy(com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNetworkPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public void listNetworkPolicies(com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNetworkPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public void createNetworkPolicy(com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNetworkPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateNetworkPolicy(com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNetworkPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public void deleteNetworkPolicy(com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNetworkPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public void createVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public void updateVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public void deleteVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public void getVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVmwareEngineNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public void listVmwareEngineNetworks(com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVmwareEngineNetworksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListPrivateCloudsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest,
                com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>(
                  this, METHODID_LIST_PRIVATE_CLOUDS)))
          .addMethod(
            getGetPrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest,
                com.google.cloud.vmwareengine.v1.PrivateCloud>(
                  this, METHODID_GET_PRIVATE_CLOUD)))
          .addMethod(
            getCreatePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_PRIVATE_CLOUD)))
          .addMethod(
            getUpdatePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_PRIVATE_CLOUD)))
          .addMethod(
            getDeletePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_PRIVATE_CLOUD)))
          .addMethod(
            getUndeletePrivateCloudMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UNDELETE_PRIVATE_CLOUD)))
          .addMethod(
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListClustersRequest,
                com.google.cloud.vmwareengine.v1.ListClustersResponse>(
                  this, METHODID_LIST_CLUSTERS)))
          .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.GetClusterRequest,
                com.google.cloud.vmwareengine.v1.Cluster>(
                  this, METHODID_GET_CLUSTER)))
          .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.CreateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLUSTER)))
          .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.UpdateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.DeleteClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CLUSTER)))
          .addMethod(
            getListSubnetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListSubnetsRequest,
                com.google.cloud.vmwareengine.v1.ListSubnetsResponse>(
                  this, METHODID_LIST_SUBNETS)))
          .addMethod(
            getListNodeTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListNodeTypesRequest,
                com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>(
                  this, METHODID_LIST_NODE_TYPES)))
          .addMethod(
            getGetNodeTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.GetNodeTypeRequest,
                com.google.cloud.vmwareengine.v1.NodeType>(
                  this, METHODID_GET_NODE_TYPE)))
          .addMethod(
            getShowNsxCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest,
                com.google.cloud.vmwareengine.v1.Credentials>(
                  this, METHODID_SHOW_NSX_CREDENTIALS)))
          .addMethod(
            getShowVcenterCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest,
                com.google.cloud.vmwareengine.v1.Credentials>(
                  this, METHODID_SHOW_VCENTER_CREDENTIALS)))
          .addMethod(
            getResetNsxCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RESET_NSX_CREDENTIALS)))
          .addMethod(
            getResetVcenterCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RESET_VCENTER_CREDENTIALS)))
          .addMethod(
            getCreateHcxActivationKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_HCX_ACTIVATION_KEY)))
          .addMethod(
            getListHcxActivationKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest,
                com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>(
                  this, METHODID_LIST_HCX_ACTIVATION_KEYS)))
          .addMethod(
            getGetHcxActivationKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest,
                com.google.cloud.vmwareengine.v1.HcxActivationKey>(
                  this, METHODID_GET_HCX_ACTIVATION_KEY)))
          .addMethod(
            getGetNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest,
                com.google.cloud.vmwareengine.v1.NetworkPolicy>(
                  this, METHODID_GET_NETWORK_POLICY)))
          .addMethod(
            getListNetworkPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest,
                com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>(
                  this, METHODID_LIST_NETWORK_POLICIES)))
          .addMethod(
            getCreateNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_NETWORK_POLICY)))
          .addMethod(
            getUpdateNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_NETWORK_POLICY)))
          .addMethod(
            getDeleteNetworkPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_NETWORK_POLICY)))
          .addMethod(
            getCreateVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_VMWARE_ENGINE_NETWORK)))
          .addMethod(
            getUpdateVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_VMWARE_ENGINE_NETWORK)))
          .addMethod(
            getDeleteVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_VMWARE_ENGINE_NETWORK)))
          .addMethod(
            getGetVmwareEngineNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest,
                com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>(
                  this, METHODID_GET_VMWARE_ENGINE_NETWORK)))
          .addMethod(
            getListVmwareEngineNetworksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest,
                com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>(
                  this, METHODID_LIST_VMWARE_ENGINE_NETWORKS)))
          .build();
    }
  }

  /**
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static final class VmwareEngineStub extends io.grpc.stub.AbstractAsyncStub<VmwareEngineStub> {
    private VmwareEngineStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmwareEngineStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmwareEngineStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public void listPrivateClouds(com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateCloudsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public void getPrivateCloud(com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateCloud> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateCloudMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds can only be created in zones, regional private clouds are
     * not supported.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public void createPrivateCloud(com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateCloudMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updatePrivateCloud(com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePrivateCloudMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public void deletePrivateCloud(com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateCloudMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public void undeletePrivateCloud(com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeletePrivateCloudMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public void listClusters(com.google.cloud.vmwareengine.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListClustersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public void getCluster(com.google.cloud.vmwareengine.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public void createCluster(com.google.cloud.vmwareengine.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Modifies a `Cluster` resource. Only the following fields can be updated:
     * `node_type_configs.*.node_count`. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateCluster(com.google.cloud.vmwareengine.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public void deleteCluster(com.google.cloud.vmwareengine.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public void listSubnets(com.google.cloud.vmwareengine.v1.ListSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListSubnetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubnetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists node types
     * </pre>
     */
    public void listNodeTypes(com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodeTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public void getNodeType(com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NodeType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public void showNsxCredentials(com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowNsxCredentialsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public void showVcenterCredentials(com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowVcenterCredentialsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public void resetNsxCredentials(com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetNsxCredentialsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public void resetVcenterCredentials(com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetVcenterCredentialsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public void createHcxActivationKey(com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHcxActivationKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public void listHcxActivationKeys(com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHcxActivationKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public void getHcxActivationKey(com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.HcxActivationKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHcxActivationKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public void getNetworkPolicy(com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNetworkPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public void listNetworkPolicies(com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNetworkPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public void createNetworkPolicy(com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNetworkPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public void updateNetworkPolicy(com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNetworkPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public void deleteNetworkPolicy(com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNetworkPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public void createVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVmwareEngineNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public void updateVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVmwareEngineNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public void deleteVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVmwareEngineNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public void getVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVmwareEngineNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public void listVmwareEngineNetworks(com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVmwareEngineNetworksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static final class VmwareEngineBlockingStub extends io.grpc.stub.AbstractBlockingStub<VmwareEngineBlockingStub> {
    private VmwareEngineBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmwareEngineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmwareEngineBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse listPrivateClouds(com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateCloudsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.PrivateCloud getPrivateCloud(com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds can only be created in zones, regional private clouds are
     * not supported.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createPrivateCloud(com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updatePrivateCloud(com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrivateCloud(com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public com.google.longrunning.Operation undeletePrivateCloud(com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeletePrivateCloudMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListClustersResponse listClusters(com.google.cloud.vmwareengine.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Cluster getCluster(com.google.cloud.vmwareengine.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(com.google.cloud.vmwareengine.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Modifies a `Cluster` resource. Only the following fields can be updated:
     * `node_type_configs.*.node_count`. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(com.google.cloud.vmwareengine.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(com.google.cloud.vmwareengine.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListSubnetsResponse listSubnets(com.google.cloud.vmwareengine.v1.ListSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubnetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists node types
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListNodeTypesResponse listNodeTypes(com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodeTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.NodeType getNodeType(com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Credentials showNsxCredentials(com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowNsxCredentialsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.Credentials showVcenterCredentials(com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowVcenterCredentialsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public com.google.longrunning.Operation resetNsxCredentials(com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetNsxCredentialsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public com.google.longrunning.Operation resetVcenterCredentials(com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetVcenterCredentialsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createHcxActivationKey(com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHcxActivationKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse listHcxActivationKeys(com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHcxActivationKeysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.HcxActivationKey getHcxActivationKey(com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHcxActivationKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.NetworkPolicy getNetworkPolicy(com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse listNetworkPolicies(com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNetworkPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public com.google.longrunning.Operation createNetworkPolicy(com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.longrunning.Operation updateNetworkPolicy(com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNetworkPolicy(com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNetworkPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public com.google.longrunning.Operation createVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public com.google.longrunning.Operation updateVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.VmwareEngineNetwork getVmwareEngineNetwork(com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVmwareEngineNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse listVmwareEngineNetworks(com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVmwareEngineNetworksMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * VMwareEngine manages VMware's private clusters in the Cloud.
   * </pre>
   */
  public static final class VmwareEngineFutureStub extends io.grpc.stub.AbstractFutureStub<VmwareEngineFutureStub> {
    private VmwareEngineFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VmwareEngineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VmwareEngineFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists `PrivateCloud` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse> listPrivateClouds(
        com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateCloudsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a `PrivateCloud` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.PrivateCloud> getPrivateCloud(
        com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new `PrivateCloud` resource in a given project and location.
     * Private clouds can only be created in zones, regional private clouds are
     * not supported.
     * Creating a private cloud also creates a [management
     * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components)
     * for that private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createPrivateCloud(
        com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Modifies a `PrivateCloud` resource. Only the following fields can be
     * updated: `description`.
     * Only fields specified in `updateMask` are applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updatePrivateCloud(
        com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Schedules a `PrivateCloud` resource for deletion.
     * A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state`
     * set to `DELETED` and `expireTime` set to the time when deletion is final
     * and can no longer be reversed. The delete operation is marked as done
     * as soon as the `PrivateCloud` is successfully scheduled for deletion
     * (this also applies when `delayHours` is set to zero), and the operation is
     * not kept in pending state until `PrivateCloud` is purged.
     * `PrivateCloud` can be restored using `UndeletePrivateCloud` method before
     * the `expireTime` elapses. When `expireTime` is reached, deletion is final
     * and all private cloud resources are irreversibly removed and billing stops.
     * During the final removal process, `PrivateCloud.state` is set to `PURGING`.
     * `PrivateCloud` can be polled using standard `GET` method for the whole
     * period of deletion and purging. It will not be returned only
     * when it is completely purged.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deletePrivateCloud(
        com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Restores a private cloud that was previously scheduled for deletion by
     * `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has
     * `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to
     * the time when deletion can no longer be reversed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> undeletePrivateCloud(
        com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeletePrivateCloudMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists `Cluster` resources in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListClustersResponse> listClusters(
        com.google.cloud.vmwareengine.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a `Cluster` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.Cluster> getCluster(
        com.google.cloud.vmwareengine.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new cluster in a given private cloud.
     * Creating a new cluster provides additional nodes for
     * use in the parent private cloud and requires sufficient [node
     * quota](https://cloud.google.com/vmware-engine/quotas).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createCluster(
        com.google.cloud.vmwareengine.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Modifies a `Cluster` resource. Only the following fields can be updated:
     * `node_type_configs.*.node_count`. Only fields specified in `updateMask` are
     * applied.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateCluster(
        com.google.cloud.vmwareengine.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or
     * gracefully shut down any workloads running on the cluster before deletion.
     * You cannot delete the management cluster of a private cloud using this
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteCluster(
        com.google.cloud.vmwareengine.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists subnets in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListSubnetsResponse> listSubnets(
        com.google.cloud.vmwareengine.v1.ListSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubnetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists node types
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse> listNodeTypes(
        com.google.cloud.vmwareengine.v1.ListNodeTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodeTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single `NodeType`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.NodeType> getNodeType(
        com.google.cloud.vmwareengine.v1.GetNodeTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of credentials for NSX appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.Credentials> showNsxCredentials(
        com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowNsxCredentialsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of credentials for Vcenter appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.Credentials> showVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowVcenterCredentialsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resets credentials of the NSX appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> resetNsxCredentials(
        com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetNsxCredentialsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resets credentials of the Vcenter appliance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> resetVcenterCredentials(
        com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetVcenterCredentialsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new HCX activation key in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createHcxActivationKey(
        com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHcxActivationKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists `HcxActivationKey` resources in a given private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse> listHcxActivationKeys(
        com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHcxActivationKeysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a `HcxActivationKey` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.HcxActivationKey> getHcxActivationKey(
        com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHcxActivationKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a `NetworkPolicy` resource by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.NetworkPolicy> getNetworkPolicy(
        com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists `NetworkPolicy` resources in a specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse> listNetworkPolicies(
        com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNetworkPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new network policy in a given VMware Engine network of a
     * project and location (region). A new network policy cannot be created if
     * another network policy already exists in the same scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createNetworkPolicy(
        com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Modifies a `NetworkPolicy` resource. Only the following fields can be
     * updated: `internet_access`, `external_ip`, `edge_services_cidr`.
     * Only fields specified in `updateMask` are applied. When updating a network
     * policy, the external IP network service can only be disabled if there are
     * no external IP addresses present in the scope of the policy. Also, a
     * `NetworkService` cannot be updated when `NetworkService.state` is set
     * to `RECONCILING`.
     * During operation processing, the resource is temporarily in the `ACTIVE`
     * state before the operation fully completes. For that period of time, you
     * can't update the resource. Use the operation status to determine when the
     * processing fully completes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateNetworkPolicy(
        com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted
     * when `NetworkService.state` is set to `RECONCILING` for either its external
     * IP or internet access service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteNetworkPolicy(
        com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNetworkPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new VMware Engine network that can be used by a private cloud.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Modifies a VMware Engine network resource. Only the following fields can be
     * updated: `description`. Only fields specified in `updateMask` are
     * applied.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware
     * Engine network after all resources that refer to it are deleted. For
     * example, a private cloud, a network peering, and a network policy can all
     * refer to the same VMware Engine network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a `VmwareEngineNetwork` resource by its resource name. The
     * resource contains details of the VMware Engine network, such as its VMware
     * Engine network type, peered networks in a service project, and state
     * (for example, `CREATING`, `ACTIVE`, `DELETING`).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork> getVmwareEngineNetwork(
        com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVmwareEngineNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists `VmwareEngineNetwork` resources in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse> listVmwareEngineNetworks(
        com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVmwareEngineNetworksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PRIVATE_CLOUDS = 0;
  private static final int METHODID_GET_PRIVATE_CLOUD = 1;
  private static final int METHODID_CREATE_PRIVATE_CLOUD = 2;
  private static final int METHODID_UPDATE_PRIVATE_CLOUD = 3;
  private static final int METHODID_DELETE_PRIVATE_CLOUD = 4;
  private static final int METHODID_UNDELETE_PRIVATE_CLOUD = 5;
  private static final int METHODID_LIST_CLUSTERS = 6;
  private static final int METHODID_GET_CLUSTER = 7;
  private static final int METHODID_CREATE_CLUSTER = 8;
  private static final int METHODID_UPDATE_CLUSTER = 9;
  private static final int METHODID_DELETE_CLUSTER = 10;
  private static final int METHODID_LIST_SUBNETS = 11;
  private static final int METHODID_LIST_NODE_TYPES = 12;
  private static final int METHODID_GET_NODE_TYPE = 13;
  private static final int METHODID_SHOW_NSX_CREDENTIALS = 14;
  private static final int METHODID_SHOW_VCENTER_CREDENTIALS = 15;
  private static final int METHODID_RESET_NSX_CREDENTIALS = 16;
  private static final int METHODID_RESET_VCENTER_CREDENTIALS = 17;
  private static final int METHODID_CREATE_HCX_ACTIVATION_KEY = 18;
  private static final int METHODID_LIST_HCX_ACTIVATION_KEYS = 19;
  private static final int METHODID_GET_HCX_ACTIVATION_KEY = 20;
  private static final int METHODID_GET_NETWORK_POLICY = 21;
  private static final int METHODID_LIST_NETWORK_POLICIES = 22;
  private static final int METHODID_CREATE_NETWORK_POLICY = 23;
  private static final int METHODID_UPDATE_NETWORK_POLICY = 24;
  private static final int METHODID_DELETE_NETWORK_POLICY = 25;
  private static final int METHODID_CREATE_VMWARE_ENGINE_NETWORK = 26;
  private static final int METHODID_UPDATE_VMWARE_ENGINE_NETWORK = 27;
  private static final int METHODID_DELETE_VMWARE_ENGINE_NETWORK = 28;
  private static final int METHODID_GET_VMWARE_ENGINE_NETWORK = 29;
  private static final int METHODID_LIST_VMWARE_ENGINE_NETWORKS = 30;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VmwareEngineImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VmwareEngineImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_PRIVATE_CLOUDS:
          serviceImpl.listPrivateClouds((com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse>) responseObserver);
          break;
        case METHODID_GET_PRIVATE_CLOUD:
          serviceImpl.getPrivateCloud((com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.PrivateCloud>) responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_CLOUD:
          serviceImpl.createPrivateCloud((com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PRIVATE_CLOUD:
          serviceImpl.updatePrivateCloud((com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_CLOUD:
          serviceImpl.deletePrivateCloud((com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_PRIVATE_CLOUD:
          serviceImpl.undeletePrivateCloud((com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters((com.google.cloud.vmwareengine.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListClustersResponse>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster((com.google.cloud.vmwareengine.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Cluster>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster((com.google.cloud.vmwareengine.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster((com.google.cloud.vmwareengine.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster((com.google.cloud.vmwareengine.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SUBNETS:
          serviceImpl.listSubnets((com.google.cloud.vmwareengine.v1.ListSubnetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListSubnetsResponse>) responseObserver);
          break;
        case METHODID_LIST_NODE_TYPES:
          serviceImpl.listNodeTypes((com.google.cloud.vmwareengine.v1.ListNodeTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNodeTypesResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_TYPE:
          serviceImpl.getNodeType((com.google.cloud.vmwareengine.v1.GetNodeTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NodeType>) responseObserver);
          break;
        case METHODID_SHOW_NSX_CREDENTIALS:
          serviceImpl.showNsxCredentials((com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>) responseObserver);
          break;
        case METHODID_SHOW_VCENTER_CREDENTIALS:
          serviceImpl.showVcenterCredentials((com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.Credentials>) responseObserver);
          break;
        case METHODID_RESET_NSX_CREDENTIALS:
          serviceImpl.resetNsxCredentials((com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_VCENTER_CREDENTIALS:
          serviceImpl.resetVcenterCredentials((com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_HCX_ACTIVATION_KEY:
          serviceImpl.createHcxActivationKey((com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HCX_ACTIVATION_KEYS:
          serviceImpl.listHcxActivationKeys((com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse>) responseObserver);
          break;
        case METHODID_GET_HCX_ACTIVATION_KEY:
          serviceImpl.getHcxActivationKey((com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.HcxActivationKey>) responseObserver);
          break;
        case METHODID_GET_NETWORK_POLICY:
          serviceImpl.getNetworkPolicy((com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.NetworkPolicy>) responseObserver);
          break;
        case METHODID_LIST_NETWORK_POLICIES:
          serviceImpl.listNetworkPolicies((com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse>) responseObserver);
          break;
        case METHODID_CREATE_NETWORK_POLICY:
          serviceImpl.createNetworkPolicy((com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NETWORK_POLICY:
          serviceImpl.updateNetworkPolicy((com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NETWORK_POLICY:
          serviceImpl.deleteNetworkPolicy((com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_VMWARE_ENGINE_NETWORK:
          serviceImpl.createVmwareEngineNetwork((com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VMWARE_ENGINE_NETWORK:
          serviceImpl.updateVmwareEngineNetwork((com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VMWARE_ENGINE_NETWORK:
          serviceImpl.deleteVmwareEngineNetwork((com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_VMWARE_ENGINE_NETWORK:
          serviceImpl.getVmwareEngineNetwork((com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.VmwareEngineNetwork>) responseObserver);
          break;
        case METHODID_LIST_VMWARE_ENGINE_NETWORKS:
          serviceImpl.listVmwareEngineNetworks((com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse>) responseObserver);
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

  private static abstract class VmwareEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VmwareEngineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vmwareengine.v1.VmwareengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VmwareEngine");
    }
  }

  private static final class VmwareEngineFileDescriptorSupplier
      extends VmwareEngineBaseDescriptorSupplier {
    VmwareEngineFileDescriptorSupplier() {}
  }

  private static final class VmwareEngineMethodDescriptorSupplier
      extends VmwareEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VmwareEngineMethodDescriptorSupplier(String methodName) {
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
      synchronized (VmwareEngineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VmwareEngineFileDescriptorSupplier())
              .addMethod(getListPrivateCloudsMethod())
              .addMethod(getGetPrivateCloudMethod())
              .addMethod(getCreatePrivateCloudMethod())
              .addMethod(getUpdatePrivateCloudMethod())
              .addMethod(getDeletePrivateCloudMethod())
              .addMethod(getUndeletePrivateCloudMethod())
              .addMethod(getListClustersMethod())
              .addMethod(getGetClusterMethod())
              .addMethod(getCreateClusterMethod())
              .addMethod(getUpdateClusterMethod())
              .addMethod(getDeleteClusterMethod())
              .addMethod(getListSubnetsMethod())
              .addMethod(getListNodeTypesMethod())
              .addMethod(getGetNodeTypeMethod())
              .addMethod(getShowNsxCredentialsMethod())
              .addMethod(getShowVcenterCredentialsMethod())
              .addMethod(getResetNsxCredentialsMethod())
              .addMethod(getResetVcenterCredentialsMethod())
              .addMethod(getCreateHcxActivationKeyMethod())
              .addMethod(getListHcxActivationKeysMethod())
              .addMethod(getGetHcxActivationKeyMethod())
              .addMethod(getGetNetworkPolicyMethod())
              .addMethod(getListNetworkPoliciesMethod())
              .addMethod(getCreateNetworkPolicyMethod())
              .addMethod(getUpdateNetworkPolicyMethod())
              .addMethod(getDeleteNetworkPolicyMethod())
              .addMethod(getCreateVmwareEngineNetworkMethod())
              .addMethod(getUpdateVmwareEngineNetworkMethod())
              .addMethod(getDeleteVmwareEngineNetworkMethod())
              .addMethod(getGetVmwareEngineNetworkMethod())
              .addMethod(getListVmwareEngineNetworksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
