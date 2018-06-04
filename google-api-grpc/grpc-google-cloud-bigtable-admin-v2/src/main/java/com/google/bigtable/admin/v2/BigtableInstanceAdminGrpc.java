package com.google.bigtable.admin.v2;

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
 * Service for creating, configuring, and deleting Cloud Bigtable Instances and
 * Clusters. Provides access to the Instance and Cluster schemas only, not the
 * tables' metadata or data stored in those tables.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/bigtable/admin/v2/bigtable_instance_admin.proto")
public final class BigtableInstanceAdminGrpc {

  private BigtableInstanceAdminGrpc() {}

  public static final String SERVICE_NAME = "google.bigtable.admin.v2.BigtableInstanceAdmin";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateInstanceRequest,
      com.google.longrunning.Operation> METHOD_CREATE_INSTANCE = getCreateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    return getCreateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = BigtableInstanceAdminGrpc.getCreateInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getCreateInstanceMethod = BigtableInstanceAdminGrpc.getCreateInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getCreateInstanceMethod = getCreateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("CreateInstance"))
                  .build();
          }
        }
     }
     return getCreateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetInstanceRequest,
      com.google.bigtable.admin.v2.Instance> METHOD_GET_INSTANCE = getGetInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetInstanceRequest,
      com.google.bigtable.admin.v2.Instance> getGetInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetInstanceRequest,
      com.google.bigtable.admin.v2.Instance> getGetInstanceMethod() {
    return getGetInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetInstanceRequest,
      com.google.bigtable.admin.v2.Instance> getGetInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetInstanceRequest, com.google.bigtable.admin.v2.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = BigtableInstanceAdminGrpc.getGetInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetInstanceMethod = BigtableInstanceAdminGrpc.getGetInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getGetInstanceMethod = getGetInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.GetInstanceRequest, com.google.bigtable.admin.v2.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.Instance.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("GetInstance"))
                  .build();
          }
        }
     }
     return getGetInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInstancesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListInstancesRequest,
      com.google.bigtable.admin.v2.ListInstancesResponse> METHOD_LIST_INSTANCES = getListInstancesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListInstancesRequest,
      com.google.bigtable.admin.v2.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListInstancesRequest,
      com.google.bigtable.admin.v2.ListInstancesResponse> getListInstancesMethod() {
    return getListInstancesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListInstancesRequest,
      com.google.bigtable.admin.v2.ListInstancesResponse> getListInstancesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListInstancesRequest, com.google.bigtable.admin.v2.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = BigtableInstanceAdminGrpc.getListInstancesMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getListInstancesMethod = BigtableInstanceAdminGrpc.getListInstancesMethod) == null) {
          BigtableInstanceAdminGrpc.getListInstancesMethod = getListInstancesMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.ListInstancesRequest, com.google.bigtable.admin.v2.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.ListInstancesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("ListInstances"))
                  .build();
          }
        }
     }
     return getListInstancesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Instance,
      com.google.bigtable.admin.v2.Instance> METHOD_UPDATE_INSTANCE = getUpdateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Instance,
      com.google.bigtable.admin.v2.Instance> getUpdateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Instance,
      com.google.bigtable.admin.v2.Instance> getUpdateInstanceMethod() {
    return getUpdateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Instance,
      com.google.bigtable.admin.v2.Instance> getUpdateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Instance, com.google.bigtable.admin.v2.Instance> getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = BigtableInstanceAdminGrpc.getUpdateInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getUpdateInstanceMethod = BigtableInstanceAdminGrpc.getUpdateInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getUpdateInstanceMethod = getUpdateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.Instance, com.google.bigtable.admin.v2.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "UpdateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.Instance.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.Instance.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("UpdateInstance"))
                  .build();
          }
        }
     }
     return getUpdateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPartialUpdateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
      com.google.longrunning.Operation> METHOD_PARTIAL_UPDATE_INSTANCE = getPartialUpdateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
      com.google.longrunning.Operation> getPartialUpdateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
      com.google.longrunning.Operation> getPartialUpdateInstanceMethod() {
    return getPartialUpdateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
      com.google.longrunning.Operation> getPartialUpdateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest, com.google.longrunning.Operation> getPartialUpdateInstanceMethod;
    if ((getPartialUpdateInstanceMethod = BigtableInstanceAdminGrpc.getPartialUpdateInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getPartialUpdateInstanceMethod = BigtableInstanceAdminGrpc.getPartialUpdateInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getPartialUpdateInstanceMethod = getPartialUpdateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.PartialUpdateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "PartialUpdateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.PartialUpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("PartialUpdateInstance"))
                  .build();
          }
        }
     }
     return getPartialUpdateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteInstanceRequest,
      com.google.protobuf.Empty> METHOD_DELETE_INSTANCE = getDeleteInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteInstanceRequest,
      com.google.protobuf.Empty> getDeleteInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteInstanceRequest,
      com.google.protobuf.Empty> getDeleteInstanceMethod() {
    return getDeleteInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteInstanceRequest,
      com.google.protobuf.Empty> getDeleteInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteInstanceRequest, com.google.protobuf.Empty> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = BigtableInstanceAdminGrpc.getDeleteInstanceMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getDeleteInstanceMethod = BigtableInstanceAdminGrpc.getDeleteInstanceMethod) == null) {
          BigtableInstanceAdminGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.DeleteInstanceRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("DeleteInstance"))
                  .build();
          }
        }
     }
     return getDeleteInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateClusterRequest,
      com.google.longrunning.Operation> METHOD_CREATE_CLUSTER = getCreateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod() {
    return getCreateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateClusterRequest, com.google.longrunning.Operation> getCreateClusterMethod;
    if ((getCreateClusterMethod = BigtableInstanceAdminGrpc.getCreateClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getCreateClusterMethod = BigtableInstanceAdminGrpc.getCreateClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getCreateClusterMethod = getCreateClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.CreateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "CreateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("CreateCluster"))
                  .build();
          }
        }
     }
     return getCreateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetClusterRequest,
      com.google.bigtable.admin.v2.Cluster> METHOD_GET_CLUSTER = getGetClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetClusterRequest,
      com.google.bigtable.admin.v2.Cluster> getGetClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetClusterRequest,
      com.google.bigtable.admin.v2.Cluster> getGetClusterMethod() {
    return getGetClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetClusterRequest,
      com.google.bigtable.admin.v2.Cluster> getGetClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster> getGetClusterMethod;
    if ((getGetClusterMethod = BigtableInstanceAdminGrpc.getGetClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetClusterMethod = BigtableInstanceAdminGrpc.getGetClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getGetClusterMethod = getGetClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.GetClusterRequest, com.google.bigtable.admin.v2.Cluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "GetCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.GetClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.Cluster.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("GetCluster"))
                  .build();
          }
        }
     }
     return getGetClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListClustersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListClustersRequest,
      com.google.bigtable.admin.v2.ListClustersResponse> METHOD_LIST_CLUSTERS = getListClustersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListClustersRequest,
      com.google.bigtable.admin.v2.ListClustersResponse> getListClustersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListClustersRequest,
      com.google.bigtable.admin.v2.ListClustersResponse> getListClustersMethod() {
    return getListClustersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListClustersRequest,
      com.google.bigtable.admin.v2.ListClustersResponse> getListClustersMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListClustersRequest, com.google.bigtable.admin.v2.ListClustersResponse> getListClustersMethod;
    if ((getListClustersMethod = BigtableInstanceAdminGrpc.getListClustersMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getListClustersMethod = BigtableInstanceAdminGrpc.getListClustersMethod) == null) {
          BigtableInstanceAdminGrpc.getListClustersMethod = getListClustersMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.ListClustersRequest, com.google.bigtable.admin.v2.ListClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "ListClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.ListClustersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("ListClusters"))
                  .build();
          }
        }
     }
     return getListClustersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Cluster,
      com.google.longrunning.Operation> METHOD_UPDATE_CLUSTER = getUpdateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Cluster,
      com.google.longrunning.Operation> getUpdateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Cluster,
      com.google.longrunning.Operation> getUpdateClusterMethod() {
    return getUpdateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Cluster,
      com.google.longrunning.Operation> getUpdateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation> getUpdateClusterMethod;
    if ((getUpdateClusterMethod = BigtableInstanceAdminGrpc.getUpdateClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getUpdateClusterMethod = BigtableInstanceAdminGrpc.getUpdateClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getUpdateClusterMethod = getUpdateClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.Cluster, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "UpdateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.Cluster.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("UpdateCluster"))
                  .build();
          }
        }
     }
     return getUpdateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteClusterRequest,
      com.google.protobuf.Empty> METHOD_DELETE_CLUSTER = getDeleteClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteClusterRequest,
      com.google.protobuf.Empty> getDeleteClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteClusterRequest,
      com.google.protobuf.Empty> getDeleteClusterMethod() {
    return getDeleteClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteClusterRequest,
      com.google.protobuf.Empty> getDeleteClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteClusterRequest, com.google.protobuf.Empty> getDeleteClusterMethod;
    if ((getDeleteClusterMethod = BigtableInstanceAdminGrpc.getDeleteClusterMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getDeleteClusterMethod = BigtableInstanceAdminGrpc.getDeleteClusterMethod) == null) {
          BigtableInstanceAdminGrpc.getDeleteClusterMethod = getDeleteClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.DeleteClusterRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "DeleteCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("DeleteCluster"))
                  .build();
          }
        }
     }
     return getDeleteClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAppProfileMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> METHOD_CREATE_APP_PROFILE = getCreateAppProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> getCreateAppProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> getCreateAppProfileMethod() {
    return getCreateAppProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> getCreateAppProfileMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.CreateAppProfileRequest, com.google.bigtable.admin.v2.AppProfile> getCreateAppProfileMethod;
    if ((getCreateAppProfileMethod = BigtableInstanceAdminGrpc.getCreateAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getCreateAppProfileMethod = BigtableInstanceAdminGrpc.getCreateAppProfileMethod) == null) {
          BigtableInstanceAdminGrpc.getCreateAppProfileMethod = getCreateAppProfileMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.CreateAppProfileRequest, com.google.bigtable.admin.v2.AppProfile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "CreateAppProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.CreateAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.AppProfile.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("CreateAppProfile"))
                  .build();
          }
        }
     }
     return getCreateAppProfileMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAppProfileMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> METHOD_GET_APP_PROFILE = getGetAppProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> getGetAppProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> getGetAppProfileMethod() {
    return getGetAppProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetAppProfileRequest,
      com.google.bigtable.admin.v2.AppProfile> getGetAppProfileMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.GetAppProfileRequest, com.google.bigtable.admin.v2.AppProfile> getGetAppProfileMethod;
    if ((getGetAppProfileMethod = BigtableInstanceAdminGrpc.getGetAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetAppProfileMethod = BigtableInstanceAdminGrpc.getGetAppProfileMethod) == null) {
          BigtableInstanceAdminGrpc.getGetAppProfileMethod = getGetAppProfileMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.GetAppProfileRequest, com.google.bigtable.admin.v2.AppProfile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "GetAppProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.GetAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.AppProfile.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("GetAppProfile"))
                  .build();
          }
        }
     }
     return getGetAppProfileMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListAppProfilesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListAppProfilesRequest,
      com.google.bigtable.admin.v2.ListAppProfilesResponse> METHOD_LIST_APP_PROFILES = getListAppProfilesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListAppProfilesRequest,
      com.google.bigtable.admin.v2.ListAppProfilesResponse> getListAppProfilesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListAppProfilesRequest,
      com.google.bigtable.admin.v2.ListAppProfilesResponse> getListAppProfilesMethod() {
    return getListAppProfilesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListAppProfilesRequest,
      com.google.bigtable.admin.v2.ListAppProfilesResponse> getListAppProfilesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.ListAppProfilesRequest, com.google.bigtable.admin.v2.ListAppProfilesResponse> getListAppProfilesMethod;
    if ((getListAppProfilesMethod = BigtableInstanceAdminGrpc.getListAppProfilesMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getListAppProfilesMethod = BigtableInstanceAdminGrpc.getListAppProfilesMethod) == null) {
          BigtableInstanceAdminGrpc.getListAppProfilesMethod = getListAppProfilesMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.ListAppProfilesRequest, com.google.bigtable.admin.v2.ListAppProfilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "ListAppProfiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.ListAppProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.ListAppProfilesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("ListAppProfiles"))
                  .build();
          }
        }
     }
     return getListAppProfilesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateAppProfileMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.UpdateAppProfileRequest,
      com.google.longrunning.Operation> METHOD_UPDATE_APP_PROFILE = getUpdateAppProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.UpdateAppProfileRequest,
      com.google.longrunning.Operation> getUpdateAppProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.UpdateAppProfileRequest,
      com.google.longrunning.Operation> getUpdateAppProfileMethod() {
    return getUpdateAppProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.UpdateAppProfileRequest,
      com.google.longrunning.Operation> getUpdateAppProfileMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.UpdateAppProfileRequest, com.google.longrunning.Operation> getUpdateAppProfileMethod;
    if ((getUpdateAppProfileMethod = BigtableInstanceAdminGrpc.getUpdateAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getUpdateAppProfileMethod = BigtableInstanceAdminGrpc.getUpdateAppProfileMethod) == null) {
          BigtableInstanceAdminGrpc.getUpdateAppProfileMethod = getUpdateAppProfileMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.UpdateAppProfileRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "UpdateAppProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.UpdateAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("UpdateAppProfile"))
                  .build();
          }
        }
     }
     return getUpdateAppProfileMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAppProfileMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteAppProfileRequest,
      com.google.protobuf.Empty> METHOD_DELETE_APP_PROFILE = getDeleteAppProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteAppProfileRequest,
      com.google.protobuf.Empty> getDeleteAppProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteAppProfileRequest,
      com.google.protobuf.Empty> getDeleteAppProfileMethod() {
    return getDeleteAppProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteAppProfileRequest,
      com.google.protobuf.Empty> getDeleteAppProfileMethodHelper() {
    io.grpc.MethodDescriptor<com.google.bigtable.admin.v2.DeleteAppProfileRequest, com.google.protobuf.Empty> getDeleteAppProfileMethod;
    if ((getDeleteAppProfileMethod = BigtableInstanceAdminGrpc.getDeleteAppProfileMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getDeleteAppProfileMethod = BigtableInstanceAdminGrpc.getDeleteAppProfileMethod) == null) {
          BigtableInstanceAdminGrpc.getDeleteAppProfileMethod = getDeleteAppProfileMethod = 
              io.grpc.MethodDescriptor.<com.google.bigtable.admin.v2.DeleteAppProfileRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "DeleteAppProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.bigtable.admin.v2.DeleteAppProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("DeleteAppProfile"))
                  .build();
          }
        }
     }
     return getDeleteAppProfileMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = BigtableInstanceAdminGrpc.getGetIamPolicyMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getGetIamPolicyMethod = BigtableInstanceAdminGrpc.getGetIamPolicyMethod) == null) {
          BigtableInstanceAdminGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("GetIamPolicy"))
                  .build();
          }
        }
     }
     return getGetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = BigtableInstanceAdminGrpc.getSetIamPolicyMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getSetIamPolicyMethod = BigtableInstanceAdminGrpc.getSetIamPolicyMethod) == null) {
          BigtableInstanceAdminGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("SetIamPolicy"))
                  .build();
          }
        }
     }
     return getSetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = BigtableInstanceAdminGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (BigtableInstanceAdminGrpc.class) {
        if ((getTestIamPermissionsMethod = BigtableInstanceAdminGrpc.getTestIamPermissionsMethod) == null) {
          BigtableInstanceAdminGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.bigtable.admin.v2.BigtableInstanceAdmin", "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BigtableInstanceAdminMethodDescriptorSupplier("TestIamPermissions"))
                  .build();
          }
        }
     }
     return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BigtableInstanceAdminStub newStub(io.grpc.Channel channel) {
    return new BigtableInstanceAdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BigtableInstanceAdminBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BigtableInstanceAdminBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BigtableInstanceAdminFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BigtableInstanceAdminFutureStub(channel);
  }

  /**
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static abstract class BigtableInstanceAdminImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Create an instance within a project.
     * </pre>
     */
    public void createInstance(com.google.bigtable.admin.v2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public void getInstance(com.google.bigtable.admin.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public void listInstances(com.google.bigtable.admin.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListInstancesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInstancesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an instance within a project.
     * </pre>
     */
    public void updateInstance(com.google.bigtable.admin.v2.Instance request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Partially updates an instance within a project.
     * </pre>
     */
    public void partialUpdateInstance(com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getPartialUpdateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public void deleteInstance(com.google.bigtable.admin.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a cluster within an instance.
     * </pre>
     */
    public void createCluster(com.google.bigtable.admin.v2.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public void getCluster(com.google.bigtable.admin.v2.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Cluster> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public void listClusters(com.google.bigtable.admin.v2.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListClustersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListClustersMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates a cluster within an instance.
     * </pre>
     */
    public void updateCluster(com.google.bigtable.admin.v2.Cluster request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public void deleteCluster(com.google.bigtable.admin.v2.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public void createAppProfile(com.google.bigtable.admin.v2.CreateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAppProfileMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public void getAppProfile(com.google.bigtable.admin.v2.GetAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAppProfileMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public void listAppProfiles(com.google.bigtable.admin.v2.ListAppProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListAppProfilesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListAppProfilesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public void updateAppProfile(com.google.bigtable.admin.v2.UpdateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAppProfileMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public void deleteAppProfile(com.google.bigtable.admin.v2.DeleteAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAppProfileMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.CreateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getGetInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.GetInstanceRequest,
                com.google.bigtable.admin.v2.Instance>(
                  this, METHODID_GET_INSTANCE)))
          .addMethod(
            getListInstancesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.ListInstancesRequest,
                com.google.bigtable.admin.v2.ListInstancesResponse>(
                  this, METHODID_LIST_INSTANCES)))
          .addMethod(
            getUpdateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.Instance,
                com.google.bigtable.admin.v2.Instance>(
                  this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
            getPartialUpdateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.PartialUpdateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_PARTIAL_UPDATE_INSTANCE)))
          .addMethod(
            getDeleteInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.DeleteInstanceRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_INSTANCE)))
          .addMethod(
            getCreateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.CreateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLUSTER)))
          .addMethod(
            getGetClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.GetClusterRequest,
                com.google.bigtable.admin.v2.Cluster>(
                  this, METHODID_GET_CLUSTER)))
          .addMethod(
            getListClustersMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.ListClustersRequest,
                com.google.bigtable.admin.v2.ListClustersResponse>(
                  this, METHODID_LIST_CLUSTERS)))
          .addMethod(
            getUpdateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.Cluster,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
            getDeleteClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.DeleteClusterRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CLUSTER)))
          .addMethod(
            getCreateAppProfileMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.CreateAppProfileRequest,
                com.google.bigtable.admin.v2.AppProfile>(
                  this, METHODID_CREATE_APP_PROFILE)))
          .addMethod(
            getGetAppProfileMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.GetAppProfileRequest,
                com.google.bigtable.admin.v2.AppProfile>(
                  this, METHODID_GET_APP_PROFILE)))
          .addMethod(
            getListAppProfilesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.ListAppProfilesRequest,
                com.google.bigtable.admin.v2.ListAppProfilesResponse>(
                  this, METHODID_LIST_APP_PROFILES)))
          .addMethod(
            getUpdateAppProfileMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.UpdateAppProfileRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_APP_PROFILE)))
          .addMethod(
            getDeleteAppProfileMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bigtable.admin.v2.DeleteAppProfileRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_APP_PROFILE)))
          .addMethod(
            getGetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getSetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static final class BigtableInstanceAdminStub extends io.grpc.stub.AbstractStub<BigtableInstanceAdminStub> {
    private BigtableInstanceAdminStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BigtableInstanceAdminStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableInstanceAdminStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BigtableInstanceAdminStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create an instance within a project.
     * </pre>
     */
    public void createInstance(com.google.bigtable.admin.v2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public void getInstance(com.google.bigtable.admin.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public void listInstances(com.google.bigtable.admin.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListInstancesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInstancesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an instance within a project.
     * </pre>
     */
    public void updateInstance(com.google.bigtable.admin.v2.Instance request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Partially updates an instance within a project.
     * </pre>
     */
    public void partialUpdateInstance(com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPartialUpdateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public void deleteInstance(com.google.bigtable.admin.v2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a cluster within an instance.
     * </pre>
     */
    public void createCluster(com.google.bigtable.admin.v2.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public void getCluster(com.google.bigtable.admin.v2.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Cluster> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public void listClusters(com.google.bigtable.admin.v2.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListClustersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClustersMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a cluster within an instance.
     * </pre>
     */
    public void updateCluster(com.google.bigtable.admin.v2.Cluster request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public void deleteCluster(com.google.bigtable.admin.v2.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public void createAppProfile(com.google.bigtable.admin.v2.CreateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAppProfileMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public void getAppProfile(com.google.bigtable.admin.v2.GetAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAppProfileMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public void listAppProfiles(com.google.bigtable.admin.v2.ListAppProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListAppProfilesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAppProfilesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public void updateAppProfile(com.google.bigtable.admin.v2.UpdateAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAppProfileMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public void deleteAppProfile(com.google.bigtable.admin.v2.DeleteAppProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAppProfileMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static final class BigtableInstanceAdminBlockingStub extends io.grpc.stub.AbstractStub<BigtableInstanceAdminBlockingStub> {
    private BigtableInstanceAdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BigtableInstanceAdminBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableInstanceAdminBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BigtableInstanceAdminBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create an instance within a project.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.bigtable.admin.v2.CreateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Instance getInstance(com.google.bigtable.admin.v2.GetInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ListInstancesResponse listInstances(com.google.bigtable.admin.v2.ListInstancesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInstancesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an instance within a project.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Instance updateInstance(com.google.bigtable.admin.v2.Instance request) {
      return blockingUnaryCall(
          getChannel(), getUpdateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Partially updates an instance within a project.
     * </pre>
     */
    public com.google.longrunning.Operation partialUpdateInstance(com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getPartialUpdateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public com.google.protobuf.Empty deleteInstance(com.google.bigtable.admin.v2.DeleteInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a cluster within an instance.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(com.google.bigtable.admin.v2.CreateClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Cluster getCluster(com.google.bigtable.admin.v2.GetClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ListClustersResponse listClusters(com.google.bigtable.admin.v2.ListClustersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListClustersMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a cluster within an instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(com.google.bigtable.admin.v2.Cluster request) {
      return blockingUnaryCall(
          getChannel(), getUpdateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCluster(com.google.bigtable.admin.v2.DeleteClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.AppProfile createAppProfile(com.google.bigtable.admin.v2.CreateAppProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAppProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public com.google.bigtable.admin.v2.AppProfile getAppProfile(com.google.bigtable.admin.v2.GetAppProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAppProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ListAppProfilesResponse listAppProfiles(com.google.bigtable.admin.v2.ListAppProfilesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAppProfilesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateAppProfile(com.google.bigtable.admin.v2.UpdateAppProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateAppProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAppProfile(com.google.bigtable.admin.v2.DeleteAppProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAppProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for creating, configuring, and deleting Cloud Bigtable Instances and
   * Clusters. Provides access to the Instance and Cluster schemas only, not the
   * tables' metadata or data stored in those tables.
   * </pre>
   */
  public static final class BigtableInstanceAdminFutureStub extends io.grpc.stub.AbstractStub<BigtableInstanceAdminFutureStub> {
    private BigtableInstanceAdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BigtableInstanceAdminFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BigtableInstanceAdminFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BigtableInstanceAdminFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create an instance within a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.bigtable.admin.v2.CreateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.Instance> getInstance(
        com.google.bigtable.admin.v2.GetInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists information about instances in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.ListInstancesResponse> listInstances(
        com.google.bigtable.admin.v2.ListInstancesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInstancesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an instance within a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.Instance> updateInstance(
        com.google.bigtable.admin.v2.Instance request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Partially updates an instance within a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> partialUpdateInstance(
        com.google.bigtable.admin.v2.PartialUpdateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPartialUpdateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete an instance from a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteInstance(
        com.google.bigtable.admin.v2.DeleteInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a cluster within an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createCluster(
        com.google.bigtable.admin.v2.CreateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.Cluster> getCluster(
        com.google.bigtable.admin.v2.GetClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists information about clusters in an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.ListClustersResponse> listClusters(
        com.google.bigtable.admin.v2.ListClustersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClustersMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a cluster within an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateCluster(
        com.google.bigtable.admin.v2.Cluster request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a cluster from an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteCluster(
        com.google.bigtable.admin.v2.DeleteClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an app profile within an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.AppProfile> createAppProfile(
        com.google.bigtable.admin.v2.CreateAppProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAppProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about an app profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.AppProfile> getAppProfile(
        com.google.bigtable.admin.v2.GetAppProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAppProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists information about app profiles in an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bigtable.admin.v2.ListAppProfilesResponse> listAppProfiles(
        com.google.bigtable.admin.v2.ListAppProfilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAppProfilesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an app profile within an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAppProfile(
        com.google.bigtable.admin.v2.UpdateAppProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAppProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an app profile from an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAppProfile(
        com.google.bigtable.admin.v2.DeleteAppProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAppProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INSTANCE = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_LIST_INSTANCES = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_PARTIAL_UPDATE_INSTANCE = 4;
  private static final int METHODID_DELETE_INSTANCE = 5;
  private static final int METHODID_CREATE_CLUSTER = 6;
  private static final int METHODID_GET_CLUSTER = 7;
  private static final int METHODID_LIST_CLUSTERS = 8;
  private static final int METHODID_UPDATE_CLUSTER = 9;
  private static final int METHODID_DELETE_CLUSTER = 10;
  private static final int METHODID_CREATE_APP_PROFILE = 11;
  private static final int METHODID_GET_APP_PROFILE = 12;
  private static final int METHODID_LIST_APP_PROFILES = 13;
  private static final int METHODID_UPDATE_APP_PROFILE = 14;
  private static final int METHODID_DELETE_APP_PROFILE = 15;
  private static final int METHODID_GET_IAM_POLICY = 16;
  private static final int METHODID_SET_IAM_POLICY = 17;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 18;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BigtableInstanceAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BigtableInstanceAdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.bigtable.admin.v2.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.bigtable.admin.v2.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.bigtable.admin.v2.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance((com.google.bigtable.admin.v2.Instance) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Instance>) responseObserver);
          break;
        case METHODID_PARTIAL_UPDATE_INSTANCE:
          serviceImpl.partialUpdateInstance((com.google.bigtable.admin.v2.PartialUpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.bigtable.admin.v2.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster((com.google.bigtable.admin.v2.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster((com.google.bigtable.admin.v2.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.Cluster>) responseObserver);
          break;
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters((com.google.bigtable.admin.v2.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListClustersResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster((com.google.bigtable.admin.v2.Cluster) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster((com.google.bigtable.admin.v2.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_APP_PROFILE:
          serviceImpl.createAppProfile((com.google.bigtable.admin.v2.CreateAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile>) responseObserver);
          break;
        case METHODID_GET_APP_PROFILE:
          serviceImpl.getAppProfile((com.google.bigtable.admin.v2.GetAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.AppProfile>) responseObserver);
          break;
        case METHODID_LIST_APP_PROFILES:
          serviceImpl.listAppProfiles((com.google.bigtable.admin.v2.ListAppProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bigtable.admin.v2.ListAppProfilesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_APP_PROFILE:
          serviceImpl.updateAppProfile((com.google.bigtable.admin.v2.UpdateAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APP_PROFILE:
          serviceImpl.deleteAppProfile((com.google.bigtable.admin.v2.DeleteAppProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static abstract class BigtableInstanceAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BigtableInstanceAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BigtableInstanceAdmin");
    }
  }

  private static final class BigtableInstanceAdminFileDescriptorSupplier
      extends BigtableInstanceAdminBaseDescriptorSupplier {
    BigtableInstanceAdminFileDescriptorSupplier() {}
  }

  private static final class BigtableInstanceAdminMethodDescriptorSupplier
      extends BigtableInstanceAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BigtableInstanceAdminMethodDescriptorSupplier(String methodName) {
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
      synchronized (BigtableInstanceAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BigtableInstanceAdminFileDescriptorSupplier())
              .addMethod(getCreateInstanceMethodHelper())
              .addMethod(getGetInstanceMethodHelper())
              .addMethod(getListInstancesMethodHelper())
              .addMethod(getUpdateInstanceMethodHelper())
              .addMethod(getPartialUpdateInstanceMethodHelper())
              .addMethod(getDeleteInstanceMethodHelper())
              .addMethod(getCreateClusterMethodHelper())
              .addMethod(getGetClusterMethodHelper())
              .addMethod(getListClustersMethodHelper())
              .addMethod(getUpdateClusterMethodHelper())
              .addMethod(getDeleteClusterMethodHelper())
              .addMethod(getCreateAppProfileMethodHelper())
              .addMethod(getGetAppProfileMethodHelper())
              .addMethod(getListAppProfilesMethodHelper())
              .addMethod(getUpdateAppProfileMethodHelper())
              .addMethod(getDeleteAppProfileMethodHelper())
              .addMethod(getGetIamPolicyMethodHelper())
              .addMethod(getSetIamPolicyMethodHelper())
              .addMethod(getTestIamPermissionsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
