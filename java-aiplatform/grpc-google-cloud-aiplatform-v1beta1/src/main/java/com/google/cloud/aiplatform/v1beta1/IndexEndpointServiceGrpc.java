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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Vertex AI's IndexEndpoints.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/index_endpoint_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IndexEndpointServiceGrpc {

  private IndexEndpointServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.IndexEndpointService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest,
          com.google.longrunning.Operation>
      getCreateIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIndexEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest,
          com.google.longrunning.Operation>
      getCreateIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest,
            com.google.longrunning.Operation>
        getCreateIndexEndpointMethod;
    if ((getCreateIndexEndpointMethod = IndexEndpointServiceGrpc.getCreateIndexEndpointMethod)
        == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getCreateIndexEndpointMethod = IndexEndpointServiceGrpc.getCreateIndexEndpointMethod)
            == null) {
          IndexEndpointServiceGrpc.getCreateIndexEndpointMethod =
              getCreateIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("CreateIndexEndpoint"))
                      .build();
        }
      }
    }
    return getCreateIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
      getGetIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIndexEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.IndexEndpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
      getGetIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest,
            com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
        getGetIndexEndpointMethod;
    if ((getGetIndexEndpointMethod = IndexEndpointServiceGrpc.getGetIndexEndpointMethod) == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getGetIndexEndpointMethod = IndexEndpointServiceGrpc.getGetIndexEndpointMethod)
            == null) {
          IndexEndpointServiceGrpc.getGetIndexEndpointMethod =
              getGetIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest,
                          com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.IndexEndpoint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("GetIndexEndpoint"))
                      .build();
        }
      }
    }
    return getGetIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest,
          com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
      getListIndexEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIndexEndpoints",
      requestType = com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest,
          com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
      getListIndexEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest,
            com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
        getListIndexEndpointsMethod;
    if ((getListIndexEndpointsMethod = IndexEndpointServiceGrpc.getListIndexEndpointsMethod)
        == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getListIndexEndpointsMethod = IndexEndpointServiceGrpc.getListIndexEndpointsMethod)
            == null) {
          IndexEndpointServiceGrpc.getListIndexEndpointsMethod =
              getListIndexEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIndexEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("ListIndexEndpoints"))
                      .build();
        }
      }
    }
    return getListIndexEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
      getUpdateIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIndexEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.IndexEndpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest,
          com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
      getUpdateIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest,
            com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
        getUpdateIndexEndpointMethod;
    if ((getUpdateIndexEndpointMethod = IndexEndpointServiceGrpc.getUpdateIndexEndpointMethod)
        == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getUpdateIndexEndpointMethod = IndexEndpointServiceGrpc.getUpdateIndexEndpointMethod)
            == null) {
          IndexEndpointServiceGrpc.getUpdateIndexEndpointMethod =
              getUpdateIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest,
                          com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.IndexEndpoint
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("UpdateIndexEndpoint"))
                      .build();
        }
      }
    }
    return getUpdateIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest,
          com.google.longrunning.Operation>
      getDeleteIndexEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIndexEndpoint",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest,
          com.google.longrunning.Operation>
      getDeleteIndexEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest,
            com.google.longrunning.Operation>
        getDeleteIndexEndpointMethod;
    if ((getDeleteIndexEndpointMethod = IndexEndpointServiceGrpc.getDeleteIndexEndpointMethod)
        == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getDeleteIndexEndpointMethod = IndexEndpointServiceGrpc.getDeleteIndexEndpointMethod)
            == null) {
          IndexEndpointServiceGrpc.getDeleteIndexEndpointMethod =
              getDeleteIndexEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIndexEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("DeleteIndexEndpoint"))
                      .build();
        }
      }
    }
    return getDeleteIndexEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployIndexRequest, com.google.longrunning.Operation>
      getDeployIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployIndex",
      requestType = com.google.cloud.aiplatform.v1beta1.DeployIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeployIndexRequest, com.google.longrunning.Operation>
      getDeployIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeployIndexRequest,
            com.google.longrunning.Operation>
        getDeployIndexMethod;
    if ((getDeployIndexMethod = IndexEndpointServiceGrpc.getDeployIndexMethod) == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getDeployIndexMethod = IndexEndpointServiceGrpc.getDeployIndexMethod) == null) {
          IndexEndpointServiceGrpc.getDeployIndexMethod =
              getDeployIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeployIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeployIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("DeployIndex"))
                      .build();
        }
      }
    }
    return getDeployIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest,
          com.google.longrunning.Operation>
      getUndeployIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployIndex",
      requestType = com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest,
          com.google.longrunning.Operation>
      getUndeployIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest,
            com.google.longrunning.Operation>
        getUndeployIndexMethod;
    if ((getUndeployIndexMethod = IndexEndpointServiceGrpc.getUndeployIndexMethod) == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getUndeployIndexMethod = IndexEndpointServiceGrpc.getUndeployIndexMethod) == null) {
          IndexEndpointServiceGrpc.getUndeployIndexMethod =
              getUndeployIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("UndeployIndex"))
                      .build();
        }
      }
    }
    return getUndeployIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest,
          com.google.longrunning.Operation>
      getMutateDeployedIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MutateDeployedIndex",
      requestType = com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest,
          com.google.longrunning.Operation>
      getMutateDeployedIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest,
            com.google.longrunning.Operation>
        getMutateDeployedIndexMethod;
    if ((getMutateDeployedIndexMethod = IndexEndpointServiceGrpc.getMutateDeployedIndexMethod)
        == null) {
      synchronized (IndexEndpointServiceGrpc.class) {
        if ((getMutateDeployedIndexMethod = IndexEndpointServiceGrpc.getMutateDeployedIndexMethod)
            == null) {
          IndexEndpointServiceGrpc.getMutateDeployedIndexMethod =
              getMutateDeployedIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MutateDeployedIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IndexEndpointServiceMethodDescriptorSupplier("MutateDeployedIndex"))
                      .build();
        }
      }
    }
    return getMutateDeployedIndexMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IndexEndpointServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IndexEndpointServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IndexEndpointServiceStub>() {
          @java.lang.Override
          public IndexEndpointServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IndexEndpointServiceStub(channel, callOptions);
          }
        };
    return IndexEndpointServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IndexEndpointServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IndexEndpointServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IndexEndpointServiceBlockingStub>() {
          @java.lang.Override
          public IndexEndpointServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IndexEndpointServiceBlockingStub(channel, callOptions);
          }
        };
    return IndexEndpointServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IndexEndpointServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IndexEndpointServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IndexEndpointServiceFutureStub>() {
          @java.lang.Override
          public IndexEndpointServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IndexEndpointServiceFutureStub(channel, callOptions);
          }
        };
    return IndexEndpointServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's IndexEndpoints.
   * </pre>
   */
  public abstract static class IndexEndpointServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public void createIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public void getIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists IndexEndpoints in a Location.
     * </pre>
     */
    public void listIndexEndpoints(
        com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIndexEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public void updateIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public void deleteIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIndexEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within
     * it.
     * Only non-empty Indexes can be deployed.
     * </pre>
     */
    public void deployIndex(
        com.google.cloud.aiplatform.v1beta1.DeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it,
     * and freeing all resources it's using.
     * </pre>
     */
    public void undeployIndex(
        com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an existing DeployedIndex under an IndexEndpoint.
     * </pre>
     */
    public void mutateDeployedIndex(
        com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMutateDeployedIndexMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateIndexEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_INDEX_ENDPOINT)))
          .addMethod(
              getGetIndexEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest,
                      com.google.cloud.aiplatform.v1beta1.IndexEndpoint>(
                      this, METHODID_GET_INDEX_ENDPOINT)))
          .addMethod(
              getListIndexEndpointsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>(
                      this, METHODID_LIST_INDEX_ENDPOINTS)))
          .addMethod(
              getUpdateIndexEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest,
                      com.google.cloud.aiplatform.v1beta1.IndexEndpoint>(
                      this, METHODID_UPDATE_INDEX_ENDPOINT)))
          .addMethod(
              getDeleteIndexEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_INDEX_ENDPOINT)))
          .addMethod(
              getDeployIndexMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeployIndexRequest,
                      com.google.longrunning.Operation>(this, METHODID_DEPLOY_INDEX)))
          .addMethod(
              getUndeployIndexMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDEPLOY_INDEX)))
          .addMethod(
              getMutateDeployedIndexMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest,
                      com.google.longrunning.Operation>(this, METHODID_MUTATE_DEPLOYED_INDEX)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's IndexEndpoints.
   * </pre>
   */
  public static final class IndexEndpointServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IndexEndpointServiceStub> {
    private IndexEndpointServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IndexEndpointServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IndexEndpointServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public void createIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public void getIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists IndexEndpoints in a Location.
     * </pre>
     */
    public void listIndexEndpoints(
        com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIndexEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public void updateIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public void deleteIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIndexEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within
     * it.
     * Only non-empty Indexes can be deployed.
     * </pre>
     */
    public void deployIndex(
        com.google.cloud.aiplatform.v1beta1.DeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it,
     * and freeing all resources it's using.
     * </pre>
     */
    public void undeployIndex(
        com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an existing DeployedIndex under an IndexEndpoint.
     * </pre>
     */
    public void mutateDeployedIndex(
        com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMutateDeployedIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's IndexEndpoints.
   * </pre>
   */
  public static final class IndexEndpointServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IndexEndpointServiceBlockingStub> {
    private IndexEndpointServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IndexEndpointServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IndexEndpointServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation createIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.IndexEndpoint getIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists IndexEndpoints in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse listIndexEndpoints(
        com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIndexEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.IndexEndpoint updateIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIndexEndpoint(
        com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIndexEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within
     * it.
     * Only non-empty Indexes can be deployed.
     * </pre>
     */
    public com.google.longrunning.Operation deployIndex(
        com.google.cloud.aiplatform.v1beta1.DeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it,
     * and freeing all resources it's using.
     * </pre>
     */
    public com.google.longrunning.Operation undeployIndex(
        com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an existing DeployedIndex under an IndexEndpoint.
     * </pre>
     */
    public com.google.longrunning.Operation mutateDeployedIndex(
        com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMutateDeployedIndexMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's IndexEndpoints.
   * </pre>
   */
  public static final class IndexEndpointServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IndexEndpointServiceFutureStub> {
    private IndexEndpointServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IndexEndpointServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IndexEndpointServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndexEndpoint(
            com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
        getIndexEndpoint(com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists IndexEndpoints in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>
        listIndexEndpoints(com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIndexEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.IndexEndpoint>
        updateIndexEndpoint(
            com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIndexEndpoint(
            com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIndexEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an Index into this IndexEndpoint, creating a DeployedIndex within
     * it.
     * Only non-empty Indexes can be deployed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployIndex(com.google.cloud.aiplatform.v1beta1.DeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it,
     * and freeing all resources it's using.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployIndex(com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an existing DeployedIndex under an IndexEndpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        mutateDeployedIndex(
            com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMutateDeployedIndexMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_INDEX_ENDPOINT = 0;
  private static final int METHODID_GET_INDEX_ENDPOINT = 1;
  private static final int METHODID_LIST_INDEX_ENDPOINTS = 2;
  private static final int METHODID_UPDATE_INDEX_ENDPOINT = 3;
  private static final int METHODID_DELETE_INDEX_ENDPOINT = 4;
  private static final int METHODID_DEPLOY_INDEX = 5;
  private static final int METHODID_UNDEPLOY_INDEX = 6;
  private static final int METHODID_MUTATE_DEPLOYED_INDEX = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IndexEndpointServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IndexEndpointServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_INDEX_ENDPOINT:
          serviceImpl.createIndexEndpoint(
              (com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INDEX_ENDPOINT:
          serviceImpl.getIndexEndpoint(
              (com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.IndexEndpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_INDEX_ENDPOINTS:
          serviceImpl.listIndexEndpoints(
              (com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INDEX_ENDPOINT:
          serviceImpl.updateIndexEndpoint(
              (com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.IndexEndpoint>)
                  responseObserver);
          break;
        case METHODID_DELETE_INDEX_ENDPOINT:
          serviceImpl.deleteIndexEndpoint(
              (com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_INDEX:
          serviceImpl.deployIndex(
              (com.google.cloud.aiplatform.v1beta1.DeployIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_INDEX:
          serviceImpl.undeployIndex(
              (com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MUTATE_DEPLOYED_INDEX:
          serviceImpl.mutateDeployedIndex(
              (com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest) request,
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

  private abstract static class IndexEndpointServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IndexEndpointServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IndexEndpointService");
    }
  }

  private static final class IndexEndpointServiceFileDescriptorSupplier
      extends IndexEndpointServiceBaseDescriptorSupplier {
    IndexEndpointServiceFileDescriptorSupplier() {}
  }

  private static final class IndexEndpointServiceMethodDescriptorSupplier
      extends IndexEndpointServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IndexEndpointServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IndexEndpointServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IndexEndpointServiceFileDescriptorSupplier())
                      .addMethod(getCreateIndexEndpointMethod())
                      .addMethod(getGetIndexEndpointMethod())
                      .addMethod(getListIndexEndpointsMethod())
                      .addMethod(getUpdateIndexEndpointMethod())
                      .addMethod(getDeleteIndexEndpointMethod())
                      .addMethod(getDeployIndexMethod())
                      .addMethod(getUndeployIndexMethod())
                      .addMethod(getMutateDeployedIndexMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
