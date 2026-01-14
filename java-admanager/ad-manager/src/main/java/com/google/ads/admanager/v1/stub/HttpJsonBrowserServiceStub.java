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

import static com.google.ads.admanager.v1.BrowserServiceClient.ListBrowsersPagedResponse;

import com.google.ads.admanager.v1.Browser;
import com.google.ads.admanager.v1.GetBrowserRequest;
import com.google.ads.admanager.v1.ListBrowsersRequest;
import com.google.ads.admanager.v1.ListBrowsersResponse;
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
 * REST stub implementation for the BrowserService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonBrowserServiceStub extends BrowserServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBrowserRequest, Browser> getBrowserMethodDescriptor =
      ApiMethodDescriptor.<GetBrowserRequest, Browser>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.BrowserService/GetBrowser")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBrowserRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/browsers/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBrowserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBrowserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Browser>newBuilder()
                  .setDefaultInstance(Browser.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBrowsersRequest, ListBrowsersResponse>
      listBrowsersMethodDescriptor =
          ApiMethodDescriptor.<ListBrowsersRequest, ListBrowsersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.BrowserService/ListBrowsers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBrowsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/browsers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBrowsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBrowsersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBrowsersResponse>newBuilder()
                      .setDefaultInstance(ListBrowsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBrowserRequest, Browser> getBrowserCallable;
  private final UnaryCallable<ListBrowsersRequest, ListBrowsersResponse> listBrowsersCallable;
  private final UnaryCallable<ListBrowsersRequest, ListBrowsersPagedResponse>
      listBrowsersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBrowserServiceStub create(BrowserServiceStubSettings settings)
      throws IOException {
    return new HttpJsonBrowserServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBrowserServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBrowserServiceStub(
        BrowserServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBrowserServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBrowserServiceStub(
        BrowserServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBrowserServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBrowserServiceStub(
      BrowserServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBrowserServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBrowserServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBrowserServiceStub(
      BrowserServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBrowserRequest, Browser> getBrowserTransportSettings =
        HttpJsonCallSettings.<GetBrowserRequest, Browser>newBuilder()
            .setMethodDescriptor(getBrowserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBrowsersRequest, ListBrowsersResponse> listBrowsersTransportSettings =
        HttpJsonCallSettings.<ListBrowsersRequest, ListBrowsersResponse>newBuilder()
            .setMethodDescriptor(listBrowsersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getBrowserCallable =
        callableFactory.createUnaryCallable(
            getBrowserTransportSettings, settings.getBrowserSettings(), clientContext);
    this.listBrowsersCallable =
        callableFactory.createUnaryCallable(
            listBrowsersTransportSettings, settings.listBrowsersSettings(), clientContext);
    this.listBrowsersPagedCallable =
        callableFactory.createPagedCallable(
            listBrowsersTransportSettings, settings.listBrowsersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBrowserMethodDescriptor);
    methodDescriptors.add(listBrowsersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBrowserRequest, Browser> getBrowserCallable() {
    return getBrowserCallable;
  }

  @Override
  public UnaryCallable<ListBrowsersRequest, ListBrowsersResponse> listBrowsersCallable() {
    return listBrowsersCallable;
  }

  @Override
  public UnaryCallable<ListBrowsersRequest, ListBrowsersPagedResponse> listBrowsersPagedCallable() {
    return listBrowsersPagedCallable;
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
