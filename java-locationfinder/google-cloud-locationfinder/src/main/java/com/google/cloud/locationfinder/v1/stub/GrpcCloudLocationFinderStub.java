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

package com.google.cloud.locationfinder.v1.stub;

import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.ListCloudLocationsPagedResponse;
import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.SearchCloudLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.locationfinder.v1.CloudLocation;
import com.google.cloud.locationfinder.v1.GetCloudLocationRequest;
import com.google.cloud.locationfinder.v1.ListCloudLocationsRequest;
import com.google.cloud.locationfinder.v1.ListCloudLocationsResponse;
import com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest;
import com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudLocationFinder service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudLocationFinderStub extends CloudLocationFinderStub {
  private static final MethodDescriptor<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsMethodDescriptor =
          MethodDescriptor.<ListCloudLocationsRequest, ListCloudLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.locationfinder.v1.CloudLocationFinder/ListCloudLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCloudLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCloudLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCloudLocationRequest, CloudLocation>
      getCloudLocationMethodDescriptor =
          MethodDescriptor.<GetCloudLocationRequest, CloudLocation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.locationfinder.v1.CloudLocationFinder/GetCloudLocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCloudLocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudLocation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsMethodDescriptor =
          MethodDescriptor.<SearchCloudLocationsRequest, SearchCloudLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.locationfinder.v1.CloudLocationFinder/SearchCloudLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchCloudLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchCloudLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsCallable;
  private final UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsPagedResponse>
      listCloudLocationsPagedCallable;
  private final UnaryCallable<GetCloudLocationRequest, CloudLocation> getCloudLocationCallable;
  private final UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsCallable;
  private final UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsPagedResponse>
      searchCloudLocationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudLocationFinderStub create(CloudLocationFinderStubSettings settings)
      throws IOException {
    return new GrpcCloudLocationFinderStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudLocationFinderStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudLocationFinderStub(
        CloudLocationFinderStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudLocationFinderStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudLocationFinderStub(
        CloudLocationFinderStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudLocationFinderStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudLocationFinderStub(
      CloudLocationFinderStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudLocationFinderCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudLocationFinderStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudLocationFinderStub(
      CloudLocationFinderStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCloudLocationsRequest, ListCloudLocationsResponse>
        listCloudLocationsTransportSettings =
            GrpcCallSettings.<ListCloudLocationsRequest, ListCloudLocationsResponse>newBuilder()
                .setMethodDescriptor(listCloudLocationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCloudLocationRequest, CloudLocation> getCloudLocationTransportSettings =
        GrpcCallSettings.<GetCloudLocationRequest, CloudLocation>newBuilder()
            .setMethodDescriptor(getCloudLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
        searchCloudLocationsTransportSettings =
            GrpcCallSettings.<SearchCloudLocationsRequest, SearchCloudLocationsResponse>newBuilder()
                .setMethodDescriptor(searchCloudLocationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listCloudLocationsCallable =
        callableFactory.createUnaryCallable(
            listCloudLocationsTransportSettings,
            settings.listCloudLocationsSettings(),
            clientContext);
    this.listCloudLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listCloudLocationsTransportSettings,
            settings.listCloudLocationsSettings(),
            clientContext);
    this.getCloudLocationCallable =
        callableFactory.createUnaryCallable(
            getCloudLocationTransportSettings, settings.getCloudLocationSettings(), clientContext);
    this.searchCloudLocationsCallable =
        callableFactory.createUnaryCallable(
            searchCloudLocationsTransportSettings,
            settings.searchCloudLocationsSettings(),
            clientContext);
    this.searchCloudLocationsPagedCallable =
        callableFactory.createPagedCallable(
            searchCloudLocationsTransportSettings,
            settings.searchCloudLocationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsCallable() {
    return listCloudLocationsCallable;
  }

  @Override
  public UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsPagedResponse>
      listCloudLocationsPagedCallable() {
    return listCloudLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudLocationRequest, CloudLocation> getCloudLocationCallable() {
    return getCloudLocationCallable;
  }

  @Override
  public UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsCallable() {
    return searchCloudLocationsCallable;
  }

  @Override
  public UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsPagedResponse>
      searchCloudLocationsPagedCallable() {
    return searchCloudLocationsPagedCallable;
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
