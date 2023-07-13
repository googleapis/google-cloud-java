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

package com.google.cloud.kms.inventory.v1.stub;

import static com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient.SearchProtectedResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest;
import com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary;
import com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest;
import com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the KeyTrackingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcKeyTrackingServiceStub extends KeyTrackingServiceStub {
  private static final MethodDescriptor<
          GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryMethodDescriptor =
          MethodDescriptor
              .<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.inventory.v1.KeyTrackingService/GetProtectedResourcesSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProtectedResourcesSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ProtectedResourcesSummary.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesMethodDescriptor =
          MethodDescriptor
              .<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.inventory.v1.KeyTrackingService/SearchProtectedResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchProtectedResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchProtectedResourcesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryCallable;
  private final UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesCallable;
  private final UnaryCallable<
          SearchProtectedResourcesRequest, SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcKeyTrackingServiceStub create(KeyTrackingServiceStubSettings settings)
      throws IOException {
    return new GrpcKeyTrackingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcKeyTrackingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcKeyTrackingServiceStub(
        KeyTrackingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcKeyTrackingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcKeyTrackingServiceStub(
        KeyTrackingServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcKeyTrackingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcKeyTrackingServiceStub(
      KeyTrackingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcKeyTrackingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcKeyTrackingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcKeyTrackingServiceStub(
      KeyTrackingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
        getProtectedResourcesSummaryTransportSettings =
            GrpcCallSettings
                .<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>newBuilder()
                .setMethodDescriptor(getProtectedResourcesSummaryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
        searchProtectedResourcesTransportSettings =
            GrpcCallSettings
                .<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>newBuilder()
                .setMethodDescriptor(searchProtectedResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();

    this.getProtectedResourcesSummaryCallable =
        callableFactory.createUnaryCallable(
            getProtectedResourcesSummaryTransportSettings,
            settings.getProtectedResourcesSummarySettings(),
            clientContext);
    this.searchProtectedResourcesCallable =
        callableFactory.createUnaryCallable(
            searchProtectedResourcesTransportSettings,
            settings.searchProtectedResourcesSettings(),
            clientContext);
    this.searchProtectedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchProtectedResourcesTransportSettings,
            settings.searchProtectedResourcesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryCallable() {
    return getProtectedResourcesSummaryCallable;
  }

  @Override
  public UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesCallable() {
    return searchProtectedResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesPagedCallable() {
    return searchProtectedResourcesPagedCallable;
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
