/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.NetworksClient.ListPeeringRoutesPagedResponse;

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
import com.google.cloud.compute.v1.AddPeeringNetworkRequest;
import com.google.cloud.compute.v1.DeleteNetworkRequest;
import com.google.cloud.compute.v1.ExchangedPeeringRoutesList;
import com.google.cloud.compute.v1.GetEffectiveFirewallsNetworkRequest;
import com.google.cloud.compute.v1.GetNetworkRequest;
import com.google.cloud.compute.v1.InsertNetworkRequest;
import com.google.cloud.compute.v1.ListNetworksRequest;
import com.google.cloud.compute.v1.ListPeeringRoutesNetworksRequest;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkList;
import com.google.cloud.compute.v1.NetworksGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkRequest;
import com.google.cloud.compute.v1.RemovePeeringNetworkRequest;
import com.google.cloud.compute.v1.SwitchToCustomModeNetworkRequest;
import com.google.cloud.compute.v1.UpdatePeeringNetworkRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonNetworksStub extends NetworksStub {

  @InternalApi
  public static final ApiMethodDescriptor<AddPeeringNetworkRequest, Operation>
      addPeeringMethodDescriptor =
          ApiMethodDescriptor.<AddPeeringNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Networks.AddPeering")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddPeeringNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networks/{network}/addPeering",
                          new FieldsExtractor<AddPeeringNetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(AddPeeringNetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddPeeringNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "network", request.getNetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddPeeringNetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddPeeringNetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddPeeringNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddPeeringNetworkRequest, String>() {
                            @Override
                            public String extract(AddPeeringNetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "networksAddPeeringRequestResource",
                                      request.getNetworksAddPeeringRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteNetworkRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteNetworkRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Networks.Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteNetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/networks/{network}",
                      new FieldsExtractor<DeleteNetworkRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteNetworkRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "network", request.getNetwork());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteNetworkRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteNetworkRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteNetworkRequest, String>() {
                        @Override
                        public String extract(DeleteNetworkRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetNetworkRequest, Network> getMethodDescriptor =
      ApiMethodDescriptor.<GetNetworkRequest, Network>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Networks.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/networks/{network}",
                      new FieldsExtractor<GetNetworkRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetNetworkRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "network", request.getNetwork());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetNetworkRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetNetworkRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetNetworkRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetNetworkRequest, String>() {
                        @Override
                        public String extract(GetNetworkRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Network>newBuilder()
                  .setDefaultInstance(Network.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsMethodDescriptor =
          ApiMethodDescriptor
              .<GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Networks.GetEffectiveFirewalls")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEffectiveFirewallsNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networks/{network}/getEffectiveFirewalls",
                          new FieldsExtractor<
                              GetEffectiveFirewallsNetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetEffectiveFirewallsNetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetEffectiveFirewallsNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "network", request.getNetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetEffectiveFirewallsNetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetEffectiveFirewallsNetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetEffectiveFirewallsNetworkRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetEffectiveFirewallsNetworkRequest, String>() {
                            @Override
                            public String extract(GetEffectiveFirewallsNetworkRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworksGetEffectiveFirewallsResponse>newBuilder()
                      .setDefaultInstance(
                          NetworksGetEffectiveFirewallsResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertNetworkRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertNetworkRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Networks.Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertNetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/networks",
                      new FieldsExtractor<InsertNetworkRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertNetworkRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertNetworkRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertNetworkRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertNetworkRequest, String>() {
                        @Override
                        public String extract(InsertNetworkRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("networkResource", request.getNetworkResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListNetworksRequest, NetworkList> listMethodDescriptor =
      ApiMethodDescriptor.<ListNetworksRequest, NetworkList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Networks.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListNetworksRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/networks",
                      new FieldsExtractor<ListNetworksRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListNetworksRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListNetworksRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListNetworksRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListNetworksRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ListNetworksRequest> serializer =
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
                      new FieldsExtractor<ListNetworksRequest, String>() {
                        @Override
                        public String extract(ListNetworksRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<NetworkList>newBuilder()
                  .setDefaultInstance(NetworkList.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
      listPeeringRoutesMethodDescriptor =
          ApiMethodDescriptor
              .<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Networks.ListPeeringRoutes")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPeeringRoutesNetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networks/{network}/listPeeringRoutes",
                          new FieldsExtractor<
                              ListPeeringRoutesNetworksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListPeeringRoutesNetworksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListPeeringRoutesNetworksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "network", request.getNetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListPeeringRoutesNetworksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListPeeringRoutesNetworksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListPeeringRoutesNetworksRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasDirection()) {
                                serializer.putQueryParam(
                                    fields, "direction", request.getDirection());
                              }
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
                              if (request.hasPeeringName()) {
                                serializer.putQueryParam(
                                    fields, "peeringName", request.getPeeringName());
                              }
                              if (request.hasRegion()) {
                                serializer.putQueryParam(fields, "region", request.getRegion());
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
                          new FieldsExtractor<ListPeeringRoutesNetworksRequest, String>() {
                            @Override
                            public String extract(ListPeeringRoutesNetworksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExchangedPeeringRoutesList>newBuilder()
                      .setDefaultInstance(ExchangedPeeringRoutesList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchNetworkRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchNetworkRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Networks.Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchNetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/networks/{network}",
                      new FieldsExtractor<PatchNetworkRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchNetworkRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "network", request.getNetwork());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchNetworkRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchNetworkRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchNetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchNetworkRequest, String>() {
                        @Override
                        public String extract(PatchNetworkRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("networkResource", request.getNetworkResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemovePeeringNetworkRequest, Operation>
      removePeeringMethodDescriptor =
          ApiMethodDescriptor.<RemovePeeringNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Networks.RemovePeering")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemovePeeringNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networks/{network}/removePeering",
                          new FieldsExtractor<RemovePeeringNetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemovePeeringNetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemovePeeringNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "network", request.getNetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemovePeeringNetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemovePeeringNetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemovePeeringNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemovePeeringNetworkRequest, String>() {
                            @Override
                            public String extract(RemovePeeringNetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "networksRemovePeeringRequestResource",
                                      request.getNetworksRemovePeeringRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeMethodDescriptor =
          ApiMethodDescriptor.<SwitchToCustomModeNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Networks.SwitchToCustomMode")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SwitchToCustomModeNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networks/{network}/switchToCustomMode",
                          new FieldsExtractor<
                              SwitchToCustomModeNetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SwitchToCustomModeNetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SwitchToCustomModeNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "network", request.getNetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SwitchToCustomModeNetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SwitchToCustomModeNetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SwitchToCustomModeNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SwitchToCustomModeNetworkRequest, String>() {
                            @Override
                            public String extract(SwitchToCustomModeNetworkRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdatePeeringNetworkRequest, Operation>
      updatePeeringMethodDescriptor =
          ApiMethodDescriptor.<UpdatePeeringNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Networks.UpdatePeering")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePeeringNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networks/{network}/updatePeering",
                          new FieldsExtractor<UpdatePeeringNetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdatePeeringNetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdatePeeringNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "network", request.getNetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdatePeeringNetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdatePeeringNetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdatePeeringNetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdatePeeringNetworkRequest, String>() {
                            @Override
                            public String extract(UpdatePeeringNetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "networksUpdatePeeringRequestResource",
                                      request.getNetworksUpdatePeeringRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddPeeringNetworkRequest, Operation> addPeeringCallable;
  private final UnaryCallable<DeleteNetworkRequest, Operation> deleteCallable;
  private final UnaryCallable<GetNetworkRequest, Network> getCallable;
  private final UnaryCallable<
          GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable;
  private final UnaryCallable<InsertNetworkRequest, Operation> insertCallable;
  private final UnaryCallable<ListNetworksRequest, NetworkList> listCallable;
  private final UnaryCallable<ListNetworksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
      listPeeringRoutesCallable;
  private final UnaryCallable<ListPeeringRoutesNetworksRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable;
  private final UnaryCallable<PatchNetworkRequest, Operation> patchCallable;
  private final UnaryCallable<RemovePeeringNetworkRequest, Operation> removePeeringCallable;
  private final UnaryCallable<SwitchToCustomModeNetworkRequest, Operation>
      switchToCustomModeCallable;
  private final UnaryCallable<UpdatePeeringNetworkRequest, Operation> updatePeeringCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetworksStub create(NetworksStubSettings settings)
      throws IOException {
    return new HttpJsonNetworksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworksStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonNetworksStub(NetworksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworksStub(
        NetworksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNetworksStub(NetworksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNetworksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNetworksStub(
      NetworksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddPeeringNetworkRequest, Operation> addPeeringTransportSettings =
        HttpJsonCallSettings.<AddPeeringNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(addPeeringMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteNetworkRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetNetworkRequest, Network> getTransportSettings =
        HttpJsonCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
        getEffectiveFirewallsTransportSettings =
            HttpJsonCallSettings
                .<GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
                    newBuilder()
                .setMethodDescriptor(getEffectiveFirewallsMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertNetworkRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListNetworksRequest, NetworkList> listTransportSettings =
        HttpJsonCallSettings.<ListNetworksRequest, NetworkList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
        listPeeringRoutesTransportSettings =
            HttpJsonCallSettings
                .<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>newBuilder()
                .setMethodDescriptor(listPeeringRoutesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchNetworkRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemovePeeringNetworkRequest, Operation> removePeeringTransportSettings =
        HttpJsonCallSettings.<RemovePeeringNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(removePeeringMethodDescriptor)
            .build();
    HttpJsonCallSettings<SwitchToCustomModeNetworkRequest, Operation>
        switchToCustomModeTransportSettings =
            HttpJsonCallSettings.<SwitchToCustomModeNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(switchToCustomModeMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdatePeeringNetworkRequest, Operation> updatePeeringTransportSettings =
        HttpJsonCallSettings.<UpdatePeeringNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePeeringMethodDescriptor)
            .build();

    this.addPeeringCallable =
        callableFactory.createUnaryCallable(
            addPeeringTransportSettings, settings.addPeeringSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getEffectiveFirewallsCallable =
        callableFactory.createUnaryCallable(
            getEffectiveFirewallsTransportSettings,
            settings.getEffectiveFirewallsSettings(),
            clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPeeringRoutesCallable =
        callableFactory.createUnaryCallable(
            listPeeringRoutesTransportSettings,
            settings.listPeeringRoutesSettings(),
            clientContext);
    this.listPeeringRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listPeeringRoutesTransportSettings,
            settings.listPeeringRoutesSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.removePeeringCallable =
        callableFactory.createUnaryCallable(
            removePeeringTransportSettings, settings.removePeeringSettings(), clientContext);
    this.switchToCustomModeCallable =
        callableFactory.createUnaryCallable(
            switchToCustomModeTransportSettings,
            settings.switchToCustomModeSettings(),
            clientContext);
    this.updatePeeringCallable =
        callableFactory.createUnaryCallable(
            updatePeeringTransportSettings, settings.updatePeeringSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AddPeeringNetworkRequest, Operation> addPeeringCallable() {
    return addPeeringCallable;
  }

  public UnaryCallable<DeleteNetworkRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetNetworkRequest, Network> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    return getEffectiveFirewallsCallable;
  }

  public UnaryCallable<InsertNetworkRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListNetworksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListNetworksRequest, NetworkList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<ListPeeringRoutesNetworksRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    return listPeeringRoutesPagedCallable;
  }

  public UnaryCallable<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
      listPeeringRoutesCallable() {
    return listPeeringRoutesCallable;
  }

  public UnaryCallable<PatchNetworkRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<RemovePeeringNetworkRequest, Operation> removePeeringCallable() {
    return removePeeringCallable;
  }

  public UnaryCallable<SwitchToCustomModeNetworkRequest, Operation> switchToCustomModeCallable() {
    return switchToCustomModeCallable;
  }

  public UnaryCallable<UpdatePeeringNetworkRequest, Operation> updatePeeringCallable() {
    return updatePeeringCallable;
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
