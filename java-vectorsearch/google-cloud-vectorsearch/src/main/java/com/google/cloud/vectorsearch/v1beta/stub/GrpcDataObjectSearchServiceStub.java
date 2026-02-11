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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.QueryDataObjectsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.SearchDataObjectsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataObjectSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataObjectSearchServiceStub extends DataObjectSearchServiceStub {
  private static final MethodDescriptor<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsMethodDescriptor =
          MethodDescriptor.<SearchDataObjectsRequest, SearchDataObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/SearchDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchDataObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsMethodDescriptor =
          MethodDescriptor.<QueryDataObjectsRequest, QueryDataObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/QueryDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryDataObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsMethodDescriptor =
          MethodDescriptor.<AggregateDataObjectsRequest, AggregateDataObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/AggregateDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AggregateDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AggregateDataObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsMethodDescriptor =
          MethodDescriptor
              .<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/BatchSearchDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchSearchDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchSearchDataObjectsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsCallable;
  private final UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsPagedResponse>
      searchDataObjectsPagedCallable;
  private final UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsCallable;
  private final UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsPagedResponse>
      queryDataObjectsPagedCallable;
  private final UnaryCallable<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsCallable;
  private final UnaryCallable<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataObjectSearchServiceStub create(
      DataObjectSearchServiceStubSettings settings) throws IOException {
    return new GrpcDataObjectSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataObjectSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataObjectSearchServiceStub(
        DataObjectSearchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataObjectSearchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataObjectSearchServiceStub(
        DataObjectSearchServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataObjectSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataObjectSearchServiceStub(
      DataObjectSearchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataObjectSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataObjectSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataObjectSearchServiceStub(
      DataObjectSearchServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchDataObjectsRequest, SearchDataObjectsResponse>
        searchDataObjectsTransportSettings =
            GrpcCallSettings.<SearchDataObjectsRequest, SearchDataObjectsResponse>newBuilder()
                .setMethodDescriptor(searchDataObjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryDataObjectsRequest, QueryDataObjectsResponse>
        queryDataObjectsTransportSettings =
            GrpcCallSettings.<QueryDataObjectsRequest, QueryDataObjectsResponse>newBuilder()
                .setMethodDescriptor(queryDataObjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
        aggregateDataObjectsTransportSettings =
            GrpcCallSettings.<AggregateDataObjectsRequest, AggregateDataObjectsResponse>newBuilder()
                .setMethodDescriptor(aggregateDataObjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
        batchSearchDataObjectsTransportSettings =
            GrpcCallSettings
                .<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>newBuilder()
                .setMethodDescriptor(batchSearchDataObjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.searchDataObjectsCallable =
        callableFactory.createUnaryCallable(
            searchDataObjectsTransportSettings,
            settings.searchDataObjectsSettings(),
            clientContext);
    this.searchDataObjectsPagedCallable =
        callableFactory.createPagedCallable(
            searchDataObjectsTransportSettings,
            settings.searchDataObjectsSettings(),
            clientContext);
    this.queryDataObjectsCallable =
        callableFactory.createUnaryCallable(
            queryDataObjectsTransportSettings, settings.queryDataObjectsSettings(), clientContext);
    this.queryDataObjectsPagedCallable =
        callableFactory.createPagedCallable(
            queryDataObjectsTransportSettings, settings.queryDataObjectsSettings(), clientContext);
    this.aggregateDataObjectsCallable =
        callableFactory.createUnaryCallable(
            aggregateDataObjectsTransportSettings,
            settings.aggregateDataObjectsSettings(),
            clientContext);
    this.batchSearchDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchSearchDataObjectsTransportSettings,
            settings.batchSearchDataObjectsSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsCallable() {
    return searchDataObjectsCallable;
  }

  @Override
  public UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsPagedResponse>
      searchDataObjectsPagedCallable() {
    return searchDataObjectsPagedCallable;
  }

  @Override
  public UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsCallable() {
    return queryDataObjectsCallable;
  }

  @Override
  public UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsPagedResponse>
      queryDataObjectsPagedCallable() {
    return queryDataObjectsPagedCallable;
  }

  @Override
  public UnaryCallable<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsCallable() {
    return aggregateDataObjectsCallable;
  }

  @Override
  public UnaryCallable<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsCallable() {
    return batchSearchDataObjectsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
