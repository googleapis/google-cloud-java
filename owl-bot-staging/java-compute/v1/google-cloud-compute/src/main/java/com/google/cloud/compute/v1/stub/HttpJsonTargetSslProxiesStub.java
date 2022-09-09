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

import static com.google.cloud.compute.v1.TargetSslProxiesClient.ListPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteTargetSslProxyRequest;
import com.google.cloud.compute.v1.GetTargetSslProxyRequest;
import com.google.cloud.compute.v1.InsertTargetSslProxyRequest;
import com.google.cloud.compute.v1.ListTargetSslProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.SetBackendServiceTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetCertificateMapTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetSslProxyRequest;
import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyList;
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
 * REST stub implementation for the TargetSslProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTargetSslProxiesStub extends TargetSslProxiesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteTargetSslProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetSslProxyRequest> serializer =
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
                  (DeleteTargetSslProxyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetTargetSslProxyRequest, TargetSslProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetSslProxyRequest, TargetSslProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetSslProxy>newBuilder()
                      .setDefaultInstance(TargetSslProxy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertTargetSslProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertTargetSslProxyRequest> serializer =
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
                                      "targetSslProxyResource",
                                      request.getTargetSslProxyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertTargetSslProxyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListTargetSslProxiesRequest, TargetSslProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetSslProxiesRequest, TargetSslProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetSslProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetSslProxiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetSslProxiesRequest> serializer =
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
                  ProtoMessageResponseParser.<TargetSslProxyList>newBuilder()
                      .setDefaultInstance(TargetSslProxyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<SetBackendServiceTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/SetBackendService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetBackendServiceTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setBackendService",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetBackendServiceTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetBackendServiceTargetSslProxyRequest> serializer =
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
                                      "targetSslProxiesSetBackendServiceRequestResource",
                                      request.getTargetSslProxiesSetBackendServiceRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetBackendServiceTargetSslProxyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapMethodDescriptor =
          ApiMethodDescriptor.<SetCertificateMapTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/SetCertificateMap")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetCertificateMapTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setCertificateMap",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetCertificateMapTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetCertificateMapTargetSslProxyRequest> serializer =
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
                                      "targetSslProxiesSetCertificateMapRequestResource",
                                      request.getTargetSslProxiesSetCertificateMapRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetCertificateMapTargetSslProxyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderMethodDescriptor =
          ApiMethodDescriptor.<SetProxyHeaderTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/SetProxyHeader")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetProxyHeaderTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setProxyHeader",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetProxyHeaderTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetProxyHeaderTargetSslProxyRequest> serializer =
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
                                      "targetSslProxiesSetProxyHeaderRequestResource",
                                      request.getTargetSslProxiesSetProxyHeaderRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetProxyHeaderTargetSslProxyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesMethodDescriptor =
          ApiMethodDescriptor.<SetSslCertificatesTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/SetSslCertificates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSslCertificatesTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setSslCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslCertificatesTargetSslProxyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslCertificatesTargetSslProxyRequest>
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
                                      "targetSslProxiesSetSslCertificatesRequestResource",
                                      request
                                          .getTargetSslProxiesSetSslCertificatesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSslCertificatesTargetSslProxyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetSslPolicyTargetSslProxyRequest, Operation>
      setSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetSslPolicyTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies/SetSslPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSslPolicyTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setSslPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslPolicyTargetSslProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "targetSslProxy", request.getTargetSslProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslPolicyTargetSslProxyRequest> serializer =
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
                  (SetSslPolicyTargetSslProxyRequest request, Operation response) -> {
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

  private final UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteTargetSslProxyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable;
  private final UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable;
  private final OperationCallable<InsertTargetSslProxyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable;
  private final UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable;
  private final OperationCallable<SetBackendServiceTargetSslProxyRequest, Operation, Operation>
      setBackendServiceOperationCallable;
  private final UnaryCallable<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapCallable;
  private final OperationCallable<SetCertificateMapTargetSslProxyRequest, Operation, Operation>
      setCertificateMapOperationCallable;
  private final UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderCallable;
  private final OperationCallable<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
      setProxyHeaderOperationCallable;
  private final UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable;
  private final OperationCallable<SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable;
  private final UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable;
  private final OperationCallable<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
      setSslPolicyOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetSslProxiesStub create(TargetSslProxiesStubSettings settings)
      throws IOException {
    return new HttpJsonTargetSslProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetSslProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetSslProxiesStub(
        TargetSslProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetSslProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetSslProxiesStub(
        TargetSslProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetSslProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetSslProxiesStub(
      TargetSslProxiesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetSslProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetSslProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetSslProxiesStub(
      TargetSslProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteTargetSslProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetSslProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTargetSslProxyRequest, TargetSslProxy> getTransportSettings =
        HttpJsonCallSettings.<GetTargetSslProxyRequest, TargetSslProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertTargetSslProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetSslProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTargetSslProxiesRequest, TargetSslProxyList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetSslProxiesRequest, TargetSslProxyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetBackendServiceTargetSslProxyRequest, Operation>
        setBackendServiceTransportSettings =
            HttpJsonCallSettings.<SetBackendServiceTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setBackendServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetCertificateMapTargetSslProxyRequest, Operation>
        setCertificateMapTransportSettings =
            HttpJsonCallSettings.<SetCertificateMapTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setCertificateMapMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation>
        setProxyHeaderTransportSettings =
            HttpJsonCallSettings.<SetProxyHeaderTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setProxyHeaderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation>
        setSslCertificatesTransportSettings =
            HttpJsonCallSettings.<SetSslCertificatesTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetSslPolicyTargetSslProxyRequest, Operation>
        setSslPolicyTransportSettings =
            HttpJsonCallSettings.<SetSslPolicyTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

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
    this.setBackendServiceCallable =
        callableFactory.createUnaryCallable(
            setBackendServiceTransportSettings,
            settings.setBackendServiceSettings(),
            clientContext);
    this.setBackendServiceOperationCallable =
        callableFactory.createOperationCallable(
            setBackendServiceTransportSettings,
            settings.setBackendServiceOperationSettings(),
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
    this.setProxyHeaderCallable =
        callableFactory.createUnaryCallable(
            setProxyHeaderTransportSettings, settings.setProxyHeaderSettings(), clientContext);
    this.setProxyHeaderOperationCallable =
        callableFactory.createOperationCallable(
            setProxyHeaderTransportSettings,
            settings.setProxyHeaderOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setBackendServiceMethodDescriptor);
    methodDescriptors.add(setCertificateMapMethodDescriptor);
    methodDescriptors.add(setProxyHeaderMethodDescriptor);
    methodDescriptors.add(setSslCertificatesMethodDescriptor);
    methodDescriptors.add(setSslPolicyMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteTargetSslProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertTargetSslProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable() {
    return setBackendServiceCallable;
  }

  @Override
  public OperationCallable<SetBackendServiceTargetSslProxyRequest, Operation, Operation>
      setBackendServiceOperationCallable() {
    return setBackendServiceOperationCallable;
  }

  @Override
  public UnaryCallable<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapCallable() {
    return setCertificateMapCallable;
  }

  @Override
  public OperationCallable<SetCertificateMapTargetSslProxyRequest, Operation, Operation>
      setCertificateMapOperationCallable() {
    return setCertificateMapOperationCallable;
  }

  @Override
  public UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation> setProxyHeaderCallable() {
    return setProxyHeaderCallable;
  }

  @Override
  public OperationCallable<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
      setProxyHeaderOperationCallable() {
    return setProxyHeaderOperationCallable;
  }

  @Override
  public UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable() {
    return setSslCertificatesCallable;
  }

  @Override
  public OperationCallable<SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable() {
    return setSslCertificatesOperationCallable;
  }

  @Override
  public UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable() {
    return setSslPolicyCallable;
  }

  @Override
  public OperationCallable<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
      setSslPolicyOperationCallable() {
    return setSslPolicyOperationCallable;
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
