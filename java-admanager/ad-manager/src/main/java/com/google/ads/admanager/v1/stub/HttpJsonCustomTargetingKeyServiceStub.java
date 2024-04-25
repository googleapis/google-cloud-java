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

import static com.google.ads.admanager.v1.CustomTargetingKeyServiceClient.ListCustomTargetingKeysPagedResponse;

import com.google.ads.admanager.v1.CustomTargetingKey;
import com.google.ads.admanager.v1.GetCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysResponse;
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
 * REST stub implementation for the CustomTargetingKeyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCustomTargetingKeyServiceStub extends CustomTargetingKeyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyMethodDescriptor =
          ApiMethodDescriptor.<GetCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/GetCustomTargetingKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomTargetingKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/customTargetingKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingKey>newBuilder()
                      .setDefaultInstance(CustomTargetingKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/ListCustomTargetingKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomTargetingKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingKeysRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCustomTargetingKeysResponse>newBuilder()
                      .setDefaultInstance(ListCustomTargetingKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable;
  private final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable;
  private final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCustomTargetingKeyServiceStub create(
      CustomTargetingKeyServiceStubSettings settings) throws IOException {
    return new HttpJsonCustomTargetingKeyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCustomTargetingKeyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCustomTargetingKeyServiceStub(
        CustomTargetingKeyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCustomTargetingKeyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCustomTargetingKeyServiceStub(
        CustomTargetingKeyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingKeyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCustomTargetingKeyServiceStub(
      CustomTargetingKeyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCustomTargetingKeyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingKeyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCustomTargetingKeyServiceStub(
      CustomTargetingKeyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCustomTargetingKeyRequest, CustomTargetingKey>
        getCustomTargetingKeyTransportSettings =
            HttpJsonCallSettings.<GetCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
                .setMethodDescriptor(getCustomTargetingKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
        listCustomTargetingKeysTransportSettings =
            HttpJsonCallSettings
                .<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>newBuilder()
                .setMethodDescriptor(listCustomTargetingKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCustomTargetingKeyCallable =
        callableFactory.createUnaryCallable(
            getCustomTargetingKeyTransportSettings,
            settings.getCustomTargetingKeySettings(),
            clientContext);
    this.listCustomTargetingKeysCallable =
        callableFactory.createUnaryCallable(
            listCustomTargetingKeysTransportSettings,
            settings.listCustomTargetingKeysSettings(),
            clientContext);
    this.listCustomTargetingKeysPagedCallable =
        callableFactory.createPagedCallable(
            listCustomTargetingKeysTransportSettings,
            settings.listCustomTargetingKeysSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCustomTargetingKeyMethodDescriptor);
    methodDescriptors.add(listCustomTargetingKeysMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable() {
    return getCustomTargetingKeyCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable() {
    return listCustomTargetingKeysCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable() {
    return listCustomTargetingKeysPagedCallable;
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
