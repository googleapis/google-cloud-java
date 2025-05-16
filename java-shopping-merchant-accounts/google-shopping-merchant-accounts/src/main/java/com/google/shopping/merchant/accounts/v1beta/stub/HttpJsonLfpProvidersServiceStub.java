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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.LfpProvidersServiceClient.FindLfpProvidersPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.shopping.merchant.accounts.v1beta.FindLfpProvidersRequest;
import com.google.shopping.merchant.accounts.v1beta.FindLfpProvidersResponse;
import com.google.shopping.merchant.accounts.v1beta.LinkLfpProviderRequest;
import com.google.shopping.merchant.accounts.v1beta.LinkLfpProviderResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LfpProvidersService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonLfpProvidersServiceStub extends LfpProvidersServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersMethodDescriptor =
          ApiMethodDescriptor.<FindLfpProvidersRequest, FindLfpProvidersResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.LfpProvidersService/FindLfpProviders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FindLfpProvidersRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*/omnichannelSettings/*}/lfpProviders:find",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FindLfpProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FindLfpProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindLfpProvidersResponse>newBuilder()
                      .setDefaultInstance(FindLfpProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<LinkLfpProviderRequest, LinkLfpProviderResponse>
      linkLfpProviderMethodDescriptor =
          ApiMethodDescriptor.<LinkLfpProviderRequest, LinkLfpProviderResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.LfpProvidersService/LinkLfpProvider")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LinkLfpProviderRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/omnichannelSettings/*/lfpProviders/*}:linkLfpProvider",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LinkLfpProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LinkLfpProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LinkLfpProviderResponse>newBuilder()
                      .setDefaultInstance(LinkLfpProviderResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersCallable;
  private final UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersPagedResponse>
      findLfpProvidersPagedCallable;
  private final UnaryCallable<LinkLfpProviderRequest, LinkLfpProviderResponse>
      linkLfpProviderCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLfpProvidersServiceStub create(
      LfpProvidersServiceStubSettings settings) throws IOException {
    return new HttpJsonLfpProvidersServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLfpProvidersServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLfpProvidersServiceStub(
        LfpProvidersServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLfpProvidersServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLfpProvidersServiceStub(
        LfpProvidersServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLfpProvidersServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLfpProvidersServiceStub(
      LfpProvidersServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLfpProvidersServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLfpProvidersServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLfpProvidersServiceStub(
      LfpProvidersServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<FindLfpProvidersRequest, FindLfpProvidersResponse>
        findLfpProvidersTransportSettings =
            HttpJsonCallSettings.<FindLfpProvidersRequest, FindLfpProvidersResponse>newBuilder()
                .setMethodDescriptor(findLfpProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<LinkLfpProviderRequest, LinkLfpProviderResponse>
        linkLfpProviderTransportSettings =
            HttpJsonCallSettings.<LinkLfpProviderRequest, LinkLfpProviderResponse>newBuilder()
                .setMethodDescriptor(linkLfpProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.findLfpProvidersCallable =
        callableFactory.createUnaryCallable(
            findLfpProvidersTransportSettings, settings.findLfpProvidersSettings(), clientContext);
    this.findLfpProvidersPagedCallable =
        callableFactory.createPagedCallable(
            findLfpProvidersTransportSettings, settings.findLfpProvidersSettings(), clientContext);
    this.linkLfpProviderCallable =
        callableFactory.createUnaryCallable(
            linkLfpProviderTransportSettings, settings.linkLfpProviderSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(findLfpProvidersMethodDescriptor);
    methodDescriptors.add(linkLfpProviderMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersResponse>
      findLfpProvidersCallable() {
    return findLfpProvidersCallable;
  }

  @Override
  public UnaryCallable<FindLfpProvidersRequest, FindLfpProvidersPagedResponse>
      findLfpProvidersPagedCallable() {
    return findLfpProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<LinkLfpProviderRequest, LinkLfpProviderResponse> linkLfpProviderCallable() {
    return linkLfpProviderCallable;
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
