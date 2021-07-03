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

import static com.google.cloud.compute.v1.InstanceGroupManagersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

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
import com.google.cloud.compute.v1.AbandonInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.CreateInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.GetInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagerAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupManagerList;
import com.google.cloud.compute.v1.InstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListManagedInstancesResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListPerInstanceConfigsResp;
import com.google.cloud.compute.v1.ListErrorsInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListManagedInstancesInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RecreateInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.ResizeInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetTargetPoolsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsInstanceGroupManagerRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the InstanceGroupManagers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonInstanceGroupManagersStub extends InstanceGroupManagersStub {
  private static final ApiMethodDescriptor<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesMethodDescriptor =
          ApiMethodDescriptor.<AbandonInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/AbandonInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AbandonInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/abandonInstances",
                          new FieldsExtractor<
                              AbandonInstancesInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AbandonInstancesInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AbandonInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AbandonInstancesInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AbandonInstancesInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AbandonInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              AbandonInstancesInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                AbandonInstancesInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersAbandonInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersAbandonInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/instanceGroupManagers",
                          new FieldsExtractor<
                              AggregatedListInstanceGroupManagersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListInstanceGroupManagersRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListInstanceGroupManagersRequest>
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
                          new FieldsExtractor<
                              AggregatedListInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(
                                AggregatedListInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManagerAggregatedList>newBuilder()
                      .setDefaultInstance(InstanceGroupManagerAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/ApplyUpdatesToInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ApplyUpdatesToInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances",
                          new FieldsExtractor<
                              ApplyUpdatesToInstancesInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ApplyUpdatesToInstancesInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ApplyUpdatesToInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ApplyUpdatesToInstancesInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ApplyUpdatesToInstancesInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ApplyUpdatesToInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              ApplyUpdatesToInstancesInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                ApplyUpdatesToInstancesInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersApplyUpdatesRequestResource",
                                      request
                                          .getInstanceGroupManagersApplyUpdatesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesMethodDescriptor =
          ApiMethodDescriptor.<CreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/CreateInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/createInstances",
                          new FieldsExtractor<
                              CreateInstancesInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                CreateInstancesInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<CreateInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              CreateInstancesInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                CreateInstancesInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<CreateInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              CreateInstancesInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                CreateInstancesInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersCreateInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersCreateInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceGroupManagerRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}",
                          new FieldsExtractor<
                              DeleteInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(DeleteInstanceGroupManagerRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/DeleteInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deleteInstances",
                          new FieldsExtractor<
                              DeleteInstancesInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteInstancesInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteInstancesInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteInstancesInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              DeleteInstancesInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                DeleteInstancesInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersDeleteInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersDeleteInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/DeletePerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeletePerInstanceConfigsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs",
                          new FieldsExtractor<
                              DeletePerInstanceConfigsInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeletePerInstanceConfigsInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      DeletePerInstanceConfigsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeletePerInstanceConfigsInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeletePerInstanceConfigsInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      DeletePerInstanceConfigsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              DeletePerInstanceConfigsInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                DeletePerInstanceConfigsInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersDeletePerInstanceConfigsReqResource",
                                      request
                                          .getInstanceGroupManagersDeletePerInstanceConfigsReqResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceGroupManagerRequest, InstanceGroupManager>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}",
                          new FieldsExtractor<
                              GetInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(GetInstanceGroupManagerRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManager>newBuilder()
                      .setDefaultInstance(InstanceGroupManager.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInstanceGroupManagerRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers",
                          new FieldsExtractor<
                              InsertInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(InsertInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagerResource",
                                      request.getInstanceGroupManagerResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListInstanceGroupManagersRequest, InstanceGroupManagerList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstanceGroupManagersRequest, InstanceGroupManagerList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers",
                          new FieldsExtractor<
                              ListInstanceGroupManagersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstanceGroupManagersRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListInstanceGroupManagersRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstanceGroupManagersRequest> serializer =
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
                          new FieldsExtractor<ListInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(ListInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManagerList>newBuilder()
                      .setDefaultInstance(InstanceGroupManagerList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/ListErrors")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListErrorsInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listErrors",
                          new FieldsExtractor<
                              ListErrorsInstanceGroupManagersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListErrorsInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListErrorsInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListErrorsInstanceGroupManagersRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListErrorsInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListErrorsInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
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
                          new FieldsExtractor<ListErrorsInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(ListErrorsInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManagersListErrorsResponse>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagersListErrorsResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagedInstancesInstanceGroupManagersRequest,
                  InstanceGroupManagersListManagedInstancesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/ListManagedInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListManagedInstancesInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances",
                          new FieldsExtractor<
                              ListManagedInstancesInstanceGroupManagersRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListManagedInstancesInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListManagedInstancesInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListManagedInstancesInstanceGroupManagersRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListManagedInstancesInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListManagedInstancesInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
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
                          new FieldsExtractor<
                              ListManagedInstancesInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(
                                ListManagedInstancesInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<InstanceGroupManagersListManagedInstancesResponse>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagersListManagedInstancesResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPerInstanceConfigsInstanceGroupManagersRequest,
                  InstanceGroupManagersListPerInstanceConfigsResp>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/ListPerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPerInstanceConfigsInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs",
                          new FieldsExtractor<
                              ListPerInstanceConfigsInstanceGroupManagersRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListPerInstanceConfigsInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListPerInstanceConfigsInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListPerInstanceConfigsInstanceGroupManagersRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListPerInstanceConfigsInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListPerInstanceConfigsInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
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
                          new FieldsExtractor<
                              ListPerInstanceConfigsInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(
                                ListPerInstanceConfigsInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<InstanceGroupManagersListPerInstanceConfigsResp>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagersListPerInstanceConfigsResp.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchInstanceGroupManagerRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}",
                          new FieldsExtractor<
                              PatchInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(PatchInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagerResource",
                                      request.getInstanceGroupManagerResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/PatchPerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchPerInstanceConfigsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs",
                          new FieldsExtractor<
                              PatchPerInstanceConfigsInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchPerInstanceConfigsInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      PatchPerInstanceConfigsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchPerInstanceConfigsInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchPerInstanceConfigsInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      PatchPerInstanceConfigsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              PatchPerInstanceConfigsInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                PatchPerInstanceConfigsInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersPatchPerInstanceConfigsReqResource",
                                      request
                                          .getInstanceGroupManagersPatchPerInstanceConfigsReqResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesMethodDescriptor =
          ApiMethodDescriptor.<RecreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/RecreateInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RecreateInstancesInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/recreateInstances",
                          new FieldsExtractor<
                              RecreateInstancesInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RecreateInstancesInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RecreateInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RecreateInstancesInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RecreateInstancesInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RecreateInstancesInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              RecreateInstancesInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                RecreateInstancesInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersRecreateInstancesRequestResource",
                                      request
                                          .getInstanceGroupManagersRecreateInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResizeInstanceGroupManagerRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/Resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resize",
                          new FieldsExtractor<
                              ResizeInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ResizeInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ResizeInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ResizeInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              serializer.putQueryParam(fields, "size", request.getSize());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ResizeInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(ResizeInstanceGroupManagerRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<SetInstanceTemplateInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/SetInstanceTemplate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetInstanceTemplateInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate",
                          new FieldsExtractor<
                              SetInstanceTemplateInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetInstanceTemplateInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetInstanceTemplateInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetInstanceTemplateInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetInstanceTemplateInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetInstanceTemplateInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              SetInstanceTemplateInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                SetInstanceTemplateInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersSetInstanceTemplateRequestResource",
                                      request
                                          .getInstanceGroupManagersSetInstanceTemplateRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsMethodDescriptor =
          ApiMethodDescriptor.<SetTargetPoolsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagers/SetTargetPools")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetTargetPoolsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setTargetPools",
                          new FieldsExtractor<
                              SetTargetPoolsInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetTargetPoolsInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetTargetPoolsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetTargetPoolsInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetTargetPoolsInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetTargetPoolsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetTargetPoolsInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                SetTargetPoolsInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersSetTargetPoolsRequestResource",
                                      request
                                          .getInstanceGroupManagersSetTargetPoolsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagers/UpdatePerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdatePerInstanceConfigsInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs",
                          new FieldsExtractor<
                              UpdatePerInstanceConfigsInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdatePerInstanceConfigsInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      UpdatePerInstanceConfigsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdatePerInstanceConfigsInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdatePerInstanceConfigsInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      UpdatePerInstanceConfigsInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              UpdatePerInstanceConfigsInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                UpdatePerInstanceConfigsInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceGroupManagersUpdatePerInstanceConfigsReqResource",
                                      request
                                          .getInstanceGroupManagersUpdatePerInstanceConfigsReqResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable;
  private final UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable;
  private final UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable;
  private final UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable;
  private final UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable;
  private final UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable;
  private final UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable;
  private final UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList>
      listCallable;
  private final UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable;
  private final UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable;
  private final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesCallable;
  private final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable;
  private final UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable;
  private final UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable;
  private final UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable;
  private final UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable;
  private final UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable;
  private final UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable;
  private final UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupManagersStub create(
      InstanceGroupManagersStubSettings settings) throws IOException {
    return new HttpJsonInstanceGroupManagersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupManagersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceGroupManagersStub(
        InstanceGroupManagersStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupManagersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupManagersStub(
        InstanceGroupManagersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupManagersStub(
      InstanceGroupManagersStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupManagersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupManagersStub(
      InstanceGroupManagersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AbandonInstancesInstanceGroupManagerRequest, Operation>
        abandonInstancesTransportSettings =
            HttpJsonCallSettings
                .<AbandonInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(abandonInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
        applyUpdatesToInstancesTransportSettings =
            HttpJsonCallSettings
                .<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(applyUpdatesToInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateInstancesInstanceGroupManagerRequest, Operation>
        createInstancesTransportSettings =
            HttpJsonCallSettings.<CreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(createInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupManagerRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteInstancesInstanceGroupManagerRequest, Operation>
        deleteInstancesTransportSettings =
            HttpJsonCallSettings.<DeleteInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
        deletePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePerInstanceConfigsMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetInstanceGroupManagerRequest, InstanceGroupManager>
        getTransportSettings =
            HttpJsonCallSettings.<GetInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInstanceGroupManagerRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListInstanceGroupManagersRequest, InstanceGroupManagerList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListInstanceGroupManagersRequest, InstanceGroupManagerList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
        listErrorsTransportSettings =
            HttpJsonCallSettings
                .<ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
                    newBuilder()
                .setMethodDescriptor(listErrorsMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListManagedInstancesInstanceGroupManagersRequest,
            InstanceGroupManagersListManagedInstancesResponse>
        listManagedInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListManagedInstancesInstanceGroupManagersRequest,
                    InstanceGroupManagersListManagedInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listManagedInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListPerInstanceConfigsInstanceGroupManagersRequest,
            InstanceGroupManagersListPerInstanceConfigsResp>
        listPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListPerInstanceConfigsInstanceGroupManagersRequest,
                    InstanceGroupManagersListPerInstanceConfigsResp>
                    newBuilder()
                .setMethodDescriptor(listPerInstanceConfigsMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchInstanceGroupManagerRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
        patchPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPerInstanceConfigsMethodDescriptor)
                .build();
    HttpJsonCallSettings<RecreateInstancesInstanceGroupManagerRequest, Operation>
        recreateInstancesTransportSettings =
            HttpJsonCallSettings
                .<RecreateInstancesInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(recreateInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeInstanceGroupManagerRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
        setInstanceTemplateTransportSettings =
            HttpJsonCallSettings
                .<SetInstanceTemplateInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetTargetPoolsInstanceGroupManagerRequest, Operation>
        setTargetPoolsTransportSettings =
            HttpJsonCallSettings.<SetTargetPoolsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetPoolsMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
        updatePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePerInstanceConfigsMethodDescriptor)
                .build();

    this.abandonInstancesCallable =
        callableFactory.createUnaryCallable(
            abandonInstancesTransportSettings, settings.abandonInstancesSettings(), clientContext);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.applyUpdatesToInstancesCallable =
        callableFactory.createUnaryCallable(
            applyUpdatesToInstancesTransportSettings,
            settings.applyUpdatesToInstancesSettings(),
            clientContext);
    this.createInstancesCallable =
        callableFactory.createUnaryCallable(
            createInstancesTransportSettings, settings.createInstancesSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteInstancesCallable =
        callableFactory.createUnaryCallable(
            deleteInstancesTransportSettings, settings.deleteInstancesSettings(), clientContext);
    this.deletePerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            deletePerInstanceConfigsTransportSettings,
            settings.deletePerInstanceConfigsSettings(),
            clientContext);
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
    this.listErrorsCallable =
        callableFactory.createUnaryCallable(
            listErrorsTransportSettings, settings.listErrorsSettings(), clientContext);
    this.listErrorsPagedCallable =
        callableFactory.createPagedCallable(
            listErrorsTransportSettings, settings.listErrorsSettings(), clientContext);
    this.listManagedInstancesCallable =
        callableFactory.createUnaryCallable(
            listManagedInstancesTransportSettings,
            settings.listManagedInstancesSettings(),
            clientContext);
    this.listManagedInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listManagedInstancesTransportSettings,
            settings.listManagedInstancesSettings(),
            clientContext);
    this.listPerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            listPerInstanceConfigsTransportSettings,
            settings.listPerInstanceConfigsSettings(),
            clientContext);
    this.listPerInstanceConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listPerInstanceConfigsTransportSettings,
            settings.listPerInstanceConfigsSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchPerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            patchPerInstanceConfigsTransportSettings,
            settings.patchPerInstanceConfigsSettings(),
            clientContext);
    this.recreateInstancesCallable =
        callableFactory.createUnaryCallable(
            recreateInstancesTransportSettings,
            settings.recreateInstancesSettings(),
            clientContext);
    this.resizeCallable =
        callableFactory.createUnaryCallable(
            resizeTransportSettings, settings.resizeSettings(), clientContext);
    this.setInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            setInstanceTemplateTransportSettings,
            settings.setInstanceTemplateSettings(),
            clientContext);
    this.setTargetPoolsCallable =
        callableFactory.createUnaryCallable(
            setTargetPoolsTransportSettings, settings.setTargetPoolsSettings(), clientContext);
    this.updatePerInstanceConfigsCallable =
        callableFactory.createUnaryCallable(
            updatePerInstanceConfigsTransportSettings,
            settings.updatePerInstanceConfigsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(abandonInstancesMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(applyUpdatesToInstancesMethodDescriptor);
    methodDescriptors.add(createInstancesMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteInstancesMethodDescriptor);
    methodDescriptors.add(deletePerInstanceConfigsMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listErrorsMethodDescriptor);
    methodDescriptors.add(listManagedInstancesMethodDescriptor);
    methodDescriptors.add(listPerInstanceConfigsMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchPerInstanceConfigsMethodDescriptor);
    methodDescriptors.add(recreateInstancesMethodDescriptor);
    methodDescriptors.add(resizeMethodDescriptor);
    methodDescriptors.add(setInstanceTemplateMethodDescriptor);
    methodDescriptors.add(setTargetPoolsMethodDescriptor);
    methodDescriptors.add(updatePerInstanceConfigsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return abandonInstancesCallable;
  }

  @Override
  public UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return applyUpdatesToInstancesCallable;
  }

  @Override
  public UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return createInstancesCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    return deleteInstancesCallable;
  }

  @Override
  public UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return deletePerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return listErrorsCallable;
  }

  @Override
  public UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return listErrorsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesCallable() {
    return listManagedInstancesCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return listManagedInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return listPerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    return listPerInstanceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    return patchPerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return recreateInstancesCallable;
  }

  @Override
  public UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  @Override
  public UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return setInstanceTemplateCallable;
  }

  @Override
  public UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    return setTargetPoolsCallable;
  }

  @Override
  public UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    return updatePerInstanceConfigsCallable;
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
