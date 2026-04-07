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

package com.google.maps.geocode.v4.stub;

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
import com.google.maps.geocode.v4.GeocodeAddressRequest;
import com.google.maps.geocode.v4.GeocodeAddressResponse;
import com.google.maps.geocode.v4.GeocodeLocationRequest;
import com.google.maps.geocode.v4.GeocodeLocationResponse;
import com.google.maps.geocode.v4.GeocodePlaceRequest;
import com.google.maps.geocode.v4.GeocodeResult;
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
 * REST stub implementation for the GeocodeService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonGeocodeServiceStub extends GeocodeServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GeocodeAddressRequest, GeocodeAddressResponse>
      geocodeAddressMethodDescriptor =
          ApiMethodDescriptor.<GeocodeAddressRequest, GeocodeAddressResponse>newBuilder()
              .setFullMethodName("google.maps.geocode.v4.GeocodeService/GeocodeAddress")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GeocodeAddressRequest>newBuilder()
                      .setPath(
                          "/v4/geocode/address",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GeocodeAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "addressQuery", request.getAddressQuery());
                            return fields;
                          })
                      .setAdditionalPaths("/v4/geocode/address/{addressQuery}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GeocodeAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "address", request.getAddress());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(
                                fields, "locationBias", request.getLocationBias());
                            serializer.putQueryParam(fields, "regionCode", request.getRegionCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GeocodeAddressResponse>newBuilder()
                      .setDefaultInstance(GeocodeAddressResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GeocodeLocationRequest, GeocodeLocationResponse>
      geocodeLocationMethodDescriptor =
          ApiMethodDescriptor.<GeocodeLocationRequest, GeocodeLocationResponse>newBuilder()
              .setFullMethodName("google.maps.geocode.v4.GeocodeService/GeocodeLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GeocodeLocationRequest>newBuilder()
                      .setPath(
                          "/v4/geocode/location",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GeocodeLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "locationQuery", request.getLocationQuery());
                            return fields;
                          })
                      .setAdditionalPaths("/v4/geocode/location/{locationQuery}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GeocodeLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "granularity", request.getGranularityList());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "location", request.getLocation());
                            serializer.putQueryParam(fields, "regionCode", request.getRegionCode());
                            serializer.putQueryParam(fields, "types", request.getTypesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GeocodeLocationResponse>newBuilder()
                      .setDefaultInstance(GeocodeLocationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GeocodePlaceRequest, GeocodeResult>
      geocodePlaceMethodDescriptor =
          ApiMethodDescriptor.<GeocodePlaceRequest, GeocodeResult>newBuilder()
              .setFullMethodName("google.maps.geocode.v4.GeocodeService/GeocodePlace")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GeocodePlaceRequest>newBuilder()
                      .setPath(
                          "/v4/geocode/{place=places/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GeocodePlaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "place", request.getPlace());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GeocodePlaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "regionCode", request.getRegionCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GeocodeResult>newBuilder()
                      .setDefaultInstance(GeocodeResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GeocodeAddressRequest, GeocodeAddressResponse> geocodeAddressCallable;
  private final UnaryCallable<GeocodeLocationRequest, GeocodeLocationResponse>
      geocodeLocationCallable;
  private final UnaryCallable<GeocodePlaceRequest, GeocodeResult> geocodePlaceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGeocodeServiceStub create(GeocodeServiceStubSettings settings)
      throws IOException {
    return new HttpJsonGeocodeServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGeocodeServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGeocodeServiceStub(
        GeocodeServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGeocodeServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGeocodeServiceStub(
        GeocodeServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGeocodeServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGeocodeServiceStub(
      GeocodeServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGeocodeServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGeocodeServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGeocodeServiceStub(
      GeocodeServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GeocodeAddressRequest, GeocodeAddressResponse>
        geocodeAddressTransportSettings =
            HttpJsonCallSettings.<GeocodeAddressRequest, GeocodeAddressResponse>newBuilder()
                .setMethodDescriptor(geocodeAddressMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("address_query", String.valueOf(request.getAddressQuery()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GeocodeLocationRequest, GeocodeLocationResponse>
        geocodeLocationTransportSettings =
            HttpJsonCallSettings.<GeocodeLocationRequest, GeocodeLocationResponse>newBuilder()
                .setMethodDescriptor(geocodeLocationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location_query", String.valueOf(request.getLocationQuery()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GeocodePlaceRequest, GeocodeResult> geocodePlaceTransportSettings =
        HttpJsonCallSettings.<GeocodePlaceRequest, GeocodeResult>newBuilder()
            .setMethodDescriptor(geocodePlaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("place", String.valueOf(request.getPlace()));
                  return builder.build();
                })
            .build();

    this.geocodeAddressCallable =
        callableFactory.createUnaryCallable(
            geocodeAddressTransportSettings, settings.geocodeAddressSettings(), clientContext);
    this.geocodeLocationCallable =
        callableFactory.createUnaryCallable(
            geocodeLocationTransportSettings, settings.geocodeLocationSettings(), clientContext);
    this.geocodePlaceCallable =
        callableFactory.createUnaryCallable(
            geocodePlaceTransportSettings, settings.geocodePlaceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(geocodeAddressMethodDescriptor);
    methodDescriptors.add(geocodeLocationMethodDescriptor);
    methodDescriptors.add(geocodePlaceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GeocodeAddressRequest, GeocodeAddressResponse> geocodeAddressCallable() {
    return geocodeAddressCallable;
  }

  @Override
  public UnaryCallable<GeocodeLocationRequest, GeocodeLocationResponse> geocodeLocationCallable() {
    return geocodeLocationCallable;
  }

  @Override
  public UnaryCallable<GeocodePlaceRequest, GeocodeResult> geocodePlaceCallable() {
    return geocodePlaceCallable;
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
