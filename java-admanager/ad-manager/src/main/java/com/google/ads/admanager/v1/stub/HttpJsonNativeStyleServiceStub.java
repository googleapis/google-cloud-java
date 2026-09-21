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

import static com.google.ads.admanager.v1.NativeStyleServiceClient.ListNativeStylesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchActivateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchArchiveNativeStylesRequest;
import com.google.ads.admanager.v1.BatchArchiveNativeStylesResponse;
import com.google.ads.admanager.v1.BatchCreateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchCreateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchDeactivateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchDeactivateNativeStylesResponse;
import com.google.ads.admanager.v1.BatchUpdateNativeStylesRequest;
import com.google.ads.admanager.v1.BatchUpdateNativeStylesResponse;
import com.google.ads.admanager.v1.GetNativeStyleRequest;
import com.google.ads.admanager.v1.ListNativeStylesRequest;
import com.google.ads.admanager.v1.ListNativeStylesResponse;
import com.google.ads.admanager.v1.NativeStyle;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the NativeStyleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonNativeStyleServiceStub extends NativeStyleServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetNativeStyleRequest, NativeStyle>
      getNativeStyleMethodDescriptor =
          ApiMethodDescriptor.<GetNativeStyleRequest, NativeStyle>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.NativeStyleService/GetNativeStyle")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNativeStyleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/nativeStyles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNativeStyleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNativeStyleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NativeStyle>newBuilder()
                      .setDefaultInstance(NativeStyle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNativeStylesRequest, ListNativeStylesResponse>
      listNativeStylesMethodDescriptor =
          ApiMethodDescriptor.<ListNativeStylesRequest, ListNativeStylesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.NativeStyleService/ListNativeStyles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNativeStylesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/nativeStyles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNativeStylesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNativeStylesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListNativeStylesResponse>newBuilder()
                      .setDefaultInstance(ListNativeStylesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.NativeStyleService/BatchCreateNativeStyles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateNativeStylesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/nativeStyles:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateNativeStylesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateNativeStylesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateNativeStylesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateNativeStylesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.NativeStyleService/BatchUpdateNativeStyles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateNativeStylesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/nativeStyles:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateNativeStylesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateNativeStylesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateNativeStylesResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateNativeStylesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.NativeStyleService/BatchActivateNativeStyles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateNativeStylesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/nativeStyles:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateNativeStylesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateNativeStylesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateNativeStylesResponse>newBuilder()
                      .setDefaultInstance(BatchActivateNativeStylesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.NativeStyleService/BatchDeactivateNativeStyles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateNativeStylesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/nativeStyles:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateNativeStylesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateNativeStylesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateNativeStylesResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateNativeStylesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.NativeStyleService/BatchArchiveNativeStyles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveNativeStylesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/nativeStyles:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveNativeStylesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveNativeStylesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveNativeStylesResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveNativeStylesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetNativeStyleRequest, NativeStyle> getNativeStyleCallable;
  private final UnaryCallable<ListNativeStylesRequest, ListNativeStylesResponse>
      listNativeStylesCallable;
  private final UnaryCallable<ListNativeStylesRequest, ListNativeStylesPagedResponse>
      listNativeStylesPagedCallable;
  private final UnaryCallable<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesCallable;
  private final UnaryCallable<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesCallable;
  private final UnaryCallable<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesCallable;
  private final UnaryCallable<
          BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesCallable;
  private final UnaryCallable<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNativeStyleServiceStub create(NativeStyleServiceStubSettings settings)
      throws IOException {
    return new HttpJsonNativeStyleServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNativeStyleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNativeStyleServiceStub(
        NativeStyleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNativeStyleServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNativeStyleServiceStub(
        NativeStyleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNativeStyleServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNativeStyleServiceStub(
      NativeStyleServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNativeStyleServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNativeStyleServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNativeStyleServiceStub(
      NativeStyleServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetNativeStyleRequest, NativeStyle> getNativeStyleTransportSettings =
        HttpJsonCallSettings.<GetNativeStyleRequest, NativeStyle>newBuilder()
            .setMethodDescriptor(getNativeStyleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListNativeStylesRequest, ListNativeStylesResponse>
        listNativeStylesTransportSettings =
            HttpJsonCallSettings.<ListNativeStylesRequest, ListNativeStylesResponse>newBuilder()
                .setMethodDescriptor(listNativeStylesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
        batchCreateNativeStylesTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>newBuilder()
                .setMethodDescriptor(batchCreateNativeStylesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
        batchUpdateNativeStylesTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateNativeStylesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
        batchActivateNativeStylesTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>newBuilder()
                .setMethodDescriptor(batchActivateNativeStylesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
        batchDeactivateNativeStylesTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateNativeStylesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
        batchArchiveNativeStylesTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>newBuilder()
                .setMethodDescriptor(batchArchiveNativeStylesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getNativeStyleCallable =
        callableFactory.createUnaryCallable(
            getNativeStyleTransportSettings, settings.getNativeStyleSettings(), clientContext);
    this.listNativeStylesCallable =
        callableFactory.createUnaryCallable(
            listNativeStylesTransportSettings, settings.listNativeStylesSettings(), clientContext);
    this.listNativeStylesPagedCallable =
        callableFactory.createPagedCallable(
            listNativeStylesTransportSettings, settings.listNativeStylesSettings(), clientContext);
    this.batchCreateNativeStylesCallable =
        callableFactory.createUnaryCallable(
            batchCreateNativeStylesTransportSettings,
            settings.batchCreateNativeStylesSettings(),
            clientContext);
    this.batchUpdateNativeStylesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateNativeStylesTransportSettings,
            settings.batchUpdateNativeStylesSettings(),
            clientContext);
    this.batchActivateNativeStylesCallable =
        callableFactory.createUnaryCallable(
            batchActivateNativeStylesTransportSettings,
            settings.batchActivateNativeStylesSettings(),
            clientContext);
    this.batchDeactivateNativeStylesCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateNativeStylesTransportSettings,
            settings.batchDeactivateNativeStylesSettings(),
            clientContext);
    this.batchArchiveNativeStylesCallable =
        callableFactory.createUnaryCallable(
            batchArchiveNativeStylesTransportSettings,
            settings.batchArchiveNativeStylesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getNativeStyleMethodDescriptor);
    methodDescriptors.add(listNativeStylesMethodDescriptor);
    methodDescriptors.add(batchCreateNativeStylesMethodDescriptor);
    methodDescriptors.add(batchUpdateNativeStylesMethodDescriptor);
    methodDescriptors.add(batchActivateNativeStylesMethodDescriptor);
    methodDescriptors.add(batchDeactivateNativeStylesMethodDescriptor);
    methodDescriptors.add(batchArchiveNativeStylesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetNativeStyleRequest, NativeStyle> getNativeStyleCallable() {
    return getNativeStyleCallable;
  }

  @Override
  public UnaryCallable<ListNativeStylesRequest, ListNativeStylesResponse>
      listNativeStylesCallable() {
    return listNativeStylesCallable;
  }

  @Override
  public UnaryCallable<ListNativeStylesRequest, ListNativeStylesPagedResponse>
      listNativeStylesPagedCallable() {
    return listNativeStylesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchCreateNativeStylesRequest, BatchCreateNativeStylesResponse>
      batchCreateNativeStylesCallable() {
    return batchCreateNativeStylesCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateNativeStylesRequest, BatchUpdateNativeStylesResponse>
      batchUpdateNativeStylesCallable() {
    return batchUpdateNativeStylesCallable;
  }

  @Override
  public UnaryCallable<BatchActivateNativeStylesRequest, BatchActivateNativeStylesResponse>
      batchActivateNativeStylesCallable() {
    return batchActivateNativeStylesCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateNativeStylesRequest, BatchDeactivateNativeStylesResponse>
      batchDeactivateNativeStylesCallable() {
    return batchDeactivateNativeStylesCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveNativeStylesRequest, BatchArchiveNativeStylesResponse>
      batchArchiveNativeStylesCallable() {
    return batchArchiveNativeStylesCallable;
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
