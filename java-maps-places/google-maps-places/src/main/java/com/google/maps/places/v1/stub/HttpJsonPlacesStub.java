/*
 * Copyright 2023 Google LLC
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

package com.google.maps.places.v1.stub;

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
import com.google.maps.places.v1.GetPhotoMediaRequest;
import com.google.maps.places.v1.GetPlaceRequest;
import com.google.maps.places.v1.PhotoMedia;
import com.google.maps.places.v1.Place;
import com.google.maps.places.v1.SearchNearbyRequest;
import com.google.maps.places.v1.SearchNearbyResponse;
import com.google.maps.places.v1.SearchTextRequest;
import com.google.maps.places.v1.SearchTextResponse;
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
 * REST stub implementation for the Places service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPlacesStub extends PlacesStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SearchNearbyRequest, SearchNearbyResponse>
      searchNearbyMethodDescriptor =
          ApiMethodDescriptor.<SearchNearbyRequest, SearchNearbyResponse>newBuilder()
              .setFullMethodName("google.maps.places.v1.Places/SearchNearby")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchNearbyRequest>newBuilder()
                      .setPath(
                          "/v1/places:searchNearby",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchNearbyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchNearbyRequest> serializer =
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
                  ProtoMessageResponseParser.<SearchNearbyResponse>newBuilder()
                      .setDefaultInstance(SearchNearbyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchTextRequest, SearchTextResponse>
      searchTextMethodDescriptor =
          ApiMethodDescriptor.<SearchTextRequest, SearchTextResponse>newBuilder()
              .setFullMethodName("google.maps.places.v1.Places/SearchText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchTextRequest>newBuilder()
                      .setPath(
                          "/v1/places:searchText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchTextRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchTextRequest> serializer =
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
                  ProtoMessageResponseParser.<SearchTextResponse>newBuilder()
                      .setDefaultInstance(SearchTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPhotoMediaRequest, PhotoMedia>
      getPhotoMediaMethodDescriptor =
          ApiMethodDescriptor.<GetPhotoMediaRequest, PhotoMedia>newBuilder()
              .setFullMethodName("google.maps.places.v1.Places/GetPhotoMedia")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPhotoMediaRequest>newBuilder()
                      .setPath(
                          "/v1/{name=places/*/photos/*/media}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPhotoMediaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPhotoMediaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "maxHeightPx", request.getMaxHeightPx());
                            serializer.putQueryParam(fields, "maxWidthPx", request.getMaxWidthPx());
                            serializer.putQueryParam(
                                fields, "skipHttpRedirect", request.getSkipHttpRedirect());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhotoMedia>newBuilder()
                      .setDefaultInstance(PhotoMedia.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPlaceRequest, Place> getPlaceMethodDescriptor =
      ApiMethodDescriptor.<GetPlaceRequest, Place>newBuilder()
          .setFullMethodName("google.maps.places.v1.Places/GetPlace")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPlaceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=places/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPlaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPlaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languageCode", request.getLanguageCode());
                        serializer.putQueryParam(fields, "regionCode", request.getRegionCode());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Place>newBuilder()
                  .setDefaultInstance(Place.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<SearchNearbyRequest, SearchNearbyResponse> searchNearbyCallable;
  private final UnaryCallable<SearchTextRequest, SearchTextResponse> searchTextCallable;
  private final UnaryCallable<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaCallable;
  private final UnaryCallable<GetPlaceRequest, Place> getPlaceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPlacesStub create(PlacesStubSettings settings) throws IOException {
    return new HttpJsonPlacesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPlacesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonPlacesStub(PlacesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPlacesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPlacesStub(
        PlacesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPlacesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPlacesStub(PlacesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPlacesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPlacesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPlacesStub(
      PlacesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SearchNearbyRequest, SearchNearbyResponse> searchNearbyTransportSettings =
        HttpJsonCallSettings.<SearchNearbyRequest, SearchNearbyResponse>newBuilder()
            .setMethodDescriptor(searchNearbyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchTextRequest, SearchTextResponse> searchTextTransportSettings =
        HttpJsonCallSettings.<SearchTextRequest, SearchTextResponse>newBuilder()
            .setMethodDescriptor(searchTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaTransportSettings =
        HttpJsonCallSettings.<GetPhotoMediaRequest, PhotoMedia>newBuilder()
            .setMethodDescriptor(getPhotoMediaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPlaceRequest, Place> getPlaceTransportSettings =
        HttpJsonCallSettings.<GetPlaceRequest, Place>newBuilder()
            .setMethodDescriptor(getPlaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.searchNearbyCallable =
        callableFactory.createUnaryCallable(
            searchNearbyTransportSettings, settings.searchNearbySettings(), clientContext);
    this.searchTextCallable =
        callableFactory.createUnaryCallable(
            searchTextTransportSettings, settings.searchTextSettings(), clientContext);
    this.getPhotoMediaCallable =
        callableFactory.createUnaryCallable(
            getPhotoMediaTransportSettings, settings.getPhotoMediaSettings(), clientContext);
    this.getPlaceCallable =
        callableFactory.createUnaryCallable(
            getPlaceTransportSettings, settings.getPlaceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(searchNearbyMethodDescriptor);
    methodDescriptors.add(searchTextMethodDescriptor);
    methodDescriptors.add(getPhotoMediaMethodDescriptor);
    methodDescriptors.add(getPlaceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SearchNearbyRequest, SearchNearbyResponse> searchNearbyCallable() {
    return searchNearbyCallable;
  }

  @Override
  public UnaryCallable<SearchTextRequest, SearchTextResponse> searchTextCallable() {
    return searchTextCallable;
  }

  @Override
  public UnaryCallable<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaCallable() {
    return getPhotoMediaCallable;
  }

  @Override
  public UnaryCallable<GetPlaceRequest, Place> getPlaceCallable() {
    return getPlaceCallable;
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
