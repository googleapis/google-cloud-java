/*
 * Copyright 2025 Google LLC
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
 * Service for creating and managing data objects.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataObjectServiceGrpc {

  private DataObjectServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.vectorsearch.v1beta.DataObjectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest,
          com.google.cloud.vectorsearch.v1beta.DataObject>
      getCreateDataObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataObject",
      requestType = com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.DataObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest,
          com.google.cloud.vectorsearch.v1beta.DataObject>
      getCreateDataObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest,
            com.google.cloud.vectorsearch.v1beta.DataObject>
        getCreateDataObjectMethod;
    if ((getCreateDataObjectMethod = DataObjectServiceGrpc.getCreateDataObjectMethod) == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getCreateDataObjectMethod = DataObjectServiceGrpc.getCreateDataObjectMethod) == null) {
          DataObjectServiceGrpc.getCreateDataObjectMethod =
              getCreateDataObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest,
                          com.google.cloud.vectorsearch.v1beta.DataObject>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.DataObject.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("CreateDataObject"))
                      .build();
        }
      }
    }
    return getCreateDataObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
      getBatchCreateDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
      getBatchCreateDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest,
            com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
        getBatchCreateDataObjectsMethod;
    if ((getBatchCreateDataObjectsMethod = DataObjectServiceGrpc.getBatchCreateDataObjectsMethod)
        == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getBatchCreateDataObjectsMethod =
                DataObjectServiceGrpc.getBatchCreateDataObjectsMethod)
            == null) {
          DataObjectServiceGrpc.getBatchCreateDataObjectsMethod =
              getBatchCreateDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest,
                          com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("BatchCreateDataObjects"))
                      .build();
        }
      }
    }
    return getBatchCreateDataObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest,
          com.google.cloud.vectorsearch.v1beta.DataObject>
      getGetDataObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataObject",
      requestType = com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.DataObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest,
          com.google.cloud.vectorsearch.v1beta.DataObject>
      getGetDataObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest,
            com.google.cloud.vectorsearch.v1beta.DataObject>
        getGetDataObjectMethod;
    if ((getGetDataObjectMethod = DataObjectServiceGrpc.getGetDataObjectMethod) == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getGetDataObjectMethod = DataObjectServiceGrpc.getGetDataObjectMethod) == null) {
          DataObjectServiceGrpc.getGetDataObjectMethod =
              getGetDataObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest,
                          com.google.cloud.vectorsearch.v1beta.DataObject>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.DataObject.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("GetDataObject"))
                      .build();
        }
      }
    }
    return getGetDataObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest,
          com.google.cloud.vectorsearch.v1beta.DataObject>
      getUpdateDataObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataObject",
      requestType = com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.DataObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest,
          com.google.cloud.vectorsearch.v1beta.DataObject>
      getUpdateDataObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest,
            com.google.cloud.vectorsearch.v1beta.DataObject>
        getUpdateDataObjectMethod;
    if ((getUpdateDataObjectMethod = DataObjectServiceGrpc.getUpdateDataObjectMethod) == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getUpdateDataObjectMethod = DataObjectServiceGrpc.getUpdateDataObjectMethod) == null) {
          DataObjectServiceGrpc.getUpdateDataObjectMethod =
              getUpdateDataObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest,
                          com.google.cloud.vectorsearch.v1beta.DataObject>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.DataObject.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("UpdateDataObject"))
                      .build();
        }
      }
    }
    return getUpdateDataObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
      getBatchUpdateDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest.class,
      responseType = com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest,
          com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
      getBatchUpdateDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest,
            com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
        getBatchUpdateDataObjectsMethod;
    if ((getBatchUpdateDataObjectsMethod = DataObjectServiceGrpc.getBatchUpdateDataObjectsMethod)
        == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getBatchUpdateDataObjectsMethod =
                DataObjectServiceGrpc.getBatchUpdateDataObjectsMethod)
            == null) {
          DataObjectServiceGrpc.getBatchUpdateDataObjectsMethod =
              getBatchUpdateDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest,
                          com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("BatchUpdateDataObjects"))
                      .build();
        }
      }
    }
    return getBatchUpdateDataObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest, com.google.protobuf.Empty>
      getDeleteDataObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataObject",
      requestType = com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest, com.google.protobuf.Empty>
      getDeleteDataObjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest, com.google.protobuf.Empty>
        getDeleteDataObjectMethod;
    if ((getDeleteDataObjectMethod = DataObjectServiceGrpc.getDeleteDataObjectMethod) == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getDeleteDataObjectMethod = DataObjectServiceGrpc.getDeleteDataObjectMethod) == null) {
          DataObjectServiceGrpc.getDeleteDataObjectMethod =
              getDeleteDataObjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataObject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("DeleteDataObject"))
                      .build();
        }
      }
    }
    return getDeleteDataObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteDataObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteDataObjects",
      requestType = com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest,
          com.google.protobuf.Empty>
      getBatchDeleteDataObjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest,
            com.google.protobuf.Empty>
        getBatchDeleteDataObjectsMethod;
    if ((getBatchDeleteDataObjectsMethod = DataObjectServiceGrpc.getBatchDeleteDataObjectsMethod)
        == null) {
      synchronized (DataObjectServiceGrpc.class) {
        if ((getBatchDeleteDataObjectsMethod =
                DataObjectServiceGrpc.getBatchDeleteDataObjectsMethod)
            == null) {
          DataObjectServiceGrpc.getBatchDeleteDataObjectsMethod =
              getBatchDeleteDataObjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteDataObjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataObjectServiceMethodDescriptorSupplier("BatchDeleteDataObjects"))
                      .build();
        }
      }
    }
    return getBatchDeleteDataObjectsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataObjectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceStub>() {
          @java.lang.Override
          public DataObjectServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectServiceStub(channel, callOptions);
          }
        };
    return DataObjectServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataObjectServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataObjectServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataObjectServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataObjectServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceBlockingStub>() {
          @java.lang.Override
          public DataObjectServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectServiceBlockingStub(channel, callOptions);
          }
        };
    return DataObjectServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataObjectServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataObjectServiceFutureStub>() {
          @java.lang.Override
          public DataObjectServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataObjectServiceFutureStub(channel, callOptions);
          }
        };
    return DataObjectServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for creating and managing data objects.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a dataObject.
     * </pre>
     */
    default void createDataObject(
        com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of dataObjects.
     * </pre>
     */
    default void batchCreateDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateDataObjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data object.
     * </pre>
     */
    default void getDataObject(
        com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataObject.
     * </pre>
     */
    default void updateDataObject(
        com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates dataObjects in a batch.
     * </pre>
     */
    default void batchUpdateDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdateDataObjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataObject.
     * </pre>
     */
    default void deleteDataObject(
        com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataObjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes dataObjects in a batch.
     * </pre>
     */
    default void batchDeleteDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteDataObjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataObjectService.
   *
   * <pre>
   * Service for creating and managing data objects.
   * </pre>
   */
  public abstract static class DataObjectServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataObjectServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataObjectService.
   *
   * <pre>
   * Service for creating and managing data objects.
   * </pre>
   */
  public static final class DataObjectServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataObjectServiceStub> {
    private DataObjectServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataObject.
     * </pre>
     */
    public void createDataObject(
        com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of dataObjects.
     * </pre>
     */
    public void batchCreateDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data object.
     * </pre>
     */
    public void getDataObject(
        com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataObject.
     * </pre>
     */
    public void updateDataObject(
        com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates dataObjects in a batch.
     * </pre>
     */
    public void batchUpdateDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataObject.
     * </pre>
     */
    public void deleteDataObject(
        com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataObjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes dataObjects in a batch.
     * </pre>
     */
    public void batchDeleteDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteDataObjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataObjectService.
   *
   * <pre>
   * Service for creating and managing data objects.
   * </pre>
   */
  public static final class DataObjectServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataObjectServiceBlockingV2Stub> {
    private DataObjectServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataObject.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.DataObject createDataObject(
        com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of dataObjects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse
        batchCreateDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchCreateDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data object.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.DataObject getDataObject(
        com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataObject.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.DataObject updateDataObject(
        com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates dataObjects in a batch.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse
        batchUpdateDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchUpdateDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataObject.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataObject(
        com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes dataObjects in a batch.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchDeleteDataObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataObjectService.
   *
   * <pre>
   * Service for creating and managing data objects.
   * </pre>
   */
  public static final class DataObjectServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataObjectServiceBlockingStub> {
    private DataObjectServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataObject.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.DataObject createDataObject(
        com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of dataObjects.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse
        batchCreateDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data object.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.DataObject getDataObject(
        com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataObject.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.DataObject updateDataObject(
        com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates dataObjects in a batch.
     * </pre>
     */
    public com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse
        batchUpdateDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateDataObjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataObject.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataObject(
        com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataObjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes dataObjects in a batch.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteDataObjects(
        com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteDataObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataObjectService.
   *
   * <pre>
   * Service for creating and managing data objects.
   * </pre>
   */
  public static final class DataObjectServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataObjectServiceFutureStub> {
    private DataObjectServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataObjectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataObjectServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a dataObject.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.DataObject>
        createDataObject(com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of dataObjects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>
        batchCreateDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateDataObjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.DataObject>
        getDataObject(com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a dataObject.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.DataObject>
        updateDataObject(com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates dataObjects in a batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>
        batchUpdateDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateDataObjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a dataObject.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataObject(com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataObjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes dataObjects in a batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteDataObjects(
            com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteDataObjectsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_OBJECT = 0;
  private static final int METHODID_BATCH_CREATE_DATA_OBJECTS = 1;
  private static final int METHODID_GET_DATA_OBJECT = 2;
  private static final int METHODID_UPDATE_DATA_OBJECT = 3;
  private static final int METHODID_BATCH_UPDATE_DATA_OBJECTS = 4;
  private static final int METHODID_DELETE_DATA_OBJECT = 5;
  private static final int METHODID_BATCH_DELETE_DATA_OBJECTS = 6;

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
        case METHODID_CREATE_DATA_OBJECT:
          serviceImpl.createDataObject(
              (com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_DATA_OBJECTS:
          serviceImpl.batchCreateDataObjects(
              (com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_OBJECT:
          serviceImpl.getDataObject(
              (com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_OBJECT:
          serviceImpl.updateDataObject(
              (com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vectorsearch.v1beta.DataObject>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_DATA_OBJECTS:
          serviceImpl.batchUpdateDataObjects(
              (com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_OBJECT:
          serviceImpl.deleteDataObject(
              (com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_DATA_OBJECTS:
          serviceImpl.batchDeleteDataObjects(
              (com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getCreateDataObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest,
                    com.google.cloud.vectorsearch.v1beta.DataObject>(
                    service, METHODID_CREATE_DATA_OBJECT)))
        .addMethod(
            getBatchCreateDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest,
                    com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse>(
                    service, METHODID_BATCH_CREATE_DATA_OBJECTS)))
        .addMethod(
            getGetDataObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest,
                    com.google.cloud.vectorsearch.v1beta.DataObject>(
                    service, METHODID_GET_DATA_OBJECT)))
        .addMethod(
            getUpdateDataObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest,
                    com.google.cloud.vectorsearch.v1beta.DataObject>(
                    service, METHODID_UPDATE_DATA_OBJECT)))
        .addMethod(
            getBatchUpdateDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest,
                    com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse>(
                    service, METHODID_BATCH_UPDATE_DATA_OBJECTS)))
        .addMethod(
            getDeleteDataObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATA_OBJECT)))
        .addMethod(
            getBatchDeleteDataObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest,
                    com.google.protobuf.Empty>(service, METHODID_BATCH_DELETE_DATA_OBJECTS)))
        .build();
  }

  private abstract static class DataObjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataObjectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vectorsearch.v1beta.DataObjectServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataObjectService");
    }
  }

  private static final class DataObjectServiceFileDescriptorSupplier
      extends DataObjectServiceBaseDescriptorSupplier {
    DataObjectServiceFileDescriptorSupplier() {}
  }

  private static final class DataObjectServiceMethodDescriptorSupplier
      extends DataObjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataObjectServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataObjectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataObjectServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataObjectMethod())
                      .addMethod(getBatchCreateDataObjectsMethod())
                      .addMethod(getGetDataObjectMethod())
                      .addMethod(getUpdateDataObjectMethod())
                      .addMethod(getBatchUpdateDataObjectsMethod())
                      .addMethod(getDeleteDataObjectMethod())
                      .addMethod(getBatchDeleteDataObjectsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
