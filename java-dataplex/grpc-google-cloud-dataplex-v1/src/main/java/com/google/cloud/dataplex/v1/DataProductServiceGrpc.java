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
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * `DataProductService` provides APIs for managing data products and
 * the underlying data assets.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DataProductServiceGrpc {

  private DataProductServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dataplex.v1.DataProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataProductRequest, com.google.longrunning.Operation>
      getCreateDataProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataProduct",
      requestType = com.google.cloud.dataplex.v1.CreateDataProductRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataProductRequest, com.google.longrunning.Operation>
      getCreateDataProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateDataProductRequest, com.google.longrunning.Operation>
        getCreateDataProductMethod;
    if ((getCreateDataProductMethod = DataProductServiceGrpc.getCreateDataProductMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getCreateDataProductMethod = DataProductServiceGrpc.getCreateDataProductMethod)
            == null) {
          DataProductServiceGrpc.getCreateDataProductMethod =
              getCreateDataProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateDataProductRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateDataProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("CreateDataProduct"))
                      .build();
        }
      }
    }
    return getCreateDataProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataProductRequest, com.google.longrunning.Operation>
      getDeleteDataProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataProduct",
      requestType = com.google.cloud.dataplex.v1.DeleteDataProductRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataProductRequest, com.google.longrunning.Operation>
      getDeleteDataProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteDataProductRequest, com.google.longrunning.Operation>
        getDeleteDataProductMethod;
    if ((getDeleteDataProductMethod = DataProductServiceGrpc.getDeleteDataProductMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getDeleteDataProductMethod = DataProductServiceGrpc.getDeleteDataProductMethod)
            == null) {
          DataProductServiceGrpc.getDeleteDataProductMethod =
              getDeleteDataProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteDataProductRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteDataProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("DeleteDataProduct"))
                      .build();
        }
      }
    }
    return getDeleteDataProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataProductRequest,
          com.google.cloud.dataplex.v1.DataProduct>
      getGetDataProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataProduct",
      requestType = com.google.cloud.dataplex.v1.GetDataProductRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataProductRequest,
          com.google.cloud.dataplex.v1.DataProduct>
      getGetDataProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataProductRequest,
            com.google.cloud.dataplex.v1.DataProduct>
        getGetDataProductMethod;
    if ((getGetDataProductMethod = DataProductServiceGrpc.getGetDataProductMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getGetDataProductMethod = DataProductServiceGrpc.getGetDataProductMethod) == null) {
          DataProductServiceGrpc.getGetDataProductMethod =
              getGetDataProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataProductRequest,
                          com.google.cloud.dataplex.v1.DataProduct>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataProduct.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("GetDataProduct"))
                      .build();
        }
      }
    }
    return getGetDataProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataProductsRequest,
          com.google.cloud.dataplex.v1.ListDataProductsResponse>
      getListDataProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataProducts",
      requestType = com.google.cloud.dataplex.v1.ListDataProductsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataProductsRequest,
          com.google.cloud.dataplex.v1.ListDataProductsResponse>
      getListDataProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataProductsRequest,
            com.google.cloud.dataplex.v1.ListDataProductsResponse>
        getListDataProductsMethod;
    if ((getListDataProductsMethod = DataProductServiceGrpc.getListDataProductsMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getListDataProductsMethod = DataProductServiceGrpc.getListDataProductsMethod)
            == null) {
          DataProductServiceGrpc.getListDataProductsMethod =
              getListDataProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataProductsRequest,
                          com.google.cloud.dataplex.v1.ListDataProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("ListDataProducts"))
                      .build();
        }
      }
    }
    return getListDataProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataProductRequest, com.google.longrunning.Operation>
      getUpdateDataProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataProduct",
      requestType = com.google.cloud.dataplex.v1.UpdateDataProductRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataProductRequest, com.google.longrunning.Operation>
      getUpdateDataProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateDataProductRequest, com.google.longrunning.Operation>
        getUpdateDataProductMethod;
    if ((getUpdateDataProductMethod = DataProductServiceGrpc.getUpdateDataProductMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getUpdateDataProductMethod = DataProductServiceGrpc.getUpdateDataProductMethod)
            == null) {
          DataProductServiceGrpc.getUpdateDataProductMethod =
              getUpdateDataProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateDataProductRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateDataProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("UpdateDataProduct"))
                      .build();
        }
      }
    }
    return getUpdateDataProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataAssetRequest, com.google.longrunning.Operation>
      getCreateDataAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataAsset",
      requestType = com.google.cloud.dataplex.v1.CreateDataAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataAssetRequest, com.google.longrunning.Operation>
      getCreateDataAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateDataAssetRequest, com.google.longrunning.Operation>
        getCreateDataAssetMethod;
    if ((getCreateDataAssetMethod = DataProductServiceGrpc.getCreateDataAssetMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getCreateDataAssetMethod = DataProductServiceGrpc.getCreateDataAssetMethod) == null) {
          DataProductServiceGrpc.getCreateDataAssetMethod =
              getCreateDataAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateDataAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateDataAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("CreateDataAsset"))
                      .build();
        }
      }
    }
    return getCreateDataAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataAssetRequest, com.google.longrunning.Operation>
      getUpdateDataAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataAsset",
      requestType = com.google.cloud.dataplex.v1.UpdateDataAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataAssetRequest, com.google.longrunning.Operation>
      getUpdateDataAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateDataAssetRequest, com.google.longrunning.Operation>
        getUpdateDataAssetMethod;
    if ((getUpdateDataAssetMethod = DataProductServiceGrpc.getUpdateDataAssetMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getUpdateDataAssetMethod = DataProductServiceGrpc.getUpdateDataAssetMethod) == null) {
          DataProductServiceGrpc.getUpdateDataAssetMethod =
              getUpdateDataAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateDataAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateDataAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("UpdateDataAsset"))
                      .build();
        }
      }
    }
    return getUpdateDataAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataAssetRequest, com.google.longrunning.Operation>
      getDeleteDataAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataAsset",
      requestType = com.google.cloud.dataplex.v1.DeleteDataAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataAssetRequest, com.google.longrunning.Operation>
      getDeleteDataAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteDataAssetRequest, com.google.longrunning.Operation>
        getDeleteDataAssetMethod;
    if ((getDeleteDataAssetMethod = DataProductServiceGrpc.getDeleteDataAssetMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getDeleteDataAssetMethod = DataProductServiceGrpc.getDeleteDataAssetMethod) == null) {
          DataProductServiceGrpc.getDeleteDataAssetMethod =
              getDeleteDataAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteDataAssetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteDataAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("DeleteDataAsset"))
                      .build();
        }
      }
    }
    return getDeleteDataAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataAssetRequest, com.google.cloud.dataplex.v1.DataAsset>
      getGetDataAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataAsset",
      requestType = com.google.cloud.dataplex.v1.GetDataAssetRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataAsset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataAssetRequest, com.google.cloud.dataplex.v1.DataAsset>
      getGetDataAssetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataAssetRequest,
            com.google.cloud.dataplex.v1.DataAsset>
        getGetDataAssetMethod;
    if ((getGetDataAssetMethod = DataProductServiceGrpc.getGetDataAssetMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getGetDataAssetMethod = DataProductServiceGrpc.getGetDataAssetMethod) == null) {
          DataProductServiceGrpc.getGetDataAssetMethod =
              getGetDataAssetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataAssetRequest,
                          com.google.cloud.dataplex.v1.DataAsset>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataAsset"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataAssetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataAsset.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("GetDataAsset"))
                      .build();
        }
      }
    }
    return getGetDataAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataAssetsRequest,
          com.google.cloud.dataplex.v1.ListDataAssetsResponse>
      getListDataAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataAssets",
      requestType = com.google.cloud.dataplex.v1.ListDataAssetsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataAssetsRequest,
          com.google.cloud.dataplex.v1.ListDataAssetsResponse>
      getListDataAssetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataAssetsRequest,
            com.google.cloud.dataplex.v1.ListDataAssetsResponse>
        getListDataAssetsMethod;
    if ((getListDataAssetsMethod = DataProductServiceGrpc.getListDataAssetsMethod) == null) {
      synchronized (DataProductServiceGrpc.class) {
        if ((getListDataAssetsMethod = DataProductServiceGrpc.getListDataAssetsMethod) == null) {
          DataProductServiceGrpc.getListDataAssetsMethod =
              getListDataAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataAssetsRequest,
                          com.google.cloud.dataplex.v1.ListDataAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataProductServiceMethodDescriptorSupplier("ListDataAssets"))
                      .build();
        }
      }
    }
    return getListDataAssetsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataProductServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataProductServiceStub>() {
          @java.lang.Override
          public DataProductServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataProductServiceStub(channel, callOptions);
          }
        };
    return DataProductServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DataProductServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataProductServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataProductServiceBlockingV2Stub>() {
          @java.lang.Override
          public DataProductServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataProductServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DataProductServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataProductServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataProductServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataProductServiceBlockingStub>() {
          @java.lang.Override
          public DataProductServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataProductServiceBlockingStub(channel, callOptions);
          }
        };
    return DataProductServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataProductServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataProductServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataProductServiceFutureStub>() {
          @java.lang.Override
          public DataProductServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataProductServiceFutureStub(channel, callOptions);
          }
        };
    return DataProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * `DataProductService` provides APIs for managing data products and
   * the underlying data assets.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a data product.
     * </pre>
     */
    default void createDataProduct(
        com.google.cloud.dataplex.v1.CreateDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data product. The deletion will fail if the data product is not
     * empty (i.e. contains at least one data asset).
     * </pre>
     */
    default void deleteDataProduct(
        com.google.cloud.dataplex.v1.DeleteDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data product.
     * </pre>
     */
    default void getDataProduct(
        com.google.cloud.dataplex.v1.GetDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists data products for a given project.
     * </pre>
     */
    default void listDataProducts(
        com.google.cloud.dataplex.v1.ListDataProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data product.
     * </pre>
     */
    default void updateDataProduct(
        com.google.cloud.dataplex.v1.UpdateDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a data asset.
     * </pre>
     */
    default void createDataAsset(
        com.google.cloud.dataplex.v1.CreateDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data asset.
     * </pre>
     */
    default void updateDataAsset(
        com.google.cloud.dataplex.v1.UpdateDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data asset.
     * </pre>
     */
    default void deleteDataAsset(
        com.google.cloud.dataplex.v1.DeleteDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data asset.
     * </pre>
     */
    default void getDataAsset(
        com.google.cloud.dataplex.v1.GetDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAsset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataAssetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists data assets for a given data product.
     * </pre>
     */
    default void listDataAssets(
        com.google.cloud.dataplex.v1.ListDataAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAssetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataAssetsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataProductService.
   *
   * <pre>
   * `DataProductService` provides APIs for managing data products and
   * the underlying data assets.
   * </pre>
   */
  public abstract static class DataProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataProductService.
   *
   * <pre>
   * `DataProductService` provides APIs for managing data products and
   * the underlying data assets.
   * </pre>
   */
  public static final class DataProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataProductServiceStub> {
    private DataProductServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataProductServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data product.
     * </pre>
     */
    public void createDataProduct(
        com.google.cloud.dataplex.v1.CreateDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data product. The deletion will fail if the data product is not
     * empty (i.e. contains at least one data asset).
     * </pre>
     */
    public void deleteDataProduct(
        com.google.cloud.dataplex.v1.DeleteDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data product.
     * </pre>
     */
    public void getDataProduct(
        com.google.cloud.dataplex.v1.GetDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists data products for a given project.
     * </pre>
     */
    public void listDataProducts(
        com.google.cloud.dataplex.v1.ListDataProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data product.
     * </pre>
     */
    public void updateDataProduct(
        com.google.cloud.dataplex.v1.UpdateDataProductRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a data asset.
     * </pre>
     */
    public void createDataAsset(
        com.google.cloud.dataplex.v1.CreateDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a data asset.
     * </pre>
     */
    public void updateDataAsset(
        com.google.cloud.dataplex.v1.UpdateDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data asset.
     * </pre>
     */
    public void deleteDataAsset(
        com.google.cloud.dataplex.v1.DeleteDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a data asset.
     * </pre>
     */
    public void getDataAsset(
        com.google.cloud.dataplex.v1.GetDataAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAsset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataAssetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists data assets for a given data product.
     * </pre>
     */
    public void listDataAssets(
        com.google.cloud.dataplex.v1.ListDataAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAssetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataAssetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataProductService.
   *
   * <pre>
   * `DataProductService` provides APIs for managing data products and
   * the underlying data assets.
   * </pre>
   */
  public static final class DataProductServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DataProductServiceBlockingV2Stub> {
    private DataProductServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataProductServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataProductServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data product.
     * </pre>
     */
    public com.google.longrunning.Operation createDataProduct(
        com.google.cloud.dataplex.v1.CreateDataProductRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data product. The deletion will fail if the data product is not
     * empty (i.e. contains at least one data asset).
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataProduct(
        com.google.cloud.dataplex.v1.DeleteDataProductRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data product.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataProduct getDataProduct(
        com.google.cloud.dataplex.v1.GetDataProductRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data products for a given project.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataProductsResponse listDataProducts(
        com.google.cloud.dataplex.v1.ListDataProductsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDataProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data product.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataProduct(
        com.google.cloud.dataplex.v1.UpdateDataProductRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a data asset.
     * </pre>
     */
    public com.google.longrunning.Operation createDataAsset(
        com.google.cloud.dataplex.v1.CreateDataAssetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data asset.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataAsset(
        com.google.cloud.dataplex.v1.UpdateDataAssetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data asset.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataAsset(
        com.google.cloud.dataplex.v1.DeleteDataAssetRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data asset.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataAsset getDataAsset(
        com.google.cloud.dataplex.v1.GetDataAssetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data assets for a given data product.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataAssetsResponse listDataAssets(
        com.google.cloud.dataplex.v1.ListDataAssetsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDataAssetsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DataProductService.
   *
   * <pre>
   * `DataProductService` provides APIs for managing data products and
   * the underlying data assets.
   * </pre>
   */
  public static final class DataProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataProductServiceBlockingStub> {
    private DataProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataProductServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data product.
     * </pre>
     */
    public com.google.longrunning.Operation createDataProduct(
        com.google.cloud.dataplex.v1.CreateDataProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data product. The deletion will fail if the data product is not
     * empty (i.e. contains at least one data asset).
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataProduct(
        com.google.cloud.dataplex.v1.DeleteDataProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data product.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataProduct getDataProduct(
        com.google.cloud.dataplex.v1.GetDataProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data products for a given project.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataProductsResponse listDataProducts(
        com.google.cloud.dataplex.v1.ListDataProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data product.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataProduct(
        com.google.cloud.dataplex.v1.UpdateDataProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a data asset.
     * </pre>
     */
    public com.google.longrunning.Operation createDataAsset(
        com.google.cloud.dataplex.v1.CreateDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data asset.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataAsset(
        com.google.cloud.dataplex.v1.UpdateDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data asset.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataAsset(
        com.google.cloud.dataplex.v1.DeleteDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data asset.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataAsset getDataAsset(
        com.google.cloud.dataplex.v1.GetDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAssetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data assets for a given data product.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataAssetsResponse listDataAssets(
        com.google.cloud.dataplex.v1.ListDataAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAssetsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataProductService.
   *
   * <pre>
   * `DataProductService` provides APIs for managing data products and
   * the underlying data assets.
   * </pre>
   */
  public static final class DataProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataProductServiceFutureStub> {
    private DataProductServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataProductServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a data product.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataProduct(com.google.cloud.dataplex.v1.CreateDataProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data product. The deletion will fail if the data product is not
     * empty (i.e. contains at least one data asset).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataProduct(com.google.cloud.dataplex.v1.DeleteDataProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data product.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.DataProduct>
        getDataProduct(com.google.cloud.dataplex.v1.GetDataProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data products for a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataProductsResponse>
        listDataProducts(com.google.cloud.dataplex.v1.ListDataProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data product.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataProduct(com.google.cloud.dataplex.v1.UpdateDataProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a data asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataAsset(com.google.cloud.dataplex.v1.CreateDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a data asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataAsset(com.google.cloud.dataplex.v1.UpdateDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a data asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataAsset(com.google.cloud.dataplex.v1.DeleteDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a data asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.DataAsset>
        getDataAsset(com.google.cloud.dataplex.v1.GetDataAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataAssetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists data assets for a given data product.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataAssetsResponse>
        listDataAssets(com.google.cloud.dataplex.v1.ListDataAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataAssetsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_PRODUCT = 0;
  private static final int METHODID_DELETE_DATA_PRODUCT = 1;
  private static final int METHODID_GET_DATA_PRODUCT = 2;
  private static final int METHODID_LIST_DATA_PRODUCTS = 3;
  private static final int METHODID_UPDATE_DATA_PRODUCT = 4;
  private static final int METHODID_CREATE_DATA_ASSET = 5;
  private static final int METHODID_UPDATE_DATA_ASSET = 6;
  private static final int METHODID_DELETE_DATA_ASSET = 7;
  private static final int METHODID_GET_DATA_ASSET = 8;
  private static final int METHODID_LIST_DATA_ASSETS = 9;

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
        case METHODID_CREATE_DATA_PRODUCT:
          serviceImpl.createDataProduct(
              (com.google.cloud.dataplex.v1.CreateDataProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_PRODUCT:
          serviceImpl.deleteDataProduct(
              (com.google.cloud.dataplex.v1.DeleteDataProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_PRODUCT:
          serviceImpl.getDataProduct(
              (com.google.cloud.dataplex.v1.GetDataProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataProduct>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_PRODUCTS:
          serviceImpl.listDataProducts(
              (com.google.cloud.dataplex.v1.ListDataProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataProductsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_PRODUCT:
          serviceImpl.updateDataProduct(
              (com.google.cloud.dataplex.v1.UpdateDataProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_DATA_ASSET:
          serviceImpl.createDataAsset(
              (com.google.cloud.dataplex.v1.CreateDataAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_ASSET:
          serviceImpl.updateDataAsset(
              (com.google.cloud.dataplex.v1.UpdateDataAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_ASSET:
          serviceImpl.deleteDataAsset(
              (com.google.cloud.dataplex.v1.DeleteDataAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DATA_ASSET:
          serviceImpl.getDataAsset(
              (com.google.cloud.dataplex.v1.GetDataAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAsset>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_ASSETS:
          serviceImpl.listDataAssets(
              (com.google.cloud.dataplex.v1.ListDataAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAssetsResponse>)
                  responseObserver);
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
            getCreateDataProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateDataProductRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_PRODUCT)))
        .addMethod(
            getDeleteDataProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteDataProductRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATA_PRODUCT)))
        .addMethod(
            getGetDataProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataProductRequest,
                    com.google.cloud.dataplex.v1.DataProduct>(service, METHODID_GET_DATA_PRODUCT)))
        .addMethod(
            getListDataProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataProductsRequest,
                    com.google.cloud.dataplex.v1.ListDataProductsResponse>(
                    service, METHODID_LIST_DATA_PRODUCTS)))
        .addMethod(
            getUpdateDataProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateDataProductRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_PRODUCT)))
        .addMethod(
            getCreateDataAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateDataAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_ASSET)))
        .addMethod(
            getUpdateDataAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateDataAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_ASSET)))
        .addMethod(
            getDeleteDataAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteDataAssetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATA_ASSET)))
        .addMethod(
            getGetDataAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataAssetRequest,
                    com.google.cloud.dataplex.v1.DataAsset>(service, METHODID_GET_DATA_ASSET)))
        .addMethod(
            getListDataAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataAssetsRequest,
                    com.google.cloud.dataplex.v1.ListDataAssetsResponse>(
                    service, METHODID_LIST_DATA_ASSETS)))
        .build();
  }

  private abstract static class DataProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.DataProductsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataProductService");
    }
  }

  private static final class DataProductServiceFileDescriptorSupplier
      extends DataProductServiceBaseDescriptorSupplier {
    DataProductServiceFileDescriptorSupplier() {}
  }

  private static final class DataProductServiceMethodDescriptorSupplier
      extends DataProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataProductServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataProductServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataProductMethod())
                      .addMethod(getDeleteDataProductMethod())
                      .addMethod(getGetDataProductMethod())
                      .addMethod(getListDataProductsMethod())
                      .addMethod(getUpdateDataProductMethod())
                      .addMethod(getCreateDataAssetMethod())
                      .addMethod(getUpdateDataAssetMethod())
                      .addMethod(getDeleteDataAssetMethod())
                      .addMethod(getGetDataAssetMethod())
                      .addMethod(getListDataAssetsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
