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

import static com.google.shopping.merchant.accounts.v1beta.AccountTaxServiceClient.ListAccountTaxPagedResponse;

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
import com.google.shopping.merchant.accounts.v1beta.AccountTax;
import com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccountTaxService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAccountTaxServiceStub extends AccountTaxServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAccountTaxRequest, AccountTax>
      getAccountTaxMethodDescriptor =
          ApiMethodDescriptor.<GetAccountTaxRequest, AccountTax>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountTaxService/GetAccountTax")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccountTaxRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/accounttax/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountTaxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountTaxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountTax>newBuilder()
                      .setDefaultInstance(AccountTax.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAccountTaxRequest, ListAccountTaxResponse>
      listAccountTaxMethodDescriptor =
          ApiMethodDescriptor.<ListAccountTaxRequest, ListAccountTaxResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountTaxService/ListAccountTax")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountTaxRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/accounttax",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountTaxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountTaxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccountTaxResponse>newBuilder()
                      .setDefaultInstance(ListAccountTaxResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAccountTaxRequest, AccountTax>
      updateAccountTaxMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccountTaxRequest, AccountTax>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountTaxService/UpdateAccountTax")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountTaxRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{accountTax.name=accounts/*/accounttax/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountTaxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "accountTax.name", request.getAccountTax().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountTaxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accountTax", request.getAccountTax(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountTax>newBuilder()
                      .setDefaultInstance(AccountTax.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAccountTaxRequest, AccountTax> getAccountTaxCallable;
  private final UnaryCallable<ListAccountTaxRequest, ListAccountTaxResponse> listAccountTaxCallable;
  private final UnaryCallable<ListAccountTaxRequest, ListAccountTaxPagedResponse>
      listAccountTaxPagedCallable;
  private final UnaryCallable<UpdateAccountTaxRequest, AccountTax> updateAccountTaxCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccountTaxServiceStub create(AccountTaxServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAccountTaxServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccountTaxServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccountTaxServiceStub(
        AccountTaxServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccountTaxServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccountTaxServiceStub(
        AccountTaxServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccountTaxServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountTaxServiceStub(
      AccountTaxServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccountTaxServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccountTaxServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountTaxServiceStub(
      AccountTaxServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAccountTaxRequest, AccountTax> getAccountTaxTransportSettings =
        HttpJsonCallSettings.<GetAccountTaxRequest, AccountTax>newBuilder()
            .setMethodDescriptor(getAccountTaxMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAccountTaxRequest, ListAccountTaxResponse>
        listAccountTaxTransportSettings =
            HttpJsonCallSettings.<ListAccountTaxRequest, ListAccountTaxResponse>newBuilder()
                .setMethodDescriptor(listAccountTaxMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAccountTaxRequest, AccountTax> updateAccountTaxTransportSettings =
        HttpJsonCallSettings.<UpdateAccountTaxRequest, AccountTax>newBuilder()
            .setMethodDescriptor(updateAccountTaxMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "account_tax.name", String.valueOf(request.getAccountTax().getName()));
                  return builder.build();
                })
            .build();

    this.getAccountTaxCallable =
        callableFactory.createUnaryCallable(
            getAccountTaxTransportSettings, settings.getAccountTaxSettings(), clientContext);
    this.listAccountTaxCallable =
        callableFactory.createUnaryCallable(
            listAccountTaxTransportSettings, settings.listAccountTaxSettings(), clientContext);
    this.listAccountTaxPagedCallable =
        callableFactory.createPagedCallable(
            listAccountTaxTransportSettings, settings.listAccountTaxSettings(), clientContext);
    this.updateAccountTaxCallable =
        callableFactory.createUnaryCallable(
            updateAccountTaxTransportSettings, settings.updateAccountTaxSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAccountTaxMethodDescriptor);
    methodDescriptors.add(listAccountTaxMethodDescriptor);
    methodDescriptors.add(updateAccountTaxMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAccountTaxRequest, AccountTax> getAccountTaxCallable() {
    return getAccountTaxCallable;
  }

  @Override
  public UnaryCallable<ListAccountTaxRequest, ListAccountTaxResponse> listAccountTaxCallable() {
    return listAccountTaxCallable;
  }

  @Override
  public UnaryCallable<ListAccountTaxRequest, ListAccountTaxPagedResponse>
      listAccountTaxPagedCallable() {
    return listAccountTaxPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountTaxRequest, AccountTax> updateAccountTaxCallable() {
    return updateAccountTaxCallable;
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
