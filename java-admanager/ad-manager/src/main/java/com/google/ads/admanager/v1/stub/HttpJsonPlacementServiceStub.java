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

import static com.google.ads.admanager.v1.PlacementServiceClient.ListPlacementsPagedResponse;

import com.google.ads.admanager.v1.GetPlacementRequest;
import com.google.ads.admanager.v1.ListPlacementsRequest;
import com.google.ads.admanager.v1.ListPlacementsResponse;
import com.google.ads.admanager.v1.Placement;
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
 * REST stub implementation for the PlacementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPlacementServiceStub extends PlacementServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetPlacementRequest, Placement>
      getPlacementMethodDescriptor =
          ApiMethodDescriptor.<GetPlacementRequest, Placement>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.PlacementService/GetPlacement")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPlacementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/placements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPlacementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPlacementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Placement>newBuilder()
                      .setDefaultInstance(Placement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPlacementsRequest, ListPlacementsResponse>
      listPlacementsMethodDescriptor =
          ApiMethodDescriptor.<ListPlacementsRequest, ListPlacementsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.PlacementService/ListPlacements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPlacementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/placements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPlacementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPlacementsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPlacementsResponse>newBuilder()
                      .setDefaultInstance(ListPlacementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetPlacementRequest, Placement> getPlacementCallable;
  private final UnaryCallable<ListPlacementsRequest, ListPlacementsResponse> listPlacementsCallable;
  private final UnaryCallable<ListPlacementsRequest, ListPlacementsPagedResponse>
      listPlacementsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPlacementServiceStub create(PlacementServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPlacementServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPlacementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPlacementServiceStub(
        PlacementServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPlacementServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPlacementServiceStub(
        PlacementServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPlacementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPlacementServiceStub(
      PlacementServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPlacementServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPlacementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPlacementServiceStub(
      PlacementServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetPlacementRequest, Placement> getPlacementTransportSettings =
        HttpJsonCallSettings.<GetPlacementRequest, Placement>newBuilder()
            .setMethodDescriptor(getPlacementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPlacementsRequest, ListPlacementsResponse>
        listPlacementsTransportSettings =
            HttpJsonCallSettings.<ListPlacementsRequest, ListPlacementsResponse>newBuilder()
                .setMethodDescriptor(listPlacementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getPlacementCallable =
        callableFactory.createUnaryCallable(
            getPlacementTransportSettings, settings.getPlacementSettings(), clientContext);
    this.listPlacementsCallable =
        callableFactory.createUnaryCallable(
            listPlacementsTransportSettings, settings.listPlacementsSettings(), clientContext);
    this.listPlacementsPagedCallable =
        callableFactory.createPagedCallable(
            listPlacementsTransportSettings, settings.listPlacementsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getPlacementMethodDescriptor);
    methodDescriptors.add(listPlacementsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetPlacementRequest, Placement> getPlacementCallable() {
    return getPlacementCallable;
  }

  @Override
  public UnaryCallable<ListPlacementsRequest, ListPlacementsResponse> listPlacementsCallable() {
    return listPlacementsCallable;
  }

  @Override
  public UnaryCallable<ListPlacementsRequest, ListPlacementsPagedResponse>
      listPlacementsPagedCallable() {
    return listPlacementsPagedCallable;
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
