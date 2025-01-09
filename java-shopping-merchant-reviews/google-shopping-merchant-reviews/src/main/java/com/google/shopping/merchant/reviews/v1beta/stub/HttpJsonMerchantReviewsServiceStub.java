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

import static com.google.shopping.merchant.reviews.v1beta.MerchantReviewsServiceClient.ListMerchantReviewsPagedResponse;

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
import com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.MerchantReview;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the MerchantReviewsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMerchantReviewsServiceStub extends MerchantReviewsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetMerchantReviewRequest, MerchantReview>
      getMerchantReviewMethodDescriptor =
          ApiMethodDescriptor.<GetMerchantReviewRequest, MerchantReview>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/GetMerchantReview")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMerchantReviewRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{name=accounts/*/merchantReviews/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMerchantReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMerchantReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MerchantReview>newBuilder()
                      .setDefaultInstance(MerchantReview.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsMethodDescriptor =
          ApiMethodDescriptor.<ListMerchantReviewsRequest, ListMerchantReviewsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/ListMerchantReviews")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMerchantReviewsRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{parent=accounts/*}/merchantReviews",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMerchantReviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMerchantReviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMerchantReviewsResponse>newBuilder()
                      .setDefaultInstance(ListMerchantReviewsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewMethodDescriptor =
          ApiMethodDescriptor.<InsertMerchantReviewRequest, MerchantReview>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/InsertMerchantReview")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertMerchantReviewRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{parent=accounts/*}/merchantReviews:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertMerchantReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertMerchantReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dataSource", request.getDataSource());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("merchantReview", request.getMerchantReview(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MerchantReview>newBuilder()
                      .setDefaultInstance(MerchantReview.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMerchantReviewRequest, Empty>
      deleteMerchantReviewMethodDescriptor =
          ApiMethodDescriptor.<DeleteMerchantReviewRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.reviews.v1beta.MerchantReviewsService/DeleteMerchantReview")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMerchantReviewRequest>newBuilder()
                      .setPath(
                          "/reviews/v1beta/{name=accounts/*/merchantReviews/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMerchantReviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMerchantReviewRequest> serializer =
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

  private final UnaryCallable<GetMerchantReviewRequest, MerchantReview> getMerchantReviewCallable;
  private final UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsCallable;
  private final UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsPagedResponse>
      listMerchantReviewsPagedCallable;
  private final UnaryCallable<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewCallable;
  private final UnaryCallable<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMerchantReviewsServiceStub create(
      MerchantReviewsServiceStubSettings settings) throws IOException {
    return new HttpJsonMerchantReviewsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMerchantReviewsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMerchantReviewsServiceStub(
        MerchantReviewsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMerchantReviewsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMerchantReviewsServiceStub(
        MerchantReviewsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMerchantReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMerchantReviewsServiceStub(
      MerchantReviewsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMerchantReviewsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMerchantReviewsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMerchantReviewsServiceStub(
      MerchantReviewsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetMerchantReviewRequest, MerchantReview>
        getMerchantReviewTransportSettings =
            HttpJsonCallSettings.<GetMerchantReviewRequest, MerchantReview>newBuilder()
                .setMethodDescriptor(getMerchantReviewMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
        listMerchantReviewsTransportSettings =
            HttpJsonCallSettings
                .<ListMerchantReviewsRequest, ListMerchantReviewsResponse>newBuilder()
                .setMethodDescriptor(listMerchantReviewsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertMerchantReviewRequest, MerchantReview>
        insertMerchantReviewTransportSettings =
            HttpJsonCallSettings.<InsertMerchantReviewRequest, MerchantReview>newBuilder()
                .setMethodDescriptor(insertMerchantReviewMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewTransportSettings =
        HttpJsonCallSettings.<DeleteMerchantReviewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMerchantReviewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getMerchantReviewCallable =
        callableFactory.createUnaryCallable(
            getMerchantReviewTransportSettings,
            settings.getMerchantReviewSettings(),
            clientContext);
    this.listMerchantReviewsCallable =
        callableFactory.createUnaryCallable(
            listMerchantReviewsTransportSettings,
            settings.listMerchantReviewsSettings(),
            clientContext);
    this.listMerchantReviewsPagedCallable =
        callableFactory.createPagedCallable(
            listMerchantReviewsTransportSettings,
            settings.listMerchantReviewsSettings(),
            clientContext);
    this.insertMerchantReviewCallable =
        callableFactory.createUnaryCallable(
            insertMerchantReviewTransportSettings,
            settings.insertMerchantReviewSettings(),
            clientContext);
    this.deleteMerchantReviewCallable =
        callableFactory.createUnaryCallable(
            deleteMerchantReviewTransportSettings,
            settings.deleteMerchantReviewSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMerchantReviewMethodDescriptor);
    methodDescriptors.add(listMerchantReviewsMethodDescriptor);
    methodDescriptors.add(insertMerchantReviewMethodDescriptor);
    methodDescriptors.add(deleteMerchantReviewMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetMerchantReviewRequest, MerchantReview> getMerchantReviewCallable() {
    return getMerchantReviewCallable;
  }

  @Override
  public UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsCallable() {
    return listMerchantReviewsCallable;
  }

  @Override
  public UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsPagedResponse>
      listMerchantReviewsPagedCallable() {
    return listMerchantReviewsPagedCallable;
  }

  @Override
  public UnaryCallable<InsertMerchantReviewRequest, MerchantReview> insertMerchantReviewCallable() {
    return insertMerchantReviewCallable;
  }

  @Override
  public UnaryCallable<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewCallable() {
    return deleteMerchantReviewCallable;
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
