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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3beta.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

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
import com.google.iam.v3beta.CreatePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.DeletePrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.GetPrincipalAccessBoundaryPolicyRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesRequest;
import com.google.iam.v3beta.ListPrincipalAccessBoundaryPoliciesResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.PrincipalAccessBoundaryPolicy;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsRequest;
import com.google.iam.v3beta.SearchPrincipalAccessBoundaryPolicyBindingsResponse;
import com.google.iam.v3beta.UpdatePrincipalAccessBoundaryPolicyRequest;
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
 * REST stub implementation for the PrincipalAccessBoundaryPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPrincipalAccessBoundaryPoliciesStub
    extends PrincipalAccessBoundaryPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(PrincipalAccessBoundaryPolicy.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/CreatePrincipalAccessBoundaryPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreatePrincipalAccessBoundaryPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{parent=organizations/*/locations/*}/principalAccessBoundaryPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "principalAccessBoundaryPolicyId",
                                request.getPrincipalAccessBoundaryPolicyId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "principalAccessBoundaryPolicy",
                                      request.getPrincipalAccessBoundaryPolicy(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePrincipalAccessBoundaryPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>newBuilder()
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/GetPrincipalAccessBoundaryPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrincipalAccessBoundaryPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{name=organizations/*/locations/*/principalAccessBoundaryPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrincipalAccessBoundaryPolicy>newBuilder()
                      .setDefaultInstance(PrincipalAccessBoundaryPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/UpdatePrincipalAccessBoundaryPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdatePrincipalAccessBoundaryPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{principalAccessBoundaryPolicy.name=organizations/*/locations/*/principalAccessBoundaryPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "principalAccessBoundaryPolicy.name",
                                request.getPrincipalAccessBoundaryPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "principalAccessBoundaryPolicy",
                                      request.getPrincipalAccessBoundaryPolicy(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePrincipalAccessBoundaryPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeletePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/DeletePrincipalAccessBoundaryPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeletePrincipalAccessBoundaryPolicyRequest>newBuilder()
                      .setPath(
                          "/v3beta/{name=organizations/*/locations/*/principalAccessBoundaryPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrincipalAccessBoundaryPolicyRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (DeletePrincipalAccessBoundaryPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrincipalAccessBoundaryPoliciesRequest,
                  ListPrincipalAccessBoundaryPoliciesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/ListPrincipalAccessBoundaryPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPrincipalAccessBoundaryPoliciesRequest>newBuilder()
                      .setPath(
                          "/v3beta/{parent=organizations/*/locations/*}/principalAccessBoundaryPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrincipalAccessBoundaryPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrincipalAccessBoundaryPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListPrincipalAccessBoundaryPoliciesResponse>newBuilder()
                      .setDefaultInstance(
                          ListPrincipalAccessBoundaryPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                  SearchPrincipalAccessBoundaryPolicyBindingsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.iam.v3beta.PrincipalAccessBoundaryPolicies/SearchPrincipalAccessBoundaryPolicyBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SearchPrincipalAccessBoundaryPolicyBindingsRequest>newBuilder()
                      .setPath(
                          "/v3beta/{name=organizations/*/locations/*/principalAccessBoundaryPolicies/*}:searchPolicyBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchPrincipalAccessBoundaryPolicyBindingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchPrincipalAccessBoundaryPolicyBindingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<SearchPrincipalAccessBoundaryPolicyBindingsResponse>newBuilder()
                      .setDefaultInstance(
                          SearchPrincipalAccessBoundaryPolicyBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyCallable;
  private final OperationCallable<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationCallable;
  private final UnaryCallable<
          GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyCallable;
  private final UnaryCallable<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyCallable;
  private final OperationCallable<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationCallable;
  private final UnaryCallable<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyCallable;
  private final OperationCallable<
          DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationCallable;
  private final UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesCallable;
  private final UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesPagedCallable;
  private final UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsCallable;
  private final UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPrincipalAccessBoundaryPoliciesStub create(
      PrincipalAccessBoundaryPoliciesStubSettings settings) throws IOException {
    return new HttpJsonPrincipalAccessBoundaryPoliciesStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonPrincipalAccessBoundaryPoliciesStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonPrincipalAccessBoundaryPoliciesStub(
        PrincipalAccessBoundaryPoliciesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPrincipalAccessBoundaryPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPrincipalAccessBoundaryPoliciesStub(
        PrincipalAccessBoundaryPoliciesStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPrincipalAccessBoundaryPoliciesStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonPrincipalAccessBoundaryPoliciesStub(
      PrincipalAccessBoundaryPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPrincipalAccessBoundaryPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPrincipalAccessBoundaryPoliciesStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonPrincipalAccessBoundaryPoliciesStub(
      PrincipalAccessBoundaryPoliciesStubSettings settings,
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

    HttpJsonCallSettings<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
        createPrincipalAccessBoundaryPolicyTransportSettings =
            HttpJsonCallSettings.<CreatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrincipalAccessBoundaryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
        getPrincipalAccessBoundaryPolicyTransportSettings =
            HttpJsonCallSettings
                .<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
                    newBuilder()
                .setMethodDescriptor(getPrincipalAccessBoundaryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
        updatePrincipalAccessBoundaryPolicyTransportSettings =
            HttpJsonCallSettings.<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePrincipalAccessBoundaryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "principal_access_boundary_policy.name",
                          String.valueOf(request.getPrincipalAccessBoundaryPolicy().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
        deletePrincipalAccessBoundaryPolicyTransportSettings =
            HttpJsonCallSettings.<DeletePrincipalAccessBoundaryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrincipalAccessBoundaryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
        listPrincipalAccessBoundaryPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListPrincipalAccessBoundaryPoliciesRequest,
                    ListPrincipalAccessBoundaryPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listPrincipalAccessBoundaryPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            SearchPrincipalAccessBoundaryPolicyBindingsRequest,
            SearchPrincipalAccessBoundaryPolicyBindingsResponse>
        searchPrincipalAccessBoundaryPolicyBindingsTransportSettings =
            HttpJsonCallSettings
                .<SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                    SearchPrincipalAccessBoundaryPolicyBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(searchPrincipalAccessBoundaryPolicyBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createPrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            createPrincipalAccessBoundaryPolicyTransportSettings,
            settings.createPrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.createPrincipalAccessBoundaryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createPrincipalAccessBoundaryPolicyTransportSettings,
            settings.createPrincipalAccessBoundaryPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            getPrincipalAccessBoundaryPolicyTransportSettings,
            settings.getPrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.updatePrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            updatePrincipalAccessBoundaryPolicyTransportSettings,
            settings.updatePrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.updatePrincipalAccessBoundaryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updatePrincipalAccessBoundaryPolicyTransportSettings,
            settings.updatePrincipalAccessBoundaryPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePrincipalAccessBoundaryPolicyCallable =
        callableFactory.createUnaryCallable(
            deletePrincipalAccessBoundaryPolicyTransportSettings,
            settings.deletePrincipalAccessBoundaryPolicySettings(),
            clientContext);
    this.deletePrincipalAccessBoundaryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deletePrincipalAccessBoundaryPolicyTransportSettings,
            settings.deletePrincipalAccessBoundaryPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listPrincipalAccessBoundaryPoliciesCallable =
        callableFactory.createUnaryCallable(
            listPrincipalAccessBoundaryPoliciesTransportSettings,
            settings.listPrincipalAccessBoundaryPoliciesSettings(),
            clientContext);
    this.listPrincipalAccessBoundaryPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listPrincipalAccessBoundaryPoliciesTransportSettings,
            settings.listPrincipalAccessBoundaryPoliciesSettings(),
            clientContext);
    this.searchPrincipalAccessBoundaryPolicyBindingsCallable =
        callableFactory.createUnaryCallable(
            searchPrincipalAccessBoundaryPolicyBindingsTransportSettings,
            settings.searchPrincipalAccessBoundaryPolicyBindingsSettings(),
            clientContext);
    this.searchPrincipalAccessBoundaryPolicyBindingsPagedCallable =
        callableFactory.createPagedCallable(
            searchPrincipalAccessBoundaryPolicyBindingsTransportSettings,
            settings.searchPrincipalAccessBoundaryPolicyBindingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createPrincipalAccessBoundaryPolicyMethodDescriptor);
    methodDescriptors.add(getPrincipalAccessBoundaryPolicyMethodDescriptor);
    methodDescriptors.add(updatePrincipalAccessBoundaryPolicyMethodDescriptor);
    methodDescriptors.add(deletePrincipalAccessBoundaryPolicyMethodDescriptor);
    methodDescriptors.add(listPrincipalAccessBoundaryPoliciesMethodDescriptor);
    methodDescriptors.add(searchPrincipalAccessBoundaryPolicyBindingsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyCallable() {
    return createPrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public OperationCallable<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationCallable() {
    return createPrincipalAccessBoundaryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyCallable() {
    return getPrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyCallable() {
    return updatePrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationCallable() {
    return updatePrincipalAccessBoundaryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyCallable() {
    return deletePrincipalAccessBoundaryPolicyCallable;
  }

  @Override
  public OperationCallable<DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationCallable() {
    return deletePrincipalAccessBoundaryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesCallable() {
    return listPrincipalAccessBoundaryPoliciesCallable;
  }

  @Override
  public UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesPagedCallable() {
    return listPrincipalAccessBoundaryPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsCallable() {
    return searchPrincipalAccessBoundaryPolicyBindingsCallable;
  }

  @Override
  public UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsPagedCallable() {
    return searchPrincipalAccessBoundaryPolicyBindingsPagedCallable;
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
