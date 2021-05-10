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

import static com.google.cloud.compute.v1.UrlMapsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.UrlMapsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListUrlMapsRequest;
import com.google.cloud.compute.v1.DeleteUrlMapRequest;
import com.google.cloud.compute.v1.GetUrlMapRequest;
import com.google.cloud.compute.v1.InsertUrlMapRequest;
import com.google.cloud.compute.v1.InvalidateCacheUrlMapRequest;
import com.google.cloud.compute.v1.ListUrlMapsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchUrlMapRequest;
import com.google.cloud.compute.v1.UpdateUrlMapRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsAggregatedList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateUrlMapRequest;
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
public class HttpJsonUrlMapsStub extends UrlMapsStub {

  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.UrlMaps.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListUrlMapsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/urlMaps",
                          new FieldsExtractor<AggregatedListUrlMapsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListUrlMapsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListUrlMapsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListUrlMapsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListUrlMapsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListUrlMapsRequest> serializer =
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
                          new FieldsExtractor<AggregatedListUrlMapsRequest, String>() {
                            @Override
                            public String extract(AggregatedListUrlMapsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UrlMapsAggregatedList>newBuilder()
                      .setDefaultInstance(UrlMapsAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteUrlMapRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps.Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      new FieldsExtractor<DeleteUrlMapRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteUrlMapRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteUrlMapRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteUrlMapRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteUrlMapRequest, String>() {
                        @Override
                        public String extract(DeleteUrlMapRequest request) {
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
  public static final ApiMethodDescriptor<GetUrlMapRequest, UrlMap> getMethodDescriptor =
      ApiMethodDescriptor.<GetUrlMapRequest, UrlMap>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      new FieldsExtractor<GetUrlMapRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetUrlMapRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetUrlMapRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetUrlMapRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetUrlMapRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetUrlMapRequest, String>() {
                        @Override
                        public String extract(GetUrlMapRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<UrlMap>newBuilder()
                  .setDefaultInstance(UrlMap.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertUrlMapRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps.Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps",
                      new FieldsExtractor<InsertUrlMapRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertUrlMapRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertUrlMapRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertUrlMapRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertUrlMapRequest, String>() {
                        @Override
                        public String extract(InsertUrlMapRequest request) {
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

  @InternalApi
  public static final ApiMethodDescriptor<InvalidateCacheUrlMapRequest, Operation>
      invalidateCacheMethodDescriptor =
          ApiMethodDescriptor.<InvalidateCacheUrlMapRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.UrlMaps.InvalidateCache")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InvalidateCacheUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/urlMaps/{urlMap}/invalidateCache",
                          new FieldsExtractor<InvalidateCacheUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InvalidateCacheUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InvalidateCacheUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InvalidateCacheUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InvalidateCacheUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InvalidateCacheUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InvalidateCacheUrlMapRequest, String>() {
                            @Override
                            public String extract(InvalidateCacheUrlMapRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "cacheInvalidationRuleResource",
                                      request.getCacheInvalidationRuleResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListUrlMapsRequest, UrlMapList> listMethodDescriptor =
      ApiMethodDescriptor.<ListUrlMapsRequest, UrlMapList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListUrlMapsRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps",
                      new FieldsExtractor<ListUrlMapsRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListUrlMapsRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListUrlMapsRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListUrlMapsRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListUrlMapsRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ListUrlMapsRequest> serializer =
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
                      new FieldsExtractor<ListUrlMapsRequest, String>() {
                        @Override
                        public String extract(ListUrlMapsRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<UrlMapList>newBuilder()
                  .setDefaultInstance(UrlMapList.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchUrlMapRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps.Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      new FieldsExtractor<PatchUrlMapRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchUrlMapRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchUrlMapRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchUrlMapRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchUrlMapRequest, String>() {
                        @Override
                        public String extract(PatchUrlMapRequest request) {
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

  @InternalApi
  public static final ApiMethodDescriptor<UpdateUrlMapRequest, Operation> updateMethodDescriptor =
      ApiMethodDescriptor.<UpdateUrlMapRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.UrlMaps.Update")
          .setHttpMethod(HttpMethods.PUT)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateUrlMapRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/urlMaps/{urlMap}",
                      new FieldsExtractor<UpdateUrlMapRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(UpdateUrlMapRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<UpdateUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<UpdateUrlMapRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(UpdateUrlMapRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<UpdateUrlMapRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<UpdateUrlMapRequest, String>() {
                        @Override
                        public String extract(UpdateUrlMapRequest request) {
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

  @InternalApi
  public static final ApiMethodDescriptor<ValidateUrlMapRequest, UrlMapsValidateResponse>
      validateMethodDescriptor =
          ApiMethodDescriptor.<ValidateUrlMapRequest, UrlMapsValidateResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.UrlMaps.Validate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateUrlMapRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/urlMaps/{urlMap}/validate",
                          new FieldsExtractor<ValidateUrlMapRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ValidateUrlMapRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ValidateUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "urlMap", request.getUrlMap());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ValidateUrlMapRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ValidateUrlMapRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ValidateUrlMapRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ValidateUrlMapRequest, String>() {
                            @Override
                            public String extract(ValidateUrlMapRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "urlMapsValidateRequestResource",
                                      request.getUrlMapsValidateRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UrlMapsValidateResponse>newBuilder()
                      .setDefaultInstance(UrlMapsValidateResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListUrlMapsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteUrlMapRequest, Operation> deleteCallable;
  private final UnaryCallable<GetUrlMapRequest, UrlMap> getCallable;
  private final UnaryCallable<InsertUrlMapRequest, Operation> insertCallable;
  private final UnaryCallable<InvalidateCacheUrlMapRequest, Operation> invalidateCacheCallable;
  private final UnaryCallable<ListUrlMapsRequest, UrlMapList> listCallable;
  private final UnaryCallable<ListUrlMapsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchUrlMapRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateUrlMapRequest, Operation> updateCallable;
  private final UnaryCallable<ValidateUrlMapRequest, UrlMapsValidateResponse> validateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUrlMapsStub create(UrlMapsStubSettings settings) throws IOException {
    return new HttpJsonUrlMapsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUrlMapsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonUrlMapsStub(UrlMapsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonUrlMapsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUrlMapsStub(
        UrlMapsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUrlMapsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUrlMapsStub(UrlMapsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUrlMapsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUrlMapsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUrlMapsStub(
      UrlMapsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings.<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteUrlMapRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetUrlMapRequest, UrlMap> getTransportSettings =
        HttpJsonCallSettings.<GetUrlMapRequest, UrlMap>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertUrlMapRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<InvalidateCacheUrlMapRequest, Operation> invalidateCacheTransportSettings =
        HttpJsonCallSettings.<InvalidateCacheUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(invalidateCacheMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListUrlMapsRequest, UrlMapList> listTransportSettings =
        HttpJsonCallSettings.<ListUrlMapsRequest, UrlMapList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchUrlMapRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateUrlMapRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateUrlMapRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();
    HttpJsonCallSettings<ValidateUrlMapRequest, UrlMapsValidateResponse> validateTransportSettings =
        HttpJsonCallSettings.<ValidateUrlMapRequest, UrlMapsValidateResponse>newBuilder()
            .setMethodDescriptor(validateMethodDescriptor)
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
    this.invalidateCacheCallable =
        callableFactory.createUnaryCallable(
            invalidateCacheTransportSettings, settings.invalidateCacheSettings(), clientContext);
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AggregatedListUrlMapsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<DeleteUrlMapRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetUrlMapRequest, UrlMap> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertUrlMapRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<InvalidateCacheUrlMapRequest, Operation> invalidateCacheCallable() {
    return invalidateCacheCallable;
  }

  public UnaryCallable<ListUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListUrlMapsRequest, UrlMapList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchUrlMapRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateUrlMapRequest, Operation> updateCallable() {
    return updateCallable;
  }

  public UnaryCallable<ValidateUrlMapRequest, UrlMapsValidateResponse> validateCallable() {
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
