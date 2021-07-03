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

import static com.google.cloud.compute.v1.RegionUrlMapsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionUrlMapRequest;
import com.google.cloud.compute.v1.GetRegionUrlMapRequest;
import com.google.cloud.compute.v1.InsertRegionUrlMapRequest;
import com.google.cloud.compute.v1.ListRegionUrlMapsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionUrlMapRequest;
import com.google.cloud.compute.v1.UpdateRegionUrlMapRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateRegionUrlMapRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionUrlMaps service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionUrlMapsStub extends RegionUrlMapsStub {
  private static final ApiMethodDescriptor<DeleteRegionUrlMapRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionUrlMapRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/urlMaps/{urlMap}",
                          new FieldsExtractor<DeleteRegionUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteRegionUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionUrlMapRequest, String>() {
                            @Override
                            public String extract(DeleteRegionUrlMapRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegionUrlMapRequest, UrlMap> getMethodDescriptor =
      ApiMethodDescriptor.<GetRegionUrlMapRequest, UrlMap>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRegionUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/urlMaps/{urlMap}",
                      new FieldsExtractor<GetRegionUrlMapRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetRegionUrlMapRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetRegionUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetRegionUrlMapRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetRegionUrlMapRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetRegionUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetRegionUrlMapRequest, String>() {
                        @Override
                        public String extract(GetRegionUrlMapRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<UrlMap>newBuilder()
                  .setDefaultInstance(UrlMap.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertRegionUrlMapRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionUrlMapRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/urlMaps",
                          new FieldsExtractor<InsertRegionUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertRegionUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionUrlMapRequest, String>() {
                            @Override
                            public String extract(InsertRegionUrlMapRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("urlMapResource", request.getUrlMapResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRegionUrlMapsRequest, UrlMapList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionUrlMapsRequest, UrlMapList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionUrlMapsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/urlMaps",
                          new FieldsExtractor<ListRegionUrlMapsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListRegionUrlMapsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionUrlMapsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionUrlMapsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionUrlMapsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionUrlMapsRequest> serializer =
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
                          new FieldsExtractor<ListRegionUrlMapsRequest, String>() {
                            @Override
                            public String extract(ListRegionUrlMapsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UrlMapList>newBuilder()
                      .setDefaultInstance(UrlMapList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRegionUrlMapRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionUrlMapRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/urlMaps/{urlMap}",
                          new FieldsExtractor<PatchRegionUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PatchRegionUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRegionUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRegionUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRegionUrlMapRequest, String>() {
                            @Override
                            public String extract(PatchRegionUrlMapRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("urlMapResource", request.getUrlMapResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRegionUrlMapRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionUrlMapRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegionUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/urlMaps/{urlMap}",
                          new FieldsExtractor<UpdateRegionUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(UpdateRegionUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateRegionUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateRegionUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateRegionUrlMapRequest, String>() {
                            @Override
                            public String extract(UpdateRegionUrlMapRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("urlMapResource", request.getUrlMapResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
      validateMethodDescriptor =
          ApiMethodDescriptor.<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionUrlMaps/Validate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateRegionUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/urlMaps/{urlMap}/validate",
                          new FieldsExtractor<ValidateRegionUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ValidateRegionUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ValidateRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ValidateRegionUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ValidateRegionUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ValidateRegionUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ValidateRegionUrlMapRequest, String>() {
                            @Override
                            public String extract(ValidateRegionUrlMapRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionUrlMapsValidateRequestResource",
                                      request.getRegionUrlMapsValidateRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UrlMapsValidateResponse>newBuilder()
                      .setDefaultInstance(UrlMapsValidateResponse.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<DeleteRegionUrlMapRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionUrlMapRequest, UrlMap> getCallable;
  private final UnaryCallable<InsertRegionUrlMapRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionUrlMapsRequest, UrlMapList> listCallable;
  private final UnaryCallable<ListRegionUrlMapsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchRegionUrlMapRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateRegionUrlMapRequest, Operation> updateCallable;
  private final UnaryCallable<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
      validateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionUrlMapsStub create(RegionUrlMapsStubSettings settings)
      throws IOException {
    return new HttpJsonRegionUrlMapsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionUrlMapsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionUrlMapsStub(
        RegionUrlMapsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionUrlMapsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionUrlMapsStub(
        RegionUrlMapsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionUrlMapsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionUrlMapsStub(
      RegionUrlMapsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionUrlMapsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionUrlMapsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionUrlMapsStub(
      RegionUrlMapsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionUrlMapRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionUrlMapRequest, UrlMap> getTransportSettings =
        HttpJsonCallSettings.<GetRegionUrlMapRequest, UrlMap>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionUrlMapRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionUrlMapsRequest, UrlMapList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionUrlMapsRequest, UrlMapList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRegionUrlMapRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateRegionUrlMapRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRegionUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();
    HttpJsonCallSettings<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
        validateTransportSettings =
            HttpJsonCallSettings.<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>newBuilder()
                .setMethodDescriptor(validateMethodDescriptor)
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
    this.validateCallable =
        callableFactory.createUnaryCallable(
            validateTransportSettings, settings.validateSettings(), clientContext);

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
    methodDescriptors.add(updateMethodDescriptor);
    methodDescriptors.add(validateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionUrlMapRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetRegionUrlMapRequest, UrlMap> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionUrlMapRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListRegionUrlMapsRequest, UrlMapList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionUrlMapRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<UpdateRegionUrlMapRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public UnaryCallable<ValidateRegionUrlMapRequest, UrlMapsValidateResponse> validateCallable() {
    return validateCallable;
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
