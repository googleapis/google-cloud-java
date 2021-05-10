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

import static com.google.cloud.compute.v1.RegionBackendServicesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteRegionBackendServiceRequest;
import com.google.cloud.compute.v1.GetHealthRegionBackendServiceRequest;
import com.google.cloud.compute.v1.GetRegionBackendServiceRequest;
import com.google.cloud.compute.v1.InsertRegionBackendServiceRequest;
import com.google.cloud.compute.v1.ListRegionBackendServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionBackendServiceRequest;
import com.google.cloud.compute.v1.UpdateRegionBackendServiceRequest;
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
public class HttpJsonRegionBackendServicesStub extends RegionBackendServicesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionBackendServiceRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices/{backendService}",
                          new FieldsExtractor<
                              DeleteRegionBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionBackendServiceRequest, String>() {
                            @Override
                            public String extract(DeleteRegionBackendServiceRequest request) {
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
  public static final ApiMethodDescriptor<GetRegionBackendServiceRequest, BackendService>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionBackendServiceRequest, BackendService>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices/{backendService}",
                          new FieldsExtractor<
                              GetRegionBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionBackendServiceRequest, String>() {
                            @Override
                            public String extract(GetRegionBackendServiceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendService>newBuilder()
                      .setDefaultInstance(BackendService.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
      getHealthMethodDescriptor =
          ApiMethodDescriptor
              .<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.GetHealth")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHealthRegionBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices/{backendService}/getHealth",
                          new FieldsExtractor<
                              GetHealthRegionBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetHealthRegionBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetHealthRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetHealthRegionBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetHealthRegionBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetHealthRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetHealthRegionBackendServiceRequest, String>() {
                            @Override
                            public String extract(GetHealthRegionBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "resourceGroupReferenceResource",
                                      request.getResourceGroupReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendServiceGroupHealth>newBuilder()
                      .setDefaultInstance(BackendServiceGroupHealth.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionBackendServiceRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices",
                          new FieldsExtractor<
                              InsertRegionBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionBackendServiceRequest, String>() {
                            @Override
                            public String extract(InsertRegionBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendServiceResource",
                                      request.getBackendServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionBackendServicesRequest, BackendServiceList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionBackendServicesRequest, BackendServiceList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionBackendServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices",
                          new FieldsExtractor<
                              ListRegionBackendServicesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionBackendServicesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionBackendServicesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionBackendServicesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionBackendServicesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionBackendServicesRequest> serializer =
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
                          new FieldsExtractor<ListRegionBackendServicesRequest, String>() {
                            @Override
                            public String extract(ListRegionBackendServicesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendServiceList>newBuilder()
                      .setDefaultInstance(BackendServiceList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionBackendServiceRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices/{backendService}",
                          new FieldsExtractor<
                              PatchRegionBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRegionBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRegionBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRegionBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRegionBackendServiceRequest, String>() {
                            @Override
                            public String extract(PatchRegionBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendServiceResource",
                                      request.getBackendServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRegionBackendServiceRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionBackendServices.Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegionBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/backendServices/{backendService}",
                          new FieldsExtractor<
                              UpdateRegionBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateRegionBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateRegionBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateRegionBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateRegionBackendServiceRequest, String>() {
                            @Override
                            public String extract(UpdateRegionBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendServiceResource",
                                      request.getBackendServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionBackendServiceRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionBackendServiceRequest, BackendService> getCallable;
  private final UnaryCallable<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable;
  private final UnaryCallable<InsertRegionBackendServiceRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionBackendServicesRequest, BackendServiceList> listCallable;
  private final UnaryCallable<ListRegionBackendServicesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchRegionBackendServiceRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateRegionBackendServiceRequest, Operation> updateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionBackendServicesStub create(
      RegionBackendServicesStubSettings settings) throws IOException {
    return new HttpJsonRegionBackendServicesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionBackendServicesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionBackendServicesStub(
        RegionBackendServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionBackendServicesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionBackendServicesStub(
        RegionBackendServicesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionBackendServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionBackendServicesStub(
      RegionBackendServicesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionBackendServicesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionBackendServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionBackendServicesStub(
      RegionBackendServicesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionBackendServiceRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionBackendServiceRequest, BackendService> getTransportSettings =
        HttpJsonCallSettings.<GetRegionBackendServiceRequest, BackendService>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
        getHealthTransportSettings =
            HttpJsonCallSettings
                .<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>newBuilder()
                .setMethodDescriptor(getHealthMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionBackendServiceRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionBackendServicesRequest, BackendServiceList>
        listTransportSettings =
            HttpJsonCallSettings.<ListRegionBackendServicesRequest, BackendServiceList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionBackendServiceRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateRegionBackendServiceRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRegionBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getHealthCallable =
        callableFactory.createUnaryCallable(
            getHealthTransportSettings, settings.getHealthSettings(), clientContext);
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

  public UnaryCallable<DeleteRegionBackendServiceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionBackendServiceRequest, BackendService> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    return getHealthCallable;
  }

  public UnaryCallable<InsertRegionBackendServiceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRegionBackendServicesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionBackendServicesRequest, BackendServiceList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchRegionBackendServiceRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateRegionBackendServiceRequest, Operation> updateCallable() {
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
