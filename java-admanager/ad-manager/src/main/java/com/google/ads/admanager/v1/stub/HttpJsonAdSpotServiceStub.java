/*
 * Copyright 2026 Google LLC
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

import static com.google.ads.admanager.v1.AdSpotServiceClient.ListAdSpotsPagedResponse;

import com.google.ads.admanager.v1.AdSpot;
import com.google.ads.admanager.v1.BatchCreateAdSpotsRequest;
import com.google.ads.admanager.v1.BatchCreateAdSpotsResponse;
import com.google.ads.admanager.v1.BatchUpdateAdSpotsRequest;
import com.google.ads.admanager.v1.BatchUpdateAdSpotsResponse;
import com.google.ads.admanager.v1.CreateAdSpotRequest;
import com.google.ads.admanager.v1.GetAdSpotRequest;
import com.google.ads.admanager.v1.ListAdSpotsRequest;
import com.google.ads.admanager.v1.ListAdSpotsResponse;
import com.google.ads.admanager.v1.UpdateAdSpotRequest;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AdSpotService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAdSpotServiceStub extends AdSpotServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAdSpotRequest, AdSpot> getAdSpotMethodDescriptor =
      ApiMethodDescriptor.<GetAdSpotRequest, AdSpot>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.AdSpotService/GetAdSpot")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAdSpotRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/adSpots/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdSpotRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdSpotRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AdSpot>newBuilder()
                  .setDefaultInstance(AdSpot.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAdSpotsRequest, ListAdSpotsResponse>
      listAdSpotsMethodDescriptor =
          ApiMethodDescriptor.<ListAdSpotsRequest, ListAdSpotsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdSpotService/ListAdSpots")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdSpotsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adSpots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdSpotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdSpotsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdSpotsResponse>newBuilder()
                      .setDefaultInstance(ListAdSpotsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdSpotRequest, AdSpot>
      createAdSpotMethodDescriptor =
          ApiMethodDescriptor.<CreateAdSpotRequest, AdSpot>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdSpotService/CreateAdSpot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdSpotRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adSpots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdSpotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdSpotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adSpot", request.getAdSpot(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdSpot>newBuilder()
                      .setDefaultInstance(AdSpot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
      batchCreateAdSpotsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdSpotService/BatchCreateAdSpots")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateAdSpotsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adSpots:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAdSpotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAdSpotsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateAdSpotsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateAdSpotsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAdSpotRequest, AdSpot>
      updateAdSpotMethodDescriptor =
          ApiMethodDescriptor.<UpdateAdSpotRequest, AdSpot>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdSpotService/UpdateAdSpot")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAdSpotRequest>newBuilder()
                      .setPath(
                          "/v1/{adSpot.name=networks/*/adSpots/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdSpotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "adSpot.name", request.getAdSpot().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdSpotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adSpot", request.getAdSpot(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdSpot>newBuilder()
                      .setDefaultInstance(AdSpot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
      batchUpdateAdSpotsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdSpotService/BatchUpdateAdSpots")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateAdSpotsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adSpots:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAdSpotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAdSpotsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateAdSpotsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateAdSpotsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAdSpotRequest, AdSpot> getAdSpotCallable;
  private final UnaryCallable<ListAdSpotsRequest, ListAdSpotsResponse> listAdSpotsCallable;
  private final UnaryCallable<ListAdSpotsRequest, ListAdSpotsPagedResponse>
      listAdSpotsPagedCallable;
  private final UnaryCallable<CreateAdSpotRequest, AdSpot> createAdSpotCallable;
  private final UnaryCallable<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
      batchCreateAdSpotsCallable;
  private final UnaryCallable<UpdateAdSpotRequest, AdSpot> updateAdSpotCallable;
  private final UnaryCallable<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
      batchUpdateAdSpotsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdSpotServiceStub create(AdSpotServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAdSpotServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdSpotServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdSpotServiceStub(
        AdSpotServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdSpotServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdSpotServiceStub(
        AdSpotServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdSpotServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdSpotServiceStub(
      AdSpotServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAdSpotServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdSpotServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdSpotServiceStub(
      AdSpotServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAdSpotRequest, AdSpot> getAdSpotTransportSettings =
        HttpJsonCallSettings.<GetAdSpotRequest, AdSpot>newBuilder()
            .setMethodDescriptor(getAdSpotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListAdSpotsRequest, ListAdSpotsResponse> listAdSpotsTransportSettings =
        HttpJsonCallSettings.<ListAdSpotsRequest, ListAdSpotsResponse>newBuilder()
            .setMethodDescriptor(listAdSpotsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateAdSpotRequest, AdSpot> createAdSpotTransportSettings =
        HttpJsonCallSettings.<CreateAdSpotRequest, AdSpot>newBuilder()
            .setMethodDescriptor(createAdSpotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
        batchCreateAdSpotsTransportSettings =
            HttpJsonCallSettings.<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>newBuilder()
                .setMethodDescriptor(batchCreateAdSpotsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateAdSpotRequest, AdSpot> updateAdSpotTransportSettings =
        HttpJsonCallSettings.<UpdateAdSpotRequest, AdSpot>newBuilder()
            .setMethodDescriptor(updateAdSpotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("ad_spot.name", String.valueOf(request.getAdSpot().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
        batchUpdateAdSpotsTransportSettings =
            HttpJsonCallSettings.<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAdSpotsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getAdSpotCallable =
        callableFactory.createUnaryCallable(
            getAdSpotTransportSettings, settings.getAdSpotSettings(), clientContext);
    this.listAdSpotsCallable =
        callableFactory.createUnaryCallable(
            listAdSpotsTransportSettings, settings.listAdSpotsSettings(), clientContext);
    this.listAdSpotsPagedCallable =
        callableFactory.createPagedCallable(
            listAdSpotsTransportSettings, settings.listAdSpotsSettings(), clientContext);
    this.createAdSpotCallable =
        callableFactory.createUnaryCallable(
            createAdSpotTransportSettings, settings.createAdSpotSettings(), clientContext);
    this.batchCreateAdSpotsCallable =
        callableFactory.createUnaryCallable(
            batchCreateAdSpotsTransportSettings,
            settings.batchCreateAdSpotsSettings(),
            clientContext);
    this.updateAdSpotCallable =
        callableFactory.createUnaryCallable(
            updateAdSpotTransportSettings, settings.updateAdSpotSettings(), clientContext);
    this.batchUpdateAdSpotsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateAdSpotsTransportSettings,
            settings.batchUpdateAdSpotsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAdSpotMethodDescriptor);
    methodDescriptors.add(listAdSpotsMethodDescriptor);
    methodDescriptors.add(createAdSpotMethodDescriptor);
    methodDescriptors.add(batchCreateAdSpotsMethodDescriptor);
    methodDescriptors.add(updateAdSpotMethodDescriptor);
    methodDescriptors.add(batchUpdateAdSpotsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAdSpotRequest, AdSpot> getAdSpotCallable() {
    return getAdSpotCallable;
  }

  @Override
  public UnaryCallable<ListAdSpotsRequest, ListAdSpotsResponse> listAdSpotsCallable() {
    return listAdSpotsCallable;
  }

  @Override
  public UnaryCallable<ListAdSpotsRequest, ListAdSpotsPagedResponse> listAdSpotsPagedCallable() {
    return listAdSpotsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAdSpotRequest, AdSpot> createAdSpotCallable() {
    return createAdSpotCallable;
  }

  @Override
  public UnaryCallable<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
      batchCreateAdSpotsCallable() {
    return batchCreateAdSpotsCallable;
  }

  @Override
  public UnaryCallable<UpdateAdSpotRequest, AdSpot> updateAdSpotCallable() {
    return updateAdSpotCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
      batchUpdateAdSpotsCallable() {
    return batchUpdateAdSpotsCallable;
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
