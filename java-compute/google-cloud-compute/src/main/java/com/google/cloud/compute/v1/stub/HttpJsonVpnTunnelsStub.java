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

import static com.google.cloud.compute.v1.VpnTunnelsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListVpnTunnelsRequest;
import com.google.cloud.compute.v1.DeleteVpnTunnelRequest;
import com.google.cloud.compute.v1.GetVpnTunnelRequest;
import com.google.cloud.compute.v1.InsertVpnTunnelRequest;
import com.google.cloud.compute.v1.ListVpnTunnelsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.VpnTunnel;
import com.google.cloud.compute.v1.VpnTunnelAggregatedList;
import com.google.cloud.compute.v1.VpnTunnelList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the VpnTunnels service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonVpnTunnelsStub extends VpnTunnelsStub {
  private static final ApiMethodDescriptor<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnTunnels/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListVpnTunnelsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/vpnTunnels",
                          new FieldsExtractor<
                              AggregatedListVpnTunnelsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListVpnTunnelsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListVpnTunnelsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListVpnTunnelsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListVpnTunnelsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListVpnTunnelsRequest> serializer =
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
                          new FieldsExtractor<AggregatedListVpnTunnelsRequest, String>() {
                            @Override
                            public String extract(AggregatedListVpnTunnelsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VpnTunnelAggregatedList>newBuilder()
                      .setDefaultInstance(VpnTunnelAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteVpnTunnelRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteVpnTunnelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnTunnels/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVpnTunnelRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnTunnels/{vpnTunnel}",
                          new FieldsExtractor<DeleteVpnTunnelRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteVpnTunnelRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteVpnTunnelRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "vpnTunnel", request.getVpnTunnel());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<DeleteVpnTunnelRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteVpnTunnelRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteVpnTunnelRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteVpnTunnelRequest, String>() {
                            @Override
                            public String extract(DeleteVpnTunnelRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVpnTunnelRequest, VpnTunnel> getMethodDescriptor =
      ApiMethodDescriptor.<GetVpnTunnelRequest, VpnTunnel>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.VpnTunnels/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVpnTunnelRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/vpnTunnels/{vpnTunnel}",
                      new FieldsExtractor<GetVpnTunnelRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetVpnTunnelRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetVpnTunnelRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "vpnTunnel", request.getVpnTunnel());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetVpnTunnelRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetVpnTunnelRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetVpnTunnelRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetVpnTunnelRequest, String>() {
                        @Override
                        public String extract(GetVpnTunnelRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<VpnTunnel>newBuilder()
                  .setDefaultInstance(VpnTunnel.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertVpnTunnelRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertVpnTunnelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnTunnels/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertVpnTunnelRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnTunnels",
                          new FieldsExtractor<InsertVpnTunnelRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertVpnTunnelRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertVpnTunnelRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<InsertVpnTunnelRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertVpnTunnelRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertVpnTunnelRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertVpnTunnelRequest, String>() {
                            @Override
                            public String extract(InsertVpnTunnelRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("vpnTunnelResource", request.getVpnTunnelResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListVpnTunnelsRequest, VpnTunnelList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListVpnTunnelsRequest, VpnTunnelList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnTunnels/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVpnTunnelsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnTunnels",
                          new FieldsExtractor<ListVpnTunnelsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListVpnTunnelsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListVpnTunnelsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListVpnTunnelsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListVpnTunnelsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListVpnTunnelsRequest> serializer =
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
                          new FieldsExtractor<ListVpnTunnelsRequest, String>() {
                            @Override
                            public String extract(ListVpnTunnelsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VpnTunnelList>newBuilder()
                      .setDefaultInstance(VpnTunnelList.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListVpnTunnelsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteVpnTunnelRequest, Operation> deleteCallable;
  private final UnaryCallable<GetVpnTunnelRequest, VpnTunnel> getCallable;
  private final UnaryCallable<InsertVpnTunnelRequest, Operation> insertCallable;
  private final UnaryCallable<ListVpnTunnelsRequest, VpnTunnelList> listCallable;
  private final UnaryCallable<ListVpnTunnelsRequest, ListPagedResponse> listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVpnTunnelsStub create(VpnTunnelsStubSettings settings)
      throws IOException {
    return new HttpJsonVpnTunnelsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVpnTunnelsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVpnTunnelsStub(VpnTunnelsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonVpnTunnelsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVpnTunnelsStub(
        VpnTunnelsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVpnTunnelsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnTunnelsStub(VpnTunnelsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVpnTunnelsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVpnTunnelsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnTunnelsStub(
      VpnTunnelsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteVpnTunnelRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteVpnTunnelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetVpnTunnelRequest, VpnTunnel> getTransportSettings =
        HttpJsonCallSettings.<GetVpnTunnelRequest, VpnTunnel>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertVpnTunnelRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertVpnTunnelRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListVpnTunnelsRequest, VpnTunnelList> listTransportSettings =
        HttpJsonCallSettings.<ListVpnTunnelsRequest, VpnTunnelList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
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
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListVpnTunnelsRequest, VpnTunnelAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListVpnTunnelsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteVpnTunnelRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetVpnTunnelRequest, VpnTunnel> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertVpnTunnelRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListVpnTunnelsRequest, VpnTunnelList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListVpnTunnelsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
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
