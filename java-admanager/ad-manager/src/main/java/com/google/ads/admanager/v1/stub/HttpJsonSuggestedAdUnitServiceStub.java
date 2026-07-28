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

import static com.google.ads.admanager.v1.SuggestedAdUnitServiceClient.ListSuggestedAdUnitsPagedResponse;

import com.google.ads.admanager.v1.BatchApproveSuggestedAdUnitsRequest;
import com.google.ads.admanager.v1.BatchApproveSuggestedAdUnitsResponse;
import com.google.ads.admanager.v1.GetSuggestedAdUnitRequest;
import com.google.ads.admanager.v1.ListSuggestedAdUnitsRequest;
import com.google.ads.admanager.v1.ListSuggestedAdUnitsResponse;
import com.google.ads.admanager.v1.SuggestedAdUnit;
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
 * REST stub implementation for the SuggestedAdUnitService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonSuggestedAdUnitServiceStub extends SuggestedAdUnitServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetSuggestedAdUnitRequest, SuggestedAdUnit>
      getSuggestedAdUnitMethodDescriptor =
          ApiMethodDescriptor.<GetSuggestedAdUnitRequest, SuggestedAdUnit>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.SuggestedAdUnitService/GetSuggestedAdUnit")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSuggestedAdUnitRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/suggestedAdUnits/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSuggestedAdUnitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSuggestedAdUnitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SuggestedAdUnit>newBuilder()
                      .setDefaultInstance(SuggestedAdUnit.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>
      listSuggestedAdUnitsMethodDescriptor =
          ApiMethodDescriptor
              .<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.SuggestedAdUnitService/ListSuggestedAdUnits")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSuggestedAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/suggestedAdUnits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSuggestedAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSuggestedAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSuggestedAdUnitsResponse>newBuilder()
                      .setDefaultInstance(ListSuggestedAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.SuggestedAdUnitService/BatchApproveSuggestedAdUnits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchApproveSuggestedAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/suggestedAdUnit:batchApprove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveSuggestedAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveSuggestedAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchApproveSuggestedAdUnitsResponse>newBuilder()
                      .setDefaultInstance(BatchApproveSuggestedAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetSuggestedAdUnitRequest, SuggestedAdUnit>
      getSuggestedAdUnitCallable;
  private final UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>
      listSuggestedAdUnitsCallable;
  private final UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsPagedResponse>
      listSuggestedAdUnitsPagedCallable;
  private final UnaryCallable<
          BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSuggestedAdUnitServiceStub create(
      SuggestedAdUnitServiceStubSettings settings) throws IOException {
    return new HttpJsonSuggestedAdUnitServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSuggestedAdUnitServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSuggestedAdUnitServiceStub(
        SuggestedAdUnitServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSuggestedAdUnitServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSuggestedAdUnitServiceStub(
        SuggestedAdUnitServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSuggestedAdUnitServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSuggestedAdUnitServiceStub(
      SuggestedAdUnitServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSuggestedAdUnitServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSuggestedAdUnitServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSuggestedAdUnitServiceStub(
      SuggestedAdUnitServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetSuggestedAdUnitRequest, SuggestedAdUnit>
        getSuggestedAdUnitTransportSettings =
            HttpJsonCallSettings.<GetSuggestedAdUnitRequest, SuggestedAdUnit>newBuilder()
                .setMethodDescriptor(getSuggestedAdUnitMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>
        listSuggestedAdUnitsTransportSettings =
            HttpJsonCallSettings
                .<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>newBuilder()
                .setMethodDescriptor(listSuggestedAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
        batchApproveSuggestedAdUnitsTransportSettings =
            HttpJsonCallSettings
                .<BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
                    newBuilder()
                .setMethodDescriptor(batchApproveSuggestedAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getSuggestedAdUnitCallable =
        callableFactory.createUnaryCallable(
            getSuggestedAdUnitTransportSettings,
            settings.getSuggestedAdUnitSettings(),
            clientContext);
    this.listSuggestedAdUnitsCallable =
        callableFactory.createUnaryCallable(
            listSuggestedAdUnitsTransportSettings,
            settings.listSuggestedAdUnitsSettings(),
            clientContext);
    this.listSuggestedAdUnitsPagedCallable =
        callableFactory.createPagedCallable(
            listSuggestedAdUnitsTransportSettings,
            settings.listSuggestedAdUnitsSettings(),
            clientContext);
    this.batchApproveSuggestedAdUnitsCallable =
        callableFactory.createUnaryCallable(
            batchApproveSuggestedAdUnitsTransportSettings,
            settings.batchApproveSuggestedAdUnitsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSuggestedAdUnitMethodDescriptor);
    methodDescriptors.add(listSuggestedAdUnitsMethodDescriptor);
    methodDescriptors.add(batchApproveSuggestedAdUnitsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetSuggestedAdUnitRequest, SuggestedAdUnit> getSuggestedAdUnitCallable() {
    return getSuggestedAdUnitCallable;
  }

  @Override
  public UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>
      listSuggestedAdUnitsCallable() {
    return listSuggestedAdUnitsCallable;
  }

  @Override
  public UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsPagedResponse>
      listSuggestedAdUnitsPagedCallable() {
    return listSuggestedAdUnitsPagedCallable;
  }

  @Override
  public UnaryCallable<BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsCallable() {
    return batchApproveSuggestedAdUnitsCallable;
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
