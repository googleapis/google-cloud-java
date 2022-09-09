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

package com.google.cloud.asset.v1p2beta1.stub;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p2beta1.CreateFeedRequest;
import com.google.cloud.asset.v1p2beta1.DeleteFeedRequest;
import com.google.cloud.asset.v1p2beta1.Feed;
import com.google.cloud.asset.v1p2beta1.GetFeedRequest;
import com.google.cloud.asset.v1p2beta1.ListFeedsRequest;
import com.google.cloud.asset.v1p2beta1.ListFeedsResponse;
import com.google.cloud.asset.v1p2beta1.UpdateFeedRequest;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAssetServiceStub extends AssetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateFeedRequest, Feed> createFeedMethodDescriptor =
      ApiMethodDescriptor.<CreateFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.asset.v1p2beta1.AssetService/CreateFeed")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateFeedRequest>newBuilder()
                  .setPath(
                      "/v1p2beta1/{parent=*/*}/feeds",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearParent().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetFeedRequest, Feed> getFeedMethodDescriptor =
      ApiMethodDescriptor.<GetFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.asset.v1p2beta1.AssetService/GetFeed")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFeedRequest>newBuilder()
                  .setPath(
                      "/v1p2beta1/{name=*/*/feeds/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListFeedsRequest, ListFeedsResponse>
      listFeedsMethodDescriptor =
          ApiMethodDescriptor.<ListFeedsRequest, ListFeedsResponse>newBuilder()
              .setFullMethodName("google.cloud.asset.v1p2beta1.AssetService/ListFeeds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeedsRequest>newBuilder()
                      .setPath(
                          "/v1p2beta1/{parent=*/*}/feeds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeedsResponse>newBuilder()
                      .setDefaultInstance(ListFeedsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFeedRequest, Feed> updateFeedMethodDescriptor =
      ApiMethodDescriptor.<UpdateFeedRequest, Feed>newBuilder()
          .setFullMethodName("google.cloud.asset.v1p2beta1.AssetService/UpdateFeed")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateFeedRequest>newBuilder()
                  .setPath(
                      "/v1p2beta1/{feed.name=*/*/feeds/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "feed.name", request.getFeed().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feed>newBuilder()
                  .setDefaultInstance(Feed.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteFeedRequest, Empty> deleteFeedMethodDescriptor =
      ApiMethodDescriptor.<DeleteFeedRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.asset.v1p2beta1.AssetService/DeleteFeed")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteFeedRequest>newBuilder()
                  .setPath(
                      "/v1p2beta1/{name=*/*/feeds/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteFeedRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable;
  private final UnaryCallable<GetFeedRequest, Feed> getFeedCallable;
  private final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable;
  private final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable;
  private final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAssetServiceStub create(AssetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAssetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAssetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAssetServiceStub(
        AssetServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAssetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAssetServiceStub(
        AssetServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAssetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAssetServiceStub(AssetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAssetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAssetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAssetServiceStub(
      AssetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateFeedRequest, Feed> createFeedTransportSettings =
        HttpJsonCallSettings.<CreateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(createFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetFeedRequest, Feed> getFeedTransportSettings =
        HttpJsonCallSettings.<GetFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(getFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsTransportSettings =
        HttpJsonCallSettings.<ListFeedsRequest, ListFeedsResponse>newBuilder()
            .setMethodDescriptor(listFeedsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFeedRequest, Feed> updateFeedTransportSettings =
        HttpJsonCallSettings.<UpdateFeedRequest, Feed>newBuilder()
            .setMethodDescriptor(updateFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFeedRequest, Empty> deleteFeedTransportSettings =
        HttpJsonCallSettings.<DeleteFeedRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createFeedCallable =
        callableFactory.createUnaryCallable(
            createFeedTransportSettings, settings.createFeedSettings(), clientContext);
    this.getFeedCallable =
        callableFactory.createUnaryCallable(
            getFeedTransportSettings, settings.getFeedSettings(), clientContext);
    this.listFeedsCallable =
        callableFactory.createUnaryCallable(
            listFeedsTransportSettings, settings.listFeedsSettings(), clientContext);
    this.updateFeedCallable =
        callableFactory.createUnaryCallable(
            updateFeedTransportSettings, settings.updateFeedSettings(), clientContext);
    this.deleteFeedCallable =
        callableFactory.createUnaryCallable(
            deleteFeedTransportSettings, settings.deleteFeedSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createFeedMethodDescriptor);
    methodDescriptors.add(getFeedMethodDescriptor);
    methodDescriptors.add(listFeedsMethodDescriptor);
    methodDescriptors.add(updateFeedMethodDescriptor);
    methodDescriptors.add(deleteFeedMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    return createFeedCallable;
  }

  @Override
  public UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    return getFeedCallable;
  }

  @Override
  public UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return listFeedsCallable;
  }

  @Override
  public UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return updateFeedCallable;
  }

  @Override
  public UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return deleteFeedCallable;
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
