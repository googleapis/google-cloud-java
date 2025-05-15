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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.FeedServiceClient.ShowFeedPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.ShowFeedRequest;
import com.google.cloud.support.v2beta.ShowFeedResponse;
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
 * REST stub implementation for the FeedService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonFeedServiceStub extends FeedServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ShowFeedRequest, ShowFeedResponse>
      showFeedMethodDescriptor =
          ApiMethodDescriptor.<ShowFeedRequest, ShowFeedResponse>newBuilder()
              .setFullMethodName("google.cloud.support.v2beta.FeedService/ShowFeed")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ShowFeedRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/cases/*}:showFeed",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ShowFeedRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2beta/{parent=organizations/*/cases/*}:showFeed")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ShowFeedRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShowFeedResponse>newBuilder()
                      .setDefaultInstance(ShowFeedResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ShowFeedRequest, ShowFeedResponse> showFeedCallable;
  private final UnaryCallable<ShowFeedRequest, ShowFeedPagedResponse> showFeedPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFeedServiceStub create(FeedServiceStubSettings settings)
      throws IOException {
    return new HttpJsonFeedServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFeedServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFeedServiceStub(
        FeedServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFeedServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFeedServiceStub(
        FeedServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFeedServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFeedServiceStub(FeedServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFeedServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFeedServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFeedServiceStub(
      FeedServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ShowFeedRequest, ShowFeedResponse> showFeedTransportSettings =
        HttpJsonCallSettings.<ShowFeedRequest, ShowFeedResponse>newBuilder()
            .setMethodDescriptor(showFeedMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.showFeedCallable =
        callableFactory.createUnaryCallable(
            showFeedTransportSettings, settings.showFeedSettings(), clientContext);
    this.showFeedPagedCallable =
        callableFactory.createPagedCallable(
            showFeedTransportSettings, settings.showFeedSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(showFeedMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ShowFeedRequest, ShowFeedResponse> showFeedCallable() {
    return showFeedCallable;
  }

  @Override
  public UnaryCallable<ShowFeedRequest, ShowFeedPagedResponse> showFeedPagedCallable() {
    return showFeedPagedCallable;
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
