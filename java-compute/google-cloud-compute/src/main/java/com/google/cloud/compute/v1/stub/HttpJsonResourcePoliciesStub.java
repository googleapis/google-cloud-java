/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ResourcePoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.ResourcePoliciesClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListResourcePoliciesRequest;
import com.google.cloud.compute.v1.DeleteResourcePolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyResourcePolicyRequest;
import com.google.cloud.compute.v1.GetResourcePolicyRequest;
import com.google.cloud.compute.v1.InsertResourcePolicyRequest;
import com.google.cloud.compute.v1.ListResourcePoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ResourcePolicy;
import com.google.cloud.compute.v1.ResourcePolicyAggregatedList;
import com.google.cloud.compute.v1.ResourcePolicyList;
import com.google.cloud.compute.v1.SetIamPolicyResourcePolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsResourcePolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ResourcePolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonResourcePoliciesStub extends ResourcePoliciesStub {
  private static final ApiMethodDescriptor<
          AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListResourcePoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/resourcePolicies",
                          new FieldsExtractor<
                              AggregatedListResourcePoliciesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListResourcePoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListResourcePoliciesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListResourcePoliciesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListResourcePoliciesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListResourcePoliciesRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasIncludeAllScopes()) {
                                serializer.putQueryParam(
                                    fields, "includeAllScopes", request.getIncludeAllScopes());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AggregatedListResourcePoliciesRequest, String>() {
                            @Override
                            public String extract(AggregatedListResourcePoliciesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourcePolicyAggregatedList>newBuilder()
                      .setDefaultInstance(ResourcePolicyAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteResourcePolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteResourcePolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteResourcePolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies/{resourcePolicy}",
                          new FieldsExtractor<DeleteResourcePolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteResourcePolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "resourcePolicy", request.getResourcePolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteResourcePolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteResourcePolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteResourcePolicyRequest, String>() {
                            @Override
                            public String extract(DeleteResourcePolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetResourcePolicyRequest, ResourcePolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetResourcePolicyRequest, ResourcePolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourcePolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies/{resourcePolicy}",
                          new FieldsExtractor<GetResourcePolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetResourcePolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "resourcePolicy", request.getResourcePolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetResourcePolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetResourcePolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetResourcePolicyRequest, String>() {
                            @Override
                            public String extract(GetResourcePolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourcePolicy>newBuilder()
                      .setDefaultInstance(ResourcePolicy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyResourcePolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyResourcePolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyResourcePolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies/{resource}/getIamPolicy",
                          new FieldsExtractor<
                              GetIamPolicyResourcePolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyResourcePolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyResourcePolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyResourcePolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyResourcePolicyRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyResourcePolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertResourcePolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertResourcePolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertResourcePolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies",
                          new FieldsExtractor<InsertResourcePolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertResourcePolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertResourcePolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertResourcePolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertResourcePolicyRequest, String>() {
                            @Override
                            public String extract(InsertResourcePolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "resourcePolicyResource",
                                      request.getResourcePolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListResourcePoliciesRequest, ResourcePolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListResourcePoliciesRequest, ResourcePolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourcePoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies",
                          new FieldsExtractor<ListResourcePoliciesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListResourcePoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListResourcePoliciesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListResourcePoliciesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListResourcePoliciesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListResourcePoliciesRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListResourcePoliciesRequest, String>() {
                            @Override
                            public String extract(ListResourcePoliciesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourcePolicyList>newBuilder()
                      .setDefaultInstance(ResourcePolicyList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyResourcePolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyResourcePolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyResourcePolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies/{resource}/setIamPolicy",
                          new FieldsExtractor<
                              SetIamPolicyResourcePolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyResourcePolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyResourcePolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyResourcePolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyResourcePolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyResourcePolicyRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyResourcePolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetPolicyRequestResource",
                                      request.getRegionSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ResourcePolicies/TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsResourcePolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/resourcePolicies/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsResourcePolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsResourcePolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsResourcePolicyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsResourcePolicyRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsResourcePolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsResourcePolicyRequest>
                                  serializer = ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsResourcePolicyRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsResourcePolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListResourcePoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteResourcePolicyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetResourcePolicyRequest, ResourcePolicy> getCallable;
  private final UnaryCallable<GetIamPolicyResourcePolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertResourcePolicyRequest, Operation> insertCallable;
  private final UnaryCallable<ListResourcePoliciesRequest, ResourcePolicyList> listCallable;
  private final UnaryCallable<ListResourcePoliciesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetIamPolicyResourcePolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonResourcePoliciesStub create(ResourcePoliciesStubSettings settings)
      throws IOException {
    return new HttpJsonResourcePoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonResourcePoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonResourcePoliciesStub(
        ResourcePoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonResourcePoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonResourcePoliciesStub(
        ResourcePoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonResourcePoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonResourcePoliciesStub(
      ResourcePoliciesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonResourcePoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonResourcePoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonResourcePoliciesStub(
      ResourcePoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteResourcePolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteResourcePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetResourcePolicyRequest, ResourcePolicy> getTransportSettings =
        HttpJsonCallSettings.<GetResourcePolicyRequest, ResourcePolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyResourcePolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyResourcePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertResourcePolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertResourcePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListResourcePoliciesRequest, ResourcePolicyList> listTransportSettings =
        HttpJsonCallSettings.<ListResourcePoliciesRequest, ResourcePolicyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyResourcePolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyResourcePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
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
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListResourcePoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteResourcePolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetResourcePolicyRequest, ResourcePolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyResourcePolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertResourcePolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListResourcePoliciesRequest, ResourcePolicyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListResourcePoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyResourcePolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
