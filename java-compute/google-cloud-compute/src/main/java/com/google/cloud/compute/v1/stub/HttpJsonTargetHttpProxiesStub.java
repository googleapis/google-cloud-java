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

import static com.google.cloud.compute.v1.TargetHttpProxiesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetHttpProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetHttpProxiesRequest;
import com.google.cloud.compute.v1.DeleteTargetHttpProxyRequest;
import com.google.cloud.compute.v1.GetTargetHttpProxyRequest;
import com.google.cloud.compute.v1.InsertTargetHttpProxyRequest;
import com.google.cloud.compute.v1.ListTargetHttpProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetHttpProxyRequest;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpProxyRequest;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyAggregatedList;
import com.google.cloud.compute.v1.TargetHttpProxyList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TargetHttpProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonTargetHttpProxiesStub extends TargetHttpProxiesStub {
  private static final ApiMethodDescriptor<
          AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListTargetHttpProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/targetHttpProxies",
                          new FieldsExtractor<
                              AggregatedListTargetHttpProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListTargetHttpProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetHttpProxiesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListTargetHttpProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListTargetHttpProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListTargetHttpProxiesRequest>
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
                          new FieldsExtractor<AggregatedListTargetHttpProxiesRequest, String>() {
                            @Override
                            public String extract(AggregatedListTargetHttpProxiesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpProxyAggregatedList>newBuilder()
                      .setDefaultInstance(TargetHttpProxyAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTargetHttpProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpProxies/{targetHttpProxy}",
                          new FieldsExtractor<DeleteTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(DeleteTargetHttpProxyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTargetHttpProxyRequest, TargetHttpProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetHttpProxyRequest, TargetHttpProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpProxies/{targetHttpProxy}",
                          new FieldsExtractor<GetTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(GetTargetHttpProxyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpProxy>newBuilder()
                      .setDefaultInstance(TargetHttpProxy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertTargetHttpProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpProxies",
                          new FieldsExtractor<InsertTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(InsertTargetHttpProxyRequest request) {
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

  private static final ApiMethodDescriptor<ListTargetHttpProxiesRequest, TargetHttpProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetHttpProxiesRequest, TargetHttpProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetHttpProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpProxies",
                          new FieldsExtractor<ListTargetHttpProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListTargetHttpProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetHttpProxiesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListTargetHttpProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListTargetHttpProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetHttpProxiesRequest> serializer =
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
                          new FieldsExtractor<ListTargetHttpProxiesRequest, String>() {
                            @Override
                            public String extract(ListTargetHttpProxiesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetHttpProxyList>newBuilder()
                      .setDefaultInstance(TargetHttpProxyList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchTargetHttpProxyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetHttpProxies/{targetHttpProxy}",
                          new FieldsExtractor<PatchTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(PatchTargetHttpProxyRequest request) {
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

  private static final ApiMethodDescriptor<SetUrlMapTargetHttpProxyRequest, Operation>
      setUrlMapMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapTargetHttpProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetHttpProxies/SetUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUrlMapTargetHttpProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/targetHttpProxies/{targetHttpProxy}/setUrlMap",
                          new FieldsExtractor<
                              SetUrlMapTargetHttpProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetUrlMapTargetHttpProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetHttpProxy", request.getTargetHttpProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetUrlMapTargetHttpProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetUrlMapTargetHttpProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetUrlMapTargetHttpProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetUrlMapTargetHttpProxyRequest, String>() {
                            @Override
                            public String extract(SetUrlMapTargetHttpProxyRequest request) {
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

  private final UnaryCallable<AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListTargetHttpProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteTargetHttpProxyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetTargetHttpProxyRequest, TargetHttpProxy> getCallable;
  private final UnaryCallable<InsertTargetHttpProxyRequest, Operation> insertCallable;
  private final UnaryCallable<ListTargetHttpProxiesRequest, TargetHttpProxyList> listCallable;
  private final UnaryCallable<ListTargetHttpProxiesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchTargetHttpProxyRequest, Operation> patchCallable;
  private final UnaryCallable<SetUrlMapTargetHttpProxyRequest, Operation> setUrlMapCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetHttpProxiesStub create(TargetHttpProxiesStubSettings settings)
      throws IOException {
    return new HttpJsonTargetHttpProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetHttpProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetHttpProxiesStub(
        TargetHttpProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetHttpProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetHttpProxiesStub(
        TargetHttpProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpProxiesStub(
      TargetHttpProxiesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetHttpProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpProxiesStub(
      TargetHttpProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetHttpProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetHttpProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetHttpProxyRequest, TargetHttpProxy> getTransportSettings =
        HttpJsonCallSettings.<GetTargetHttpProxyRequest, TargetHttpProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertTargetHttpProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetHttpProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetHttpProxiesRequest, TargetHttpProxyList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetHttpProxiesRequest, TargetHttpProxyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchTargetHttpProxyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchTargetHttpProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetUrlMapTargetHttpProxyRequest, Operation> setUrlMapTransportSettings =
        HttpJsonCallSettings.<SetUrlMapTargetHttpProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(setUrlMapMethodDescriptor)
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
    this.setUrlMapCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTransportSettings, settings.setUrlMapSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setUrlMapMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListTargetHttpProxiesRequest, TargetHttpProxyAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListTargetHttpProxiesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetHttpProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetTargetHttpProxyRequest, TargetHttpProxy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertTargetHttpProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListTargetHttpProxiesRequest, TargetHttpProxyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListTargetHttpProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchTargetHttpProxyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SetUrlMapTargetHttpProxyRequest, Operation> setUrlMapCallable() {
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
