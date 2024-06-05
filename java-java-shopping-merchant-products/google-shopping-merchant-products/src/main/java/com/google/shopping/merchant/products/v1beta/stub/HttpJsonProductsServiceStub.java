/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.products.v1beta.stub;

import static com.google.shopping.merchant.products.v1beta.ProductsServiceClient.ListProductsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.products.v1beta.GetProductRequest;
import com.google.shopping.merchant.products.v1beta.ListProductsRequest;
import com.google.shopping.merchant.products.v1beta.ListProductsResponse;
import com.google.shopping.merchant.products.v1beta.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ProductsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProductsServiceStub extends ProductsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      ApiMethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setFullMethodName("google.shopping.merchant.products.v1beta.ProductsService/GetProduct")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProductRequest>newBuilder()
                  .setPath(
                      "/products/v1beta/{name=accounts/*/products/*}",
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
              .setFullMethodName(
                  "google.shopping.merchant.products.v1beta.ProductsService/ListProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductsRequest>newBuilder()
                      .setPath(
                          "/products/v1beta/{parent=accounts/*}/products",
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

  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProductsServiceStub create(ProductsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonProductsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProductsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProductsServiceStub(
        ProductsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProductsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProductsServiceStub(
        ProductsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProductsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductsServiceStub(
      ProductsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProductsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProductsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductsServiceStub(
      ProductsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProductRequest, Product> getProductTransportSettings =
        HttpJsonCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        HttpJsonCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getProductCallable =
        callableFactory.createUnaryCallable(
            getProductTransportSettings, settings.getProductSettings(), clientContext);
    this.listProductsCallable =
        callableFactory.createUnaryCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listProductsPagedCallable =
        callableFactory.createPagedCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProductMethodDescriptor);
    methodDescriptors.add(listProductsMethodDescriptor);
    return methodDescriptors;
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
