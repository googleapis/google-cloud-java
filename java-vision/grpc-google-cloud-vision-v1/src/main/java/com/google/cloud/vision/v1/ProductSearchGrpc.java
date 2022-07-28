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
package com.google.cloud.vision.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages Products and ProductSets of reference images for use in product
 * search. It uses the following resource model:
 * - The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
 * `projects/&#42;&#47;locations/&#42;&#47;productSets/&#42;`, which acts as a way to put different
 * products into groups to limit identification.
 * In parallel,
 * - The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
 *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;`
 * - Each [Product][google.cloud.vision.v1.Product] has a collection of [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
 *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;&#47;referenceImages/&#42;`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/vision/v1/product_search_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductSearchGrpc {

  private ProductSearchGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.vision.v1.ProductSearch";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getCreateProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProductSet",
      requestType = com.google.cloud.vision.v1.CreateProductSetRequest.class,
      responseType = com.google.cloud.vision.v1.ProductSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getCreateProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.CreateProductSetRequest,
            com.google.cloud.vision.v1.ProductSet>
        getCreateProductSetMethod;
    if ((getCreateProductSetMethod = ProductSearchGrpc.getCreateProductSetMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getCreateProductSetMethod = ProductSearchGrpc.getCreateProductSetMethod) == null) {
          ProductSearchGrpc.getCreateProductSetMethod =
              getCreateProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.CreateProductSetRequest,
                          com.google.cloud.vision.v1.ProductSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.CreateProductSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ProductSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("CreateProductSet"))
                      .build();
        }
      }
    }
    return getCreateProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductSetsRequest,
          com.google.cloud.vision.v1.ListProductSetsResponse>
      getListProductSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProductSets",
      requestType = com.google.cloud.vision.v1.ListProductSetsRequest.class,
      responseType = com.google.cloud.vision.v1.ListProductSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductSetsRequest,
          com.google.cloud.vision.v1.ListProductSetsResponse>
      getListProductSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.ListProductSetsRequest,
            com.google.cloud.vision.v1.ListProductSetsResponse>
        getListProductSetsMethod;
    if ((getListProductSetsMethod = ProductSearchGrpc.getListProductSetsMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getListProductSetsMethod = ProductSearchGrpc.getListProductSetsMethod) == null) {
          ProductSearchGrpc.getListProductSetsMethod =
              getListProductSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.ListProductSetsRequest,
                          com.google.cloud.vision.v1.ListProductSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProductSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListProductSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListProductSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("ListProductSets"))
                      .build();
        }
      }
    }
    return getListProductSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getGetProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductSet",
      requestType = com.google.cloud.vision.v1.GetProductSetRequest.class,
      responseType = com.google.cloud.vision.v1.ProductSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getGetProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
        getGetProductSetMethod;
    if ((getGetProductSetMethod = ProductSearchGrpc.getGetProductSetMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getGetProductSetMethod = ProductSearchGrpc.getGetProductSetMethod) == null) {
          ProductSearchGrpc.getGetProductSetMethod =
              getGetProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.GetProductSetRequest,
                          com.google.cloud.vision.v1.ProductSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.GetProductSetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ProductSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("GetProductSet"))
                      .build();
        }
      }
    }
    return getGetProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getUpdateProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProductSet",
      requestType = com.google.cloud.vision.v1.UpdateProductSetRequest.class,
      responseType = com.google.cloud.vision.v1.ProductSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getUpdateProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.UpdateProductSetRequest,
            com.google.cloud.vision.v1.ProductSet>
        getUpdateProductSetMethod;
    if ((getUpdateProductSetMethod = ProductSearchGrpc.getUpdateProductSetMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getUpdateProductSetMethod = ProductSearchGrpc.getUpdateProductSetMethod) == null) {
          ProductSearchGrpc.getUpdateProductSetMethod =
              getUpdateProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.UpdateProductSetRequest,
                          com.google.cloud.vision.v1.ProductSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.UpdateProductSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ProductSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("UpdateProductSet"))
                      .build();
        }
      }
    }
    return getUpdateProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
      getDeleteProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProductSet",
      requestType = com.google.cloud.vision.v1.DeleteProductSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
      getDeleteProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
        getDeleteProductSetMethod;
    if ((getDeleteProductSetMethod = ProductSearchGrpc.getDeleteProductSetMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getDeleteProductSetMethod = ProductSearchGrpc.getDeleteProductSetMethod) == null) {
          ProductSearchGrpc.getDeleteProductSetMethod =
              getDeleteProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.DeleteProductSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.DeleteProductSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("DeleteProductSet"))
                      .build();
        }
      }
    }
    return getDeleteProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
      getCreateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProduct",
      requestType = com.google.cloud.vision.v1.CreateProductRequest.class,
      responseType = com.google.cloud.vision.v1.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
      getCreateProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
        getCreateProductMethod;
    if ((getCreateProductMethod = ProductSearchGrpc.getCreateProductMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getCreateProductMethod = ProductSearchGrpc.getCreateProductMethod) == null) {
          ProductSearchGrpc.getCreateProductMethod =
              getCreateProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.CreateProductRequest,
                          com.google.cloud.vision.v1.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.CreateProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.Product.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("CreateProduct"))
                      .build();
        }
      }
    }
    return getCreateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsRequest,
          com.google.cloud.vision.v1.ListProductsResponse>
      getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = com.google.cloud.vision.v1.ListProductsRequest.class,
      responseType = com.google.cloud.vision.v1.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsRequest,
          com.google.cloud.vision.v1.ListProductsResponse>
      getListProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.ListProductsRequest,
            com.google.cloud.vision.v1.ListProductsResponse>
        getListProductsMethod;
    if ((getListProductsMethod = ProductSearchGrpc.getListProductsMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getListProductsMethod = ProductSearchGrpc.getListProductsMethod) == null) {
          ProductSearchGrpc.getListProductsMethod =
              getListProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.ListProductsRequest,
                          com.google.cloud.vision.v1.ListProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListProductsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListProductsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("ListProducts"))
                      .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
      getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = com.google.cloud.vision.v1.GetProductRequest.class,
      responseType = com.google.cloud.vision.v1.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
      getGetProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
        getGetProductMethod;
    if ((getGetProductMethod = ProductSearchGrpc.getGetProductMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getGetProductMethod = ProductSearchGrpc.getGetProductMethod) == null) {
          ProductSearchGrpc.getGetProductMethod =
              getGetProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.GetProductRequest,
                          com.google.cloud.vision.v1.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.GetProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.Product.getDefaultInstance()))
                      .setSchemaDescriptor(new ProductSearchMethodDescriptorSupplier("GetProduct"))
                      .build();
        }
      }
    }
    return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
      getUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProduct",
      requestType = com.google.cloud.vision.v1.UpdateProductRequest.class,
      responseType = com.google.cloud.vision.v1.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
      getUpdateProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
        getUpdateProductMethod;
    if ((getUpdateProductMethod = ProductSearchGrpc.getUpdateProductMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getUpdateProductMethod = ProductSearchGrpc.getUpdateProductMethod) == null) {
          ProductSearchGrpc.getUpdateProductMethod =
              getUpdateProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.UpdateProductRequest,
                          com.google.cloud.vision.v1.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.UpdateProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.Product.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("UpdateProduct"))
                      .build();
        }
      }
    }
    return getUpdateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProduct",
      requestType = com.google.cloud.vision.v1.DeleteProductRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
        getDeleteProductMethod;
    if ((getDeleteProductMethod = ProductSearchGrpc.getDeleteProductMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getDeleteProductMethod = ProductSearchGrpc.getDeleteProductMethod) == null) {
          ProductSearchGrpc.getDeleteProductMethod =
              getDeleteProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.DeleteProductRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("DeleteProduct"))
                      .build();
        }
      }
    }
    return getDeleteProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getCreateReferenceImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReferenceImage",
      requestType = com.google.cloud.vision.v1.CreateReferenceImageRequest.class,
      responseType = com.google.cloud.vision.v1.ReferenceImage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getCreateReferenceImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.CreateReferenceImageRequest,
            com.google.cloud.vision.v1.ReferenceImage>
        getCreateReferenceImageMethod;
    if ((getCreateReferenceImageMethod = ProductSearchGrpc.getCreateReferenceImageMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getCreateReferenceImageMethod = ProductSearchGrpc.getCreateReferenceImageMethod)
            == null) {
          ProductSearchGrpc.getCreateReferenceImageMethod =
              getCreateReferenceImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.CreateReferenceImageRequest,
                          com.google.cloud.vision.v1.ReferenceImage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateReferenceImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.CreateReferenceImageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ReferenceImage.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("CreateReferenceImage"))
                      .build();
        }
      }
    }
    return getCreateReferenceImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
      getDeleteReferenceImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReferenceImage",
      requestType = com.google.cloud.vision.v1.DeleteReferenceImageRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
      getDeleteReferenceImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
        getDeleteReferenceImageMethod;
    if ((getDeleteReferenceImageMethod = ProductSearchGrpc.getDeleteReferenceImageMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getDeleteReferenceImageMethod = ProductSearchGrpc.getDeleteReferenceImageMethod)
            == null) {
          ProductSearchGrpc.getDeleteReferenceImageMethod =
              getDeleteReferenceImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.DeleteReferenceImageRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteReferenceImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.DeleteReferenceImageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("DeleteReferenceImage"))
                      .build();
        }
      }
    }
    return getDeleteReferenceImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListReferenceImagesRequest,
          com.google.cloud.vision.v1.ListReferenceImagesResponse>
      getListReferenceImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReferenceImages",
      requestType = com.google.cloud.vision.v1.ListReferenceImagesRequest.class,
      responseType = com.google.cloud.vision.v1.ListReferenceImagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListReferenceImagesRequest,
          com.google.cloud.vision.v1.ListReferenceImagesResponse>
      getListReferenceImagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.ListReferenceImagesRequest,
            com.google.cloud.vision.v1.ListReferenceImagesResponse>
        getListReferenceImagesMethod;
    if ((getListReferenceImagesMethod = ProductSearchGrpc.getListReferenceImagesMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getListReferenceImagesMethod = ProductSearchGrpc.getListReferenceImagesMethod)
            == null) {
          ProductSearchGrpc.getListReferenceImagesMethod =
              getListReferenceImagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.ListReferenceImagesRequest,
                          com.google.cloud.vision.v1.ListReferenceImagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListReferenceImages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListReferenceImagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListReferenceImagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("ListReferenceImages"))
                      .build();
        }
      }
    }
    return getListReferenceImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getGetReferenceImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReferenceImage",
      requestType = com.google.cloud.vision.v1.GetReferenceImageRequest.class,
      responseType = com.google.cloud.vision.v1.ReferenceImage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getGetReferenceImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.GetReferenceImageRequest,
            com.google.cloud.vision.v1.ReferenceImage>
        getGetReferenceImageMethod;
    if ((getGetReferenceImageMethod = ProductSearchGrpc.getGetReferenceImageMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getGetReferenceImageMethod = ProductSearchGrpc.getGetReferenceImageMethod) == null) {
          ProductSearchGrpc.getGetReferenceImageMethod =
              getGetReferenceImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.GetReferenceImageRequest,
                          com.google.cloud.vision.v1.ReferenceImage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReferenceImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.GetReferenceImageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ReferenceImage.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("GetReferenceImage"))
                      .build();
        }
      }
    }
    return getGetReferenceImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
      getAddProductToProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddProductToProductSet",
      requestType = com.google.cloud.vision.v1.AddProductToProductSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
      getAddProductToProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
        getAddProductToProductSetMethod;
    if ((getAddProductToProductSetMethod = ProductSearchGrpc.getAddProductToProductSetMethod)
        == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getAddProductToProductSetMethod = ProductSearchGrpc.getAddProductToProductSetMethod)
            == null) {
          ProductSearchGrpc.getAddProductToProductSetMethod =
              getAddProductToProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.AddProductToProductSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddProductToProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.AddProductToProductSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("AddProductToProductSet"))
                      .build();
        }
      }
    }
    return getAddProductToProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.RemoveProductFromProductSetRequest, com.google.protobuf.Empty>
      getRemoveProductFromProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveProductFromProductSet",
      requestType = com.google.cloud.vision.v1.RemoveProductFromProductSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.RemoveProductFromProductSetRequest, com.google.protobuf.Empty>
      getRemoveProductFromProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.RemoveProductFromProductSetRequest,
            com.google.protobuf.Empty>
        getRemoveProductFromProductSetMethod;
    if ((getRemoveProductFromProductSetMethod =
            ProductSearchGrpc.getRemoveProductFromProductSetMethod)
        == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getRemoveProductFromProductSetMethod =
                ProductSearchGrpc.getRemoveProductFromProductSetMethod)
            == null) {
          ProductSearchGrpc.getRemoveProductFromProductSetMethod =
              getRemoveProductFromProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.RemoveProductFromProductSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveProductFromProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.RemoveProductFromProductSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("RemoveProductFromProductSet"))
                      .build();
        }
      }
    }
    return getRemoveProductFromProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsInProductSetRequest,
          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
      getListProductsInProductSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProductsInProductSet",
      requestType = com.google.cloud.vision.v1.ListProductsInProductSetRequest.class,
      responseType = com.google.cloud.vision.v1.ListProductsInProductSetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsInProductSetRequest,
          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
      getListProductsInProductSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.ListProductsInProductSetRequest,
            com.google.cloud.vision.v1.ListProductsInProductSetResponse>
        getListProductsInProductSetMethod;
    if ((getListProductsInProductSetMethod = ProductSearchGrpc.getListProductsInProductSetMethod)
        == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getListProductsInProductSetMethod =
                ProductSearchGrpc.getListProductsInProductSetMethod)
            == null) {
          ProductSearchGrpc.getListProductsInProductSetMethod =
              getListProductsInProductSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.ListProductsInProductSetRequest,
                          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListProductsInProductSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListProductsInProductSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ListProductsInProductSetResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("ListProductsInProductSet"))
                      .build();
        }
      }
    }
    return getListProductsInProductSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
      getImportProductSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportProductSets",
      requestType = com.google.cloud.vision.v1.ImportProductSetsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
      getImportProductSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
        getImportProductSetsMethod;
    if ((getImportProductSetsMethod = ProductSearchGrpc.getImportProductSetsMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getImportProductSetsMethod = ProductSearchGrpc.getImportProductSetsMethod) == null) {
          ProductSearchGrpc.getImportProductSetsMethod =
              getImportProductSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.ImportProductSetsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportProductSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.ImportProductSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("ImportProductSets"))
                      .build();
        }
      }
    }
    return getImportProductSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeProducts",
      requestType = com.google.cloud.vision.v1.PurgeProductsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
        getPurgeProductsMethod;
    if ((getPurgeProductsMethod = ProductSearchGrpc.getPurgeProductsMethod) == null) {
      synchronized (ProductSearchGrpc.class) {
        if ((getPurgeProductsMethod = ProductSearchGrpc.getPurgeProductsMethod) == null) {
          ProductSearchGrpc.getPurgeProductsMethod =
              getPurgeProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1.PurgeProductsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurgeProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1.PurgeProductsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProductSearchMethodDescriptorSupplier("PurgeProducts"))
                      .build();
        }
      }
    }
    return getPurgeProductsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProductSearchStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductSearchStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductSearchStub>() {
          @java.lang.Override
          public ProductSearchStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductSearchStub(channel, callOptions);
          }
        };
    return ProductSearchStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductSearchBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductSearchBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductSearchBlockingStub>() {
          @java.lang.Override
          public ProductSearchBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductSearchBlockingStub(channel, callOptions);
          }
        };
    return ProductSearchBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductSearchFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductSearchFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProductSearchFutureStub>() {
          @java.lang.Override
          public ProductSearchFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProductSearchFutureStub(channel, callOptions);
          }
        };
    return ProductSearchFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Products and ProductSets of reference images for use in product
   * search. It uses the following resource model:
   * - The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;productSets/&#42;`, which acts as a way to put different
   * products into groups to limit identification.
   * In parallel,
   * - The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;`
   * - Each [Product][google.cloud.vision.v1.Product] has a collection of [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;&#47;referenceImages/&#42;`
   * </pre>
   */
  public abstract static class ProductSearchImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates and returns a new ProductSet resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing, or is longer than
     *   4096 characters.
     * </pre>
     */
    public void createProductSet(
        com.google.cloud.vision.v1.CreateProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSets in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public void listProductSets(
        com.google.cloud.vision.v1.ListProductSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ProductSet.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * </pre>
     */
    public void getProductSet(
        com.google.cloud.vision.v1.GetProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a ProductSet resource.
     * Only display_name can be updated currently.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but
     *   missing from the request or longer than 4096 characters.
     * </pre>
     */
    public void updateProductSet(
        com.google.cloud.vision.v1.UpdateProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a ProductSet. Products and ReferenceImages in the
     * ProductSet are not deleted.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public void deleteProductSet(
        com.google.cloud.vision.v1.DeleteProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new product resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if description is longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is missing or invalid.
     * </pre>
     */
    public void createProduct(
        com.google.cloud.vision.v1.CreateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists products in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public void listProducts(
        com.google.cloud.vision.v1.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a Product.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * </pre>
     */
    public void getProduct(
        com.google.cloud.vision.v1.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a Product resource.
     * Only the `display_name`, `description`, and `labels` fields can be updated
     * right now.
     * If labels are updated, the change will not be reflected in queries until
     * the next index time.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but is
     *   missing from the request or longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if description is present in update_mask but is
     *   longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is present in update_mask.
     * </pre>
     */
    public void updateProduct(
        com.google.cloud.vision.v1.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a product and its reference images.
     * Metadata of the product and all its images will be deleted right away, but
     * search queries against ProductSets containing the product may still work
     * until all related caches are refreshed.
     * </pre>
     */
    public void deleteProduct(
        com.google.cloud.vision.v1.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProductMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new ReferenceImage resource.
     * The `bounding_poly` field is optional. If `bounding_poly` is not specified,
     * the system will try to detect regions of interest in the image that are
     * compatible with the product_category on the parent product. If it is
     * specified, detection is ALWAYS skipped. The system converts polygons into
     * non-rotated rectangles.
     * Note that the pipeline will resize the image if the image resolution is too
     * large to process (above 50MP).
     * Possible errors:
     * * Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if the product does not exist.
     * * Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing
     *   compatible with the parent product's product_category is detected.
     * * Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
     * </pre>
     */
    public void createReferenceImage(
        com.google.cloud.vision.v1.CreateReferenceImageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ReferenceImage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReferenceImageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a reference image.
     * The image metadata will be deleted right away, but search queries
     * against ProductSets containing the image may still work until all related
     * caches are refreshed.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public void deleteReferenceImage(
        com.google.cloud.vision.v1.DeleteReferenceImageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReferenceImageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reference images.
     * Possible errors:
     * * Returns NOT_FOUND if the parent product does not exist.
     * * Returns INVALID_ARGUMENT if the page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public void listReferenceImages(
        com.google.cloud.vision.v1.ListReferenceImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListReferenceImagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReferenceImagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ReferenceImage.
     * Possible errors:
     * * Returns NOT_FOUND if the specified image does not exist.
     * </pre>
     */
    public void getReferenceImage(
        com.google.cloud.vision.v1.GetReferenceImageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ReferenceImage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReferenceImageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a Product to the specified ProductSet. If the Product is already
     * present, no change is made.
     * One Product can be added to at most 100 ProductSets.
     * Possible errors:
     * * Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
     * </pre>
     */
    public void addProductToProductSet(
        com.google.cloud.vision.v1.AddProductToProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddProductToProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Product from the specified ProductSet.
     * </pre>
     */
    public void removeProductFromProductSet(
        com.google.cloud.vision.v1.RemoveProductFromProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveProductFromProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products in a ProductSet, in an unspecified order. If the
     * ProductSet does not exist, the products field of the response will be
     * empty.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public void listProductsInProductSet(
        com.google.cloud.vision.v1.ListProductsInProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductsInProductSetResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductsInProductSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API that imports a list of reference images to specified
     * product sets based on a list of image information.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * `Operation.response` contains `ImportProductSetsResponse`. (results)
     * The input source of this method is a csv file on Google Cloud Storage.
     * For the format of the csv file please see
     * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
     * </pre>
     */
    public void importProductSets(
        com.google.cloud.vision.v1.ImportProductSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportProductSetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API to delete all Products in a ProductSet or all Products
     * that are in no ProductSet.
     * If a Product is a member of the specified ProductSet in addition to other
     * ProductSets, the Product will still be deleted.
     * It is recommended to not delete the specified ProductSet until after this
     * operation has completed. It is also recommended to not add any of the
     * Products involved in the batch delete to a new ProductSet while this
     * operation is running because those Products may still end up deleted.
     * It's not possible to undo the PurgeProducts operation. Therefore, it is
     * recommended to keep the csv files used in ImportProductSets (if that was
     * how you originally built the Product Set) before starting PurgeProducts, in
     * case you need to re-import the data after deletion.
     * If the plan is to purge all of the Products from a ProductSet and then
     * re-use the empty ProductSet to re-import new Products into the empty
     * ProductSet, you must wait until the PurgeProducts operation has finished
     * for that ProductSet.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * </pre>
     */
    public void purgeProducts(
        com.google.cloud.vision.v1.PurgeProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeProductsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.CreateProductSetRequest,
                      com.google.cloud.vision.v1.ProductSet>(this, METHODID_CREATE_PRODUCT_SET)))
          .addMethod(
              getListProductSetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListProductSetsRequest,
                      com.google.cloud.vision.v1.ListProductSetsResponse>(
                      this, METHODID_LIST_PRODUCT_SETS)))
          .addMethod(
              getGetProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.GetProductSetRequest,
                      com.google.cloud.vision.v1.ProductSet>(this, METHODID_GET_PRODUCT_SET)))
          .addMethod(
              getUpdateProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.UpdateProductSetRequest,
                      com.google.cloud.vision.v1.ProductSet>(this, METHODID_UPDATE_PRODUCT_SET)))
          .addMethod(
              getDeleteProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.DeleteProductSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PRODUCT_SET)))
          .addMethod(
              getCreateProductMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.CreateProductRequest,
                      com.google.cloud.vision.v1.Product>(this, METHODID_CREATE_PRODUCT)))
          .addMethod(
              getListProductsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListProductsRequest,
                      com.google.cloud.vision.v1.ListProductsResponse>(
                      this, METHODID_LIST_PRODUCTS)))
          .addMethod(
              getGetProductMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.GetProductRequest,
                      com.google.cloud.vision.v1.Product>(this, METHODID_GET_PRODUCT)))
          .addMethod(
              getUpdateProductMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.UpdateProductRequest,
                      com.google.cloud.vision.v1.Product>(this, METHODID_UPDATE_PRODUCT)))
          .addMethod(
              getDeleteProductMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_PRODUCT)))
          .addMethod(
              getCreateReferenceImageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.CreateReferenceImageRequest,
                      com.google.cloud.vision.v1.ReferenceImage>(
                      this, METHODID_CREATE_REFERENCE_IMAGE)))
          .addMethod(
              getDeleteReferenceImageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.DeleteReferenceImageRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_REFERENCE_IMAGE)))
          .addMethod(
              getListReferenceImagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListReferenceImagesRequest,
                      com.google.cloud.vision.v1.ListReferenceImagesResponse>(
                      this, METHODID_LIST_REFERENCE_IMAGES)))
          .addMethod(
              getGetReferenceImageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.GetReferenceImageRequest,
                      com.google.cloud.vision.v1.ReferenceImage>(
                      this, METHODID_GET_REFERENCE_IMAGE)))
          .addMethod(
              getAddProductToProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.AddProductToProductSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_ADD_PRODUCT_TO_PRODUCT_SET)))
          .addMethod(
              getRemoveProductFromProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.RemoveProductFromProductSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_REMOVE_PRODUCT_FROM_PRODUCT_SET)))
          .addMethod(
              getListProductsInProductSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListProductsInProductSetRequest,
                      com.google.cloud.vision.v1.ListProductsInProductSetResponse>(
                      this, METHODID_LIST_PRODUCTS_IN_PRODUCT_SET)))
          .addMethod(
              getImportProductSetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ImportProductSetsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_PRODUCT_SETS)))
          .addMethod(
              getPurgeProductsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.PurgeProductsRequest,
                      com.google.longrunning.Operation>(this, METHODID_PURGE_PRODUCTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Products and ProductSets of reference images for use in product
   * search. It uses the following resource model:
   * - The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;productSets/&#42;`, which acts as a way to put different
   * products into groups to limit identification.
   * In parallel,
   * - The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;`
   * - Each [Product][google.cloud.vision.v1.Product] has a collection of [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;&#47;referenceImages/&#42;`
   * </pre>
   */
  public static final class ProductSearchStub
      extends io.grpc.stub.AbstractAsyncStub<ProductSearchStub> {
    private ProductSearchStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductSearchStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductSearchStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new ProductSet resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing, or is longer than
     *   4096 characters.
     * </pre>
     */
    public void createProductSet(
        com.google.cloud.vision.v1.CreateProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSets in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public void listProductSets(
        com.google.cloud.vision.v1.ListProductSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ProductSet.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * </pre>
     */
    public void getProductSet(
        com.google.cloud.vision.v1.GetProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a ProductSet resource.
     * Only display_name can be updated currently.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but
     *   missing from the request or longer than 4096 characters.
     * </pre>
     */
    public void updateProductSet(
        com.google.cloud.vision.v1.UpdateProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a ProductSet. Products and ReferenceImages in the
     * ProductSet are not deleted.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public void deleteProductSet(
        com.google.cloud.vision.v1.DeleteProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new product resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if description is longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is missing or invalid.
     * </pre>
     */
    public void createProduct(
        com.google.cloud.vision.v1.CreateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists products in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public void listProducts(
        com.google.cloud.vision.v1.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductsResponse>
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
     * Gets information associated with a Product.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * </pre>
     */
    public void getProduct(
        com.google.cloud.vision.v1.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a Product resource.
     * Only the `display_name`, `description`, and `labels` fields can be updated
     * right now.
     * If labels are updated, the change will not be reflected in queries until
     * the next index time.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but is
     *   missing from the request or longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if description is present in update_mask but is
     *   longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is present in update_mask.
     * </pre>
     */
    public void updateProduct(
        com.google.cloud.vision.v1.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a product and its reference images.
     * Metadata of the product and all its images will be deleted right away, but
     * search queries against ProductSets containing the product may still work
     * until all related caches are refreshed.
     * </pre>
     */
    public void deleteProduct(
        com.google.cloud.vision.v1.DeleteProductRequest request,
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
     * Creates and returns a new ReferenceImage resource.
     * The `bounding_poly` field is optional. If `bounding_poly` is not specified,
     * the system will try to detect regions of interest in the image that are
     * compatible with the product_category on the parent product. If it is
     * specified, detection is ALWAYS skipped. The system converts polygons into
     * non-rotated rectangles.
     * Note that the pipeline will resize the image if the image resolution is too
     * large to process (above 50MP).
     * Possible errors:
     * * Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if the product does not exist.
     * * Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing
     *   compatible with the parent product's product_category is detected.
     * * Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
     * </pre>
     */
    public void createReferenceImage(
        com.google.cloud.vision.v1.CreateReferenceImageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ReferenceImage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReferenceImageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a reference image.
     * The image metadata will be deleted right away, but search queries
     * against ProductSets containing the image may still work until all related
     * caches are refreshed.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public void deleteReferenceImage(
        com.google.cloud.vision.v1.DeleteReferenceImageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReferenceImageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reference images.
     * Possible errors:
     * * Returns NOT_FOUND if the parent product does not exist.
     * * Returns INVALID_ARGUMENT if the page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public void listReferenceImages(
        com.google.cloud.vision.v1.ListReferenceImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListReferenceImagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReferenceImagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ReferenceImage.
     * Possible errors:
     * * Returns NOT_FOUND if the specified image does not exist.
     * </pre>
     */
    public void getReferenceImage(
        com.google.cloud.vision.v1.GetReferenceImageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ReferenceImage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReferenceImageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a Product to the specified ProductSet. If the Product is already
     * present, no change is made.
     * One Product can be added to at most 100 ProductSets.
     * Possible errors:
     * * Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
     * </pre>
     */
    public void addProductToProductSet(
        com.google.cloud.vision.v1.AddProductToProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductToProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Product from the specified ProductSet.
     * </pre>
     */
    public void removeProductFromProductSet(
        com.google.cloud.vision.v1.RemoveProductFromProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveProductFromProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products in a ProductSet, in an unspecified order. If the
     * ProductSet does not exist, the products field of the response will be
     * empty.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public void listProductsInProductSet(
        com.google.cloud.vision.v1.ListProductsInProductSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductsInProductSetResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductsInProductSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API that imports a list of reference images to specified
     * product sets based on a list of image information.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * `Operation.response` contains `ImportProductSetsResponse`. (results)
     * The input source of this method is a csv file on Google Cloud Storage.
     * For the format of the csv file please see
     * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
     * </pre>
     */
    public void importProductSets(
        com.google.cloud.vision.v1.ImportProductSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportProductSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API to delete all Products in a ProductSet or all Products
     * that are in no ProductSet.
     * If a Product is a member of the specified ProductSet in addition to other
     * ProductSets, the Product will still be deleted.
     * It is recommended to not delete the specified ProductSet until after this
     * operation has completed. It is also recommended to not add any of the
     * Products involved in the batch delete to a new ProductSet while this
     * operation is running because those Products may still end up deleted.
     * It's not possible to undo the PurgeProducts operation. Therefore, it is
     * recommended to keep the csv files used in ImportProductSets (if that was
     * how you originally built the Product Set) before starting PurgeProducts, in
     * case you need to re-import the data after deletion.
     * If the plan is to purge all of the Products from a ProductSet and then
     * re-use the empty ProductSet to re-import new Products into the empty
     * ProductSet, you must wait until the PurgeProducts operation has finished
     * for that ProductSet.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * </pre>
     */
    public void purgeProducts(
        com.google.cloud.vision.v1.PurgeProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Products and ProductSets of reference images for use in product
   * search. It uses the following resource model:
   * - The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;productSets/&#42;`, which acts as a way to put different
   * products into groups to limit identification.
   * In parallel,
   * - The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;`
   * - Each [Product][google.cloud.vision.v1.Product] has a collection of [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;&#47;referenceImages/&#42;`
   * </pre>
   */
  public static final class ProductSearchBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductSearchBlockingStub> {
    private ProductSearchBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductSearchBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductSearchBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new ProductSet resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing, or is longer than
     *   4096 characters.
     * </pre>
     */
    public com.google.cloud.vision.v1.ProductSet createProductSet(
        com.google.cloud.vision.v1.CreateProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSets in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public com.google.cloud.vision.v1.ListProductSetsResponse listProductSets(
        com.google.cloud.vision.v1.ListProductSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ProductSet.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * </pre>
     */
    public com.google.cloud.vision.v1.ProductSet getProductSet(
        com.google.cloud.vision.v1.GetProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a ProductSet resource.
     * Only display_name can be updated currently.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but
     *   missing from the request or longer than 4096 characters.
     * </pre>
     */
    public com.google.cloud.vision.v1.ProductSet updateProductSet(
        com.google.cloud.vision.v1.UpdateProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a ProductSet. Products and ReferenceImages in the
     * ProductSet are not deleted.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProductSet(
        com.google.cloud.vision.v1.DeleteProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new product resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if description is longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is missing or invalid.
     * </pre>
     */
    public com.google.cloud.vision.v1.Product createProduct(
        com.google.cloud.vision.v1.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists products in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public com.google.cloud.vision.v1.ListProductsResponse listProducts(
        com.google.cloud.vision.v1.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a Product.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * </pre>
     */
    public com.google.cloud.vision.v1.Product getProduct(
        com.google.cloud.vision.v1.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a Product resource.
     * Only the `display_name`, `description`, and `labels` fields can be updated
     * right now.
     * If labels are updated, the change will not be reflected in queries until
     * the next index time.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but is
     *   missing from the request or longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if description is present in update_mask but is
     *   longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is present in update_mask.
     * </pre>
     */
    public com.google.cloud.vision.v1.Product updateProduct(
        com.google.cloud.vision.v1.UpdateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a product and its reference images.
     * Metadata of the product and all its images will be deleted right away, but
     * search queries against ProductSets containing the product may still work
     * until all related caches are refreshed.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProduct(
        com.google.cloud.vision.v1.DeleteProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new ReferenceImage resource.
     * The `bounding_poly` field is optional. If `bounding_poly` is not specified,
     * the system will try to detect regions of interest in the image that are
     * compatible with the product_category on the parent product. If it is
     * specified, detection is ALWAYS skipped. The system converts polygons into
     * non-rotated rectangles.
     * Note that the pipeline will resize the image if the image resolution is too
     * large to process (above 50MP).
     * Possible errors:
     * * Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if the product does not exist.
     * * Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing
     *   compatible with the parent product's product_category is detected.
     * * Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
     * </pre>
     */
    public com.google.cloud.vision.v1.ReferenceImage createReferenceImage(
        com.google.cloud.vision.v1.CreateReferenceImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReferenceImageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a reference image.
     * The image metadata will be deleted right away, but search queries
     * against ProductSets containing the image may still work until all related
     * caches are refreshed.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public com.google.protobuf.Empty deleteReferenceImage(
        com.google.cloud.vision.v1.DeleteReferenceImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReferenceImageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reference images.
     * Possible errors:
     * * Returns NOT_FOUND if the parent product does not exist.
     * * Returns INVALID_ARGUMENT if the page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public com.google.cloud.vision.v1.ListReferenceImagesResponse listReferenceImages(
        com.google.cloud.vision.v1.ListReferenceImagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReferenceImagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ReferenceImage.
     * Possible errors:
     * * Returns NOT_FOUND if the specified image does not exist.
     * </pre>
     */
    public com.google.cloud.vision.v1.ReferenceImage getReferenceImage(
        com.google.cloud.vision.v1.GetReferenceImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReferenceImageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a Product to the specified ProductSet. If the Product is already
     * present, no change is made.
     * One Product can be added to at most 100 ProductSets.
     * Possible errors:
     * * Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
     * </pre>
     */
    public com.google.protobuf.Empty addProductToProductSet(
        com.google.cloud.vision.v1.AddProductToProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductToProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Product from the specified ProductSet.
     * </pre>
     */
    public com.google.protobuf.Empty removeProductFromProductSet(
        com.google.cloud.vision.v1.RemoveProductFromProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveProductFromProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products in a ProductSet, in an unspecified order. If the
     * ProductSet does not exist, the products field of the response will be
     * empty.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public com.google.cloud.vision.v1.ListProductsInProductSetResponse listProductsInProductSet(
        com.google.cloud.vision.v1.ListProductsInProductSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsInProductSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API that imports a list of reference images to specified
     * product sets based on a list of image information.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * `Operation.response` contains `ImportProductSetsResponse`. (results)
     * The input source of this method is a csv file on Google Cloud Storage.
     * For the format of the csv file please see
     * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
     * </pre>
     */
    public com.google.longrunning.Operation importProductSets(
        com.google.cloud.vision.v1.ImportProductSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportProductSetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API to delete all Products in a ProductSet or all Products
     * that are in no ProductSet.
     * If a Product is a member of the specified ProductSet in addition to other
     * ProductSets, the Product will still be deleted.
     * It is recommended to not delete the specified ProductSet until after this
     * operation has completed. It is also recommended to not add any of the
     * Products involved in the batch delete to a new ProductSet while this
     * operation is running because those Products may still end up deleted.
     * It's not possible to undo the PurgeProducts operation. Therefore, it is
     * recommended to keep the csv files used in ImportProductSets (if that was
     * how you originally built the Product Set) before starting PurgeProducts, in
     * case you need to re-import the data after deletion.
     * If the plan is to purge all of the Products from a ProductSet and then
     * re-use the empty ProductSet to re-import new Products into the empty
     * ProductSet, you must wait until the PurgeProducts operation has finished
     * for that ProductSet.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * </pre>
     */
    public com.google.longrunning.Operation purgeProducts(
        com.google.cloud.vision.v1.PurgeProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Products and ProductSets of reference images for use in product
   * search. It uses the following resource model:
   * - The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;productSets/&#42;`, which acts as a way to put different
   * products into groups to limit identification.
   * In parallel,
   * - The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;`
   * - Each [Product][google.cloud.vision.v1.Product] has a collection of [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
   *   `projects/&#42;&#47;locations/&#42;&#47;products/&#42;&#47;referenceImages/&#42;`
   * </pre>
   */
  public static final class ProductSearchFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductSearchFutureStub> {
    private ProductSearchFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductSearchFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductSearchFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new ProductSet resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing, or is longer than
     *   4096 characters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vision.v1.ProductSet>
        createProductSet(com.google.cloud.vision.v1.CreateProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists ProductSets in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1.ListProductSetsResponse>
        listProductSets(com.google.cloud.vision.v1.ListProductSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductSetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ProductSet.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vision.v1.ProductSet>
        getProductSet(com.google.cloud.vision.v1.GetProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a ProductSet resource.
     * Only display_name can be updated currently.
     * Possible errors:
     * * Returns NOT_FOUND if the ProductSet does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but
     *   missing from the request or longer than 4096 characters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vision.v1.ProductSet>
        updateProductSet(com.google.cloud.vision.v1.UpdateProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a ProductSet. Products and ReferenceImages in the
     * ProductSet are not deleted.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProductSet(com.google.cloud.vision.v1.DeleteProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new product resource.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if display_name is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if description is longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is missing or invalid.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vision.v1.Product>
        createProduct(com.google.cloud.vision.v1.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists products in an unspecified order.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1.ListProductsResponse>
        listProducts(com.google.cloud.vision.v1.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a Product.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vision.v1.Product>
        getProduct(com.google.cloud.vision.v1.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Makes changes to a Product resource.
     * Only the `display_name`, `description`, and `labels` fields can be updated
     * right now.
     * If labels are updated, the change will not be reflected in queries until
     * the next index time.
     * Possible errors:
     * * Returns NOT_FOUND if the Product does not exist.
     * * Returns INVALID_ARGUMENT if display_name is present in update_mask but is
     *   missing from the request or longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if description is present in update_mask but is
     *   longer than 4096 characters.
     * * Returns INVALID_ARGUMENT if product_category is present in update_mask.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.vision.v1.Product>
        updateProduct(com.google.cloud.vision.v1.UpdateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a product and its reference images.
     * Metadata of the product and all its images will be deleted right away, but
     * search queries against ProductSets containing the product may still work
     * until all related caches are refreshed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProduct(com.google.cloud.vision.v1.DeleteProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new ReferenceImage resource.
     * The `bounding_poly` field is optional. If `bounding_poly` is not specified,
     * the system will try to detect regions of interest in the image that are
     * compatible with the product_category on the parent product. If it is
     * specified, detection is ALWAYS skipped. The system converts polygons into
     * non-rotated rectangles.
     * Note that the pipeline will resize the image if the image resolution is too
     * large to process (above 50MP).
     * Possible errors:
     * * Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096
     *   characters.
     * * Returns INVALID_ARGUMENT if the product does not exist.
     * * Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing
     *   compatible with the parent product's product_category is detected.
     * * Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1.ReferenceImage>
        createReferenceImage(com.google.cloud.vision.v1.CreateReferenceImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReferenceImageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes a reference image.
     * The image metadata will be deleted right away, but search queries
     * against ProductSets containing the image may still work until all related
     * caches are refreshed.
     * The actual image files are not deleted from Google Cloud Storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteReferenceImage(com.google.cloud.vision.v1.DeleteReferenceImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReferenceImageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reference images.
     * Possible errors:
     * * Returns NOT_FOUND if the parent product does not exist.
     * * Returns INVALID_ARGUMENT if the page_size is greater than 100, or less
     *   than 1.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1.ListReferenceImagesResponse>
        listReferenceImages(com.google.cloud.vision.v1.ListReferenceImagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReferenceImagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information associated with a ReferenceImage.
     * Possible errors:
     * * Returns NOT_FOUND if the specified image does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1.ReferenceImage>
        getReferenceImage(com.google.cloud.vision.v1.GetReferenceImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReferenceImageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a Product to the specified ProductSet. If the Product is already
     * present, no change is made.
     * One Product can be added to at most 100 ProductSets.
     * Possible errors:
     * * Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        addProductToProductSet(com.google.cloud.vision.v1.AddProductToProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductToProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Product from the specified ProductSet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        removeProductFromProductSet(
            com.google.cloud.vision.v1.RemoveProductFromProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveProductFromProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products in a ProductSet, in an unspecified order. If the
     * ProductSet does not exist, the products field of the response will be
     * empty.
     * Possible errors:
     * * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1.ListProductsInProductSetResponse>
        listProductsInProductSet(
            com.google.cloud.vision.v1.ListProductsInProductSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsInProductSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API that imports a list of reference images to specified
     * product sets based on a list of image information.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * `Operation.response` contains `ImportProductSetsResponse`. (results)
     * The input source of this method is a csv file on Google Cloud Storage.
     * For the format of the csv file please see
     * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importProductSets(com.google.cloud.vision.v1.ImportProductSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportProductSetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Asynchronous API to delete all Products in a ProductSet or all Products
     * that are in no ProductSet.
     * If a Product is a member of the specified ProductSet in addition to other
     * ProductSets, the Product will still be deleted.
     * It is recommended to not delete the specified ProductSet until after this
     * operation has completed. It is also recommended to not add any of the
     * Products involved in the batch delete to a new ProductSet while this
     * operation is running because those Products may still end up deleted.
     * It's not possible to undo the PurgeProducts operation. Therefore, it is
     * recommended to keep the csv files used in ImportProductSets (if that was
     * how you originally built the Product Set) before starting PurgeProducts, in
     * case you need to re-import the data after deletion.
     * If the plan is to purge all of the Products from a ProductSet and then
     * re-use the empty ProductSet to re-import new Products into the empty
     * ProductSet, you must wait until the PurgeProducts operation has finished
     * for that ProductSet.
     * The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep track of the
     * progress and results of the request.
     * `Operation.metadata` contains `BatchOperationMetadata`. (progress)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeProducts(com.google.cloud.vision.v1.PurgeProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PRODUCT_SET = 0;
  private static final int METHODID_LIST_PRODUCT_SETS = 1;
  private static final int METHODID_GET_PRODUCT_SET = 2;
  private static final int METHODID_UPDATE_PRODUCT_SET = 3;
  private static final int METHODID_DELETE_PRODUCT_SET = 4;
  private static final int METHODID_CREATE_PRODUCT = 5;
  private static final int METHODID_LIST_PRODUCTS = 6;
  private static final int METHODID_GET_PRODUCT = 7;
  private static final int METHODID_UPDATE_PRODUCT = 8;
  private static final int METHODID_DELETE_PRODUCT = 9;
  private static final int METHODID_CREATE_REFERENCE_IMAGE = 10;
  private static final int METHODID_DELETE_REFERENCE_IMAGE = 11;
  private static final int METHODID_LIST_REFERENCE_IMAGES = 12;
  private static final int METHODID_GET_REFERENCE_IMAGE = 13;
  private static final int METHODID_ADD_PRODUCT_TO_PRODUCT_SET = 14;
  private static final int METHODID_REMOVE_PRODUCT_FROM_PRODUCT_SET = 15;
  private static final int METHODID_LIST_PRODUCTS_IN_PRODUCT_SET = 16;
  private static final int METHODID_IMPORT_PRODUCT_SETS = 17;
  private static final int METHODID_PURGE_PRODUCTS = 18;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductSearchImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductSearchImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PRODUCT_SET:
          serviceImpl.createProductSet(
              (com.google.cloud.vision.v1.CreateProductSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCT_SETS:
          serviceImpl.listProductSets(
              (com.google.cloud.vision.v1.ListProductSetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductSetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PRODUCT_SET:
          serviceImpl.getProductSet(
              (com.google.cloud.vision.v1.GetProductSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT_SET:
          serviceImpl.updateProductSet(
              (com.google.cloud.vision.v1.UpdateProductSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ProductSet>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRODUCT_SET:
          serviceImpl.deleteProductSet(
              (com.google.cloud.vision.v1.DeleteProductSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_PRODUCT:
          serviceImpl.createProduct(
              (com.google.cloud.vision.v1.CreateProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product>) responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts(
              (com.google.cloud.vision.v1.ListProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListProductsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct(
              (com.google.cloud.vision.v1.GetProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product>) responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT:
          serviceImpl.updateProduct(
              (com.google.cloud.vision.v1.UpdateProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.Product>) responseObserver);
          break;
        case METHODID_DELETE_PRODUCT:
          serviceImpl.deleteProduct(
              (com.google.cloud.vision.v1.DeleteProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_REFERENCE_IMAGE:
          serviceImpl.createReferenceImage(
              (com.google.cloud.vision.v1.CreateReferenceImageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ReferenceImage>)
                  responseObserver);
          break;
        case METHODID_DELETE_REFERENCE_IMAGE:
          serviceImpl.deleteReferenceImage(
              (com.google.cloud.vision.v1.DeleteReferenceImageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_REFERENCE_IMAGES:
          serviceImpl.listReferenceImages(
              (com.google.cloud.vision.v1.ListReferenceImagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ListReferenceImagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REFERENCE_IMAGE:
          serviceImpl.getReferenceImage(
              (com.google.cloud.vision.v1.GetReferenceImageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.vision.v1.ReferenceImage>)
                  responseObserver);
          break;
        case METHODID_ADD_PRODUCT_TO_PRODUCT_SET:
          serviceImpl.addProductToProductSet(
              (com.google.cloud.vision.v1.AddProductToProductSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_PRODUCT_FROM_PRODUCT_SET:
          serviceImpl.removeProductFromProductSet(
              (com.google.cloud.vision.v1.RemoveProductFromProductSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_PRODUCTS_IN_PRODUCT_SET:
          serviceImpl.listProductsInProductSet(
              (com.google.cloud.vision.v1.ListProductsInProductSetRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vision.v1.ListProductsInProductSetResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_PRODUCT_SETS:
          serviceImpl.importProductSets(
              (com.google.cloud.vision.v1.ImportProductSetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_PRODUCTS:
          serviceImpl.purgeProducts(
              (com.google.cloud.vision.v1.PurgeProductsRequest) request,
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

  private abstract static class ProductSearchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductSearchBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vision.v1.ProductSearchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductSearch");
    }
  }

  private static final class ProductSearchFileDescriptorSupplier
      extends ProductSearchBaseDescriptorSupplier {
    ProductSearchFileDescriptorSupplier() {}
  }

  private static final class ProductSearchMethodDescriptorSupplier
      extends ProductSearchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductSearchMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductSearchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProductSearchFileDescriptorSupplier())
                      .addMethod(getCreateProductSetMethod())
                      .addMethod(getListProductSetsMethod())
                      .addMethod(getGetProductSetMethod())
                      .addMethod(getUpdateProductSetMethod())
                      .addMethod(getDeleteProductSetMethod())
                      .addMethod(getCreateProductMethod())
                      .addMethod(getListProductsMethod())
                      .addMethod(getGetProductMethod())
                      .addMethod(getUpdateProductMethod())
                      .addMethod(getDeleteProductMethod())
                      .addMethod(getCreateReferenceImageMethod())
                      .addMethod(getDeleteReferenceImageMethod())
                      .addMethod(getListReferenceImagesMethod())
                      .addMethod(getGetReferenceImageMethod())
                      .addMethod(getAddProductToProductSetMethod())
                      .addMethod(getRemoveProductFromProductSetMethod())
                      .addMethod(getListProductsInProductSetMethod())
                      .addMethod(getImportProductSetsMethod())
                      .addMethod(getPurgeProductsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
