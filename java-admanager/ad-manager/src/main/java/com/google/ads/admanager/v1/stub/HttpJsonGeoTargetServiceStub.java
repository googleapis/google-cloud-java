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

import static com.google.ads.admanager.v1.GeoTargetServiceClient.ListGeoTargetsPagedResponse;

import com.google.ads.admanager.v1.GeoTarget;
import com.google.ads.admanager.v1.GetGeoTargetRequest;
import com.google.ads.admanager.v1.ListGeoTargetsRequest;
import com.google.ads.admanager.v1.ListGeoTargetsResponse;
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
 * REST stub implementation for the GeoTargetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonGeoTargetServiceStub extends GeoTargetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetGeoTargetRequest, GeoTarget>
      getGeoTargetMethodDescriptor =
          ApiMethodDescriptor.<GetGeoTargetRequest, GeoTarget>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.GeoTargetService/GetGeoTarget")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGeoTargetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/geoTargets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGeoTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGeoTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GeoTarget>newBuilder()
                      .setDefaultInstance(GeoTarget.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGeoTargetsRequest, ListGeoTargetsResponse>
      listGeoTargetsMethodDescriptor =
          ApiMethodDescriptor.<ListGeoTargetsRequest, ListGeoTargetsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.GeoTargetService/ListGeoTargets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGeoTargetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/geoTargets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGeoTargetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGeoTargetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGeoTargetsResponse>newBuilder()
                      .setDefaultInstance(ListGeoTargetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetGeoTargetRequest, GeoTarget> getGeoTargetCallable;
  private final UnaryCallable<ListGeoTargetsRequest, ListGeoTargetsResponse> listGeoTargetsCallable;
  private final UnaryCallable<ListGeoTargetsRequest, ListGeoTargetsPagedResponse>
      listGeoTargetsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGeoTargetServiceStub create(GeoTargetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonGeoTargetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGeoTargetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGeoTargetServiceStub(
        GeoTargetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGeoTargetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGeoTargetServiceStub(
        GeoTargetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGeoTargetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGeoTargetServiceStub(
      GeoTargetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGeoTargetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGeoTargetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGeoTargetServiceStub(
      GeoTargetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetGeoTargetRequest, GeoTarget> getGeoTargetTransportSettings =
        HttpJsonCallSettings.<GetGeoTargetRequest, GeoTarget>newBuilder()
            .setMethodDescriptor(getGeoTargetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGeoTargetsRequest, ListGeoTargetsResponse>
        listGeoTargetsTransportSettings =
            HttpJsonCallSettings.<ListGeoTargetsRequest, ListGeoTargetsResponse>newBuilder()
                .setMethodDescriptor(listGeoTargetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getGeoTargetCallable =
        callableFactory.createUnaryCallable(
            getGeoTargetTransportSettings, settings.getGeoTargetSettings(), clientContext);
    this.listGeoTargetsCallable =
        callableFactory.createUnaryCallable(
            listGeoTargetsTransportSettings, settings.listGeoTargetsSettings(), clientContext);
    this.listGeoTargetsPagedCallable =
        callableFactory.createPagedCallable(
            listGeoTargetsTransportSettings, settings.listGeoTargetsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getGeoTargetMethodDescriptor);
    methodDescriptors.add(listGeoTargetsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetGeoTargetRequest, GeoTarget> getGeoTargetCallable() {
    return getGeoTargetCallable;
  }

  @Override
  public UnaryCallable<ListGeoTargetsRequest, ListGeoTargetsResponse> listGeoTargetsCallable() {
    return listGeoTargetsCallable;
  }

  @Override
  public UnaryCallable<ListGeoTargetsRequest, ListGeoTargetsPagedResponse>
      listGeoTargetsPagedCallable() {
    return listGeoTargetsPagedCallable;
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
