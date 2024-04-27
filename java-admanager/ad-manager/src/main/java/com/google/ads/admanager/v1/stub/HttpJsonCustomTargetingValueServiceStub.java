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

import static com.google.ads.admanager.v1.CustomTargetingValueServiceClient.ListCustomTargetingValuesPagedResponse;

import com.google.ads.admanager.v1.CustomTargetingValue;
import com.google.ads.admanager.v1.GetCustomTargetingValueRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesResponse;
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
 * REST stub implementation for the CustomTargetingValueService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCustomTargetingValueServiceStub extends CustomTargetingValueServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueMethodDescriptor =
          ApiMethodDescriptor.<GetCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/GetCustomTargetingValue")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomTargetingValueRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/customTargetingKeys/*/customTargetingValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingValue>newBuilder()
                      .setDefaultInstance(CustomTargetingValue.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/ListCustomTargetingValues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomTargetingValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/customTargetingKeys/*}/customTargetingValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingValuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingValuesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCustomTargetingValuesResponse>newBuilder()
                      .setDefaultInstance(ListCustomTargetingValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable;
  private final UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable;
  private final UnaryCallable<
          ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCustomTargetingValueServiceStub create(
      CustomTargetingValueServiceStubSettings settings) throws IOException {
    return new HttpJsonCustomTargetingValueServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCustomTargetingValueServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCustomTargetingValueServiceStub(
        CustomTargetingValueServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCustomTargetingValueServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCustomTargetingValueServiceStub(
        CustomTargetingValueServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingValueServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCustomTargetingValueServiceStub(
      CustomTargetingValueServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCustomTargetingValueServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingValueServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCustomTargetingValueServiceStub(
      CustomTargetingValueServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCustomTargetingValueRequest, CustomTargetingValue>
        getCustomTargetingValueTransportSettings =
            HttpJsonCallSettings.<GetCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
                .setMethodDescriptor(getCustomTargetingValueMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
        listCustomTargetingValuesTransportSettings =
            HttpJsonCallSettings
                .<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>newBuilder()
                .setMethodDescriptor(listCustomTargetingValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCustomTargetingValueCallable =
        callableFactory.createUnaryCallable(
            getCustomTargetingValueTransportSettings,
            settings.getCustomTargetingValueSettings(),
            clientContext);
    this.listCustomTargetingValuesCallable =
        callableFactory.createUnaryCallable(
            listCustomTargetingValuesTransportSettings,
            settings.listCustomTargetingValuesSettings(),
            clientContext);
    this.listCustomTargetingValuesPagedCallable =
        callableFactory.createPagedCallable(
            listCustomTargetingValuesTransportSettings,
            settings.listCustomTargetingValuesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCustomTargetingValueMethodDescriptor);
    methodDescriptors.add(listCustomTargetingValuesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable() {
    return getCustomTargetingValueCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable() {
    return listCustomTargetingValuesCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable() {
    return listCustomTargetingValuesPagedCallable;
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
