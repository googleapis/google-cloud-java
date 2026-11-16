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

import static com.google.ads.admanager.v1.ChangeEventServiceClient.ListChangeEventsPagedResponse;

import com.google.ads.admanager.v1.ChangeEvent;
import com.google.ads.admanager.v1.GetChangeEventRequest;
import com.google.ads.admanager.v1.ListChangeEventsRequest;
import com.google.ads.admanager.v1.ListChangeEventsResponse;
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
 * REST stub implementation for the ChangeEventService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonChangeEventServiceStub extends ChangeEventServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetChangeEventRequest, ChangeEvent>
      getChangeEventMethodDescriptor =
          ApiMethodDescriptor.<GetChangeEventRequest, ChangeEvent>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ChangeEventService/GetChangeEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChangeEventRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/changeEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChangeEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChangeEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChangeEvent>newBuilder()
                      .setDefaultInstance(ChangeEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListChangeEventsRequest, ListChangeEventsResponse>
      listChangeEventsMethodDescriptor =
          ApiMethodDescriptor.<ListChangeEventsRequest, ListChangeEventsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ChangeEventService/ListChangeEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChangeEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/changeEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChangeEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChangeEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListChangeEventsResponse>newBuilder()
                      .setDefaultInstance(ListChangeEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetChangeEventRequest, ChangeEvent> getChangeEventCallable;
  private final UnaryCallable<ListChangeEventsRequest, ListChangeEventsResponse>
      listChangeEventsCallable;
  private final UnaryCallable<ListChangeEventsRequest, ListChangeEventsPagedResponse>
      listChangeEventsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonChangeEventServiceStub create(ChangeEventServiceStubSettings settings)
      throws IOException {
    return new HttpJsonChangeEventServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonChangeEventServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonChangeEventServiceStub(
        ChangeEventServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonChangeEventServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonChangeEventServiceStub(
        ChangeEventServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonChangeEventServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonChangeEventServiceStub(
      ChangeEventServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonChangeEventServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonChangeEventServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonChangeEventServiceStub(
      ChangeEventServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetChangeEventRequest, ChangeEvent> getChangeEventTransportSettings =
        HttpJsonCallSettings.<GetChangeEventRequest, ChangeEvent>newBuilder()
            .setMethodDescriptor(getChangeEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListChangeEventsRequest, ListChangeEventsResponse>
        listChangeEventsTransportSettings =
            HttpJsonCallSettings.<ListChangeEventsRequest, ListChangeEventsResponse>newBuilder()
                .setMethodDescriptor(listChangeEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getChangeEventCallable =
        callableFactory.createUnaryCallable(
            getChangeEventTransportSettings, settings.getChangeEventSettings(), clientContext);
    this.listChangeEventsCallable =
        callableFactory.createUnaryCallable(
            listChangeEventsTransportSettings, settings.listChangeEventsSettings(), clientContext);
    this.listChangeEventsPagedCallable =
        callableFactory.createPagedCallable(
            listChangeEventsTransportSettings, settings.listChangeEventsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getChangeEventMethodDescriptor);
    methodDescriptors.add(listChangeEventsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetChangeEventRequest, ChangeEvent> getChangeEventCallable() {
    return getChangeEventCallable;
  }

  @Override
  public UnaryCallable<ListChangeEventsRequest, ListChangeEventsResponse>
      listChangeEventsCallable() {
    return listChangeEventsCallable;
  }

  @Override
  public UnaryCallable<ListChangeEventsRequest, ListChangeEventsPagedResponse>
      listChangeEventsPagedCallable() {
    return listChangeEventsPagedCallable;
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
