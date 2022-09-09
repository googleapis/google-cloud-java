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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.DeleteTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.GetTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.InsertTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.ListTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetCertificateMapTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetQuicOverrideTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyAggregatedList;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
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
 * REST stub implementation for the TargetHttpsProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTargetHttpsProxiesStub extends TargetHttpsProxiesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListTargetHttpsProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/targetHttpsProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListTargetHttpsProxiesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxyAggregatedList>newBuilder()
                      .setDefaultInstance(TargetHttpsProxyAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTargetHttpsProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
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
                  (DeleteTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetTargetHttpsProxyRequest, TargetHttpsProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxy>newBuilder()
                      .setDefaultInstance(TargetHttpsProxy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertTargetHttpsProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxyResource",
                                      request.getTargetHttpsProxyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetHttpsProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetHttpsProxiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxyList>newBuilder()
                      .setDefaultInstance(TargetHttpsProxyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchTargetHttpsProxyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxyResource",
                                      request.getTargetHttpsProxyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapMethodDescriptor =
          ApiMethodDescriptor.<SetCertificateMapTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetCertificateMap")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetCertificateMapTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}/setCertificateMap",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetCertificateMapTargetHttpsProxyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetCertificateMapTargetHttpsProxyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxiesSetCertificateMapRequestResource",
                                      request
                                          .getTargetHttpsProxiesSetCertificateMapRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetCertificateMapTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideMethodDescriptor =
          ApiMethodDescriptor.<SetQuicOverrideTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetQuicOverride")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetQuicOverrideTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}/setQuicOverride",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetQuicOverrideTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetQuicOverrideTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxiesSetQuicOverrideRequestResource",
                                      request.getTargetHttpsProxiesSetQuicOverrideRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetQuicOverrideTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesMethodDescriptor =
          ApiMethodDescriptor.<SetSslCertificatesTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetSslCertificates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetSslCertificatesTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslCertificatesTargetHttpsProxyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslCertificatesTargetHttpsProxyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxiesSetSslCertificatesRequestResource",
                                      request
                                          .getTargetHttpsProxiesSetSslCertificatesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSslCertificatesTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetSslPolicyTargetHttpsProxyRequest, Operation>
      setSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetSslPolicyTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetSslPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSslPolicyTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpsProxies/{targetHttpsProxy}/setSslPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslPolicyTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslPolicyTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "sslPolicyReferenceResource",
                                      request.getSslPolicyReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSslPolicyTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetUrlMapTargetHttpsProxyRequest, Operation>
      setUrlMapMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpsProxies/SetUrlMap")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUrlMapTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetUrlMapTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetUrlMapTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "urlMapReferenceResource",
                                      request.getUrlMapReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetUrlMapTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<
          AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListTargetHttpsProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteTargetHttpsProxyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetTargetHttpsProxyRequest, TargetHttpsProxy> getCallable;
  private final UnaryCallable<InsertTargetHttpsProxyRequest, Operation> insertCallable;
  private final OperationCallable<InsertTargetHttpsProxyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListTargetHttpsProxiesRequest, TargetHttpsProxyList> listCallable;
  private final UnaryCallable<ListTargetHttpsProxiesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchTargetHttpsProxyRequest, Operation> patchCallable;
  private final OperationCallable<PatchTargetHttpsProxyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapCallable;
  private final OperationCallable<SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
      setCertificateMapOperationCallable;
  private final UnaryCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideCallable;
  private final OperationCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
      setQuicOverrideOperationCallable;
  private final UnaryCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable;
  private final OperationCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable;
  private final UnaryCallable<SetSslPolicyTargetHttpsProxyRequest, Operation> setSslPolicyCallable;
  private final OperationCallable<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
      setSslPolicyOperationCallable;
  private final UnaryCallable<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapCallable;
  private final OperationCallable<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
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
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetHttpsProxiesRequest, TargetHttpsProxyAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteTargetHttpsProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTargetHttpsProxyRequest, TargetHttpsProxy> getTransportSettings =
        HttpJsonCallSettings.<GetTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertTargetHttpsProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>
        listTransportSettings =
            HttpJsonCallSettings.<ListTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchTargetHttpsProxyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetCertificateMapTargetHttpsProxyRequest, Operation>
        setCertificateMapTransportSettings =
            HttpJsonCallSettings.<SetCertificateMapTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setCertificateMapMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation>
        setQuicOverrideTransportSettings =
            HttpJsonCallSettings.<SetQuicOverrideTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setQuicOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation>
        setSslCertificatesTransportSettings =
            HttpJsonCallSettings.<SetSslCertificatesTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation>
        setSslPolicyTransportSettings =
            HttpJsonCallSettings.<SetSslPolicyTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapTransportSettings =
        HttpJsonCallSettings.<SetUrlMapTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(setUrlMapMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setCertificateMapCallable =
        callableFactory.createUnaryCallable(
            setCertificateMapTransportSettings,
            settings.setCertificateMapSettings(),
            clientContext);
    this.setCertificateMapOperationCallable =
        callableFactory.createOperationCallable(
            setCertificateMapTransportSettings,
            settings.setCertificateMapOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setQuicOverrideCallable =
        callableFactory.createUnaryCallable(
            setQuicOverrideTransportSettings, settings.setQuicOverrideSettings(), clientContext);
    this.setQuicOverrideOperationCallable =
        callableFactory.createOperationCallable(
            setQuicOverrideTransportSettings,
            settings.setQuicOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesTransportSettings,
            settings.setSslCertificatesSettings(),
            clientContext);
    this.setSslCertificatesOperationCallable =
        callableFactory.createOperationCallable(
            setSslCertificatesTransportSettings,
            settings.setSslCertificatesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setSslPolicyCallable =
        callableFactory.createUnaryCallable(
            setSslPolicyTransportSettings, settings.setSslPolicySettings(), clientContext);
    this.setSslPolicyOperationCallable =
        callableFactory.createOperationCallable(
            setSslPolicyTransportSettings,
            settings.setSslPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setUrlMapCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTransportSettings, settings.setUrlMapSettings(), clientContext);
    this.setUrlMapOperationCallable =
        callableFactory.createOperationCallable(
            setUrlMapTransportSettings,
            settings.setUrlMapOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

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
    methodDescriptors.add(setCertificateMapMethodDescriptor);
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
  public OperationCallable<DeleteTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
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
  public OperationCallable<InsertTargetHttpsProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
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
  public OperationCallable<PatchTargetHttpsProxyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapCallable() {
    return setCertificateMapCallable;
  }

  @Override
  public OperationCallable<SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
      setCertificateMapOperationCallable() {
    return setCertificateMapOperationCallable;
  }

  @Override
  public UnaryCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideCallable() {
    return setQuicOverrideCallable;
  }

  @Override
  public OperationCallable<SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
      setQuicOverrideOperationCallable() {
    return setQuicOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return setSslCertificatesCallable;
  }

  @Override
  public OperationCallable<SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable() {
    return setSslCertificatesOperationCallable;
  }

  @Override
  public UnaryCallable<SetSslPolicyTargetHttpsProxyRequest, Operation> setSslPolicyCallable() {
    return setSslPolicyCallable;
  }

  @Override
  public OperationCallable<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
      setSslPolicyOperationCallable() {
    return setSslPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapCallable() {
    return setUrlMapCallable;
  }

  @Override
  public OperationCallable<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationCallable() {
    return setUrlMapOperationCallable;
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
