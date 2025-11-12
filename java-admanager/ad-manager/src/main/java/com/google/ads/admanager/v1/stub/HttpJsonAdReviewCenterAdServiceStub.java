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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdReviewCenterAdServiceClient.SearchAdReviewCenterAdsPagedResponse;

import com.google.ads.admanager.v1.BatchAdReviewCenterAdsOperationMetadata;
import com.google.ads.admanager.v1.BatchAllowAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.BatchAllowAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsResponse;
import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the AdReviewCenterAdService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAdReviewCenterAdServiceStub extends AdReviewCenterAdServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BatchBlockAdReviewCenterAdsResponse.getDescriptor())
          .add(BatchAdReviewCenterAdsOperationMetadata.getDescriptor())
          .add(BatchAllowAdReviewCenterAdsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
      searchAdReviewCenterAdsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AdReviewCenterAdService/SearchAdReviewCenterAds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAdReviewCenterAdsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/webProperties/*}/adReviewCenterAds:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAdReviewCenterAdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAdReviewCenterAdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "adReviewCenterAdId", request.getAdReviewCenterAdIdList());
                            serializer.putQueryParam(
                                fields, "buyerAccountId", request.getBuyerAccountIdList());
                            serializer.putQueryParam(
                                fields, "dateTimeRange", request.getDateTimeRange());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "searchText", request.getSearchTextList());
                            serializer.putQueryParam(fields, "status", request.getStatusValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAdReviewCenterAdsResponse>newBuilder()
                      .setDefaultInstance(SearchAdReviewCenterAdsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsMethodDescriptor =
          ApiMethodDescriptor.<BatchAllowAdReviewCenterAdsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AdReviewCenterAdService/BatchAllowAdReviewCenterAds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchAllowAdReviewCenterAdsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/webProperties/*}/adReviewCenterAds:batchAllow",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchAllowAdReviewCenterAdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchAllowAdReviewCenterAdsRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchAllowAdReviewCenterAdsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsMethodDescriptor =
          ApiMethodDescriptor.<BatchBlockAdReviewCenterAdsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AdReviewCenterAdService/BatchBlockAdReviewCenterAds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchBlockAdReviewCenterAdsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/webProperties/*}/adReviewCenterAds:batchBlock",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchBlockAdReviewCenterAdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchBlockAdReviewCenterAdsRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchBlockAdReviewCenterAdsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
      searchAdReviewCenterAdsCallable;
  private final UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsPagedCallable;
  private final UnaryCallable<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsCallable;
  private final OperationCallable<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationCallable;
  private final UnaryCallable<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsCallable;
  private final OperationCallable<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdReviewCenterAdServiceStub create(
      AdReviewCenterAdServiceStubSettings settings) throws IOException {
    return new HttpJsonAdReviewCenterAdServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdReviewCenterAdServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdReviewCenterAdServiceStub(
        AdReviewCenterAdServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdReviewCenterAdServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdReviewCenterAdServiceStub(
        AdReviewCenterAdServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdReviewCenterAdServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdReviewCenterAdServiceStub(
      AdReviewCenterAdServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAdReviewCenterAdServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdReviewCenterAdServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdReviewCenterAdServiceStub(
      AdReviewCenterAdServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=networks/*/operations/reports/runs/*}")
                        .build())
                .build());

    HttpJsonCallSettings<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
        searchAdReviewCenterAdsTransportSettings =
            HttpJsonCallSettings
                .<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>newBuilder()
                .setMethodDescriptor(searchAdReviewCenterAdsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchAllowAdReviewCenterAdsRequest, Operation>
        batchAllowAdReviewCenterAdsTransportSettings =
            HttpJsonCallSettings.<BatchAllowAdReviewCenterAdsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchAllowAdReviewCenterAdsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchBlockAdReviewCenterAdsRequest, Operation>
        batchBlockAdReviewCenterAdsTransportSettings =
            HttpJsonCallSettings.<BatchBlockAdReviewCenterAdsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchBlockAdReviewCenterAdsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.searchAdReviewCenterAdsCallable =
        callableFactory.createUnaryCallable(
            searchAdReviewCenterAdsTransportSettings,
            settings.searchAdReviewCenterAdsSettings(),
            clientContext);
    this.searchAdReviewCenterAdsPagedCallable =
        callableFactory.createPagedCallable(
            searchAdReviewCenterAdsTransportSettings,
            settings.searchAdReviewCenterAdsSettings(),
            clientContext);
    this.batchAllowAdReviewCenterAdsCallable =
        callableFactory.createUnaryCallable(
            batchAllowAdReviewCenterAdsTransportSettings,
            settings.batchAllowAdReviewCenterAdsSettings(),
            clientContext);
    this.batchAllowAdReviewCenterAdsOperationCallable =
        callableFactory.createOperationCallable(
            batchAllowAdReviewCenterAdsTransportSettings,
            settings.batchAllowAdReviewCenterAdsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchBlockAdReviewCenterAdsCallable =
        callableFactory.createUnaryCallable(
            batchBlockAdReviewCenterAdsTransportSettings,
            settings.batchBlockAdReviewCenterAdsSettings(),
            clientContext);
    this.batchBlockAdReviewCenterAdsOperationCallable =
        callableFactory.createOperationCallable(
            batchBlockAdReviewCenterAdsTransportSettings,
            settings.batchBlockAdReviewCenterAdsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(searchAdReviewCenterAdsMethodDescriptor);
    methodDescriptors.add(batchAllowAdReviewCenterAdsMethodDescriptor);
    methodDescriptors.add(batchBlockAdReviewCenterAdsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
      searchAdReviewCenterAdsCallable() {
    return searchAdReviewCenterAdsCallable;
  }

  @Override
  public UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsPagedCallable() {
    return searchAdReviewCenterAdsPagedCallable;
  }

  @Override
  public UnaryCallable<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsCallable() {
    return batchAllowAdReviewCenterAdsCallable;
  }

  @Override
  public OperationCallable<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationCallable() {
    return batchAllowAdReviewCenterAdsOperationCallable;
  }

  @Override
  public UnaryCallable<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsCallable() {
    return batchBlockAdReviewCenterAdsCallable;
  }

  @Override
  public OperationCallable<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationCallable() {
    return batchBlockAdReviewCenterAdsOperationCallable;
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
