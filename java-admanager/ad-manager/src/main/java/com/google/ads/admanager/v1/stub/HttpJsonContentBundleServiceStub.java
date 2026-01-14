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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ContentBundleServiceClient.ListContentBundlesPagedResponse;

import com.google.ads.admanager.v1.ContentBundle;
import com.google.ads.admanager.v1.GetContentBundleRequest;
import com.google.ads.admanager.v1.ListContentBundlesRequest;
import com.google.ads.admanager.v1.ListContentBundlesResponse;
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
 * REST stub implementation for the ContentBundleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonContentBundleServiceStub extends ContentBundleServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetContentBundleRequest, ContentBundle>
      getContentBundleMethodDescriptor =
          ApiMethodDescriptor.<GetContentBundleRequest, ContentBundle>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ContentBundleService/GetContentBundle")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetContentBundleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/contentBundles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetContentBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetContentBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ContentBundle>newBuilder()
                      .setDefaultInstance(ContentBundle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListContentBundlesRequest, ListContentBundlesResponse>
      listContentBundlesMethodDescriptor =
          ApiMethodDescriptor.<ListContentBundlesRequest, ListContentBundlesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ContentBundleService/ListContentBundles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListContentBundlesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/contentBundles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListContentBundlesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListContentBundlesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListContentBundlesResponse>newBuilder()
                      .setDefaultInstance(ListContentBundlesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetContentBundleRequest, ContentBundle> getContentBundleCallable;
  private final UnaryCallable<ListContentBundlesRequest, ListContentBundlesResponse>
      listContentBundlesCallable;
  private final UnaryCallable<ListContentBundlesRequest, ListContentBundlesPagedResponse>
      listContentBundlesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonContentBundleServiceStub create(
      ContentBundleServiceStubSettings settings) throws IOException {
    return new HttpJsonContentBundleServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonContentBundleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonContentBundleServiceStub(
        ContentBundleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonContentBundleServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonContentBundleServiceStub(
        ContentBundleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonContentBundleServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContentBundleServiceStub(
      ContentBundleServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonContentBundleServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonContentBundleServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContentBundleServiceStub(
      ContentBundleServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetContentBundleRequest, ContentBundle> getContentBundleTransportSettings =
        HttpJsonCallSettings.<GetContentBundleRequest, ContentBundle>newBuilder()
            .setMethodDescriptor(getContentBundleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListContentBundlesRequest, ListContentBundlesResponse>
        listContentBundlesTransportSettings =
            HttpJsonCallSettings.<ListContentBundlesRequest, ListContentBundlesResponse>newBuilder()
                .setMethodDescriptor(listContentBundlesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getContentBundleCallable =
        callableFactory.createUnaryCallable(
            getContentBundleTransportSettings, settings.getContentBundleSettings(), clientContext);
    this.listContentBundlesCallable =
        callableFactory.createUnaryCallable(
            listContentBundlesTransportSettings,
            settings.listContentBundlesSettings(),
            clientContext);
    this.listContentBundlesPagedCallable =
        callableFactory.createPagedCallable(
            listContentBundlesTransportSettings,
            settings.listContentBundlesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getContentBundleMethodDescriptor);
    methodDescriptors.add(listContentBundlesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetContentBundleRequest, ContentBundle> getContentBundleCallable() {
    return getContentBundleCallable;
  }

  @Override
  public UnaryCallable<ListContentBundlesRequest, ListContentBundlesResponse>
      listContentBundlesCallable() {
    return listContentBundlesCallable;
  }

  @Override
  public UnaryCallable<ListContentBundlesRequest, ListContentBundlesPagedResponse>
      listContentBundlesPagedCallable() {
    return listContentBundlesPagedCallable;
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
