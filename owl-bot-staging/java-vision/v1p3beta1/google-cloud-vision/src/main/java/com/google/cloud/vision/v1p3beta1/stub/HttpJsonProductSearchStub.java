/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vision.v1p3beta1.stub;

import static com.google.cloud.vision.v1p3beta1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1p3beta1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1p3beta1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1p3beta1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p3beta1.AddProductToProductSetRequest;
import com.google.cloud.vision.v1p3beta1.BatchOperationMetadata;
import com.google.cloud.vision.v1p3beta1.CreateProductRequest;
import com.google.cloud.vision.v1p3beta1.CreateProductSetRequest;
import com.google.cloud.vision.v1p3beta1.CreateReferenceImageRequest;
import com.google.cloud.vision.v1p3beta1.DeleteProductRequest;
import com.google.cloud.vision.v1p3beta1.DeleteProductSetRequest;
import com.google.cloud.vision.v1p3beta1.DeleteReferenceImageRequest;
import com.google.cloud.vision.v1p3beta1.GetProductRequest;
import com.google.cloud.vision.v1p3beta1.GetProductSetRequest;
import com.google.cloud.vision.v1p3beta1.GetReferenceImageRequest;
import com.google.cloud.vision.v1p3beta1.ImportProductSetsRequest;
import com.google.cloud.vision.v1p3beta1.ImportProductSetsResponse;
import com.google.cloud.vision.v1p3beta1.ListProductSetsRequest;
import com.google.cloud.vision.v1p3beta1.ListProductSetsResponse;
import com.google.cloud.vision.v1p3beta1.ListProductsInProductSetRequest;
import com.google.cloud.vision.v1p3beta1.ListProductsInProductSetResponse;
import com.google.cloud.vision.v1p3beta1.ListProductsRequest;
import com.google.cloud.vision.v1p3beta1.ListProductsResponse;
import com.google.cloud.vision.v1p3beta1.ListReferenceImagesRequest;
import com.google.cloud.vision.v1p3beta1.ListReferenceImagesResponse;
import com.google.cloud.vision.v1p3beta1.Product;
import com.google.cloud.vision.v1p3beta1.ProductSet;
import com.google.cloud.vision.v1p3beta1.ReferenceImage;
import com.google.cloud.vision.v1p3beta1.RemoveProductFromProductSetRequest;
import com.google.cloud.vision.v1p3beta1.UpdateProductRequest;
import com.google.cloud.vision.v1p3beta1.UpdateProductSetRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ProductSearch service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProductSearchStub extends ProductSearchStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportProductSetsResponse.getDescriptor())
          .add(BatchOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateProductSetRequest, ProductSet>
      createProductSetMethodDescriptor =
          ApiMethodDescriptor.<CreateProductSetRequest, ProductSet>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/CreateProductSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*}/productSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "productSetId", request.getProductSetId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("productSet", request.getProductSet(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductSet>newBuilder()
                      .setDefaultInstance(ProductSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProductSetsRequest, ListProductSetsResponse>
      listProductSetsMethodDescriptor =
          ApiMethodDescriptor.<ListProductSetsRequest, ListProductSetsResponse>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/ListProductSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductSetsRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*}/productSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProductSetsResponse>newBuilder()
                      .setDefaultInstance(ListProductSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProductSetRequest, ProductSet>
      getProductSetMethodDescriptor =
          ApiMethodDescriptor.<GetProductSetRequest, ProductSet>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/GetProductSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/productSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductSet>newBuilder()
                      .setDefaultInstance(ProductSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateProductSetRequest, ProductSet>
      updateProductSetMethodDescriptor =
          ApiMethodDescriptor.<UpdateProductSetRequest, ProductSet>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/UpdateProductSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{productSet.name=projects/*/locations/*/productSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "productSet.name", request.getProductSet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("productSet", request.getProductSet(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductSet>newBuilder()
                      .setDefaultInstance(ProductSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteProductSetRequest, Empty>
      deleteProductSetMethodDescriptor =
          ApiMethodDescriptor.<DeleteProductSetRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/DeleteProductSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/productSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateProductRequest, Product>
      createProductMethodDescriptor =
          ApiMethodDescriptor.<CreateProductRequest, Product>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/CreateProduct")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProductRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*}/products",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "productId", request.getProductId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("product", request.getProduct(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Product>newBuilder()
                      .setDefaultInstance(Product.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          ApiMethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/ListProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductsRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*}/products",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProductsResponse>newBuilder()
                      .setDefaultInstance(ListProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      ApiMethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/GetProduct")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProductRequest>newBuilder()
                  .setPath(
                      "/v1p3beta1/{name=projects/*/locations/*/products/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProductRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProductRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Product>newBuilder()
                  .setDefaultInstance(Product.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateProductRequest, Product>
      updateProductMethodDescriptor =
          ApiMethodDescriptor.<UpdateProductRequest, Product>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/UpdateProduct")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProductRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{product.name=projects/*/locations/*/products/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "product.name", request.getProduct().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("product", request.getProduct(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Product>newBuilder()
                      .setDefaultInstance(Product.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteProductRequest, Empty>
      deleteProductMethodDescriptor =
          ApiMethodDescriptor.<DeleteProductRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/DeleteProduct")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProductRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/products/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageMethodDescriptor =
          ApiMethodDescriptor.<CreateReferenceImageRequest, ReferenceImage>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/CreateReferenceImage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReferenceImageRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*/products/*}/referenceImages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReferenceImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReferenceImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "referenceImageId", request.getReferenceImageId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("referenceImage", request.getReferenceImage(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReferenceImage>newBuilder()
                      .setDefaultInstance(ReferenceImage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReferenceImageRequest, Empty>
      deleteReferenceImageMethodDescriptor =
          ApiMethodDescriptor.<DeleteReferenceImageRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/DeleteReferenceImage")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReferenceImageRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/products/*/referenceImages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReferenceImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReferenceImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesMethodDescriptor =
          ApiMethodDescriptor.<ListReferenceImagesRequest, ListReferenceImagesResponse>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/ListReferenceImages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReferenceImagesRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*/products/*}/referenceImages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReferenceImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReferenceImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReferenceImagesResponse>newBuilder()
                      .setDefaultInstance(ListReferenceImagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReferenceImageRequest, ReferenceImage>
      getReferenceImageMethodDescriptor =
          ApiMethodDescriptor.<GetReferenceImageRequest, ReferenceImage>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/GetReferenceImage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReferenceImageRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/products/*/referenceImages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReferenceImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReferenceImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReferenceImage>newBuilder()
                      .setDefaultInstance(ReferenceImage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddProductToProductSetRequest, Empty>
      addProductToProductSetMethodDescriptor =
          ApiMethodDescriptor.<AddProductToProductSetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.vision.v1p3beta1.ProductSearch/AddProductToProductSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddProductToProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/productSets/*}:addProduct",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddProductToProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddProductToProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetMethodDescriptor =
          ApiMethodDescriptor.<RemoveProductFromProductSetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.vision.v1p3beta1.ProductSearch/RemoveProductFromProductSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveProductFromProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/productSets/*}:removeProduct",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveProductFromProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveProductFromProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetMethodDescriptor =
          ApiMethodDescriptor
              .<ListProductsInProductSetRequest, ListProductsInProductSetResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vision.v1p3beta1.ProductSearch/ListProductsInProductSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductsInProductSetRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{name=projects/*/locations/*/productSets/*}/products",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsInProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsInProductSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProductsInProductSetResponse>newBuilder()
                      .setDefaultInstance(ListProductsInProductSetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportProductSetsRequest, Operation>
      importProductSetsMethodDescriptor =
          ApiMethodDescriptor.<ImportProductSetsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p3beta1.ProductSearch/ImportProductSets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportProductSetsRequest>newBuilder()
                      .setPath(
                          "/v1p3beta1/{parent=projects/*/locations/*}/productSets:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportProductSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportProductSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportProductSetsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateProductSetRequest, ProductSet> createProductSetCallable;
  private final UnaryCallable<ListProductSetsRequest, ListProductSetsResponse>
      listProductSetsCallable;
  private final UnaryCallable<ListProductSetsRequest, ListProductSetsPagedResponse>
      listProductSetsPagedCallable;
  private final UnaryCallable<GetProductSetRequest, ProductSet> getProductSetCallable;
  private final UnaryCallable<UpdateProductSetRequest, ProductSet> updateProductSetCallable;
  private final UnaryCallable<DeleteProductSetRequest, Empty> deleteProductSetCallable;
  private final UnaryCallable<CreateProductRequest, Product> createProductCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;
  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<UpdateProductRequest, Product> updateProductCallable;
  private final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable;
  private final UnaryCallable<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageCallable;
  private final UnaryCallable<DeleteReferenceImageRequest, Empty> deleteReferenceImageCallable;
  private final UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesCallable;
  private final UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesPagedResponse>
      listReferenceImagesPagedCallable;
  private final UnaryCallable<GetReferenceImageRequest, ReferenceImage> getReferenceImageCallable;
  private final UnaryCallable<AddProductToProductSetRequest, Empty> addProductToProductSetCallable;
  private final UnaryCallable<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetCallable;
  private final UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetCallable;
  private final UnaryCallable<
          ListProductsInProductSetRequest, ListProductsInProductSetPagedResponse>
      listProductsInProductSetPagedCallable;
  private final UnaryCallable<ImportProductSetsRequest, Operation> importProductSetsCallable;
  private final OperationCallable<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProductSearchStub create(ProductSearchStubSettings settings)
      throws IOException {
    return new HttpJsonProductSearchStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProductSearchStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProductSearchStub(
        ProductSearchStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProductSearchStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProductSearchStub(
        ProductSearchStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProductSearchStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductSearchStub(
      ProductSearchStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProductSearchCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProductSearchStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductSearchStub(
      ProductSearchStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateProductSetRequest, ProductSet> createProductSetTransportSettings =
        HttpJsonCallSettings.<CreateProductSetRequest, ProductSet>newBuilder()
            .setMethodDescriptor(createProductSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListProductSetsRequest, ListProductSetsResponse>
        listProductSetsTransportSettings =
            HttpJsonCallSettings.<ListProductSetsRequest, ListProductSetsResponse>newBuilder()
                .setMethodDescriptor(listProductSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetProductSetRequest, ProductSet> getProductSetTransportSettings =
        HttpJsonCallSettings.<GetProductSetRequest, ProductSet>newBuilder()
            .setMethodDescriptor(getProductSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateProductSetRequest, ProductSet> updateProductSetTransportSettings =
        HttpJsonCallSettings.<UpdateProductSetRequest, ProductSet>newBuilder()
            .setMethodDescriptor(updateProductSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteProductSetRequest, Empty> deleteProductSetTransportSettings =
        HttpJsonCallSettings.<DeleteProductSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateProductRequest, Product> createProductTransportSettings =
        HttpJsonCallSettings.<CreateProductRequest, Product>newBuilder()
            .setMethodDescriptor(createProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        HttpJsonCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetProductRequest, Product> getProductTransportSettings =
        HttpJsonCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateProductRequest, Product> updateProductTransportSettings =
        HttpJsonCallSettings.<UpdateProductRequest, Product>newBuilder()
            .setMethodDescriptor(updateProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteProductRequest, Empty> deleteProductTransportSettings =
        HttpJsonCallSettings.<DeleteProductRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateReferenceImageRequest, ReferenceImage>
        createReferenceImageTransportSettings =
            HttpJsonCallSettings.<CreateReferenceImageRequest, ReferenceImage>newBuilder()
                .setMethodDescriptor(createReferenceImageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteReferenceImageRequest, Empty> deleteReferenceImageTransportSettings =
        HttpJsonCallSettings.<DeleteReferenceImageRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReferenceImageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListReferenceImagesRequest, ListReferenceImagesResponse>
        listReferenceImagesTransportSettings =
            HttpJsonCallSettings
                .<ListReferenceImagesRequest, ListReferenceImagesResponse>newBuilder()
                .setMethodDescriptor(listReferenceImagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetReferenceImageRequest, ReferenceImage>
        getReferenceImageTransportSettings =
            HttpJsonCallSettings.<GetReferenceImageRequest, ReferenceImage>newBuilder()
                .setMethodDescriptor(getReferenceImageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddProductToProductSetRequest, Empty>
        addProductToProductSetTransportSettings =
            HttpJsonCallSettings.<AddProductToProductSetRequest, Empty>newBuilder()
                .setMethodDescriptor(addProductToProductSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveProductFromProductSetRequest, Empty>
        removeProductFromProductSetTransportSettings =
            HttpJsonCallSettings.<RemoveProductFromProductSetRequest, Empty>newBuilder()
                .setMethodDescriptor(removeProductFromProductSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
        listProductsInProductSetTransportSettings =
            HttpJsonCallSettings
                .<ListProductsInProductSetRequest, ListProductsInProductSetResponse>newBuilder()
                .setMethodDescriptor(listProductsInProductSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportProductSetsRequest, Operation> importProductSetsTransportSettings =
        HttpJsonCallSettings.<ImportProductSetsRequest, Operation>newBuilder()
            .setMethodDescriptor(importProductSetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createProductSetCallable =
        callableFactory.createUnaryCallable(
            createProductSetTransportSettings, settings.createProductSetSettings(), clientContext);
    this.listProductSetsCallable =
        callableFactory.createUnaryCallable(
            listProductSetsTransportSettings, settings.listProductSetsSettings(), clientContext);
    this.listProductSetsPagedCallable =
        callableFactory.createPagedCallable(
            listProductSetsTransportSettings, settings.listProductSetsSettings(), clientContext);
    this.getProductSetCallable =
        callableFactory.createUnaryCallable(
            getProductSetTransportSettings, settings.getProductSetSettings(), clientContext);
    this.updateProductSetCallable =
        callableFactory.createUnaryCallable(
            updateProductSetTransportSettings, settings.updateProductSetSettings(), clientContext);
    this.deleteProductSetCallable =
        callableFactory.createUnaryCallable(
            deleteProductSetTransportSettings, settings.deleteProductSetSettings(), clientContext);
    this.createProductCallable =
        callableFactory.createUnaryCallable(
            createProductTransportSettings, settings.createProductSettings(), clientContext);
    this.listProductsCallable =
        callableFactory.createUnaryCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listProductsPagedCallable =
        callableFactory.createPagedCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.getProductCallable =
        callableFactory.createUnaryCallable(
            getProductTransportSettings, settings.getProductSettings(), clientContext);
    this.updateProductCallable =
        callableFactory.createUnaryCallable(
            updateProductTransportSettings, settings.updateProductSettings(), clientContext);
    this.deleteProductCallable =
        callableFactory.createUnaryCallable(
            deleteProductTransportSettings, settings.deleteProductSettings(), clientContext);
    this.createReferenceImageCallable =
        callableFactory.createUnaryCallable(
            createReferenceImageTransportSettings,
            settings.createReferenceImageSettings(),
            clientContext);
    this.deleteReferenceImageCallable =
        callableFactory.createUnaryCallable(
            deleteReferenceImageTransportSettings,
            settings.deleteReferenceImageSettings(),
            clientContext);
    this.listReferenceImagesCallable =
        callableFactory.createUnaryCallable(
            listReferenceImagesTransportSettings,
            settings.listReferenceImagesSettings(),
            clientContext);
    this.listReferenceImagesPagedCallable =
        callableFactory.createPagedCallable(
            listReferenceImagesTransportSettings,
            settings.listReferenceImagesSettings(),
            clientContext);
    this.getReferenceImageCallable =
        callableFactory.createUnaryCallable(
            getReferenceImageTransportSettings,
            settings.getReferenceImageSettings(),
            clientContext);
    this.addProductToProductSetCallable =
        callableFactory.createUnaryCallable(
            addProductToProductSetTransportSettings,
            settings.addProductToProductSetSettings(),
            clientContext);
    this.removeProductFromProductSetCallable =
        callableFactory.createUnaryCallable(
            removeProductFromProductSetTransportSettings,
            settings.removeProductFromProductSetSettings(),
            clientContext);
    this.listProductsInProductSetCallable =
        callableFactory.createUnaryCallable(
            listProductsInProductSetTransportSettings,
            settings.listProductsInProductSetSettings(),
            clientContext);
    this.listProductsInProductSetPagedCallable =
        callableFactory.createPagedCallable(
            listProductsInProductSetTransportSettings,
            settings.listProductsInProductSetSettings(),
            clientContext);
    this.importProductSetsCallable =
        callableFactory.createUnaryCallable(
            importProductSetsTransportSettings,
            settings.importProductSetsSettings(),
            clientContext);
    this.importProductSetsOperationCallable =
        callableFactory.createOperationCallable(
            importProductSetsTransportSettings,
            settings.importProductSetsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createProductSetMethodDescriptor);
    methodDescriptors.add(listProductSetsMethodDescriptor);
    methodDescriptors.add(getProductSetMethodDescriptor);
    methodDescriptors.add(updateProductSetMethodDescriptor);
    methodDescriptors.add(deleteProductSetMethodDescriptor);
    methodDescriptors.add(createProductMethodDescriptor);
    methodDescriptors.add(listProductsMethodDescriptor);
    methodDescriptors.add(getProductMethodDescriptor);
    methodDescriptors.add(updateProductMethodDescriptor);
    methodDescriptors.add(deleteProductMethodDescriptor);
    methodDescriptors.add(createReferenceImageMethodDescriptor);
    methodDescriptors.add(deleteReferenceImageMethodDescriptor);
    methodDescriptors.add(listReferenceImagesMethodDescriptor);
    methodDescriptors.add(getReferenceImageMethodDescriptor);
    methodDescriptors.add(addProductToProductSetMethodDescriptor);
    methodDescriptors.add(removeProductFromProductSetMethodDescriptor);
    methodDescriptors.add(listProductsInProductSetMethodDescriptor);
    methodDescriptors.add(importProductSetsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateProductSetRequest, ProductSet> createProductSetCallable() {
    return createProductSetCallable;
  }

  @Override
  public UnaryCallable<ListProductSetsRequest, ListProductSetsResponse> listProductSetsCallable() {
    return listProductSetsCallable;
  }

  @Override
  public UnaryCallable<ListProductSetsRequest, ListProductSetsPagedResponse>
      listProductSetsPagedCallable() {
    return listProductSetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetProductSetRequest, ProductSet> getProductSetCallable() {
    return getProductSetCallable;
  }

  @Override
  public UnaryCallable<UpdateProductSetRequest, ProductSet> updateProductSetCallable() {
    return updateProductSetCallable;
  }

  @Override
  public UnaryCallable<DeleteProductSetRequest, Empty> deleteProductSetCallable() {
    return deleteProductSetCallable;
  }

  @Override
  public UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return createProductCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return listProductsCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    return listProductsPagedCallable;
  }

  @Override
  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return getProductCallable;
  }

  @Override
  public UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return updateProductCallable;
  }

  @Override
  public UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return deleteProductCallable;
  }

  @Override
  public UnaryCallable<CreateReferenceImageRequest, ReferenceImage> createReferenceImageCallable() {
    return createReferenceImageCallable;
  }

  @Override
  public UnaryCallable<DeleteReferenceImageRequest, Empty> deleteReferenceImageCallable() {
    return deleteReferenceImageCallable;
  }

  @Override
  public UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesCallable() {
    return listReferenceImagesCallable;
  }

  @Override
  public UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesPagedResponse>
      listReferenceImagesPagedCallable() {
    return listReferenceImagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetReferenceImageRequest, ReferenceImage> getReferenceImageCallable() {
    return getReferenceImageCallable;
  }

  @Override
  public UnaryCallable<AddProductToProductSetRequest, Empty> addProductToProductSetCallable() {
    return addProductToProductSetCallable;
  }

  @Override
  public UnaryCallable<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetCallable() {
    return removeProductFromProductSetCallable;
  }

  @Override
  public UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetCallable() {
    return listProductsInProductSetCallable;
  }

  @Override
  public UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetPagedResponse>
      listProductsInProductSetPagedCallable() {
    return listProductsInProductSetPagedCallable;
  }

  @Override
  public UnaryCallable<ImportProductSetsRequest, Operation> importProductSetsCallable() {
    return importProductSetsCallable;
  }

  @Override
  public OperationCallable<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationCallable() {
    return importProductSetsOperationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
