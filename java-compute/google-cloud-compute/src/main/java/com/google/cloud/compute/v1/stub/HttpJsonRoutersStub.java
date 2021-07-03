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

import static com.google.cloud.compute.v1.RoutersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.GetNatMappingInfoPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRoutersRequest;
import com.google.cloud.compute.v1.DeleteRouterRequest;
import com.google.cloud.compute.v1.GetNatMappingInfoRoutersRequest;
import com.google.cloud.compute.v1.GetRouterRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterRequest;
import com.google.cloud.compute.v1.InsertRouterRequest;
import com.google.cloud.compute.v1.ListRoutersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRouterRequest;
import com.google.cloud.compute.v1.PreviewRouterRequest;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.UpdateRouterRequest;
import com.google.cloud.compute.v1.VmEndpointNatMappingsList;
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
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRoutersStub extends RoutersStub {
  private static final ApiMethodDescriptor<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListRoutersRequest, RouterAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListRoutersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/routers",
                          new FieldsExtractor<AggregatedListRoutersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListRoutersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListRoutersRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListRoutersRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListRoutersRequest request) {
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
                          new FieldsExtractor<AggregatedListRoutersRequest, String>() {
                            @Override
                            public String extract(AggregatedListRoutersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RouterAggregatedList>newBuilder()
                      .setDefaultInstance(RouterAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRouterRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      new FieldsExtractor<DeleteRouterRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteRouterRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "router", request.getRouter());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteRouterRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteRouterRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteRouterRequest, String>() {
                        @Override
                        public String extract(DeleteRouterRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetRouterRequest, Router> getMethodDescriptor =
      ApiMethodDescriptor.<GetRouterRequest, Router>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      new FieldsExtractor<GetRouterRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetRouterRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "router", request.getRouter());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetRouterRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetRouterRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetRouterRequest, String>() {
                        @Override
                        public String extract(GetRouterRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Router>newBuilder()
                  .setDefaultInstance(Router.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoMethodDescriptor =
          ApiMethodDescriptor
              .<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/GetNatMappingInfo")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNatMappingInfoRoutersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/routers/{router}/getNatMappingInfo",
                          new FieldsExtractor<
                              GetNatMappingInfoRoutersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetNatMappingInfoRoutersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetNatMappingInfoRoutersRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "router", request.getRouter());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetNatMappingInfoRoutersRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetNatMappingInfoRoutersRequest request) {
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
                          new FieldsExtractor<GetNatMappingInfoRoutersRequest, String>() {
                            @Override
                            public String extract(GetNatMappingInfoRoutersRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VmEndpointNatMappingsList>newBuilder()
                      .setDefaultInstance(VmEndpointNatMappingsList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusMethodDescriptor =
          ApiMethodDescriptor.<GetRouterStatusRouterRequest, RouterStatusResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/GetRouterStatus")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRouterStatusRouterRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/routers/{router}/getRouterStatus",
                          new FieldsExtractor<GetRouterStatusRouterRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRouterStatusRouterRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRouterStatusRouterRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "router", request.getRouter());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRouterStatusRouterRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRouterStatusRouterRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRouterStatusRouterRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRouterStatusRouterRequest, String>() {
                            @Override
                            public String extract(GetRouterStatusRouterRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RouterStatusResponse>newBuilder()
                      .setDefaultInstance(RouterStatusResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRouterRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers",
                      new FieldsExtractor<InsertRouterRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertRouterRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertRouterRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertRouterRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertRouterRequest, String>() {
                        @Override
                        public String extract(InsertRouterRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("routerResource", request.getRouterResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListRoutersRequest, RouterList> listMethodDescriptor =
      ApiMethodDescriptor.<ListRoutersRequest, RouterList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListRoutersRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers",
                      new FieldsExtractor<ListRoutersRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListRoutersRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListRoutersRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListRoutersRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListRoutersRequest request) {
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
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ListRoutersRequest, String>() {
                        @Override
                        public String extract(ListRoutersRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<RouterList>newBuilder()
                  .setDefaultInstance(RouterList.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<PatchRouterRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      new FieldsExtractor<PatchRouterRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchRouterRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "router", request.getRouter());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchRouterRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchRouterRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchRouterRequest, String>() {
                        @Override
                        public String extract(PatchRouterRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("routerResource", request.getRouterResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<PreviewRouterRequest, RoutersPreviewResponse>
      previewMethodDescriptor =
          ApiMethodDescriptor.<PreviewRouterRequest, RoutersPreviewResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Routers/Preview")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewRouterRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/routers/{router}/preview",
                          new FieldsExtractor<PreviewRouterRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PreviewRouterRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PreviewRouterRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "router", request.getRouter());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<PreviewRouterRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(PreviewRouterRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PreviewRouterRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PreviewRouterRequest, String>() {
                            @Override
                            public String extract(PreviewRouterRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("routerResource", request.getRouterResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RoutersPreviewResponse>newBuilder()
                      .setDefaultInstance(RoutersPreviewResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRouterRequest, Operation> updateMethodDescriptor =
      ApiMethodDescriptor.<UpdateRouterRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Routers/Update")
          .setHttpMethod(HttpMethods.PUT)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateRouterRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/routers/{router}",
                      new FieldsExtractor<UpdateRouterRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(UpdateRouterRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<UpdateRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "router", request.getRouter());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<UpdateRouterRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(UpdateRouterRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<UpdateRouterRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<UpdateRouterRequest, String>() {
                        @Override
                        public String extract(UpdateRouterRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("routerResource", request.getRouterResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private final UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListRoutersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteRouterRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRouterRequest, Router> getCallable;
  private final UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoCallable;
  private final UnaryCallable<GetNatMappingInfoRoutersRequest, GetNatMappingInfoPagedResponse>
      getNatMappingInfoPagedCallable;
  private final UnaryCallable<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusCallable;
  private final UnaryCallable<InsertRouterRequest, Operation> insertCallable;
  private final UnaryCallable<ListRoutersRequest, RouterList> listCallable;
  private final UnaryCallable<ListRoutersRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchRouterRequest, Operation> patchCallable;
  private final UnaryCallable<PreviewRouterRequest, RoutersPreviewResponse> previewCallable;
  private final UnaryCallable<UpdateRouterRequest, Operation> updateCallable;

  private final BackgroundResource backgroundResources;
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

    HttpJsonCallSettings<AggregatedListRoutersRequest, RouterAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings.<AggregatedListRoutersRequest, RouterAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteRouterRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRouterRequest, Router> getTransportSettings =
        HttpJsonCallSettings.<GetRouterRequest, Router>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
        getNatMappingInfoTransportSettings =
            HttpJsonCallSettings
                .<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>newBuilder()
                .setMethodDescriptor(getNatMappingInfoMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRouterStatusRouterRequest, RouterStatusResponse>
        getRouterStatusTransportSettings =
            HttpJsonCallSettings.<GetRouterStatusRouterRequest, RouterStatusResponse>newBuilder()
                .setMethodDescriptor(getRouterStatusMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRouterRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRoutersRequest, RouterList> listTransportSettings =
        HttpJsonCallSettings.<ListRoutersRequest, RouterList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRouterRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<PreviewRouterRequest, RoutersPreviewResponse> previewTransportSettings =
        HttpJsonCallSettings.<PreviewRouterRequest, RoutersPreviewResponse>newBuilder()
            .setMethodDescriptor(previewMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateRouterRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRouterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
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
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.previewCallable =
        callableFactory.createUnaryCallable(
            previewTransportSettings, settings.previewSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);

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
  public UnaryCallable<PreviewRouterRequest, RoutersPreviewResponse> previewCallable() {
    return previewCallable;
  }

  @Override
  public UnaryCallable<UpdateRouterRequest, Operation> updateCallable() {
    return updateCallable;
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
