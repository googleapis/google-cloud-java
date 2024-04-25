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

import static com.google.ads.admanager.v1.AdUnitServiceClient.ListAdUnitsPagedResponse;

import com.google.ads.admanager.v1.AdUnit;
import com.google.ads.admanager.v1.GetAdUnitRequest;
import com.google.ads.admanager.v1.ListAdUnitsRequest;
import com.google.ads.admanager.v1.ListAdUnitsResponse;
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
 * REST stub implementation for the AdUnitService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAdUnitServiceStub extends AdUnitServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAdUnitRequest, AdUnit> getAdUnitMethodDescriptor =
      ApiMethodDescriptor.<GetAdUnitRequest, AdUnit>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.AdUnitService/GetAdUnit")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAdUnitRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/adUnits/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AdUnit>newBuilder()
                  .setDefaultInstance(AdUnit.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAdUnitsRequest, ListAdUnitsResponse>
      listAdUnitsMethodDescriptor =
          ApiMethodDescriptor.<ListAdUnitsRequest, ListAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/ListAdUnits")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdUnitsResponse>newBuilder()
                      .setDefaultInstance(ListAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable;
  private final UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable;
  private final UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse>
      listAdUnitsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdUnitServiceStub create(AdUnitServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAdUnitServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdUnitServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdUnitServiceStub(
        AdUnitServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdUnitServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdUnitServiceStub(
        AdUnitServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdUnitServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdUnitServiceStub(
      AdUnitServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAdUnitServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdUnitServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdUnitServiceStub(
      AdUnitServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAdUnitRequest, AdUnit> getAdUnitTransportSettings =
        HttpJsonCallSettings.<GetAdUnitRequest, AdUnit>newBuilder()
            .setMethodDescriptor(getAdUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsTransportSettings =
        HttpJsonCallSettings.<ListAdUnitsRequest, ListAdUnitsResponse>newBuilder()
            .setMethodDescriptor(listAdUnitsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getAdUnitCallable =
        callableFactory.createUnaryCallable(
            getAdUnitTransportSettings, settings.getAdUnitSettings(), clientContext);
    this.listAdUnitsCallable =
        callableFactory.createUnaryCallable(
            listAdUnitsTransportSettings, settings.listAdUnitsSettings(), clientContext);
    this.listAdUnitsPagedCallable =
        callableFactory.createPagedCallable(
            listAdUnitsTransportSettings, settings.listAdUnitsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAdUnitMethodDescriptor);
    methodDescriptors.add(listAdUnitsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable() {
    return getAdUnitCallable;
  }

  @Override
  public UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable() {
    return listAdUnitsCallable;
  }

  @Override
  public UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse> listAdUnitsPagedCallable() {
    return listAdUnitsPagedCallable;
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
