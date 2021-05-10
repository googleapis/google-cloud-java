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

import static com.google.cloud.compute.v1.RegionAutoscalersClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.DeleteRegionAutoscalerRequest;
import com.google.cloud.compute.v1.GetRegionAutoscalerRequest;
import com.google.cloud.compute.v1.InsertRegionAutoscalerRequest;
import com.google.cloud.compute.v1.ListRegionAutoscalersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionAutoscalerRequest;
import com.google.cloud.compute.v1.RegionAutoscalerList;
import com.google.cloud.compute.v1.UpdateRegionAutoscalerRequest;
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
public class HttpJsonRegionAutoscalersStub extends RegionAutoscalersStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionAutoscalerRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionAutoscalerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionAutoscalers.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionAutoscalerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/autoscalers/{autoscaler}",
                          new FieldsExtractor<
                              DeleteRegionAutoscalerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionAutoscalerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "autoscaler", request.getAutoscaler());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionAutoscalerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionAutoscalerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionAutoscalerRequest, String>() {
                            @Override
                            public String extract(DeleteRegionAutoscalerRequest request) {
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
  public static final ApiMethodDescriptor<GetRegionAutoscalerRequest, Autoscaler>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionAutoscalerRequest, Autoscaler>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionAutoscalers.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionAutoscalerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/autoscalers/{autoscaler}",
                          new FieldsExtractor<GetRegionAutoscalerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetRegionAutoscalerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "autoscaler", request.getAutoscaler());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionAutoscalerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionAutoscalerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionAutoscalerRequest, String>() {
                            @Override
                            public String extract(GetRegionAutoscalerRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Autoscaler>newBuilder()
                      .setDefaultInstance(Autoscaler.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionAutoscalerRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionAutoscalerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionAutoscalers.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionAutoscalerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/autoscalers",
                          new FieldsExtractor<
                              InsertRegionAutoscalerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionAutoscalerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionAutoscalerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionAutoscalerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionAutoscalerRequest, String>() {
                            @Override
                            public String extract(InsertRegionAutoscalerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("autoscalerResource", request.getAutoscalerResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionAutoscalersRequest, RegionAutoscalerList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionAutoscalersRequest, RegionAutoscalerList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionAutoscalers.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionAutoscalersRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/autoscalers",
                          new FieldsExtractor<ListRegionAutoscalersRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionAutoscalersRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionAutoscalersRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionAutoscalersRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionAutoscalersRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionAutoscalersRequest> serializer =
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
                          new FieldsExtractor<ListRegionAutoscalersRequest, String>() {
                            @Override
                            public String extract(ListRegionAutoscalersRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegionAutoscalerList>newBuilder()
                      .setDefaultInstance(RegionAutoscalerList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionAutoscalerRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionAutoscalerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionAutoscalers.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionAutoscalerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/autoscalers",
                          new FieldsExtractor<PatchRegionAutoscalerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRegionAutoscalerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRegionAutoscalerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRegionAutoscalerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasAutoscaler()) {
                                serializer.putQueryParam(
                                    fields, "autoscaler", request.getAutoscaler());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRegionAutoscalerRequest, String>() {
                            @Override
                            public String extract(PatchRegionAutoscalerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("autoscalerResource", request.getAutoscalerResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRegionAutoscalerRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionAutoscalerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionAutoscalers.Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegionAutoscalerRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/autoscalers",
                          new FieldsExtractor<
                              UpdateRegionAutoscalerRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateRegionAutoscalerRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateRegionAutoscalerRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateRegionAutoscalerRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionAutoscalerRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasAutoscaler()) {
                                serializer.putQueryParam(
                                    fields, "autoscaler", request.getAutoscaler());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateRegionAutoscalerRequest, String>() {
                            @Override
                            public String extract(UpdateRegionAutoscalerRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("autoscalerResource", request.getAutoscalerResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionAutoscalerRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionAutoscalerRequest, Autoscaler> getCallable;
  private final UnaryCallable<InsertRegionAutoscalerRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionAutoscalersRequest, RegionAutoscalerList> listCallable;
  private final UnaryCallable<ListRegionAutoscalersRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchRegionAutoscalerRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateRegionAutoscalerRequest, Operation> updateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionAutoscalersStub create(RegionAutoscalersStubSettings settings)
      throws IOException {
    return new HttpJsonRegionAutoscalersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionAutoscalersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionAutoscalersStub(
        RegionAutoscalersStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionAutoscalersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionAutoscalersStub(
        RegionAutoscalersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionAutoscalersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionAutoscalersStub(
      RegionAutoscalersStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionAutoscalersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionAutoscalersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionAutoscalersStub(
      RegionAutoscalersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionAutoscalerRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionAutoscalerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionAutoscalerRequest, Autoscaler> getTransportSettings =
        HttpJsonCallSettings.<GetRegionAutoscalerRequest, Autoscaler>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionAutoscalerRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionAutoscalerRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionAutoscalersRequest, RegionAutoscalerList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionAutoscalersRequest, RegionAutoscalerList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRegionAutoscalerRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionAutoscalerRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateRegionAutoscalerRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRegionAutoscalerRequest, Operation>newBuilder()
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

  public UnaryCallable<DeleteRegionAutoscalerRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionAutoscalerRequest, Autoscaler> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertRegionAutoscalerRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRegionAutoscalersRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionAutoscalersRequest, RegionAutoscalerList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchRegionAutoscalerRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateRegionAutoscalerRequest, Operation> updateCallable() {
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
