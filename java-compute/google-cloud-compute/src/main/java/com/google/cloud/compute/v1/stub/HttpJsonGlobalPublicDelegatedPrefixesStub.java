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

import static com.google.cloud.compute.v1.GlobalPublicDelegatedPrefixesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.GetGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.InsertGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.ListGlobalPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.PublicDelegatedPrefix;
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
public class HttpJsonGlobalPublicDelegatedPrefixesStub extends GlobalPublicDelegatedPrefixesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          new FieldsExtractor<
                              DeleteGlobalPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields,
                                  "publicDelegatedPrefix",
                                  request.getPublicDelegatedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteGlobalPublicDelegatedPrefixeRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteGlobalPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(
                                DeleteGlobalPublicDelegatedPrefixeRequest request) {
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
  public static final ApiMethodDescriptor<
          GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          new FieldsExtractor<
                              GetGlobalPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields,
                                  "publicDelegatedPrefix",
                                  request.getPublicDelegatedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetGlobalPublicDelegatedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetGlobalPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(GetGlobalPublicDelegatedPrefixeRequest request) {
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
  public static final ApiMethodDescriptor<InsertGlobalPublicDelegatedPrefixeRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InsertGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes",
                          new FieldsExtractor<
                              InsertGlobalPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertGlobalPublicDelegatedPrefixeRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertGlobalPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(
                                InsertGlobalPublicDelegatedPrefixeRequest request) {
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
          ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListGlobalPublicDelegatedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes",
                          new FieldsExtractor<
                              ListGlobalPublicDelegatedPrefixesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListGlobalPublicDelegatedPrefixesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalPublicDelegatedPrefixesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListGlobalPublicDelegatedPrefixesRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListGlobalPublicDelegatedPrefixesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalPublicDelegatedPrefixesRequest>
                                  serializer = ProtoRestSerializer.create();
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
                          new FieldsExtractor<ListGlobalPublicDelegatedPrefixesRequest, String>() {
                            @Override
                            public String extract(
                                ListGlobalPublicDelegatedPrefixesRequest request) {
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
  public static final ApiMethodDescriptor<PatchGlobalPublicDelegatedPrefixeRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          new FieldsExtractor<
                              PatchGlobalPublicDelegatedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields,
                                  "publicDelegatedPrefix",
                                  request.getPublicDelegatedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchGlobalPublicDelegatedPrefixeRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchGlobalPublicDelegatedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchGlobalPublicDelegatedPrefixeRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchGlobalPublicDelegatedPrefixeRequest, String>() {
                            @Override
                            public String extract(
                                PatchGlobalPublicDelegatedPrefixeRequest request) {
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

  private final UnaryCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation> deleteCallable;
  private final UnaryCallable<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getCallable;
  private final UnaryCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation> insertCallable;
  private final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable;
  private final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation> patchCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalPublicDelegatedPrefixesStub create(
      GlobalPublicDelegatedPrefixesStubSettings settings) throws IOException {
    return new HttpJsonGlobalPublicDelegatedPrefixesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalPublicDelegatedPrefixesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalPublicDelegatedPrefixesStub(
        GlobalPublicDelegatedPrefixesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalPublicDelegatedPrefixesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalPublicDelegatedPrefixesStub(
        GlobalPublicDelegatedPrefixesStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalPublicDelegatedPrefixesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalPublicDelegatedPrefixesStub(
      GlobalPublicDelegatedPrefixesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalPublicDelegatedPrefixesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalPublicDelegatedPrefixesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalPublicDelegatedPrefixesStub(
      GlobalPublicDelegatedPrefixesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertGlobalPublicDelegatedPrefixeRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchGlobalPublicDelegatedPrefixeRequest, Operation>
        patchTransportSettings =
            HttpJsonCallSettings.<PatchGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
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

  public UnaryCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation> patchCallable() {
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
