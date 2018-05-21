package com.google.container.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Google Container Engine Cluster Manager v1
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/container/v1/cluster_service.proto")
public final class ClusterManagerGrpc {

  private ClusterManagerGrpc() {}

  public static final String SERVICE_NAME = "google.container.v1.ClusterManager";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListClustersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.ListClustersRequest,
      com.google.container.v1.ListClustersResponse> METHOD_LIST_CLUSTERS = getListClustersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.ListClustersRequest,
      com.google.container.v1.ListClustersResponse> getListClustersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.ListClustersRequest,
      com.google.container.v1.ListClustersResponse> getListClustersMethod() {
    return getListClustersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.ListClustersRequest,
      com.google.container.v1.ListClustersResponse> getListClustersMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.ListClustersRequest, com.google.container.v1.ListClustersResponse> getListClustersMethod;
    if ((getListClustersMethod = ClusterManagerGrpc.getListClustersMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListClustersMethod = ClusterManagerGrpc.getListClustersMethod) == null) {
          ClusterManagerGrpc.getListClustersMethod = getListClustersMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.ListClustersRequest, com.google.container.v1.ListClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "ListClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ListClustersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("ListClusters"))
                  .build();
          }
        }
     }
     return getListClustersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.GetClusterRequest,
      com.google.container.v1.Cluster> METHOD_GET_CLUSTER = getGetClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.GetClusterRequest,
      com.google.container.v1.Cluster> getGetClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.GetClusterRequest,
      com.google.container.v1.Cluster> getGetClusterMethod() {
    return getGetClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.GetClusterRequest,
      com.google.container.v1.Cluster> getGetClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster> getGetClusterMethod;
    if ((getGetClusterMethod = ClusterManagerGrpc.getGetClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetClusterMethod = ClusterManagerGrpc.getGetClusterMethod) == null) {
          ClusterManagerGrpc.getGetClusterMethod = getGetClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.GetClusterRequest, com.google.container.v1.Cluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "GetCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.GetClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Cluster.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("GetCluster"))
                  .build();
          }
        }
     }
     return getGetClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.CreateClusterRequest,
      com.google.container.v1.Operation> METHOD_CREATE_CLUSTER = getCreateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.CreateClusterRequest,
      com.google.container.v1.Operation> getCreateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.CreateClusterRequest,
      com.google.container.v1.Operation> getCreateClusterMethod() {
    return getCreateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.CreateClusterRequest,
      com.google.container.v1.Operation> getCreateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.CreateClusterRequest, com.google.container.v1.Operation> getCreateClusterMethod;
    if ((getCreateClusterMethod = ClusterManagerGrpc.getCreateClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCreateClusterMethod = ClusterManagerGrpc.getCreateClusterMethod) == null) {
          ClusterManagerGrpc.getCreateClusterMethod = getCreateClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.CreateClusterRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "CreateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("CreateCluster"))
                  .build();
          }
        }
     }
     return getCreateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.UpdateClusterRequest,
      com.google.container.v1.Operation> METHOD_UPDATE_CLUSTER = getUpdateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.UpdateClusterRequest,
      com.google.container.v1.Operation> getUpdateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.UpdateClusterRequest,
      com.google.container.v1.Operation> getUpdateClusterMethod() {
    return getUpdateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.UpdateClusterRequest,
      com.google.container.v1.Operation> getUpdateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.UpdateClusterRequest, com.google.container.v1.Operation> getUpdateClusterMethod;
    if ((getUpdateClusterMethod = ClusterManagerGrpc.getUpdateClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getUpdateClusterMethod = ClusterManagerGrpc.getUpdateClusterMethod) == null) {
          ClusterManagerGrpc.getUpdateClusterMethod = getUpdateClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.UpdateClusterRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "UpdateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("UpdateCluster"))
                  .build();
          }
        }
     }
     return getUpdateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateNodePoolMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.UpdateNodePoolRequest,
      com.google.container.v1.Operation> METHOD_UPDATE_NODE_POOL = getUpdateNodePoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.UpdateNodePoolRequest,
      com.google.container.v1.Operation> getUpdateNodePoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.UpdateNodePoolRequest,
      com.google.container.v1.Operation> getUpdateNodePoolMethod() {
    return getUpdateNodePoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.UpdateNodePoolRequest,
      com.google.container.v1.Operation> getUpdateNodePoolMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.UpdateNodePoolRequest, com.google.container.v1.Operation> getUpdateNodePoolMethod;
    if ((getUpdateNodePoolMethod = ClusterManagerGrpc.getUpdateNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getUpdateNodePoolMethod = ClusterManagerGrpc.getUpdateNodePoolMethod) == null) {
          ClusterManagerGrpc.getUpdateNodePoolMethod = getUpdateNodePoolMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.UpdateNodePoolRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "UpdateNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.UpdateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("UpdateNodePool"))
                  .build();
          }
        }
     }
     return getUpdateNodePoolMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetNodePoolAutoscalingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolAutoscalingRequest,
      com.google.container.v1.Operation> METHOD_SET_NODE_POOL_AUTOSCALING = getSetNodePoolAutoscalingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolAutoscalingRequest,
      com.google.container.v1.Operation> getSetNodePoolAutoscalingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolAutoscalingRequest,
      com.google.container.v1.Operation> getSetNodePoolAutoscalingMethod() {
    return getSetNodePoolAutoscalingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolAutoscalingRequest,
      com.google.container.v1.Operation> getSetNodePoolAutoscalingMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolAutoscalingRequest, com.google.container.v1.Operation> getSetNodePoolAutoscalingMethod;
    if ((getSetNodePoolAutoscalingMethod = ClusterManagerGrpc.getSetNodePoolAutoscalingMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNodePoolAutoscalingMethod = ClusterManagerGrpc.getSetNodePoolAutoscalingMethod) == null) {
          ClusterManagerGrpc.getSetNodePoolAutoscalingMethod = getSetNodePoolAutoscalingMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetNodePoolAutoscalingRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetNodePoolAutoscaling"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetNodePoolAutoscalingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetNodePoolAutoscaling"))
                  .build();
          }
        }
     }
     return getSetNodePoolAutoscalingMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetLoggingServiceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetLoggingServiceRequest,
      com.google.container.v1.Operation> METHOD_SET_LOGGING_SERVICE = getSetLoggingServiceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetLoggingServiceRequest,
      com.google.container.v1.Operation> getSetLoggingServiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetLoggingServiceRequest,
      com.google.container.v1.Operation> getSetLoggingServiceMethod() {
    return getSetLoggingServiceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetLoggingServiceRequest,
      com.google.container.v1.Operation> getSetLoggingServiceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetLoggingServiceRequest, com.google.container.v1.Operation> getSetLoggingServiceMethod;
    if ((getSetLoggingServiceMethod = ClusterManagerGrpc.getSetLoggingServiceMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLoggingServiceMethod = ClusterManagerGrpc.getSetLoggingServiceMethod) == null) {
          ClusterManagerGrpc.getSetLoggingServiceMethod = getSetLoggingServiceMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetLoggingServiceRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetLoggingService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetLoggingServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetLoggingService"))
                  .build();
          }
        }
     }
     return getSetLoggingServiceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetMonitoringServiceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetMonitoringServiceRequest,
      com.google.container.v1.Operation> METHOD_SET_MONITORING_SERVICE = getSetMonitoringServiceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetMonitoringServiceRequest,
      com.google.container.v1.Operation> getSetMonitoringServiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetMonitoringServiceRequest,
      com.google.container.v1.Operation> getSetMonitoringServiceMethod() {
    return getSetMonitoringServiceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetMonitoringServiceRequest,
      com.google.container.v1.Operation> getSetMonitoringServiceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetMonitoringServiceRequest, com.google.container.v1.Operation> getSetMonitoringServiceMethod;
    if ((getSetMonitoringServiceMethod = ClusterManagerGrpc.getSetMonitoringServiceMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetMonitoringServiceMethod = ClusterManagerGrpc.getSetMonitoringServiceMethod) == null) {
          ClusterManagerGrpc.getSetMonitoringServiceMethod = getSetMonitoringServiceMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetMonitoringServiceRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetMonitoringService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetMonitoringServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetMonitoringService"))
                  .build();
          }
        }
     }
     return getSetMonitoringServiceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetAddonsConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetAddonsConfigRequest,
      com.google.container.v1.Operation> METHOD_SET_ADDONS_CONFIG = getSetAddonsConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetAddonsConfigRequest,
      com.google.container.v1.Operation> getSetAddonsConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetAddonsConfigRequest,
      com.google.container.v1.Operation> getSetAddonsConfigMethod() {
    return getSetAddonsConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetAddonsConfigRequest,
      com.google.container.v1.Operation> getSetAddonsConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetAddonsConfigRequest, com.google.container.v1.Operation> getSetAddonsConfigMethod;
    if ((getSetAddonsConfigMethod = ClusterManagerGrpc.getSetAddonsConfigMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetAddonsConfigMethod = ClusterManagerGrpc.getSetAddonsConfigMethod) == null) {
          ClusterManagerGrpc.getSetAddonsConfigMethod = getSetAddonsConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetAddonsConfigRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetAddonsConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetAddonsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetAddonsConfig"))
                  .build();
          }
        }
     }
     return getSetAddonsConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetLocationsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetLocationsRequest,
      com.google.container.v1.Operation> METHOD_SET_LOCATIONS = getSetLocationsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetLocationsRequest,
      com.google.container.v1.Operation> getSetLocationsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetLocationsRequest,
      com.google.container.v1.Operation> getSetLocationsMethod() {
    return getSetLocationsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetLocationsRequest,
      com.google.container.v1.Operation> getSetLocationsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetLocationsRequest, com.google.container.v1.Operation> getSetLocationsMethod;
    if ((getSetLocationsMethod = ClusterManagerGrpc.getSetLocationsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLocationsMethod = ClusterManagerGrpc.getSetLocationsMethod) == null) {
          ClusterManagerGrpc.getSetLocationsMethod = getSetLocationsMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetLocationsRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetLocations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetLocations"))
                  .build();
          }
        }
     }
     return getSetLocationsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateMasterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.UpdateMasterRequest,
      com.google.container.v1.Operation> METHOD_UPDATE_MASTER = getUpdateMasterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.UpdateMasterRequest,
      com.google.container.v1.Operation> getUpdateMasterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.UpdateMasterRequest,
      com.google.container.v1.Operation> getUpdateMasterMethod() {
    return getUpdateMasterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.UpdateMasterRequest,
      com.google.container.v1.Operation> getUpdateMasterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.UpdateMasterRequest, com.google.container.v1.Operation> getUpdateMasterMethod;
    if ((getUpdateMasterMethod = ClusterManagerGrpc.getUpdateMasterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getUpdateMasterMethod = ClusterManagerGrpc.getUpdateMasterMethod) == null) {
          ClusterManagerGrpc.getUpdateMasterMethod = getUpdateMasterMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.UpdateMasterRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "UpdateMaster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.UpdateMasterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("UpdateMaster"))
                  .build();
          }
        }
     }
     return getUpdateMasterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetMasterAuthMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetMasterAuthRequest,
      com.google.container.v1.Operation> METHOD_SET_MASTER_AUTH = getSetMasterAuthMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetMasterAuthRequest,
      com.google.container.v1.Operation> getSetMasterAuthMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetMasterAuthRequest,
      com.google.container.v1.Operation> getSetMasterAuthMethod() {
    return getSetMasterAuthMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetMasterAuthRequest,
      com.google.container.v1.Operation> getSetMasterAuthMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetMasterAuthRequest, com.google.container.v1.Operation> getSetMasterAuthMethod;
    if ((getSetMasterAuthMethod = ClusterManagerGrpc.getSetMasterAuthMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetMasterAuthMethod = ClusterManagerGrpc.getSetMasterAuthMethod) == null) {
          ClusterManagerGrpc.getSetMasterAuthMethod = getSetMasterAuthMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetMasterAuthRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetMasterAuth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetMasterAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetMasterAuth"))
                  .build();
          }
        }
     }
     return getSetMasterAuthMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.DeleteClusterRequest,
      com.google.container.v1.Operation> METHOD_DELETE_CLUSTER = getDeleteClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.DeleteClusterRequest,
      com.google.container.v1.Operation> getDeleteClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.DeleteClusterRequest,
      com.google.container.v1.Operation> getDeleteClusterMethod() {
    return getDeleteClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.DeleteClusterRequest,
      com.google.container.v1.Operation> getDeleteClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.DeleteClusterRequest, com.google.container.v1.Operation> getDeleteClusterMethod;
    if ((getDeleteClusterMethod = ClusterManagerGrpc.getDeleteClusterMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getDeleteClusterMethod = ClusterManagerGrpc.getDeleteClusterMethod) == null) {
          ClusterManagerGrpc.getDeleteClusterMethod = getDeleteClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.DeleteClusterRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "DeleteCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("DeleteCluster"))
                  .build();
          }
        }
     }
     return getDeleteClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListOperationsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.ListOperationsRequest,
      com.google.container.v1.ListOperationsResponse> METHOD_LIST_OPERATIONS = getListOperationsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.ListOperationsRequest,
      com.google.container.v1.ListOperationsResponse> getListOperationsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.ListOperationsRequest,
      com.google.container.v1.ListOperationsResponse> getListOperationsMethod() {
    return getListOperationsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.ListOperationsRequest,
      com.google.container.v1.ListOperationsResponse> getListOperationsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.ListOperationsRequest, com.google.container.v1.ListOperationsResponse> getListOperationsMethod;
    if ((getListOperationsMethod = ClusterManagerGrpc.getListOperationsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListOperationsMethod = ClusterManagerGrpc.getListOperationsMethod) == null) {
          ClusterManagerGrpc.getListOperationsMethod = getListOperationsMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.ListOperationsRequest, com.google.container.v1.ListOperationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "ListOperations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ListOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ListOperationsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("ListOperations"))
                  .build();
          }
        }
     }
     return getListOperationsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOperationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.GetOperationRequest,
      com.google.container.v1.Operation> METHOD_GET_OPERATION = getGetOperationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.GetOperationRequest,
      com.google.container.v1.Operation> getGetOperationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.GetOperationRequest,
      com.google.container.v1.Operation> getGetOperationMethod() {
    return getGetOperationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.GetOperationRequest,
      com.google.container.v1.Operation> getGetOperationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.GetOperationRequest, com.google.container.v1.Operation> getGetOperationMethod;
    if ((getGetOperationMethod = ClusterManagerGrpc.getGetOperationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetOperationMethod = ClusterManagerGrpc.getGetOperationMethod) == null) {
          ClusterManagerGrpc.getGetOperationMethod = getGetOperationMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.GetOperationRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "GetOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.GetOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("GetOperation"))
                  .build();
          }
        }
     }
     return getGetOperationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCancelOperationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.CancelOperationRequest,
      com.google.protobuf.Empty> METHOD_CANCEL_OPERATION = getCancelOperationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.CancelOperationRequest,
      com.google.protobuf.Empty> getCancelOperationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.CancelOperationRequest,
      com.google.protobuf.Empty> getCancelOperationMethod() {
    return getCancelOperationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.CancelOperationRequest,
      com.google.protobuf.Empty> getCancelOperationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty> getCancelOperationMethod;
    if ((getCancelOperationMethod = ClusterManagerGrpc.getCancelOperationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCancelOperationMethod = ClusterManagerGrpc.getCancelOperationMethod) == null) {
          ClusterManagerGrpc.getCancelOperationMethod = getCancelOperationMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.CancelOperationRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "CancelOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.CancelOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("CancelOperation"))
                  .build();
          }
        }
     }
     return getCancelOperationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetServerConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.GetServerConfigRequest,
      com.google.container.v1.ServerConfig> METHOD_GET_SERVER_CONFIG = getGetServerConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.GetServerConfigRequest,
      com.google.container.v1.ServerConfig> getGetServerConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.GetServerConfigRequest,
      com.google.container.v1.ServerConfig> getGetServerConfigMethod() {
    return getGetServerConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.GetServerConfigRequest,
      com.google.container.v1.ServerConfig> getGetServerConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.GetServerConfigRequest, com.google.container.v1.ServerConfig> getGetServerConfigMethod;
    if ((getGetServerConfigMethod = ClusterManagerGrpc.getGetServerConfigMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetServerConfigMethod = ClusterManagerGrpc.getGetServerConfigMethod) == null) {
          ClusterManagerGrpc.getGetServerConfigMethod = getGetServerConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.GetServerConfigRequest, com.google.container.v1.ServerConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "GetServerConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.GetServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ServerConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("GetServerConfig"))
                  .build();
          }
        }
     }
     return getGetServerConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNodePoolsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.ListNodePoolsRequest,
      com.google.container.v1.ListNodePoolsResponse> METHOD_LIST_NODE_POOLS = getListNodePoolsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.ListNodePoolsRequest,
      com.google.container.v1.ListNodePoolsResponse> getListNodePoolsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.ListNodePoolsRequest,
      com.google.container.v1.ListNodePoolsResponse> getListNodePoolsMethod() {
    return getListNodePoolsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.ListNodePoolsRequest,
      com.google.container.v1.ListNodePoolsResponse> getListNodePoolsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.ListNodePoolsRequest, com.google.container.v1.ListNodePoolsResponse> getListNodePoolsMethod;
    if ((getListNodePoolsMethod = ClusterManagerGrpc.getListNodePoolsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getListNodePoolsMethod = ClusterManagerGrpc.getListNodePoolsMethod) == null) {
          ClusterManagerGrpc.getListNodePoolsMethod = getListNodePoolsMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.ListNodePoolsRequest, com.google.container.v1.ListNodePoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "ListNodePools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ListNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.ListNodePoolsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("ListNodePools"))
                  .build();
          }
        }
     }
     return getListNodePoolsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNodePoolMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.GetNodePoolRequest,
      com.google.container.v1.NodePool> METHOD_GET_NODE_POOL = getGetNodePoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.GetNodePoolRequest,
      com.google.container.v1.NodePool> getGetNodePoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.GetNodePoolRequest,
      com.google.container.v1.NodePool> getGetNodePoolMethod() {
    return getGetNodePoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.GetNodePoolRequest,
      com.google.container.v1.NodePool> getGetNodePoolMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.GetNodePoolRequest, com.google.container.v1.NodePool> getGetNodePoolMethod;
    if ((getGetNodePoolMethod = ClusterManagerGrpc.getGetNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getGetNodePoolMethod = ClusterManagerGrpc.getGetNodePoolMethod) == null) {
          ClusterManagerGrpc.getGetNodePoolMethod = getGetNodePoolMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.GetNodePoolRequest, com.google.container.v1.NodePool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "GetNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.GetNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.NodePool.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("GetNodePool"))
                  .build();
          }
        }
     }
     return getGetNodePoolMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateNodePoolMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.CreateNodePoolRequest,
      com.google.container.v1.Operation> METHOD_CREATE_NODE_POOL = getCreateNodePoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.CreateNodePoolRequest,
      com.google.container.v1.Operation> getCreateNodePoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.CreateNodePoolRequest,
      com.google.container.v1.Operation> getCreateNodePoolMethod() {
    return getCreateNodePoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.CreateNodePoolRequest,
      com.google.container.v1.Operation> getCreateNodePoolMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.CreateNodePoolRequest, com.google.container.v1.Operation> getCreateNodePoolMethod;
    if ((getCreateNodePoolMethod = ClusterManagerGrpc.getCreateNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCreateNodePoolMethod = ClusterManagerGrpc.getCreateNodePoolMethod) == null) {
          ClusterManagerGrpc.getCreateNodePoolMethod = getCreateNodePoolMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.CreateNodePoolRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "CreateNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.CreateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("CreateNodePool"))
                  .build();
          }
        }
     }
     return getCreateNodePoolMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteNodePoolMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.DeleteNodePoolRequest,
      com.google.container.v1.Operation> METHOD_DELETE_NODE_POOL = getDeleteNodePoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.DeleteNodePoolRequest,
      com.google.container.v1.Operation> getDeleteNodePoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.DeleteNodePoolRequest,
      com.google.container.v1.Operation> getDeleteNodePoolMethod() {
    return getDeleteNodePoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.DeleteNodePoolRequest,
      com.google.container.v1.Operation> getDeleteNodePoolMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.DeleteNodePoolRequest, com.google.container.v1.Operation> getDeleteNodePoolMethod;
    if ((getDeleteNodePoolMethod = ClusterManagerGrpc.getDeleteNodePoolMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getDeleteNodePoolMethod = ClusterManagerGrpc.getDeleteNodePoolMethod) == null) {
          ClusterManagerGrpc.getDeleteNodePoolMethod = getDeleteNodePoolMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.DeleteNodePoolRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "DeleteNodePool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.DeleteNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("DeleteNodePool"))
                  .build();
          }
        }
     }
     return getDeleteNodePoolMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRollbackNodePoolUpgradeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.RollbackNodePoolUpgradeRequest,
      com.google.container.v1.Operation> METHOD_ROLLBACK_NODE_POOL_UPGRADE = getRollbackNodePoolUpgradeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.RollbackNodePoolUpgradeRequest,
      com.google.container.v1.Operation> getRollbackNodePoolUpgradeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.RollbackNodePoolUpgradeRequest,
      com.google.container.v1.Operation> getRollbackNodePoolUpgradeMethod() {
    return getRollbackNodePoolUpgradeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.RollbackNodePoolUpgradeRequest,
      com.google.container.v1.Operation> getRollbackNodePoolUpgradeMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.RollbackNodePoolUpgradeRequest, com.google.container.v1.Operation> getRollbackNodePoolUpgradeMethod;
    if ((getRollbackNodePoolUpgradeMethod = ClusterManagerGrpc.getRollbackNodePoolUpgradeMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getRollbackNodePoolUpgradeMethod = ClusterManagerGrpc.getRollbackNodePoolUpgradeMethod) == null) {
          ClusterManagerGrpc.getRollbackNodePoolUpgradeMethod = getRollbackNodePoolUpgradeMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.RollbackNodePoolUpgradeRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "RollbackNodePoolUpgrade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.RollbackNodePoolUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("RollbackNodePoolUpgrade"))
                  .build();
          }
        }
     }
     return getRollbackNodePoolUpgradeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetNodePoolManagementMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolManagementRequest,
      com.google.container.v1.Operation> METHOD_SET_NODE_POOL_MANAGEMENT = getSetNodePoolManagementMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolManagementRequest,
      com.google.container.v1.Operation> getSetNodePoolManagementMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolManagementRequest,
      com.google.container.v1.Operation> getSetNodePoolManagementMethod() {
    return getSetNodePoolManagementMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolManagementRequest,
      com.google.container.v1.Operation> getSetNodePoolManagementMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolManagementRequest, com.google.container.v1.Operation> getSetNodePoolManagementMethod;
    if ((getSetNodePoolManagementMethod = ClusterManagerGrpc.getSetNodePoolManagementMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNodePoolManagementMethod = ClusterManagerGrpc.getSetNodePoolManagementMethod) == null) {
          ClusterManagerGrpc.getSetNodePoolManagementMethod = getSetNodePoolManagementMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetNodePoolManagementRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetNodePoolManagement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetNodePoolManagementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetNodePoolManagement"))
                  .build();
          }
        }
     }
     return getSetNodePoolManagementMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetLabelsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetLabelsRequest,
      com.google.container.v1.Operation> METHOD_SET_LABELS = getSetLabelsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetLabelsRequest,
      com.google.container.v1.Operation> getSetLabelsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetLabelsRequest,
      com.google.container.v1.Operation> getSetLabelsMethod() {
    return getSetLabelsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetLabelsRequest,
      com.google.container.v1.Operation> getSetLabelsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation> getSetLabelsMethod;
    if ((getSetLabelsMethod = ClusterManagerGrpc.getSetLabelsMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLabelsMethod = ClusterManagerGrpc.getSetLabelsMethod) == null) {
          ClusterManagerGrpc.getSetLabelsMethod = getSetLabelsMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetLabelsRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetLabels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetLabels"))
                  .build();
          }
        }
     }
     return getSetLabelsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetLegacyAbacMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetLegacyAbacRequest,
      com.google.container.v1.Operation> METHOD_SET_LEGACY_ABAC = getSetLegacyAbacMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetLegacyAbacRequest,
      com.google.container.v1.Operation> getSetLegacyAbacMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetLegacyAbacRequest,
      com.google.container.v1.Operation> getSetLegacyAbacMethod() {
    return getSetLegacyAbacMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetLegacyAbacRequest,
      com.google.container.v1.Operation> getSetLegacyAbacMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetLegacyAbacRequest, com.google.container.v1.Operation> getSetLegacyAbacMethod;
    if ((getSetLegacyAbacMethod = ClusterManagerGrpc.getSetLegacyAbacMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetLegacyAbacMethod = ClusterManagerGrpc.getSetLegacyAbacMethod) == null) {
          ClusterManagerGrpc.getSetLegacyAbacMethod = getSetLegacyAbacMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetLegacyAbacRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetLegacyAbac"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetLegacyAbacRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetLegacyAbac"))
                  .build();
          }
        }
     }
     return getSetLegacyAbacMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStartIPRotationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.StartIPRotationRequest,
      com.google.container.v1.Operation> METHOD_START_IPROTATION = getStartIPRotationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.StartIPRotationRequest,
      com.google.container.v1.Operation> getStartIPRotationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.StartIPRotationRequest,
      com.google.container.v1.Operation> getStartIPRotationMethod() {
    return getStartIPRotationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.StartIPRotationRequest,
      com.google.container.v1.Operation> getStartIPRotationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.StartIPRotationRequest, com.google.container.v1.Operation> getStartIPRotationMethod;
    if ((getStartIPRotationMethod = ClusterManagerGrpc.getStartIPRotationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getStartIPRotationMethod = ClusterManagerGrpc.getStartIPRotationMethod) == null) {
          ClusterManagerGrpc.getStartIPRotationMethod = getStartIPRotationMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.StartIPRotationRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "StartIPRotation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.StartIPRotationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("StartIPRotation"))
                  .build();
          }
        }
     }
     return getStartIPRotationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCompleteIPRotationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.CompleteIPRotationRequest,
      com.google.container.v1.Operation> METHOD_COMPLETE_IPROTATION = getCompleteIPRotationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.CompleteIPRotationRequest,
      com.google.container.v1.Operation> getCompleteIPRotationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.CompleteIPRotationRequest,
      com.google.container.v1.Operation> getCompleteIPRotationMethod() {
    return getCompleteIPRotationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.CompleteIPRotationRequest,
      com.google.container.v1.Operation> getCompleteIPRotationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.CompleteIPRotationRequest, com.google.container.v1.Operation> getCompleteIPRotationMethod;
    if ((getCompleteIPRotationMethod = ClusterManagerGrpc.getCompleteIPRotationMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getCompleteIPRotationMethod = ClusterManagerGrpc.getCompleteIPRotationMethod) == null) {
          ClusterManagerGrpc.getCompleteIPRotationMethod = getCompleteIPRotationMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.CompleteIPRotationRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "CompleteIPRotation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.CompleteIPRotationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("CompleteIPRotation"))
                  .build();
          }
        }
     }
     return getCompleteIPRotationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetNodePoolSizeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolSizeRequest,
      com.google.container.v1.Operation> METHOD_SET_NODE_POOL_SIZE = getSetNodePoolSizeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolSizeRequest,
      com.google.container.v1.Operation> getSetNodePoolSizeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolSizeRequest,
      com.google.container.v1.Operation> getSetNodePoolSizeMethod() {
    return getSetNodePoolSizeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolSizeRequest,
      com.google.container.v1.Operation> getSetNodePoolSizeMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetNodePoolSizeRequest, com.google.container.v1.Operation> getSetNodePoolSizeMethod;
    if ((getSetNodePoolSizeMethod = ClusterManagerGrpc.getSetNodePoolSizeMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNodePoolSizeMethod = ClusterManagerGrpc.getSetNodePoolSizeMethod) == null) {
          ClusterManagerGrpc.getSetNodePoolSizeMethod = getSetNodePoolSizeMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetNodePoolSizeRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetNodePoolSize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetNodePoolSizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetNodePoolSize"))
                  .build();
          }
        }
     }
     return getSetNodePoolSizeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetNetworkPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetNetworkPolicyRequest,
      com.google.container.v1.Operation> METHOD_SET_NETWORK_POLICY = getSetNetworkPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetNetworkPolicyRequest,
      com.google.container.v1.Operation> getSetNetworkPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetNetworkPolicyRequest,
      com.google.container.v1.Operation> getSetNetworkPolicyMethod() {
    return getSetNetworkPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetNetworkPolicyRequest,
      com.google.container.v1.Operation> getSetNetworkPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetNetworkPolicyRequest, com.google.container.v1.Operation> getSetNetworkPolicyMethod;
    if ((getSetNetworkPolicyMethod = ClusterManagerGrpc.getSetNetworkPolicyMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetNetworkPolicyMethod = ClusterManagerGrpc.getSetNetworkPolicyMethod) == null) {
          ClusterManagerGrpc.getSetNetworkPolicyMethod = getSetNetworkPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetNetworkPolicyRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetNetworkPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetNetworkPolicy"))
                  .build();
          }
        }
     }
     return getSetNetworkPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetMaintenancePolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.container.v1.SetMaintenancePolicyRequest,
      com.google.container.v1.Operation> METHOD_SET_MAINTENANCE_POLICY = getSetMaintenancePolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.container.v1.SetMaintenancePolicyRequest,
      com.google.container.v1.Operation> getSetMaintenancePolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.container.v1.SetMaintenancePolicyRequest,
      com.google.container.v1.Operation> getSetMaintenancePolicyMethod() {
    return getSetMaintenancePolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.container.v1.SetMaintenancePolicyRequest,
      com.google.container.v1.Operation> getSetMaintenancePolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.container.v1.SetMaintenancePolicyRequest, com.google.container.v1.Operation> getSetMaintenancePolicyMethod;
    if ((getSetMaintenancePolicyMethod = ClusterManagerGrpc.getSetMaintenancePolicyMethod) == null) {
      synchronized (ClusterManagerGrpc.class) {
        if ((getSetMaintenancePolicyMethod = ClusterManagerGrpc.getSetMaintenancePolicyMethod) == null) {
          ClusterManagerGrpc.getSetMaintenancePolicyMethod = getSetMaintenancePolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.container.v1.SetMaintenancePolicyRequest, com.google.container.v1.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.container.v1.ClusterManager", "SetMaintenancePolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.SetMaintenancePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.container.v1.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterManagerMethodDescriptorSupplier("SetMaintenancePolicy"))
                  .build();
          }
        }
     }
     return getSetMaintenancePolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClusterManagerStub newStub(io.grpc.Channel channel) {
    return new ClusterManagerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClusterManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClusterManagerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClusterManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClusterManagerFutureStub(channel);
  }

  /**
   * <pre>
   * Google Container Engine Cluster Manager v1
   * </pre>
   */
  public static abstract class ClusterManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public void listClusters(com.google.container.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListClustersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListClustersMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public void getCluster(com.google.container.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Cluster> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the cluster creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range is being used by the cluster.
     * </pre>
     */
    public void createCluster(com.google.container.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public void updateCluster(com.google.container.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the version and/or image type of a specific node pool.
     * </pre>
     */
    public void updateNodePool(com.google.container.v1.UpdateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateNodePoolMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the autoscaling settings of a specific node pool.
     * </pre>
     */
    public void setNodePoolAutoscaling(com.google.container.v1.SetNodePoolAutoscalingRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetNodePoolAutoscalingMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the logging service of a specific cluster.
     * </pre>
     */
    public void setLoggingService(com.google.container.v1.SetLoggingServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLoggingServiceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the monitoring service of a specific cluster.
     * </pre>
     */
    public void setMonitoringService(com.google.container.v1.SetMonitoringServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetMonitoringServiceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the addons of a specific cluster.
     * </pre>
     */
    public void setAddonsConfig(com.google.container.v1.SetAddonsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetAddonsConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the locations of a specific cluster.
     * </pre>
     */
    public void setLocations(com.google.container.v1.SetLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLocationsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the master of a specific cluster.
     * </pre>
     */
    public void updateMaster(com.google.container.v1.UpdateMasterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMasterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Used to set master auth materials. Currently supports :-
     * Changing the admin password of a specific cluster.
     * This can be either via password generation or explicitly set the password.
     * </pre>
     */
    public void setMasterAuth(com.google.container.v1.SetMasterAuthRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetMasterAuthMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster
     * (e.g. load balancer resources) will not be deleted if they weren't present
     * at the initial create time.
     * </pre>
     */
    public void deleteCluster(com.google.container.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public void listOperations(com.google.container.v1.ListOperationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListOperationsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListOperationsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public void getOperation(com.google.container.v1.GetOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOperationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public void cancelOperation(com.google.container.v1.CancelOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelOperationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns configuration info about the Container Engine service.
     * </pre>
     */
    public void getServerConfig(com.google.container.v1.GetServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ServerConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServerConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public void listNodePools(com.google.container.v1.ListNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListNodePoolsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNodePoolsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the node pool requested.
     * </pre>
     */
    public void getNodePool(com.google.container.v1.GetNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.NodePool> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNodePoolMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public void createNodePool(com.google.container.v1.CreateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNodePoolMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public void deleteNodePool(com.google.container.v1.DeleteNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteNodePoolMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Roll back the previously Aborted or Failed NodePool upgrade.
     * This will be an no-op if the last upgrade successfully completed.
     * </pre>
     */
    public void rollbackNodePoolUpgrade(com.google.container.v1.RollbackNodePoolUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getRollbackNodePoolUpgradeMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public void setNodePoolManagement(com.google.container.v1.SetNodePoolManagementRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetNodePoolManagementMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public void setLabels(com.google.container.v1.SetLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLabelsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public void setLegacyAbac(com.google.container.v1.SetLegacyAbacRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLegacyAbacMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Start master IP rotation.
     * </pre>
     */
    public void startIPRotation(com.google.container.v1.StartIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getStartIPRotationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public void completeIPRotation(com.google.container.v1.CompleteIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCompleteIPRotationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the size of a specific node pool.
     * </pre>
     */
    public void setNodePoolSize(com.google.container.v1.SetNodePoolSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetNodePoolSizeMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Enables/Disables Network Policy for a cluster.
     * </pre>
     */
    public void setNetworkPolicy(com.google.container.v1.SetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetNetworkPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public void setMaintenancePolicy(com.google.container.v1.SetMaintenancePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetMaintenancePolicyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListClustersMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.ListClustersRequest,
                com.google.container.v1.ListClustersResponse>(
                  this, METHODID_LIST_CLUSTERS)))
          .addMethod(
            getGetClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.GetClusterRequest,
                com.google.container.v1.Cluster>(
                  this, METHODID_GET_CLUSTER)))
          .addMethod(
            getCreateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.CreateClusterRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_CREATE_CLUSTER)))
          .addMethod(
            getUpdateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.UpdateClusterRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
            getUpdateNodePoolMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.UpdateNodePoolRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_UPDATE_NODE_POOL)))
          .addMethod(
            getSetNodePoolAutoscalingMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetNodePoolAutoscalingRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_NODE_POOL_AUTOSCALING)))
          .addMethod(
            getSetLoggingServiceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetLoggingServiceRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_LOGGING_SERVICE)))
          .addMethod(
            getSetMonitoringServiceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetMonitoringServiceRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_MONITORING_SERVICE)))
          .addMethod(
            getSetAddonsConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetAddonsConfigRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_ADDONS_CONFIG)))
          .addMethod(
            getSetLocationsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetLocationsRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_LOCATIONS)))
          .addMethod(
            getUpdateMasterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.UpdateMasterRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_UPDATE_MASTER)))
          .addMethod(
            getSetMasterAuthMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetMasterAuthRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_MASTER_AUTH)))
          .addMethod(
            getDeleteClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.DeleteClusterRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_DELETE_CLUSTER)))
          .addMethod(
            getListOperationsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.ListOperationsRequest,
                com.google.container.v1.ListOperationsResponse>(
                  this, METHODID_LIST_OPERATIONS)))
          .addMethod(
            getGetOperationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.GetOperationRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_GET_OPERATION)))
          .addMethod(
            getCancelOperationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.CancelOperationRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CANCEL_OPERATION)))
          .addMethod(
            getGetServerConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.GetServerConfigRequest,
                com.google.container.v1.ServerConfig>(
                  this, METHODID_GET_SERVER_CONFIG)))
          .addMethod(
            getListNodePoolsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.ListNodePoolsRequest,
                com.google.container.v1.ListNodePoolsResponse>(
                  this, METHODID_LIST_NODE_POOLS)))
          .addMethod(
            getGetNodePoolMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.GetNodePoolRequest,
                com.google.container.v1.NodePool>(
                  this, METHODID_GET_NODE_POOL)))
          .addMethod(
            getCreateNodePoolMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.CreateNodePoolRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_CREATE_NODE_POOL)))
          .addMethod(
            getDeleteNodePoolMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.DeleteNodePoolRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_DELETE_NODE_POOL)))
          .addMethod(
            getRollbackNodePoolUpgradeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.RollbackNodePoolUpgradeRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_ROLLBACK_NODE_POOL_UPGRADE)))
          .addMethod(
            getSetNodePoolManagementMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetNodePoolManagementRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_NODE_POOL_MANAGEMENT)))
          .addMethod(
            getSetLabelsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetLabelsRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_LABELS)))
          .addMethod(
            getSetLegacyAbacMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetLegacyAbacRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_LEGACY_ABAC)))
          .addMethod(
            getStartIPRotationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.StartIPRotationRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_START_IPROTATION)))
          .addMethod(
            getCompleteIPRotationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.CompleteIPRotationRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_COMPLETE_IPROTATION)))
          .addMethod(
            getSetNodePoolSizeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetNodePoolSizeRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_NODE_POOL_SIZE)))
          .addMethod(
            getSetNetworkPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetNetworkPolicyRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_NETWORK_POLICY)))
          .addMethod(
            getSetMaintenancePolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.container.v1.SetMaintenancePolicyRequest,
                com.google.container.v1.Operation>(
                  this, METHODID_SET_MAINTENANCE_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * Google Container Engine Cluster Manager v1
   * </pre>
   */
  public static final class ClusterManagerStub extends io.grpc.stub.AbstractStub<ClusterManagerStub> {
    private ClusterManagerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterManagerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterManagerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public void listClusters(com.google.container.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListClustersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClustersMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public void getCluster(com.google.container.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Cluster> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the cluster creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range is being used by the cluster.
     * </pre>
     */
    public void createCluster(com.google.container.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public void updateCluster(com.google.container.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the version and/or image type of a specific node pool.
     * </pre>
     */
    public void updateNodePool(com.google.container.v1.UpdateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateNodePoolMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the autoscaling settings of a specific node pool.
     * </pre>
     */
    public void setNodePoolAutoscaling(com.google.container.v1.SetNodePoolAutoscalingRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetNodePoolAutoscalingMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the logging service of a specific cluster.
     * </pre>
     */
    public void setLoggingService(com.google.container.v1.SetLoggingServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLoggingServiceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the monitoring service of a specific cluster.
     * </pre>
     */
    public void setMonitoringService(com.google.container.v1.SetMonitoringServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetMonitoringServiceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the addons of a specific cluster.
     * </pre>
     */
    public void setAddonsConfig(com.google.container.v1.SetAddonsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetAddonsConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the locations of a specific cluster.
     * </pre>
     */
    public void setLocations(com.google.container.v1.SetLocationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLocationsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the master of a specific cluster.
     * </pre>
     */
    public void updateMaster(com.google.container.v1.UpdateMasterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMasterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Used to set master auth materials. Currently supports :-
     * Changing the admin password of a specific cluster.
     * This can be either via password generation or explicitly set the password.
     * </pre>
     */
    public void setMasterAuth(com.google.container.v1.SetMasterAuthRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetMasterAuthMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster
     * (e.g. load balancer resources) will not be deleted if they weren't present
     * at the initial create time.
     * </pre>
     */
    public void deleteCluster(com.google.container.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public void listOperations(com.google.container.v1.ListOperationsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListOperationsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOperationsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public void getOperation(com.google.container.v1.GetOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOperationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public void cancelOperation(com.google.container.v1.CancelOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelOperationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns configuration info about the Container Engine service.
     * </pre>
     */
    public void getServerConfig(com.google.container.v1.GetServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ServerConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServerConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public void listNodePools(com.google.container.v1.ListNodePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.ListNodePoolsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNodePoolsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the node pool requested.
     * </pre>
     */
    public void getNodePool(com.google.container.v1.GetNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.NodePool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNodePoolMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public void createNodePool(com.google.container.v1.CreateNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNodePoolMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public void deleteNodePool(com.google.container.v1.DeleteNodePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteNodePoolMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Roll back the previously Aborted or Failed NodePool upgrade.
     * This will be an no-op if the last upgrade successfully completed.
     * </pre>
     */
    public void rollbackNodePoolUpgrade(com.google.container.v1.RollbackNodePoolUpgradeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRollbackNodePoolUpgradeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public void setNodePoolManagement(com.google.container.v1.SetNodePoolManagementRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetNodePoolManagementMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public void setLabels(com.google.container.v1.SetLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLabelsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public void setLegacyAbac(com.google.container.v1.SetLegacyAbacRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLegacyAbacMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Start master IP rotation.
     * </pre>
     */
    public void startIPRotation(com.google.container.v1.StartIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartIPRotationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public void completeIPRotation(com.google.container.v1.CompleteIPRotationRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCompleteIPRotationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the size of a specific node pool.
     * </pre>
     */
    public void setNodePoolSize(com.google.container.v1.SetNodePoolSizeRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetNodePoolSizeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enables/Disables Network Policy for a cluster.
     * </pre>
     */
    public void setNetworkPolicy(com.google.container.v1.SetNetworkPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetNetworkPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public void setMaintenancePolicy(com.google.container.v1.SetMaintenancePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.container.v1.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetMaintenancePolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Google Container Engine Cluster Manager v1
   * </pre>
   */
  public static final class ClusterManagerBlockingStub extends io.grpc.stub.AbstractStub<ClusterManagerBlockingStub> {
    private ClusterManagerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterManagerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterManagerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public com.google.container.v1.ListClustersResponse listClusters(com.google.container.v1.ListClustersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListClustersMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Cluster getCluster(com.google.container.v1.GetClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the cluster creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range is being used by the cluster.
     * </pre>
     */
    public com.google.container.v1.Operation createCluster(com.google.container.v1.CreateClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation updateCluster(com.google.container.v1.UpdateClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the version and/or image type of a specific node pool.
     * </pre>
     */
    public com.google.container.v1.Operation updateNodePool(com.google.container.v1.UpdateNodePoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateNodePoolMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the autoscaling settings of a specific node pool.
     * </pre>
     */
    public com.google.container.v1.Operation setNodePoolAutoscaling(com.google.container.v1.SetNodePoolAutoscalingRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetNodePoolAutoscalingMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the logging service of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLoggingService(com.google.container.v1.SetLoggingServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetLoggingServiceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the monitoring service of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setMonitoringService(com.google.container.v1.SetMonitoringServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetMonitoringServiceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the addons of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setAddonsConfig(com.google.container.v1.SetAddonsConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetAddonsConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the locations of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLocations(com.google.container.v1.SetLocationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetLocationsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the master of a specific cluster.
     * </pre>
     */
    public com.google.container.v1.Operation updateMaster(com.google.container.v1.UpdateMasterRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMasterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Used to set master auth materials. Currently supports :-
     * Changing the admin password of a specific cluster.
     * This can be either via password generation or explicitly set the password.
     * </pre>
     */
    public com.google.container.v1.Operation setMasterAuth(com.google.container.v1.SetMasterAuthRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetMasterAuthMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster
     * (e.g. load balancer resources) will not be deleted if they weren't present
     * at the initial create time.
     * </pre>
     */
    public com.google.container.v1.Operation deleteCluster(com.google.container.v1.DeleteClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public com.google.container.v1.ListOperationsResponse listOperations(com.google.container.v1.ListOperationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListOperationsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public com.google.container.v1.Operation getOperation(com.google.container.v1.GetOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOperationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public com.google.protobuf.Empty cancelOperation(com.google.container.v1.CancelOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelOperationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns configuration info about the Container Engine service.
     * </pre>
     */
    public com.google.container.v1.ServerConfig getServerConfig(com.google.container.v1.GetServerConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetServerConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public com.google.container.v1.ListNodePoolsResponse listNodePools(com.google.container.v1.ListNodePoolsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNodePoolsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the node pool requested.
     * </pre>
     */
    public com.google.container.v1.NodePool getNodePool(com.google.container.v1.GetNodePoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNodePoolMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation createNodePool(com.google.container.v1.CreateNodePoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateNodePoolMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation deleteNodePool(com.google.container.v1.DeleteNodePoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteNodePoolMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Roll back the previously Aborted or Failed NodePool upgrade.
     * This will be an no-op if the last upgrade successfully completed.
     * </pre>
     */
    public com.google.container.v1.Operation rollbackNodePoolUpgrade(com.google.container.v1.RollbackNodePoolUpgradeRequest request) {
      return blockingUnaryCall(
          getChannel(), getRollbackNodePoolUpgradeMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public com.google.container.v1.Operation setNodePoolManagement(com.google.container.v1.SetNodePoolManagementRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetNodePoolManagementMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLabels(com.google.container.v1.SetLabelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetLabelsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setLegacyAbac(com.google.container.v1.SetLegacyAbacRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetLegacyAbacMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Start master IP rotation.
     * </pre>
     */
    public com.google.container.v1.Operation startIPRotation(com.google.container.v1.StartIPRotationRequest request) {
      return blockingUnaryCall(
          getChannel(), getStartIPRotationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public com.google.container.v1.Operation completeIPRotation(com.google.container.v1.CompleteIPRotationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCompleteIPRotationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the size of a specific node pool.
     * </pre>
     */
    public com.google.container.v1.Operation setNodePoolSize(com.google.container.v1.SetNodePoolSizeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetNodePoolSizeMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enables/Disables Network Policy for a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setNetworkPolicy(com.google.container.v1.SetNetworkPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetNetworkPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public com.google.container.v1.Operation setMaintenancePolicy(com.google.container.v1.SetMaintenancePolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetMaintenancePolicyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Google Container Engine Cluster Manager v1
   * </pre>
   */
  public static final class ClusterManagerFutureStub extends io.grpc.stub.AbstractStub<ClusterManagerFutureStub> {
    private ClusterManagerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterManagerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterManagerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all clusters owned by a project in either the specified zone or all
     * zones.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.ListClustersResponse> listClusters(
        com.google.container.v1.ListClustersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClustersMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Cluster> getCluster(
        com.google.container.v1.GetClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a cluster, consisting of the specified number and type of Google
     * Compute Engine instances.
     * By default, the cluster is created in the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * One firewall is added for the cluster. After cluster creation,
     * the cluster creates routes for each node to allow the containers
     * on that node to communicate with all other instances in the
     * cluster.
     * Finally, an entry is added to the project's global metadata indicating
     * which CIDR range is being used by the cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> createCluster(
        com.google.container.v1.CreateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the settings of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> updateCluster(
        com.google.container.v1.UpdateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the version and/or image type of a specific node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> updateNodePool(
        com.google.container.v1.UpdateNodePoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateNodePoolMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the autoscaling settings of a specific node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setNodePoolAutoscaling(
        com.google.container.v1.SetNodePoolAutoscalingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetNodePoolAutoscalingMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the logging service of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setLoggingService(
        com.google.container.v1.SetLoggingServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLoggingServiceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the monitoring service of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setMonitoringService(
        com.google.container.v1.SetMonitoringServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetMonitoringServiceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the addons of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setAddonsConfig(
        com.google.container.v1.SetAddonsConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetAddonsConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the locations of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setLocations(
        com.google.container.v1.SetLocationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLocationsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the master of a specific cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> updateMaster(
        com.google.container.v1.UpdateMasterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMasterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Used to set master auth materials. Currently supports :-
     * Changing the admin password of a specific cluster.
     * This can be either via password generation or explicitly set the password.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setMasterAuth(
        com.google.container.v1.SetMasterAuthRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetMasterAuthMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the cluster, including the Kubernetes endpoint and all worker
     * nodes.
     * Firewalls and routes that were configured during cluster creation
     * are also deleted.
     * Other Google Compute Engine resources that might be in use by the cluster
     * (e.g. load balancer resources) will not be deleted if they weren't present
     * at the initial create time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> deleteCluster(
        com.google.container.v1.DeleteClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all operations in a project in a specific zone or all zones.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.ListOperationsResponse> listOperations(
        com.google.container.v1.ListOperationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOperationsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the specified operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> getOperation(
        com.google.container.v1.GetOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOperationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancels the specified operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> cancelOperation(
        com.google.container.v1.CancelOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelOperationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns configuration info about the Container Engine service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.ServerConfig> getServerConfig(
        com.google.container.v1.GetServerConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServerConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the node pools for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.ListNodePoolsResponse> listNodePools(
        com.google.container.v1.ListNodePoolsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNodePoolsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the node pool requested.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.NodePool> getNodePool(
        com.google.container.v1.GetNodePoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNodePoolMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a node pool for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> createNodePool(
        com.google.container.v1.CreateNodePoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNodePoolMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a node pool from a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> deleteNodePool(
        com.google.container.v1.DeleteNodePoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteNodePoolMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Roll back the previously Aborted or Failed NodePool upgrade.
     * This will be an no-op if the last upgrade successfully completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> rollbackNodePoolUpgrade(
        com.google.container.v1.RollbackNodePoolUpgradeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRollbackNodePoolUpgradeMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the NodeManagement options for a node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setNodePoolManagement(
        com.google.container.v1.SetNodePoolManagementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetNodePoolManagementMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets labels on a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setLabels(
        com.google.container.v1.SetLabelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLabelsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enables or disables the ABAC authorization mechanism on a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setLegacyAbac(
        com.google.container.v1.SetLegacyAbacRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLegacyAbacMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Start master IP rotation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> startIPRotation(
        com.google.container.v1.StartIPRotationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStartIPRotationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Completes master IP rotation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> completeIPRotation(
        com.google.container.v1.CompleteIPRotationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCompleteIPRotationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the size of a specific node pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setNodePoolSize(
        com.google.container.v1.SetNodePoolSizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetNodePoolSizeMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enables/Disables Network Policy for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setNetworkPolicy(
        com.google.container.v1.SetNetworkPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetNetworkPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the maintenance policy for a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.container.v1.Operation> setMaintenancePolicy(
        com.google.container.v1.SetMaintenancePolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetMaintenancePolicyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_UPDATE_NODE_POOL = 4;
  private static final int METHODID_SET_NODE_POOL_AUTOSCALING = 5;
  private static final int METHODID_SET_LOGGING_SERVICE = 6;
  private static final int METHODID_SET_MONITORING_SERVICE = 7;
  private static final int METHODID_SET_ADDONS_CONFIG = 8;
  private static final int METHODID_SET_LOCATIONS = 9;
  private static final int METHODID_UPDATE_MASTER = 10;
  private static final int METHODID_SET_MASTER_AUTH = 11;
  private static final int METHODID_DELETE_CLUSTER = 12;
  private static final int METHODID_LIST_OPERATIONS = 13;
  private static final int METHODID_GET_OPERATION = 14;
  private static final int METHODID_CANCEL_OPERATION = 15;
  private static final int METHODID_GET_SERVER_CONFIG = 16;
  private static final int METHODID_LIST_NODE_POOLS = 17;
  private static final int METHODID_GET_NODE_POOL = 18;
  private static final int METHODID_CREATE_NODE_POOL = 19;
  private static final int METHODID_DELETE_NODE_POOL = 20;
  private static final int METHODID_ROLLBACK_NODE_POOL_UPGRADE = 21;
  private static final int METHODID_SET_NODE_POOL_MANAGEMENT = 22;
  private static final int METHODID_SET_LABELS = 23;
  private static final int METHODID_SET_LEGACY_ABAC = 24;
  private static final int METHODID_START_IPROTATION = 25;
  private static final int METHODID_COMPLETE_IPROTATION = 26;
  private static final int METHODID_SET_NODE_POOL_SIZE = 27;
  private static final int METHODID_SET_NETWORK_POLICY = 28;
  private static final int METHODID_SET_MAINTENANCE_POLICY = 29;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClusterManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClusterManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters((com.google.container.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListClustersResponse>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster((com.google.container.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Cluster>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster((com.google.container.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster((com.google.container.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_NODE_POOL:
          serviceImpl.updateNodePool((com.google.container.v1.UpdateNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NODE_POOL_AUTOSCALING:
          serviceImpl.setNodePoolAutoscaling((com.google.container.v1.SetNodePoolAutoscalingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LOGGING_SERVICE:
          serviceImpl.setLoggingService((com.google.container.v1.SetLoggingServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_MONITORING_SERVICE:
          serviceImpl.setMonitoringService((com.google.container.v1.SetMonitoringServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_ADDONS_CONFIG:
          serviceImpl.setAddonsConfig((com.google.container.v1.SetAddonsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LOCATIONS:
          serviceImpl.setLocations((com.google.container.v1.SetLocationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MASTER:
          serviceImpl.updateMaster((com.google.container.v1.UpdateMasterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_MASTER_AUTH:
          serviceImpl.setMasterAuth((com.google.container.v1.SetMasterAuthRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster((com.google.container.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_LIST_OPERATIONS:
          serviceImpl.listOperations((com.google.container.v1.ListOperationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListOperationsResponse>) responseObserver);
          break;
        case METHODID_GET_OPERATION:
          serviceImpl.getOperation((com.google.container.v1.GetOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_OPERATION:
          serviceImpl.cancelOperation((com.google.container.v1.CancelOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SERVER_CONFIG:
          serviceImpl.getServerConfig((com.google.container.v1.GetServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ServerConfig>) responseObserver);
          break;
        case METHODID_LIST_NODE_POOLS:
          serviceImpl.listNodePools((com.google.container.v1.ListNodePoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.ListNodePoolsResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_POOL:
          serviceImpl.getNodePool((com.google.container.v1.GetNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.NodePool>) responseObserver);
          break;
        case METHODID_CREATE_NODE_POOL:
          serviceImpl.createNodePool((com.google.container.v1.CreateNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NODE_POOL:
          serviceImpl.deleteNodePool((com.google.container.v1.DeleteNodePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_ROLLBACK_NODE_POOL_UPGRADE:
          serviceImpl.rollbackNodePoolUpgrade((com.google.container.v1.RollbackNodePoolUpgradeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NODE_POOL_MANAGEMENT:
          serviceImpl.setNodePoolManagement((com.google.container.v1.SetNodePoolManagementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LABELS:
          serviceImpl.setLabels((com.google.container.v1.SetLabelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_LEGACY_ABAC:
          serviceImpl.setLegacyAbac((com.google.container.v1.SetLegacyAbacRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_START_IPROTATION:
          serviceImpl.startIPRotation((com.google.container.v1.StartIPRotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_COMPLETE_IPROTATION:
          serviceImpl.completeIPRotation((com.google.container.v1.CompleteIPRotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NODE_POOL_SIZE:
          serviceImpl.setNodePoolSize((com.google.container.v1.SetNodePoolSizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_NETWORK_POLICY:
          serviceImpl.setNetworkPolicy((com.google.container.v1.SetNetworkPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
          break;
        case METHODID_SET_MAINTENANCE_POLICY:
          serviceImpl.setMaintenancePolicy((com.google.container.v1.SetMaintenancePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.container.v1.Operation>) responseObserver);
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

  private static abstract class ClusterManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClusterManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.container.v1.ClusterServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClusterManager");
    }
  }

  private static final class ClusterManagerFileDescriptorSupplier
      extends ClusterManagerBaseDescriptorSupplier {
    ClusterManagerFileDescriptorSupplier() {}
  }

  private static final class ClusterManagerMethodDescriptorSupplier
      extends ClusterManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClusterManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClusterManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClusterManagerFileDescriptorSupplier())
              .addMethod(getListClustersMethodHelper())
              .addMethod(getGetClusterMethodHelper())
              .addMethod(getCreateClusterMethodHelper())
              .addMethod(getUpdateClusterMethodHelper())
              .addMethod(getUpdateNodePoolMethodHelper())
              .addMethod(getSetNodePoolAutoscalingMethodHelper())
              .addMethod(getSetLoggingServiceMethodHelper())
              .addMethod(getSetMonitoringServiceMethodHelper())
              .addMethod(getSetAddonsConfigMethodHelper())
              .addMethod(getSetLocationsMethodHelper())
              .addMethod(getUpdateMasterMethodHelper())
              .addMethod(getSetMasterAuthMethodHelper())
              .addMethod(getDeleteClusterMethodHelper())
              .addMethod(getListOperationsMethodHelper())
              .addMethod(getGetOperationMethodHelper())
              .addMethod(getCancelOperationMethodHelper())
              .addMethod(getGetServerConfigMethodHelper())
              .addMethod(getListNodePoolsMethodHelper())
              .addMethod(getGetNodePoolMethodHelper())
              .addMethod(getCreateNodePoolMethodHelper())
              .addMethod(getDeleteNodePoolMethodHelper())
              .addMethod(getRollbackNodePoolUpgradeMethodHelper())
              .addMethod(getSetNodePoolManagementMethodHelper())
              .addMethod(getSetLabelsMethodHelper())
              .addMethod(getSetLegacyAbacMethodHelper())
              .addMethod(getStartIPRotationMethodHelper())
              .addMethod(getCompleteIPRotationMethodHelper())
              .addMethod(getSetNodePoolSizeMethodHelper())
              .addMethod(getSetNetworkPolicyMethodHelper())
              .addMethod(getSetMaintenancePolicyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
