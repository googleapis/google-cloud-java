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

import static com.google.ads.admanager.v1.BrowserLanguageServiceClient.ListBrowserLanguagesPagedResponse;

import com.google.ads.admanager.v1.BrowserLanguage;
import com.google.ads.admanager.v1.GetBrowserLanguageRequest;
import com.google.ads.admanager.v1.ListBrowserLanguagesRequest;
import com.google.ads.admanager.v1.ListBrowserLanguagesResponse;
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
 * REST stub implementation for the BrowserLanguageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonBrowserLanguageServiceStub extends BrowserLanguageServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBrowserLanguageRequest, BrowserLanguage>
      getBrowserLanguageMethodDescriptor =
          ApiMethodDescriptor.<GetBrowserLanguageRequest, BrowserLanguage>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.BrowserLanguageService/GetBrowserLanguage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBrowserLanguageRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/browserLanguages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBrowserLanguageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBrowserLanguageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BrowserLanguage>newBuilder()
                      .setDefaultInstance(BrowserLanguage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>
      listBrowserLanguagesMethodDescriptor =
          ApiMethodDescriptor
              .<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.BrowserLanguageService/ListBrowserLanguages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBrowserLanguagesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/browserLanguages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBrowserLanguagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBrowserLanguagesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBrowserLanguagesResponse>newBuilder()
                      .setDefaultInstance(ListBrowserLanguagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBrowserLanguageRequest, BrowserLanguage>
      getBrowserLanguageCallable;
  private final UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>
      listBrowserLanguagesCallable;
  private final UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesPagedResponse>
      listBrowserLanguagesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBrowserLanguageServiceStub create(
      BrowserLanguageServiceStubSettings settings) throws IOException {
    return new HttpJsonBrowserLanguageServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBrowserLanguageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBrowserLanguageServiceStub(
        BrowserLanguageServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBrowserLanguageServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBrowserLanguageServiceStub(
        BrowserLanguageServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBrowserLanguageServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBrowserLanguageServiceStub(
      BrowserLanguageServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBrowserLanguageServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBrowserLanguageServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBrowserLanguageServiceStub(
      BrowserLanguageServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBrowserLanguageRequest, BrowserLanguage>
        getBrowserLanguageTransportSettings =
            HttpJsonCallSettings.<GetBrowserLanguageRequest, BrowserLanguage>newBuilder()
                .setMethodDescriptor(getBrowserLanguageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>
        listBrowserLanguagesTransportSettings =
            HttpJsonCallSettings
                .<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>newBuilder()
                .setMethodDescriptor(listBrowserLanguagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getBrowserLanguageCallable =
        callableFactory.createUnaryCallable(
            getBrowserLanguageTransportSettings,
            settings.getBrowserLanguageSettings(),
            clientContext);
    this.listBrowserLanguagesCallable =
        callableFactory.createUnaryCallable(
            listBrowserLanguagesTransportSettings,
            settings.listBrowserLanguagesSettings(),
            clientContext);
    this.listBrowserLanguagesPagedCallable =
        callableFactory.createPagedCallable(
            listBrowserLanguagesTransportSettings,
            settings.listBrowserLanguagesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBrowserLanguageMethodDescriptor);
    methodDescriptors.add(listBrowserLanguagesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBrowserLanguageRequest, BrowserLanguage> getBrowserLanguageCallable() {
    return getBrowserLanguageCallable;
  }

  @Override
  public UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesResponse>
      listBrowserLanguagesCallable() {
    return listBrowserLanguagesCallable;
  }

  @Override
  public UnaryCallable<ListBrowserLanguagesRequest, ListBrowserLanguagesPagedResponse>
      listBrowserLanguagesPagedCallable() {
    return listBrowserLanguagesPagedCallable;
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
