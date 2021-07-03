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

import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.DeleteTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.GetTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.InsertTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.ListTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetQuicOverrideTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyAggregatedList;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TargetHttpsProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonTargetHttpsProxiesStub extends TargetHttpsProxiesStub {
  private static final ApiMethodDescriptor<
          AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListTargetHttpsProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/targetHttpsProxies",
                          new FieldsExtractor<
                              AggregatedListTargetHttpsProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListTargetHttpsProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetHttpsProxiesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListTargetHttpsProxiesRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListTargetHttpsProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetHttpsProxiesRequest>
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
                          new FieldsExtractor<AggregatedListTargetHttpsProxiesRequest, String>() {
                            @Override
                            public String extract(AggregatedListTargetHttpsProxiesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxyAggregatedList>newBuilder()
                      .setDefaultInstance(TargetHttpsProxyAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTargetHttpsProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}",
                          new FieldsExtractor<
                              DeleteTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(DeleteTargetHttpsProxyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTargetHttpsProxyRequest, TargetHttpsProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}",
                          new FieldsExtractor<GetTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(GetTargetHttpsProxyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxy>newBuilder()
                      .setDefaultInstance(TargetHttpsProxy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertTargetHttpsProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies",
                          new FieldsExtractor<
                              InsertTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(InsertTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxyResource",
                                      request.getTargetHttpsProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetHttpsProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies",
                          new FieldsExtractor<
                              ListTargetHttpsProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListTargetHttpsProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetHttpsProxiesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListTargetHttpsProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListTargetHttpsProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetHttpsProxiesRequest> serializer =
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
                          new FieldsExtractor<ListTargetHttpsProxiesRequest, String>() {
                            @Override
                            public String extract(ListTargetHttpsProxiesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxyList>newBuilder()
                      .setDefaultInstance(TargetHttpsProxyList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchTargetHttpsProxyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}",
                          new FieldsExtractor<PatchTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(PatchTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxyResource",
                                      request.getTargetHttpsProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideMethodDescriptor =
          ApiMethodDescriptor.<SetQuicOverrideTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetQuicOverride")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetQuicOverrideTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}/setQuicOverride",
                          new FieldsExtractor<
                              SetQuicOverrideTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetQuicOverrideTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetQuicOverrideTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetQuicOverrideTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetQuicOverrideTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetQuicOverrideTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetQuicOverrideTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(SetQuicOverrideTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxiesSetQuicOverrideRequestResource",
                                      request
                                          .getTargetHttpsProxiesSetQuicOverrideRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesMethodDescriptor =
          ApiMethodDescriptor.<SetSslCertificatesTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetSslCertificates")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetSslCertificatesTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates",
                          new FieldsExtractor<
                              SetSslCertificatesTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSslCertificatesTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslCertificatesTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSslCertificatesTargetHttpsProxyRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSslCertificatesTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslCertificatesTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetSslCertificatesTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(
                                SetSslCertificatesTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxiesSetSslCertificatesRequestResource",
                                      request
                                          .getTargetHttpsProxiesSetSslCertificatesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetSslPolicyTargetHttpsProxyRequest, Operation>
      setSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetSslPolicyTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetSslPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSslPolicyTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}/setSslPolicy",
                          new FieldsExtractor<
                              SetSslPolicyTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSslPolicyTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslPolicyTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSslPolicyTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSslPolicyTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslPolicyTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetSslPolicyTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(SetSslPolicyTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "sslPolicyReferenceResource",
                                      request.getSslPolicyReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetUrlMapTargetHttpsProxyRequest, Operation>
      setUrlMapMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUrlMapTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap",
                          new FieldsExtractor<
                              SetUrlMapTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetUrlMapTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetUrlMapTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetUrlMapTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetUrlMapTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(SetUrlMapTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "urlMapReferenceResource",
                                      request.getUrlMapReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<
          AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListTargetHttpsProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteTargetHttpsProxyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetTargetHttpsProxyRequest, TargetHttpsProxy> getCallable;
  private final UnaryCallable<InsertTargetHttpsProxyRequest, Operation> insertCallable;
  private final UnaryCallable<ListTargetHttpsProxiesRequest, TargetHttpsProxyList> listCallable;
  private final UnaryCallable<ListTargetHttpsProxiesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchTargetHttpsProxyRequest, Operation> patchCallable;
  private final UnaryCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideCallable;
  private final UnaryCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable;
  private final UnaryCallable<SetSslPolicyTargetHttpsProxyRequest, Operation> setSslPolicyCallable;
  private final UnaryCallable<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetHttpsProxiesStub create(TargetHttpsProxiesStubSettings settings)
      throws IOException {
    return new HttpJsonTargetHttpsProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetHttpsProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetHttpsProxiesStub(
        TargetHttpsProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetHttpsProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetHttpsProxiesStub(
        TargetHttpsProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpsProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpsProxiesStub(
      TargetHttpsProxiesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetHttpsProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpsProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpsProxiesStub(
      TargetHttpsProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetHttpsProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetHttpsProxyRequest, TargetHttpsProxy> getTransportSettings =
        HttpJsonCallSettings.<GetTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertTargetHttpsProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>
        listTransportSettings =
            HttpJsonCallSettings.<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchTargetHttpsProxyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation>
        setQuicOverrideTransportSettings =
            HttpJsonCallSettings.<SetQuicOverrideTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setQuicOverrideMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation>
        setSslCertificatesTransportSettings =
            HttpJsonCallSettings.<SetSslCertificatesTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation>
        setSslPolicyTransportSettings =
            HttpJsonCallSettings.<SetSslPolicyTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapTransportSettings =
        HttpJsonCallSettings.<SetUrlMapTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(setUrlMapMethodDescriptor)
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
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.setQuicOverrideCallable =
        callableFactory.createUnaryCallable(
            setQuicOverrideTransportSettings, settings.setQuicOverrideSettings(), clientContext);
    this.setSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesTransportSettings,
            settings.setSslCertificatesSettings(),
            clientContext);
    this.setSslPolicyCallable =
        callableFactory.createUnaryCallable(
            setSslPolicyTransportSettings, settings.setSslPolicySettings(), clientContext);
    this.setUrlMapCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTransportSettings, settings.setUrlMapSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setQuicOverrideMethodDescriptor);
    methodDescriptors.add(setSslCertificatesMethodDescriptor);
    methodDescriptors.add(setSslPolicyMethodDescriptor);
    methodDescriptors.add(setUrlMapMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListTargetHttpsProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetHttpsProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetTargetHttpsProxyRequest, TargetHttpsProxy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertTargetHttpsProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListTargetHttpsProxiesRequest, TargetHttpsProxyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListTargetHttpsProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchTargetHttpsProxyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideCallable() {
    return setQuicOverrideCallable;
  }

  @Override
  public UnaryCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return setSslCertificatesCallable;
  }

  @Override
  public UnaryCallable<SetSslPolicyTargetHttpsProxyRequest, Operation> setSslPolicyCallable() {
    return setSslPolicyCallable;
  }

  @Override
  public UnaryCallable<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapCallable() {
    return setUrlMapCallable;
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
