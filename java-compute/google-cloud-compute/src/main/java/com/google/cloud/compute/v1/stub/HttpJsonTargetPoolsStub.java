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

import static com.google.cloud.compute.v1.TargetPoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.AddInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.AggregatedListTargetPoolsRequest;
import com.google.cloud.compute.v1.DeleteTargetPoolRequest;
import com.google.cloud.compute.v1.GetHealthTargetPoolRequest;
import com.google.cloud.compute.v1.GetTargetPoolRequest;
import com.google.cloud.compute.v1.InsertTargetPoolRequest;
import com.google.cloud.compute.v1.ListTargetPoolsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.RemoveInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.SetBackupTargetPoolRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolAggregatedList;
import com.google.cloud.compute.v1.TargetPoolInstanceHealth;
import com.google.cloud.compute.v1.TargetPoolList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TargetPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonTargetPoolsStub extends TargetPoolsStub {
  private static final ApiMethodDescriptor<AddHealthCheckTargetPoolRequest, Operation>
      addHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<AddHealthCheckTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/AddHealthCheck")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddHealthCheckTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/addHealthCheck",
                          new FieldsExtractor<
                              AddHealthCheckTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddHealthCheckTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddHealthCheckTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddHealthCheckTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddHealthCheckTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddHealthCheckTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddHealthCheckTargetPoolRequest, String>() {
                            @Override
                            public String extract(AddHealthCheckTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetPoolsAddHealthCheckRequestResource",
                                      request.getTargetPoolsAddHealthCheckRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddInstanceTargetPoolRequest, Operation>
      addInstanceMethodDescriptor =
          ApiMethodDescriptor.<AddInstanceTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/AddInstance")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddInstanceTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/addInstance",
                          new FieldsExtractor<AddInstanceTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddInstanceTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddInstanceTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddInstanceTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddInstanceTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddInstanceTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddInstanceTargetPoolRequest, String>() {
                            @Override
                            public String extract(AddInstanceTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetPoolsAddInstanceRequestResource",
                                      request.getTargetPoolsAddInstanceRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListTargetPoolsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/targetPools",
                          new FieldsExtractor<
                              AggregatedListTargetPoolsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListTargetPoolsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetPoolsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListTargetPoolsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListTargetPoolsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetPoolsRequest> serializer =
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
                          new FieldsExtractor<AggregatedListTargetPoolsRequest, String>() {
                            @Override
                            public String extract(AggregatedListTargetPoolsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetPoolAggregatedList>newBuilder()
                      .setDefaultInstance(TargetPoolAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTargetPoolRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}",
                          new FieldsExtractor<DeleteTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteTargetPoolRequest, String>() {
                            @Override
                            public String extract(DeleteTargetPoolRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTargetPoolRequest, TargetPool> getMethodDescriptor =
      ApiMethodDescriptor.<GetTargetPoolRequest, TargetPool>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.TargetPools/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTargetPoolRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}",
                      new FieldsExtractor<GetTargetPoolRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetTargetPoolRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetTargetPoolRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "targetPool", request.getTargetPool());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetTargetPoolRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetTargetPoolRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetTargetPoolRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetTargetPoolRequest, String>() {
                        @Override
                        public String extract(GetTargetPoolRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<TargetPool>newBuilder()
                  .setDefaultInstance(TargetPool.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthMethodDescriptor =
          ApiMethodDescriptor.<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/GetHealth")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHealthTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/getHealth",
                          new FieldsExtractor<GetHealthTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetHealthTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetHealthTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetHealthTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetHealthTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetHealthTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetHealthTargetPoolRequest, String>() {
                            @Override
                            public String extract(GetHealthTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceReferenceResource",
                                      request.getInstanceReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetPoolInstanceHealth>newBuilder()
                      .setDefaultInstance(TargetPoolInstanceHealth.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertTargetPoolRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools",
                          new FieldsExtractor<InsertTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertTargetPoolRequest, String>() {
                            @Override
                            public String extract(InsertTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("targetPoolResource", request.getTargetPoolResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTargetPoolsRequest, TargetPoolList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetPoolsRequest, TargetPoolList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetPoolsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools",
                          new FieldsExtractor<ListTargetPoolsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListTargetPoolsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetPoolsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListTargetPoolsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListTargetPoolsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetPoolsRequest> serializer =
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
                          new FieldsExtractor<ListTargetPoolsRequest, String>() {
                            @Override
                            public String extract(ListTargetPoolsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetPoolList>newBuilder()
                      .setDefaultInstance(TargetPoolList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<RemoveHealthCheckTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/RemoveHealthCheck")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveHealthCheckTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/removeHealthCheck",
                          new FieldsExtractor<
                              RemoveHealthCheckTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveHealthCheckTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveHealthCheckTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveHealthCheckTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveHealthCheckTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveHealthCheckTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveHealthCheckTargetPoolRequest, String>() {
                            @Override
                            public String extract(RemoveHealthCheckTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetPoolsRemoveHealthCheckRequestResource",
                                      request.getTargetPoolsRemoveHealthCheckRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveInstanceTargetPoolRequest, Operation>
      removeInstanceMethodDescriptor =
          ApiMethodDescriptor.<RemoveInstanceTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/RemoveInstance")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveInstanceTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/removeInstance",
                          new FieldsExtractor<
                              RemoveInstanceTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveInstanceTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveInstanceTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveInstanceTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveInstanceTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveInstanceTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveInstanceTargetPoolRequest, String>() {
                            @Override
                            public String extract(RemoveInstanceTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetPoolsRemoveInstanceRequestResource",
                                      request.getTargetPoolsRemoveInstanceRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetBackupTargetPoolRequest, Operation>
      setBackupMethodDescriptor =
          ApiMethodDescriptor.<SetBackupTargetPoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetPools/SetBackup")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetBackupTargetPoolRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetPools/{targetPool}/setBackup",
                          new FieldsExtractor<SetBackupTargetPoolRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetBackupTargetPoolRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetBackupTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetPool", request.getTargetPool());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetBackupTargetPoolRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetBackupTargetPoolRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetBackupTargetPoolRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFailoverRatio()) {
                                serializer.putQueryParam(
                                    fields, "failoverRatio", request.getFailoverRatio());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetBackupTargetPoolRequest, String>() {
                            @Override
                            public String extract(SetBackupTargetPoolRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetReferenceResource",
                                      request.getTargetReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable;
  private final UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable;
  private final UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable;
  private final UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable;
  private final UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthCallable;
  private final UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable;
  private final UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable;
  private final UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckCallable;
  private final UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable;
  private final UnaryCallable<SetBackupTargetPoolRequest, Operation> setBackupCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetPoolsStub create(TargetPoolsStubSettings settings)
      throws IOException {
    return new HttpJsonTargetPoolsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetPoolsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetPoolsStub(TargetPoolsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetPoolsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetPoolsStub(
        TargetPoolsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetPoolsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTargetPoolsStub(TargetPoolsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTargetPoolsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetPoolsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTargetPoolsStub(
      TargetPoolsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddHealthCheckTargetPoolRequest, Operation>
        addHealthCheckTransportSettings =
            HttpJsonCallSettings.<AddHealthCheckTargetPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(addHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<AddInstanceTargetPoolRequest, Operation> addInstanceTransportSettings =
        HttpJsonCallSettings.<AddInstanceTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(addInstanceMethodDescriptor)
            .build();
    HttpJsonCallSettings<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetPoolRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetPoolRequest, TargetPool> getTransportSettings =
        HttpJsonCallSettings.<GetTargetPoolRequest, TargetPool>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
        getHealthTransportSettings =
            HttpJsonCallSettings.<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>newBuilder()
                .setMethodDescriptor(getHealthMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetPoolRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetPoolsRequest, TargetPoolList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetPoolsRequest, TargetPoolList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemoveHealthCheckTargetPoolRequest, Operation>
        removeHealthCheckTransportSettings =
            HttpJsonCallSettings.<RemoveHealthCheckTargetPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(removeHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveInstanceTargetPoolRequest, Operation>
        removeInstanceTransportSettings =
            HttpJsonCallSettings.<RemoveInstanceTargetPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(removeInstanceMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetBackupTargetPoolRequest, Operation> setBackupTransportSettings =
        HttpJsonCallSettings.<SetBackupTargetPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(setBackupMethodDescriptor)
            .build();

    this.addHealthCheckCallable =
        callableFactory.createUnaryCallable(
            addHealthCheckTransportSettings, settings.addHealthCheckSettings(), clientContext);
    this.addInstanceCallable =
        callableFactory.createUnaryCallable(
            addInstanceTransportSettings, settings.addInstanceSettings(), clientContext);
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
    this.getHealthCallable =
        callableFactory.createUnaryCallable(
            getHealthTransportSettings, settings.getHealthSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.removeHealthCheckCallable =
        callableFactory.createUnaryCallable(
            removeHealthCheckTransportSettings,
            settings.removeHealthCheckSettings(),
            clientContext);
    this.removeInstanceCallable =
        callableFactory.createUnaryCallable(
            removeInstanceTransportSettings, settings.removeInstanceSettings(), clientContext);
    this.setBackupCallable =
        callableFactory.createUnaryCallable(
            setBackupTransportSettings, settings.setBackupSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addHealthCheckMethodDescriptor);
    methodDescriptors.add(addInstanceMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getHealthMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(removeHealthCheckMethodDescriptor);
    methodDescriptors.add(removeInstanceMethodDescriptor);
    methodDescriptors.add(setBackupMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable() {
    return addHealthCheckCallable;
  }

  @Override
  public UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable() {
    return addInstanceCallable;
  }

  @Override
  public UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth> getHealthCallable() {
    return getHealthCallable;
  }

  @Override
  public UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation> removeHealthCheckCallable() {
    return removeHealthCheckCallable;
  }

  @Override
  public UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable() {
    return removeInstanceCallable;
  }

  @Override
  public UnaryCallable<SetBackupTargetPoolRequest, Operation> setBackupCallable() {
    return setBackupCallable;
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
