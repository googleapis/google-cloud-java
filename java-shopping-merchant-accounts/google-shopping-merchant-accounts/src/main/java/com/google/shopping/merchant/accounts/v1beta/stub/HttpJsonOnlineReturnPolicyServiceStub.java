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

import static com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyServiceClient.ListOnlineReturnPoliciesPagedResponse;

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
import com.google.shopping.merchant.accounts.v1beta.CreateOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1beta.GetOnlineReturnPolicyRequest;
import com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesRequest;
import com.google.shopping.merchant.accounts.v1beta.ListOnlineReturnPoliciesResponse;
import com.google.shopping.merchant.accounts.v1beta.OnlineReturnPolicy;
import com.google.shopping.merchant.accounts.v1beta.UpdateOnlineReturnPolicyRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the OnlineReturnPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonOnlineReturnPolicyServiceStub extends OnlineReturnPolicyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyService/GetOnlineReturnPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOnlineReturnPolicyRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/onlineReturnPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OnlineReturnPolicy>newBuilder()
                      .setDefaultInstance(OnlineReturnPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyService/ListOnlineReturnPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOnlineReturnPoliciesRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/onlineReturnPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOnlineReturnPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOnlineReturnPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOnlineReturnPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListOnlineReturnPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyService/CreateOnlineReturnPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOnlineReturnPolicyRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{parent=accounts/*}/onlineReturnPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "onlineReturnPolicy", request.getOnlineReturnPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OnlineReturnPolicy>newBuilder()
                      .setDefaultInstance(OnlineReturnPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      updateOnlineReturnPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyService/UpdateOnlineReturnPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOnlineReturnPolicyRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{onlineReturnPolicy.name=accounts/*/onlineReturnPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "onlineReturnPolicy.name",
                                request.getOnlineReturnPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "onlineReturnPolicy", request.getOnlineReturnPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OnlineReturnPolicy>newBuilder()
                      .setDefaultInstance(OnlineReturnPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteOnlineReturnPolicyRequest, Empty>
      deleteOnlineReturnPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteOnlineReturnPolicyRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.OnlineReturnPolicyService/DeleteOnlineReturnPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOnlineReturnPolicyRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/onlineReturnPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOnlineReturnPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOnlineReturnPolicyRequest> serializer =
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

  private final UnaryCallable<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyCallable;
  private final UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesCallable;
  private final UnaryCallable<
          ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesPagedResponse>
      listOnlineReturnPoliciesPagedCallable;
  private final UnaryCallable<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyCallable;
  private final UnaryCallable<UpdateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      updateOnlineReturnPolicyCallable;
  private final UnaryCallable<DeleteOnlineReturnPolicyRequest, Empty>
      deleteOnlineReturnPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOnlineReturnPolicyServiceStub create(
      OnlineReturnPolicyServiceStubSettings settings) throws IOException {
    return new HttpJsonOnlineReturnPolicyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOnlineReturnPolicyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOnlineReturnPolicyServiceStub(
        OnlineReturnPolicyServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOnlineReturnPolicyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOnlineReturnPolicyServiceStub(
        OnlineReturnPolicyServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOnlineReturnPolicyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOnlineReturnPolicyServiceStub(
      OnlineReturnPolicyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOnlineReturnPolicyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOnlineReturnPolicyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOnlineReturnPolicyServiceStub(
      OnlineReturnPolicyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
        getOnlineReturnPolicyTransportSettings =
            HttpJsonCallSettings.<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
                .setMethodDescriptor(getOnlineReturnPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
        listOnlineReturnPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>newBuilder()
                .setMethodDescriptor(listOnlineReturnPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
        createOnlineReturnPolicyTransportSettings =
            HttpJsonCallSettings.<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
                .setMethodDescriptor(createOnlineReturnPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateOnlineReturnPolicyRequest, OnlineReturnPolicy>
        updateOnlineReturnPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateOnlineReturnPolicyRequest, OnlineReturnPolicy>newBuilder()
                .setMethodDescriptor(updateOnlineReturnPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "online_return_policy.name",
                          String.valueOf(request.getOnlineReturnPolicy().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteOnlineReturnPolicyRequest, Empty>
        deleteOnlineReturnPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteOnlineReturnPolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteOnlineReturnPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            getOnlineReturnPolicyTransportSettings,
            settings.getOnlineReturnPolicySettings(),
            clientContext);
    this.listOnlineReturnPoliciesCallable =
        callableFactory.createUnaryCallable(
            listOnlineReturnPoliciesTransportSettings,
            settings.listOnlineReturnPoliciesSettings(),
            clientContext);
    this.listOnlineReturnPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listOnlineReturnPoliciesTransportSettings,
            settings.listOnlineReturnPoliciesSettings(),
            clientContext);
    this.createOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            createOnlineReturnPolicyTransportSettings,
            settings.createOnlineReturnPolicySettings(),
            clientContext);
    this.updateOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            updateOnlineReturnPolicyTransportSettings,
            settings.updateOnlineReturnPolicySettings(),
            clientContext);
    this.deleteOnlineReturnPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteOnlineReturnPolicyTransportSettings,
            settings.deleteOnlineReturnPolicySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOnlineReturnPolicyMethodDescriptor);
    methodDescriptors.add(listOnlineReturnPoliciesMethodDescriptor);
    methodDescriptors.add(createOnlineReturnPolicyMethodDescriptor);
    methodDescriptors.add(updateOnlineReturnPolicyMethodDescriptor);
    methodDescriptors.add(deleteOnlineReturnPolicyMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOnlineReturnPolicyRequest, OnlineReturnPolicy>
      getOnlineReturnPolicyCallable() {
    return getOnlineReturnPolicyCallable;
  }

  @Override
  public UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesResponse>
      listOnlineReturnPoliciesCallable() {
    return listOnlineReturnPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListOnlineReturnPoliciesRequest, ListOnlineReturnPoliciesPagedResponse>
      listOnlineReturnPoliciesPagedCallable() {
    return listOnlineReturnPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      createOnlineReturnPolicyCallable() {
    return createOnlineReturnPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateOnlineReturnPolicyRequest, OnlineReturnPolicy>
      updateOnlineReturnPolicyCallable() {
    return updateOnlineReturnPolicyCallable;
  }

  @Override
  public UnaryCallable<DeleteOnlineReturnPolicyRequest, Empty> deleteOnlineReturnPolicyCallable() {
    return deleteOnlineReturnPolicyCallable;
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
