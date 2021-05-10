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

import static com.google.cloud.compute.v1.HealthChecksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.HealthChecksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListHealthChecksRequest;
import com.google.cloud.compute.v1.DeleteHealthCheckRequest;
import com.google.cloud.compute.v1.GetHealthCheckRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.HealthChecksAggregatedList;
import com.google.cloud.compute.v1.InsertHealthCheckRequest;
import com.google.cloud.compute.v1.ListHealthChecksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHealthCheckRequest;
import com.google.cloud.compute.v1.UpdateHealthCheckRequest;
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
public class HttpJsonHealthChecksStub extends HealthChecksStub {

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/healthChecks",
                          new FieldsExtractor<
                              AggregatedListHealthChecksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListHealthChecksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListHealthChecksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListHealthChecksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListHealthChecksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListHealthChecksRequest> serializer =
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
                          new FieldsExtractor<AggregatedListHealthChecksRequest, String>() {
                            @Override
                            public String extract(AggregatedListHealthChecksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HealthChecksAggregatedList>newBuilder()
                      .setDefaultInstance(HealthChecksAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteHealthCheckRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                          new FieldsExtractor<DeleteHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteHealthCheckRequest, String>() {
                            @Override
                            public String extract(DeleteHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<GetHealthCheckRequest, HealthCheck> getMethodDescriptor =
      ApiMethodDescriptor.<GetHealthCheckRequest, HealthCheck>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.HealthChecks.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetHealthCheckRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                      new FieldsExtractor<GetHealthCheckRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetHealthCheckRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetHealthCheckRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "healthCheck", request.getHealthCheck());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetHealthCheckRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetHealthCheckRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetHealthCheckRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetHealthCheckRequest, String>() {
                        @Override
                        public String extract(GetHealthCheckRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<HealthCheck>newBuilder()
                  .setDefaultInstance(HealthCheck.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertHealthCheckRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks",
                          new FieldsExtractor<InsertHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertHealthCheckRequest, String>() {
                            @Override
                            public String extract(InsertHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("healthCheckResource", request.getHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListHealthChecksRequest, HealthCheckList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListHealthChecksRequest, HealthCheckList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks",
                          new FieldsExtractor<ListHealthChecksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListHealthChecksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListHealthChecksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListHealthChecksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListHealthChecksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListHealthChecksRequest> serializer =
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
                          new FieldsExtractor<ListHealthChecksRequest, String>() {
                            @Override
                            public String extract(ListHealthChecksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HealthCheckList>newBuilder()
                      .setDefaultInstance(HealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchHealthCheckRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                          new FieldsExtractor<PatchHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PatchHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchHealthCheckRequest, String>() {
                            @Override
                            public String extract(PatchHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("healthCheckResource", request.getHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateHealthCheckRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks.Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                          new FieldsExtractor<UpdateHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(UpdateHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateHealthCheckRequest, String>() {
                            @Override
                            public String extract(UpdateHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("healthCheckResource", request.getHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteHealthCheckRequest, Operation> deleteCallable;
  private final UnaryCallable<GetHealthCheckRequest, HealthCheck> getCallable;
  private final UnaryCallable<InsertHealthCheckRequest, Operation> insertCallable;
  private final UnaryCallable<ListHealthChecksRequest, HealthCheckList> listCallable;
  private final UnaryCallable<ListHealthChecksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchHealthCheckRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateHealthCheckRequest, Operation> updateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHealthChecksStub create(HealthChecksStubSettings settings)
      throws IOException {
    return new HttpJsonHealthChecksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHealthChecksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHealthChecksStub(
        HealthChecksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHealthChecksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHealthChecksStub(
        HealthChecksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHealthChecksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHealthChecksStub(HealthChecksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonHealthChecksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHealthChecksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHealthChecksStub(
      HealthChecksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteHealthCheckRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHealthCheckRequest, HealthCheck> getTransportSettings =
        HttpJsonCallSettings.<GetHealthCheckRequest, HealthCheck>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertHealthCheckRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListHealthChecksRequest, HealthCheckList> listTransportSettings =
        HttpJsonCallSettings.<ListHealthChecksRequest, HealthCheckList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchHealthCheckRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateHealthCheckRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateHealthCheckRequest, Operation>newBuilder()
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
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AggregatedListHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<DeleteHealthCheckRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetHealthCheckRequest, HealthCheck> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertHealthCheckRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListHealthChecksRequest, HealthCheckList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchHealthCheckRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateHealthCheckRequest, Operation> updateCallable() {
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
