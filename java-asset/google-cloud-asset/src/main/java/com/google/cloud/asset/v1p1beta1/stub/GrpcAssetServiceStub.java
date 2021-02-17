/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.asset.v1p1beta1.stub;

import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p1beta1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1p1beta1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1p1beta1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1p1beta1.SearchAllResourcesResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAssetServiceStub extends AssetServiceStub {
  private static final MethodDescriptor<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesMethodDescriptor =
          MethodDescriptor.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1p1beta1.AssetService/SearchAllResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAllResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAllResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesMethodDescriptor =
          MethodDescriptor.<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1p1beta1.AssetService/SearchAllIamPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchAllIamPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAllIamPoliciesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable;
  private final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable;
  private final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable;
  private final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAssetServiceStub create(AssetServiceStubSettings settings)
      throws IOException {
    return new GrpcAssetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAssetServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcAssetServiceStub(AssetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAssetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAssetServiceStub(
        AssetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAssetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssetServiceStub(AssetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAssetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAssetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssetServiceStub(
      AssetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchAllResourcesRequest, SearchAllResourcesResponse>
        searchAllResourcesTransportSettings =
            GrpcCallSettings.<SearchAllResourcesRequest, SearchAllResourcesResponse>newBuilder()
                .setMethodDescriptor(searchAllResourcesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SearchAllResourcesRequest>() {
                      @Override
                      public Map<String, String> extract(SearchAllResourcesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("scope", String.valueOf(request.getScope()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
        searchAllIamPoliciesTransportSettings =
            GrpcCallSettings.<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>newBuilder()
                .setMethodDescriptor(searchAllIamPoliciesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SearchAllIamPoliciesRequest>() {
                      @Override
                      public Map<String, String> extract(SearchAllIamPoliciesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("scope", String.valueOf(request.getScope()));
                        return params.build();
                      }
                    })
                .build();

    this.searchAllResourcesCallable =
        callableFactory.createUnaryCallable(
            searchAllResourcesTransportSettings,
            settings.searchAllResourcesSettings(),
            clientContext);
    this.searchAllResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchAllResourcesTransportSettings,
            settings.searchAllResourcesSettings(),
            clientContext);
    this.searchAllIamPoliciesCallable =
        callableFactory.createUnaryCallable(
            searchAllIamPoliciesTransportSettings,
            settings.searchAllIamPoliciesSettings(),
            clientContext);
    this.searchAllIamPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            searchAllIamPoliciesTransportSettings,
            settings.searchAllIamPoliciesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    return searchAllResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    return searchAllResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    return searchAllIamPoliciesCallable;
  }

  @Override
  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    return searchAllIamPoliciesPagedCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
