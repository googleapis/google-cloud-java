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

import static com.google.ads.admanager.v1.OrderServiceClient.ListOrdersPagedResponse;

import com.google.ads.admanager.v1.GetOrderRequest;
import com.google.ads.admanager.v1.ListOrdersRequest;
import com.google.ads.admanager.v1.ListOrdersResponse;
import com.google.ads.admanager.v1.Order;
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
 * REST stub implementation for the OrderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonOrderServiceStub extends OrderServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOrderRequest, Order> getOrderMethodDescriptor =
      ApiMethodDescriptor.<GetOrderRequest, Order>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.OrderService/GetOrder")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetOrderRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/orders/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetOrderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetOrderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Order>newBuilder()
                  .setDefaultInstance(Order.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListOrdersRequest, ListOrdersResponse>
      listOrdersMethodDescriptor =
          ApiMethodDescriptor.<ListOrdersRequest, ListOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/ListOrders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrdersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOrdersResponse>newBuilder()
                      .setDefaultInstance(ListOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOrderRequest, Order> getOrderCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOrderServiceStub create(OrderServiceStubSettings settings)
      throws IOException {
    return new HttpJsonOrderServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOrderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOrderServiceStub(
        OrderServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonOrderServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOrderServiceStub(
        OrderServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOrderServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonOrderServiceStub(OrderServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOrderServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOrderServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonOrderServiceStub(
      OrderServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOrderRequest, Order> getOrderTransportSettings =
        HttpJsonCallSettings.<GetOrderRequest, Order>newBuilder()
            .setMethodDescriptor(getOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListOrdersRequest, ListOrdersResponse> listOrdersTransportSettings =
        HttpJsonCallSettings.<ListOrdersRequest, ListOrdersResponse>newBuilder()
            .setMethodDescriptor(listOrdersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getOrderCallable =
        callableFactory.createUnaryCallable(
            getOrderTransportSettings, settings.getOrderSettings(), clientContext);
    this.listOrdersCallable =
        callableFactory.createUnaryCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.listOrdersPagedCallable =
        callableFactory.createPagedCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOrderMethodDescriptor);
    methodDescriptors.add(listOrdersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return getOrderCallable;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    return listOrdersCallable;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    return listOrdersPagedCallable;
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
