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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpsProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetSslCertificatesRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpsProxyRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionTargetHttpsProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionTargetHttpsProxiesStub extends RegionTargetHttpsProxiesStub {
  private static final ApiMethodDescriptor<DeleteRegionTargetHttpsProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}",
                          new FieldsExtractor<
                              DeleteRegionTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(DeleteRegionTargetHttpsProxyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}",
                          new FieldsExtractor<
                              GetRegionTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(GetRegionTargetHttpsProxyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxy>newBuilder()
                      .setDefaultInstance(TargetHttpsProxy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionTargetHttpsProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies",
                          new FieldsExtractor<
                              InsertRegionTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionTargetHttpsProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(InsertRegionTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetHttpsProxyResource",
                                      request.getTargetHttpsProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionTargetHttpsProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies",
                          new FieldsExtractor<
                              ListRegionTargetHttpsProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionTargetHttpsProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionTargetHttpsProxiesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionTargetHttpsProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionTargetHttpsProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionTargetHttpsProxiesRequest> serializer =
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
                          new FieldsExtractor<ListRegionTargetHttpsProxiesRequest, String>() {
                            @Override
                            public String extract(ListRegionTargetHttpsProxiesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpsProxyList>newBuilder()
                      .setDefaultInstance(TargetHttpsProxyList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesMethodDescriptor =
          ApiMethodDescriptor
              .<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionTargetHttpsProxies/SetSslCertificates")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetSslCertificatesRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates",
                          new FieldsExtractor<
                              SetSslCertificatesRegionTargetHttpsProxyRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSslCertificatesRegionTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslCertificatesRegionTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSslCertificatesRegionTargetHttpsProxyRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSslCertificatesRegionTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslCertificatesRegionTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              SetSslCertificatesRegionTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(
                                SetSslCertificatesRegionTargetHttpsProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionTargetHttpsProxiesSetSslCertificatesRequestResource",
                                      request
                                          .getRegionTargetHttpsProxiesSetSslCertificatesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
      setUrlMapMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapRegionTargetHttpsProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionTargetHttpsProxies/SetUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUrlMapRegionTargetHttpsProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap",
                          new FieldsExtractor<
                              SetUrlMapRegionTargetHttpsProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetUrlMapRegionTargetHttpsProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapRegionTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "targetHttpsProxy", request.getTargetHttpsProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetUrlMapRegionTargetHttpsProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetUrlMapRegionTargetHttpsProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapRegionTargetHttpsProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetUrlMapRegionTargetHttpsProxyRequest, String>() {
                            @Override
                            public String extract(SetUrlMapRegionTargetHttpsProxyRequest request) {
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

  private final UnaryCallable<DeleteRegionTargetHttpsProxyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getCallable;
  private final UnaryCallable<InsertRegionTargetHttpsProxyRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listCallable;
  private final UnaryCallable<ListRegionTargetHttpsProxiesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable;
  private final UnaryCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation> setUrlMapCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionTargetHttpsProxiesStub create(
      RegionTargetHttpsProxiesStubSettings settings) throws IOException {
    return new HttpJsonRegionTargetHttpsProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionTargetHttpsProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionTargetHttpsProxiesStub(
        RegionTargetHttpsProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionTargetHttpsProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionTargetHttpsProxiesStub(
        RegionTargetHttpsProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpsProxiesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpsProxiesStub(
      RegionTargetHttpsProxiesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionTargetHttpsProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpsProxiesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpsProxiesStub(
      RegionTargetHttpsProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionTargetHttpsProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getTransportSettings =
        HttpJsonCallSettings.<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionTargetHttpsProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionTargetHttpsProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
        setSslCertificatesTransportSettings =
            HttpJsonCallSettings
                .<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
        setUrlMapTransportSettings =
            HttpJsonCallSettings.<SetUrlMapRegionTargetHttpsProxyRequest, Operation>newBuilder()
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
    this.setSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesTransportSettings,
            settings.setSslCertificatesSettings(),
            clientContext);
    this.setUrlMapCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTransportSettings, settings.setUrlMapSettings(), clientContext);

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
    methodDescriptors.add(setSslCertificatesMethodDescriptor);
    methodDescriptors.add(setUrlMapMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionTargetHttpsProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionTargetHttpsProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionTargetHttpsProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return setSslCertificatesCallable;
  }

  @Override
  public UnaryCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation> setUrlMapCallable() {
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
