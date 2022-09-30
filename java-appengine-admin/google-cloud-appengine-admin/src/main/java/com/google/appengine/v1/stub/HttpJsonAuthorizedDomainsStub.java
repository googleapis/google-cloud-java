/*
 * Copyright 2022 Google LLC
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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.AuthorizedDomainsClient.ListAuthorizedDomainsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.ListAuthorizedDomainsRequest;
import com.google.appengine.v1.ListAuthorizedDomainsResponse;
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
 * REST stub implementation for the AuthorizedDomains service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAuthorizedDomainsStub extends AuthorizedDomainsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>newBuilder()
              .setFullMethodName("google.appengine.v1.AuthorizedDomains/ListAuthorizedDomains")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAuthorizedDomainsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/authorizedDomains",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizedDomainsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizedDomainsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAuthorizedDomainsResponse>newBuilder()
                      .setDefaultInstance(ListAuthorizedDomainsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsCallable;
  private final UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsPagedResponse>
      listAuthorizedDomainsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAuthorizedDomainsStub create(AuthorizedDomainsStubSettings settings)
      throws IOException {
    return new HttpJsonAuthorizedDomainsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAuthorizedDomainsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAuthorizedDomainsStub(
        AuthorizedDomainsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAuthorizedDomainsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAuthorizedDomainsStub(
        AuthorizedDomainsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAuthorizedDomainsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAuthorizedDomainsStub(
      AuthorizedDomainsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAuthorizedDomainsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAuthorizedDomainsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAuthorizedDomainsStub(
      AuthorizedDomainsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
        listAuthorizedDomainsTransportSettings =
            HttpJsonCallSettings
                .<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>newBuilder()
                .setMethodDescriptor(listAuthorizedDomainsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listAuthorizedDomainsCallable =
        callableFactory.createUnaryCallable(
            listAuthorizedDomainsTransportSettings,
            settings.listAuthorizedDomainsSettings(),
            clientContext);
    this.listAuthorizedDomainsPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizedDomainsTransportSettings,
            settings.listAuthorizedDomainsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAuthorizedDomainsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsCallable() {
    return listAuthorizedDomainsCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsPagedResponse>
      listAuthorizedDomainsPagedCallable() {
    return listAuthorizedDomainsPagedCallable;
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
