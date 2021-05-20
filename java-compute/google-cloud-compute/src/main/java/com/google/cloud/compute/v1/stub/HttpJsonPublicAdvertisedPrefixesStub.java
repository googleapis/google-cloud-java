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

import static com.google.cloud.compute.v1.PublicAdvertisedPrefixesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeletePublicAdvertisedPrefixeRequest;
import com.google.cloud.compute.v1.GetPublicAdvertisedPrefixeRequest;
import com.google.cloud.compute.v1.InsertPublicAdvertisedPrefixeRequest;
import com.google.cloud.compute.v1.ListPublicAdvertisedPrefixesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchPublicAdvertisedPrefixeRequest;
import com.google.cloud.compute.v1.PublicAdvertisedPrefix;
import com.google.cloud.compute.v1.PublicAdvertisedPrefixList;
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
public class HttpJsonPublicAdvertisedPrefixesStub extends PublicAdvertisedPrefixesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeletePublicAdvertisedPrefixeRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeletePublicAdvertisedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicAdvertisedPrefixes.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePublicAdvertisedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}",
                          new FieldsExtractor<
                              DeletePublicAdvertisedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeletePublicAdvertisedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeletePublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields,
                                  "publicAdvertisedPrefix",
                                  request.getPublicAdvertisedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeletePublicAdvertisedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeletePublicAdvertisedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeletePublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeletePublicAdvertisedPrefixeRequest, String>() {
                            @Override
                            public String extract(DeletePublicAdvertisedPrefixeRequest request) {
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
  public static final ApiMethodDescriptor<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicAdvertisedPrefixes.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPublicAdvertisedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}",
                          new FieldsExtractor<
                              GetPublicAdvertisedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetPublicAdvertisedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetPublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields,
                                  "publicAdvertisedPrefix",
                                  request.getPublicAdvertisedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetPublicAdvertisedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetPublicAdvertisedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetPublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetPublicAdvertisedPrefixeRequest, String>() {
                            @Override
                            public String extract(GetPublicAdvertisedPrefixeRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicAdvertisedPrefix>newBuilder()
                      .setDefaultInstance(PublicAdvertisedPrefix.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertPublicAdvertisedPrefixeRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertPublicAdvertisedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicAdvertisedPrefixes.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertPublicAdvertisedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicAdvertisedPrefixes",
                          new FieldsExtractor<
                              InsertPublicAdvertisedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertPublicAdvertisedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertPublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertPublicAdvertisedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertPublicAdvertisedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertPublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertPublicAdvertisedPrefixeRequest, String>() {
                            @Override
                            public String extract(InsertPublicAdvertisedPrefixeRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "publicAdvertisedPrefixResource",
                                      request.getPublicAdvertisedPrefixResource());
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
          ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicAdvertisedPrefixes.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPublicAdvertisedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicAdvertisedPrefixes",
                          new FieldsExtractor<
                              ListPublicAdvertisedPrefixesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListPublicAdvertisedPrefixesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListPublicAdvertisedPrefixesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListPublicAdvertisedPrefixesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListPublicAdvertisedPrefixesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListPublicAdvertisedPrefixesRequest> serializer =
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
                          new FieldsExtractor<ListPublicAdvertisedPrefixesRequest, String>() {
                            @Override
                            public String extract(ListPublicAdvertisedPrefixesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicAdvertisedPrefixList>newBuilder()
                      .setDefaultInstance(PublicAdvertisedPrefixList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchPublicAdvertisedPrefixeRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchPublicAdvertisedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicAdvertisedPrefixes.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchPublicAdvertisedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}",
                          new FieldsExtractor<
                              PatchPublicAdvertisedPrefixeRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchPublicAdvertisedPrefixeRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchPublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields,
                                  "publicAdvertisedPrefix",
                                  request.getPublicAdvertisedPrefix());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchPublicAdvertisedPrefixeRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchPublicAdvertisedPrefixeRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchPublicAdvertisedPrefixeRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchPublicAdvertisedPrefixeRequest, String>() {
                            @Override
                            public String extract(PatchPublicAdvertisedPrefixeRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "publicAdvertisedPrefixResource",
                                      request.getPublicAdvertisedPrefixResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeletePublicAdvertisedPrefixeRequest, Operation> deleteCallable;
  private final UnaryCallable<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix>
      getCallable;
  private final UnaryCallable<InsertPublicAdvertisedPrefixeRequest, Operation> insertCallable;
  private final UnaryCallable<ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>
      listCallable;
  private final UnaryCallable<ListPublicAdvertisedPrefixesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchPublicAdvertisedPrefixeRequest, Operation> patchCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPublicAdvertisedPrefixesStub create(
      PublicAdvertisedPrefixesStubSettings settings) throws IOException {
    return new HttpJsonPublicAdvertisedPrefixesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPublicAdvertisedPrefixesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPublicAdvertisedPrefixesStub(
        PublicAdvertisedPrefixesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPublicAdvertisedPrefixesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPublicAdvertisedPrefixesStub(
        PublicAdvertisedPrefixesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPublicAdvertisedPrefixesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPublicAdvertisedPrefixesStub(
      PublicAdvertisedPrefixesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPublicAdvertisedPrefixesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPublicAdvertisedPrefixesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPublicAdvertisedPrefixesStub(
      PublicAdvertisedPrefixesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeletePublicAdvertisedPrefixeRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeletePublicAdvertisedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertPublicAdvertisedPrefixeRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertPublicAdvertisedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchPublicAdvertisedPrefixeRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchPublicAdvertisedPrefixeRequest, Operation>newBuilder()
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

  public UnaryCallable<DeletePublicAdvertisedPrefixeRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertPublicAdvertisedPrefixeRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListPublicAdvertisedPrefixesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>
      listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchPublicAdvertisedPrefixeRequest, Operation> patchCallable() {
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
