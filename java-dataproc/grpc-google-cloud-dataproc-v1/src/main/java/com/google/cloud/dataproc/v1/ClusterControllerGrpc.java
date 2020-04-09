/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The ClusterControllerService provides methods to manage clusters
 * of Compute Engine instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/clusters.proto")
public final class ClusterControllerGrpc {

  private ClusterControllerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.ClusterController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.dataproc.v1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = ClusterControllerGrpc.getCreateClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getCreateClusterMethod = ClusterControllerGrpc.getCreateClusterMethod) == null) {
          ClusterControllerGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterControllerMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.dataproc.v1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.UpdateClusterRequest, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = ClusterControllerGrpc.getUpdateClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getUpdateClusterMethod = ClusterControllerGrpc.getUpdateClusterMethod) == null) {
          ClusterControllerGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterControllerMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.dataproc.v1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.DeleteClusterRequest, com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = ClusterControllerGrpc.getDeleteClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getDeleteClusterMethod = ClusterControllerGrpc.getDeleteClusterMethod) == null) {
          ClusterControllerGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterControllerMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetClusterRequest, com.google.cloud.dataproc.v1.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.dataproc.v1.GetClusterRequest.class,
      responseType = com.google.cloud.dataproc.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetClusterRequest, com.google.cloud.dataproc.v1.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.GetClusterRequest, com.google.cloud.dataproc.v1.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = ClusterControllerGrpc.getGetClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getGetClusterMethod = ClusterControllerGrpc.getGetClusterMethod) == null) {
          ClusterControllerGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.GetClusterRequest,
                          com.google.cloud.dataproc.v1.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.GetClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterControllerMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListClustersRequest,
          com.google.cloud.dataproc.v1.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.dataproc.v1.ListClustersRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListClustersRequest,
          com.google.cloud.dataproc.v1.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.ListClustersRequest,
            com.google.cloud.dataproc.v1.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = ClusterControllerGrpc.getListClustersMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getListClustersMethod = ClusterControllerGrpc.getListClustersMethod) == null) {
          ClusterControllerGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.ListClustersRequest,
                          com.google.cloud.dataproc.v1.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterControllerMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DiagnoseClusterRequest, com.google.longrunning.Operation>
      getDiagnoseClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseCluster",
      requestType = com.google.cloud.dataproc.v1.DiagnoseClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DiagnoseClusterRequest, com.google.longrunning.Operation>
      getDiagnoseClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.DiagnoseClusterRequest, com.google.longrunning.Operation>
        getDiagnoseClusterMethod;
    if ((getDiagnoseClusterMethod = ClusterControllerGrpc.getDiagnoseClusterMethod) == null) {
      synchronized (ClusterControllerGrpc.class) {
        if ((getDiagnoseClusterMethod = ClusterControllerGrpc.getDiagnoseClusterMethod) == null) {
          ClusterControllerGrpc.getDiagnoseClusterMethod =
              getDiagnoseClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.DiagnoseClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ClusterControllerMethodDescriptorSupplier("DiagnoseCluster"))
                      .build();
        }
      }
    }
    return getDiagnoseClusterMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ClusterControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClusterControllerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ClusterControllerStub>() {
          @java.lang.Override
          public ClusterControllerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ClusterControllerStub(channel, callOptions);
          }
        };
    return ClusterControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClusterControllerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClusterControllerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ClusterControllerBlockingStub>() {
          @java.lang.Override
          public ClusterControllerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ClusterControllerBlockingStub(channel, callOptions);
          }
        };
    return ClusterControllerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ClusterControllerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClusterControllerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ClusterControllerFutureStub>() {
          @java.lang.Override
          public ClusterControllerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ClusterControllerFutureStub(channel, callOptions);
          }
        };
    return ClusterControllerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Compute Engine instances.
   * </pre>
   */
  public abstract static class ClusterControllerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public void createCluster(
        com.google.cloud.dataproc.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.dataproc.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.dataproc.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.dataproc.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Cluster> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all regions/{region}/clusters in a project alphabetically.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.dataproc.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListClustersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets cluster diagnostic information. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * After the operation completes,
     * [Operation.response][google.longrunning.Operation.response]
     * contains
     * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
     * </pre>
     */
    public void diagnoseCluster(
        com.google.cloud.dataproc.v1.DiagnoseClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDiagnoseClusterMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateClusterMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.CreateClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CLUSTER)))
          .addMethod(
              getUpdateClusterMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.UpdateClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
              getDeleteClusterMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.DeleteClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CLUSTER)))
          .addMethod(
              getGetClusterMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.GetClusterRequest,
                      com.google.cloud.dataproc.v1.Cluster>(this, METHODID_GET_CLUSTER)))
          .addMethod(
              getListClustersMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.ListClustersRequest,
                      com.google.cloud.dataproc.v1.ListClustersResponse>(
                      this, METHODID_LIST_CLUSTERS)))
          .addMethod(
              getDiagnoseClusterMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.DiagnoseClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_DIAGNOSE_CLUSTER)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Compute Engine instances.
   * </pre>
   */
  public static final class ClusterControllerStub
      extends io.grpc.stub.AbstractAsyncStub<ClusterControllerStub> {
    private ClusterControllerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClusterControllerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public void createCluster(
        com.google.cloud.dataproc.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.dataproc.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.dataproc.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.dataproc.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Cluster> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all regions/{region}/clusters in a project alphabetically.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.dataproc.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListClustersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets cluster diagnostic information. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * After the operation completes,
     * [Operation.response][google.longrunning.Operation.response]
     * contains
     * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
     * </pre>
     */
    public void diagnoseCluster(
        com.google.cloud.dataproc.v1.DiagnoseClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDiagnoseClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Compute Engine instances.
   * </pre>
   */
  public static final class ClusterControllerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ClusterControllerBlockingStub> {
    private ClusterControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClusterControllerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.dataproc.v1.CreateClusterRequest request) {
      return blockingUnaryCall(getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.dataproc.v1.UpdateClusterRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.dataproc.v1.DeleteClusterRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.Cluster getCluster(
        com.google.cloud.dataproc.v1.GetClusterRequest request) {
      return blockingUnaryCall(getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all regions/{region}/clusters in a project alphabetically.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListClustersResponse listClusters(
        com.google.cloud.dataproc.v1.ListClustersRequest request) {
      return blockingUnaryCall(getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets cluster diagnostic information. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * After the operation completes,
     * [Operation.response][google.longrunning.Operation.response]
     * contains
     * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
     * </pre>
     */
    public com.google.longrunning.Operation diagnoseCluster(
        com.google.cloud.dataproc.v1.DiagnoseClusterRequest request) {
      return blockingUnaryCall(getChannel(), getDiagnoseClusterMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The ClusterControllerService provides methods to manage clusters
   * of Compute Engine instances.
   * </pre>
   */
  public static final class ClusterControllerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ClusterControllerFutureStub> {
    private ClusterControllerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClusterControllerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.dataproc.v1.CreateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.dataproc.v1.UpdateClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a cluster in a project. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.dataproc.v1.DeleteClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the resource representation for a cluster in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.Cluster>
        getCluster(com.google.cloud.dataproc.v1.GetClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all regions/{region}/clusters in a project alphabetically.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.ListClustersResponse>
        listClusters(com.google.cloud.dataproc.v1.ListClustersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets cluster diagnostic information. The returned
     * [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
     * After the operation completes,
     * [Operation.response][google.longrunning.Operation.response]
     * contains
     * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        diagnoseCluster(com.google.cloud.dataproc.v1.DiagnoseClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDiagnoseClusterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CLUSTER = 0;
  private static final int METHODID_UPDATE_CLUSTER = 1;
  private static final int METHODID_DELETE_CLUSTER = 2;
  private static final int METHODID_GET_CLUSTER = 3;
  private static final int METHODID_LIST_CLUSTERS = 4;
  private static final int METHODID_DIAGNOSE_CLUSTER = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.createCluster(
              (com.google.cloud.dataproc.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.dataproc.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.dataproc.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.dataproc.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.Cluster>) responseObserver);
          break;
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.dataproc.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_DIAGNOSE_CLUSTER:
          serviceImpl.diagnoseCluster(
              (com.google.cloud.dataproc.v1.DiagnoseClusterRequest) request,
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

  private abstract static class ClusterControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ClusterControllerFileDescriptorSupplier())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getListClustersMethod())
                      .addMethod(getDiagnoseClusterMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
