/*
 * Copyright 2024 Google LLC
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
package com.google.maps.mapsplatformdatasets.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service definition for the Maps Platform Datasets API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/mapsplatformdatasets/v1/maps_platform_datasets_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MapsPlatformDatasetsGrpc {

  private MapsPlatformDatasetsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.maps.mapsplatformdatasets.v1.MapsPlatformDatasets";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest,
          com.google.maps.mapsplatformdatasets.v1.Dataset>
      getCreateDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataset",
      requestType = com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest.class,
      responseType = com.google.maps.mapsplatformdatasets.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest,
          com.google.maps.mapsplatformdatasets.v1.Dataset>
      getCreateDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest,
            com.google.maps.mapsplatformdatasets.v1.Dataset>
        getCreateDatasetMethod;
    if ((getCreateDatasetMethod = MapsPlatformDatasetsGrpc.getCreateDatasetMethod) == null) {
      synchronized (MapsPlatformDatasetsGrpc.class) {
        if ((getCreateDatasetMethod = MapsPlatformDatasetsGrpc.getCreateDatasetMethod) == null) {
          MapsPlatformDatasetsGrpc.getCreateDatasetMethod =
              getCreateDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest,
                          com.google.maps.mapsplatformdatasets.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapsPlatformDatasetsMethodDescriptorSupplier("CreateDataset"))
                      .build();
        }
      }
    }
    return getCreateDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest,
          com.google.maps.mapsplatformdatasets.v1.Dataset>
      getUpdateDatasetMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatasetMetadata",
      requestType = com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest.class,
      responseType = com.google.maps.mapsplatformdatasets.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest,
          com.google.maps.mapsplatformdatasets.v1.Dataset>
      getUpdateDatasetMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest,
            com.google.maps.mapsplatformdatasets.v1.Dataset>
        getUpdateDatasetMetadataMethod;
    if ((getUpdateDatasetMetadataMethod = MapsPlatformDatasetsGrpc.getUpdateDatasetMetadataMethod)
        == null) {
      synchronized (MapsPlatformDatasetsGrpc.class) {
        if ((getUpdateDatasetMetadataMethod =
                MapsPlatformDatasetsGrpc.getUpdateDatasetMetadataMethod)
            == null) {
          MapsPlatformDatasetsGrpc.getUpdateDatasetMetadataMethod =
              getUpdateDatasetMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest,
                          com.google.maps.mapsplatformdatasets.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDatasetMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapsPlatformDatasetsMethodDescriptorSupplier("UpdateDatasetMetadata"))
                      .build();
        }
      }
    }
    return getUpdateDatasetMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest,
          com.google.maps.mapsplatformdatasets.v1.Dataset>
      getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest.class,
      responseType = com.google.maps.mapsplatformdatasets.v1.Dataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest,
          com.google.maps.mapsplatformdatasets.v1.Dataset>
      getGetDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest,
            com.google.maps.mapsplatformdatasets.v1.Dataset>
        getGetDatasetMethod;
    if ((getGetDatasetMethod = MapsPlatformDatasetsGrpc.getGetDatasetMethod) == null) {
      synchronized (MapsPlatformDatasetsGrpc.class) {
        if ((getGetDatasetMethod = MapsPlatformDatasetsGrpc.getGetDatasetMethod) == null) {
          MapsPlatformDatasetsGrpc.getGetDatasetMethod =
              getGetDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest,
                          com.google.maps.mapsplatformdatasets.v1.Dataset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.Dataset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapsPlatformDatasetsMethodDescriptorSupplier("GetDataset"))
                      .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest,
          com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
      getListDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatasets",
      requestType = com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest.class,
      responseType = com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest,
          com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
      getListDatasetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest,
            com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
        getListDatasetsMethod;
    if ((getListDatasetsMethod = MapsPlatformDatasetsGrpc.getListDatasetsMethod) == null) {
      synchronized (MapsPlatformDatasetsGrpc.class) {
        if ((getListDatasetsMethod = MapsPlatformDatasetsGrpc.getListDatasetsMethod) == null) {
          MapsPlatformDatasetsGrpc.getListDatasetsMethod =
              getListDatasetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest,
                          com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatasets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapsPlatformDatasetsMethodDescriptorSupplier("ListDatasets"))
                      .build();
        }
      }
    }
    return getListDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest, com.google.protobuf.Empty>
      getDeleteDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataset",
      requestType = com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest, com.google.protobuf.Empty>
      getDeleteDatasetMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest, com.google.protobuf.Empty>
        getDeleteDatasetMethod;
    if ((getDeleteDatasetMethod = MapsPlatformDatasetsGrpc.getDeleteDatasetMethod) == null) {
      synchronized (MapsPlatformDatasetsGrpc.class) {
        if ((getDeleteDatasetMethod = MapsPlatformDatasetsGrpc.getDeleteDatasetMethod) == null) {
          MapsPlatformDatasetsGrpc.getDeleteDatasetMethod =
              getDeleteDatasetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MapsPlatformDatasetsMethodDescriptorSupplier("DeleteDataset"))
                      .build();
        }
      }
    }
    return getDeleteDatasetMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MapsPlatformDatasetsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapsPlatformDatasetsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapsPlatformDatasetsStub>() {
          @java.lang.Override
          public MapsPlatformDatasetsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapsPlatformDatasetsStub(channel, callOptions);
          }
        };
    return MapsPlatformDatasetsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MapsPlatformDatasetsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapsPlatformDatasetsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapsPlatformDatasetsBlockingStub>() {
          @java.lang.Override
          public MapsPlatformDatasetsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapsPlatformDatasetsBlockingStub(channel, callOptions);
          }
        };
    return MapsPlatformDatasetsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MapsPlatformDatasetsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MapsPlatformDatasetsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MapsPlatformDatasetsFutureStub>() {
          @java.lang.Override
          public MapsPlatformDatasetsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MapsPlatformDatasetsFutureStub(channel, callOptions);
          }
        };
    return MapsPlatformDatasetsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service definition for the Maps Platform Datasets API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new dataset for the specified project.
     * </pre>
     */
    default void createDataset(
        com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for the dataset.
     * </pre>
     */
    default void updateDatasetMetadata(
        com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatasetMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset.
     * </pre>
     */
    default void getDataset(
        com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the datasets for the specified project.
     * </pre>
     */
    default void listDatasets(
        com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatasetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified dataset.
     * </pre>
     */
    default void deleteDataset(
        com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatasetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MapsPlatformDatasets.
   *
   * <pre>
   * Service definition for the Maps Platform Datasets API.
   * </pre>
   */
  public abstract static class MapsPlatformDatasetsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MapsPlatformDatasetsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MapsPlatformDatasets.
   *
   * <pre>
   * Service definition for the Maps Platform Datasets API.
   * </pre>
   */
  public static final class MapsPlatformDatasetsStub
      extends io.grpc.stub.AbstractAsyncStub<MapsPlatformDatasetsStub> {
    private MapsPlatformDatasetsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapsPlatformDatasetsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapsPlatformDatasetsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new dataset for the specified project.
     * </pre>
     */
    public void createDataset(
        com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for the dataset.
     * </pre>
     */
    public void updateDatasetMetadata(
        com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatasetMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset.
     * </pre>
     */
    public void getDataset(
        com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the datasets for the specified project.
     * </pre>
     */
    public void listDatasets(
        com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified dataset.
     * </pre>
     */
    public void deleteDataset(
        com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MapsPlatformDatasets.
   *
   * <pre>
   * Service definition for the Maps Platform Datasets API.
   * </pre>
   */
  public static final class MapsPlatformDatasetsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MapsPlatformDatasetsBlockingStub> {
    private MapsPlatformDatasetsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapsPlatformDatasetsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapsPlatformDatasetsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new dataset for the specified project.
     * </pre>
     */
    public com.google.maps.mapsplatformdatasets.v1.Dataset createDataset(
        com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for the dataset.
     * </pre>
     */
    public com.google.maps.mapsplatformdatasets.v1.Dataset updateDatasetMetadata(
        com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatasetMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset.
     * </pre>
     */
    public com.google.maps.mapsplatformdatasets.v1.Dataset getDataset(
        com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the datasets for the specified project.
     * </pre>
     */
    public com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse listDatasets(
        com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatasetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified dataset.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataset(
        com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatasetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MapsPlatformDatasets.
   *
   * <pre>
   * Service definition for the Maps Platform Datasets API.
   * </pre>
   */
  public static final class MapsPlatformDatasetsFutureStub
      extends io.grpc.stub.AbstractFutureStub<MapsPlatformDatasetsFutureStub> {
    private MapsPlatformDatasetsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MapsPlatformDatasetsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MapsPlatformDatasetsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new dataset for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapsplatformdatasets.v1.Dataset>
        createDataset(com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for the dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapsplatformdatasets.v1.Dataset>
        updateDatasetMetadata(
            com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatasetMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapsplatformdatasets.v1.Dataset>
        getDataset(com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the datasets for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>
        listDatasets(com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatasetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataset(com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatasetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATASET = 0;
  private static final int METHODID_UPDATE_DATASET_METADATA = 1;
  private static final int METHODID_GET_DATASET = 2;
  private static final int METHODID_LIST_DATASETS = 3;
  private static final int METHODID_DELETE_DATASET = 4;

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
        case METHODID_CREATE_DATASET:
          serviceImpl.createDataset(
              (com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATASET_METADATA:
          serviceImpl.updateDatasetMetadata(
              (com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset(
              (com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.mapsplatformdatasets.v1.Dataset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATASETS:
          serviceImpl.listDatasets(
              (com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATASET:
          serviceImpl.deleteDataset(
              (com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest) request,
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
            getCreateDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest,
                    com.google.maps.mapsplatformdatasets.v1.Dataset>(
                    service, METHODID_CREATE_DATASET)))
        .addMethod(
            getUpdateDatasetMetadataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest,
                    com.google.maps.mapsplatformdatasets.v1.Dataset>(
                    service, METHODID_UPDATE_DATASET_METADATA)))
        .addMethod(
            getGetDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest,
                    com.google.maps.mapsplatformdatasets.v1.Dataset>(
                    service, METHODID_GET_DATASET)))
        .addMethod(
            getListDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest,
                    com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse>(
                    service, METHODID_LIST_DATASETS)))
        .addMethod(
            getDeleteDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DATASET)))
        .build();
  }

  private abstract static class MapsPlatformDatasetsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MapsPlatformDatasetsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.mapsplatformdatasets.v1.MapsPlatformDatasetsServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MapsPlatformDatasets");
    }
  }

  private static final class MapsPlatformDatasetsFileDescriptorSupplier
      extends MapsPlatformDatasetsBaseDescriptorSupplier {
    MapsPlatformDatasetsFileDescriptorSupplier() {}
  }

  private static final class MapsPlatformDatasetsMethodDescriptorSupplier
      extends MapsPlatformDatasetsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MapsPlatformDatasetsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MapsPlatformDatasetsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MapsPlatformDatasetsFileDescriptorSupplier())
                      .addMethod(getCreateDatasetMethod())
                      .addMethod(getUpdateDatasetMetadataMethod())
                      .addMethod(getGetDatasetMethod())
                      .addMethod(getListDatasetsMethod())
                      .addMethod(getDeleteDatasetMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
