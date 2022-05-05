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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.ProductServiceClient.ListProductsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.AddFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2.AddFulfillmentPlacesRequest;
import com.google.cloud.retail.v2.AddFulfillmentPlacesResponse;
import com.google.cloud.retail.v2.AddLocalInventoriesMetadata;
import com.google.cloud.retail.v2.AddLocalInventoriesRequest;
import com.google.cloud.retail.v2.AddLocalInventoriesResponse;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.ListProductsRequest;
import com.google.cloud.retail.v2.ListProductsResponse;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesRequest;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesResponse;
import com.google.cloud.retail.v2.RemoveLocalInventoriesMetadata;
import com.google.cloud.retail.v2.RemoveLocalInventoriesRequest;
import com.google.cloud.retail.v2.RemoveLocalInventoriesResponse;
import com.google.cloud.retail.v2.SetInventoryMetadata;
import com.google.cloud.retail.v2.SetInventoryRequest;
import com.google.cloud.retail.v2.SetInventoryResponse;
import com.google.cloud.retail.v2.UpdateProductRequest;
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
 * gRPC stub implementation for the ProductService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcProductServiceStub extends ProductServiceStub {
  private static final MethodDescriptor<CreateProductRequest, Product>
      createProductMethodDescriptor =
          MethodDescriptor.<CreateProductRequest, Product>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/CreateProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      MethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2.ProductService/GetProduct")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProductRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          MethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/ListProducts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProductRequest, Product>
      updateProductMethodDescriptor =
          MethodDescriptor.<UpdateProductRequest, Product>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/UpdateProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProductRequest, Empty> deleteProductMethodDescriptor =
      MethodDescriptor.<DeleteProductRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2.ProductService/DeleteProduct")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteProductRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ImportProductsRequest, Operation>
      importProductsMethodDescriptor =
          MethodDescriptor.<ImportProductsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/ImportProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetInventoryRequest, Operation>
      setInventoryMethodDescriptor =
          MethodDescriptor.<SetInventoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/SetInventory")
              .setRequestMarshaller(ProtoUtils.marshaller(SetInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddFulfillmentPlacesRequest, Operation>
      addFulfillmentPlacesMethodDescriptor =
          MethodDescriptor.<AddFulfillmentPlacesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/AddFulfillmentPlaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddFulfillmentPlacesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesMethodDescriptor =
          MethodDescriptor.<RemoveFulfillmentPlacesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/RemoveFulfillmentPlaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveFulfillmentPlacesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddLocalInventoriesRequest, Operation>
      addLocalInventoriesMethodDescriptor =
          MethodDescriptor.<AddLocalInventoriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/AddLocalInventories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddLocalInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveLocalInventoriesRequest, Operation>
      removeLocalInventoriesMethodDescriptor =
          MethodDescriptor.<RemoveLocalInventoriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2.ProductService/RemoveLocalInventories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveLocalInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateProductRequest, Product> createProductCallable;
  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;
  private final UnaryCallable<UpdateProductRequest, Product> updateProductCallable;
  private final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable;
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProductServiceStub create(ProductServiceStubSettings settings)
      throws IOException {
    return new GrpcProductServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProductServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProductServiceStub(
        ProductServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProductServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProductServiceStub(
        ProductServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProductServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProductServiceStub(ProductServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcProductServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProductServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProductServiceStub(
      ProductServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<ImportProductsRequest, Operation> importProductsTransportSettings =
        GrpcCallSettings.<ImportProductsRequest, Operation>newBuilder()
            .setMethodDescriptor(importProductsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetInventoryRequest, Operation> setInventoryTransportSettings =
        GrpcCallSettings.<SetInventoryRequest, Operation>newBuilder()
            .setMethodDescriptor(setInventoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("inventory.name", String.valueOf(request.getInventory().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AddFulfillmentPlacesRequest, Operation> addFulfillmentPlacesTransportSettings =
        GrpcCallSettings.<AddFulfillmentPlacesRequest, Operation>newBuilder()
            .setMethodDescriptor(addFulfillmentPlacesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("product", String.valueOf(request.getProduct()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemoveFulfillmentPlacesRequest, Operation>
        removeFulfillmentPlacesTransportSettings =
            GrpcCallSettings.<RemoveFulfillmentPlacesRequest, Operation>newBuilder()
                .setMethodDescriptor(removeFulfillmentPlacesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("product", String.valueOf(request.getProduct()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<AddLocalInventoriesRequest, Operation> addLocalInventoriesTransportSettings =
        GrpcCallSettings.<AddLocalInventoriesRequest, Operation>newBuilder()
            .setMethodDescriptor(addLocalInventoriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("product", String.valueOf(request.getProduct()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemoveLocalInventoriesRequest, Operation>
        removeLocalInventoriesTransportSettings =
            GrpcCallSettings.<RemoveLocalInventoriesRequest, Operation>newBuilder()
                .setMethodDescriptor(removeLocalInventoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("product", String.valueOf(request.getProduct()));
                      return params.build();
                    })
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
    this.importProductsCallable =
        callableFactory.createUnaryCallable(
            importProductsTransportSettings, settings.importProductsSettings(), clientContext);
    this.importProductsOperationCallable =
        callableFactory.createOperationCallable(
            importProductsTransportSettings,
            settings.importProductsOperationSettings(),
            clientContext,
            operationsStub);
    this.setInventoryCallable =
        callableFactory.createUnaryCallable(
            setInventoryTransportSettings, settings.setInventorySettings(), clientContext);
    this.setInventoryOperationCallable =
        callableFactory.createOperationCallable(
            setInventoryTransportSettings,
            settings.setInventoryOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
