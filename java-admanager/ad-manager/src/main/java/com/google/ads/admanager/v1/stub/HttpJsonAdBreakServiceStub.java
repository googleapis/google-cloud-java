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

import static com.google.ads.admanager.v1.AdBreakServiceClient.ListAdBreaksPagedResponse;

import com.google.ads.admanager.v1.AdBreak;
import com.google.ads.admanager.v1.CreateAdBreakRequest;
import com.google.ads.admanager.v1.DeleteAdBreakRequest;
import com.google.ads.admanager.v1.GetAdBreakRequest;
import com.google.ads.admanager.v1.ListAdBreaksRequest;
import com.google.ads.admanager.v1.ListAdBreaksResponse;
import com.google.ads.admanager.v1.UpdateAdBreakRequest;
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
 * REST stub implementation for the AdBreakService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAdBreakServiceStub extends AdBreakServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAdBreakRequest, AdBreak> getAdBreakMethodDescriptor =
      ApiMethodDescriptor.<GetAdBreakRequest, AdBreak>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.AdBreakService/GetAdBreak")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAdBreakRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/liveStreamEventsByAssetKey/*/adBreaks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdBreakRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=networks/*/liveStreamEventsByCustomAssetKey/*/adBreaks/*}",
                      "/v1/{name=networks/*/liveStreamEvents/*/adBreaks/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdBreakRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AdBreak>newBuilder()
                  .setDefaultInstance(AdBreak.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAdBreaksRequest, ListAdBreaksResponse>
      listAdBreaksMethodDescriptor =
          ApiMethodDescriptor.<ListAdBreaksRequest, ListAdBreaksResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdBreakService/ListAdBreaks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdBreaksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/liveStreamEventsByAssetKey/*}/adBreaks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdBreaksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=networks/*/liveStreamEventsByCustomAssetKey/*}/adBreaks",
                          "/v1/{parent=networks/*/liveStreamEvents/*}/adBreaks")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdBreaksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdBreaksResponse>newBuilder()
                      .setDefaultInstance(ListAdBreaksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdBreakRequest, AdBreak>
      createAdBreakMethodDescriptor =
          ApiMethodDescriptor.<CreateAdBreakRequest, AdBreak>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdBreakService/CreateAdBreak")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdBreakRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/liveStreamEventsByAssetKey/*}/adBreaks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdBreakRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=networks/*/liveStreamEventsByCustomAssetKey/*}/adBreaks",
                          "/v1/{parent=networks/*/liveStreamEvents/*}/adBreaks")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdBreakRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adBreak", request.getAdBreak(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdBreak>newBuilder()
                      .setDefaultInstance(AdBreak.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAdBreakRequest, AdBreak>
      updateAdBreakMethodDescriptor =
          ApiMethodDescriptor.<UpdateAdBreakRequest, AdBreak>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdBreakService/UpdateAdBreak")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAdBreakRequest>newBuilder()
                      .setPath(
                          "/v1/{adBreak.name=networks/*/liveStreamEventsByAssetKey/*/adBreaks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdBreakRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "adBreak.name", request.getAdBreak().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdBreakRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adBreak", request.getAdBreak(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdBreak>newBuilder()
                      .setDefaultInstance(AdBreak.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAdBreakRequest, Empty>
      deleteAdBreakMethodDescriptor =
          ApiMethodDescriptor.<DeleteAdBreakRequest, Empty>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdBreakService/DeleteAdBreak")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAdBreakRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/liveStreamEventsByAssetKey/*/adBreaks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdBreakRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdBreakRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private final UnaryCallable<GetAdBreakRequest, AdBreak> getAdBreakCallable;
  private final UnaryCallable<ListAdBreaksRequest, ListAdBreaksResponse> listAdBreaksCallable;
  private final UnaryCallable<ListAdBreaksRequest, ListAdBreaksPagedResponse>
      listAdBreaksPagedCallable;
  private final UnaryCallable<CreateAdBreakRequest, AdBreak> createAdBreakCallable;
  private final UnaryCallable<UpdateAdBreakRequest, AdBreak> updateAdBreakCallable;
  private final UnaryCallable<DeleteAdBreakRequest, Empty> deleteAdBreakCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdBreakServiceStub create(AdBreakServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAdBreakServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdBreakServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdBreakServiceStub(
        AdBreakServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdBreakServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdBreakServiceStub(
        AdBreakServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdBreakServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdBreakServiceStub(
      AdBreakServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAdBreakServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdBreakServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdBreakServiceStub(
      AdBreakServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAdBreakRequest, AdBreak> getAdBreakTransportSettings =
        HttpJsonCallSettings.<GetAdBreakRequest, AdBreak>newBuilder()
            .setMethodDescriptor(getAdBreakMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAdBreaksRequest, ListAdBreaksResponse> listAdBreaksTransportSettings =
        HttpJsonCallSettings.<ListAdBreaksRequest, ListAdBreaksResponse>newBuilder()
            .setMethodDescriptor(listAdBreaksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAdBreakRequest, AdBreak> createAdBreakTransportSettings =
        HttpJsonCallSettings.<CreateAdBreakRequest, AdBreak>newBuilder()
            .setMethodDescriptor(createAdBreakMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAdBreakRequest, AdBreak> updateAdBreakTransportSettings =
        HttpJsonCallSettings.<UpdateAdBreakRequest, AdBreak>newBuilder()
            .setMethodDescriptor(updateAdBreakMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("ad_break.name", String.valueOf(request.getAdBreak().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAdBreakRequest, Empty> deleteAdBreakTransportSettings =
        HttpJsonCallSettings.<DeleteAdBreakRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAdBreakMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getAdBreakCallable =
        callableFactory.createUnaryCallable(
            getAdBreakTransportSettings, settings.getAdBreakSettings(), clientContext);
    this.listAdBreaksCallable =
        callableFactory.createUnaryCallable(
            listAdBreaksTransportSettings, settings.listAdBreaksSettings(), clientContext);
    this.listAdBreaksPagedCallable =
        callableFactory.createPagedCallable(
            listAdBreaksTransportSettings, settings.listAdBreaksSettings(), clientContext);
    this.createAdBreakCallable =
        callableFactory.createUnaryCallable(
            createAdBreakTransportSettings, settings.createAdBreakSettings(), clientContext);
    this.updateAdBreakCallable =
        callableFactory.createUnaryCallable(
            updateAdBreakTransportSettings, settings.updateAdBreakSettings(), clientContext);
    this.deleteAdBreakCallable =
        callableFactory.createUnaryCallable(
            deleteAdBreakTransportSettings, settings.deleteAdBreakSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAdBreakMethodDescriptor);
    methodDescriptors.add(listAdBreaksMethodDescriptor);
    methodDescriptors.add(createAdBreakMethodDescriptor);
    methodDescriptors.add(updateAdBreakMethodDescriptor);
    methodDescriptors.add(deleteAdBreakMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAdBreakRequest, AdBreak> getAdBreakCallable() {
    return getAdBreakCallable;
  }

  @Override
  public UnaryCallable<ListAdBreaksRequest, ListAdBreaksResponse> listAdBreaksCallable() {
    return listAdBreaksCallable;
  }

  @Override
  public UnaryCallable<ListAdBreaksRequest, ListAdBreaksPagedResponse> listAdBreaksPagedCallable() {
    return listAdBreaksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAdBreakRequest, AdBreak> createAdBreakCallable() {
    return createAdBreakCallable;
  }

  @Override
  public UnaryCallable<UpdateAdBreakRequest, AdBreak> updateAdBreakCallable() {
    return updateAdBreakCallable;
  }

  @Override
  public UnaryCallable<DeleteAdBreakRequest, Empty> deleteAdBreakCallable() {
    return deleteAdBreakCallable;
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
