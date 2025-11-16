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

package com.google.shopping.merchant.quota.v1.stub;

import static com.google.shopping.merchant.quota.v1.AccountLimitsServiceClient.ListAccountLimitsPagedResponse;

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
import com.google.shopping.merchant.quota.v1.AccountLimit;
import com.google.shopping.merchant.quota.v1.GetAccountLimitRequest;
import com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest;
import com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccountLimitsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAccountLimitsServiceStub extends AccountLimitsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAccountLimitRequest, AccountLimit>
      getAccountLimitMethodDescriptor =
          ApiMethodDescriptor.<GetAccountLimitRequest, AccountLimit>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.quota.v1.AccountLimitsService/GetAccountLimit")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccountLimitRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/limits/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountLimitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountLimitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountLimit>newBuilder()
                      .setDefaultInstance(AccountLimit.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsMethodDescriptor =
          ApiMethodDescriptor.<ListAccountLimitsRequest, ListAccountLimitsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.quota.v1.AccountLimitsService/ListAccountLimits")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountLimitsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{parent=accounts/*}/limits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountLimitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountLimitsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAccountLimitsResponse>newBuilder()
                      .setDefaultInstance(ListAccountLimitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAccountLimitRequest, AccountLimit> getAccountLimitCallable;
  private final UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsCallable;
  private final UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsPagedResponse>
      listAccountLimitsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccountLimitsServiceStub create(
      AccountLimitsServiceStubSettings settings) throws IOException {
    return new HttpJsonAccountLimitsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccountLimitsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccountLimitsServiceStub(
        AccountLimitsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccountLimitsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccountLimitsServiceStub(
        AccountLimitsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccountLimitsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountLimitsServiceStub(
      AccountLimitsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccountLimitsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccountLimitsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountLimitsServiceStub(
      AccountLimitsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAccountLimitRequest, AccountLimit> getAccountLimitTransportSettings =
        HttpJsonCallSettings.<GetAccountLimitRequest, AccountLimit>newBuilder()
            .setMethodDescriptor(getAccountLimitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAccountLimitsRequest, ListAccountLimitsResponse>
        listAccountLimitsTransportSettings =
            HttpJsonCallSettings.<ListAccountLimitsRequest, ListAccountLimitsResponse>newBuilder()
                .setMethodDescriptor(listAccountLimitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAccountLimitCallable =
        callableFactory.createUnaryCallable(
            getAccountLimitTransportSettings, settings.getAccountLimitSettings(), clientContext);
    this.listAccountLimitsCallable =
        callableFactory.createUnaryCallable(
            listAccountLimitsTransportSettings,
            settings.listAccountLimitsSettings(),
            clientContext);
    this.listAccountLimitsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountLimitsTransportSettings,
            settings.listAccountLimitsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAccountLimitMethodDescriptor);
    methodDescriptors.add(listAccountLimitsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAccountLimitRequest, AccountLimit> getAccountLimitCallable() {
    return getAccountLimitCallable;
  }

  @Override
  public UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsCallable() {
    return listAccountLimitsCallable;
  }

  @Override
  public UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsPagedResponse>
      listAccountLimitsPagedCallable() {
    return listAccountLimitsPagedCallable;
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
