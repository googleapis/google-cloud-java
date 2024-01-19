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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.places.v1.GetPhotoMediaRequest;
import com.google.maps.places.v1.GetPlaceRequest;
import com.google.maps.places.v1.PhotoMedia;
import com.google.maps.places.v1.Place;
import com.google.maps.places.v1.SearchNearbyRequest;
import com.google.maps.places.v1.SearchNearbyResponse;
import com.google.maps.places.v1.SearchTextRequest;
import com.google.maps.places.v1.SearchTextResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Places service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPlacesStub extends PlacesStub {
  private static final MethodDescriptor<SearchNearbyRequest, SearchNearbyResponse>
      searchNearbyMethodDescriptor =
          MethodDescriptor.<SearchNearbyRequest, SearchNearbyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.places.v1.Places/SearchNearby")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchNearbyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchNearbyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchTextRequest, SearchTextResponse>
      searchTextMethodDescriptor =
          MethodDescriptor.<SearchTextRequest, SearchTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.places.v1.Places/SearchText")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchTextRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchTextResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPhotoMediaRequest, PhotoMedia>
      getPhotoMediaMethodDescriptor =
          MethodDescriptor.<GetPhotoMediaRequest, PhotoMedia>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.places.v1.Places/GetPhotoMedia")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPhotoMediaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhotoMedia.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPlaceRequest, Place> getPlaceMethodDescriptor =
      MethodDescriptor.<GetPlaceRequest, Place>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.maps.places.v1.Places/GetPlace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPlaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Place.getDefaultInstance()))
          .build();

  private final UnaryCallable<SearchNearbyRequest, SearchNearbyResponse> searchNearbyCallable;
  private final UnaryCallable<SearchTextRequest, SearchTextResponse> searchTextCallable;
  private final UnaryCallable<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaCallable;
  private final UnaryCallable<GetPlaceRequest, Place> getPlaceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPlacesStub create(PlacesStubSettings settings) throws IOException {
    return new GrpcPlacesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPlacesStub create(ClientContext clientContext) throws IOException {
    return new GrpcPlacesStub(PlacesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPlacesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPlacesStub(
        PlacesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPlacesStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcPlacesStub(PlacesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPlacesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPlacesStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcPlacesStub(
      PlacesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchNearbyRequest, SearchNearbyResponse> searchNearbyTransportSettings =
        GrpcCallSettings.<SearchNearbyRequest, SearchNearbyResponse>newBuilder()
            .setMethodDescriptor(searchNearbyMethodDescriptor)
            .build();
    GrpcCallSettings<SearchTextRequest, SearchTextResponse> searchTextTransportSettings =
        GrpcCallSettings.<SearchTextRequest, SearchTextResponse>newBuilder()
            .setMethodDescriptor(searchTextMethodDescriptor)
            .build();
    GrpcCallSettings<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaTransportSettings =
        GrpcCallSettings.<GetPhotoMediaRequest, PhotoMedia>newBuilder()
            .setMethodDescriptor(getPhotoMediaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPlaceRequest, Place> getPlaceTransportSettings =
        GrpcCallSettings.<GetPlaceRequest, Place>newBuilder()
            .setMethodDescriptor(getPlaceMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
