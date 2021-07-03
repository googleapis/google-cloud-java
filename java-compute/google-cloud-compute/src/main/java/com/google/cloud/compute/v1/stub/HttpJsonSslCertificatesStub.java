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

import static com.google.cloud.compute.v1.SslCertificatesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SslCertificatesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSslCertificatesRequest;
import com.google.cloud.compute.v1.DeleteSslCertificateRequest;
import com.google.cloud.compute.v1.GetSslCertificateRequest;
import com.google.cloud.compute.v1.InsertSslCertificateRequest;
import com.google.cloud.compute.v1.ListSslCertificatesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SslCertificate;
import com.google.cloud.compute.v1.SslCertificateAggregatedList;
import com.google.cloud.compute.v1.SslCertificateList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the SslCertificates service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonSslCertificatesStub extends SslCertificatesStub {
  private static final ApiMethodDescriptor<
          AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslCertificates/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListSslCertificatesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/sslCertificates",
                          new FieldsExtractor<
                              AggregatedListSslCertificatesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListSslCertificatesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListSslCertificatesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListSslCertificatesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListSslCertificatesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListSslCertificatesRequest> serializer =
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
                          new FieldsExtractor<AggregatedListSslCertificatesRequest, String>() {
                            @Override
                            public String extract(AggregatedListSslCertificatesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertificateAggregatedList>newBuilder()
                      .setDefaultInstance(SslCertificateAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSslCertificateRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSslCertificateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslCertificates/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSslCertificateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslCertificates/{sslCertificate}",
                          new FieldsExtractor<DeleteSslCertificateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteSslCertificateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "sslCertificate", request.getSslCertificate());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteSslCertificateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSslCertificateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteSslCertificateRequest, String>() {
                            @Override
                            public String extract(DeleteSslCertificateRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSslCertificateRequest, SslCertificate>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetSslCertificateRequest, SslCertificate>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslCertificates/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSslCertificateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslCertificates/{sslCertificate}",
                          new FieldsExtractor<GetSslCertificateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetSslCertificateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "sslCertificate", request.getSslCertificate());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetSslCertificateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetSslCertificateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetSslCertificateRequest, String>() {
                            @Override
                            public String extract(GetSslCertificateRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertificate>newBuilder()
                      .setDefaultInstance(SslCertificate.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertSslCertificateRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertSslCertificateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslCertificates/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertSslCertificateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslCertificates",
                          new FieldsExtractor<InsertSslCertificateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertSslCertificateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertSslCertificateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertSslCertificateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertSslCertificateRequest, String>() {
                            @Override
                            public String extract(InsertSslCertificateRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "sslCertificateResource",
                                      request.getSslCertificateResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSslCertificatesRequest, SslCertificateList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSslCertificatesRequest, SslCertificateList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslCertificates/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSslCertificatesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslCertificates",
                          new FieldsExtractor<ListSslCertificatesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListSslCertificatesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListSslCertificatesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListSslCertificatesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListSslCertificatesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListSslCertificatesRequest> serializer =
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
                          new FieldsExtractor<ListSslCertificatesRequest, String>() {
                            @Override
                            public String extract(ListSslCertificatesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertificateList>newBuilder()
                      .setDefaultInstance(SslCertificateList.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListSslCertificatesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteSslCertificateRequest, Operation> deleteCallable;
  private final UnaryCallable<GetSslCertificateRequest, SslCertificate> getCallable;
  private final UnaryCallable<InsertSslCertificateRequest, Operation> insertCallable;
  private final UnaryCallable<ListSslCertificatesRequest, SslCertificateList> listCallable;
  private final UnaryCallable<ListSslCertificatesRequest, ListPagedResponse> listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSslCertificatesStub create(SslCertificatesStubSettings settings)
      throws IOException {
    return new HttpJsonSslCertificatesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSslCertificatesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSslCertificatesStub(
        SslCertificatesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSslCertificatesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSslCertificatesStub(
        SslCertificatesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSslCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSslCertificatesStub(
      SslCertificatesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSslCertificatesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSslCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSslCertificatesStub(
      SslCertificatesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteSslCertificateRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSslCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSslCertificateRequest, SslCertificate> getTransportSettings =
        HttpJsonCallSettings.<GetSslCertificateRequest, SslCertificate>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertSslCertificateRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertSslCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSslCertificatesRequest, SslCertificateList> listTransportSettings =
        HttpJsonCallSettings.<ListSslCertificatesRequest, SslCertificateList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
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
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListSslCertificatesRequest, SslCertificateAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListSslCertificatesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSslCertificateRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetSslCertificateRequest, SslCertificate> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertSslCertificateRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListSslCertificatesRequest, SslCertificateList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListSslCertificatesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
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
