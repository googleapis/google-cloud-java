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

package com.google.cloud.retail.v2alpha.stub;

import static com.google.cloud.retail.v2alpha.ProductServiceClient.ListProductsPagedResponse;

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
import com.google.cloud.retail.v2alpha.AddFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2alpha.AddFulfillmentPlacesRequest;
import com.google.cloud.retail.v2alpha.AddFulfillmentPlacesResponse;
import com.google.cloud.retail.v2alpha.AddLocalInventoriesMetadata;
import com.google.cloud.retail.v2alpha.AddLocalInventoriesRequest;
import com.google.cloud.retail.v2alpha.AddLocalInventoriesResponse;
import com.google.cloud.retail.v2alpha.CreateProductRequest;
import com.google.cloud.retail.v2alpha.DeleteProductRequest;
import com.google.cloud.retail.v2alpha.GetProductRequest;
import com.google.cloud.retail.v2alpha.ImportMetadata;
import com.google.cloud.retail.v2alpha.ImportProductsRequest;
import com.google.cloud.retail.v2alpha.ImportProductsResponse;
import com.google.cloud.retail.v2alpha.ListProductsRequest;
import com.google.cloud.retail.v2alpha.ListProductsResponse;
import com.google.cloud.retail.v2alpha.Product;
import com.google.cloud.retail.v2alpha.PurgeProductsMetadata;
import com.google.cloud.retail.v2alpha.PurgeProductsRequest;
import com.google.cloud.retail.v2alpha.PurgeProductsResponse;
import com.google.cloud.retail.v2alpha.RemoveFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2alpha.RemoveFulfillmentPlacesRequest;
import com.google.cloud.retail.v2alpha.RemoveFulfillmentPlacesResponse;
import com.google.cloud.retail.v2alpha.RemoveLocalInventoriesMetadata;
import com.google.cloud.retail.v2alpha.RemoveLocalInventoriesRequest;
import com.google.cloud.retail.v2alpha.RemoveLocalInventoriesResponse;
import com.google.cloud.retail.v2alpha.SetInventoryMetadata;
import com.google.cloud.retail.v2alpha.SetInventoryRequest;
import com.google.cloud.retail.v2alpha.SetInventoryResponse;
import com.google.cloud.retail.v2alpha.UpdateProductRequest;
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
 * REST stub implementation for the ProductService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProductServiceStub extends ProductServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(RemoveLocalInventoriesResponse.getDescriptor())
          .add(PurgeProductsMetadata.getDescriptor())
          .add(AddFulfillmentPlacesResponse.getDescriptor())
          .add(RemoveFulfillmentPlacesMetadata.getDescriptor())
          .add(SetInventoryResponse.getDescriptor())
          .add(SetInventoryMetadata.getDescriptor())
          .add(AddLocalInventoriesMetadata.getDescriptor())
          .add(PurgeProductsResponse.getDescriptor())
          .add(ImportProductsResponse.getDescriptor())
          .add(AddLocalInventoriesResponse.getDescriptor())
          .add(ImportMetadata.getDescriptor())
          .add(AddFulfillmentPlacesMetadata.getDescriptor())
          .add(RemoveFulfillmentPlacesResponse.getDescriptor())
          .add(RemoveLocalInventoriesMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateProductRequest, Product>
      createProductMethodDescriptor =
          ApiMethodDescriptor.<CreateProductRequest, Product>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/CreateProduct")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProductRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*/branches/*}/products",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("product", request.getProduct(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Product>newBuilder()
                      .setDefaultInstance(Product.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      ApiMethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ProductService/GetProduct")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProductRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{name=projects/*/locations/*/catalogs/*/branches/*/products/**}",
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          ApiMethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/ListProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductsRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*/branches/*}/products",
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
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            serializer.putQueryParam(
                                fields, "requireTotalSize", request.getRequireTotalSize());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<UpdateProductRequest, Product>
      updateProductMethodDescriptor =
          ApiMethodDescriptor.<UpdateProductRequest, Product>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/UpdateProduct")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProductRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{product.name=projects/*/locations/*/catalogs/*/branches/*/products/**}",
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
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("product", request.getProduct(), true))
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
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/DeleteProduct")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProductRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{name=projects/*/locations/*/catalogs/*/branches/*/products/**}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<PurgeProductsRequest, Operation>
      purgeProductsMethodDescriptor =
          ApiMethodDescriptor.<PurgeProductsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/PurgeProducts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PurgeProductsRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*/branches/*}/products:purge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PurgeProductsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportProductsRequest, Operation>
      importProductsMethodDescriptor =
          ApiMethodDescriptor.<ImportProductsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/ImportProducts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportProductsRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*/branches/*}/products:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportProductsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SetInventoryRequest, Operation>
      setInventoryMethodDescriptor =
          ApiMethodDescriptor.<SetInventoryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/SetInventory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetInventoryRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{inventory.name=projects/*/locations/*/catalogs/*/branches/*/products/**}:setInventory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "inventory.name", request.getInventory().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetInventoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AddFulfillmentPlacesRequest, Operation>
      addFulfillmentPlacesMethodDescriptor =
          ApiMethodDescriptor.<AddFulfillmentPlacesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/AddFulfillmentPlaces")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddFulfillmentPlacesRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{product=projects/*/locations/*/catalogs/*/branches/*/products/**}:addFulfillmentPlaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddFulfillmentPlacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "product", request.getProduct());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddFulfillmentPlacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProduct().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddFulfillmentPlacesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesMethodDescriptor =
          ApiMethodDescriptor.<RemoveFulfillmentPlacesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.ProductService/RemoveFulfillmentPlaces")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveFulfillmentPlacesRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{product=projects/*/locations/*/catalogs/*/branches/*/products/**}:removeFulfillmentPlaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveFulfillmentPlacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "product", request.getProduct());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveFulfillmentPlacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProduct().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveFulfillmentPlacesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AddLocalInventoriesRequest, Operation>
      addLocalInventoriesMethodDescriptor =
          ApiMethodDescriptor.<AddLocalInventoriesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProductService/AddLocalInventories")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddLocalInventoriesRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{product=projects/*/locations/*/catalogs/*/branches/*/products/**}:addLocalInventories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddLocalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "product", request.getProduct());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddLocalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProduct().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddLocalInventoriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveLocalInventoriesRequest, Operation>
      removeLocalInventoriesMethodDescriptor =
          ApiMethodDescriptor.<RemoveLocalInventoriesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.ProductService/RemoveLocalInventories")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveLocalInventoriesRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{product=projects/*/locations/*/catalogs/*/branches/*/products/**}:removeLocalInventories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveLocalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "product", request.getProduct());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveLocalInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProduct().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveLocalInventoriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateProductRequest, Product> createProductCallable;
  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;
  private final UnaryCallable<UpdateProductRequest, Product> updateProductCallable;
  private final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable;
  private final UnaryCallable<PurgeProductsRequest, Operation> purgeProductsCallable;
  private final OperationCallable<
          PurgeProductsRequest, PurgeProductsResponse, PurgeProductsMetadata>
      purgeProductsOperationCallable;
  private final UnaryCallable<ImportProductsRequest, Operation> importProductsCallable;
  private final OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable;
  private final UnaryCallable<SetInventoryRequest, Operation> setInventoryCallable;
  private final OperationCallable<SetInventoryRequest, SetInventoryResponse, SetInventoryMetadata>
      setInventoryOperationCallable;
  private final UnaryCallable<AddFulfillmentPlacesRequest, Operation> addFulfillmentPlacesCallable;
  private final OperationCallable<
          AddFulfillmentPlacesRequest, AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesOperationCallable;
  private final UnaryCallable<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesCallable;
  private final OperationCallable<
          RemoveFulfillmentPlacesRequest,
          RemoveFulfillmentPlacesResponse,
          RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesOperationCallable;
  private final UnaryCallable<AddLocalInventoriesRequest, Operation> addLocalInventoriesCallable;
  private final OperationCallable<
          AddLocalInventoriesRequest, AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesOperationCallable;
  private final UnaryCallable<RemoveLocalInventoriesRequest, Operation>
      removeLocalInventoriesCallable;
  private final OperationCallable<
          RemoveLocalInventoriesRequest,
          RemoveLocalInventoriesResponse,
          RemoveLocalInventoriesMetadata>
      removeLocalInventoriesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProductServiceStub create(ProductServiceStubSettings settings)
      throws IOException {
    return new HttpJsonProductServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProductServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProductServiceStub(
        ProductServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProductServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProductServiceStub(
        ProductServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProductServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductServiceStub(
      ProductServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProductServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProductServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductServiceStub(
      ProductServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateProductRequest, Product> createProductTransportSettings =
        HttpJsonCallSettings.<CreateProductRequest, Product>newBuilder()
            .setMethodDescriptor(createProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetProductRequest, Product> getProductTransportSettings =
        HttpJsonCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        HttpJsonCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
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
    HttpJsonCallSettings<PurgeProductsRequest, Operation> purgeProductsTransportSettings =
        HttpJsonCallSettings.<PurgeProductsRequest, Operation>newBuilder()
            .setMethodDescriptor(purgeProductsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportProductsRequest, Operation> importProductsTransportSettings =
        HttpJsonCallSettings.<ImportProductsRequest, Operation>newBuilder()
            .setMethodDescriptor(importProductsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetInventoryRequest, Operation> setInventoryTransportSettings =
        HttpJsonCallSettings.<SetInventoryRequest, Operation>newBuilder()
            .setMethodDescriptor(setInventoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AddFulfillmentPlacesRequest, Operation>
        addFulfillmentPlacesTransportSettings =
            HttpJsonCallSettings.<AddFulfillmentPlacesRequest, Operation>newBuilder()
                .setMethodDescriptor(addFulfillmentPlacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveFulfillmentPlacesRequest, Operation>
        removeFulfillmentPlacesTransportSettings =
            HttpJsonCallSettings.<RemoveFulfillmentPlacesRequest, Operation>newBuilder()
                .setMethodDescriptor(removeFulfillmentPlacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddLocalInventoriesRequest, Operation>
        addLocalInventoriesTransportSettings =
            HttpJsonCallSettings.<AddLocalInventoriesRequest, Operation>newBuilder()
                .setMethodDescriptor(addLocalInventoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveLocalInventoriesRequest, Operation>
        removeLocalInventoriesTransportSettings =
            HttpJsonCallSettings.<RemoveLocalInventoriesRequest, Operation>newBuilder()
                .setMethodDescriptor(removeLocalInventoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createProductCallable =
        callableFactory.createUnaryCallable(
            createProductTransportSettings, settings.createProductSettings(), clientContext);
    this.getProductCallable =
        callableFactory.createUnaryCallable(
            getProductTransportSettings, settings.getProductSettings(), clientContext);
    this.listProductsCallable =
        callableFactory.createUnaryCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listProductsPagedCallable =
        callableFactory.createPagedCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.updateProductCallable =
        callableFactory.createUnaryCallable(
            updateProductTransportSettings, settings.updateProductSettings(), clientContext);
    this.deleteProductCallable =
        callableFactory.createUnaryCallable(
            deleteProductTransportSettings, settings.deleteProductSettings(), clientContext);
    this.purgeProductsCallable =
        callableFactory.createUnaryCallable(
            purgeProductsTransportSettings, settings.purgeProductsSettings(), clientContext);
    this.purgeProductsOperationCallable =
        callableFactory.createOperationCallable(
            purgeProductsTransportSettings,
            settings.purgeProductsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importProductsCallable =
        callableFactory.createUnaryCallable(
            importProductsTransportSettings, settings.importProductsSettings(), clientContext);
    this.importProductsOperationCallable =
        callableFactory.createOperationCallable(
            importProductsTransportSettings,
            settings.importProductsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setInventoryCallable =
        callableFactory.createUnaryCallable(
            setInventoryTransportSettings, settings.setInventorySettings(), clientContext);
    this.setInventoryOperationCallable =
        callableFactory.createOperationCallable(
            setInventoryTransportSettings,
            settings.setInventoryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addFulfillmentPlacesCallable =
        callableFactory.createUnaryCallable(
            addFulfillmentPlacesTransportSettings,
            settings.addFulfillmentPlacesSettings(),
            clientContext);
    this.addFulfillmentPlacesOperationCallable =
        callableFactory.createOperationCallable(
            addFulfillmentPlacesTransportSettings,
            settings.addFulfillmentPlacesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeFulfillmentPlacesCallable =
        callableFactory.createUnaryCallable(
            removeFulfillmentPlacesTransportSettings,
            settings.removeFulfillmentPlacesSettings(),
            clientContext);
    this.removeFulfillmentPlacesOperationCallable =
        callableFactory.createOperationCallable(
            removeFulfillmentPlacesTransportSettings,
            settings.removeFulfillmentPlacesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addLocalInventoriesCallable =
        callableFactory.createUnaryCallable(
            addLocalInventoriesTransportSettings,
            settings.addLocalInventoriesSettings(),
            clientContext);
    this.addLocalInventoriesOperationCallable =
        callableFactory.createOperationCallable(
            addLocalInventoriesTransportSettings,
            settings.addLocalInventoriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeLocalInventoriesCallable =
        callableFactory.createUnaryCallable(
            removeLocalInventoriesTransportSettings,
            settings.removeLocalInventoriesSettings(),
            clientContext);
    this.removeLocalInventoriesOperationCallable =
        callableFactory.createOperationCallable(
            removeLocalInventoriesTransportSettings,
            settings.removeLocalInventoriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createProductMethodDescriptor);
    methodDescriptors.add(getProductMethodDescriptor);
    methodDescriptors.add(listProductsMethodDescriptor);
    methodDescriptors.add(updateProductMethodDescriptor);
    methodDescriptors.add(deleteProductMethodDescriptor);
    methodDescriptors.add(purgeProductsMethodDescriptor);
    methodDescriptors.add(importProductsMethodDescriptor);
    methodDescriptors.add(setInventoryMethodDescriptor);
    methodDescriptors.add(addFulfillmentPlacesMethodDescriptor);
    methodDescriptors.add(removeFulfillmentPlacesMethodDescriptor);
    methodDescriptors.add(addLocalInventoriesMethodDescriptor);
    methodDescriptors.add(removeLocalInventoriesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return createProductCallable;
  }

  @Override
  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return getProductCallable;
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
  public UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return updateProductCallable;
  }

  @Override
  public UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return deleteProductCallable;
  }

  @Override
  public UnaryCallable<PurgeProductsRequest, Operation> purgeProductsCallable() {
    return purgeProductsCallable;
  }

  @Override
  public OperationCallable<PurgeProductsRequest, PurgeProductsResponse, PurgeProductsMetadata>
      purgeProductsOperationCallable() {
    return purgeProductsOperationCallable;
  }

  @Override
  public UnaryCallable<ImportProductsRequest, Operation> importProductsCallable() {
    return importProductsCallable;
  }

  @Override
  public OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable() {
    return importProductsOperationCallable;
  }

  @Override
  public UnaryCallable<SetInventoryRequest, Operation> setInventoryCallable() {
    return setInventoryCallable;
  }

  @Override
  public OperationCallable<SetInventoryRequest, SetInventoryResponse, SetInventoryMetadata>
      setInventoryOperationCallable() {
    return setInventoryOperationCallable;
  }

  @Override
  public UnaryCallable<AddFulfillmentPlacesRequest, Operation> addFulfillmentPlacesCallable() {
    return addFulfillmentPlacesCallable;
  }

  @Override
  public OperationCallable<
          AddFulfillmentPlacesRequest, AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesOperationCallable() {
    return addFulfillmentPlacesOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesCallable() {
    return removeFulfillmentPlacesCallable;
  }

  @Override
  public OperationCallable<
          RemoveFulfillmentPlacesRequest,
          RemoveFulfillmentPlacesResponse,
          RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesOperationCallable() {
    return removeFulfillmentPlacesOperationCallable;
  }

  @Override
  public UnaryCallable<AddLocalInventoriesRequest, Operation> addLocalInventoriesCallable() {
    return addLocalInventoriesCallable;
  }

  @Override
  public OperationCallable<
          AddLocalInventoriesRequest, AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesOperationCallable() {
    return addLocalInventoriesOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveLocalInventoriesRequest, Operation> removeLocalInventoriesCallable() {
    return removeLocalInventoriesCallable;
  }

  @Override
  public OperationCallable<
          RemoveLocalInventoriesRequest,
          RemoveLocalInventoriesResponse,
          RemoveLocalInventoriesMetadata>
      removeLocalInventoriesOperationCallable() {
    return removeLocalInventoriesOperationCallable;
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
