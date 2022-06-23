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

package com.google.cloud.vision.v1p4beta1.stub;

import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p4beta1.AddProductToProductSetRequest;
import com.google.cloud.vision.v1p4beta1.BatchOperationMetadata;
import com.google.cloud.vision.v1p4beta1.CreateProductRequest;
import com.google.cloud.vision.v1p4beta1.CreateProductSetRequest;
import com.google.cloud.vision.v1p4beta1.CreateReferenceImageRequest;
import com.google.cloud.vision.v1p4beta1.DeleteProductRequest;
import com.google.cloud.vision.v1p4beta1.DeleteProductSetRequest;
import com.google.cloud.vision.v1p4beta1.DeleteReferenceImageRequest;
import com.google.cloud.vision.v1p4beta1.GetProductRequest;
import com.google.cloud.vision.v1p4beta1.GetProductSetRequest;
import com.google.cloud.vision.v1p4beta1.GetReferenceImageRequest;
import com.google.cloud.vision.v1p4beta1.ImportProductSetsRequest;
import com.google.cloud.vision.v1p4beta1.ImportProductSetsResponse;
import com.google.cloud.vision.v1p4beta1.ListProductSetsRequest;
import com.google.cloud.vision.v1p4beta1.ListProductSetsResponse;
import com.google.cloud.vision.v1p4beta1.ListProductsInProductSetRequest;
import com.google.cloud.vision.v1p4beta1.ListProductsInProductSetResponse;
import com.google.cloud.vision.v1p4beta1.ListProductsRequest;
import com.google.cloud.vision.v1p4beta1.ListProductsResponse;
import com.google.cloud.vision.v1p4beta1.ListReferenceImagesRequest;
import com.google.cloud.vision.v1p4beta1.ListReferenceImagesResponse;
import com.google.cloud.vision.v1p4beta1.Product;
import com.google.cloud.vision.v1p4beta1.ProductSet;
import com.google.cloud.vision.v1p4beta1.PurgeProductsRequest;
import com.google.cloud.vision.v1p4beta1.ReferenceImage;
import com.google.cloud.vision.v1p4beta1.RemoveProductFromProductSetRequest;
import com.google.cloud.vision.v1p4beta1.UpdateProductRequest;
import com.google.cloud.vision.v1p4beta1.UpdateProductSetRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProductSearch service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProductSearchStub extends ProductSearchStub {
  private static final MethodDescriptor<CreateProductSetRequest, ProductSet>
      createProductSetMethodDescriptor =
          MethodDescriptor.<CreateProductSetRequest, ProductSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/CreateProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProductSetsRequest, ListProductSetsResponse>
      listProductSetsMethodDescriptor =
          MethodDescriptor.<ListProductSetsRequest, ListProductSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/ListProductSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProductSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductSetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProductSetRequest, ProductSet>
      getProductSetMethodDescriptor =
          MethodDescriptor.<GetProductSetRequest, ProductSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/GetProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProductSetRequest, ProductSet>
      updateProductSetMethodDescriptor =
          MethodDescriptor.<UpdateProductSetRequest, ProductSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/UpdateProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProductSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProductSetRequest, Empty>
      deleteProductSetMethodDescriptor =
          MethodDescriptor.<DeleteProductSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/DeleteProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateProductRequest, Product>
      createProductMethodDescriptor =
          MethodDescriptor.<CreateProductRequest, Product>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/CreateProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          MethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/ListProducts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      MethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/GetProduct")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProductRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateProductRequest, Product>
      updateProductMethodDescriptor =
          MethodDescriptor.<UpdateProductRequest, Product>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/UpdateProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProductRequest, Empty> deleteProductMethodDescriptor =
      MethodDescriptor.<DeleteProductRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/DeleteProduct")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteProductRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageMethodDescriptor =
          MethodDescriptor.<CreateReferenceImageRequest, ReferenceImage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/CreateReferenceImage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReferenceImageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReferenceImage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReferenceImageRequest, Empty>
      deleteReferenceImageMethodDescriptor =
          MethodDescriptor.<DeleteReferenceImageRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/DeleteReferenceImage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReferenceImageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesMethodDescriptor =
          MethodDescriptor.<ListReferenceImagesRequest, ListReferenceImagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/ListReferenceImages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReferenceImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReferenceImagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReferenceImageRequest, ReferenceImage>
      getReferenceImageMethodDescriptor =
          MethodDescriptor.<GetReferenceImageRequest, ReferenceImage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/GetReferenceImage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReferenceImageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReferenceImage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddProductToProductSetRequest, Empty>
      addProductToProductSetMethodDescriptor =
          MethodDescriptor.<AddProductToProductSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ProductSearch/AddProductToProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddProductToProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetMethodDescriptor =
          MethodDescriptor.<RemoveProductFromProductSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ProductSearch/RemoveProductFromProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveProductFromProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetMethodDescriptor =
          MethodDescriptor
              .<ListProductsInProductSetRequest, ListProductsInProductSetResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ProductSearch/ListProductsInProductSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProductsInProductSetRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductsInProductSetResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportProductSetsRequest, Operation>
      importProductSetsMethodDescriptor =
          MethodDescriptor.<ImportProductSetsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/ImportProductSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportProductSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PurgeProductsRequest, Operation>
      purgeProductsMethodDescriptor =
          MethodDescriptor.<PurgeProductsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ProductSearch/PurgeProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PurgeProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
  private final UnaryCallable<PurgeProductsRequest, Operation> purgeProductsCallable;
  private final OperationCallable<PurgeProductsRequest, Empty, BatchOperationMetadata>
      purgeProductsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProductSearchStub create(ProductSearchStubSettings settings)
      throws IOException {
    return new GrpcProductSearchStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProductSearchStub create(ClientContext clientContext) throws IOException {
    return new GrpcProductSearchStub(ProductSearchStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProductSearchStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProductSearchStub(
        ProductSearchStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProductSearchStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProductSearchStub(ProductSearchStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcProductSearchCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProductSearchStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProductSearchStub(
      ProductSearchStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateProductSetRequest, ProductSet> createProductSetTransportSettings =
        GrpcCallSettings.<CreateProductSetRequest, ProductSet>newBuilder()
            .setMethodDescriptor(createProductSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListProductSetsRequest, ListProductSetsResponse>
        listProductSetsTransportSettings =
            GrpcCallSettings.<ListProductSetsRequest, ListProductSetsResponse>newBuilder()
                .setMethodDescriptor(listProductSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetProductSetRequest, ProductSet> getProductSetTransportSettings =
        GrpcCallSettings.<GetProductSetRequest, ProductSet>newBuilder()
            .setMethodDescriptor(getProductSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateProductSetRequest, ProductSet> updateProductSetTransportSettings =
        GrpcCallSettings.<UpdateProductSetRequest, ProductSet>newBuilder()
            .setMethodDescriptor(updateProductSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("product_set.name", String.valueOf(request.getProductSet().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteProductSetRequest, Empty> deleteProductSetTransportSettings =
        GrpcCallSettings.<DeleteProductSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateProductRequest, Product> createProductTransportSettings =
        GrpcCallSettings.<CreateProductRequest, Product>newBuilder()
            .setMethodDescriptor(createProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        GrpcCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetProductRequest, Product> getProductTransportSettings =
        GrpcCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateProductRequest, Product> updateProductTransportSettings =
        GrpcCallSettings.<UpdateProductRequest, Product>newBuilder()
            .setMethodDescriptor(updateProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("product.name", String.valueOf(request.getProduct().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteProductRequest, Empty> deleteProductTransportSettings =
        GrpcCallSettings.<DeleteProductRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateReferenceImageRequest, ReferenceImage>
        createReferenceImageTransportSettings =
            GrpcCallSettings.<CreateReferenceImageRequest, ReferenceImage>newBuilder()
                .setMethodDescriptor(createReferenceImageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteReferenceImageRequest, Empty> deleteReferenceImageTransportSettings =
        GrpcCallSettings.<DeleteReferenceImageRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReferenceImageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListReferenceImagesRequest, ListReferenceImagesResponse>
        listReferenceImagesTransportSettings =
            GrpcCallSettings.<ListReferenceImagesRequest, ListReferenceImagesResponse>newBuilder()
                .setMethodDescriptor(listReferenceImagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetReferenceImageRequest, ReferenceImage> getReferenceImageTransportSettings =
        GrpcCallSettings.<GetReferenceImageRequest, ReferenceImage>newBuilder()
            .setMethodDescriptor(getReferenceImageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AddProductToProductSetRequest, Empty> addProductToProductSetTransportSettings =
        GrpcCallSettings.<AddProductToProductSetRequest, Empty>newBuilder()
            .setMethodDescriptor(addProductToProductSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemoveProductFromProductSetRequest, Empty>
        removeProductFromProductSetTransportSettings =
            GrpcCallSettings.<RemoveProductFromProductSetRequest, Empty>newBuilder()
                .setMethodDescriptor(removeProductFromProductSetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
        listProductsInProductSetTransportSettings =
            GrpcCallSettings
                .<ListProductsInProductSetRequest, ListProductsInProductSetResponse>newBuilder()
                .setMethodDescriptor(listProductsInProductSetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportProductSetsRequest, Operation> importProductSetsTransportSettings =
        GrpcCallSettings.<ImportProductSetsRequest, Operation>newBuilder()
            .setMethodDescriptor(importProductSetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PurgeProductsRequest, Operation> purgeProductsTransportSettings =
        GrpcCallSettings.<PurgeProductsRequest, Operation>newBuilder()
            .setMethodDescriptor(purgeProductsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
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
            operationsStub);
    this.purgeProductsCallable =
        callableFactory.createUnaryCallable(
            purgeProductsTransportSettings, settings.purgeProductsSettings(), clientContext);
    this.purgeProductsOperationCallable =
        callableFactory.createOperationCallable(
            purgeProductsTransportSettings,
            settings.purgeProductsOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<PurgeProductsRequest, Operation> purgeProductsCallable() {
    return purgeProductsCallable;
  }

  @Override
  public OperationCallable<PurgeProductsRequest, Empty, BatchOperationMetadata>
      purgeProductsOperationCallable() {
    return purgeProductsOperationCallable;
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
