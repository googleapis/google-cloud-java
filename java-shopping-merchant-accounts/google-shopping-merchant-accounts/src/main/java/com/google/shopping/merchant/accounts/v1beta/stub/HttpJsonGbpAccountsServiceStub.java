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

import static com.google.shopping.merchant.accounts.v1beta.GbpAccountsServiceClient.ListGbpAccountsPagedResponse;

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
import com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.LinkGbpAccountResponse;
import com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListGbpAccountsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GbpAccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGbpAccountsServiceStub extends GbpAccountsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListGbpAccountsRequest, ListGbpAccountsResponse>
      listGbpAccountsMethodDescriptor =
          ApiMethodDescriptor.<ListGbpAccountsRequest, ListGbpAccountsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.GbpAccountsService/ListGbpAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGbpAccountsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/gbpAccounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGbpAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGbpAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGbpAccountsResponse>newBuilder()
                      .setDefaultInstance(ListGbpAccountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<LinkGbpAccountRequest, LinkGbpAccountResponse>
      linkGbpAccountMethodDescriptor =
          ApiMethodDescriptor.<LinkGbpAccountRequest, LinkGbpAccountResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.GbpAccountsService/LinkGbpAccount")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LinkGbpAccountRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/gbpAccounts:linkGbpAccount",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LinkGbpAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LinkGbpAccountRequest> serializer =
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
                  ProtoMessageResponseParser.<LinkGbpAccountResponse>newBuilder()
                      .setDefaultInstance(LinkGbpAccountResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsResponse>
      listGbpAccountsCallable;
  private final UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsPagedResponse>
      listGbpAccountsPagedCallable;
  private final UnaryCallable<LinkGbpAccountRequest, LinkGbpAccountResponse> linkGbpAccountCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGbpAccountsServiceStub create(GbpAccountsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonGbpAccountsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGbpAccountsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGbpAccountsServiceStub(
        GbpAccountsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGbpAccountsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGbpAccountsServiceStub(
        GbpAccountsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGbpAccountsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGbpAccountsServiceStub(
      GbpAccountsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGbpAccountsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGbpAccountsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGbpAccountsServiceStub(
      GbpAccountsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListGbpAccountsRequest, ListGbpAccountsResponse>
        listGbpAccountsTransportSettings =
            HttpJsonCallSettings.<ListGbpAccountsRequest, ListGbpAccountsResponse>newBuilder()
                .setMethodDescriptor(listGbpAccountsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<LinkGbpAccountRequest, LinkGbpAccountResponse>
        linkGbpAccountTransportSettings =
            HttpJsonCallSettings.<LinkGbpAccountRequest, LinkGbpAccountResponse>newBuilder()
                .setMethodDescriptor(linkGbpAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listGbpAccountsCallable =
        callableFactory.createUnaryCallable(
            listGbpAccountsTransportSettings, settings.listGbpAccountsSettings(), clientContext);
    this.listGbpAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listGbpAccountsTransportSettings, settings.listGbpAccountsSettings(), clientContext);
    this.linkGbpAccountCallable =
        callableFactory.createUnaryCallable(
            linkGbpAccountTransportSettings, settings.linkGbpAccountSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listGbpAccountsMethodDescriptor);
    methodDescriptors.add(linkGbpAccountMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsResponse> listGbpAccountsCallable() {
    return listGbpAccountsCallable;
  }

  @Override
  public UnaryCallable<ListGbpAccountsRequest, ListGbpAccountsPagedResponse>
      listGbpAccountsPagedCallable() {
    return listGbpAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<LinkGbpAccountRequest, LinkGbpAccountResponse> linkGbpAccountCallable() {
    return linkGbpAccountCallable;
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
