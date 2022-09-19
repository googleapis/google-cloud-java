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

import static com.google.cloud.compute.v1.RoutersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.GetNatMappingInfoPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRoutersRequest;
import com.google.cloud.compute.v1.DeleteRouterRequest;
import com.google.cloud.compute.v1.GetNatMappingInfoRoutersRequest;
import com.google.cloud.compute.v1.GetRouterRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterRequest;
import com.google.cloud.compute.v1.InsertRouterRequest;
import com.google.cloud.compute.v1.ListRoutersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchRouterRequest;
import com.google.cloud.compute.v1.PreviewRouterRequest;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.UpdateRouterRequest;
import com.google.cloud.compute.v1.VmEndpointNatMappingsList;
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
 * REST stub implementation for the Routers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRoutersStub extends RoutersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListRoutersRequest, RouterAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListRoutersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/routers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListRoutersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListRoutersRequest> serializer =
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
                  ProtoMessageResponseParser.<RouterAggregatedList>newBuilder()
                      .setDefaultInstance(RouterAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRouterRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Delete")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        serializer.putPathParam(fields, "router", request.getRouter());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRouterRequest> serializer =
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
              (DeleteRouterRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetRouterRequest, Router> getMethodDescriptor =
      ApiMethodDescriptor.<GetRouterRequest, Router>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        serializer.putPathParam(fields, "router", request.getRouter());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Router>newBuilder()
                  .setDefaultInstance(Router.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoMethodDescriptor =
          ApiMethodDescriptor
              .<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/GetNatMappingInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNatMappingInfoRoutersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/routers/{router}/getNatMappingInfo",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNatMappingInfoRoutersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "router", request.getRouter());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNatMappingInfoRoutersRequest> serializer =
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
                  ProtoMessageResponseParser.<VmEndpointNatMappingsList>newBuilder()
                      .setDefaultInstance(VmEndpointNatMappingsList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusMethodDescriptor =
          ApiMethodDescriptor.<GetRouterStatusRouterRequest, RouterStatusResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/GetRouterStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRouterStatusRouterRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/routers/{router}/getRouterStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRouterStatusRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "router", request.getRouter());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRouterStatusRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RouterStatusResponse>newBuilder()
                      .setDefaultInstance(RouterStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRouterRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Insert")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<InsertRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<InsertRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("routerResource", request.getRouterResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (InsertRouterRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListRoutersRequest, RouterList> listMethodDescriptor =
      ApiMethodDescriptor.<ListRoutersRequest, RouterList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/List")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListRoutersRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ListRoutersRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ListRoutersRequest> serializer =
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
              ProtoMessageResponseParser.<RouterList>newBuilder()
                  .setDefaultInstance(RouterList.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<PatchRouterRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Patch")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PatchRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        serializer.putPathParam(fields, "router", request.getRouter());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PatchRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("routerResource", request.getRouterResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (PatchRouterRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<PreviewRouterRequest, RoutersPreviewResponse>
      previewMethodDescriptor =
          ApiMethodDescriptor.<PreviewRouterRequest, RoutersPreviewResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/Preview")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewRouterRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/routers/{router}/preview",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "router", request.getRouter());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewRouterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("routerResource", request.getRouterResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RoutersPreviewResponse>newBuilder()
                      .setDefaultInstance(RoutersPreviewResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRouterRequest, Operation> updateMethodDescriptor =
      ApiMethodDescriptor.<UpdateRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Update")
          .setHttpMethod("PUT")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        serializer.putPathParam(fields, "router", request.getRouter());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRouterRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("routerResource", request.getRouterResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (UpdateRouterRequest request, Operation response) -> {
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

  private final UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListRoutersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteRouterRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRouterRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRouterRequest, Router> getCallable;
  private final UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoCallable;
  private final UnaryCallable<GetNatMappingInfoRoutersRequest, GetNatMappingInfoPagedResponse>
      getNatMappingInfoPagedCallable;
  private final UnaryCallable<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusCallable;
  private final UnaryCallable<InsertRouterRequest, Operation> insertCallable;
  private final OperationCallable<InsertRouterRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRoutersRequest, RouterList> listCallable;
  private final UnaryCallable<ListRoutersRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchRouterRequest, Operation> patchCallable;
  private final OperationCallable<PatchRouterRequest, Operation, Operation> patchOperationCallable;
  private final UnaryCallable<PreviewRouterRequest, RoutersPreviewResponse> previewCallable;
  private final UnaryCallable<UpdateRouterRequest, Operation> updateCallable;
  private final OperationCallable<UpdateRouterRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRoutersStub create(RoutersStubSettings settings) throws IOException {
    return new HttpJsonRoutersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRoutersStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRoutersStub(RoutersStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRoutersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRoutersStub(
        RoutersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRoutersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoutersStub(RoutersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRoutersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRoutersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoutersStub(
      RoutersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListRoutersRequest, RouterAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings.<AggregatedListRoutersRequest, RouterAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteRouterRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRouterRequest, Router> getTransportSettings =
        HttpJsonCallSettings.<GetRouterRequest, Router>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
        getNatMappingInfoTransportSettings =
            HttpJsonCallSettings
                .<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>newBuilder()
                .setMethodDescriptor(getNatMappingInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusTransportSettings =
            HttpJsonCallSettings.<GetRouterStatusRouterRequest, RouterStatusResponse>newBuilder()
                .setMethodDescriptor(getRouterStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertRouterRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRoutersRequest, RouterList> listTransportSettings =
        HttpJsonCallSettings.<ListRoutersRequest, RouterList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchRouterRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewTransportSettings =
        HttpJsonCallSettings.<PreviewRouterRequest, RoutersPreviewResponse>newBuilder()
            .setMethodDescriptor(previewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRouterRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
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
    this.getNatMappingInfoCallable =
        callableFactory.createUnaryCallable(
            getNatMappingInfoTransportSettings,
            settings.getNatMappingInfoSettings(),
            clientContext);
    this.getNatMappingInfoPagedCallable =
        callableFactory.createPagedCallable(
            getNatMappingInfoTransportSettings,
            settings.getNatMappingInfoSettings(),
            clientContext);
    this.getRouterStatusCallable =
        callableFactory.createUnaryCallable(
            getRouterStatusTransportSettings, settings.getRouterStatusSettings(), clientContext);
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
    this.previewCallable =
        callableFactory.createUnaryCallable(
            previewTransportSettings, settings.previewSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.updateOperationCallable =
        callableFactory.createOperationCallable(
            updateTransportSettings,
            settings.updateOperationSettings(),
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
    methodDescriptors.add(getNatMappingInfoMethodDescriptor);
    methodDescriptors.add(getRouterStatusMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(previewMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListRoutersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRouterRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRouterRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRouterRequest, Router> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoCallable() {
    return getNatMappingInfoCallable;
  }

  @Override
  public UnaryCallable<GetNatMappingInfoRoutersRequest, GetNatMappingInfoPagedResponse>
      getNatMappingInfoPagedCallable() {
    return getNatMappingInfoPagedCallable;
  }

  @Override
  public UnaryCallable<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusCallable() {
    return getRouterStatusCallable;
  }

  @Override
  public UnaryCallable<InsertRouterRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRouterRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRoutersRequest, RouterList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRoutersRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRouterRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchRouterRequest, Operation, Operation> patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PreviewRouterRequest, RoutersPreviewResponse> previewCallable() {
    return previewCallable;
  }

  @Override
  public UnaryCallable<UpdateRouterRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateRouterRequest, Operation, Operation> updateOperationCallable() {
    return updateOperationCallable;
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
