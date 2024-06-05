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

package com.google.shopping.merchant.promotions.v1beta.stub;

import static com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient.ListPromotionsPagedResponse;

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
import com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse;
import com.google.shopping.merchant.promotions.v1beta.Promotion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the PromotionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPromotionsServiceStub extends PromotionsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<InsertPromotionRequest, Promotion>
      insertPromotionMethodDescriptor =
          ApiMethodDescriptor.<InsertPromotionRequest, Promotion>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.promotions.v1beta.PromotionsService/InsertPromotion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertPromotionRequest>newBuilder()
                      .setPath(
                          "/promotions/v1beta/{parent=accounts/*}/promotions:insert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertPromotionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertPromotionRequest> serializer =
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
                  ProtoMessageResponseParser.<Promotion>newBuilder()
                      .setDefaultInstance(Promotion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPromotionRequest, Promotion>
      getPromotionMethodDescriptor =
          ApiMethodDescriptor.<GetPromotionRequest, Promotion>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.promotions.v1beta.PromotionsService/GetPromotion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPromotionRequest>newBuilder()
                      .setPath(
                          "/promotions/v1beta/{name=accounts/*/promotions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPromotionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPromotionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Promotion>newBuilder()
                      .setDefaultInstance(Promotion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPromotionsRequest, ListPromotionsResponse>
      listPromotionsMethodDescriptor =
          ApiMethodDescriptor.<ListPromotionsRequest, ListPromotionsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.promotions.v1beta.PromotionsService/ListPromotions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPromotionsRequest>newBuilder()
                      .setPath(
                          "/promotions/v1beta/{parent=accounts/*}/promotions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPromotionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPromotionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPromotionsResponse>newBuilder()
                      .setDefaultInstance(ListPromotionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<InsertPromotionRequest, Promotion> insertPromotionCallable;
  private final UnaryCallable<GetPromotionRequest, Promotion> getPromotionCallable;
  private final UnaryCallable<ListPromotionsRequest, ListPromotionsResponse> listPromotionsCallable;
  private final UnaryCallable<ListPromotionsRequest, ListPromotionsPagedResponse>
      listPromotionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPromotionsServiceStub create(PromotionsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPromotionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPromotionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPromotionsServiceStub(
        PromotionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPromotionsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPromotionsServiceStub(
        PromotionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPromotionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPromotionsServiceStub(
      PromotionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPromotionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPromotionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPromotionsServiceStub(
      PromotionsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<InsertPromotionRequest, Promotion> insertPromotionTransportSettings =
        HttpJsonCallSettings.<InsertPromotionRequest, Promotion>newBuilder()
            .setMethodDescriptor(insertPromotionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPromotionRequest, Promotion> getPromotionTransportSettings =
        HttpJsonCallSettings.<GetPromotionRequest, Promotion>newBuilder()
            .setMethodDescriptor(getPromotionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPromotionsRequest, ListPromotionsResponse>
        listPromotionsTransportSettings =
            HttpJsonCallSettings.<ListPromotionsRequest, ListPromotionsResponse>newBuilder()
                .setMethodDescriptor(listPromotionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.insertPromotionCallable =
        callableFactory.createUnaryCallable(
            insertPromotionTransportSettings, settings.insertPromotionSettings(), clientContext);
    this.getPromotionCallable =
        callableFactory.createUnaryCallable(
            getPromotionTransportSettings, settings.getPromotionSettings(), clientContext);
    this.listPromotionsCallable =
        callableFactory.createUnaryCallable(
            listPromotionsTransportSettings, settings.listPromotionsSettings(), clientContext);
    this.listPromotionsPagedCallable =
        callableFactory.createPagedCallable(
            listPromotionsTransportSettings, settings.listPromotionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(insertPromotionMethodDescriptor);
    methodDescriptors.add(getPromotionMethodDescriptor);
    methodDescriptors.add(listPromotionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<InsertPromotionRequest, Promotion> insertPromotionCallable() {
    return insertPromotionCallable;
  }

  @Override
  public UnaryCallable<GetPromotionRequest, Promotion> getPromotionCallable() {
    return getPromotionCallable;
  }

  @Override
  public UnaryCallable<ListPromotionsRequest, ListPromotionsResponse> listPromotionsCallable() {
    return listPromotionsCallable;
  }

  @Override
  public UnaryCallable<ListPromotionsRequest, ListPromotionsPagedResponse>
      listPromotionsPagedCallable() {
    return listPromotionsPagedCallable;
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
