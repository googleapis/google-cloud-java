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

import static com.google.cloud.compute.v1.RegionSslCertificatesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionSslCertificateRequest;
import com.google.cloud.compute.v1.GetRegionSslCertificateRequest;
import com.google.cloud.compute.v1.InsertRegionSslCertificateRequest;
import com.google.cloud.compute.v1.ListRegionSslCertificatesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SslCertificate;
import com.google.cloud.compute.v1.SslCertificateList;
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
public class HttpJsonRegionSslCertificatesStub extends RegionSslCertificatesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionSslCertificateRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionSslCertificateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSslCertificates.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionSslCertificateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/sslCertificates/{sslCertificate}",
                          new FieldsExtractor<
                              DeleteRegionSslCertificateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionSslCertificateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "sslCertificate", request.getSslCertificate());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionSslCertificateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionSslCertificateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionSslCertificateRequest, String>() {
                            @Override
                            public String extract(DeleteRegionSslCertificateRequest request) {
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
  public static final ApiMethodDescriptor<GetRegionSslCertificateRequest, SslCertificate>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionSslCertificateRequest, SslCertificate>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSslCertificates.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionSslCertificateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/sslCertificates/{sslCertificate}",
                          new FieldsExtractor<
                              GetRegionSslCertificateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionSslCertificateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "sslCertificate", request.getSslCertificate());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionSslCertificateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionSslCertificateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionSslCertificateRequest, String>() {
                            @Override
                            public String extract(GetRegionSslCertificateRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertificate>newBuilder()
                      .setDefaultInstance(SslCertificate.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionSslCertificateRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionSslCertificateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSslCertificates.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionSslCertificateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/sslCertificates",
                          new FieldsExtractor<
                              InsertRegionSslCertificateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionSslCertificateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionSslCertificateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionSslCertificateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionSslCertificateRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionSslCertificateRequest, String>() {
                            @Override
                            public String extract(InsertRegionSslCertificateRequest request) {
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

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionSslCertificatesRequest, SslCertificateList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionSslCertificatesRequest, SslCertificateList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSslCertificates.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionSslCertificatesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/sslCertificates",
                          new FieldsExtractor<
                              ListRegionSslCertificatesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionSslCertificatesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionSslCertificatesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionSslCertificatesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionSslCertificatesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionSslCertificatesRequest> serializer =
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
                          new FieldsExtractor<ListRegionSslCertificatesRequest, String>() {
                            @Override
                            public String extract(ListRegionSslCertificatesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertificateList>newBuilder()
                      .setDefaultInstance(SslCertificateList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionSslCertificateRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionSslCertificateRequest, SslCertificate> getCallable;
  private final UnaryCallable<InsertRegionSslCertificateRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionSslCertificatesRequest, SslCertificateList> listCallable;
  private final UnaryCallable<ListRegionSslCertificatesRequest, ListPagedResponse>
      listPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionSslCertificatesStub create(
      RegionSslCertificatesStubSettings settings) throws IOException {
    return new HttpJsonRegionSslCertificatesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionSslCertificatesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionSslCertificatesStub(
        RegionSslCertificatesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionSslCertificatesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionSslCertificatesStub(
        RegionSslCertificatesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionSslCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionSslCertificatesStub(
      RegionSslCertificatesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionSslCertificatesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionSslCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionSslCertificatesStub(
      RegionSslCertificatesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionSslCertificateRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionSslCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionSslCertificateRequest, SslCertificate> getTransportSettings =
        HttpJsonCallSettings.<GetRegionSslCertificateRequest, SslCertificate>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionSslCertificateRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionSslCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionSslCertificatesRequest, SslCertificateList>
        listTransportSettings =
            HttpJsonCallSettings.<ListRegionSslCertificatesRequest, SslCertificateList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteRegionSslCertificateRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionSslCertificateRequest, SslCertificate> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertRegionSslCertificateRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRegionSslCertificatesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionSslCertificatesRequest, SslCertificateList> listCallable() {
    return listCallable;
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
