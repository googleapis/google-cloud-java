/*
 * Copyright 2026 Google LLC
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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v3beta.AccessPolicy;
import com.google.iam.v3beta.CreateAccessPolicyRequest;
import com.google.iam.v3beta.DeleteAccessPolicyRequest;
import com.google.iam.v3beta.GetAccessPolicyRequest;
import com.google.iam.v3beta.ListAccessPoliciesRequest;
import com.google.iam.v3beta.ListAccessPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.SearchAccessPolicyBindingsRequest;
import com.google.iam.v3beta.SearchAccessPolicyBindingsResponse;
import com.google.iam.v3beta.UpdateAccessPolicyRequest;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the AccessPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAccessPoliciesStub extends AccessPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(AccessPolicy.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateAccessPolicyRequest, Operation>
      createAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateAccessPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v3beta.AccessPolicies/CreateAccessPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{parent=projects/*/locations/*}/accessPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3beta/{parent=folders/*/locations/*}/accessPolicies",
                          "/v3beta/{parent=organizations/*/locations/*}/accessPolicies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "accessPolicyId", request.getAccessPolicyId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accessPolicy", request.getAccessPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAccessPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAccessPolicyRequest, AccessPolicy>
      getAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
              .setFullMethodName("google.iam.v3beta.AccessPolicies/GetAccessPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{name=projects/*/locations/*/accessPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3beta/{name=folders/*/locations/*/accessPolicies/*}",
                          "/v3beta/{name=organizations/*/locations/*/accessPolicies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessPolicy>newBuilder()
                      .setDefaultInstance(AccessPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAccessPolicyRequest, Operation>
      updateAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccessPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v3beta.AccessPolicies/UpdateAccessPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{accessPolicy.name=projects/*/locations/*/accessPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "accessPolicy.name", request.getAccessPolicy().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3beta/{accessPolicy.name=folders/*/locations/*/accessPolicies/*}",
                          "/v3beta/{accessPolicy.name=organizations/*/locations/*/accessPolicies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accessPolicy", request.getAccessPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAccessPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAccessPolicyRequest, Operation>
      deleteAccessPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v3beta.AccessPolicies/DeleteAccessPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{name=projects/*/locations/*/accessPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3beta/{name=folders/*/locations/*/accessPolicies/*}",
                          "/v3beta/{name=organizations/*/locations/*/accessPolicies/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteAccessPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
              .setFullMethodName("google.iam.v3beta.AccessPolicies/ListAccessPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccessPoliciesRequest>newBuilder()
                      .setPath(
                          "/v3beta/{parent=projects/*/locations/*}/accessPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3beta/{parent=folders/*/locations/*}/accessPolicies",
                          "/v3beta/{parent=organizations/*/locations/*}/accessPolicies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccessPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListAccessPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>newBuilder()
              .setFullMethodName("google.iam.v3beta.AccessPolicies/SearchAccessPolicyBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAccessPolicyBindingsRequest>newBuilder()
                      .setPath(
                          "/v3beta/{name=organizations/*/locations/*/accessPolicies/*}:searchPolicyBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAccessPolicyBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3beta/{name=folders/*/locations/*/accessPolicies/*}:searchPolicyBindings",
                          "/v3beta/{name=projects/*/locations/*/accessPolicies/*}:searchPolicyBindings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAccessPolicyBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAccessPolicyBindingsResponse>newBuilder()
                      .setDefaultInstance(SearchAccessPolicyBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateAccessPolicyRequest, Operation> createAccessPolicyCallable;
  private final OperationCallable<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationCallable;
  private final UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable;
  private final UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable;
  private final OperationCallable<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationCallable;
  private final UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable;
  private final OperationCallable<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationCallable;
  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable;
  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable;
  private final UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsCallable;
  private final UnaryCallable<
          SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccessPoliciesStub create(AccessPoliciesStubSettings settings)
      throws IOException {
    return new HttpJsonAccessPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccessPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccessPoliciesStub(
        AccessPoliciesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccessPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccessPoliciesStub(
        AccessPoliciesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccessPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccessPoliciesStub(
      AccessPoliciesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccessPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccessPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccessPoliciesStub(
      AccessPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v3beta/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v3beta/{name=folders/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v3beta/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateAccessPolicyRequest, Operation> createAccessPolicyTransportSettings =
        HttpJsonCallSettings.<CreateAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyTransportSettings =
        HttpJsonCallSettings.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
            .setMethodDescriptor(getAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicyTransportSettings =
        HttpJsonCallSettings.<UpdateAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "access_policy.name", String.valueOf(request.getAccessPolicy().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyTransportSettings =
        HttpJsonCallSettings.<DeleteAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAccessPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
        listAccessPoliciesTransportSettings =
            HttpJsonCallSettings.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAccessPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
        searchAccessPolicyBindingsTransportSettings =
            HttpJsonCallSettings
                .<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>newBuilder()
                .setMethodDescriptor(searchAccessPolicyBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicySettings(),
            clientContext);
    this.createAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            getAccessPolicyTransportSettings, settings.getAccessPolicySettings(), clientContext);
    this.updateAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicySettings(),
            clientContext);
    this.updateAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicySettings(),
            clientContext);
    this.deleteAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAccessPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.listAccessPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.searchAccessPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            searchAccessPolicyBindingsTransportSettings,
            settings.searchAccessPolicyBindingsSettings(),
            clientContext);
    this.searchAccessPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            searchAccessPolicyBindingsTransportSettings,
            settings.searchAccessPolicyBindingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAccessPolicyMethodDescriptor);
    methodDescriptors.add(getAccessPolicyMethodDescriptor);
    methodDescriptors.add(updateAccessPolicyMethodDescriptor);
    methodDescriptors.add(deleteAccessPolicyMethodDescriptor);
    methodDescriptors.add(listAccessPoliciesMethodDescriptor);
    methodDescriptors.add(searchAccessPolicyBindingsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateAccessPolicyRequest, Operation> createAccessPolicyCallable() {
    return createAccessPolicyCallable;
  }

  @Override
  public OperationCallable<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationCallable() {
    return createAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    return getAccessPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    return updateAccessPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationCallable() {
    return updateAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    return deleteAccessPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationCallable() {
    return deleteAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    return listAccessPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    return listAccessPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsCallable() {
    return searchAccessPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsPagedCallable() {
    return searchAccessPolicyBindingsPagedCallable;
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
