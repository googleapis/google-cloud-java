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

import static com.google.cloud.compute.v1.HttpsHealthChecksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteHttpsHealthCheckRequest;
import com.google.cloud.compute.v1.GetHttpsHealthCheckRequest;
import com.google.cloud.compute.v1.HttpsHealthCheck;
import com.google.cloud.compute.v1.HttpsHealthCheckList;
import com.google.cloud.compute.v1.InsertHttpsHealthCheckRequest;
import com.google.cloud.compute.v1.ListHttpsHealthChecksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHttpsHealthCheckRequest;
import com.google.cloud.compute.v1.UpdateHttpsHealthCheckRequest;
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
public class HttpJsonHttpsHealthChecksStub extends HttpsHealthChecksStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteHttpsHealthCheckRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteHttpsHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpsHealthChecks.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHttpsHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}",
                          new FieldsExtractor<
                              DeleteHttpsHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteHttpsHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpsHealthCheck", request.getHttpsHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteHttpsHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteHttpsHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteHttpsHealthCheckRequest, String>() {
                            @Override
                            public String extract(DeleteHttpsHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<GetHttpsHealthCheckRequest, HttpsHealthCheck>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetHttpsHealthCheckRequest, HttpsHealthCheck>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpsHealthChecks.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHttpsHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}",
                          new FieldsExtractor<GetHttpsHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetHttpsHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpsHealthCheck", request.getHttpsHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetHttpsHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetHttpsHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetHttpsHealthCheckRequest, String>() {
                            @Override
                            public String extract(GetHttpsHealthCheckRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpsHealthCheck>newBuilder()
                      .setDefaultInstance(HttpsHealthCheck.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertHttpsHealthCheckRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertHttpsHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpsHealthChecks.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertHttpsHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpsHealthChecks",
                          new FieldsExtractor<
                              InsertHttpsHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertHttpsHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertHttpsHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertHttpsHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertHttpsHealthCheckRequest, String>() {
                            @Override
                            public String extract(InsertHttpsHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "httpsHealthCheckResource",
                                      request.getHttpsHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListHttpsHealthChecksRequest, HttpsHealthCheckList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListHttpsHealthChecksRequest, HttpsHealthCheckList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpsHealthChecks.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHttpsHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpsHealthChecks",
                          new FieldsExtractor<ListHttpsHealthChecksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListHttpsHealthChecksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListHttpsHealthChecksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListHttpsHealthChecksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListHttpsHealthChecksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListHttpsHealthChecksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListHttpsHealthChecksRequest, String>() {
                            @Override
                            public String extract(ListHttpsHealthChecksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpsHealthCheckList>newBuilder()
                      .setDefaultInstance(HttpsHealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchHttpsHealthCheckRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchHttpsHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpsHealthChecks.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchHttpsHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}",
                          new FieldsExtractor<PatchHttpsHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchHttpsHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpsHealthCheck", request.getHttpsHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchHttpsHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchHttpsHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchHttpsHealthCheckRequest, String>() {
                            @Override
                            public String extract(PatchHttpsHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "httpsHealthCheckResource",
                                      request.getHttpsHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateHttpsHealthCheckRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateHttpsHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpsHealthChecks.Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHttpsHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}",
                          new FieldsExtractor<
                              UpdateHttpsHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateHttpsHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpsHealthCheck", request.getHttpsHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateHttpsHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateHttpsHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateHttpsHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateHttpsHealthCheckRequest, String>() {
                            @Override
                            public String extract(UpdateHttpsHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "httpsHealthCheckResource",
                                      request.getHttpsHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteHttpsHealthCheckRequest, Operation> deleteCallable;
  private final UnaryCallable<GetHttpsHealthCheckRequest, HttpsHealthCheck> getCallable;
  private final UnaryCallable<InsertHttpsHealthCheckRequest, Operation> insertCallable;
  private final UnaryCallable<ListHttpsHealthChecksRequest, HttpsHealthCheckList> listCallable;
  private final UnaryCallable<ListHttpsHealthChecksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchHttpsHealthCheckRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateHttpsHealthCheckRequest, Operation> updateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHttpsHealthChecksStub create(HttpsHealthChecksStubSettings settings)
      throws IOException {
    return new HttpJsonHttpsHealthChecksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHttpsHealthChecksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHttpsHealthChecksStub(
        HttpsHealthChecksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHttpsHealthChecksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHttpsHealthChecksStub(
        HttpsHealthChecksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHttpsHealthChecksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpsHealthChecksStub(
      HttpsHealthChecksStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHttpsHealthChecksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHttpsHealthChecksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpsHealthChecksStub(
      HttpsHealthChecksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteHttpsHealthCheckRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteHttpsHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHttpsHealthCheckRequest, HttpsHealthCheck> getTransportSettings =
        HttpJsonCallSettings.<GetHttpsHealthCheckRequest, HttpsHealthCheck>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertHttpsHealthCheckRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertHttpsHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListHttpsHealthChecksRequest, HttpsHealthCheckList> listTransportSettings =
        HttpJsonCallSettings.<ListHttpsHealthChecksRequest, HttpsHealthCheckList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchHttpsHealthCheckRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchHttpsHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateHttpsHealthCheckRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateHttpsHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
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
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteHttpsHealthCheckRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetHttpsHealthCheckRequest, HttpsHealthCheck> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertHttpsHealthCheckRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListHttpsHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListHttpsHealthChecksRequest, HttpsHealthCheckList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchHttpsHealthCheckRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateHttpsHealthCheckRequest, Operation> updateCallable() {
    return updateCallable;
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
