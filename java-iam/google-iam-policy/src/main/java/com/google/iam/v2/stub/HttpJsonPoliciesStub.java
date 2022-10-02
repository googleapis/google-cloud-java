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

package com.google.iam.v2.stub;

import static com.google.iam.v2.PoliciesClient.ListPoliciesPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v2.CreatePolicyRequest;
import com.google.iam.v2.DeletePolicyRequest;
import com.google.iam.v2.GetPolicyRequest;
import com.google.iam.v2.ListPoliciesRequest;
import com.google.iam.v2.ListPoliciesResponse;
import com.google.iam.v2.Policy;
import com.google.iam.v2.PolicyOperationMetadata;
import com.google.iam.v2.UpdatePolicyRequest;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the Policies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPoliciesStub extends PoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(PolicyOperationMetadata.getDescriptor())
          .add(Policy.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListPoliciesRequest, ListPoliciesResponse>
      listPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
              .setFullMethodName("google.iam.v2.Policies/ListPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPoliciesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=policies/*/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      ApiMethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setFullMethodName("google.iam.v2.Policies/GetPolicy")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPolicyRequest>newBuilder()
                  .setPath(
                      "/v2/{name=policies/*/*/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPolicyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPolicyRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Policy>newBuilder()
                  .setDefaultInstance(Policy.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreatePolicyRequest, Operation>
      createPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreatePolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v2.Policies/CreatePolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=policies/*/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "policyId", request.getPolicyId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePolicyRequest, Operation>
      updatePolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdatePolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v2.Policies/UpdatePolicy")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{policy.name=policies/*/*/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policy.name", request.getPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePolicyRequest, Operation>
      deletePolicyMethodDescriptor =
          ApiMethodDescriptor.<DeletePolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.iam.v2.Policies/DeletePolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{name=policies/*/*/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeletePolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable;
  private final UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse>
      listPoliciesPagedCallable;
  private final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable;
  private final UnaryCallable<CreatePolicyRequest, Operation> createPolicyCallable;
  private final OperationCallable<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationCallable;
  private final UnaryCallable<UpdatePolicyRequest, Operation> updatePolicyCallable;
  private final OperationCallable<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationCallable;
  private final UnaryCallable<DeletePolicyRequest, Operation> deletePolicyCallable;
  private final OperationCallable<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPoliciesStub create(PoliciesStubSettings settings)
      throws IOException {
    return new HttpJsonPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPoliciesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonPoliciesStub(
        PoliciesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPoliciesStub(
        PoliciesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPoliciesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPoliciesStub(PoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPoliciesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonPoliciesStub(
      PoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListPoliciesRequest, ListPoliciesResponse> listPoliciesTransportSettings =
        HttpJsonCallSettings.<ListPoliciesRequest, ListPoliciesResponse>newBuilder()
            .setMethodDescriptor(listPoliciesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        HttpJsonCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreatePolicyRequest, Operation> createPolicyTransportSettings =
        HttpJsonCallSettings.<CreatePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePolicyRequest, Operation> updatePolicyTransportSettings =
        HttpJsonCallSettings.<UpdatePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePolicyRequest, Operation> deletePolicyTransportSettings =
        HttpJsonCallSettings.<DeletePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listPoliciesCallable =
        callableFactory.createUnaryCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.listPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listPoliciesTransportSettings, settings.listPoliciesSettings(), clientContext);
    this.getPolicyCallable =
        callableFactory.createUnaryCallable(
            getPolicyTransportSettings, settings.getPolicySettings(), clientContext);
    this.createPolicyCallable =
        callableFactory.createUnaryCallable(
            createPolicyTransportSettings, settings.createPolicySettings(), clientContext);
    this.createPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createPolicyTransportSettings,
            settings.createPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePolicyCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTransportSettings, settings.updatePolicySettings(), clientContext);
    this.updatePolicyOperationCallable =
        callableFactory.createOperationCallable(
            updatePolicyTransportSettings,
            settings.updatePolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePolicyCallable =
        callableFactory.createUnaryCallable(
            deletePolicyTransportSettings, settings.deletePolicySettings(), clientContext);
    this.deletePolicyOperationCallable =
        callableFactory.createOperationCallable(
            deletePolicyTransportSettings,
            settings.deletePolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listPoliciesMethodDescriptor);
    methodDescriptors.add(getPolicyMethodDescriptor);
    methodDescriptors.add(createPolicyMethodDescriptor);
    methodDescriptors.add(updatePolicyMethodDescriptor);
    methodDescriptors.add(deletePolicyMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    return listPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse> listPoliciesPagedCallable() {
    return listPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<CreatePolicyRequest, Operation> createPolicyCallable() {
    return createPolicyCallable;
  }

  @Override
  public OperationCallable<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationCallable() {
    return createPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyRequest, Operation> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public OperationCallable<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationCallable() {
    return updatePolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyRequest, Operation> deletePolicyCallable() {
    return deletePolicyCallable;
  }

  @Override
  public OperationCallable<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationCallable() {
    return deletePolicyOperationCallable;
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
