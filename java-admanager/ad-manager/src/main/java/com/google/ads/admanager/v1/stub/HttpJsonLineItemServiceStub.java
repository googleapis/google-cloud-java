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

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.GetLineItemRequest;
import com.google.ads.admanager.v1.LineItem;
import com.google.ads.admanager.v1.ListLineItemsRequest;
import com.google.ads.admanager.v1.ListLineItemsResponse;
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
 * REST stub implementation for the LineItemService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLineItemServiceStub extends LineItemServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLineItemRequest, LineItem>
      getLineItemMethodDescriptor =
          ApiMethodDescriptor.<GetLineItemRequest, LineItem>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/GetLineItem")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLineItemRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/orders/*/lineItems/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItem>newBuilder()
                      .setDefaultInstance(LineItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLineItemsRequest, ListLineItemsResponse>
      listLineItemsMethodDescriptor =
          ApiMethodDescriptor.<ListLineItemsRequest, ListLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/ListLineItems")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*/orders/*}/lineItems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLineItemsResponse>newBuilder()
                      .setDefaultInstance(ListLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable;
  private final UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable;
  private final UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLineItemServiceStub create(LineItemServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLineItemServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLineItemServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLineItemServiceStub(
        LineItemServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLineItemServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLineItemServiceStub(
        LineItemServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLineItemServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLineItemServiceStub(
      LineItemServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLineItemServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLineItemServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLineItemServiceStub(
      LineItemServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLineItemRequest, LineItem> getLineItemTransportSettings =
        HttpJsonCallSettings.<GetLineItemRequest, LineItem>newBuilder()
            .setMethodDescriptor(getLineItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLineItemsRequest, ListLineItemsResponse>
        listLineItemsTransportSettings =
            HttpJsonCallSettings.<ListLineItemsRequest, ListLineItemsResponse>newBuilder()
                .setMethodDescriptor(listLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getLineItemCallable =
        callableFactory.createUnaryCallable(
            getLineItemTransportSettings, settings.getLineItemSettings(), clientContext);
    this.listLineItemsCallable =
        callableFactory.createUnaryCallable(
            listLineItemsTransportSettings, settings.listLineItemsSettings(), clientContext);
    this.listLineItemsPagedCallable =
        callableFactory.createPagedCallable(
            listLineItemsTransportSettings, settings.listLineItemsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLineItemMethodDescriptor);
    methodDescriptors.add(listLineItemsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable() {
    return getLineItemCallable;
  }

  @Override
  public UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable() {
    return listLineItemsCallable;
  }

  @Override
  public UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable() {
    return listLineItemsPagedCallable;
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
