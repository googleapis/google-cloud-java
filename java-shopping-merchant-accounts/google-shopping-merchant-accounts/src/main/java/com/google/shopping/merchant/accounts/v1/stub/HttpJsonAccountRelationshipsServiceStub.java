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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.AccountRelationshipsServiceClient.ListAccountRelationshipsPagedResponse;

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
import com.google.shopping.merchant.accounts.v1.AccountRelationship;
import com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse;
import com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccountRelationshipsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAccountRelationshipsServiceStub extends AccountRelationshipsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipMethodDescriptor =
          ApiMethodDescriptor.<GetAccountRelationshipRequest, AccountRelationship>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountRelationshipsService/GetAccountRelationship")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccountRelationshipRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/relationships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountRelationshipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountRelationshipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountRelationship>newBuilder()
                      .setDefaultInstance(AccountRelationship.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccountRelationshipRequest, AccountRelationship>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountRelationshipsService/UpdateAccountRelationship")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountRelationshipRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{accountRelationship.name=accounts/*/relationships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountRelationshipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "accountRelationship.name",
                                request.getAccountRelationship().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountRelationshipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "accountRelationship",
                                      request.getAccountRelationship(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountRelationship>newBuilder()
                      .setDefaultInstance(AccountRelationship.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountRelationshipsService/ListAccountRelationships")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountRelationshipsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{parent=accounts/*}/relationships",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountRelationshipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountRelationshipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccountRelationshipsResponse>newBuilder()
                      .setDefaultInstance(ListAccountRelationshipsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipCallable;
  private final UnaryCallable<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipCallable;
  private final UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsCallable;
  private final UnaryCallable<
          ListAccountRelationshipsRequest, ListAccountRelationshipsPagedResponse>
      listAccountRelationshipsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccountRelationshipsServiceStub create(
      AccountRelationshipsServiceStubSettings settings) throws IOException {
    return new HttpJsonAccountRelationshipsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccountRelationshipsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccountRelationshipsServiceStub(
        AccountRelationshipsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccountRelationshipsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccountRelationshipsServiceStub(
        AccountRelationshipsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccountRelationshipsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAccountRelationshipsServiceStub(
      AccountRelationshipsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAccountRelationshipsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccountRelationshipsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAccountRelationshipsServiceStub(
      AccountRelationshipsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAccountRelationshipRequest, AccountRelationship>
        getAccountRelationshipTransportSettings =
            HttpJsonCallSettings.<GetAccountRelationshipRequest, AccountRelationship>newBuilder()
                .setMethodDescriptor(getAccountRelationshipMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAccountRelationshipRequest, AccountRelationship>
        updateAccountRelationshipTransportSettings =
            HttpJsonCallSettings.<UpdateAccountRelationshipRequest, AccountRelationship>newBuilder()
                .setMethodDescriptor(updateAccountRelationshipMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "account_relationship.name",
                          String.valueOf(request.getAccountRelationship().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
        listAccountRelationshipsTransportSettings =
            HttpJsonCallSettings
                .<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>newBuilder()
                .setMethodDescriptor(listAccountRelationshipsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAccountRelationshipCallable =
        callableFactory.createUnaryCallable(
            getAccountRelationshipTransportSettings,
            settings.getAccountRelationshipSettings(),
            clientContext);
    this.updateAccountRelationshipCallable =
        callableFactory.createUnaryCallable(
            updateAccountRelationshipTransportSettings,
            settings.updateAccountRelationshipSettings(),
            clientContext);
    this.listAccountRelationshipsCallable =
        callableFactory.createUnaryCallable(
            listAccountRelationshipsTransportSettings,
            settings.listAccountRelationshipsSettings(),
            clientContext);
    this.listAccountRelationshipsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountRelationshipsTransportSettings,
            settings.listAccountRelationshipsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAccountRelationshipMethodDescriptor);
    methodDescriptors.add(updateAccountRelationshipMethodDescriptor);
    methodDescriptors.add(listAccountRelationshipsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipCallable() {
    return getAccountRelationshipCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipCallable() {
    return updateAccountRelationshipCallable;
  }

  @Override
  public UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsCallable() {
    return listAccountRelationshipsCallable;
  }

  @Override
  public UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsPagedResponse>
      listAccountRelationshipsPagedCallable() {
    return listAccountRelationshipsPagedCallable;
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
