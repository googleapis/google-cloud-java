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

import static com.google.cloud.compute.v1.RegionTargetHttpProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionTargetHttpProxyRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpProxyRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpProxyRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpProxyRequest;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyList;
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
public class HttpJsonRegionTargetHttpProxiesStub extends RegionTargetHttpProxiesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionTargetHttpProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpProxies.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}",
                          new FieldsExtractor<
                              DeleteRegionTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(DeleteRegionTargetHttpProxyRequest request) {
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
  public static final ApiMethodDescriptor<GetRegionTargetHttpProxyRequest, TargetHttpProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionTargetHttpProxyRequest, TargetHttpProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpProxies.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}",
                          new FieldsExtractor<
                              GetRegionTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(GetRegionTargetHttpProxyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpProxy>newBuilder()
                      .setDefaultInstance(TargetHttpProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionTargetHttpProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpProxies.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpProxies",
                          new FieldsExtractor<
                              InsertRegionTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(InsertRegionTargetHttpProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpProxyResource",
                                      request.getTargetHttpProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionTargetHttpProxiesRequest, TargetHttpProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionTargetHttpProxiesRequest, TargetHttpProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpProxies.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionTargetHttpProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpProxies",
                          new FieldsExtractor<
                              ListRegionTargetHttpProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionTargetHttpProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionTargetHttpProxiesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionTargetHttpProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionTargetHttpProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionTargetHttpProxiesRequest> serializer =
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
                          new FieldsExtractor<ListRegionTargetHttpProxiesRequest, String>() {
                            @Override
                            public String extract(ListRegionTargetHttpProxiesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpProxyList>newBuilder()
                      .setDefaultInstance(TargetHttpProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetUrlMapRegionTargetHttpProxyRequest, Operation>
      setUrlMapMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapRegionTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpProxies.SetUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUrlMapRegionTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}/setUrlMap",
                          new FieldsExtractor<
                              SetUrlMapRegionTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetUrlMapRegionTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapRegionTargetHttpProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetUrlMapRegionTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetUrlMapRegionTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapRegionTargetHttpProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetUrlMapRegionTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(SetUrlMapRegionTargetHttpProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "urlMapReferenceResource",
                                      request.getUrlMapReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionTargetHttpProxyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionTargetHttpProxyRequest, TargetHttpProxy> getCallable;
  private final UnaryCallable<InsertRegionTargetHttpProxyRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionTargetHttpProxiesRequest, TargetHttpProxyList> listCallable;
  private final UnaryCallable<ListRegionTargetHttpProxiesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<SetUrlMapRegionTargetHttpProxyRequest, Operation> setUrlMapCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionTargetHttpProxiesStub create(
      RegionTargetHttpProxiesStubSettings settings) throws IOException {
    return new HttpJsonRegionTargetHttpProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionTargetHttpProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionTargetHttpProxiesStub(
        RegionTargetHttpProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionTargetHttpProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionTargetHttpProxiesStub(
        RegionTargetHttpProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpProxiesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpProxiesStub(
      RegionTargetHttpProxiesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionTargetHttpProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpProxiesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpProxiesStub(
      RegionTargetHttpProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionTargetHttpProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionTargetHttpProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionTargetHttpProxyRequest, TargetHttpProxy> getTransportSettings =
        HttpJsonCallSettings.<GetRegionTargetHttpProxyRequest, TargetHttpProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionTargetHttpProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionTargetHttpProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionTargetHttpProxiesRequest, TargetHttpProxyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionTargetHttpProxiesRequest, TargetHttpProxyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapRegionTargetHttpProxyRequest, Operation>
        setUrlMapTransportSettings =
            HttpJsonCallSettings.<SetUrlMapRegionTargetHttpProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setUrlMapMethodDescriptor)
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
    this.setUrlMapCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTransportSettings, settings.setUrlMapSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteRegionTargetHttpProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionTargetHttpProxyRequest, TargetHttpProxy> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertRegionTargetHttpProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRegionTargetHttpProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionTargetHttpProxiesRequest, TargetHttpProxyList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<SetUrlMapRegionTargetHttpProxyRequest, Operation> setUrlMapCallable() {
    return setUrlMapCallable;
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
