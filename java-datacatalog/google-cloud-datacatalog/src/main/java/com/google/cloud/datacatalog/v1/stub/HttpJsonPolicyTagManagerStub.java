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

package com.google.cloud.datacatalog.v1.stub;

import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListPolicyTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListTaxonomiesPagedResponse;

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
import com.google.cloud.datacatalog.v1.CreatePolicyTagRequest;
import com.google.cloud.datacatalog.v1.CreateTaxonomyRequest;
import com.google.cloud.datacatalog.v1.DeletePolicyTagRequest;
import com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest;
import com.google.cloud.datacatalog.v1.GetPolicyTagRequest;
import com.google.cloud.datacatalog.v1.GetTaxonomyRequest;
import com.google.cloud.datacatalog.v1.ListPolicyTagsRequest;
import com.google.cloud.datacatalog.v1.ListPolicyTagsResponse;
import com.google.cloud.datacatalog.v1.ListTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ListTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.PolicyTag;
import com.google.cloud.datacatalog.v1.Taxonomy;
import com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest;
import com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the PolicyTagManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPolicyTagManagerStub extends PolicyTagManagerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateTaxonomyRequest, Taxonomy>
      createTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<CreateTaxonomyRequest, Taxonomy>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/CreateTaxonomy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/taxonomies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("taxonomy", request.getTaxonomy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Taxonomy>newBuilder()
                      .setDefaultInstance(Taxonomy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTaxonomyRequest, Empty>
      deleteTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTaxonomyRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/DeleteTaxonomy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/taxonomies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTaxonomyRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdateTaxonomyRequest, Taxonomy>
      updateTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<UpdateTaxonomyRequest, Taxonomy>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/UpdateTaxonomy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{taxonomy.name=projects/*/locations/*/taxonomies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "taxonomy.name", request.getTaxonomy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("taxonomy", request.getTaxonomy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Taxonomy>newBuilder()
                      .setDefaultInstance(Taxonomy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTaxonomiesRequest, ListTaxonomiesResponse>
      listTaxonomiesMethodDescriptor =
          ApiMethodDescriptor.<ListTaxonomiesRequest, ListTaxonomiesResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/ListTaxonomies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTaxonomiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/taxonomies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTaxonomiesResponse>newBuilder()
                      .setDefaultInstance(ListTaxonomiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTaxonomyRequest, Taxonomy>
      getTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<GetTaxonomyRequest, Taxonomy>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/GetTaxonomy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/taxonomies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Taxonomy>newBuilder()
                      .setDefaultInstance(Taxonomy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePolicyTagRequest, PolicyTag>
      createPolicyTagMethodDescriptor =
          ApiMethodDescriptor.<CreatePolicyTagRequest, PolicyTag>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/CreatePolicyTag")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePolicyTagRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/taxonomies/*}/policyTags",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policyTag", request.getPolicyTag(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PolicyTag>newBuilder()
                      .setDefaultInstance(PolicyTag.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePolicyTagRequest, Empty>
      deletePolicyTagMethodDescriptor =
          ApiMethodDescriptor.<DeletePolicyTagRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/DeletePolicyTag")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePolicyTagRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/taxonomies/*/policyTags/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePolicyTagRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdatePolicyTagRequest, PolicyTag>
      updatePolicyTagMethodDescriptor =
          ApiMethodDescriptor.<UpdatePolicyTagRequest, PolicyTag>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/UpdatePolicyTag")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePolicyTagRequest>newBuilder()
                      .setPath(
                          "/v1/{policyTag.name=projects/*/locations/*/taxonomies/*/policyTags/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policyTag.name", request.getPolicyTag().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policyTag", request.getPolicyTag(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PolicyTag>newBuilder()
                      .setDefaultInstance(PolicyTag.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPolicyTagsRequest, ListPolicyTagsResponse>
      listPolicyTagsMethodDescriptor =
          ApiMethodDescriptor.<ListPolicyTagsRequest, ListPolicyTagsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/ListPolicyTags")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPolicyTagsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/taxonomies/*}/policyTags",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPolicyTagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPolicyTagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPolicyTagsResponse>newBuilder()
                      .setDefaultInstance(ListPolicyTagsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPolicyTagRequest, PolicyTag>
      getPolicyTagMethodDescriptor =
          ApiMethodDescriptor.<GetPolicyTagRequest, PolicyTag>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/GetPolicyTag")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPolicyTagRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/taxonomies/*/policyTags/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPolicyTagRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PolicyTag>newBuilder()
                      .setDefaultInstance(PolicyTag.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/taxonomies/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/taxonomies/*/policyTags/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/taxonomies/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/taxonomies/*/policyTags/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/taxonomies/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/taxonomies/*/policyTags/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable;
  private final UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable;
  private final UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable;
  private final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse> listTaxonomiesCallable;
  private final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesPagedResponse>
      listTaxonomiesPagedCallable;
  private final UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable;
  private final UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable;
  private final UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable;
  private final UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable;
  private final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse> listPolicyTagsCallable;
  private final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsPagedResponse>
      listPolicyTagsPagedCallable;
  private final UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPolicyTagManagerStub create(PolicyTagManagerStubSettings settings)
      throws IOException {
    return new HttpJsonPolicyTagManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPolicyTagManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPolicyTagManagerStub(
        PolicyTagManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPolicyTagManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPolicyTagManagerStub(
        PolicyTagManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPolicyTagManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPolicyTagManagerStub(
      PolicyTagManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPolicyTagManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPolicyTagManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPolicyTagManagerStub(
      PolicyTagManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateTaxonomyRequest, Taxonomy> createTaxonomyTransportSettings =
        HttpJsonCallSettings.<CreateTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(createTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTaxonomyRequest, Empty> deleteTaxonomyTransportSettings =
        HttpJsonCallSettings.<DeleteTaxonomyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyTransportSettings =
        HttpJsonCallSettings.<UpdateTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(updateTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTaxonomiesRequest, ListTaxonomiesResponse>
        listTaxonomiesTransportSettings =
            HttpJsonCallSettings.<ListTaxonomiesRequest, ListTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(listTaxonomiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTaxonomyRequest, Taxonomy> getTaxonomyTransportSettings =
        HttpJsonCallSettings.<GetTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(getTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreatePolicyTagRequest, PolicyTag> createPolicyTagTransportSettings =
        HttpJsonCallSettings.<CreatePolicyTagRequest, PolicyTag>newBuilder()
            .setMethodDescriptor(createPolicyTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePolicyTagRequest, Empty> deletePolicyTagTransportSettings =
        HttpJsonCallSettings.<DeletePolicyTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePolicyTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagTransportSettings =
        HttpJsonCallSettings.<UpdatePolicyTagRequest, PolicyTag>newBuilder()
            .setMethodDescriptor(updatePolicyTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListPolicyTagsRequest, ListPolicyTagsResponse>
        listPolicyTagsTransportSettings =
            HttpJsonCallSettings.<ListPolicyTagsRequest, ListPolicyTagsResponse>newBuilder()
                .setMethodDescriptor(listPolicyTagsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPolicyTagRequest, PolicyTag> getPolicyTagTransportSettings =
        HttpJsonCallSettings.<GetPolicyTagRequest, PolicyTag>newBuilder()
            .setMethodDescriptor(getPolicyTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createTaxonomyCallable =
        callableFactory.createUnaryCallable(
            createTaxonomyTransportSettings, settings.createTaxonomySettings(), clientContext);
    this.deleteTaxonomyCallable =
        callableFactory.createUnaryCallable(
            deleteTaxonomyTransportSettings, settings.deleteTaxonomySettings(), clientContext);
    this.updateTaxonomyCallable =
        callableFactory.createUnaryCallable(
            updateTaxonomyTransportSettings, settings.updateTaxonomySettings(), clientContext);
    this.listTaxonomiesCallable =
        callableFactory.createUnaryCallable(
            listTaxonomiesTransportSettings, settings.listTaxonomiesSettings(), clientContext);
    this.listTaxonomiesPagedCallable =
        callableFactory.createPagedCallable(
            listTaxonomiesTransportSettings, settings.listTaxonomiesSettings(), clientContext);
    this.getTaxonomyCallable =
        callableFactory.createUnaryCallable(
            getTaxonomyTransportSettings, settings.getTaxonomySettings(), clientContext);
    this.createPolicyTagCallable =
        callableFactory.createUnaryCallable(
            createPolicyTagTransportSettings, settings.createPolicyTagSettings(), clientContext);
    this.deletePolicyTagCallable =
        callableFactory.createUnaryCallable(
            deletePolicyTagTransportSettings, settings.deletePolicyTagSettings(), clientContext);
    this.updatePolicyTagCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTagTransportSettings, settings.updatePolicyTagSettings(), clientContext);
    this.listPolicyTagsCallable =
        callableFactory.createUnaryCallable(
            listPolicyTagsTransportSettings, settings.listPolicyTagsSettings(), clientContext);
    this.listPolicyTagsPagedCallable =
        callableFactory.createPagedCallable(
            listPolicyTagsTransportSettings, settings.listPolicyTagsSettings(), clientContext);
    this.getPolicyTagCallable =
        callableFactory.createUnaryCallable(
            getPolicyTagTransportSettings, settings.getPolicyTagSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createTaxonomyMethodDescriptor);
    methodDescriptors.add(deleteTaxonomyMethodDescriptor);
    methodDescriptors.add(updateTaxonomyMethodDescriptor);
    methodDescriptors.add(listTaxonomiesMethodDescriptor);
    methodDescriptors.add(getTaxonomyMethodDescriptor);
    methodDescriptors.add(createPolicyTagMethodDescriptor);
    methodDescriptors.add(deletePolicyTagMethodDescriptor);
    methodDescriptors.add(updatePolicyTagMethodDescriptor);
    methodDescriptors.add(listPolicyTagsMethodDescriptor);
    methodDescriptors.add(getPolicyTagMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable() {
    return createTaxonomyCallable;
  }

  @Override
  public UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable() {
    return deleteTaxonomyCallable;
  }

  @Override
  public UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable() {
    return updateTaxonomyCallable;
  }

  @Override
  public UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse> listTaxonomiesCallable() {
    return listTaxonomiesCallable;
  }

  @Override
  public UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesPagedResponse>
      listTaxonomiesPagedCallable() {
    return listTaxonomiesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable() {
    return getTaxonomyCallable;
  }

  @Override
  public UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable() {
    return createPolicyTagCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable() {
    return deletePolicyTagCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable() {
    return updatePolicyTagCallable;
  }

  @Override
  public UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse> listPolicyTagsCallable() {
    return listPolicyTagsCallable;
  }

  @Override
  public UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsPagedResponse>
      listPolicyTagsPagedCallable() {
    return listPolicyTagsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable() {
    return getPolicyTagCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
