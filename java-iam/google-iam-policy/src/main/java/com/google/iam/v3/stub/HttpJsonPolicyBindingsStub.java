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

package com.google.iam.v3.stub;

import static com.google.iam.v3.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.iam.v3.CreatePolicyBindingRequest;
import com.google.iam.v3.DeletePolicyBindingRequest;
import com.google.iam.v3.GetPolicyBindingRequest;
import com.google.iam.v3.ListPolicyBindingsRequest;
import com.google.iam.v3.ListPolicyBindingsResponse;
import com.google.iam.v3.OperationMetadata;
import com.google.iam.v3.PolicyBinding;
import com.google.iam.v3.SearchTargetPolicyBindingsRequest;
import com.google.iam.v3.SearchTargetPolicyBindingsResponse;
import com.google.iam.v3.UpdatePolicyBindingRequest;
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
 * REST stub implementation for the PolicyBindings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPolicyBindingsStub extends PolicyBindingsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(PolicyBinding.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreatePolicyBindingRequest, Operation>
      createPolicyBindingMethodDescriptor =
          ApiMethodDescriptor.<CreatePolicyBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v3.PolicyBindings/CreatePolicyBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePolicyBindingRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/policyBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{parent=folders/*/locations/*}/policyBindings",
                          "/v3/{parent=organizations/*/locations/*}/policyBindings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "policyBindingId", request.getPolicyBindingId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policyBinding", request.getPolicyBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePolicyBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPolicyBindingRequest, PolicyBinding>
      getPolicyBindingMethodDescriptor =
          ApiMethodDescriptor.<GetPolicyBindingRequest, PolicyBinding>newBuilder()
              .setFullMethodName("google.iam.v3.PolicyBindings/GetPolicyBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPolicyBindingRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/policyBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{name=folders/*/locations/*/policyBindings/*}",
                          "/v3/{name=organizations/*/locations/*/policyBindings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PolicyBinding>newBuilder()
                      .setDefaultInstance(PolicyBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePolicyBindingRequest, Operation>
      updatePolicyBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdatePolicyBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v3.PolicyBindings/UpdatePolicyBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePolicyBindingRequest>newBuilder()
                      .setPath(
                          "/v3/{policyBinding.name=projects/*/locations/*/policyBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policyBinding.name", request.getPolicyBinding().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{policyBinding.name=folders/*/locations/*/policyBindings/*}",
                          "/v3/{policyBinding.name=organizations/*/locations/*/policyBindings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policyBinding", request.getPolicyBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePolicyBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePolicyBindingRequest, Operation>
      deletePolicyBindingMethodDescriptor =
          ApiMethodDescriptor.<DeletePolicyBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v3.PolicyBindings/DeletePolicyBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePolicyBindingRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/policyBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{name=folders/*/locations/*/policyBindings/*}",
                          "/v3/{name=organizations/*/locations/*/policyBindings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeletePolicyBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsMethodDescriptor =
          ApiMethodDescriptor.<ListPolicyBindingsRequest, ListPolicyBindingsResponse>newBuilder()
              .setFullMethodName("google.iam.v3.PolicyBindings/ListPolicyBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPolicyBindingsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/policyBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPolicyBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{parent=folders/*/locations/*}/policyBindings",
                          "/v3/{parent=organizations/*/locations/*}/policyBindings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPolicyBindingsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPolicyBindingsResponse>newBuilder()
                      .setDefaultInstance(ListPolicyBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>newBuilder()
              .setFullMethodName("google.iam.v3.PolicyBindings/SearchTargetPolicyBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchTargetPolicyBindingsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/policyBindings:searchTargetPolicyBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchTargetPolicyBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{parent=folders/*/locations/*}/policyBindings:searchTargetPolicyBindings",
                          "/v3/{parent=organizations/*/locations/*}/policyBindings:searchTargetPolicyBindings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchTargetPolicyBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "target", request.getTarget());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchTargetPolicyBindingsResponse>newBuilder()
                      .setDefaultInstance(SearchTargetPolicyBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreatePolicyBindingRequest, Operation> createPolicyBindingCallable;
  private final OperationCallable<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationCallable;
  private final UnaryCallable<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingCallable;
  private final UnaryCallable<UpdatePolicyBindingRequest, Operation> updatePolicyBindingCallable;
  private final OperationCallable<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationCallable;
  private final UnaryCallable<DeletePolicyBindingRequest, Operation> deletePolicyBindingCallable;
  private final OperationCallable<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationCallable;
  private final UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsCallable;
  private final UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsPagedResponse>
      listPolicyBindingsPagedCallable;
  private final UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsCallable;
  private final UnaryCallable<
          SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPolicyBindingsStub create(PolicyBindingsStubSettings settings)
      throws IOException {
    return new HttpJsonPolicyBindingsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPolicyBindingsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPolicyBindingsStub(
        PolicyBindingsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPolicyBindingsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPolicyBindingsStub(
        PolicyBindingsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPolicyBindingsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPolicyBindingsStub(
      PolicyBindingsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPolicyBindingsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPolicyBindingsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPolicyBindingsStub(
      PolicyBindingsStubSettings settings,
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
                        .setGet("/v3/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v3/{name=folders/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v3/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreatePolicyBindingRequest, Operation>
        createPolicyBindingTransportSettings =
            HttpJsonCallSettings.<CreatePolicyBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createPolicyBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingTransportSettings =
        HttpJsonCallSettings.<GetPolicyBindingRequest, PolicyBinding>newBuilder()
            .setMethodDescriptor(getPolicyBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePolicyBindingRequest, Operation>
        updatePolicyBindingTransportSettings =
            HttpJsonCallSettings.<UpdatePolicyBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePolicyBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "policy_binding.name",
                          String.valueOf(request.getPolicyBinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePolicyBindingRequest, Operation>
        deletePolicyBindingTransportSettings =
            HttpJsonCallSettings.<DeletePolicyBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePolicyBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
        listPolicyBindingsTransportSettings =
            HttpJsonCallSettings.<ListPolicyBindingsRequest, ListPolicyBindingsResponse>newBuilder()
                .setMethodDescriptor(listPolicyBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
        searchTargetPolicyBindingsTransportSettings =
            HttpJsonCallSettings
                .<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>newBuilder()
                .setMethodDescriptor(searchTargetPolicyBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            createPolicyBindingTransportSettings,
            settings.createPolicyBindingSettings(),
            clientContext);
    this.createPolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            createPolicyBindingTransportSettings,
            settings.createPolicyBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPolicyBindingCallable =
        callableFactory.createUnaryCallable(
            getPolicyBindingTransportSettings, settings.getPolicyBindingSettings(), clientContext);
    this.updatePolicyBindingCallable =
        callableFactory.createUnaryCallable(
            updatePolicyBindingTransportSettings,
            settings.updatePolicyBindingSettings(),
            clientContext);
    this.updatePolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            updatePolicyBindingTransportSettings,
            settings.updatePolicyBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePolicyBindingCallable =
        callableFactory.createUnaryCallable(
            deletePolicyBindingTransportSettings,
            settings.deletePolicyBindingSettings(),
            clientContext);
    this.deletePolicyBindingOperationCallable =
        callableFactory.createOperationCallable(
            deletePolicyBindingTransportSettings,
            settings.deletePolicyBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            listPolicyBindingsTransportSettings,
            settings.listPolicyBindingsSettings(),
            clientContext);
    this.listPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listPolicyBindingsTransportSettings,
            settings.listPolicyBindingsSettings(),
            clientContext);
    this.searchTargetPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            searchTargetPolicyBindingsTransportSettings,
            settings.searchTargetPolicyBindingsSettings(),
            clientContext);
    this.searchTargetPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            searchTargetPolicyBindingsTransportSettings,
            settings.searchTargetPolicyBindingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createPolicyBindingMethodDescriptor);
    methodDescriptors.add(getPolicyBindingMethodDescriptor);
    methodDescriptors.add(updatePolicyBindingMethodDescriptor);
    methodDescriptors.add(deletePolicyBindingMethodDescriptor);
    methodDescriptors.add(listPolicyBindingsMethodDescriptor);
    methodDescriptors.add(searchTargetPolicyBindingsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreatePolicyBindingRequest, Operation> createPolicyBindingCallable() {
    return createPolicyBindingCallable;
  }

  @Override
  public OperationCallable<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationCallable() {
    return createPolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingCallable() {
    return getPolicyBindingCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyBindingRequest, Operation> updatePolicyBindingCallable() {
    return updatePolicyBindingCallable;
  }

  @Override
  public OperationCallable<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationCallable() {
    return updatePolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyBindingRequest, Operation> deletePolicyBindingCallable() {
    return deletePolicyBindingCallable;
  }

  @Override
  public OperationCallable<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationCallable() {
    return deletePolicyBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsCallable() {
    return listPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsPagedResponse>
      listPolicyBindingsPagedCallable() {
    return listPolicyBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsCallable() {
    return searchTargetPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsPagedCallable() {
    return searchTargetPolicyBindingsPagedCallable;
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
