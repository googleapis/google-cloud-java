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
package com.google.cloud.vectorsearch.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * VectorSearchService provides methods for managing Collection resources, and
 * Collection Index resources. The primary resources offered by this service are
 * Collections which are a container for a set of related JSON data objects, and
 * Collection Indexes which enable efficient ANN search across data objects
 * within a Collection.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class VectorSearchServiceGrpc {

  private VectorSearchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.vectorsearch.v1beta.VectorSearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest,
          com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
      getListCollectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCollections",
      requestType = com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest,
          com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
      getListCollectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest,
            com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
        getListCollectionsMethod;
    if ((getListCollectionsMethod = VectorSearchServiceGrpc.getListCollectionsMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getListCollectionsMethod = VectorSearchServiceGrpc.getListCollectionsMethod) == null) {
          VectorSearchServiceGrpc.getListCollectionsMethod =
              getListCollectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest,
                          com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCollections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("ListCollections"))
                      .build();
        }
      }
    }
    return getListCollectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.GetCollectionRequest,
          com.google.cloud.vectorsearch.v1beta.Collection>
      getGetCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCollection",
      requestType = com.google.cloud.vectorsearch.v1beta.GetCollectionRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.Collection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.GetCollectionRequest,
          com.google.cloud.vectorsearch.v1beta.Collection>
      getGetCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.GetCollectionRequest,
            com.google.cloud.vectorsearch.v1beta.Collection>
        getGetCollectionMethod;
    if ((getGetCollectionMethod = VectorSearchServiceGrpc.getGetCollectionMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getGetCollectionMethod = VectorSearchServiceGrpc.getGetCollectionMethod) == null) {
          VectorSearchServiceGrpc.getGetCollectionMethod =
              getGetCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.GetCollectionRequest,
                          com.google.cloud.vectorsearch.v1beta.Collection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.GetCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.Collection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("GetCollection"))
                      .build();
        }
      }
    }
    return getGetCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest,
          com.google.longrunning.Operation>
      getCreateCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCollection",
      requestType = com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest,
          com.google.longrunning.Operation>
      getCreateCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest,
            com.google.longrunning.Operation>
        getCreateCollectionMethod;
    if ((getCreateCollectionMethod = VectorSearchServiceGrpc.getCreateCollectionMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getCreateCollectionMethod = VectorSearchServiceGrpc.getCreateCollectionMethod)
            == null) {
          VectorSearchServiceGrpc.getCreateCollectionMethod =
              getCreateCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("CreateCollection"))
                      .build();
        }
      }
    }
    return getCreateCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest,
          com.google.longrunning.Operation>
      getUpdateCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCollection",
      requestType = com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest,
          com.google.longrunning.Operation>
      getUpdateCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest,
            com.google.longrunning.Operation>
        getUpdateCollectionMethod;
    if ((getUpdateCollectionMethod = VectorSearchServiceGrpc.getUpdateCollectionMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getUpdateCollectionMethod = VectorSearchServiceGrpc.getUpdateCollectionMethod)
            == null) {
          VectorSearchServiceGrpc.getUpdateCollectionMethod =
              getUpdateCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("UpdateCollection"))
                      .build();
        }
      }
    }
    return getUpdateCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest,
          com.google.longrunning.Operation>
      getDeleteCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCollection",
      requestType = com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest,
          com.google.longrunning.Operation>
      getDeleteCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest,
            com.google.longrunning.Operation>
        getDeleteCollectionMethod;
    if ((getDeleteCollectionMethod = VectorSearchServiceGrpc.getDeleteCollectionMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getDeleteCollectionMethod = VectorSearchServiceGrpc.getDeleteCollectionMethod)
            == null) {
          VectorSearchServiceGrpc.getDeleteCollectionMethod =
              getDeleteCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("DeleteCollection"))
                      .build();
        }
      }
    }
    return getDeleteCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.ListIndexesRequest,
          com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
      getListIndexesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIndexes",
      requestType = com.google.cloud.vectorsearch.v1beta.ListIndexesRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.ListIndexesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.ListIndexesRequest,
          com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
      getListIndexesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.ListIndexesRequest,
            com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
        getListIndexesMethod;
    if ((getListIndexesMethod = VectorSearchServiceGrpc.getListIndexesMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getListIndexesMethod = VectorSearchServiceGrpc.getListIndexesMethod) == null) {
          VectorSearchServiceGrpc.getListIndexesMethod =
              getListIndexesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.ListIndexesRequest,
                          com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIndexes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.ListIndexesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.ListIndexesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("ListIndexes"))
                      .build();
        }
      }
    }
    return getListIndexesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.GetIndexRequest,
          com.google.cloud.vectorsearch.v1beta.Index>
      getGetIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIndex",
      requestType = com.google.cloud.vectorsearch.v1beta.GetIndexRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.Index.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.GetIndexRequest,
          com.google.cloud.vectorsearch.v1beta.Index>
      getGetIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.GetIndexRequest,
            com.google.cloud.vectorsearch.v1beta.Index>
        getGetIndexMethod;
    if ((getGetIndexMethod = VectorSearchServiceGrpc.getGetIndexMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getGetIndexMethod = VectorSearchServiceGrpc.getGetIndexMethod) == null) {
          VectorSearchServiceGrpc.getGetIndexMethod =
              getGetIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.GetIndexRequest,
                          com.google.cloud.vectorsearch.v1beta.Index>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.GetIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.Index.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("GetIndex"))
                      .build();
        }
      }
    }
    return getGetIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIndex",
      requestType = com.google.cloud.vectorsearch.v1beta.CreateIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.CreateIndexRequest, com.google.longrunning.Operation>
      getCreateIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.CreateIndexRequest,
            com.google.longrunning.Operation>
        getCreateIndexMethod;
    if ((getCreateIndexMethod = VectorSearchServiceGrpc.getCreateIndexMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getCreateIndexMethod = VectorSearchServiceGrpc.getCreateIndexMethod) == null) {
          VectorSearchServiceGrpc.getCreateIndexMethod =
              getCreateIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.CreateIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.CreateIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("CreateIndex"))
                      .build();
        }
      }
    }
    return getCreateIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest, com.google.longrunning.Operation>
      getDeleteIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIndex",
      requestType = com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest, com.google.longrunning.Operation>
      getDeleteIndexMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest,
            com.google.longrunning.Operation>
        getDeleteIndexMethod;
    if ((getDeleteIndexMethod = VectorSearchServiceGrpc.getDeleteIndexMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getDeleteIndexMethod = VectorSearchServiceGrpc.getDeleteIndexMethod) == null) {
          VectorSearchServiceGrpc.getDeleteIndexMethod =
              getDeleteIndexMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIndex"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("DeleteIndex"))
                      .build();
        }
      }
    }
    return getDeleteIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest,
          com.google.longrunning.Operation>
      getImportDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest,
          com.google.longrunning.Operation>
      getImportDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest,
            com.google.longrunning.Operation>
        getImportDataObjectsMethod;
    if ((getImportDataObjectsMethod = VectorSearchServiceGrpc.getImportDataObjectsMethod) == null) {
      synchronized (VectorSearchServiceGrpc.class) {
        if ((getImportDataObjectsMethod = VectorSearchServiceGrpc.getImportDataObjectsMethod)
            == null) {
          VectorSearchServiceGrpc.getImportDataObjectsMethod =
              getImportDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VectorSearchServiceMethodDescriptorSupplier("ImportDataObjects"))
                      .build();
        }
      }
    }
    return getImportDataObjectsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VectorSearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceStub>() {
          @java.lang.Override
          public VectorSearchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VectorSearchServiceStub(channel, callOptions);
          }
        };
    return VectorSearchServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static VectorSearchServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceBlockingV2Stub>() {
          @java.lang.Override
          public VectorSearchServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VectorSearchServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return VectorSearchServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VectorSearchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceBlockingStub>() {
          @java.lang.Override
          public VectorSearchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VectorSearchServiceBlockingStub(channel, callOptions);
          }
        };
    return VectorSearchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VectorSearchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VectorSearchServiceFutureStub>() {
          @java.lang.Override
          public VectorSearchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VectorSearchServiceFutureStub(channel, callOptions);
          }
        };
    return VectorSearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * VectorSearchService provides methods for managing Collection resources, and
   * Collection Index resources. The primary resources offered by this service are
   * Collections which are a container for a set of related JSON data objects, and
   * Collection Indexes which enable efficient ANN search across data objects
   * within a Collection.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Collections in a given project and location.
     * </pre>
     */
    default void listCollections(
        com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCollectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collection.
     * </pre>
     */
    default void getCollection(
        com.google.cloud.vectorsearch.v1beta.GetCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.Collection>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Collection in a given project and location.
     * </pre>
     */
    default void createCollection(
        com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collection.
     * </pre>
     */
    default void updateCollection(
        com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collection.
     * </pre>
     */
    default void deleteCollection(
        com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Indexes in a given project and location.
     * </pre>
     */
    default void listIndexes(
        com.google.cloud.vectorsearch.v1beta.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIndexesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Index.
     * </pre>
     */
    default void getIndex(
        com.google.cloud.vectorsearch.v1beta.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.Index> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Index in a given project and location.
     * </pre>
     */
    default void createIndex(
        com.google.cloud.vectorsearch.v1beta.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Index.
     * </pre>
     */
    default void deleteIndex(
        com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIndexMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Long-Running Operation to import DataObjects into a Collection.
     * </pre>
     */
    default void importDataObjects(
        com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportDataObjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VectorSearchService.
   *
   * <pre>
   * VectorSearchService provides methods for managing Collection resources, and
   * Collection Index resources. The primary resources offered by this service are
   * Collections which are a container for a set of related JSON data objects, and
   * Collection Indexes which enable efficient ANN search across data objects
   * within a Collection.
   * </pre>
   */
  public abstract static class VectorSearchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VectorSearchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VectorSearchService.
   *
   * <pre>
   * VectorSearchService provides methods for managing Collection resources, and
   * Collection Index resources. The primary resources offered by this service are
   * Collections which are a container for a set of related JSON data objects, and
   * Collection Indexes which enable efficient ANN search across data objects
   * within a Collection.
   * </pre>
   */
  public static final class VectorSearchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VectorSearchServiceStub> {
    private VectorSearchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorSearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VectorSearchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Collections in a given project and location.
     * </pre>
     */
    public void listCollections(
        com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCollectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collection.
     * </pre>
     */
    public void getCollection(
        com.google.cloud.vectorsearch.v1beta.GetCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.Collection>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Collection in a given project and location.
     * </pre>
     */
    public void createCollection(
        com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collection.
     * </pre>
     */
    public void updateCollection(
        com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collection.
     * </pre>
     */
    public void deleteCollection(
        com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Indexes in a given project and location.
     * </pre>
     */
    public void listIndexes(
        com.google.cloud.vectorsearch.v1beta.ListIndexesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Index.
     * </pre>
     */
    public void getIndex(
        com.google.cloud.vectorsearch.v1beta.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.Index> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Index in a given project and location.
     * </pre>
     */
    public void createIndex(
        com.google.cloud.vectorsearch.v1beta.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Index.
     * </pre>
     */
    public void deleteIndex(
        com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Long-Running Operation to import DataObjects into a Collection.
     * </pre>
     */
    public void importDataObjects(
        com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VectorSearchService.
   *
   * <pre>
   * VectorSearchService provides methods for managing Collection resources, and
   * Collection Index resources. The primary resources offered by this service are
   * Collections which are a container for a set of related JSON data objects, and
   * Collection Indexes which enable efficient ANN search across data objects
   * within a Collection.
   * </pre>
   */
  public static final class VectorSearchServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<VectorSearchServiceBlockingV2Stub> {
    private VectorSearchServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorSearchServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VectorSearchServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Collections in a given project and location.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse listCollections(
        com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCollectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collection.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.Collection getCollection(
        com.google.cloud.vectorsearch.v1beta.GetCollectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Collection in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCollection(
        com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collection.
     * </pre>
     */
    public com.google.longrunning.Operation updateCollection(
        com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCollection(
        com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Indexes in a given project and location.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.ListIndexesResponse listIndexes(
        com.google.cloud.vectorsearch.v1beta.ListIndexesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListIndexesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Index.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.Index getIndex(
        com.google.cloud.vectorsearch.v1beta.GetIndexRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Index in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.cloud.vectorsearch.v1beta.CreateIndexRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Index.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIndex(
        com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Long-Running Operation to import DataObjects into a Collection.
     * </pre>
     */
    public com.google.longrunning.Operation importDataObjects(
        com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportDataObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service VectorSearchService.
   *
   * <pre>
   * VectorSearchService provides methods for managing Collection resources, and
   * Collection Index resources. The primary resources offered by this service are
   * Collections which are a container for a set of related JSON data objects, and
   * Collection Indexes which enable efficient ANN search across data objects
   * within a Collection.
   * </pre>
   */
  public static final class VectorSearchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VectorSearchServiceBlockingStub> {
    private VectorSearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorSearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VectorSearchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Collections in a given project and location.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse listCollections(
        com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCollectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collection.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.Collection getCollection(
        com.google.cloud.vectorsearch.v1beta.GetCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Collection in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCollection(
        com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collection.
     * </pre>
     */
    public com.google.longrunning.Operation updateCollection(
        com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCollection(
        com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Indexes in a given project and location.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.ListIndexesResponse listIndexes(
        com.google.cloud.vectorsearch.v1beta.ListIndexesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIndexesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Index.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.Index getIndex(
        com.google.cloud.vectorsearch.v1beta.GetIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Index in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createIndex(
        com.google.cloud.vectorsearch.v1beta.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Index.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIndex(
        com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIndexMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Long-Running Operation to import DataObjects into a Collection.
     * </pre>
     */
    public com.google.longrunning.Operation importDataObjects(
        com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VectorSearchService.
   *
   * <pre>
   * VectorSearchService provides methods for managing Collection resources, and
   * Collection Index resources. The primary resources offered by this service are
   * Collections which are a container for a set of related JSON data objects, and
   * Collection Indexes which enable efficient ANN search across data objects
   * within a Collection.
   * </pre>
   */
  public static final class VectorSearchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VectorSearchServiceFutureStub> {
    private VectorSearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorSearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VectorSearchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Collections in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>
        listCollections(com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCollectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.Collection>
        getCollection(com.google.cloud.vectorsearch.v1beta.GetCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Collection in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCollection(com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCollection(com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCollection(com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Indexes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>
        listIndexes(com.google.cloud.vectorsearch.v1beta.ListIndexesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIndexesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.Index>
        getIndex(com.google.cloud.vectorsearch.v1beta.GetIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Index in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIndex(com.google.cloud.vectorsearch.v1beta.CreateIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIndex(com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIndexMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a Long-Running Operation to import DataObjects into a Collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importDataObjects(com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataObjectsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_COLLECTIONS = 0;
  private static final int METHODID_GET_COLLECTION = 1;
  private static final int METHODID_CREATE_COLLECTION = 2;
  private static final int METHODID_UPDATE_COLLECTION = 3;
  private static final int METHODID_DELETE_COLLECTION = 4;
  private static final int METHODID_LIST_INDEXES = 5;
  private static final int METHODID_GET_INDEX = 6;
  private static final int METHODID_CREATE_INDEX = 7;
  private static final int METHODID_DELETE_INDEX = 8;
  private static final int METHODID_IMPORT_DATA_OBJECTS = 9;

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
        case METHODID_LIST_COLLECTIONS:
          serviceImpl.listCollections(
              (com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_COLLECTION:
          serviceImpl.getCollection(
              (com.google.cloud.vectorsearch.v1beta.GetCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.Collection>)
                  responseObserver);
          break;
        case METHODID_CREATE_COLLECTION:
          serviceImpl.createCollection(
              (com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_COLLECTION:
          serviceImpl.updateCollection(
              (com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_COLLECTION:
          serviceImpl.deleteCollection(
              (com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INDEXES:
          serviceImpl.listIndexes(
              (com.google.cloud.vectorsearch.v1beta.ListIndexesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INDEX:
          serviceImpl.getIndex(
              (com.google.cloud.vectorsearch.v1beta.GetIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.Index>)
                  responseObserver);
          break;
        case METHODID_CREATE_INDEX:
          serviceImpl.createIndex(
              (com.google.cloud.vectorsearch.v1beta.CreateIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INDEX:
          serviceImpl.deleteIndex(
              (com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DATA_OBJECTS:
          serviceImpl.importDataObjects(
              (com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest) request,
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
            getListCollectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest,
                    com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse>(
                    service, METHODID_LIST_COLLECTIONS)))
        .addMethod(
            getGetCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.GetCollectionRequest,
                    com.google.cloud.vectorsearch.v1beta.Collection>(
                    service, METHODID_GET_COLLECTION)))
        .addMethod(
            getCreateCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_COLLECTION)))
        .addMethod(
            getUpdateCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_COLLECTION)))
        .addMethod(
            getDeleteCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_COLLECTION)))
        .addMethod(
            getListIndexesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.ListIndexesRequest,
                    com.google.cloud.vectorsearch.v1beta.ListIndexesResponse>(
                    service, METHODID_LIST_INDEXES)))
        .addMethod(
            getGetIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.GetIndexRequest,
                    com.google.cloud.vectorsearch.v1beta.Index>(service, METHODID_GET_INDEX)))
        .addMethod(
            getCreateIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.CreateIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INDEX)))
        .addMethod(
            getDeleteIndexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INDEX)))
        .addMethod(
            getImportDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_DATA_OBJECTS)))
        .build();
  }

  private abstract static class VectorSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VectorSearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vectorsearch.v1beta.VectorSearchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VectorSearchService");
    }
  }

  private static final class VectorSearchServiceFileDescriptorSupplier
      extends VectorSearchServiceBaseDescriptorSupplier {
    VectorSearchServiceFileDescriptorSupplier() {}
  }

  private static final class VectorSearchServiceMethodDescriptorSupplier
      extends VectorSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VectorSearchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VectorSearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VectorSearchServiceFileDescriptorSupplier())
                      .addMethod(getListCollectionsMethod())
                      .addMethod(getGetCollectionMethod())
                      .addMethod(getCreateCollectionMethod())
                      .addMethod(getUpdateCollectionMethod())
                      .addMethod(getDeleteCollectionMethod())
                      .addMethod(getListIndexesMethod())
                      .addMethod(getGetIndexMethod())
                      .addMethod(getCreateIndexMethod())
                      .addMethod(getDeleteIndexMethod())
                      .addMethod(getImportDataObjectsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
