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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ContextRetrievalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcContextRetrievalServiceStub extends ContextRetrievalServiceStub {
  private static final MethodDescriptor<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextMethodDescriptor =
          MethodDescriptor
              .<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableContext")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveBigQueryTableContextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveBigQueryTableContextResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsMethodDescriptor =
          MethodDescriptor
              .<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableContexts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveBigQueryTableContextsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveBigQueryTableContextsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesMethodDescriptor =
          MethodDescriptor
              .<RetrieveBigQueryTableContextsFromRecentTablesRequest,
                  RetrieveBigQueryTableContextsFromRecentTablesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableContextsFromRecentTables")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryTableContextsFromRecentTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryTableContextsFromRecentTablesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsMethodDescriptor =
          MethodDescriptor
              .<RetrieveBigQueryTableSuggestedDescriptionsRequest,
                  RetrieveBigQueryTableSuggestedDescriptionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableSuggestedDescriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryTableSuggestedDescriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryTableSuggestedDescriptionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesMethodDescriptor =
          MethodDescriptor
              .<RetrieveBigQueryTableSuggestedExamplesRequest,
                  RetrieveBigQueryTableSuggestedExamplesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableSuggestedExamples")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryTableSuggestedExamplesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryTableSuggestedExamplesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesMethodDescriptor =
          MethodDescriptor
              .<RetrieveBigQueryRecentRelevantTablesRequest,
                  RetrieveBigQueryRecentRelevantTablesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryRecentRelevantTables")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryRecentRelevantTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      RetrieveBigQueryRecentRelevantTablesResponse.getDefaultInstance()))
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

  private final UnaryCallable<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesCallable;
  private final UnaryCallable<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcContextRetrievalServiceStub create(
      ContextRetrievalServiceStubSettings settings) throws IOException {
    return new GrpcContextRetrievalServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcContextRetrievalServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcContextRetrievalServiceStub(
        ContextRetrievalServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcContextRetrievalServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcContextRetrievalServiceStub(
        ContextRetrievalServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcContextRetrievalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContextRetrievalServiceStub(
      ContextRetrievalServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcContextRetrievalServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcContextRetrievalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContextRetrievalServiceStub(
      ContextRetrievalServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
        retrieveBigQueryTableContextTransportSettings =
            GrpcCallSettings
                .<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableContextMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
        retrieveBigQueryTableContextsTransportSettings =
            GrpcCallSettings
                .<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableContextsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            RetrieveBigQueryTableContextsFromRecentTablesRequest,
            RetrieveBigQueryTableContextsFromRecentTablesResponse>
        retrieveBigQueryTableContextsFromRecentTablesTransportSettings =
            GrpcCallSettings
                .<RetrieveBigQueryTableContextsFromRecentTablesRequest,
                    RetrieveBigQueryTableContextsFromRecentTablesResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableContextsFromRecentTablesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            RetrieveBigQueryTableSuggestedDescriptionsRequest,
            RetrieveBigQueryTableSuggestedDescriptionsResponse>
        retrieveBigQueryTableSuggestedDescriptionsTransportSettings =
            GrpcCallSettings
                .<RetrieveBigQueryTableSuggestedDescriptionsRequest,
                    RetrieveBigQueryTableSuggestedDescriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableSuggestedDescriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            RetrieveBigQueryTableSuggestedExamplesRequest,
            RetrieveBigQueryTableSuggestedExamplesResponse>
        retrieveBigQueryTableSuggestedExamplesTransportSettings =
            GrpcCallSettings
                .<RetrieveBigQueryTableSuggestedExamplesRequest,
                    RetrieveBigQueryTableSuggestedExamplesResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableSuggestedExamplesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            RetrieveBigQueryRecentRelevantTablesRequest,
            RetrieveBigQueryRecentRelevantTablesResponse>
        retrieveBigQueryRecentRelevantTablesTransportSettings =
            GrpcCallSettings
                .<RetrieveBigQueryRecentRelevantTablesRequest,
                    RetrieveBigQueryRecentRelevantTablesResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryRecentRelevantTablesMethodDescriptor)
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

    this.retrieveBigQueryTableContextCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableContextTransportSettings,
            settings.retrieveBigQueryTableContextSettings(),
            clientContext);
    this.retrieveBigQueryTableContextsCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableContextsTransportSettings,
            settings.retrieveBigQueryTableContextsSettings(),
            clientContext);
    this.retrieveBigQueryTableContextsFromRecentTablesCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableContextsFromRecentTablesTransportSettings,
            settings.retrieveBigQueryTableContextsFromRecentTablesSettings(),
            clientContext);
    this.retrieveBigQueryTableSuggestedDescriptionsCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableSuggestedDescriptionsTransportSettings,
            settings.retrieveBigQueryTableSuggestedDescriptionsSettings(),
            clientContext);
    this.retrieveBigQueryTableSuggestedExamplesCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableSuggestedExamplesTransportSettings,
            settings.retrieveBigQueryTableSuggestedExamplesSettings(),
            clientContext);
    this.retrieveBigQueryRecentRelevantTablesCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryRecentRelevantTablesTransportSettings,
            settings.retrieveBigQueryRecentRelevantTablesSettings(),
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
  public UnaryCallable<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextCallable() {
    return retrieveBigQueryTableContextCallable;
  }

  @Override
  public UnaryCallable<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsCallable() {
    return retrieveBigQueryTableContextsCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesCallable() {
    return retrieveBigQueryTableContextsFromRecentTablesCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsCallable() {
    return retrieveBigQueryTableSuggestedDescriptionsCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesCallable() {
    return retrieveBigQueryTableSuggestedExamplesCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesCallable() {
    return retrieveBigQueryRecentRelevantTablesCallable;
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
