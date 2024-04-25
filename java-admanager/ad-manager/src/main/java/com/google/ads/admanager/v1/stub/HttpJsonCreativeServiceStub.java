/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.CreativeServiceClient.ListCreativesPagedResponse;

import com.google.ads.admanager.v1.Creative;
import com.google.ads.admanager.v1.GetCreativeRequest;
import com.google.ads.admanager.v1.ListCreativesRequest;
import com.google.ads.admanager.v1.ListCreativesResponse;
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
 * REST stub implementation for the CreativeService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCreativeServiceStub extends CreativeServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCreativeRequest, Creative>
      getCreativeMethodDescriptor =
          ApiMethodDescriptor.<GetCreativeRequest, Creative>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CreativeService/GetCreative")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCreativeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/creatives/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Creative>newBuilder()
                      .setDefaultInstance(Creative.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCreativesRequest, ListCreativesResponse>
      listCreativesMethodDescriptor =
          ApiMethodDescriptor.<ListCreativesRequest, ListCreativesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CreativeService/ListCreatives")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCreativesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creatives",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCreativesResponse>newBuilder()
                      .setDefaultInstance(ListCreativesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCreativeRequest, Creative> getCreativeCallable;
  private final UnaryCallable<ListCreativesRequest, ListCreativesResponse> listCreativesCallable;
  private final UnaryCallable<ListCreativesRequest, ListCreativesPagedResponse>
      listCreativesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCreativeServiceStub create(CreativeServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCreativeServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCreativeServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCreativeServiceStub(
        CreativeServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCreativeServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCreativeServiceStub(
        CreativeServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCreativeServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeServiceStub(
      CreativeServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCreativeServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCreativeServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeServiceStub(
      CreativeServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCreativeRequest, Creative> getCreativeTransportSettings =
        HttpJsonCallSettings.<GetCreativeRequest, Creative>newBuilder()
            .setMethodDescriptor(getCreativeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCreativesRequest, ListCreativesResponse>
        listCreativesTransportSettings =
            HttpJsonCallSettings.<ListCreativesRequest, ListCreativesResponse>newBuilder()
                .setMethodDescriptor(listCreativesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCreativeCallable =
        callableFactory.createUnaryCallable(
            getCreativeTransportSettings, settings.getCreativeSettings(), clientContext);
    this.listCreativesCallable =
        callableFactory.createUnaryCallable(
            listCreativesTransportSettings, settings.listCreativesSettings(), clientContext);
    this.listCreativesPagedCallable =
        callableFactory.createPagedCallable(
            listCreativesTransportSettings, settings.listCreativesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCreativeMethodDescriptor);
    methodDescriptors.add(listCreativesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCreativeRequest, Creative> getCreativeCallable() {
    return getCreativeCallable;
  }

  @Override
  public UnaryCallable<ListCreativesRequest, ListCreativesResponse> listCreativesCallable() {
    return listCreativesCallable;
  }

  @Override
  public UnaryCallable<ListCreativesRequest, ListCreativesPagedResponse>
      listCreativesPagedCallable() {
    return listCreativesPagedCallable;
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
