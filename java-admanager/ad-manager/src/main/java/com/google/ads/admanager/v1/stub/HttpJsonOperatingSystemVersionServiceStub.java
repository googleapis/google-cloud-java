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

import static com.google.ads.admanager.v1.OperatingSystemVersionServiceClient.ListOperatingSystemVersionsPagedResponse;

import com.google.ads.admanager.v1.GetOperatingSystemVersionRequest;
import com.google.ads.admanager.v1.ListOperatingSystemVersionsRequest;
import com.google.ads.admanager.v1.ListOperatingSystemVersionsResponse;
import com.google.ads.admanager.v1.OperatingSystemVersion;
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
 * REST stub implementation for the OperatingSystemVersionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonOperatingSystemVersionServiceStub extends OperatingSystemVersionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOperatingSystemVersionRequest, OperatingSystemVersion>
      getOperatingSystemVersionMethodDescriptor =
          ApiMethodDescriptor.<GetOperatingSystemVersionRequest, OperatingSystemVersion>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OperatingSystemVersionService/GetOperatingSystemVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOperatingSystemVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/operatingSystemVersions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperatingSystemVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperatingSystemVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OperatingSystemVersion>newBuilder()
                      .setDefaultInstance(OperatingSystemVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
      listOperatingSystemVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OperatingSystemVersionService/ListOperatingSystemVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOperatingSystemVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/operatingSystemVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOperatingSystemVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOperatingSystemVersionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOperatingSystemVersionsResponse>newBuilder()
                      .setDefaultInstance(ListOperatingSystemVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOperatingSystemVersionRequest, OperatingSystemVersion>
      getOperatingSystemVersionCallable;
  private final UnaryCallable<
          ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
      listOperatingSystemVersionsCallable;
  private final UnaryCallable<
          ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsPagedResponse>
      listOperatingSystemVersionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOperatingSystemVersionServiceStub create(
      OperatingSystemVersionServiceStubSettings settings) throws IOException {
    return new HttpJsonOperatingSystemVersionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOperatingSystemVersionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOperatingSystemVersionServiceStub(
        OperatingSystemVersionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonOperatingSystemVersionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOperatingSystemVersionServiceStub(
        OperatingSystemVersionServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOperatingSystemVersionServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonOperatingSystemVersionServiceStub(
      OperatingSystemVersionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOperatingSystemVersionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOperatingSystemVersionServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonOperatingSystemVersionServiceStub(
      OperatingSystemVersionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOperatingSystemVersionRequest, OperatingSystemVersion>
        getOperatingSystemVersionTransportSettings =
            HttpJsonCallSettings
                .<GetOperatingSystemVersionRequest, OperatingSystemVersion>newBuilder()
                .setMethodDescriptor(getOperatingSystemVersionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
        listOperatingSystemVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
                    newBuilder()
                .setMethodDescriptor(listOperatingSystemVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getOperatingSystemVersionCallable =
        callableFactory.createUnaryCallable(
            getOperatingSystemVersionTransportSettings,
            settings.getOperatingSystemVersionSettings(),
            clientContext);
    this.listOperatingSystemVersionsCallable =
        callableFactory.createUnaryCallable(
            listOperatingSystemVersionsTransportSettings,
            settings.listOperatingSystemVersionsSettings(),
            clientContext);
    this.listOperatingSystemVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listOperatingSystemVersionsTransportSettings,
            settings.listOperatingSystemVersionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOperatingSystemVersionMethodDescriptor);
    methodDescriptors.add(listOperatingSystemVersionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOperatingSystemVersionRequest, OperatingSystemVersion>
      getOperatingSystemVersionCallable() {
    return getOperatingSystemVersionCallable;
  }

  @Override
  public UnaryCallable<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsResponse>
      listOperatingSystemVersionsCallable() {
    return listOperatingSystemVersionsCallable;
  }

  @Override
  public UnaryCallable<ListOperatingSystemVersionsRequest, ListOperatingSystemVersionsPagedResponse>
      listOperatingSystemVersionsPagedCallable() {
    return listOperatingSystemVersionsPagedCallable;
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
