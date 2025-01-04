/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.reviews.v1beta.stub;

import static com.google.shopping.merchant.reviews.v1beta.ProductReviewsServiceClient.ListProductReviewsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.reviews.v1beta.DeleteProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertProductReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListProductReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListProductReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.ProductReview;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ProductReviewsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProductReviewsServiceStub extends ProductReviewsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProductReviewRequest, ProductReview>
      getProductReviewMethodDescriptor =
          ApiMethodDescriptor.<GetProductReviewRequest, ProductReview>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/GetProductReview")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProductReviewRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{name=accounts/*/productReviews/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProductReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProductReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductReview>newBuilder()
                      .setDefaultInstance(ProductReview.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsMethodDescriptor =
          ApiMethodDescriptor.<ListProductReviewsRequest, ListProductReviewsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/ListProductReviews")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductReviewsRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{parent=accounts/*}/productReviews",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductReviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductReviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProductReviewsResponse>newBuilder()
                      .setDefaultInstance(ListProductReviewsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertProductReviewRequest, ProductReview>
      insertProductReviewMethodDescriptor =
          ApiMethodDescriptor.<InsertProductReviewRequest, ProductReview>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/InsertProductReview")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertProductReviewRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{parent=accounts/*}/productReviews:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertProductReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertProductReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dataSource", request.getDataSource());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("productReview", request.getProductReview(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProductReview>newBuilder()
                      .setDefaultInstance(ProductReview.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteProductReviewRequest, Empty>
      deleteProductReviewMethodDescriptor =
          ApiMethodDescriptor.<DeleteProductReviewRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.ProductReviewsService/DeleteProductReview")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProductReviewRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{name=accounts/*/productReviews/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProductReviewRequest> serializer =
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

  private final UnaryCallable<GetProductReviewRequest, ProductReview> getProductReviewCallable;
  private final UnaryCallable<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsCallable;
  private final UnaryCallable<ListProductReviewsRequest, ListProductReviewsPagedResponse>
      listProductReviewsPagedCallable;
  private final UnaryCallable<InsertProductReviewRequest, ProductReview>
      insertProductReviewCallable;
  private final UnaryCallable<DeleteProductReviewRequest, Empty> deleteProductReviewCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProductReviewsServiceStub create(
      ProductReviewsServiceStubSettings settings) throws IOException {
    return new HttpJsonProductReviewsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProductReviewsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProductReviewsServiceStub(
        ProductReviewsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProductReviewsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProductReviewsServiceStub(
        ProductReviewsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProductReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductReviewsServiceStub(
      ProductReviewsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProductReviewsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProductReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProductReviewsServiceStub(
      ProductReviewsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProductReviewRequest, ProductReview> getProductReviewTransportSettings =
        HttpJsonCallSettings.<GetProductReviewRequest, ProductReview>newBuilder()
            .setMethodDescriptor(getProductReviewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProductReviewsRequest, ListProductReviewsResponse>
        listProductReviewsTransportSettings =
            HttpJsonCallSettings.<ListProductReviewsRequest, ListProductReviewsResponse>newBuilder()
                .setMethodDescriptor(listProductReviewsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertProductReviewRequest, ProductReview>
        insertProductReviewTransportSettings =
            HttpJsonCallSettings.<InsertProductReviewRequest, ProductReview>newBuilder()
                .setMethodDescriptor(insertProductReviewMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteProductReviewRequest, Empty> deleteProductReviewTransportSettings =
        HttpJsonCallSettings.<DeleteProductReviewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteProductReviewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getProductReviewCallable =
        callableFactory.createUnaryCallable(
            getProductReviewTransportSettings, settings.getProductReviewSettings(), clientContext);
    this.listProductReviewsCallable =
        callableFactory.createUnaryCallable(
            listProductReviewsTransportSettings,
            settings.listProductReviewsSettings(),
            clientContext);
    this.listProductReviewsPagedCallable =
        callableFactory.createPagedCallable(
            listProductReviewsTransportSettings,
            settings.listProductReviewsSettings(),
            clientContext);
    this.insertProductReviewCallable =
        callableFactory.createUnaryCallable(
            insertProductReviewTransportSettings,
            settings.insertProductReviewSettings(),
            clientContext);
    this.deleteProductReviewCallable =
        callableFactory.createUnaryCallable(
            deleteProductReviewTransportSettings,
            settings.deleteProductReviewSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProductReviewMethodDescriptor);
    methodDescriptors.add(listProductReviewsMethodDescriptor);
    methodDescriptors.add(insertProductReviewMethodDescriptor);
    methodDescriptors.add(deleteProductReviewMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetProductReviewRequest, ProductReview> getProductReviewCallable() {
    return getProductReviewCallable;
  }

  @Override
  public UnaryCallable<ListProductReviewsRequest, ListProductReviewsResponse>
      listProductReviewsCallable() {
    return listProductReviewsCallable;
  }

  @Override
  public UnaryCallable<ListProductReviewsRequest, ListProductReviewsPagedResponse>
      listProductReviewsPagedCallable() {
    return listProductReviewsPagedCallable;
  }

  @Override
  public UnaryCallable<InsertProductReviewRequest, ProductReview> insertProductReviewCallable() {
    return insertProductReviewCallable;
  }

  @Override
  public UnaryCallable<DeleteProductReviewRequest, Empty> deleteProductReviewCallable() {
    return deleteProductReviewCallable;
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
