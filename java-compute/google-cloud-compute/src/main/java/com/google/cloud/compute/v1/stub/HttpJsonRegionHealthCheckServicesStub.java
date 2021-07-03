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

import static com.google.cloud.compute.v1.RegionHealthCheckServicesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionHealthCheckServiceRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckServiceRequest;
import com.google.cloud.compute.v1.HealthCheckService;
import com.google.cloud.compute.v1.HealthCheckServicesList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckServiceRequest;
import com.google.cloud.compute.v1.ListRegionHealthCheckServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckServiceRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionHealthCheckServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionHealthCheckServicesStub extends RegionHealthCheckServicesStub {
  private static final ApiMethodDescriptor<DeleteRegionHealthCheckServiceRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionHealthCheckServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthCheckServices/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionHealthCheckServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthCheckServices/{healthCheckService}",
                          new FieldsExtractor<
                              DeleteRegionHealthCheckServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionHealthCheckServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionHealthCheckServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "healthCheckService", request.getHealthCheckService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionHealthCheckServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionHealthCheckServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionHealthCheckServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionHealthCheckServiceRequest, String>() {
                            @Override
                            public String extract(DeleteRegionHealthCheckServiceRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegionHealthCheckServiceRequest, HealthCheckService>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionHealthCheckServiceRequest, HealthCheckService>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthCheckServices/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionHealthCheckServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthCheckServices/{healthCheckService}",
                          new FieldsExtractor<
                              GetRegionHealthCheckServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionHealthCheckServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionHealthCheckServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "healthCheckService", request.getHealthCheckService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionHealthCheckServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionHealthCheckServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionHealthCheckServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionHealthCheckServiceRequest, String>() {
                            @Override
                            public String extract(GetRegionHealthCheckServiceRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HealthCheckService>newBuilder()
                      .setDefaultInstance(HealthCheckService.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionHealthCheckServiceRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionHealthCheckServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthCheckServices/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionHealthCheckServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthCheckServices",
                          new FieldsExtractor<
                              InsertRegionHealthCheckServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionHealthCheckServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionHealthCheckServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionHealthCheckServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionHealthCheckServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionHealthCheckServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionHealthCheckServiceRequest, String>() {
                            @Override
                            public String extract(InsertRegionHealthCheckServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "healthCheckServiceResource",
                                      request.getHealthCheckServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListRegionHealthCheckServicesRequest, HealthCheckServicesList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthCheckServices/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionHealthCheckServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthCheckServices",
                          new FieldsExtractor<
                              ListRegionHealthCheckServicesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionHealthCheckServicesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionHealthCheckServicesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionHealthCheckServicesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionHealthCheckServicesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionHealthCheckServicesRequest> serializer =
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
                          new FieldsExtractor<ListRegionHealthCheckServicesRequest, String>() {
                            @Override
                            public String extract(ListRegionHealthCheckServicesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HealthCheckServicesList>newBuilder()
                      .setDefaultInstance(HealthCheckServicesList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRegionHealthCheckServiceRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionHealthCheckServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionHealthCheckServices/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionHealthCheckServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/healthCheckServices/{healthCheckService}",
                          new FieldsExtractor<
                              PatchRegionHealthCheckServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRegionHealthCheckServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionHealthCheckServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "healthCheckService", request.getHealthCheckService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRegionHealthCheckServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRegionHealthCheckServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionHealthCheckServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRegionHealthCheckServiceRequest, String>() {
                            @Override
                            public String extract(PatchRegionHealthCheckServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "healthCheckServiceResource",
                                      request.getHealthCheckServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<DeleteRegionHealthCheckServiceRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionHealthCheckServiceRequest, HealthCheckService> getCallable;
  private final UnaryCallable<InsertRegionHealthCheckServiceRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>
      listCallable;
  private final UnaryCallable<ListRegionHealthCheckServicesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchRegionHealthCheckServiceRequest, Operation> patchCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionHealthCheckServicesStub create(
      RegionHealthCheckServicesStubSettings settings) throws IOException {
    return new HttpJsonRegionHealthCheckServicesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionHealthCheckServicesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionHealthCheckServicesStub(
        RegionHealthCheckServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionHealthCheckServicesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionHealthCheckServicesStub(
        RegionHealthCheckServicesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthCheckServicesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthCheckServicesStub(
      RegionHealthCheckServicesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionHealthCheckServicesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthCheckServicesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthCheckServicesStub(
      RegionHealthCheckServicesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionHealthCheckServiceRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionHealthCheckServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionHealthCheckServiceRequest, HealthCheckService>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionHealthCheckServiceRequest, HealthCheckService>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionHealthCheckServiceRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionHealthCheckServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionHealthCheckServiceRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionHealthCheckServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
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
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionHealthCheckServiceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetRegionHealthCheckServiceRequest, HealthCheckService> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionHealthCheckServiceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListRegionHealthCheckServicesRequest, HealthCheckServicesList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionHealthCheckServicesRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionHealthCheckServiceRequest, Operation> patchCallable() {
    return patchCallable;
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
