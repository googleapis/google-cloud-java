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

import static com.google.ads.admanager.v1.BandwidthGroupServiceClient.ListBandwidthGroupsPagedResponse;

import com.google.ads.admanager.v1.BandwidthGroup;
import com.google.ads.admanager.v1.GetBandwidthGroupRequest;
import com.google.ads.admanager.v1.ListBandwidthGroupsRequest;
import com.google.ads.admanager.v1.ListBandwidthGroupsResponse;
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
 * REST stub implementation for the BandwidthGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonBandwidthGroupServiceStub extends BandwidthGroupServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBandwidthGroupRequest, BandwidthGroup>
      getBandwidthGroupMethodDescriptor =
          ApiMethodDescriptor.<GetBandwidthGroupRequest, BandwidthGroup>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.BandwidthGroupService/GetBandwidthGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBandwidthGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/bandwidthGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBandwidthGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBandwidthGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BandwidthGroup>newBuilder()
                      .setDefaultInstance(BandwidthGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>
      listBandwidthGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.BandwidthGroupService/ListBandwidthGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBandwidthGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/bandwidthGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBandwidthGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBandwidthGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBandwidthGroupsResponse>newBuilder()
                      .setDefaultInstance(ListBandwidthGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBandwidthGroupRequest, BandwidthGroup> getBandwidthGroupCallable;
  private final UnaryCallable<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>
      listBandwidthGroupsCallable;
  private final UnaryCallable<ListBandwidthGroupsRequest, ListBandwidthGroupsPagedResponse>
      listBandwidthGroupsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBandwidthGroupServiceStub create(
      BandwidthGroupServiceStubSettings settings) throws IOException {
    return new HttpJsonBandwidthGroupServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBandwidthGroupServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBandwidthGroupServiceStub(
        BandwidthGroupServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBandwidthGroupServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBandwidthGroupServiceStub(
        BandwidthGroupServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBandwidthGroupServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBandwidthGroupServiceStub(
      BandwidthGroupServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBandwidthGroupServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBandwidthGroupServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBandwidthGroupServiceStub(
      BandwidthGroupServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBandwidthGroupRequest, BandwidthGroup>
        getBandwidthGroupTransportSettings =
            HttpJsonCallSettings.<GetBandwidthGroupRequest, BandwidthGroup>newBuilder()
                .setMethodDescriptor(getBandwidthGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>
        listBandwidthGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>newBuilder()
                .setMethodDescriptor(listBandwidthGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getBandwidthGroupCallable =
        callableFactory.createUnaryCallable(
            getBandwidthGroupTransportSettings,
            settings.getBandwidthGroupSettings(),
            clientContext);
    this.listBandwidthGroupsCallable =
        callableFactory.createUnaryCallable(
            listBandwidthGroupsTransportSettings,
            settings.listBandwidthGroupsSettings(),
            clientContext);
    this.listBandwidthGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listBandwidthGroupsTransportSettings,
            settings.listBandwidthGroupsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBandwidthGroupMethodDescriptor);
    methodDescriptors.add(listBandwidthGroupsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBandwidthGroupRequest, BandwidthGroup> getBandwidthGroupCallable() {
    return getBandwidthGroupCallable;
  }

  @Override
  public UnaryCallable<ListBandwidthGroupsRequest, ListBandwidthGroupsResponse>
      listBandwidthGroupsCallable() {
    return listBandwidthGroupsCallable;
  }

  @Override
  public UnaryCallable<ListBandwidthGroupsRequest, ListBandwidthGroupsPagedResponse>
      listBandwidthGroupsPagedCallable() {
    return listBandwidthGroupsPagedCallable;
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
