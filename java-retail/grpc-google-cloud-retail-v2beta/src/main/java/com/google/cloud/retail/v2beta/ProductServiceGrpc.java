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
package com.google.cloud.retail.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for ingesting [Product][google.cloud.retail.v2beta.Product]
 * information of the customer's website.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2beta/product_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.retail.v2beta.ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.CreateProductRequest,
          com.google.cloud.retail.v2beta.Product>
      getCreateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProduct",
      requestType = com.google.cloud.retail.v2beta.CreateProductRequest.class,
      responseType = com.google.cloud.retail.v2beta.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.CreateProductRequest,
          com.google.cloud.retail.v2beta.Product>
      getCreateProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.CreateProductRequest,
            com.google.cloud.retail.v2beta.Product>
        getCreateProductMethod;
    if ((getCreateProductMethod = ProductServiceGrpc.getCreateProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getCreateProductMethod = ProductServiceGrpc.getCreateProductMethod) == null) {
          ProductServiceGrpc.getCreateProductMethod =
              getCreateProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.CreateProductRequest,
                          com.google.cloud.retail.v2beta.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.CreateProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.Product.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("CreateProduct"))
                      .build();
        }
      }
    }
    return getCreateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.GetProductRequest, com.google.cloud.retail.v2beta.Product>
      getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = com.google.cloud.retail.v2beta.GetProductRequest.class,
      responseType = com.google.cloud.retail.v2beta.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.GetProductRequest, com.google.cloud.retail.v2beta.Product>
      getGetProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.GetProductRequest,
            com.google.cloud.retail.v2beta.Product>
        getGetProductMethod;
    if ((getGetProductMethod = ProductServiceGrpc.getGetProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getGetProductMethod = ProductServiceGrpc.getGetProductMethod) == null) {
          ProductServiceGrpc.getGetProductMethod =
              getGetProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.GetProductRequest,
                          com.google.cloud.retail.v2beta.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.GetProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.Product.getDefaultInstance()))
                      .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("GetProduct"))
                      .build();
        }
      }
    }
    return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ListProductsRequest,
          com.google.cloud.retail.v2beta.ListProductsResponse>
      getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = com.google.cloud.retail.v2beta.ListProductsRequest.class,
      responseType = com.google.cloud.retail.v2beta.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ListProductsRequest,
          com.google.cloud.retail.v2beta.ListProductsResponse>
      getListProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.ListProductsRequest,
            com.google.cloud.retail.v2beta.ListProductsResponse>
        getListProductsMethod;
    if ((getListProductsMethod = ProductServiceGrpc.getListProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getListProductsMethod = ProductServiceGrpc.getListProductsMethod) == null) {
          ProductServiceGrpc.getListProductsMethod =
              getListProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.ListProductsRequest,
                          com.google.cloud.retail.v2beta.ListProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ListProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ListProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("ListProducts"))
                      .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.UpdateProductRequest,
          com.google.cloud.retail.v2beta.Product>
      getUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProduct",
      requestType = com.google.cloud.retail.v2beta.UpdateProductRequest.class,
      responseType = com.google.cloud.retail.v2beta.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.UpdateProductRequest,
          com.google.cloud.retail.v2beta.Product>
      getUpdateProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.UpdateProductRequest,
            com.google.cloud.retail.v2beta.Product>
        getUpdateProductMethod;
    if ((getUpdateProductMethod = ProductServiceGrpc.getUpdateProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUpdateProductMethod = ProductServiceGrpc.getUpdateProductMethod) == null) {
          ProductServiceGrpc.getUpdateProductMethod =
              getUpdateProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.UpdateProductRequest,
                          com.google.cloud.retail.v2beta.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.UpdateProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.Product.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("UpdateProduct"))
                      .build();
        }
      }
    }
    return getUpdateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProduct",
      requestType = com.google.cloud.retail.v2beta.DeleteProductRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.DeleteProductRequest, com.google.protobuf.Empty>
        getDeleteProductMethod;
    if ((getDeleteProductMethod = ProductServiceGrpc.getDeleteProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getDeleteProductMethod = ProductServiceGrpc.getDeleteProductMethod) == null) {
          ProductServiceGrpc.getDeleteProductMethod =
              getDeleteProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.DeleteProductRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.DeleteProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("DeleteProduct"))
                      .build();
        }
      }
    }
    return getDeleteProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeProducts",
      requestType = com.google.cloud.retail.v2beta.PurgeProductsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.PurgeProductsRequest, com.google.longrunning.Operation>
        getPurgeProductsMethod;
    if ((getPurgeProductsMethod = ProductServiceGrpc.getPurgeProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getPurgeProductsMethod = ProductServiceGrpc.getPurgeProductsMethod) == null) {
          ProductServiceGrpc.getPurgeProductsMethod =
              getPurgeProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.PurgeProductsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurgeProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.PurgeProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("PurgeProducts"))
                      .build();
        }
      }
    }
    return getPurgeProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ImportProductsRequest, com.google.longrunning.Operation>
      getImportProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportProducts",
      requestType = com.google.cloud.retail.v2beta.ImportProductsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ImportProductsRequest, com.google.longrunning.Operation>
      getImportProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.ImportProductsRequest, com.google.longrunning.Operation>
        getImportProductsMethod;
    if ((getImportProductsMethod = ProductServiceGrpc.getImportProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getImportProductsMethod = ProductServiceGrpc.getImportProductsMethod) == null) {
          ProductServiceGrpc.getImportProductsMethod =
              getImportProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.ImportProductsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ImportProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("ImportProducts"))
                      .build();
        }
      }
    }
    return getImportProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ExportProductsRequest, com.google.longrunning.Operation>
      getExportProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportProducts",
      requestType = com.google.cloud.retail.v2beta.ExportProductsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ExportProductsRequest, com.google.longrunning.Operation>
      getExportProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.ExportProductsRequest, com.google.longrunning.Operation>
        getExportProductsMethod;
    if ((getExportProductsMethod = ProductServiceGrpc.getExportProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getExportProductsMethod = ProductServiceGrpc.getExportProductsMethod) == null) {
          ProductServiceGrpc.getExportProductsMethod =
              getExportProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.ExportProductsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ExportProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("ExportProducts"))
                      .build();
        }
      }
    }
    return getExportProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.SetInventoryRequest, com.google.longrunning.Operation>
      getSetInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetInventory",
      requestType = com.google.cloud.retail.v2beta.SetInventoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.SetInventoryRequest, com.google.longrunning.Operation>
      getSetInventoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.SetInventoryRequest, com.google.longrunning.Operation>
        getSetInventoryMethod;
    if ((getSetInventoryMethod = ProductServiceGrpc.getSetInventoryMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getSetInventoryMethod = ProductServiceGrpc.getSetInventoryMethod) == null) {
          ProductServiceGrpc.getSetInventoryMethod =
              getSetInventoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.SetInventoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetInventory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.SetInventoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("SetInventory"))
                      .build();
        }
      }
    }
    return getSetInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest,
          com.google.longrunning.Operation>
      getAddFulfillmentPlacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFulfillmentPlaces",
      requestType = com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest,
          com.google.longrunning.Operation>
      getAddFulfillmentPlacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest,
            com.google.longrunning.Operation>
        getAddFulfillmentPlacesMethod;
    if ((getAddFulfillmentPlacesMethod = ProductServiceGrpc.getAddFulfillmentPlacesMethod)
        == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getAddFulfillmentPlacesMethod = ProductServiceGrpc.getAddFulfillmentPlacesMethod)
            == null) {
          ProductServiceGrpc.getAddFulfillmentPlacesMethod =
              getAddFulfillmentPlacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddFulfillmentPlaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("AddFulfillmentPlaces"))
                      .build();
        }
      }
    }
    return getAddFulfillmentPlacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest,
          com.google.longrunning.Operation>
      getRemoveFulfillmentPlacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveFulfillmentPlaces",
      requestType = com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest,
          com.google.longrunning.Operation>
      getRemoveFulfillmentPlacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest,
            com.google.longrunning.Operation>
        getRemoveFulfillmentPlacesMethod;
    if ((getRemoveFulfillmentPlacesMethod = ProductServiceGrpc.getRemoveFulfillmentPlacesMethod)
        == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getRemoveFulfillmentPlacesMethod = ProductServiceGrpc.getRemoveFulfillmentPlacesMethod)
            == null) {
          ProductServiceGrpc.getRemoveFulfillmentPlacesMethod =
              getRemoveFulfillmentPlacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveFulfillmentPlaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("RemoveFulfillmentPlaces"))
                      .build();
        }
      }
    }
    return getRemoveFulfillmentPlacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.AddLocalInventoriesRequest,
          com.google.longrunning.Operation>
      getAddLocalInventoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLocalInventories",
      requestType = com.google.cloud.retail.v2beta.AddLocalInventoriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.AddLocalInventoriesRequest,
          com.google.longrunning.Operation>
      getAddLocalInventoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.AddLocalInventoriesRequest,
            com.google.longrunning.Operation>
        getAddLocalInventoriesMethod;
    if ((getAddLocalInventoriesMethod = ProductServiceGrpc.getAddLocalInventoriesMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getAddLocalInventoriesMethod = ProductServiceGrpc.getAddLocalInventoriesMethod)
            == null) {
          ProductServiceGrpc.getAddLocalInventoriesMethod =
              getAddLocalInventoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.AddLocalInventoriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddLocalInventories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.AddLocalInventoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("AddLocalInventories"))
                      .build();
        }
      }
    }
    return getAddLocalInventoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest,
          com.google.longrunning.Operation>
      getRemoveLocalInventoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveLocalInventories",
      requestType = com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest,
          com.google.longrunning.Operation>
      getRemoveLocalInventoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest,
            com.google.longrunning.Operation>
        getRemoveLocalInventoriesMethod;
    if ((getRemoveLocalInventoriesMethod = ProductServiceGrpc.getRemoveLocalInventoriesMethod)
        == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getRemoveLocalInventoriesMethod = ProductServiceGrpc.getRemoveLocalInventoriesMethod)
            == null) {
          ProductServiceGrpc.getRemoveLocalInventoriesMethod =
              getRemoveLocalInventoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveLocalInventories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductServiceMethodDescriptorSupplier("RemoveLocalInventories"))
                      .build();
        }
      }
    }
    return getRemoveLocalInventoriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub>() {
          @java.lang.Override
          public ProductServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductServiceStub(channel, callOptions);
          }
        };
    return ProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub>() {
          @java.lang.Override
          public ProductServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductServiceBlockingStub(channel, callOptions);
          }
        };
    return ProductServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub>() {
          @java.lang.Override
          public ProductServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductServiceFutureStub(channel, callOptions);
          }
        };
    return ProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2beta.Product]
   * information of the customer's website.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    default void createProduct(
        com.google.cloud.retail.v2beta.CreateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    default void getProduct(
        com.google.cloud.retail.v2beta.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    default void listProducts(
        com.google.cloud.retail.v2beta.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    default void updateProduct(
        com.google.cloud.retail.v2beta.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    default void deleteProduct(
        com.google.cloud.retail.v2beta.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all selected
     * [Product][google.cloud.retail.v2beta.Product]s under a branch.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed offline. Depending on the number of
     * [Product][google.cloud.retail.v2beta.Product]s, this operation could take
     * hours to complete. Before the operation completes, some
     * [Product][google.cloud.retail.v2beta.Product]s may still be returned by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Depending on the number of [Product][google.cloud.retail.v2beta.Product]s,
     * this operation could take hours to complete. To get a sample of
     * [Product][google.cloud.retail.v2beta.Product]s that would be deleted, set
     * [PurgeProductsRequest.force][google.cloud.retail.v2beta.PurgeProductsRequest.force]
     * to false.
     * </pre>
     */
    default void purgeProducts(
        com.google.cloud.retail.v2beta.PurgeProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2beta.Product]s.
     * Request processing may be synchronous.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2beta.Product]s to be successfully updated.
     * </pre>
     */
    default void importProducts(
        com.google.cloud.retail.v2beta.ImportProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports multiple [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    default void exportProducts(
        com.google.cloud.retail.v2beta.ExportProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] while respecting the last
     * update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update is enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * When inventory is updated with
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct],
     * the specified inventory field value(s) overwrite any existing value(s)
     * while ignoring the last update time for this field. Furthermore, the last
     * update times for the specified inventory fields are overwritten by the
     * times of the
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * or
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * request.
     * If no inventory fields are set in
     * [CreateProductRequest.product][google.cloud.retail.v2beta.CreateProductRequest.product],
     * then any pre-existing inventory information for this product is used.
     * If no inventory fields are set in
     * [SetInventoryRequest.set_mask][google.cloud.retail.v2beta.SetInventoryRequest.set_mask],
     * then any existing inventory information is preserved.
     * Pre-existing inventory information can only be updated with
     * [ProductService.SetInventory][google.cloud.retail.v2beta.ProductService.SetInventory],
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces],
     * and
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces].
     * The returned [Operation][google.longrunning.Operation]s is obsolete after
     * one day, and the [GetOperation][google.longrunning.Operations.GetOperation]
     * API returns `NOT_FOUND` afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates are not marked as [done][google.longrunning.Operation.done] until
     * they are obsolete.
     * </pre>
     */
    default void setInventory(
        com.google.cloud.retail.v2beta.SetInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetInventoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * method instead of the
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces]
     * method.
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally adds place IDs to
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the added place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    default void addFulfillmentPlaces(
        com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddFulfillmentPlacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * method instead of the
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces]
     * method.
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally removes place IDs from a
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the removed place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    default void removeFulfillmentPlaces(
        com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveFulfillmentPlacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places, while
     * respecting the last update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * inventory information. If the request is valid, the update will be enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be modified using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    default void addLocalInventories(
        com.google.cloud.retail.v2beta.AddLocalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddLocalInventoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places at a
     * removal timestamp.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, removals are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be removed using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    default void removeLocalInventories(
        com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveLocalInventoriesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductService.
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2beta.Product]
   * information of the customer's website.
   * </pre>
   */
  public abstract static class ProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductService.
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2beta.Product]
   * information of the customer's website.
   * </pre>
   */
  public static final class ProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceStub> {
    private ProductServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public void createProduct(
        com.google.cloud.retail.v2beta.CreateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public void getProduct(
        com.google.cloud.retail.v2beta.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    public void listProducts(
        com.google.cloud.retail.v2beta.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public void updateProduct(
        com.google.cloud.retail.v2beta.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public void deleteProduct(
        com.google.cloud.retail.v2beta.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all selected
     * [Product][google.cloud.retail.v2beta.Product]s under a branch.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed offline. Depending on the number of
     * [Product][google.cloud.retail.v2beta.Product]s, this operation could take
     * hours to complete. Before the operation completes, some
     * [Product][google.cloud.retail.v2beta.Product]s may still be returned by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Depending on the number of [Product][google.cloud.retail.v2beta.Product]s,
     * this operation could take hours to complete. To get a sample of
     * [Product][google.cloud.retail.v2beta.Product]s that would be deleted, set
     * [PurgeProductsRequest.force][google.cloud.retail.v2beta.PurgeProductsRequest.force]
     * to false.
     * </pre>
     */
    public void purgeProducts(
        com.google.cloud.retail.v2beta.PurgeProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2beta.Product]s.
     * Request processing may be synchronous.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2beta.Product]s to be successfully updated.
     * </pre>
     */
    public void importProducts(
        com.google.cloud.retail.v2beta.ImportProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports multiple [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    public void exportProducts(
        com.google.cloud.retail.v2beta.ExportProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] while respecting the last
     * update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update is enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * When inventory is updated with
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct],
     * the specified inventory field value(s) overwrite any existing value(s)
     * while ignoring the last update time for this field. Furthermore, the last
     * update times for the specified inventory fields are overwritten by the
     * times of the
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * or
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * request.
     * If no inventory fields are set in
     * [CreateProductRequest.product][google.cloud.retail.v2beta.CreateProductRequest.product],
     * then any pre-existing inventory information for this product is used.
     * If no inventory fields are set in
     * [SetInventoryRequest.set_mask][google.cloud.retail.v2beta.SetInventoryRequest.set_mask],
     * then any existing inventory information is preserved.
     * Pre-existing inventory information can only be updated with
     * [ProductService.SetInventory][google.cloud.retail.v2beta.ProductService.SetInventory],
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces],
     * and
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces].
     * The returned [Operation][google.longrunning.Operation]s is obsolete after
     * one day, and the [GetOperation][google.longrunning.Operations.GetOperation]
     * API returns `NOT_FOUND` afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates are not marked as [done][google.longrunning.Operation.done] until
     * they are obsolete.
     * </pre>
     */
    public void setInventory(
        com.google.cloud.retail.v2beta.SetInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetInventoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * method instead of the
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces]
     * method.
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally adds place IDs to
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the added place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public void addFulfillmentPlaces(
        com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFulfillmentPlacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * method instead of the
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces]
     * method.
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally removes place IDs from a
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the removed place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public void removeFulfillmentPlaces(
        com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveFulfillmentPlacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places, while
     * respecting the last update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * inventory information. If the request is valid, the update will be enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be modified using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public void addLocalInventories(
        com.google.cloud.retail.v2beta.AddLocalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLocalInventoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places at a
     * removal timestamp.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, removals are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be removed using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public void removeLocalInventories(
        com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveLocalInventoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductService.
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2beta.Product]
   * information of the customer's website.
   * </pre>
   */
  public static final class ProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Product createProduct(
        com.google.cloud.retail.v2beta.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Product getProduct(
        com.google.cloud.retail.v2beta.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.ListProductsResponse listProducts(
        com.google.cloud.retail.v2beta.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Product updateProduct(
        com.google.cloud.retail.v2beta.UpdateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.protobuf.Empty deleteProduct(
        com.google.cloud.retail.v2beta.DeleteProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all selected
     * [Product][google.cloud.retail.v2beta.Product]s under a branch.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed offline. Depending on the number of
     * [Product][google.cloud.retail.v2beta.Product]s, this operation could take
     * hours to complete. Before the operation completes, some
     * [Product][google.cloud.retail.v2beta.Product]s may still be returned by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Depending on the number of [Product][google.cloud.retail.v2beta.Product]s,
     * this operation could take hours to complete. To get a sample of
     * [Product][google.cloud.retail.v2beta.Product]s that would be deleted, set
     * [PurgeProductsRequest.force][google.cloud.retail.v2beta.PurgeProductsRequest.force]
     * to false.
     * </pre>
     */
    public com.google.longrunning.Operation purgeProducts(
        com.google.cloud.retail.v2beta.PurgeProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2beta.Product]s.
     * Request processing may be synchronous.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2beta.Product]s to be successfully updated.
     * </pre>
     */
    public com.google.longrunning.Operation importProducts(
        com.google.cloud.retail.v2beta.ImportProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports multiple [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    public com.google.longrunning.Operation exportProducts(
        com.google.cloud.retail.v2beta.ExportProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] while respecting the last
     * update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update is enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * When inventory is updated with
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct],
     * the specified inventory field value(s) overwrite any existing value(s)
     * while ignoring the last update time for this field. Furthermore, the last
     * update times for the specified inventory fields are overwritten by the
     * times of the
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * or
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * request.
     * If no inventory fields are set in
     * [CreateProductRequest.product][google.cloud.retail.v2beta.CreateProductRequest.product],
     * then any pre-existing inventory information for this product is used.
     * If no inventory fields are set in
     * [SetInventoryRequest.set_mask][google.cloud.retail.v2beta.SetInventoryRequest.set_mask],
     * then any existing inventory information is preserved.
     * Pre-existing inventory information can only be updated with
     * [ProductService.SetInventory][google.cloud.retail.v2beta.ProductService.SetInventory],
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces],
     * and
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces].
     * The returned [Operation][google.longrunning.Operation]s is obsolete after
     * one day, and the [GetOperation][google.longrunning.Operations.GetOperation]
     * API returns `NOT_FOUND` afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates are not marked as [done][google.longrunning.Operation.done] until
     * they are obsolete.
     * </pre>
     */
    public com.google.longrunning.Operation setInventory(
        com.google.cloud.retail.v2beta.SetInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * method instead of the
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces]
     * method.
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally adds place IDs to
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the added place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.longrunning.Operation addFulfillmentPlaces(
        com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFulfillmentPlacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * method instead of the
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces]
     * method.
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally removes place IDs from a
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the removed place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.longrunning.Operation removeFulfillmentPlaces(
        com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveFulfillmentPlacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places, while
     * respecting the last update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * inventory information. If the request is valid, the update will be enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be modified using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.longrunning.Operation addLocalInventories(
        com.google.cloud.retail.v2beta.AddLocalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLocalInventoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places at a
     * removal timestamp.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, removals are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be removed using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.longrunning.Operation removeLocalInventories(
        com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveLocalInventoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductService.
   *
   * <pre>
   * Service for ingesting [Product][google.cloud.retail.v2beta.Product]
   * information of the customer's website.
   * </pre>
   */
  public static final class ProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2beta.Product>
        createProduct(com.google.cloud.retail.v2beta.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2beta.Product>
        getProduct(com.google.cloud.retail.v2beta.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2beta.ListProductsResponse>
        listProducts(com.google.cloud.retail.v2beta.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2beta.Product>
        updateProduct(com.google.cloud.retail.v2beta.UpdateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Product][google.cloud.retail.v2beta.Product].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProduct(com.google.cloud.retail.v2beta.DeleteProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all selected
     * [Product][google.cloud.retail.v2beta.Product]s under a branch.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed offline. Depending on the number of
     * [Product][google.cloud.retail.v2beta.Product]s, this operation could take
     * hours to complete. Before the operation completes, some
     * [Product][google.cloud.retail.v2beta.Product]s may still be returned by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Depending on the number of [Product][google.cloud.retail.v2beta.Product]s,
     * this operation could take hours to complete. To get a sample of
     * [Product][google.cloud.retail.v2beta.Product]s that would be deleted, set
     * [PurgeProductsRequest.force][google.cloud.retail.v2beta.PurgeProductsRequest.force]
     * to false.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeProducts(com.google.cloud.retail.v2beta.PurgeProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Bulk import of multiple [Product][google.cloud.retail.v2beta.Product]s.
     * Request processing may be synchronous.
     * Non-existing items are created.
     * Note that it is possible for a subset of the
     * [Product][google.cloud.retail.v2beta.Product]s to be successfully updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importProducts(com.google.cloud.retail.v2beta.ImportProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports multiple [Product][google.cloud.retail.v2beta.Product]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportProducts(com.google.cloud.retail.v2beta.ExportProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] while respecting the last
     * update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update is enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * When inventory is updated with
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct],
     * the specified inventory field value(s) overwrite any existing value(s)
     * while ignoring the last update time for this field. Furthermore, the last
     * update times for the specified inventory fields are overwritten by the
     * times of the
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * or
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * request.
     * If no inventory fields are set in
     * [CreateProductRequest.product][google.cloud.retail.v2beta.CreateProductRequest.product],
     * then any pre-existing inventory information for this product is used.
     * If no inventory fields are set in
     * [SetInventoryRequest.set_mask][google.cloud.retail.v2beta.SetInventoryRequest.set_mask],
     * then any existing inventory information is preserved.
     * Pre-existing inventory information can only be updated with
     * [ProductService.SetInventory][google.cloud.retail.v2beta.ProductService.SetInventory],
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces],
     * and
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces].
     * The returned [Operation][google.longrunning.Operation]s is obsolete after
     * one day, and the [GetOperation][google.longrunning.Operations.GetOperation]
     * API returns `NOT_FOUND` afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates are not marked as [done][google.longrunning.Operation.done] until
     * they are obsolete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setInventory(com.google.cloud.retail.v2beta.SetInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetInventoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * method instead of the
     * [ProductService.AddFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.AddFulfillmentPlaces]
     * method.
     * [ProductService.AddLocalInventories][google.cloud.retail.v2beta.ProductService.AddLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally adds place IDs to
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the added place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addFulfillmentPlaces(com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFulfillmentPlacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * We recommend that you use the
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * method instead of the
     * [ProductService.RemoveFulfillmentPlaces][google.cloud.retail.v2beta.ProductService.RemoveFulfillmentPlaces]
     * method.
     * [ProductService.RemoveLocalInventories][google.cloud.retail.v2beta.ProductService.RemoveLocalInventories]
     * achieves the same results but provides more fine-grained control over
     * ingesting local inventory data.
     * Incrementally removes place IDs from a
     * [Product.fulfillment_info.place_ids][google.cloud.retail.v2beta.FulfillmentInfo.place_ids].
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * fulfillment information. If the request is valid, the update will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, the removed place IDs are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeFulfillmentPlaces(
            com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveFulfillmentPlacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places, while
     * respecting the last update timestamps of each inventory field.
     * This process is asynchronous and does not require the
     * [Product][google.cloud.retail.v2beta.Product] to exist before updating
     * inventory information. If the request is valid, the update will be enqueued
     * and processed downstream. As a consequence, when a response is returned,
     * updates are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be modified using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addLocalInventories(com.google.cloud.retail.v2beta.AddLocalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLocalInventoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove local inventory information for a
     * [Product][google.cloud.retail.v2beta.Product] at a list of places at a
     * removal timestamp.
     * This process is asynchronous. If the request is valid, the removal will be
     * enqueued and processed downstream. As a consequence, when a response is
     * returned, removals are not immediately manifested in the
     * [Product][google.cloud.retail.v2beta.Product] queried by
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct]
     * or
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts].
     * Local inventory information can only be removed using this method.
     * [ProductService.CreateProduct][google.cloud.retail.v2beta.ProductService.CreateProduct]
     * and
     * [ProductService.UpdateProduct][google.cloud.retail.v2beta.ProductService.UpdateProduct]
     * has no effect on local inventories.
     * The returned [Operation][google.longrunning.Operation]s will be obsolete
     * after 1 day, and [GetOperation][google.longrunning.Operations.GetOperation]
     * API will return NOT_FOUND afterwards.
     * If conflicting updates are issued, the
     * [Operation][google.longrunning.Operation]s associated with the stale
     * updates will not be marked as [done][google.longrunning.Operation.done]
     * until being obsolete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeLocalInventories(
            com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveLocalInventoriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PRODUCT = 0;
  private static final int METHODID_GET_PRODUCT = 1;
  private static final int METHODID_LIST_PRODUCTS = 2;
  private static final int METHODID_UPDATE_PRODUCT = 3;
  private static final int METHODID_DELETE_PRODUCT = 4;
  private static final int METHODID_PURGE_PRODUCTS = 5;
  private static final int METHODID_IMPORT_PRODUCTS = 6;
  private static final int METHODID_EXPORT_PRODUCTS = 7;
  private static final int METHODID_SET_INVENTORY = 8;
  private static final int METHODID_ADD_FULFILLMENT_PLACES = 9;
  private static final int METHODID_REMOVE_FULFILLMENT_PLACES = 10;
  private static final int METHODID_ADD_LOCAL_INVENTORIES = 11;
  private static final int METHODID_REMOVE_LOCAL_INVENTORIES = 12;

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
        case METHODID_CREATE_PRODUCT:
          serviceImpl.createProduct(
              (com.google.cloud.retail.v2beta.CreateProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product>)
                  responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct(
              (com.google.cloud.retail.v2beta.GetProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts(
              (com.google.cloud.retail.v2beta.ListProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListProductsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT:
          serviceImpl.updateProduct(
              (com.google.cloud.retail.v2beta.UpdateProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Product>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRODUCT:
          serviceImpl.deleteProduct(
              (com.google.cloud.retail.v2beta.DeleteProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PURGE_PRODUCTS:
          serviceImpl.purgeProducts(
              (com.google.cloud.retail.v2beta.PurgeProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_PRODUCTS:
          serviceImpl.importProducts(
              (com.google.cloud.retail.v2beta.ImportProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_PRODUCTS:
          serviceImpl.exportProducts(
              (com.google.cloud.retail.v2beta.ExportProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_INVENTORY:
          serviceImpl.setInventory(
              (com.google.cloud.retail.v2beta.SetInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_FULFILLMENT_PLACES:
          serviceImpl.addFulfillmentPlaces(
              (com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_FULFILLMENT_PLACES:
          serviceImpl.removeFulfillmentPlaces(
              (com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_LOCAL_INVENTORIES:
          serviceImpl.addLocalInventories(
              (com.google.cloud.retail.v2beta.AddLocalInventoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_LOCAL_INVENTORIES:
          serviceImpl.removeLocalInventories(
              (com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest) request,
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
            getCreateProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.CreateProductRequest,
                    com.google.cloud.retail.v2beta.Product>(service, METHODID_CREATE_PRODUCT)))
        .addMethod(
            getGetProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.GetProductRequest,
                    com.google.cloud.retail.v2beta.Product>(service, METHODID_GET_PRODUCT)))
        .addMethod(
            getListProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.ListProductsRequest,
                    com.google.cloud.retail.v2beta.ListProductsResponse>(
                    service, METHODID_LIST_PRODUCTS)))
        .addMethod(
            getUpdateProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.UpdateProductRequest,
                    com.google.cloud.retail.v2beta.Product>(service, METHODID_UPDATE_PRODUCT)))
        .addMethod(
            getDeleteProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.DeleteProductRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_PRODUCT)))
        .addMethod(
            getPurgeProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.PurgeProductsRequest,
                    com.google.longrunning.Operation>(service, METHODID_PURGE_PRODUCTS)))
        .addMethod(
            getImportProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.ImportProductsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_PRODUCTS)))
        .addMethod(
            getExportProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.ExportProductsRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_PRODUCTS)))
        .addMethod(
            getSetInventoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.SetInventoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_SET_INVENTORY)))
        .addMethod(
            getAddFulfillmentPlacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_FULFILLMENT_PLACES)))
        .addMethod(
            getRemoveFulfillmentPlacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest,
                    com.google.longrunning.Operation>(service, METHODID_REMOVE_FULFILLMENT_PLACES)))
        .addMethod(
            getAddLocalInventoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.AddLocalInventoriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_LOCAL_INVENTORIES)))
        .addMethod(
            getRemoveLocalInventoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_REMOVE_LOCAL_INVENTORIES)))
        .build();
  }

  private abstract static class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2beta.ProductServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
                      .addMethod(getCreateProductMethod())
                      .addMethod(getGetProductMethod())
                      .addMethod(getListProductsMethod())
                      .addMethod(getUpdateProductMethod())
                      .addMethod(getDeleteProductMethod())
                      .addMethod(getPurgeProductsMethod())
                      .addMethod(getImportProductsMethod())
                      .addMethod(getExportProductsMethod())
                      .addMethod(getSetInventoryMethod())
                      .addMethod(getAddFulfillmentPlacesMethod())
                      .addMethod(getRemoveFulfillmentPlacesMethod())
                      .addMethod(getAddLocalInventoriesMethod())
                      .addMethod(getRemoveLocalInventoriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
