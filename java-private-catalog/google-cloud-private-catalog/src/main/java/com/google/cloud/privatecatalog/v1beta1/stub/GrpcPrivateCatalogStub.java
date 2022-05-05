/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.privatecatalog.v1beta1.stub;

import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchCatalogsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchProductsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchVersionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PrivateCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPrivateCatalogStub extends PrivateCatalogStub {
  private static final MethodDescriptor<SearchCatalogsRequest, SearchCatalogsResponse>
      searchCatalogsMethodDescriptor =
          MethodDescriptor.<SearchCatalogsRequest, SearchCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privatecatalog.v1beta1.PrivateCatalog/SearchCatalogs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchCatalogsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchProductsRequest, SearchProductsResponse>
      searchProductsMethodDescriptor =
          MethodDescriptor.<SearchProductsRequest, SearchProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privatecatalog.v1beta1.PrivateCatalog/SearchProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchProductsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchVersionsRequest, SearchVersionsResponse>
      searchVersionsMethodDescriptor =
          MethodDescriptor.<SearchVersionsRequest, SearchVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privatecatalog.v1beta1.PrivateCatalog/SearchVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchVersionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse> searchCatalogsCallable;
  private final UnaryCallable<SearchCatalogsRequest, SearchCatalogsPagedResponse>
      searchCatalogsPagedCallable;
  private final UnaryCallable<SearchProductsRequest, SearchProductsResponse> searchProductsCallable;
  private final UnaryCallable<SearchProductsRequest, SearchProductsPagedResponse>
      searchProductsPagedCallable;
  private final UnaryCallable<SearchVersionsRequest, SearchVersionsResponse> searchVersionsCallable;
  private final UnaryCallable<SearchVersionsRequest, SearchVersionsPagedResponse>
      searchVersionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPrivateCatalogStub create(PrivateCatalogStubSettings settings)
      throws IOException {
    return new GrpcPrivateCatalogStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPrivateCatalogStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPrivateCatalogStub(
        PrivateCatalogStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPrivateCatalogStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPrivateCatalogStub(
        PrivateCatalogStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPrivateCatalogStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPrivateCatalogStub(PrivateCatalogStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPrivateCatalogCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPrivateCatalogStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPrivateCatalogStub(
      PrivateCatalogStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchCatalogsRequest, SearchCatalogsResponse>
        searchCatalogsTransportSettings =
            GrpcCallSettings.<SearchCatalogsRequest, SearchCatalogsResponse>newBuilder()
                .setMethodDescriptor(searchCatalogsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SearchProductsRequest, SearchProductsResponse>
        searchProductsTransportSettings =
            GrpcCallSettings.<SearchProductsRequest, SearchProductsResponse>newBuilder()
                .setMethodDescriptor(searchProductsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SearchVersionsRequest, SearchVersionsResponse>
        searchVersionsTransportSettings =
            GrpcCallSettings.<SearchVersionsRequest, SearchVersionsResponse>newBuilder()
                .setMethodDescriptor(searchVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.searchCatalogsCallable =
        callableFactory.createUnaryCallable(
            searchCatalogsTransportSettings, settings.searchCatalogsSettings(), clientContext);
    this.searchCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            searchCatalogsTransportSettings, settings.searchCatalogsSettings(), clientContext);
    this.searchProductsCallable =
        callableFactory.createUnaryCallable(
            searchProductsTransportSettings, settings.searchProductsSettings(), clientContext);
    this.searchProductsPagedCallable =
        callableFactory.createPagedCallable(
            searchProductsTransportSettings, settings.searchProductsSettings(), clientContext);
    this.searchVersionsCallable =
        callableFactory.createUnaryCallable(
            searchVersionsTransportSettings, settings.searchVersionsSettings(), clientContext);
    this.searchVersionsPagedCallable =
        callableFactory.createPagedCallable(
            searchVersionsTransportSettings, settings.searchVersionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse> searchCatalogsCallable() {
    return searchCatalogsCallable;
  }

  @Override
  public UnaryCallable<SearchCatalogsRequest, SearchCatalogsPagedResponse>
      searchCatalogsPagedCallable() {
    return searchCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchProductsRequest, SearchProductsResponse> searchProductsCallable() {
    return searchProductsCallable;
  }

  @Override
  public UnaryCallable<SearchProductsRequest, SearchProductsPagedResponse>
      searchProductsPagedCallable() {
    return searchProductsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchVersionsRequest, SearchVersionsResponse> searchVersionsCallable() {
    return searchVersionsCallable;
  }

  @Override
  public UnaryCallable<SearchVersionsRequest, SearchVersionsPagedResponse>
      searchVersionsPagedCallable() {
    return searchVersionsPagedCallable;
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
