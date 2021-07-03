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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

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
import com.google.cloud.compute.v1.AbandonInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.CreateInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.GetRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InsertRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.ListErrorsRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListManagedInstancesRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.PatchRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RecreateInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RegionInstanceGroupManagerList;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListInstanceConfigsResp;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListInstancesResponse;
import com.google.cloud.compute.v1.ResizeRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetTargetPoolsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionInstanceGroupManagers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionInstanceGroupManagersStub extends RegionInstanceGroupManagersStub {
  private static final ApiMethodDescriptor<
          AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/AbandonInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AbandonInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/abandonInstances",
                          new FieldsExtractor<
                              AbandonInstancesRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AbandonInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AbandonInstancesRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AbandonInstancesRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AbandonInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AbandonInstancesRegionInstanceGroupManagerRequest>
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
                              AbandonInstancesRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                AbandonInstancesRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersAbandonInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersAbandonInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/ApplyUpdatesToInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances",
                          new FieldsExtractor<
                              ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersApplyUpdatesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersApplyUpdatesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<CreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/CreateInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/createInstances",
                          new FieldsExtractor<
                              CreateInstancesRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                CreateInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<CreateInstancesRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              CreateInstancesRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                CreateInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<CreateInstancesRegionInstanceGroupManagerRequest>
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
                              CreateInstancesRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                CreateInstancesRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersCreateInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersCreateInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRegionInstanceGroupManagerRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}",
                          new FieldsExtractor<
                              DeleteRegionInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(DeleteRegionInstanceGroupManagerRequest request) {
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
          DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/DeleteInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/deleteInstances",
                          new FieldsExtractor<
                              DeleteInstancesRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstancesRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteInstancesRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstancesRegionInstanceGroupManagerRequest>
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
                              DeleteInstancesRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                DeleteInstancesRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersDeleteInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersDeleteInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/DeletePerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs",
                          new FieldsExtractor<
                              DeletePerInstanceConfigsRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      DeletePerInstanceConfigsRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeletePerInstanceConfigsRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      DeletePerInstanceConfigsRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagerDeleteInstanceConfigReqResource",
                                      request
                                          .getRegionInstanceGroupManagerDeleteInstanceConfigReqResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}",
                          new FieldsExtractor<
                              GetRegionInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionInstanceGroupManagerRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(GetRegionInstanceGroupManagerRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManager>newBuilder()
                      .setDefaultInstance(InstanceGroupManager.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionInstanceGroupManagerRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers",
                          new FieldsExtractor<
                              InsertRegionInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(InsertRegionInstanceGroupManagerRequest request) {
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
          ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers",
                          new FieldsExtractor<
                              ListRegionInstanceGroupManagersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionInstanceGroupManagersRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionInstanceGroupManagersRequest>
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
                          new FieldsExtractor<ListRegionInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(ListRegionInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegionInstanceGroupManagerList>newBuilder()
                      .setDefaultInstance(RegionInstanceGroupManagerList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListErrorsRegionInstanceGroupManagersRequest,
                  RegionInstanceGroupManagersListErrorsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/ListErrors")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListErrorsRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listErrors",
                          new FieldsExtractor<
                              ListErrorsRegionInstanceGroupManagersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListErrorsRegionInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListErrorsRegionInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListErrorsRegionInstanceGroupManagersRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListErrorsRegionInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListErrorsRegionInstanceGroupManagersRequest>
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
                              ListErrorsRegionInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(
                                ListErrorsRegionInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RegionInstanceGroupManagersListErrorsResponse>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagersListErrorsResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagedInstancesRegionInstanceGroupManagersRequest,
                  RegionInstanceGroupManagersListInstancesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/ListManagedInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListManagedInstancesRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances",
                          new FieldsExtractor<
                              ListManagedInstancesRegionInstanceGroupManagersRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListManagedInstancesRegionInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListManagedInstancesRegionInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListManagedInstancesRegionInstanceGroupManagersRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListManagedInstancesRegionInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListManagedInstancesRegionInstanceGroupManagersRequest>
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
                              ListManagedInstancesRegionInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(
                                ListManagedInstancesRegionInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RegionInstanceGroupManagersListInstancesResponse>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagersListInstancesResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                  RegionInstanceGroupManagersListInstanceConfigsResp>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/ListPerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPerInstanceConfigsRegionInstanceGroupManagersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs",
                          new FieldsExtractor<
                              ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListPerInstanceConfigsRegionInstanceGroupManagersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListPerInstanceConfigsRegionInstanceGroupManagersRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListPerInstanceConfigsRegionInstanceGroupManagersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListPerInstanceConfigsRegionInstanceGroupManagersRequest>
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
                              ListPerInstanceConfigsRegionInstanceGroupManagersRequest, String>() {
                            @Override
                            public String extract(
                                ListPerInstanceConfigsRegionInstanceGroupManagersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RegionInstanceGroupManagersListInstanceConfigsResp>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagersListInstanceConfigsResp.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRegionInstanceGroupManagerRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}",
                          new FieldsExtractor<
                              PatchRegionInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRegionInstanceGroupManagerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(PatchRegionInstanceGroupManagerRequest request) {
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
          PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/PatchPerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs",
                          new FieldsExtractor<
                              PatchPerInstanceConfigsRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      PatchPerInstanceConfigsRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchPerInstanceConfigsRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      PatchPerInstanceConfigsRegionInstanceGroupManagerRequest>
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
                              PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagerPatchInstanceConfigReqResource",
                                      request
                                          .getRegionInstanceGroupManagerPatchInstanceConfigReqResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/RecreateInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RecreateInstancesRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/recreateInstances",
                          new FieldsExtractor<
                              RecreateInstancesRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RecreateInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      RecreateInstancesRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RecreateInstancesRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RecreateInstancesRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      RecreateInstancesRegionInstanceGroupManagerRequest>
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
                              RecreateInstancesRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                RecreateInstancesRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersRecreateRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersRecreateRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResizeRegionInstanceGroupManagerRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroupManagers/Resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resize",
                          new FieldsExtractor<
                              ResizeRegionInstanceGroupManagerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ResizeRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ResizeRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ResizeRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              serializer.putQueryParam(fields, "size", request.getSize());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ResizeRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(ResizeRegionInstanceGroupManagerRequest request) {
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
          SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/SetInstanceTemplate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetInstanceTemplateRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate",
                          new FieldsExtractor<
                              SetInstanceTemplateRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetInstanceTemplateRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      SetInstanceTemplateRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetInstanceTemplateRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetInstanceTemplateRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      SetInstanceTemplateRegionInstanceGroupManagerRequest>
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
                              SetInstanceTemplateRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                SetInstanceTemplateRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersSetTemplateRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersSetTemplateRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsMethodDescriptor =
          ApiMethodDescriptor
              .<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/SetTargetPools")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetTargetPoolsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/setTargetPools",
                          new FieldsExtractor<
                              SetTargetPoolsRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetTargetPoolsRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetTargetPoolsRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetTargetPoolsRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetTargetPoolsRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetTargetPoolsRegionInstanceGroupManagerRequest>
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
                              SetTargetPoolsRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                SetTargetPoolsRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagersSetTargetPoolsRequestResource",
                                      request
                                          .getRegionInstanceGroupManagersSetTargetPoolsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagers/UpdatePerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs",
                          new FieldsExtractor<
                              UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "instanceGroupManager",
                                  request.getInstanceGroupManager());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest>
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
                              UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, String>() {
                            @Override
                            public String extract(
                                UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupManagerUpdateInstanceConfigReqResource",
                                      request
                                          .getRegionInstanceGroupManagerUpdateInstanceConfigReqResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable;
  private final UnaryCallable<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable;
  private final UnaryCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesCallable;
  private final UnaryCallable<DeleteRegionInstanceGroupManagerRequest, Operation> deleteCallable;
  private final UnaryCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable;
  private final UnaryCallable<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable;
  private final UnaryCallable<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
      getCallable;
  private final UnaryCallable<InsertRegionInstanceGroupManagerRequest, Operation> insertCallable;
  private final UnaryCallable<
          ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listCallable;
  private final UnaryCallable<ListRegionInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsCallable;
  private final UnaryCallable<ListErrorsRegionInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable;
  private final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesCallable;
  private final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable;
  private final UnaryCallable<PatchRegionInstanceGroupManagerRequest, Operation> patchCallable;
  private final UnaryCallable<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable;
  private final UnaryCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable;
  private final UnaryCallable<ResizeRegionInstanceGroupManagerRequest, Operation> resizeCallable;
  private final UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable;
  private final UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable;
  private final UnaryCallable<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionInstanceGroupManagersStub create(
      RegionInstanceGroupManagersStubSettings settings) throws IOException {
    return new HttpJsonRegionInstanceGroupManagersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionInstanceGroupManagersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionInstanceGroupManagersStub(
        RegionInstanceGroupManagersStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionInstanceGroupManagersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionInstanceGroupManagersStub(
        RegionInstanceGroupManagersStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupManagersStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionInstanceGroupManagersStub(
      RegionInstanceGroupManagersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionInstanceGroupManagersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupManagersStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionInstanceGroupManagersStub(
      RegionInstanceGroupManagersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
        abandonInstancesTransportSettings =
            HttpJsonCallSettings
                .<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(abandonInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
        applyUpdatesToInstancesTransportSettings =
            HttpJsonCallSettings
                .<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(applyUpdatesToInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
        createInstancesTransportSettings =
            HttpJsonCallSettings
                .<CreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(createInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteRegionInstanceGroupManagerRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
        deleteInstancesTransportSettings =
            HttpJsonCallSettings
                .<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        deletePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePerInstanceConfigsMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionInstanceGroupManagerRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
                    newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListErrorsRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListErrorsResponse>
        listErrorsTransportSettings =
            HttpJsonCallSettings
                .<ListErrorsRegionInstanceGroupManagersRequest,
                    RegionInstanceGroupManagersListErrorsResponse>
                    newBuilder()
                .setMethodDescriptor(listErrorsMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListManagedInstancesRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListInstancesResponse>
        listManagedInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListManagedInstancesRegionInstanceGroupManagersRequest,
                    RegionInstanceGroupManagersListInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listManagedInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListInstanceConfigsResp>
        listPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                    RegionInstanceGroupManagersListInstanceConfigsResp>
                    newBuilder()
                .setMethodDescriptor(listPerInstanceConfigsMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionInstanceGroupManagerRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionInstanceGroupManagerRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        patchPerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPerInstanceConfigsMethodDescriptor)
                .build();
    HttpJsonCallSettings<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
        recreateInstancesTransportSettings =
            HttpJsonCallSettings
                .<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(recreateInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeRegionInstanceGroupManagerRequest, Operation>
        resizeTransportSettings =
            HttpJsonCallSettings.<ResizeRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(resizeMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
        setInstanceTemplateTransportSettings =
            HttpJsonCallSettings
                .<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
        setTargetPoolsTransportSettings =
            HttpJsonCallSettings
                .<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetPoolsMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        updatePerInstanceConfigsTransportSettings =
            HttpJsonCallSettings
                .<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePerInstanceConfigsMethodDescriptor)
                .build();

    this.abandonInstancesCallable =
        callableFactory.createUnaryCallable(
            abandonInstancesTransportSettings, settings.abandonInstancesSettings(), clientContext);
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
  public UnaryCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return abandonInstancesCallable;
  }

  @Override
  public UnaryCallable<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return applyUpdatesToInstancesCallable;
  }

  @Override
  public UnaryCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return createInstancesCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionInstanceGroupManagerRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    return deleteInstancesCallable;
  }

  @Override
  public UnaryCallable<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return deletePerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<GetRegionInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionInstanceGroupManagerRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return listErrorsCallable;
  }

  @Override
  public UnaryCallable<ListErrorsRegionInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return listErrorsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesCallable() {
    return listManagedInstancesCallable;
  }

  @Override
  public UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return listManagedInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return listPerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    return listPerInstanceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionInstanceGroupManagerRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    return patchPerInstanceConfigsCallable;
  }

  @Override
  public UnaryCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return recreateInstancesCallable;
  }

  @Override
  public UnaryCallable<ResizeRegionInstanceGroupManagerRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  @Override
  public UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return setInstanceTemplateCallable;
  }

  @Override
  public UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    return setTargetPoolsCallable;
  }

  @Override
  public UnaryCallable<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
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
