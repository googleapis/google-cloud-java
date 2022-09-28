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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

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
import com.google.cloud.dataproc.v1.AutoscalingPolicy;
import com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse;
import com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the AutoscalingPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAutoscalingPolicyServiceStub extends AutoscalingPolicyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/CreateAutoscalingPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAutoscalingPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autoscalingPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/regions/*}/autoscalingPolicies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutoscalingPolicy>newBuilder()
                      .setDefaultInstance(AutoscalingPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/UpdateAutoscalingPolicy")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAutoscalingPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{policy.name=projects/*/locations/*/autoscalingPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policy.name", request.getPolicy().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{policy.name=projects/*/regions/*/autoscalingPolicies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutoscalingPolicy>newBuilder()
                      .setDefaultInstance(AutoscalingPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/GetAutoscalingPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAutoscalingPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autoscalingPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/regions/*/autoscalingPolicies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutoscalingPolicy>newBuilder()
                      .setDefaultInstance(AutoscalingPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/ListAutoscalingPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAutoscalingPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/autoscalingPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutoscalingPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/regions/*}/autoscalingPolicies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAutoscalingPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAutoscalingPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListAutoscalingPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteAutoscalingPolicyRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/DeleteAutoscalingPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAutoscalingPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/autoscalingPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/regions/*/autoscalingPolicies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAutoscalingPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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

  private final UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable;
  private final UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable;
  private final UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable;
  private final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable;
  private final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable;
  private final UnaryCallable<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAutoscalingPolicyServiceStub create(
      AutoscalingPolicyServiceStubSettings settings) throws IOException {
    return new HttpJsonAutoscalingPolicyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAutoscalingPolicyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAutoscalingPolicyServiceStub(
        AutoscalingPolicyServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAutoscalingPolicyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAutoscalingPolicyServiceStub(
        AutoscalingPolicyServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAutoscalingPolicyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAutoscalingPolicyServiceStub(
      AutoscalingPolicyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAutoscalingPolicyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAutoscalingPolicyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAutoscalingPolicyServiceStub(
      AutoscalingPolicyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
        createAutoscalingPolicyTransportSettings =
            HttpJsonCallSettings.<CreateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
                .setMethodDescriptor(createAutoscalingPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
        updateAutoscalingPolicyTransportSettings =
            HttpJsonCallSettings.<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
                .setMethodDescriptor(updateAutoscalingPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAutoscalingPolicyRequest, AutoscalingPolicy>
        getAutoscalingPolicyTransportSettings =
            HttpJsonCallSettings.<GetAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
                .setMethodDescriptor(getAutoscalingPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
        listAutoscalingPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAutoscalingPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAutoscalingPolicyRequest, Empty>
        deleteAutoscalingPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteAutoscalingPolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAutoscalingPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            createAutoscalingPolicyTransportSettings,
            settings.createAutoscalingPolicySettings(),
            clientContext);
    this.updateAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAutoscalingPolicyTransportSettings,
            settings.updateAutoscalingPolicySettings(),
            clientContext);
    this.getAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            getAutoscalingPolicyTransportSettings,
            settings.getAutoscalingPolicySettings(),
            clientContext);
    this.listAutoscalingPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAutoscalingPoliciesTransportSettings,
            settings.listAutoscalingPoliciesSettings(),
            clientContext);
    this.listAutoscalingPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAutoscalingPoliciesTransportSettings,
            settings.listAutoscalingPoliciesSettings(),
            clientContext);
    this.deleteAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAutoscalingPolicyTransportSettings,
            settings.deleteAutoscalingPolicySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAutoscalingPolicyMethodDescriptor);
    methodDescriptors.add(updateAutoscalingPolicyMethodDescriptor);
    methodDescriptors.add(getAutoscalingPolicyMethodDescriptor);
    methodDescriptors.add(listAutoscalingPoliciesMethodDescriptor);
    methodDescriptors.add(deleteAutoscalingPolicyMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable() {
    return createAutoscalingPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable() {
    return updateAutoscalingPolicyCallable;
  }

  @Override
  public UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable() {
    return getAutoscalingPolicyCallable;
  }

  @Override
  public UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable() {
    return listAutoscalingPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable() {
    return listAutoscalingPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAutoscalingPolicyRequest, Empty> deleteAutoscalingPolicyCallable() {
    return deleteAutoscalingPolicyCallable;
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
