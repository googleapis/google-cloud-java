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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.PartnerLinkServiceClient.SearchPartnerLinksPagedResponse;

import com.google.ads.datamanager.v1.CreatePartnerLinkRequest;
import com.google.ads.datamanager.v1.DeletePartnerLinkRequest;
import com.google.ads.datamanager.v1.PartnerLink;
import com.google.ads.datamanager.v1.SearchPartnerLinksRequest;
import com.google.ads.datamanager.v1.SearchPartnerLinksResponse;
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
import com.google.protobuf.Empty;
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
 * REST stub implementation for the PartnerLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPartnerLinkServiceStub extends PartnerLinkServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreatePartnerLinkRequest, PartnerLink>
      createPartnerLinkMethodDescriptor =
          ApiMethodDescriptor.<CreatePartnerLinkRequest, PartnerLink>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.PartnerLinkService/CreatePartnerLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePartnerLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/partnerLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("partnerLink", request.getPartnerLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PartnerLink>newBuilder()
                      .setDefaultInstance(PartnerLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePartnerLinkRequest, Empty>
      deletePartnerLinkMethodDescriptor =
          ApiMethodDescriptor.<DeletePartnerLinkRequest, Empty>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.PartnerLinkService/DeletePartnerLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePartnerLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accountTypes/*/accounts/*/partnerLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksMethodDescriptor =
          ApiMethodDescriptor.<SearchPartnerLinksRequest, SearchPartnerLinksResponse>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.PartnerLinkService/SearchPartnerLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchPartnerLinksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/partnerLinks:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchPartnerLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchPartnerLinksRequest> serializer =
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
                  ProtoMessageResponseParser.<SearchPartnerLinksResponse>newBuilder()
                      .setDefaultInstance(SearchPartnerLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkCallable;
  private final UnaryCallable<DeletePartnerLinkRequest, Empty> deletePartnerLinkCallable;
  private final UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksCallable;
  private final UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksPagedResponse>
      searchPartnerLinksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPartnerLinkServiceStub create(PartnerLinkServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPartnerLinkServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPartnerLinkServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPartnerLinkServiceStub(
        PartnerLinkServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPartnerLinkServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPartnerLinkServiceStub(
        PartnerLinkServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPartnerLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPartnerLinkServiceStub(
      PartnerLinkServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPartnerLinkServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPartnerLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPartnerLinkServiceStub(
      PartnerLinkServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkTransportSettings =
        HttpJsonCallSettings.<CreatePartnerLinkRequest, PartnerLink>newBuilder()
            .setMethodDescriptor(createPartnerLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePartnerLinkRequest, Empty> deletePartnerLinkTransportSettings =
        HttpJsonCallSettings.<DeletePartnerLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePartnerLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
        searchPartnerLinksTransportSettings =
            HttpJsonCallSettings.<SearchPartnerLinksRequest, SearchPartnerLinksResponse>newBuilder()
                .setMethodDescriptor(searchPartnerLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createPartnerLinkCallable =
        callableFactory.createUnaryCallable(
            createPartnerLinkTransportSettings,
            settings.createPartnerLinkSettings(),
            clientContext);
    this.deletePartnerLinkCallable =
        callableFactory.createUnaryCallable(
            deletePartnerLinkTransportSettings,
            settings.deletePartnerLinkSettings(),
            clientContext);
    this.searchPartnerLinksCallable =
        callableFactory.createUnaryCallable(
            searchPartnerLinksTransportSettings,
            settings.searchPartnerLinksSettings(),
            clientContext);
    this.searchPartnerLinksPagedCallable =
        callableFactory.createPagedCallable(
            searchPartnerLinksTransportSettings,
            settings.searchPartnerLinksSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createPartnerLinkMethodDescriptor);
    methodDescriptors.add(deletePartnerLinkMethodDescriptor);
    methodDescriptors.add(searchPartnerLinksMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkCallable() {
    return createPartnerLinkCallable;
  }

  @Override
  public UnaryCallable<DeletePartnerLinkRequest, Empty> deletePartnerLinkCallable() {
    return deletePartnerLinkCallable;
  }

  @Override
  public UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksCallable() {
    return searchPartnerLinksCallable;
  }

  @Override
  public UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksPagedResponse>
      searchPartnerLinksPagedCallable() {
    return searchPartnerLinksPagedCallable;
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
