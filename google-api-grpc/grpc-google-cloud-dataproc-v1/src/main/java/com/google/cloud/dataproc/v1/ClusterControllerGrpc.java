package com.google.cloud.dataproc.v1;

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
 * The ClusterControllerService provides methods to manage clusters
 * of Google Compute Engine instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dataproc/v1/clusters.proto")
public final class ClusterControllerGrpc {

  private ClusterControllerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.ClusterController";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateClusterRequest,
      com.google.longrunning.Operation> METHOD_CREATE_CLUSTER = getCreateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethod() {
    return getCreateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateClusterRequest,
      com.google.longrunning.Operation> getCreateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateClusterRequest, com.google.longrunning.Operation> getCreateClusterMethod;
    if ((getCreateClusterMethod = ClusterControllerGrpc.getCreateClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getCreateClusterMethod = ClusterControllerGrpc.getCreateClusterMethod) == null) {
          ClusterControllerGrpc.getCreateClusterMethod = getCreateClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.CreateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1.ClusterController", "CreateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterControllerMethodDescriptorSupplier("CreateCluster"))
                  .build();
          }
        }
     }
     return getCreateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> METHOD_UPDATE_CLUSTER = getUpdateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethod() {
    return getUpdateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateClusterRequest,
      com.google.longrunning.Operation> getUpdateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateClusterRequest, com.google.longrunning.Operation> getUpdateClusterMethod;
    if ((getUpdateClusterMethod = ClusterControllerGrpc.getUpdateClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getUpdateClusterMethod = ClusterControllerGrpc.getUpdateClusterMethod) == null) {
          ClusterControllerGrpc.getUpdateClusterMethod = getUpdateClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.UpdateClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1.ClusterController", "UpdateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterControllerMethodDescriptorSupplier("UpdateCluster"))
                  .build();
          }
        }
     }
     return getUpdateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> METHOD_DELETE_CLUSTER = getDeleteClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethod() {
    return getDeleteClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteClusterRequest,
      com.google.longrunning.Operation> getDeleteClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteClusterRequest, com.google.longrunning.Operation> getDeleteClusterMethod;
    if ((getDeleteClusterMethod = ClusterControllerGrpc.getDeleteClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getDeleteClusterMethod = ClusterControllerGrpc.getDeleteClusterMethod) == null) {
          ClusterControllerGrpc.getDeleteClusterMethod = getDeleteClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.DeleteClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1.ClusterController", "DeleteCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterControllerMethodDescriptorSupplier("DeleteCluster"))
                  .build();
          }
        }
     }
     return getDeleteClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetClusterRequest,
      com.google.cloud.dataproc.v1.Cluster> METHOD_GET_CLUSTER = getGetClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetClusterRequest,
      com.google.cloud.dataproc.v1.Cluster> getGetClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetClusterRequest,
      com.google.cloud.dataproc.v1.Cluster> getGetClusterMethod() {
    return getGetClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetClusterRequest,
      com.google.cloud.dataproc.v1.Cluster> getGetClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetClusterRequest, com.google.cloud.dataproc.v1.Cluster> getGetClusterMethod;
    if ((getGetClusterMethod = ClusterControllerGrpc.getGetClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getGetClusterMethod = ClusterControllerGrpc.getGetClusterMethod) == null) {
          ClusterControllerGrpc.getGetClusterMethod = getGetClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.GetClusterRequest, com.google.cloud.dataproc.v1.Cluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1.ClusterController", "GetCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.GetClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.Cluster.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterControllerMethodDescriptorSupplier("GetCluster"))
                  .build();
          }
        }
     }
     return getGetClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListClustersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListClustersRequest,
      com.google.cloud.dataproc.v1.ListClustersResponse> METHOD_LIST_CLUSTERS = getListClustersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListClustersRequest,
      com.google.cloud.dataproc.v1.ListClustersResponse> getListClustersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListClustersRequest,
      com.google.cloud.dataproc.v1.ListClustersResponse> getListClustersMethod() {
    return getListClustersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListClustersRequest,
      com.google.cloud.dataproc.v1.ListClustersResponse> getListClustersMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListClustersRequest, com.google.cloud.dataproc.v1.ListClustersResponse> getListClustersMethod;
    if ((getListClustersMethod = ClusterControllerGrpc.getListClustersMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getListClustersMethod = ClusterControllerGrpc.getListClustersMethod) == null) {
          ClusterControllerGrpc.getListClustersMethod = getListClustersMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.ListClustersRequest, com.google.cloud.dataproc.v1.ListClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1.ClusterController", "ListClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListClustersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterControllerMethodDescriptorSupplier("ListClusters"))
                  .build();
          }
        }
     }
     return getListClustersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDiagnoseClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
      com.google.longrunning.Operation> METHOD_DIAGNOSE_CLUSTER = getDiagnoseClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
      com.google.longrunning.Operation> getDiagnoseClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
      com.google.longrunning.Operation> getDiagnoseClusterMethod() {
    return getDiagnoseClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
      com.google.longrunning.Operation> getDiagnoseClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DiagnoseClusterRequest, com.google.longrunning.Operation> getDiagnoseClusterMethod;
    if ((getDiagnoseClusterMethod = ClusterControllerGrpc.getDiagnoseClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getDiagnoseClusterMethod = ClusterControllerGrpc.getDiagnoseClusterMethod) == null) {
          ClusterControllerGrpc.getDiagnoseClusterMethod = getDiagnoseClusterMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.DiagnoseClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.dataproc.v1.ClusterController", "DiagnoseCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.DiagnoseClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ClusterControllerMethodDescriptorSupplier("DiagnoseCluster"))
                  .build();
          }
        }
     }
     return getDiagnoseClusterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClusterControllerStub newStub(io.grpc.Channel channel) {
    return new ClusterControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClusterControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClusterControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClusterControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClusterControllerFutureStub(channel);
  }

  /**
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Google Compute Engine instances.
   * </pre>
   */
  public static abstract class ClusterControllerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a cluster in a project.
     * </pre>
     */
    public void createCluster(com.google.cloud.dataproc.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates a cluster in a project.
     * </pre>
     */
    public void updateCluster(com.google.cloud.dataproc.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a cluster in a project.
     * </pre>
     */
    public void deleteCluster(com.google.cloud.dataproc.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public void getCluster(com.google.cloud.dataproc.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Cluster> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClusterMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists all regions/{region}/clusters in a project.
     * </pre>
     */
    public void listClusters(com.google.cloud.dataproc.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListClustersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListClustersMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets cluster diagnostic information.
     * After the operation completes, the Operation.response field
     * contains `DiagnoseClusterOutputLocation`.
     * </pre>
     */
    public void diagnoseCluster(com.google.cloud.dataproc.v1.DiagnoseClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDiagnoseClusterMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.CreateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CLUSTER)))
          .addMethod(
            getUpdateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.UpdateClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
            getDeleteClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.DeleteClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CLUSTER)))
          .addMethod(
            getGetClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.GetClusterRequest,
                com.google.cloud.dataproc.v1.Cluster>(
                  this, METHODID_GET_CLUSTER)))
          .addMethod(
            getListClustersMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.ListClustersRequest,
                com.google.cloud.dataproc.v1.ListClustersResponse>(
                  this, METHODID_LIST_CLUSTERS)))
          .addMethod(
            getDiagnoseClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DIAGNOSE_CLUSTER)))
          .build();
    }
  }

  /**
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Google Compute Engine instances.
   * </pre>
   */
  public static final class ClusterControllerStub extends io.grpc.stub.AbstractStub<ClusterControllerStub> {
    private ClusterControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterControllerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a cluster in a project.
     * </pre>
     */
    public void createCluster(com.google.cloud.dataproc.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a cluster in a project.
     * </pre>
     */
    public void updateCluster(com.google.cloud.dataproc.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a cluster in a project.
     * </pre>
     */
    public void deleteCluster(com.google.cloud.dataproc.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public void getCluster(com.google.cloud.dataproc.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Cluster> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all regions/{region}/clusters in a project.
     * </pre>
     */
    public void listClusters(com.google.cloud.dataproc.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListClustersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClustersMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets cluster diagnostic information.
     * After the operation completes, the Operation.response field
     * contains `DiagnoseClusterOutputLocation`.
     * </pre>
     */
    public void diagnoseCluster(com.google.cloud.dataproc.v1.DiagnoseClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDiagnoseClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Google Compute Engine instances.
   * </pre>
   */
  public static final class ClusterControllerBlockingStub extends io.grpc.stub.AbstractStub<ClusterControllerBlockingStub> {
    private ClusterControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterControllerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a cluster in a project.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(com.google.cloud.dataproc.v1.CreateClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a cluster in a project.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(com.google.cloud.dataproc.v1.UpdateClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a cluster in a project.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(com.google.cloud.dataproc.v1.DeleteClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Cluster getCluster(com.google.cloud.dataproc.v1.GetClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all regions/{region}/clusters in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListClustersResponse listClusters(com.google.cloud.dataproc.v1.ListClustersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListClustersMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets cluster diagnostic information.
     * After the operation completes, the Operation.response field
     * contains `DiagnoseClusterOutputLocation`.
     * </pre>
     */
    public com.google.longrunning.Operation diagnoseCluster(com.google.cloud.dataproc.v1.DiagnoseClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDiagnoseClusterMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Google Compute Engine instances.
   * </pre>
   */
  public static final class ClusterControllerFutureStub extends io.grpc.stub.AbstractStub<ClusterControllerFutureStub> {
    private ClusterControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterControllerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a cluster in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createCluster(
        com.google.cloud.dataproc.v1.CreateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a cluster in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateCluster(
        com.google.cloud.dataproc.v1.UpdateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a cluster in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteCluster(
        com.google.cloud.dataproc.v1.DeleteClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Cluster> getCluster(
        com.google.cloud.dataproc.v1.GetClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all regions/{region}/clusters in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.ListClustersResponse> listClusters(
        com.google.cloud.dataproc.v1.ListClustersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClustersMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets cluster diagnostic information.
     * After the operation completes, the Operation.response field
     * contains `DiagnoseClusterOutputLocation`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> diagnoseCluster(
        com.google.cloud.dataproc.v1.DiagnoseClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDiagnoseClusterMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CLUSTER = 0;
  private static final int METHODID_UPDATE_CLUSTER = 1;
  private static final int METHODID_DELETE_CLUSTER = 2;
  private static final int METHODID_GET_CLUSTER = 3;
  private static final int METHODID_LIST_CLUSTERS = 4;
  private static final int METHODID_DIAGNOSE_CLUSTER = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClusterControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClusterControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster((com.google.cloud.dataproc.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster((com.google.cloud.dataproc.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster((com.google.cloud.dataproc.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster((com.google.cloud.dataproc.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Cluster>) responseObserver);
          break;
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters((com.google.cloud.dataproc.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListClustersResponse>) responseObserver);
          break;
        case METHODID_DIAGNOSE_CLUSTER:
          serviceImpl.diagnoseCluster((com.google.cloud.dataproc.v1.DiagnoseClusterRequest) request,
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

  private static abstract class ClusterControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClusterControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.ClustersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClusterController");
    }
  }

  private static final class ClusterControllerFileDescriptorSupplier
      extends ClusterControllerBaseDescriptorSupplier {
    ClusterControllerFileDescriptorSupplier() {}
  }

  private static final class ClusterControllerMethodDescriptorSupplier
      extends ClusterControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClusterControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClusterControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClusterControllerFileDescriptorSupplier())
              .addMethod(getCreateClusterMethodHelper())
              .addMethod(getUpdateClusterMethodHelper())
              .addMethod(getDeleteClusterMethodHelper())
              .addMethod(getGetClusterMethodHelper())
              .addMethod(getListClustersMethodHelper())
              .addMethod(getDiagnoseClusterMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
