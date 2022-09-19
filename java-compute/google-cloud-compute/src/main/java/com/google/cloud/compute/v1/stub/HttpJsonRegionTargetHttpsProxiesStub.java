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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
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
 * REST stub implementation for the RegionTargetHttpsProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionTargetHttpsProxiesStub extends RegionTargetHttpsProxiesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteRegionTargetHttpsProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionTargetHttpsProxyRequest> serializer =
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
                  (DeleteRegionTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionTargetHttpsProxyRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertRegionTargetHttpsProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionTargetHttpsProxyRequest> serializer =
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
                  (InsertRegionTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionTargetHttpsProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionTargetHttpsProxiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionTargetHttpsProxiesRequest> serializer =
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

  private static final ApiMethodDescriptor<PatchRegionTargetHttpsProxyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionTargetHttpsProxyRequest> serializer =
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
                  (PatchRegionTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesMethodDescriptor =
          ApiMethodDescriptor
              .<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionTargetHttpsProxies/SetSslCertificates")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetSslCertificatesRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslCertificatesRegionTargetHttpsProxyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSslCertificatesRegionTargetHttpsProxyRequest>
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
                                      "regionTargetHttpsProxiesSetSslCertificatesRequestResource",
                                      request
                                          .getRegionTargetHttpsProxiesSetSslCertificatesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSslCertificatesRegionTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
      setUrlMapMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/SetUrlMap")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUrlMapRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetUrlMapRegionTargetHttpsProxyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetUrlMapRegionTargetHttpsProxyRequest> serializer =
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
                  (SetUrlMapRegionTargetHttpsProxyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<DeleteRegionTargetHttpsProxyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getCallable;
  private final UnaryCallable<InsertRegionTargetHttpsProxyRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionTargetHttpsProxyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listCallable;
  private final UnaryCallable<ListRegionTargetHttpsProxiesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchRegionTargetHttpsProxyRequest, Operation> patchCallable;
  private final OperationCallable<PatchRegionTargetHttpsProxyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable;
  private final OperationCallable<
          SetSslCertificatesRegionTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable;
  private final UnaryCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation> setUrlMapCallable;
  private final OperationCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionTargetHttpsProxiesStub create(
      RegionTargetHttpsProxiesStubSettings settings) throws IOException {
    return new HttpJsonRegionTargetHttpsProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionTargetHttpsProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionTargetHttpsProxiesStub(
        RegionTargetHttpsProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionTargetHttpsProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionTargetHttpsProxiesStub(
        RegionTargetHttpsProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpsProxiesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpsProxiesStub(
      RegionTargetHttpsProxiesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionTargetHttpsProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpsProxiesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpsProxiesStub(
      RegionTargetHttpsProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteRegionTargetHttpsProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getTransportSettings =
        HttpJsonCallSettings.<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertRegionTargetHttpsProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchRegionTargetHttpsProxyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
        setSslCertificatesTransportSettings =
            HttpJsonCallSettings
                .<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
        setUrlMapTransportSettings =
            HttpJsonCallSettings.<SetUrlMapRegionTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setUrlMapMethodDescriptor)
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
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setSslCertificatesMethodDescriptor);
    methodDescriptors.add(setUrlMapMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionTargetHttpsProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionTargetHttpsProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionTargetHttpsProxyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionTargetHttpsProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionTargetHttpsProxyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchRegionTargetHttpsProxyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return setSslCertificatesCallable;
  }

  @Override
  public OperationCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationCallable() {
    return setSslCertificatesOperationCallable;
  }

  @Override
  public UnaryCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation> setUrlMapCallable() {
    return setUrlMapCallable;
  }

  @Override
  public OperationCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation, Operation>
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
