package com.google.cloud.gkemulticloud.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The AwsClusters API provides a single centrally managed service
 * to create and manage Anthos clusters that run on AWS infrastructure.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkemulticloud/v1/aws_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AwsClustersGrpc {

  private AwsClustersGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.gkemulticloud.v1.AwsClusters";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest,
      com.google.longrunning.Operation> getCreateAwsClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAwsCluster",
      requestType = com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest,
      com.google.longrunning.Operation> getCreateAwsClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest, com.google.longrunning.Operation> getCreateAwsClusterMethod;
    if ((getCreateAwsClusterMethod = AwsClustersGrpc.getCreateAwsClusterMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getCreateAwsClusterMethod = AwsClustersGrpc.getCreateAwsClusterMethod) == null) {
          AwsClustersGrpc.getCreateAwsClusterMethod = getCreateAwsClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAwsCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("CreateAwsCluster"))
              .build();
        }
      }
    }
    return getCreateAwsClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest,
      com.google.longrunning.Operation> getUpdateAwsClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAwsCluster",
      requestType = com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest,
      com.google.longrunning.Operation> getUpdateAwsClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest, com.google.longrunning.Operation> getUpdateAwsClusterMethod;
    if ((getUpdateAwsClusterMethod = AwsClustersGrpc.getUpdateAwsClusterMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getUpdateAwsClusterMethod = AwsClustersGrpc.getUpdateAwsClusterMethod) == null) {
          AwsClustersGrpc.getUpdateAwsClusterMethod = getUpdateAwsClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAwsCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("UpdateAwsCluster"))
              .build();
        }
      }
    }
    return getUpdateAwsClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest,
      com.google.cloud.gkemulticloud.v1.AwsCluster> getGetAwsClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAwsCluster",
      requestType = com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AwsCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest,
      com.google.cloud.gkemulticloud.v1.AwsCluster> getGetAwsClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest, com.google.cloud.gkemulticloud.v1.AwsCluster> getGetAwsClusterMethod;
    if ((getGetAwsClusterMethod = AwsClustersGrpc.getGetAwsClusterMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGetAwsClusterMethod = AwsClustersGrpc.getGetAwsClusterMethod) == null) {
          AwsClustersGrpc.getGetAwsClusterMethod = getGetAwsClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest, com.google.cloud.gkemulticloud.v1.AwsCluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAwsCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.AwsCluster.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GetAwsCluster"))
              .build();
        }
      }
    }
    return getGetAwsClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest,
      com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse> getListAwsClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAwsClusters",
      requestType = com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest,
      com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse> getListAwsClustersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest, com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse> getListAwsClustersMethod;
    if ((getListAwsClustersMethod = AwsClustersGrpc.getListAwsClustersMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getListAwsClustersMethod = AwsClustersGrpc.getListAwsClustersMethod) == null) {
          AwsClustersGrpc.getListAwsClustersMethod = getListAwsClustersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest, com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAwsClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("ListAwsClusters"))
              .build();
        }
      }
    }
    return getListAwsClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest,
      com.google.longrunning.Operation> getDeleteAwsClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAwsCluster",
      requestType = com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest,
      com.google.longrunning.Operation> getDeleteAwsClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest, com.google.longrunning.Operation> getDeleteAwsClusterMethod;
    if ((getDeleteAwsClusterMethod = AwsClustersGrpc.getDeleteAwsClusterMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getDeleteAwsClusterMethod = AwsClustersGrpc.getDeleteAwsClusterMethod) == null) {
          AwsClustersGrpc.getDeleteAwsClusterMethod = getDeleteAwsClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAwsCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("DeleteAwsCluster"))
              .build();
        }
      }
    }
    return getDeleteAwsClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest,
      com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse> getGenerateAwsClusterAgentTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAwsClusterAgentToken",
      requestType = com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest,
      com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse> getGenerateAwsClusterAgentTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest, com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse> getGenerateAwsClusterAgentTokenMethod;
    if ((getGenerateAwsClusterAgentTokenMethod = AwsClustersGrpc.getGenerateAwsClusterAgentTokenMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGenerateAwsClusterAgentTokenMethod = AwsClustersGrpc.getGenerateAwsClusterAgentTokenMethod) == null) {
          AwsClustersGrpc.getGenerateAwsClusterAgentTokenMethod = getGenerateAwsClusterAgentTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest, com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateAwsClusterAgentToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GenerateAwsClusterAgentToken"))
              .build();
        }
      }
    }
    return getGenerateAwsClusterAgentTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest,
      com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse> getGenerateAwsAccessTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAwsAccessToken",
      requestType = com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest,
      com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse> getGenerateAwsAccessTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest, com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse> getGenerateAwsAccessTokenMethod;
    if ((getGenerateAwsAccessTokenMethod = AwsClustersGrpc.getGenerateAwsAccessTokenMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGenerateAwsAccessTokenMethod = AwsClustersGrpc.getGenerateAwsAccessTokenMethod) == null) {
          AwsClustersGrpc.getGenerateAwsAccessTokenMethod = getGenerateAwsAccessTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest, com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateAwsAccessToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GenerateAwsAccessToken"))
              .build();
        }
      }
    }
    return getGenerateAwsAccessTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest,
      com.google.longrunning.Operation> getCreateAwsNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAwsNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest,
      com.google.longrunning.Operation> getCreateAwsNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest, com.google.longrunning.Operation> getCreateAwsNodePoolMethod;
    if ((getCreateAwsNodePoolMethod = AwsClustersGrpc.getCreateAwsNodePoolMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getCreateAwsNodePoolMethod = AwsClustersGrpc.getCreateAwsNodePoolMethod) == null) {
          AwsClustersGrpc.getCreateAwsNodePoolMethod = getCreateAwsNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAwsNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("CreateAwsNodePool"))
              .build();
        }
      }
    }
    return getCreateAwsNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest,
      com.google.longrunning.Operation> getUpdateAwsNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAwsNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest,
      com.google.longrunning.Operation> getUpdateAwsNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest, com.google.longrunning.Operation> getUpdateAwsNodePoolMethod;
    if ((getUpdateAwsNodePoolMethod = AwsClustersGrpc.getUpdateAwsNodePoolMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getUpdateAwsNodePoolMethod = AwsClustersGrpc.getUpdateAwsNodePoolMethod) == null) {
          AwsClustersGrpc.getUpdateAwsNodePoolMethod = getUpdateAwsNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAwsNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("UpdateAwsNodePool"))
              .build();
        }
      }
    }
    return getUpdateAwsNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest,
      com.google.longrunning.Operation> getRollbackAwsNodePoolUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackAwsNodePoolUpdate",
      requestType = com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest,
      com.google.longrunning.Operation> getRollbackAwsNodePoolUpdateMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest, com.google.longrunning.Operation> getRollbackAwsNodePoolUpdateMethod;
    if ((getRollbackAwsNodePoolUpdateMethod = AwsClustersGrpc.getRollbackAwsNodePoolUpdateMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getRollbackAwsNodePoolUpdateMethod = AwsClustersGrpc.getRollbackAwsNodePoolUpdateMethod) == null) {
          AwsClustersGrpc.getRollbackAwsNodePoolUpdateMethod = getRollbackAwsNodePoolUpdateMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollbackAwsNodePoolUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("RollbackAwsNodePoolUpdate"))
              .build();
        }
      }
    }
    return getRollbackAwsNodePoolUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest,
      com.google.cloud.gkemulticloud.v1.AwsNodePool> getGetAwsNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAwsNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AwsNodePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest,
      com.google.cloud.gkemulticloud.v1.AwsNodePool> getGetAwsNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest, com.google.cloud.gkemulticloud.v1.AwsNodePool> getGetAwsNodePoolMethod;
    if ((getGetAwsNodePoolMethod = AwsClustersGrpc.getGetAwsNodePoolMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGetAwsNodePoolMethod = AwsClustersGrpc.getGetAwsNodePoolMethod) == null) {
          AwsClustersGrpc.getGetAwsNodePoolMethod = getGetAwsNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest, com.google.cloud.gkemulticloud.v1.AwsNodePool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAwsNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.AwsNodePool.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GetAwsNodePool"))
              .build();
        }
      }
    }
    return getGetAwsNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest,
      com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse> getListAwsNodePoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAwsNodePools",
      requestType = com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest,
      com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse> getListAwsNodePoolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest, com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse> getListAwsNodePoolsMethod;
    if ((getListAwsNodePoolsMethod = AwsClustersGrpc.getListAwsNodePoolsMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getListAwsNodePoolsMethod = AwsClustersGrpc.getListAwsNodePoolsMethod) == null) {
          AwsClustersGrpc.getListAwsNodePoolsMethod = getListAwsNodePoolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest, com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAwsNodePools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("ListAwsNodePools"))
              .build();
        }
      }
    }
    return getListAwsNodePoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest,
      com.google.longrunning.Operation> getDeleteAwsNodePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAwsNodePool",
      requestType = com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest,
      com.google.longrunning.Operation> getDeleteAwsNodePoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest, com.google.longrunning.Operation> getDeleteAwsNodePoolMethod;
    if ((getDeleteAwsNodePoolMethod = AwsClustersGrpc.getDeleteAwsNodePoolMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getDeleteAwsNodePoolMethod = AwsClustersGrpc.getDeleteAwsNodePoolMethod) == null) {
          AwsClustersGrpc.getDeleteAwsNodePoolMethod = getDeleteAwsNodePoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAwsNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("DeleteAwsNodePool"))
              .build();
        }
      }
    }
    return getDeleteAwsNodePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest,
      com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig> getGetAwsOpenIdConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAwsOpenIdConfig",
      requestType = com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest,
      com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig> getGetAwsOpenIdConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest, com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig> getGetAwsOpenIdConfigMethod;
    if ((getGetAwsOpenIdConfigMethod = AwsClustersGrpc.getGetAwsOpenIdConfigMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGetAwsOpenIdConfigMethod = AwsClustersGrpc.getGetAwsOpenIdConfigMethod) == null) {
          AwsClustersGrpc.getGetAwsOpenIdConfigMethod = getGetAwsOpenIdConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest, com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAwsOpenIdConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GetAwsOpenIdConfig"))
              .build();
        }
      }
    }
    return getGetAwsOpenIdConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest,
      com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys> getGetAwsJsonWebKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAwsJsonWebKeys",
      requestType = com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest,
      com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys> getGetAwsJsonWebKeysMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest, com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys> getGetAwsJsonWebKeysMethod;
    if ((getGetAwsJsonWebKeysMethod = AwsClustersGrpc.getGetAwsJsonWebKeysMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGetAwsJsonWebKeysMethod = AwsClustersGrpc.getGetAwsJsonWebKeysMethod) == null) {
          AwsClustersGrpc.getGetAwsJsonWebKeysMethod = getGetAwsJsonWebKeysMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest, com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAwsJsonWebKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GetAwsJsonWebKeys"))
              .build();
        }
      }
    }
    return getGetAwsJsonWebKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest,
      com.google.cloud.gkemulticloud.v1.AwsServerConfig> getGetAwsServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAwsServerConfig",
      requestType = com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AwsServerConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest,
      com.google.cloud.gkemulticloud.v1.AwsServerConfig> getGetAwsServerConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest, com.google.cloud.gkemulticloud.v1.AwsServerConfig> getGetAwsServerConfigMethod;
    if ((getGetAwsServerConfigMethod = AwsClustersGrpc.getGetAwsServerConfigMethod) == null) {
      synchronized (AwsClustersGrpc.class) {
        if ((getGetAwsServerConfigMethod = AwsClustersGrpc.getGetAwsServerConfigMethod) == null) {
          AwsClustersGrpc.getGetAwsServerConfigMethod = getGetAwsServerConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest, com.google.cloud.gkemulticloud.v1.AwsServerConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAwsServerConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gkemulticloud.v1.AwsServerConfig.getDefaultInstance()))
              .setSchemaDescriptor(new AwsClustersMethodDescriptorSupplier("GetAwsServerConfig"))
              .build();
        }
      }
    }
    return getGetAwsServerConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AwsClustersStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AwsClustersStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AwsClustersStub>() {
        @java.lang.Override
        public AwsClustersStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AwsClustersStub(channel, callOptions);
        }
      };
    return AwsClustersStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AwsClustersBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AwsClustersBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AwsClustersBlockingStub>() {
        @java.lang.Override
        public AwsClustersBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AwsClustersBlockingStub(channel, callOptions);
        }
      };
    return AwsClustersBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AwsClustersFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AwsClustersFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AwsClustersFutureStub>() {
        @java.lang.Override
        public AwsClustersFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AwsClustersFutureStub(channel, callOptions);
        }
      };
    return AwsClustersFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The AwsClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on AWS infrastructure.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void createAwsCluster(com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAwsClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    default void updateAwsCluster(com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAwsClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * </pre>
     */
    default void getAwsCluster(com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsCluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAwsClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources
     * on a given Google Cloud project and region.
     * </pre>
     */
    default void listAwsClusters(com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAwsClustersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * Fails if the cluster has one or more associated
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void deleteAwsCluster(com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAwsClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    default void generateAwsClusterAgentToken(com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateAwsClusterAgentTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
     * </pre>
     */
    default void generateAwsAccessToken(com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateAwsAccessTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool],
     * attached to a given [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void createAwsNodePool(com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAwsNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
     * </pre>
     */
    default void updateAwsNodePool(com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAwsNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Rolls back a previously aborted or failed
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] update request.
     * Makes no changes if the last update request successfully finished.
     * If an update request is in progress, you cannot rollback the update.
     * You must first cancel or let it finish unsuccessfully before you can
     * rollback.
     * </pre>
     */
    default void rollbackAwsNodePoolUpdate(com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRollbackAwsNodePoolUpdateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Describes a specific
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
     * </pre>
     */
    default void getAwsNodePool(com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsNodePool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAwsNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resources on a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    default void listAwsNodePools(com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAwsNodePoolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void deleteAwsNodePool(com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAwsNodePoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the OIDC discovery document for the cluster.
     * See the
     * [OpenID Connect Discovery 1.0
     * specification](https://openid.net/specs/openid-connect-discovery-1_0.html)
     * for details.
     * </pre>
     */
    default void getAwsOpenIdConfig(com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAwsOpenIdConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * </pre>
     */
    default void getAwsJsonWebKeys(com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAwsJsonWebKeysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information, such as supported AWS regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    default void getAwsServerConfig(com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsServerConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAwsServerConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AwsClusters.
   * <pre>
   * The AwsClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on AWS infrastructure.
   * </pre>
   */
  public static abstract class AwsClustersImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AwsClustersGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AwsClusters.
   * <pre>
   * The AwsClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on AWS infrastructure.
   * </pre>
   */
  public static final class AwsClustersStub
      extends io.grpc.stub.AbstractAsyncStub<AwsClustersStub> {
    private AwsClustersStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwsClustersStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AwsClustersStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAwsCluster(com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAwsClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    public void updateAwsCluster(com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAwsClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * </pre>
     */
    public void getAwsCluster(com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsCluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAwsClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources
     * on a given Google Cloud project and region.
     * </pre>
     */
    public void listAwsClusters(com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAwsClustersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * Fails if the cluster has one or more associated
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAwsCluster(com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAwsClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    public void generateAwsClusterAgentToken(com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAwsClusterAgentTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
     * </pre>
     */
    public void generateAwsAccessToken(com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAwsAccessTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool],
     * attached to a given [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAwsNodePool(com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAwsNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
     * </pre>
     */
    public void updateAwsNodePool(com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAwsNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Rolls back a previously aborted or failed
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] update request.
     * Makes no changes if the last update request successfully finished.
     * If an update request is in progress, you cannot rollback the update.
     * You must first cancel or let it finish unsuccessfully before you can
     * rollback.
     * </pre>
     */
    public void rollbackAwsNodePoolUpdate(com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackAwsNodePoolUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Describes a specific
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
     * </pre>
     */
    public void getAwsNodePool(com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsNodePool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAwsNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resources on a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    public void listAwsNodePools(com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAwsNodePoolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAwsNodePool(com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAwsNodePoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the OIDC discovery document for the cluster.
     * See the
     * [OpenID Connect Discovery 1.0
     * specification](https://openid.net/specs/openid-connect-discovery-1_0.html)
     * for details.
     * </pre>
     */
    public void getAwsOpenIdConfig(com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAwsOpenIdConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * </pre>
     */
    public void getAwsJsonWebKeys(com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAwsJsonWebKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information, such as supported AWS regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public void getAwsServerConfig(com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsServerConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAwsServerConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AwsClusters.
   * <pre>
   * The AwsClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on AWS infrastructure.
   * </pre>
   */
  public static final class AwsClustersBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AwsClustersBlockingStub> {
    private AwsClustersBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwsClustersBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AwsClustersBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAwsCluster(com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAwsClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    public com.google.longrunning.Operation updateAwsCluster(com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAwsClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AwsCluster getAwsCluster(com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAwsClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources
     * on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse listAwsClusters(com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAwsClustersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * Fails if the cluster has one or more associated
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAwsCluster(com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAwsClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse generateAwsClusterAgentToken(com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAwsClusterAgentTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse generateAwsAccessToken(com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAwsAccessTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool],
     * attached to a given [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAwsNodePool(com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAwsNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
     * </pre>
     */
    public com.google.longrunning.Operation updateAwsNodePool(com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAwsNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Rolls back a previously aborted or failed
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] update request.
     * Makes no changes if the last update request successfully finished.
     * If an update request is in progress, you cannot rollback the update.
     * You must first cancel or let it finish unsuccessfully before you can
     * rollback.
     * </pre>
     */
    public com.google.longrunning.Operation rollbackAwsNodePoolUpdate(com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackAwsNodePoolUpdateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Describes a specific
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AwsNodePool getAwsNodePool(com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAwsNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resources on a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse listAwsNodePools(com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAwsNodePoolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAwsNodePool(com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAwsNodePoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the OIDC discovery document for the cluster.
     * See the
     * [OpenID Connect Discovery 1.0
     * specification](https://openid.net/specs/openid-connect-discovery-1_0.html)
     * for details.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig getAwsOpenIdConfig(com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAwsOpenIdConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys getAwsJsonWebKeys(com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAwsJsonWebKeysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information, such as supported AWS regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AwsServerConfig getAwsServerConfig(com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAwsServerConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AwsClusters.
   * <pre>
   * The AwsClusters API provides a single centrally managed service
   * to create and manage Anthos clusters that run on AWS infrastructure.
   * </pre>
   */
  public static final class AwsClustersFutureStub
      extends io.grpc.stub.AbstractFutureStub<AwsClustersFutureStub> {
    private AwsClustersFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwsClustersFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AwsClustersFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAwsCluster(
        com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAwsClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAwsCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAwsClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Describes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.AwsCluster> getAwsCluster(
        com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAwsClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resources
     * on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse> listAwsClusters(
        com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAwsClustersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a specific [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster]
     * resource.
     * Fails if the cluster has one or more associated
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resources.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAwsCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAwsClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse> generateAwsClusterAgentToken(
        com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAwsClusterAgentTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates a short-lived access token to authenticate to a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse> generateAwsAccessToken(
        com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAwsAccessTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool],
     * attached to a given [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAwsNodePool(
        com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAwsNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAwsNodePool(
        com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAwsNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Rolls back a previously aborted or failed
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] update request.
     * Makes no changes if the last update request successfully finished.
     * If an update request is in progress, you cannot rollback the update.
     * You must first cancel or let it finish unsuccessfully before you can
     * rollback.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> rollbackAwsNodePoolUpdate(
        com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackAwsNodePoolUpdateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Describes a specific
     * [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.AwsNodePool> getAwsNodePool(
        com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAwsNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resources on a given
     * [AwsCluster][google.cloud.gkemulticloud.v1.AwsCluster].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse> listAwsNodePools(
        com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAwsNodePoolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a specific [AwsNodePool][google.cloud.gkemulticloud.v1.AwsNodePool]
     * resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAwsNodePool(
        com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAwsNodePoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the OIDC discovery document for the cluster.
     * See the
     * [OpenID Connect Discovery 1.0
     * specification](https://openid.net/specs/openid-connect-discovery-1_0.html)
     * for details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig> getAwsOpenIdConfig(
        com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAwsOpenIdConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the public component of the cluster signing keys in
     * JSON Web Key format.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys> getAwsJsonWebKeys(
        com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAwsJsonWebKeysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information, such as supported AWS regions and Kubernetes
     * versions, on a given Google Cloud location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkemulticloud.v1.AwsServerConfig> getAwsServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAwsServerConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_AWS_CLUSTER = 0;
  private static final int METHODID_UPDATE_AWS_CLUSTER = 1;
  private static final int METHODID_GET_AWS_CLUSTER = 2;
  private static final int METHODID_LIST_AWS_CLUSTERS = 3;
  private static final int METHODID_DELETE_AWS_CLUSTER = 4;
  private static final int METHODID_GENERATE_AWS_CLUSTER_AGENT_TOKEN = 5;
  private static final int METHODID_GENERATE_AWS_ACCESS_TOKEN = 6;
  private static final int METHODID_CREATE_AWS_NODE_POOL = 7;
  private static final int METHODID_UPDATE_AWS_NODE_POOL = 8;
  private static final int METHODID_ROLLBACK_AWS_NODE_POOL_UPDATE = 9;
  private static final int METHODID_GET_AWS_NODE_POOL = 10;
  private static final int METHODID_LIST_AWS_NODE_POOLS = 11;
  private static final int METHODID_DELETE_AWS_NODE_POOL = 12;
  private static final int METHODID_GET_AWS_OPEN_ID_CONFIG = 13;
  private static final int METHODID_GET_AWS_JSON_WEB_KEYS = 14;
  private static final int METHODID_GET_AWS_SERVER_CONFIG = 15;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_CREATE_AWS_CLUSTER:
          serviceImpl.createAwsCluster((com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AWS_CLUSTER:
          serviceImpl.updateAwsCluster((com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AWS_CLUSTER:
          serviceImpl.getAwsCluster((com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsCluster>) responseObserver);
          break;
        case METHODID_LIST_AWS_CLUSTERS:
          serviceImpl.listAwsClusters((com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse>) responseObserver);
          break;
        case METHODID_DELETE_AWS_CLUSTER:
          serviceImpl.deleteAwsCluster((com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_AWS_CLUSTER_AGENT_TOKEN:
          serviceImpl.generateAwsClusterAgentToken((com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse>) responseObserver);
          break;
        case METHODID_GENERATE_AWS_ACCESS_TOKEN:
          serviceImpl.generateAwsAccessToken((com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse>) responseObserver);
          break;
        case METHODID_CREATE_AWS_NODE_POOL:
          serviceImpl.createAwsNodePool((com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_AWS_NODE_POOL:
          serviceImpl.updateAwsNodePool((com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ROLLBACK_AWS_NODE_POOL_UPDATE:
          serviceImpl.rollbackAwsNodePoolUpdate((com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AWS_NODE_POOL:
          serviceImpl.getAwsNodePool((com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsNodePool>) responseObserver);
          break;
        case METHODID_LIST_AWS_NODE_POOLS:
          serviceImpl.listAwsNodePools((com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse>) responseObserver);
          break;
        case METHODID_DELETE_AWS_NODE_POOL:
          serviceImpl.deleteAwsNodePool((com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_AWS_OPEN_ID_CONFIG:
          serviceImpl.getAwsOpenIdConfig((com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig>) responseObserver);
          break;
        case METHODID_GET_AWS_JSON_WEB_KEYS:
          serviceImpl.getAwsJsonWebKeys((com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys>) responseObserver);
          break;
        case METHODID_GET_AWS_SERVER_CONFIG:
          serviceImpl.getAwsServerConfig((com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AwsServerConfig>) responseObserver);
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
          getCreateAwsClusterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_AWS_CLUSTER)))
        .addMethod(
          getUpdateAwsClusterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_AWS_CLUSTER)))
        .addMethod(
          getGetAwsClusterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest,
              com.google.cloud.gkemulticloud.v1.AwsCluster>(
                service, METHODID_GET_AWS_CLUSTER)))
        .addMethod(
          getListAwsClustersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest,
              com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse>(
                service, METHODID_LIST_AWS_CLUSTERS)))
        .addMethod(
          getDeleteAwsClusterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_AWS_CLUSTER)))
        .addMethod(
          getGenerateAwsClusterAgentTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest,
              com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse>(
                service, METHODID_GENERATE_AWS_CLUSTER_AGENT_TOKEN)))
        .addMethod(
          getGenerateAwsAccessTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest,
              com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse>(
                service, METHODID_GENERATE_AWS_ACCESS_TOKEN)))
        .addMethod(
          getCreateAwsNodePoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_AWS_NODE_POOL)))
        .addMethod(
          getUpdateAwsNodePoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_AWS_NODE_POOL)))
        .addMethod(
          getRollbackAwsNodePoolUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest,
              com.google.longrunning.Operation>(
                service, METHODID_ROLLBACK_AWS_NODE_POOL_UPDATE)))
        .addMethod(
          getGetAwsNodePoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest,
              com.google.cloud.gkemulticloud.v1.AwsNodePool>(
                service, METHODID_GET_AWS_NODE_POOL)))
        .addMethod(
          getListAwsNodePoolsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest,
              com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse>(
                service, METHODID_LIST_AWS_NODE_POOLS)))
        .addMethod(
          getDeleteAwsNodePoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_AWS_NODE_POOL)))
        .addMethod(
          getGetAwsOpenIdConfigMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest,
              com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig>(
                service, METHODID_GET_AWS_OPEN_ID_CONFIG)))
        .addMethod(
          getGetAwsJsonWebKeysMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest,
              com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys>(
                service, METHODID_GET_AWS_JSON_WEB_KEYS)))
        .addMethod(
          getGetAwsServerConfigMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest,
              com.google.cloud.gkemulticloud.v1.AwsServerConfig>(
                service, METHODID_GET_AWS_SERVER_CONFIG)))
        .build();
  }

  private static abstract class AwsClustersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AwsClustersBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkemulticloud.v1.AwsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AwsClusters");
    }
  }

  private static final class AwsClustersFileDescriptorSupplier
      extends AwsClustersBaseDescriptorSupplier {
    AwsClustersFileDescriptorSupplier() {}
  }

  private static final class AwsClustersMethodDescriptorSupplier
      extends AwsClustersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AwsClustersMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AwsClustersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AwsClustersFileDescriptorSupplier())
              .addMethod(getCreateAwsClusterMethod())
              .addMethod(getUpdateAwsClusterMethod())
              .addMethod(getGetAwsClusterMethod())
              .addMethod(getListAwsClustersMethod())
              .addMethod(getDeleteAwsClusterMethod())
              .addMethod(getGenerateAwsClusterAgentTokenMethod())
              .addMethod(getGenerateAwsAccessTokenMethod())
              .addMethod(getCreateAwsNodePoolMethod())
              .addMethod(getUpdateAwsNodePoolMethod())
              .addMethod(getRollbackAwsNodePoolUpdateMethod())
              .addMethod(getGetAwsNodePoolMethod())
              .addMethod(getListAwsNodePoolsMethod())
              .addMethod(getDeleteAwsNodePoolMethod())
              .addMethod(getGetAwsOpenIdConfigMethod())
              .addMethod(getGetAwsJsonWebKeysMethod())
              .addMethod(getGetAwsServerConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
