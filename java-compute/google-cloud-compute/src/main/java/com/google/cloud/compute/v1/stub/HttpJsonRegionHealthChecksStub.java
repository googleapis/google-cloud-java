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

import static com.google.cloud.compute.v1.RegionHealthChecksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionHealthCheckRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckRequest;
import com.google.cloud.compute.v1.ListRegionHealthChecksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckRequest;
import com.google.cloud.compute.v1.UpdateRegionHealthCheckRequest;
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
public class HttpJsonRegionHealthChecksStub extends RegionHealthChecksStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionHealthCheckRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthChecks.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthChecks/{healthCheck}",
                          new FieldsExtractor<
                              DeleteRegionHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionHealthCheckRequest, String>() {
                            @Override
                            public String extract(DeleteRegionHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<GetRegionHealthCheckRequest, HealthCheck>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionHealthCheckRequest, HealthCheck>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthChecks.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthChecks/{healthCheck}",
                          new FieldsExtractor<GetRegionHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionHealthCheckRequest, String>() {
                            @Override
                            public String extract(GetRegionHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<InsertRegionHealthCheckRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthChecks.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthChecks",
                          new FieldsExtractor<
                              InsertRegionHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionHealthCheckRequest, String>() {
                            @Override
                            public String extract(InsertRegionHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<ListRegionHealthChecksRequest, HealthCheckList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionHealthChecksRequest, HealthCheckList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthChecks.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthChecks",
                          new FieldsExtractor<
                              ListRegionHealthChecksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionHealthChecksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionHealthChecksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionHealthChecksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionHealthChecksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionHealthChecksRequest> serializer =
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
                          new FieldsExtractor<ListRegionHealthChecksRequest, String>() {
                            @Override
                            public String extract(ListRegionHealthChecksRequest request) {
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
  public static final ApiMethodDescriptor<PatchRegionHealthCheckRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthChecks.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthChecks/{healthCheck}",
                          new FieldsExtractor<
                              PatchRegionHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRegionHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRegionHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRegionHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRegionHealthCheckRequest, String>() {
                            @Override
                            public String extract(PatchRegionHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<UpdateRegionHealthCheckRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthChecks.Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegionHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthChecks/{healthCheck}",
                          new FieldsExtractor<
                              UpdateRegionHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateRegionHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "healthCheck", request.getHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateRegionHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateRegionHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateRegionHealthCheckRequest, String>() {
                            @Override
                            public String extract(UpdateRegionHealthCheckRequest request) {
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

  private final UnaryCallable<DeleteRegionHealthCheckRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionHealthCheckRequest, HealthCheck> getCallable;
  private final UnaryCallable<InsertRegionHealthCheckRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionHealthChecksRequest, HealthCheckList> listCallable;
  private final UnaryCallable<ListRegionHealthChecksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchRegionHealthCheckRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateRegionHealthCheckRequest, Operation> updateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionHealthChecksStub create(RegionHealthChecksStubSettings settings)
      throws IOException {
    return new HttpJsonRegionHealthChecksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionHealthChecksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionHealthChecksStub(
        RegionHealthChecksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionHealthChecksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionHealthChecksStub(
        RegionHealthChecksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthChecksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthChecksStub(
      RegionHealthChecksStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionHealthChecksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthChecksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthChecksStub(
      RegionHealthChecksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionHealthCheckRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionHealthCheckRequest, HealthCheck> getTransportSettings =
        HttpJsonCallSettings.<GetRegionHealthCheckRequest, HealthCheck>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionHealthCheckRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionHealthChecksRequest, HealthCheckList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionHealthChecksRequest, HealthCheckList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRegionHealthCheckRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateRegionHealthCheckRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRegionHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();

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

  public UnaryCallable<DeleteRegionHealthCheckRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionHealthCheckRequest, HealthCheck> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertRegionHealthCheckRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRegionHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionHealthChecksRequest, HealthCheckList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchRegionHealthCheckRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateRegionHealthCheckRequest, Operation> updateCallable() {
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
