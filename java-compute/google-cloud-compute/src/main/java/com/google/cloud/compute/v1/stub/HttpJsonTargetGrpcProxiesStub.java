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

import static com.google.cloud.compute.v1.TargetGrpcProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetGrpcProxyRequest;
import com.google.cloud.compute.v1.GetTargetGrpcProxyRequest;
import com.google.cloud.compute.v1.InsertTargetGrpcProxyRequest;
import com.google.cloud.compute.v1.ListTargetGrpcProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetGrpcProxyRequest;
import com.google.cloud.compute.v1.TargetGrpcProxy;
import com.google.cloud.compute.v1.TargetGrpcProxyList;
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
public class HttpJsonTargetGrpcProxiesStub extends TargetGrpcProxiesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetGrpcProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetGrpcProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetGrpcProxies.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetGrpcProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetGrpcProxies/{targetGrpcProxy}",
                          new FieldsExtractor<DeleteTargetGrpcProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteTargetGrpcProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetGrpcProxy", request.getTargetGrpcProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteTargetGrpcProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteTargetGrpcProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteTargetGrpcProxyRequest, String>() {
                            @Override
                            public String extract(DeleteTargetGrpcProxyRequest request) {
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
  public static final ApiMethodDescriptor<GetTargetGrpcProxyRequest, TargetGrpcProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetGrpcProxyRequest, TargetGrpcProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetGrpcProxies.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetGrpcProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetGrpcProxies/{targetGrpcProxy}",
                          new FieldsExtractor<GetTargetGrpcProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetTargetGrpcProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetGrpcProxy", request.getTargetGrpcProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetTargetGrpcProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetTargetGrpcProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetTargetGrpcProxyRequest, String>() {
                            @Override
                            public String extract(GetTargetGrpcProxyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetGrpcProxy>newBuilder()
                      .setDefaultInstance(TargetGrpcProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetGrpcProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetGrpcProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetGrpcProxies.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetGrpcProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetGrpcProxies",
                          new FieldsExtractor<InsertTargetGrpcProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertTargetGrpcProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertTargetGrpcProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertTargetGrpcProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertTargetGrpcProxyRequest, String>() {
                            @Override
                            public String extract(InsertTargetGrpcProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetGrpcProxyResource",
                                      request.getTargetGrpcProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListTargetGrpcProxiesRequest, TargetGrpcProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetGrpcProxiesRequest, TargetGrpcProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetGrpcProxies.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetGrpcProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetGrpcProxies",
                          new FieldsExtractor<ListTargetGrpcProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListTargetGrpcProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetGrpcProxiesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListTargetGrpcProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListTargetGrpcProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetGrpcProxiesRequest> serializer =
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
                          new FieldsExtractor<ListTargetGrpcProxiesRequest, String>() {
                            @Override
                            public String extract(ListTargetGrpcProxiesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetGrpcProxyList>newBuilder()
                      .setDefaultInstance(TargetGrpcProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchTargetGrpcProxyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchTargetGrpcProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetGrpcProxies.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchTargetGrpcProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetGrpcProxies/{targetGrpcProxy}",
                          new FieldsExtractor<PatchTargetGrpcProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchTargetGrpcProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetGrpcProxy", request.getTargetGrpcProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchTargetGrpcProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchTargetGrpcProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchTargetGrpcProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchTargetGrpcProxyRequest, String>() {
                            @Override
                            public String extract(PatchTargetGrpcProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetGrpcProxyResource",
                                      request.getTargetGrpcProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteTargetGrpcProxyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetTargetGrpcProxyRequest, TargetGrpcProxy> getCallable;
  private final UnaryCallable<InsertTargetGrpcProxyRequest, Operation> insertCallable;
  private final UnaryCallable<ListTargetGrpcProxiesRequest, TargetGrpcProxyList> listCallable;
  private final UnaryCallable<ListTargetGrpcProxiesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchTargetGrpcProxyRequest, Operation> patchCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetGrpcProxiesStub create(TargetGrpcProxiesStubSettings settings)
      throws IOException {
    return new HttpJsonTargetGrpcProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetGrpcProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetGrpcProxiesStub(
        TargetGrpcProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetGrpcProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetGrpcProxiesStub(
        TargetGrpcProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetGrpcProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetGrpcProxiesStub(
      TargetGrpcProxiesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetGrpcProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetGrpcProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetGrpcProxiesStub(
      TargetGrpcProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteTargetGrpcProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetGrpcProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetGrpcProxyRequest, TargetGrpcProxy> getTransportSettings =
        HttpJsonCallSettings.<GetTargetGrpcProxyRequest, TargetGrpcProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertTargetGrpcProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetGrpcProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetGrpcProxiesRequest, TargetGrpcProxyList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetGrpcProxiesRequest, TargetGrpcProxyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchTargetGrpcProxyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchTargetGrpcProxyRequest, Operation>newBuilder()
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteTargetGrpcProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetTargetGrpcProxyRequest, TargetGrpcProxy> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertTargetGrpcProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListTargetGrpcProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListTargetGrpcProxiesRequest, TargetGrpcProxyList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchTargetGrpcProxyRequest, Operation> patchCallable() {
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
