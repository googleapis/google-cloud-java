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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.AccountsServiceClient.ListAccountsPagedResponse;
import static com.google.shopping.merchant.accounts.v1beta.AccountsServiceClient.ListSubAccountsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1beta.Account;
import com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.GetAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse;
import com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest;
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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAccountsServiceStub extends AccountsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAccountRequest, Account> getAccountMethodDescriptor =
      ApiMethodDescriptor.<GetAccountRequest, Account>newBuilder()
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.AccountsService/GetAccount")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAccountRequest>newBuilder()
                  .setPath(
                      "/accounts/v1beta/{name=accounts/*}",
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

  private static final ApiMethodDescriptor<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountMethodDescriptor =
          ApiMethodDescriptor.<CreateAndConfigureAccountRequest, Account>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/CreateAndConfigureAccount")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAndConfigureAccountRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/accounts:createAndConfigure",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAndConfigureAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAndConfigureAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Account>newBuilder()
                      .setDefaultInstance(Account.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAccountRequest, Empty>
      deleteAccountMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccountRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/DeleteAccount")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccountRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccountRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdateAccountRequest, Account>
      updateAccountMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccountRequest, Account>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/UpdateAccount")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{account.name=accounts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "account.name", request.getAccount().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("account", request.getAccount(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Account>newBuilder()
                      .setDefaultInstance(Account.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAccountsRequest, ListAccountsResponse>
      listAccountsMethodDescriptor =
          ApiMethodDescriptor.<ListAccountsRequest, ListAccountsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/ListAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/accounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAccountsResponse>newBuilder()
                      .setDefaultInstance(ListAccountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSubAccountsRequest, ListSubAccountsResponse>
      listSubAccountsMethodDescriptor =
          ApiMethodDescriptor.<ListSubAccountsRequest, ListSubAccountsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/ListSubAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubAccountsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{provider=accounts/*}:listSubaccounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "provider", request.getProvider());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSubAccountsResponse>newBuilder()
                      .setDefaultInstance(ListSubAccountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAccountRequest, Account> getAccountCallable;
  private final UnaryCallable<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountCallable;
  private final UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable;
  private final UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable;
  private final UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable;
  private final UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse>
      listAccountsPagedCallable;
  private final UnaryCallable<ListSubAccountsRequest, ListSubAccountsResponse>
      listSubAccountsCallable;
  private final UnaryCallable<ListSubAccountsRequest, ListSubAccountsPagedResponse>
      listSubAccountsPagedCallable;

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
    HttpJsonCallSettings<CreateAndConfigureAccountRequest, Account>
        createAndConfigureAccountTransportSettings =
            HttpJsonCallSettings.<CreateAndConfigureAccountRequest, Account>newBuilder()
                .setMethodDescriptor(createAndConfigureAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAccountRequest, Empty> deleteAccountTransportSettings =
        HttpJsonCallSettings.<DeleteAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAccountRequest, Account> updateAccountTransportSettings =
        HttpJsonCallSettings.<UpdateAccountRequest, Account>newBuilder()
            .setMethodDescriptor(updateAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("account.name", String.valueOf(request.getAccount().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAccountsRequest, ListAccountsResponse> listAccountsTransportSettings =
        HttpJsonCallSettings.<ListAccountsRequest, ListAccountsResponse>newBuilder()
            .setMethodDescriptor(listAccountsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSubAccountsRequest, ListSubAccountsResponse>
        listSubAccountsTransportSettings =
            HttpJsonCallSettings.<ListSubAccountsRequest, ListSubAccountsResponse>newBuilder()
                .setMethodDescriptor(listSubAccountsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("provider", String.valueOf(request.getProvider()));
                      return builder.build();
                    })
                .build();

    this.getAccountCallable =
        callableFactory.createUnaryCallable(
            getAccountTransportSettings, settings.getAccountSettings(), clientContext);
    this.createAndConfigureAccountCallable =
        callableFactory.createUnaryCallable(
            createAndConfigureAccountTransportSettings,
            settings.createAndConfigureAccountSettings(),
            clientContext);
    this.deleteAccountCallable =
        callableFactory.createUnaryCallable(
            deleteAccountTransportSettings, settings.deleteAccountSettings(), clientContext);
    this.updateAccountCallable =
        callableFactory.createUnaryCallable(
            updateAccountTransportSettings, settings.updateAccountSettings(), clientContext);
    this.listAccountsCallable =
        callableFactory.createUnaryCallable(
            listAccountsTransportSettings, settings.listAccountsSettings(), clientContext);
    this.listAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountsTransportSettings, settings.listAccountsSettings(), clientContext);
    this.listSubAccountsCallable =
        callableFactory.createUnaryCallable(
            listSubAccountsTransportSettings, settings.listSubAccountsSettings(), clientContext);
    this.listSubAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listSubAccountsTransportSettings, settings.listSubAccountsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAccountMethodDescriptor);
    methodDescriptors.add(createAndConfigureAccountMethodDescriptor);
    methodDescriptors.add(deleteAccountMethodDescriptor);
    methodDescriptors.add(updateAccountMethodDescriptor);
    methodDescriptors.add(listAccountsMethodDescriptor);
    methodDescriptors.add(listSubAccountsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    return getAccountCallable;
  }

  @Override
  public UnaryCallable<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountCallable() {
    return createAndConfigureAccountCallable;
  }

  @Override
  public UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable() {
    return deleteAccountCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable() {
    return updateAccountCallable;
  }

  @Override
  public UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable() {
    return listAccountsCallable;
  }

  @Override
  public UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse> listAccountsPagedCallable() {
    return listAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<ListSubAccountsRequest, ListSubAccountsResponse> listSubAccountsCallable() {
    return listSubAccountsCallable;
  }

  @Override
  public UnaryCallable<ListSubAccountsRequest, ListSubAccountsPagedResponse>
      listSubAccountsPagedCallable() {
    return listSubAccountsPagedCallable;
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
