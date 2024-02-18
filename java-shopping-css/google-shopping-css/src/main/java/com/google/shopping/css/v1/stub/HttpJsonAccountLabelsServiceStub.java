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

import static com.google.shopping.css.v1.AccountLabelsServiceClient.ListAccountLabelsPagedResponse;

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
import com.google.shopping.css.v1.AccountLabel;
import com.google.shopping.css.v1.CreateAccountLabelRequest;
import com.google.shopping.css.v1.DeleteAccountLabelRequest;
import com.google.shopping.css.v1.ListAccountLabelsRequest;
import com.google.shopping.css.v1.ListAccountLabelsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccountLabelsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAccountLabelsServiceStub extends AccountLabelsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsMethodDescriptor =
          ApiMethodDescriptor.<ListAccountLabelsRequest, ListAccountLabelsResponse>newBuilder()
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/ListAccountLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/labels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccountLabelsResponse>newBuilder()
                      .setDefaultInstance(ListAccountLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAccountLabelRequest, AccountLabel>
      createAccountLabelMethodDescriptor =
          ApiMethodDescriptor.<CreateAccountLabelRequest, AccountLabel>newBuilder()
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/CreateAccountLabel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAccountLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/labels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccountLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccountLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accountLabel", request.getAccountLabel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountLabel>newBuilder()
                      .setDefaultInstance(AccountLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAccountLabelRequest, AccountLabel>
      updateAccountLabelMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccountLabelRequest, AccountLabel>newBuilder()
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/UpdateAccountLabel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{accountLabel.name=accounts/*/labels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "accountLabel.name", request.getAccountLabel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accountLabel", request.getAccountLabel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountLabel>newBuilder()
                      .setDefaultInstance(AccountLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAccountLabelRequest, Empty>
      deleteAccountLabelMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccountLabelRequest, Empty>newBuilder()
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/DeleteAccountLabel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccountLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/labels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccountLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccountLabelRequest> serializer =
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

  private final UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsCallable;
  private final UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsPagedResponse>
      listAccountLabelsPagedCallable;
  private final UnaryCallable<CreateAccountLabelRequest, AccountLabel> createAccountLabelCallable;
  private final UnaryCallable<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelCallable;
  private final UnaryCallable<DeleteAccountLabelRequest, Empty> deleteAccountLabelCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccountLabelsServiceStub create(
      AccountLabelsServiceStubSettings settings) throws IOException {
    return new HttpJsonAccountLabelsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccountLabelsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccountLabelsServiceStub(
        AccountLabelsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccountLabelsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccountLabelsServiceStub(
        AccountLabelsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccountLabelsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountLabelsServiceStub(
      AccountLabelsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccountLabelsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccountLabelsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountLabelsServiceStub(
      AccountLabelsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListAccountLabelsRequest, ListAccountLabelsResponse>
        listAccountLabelsTransportSettings =
            HttpJsonCallSettings.<ListAccountLabelsRequest, ListAccountLabelsResponse>newBuilder()
                .setMethodDescriptor(listAccountLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAccountLabelRequest, AccountLabel>
        createAccountLabelTransportSettings =
            HttpJsonCallSettings.<CreateAccountLabelRequest, AccountLabel>newBuilder()
                .setMethodDescriptor(createAccountLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAccountLabelRequest, AccountLabel>
        updateAccountLabelTransportSettings =
            HttpJsonCallSettings.<UpdateAccountLabelRequest, AccountLabel>newBuilder()
                .setMethodDescriptor(updateAccountLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "account_label.name",
                          String.valueOf(request.getAccountLabel().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAccountLabelRequest, Empty> deleteAccountLabelTransportSettings =
        HttpJsonCallSettings.<DeleteAccountLabelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccountLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listAccountLabelsCallable =
        callableFactory.createUnaryCallable(
            listAccountLabelsTransportSettings,
            settings.listAccountLabelsSettings(),
            clientContext);
    this.listAccountLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountLabelsTransportSettings,
            settings.listAccountLabelsSettings(),
            clientContext);
    this.createAccountLabelCallable =
        callableFactory.createUnaryCallable(
            createAccountLabelTransportSettings,
            settings.createAccountLabelSettings(),
            clientContext);
    this.updateAccountLabelCallable =
        callableFactory.createUnaryCallable(
            updateAccountLabelTransportSettings,
            settings.updateAccountLabelSettings(),
            clientContext);
    this.deleteAccountLabelCallable =
        callableFactory.createUnaryCallable(
            deleteAccountLabelTransportSettings,
            settings.deleteAccountLabelSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAccountLabelsMethodDescriptor);
    methodDescriptors.add(createAccountLabelMethodDescriptor);
    methodDescriptors.add(updateAccountLabelMethodDescriptor);
    methodDescriptors.add(deleteAccountLabelMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsCallable() {
    return listAccountLabelsCallable;
  }

  @Override
  public UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsPagedResponse>
      listAccountLabelsPagedCallable() {
    return listAccountLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAccountLabelRequest, AccountLabel> createAccountLabelCallable() {
    return createAccountLabelCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelCallable() {
    return updateAccountLabelCallable;
  }

  @Override
  public UnaryCallable<DeleteAccountLabelRequest, Empty> deleteAccountLabelCallable() {
    return deleteAccountLabelCallable;
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
