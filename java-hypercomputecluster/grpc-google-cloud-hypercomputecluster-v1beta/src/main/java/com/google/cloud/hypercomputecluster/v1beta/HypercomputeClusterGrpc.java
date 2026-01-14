/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.hypercomputecluster.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class HypercomputeClusterGrpc {

  private HypercomputeClusterGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.hypercomputecluster.v1beta.HypercomputeCluster";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest,
          com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest.class,
      responseType = com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest,
          com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest,
            com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = HypercomputeClusterGrpc.getListClustersMethod) == null) {
      synchronized (HypercomputeClusterGrpc.class) {
        if ((getListClustersMethod = HypercomputeClusterGrpc.getListClustersMethod) == null) {
          HypercomputeClusterGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest,
                          com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HypercomputeClusterMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest,
          com.google.cloud.hypercomputecluster.v1beta.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest.class,
      responseType = com.google.cloud.hypercomputecluster.v1beta.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest,
          com.google.cloud.hypercomputecluster.v1beta.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest,
            com.google.cloud.hypercomputecluster.v1beta.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = HypercomputeClusterGrpc.getGetClusterMethod) == null) {
      synchronized (HypercomputeClusterGrpc.class) {
        if ((getGetClusterMethod = HypercomputeClusterGrpc.getGetClusterMethod) == null) {
          HypercomputeClusterGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest,
                          com.google.cloud.hypercomputecluster.v1beta.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.Cluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HypercomputeClusterMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest,
          com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest,
          com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest,
            com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = HypercomputeClusterGrpc.getCreateClusterMethod) == null) {
      synchronized (HypercomputeClusterGrpc.class) {
        if ((getCreateClusterMethod = HypercomputeClusterGrpc.getCreateClusterMethod) == null) {
          HypercomputeClusterGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HypercomputeClusterMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest,
          com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest,
          com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest,
            com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = HypercomputeClusterGrpc.getUpdateClusterMethod) == null) {
      synchronized (HypercomputeClusterGrpc.class) {
        if ((getUpdateClusterMethod = HypercomputeClusterGrpc.getUpdateClusterMethod) == null) {
          HypercomputeClusterGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HypercomputeClusterMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest,
          com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest,
          com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest,
            com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = HypercomputeClusterGrpc.getDeleteClusterMethod) == null) {
      synchronized (HypercomputeClusterGrpc.class) {
        if ((getDeleteClusterMethod = HypercomputeClusterGrpc.getDeleteClusterMethod) == null) {
          HypercomputeClusterGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HypercomputeClusterMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HypercomputeClusterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterStub>() {
          @java.lang.Override
          public HypercomputeClusterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HypercomputeClusterStub(channel, callOptions);
          }
        };
    return HypercomputeClusterStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static HypercomputeClusterBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterBlockingV2Stub>() {
          @java.lang.Override
          public HypercomputeClusterBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HypercomputeClusterBlockingV2Stub(channel, callOptions);
          }
        };
    return HypercomputeClusterBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HypercomputeClusterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterBlockingStub>() {
          @java.lang.Override
          public HypercomputeClusterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HypercomputeClusterBlockingStub(channel, callOptions);
          }
        };
    return HypercomputeClusterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HypercomputeClusterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HypercomputeClusterFutureStub>() {
          @java.lang.Override
          public HypercomputeClusterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HypercomputeClusterFutureStub(channel, callOptions);
          }
        };
    return HypercomputeClusterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    default void listClusters(
        com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    default void getCluster(
        com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.hypercomputecluster.v1beta.Cluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    default void createCluster(
        com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    default void updateCluster(
        com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    default void deleteCluster(
        com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HypercomputeCluster.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class HypercomputeClusterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HypercomputeClusterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HypercomputeCluster.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class HypercomputeClusterStub
      extends io.grpc.stub.AbstractAsyncStub<HypercomputeClusterStub> {
    private HypercomputeClusterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HypercomputeClusterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HypercomputeClusterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.hypercomputecluster.v1beta.Cluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public void createCluster(
        com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HypercomputeCluster.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class HypercomputeClusterBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<HypercomputeClusterBlockingV2Stub> {
    private HypercomputeClusterBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HypercomputeClusterBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HypercomputeClusterBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse listClusters(
        com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.cloud.hypercomputecluster.v1beta.Cluster getCluster(
        com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service HypercomputeCluster.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class HypercomputeClusterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HypercomputeClusterBlockingStub> {
    private HypercomputeClusterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HypercomputeClusterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HypercomputeClusterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse listClusters(
        com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.cloud.hypercomputecluster.v1beta.Cluster getCluster(
        com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HypercomputeCluster.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class HypercomputeClusterFutureStub
      extends io.grpc.stub.AbstractFutureStub<HypercomputeClusterFutureStub> {
    private HypercomputeClusterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HypercomputeClusterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HypercomputeClusterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>
        listClusters(com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.hypercomputecluster.v1beta.Cluster>
        getCluster(com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_DELETE_CLUSTER = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.hypercomputecluster.v1beta.Cluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.hypercomputecluster.v1beta.ListClustersRequest,
                    com.google.cloud.hypercomputecluster.v1beta.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.hypercomputecluster.v1beta.GetClusterRequest,
                    com.google.cloud.hypercomputecluster.v1beta.Cluster>(
                    service, METHODID_GET_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.hypercomputecluster.v1beta.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.hypercomputecluster.v1beta.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.hypercomputecluster.v1beta.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .build();
  }

  private abstract static class HypercomputeClusterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HypercomputeClusterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.hypercomputecluster.v1beta.HypercomputeClusterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HypercomputeCluster");
    }
  }

  private static final class HypercomputeClusterFileDescriptorSupplier
      extends HypercomputeClusterBaseDescriptorSupplier {
    HypercomputeClusterFileDescriptorSupplier() {}
  }

  private static final class HypercomputeClusterMethodDescriptorSupplier
      extends HypercomputeClusterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HypercomputeClusterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HypercomputeClusterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HypercomputeClusterFileDescriptorSupplier())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
