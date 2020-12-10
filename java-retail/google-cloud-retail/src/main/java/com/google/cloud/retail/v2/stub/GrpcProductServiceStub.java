/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.UpdateProductRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
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

  private final UnaryCallable<CreateProductRequest, Product> createProductCallable;
  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<UpdateProductRequest, Product> updateProductCallable;
  private final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable;
  private final UnaryCallable<ImportProductsRequest, Operation> importProductsCallable;
  private final OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable;

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
                new RequestParamsExtractor<CreateProductRequest>() {
                  @Override
                  public Map<String, String> extract(CreateProductRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetProductRequest, Product> getProductTransportSettings =
        GrpcCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetProductRequest>() {
                  @Override
                  public Map<String, String> extract(GetProductRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateProductRequest, Product> updateProductTransportSettings =
        GrpcCallSettings.<UpdateProductRequest, Product>newBuilder()
            .setMethodDescriptor(updateProductMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateProductRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateProductRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("product.name", String.valueOf(request.getProduct().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteProductRequest, Empty> deleteProductTransportSettings =
        GrpcCallSettings.<DeleteProductRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteProductRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteProductRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ImportProductsRequest, Operation> importProductsTransportSettings =
        GrpcCallSettings.<ImportProductsRequest, Operation>newBuilder()
            .setMethodDescriptor(importProductsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ImportProductsRequest>() {
                  @Override
                  public Map<String, String> extract(ImportProductsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();

    this.createProductCallable =
        callableFactory.createUnaryCallable(
            createProductTransportSettings, settings.createProductSettings(), clientContext);
    this.getProductCallable =
        callableFactory.createUnaryCallable(
            getProductTransportSettings, settings.getProductSettings(), clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return createProductCallable;
  }

  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return getProductCallable;
  }

  public UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return updateProductCallable;
  }

  public UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return deleteProductCallable;
  }

  public UnaryCallable<ImportProductsRequest, Operation> importProductsCallable() {
    return importProductsCallable;
  }

  public OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable() {
    return importProductsOperationCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
