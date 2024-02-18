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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.AccountsServiceClient.ListChildAccountsPagedResponse;

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
import com.google.shopping.css.v1.Account;
import com.google.shopping.css.v1.GetAccountRequest;
import com.google.shopping.css.v1.ListChildAccountsRequest;
import com.google.shopping.css.v1.ListChildAccountsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelsRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAccountsServiceStub extends AccountsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsMethodDescriptor =
          ApiMethodDescriptor.<ListChildAccountsRequest, ListChildAccountsResponse>newBuilder()
              .setFullMethodName("google.shopping.css.v1.AccountsService/ListChildAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChildAccountsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}:listChildAccounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChildAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChildAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFullName()) {
                              serializer.putQueryParam(fields, "fullName", request.getFullName());
                            }
                            if (request.hasLabelId()) {
                              serializer.putQueryParam(fields, "labelId", request.getLabelId());
                            }
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListChildAccountsResponse>newBuilder()
                      .setDefaultInstance(ListChildAccountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAccountRequest, Account> getAccountMethodDescriptor =
      ApiMethodDescriptor.<GetAccountRequest, Account>newBuilder()
          .setFullMethodName("google.shopping.css.v1.AccountsService/GetAccount")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAccountRequest>newBuilder()
                  .setPath(
                      "/v1/{name=accounts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAccountRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAccountRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasParent()) {
                          serializer.putQueryParam(fields, "parent", request.getParent());
                        }
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Account>newBuilder()
                  .setDefaultInstance(Account.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateAccountLabelsRequest, Account>
      updateLabelsMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccountLabelsRequest, Account>newBuilder()
              .setFullMethodName("google.shopping.css.v1.AccountsService/UpdateLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*}:updateLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountLabelsRequest> serializer =
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
                  ProtoMessageResponseParser.<Account>newBuilder()
                      .setDefaultInstance(Account.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsCallable;
  private final UnaryCallable<ListChildAccountsRequest, ListChildAccountsPagedResponse>
      listChildAccountsPagedCallable;
  private final UnaryCallable<GetAccountRequest, Account> getAccountCallable;
  private final UnaryCallable<UpdateAccountLabelsRequest, Account> updateLabelsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccountsServiceStub create(AccountsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAccountsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccountsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccountsServiceStub(
        AccountsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccountsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccountsServiceStub(
        AccountsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccountsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountsServiceStub(
      AccountsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccountsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccountsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountsServiceStub(
      AccountsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListChildAccountsRequest, ListChildAccountsResponse>
        listChildAccountsTransportSettings =
            HttpJsonCallSettings.<ListChildAccountsRequest, ListChildAccountsResponse>newBuilder()
                .setMethodDescriptor(listChildAccountsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAccountRequest, Account> getAccountTransportSettings =
        HttpJsonCallSettings.<GetAccountRequest, Account>newBuilder()
            .setMethodDescriptor(getAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAccountLabelsRequest, Account> updateLabelsTransportSettings =
        HttpJsonCallSettings.<UpdateAccountLabelsRequest, Account>newBuilder()
            .setMethodDescriptor(updateLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listChildAccountsCallable =
        callableFactory.createUnaryCallable(
            listChildAccountsTransportSettings,
            settings.listChildAccountsSettings(),
            clientContext);
    this.listChildAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listChildAccountsTransportSettings,
            settings.listChildAccountsSettings(),
            clientContext);
    this.getAccountCallable =
        callableFactory.createUnaryCallable(
            getAccountTransportSettings, settings.getAccountSettings(), clientContext);
    this.updateLabelsCallable =
        callableFactory.createUnaryCallable(
            updateLabelsTransportSettings, settings.updateLabelsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listChildAccountsMethodDescriptor);
    methodDescriptors.add(getAccountMethodDescriptor);
    methodDescriptors.add(updateLabelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsCallable() {
    return listChildAccountsCallable;
  }

  @Override
  public UnaryCallable<ListChildAccountsRequest, ListChildAccountsPagedResponse>
      listChildAccountsPagedCallable() {
    return listChildAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    return getAccountCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountLabelsRequest, Account> updateLabelsCallable() {
    return updateLabelsCallable;
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
