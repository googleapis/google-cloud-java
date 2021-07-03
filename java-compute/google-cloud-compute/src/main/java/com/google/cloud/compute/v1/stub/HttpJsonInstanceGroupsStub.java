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

import static com.google.cloud.compute.v1.InstanceGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupRequest;
import com.google.cloud.compute.v1.GetInstanceGroupRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.ListInstanceGroupsRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the InstanceGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonInstanceGroupsStub extends InstanceGroupsStub {
  private static final ApiMethodDescriptor<AddInstancesInstanceGroupRequest, Operation>
      addInstancesMethodDescriptor =
          ApiMethodDescriptor.<AddInstancesInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/AddInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddInstancesInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/addInstances",
                          new FieldsExtractor<
                              AddInstancesInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddInstancesInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddInstancesInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddInstancesInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddInstancesInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddInstancesInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddInstancesInstanceGroupRequest, String>() {
                            @Override
                            public String extract(AddInstancesInstanceGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupsAddInstancesRequestResource",
                                      request.getInstanceGroupsAddInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/instanceGroups",
                          new FieldsExtractor<
                              AggregatedListInstanceGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListInstanceGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListInstanceGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListInstanceGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListInstanceGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListInstanceGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
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
                          new FieldsExtractor<AggregatedListInstanceGroupsRequest, String>() {
                            @Override
                            public String extract(AggregatedListInstanceGroupsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupAggregatedList>newBuilder()
                      .setDefaultInstance(InstanceGroupAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}",
                          new FieldsExtractor<DeleteInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteInstanceGroupRequest, String>() {
                            @Override
                            public String extract(DeleteInstanceGroupRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceGroupRequest, InstanceGroup>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceGroupRequest, InstanceGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}",
                          new FieldsExtractor<GetInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetInstanceGroupRequest, String>() {
                            @Override
                            public String extract(GetInstanceGroupRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroup>newBuilder()
                      .setDefaultInstance(InstanceGroup.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInstanceGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups",
                          new FieldsExtractor<InsertInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertInstanceGroupRequest, String>() {
                            @Override
                            public String extract(InsertInstanceGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupResource", request.getInstanceGroupResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListInstanceGroupsRequest, InstanceGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListInstanceGroupsRequest, InstanceGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups",
                          new FieldsExtractor<ListInstanceGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListInstanceGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstanceGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListInstanceGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListInstanceGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstanceGroupsRequest> serializer =
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
                          new FieldsExtractor<ListInstanceGroupsRequest, String>() {
                            @Override
                            public String extract(ListInstanceGroupsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupList>newBuilder()
                      .setDefaultInstance(InstanceGroupList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/ListInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/listInstances",
                          new FieldsExtractor<
                              ListInstancesInstanceGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListInstancesInstanceGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstancesInstanceGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListInstancesInstanceGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListInstancesInstanceGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstancesInstanceGroupsRequest> serializer =
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
                          new FieldsExtractor<ListInstancesInstanceGroupsRequest, String>() {
                            @Override
                            public String extract(ListInstancesInstanceGroupsRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupsListInstancesRequestResource",
                                      request.getInstanceGroupsListInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupsListInstances>newBuilder()
                      .setDefaultInstance(InstanceGroupsListInstances.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesMethodDescriptor =
          ApiMethodDescriptor.<RemoveInstancesInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/RemoveInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveInstancesInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/removeInstances",
                          new FieldsExtractor<
                              RemoveInstancesInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveInstancesInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveInstancesInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveInstancesInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveInstancesInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveInstancesInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveInstancesInstanceGroupRequest, String>() {
                            @Override
                            public String extract(RemoveInstancesInstanceGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupsRemoveInstancesRequestResource",
                                      request.getInstanceGroupsRemoveInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNamedPortsInstanceGroupRequest, Operation>
      setNamedPortsMethodDescriptor =
          ApiMethodDescriptor.<SetNamedPortsInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroups/SetNamedPorts")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNamedPortsInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroups/{instanceGroup}/setNamedPorts",
                          new FieldsExtractor<
                              SetNamedPortsInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetNamedPortsInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetNamedPortsInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetNamedPortsInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetNamedPortsInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetNamedPortsInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetNamedPortsInstanceGroupRequest, String>() {
                            @Override
                            public String extract(SetNamedPortsInstanceGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupsSetNamedPortsRequestResource",
                                      request.getInstanceGroupsSetNamedPortsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AddInstancesInstanceGroupRequest, Operation> addInstancesCallable;
  private final UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListInstanceGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteInstanceGroupRequest, Operation> deleteCallable;
  private final UnaryCallable<GetInstanceGroupRequest, InstanceGroup> getCallable;
  private final UnaryCallable<InsertInstanceGroupRequest, Operation> insertCallable;
  private final UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> listCallable;
  private final UnaryCallable<ListInstanceGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesCallable;
  private final UnaryCallable<ListInstancesInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesCallable;
  private final UnaryCallable<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupsStub create(InstanceGroupsStubSettings settings)
      throws IOException {
    return new HttpJsonInstanceGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceGroupsStub(
        InstanceGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupsStub(
        InstanceGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupsStub(
      InstanceGroupsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupsStub(
      InstanceGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddInstancesInstanceGroupRequest, Operation>
        addInstancesTransportSettings =
            HttpJsonCallSettings.<AddInstancesInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(addInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetInstanceGroupRequest, InstanceGroup> getTransportSettings =
        HttpJsonCallSettings.<GetInstanceGroupRequest, InstanceGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertInstanceGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListInstanceGroupsRequest, InstanceGroupList> listTransportSettings =
        HttpJsonCallSettings.<ListInstanceGroupsRequest, InstanceGroupList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
        listInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveInstancesInstanceGroupRequest, Operation>
        removeInstancesTransportSettings =
            HttpJsonCallSettings.<RemoveInstancesInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(removeInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetNamedPortsInstanceGroupRequest, Operation>
        setNamedPortsTransportSettings =
            HttpJsonCallSettings.<SetNamedPortsInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(setNamedPortsMethodDescriptor)
                .build();

    this.addInstancesCallable =
        callableFactory.createUnaryCallable(
            addInstancesTransportSettings, settings.addInstancesSettings(), clientContext);
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
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.removeInstancesCallable =
        callableFactory.createUnaryCallable(
            removeInstancesTransportSettings, settings.removeInstancesSettings(), clientContext);
    this.setNamedPortsCallable =
        callableFactory.createUnaryCallable(
            setNamedPortsTransportSettings, settings.setNamedPortsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addInstancesMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(removeInstancesMethodDescriptor);
    methodDescriptors.add(setNamedPortsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddInstancesInstanceGroupRequest, Operation> addInstancesCallable() {
    return addInstancesCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstanceGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetInstanceGroupRequest, InstanceGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertInstanceGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<RemoveInstancesInstanceGroupRequest, Operation> removeInstancesCallable() {
    return removeInstancesCallable;
  }

  @Override
  public UnaryCallable<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsCallable() {
    return setNamedPortsCallable;
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
