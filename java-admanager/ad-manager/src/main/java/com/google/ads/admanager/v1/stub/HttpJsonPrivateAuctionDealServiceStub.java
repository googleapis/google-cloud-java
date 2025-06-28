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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.PrivateAuctionDealServiceClient.ListPrivateAuctionDealsPagedResponse;

import com.google.ads.admanager.v1.CreatePrivateAuctionDealRequest;
import com.google.ads.admanager.v1.GetPrivateAuctionDealRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionDealsRequest;
import com.google.ads.admanager.v1.ListPrivateAuctionDealsResponse;
import com.google.ads.admanager.v1.PrivateAuctionDeal;
import com.google.ads.admanager.v1.UpdatePrivateAuctionDealRequest;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the PrivateAuctionDealService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPrivateAuctionDealServiceStub extends PrivateAuctionDealServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
      getPrivateAuctionDealMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateAuctionDealRequest, PrivateAuctionDeal>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionDealService/GetPrivateAuctionDeal")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateAuctionDealRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/privateAuctionDeals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateAuctionDealRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateAuctionDealRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateAuctionDeal>newBuilder()
                      .setDefaultInstance(PrivateAuctionDeal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>
      listPrivateAuctionDealsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionDealService/ListPrivateAuctionDeals")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateAuctionDealsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/privateAuctionDeals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateAuctionDealsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateAuctionDealsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPrivateAuctionDealsResponse>newBuilder()
                      .setDefaultInstance(ListPrivateAuctionDealsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
      createPrivateAuctionDealMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionDealService/CreatePrivateAuctionDeal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateAuctionDealRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/privateAuctionDeals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateAuctionDealRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateAuctionDealRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "privateAuctionDeal", request.getPrivateAuctionDeal(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateAuctionDeal>newBuilder()
                      .setDefaultInstance(PrivateAuctionDeal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
      updatePrivateAuctionDealMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.PrivateAuctionDealService/UpdatePrivateAuctionDeal")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePrivateAuctionDealRequest>newBuilder()
                      .setPath(
                          "/v1/{privateAuctionDeal.name=networks/*/privateAuctionDeals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateAuctionDealRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "privateAuctionDeal.name",
                                request.getPrivateAuctionDeal().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateAuctionDealRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "privateAuctionDeal", request.getPrivateAuctionDeal(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateAuctionDeal>newBuilder()
                      .setDefaultInstance(PrivateAuctionDeal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
      getPrivateAuctionDealCallable;
  private final UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>
      listPrivateAuctionDealsCallable;
  private final UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsPagedResponse>
      listPrivateAuctionDealsPagedCallable;
  private final UnaryCallable<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
      createPrivateAuctionDealCallable;
  private final UnaryCallable<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
      updatePrivateAuctionDealCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPrivateAuctionDealServiceStub create(
      PrivateAuctionDealServiceStubSettings settings) throws IOException {
    return new HttpJsonPrivateAuctionDealServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPrivateAuctionDealServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPrivateAuctionDealServiceStub(
        PrivateAuctionDealServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPrivateAuctionDealServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPrivateAuctionDealServiceStub(
        PrivateAuctionDealServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPrivateAuctionDealServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivateAuctionDealServiceStub(
      PrivateAuctionDealServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPrivateAuctionDealServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPrivateAuctionDealServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivateAuctionDealServiceStub(
      PrivateAuctionDealServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
        getPrivateAuctionDealTransportSettings =
            HttpJsonCallSettings.<GetPrivateAuctionDealRequest, PrivateAuctionDeal>newBuilder()
                .setMethodDescriptor(getPrivateAuctionDealMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>
        listPrivateAuctionDealsTransportSettings =
            HttpJsonCallSettings
                .<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>newBuilder()
                .setMethodDescriptor(listPrivateAuctionDealsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
        createPrivateAuctionDealTransportSettings =
            HttpJsonCallSettings.<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>newBuilder()
                .setMethodDescriptor(createPrivateAuctionDealMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
        updatePrivateAuctionDealTransportSettings =
            HttpJsonCallSettings.<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>newBuilder()
                .setMethodDescriptor(updatePrivateAuctionDealMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_auction_deal.name",
                          String.valueOf(request.getPrivateAuctionDeal().getName()));
                      return builder.build();
                    })
                .build();

    this.getPrivateAuctionDealCallable =
        callableFactory.createUnaryCallable(
            getPrivateAuctionDealTransportSettings,
            settings.getPrivateAuctionDealSettings(),
            clientContext);
    this.listPrivateAuctionDealsCallable =
        callableFactory.createUnaryCallable(
            listPrivateAuctionDealsTransportSettings,
            settings.listPrivateAuctionDealsSettings(),
            clientContext);
    this.listPrivateAuctionDealsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateAuctionDealsTransportSettings,
            settings.listPrivateAuctionDealsSettings(),
            clientContext);
    this.createPrivateAuctionDealCallable =
        callableFactory.createUnaryCallable(
            createPrivateAuctionDealTransportSettings,
            settings.createPrivateAuctionDealSettings(),
            clientContext);
    this.updatePrivateAuctionDealCallable =
        callableFactory.createUnaryCallable(
            updatePrivateAuctionDealTransportSettings,
            settings.updatePrivateAuctionDealSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getPrivateAuctionDealMethodDescriptor);
    methodDescriptors.add(listPrivateAuctionDealsMethodDescriptor);
    methodDescriptors.add(createPrivateAuctionDealMethodDescriptor);
    methodDescriptors.add(updatePrivateAuctionDealMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
      getPrivateAuctionDealCallable() {
    return getPrivateAuctionDealCallable;
  }

  @Override
  public UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>
      listPrivateAuctionDealsCallable() {
    return listPrivateAuctionDealsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsPagedResponse>
      listPrivateAuctionDealsPagedCallable() {
    return listPrivateAuctionDealsPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
      createPrivateAuctionDealCallable() {
    return createPrivateAuctionDealCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
      updatePrivateAuctionDealCallable() {
    return updatePrivateAuctionDealCallable;
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
