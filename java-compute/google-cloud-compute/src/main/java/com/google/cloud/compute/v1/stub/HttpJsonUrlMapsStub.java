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

import static com.google.cloud.compute.v1.UrlMapsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.UrlMapsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListUrlMapsRequest;
import com.google.cloud.compute.v1.DeleteUrlMapRequest;
import com.google.cloud.compute.v1.GetUrlMapRequest;
import com.google.cloud.compute.v1.InsertUrlMapRequest;
import com.google.cloud.compute.v1.InvalidateCacheUrlMapRequest;
import com.google.cloud.compute.v1.ListUrlMapsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchUrlMapRequest;
import com.google.cloud.compute.v1.UpdateUrlMapRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsAggregatedList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateUrlMapRequest;
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
 * REST stub implementation for the UrlMaps service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonUrlMapsStub extends UrlMapsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.UrlMaps/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListUrlMapsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/urlMaps",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListUrlMapsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListUrlMapsRequest> serializer =
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
                  ProtoMessageResponseParser.<UrlMapsAggregatedList>newBuilder()
                      .setDefaultInstance(UrlMapsAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUrlMapRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps/Delete")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteUrlMapRequest> serializer =
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
              (DeleteUrlMapRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetUrlMapRequest, UrlMap> getMethodDescriptor =
      ApiMethodDescriptor.<GetUrlMapRequest, UrlMap>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<UrlMap>newBuilder()
                  .setDefaultInstance(UrlMap.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertUrlMapRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps/Insert")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<InsertUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<InsertUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("urlMapResource", request.getUrlMapResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (InsertUrlMapRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<InvalidateCacheUrlMapRequest, Operation>
      invalidateCacheMethodDescriptor =
          ApiMethodDescriptor.<InvalidateCacheUrlMapRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.UrlMaps/InvalidateCache")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InvalidateCacheUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/urlMaps/{urlMap}/invalidateCache",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InvalidateCacheUrlMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InvalidateCacheUrlMapRequest> serializer =
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
                                      "cacheInvalidationRuleResource",
                                      request.getCacheInvalidationRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InvalidateCacheUrlMapRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListUrlMapsRequest, UrlMapList> listMethodDescriptor =
      ApiMethodDescriptor.<ListUrlMapsRequest, UrlMapList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps/List")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListUrlMapsRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ListUrlMapsRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ListUrlMapsRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasFilter()) {
                          serializer.putQueryParam(fields, "filter", request.getFilter());
                        }
                        if (request.hasMaxResults()) {
                          serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                        }
                        if (request.hasOrderBy()) {
                          serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                        }
                        if (request.hasPageToken()) {
                          serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                        }
                        if (request.hasReturnPartialSuccess()) {
                          serializer.putQueryParam(
                              fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<UrlMapList>newBuilder()
                  .setDefaultInstance(UrlMapList.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<PatchUrlMapRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps/Patch")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PatchUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PatchUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("urlMapResource", request.getUrlMapResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (PatchUrlMapRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<UpdateUrlMapRequest, Operation> updateMethodDescriptor =
      ApiMethodDescriptor.<UpdateUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps/Update")
          .setHttpMethod("PUT")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUrlMapRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("urlMapResource", request.getUrlMapResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (UpdateUrlMapRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ValidateUrlMapRequest, UrlMapsValidateResponse>
      validateMethodDescriptor =
          ApiMethodDescriptor.<ValidateUrlMapRequest, UrlMapsValidateResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.UrlMaps/Validate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/urlMaps/{urlMap}/validate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateUrlMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateUrlMapRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "urlMapsValidateRequestResource",
                                      request.getUrlMapsValidateRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UrlMapsValidateResponse>newBuilder()
                      .setDefaultInstance(UrlMapsValidateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListUrlMapsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteUrlMapRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteUrlMapRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetUrlMapRequest, UrlMap> getCallable;
  private final UnaryCallable<InsertUrlMapRequest, Operation> insertCallable;
  private final OperationCallable<InsertUrlMapRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<InvalidateCacheUrlMapRequest, Operation> invalidateCacheCallable;
  private final OperationCallable<InvalidateCacheUrlMapRequest, Operation, Operation>
      invalidateCacheOperationCallable;
  private final UnaryCallable<ListUrlMapsRequest, UrlMapList> listCallable;
  private final UnaryCallable<ListUrlMapsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchUrlMapRequest, Operation> patchCallable;
  private final OperationCallable<PatchUrlMapRequest, Operation, Operation> patchOperationCallable;
  private final UnaryCallable<UpdateUrlMapRequest, Operation> updateCallable;
  private final OperationCallable<UpdateUrlMapRequest, Operation, Operation>
      updateOperationCallable;
  private final UnaryCallable<ValidateUrlMapRequest, UrlMapsValidateResponse> validateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUrlMapsStub create(UrlMapsStubSettings settings) throws IOException {
    return new HttpJsonUrlMapsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUrlMapsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonUrlMapsStub(UrlMapsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonUrlMapsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUrlMapsStub(
        UrlMapsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUrlMapsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUrlMapsStub(UrlMapsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUrlMapsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUrlMapsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUrlMapsStub(
      UrlMapsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings.<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteUrlMapRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetUrlMapRequest, UrlMap> getTransportSettings =
        HttpJsonCallSettings.<GetUrlMapRequest, UrlMap>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertUrlMapRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InvalidateCacheUrlMapRequest, Operation> invalidateCacheTransportSettings =
        HttpJsonCallSettings.<InvalidateCacheUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(invalidateCacheMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListUrlMapsRequest, UrlMapList> listTransportSettings =
        HttpJsonCallSettings.<ListUrlMapsRequest, UrlMapList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchUrlMapRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateUrlMapRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ValidateUrlMapRequest, UrlMapsValidateResponse> validateTransportSettings =
        HttpJsonCallSettings.<ValidateUrlMapRequest, UrlMapsValidateResponse>newBuilder()
            .setMethodDescriptor(validateMethodDescriptor)
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
    this.invalidateCacheCallable =
        callableFactory.createUnaryCallable(
            invalidateCacheTransportSettings, settings.invalidateCacheSettings(), clientContext);
    this.invalidateCacheOperationCallable =
        callableFactory.createOperationCallable(
            invalidateCacheTransportSettings,
            settings.invalidateCacheOperationSettings(),
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
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.updateOperationCallable =
        callableFactory.createOperationCallable(
            updateTransportSettings,
            settings.updateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.validateCallable =
        callableFactory.createUnaryCallable(
            validateTransportSettings, settings.validateSettings(), clientContext);

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
    methodDescriptors.add(invalidateCacheMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    methodDescriptors.add(validateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListUrlMapsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteUrlMapRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteUrlMapRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetUrlMapRequest, UrlMap> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertUrlMapRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertUrlMapRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<InvalidateCacheUrlMapRequest, Operation> invalidateCacheCallable() {
    return invalidateCacheCallable;
  }

  @Override
  public OperationCallable<InvalidateCacheUrlMapRequest, Operation, Operation>
      invalidateCacheOperationCallable() {
    return invalidateCacheOperationCallable;
  }

  @Override
  public UnaryCallable<ListUrlMapsRequest, UrlMapList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchUrlMapRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchUrlMapRequest, Operation, Operation> patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateUrlMapRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateUrlMapRequest, Operation, Operation> updateOperationCallable() {
    return updateOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateUrlMapRequest, UrlMapsValidateResponse> validateCallable() {
    return validateCallable;
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
