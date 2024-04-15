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

package com.google.shopping.merchant.quota.v1beta.stub;

import static com.google.shopping.merchant.quota.v1beta.QuotaServiceClient.ListQuotaGroupsPagedResponse;

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
import com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsRequest;
import com.google.shopping.merchant.quota.v1beta.ListQuotaGroupsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the QuotaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonQuotaServiceStub extends QuotaServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListQuotaGroupsRequest, ListQuotaGroupsResponse>
      listQuotaGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListQuotaGroupsRequest, ListQuotaGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.quota.v1beta.QuotaService/ListQuotaGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQuotaGroupsRequest>newBuilder()
                      .setPath(
                          "/quota/v1beta/{parent=accounts/*}/quotas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQuotaGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQuotaGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListQuotaGroupsResponse>newBuilder()
                      .setDefaultInstance(ListQuotaGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsResponse>
      listQuotaGroupsCallable;
  private final UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsPagedResponse>
      listQuotaGroupsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonQuotaServiceStub create(QuotaServiceStubSettings settings)
      throws IOException {
    return new HttpJsonQuotaServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonQuotaServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonQuotaServiceStub(
        QuotaServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonQuotaServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonQuotaServiceStub(
        QuotaServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonQuotaServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonQuotaServiceStub(QuotaServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonQuotaServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonQuotaServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonQuotaServiceStub(
      QuotaServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListQuotaGroupsRequest, ListQuotaGroupsResponse>
        listQuotaGroupsTransportSettings =
            HttpJsonCallSettings.<ListQuotaGroupsRequest, ListQuotaGroupsResponse>newBuilder()
                .setMethodDescriptor(listQuotaGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listQuotaGroupsCallable =
        callableFactory.createUnaryCallable(
            listQuotaGroupsTransportSettings, settings.listQuotaGroupsSettings(), clientContext);
    this.listQuotaGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listQuotaGroupsTransportSettings, settings.listQuotaGroupsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listQuotaGroupsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsResponse> listQuotaGroupsCallable() {
    return listQuotaGroupsCallable;
  }

  @Override
  public UnaryCallable<ListQuotaGroupsRequest, ListQuotaGroupsPagedResponse>
      listQuotaGroupsPagedCallable() {
    return listQuotaGroupsPagedCallable;
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
