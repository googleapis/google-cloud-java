package com.google.cloud.edgecontainer.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * EdgeContainer API provides management of Kubernetes Clusters on Google Edge
 * Cloud deployments.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/edgecontainer/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EdgeContainerGrpc {

  private EdgeContainerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.edgecontainer.v1.EdgeContainer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListClustersRequest,
      com.google.cloud.edgecontainer.v1.ListClustersResponse> getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.edgecontainer.v1.ListClustersRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListClustersRequest,
      com.google.cloud.edgecontainer.v1.ListClustersResponse> getListClustersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListClustersRequest, com.google.cloud.edgecontainer.v1.ListClustersResponse> getListClustersMethod;
    if ((getListClustersMethod = EdgeContainerGrpc.getListClustersMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getListClustersMethod = EdgeContainerGrpc.getListClustersMethod) == null) {
          EdgeContainerGrpc.getListClustersMethod = getListClustersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.ListClustersRequest, com.google.cloud.edgecontainer.v1.ListClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListClustersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("ListClusters"))
              .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetClusterRequest,
      com.google.cloud.edgecontainer.v1.Cluster> getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.edgecontainer.v1.GetClusterRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetClusterRequest,
      com.google.cloud.edgecontainer.v1.Cluster> getGetClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetClusterRequest, com.google.cloud.edgecontainer.v1.Cluster> getGetClusterMethod;
    if ((getGetClusterMethod = EdgeContainerGrpc.getGetClusterMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getGetClusterMethod = EdgeContainerGrpc.getGetClusterMethod) == null) {
          EdgeContainerGrpc.getGetClusterMethod = getGetClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.GetClusterRequest, com.google.cloud.edgecontainer.v1.Cluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.GetClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.Cluster.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("GetCluster"))
              .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.edgecontainer.v1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateClusterRequest, com.google.longrunning.Operation> getCreateClusterMethod;
    if ((getCreateClusterMethod = EdgeContainerGrpc.getCreateClusterMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getCreateClusterMethod = EdgeContainerGrpc.getCreateClusterMethod) == null) {
          EdgeContainerGrpc.getCreateClusterMethod = getCreateClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.CreateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("CreateCluster"))
              .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.edgecontainer.v1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.UpdateClusterRequest, com.google.longrunning.Operation> getUpdateClusterMethod;
    if ((getUpdateClusterMethod = EdgeContainerGrpc.getUpdateClusterMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getUpdateClusterMethod = EdgeContainerGrpc.getUpdateClusterMethod) == null) {
          EdgeContainerGrpc.getUpdateClusterMethod = getUpdateClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.UpdateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("UpdateCluster"))
              .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.edgecontainer.v1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteClusterRequest, com.google.longrunning.Operation> getDeleteClusterMethod;
    if ((getDeleteClusterMethod = EdgeContainerGrpc.getDeleteClusterMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getDeleteClusterMethod = EdgeContainerGrpc.getDeleteClusterMethod) == null) {
          EdgeContainerGrpc.getDeleteClusterMethod = getDeleteClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.DeleteClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("DeleteCluster"))
              .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest,
      com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse> getGenerateAccessTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAccessToken",
      requestType = com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest,
      com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse> getGenerateAccessTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest, com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse> getGenerateAccessTokenMethod;
    if ((getGenerateAccessTokenMethod = EdgeContainerGrpc.getGenerateAccessTokenMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getGenerateAccessTokenMethod = EdgeContainerGrpc.getGenerateAccessTokenMethod) == null) {
          EdgeContainerGrpc.getGenerateAccessTokenMethod = getGenerateAccessTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest, com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateAccessToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("GenerateAccessToken"))
              .build();
        }
      }
    }
    return getGenerateAccessTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListNodePoolsRequest,
      com.google.cloud.edgecontainer.v1.ListNodePoolsResponse> getListNodePoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNodePools",
      requestType = com.google.cloud.edgecontainer.v1.ListNodePoolsRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.ListNodePoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListNodePoolsRequest,
      com.google.cloud.edgecontainer.v1.ListNodePoolsResponse> getListNodePoolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListNodePoolsRequest, com.google.cloud.edgecontainer.v1.ListNodePoolsResponse> getListNodePoolsMethod;
    if ((getListNodePoolsMethod = EdgeContainerGrpc.getListNodePoolsMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getListNodePoolsMethod = EdgeContainerGrpc.getListNodePoolsMethod) == null) {
          EdgeContainerGrpc.getListNodePoolsMethod = getListNodePoolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.ListNodePoolsRequest, com.google.cloud.edgecontainer.v1.ListNodePoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNodePools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListNodePoolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("ListNodePools"))
              .build();
        }
      }
    }
    return getListNodePoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetNodePoolRequest,
      com.google.cloud.edgecontainer.v1.NodePool> getGetNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodePool",
      requestType = com.google.cloud.edgecontainer.v1.GetNodePoolRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.NodePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetNodePoolRequest,
      com.google.cloud.edgecontainer.v1.NodePool> getGetNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetNodePoolRequest, com.google.cloud.edgecontainer.v1.NodePool> getGetNodePoolMethod;
    if ((getGetNodePoolMethod = EdgeContainerGrpc.getGetNodePoolMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getGetNodePoolMethod = EdgeContainerGrpc.getGetNodePoolMethod) == null) {
          EdgeContainerGrpc.getGetNodePoolMethod = getGetNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.GetNodePoolRequest, com.google.cloud.edgecontainer.v1.NodePool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.GetNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.NodePool.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("GetNodePool"))
              .build();
        }
      }
    }
    return getGetNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateNodePoolRequest,
      com.google.longrunning.Operation> getCreateNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNodePool",
      requestType = com.google.cloud.edgecontainer.v1.CreateNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateNodePoolRequest,
      com.google.longrunning.Operation> getCreateNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateNodePoolRequest, com.google.longrunning.Operation> getCreateNodePoolMethod;
    if ((getCreateNodePoolMethod = EdgeContainerGrpc.getCreateNodePoolMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getCreateNodePoolMethod = EdgeContainerGrpc.getCreateNodePoolMethod) == null) {
          EdgeContainerGrpc.getCreateNodePoolMethod = getCreateNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.CreateNodePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.CreateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("CreateNodePool"))
              .build();
        }
      }
    }
    return getCreateNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest,
      com.google.longrunning.Operation> getUpdateNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNodePool",
      requestType = com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest,
      com.google.longrunning.Operation> getUpdateNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest, com.google.longrunning.Operation> getUpdateNodePoolMethod;
    if ((getUpdateNodePoolMethod = EdgeContainerGrpc.getUpdateNodePoolMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getUpdateNodePoolMethod = EdgeContainerGrpc.getUpdateNodePoolMethod) == null) {
          EdgeContainerGrpc.getUpdateNodePoolMethod = getUpdateNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("UpdateNodePool"))
              .build();
        }
      }
    }
    return getUpdateNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest,
      com.google.longrunning.Operation> getDeleteNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNodePool",
      requestType = com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest,
      com.google.longrunning.Operation> getDeleteNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest, com.google.longrunning.Operation> getDeleteNodePoolMethod;
    if ((getDeleteNodePoolMethod = EdgeContainerGrpc.getDeleteNodePoolMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getDeleteNodePoolMethod = EdgeContainerGrpc.getDeleteNodePoolMethod) == null) {
          EdgeContainerGrpc.getDeleteNodePoolMethod = getDeleteNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("DeleteNodePool"))
              .build();
        }
      }
    }
    return getDeleteNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListMachinesRequest,
      com.google.cloud.edgecontainer.v1.ListMachinesResponse> getListMachinesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMachines",
      requestType = com.google.cloud.edgecontainer.v1.ListMachinesRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.ListMachinesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListMachinesRequest,
      com.google.cloud.edgecontainer.v1.ListMachinesResponse> getListMachinesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListMachinesRequest, com.google.cloud.edgecontainer.v1.ListMachinesResponse> getListMachinesMethod;
    if ((getListMachinesMethod = EdgeContainerGrpc.getListMachinesMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getListMachinesMethod = EdgeContainerGrpc.getListMachinesMethod) == null) {
          EdgeContainerGrpc.getListMachinesMethod = getListMachinesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.ListMachinesRequest, com.google.cloud.edgecontainer.v1.ListMachinesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMachines"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListMachinesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListMachinesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("ListMachines"))
              .build();
        }
      }
    }
    return getListMachinesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetMachineRequest,
      com.google.cloud.edgecontainer.v1.Machine> getGetMachineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMachine",
      requestType = com.google.cloud.edgecontainer.v1.GetMachineRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.Machine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetMachineRequest,
      com.google.cloud.edgecontainer.v1.Machine> getGetMachineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetMachineRequest, com.google.cloud.edgecontainer.v1.Machine> getGetMachineMethod;
    if ((getGetMachineMethod = EdgeContainerGrpc.getGetMachineMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getGetMachineMethod = EdgeContainerGrpc.getGetMachineMethod) == null) {
          EdgeContainerGrpc.getGetMachineMethod = getGetMachineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.GetMachineRequest, com.google.cloud.edgecontainer.v1.Machine>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMachine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.GetMachineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.Machine.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("GetMachine"))
              .build();
        }
      }
    }
    return getGetMachineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest,
      com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse> getListVpnConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVpnConnections",
      requestType = com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest,
      com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse> getListVpnConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest, com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse> getListVpnConnectionsMethod;
    if ((getListVpnConnectionsMethod = EdgeContainerGrpc.getListVpnConnectionsMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getListVpnConnectionsMethod = EdgeContainerGrpc.getListVpnConnectionsMethod) == null) {
          EdgeContainerGrpc.getListVpnConnectionsMethod = getListVpnConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest, com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVpnConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("ListVpnConnections"))
              .build();
        }
      }
    }
    return getListVpnConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest,
      com.google.cloud.edgecontainer.v1.VpnConnection> getGetVpnConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVpnConnection",
      requestType = com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest.class,
      responseType = com.google.cloud.edgecontainer.v1.VpnConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest,
      com.google.cloud.edgecontainer.v1.VpnConnection> getGetVpnConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest, com.google.cloud.edgecontainer.v1.VpnConnection> getGetVpnConnectionMethod;
    if ((getGetVpnConnectionMethod = EdgeContainerGrpc.getGetVpnConnectionMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getGetVpnConnectionMethod = EdgeContainerGrpc.getGetVpnConnectionMethod) == null) {
          EdgeContainerGrpc.getGetVpnConnectionMethod = getGetVpnConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest, com.google.cloud.edgecontainer.v1.VpnConnection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVpnConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.VpnConnection.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("GetVpnConnection"))
              .build();
        }
      }
    }
    return getGetVpnConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest,
      com.google.longrunning.Operation> getCreateVpnConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVpnConnection",
      requestType = com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest,
      com.google.longrunning.Operation> getCreateVpnConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest, com.google.longrunning.Operation> getCreateVpnConnectionMethod;
    if ((getCreateVpnConnectionMethod = EdgeContainerGrpc.getCreateVpnConnectionMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getCreateVpnConnectionMethod = EdgeContainerGrpc.getCreateVpnConnectionMethod) == null) {
          EdgeContainerGrpc.getCreateVpnConnectionMethod = getCreateVpnConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVpnConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("CreateVpnConnection"))
              .build();
        }
      }
    }
    return getCreateVpnConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest,
      com.google.longrunning.Operation> getDeleteVpnConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVpnConnection",
      requestType = com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest,
      com.google.longrunning.Operation> getDeleteVpnConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest, com.google.longrunning.Operation> getDeleteVpnConnectionMethod;
    if ((getDeleteVpnConnectionMethod = EdgeContainerGrpc.getDeleteVpnConnectionMethod) == null) {
      synchronized (EdgeContainerGrpc.class) {
        if ((getDeleteVpnConnectionMethod = EdgeContainerGrpc.getDeleteVpnConnectionMethod) == null) {
          EdgeContainerGrpc.getDeleteVpnConnectionMethod = getDeleteVpnConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVpnConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeContainerMethodDescriptorSupplier("DeleteVpnConnection"))
              .build();
        }
      }
    }
    return getDeleteVpnConnectionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EdgeContainerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EdgeContainerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EdgeContainerStub>() {
        @java.lang.Override
        public EdgeContainerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EdgeContainerStub(channel, callOptions);
        }
      };
    return EdgeContainerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EdgeContainerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EdgeContainerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EdgeContainerBlockingStub>() {
        @java.lang.Override
        public EdgeContainerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EdgeContainerBlockingStub(channel, callOptions);
        }
      };
    return EdgeContainerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EdgeContainerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EdgeContainerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EdgeContainerFutureStub>() {
        @java.lang.Override
        public EdgeContainerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EdgeContainerFutureStub(channel, callOptions);
        }
      };
    return EdgeContainerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * EdgeContainer API provides management of Kubernetes Clusters on Google Edge
   * Cloud deployments.
   * </pre>
   */
  public static abstract class EdgeContainerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public void listClusters(com.google.cloud.edgecontainer.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListClustersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListClustersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public void getCluster(com.google.cloud.edgecontainer.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public void createCluster(com.google.cloud.edgecontainer.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public void updateCluster(com.google.cloud.edgecontainer.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public void deleteCluster(com.google.cloud.edgecontainer.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates an access token for a Cluster.
     * </pre>
     */
    public void generateAccessToken(com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateAccessTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists NodePools in a given project and location.
     * </pre>
     */
    public void listNodePools(com.google.cloud.edgecontainer.v1.ListNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListNodePoolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNodePoolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single NodePool.
     * </pre>
     */
    public void getNodePool(com.google.cloud.edgecontainer.v1.GetNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.NodePool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new NodePool in a given project and location.
     * </pre>
     */
    public void createNodePool(com.google.cloud.edgecontainer.v1.CreateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single NodePool.
     * </pre>
     */
    public void updateNodePool(com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single NodePool.
     * </pre>
     */
    public void deleteNodePool(com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Machines in a given project and location.
     * </pre>
     */
    public void listMachines(com.google.cloud.edgecontainer.v1.ListMachinesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListMachinesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMachinesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Machine.
     * </pre>
     */
    public void getMachine(com.google.cloud.edgecontainer.v1.GetMachineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.Machine> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMachineMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists VPN connections in a given project and location.
     * </pre>
     */
    public void listVpnConnections(com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVpnConnectionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single VPN connection.
     * </pre>
     */
    public void getVpnConnection(com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.VpnConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVpnConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new VPN connection in a given project and location.
     * </pre>
     */
    public void createVpnConnection(com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVpnConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single VPN connection.
     * </pre>
     */
    public void deleteVpnConnection(com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVpnConnectionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.ListClustersRequest,
                com.google.cloud.edgecontainer.v1.ListClustersResponse>(
                  this, METHODID_LIST_CLUSTERS)))
          .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.GetClusterRequest,
                com.google.cloud.edgecontainer.v1.Cluster>(
                  this, METHODID_GET_CLUSTER)))
          .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.CreateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLUSTER)))
          .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.UpdateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.DeleteClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CLUSTER)))
          .addMethod(
            getGenerateAccessTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest,
                com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse>(
                  this, METHODID_GENERATE_ACCESS_TOKEN)))
          .addMethod(
            getListNodePoolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.ListNodePoolsRequest,
                com.google.cloud.edgecontainer.v1.ListNodePoolsResponse>(
                  this, METHODID_LIST_NODE_POOLS)))
          .addMethod(
            getGetNodePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.GetNodePoolRequest,
                com.google.cloud.edgecontainer.v1.NodePool>(
                  this, METHODID_GET_NODE_POOL)))
          .addMethod(
            getCreateNodePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.CreateNodePoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_NODE_POOL)))
          .addMethod(
            getUpdateNodePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_NODE_POOL)))
          .addMethod(
            getDeleteNodePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_NODE_POOL)))
          .addMethod(
            getListMachinesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.ListMachinesRequest,
                com.google.cloud.edgecontainer.v1.ListMachinesResponse>(
                  this, METHODID_LIST_MACHINES)))
          .addMethod(
            getGetMachineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.GetMachineRequest,
                com.google.cloud.edgecontainer.v1.Machine>(
                  this, METHODID_GET_MACHINE)))
          .addMethod(
            getListVpnConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest,
                com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse>(
                  this, METHODID_LIST_VPN_CONNECTIONS)))
          .addMethod(
            getGetVpnConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest,
                com.google.cloud.edgecontainer.v1.VpnConnection>(
                  this, METHODID_GET_VPN_CONNECTION)))
          .addMethod(
            getCreateVpnConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_VPN_CONNECTION)))
          .addMethod(
            getDeleteVpnConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_VPN_CONNECTION)))
          .build();
    }
  }

  /**
   * <pre>
   * EdgeContainer API provides management of Kubernetes Clusters on Google Edge
   * Cloud deployments.
   * </pre>
   */
  public static final class EdgeContainerStub extends io.grpc.stub.AbstractAsyncStub<EdgeContainerStub> {
    private EdgeContainerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EdgeContainerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EdgeContainerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public void listClusters(com.google.cloud.edgecontainer.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListClustersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public void getCluster(com.google.cloud.edgecontainer.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public void createCluster(com.google.cloud.edgecontainer.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public void updateCluster(com.google.cloud.edgecontainer.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public void deleteCluster(com.google.cloud.edgecontainer.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates an access token for a Cluster.
     * </pre>
     */
    public void generateAccessToken(com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists NodePools in a given project and location.
     * </pre>
     */
    public void listNodePools(com.google.cloud.edgecontainer.v1.ListNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListNodePoolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNodePoolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single NodePool.
     * </pre>
     */
    public void getNodePool(com.google.cloud.edgecontainer.v1.GetNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.NodePool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new NodePool in a given project and location.
     * </pre>
     */
    public void createNodePool(com.google.cloud.edgecontainer.v1.CreateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single NodePool.
     * </pre>
     */
    public void updateNodePool(com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single NodePool.
     * </pre>
     */
    public void deleteNodePool(com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Machines in a given project and location.
     * </pre>
     */
    public void listMachines(com.google.cloud.edgecontainer.v1.ListMachinesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListMachinesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMachinesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Machine.
     * </pre>
     */
    public void getMachine(com.google.cloud.edgecontainer.v1.GetMachineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.Machine> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMachineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists VPN connections in a given project and location.
     * </pre>
     */
    public void listVpnConnections(com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVpnConnectionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single VPN connection.
     * </pre>
     */
    public void getVpnConnection(com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.VpnConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVpnConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new VPN connection in a given project and location.
     * </pre>
     */
    public void createVpnConnection(com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVpnConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single VPN connection.
     * </pre>
     */
    public void deleteVpnConnection(com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVpnConnectionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * EdgeContainer API provides management of Kubernetes Clusters on Google Edge
   * Cloud deployments.
   * </pre>
   */
  public static final class EdgeContainerBlockingStub extends io.grpc.stub.AbstractBlockingStub<EdgeContainerBlockingStub> {
    private EdgeContainerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EdgeContainerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EdgeContainerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.ListClustersResponse listClusters(com.google.cloud.edgecontainer.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.Cluster getCluster(com.google.cloud.edgecontainer.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(com.google.cloud.edgecontainer.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(com.google.cloud.edgecontainer.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(com.google.cloud.edgecontainer.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates an access token for a Cluster.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse generateAccessToken(com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAccessTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists NodePools in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.ListNodePoolsResponse listNodePools(com.google.cloud.edgecontainer.v1.ListNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNodePoolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single NodePool.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.NodePool getNodePool(com.google.cloud.edgecontainer.v1.GetNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new NodePool in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createNodePool(com.google.cloud.edgecontainer.v1.CreateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single NodePool.
     * </pre>
     */
    public com.google.longrunning.Operation updateNodePool(com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single NodePool.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNodePool(com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Machines in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.ListMachinesResponse listMachines(com.google.cloud.edgecontainer.v1.ListMachinesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMachinesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Machine.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.Machine getMachine(com.google.cloud.edgecontainer.v1.GetMachineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMachineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists VPN connections in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse listVpnConnections(com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVpnConnectionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single VPN connection.
     * </pre>
     */
    public com.google.cloud.edgecontainer.v1.VpnConnection getVpnConnection(com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVpnConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new VPN connection in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createVpnConnection(com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVpnConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single VPN connection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVpnConnection(com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVpnConnectionMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * EdgeContainer API provides management of Kubernetes Clusters on Google Edge
   * Cloud deployments.
   * </pre>
   */
  public static final class EdgeContainerFutureStub extends io.grpc.stub.AbstractFutureStub<EdgeContainerFutureStub> {
    private EdgeContainerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EdgeContainerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EdgeContainerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.ListClustersResponse> listClusters(
        com.google.cloud.edgecontainer.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.Cluster> getCluster(
        com.google.cloud.edgecontainer.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createCluster(
        com.google.cloud.edgecontainer.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateCluster(
        com.google.cloud.edgecontainer.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteCluster(
        com.google.cloud.edgecontainer.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates an access token for a Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse> generateAccessToken(
        com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists NodePools in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.ListNodePoolsResponse> listNodePools(
        com.google.cloud.edgecontainer.v1.ListNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNodePoolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single NodePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.NodePool> getNodePool(
        com.google.cloud.edgecontainer.v1.GetNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new NodePool in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createNodePool(
        com.google.cloud.edgecontainer.v1.CreateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single NodePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateNodePool(
        com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single NodePool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteNodePool(
        com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Machines in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.ListMachinesResponse> listMachines(
        com.google.cloud.edgecontainer.v1.ListMachinesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMachinesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Machine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.Machine> getMachine(
        com.google.cloud.edgecontainer.v1.GetMachineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMachineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists VPN connections in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse> listVpnConnections(
        com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVpnConnectionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single VPN connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgecontainer.v1.VpnConnection> getVpnConnection(
        com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVpnConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new VPN connection in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createVpnConnection(
        com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVpnConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single VPN connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteVpnConnection(
        com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVpnConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_DELETE_CLUSTER = 4;
  private static final int METHODID_GENERATE_ACCESS_TOKEN = 5;
  private static final int METHODID_LIST_NODE_POOLS = 6;
  private static final int METHODID_GET_NODE_POOL = 7;
  private static final int METHODID_CREATE_NODE_POOL = 8;
  private static final int METHODID_UPDATE_NODE_POOL = 9;
  private static final int METHODID_DELETE_NODE_POOL = 10;
  private static final int METHODID_LIST_MACHINES = 11;
  private static final int METHODID_GET_MACHINE = 12;
  private static final int METHODID_LIST_VPN_CONNECTIONS = 13;
  private static final int METHODID_GET_VPN_CONNECTION = 14;
  private static final int METHODID_CREATE_VPN_CONNECTION = 15;
  private static final int METHODID_DELETE_VPN_CONNECTION = 16;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EdgeContainerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EdgeContainerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters((com.google.cloud.edgecontainer.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListClustersResponse>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster((com.google.cloud.edgecontainer.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.Cluster>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster((com.google.cloud.edgecontainer.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster((com.google.cloud.edgecontainer.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster((com.google.cloud.edgecontainer.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_ACCESS_TOKEN:
          serviceImpl.generateAccessToken((com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse>) responseObserver);
          break;
        case METHODID_LIST_NODE_POOLS:
          serviceImpl.listNodePools((com.google.cloud.edgecontainer.v1.ListNodePoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListNodePoolsResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_POOL:
          serviceImpl.getNodePool((com.google.cloud.edgecontainer.v1.GetNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.NodePool>) responseObserver);
          break;
        case METHODID_CREATE_NODE_POOL:
          serviceImpl.createNodePool((com.google.cloud.edgecontainer.v1.CreateNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NODE_POOL:
          serviceImpl.updateNodePool((com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NODE_POOL:
          serviceImpl.deleteNodePool((com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MACHINES:
          serviceImpl.listMachines((com.google.cloud.edgecontainer.v1.ListMachinesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListMachinesResponse>) responseObserver);
          break;
        case METHODID_GET_MACHINE:
          serviceImpl.getMachine((com.google.cloud.edgecontainer.v1.GetMachineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.Machine>) responseObserver);
          break;
        case METHODID_LIST_VPN_CONNECTIONS:
          serviceImpl.listVpnConnections((com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse>) responseObserver);
          break;
        case METHODID_GET_VPN_CONNECTION:
          serviceImpl.getVpnConnection((com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgecontainer.v1.VpnConnection>) responseObserver);
          break;
        case METHODID_CREATE_VPN_CONNECTION:
          serviceImpl.createVpnConnection((com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VPN_CONNECTION:
          serviceImpl.deleteVpnConnection((com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private static abstract class EdgeContainerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EdgeContainerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.edgecontainer.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EdgeContainer");
    }
  }

  private static final class EdgeContainerFileDescriptorSupplier
      extends EdgeContainerBaseDescriptorSupplier {
    EdgeContainerFileDescriptorSupplier() {}
  }

  private static final class EdgeContainerMethodDescriptorSupplier
      extends EdgeContainerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EdgeContainerMethodDescriptorSupplier(String methodName) {
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
      synchronized (EdgeContainerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EdgeContainerFileDescriptorSupplier())
              .addMethod(getListClustersMethod())
              .addMethod(getGetClusterMethod())
              .addMethod(getCreateClusterMethod())
              .addMethod(getUpdateClusterMethod())
              .addMethod(getDeleteClusterMethod())
              .addMethod(getGenerateAccessTokenMethod())
              .addMethod(getListNodePoolsMethod())
              .addMethod(getGetNodePoolMethod())
              .addMethod(getCreateNodePoolMethod())
              .addMethod(getUpdateNodePoolMethod())
              .addMethod(getDeleteNodePoolMethod())
              .addMethod(getListMachinesMethod())
              .addMethod(getGetMachineMethod())
              .addMethod(getListVpnConnectionsMethod())
              .addMethod(getGetVpnConnectionMethod())
              .addMethod(getCreateVpnConnectionMethod())
              .addMethod(getDeleteVpnConnectionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
