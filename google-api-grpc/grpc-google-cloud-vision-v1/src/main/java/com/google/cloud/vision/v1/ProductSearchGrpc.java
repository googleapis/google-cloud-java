package com.google.cloud.vision.v1;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/vision/v1/product_search_service.proto")
public final class ProductSearchGrpc {

  private ProductSearchGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.vision.v1.ProductSearch";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      METHOD_CREATE_PRODUCT_SET = getCreateProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getCreateProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getCreateProductSetMethod() {
    return getCreateProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getCreateProductSetMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "CreateProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListProductSetsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductSetsRequest,
          com.google.cloud.vision.v1.ListProductSetsResponse>
      METHOD_LIST_PRODUCT_SETS = getListProductSetsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductSetsRequest,
          com.google.cloud.vision.v1.ListProductSetsResponse>
      getListProductSetsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductSetsRequest,
          com.google.cloud.vision.v1.ListProductSetsResponse>
      getListProductSetsMethod() {
    return getListProductSetsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductSetsRequest,
          com.google.cloud.vision.v1.ListProductSetsResponse>
      getListProductSetsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "ListProductSets"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      METHOD_GET_PRODUCT_SET = getGetProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getGetProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getGetProductSetMethod() {
    return getGetProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getGetProductSetMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "GetProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      METHOD_UPDATE_PRODUCT_SET = getUpdateProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getUpdateProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getUpdateProductSetMethod() {
    return getUpdateProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductSetRequest, com.google.cloud.vision.v1.ProductSet>
      getUpdateProductSetMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "UpdateProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
      METHOD_DELETE_PRODUCT_SET = getDeleteProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
      getDeleteProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
      getDeleteProductSetMethod() {
    return getDeleteProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductSetRequest, com.google.protobuf.Empty>
      getDeleteProductSetMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "DeleteProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateProductMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
      METHOD_CREATE_PRODUCT = getCreateProductMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
      getCreateProductMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
      getCreateProductMethod() {
    return getCreateProductMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateProductRequest, com.google.cloud.vision.v1.Product>
      getCreateProductMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "CreateProduct"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListProductsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsRequest,
          com.google.cloud.vision.v1.ListProductsResponse>
      METHOD_LIST_PRODUCTS = getListProductsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsRequest,
          com.google.cloud.vision.v1.ListProductsResponse>
      getListProductsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsRequest,
          com.google.cloud.vision.v1.ListProductsResponse>
      getListProductsMethod() {
    return getListProductsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsRequest,
          com.google.cloud.vision.v1.ListProductsResponse>
      getListProductsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "ListProducts"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetProductMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
      METHOD_GET_PRODUCT = getGetProductMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
      getGetProductMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
      getGetProductMethod() {
    return getGetProductMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetProductRequest, com.google.cloud.vision.v1.Product>
      getGetProductMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "GetProduct"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateProductMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
      METHOD_UPDATE_PRODUCT = getUpdateProductMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
      getUpdateProductMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
      getUpdateProductMethod() {
    return getUpdateProductMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.UpdateProductRequest, com.google.cloud.vision.v1.Product>
      getUpdateProductMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "UpdateProduct"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteProductMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
      METHOD_DELETE_PRODUCT = getDeleteProductMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethod() {
    return getDeleteProductMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>
      getDeleteProductMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "DeleteProduct"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateReferenceImageMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      METHOD_CREATE_REFERENCE_IMAGE = getCreateReferenceImageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getCreateReferenceImageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getCreateReferenceImageMethod() {
    return getCreateReferenceImageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.CreateReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getCreateReferenceImageMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "CreateReferenceImage"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteReferenceImageMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
      METHOD_DELETE_REFERENCE_IMAGE = getDeleteReferenceImageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
      getDeleteReferenceImageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
      getDeleteReferenceImageMethod() {
    return getDeleteReferenceImageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.DeleteReferenceImageRequest, com.google.protobuf.Empty>
      getDeleteReferenceImageMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "DeleteReferenceImage"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListReferenceImagesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListReferenceImagesRequest,
          com.google.cloud.vision.v1.ListReferenceImagesResponse>
      METHOD_LIST_REFERENCE_IMAGES = getListReferenceImagesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListReferenceImagesRequest,
          com.google.cloud.vision.v1.ListReferenceImagesResponse>
      getListReferenceImagesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListReferenceImagesRequest,
          com.google.cloud.vision.v1.ListReferenceImagesResponse>
      getListReferenceImagesMethod() {
    return getListReferenceImagesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListReferenceImagesRequest,
          com.google.cloud.vision.v1.ListReferenceImagesResponse>
      getListReferenceImagesMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "ListReferenceImages"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetReferenceImageMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      METHOD_GET_REFERENCE_IMAGE = getGetReferenceImageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getGetReferenceImageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getGetReferenceImageMethod() {
    return getGetReferenceImageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.GetReferenceImageRequest,
          com.google.cloud.vision.v1.ReferenceImage>
      getGetReferenceImageMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "GetReferenceImage"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddProductToProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
      METHOD_ADD_PRODUCT_TO_PRODUCT_SET = getAddProductToProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
      getAddProductToProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
      getAddProductToProductSetMethod() {
    return getAddProductToProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.AddProductToProductSetRequest, com.google.protobuf.Empty>
      getAddProductToProductSetMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "AddProductToProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveProductFromProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.RemoveProductFromProductSetRequest, com.google.protobuf.Empty>
      METHOD_REMOVE_PRODUCT_FROM_PRODUCT_SET = getRemoveProductFromProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.RemoveProductFromProductSetRequest, com.google.protobuf.Empty>
      getRemoveProductFromProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.RemoveProductFromProductSetRequest, com.google.protobuf.Empty>
      getRemoveProductFromProductSetMethod() {
    return getRemoveProductFromProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.RemoveProductFromProductSetRequest, com.google.protobuf.Empty>
      getRemoveProductFromProductSetMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch",
                              "RemoveProductFromProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListProductsInProductSetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsInProductSetRequest,
          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
      METHOD_LIST_PRODUCTS_IN_PRODUCT_SET = getListProductsInProductSetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsInProductSetRequest,
          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
      getListProductsInProductSetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsInProductSetRequest,
          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
      getListProductsInProductSetMethod() {
    return getListProductsInProductSetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ListProductsInProductSetRequest,
          com.google.cloud.vision.v1.ListProductsInProductSetResponse>
      getListProductsInProductSetMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "ListProductsInProductSet"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getImportProductSetsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
      METHOD_IMPORT_PRODUCT_SETS = getImportProductSetsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
      getImportProductSetsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
      getImportProductSetsMethod() {
    return getImportProductSetsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.ImportProductSetsRequest, com.google.longrunning.Operation>
      getImportProductSetsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "ImportProductSets"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPurgeProductsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
      METHOD_PURGE_PRODUCTS = getPurgeProductsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethod() {
    return getPurgeProductsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1.PurgeProductsRequest, com.google.longrunning.Operation>
      getPurgeProductsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.vision.v1.ProductSearch", "PurgeProducts"))
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
    return new ProductSearchStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductSearchBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ProductSearchBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProductSearchFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ProductSearchFutureStub(channel);
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
      asyncUnimplementedUnaryCall(getCreateProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListProductSetsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCreateProductMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListProductsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetProductMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateProductMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteProductMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCreateReferenceImageMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteReferenceImageMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListReferenceImagesMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetReferenceImageMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getAddProductToProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRemoveProductFromProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListProductsInProductSetMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getImportProductSetsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getPurgeProductsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.CreateProductSetRequest,
                      com.google.cloud.vision.v1.ProductSet>(this, METHODID_CREATE_PRODUCT_SET)))
          .addMethod(
              getListProductSetsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListProductSetsRequest,
                      com.google.cloud.vision.v1.ListProductSetsResponse>(
                      this, METHODID_LIST_PRODUCT_SETS)))
          .addMethod(
              getGetProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.GetProductSetRequest,
                      com.google.cloud.vision.v1.ProductSet>(this, METHODID_GET_PRODUCT_SET)))
          .addMethod(
              getUpdateProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.UpdateProductSetRequest,
                      com.google.cloud.vision.v1.ProductSet>(this, METHODID_UPDATE_PRODUCT_SET)))
          .addMethod(
              getDeleteProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.DeleteProductSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PRODUCT_SET)))
          .addMethod(
              getCreateProductMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.CreateProductRequest,
                      com.google.cloud.vision.v1.Product>(this, METHODID_CREATE_PRODUCT)))
          .addMethod(
              getListProductsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListProductsRequest,
                      com.google.cloud.vision.v1.ListProductsResponse>(
                      this, METHODID_LIST_PRODUCTS)))
          .addMethod(
              getGetProductMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.GetProductRequest,
                      com.google.cloud.vision.v1.Product>(this, METHODID_GET_PRODUCT)))
          .addMethod(
              getUpdateProductMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.UpdateProductRequest,
                      com.google.cloud.vision.v1.Product>(this, METHODID_UPDATE_PRODUCT)))
          .addMethod(
              getDeleteProductMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.DeleteProductRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_PRODUCT)))
          .addMethod(
              getCreateReferenceImageMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.CreateReferenceImageRequest,
                      com.google.cloud.vision.v1.ReferenceImage>(
                      this, METHODID_CREATE_REFERENCE_IMAGE)))
          .addMethod(
              getDeleteReferenceImageMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.DeleteReferenceImageRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_REFERENCE_IMAGE)))
          .addMethod(
              getListReferenceImagesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListReferenceImagesRequest,
                      com.google.cloud.vision.v1.ListReferenceImagesResponse>(
                      this, METHODID_LIST_REFERENCE_IMAGES)))
          .addMethod(
              getGetReferenceImageMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.GetReferenceImageRequest,
                      com.google.cloud.vision.v1.ReferenceImage>(
                      this, METHODID_GET_REFERENCE_IMAGE)))
          .addMethod(
              getAddProductToProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.AddProductToProductSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_ADD_PRODUCT_TO_PRODUCT_SET)))
          .addMethod(
              getRemoveProductFromProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.RemoveProductFromProductSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_REMOVE_PRODUCT_FROM_PRODUCT_SET)))
          .addMethod(
              getListProductsInProductSetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ListProductsInProductSetRequest,
                      com.google.cloud.vision.v1.ListProductsInProductSetResponse>(
                      this, METHODID_LIST_PRODUCTS_IN_PRODUCT_SET)))
          .addMethod(
              getImportProductSetsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1.ImportProductSetsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_PRODUCT_SETS)))
          .addMethod(
              getPurgeProductsMethodHelper(),
              asyncUnaryCall(
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
  public static final class ProductSearchStub extends io.grpc.stub.AbstractStub<ProductSearchStub> {
    private ProductSearchStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getCreateProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListProductSetsMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getCreateProductMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListProductsMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetProductMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateProductMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteProductMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getCreateReferenceImageMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteReferenceImageMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListReferenceImagesMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetReferenceImageMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getAddProductToProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getRemoveProductFromProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListProductsInProductSetMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getImportProductSetsMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getPurgeProductsMethodHelper(), getCallOptions()),
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
      extends io.grpc.stub.AbstractStub<ProductSearchBlockingStub> {
    private ProductSearchBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(
          getChannel(), getCreateProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListProductSetsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getUpdateProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getCreateProductMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListProductsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetProductMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getUpdateProductMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteProductMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getCreateReferenceImageMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteReferenceImageMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListReferenceImagesMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetReferenceImageMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getAddProductToProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getRemoveProductFromProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListProductsInProductSetMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getImportProductSetsMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getPurgeProductsMethodHelper(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractStub<ProductSearchFutureStub> {
    private ProductSearchFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getCreateProductSetMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListProductSetsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetProductSetMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateProductSetMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteProductSetMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getCreateProductMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListProductsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetProductMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateProductMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteProductMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getCreateReferenceImageMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteReferenceImageMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListReferenceImagesMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetReferenceImageMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getAddProductToProductSetMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getRemoveProductFromProductSetMethodHelper(), getCallOptions()),
          request);
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
      return futureUnaryCall(
          getChannel().newCall(getListProductsInProductSetMethodHelper(), getCallOptions()),
          request);
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
      return futureUnaryCall(
          getChannel().newCall(getImportProductSetsMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getPurgeProductsMethodHelper(), getCallOptions()), request);
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
                      .addMethod(getCreateProductSetMethodHelper())
                      .addMethod(getListProductSetsMethodHelper())
                      .addMethod(getGetProductSetMethodHelper())
                      .addMethod(getUpdateProductSetMethodHelper())
                      .addMethod(getDeleteProductSetMethodHelper())
                      .addMethod(getCreateProductMethodHelper())
                      .addMethod(getListProductsMethodHelper())
                      .addMethod(getGetProductMethodHelper())
                      .addMethod(getUpdateProductMethodHelper())
                      .addMethod(getDeleteProductMethodHelper())
                      .addMethod(getCreateReferenceImageMethodHelper())
                      .addMethod(getDeleteReferenceImageMethodHelper())
                      .addMethod(getListReferenceImagesMethodHelper())
                      .addMethod(getGetReferenceImageMethodHelper())
                      .addMethod(getAddProductToProductSetMethodHelper())
                      .addMethod(getRemoveProductFromProductSetMethodHelper())
                      .addMethod(getListProductsInProductSetMethodHelper())
                      .addMethod(getImportProductSetsMethodHelper())
                      .addMethod(getPurgeProductsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
