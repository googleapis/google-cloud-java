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

import static com.google.cloud.compute.v1.TargetVpnGatewaysClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetVpnGatewaysClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetVpnGatewaysRequest;
import com.google.cloud.compute.v1.DeleteTargetVpnGatewayRequest;
import com.google.cloud.compute.v1.GetTargetVpnGatewayRequest;
import com.google.cloud.compute.v1.InsertTargetVpnGatewayRequest;
import com.google.cloud.compute.v1.ListTargetVpnGatewaysRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TargetVpnGateway;
import com.google.cloud.compute.v1.TargetVpnGatewayAggregatedList;
import com.google.cloud.compute.v1.TargetVpnGatewayList;
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
public class HttpJsonTargetVpnGatewaysStub extends TargetVpnGatewaysStub {

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetVpnGateways.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListTargetVpnGatewaysRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/targetVpnGateways",
                          new FieldsExtractor<
                              AggregatedListTargetVpnGatewaysRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListTargetVpnGatewaysRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetVpnGatewaysRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListTargetVpnGatewaysRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListTargetVpnGatewaysRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetVpnGatewaysRequest>
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
                          new FieldsExtractor<AggregatedListTargetVpnGatewaysRequest, String>() {
                            @Override
                            public String extract(AggregatedListTargetVpnGatewaysRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetVpnGatewayAggregatedList>newBuilder()
                      .setDefaultInstance(TargetVpnGatewayAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetVpnGatewayRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetVpnGateways.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetVpnGateways/{targetVpnGateway}",
                          new FieldsExtractor<
                              DeleteTargetVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteTargetVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetVpnGateway", request.getTargetVpnGateway());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteTargetVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteTargetVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteTargetVpnGatewayRequest, String>() {
                            @Override
                            public String extract(DeleteTargetVpnGatewayRequest request) {
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
  public static final ApiMethodDescriptor<GetTargetVpnGatewayRequest, TargetVpnGateway>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetVpnGatewayRequest, TargetVpnGateway>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetVpnGateways.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetVpnGateways/{targetVpnGateway}",
                          new FieldsExtractor<GetTargetVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetTargetVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetVpnGateway", request.getTargetVpnGateway());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetTargetVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetTargetVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetTargetVpnGatewayRequest, String>() {
                            @Override
                            public String extract(GetTargetVpnGatewayRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetVpnGateway>newBuilder()
                      .setDefaultInstance(TargetVpnGateway.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetVpnGatewayRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetVpnGateways.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetVpnGateways",
                          new FieldsExtractor<
                              InsertTargetVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertTargetVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertTargetVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertTargetVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertTargetVpnGatewayRequest, String>() {
                            @Override
                            public String extract(InsertTargetVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetVpnGatewayResource",
                                      request.getTargetVpnGatewayResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListTargetVpnGatewaysRequest, TargetVpnGatewayList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetVpnGatewaysRequest, TargetVpnGatewayList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetVpnGateways.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetVpnGatewaysRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetVpnGateways",
                          new FieldsExtractor<ListTargetVpnGatewaysRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListTargetVpnGatewaysRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetVpnGatewaysRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListTargetVpnGatewaysRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListTargetVpnGatewaysRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetVpnGatewaysRequest> serializer =
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
                          new FieldsExtractor<ListTargetVpnGatewaysRequest, String>() {
                            @Override
                            public String extract(ListTargetVpnGatewaysRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetVpnGatewayList>newBuilder()
                      .setDefaultInstance(TargetVpnGatewayList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListTargetVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteTargetVpnGatewayRequest, Operation> deleteCallable;
  private final UnaryCallable<GetTargetVpnGatewayRequest, TargetVpnGateway> getCallable;
  private final UnaryCallable<InsertTargetVpnGatewayRequest, Operation> insertCallable;
  private final UnaryCallable<ListTargetVpnGatewaysRequest, TargetVpnGatewayList> listCallable;
  private final UnaryCallable<ListTargetVpnGatewaysRequest, ListPagedResponse> listPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetVpnGatewaysStub create(TargetVpnGatewaysStubSettings settings)
      throws IOException {
    return new HttpJsonTargetVpnGatewaysStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetVpnGatewaysStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetVpnGatewaysStub(
        TargetVpnGatewaysStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetVpnGatewaysStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetVpnGatewaysStub(
        TargetVpnGatewaysStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetVpnGatewaysStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetVpnGatewaysStub(
      TargetVpnGatewaysStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetVpnGatewaysCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetVpnGatewaysStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetVpnGatewaysStub(
      TargetVpnGatewaysStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetVpnGatewayRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetVpnGatewayRequest, TargetVpnGateway> getTransportSettings =
        HttpJsonCallSettings.<GetTargetVpnGatewayRequest, TargetVpnGateway>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertTargetVpnGatewayRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetVpnGatewaysRequest, TargetVpnGatewayList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetVpnGatewaysRequest, TargetVpnGatewayList>newBuilder()
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AggregatedListTargetVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListTargetVpnGatewaysRequest, TargetVpnGatewayAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<DeleteTargetVpnGatewayRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetTargetVpnGatewayRequest, TargetVpnGateway> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertTargetVpnGatewayRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListTargetVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListTargetVpnGatewaysRequest, TargetVpnGatewayList> listCallable() {
    return listCallable;
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
