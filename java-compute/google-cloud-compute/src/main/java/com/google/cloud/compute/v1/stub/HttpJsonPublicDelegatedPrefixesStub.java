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

import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.DeletePublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.GetPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.InsertPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.ListPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.PublicDelegatedPrefix;
import com.google.cloud.compute.v1.PublicDelegatedPrefixAggregatedList;
import com.google.cloud.compute.v1.PublicDelegatedPrefixList;
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
public class HttpJsonPublicDelegatedPrefixesStub extends PublicDelegatedPrefixesStub {

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListPublicDelegatedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/publicDelegatedPrefixes",
                          new FieldsExtractor<
                              AggregatedListPublicDelegatedPrefixesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListPublicDelegatedPrefixesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListPublicDelegatedPrefixesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListPublicDelegatedPrefixesRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListPublicDelegatedPrefixesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListPublicDelegatedPrefixesRequest>
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
                          new FieldsExtractor<
                              AggregatedListPublicDelegatedPrefixesRequest, String>() {
                            @Override
                            public String extract(
                                AggregatedListPublicDelegatedPrefixesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicDelegatedPrefixAggregatedList>newBuilder()
                      .setDefaultInstance(PublicDelegatedPrefixAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeletePublicDelegatedPrefixeRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeletePublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          new FieldsExtractor<
                              DeletePublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeletePublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeletePublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields,
                                  "publicDelegatedPrefix",
                                  request.getPublicDelegatedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeletePublicDelegatedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeletePublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeletePublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeletePublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(DeletePublicDelegatedPrefixeRequest request) {
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
  public static final ApiMethodDescriptor<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          new FieldsExtractor<
                              GetPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetPublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields,
                                  "publicDelegatedPrefix",
                                  request.getPublicDelegatedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetPublicDelegatedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetPublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(GetPublicDelegatedPrefixeRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicDelegatedPrefix>newBuilder()
                      .setDefaultInstance(PublicDelegatedPrefix.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertPublicDelegatedPrefixeRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes",
                          new FieldsExtractor<
                              InsertPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertPublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertPublicDelegatedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertPublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(InsertPublicDelegatedPrefixeRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "publicDelegatedPrefixResource",
                                      request.getPublicDelegatedPrefixResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPublicDelegatedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes",
                          new FieldsExtractor<
                              ListPublicDelegatedPrefixesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListPublicDelegatedPrefixesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListPublicDelegatedPrefixesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListPublicDelegatedPrefixesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListPublicDelegatedPrefixesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListPublicDelegatedPrefixesRequest> serializer =
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
                          new FieldsExtractor<ListPublicDelegatedPrefixesRequest, String>() {
                            @Override
                            public String extract(ListPublicDelegatedPrefixesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicDelegatedPrefixList>newBuilder()
                      .setDefaultInstance(PublicDelegatedPrefixList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchPublicDelegatedPrefixeRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          new FieldsExtractor<
                              PatchPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchPublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields,
                                  "publicDelegatedPrefix",
                                  request.getPublicDelegatedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchPublicDelegatedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchPublicDelegatedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(PatchPublicDelegatedPrefixeRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "publicDelegatedPrefixResource",
                                      request.getPublicDelegatedPrefixResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListPublicDelegatedPrefixesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeletePublicDelegatedPrefixeRequest, Operation> deleteCallable;
  private final UnaryCallable<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix> getCallable;
  private final UnaryCallable<InsertPublicDelegatedPrefixeRequest, Operation> insertCallable;
  private final UnaryCallable<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable;
  private final UnaryCallable<ListPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchPublicDelegatedPrefixeRequest, Operation> patchCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPublicDelegatedPrefixesStub create(
      PublicDelegatedPrefixesStubSettings settings) throws IOException {
    return new HttpJsonPublicDelegatedPrefixesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPublicDelegatedPrefixesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPublicDelegatedPrefixesStub(
        PublicDelegatedPrefixesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPublicDelegatedPrefixesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPublicDelegatedPrefixesStub(
        PublicDelegatedPrefixesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPublicDelegatedPrefixesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPublicDelegatedPrefixesStub(
      PublicDelegatedPrefixesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPublicDelegatedPrefixesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPublicDelegatedPrefixesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPublicDelegatedPrefixesStub(
      PublicDelegatedPrefixesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeletePublicDelegatedPrefixeRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeletePublicDelegatedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertPublicDelegatedPrefixeRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertPublicDelegatedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchPublicDelegatedPrefixeRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchPublicDelegatedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AggregatedListPublicDelegatedPrefixesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<
          AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<DeletePublicDelegatedPrefixeRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertPublicDelegatedPrefixeRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListPublicDelegatedPrefixesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchPublicDelegatedPrefixeRequest, Operation> patchCallable() {
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
