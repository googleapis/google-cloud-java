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

import static com.google.cloud.compute.v1.HttpHealthChecksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteHttpHealthCheckRequest;
import com.google.cloud.compute.v1.GetHttpHealthCheckRequest;
import com.google.cloud.compute.v1.HttpHealthCheck;
import com.google.cloud.compute.v1.HttpHealthCheckList;
import com.google.cloud.compute.v1.InsertHttpHealthCheckRequest;
import com.google.cloud.compute.v1.ListHttpHealthChecksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHttpHealthCheckRequest;
import com.google.cloud.compute.v1.UpdateHttpHealthCheckRequest;
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
public class HttpJsonHttpHealthChecksStub extends HttpHealthChecksStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteHttpHealthCheckRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteHttpHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpHealthChecks.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHttpHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpHealthChecks/{httpHealthCheck}",
                          new FieldsExtractor<DeleteHttpHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteHttpHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpHealthCheck", request.getHttpHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteHttpHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteHttpHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteHttpHealthCheckRequest, String>() {
                            @Override
                            public String extract(DeleteHttpHealthCheckRequest request) {
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
  public static final ApiMethodDescriptor<GetHttpHealthCheckRequest, HttpHealthCheck>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetHttpHealthCheckRequest, HttpHealthCheck>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpHealthChecks.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHttpHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpHealthChecks/{httpHealthCheck}",
                          new FieldsExtractor<GetHttpHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetHttpHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpHealthCheck", request.getHttpHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetHttpHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetHttpHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetHttpHealthCheckRequest, String>() {
                            @Override
                            public String extract(GetHttpHealthCheckRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpHealthCheck>newBuilder()
                      .setDefaultInstance(HttpHealthCheck.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertHttpHealthCheckRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertHttpHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpHealthChecks.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertHttpHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpHealthChecks",
                          new FieldsExtractor<InsertHttpHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertHttpHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertHttpHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertHttpHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertHttpHealthCheckRequest, String>() {
                            @Override
                            public String extract(InsertHttpHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "httpHealthCheckResource",
                                      request.getHttpHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListHttpHealthChecksRequest, HttpHealthCheckList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListHttpHealthChecksRequest, HttpHealthCheckList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpHealthChecks.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHttpHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpHealthChecks",
                          new FieldsExtractor<ListHttpHealthChecksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListHttpHealthChecksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListHttpHealthChecksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListHttpHealthChecksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListHttpHealthChecksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListHttpHealthChecksRequest> serializer =
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
                          new FieldsExtractor<ListHttpHealthChecksRequest, String>() {
                            @Override
                            public String extract(ListHttpHealthChecksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpHealthCheckList>newBuilder()
                      .setDefaultInstance(HttpHealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchHttpHealthCheckRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchHttpHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpHealthChecks.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchHttpHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpHealthChecks/{httpHealthCheck}",
                          new FieldsExtractor<PatchHttpHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchHttpHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpHealthCheck", request.getHttpHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchHttpHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchHttpHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchHttpHealthCheckRequest, String>() {
                            @Override
                            public String extract(PatchHttpHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "httpHealthCheckResource",
                                      request.getHttpHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateHttpHealthCheckRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateHttpHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HttpHealthChecks.Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHttpHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/httpHealthChecks/{httpHealthCheck}",
                          new FieldsExtractor<UpdateHttpHealthCheckRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateHttpHealthCheckRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "httpHealthCheck", request.getHttpHealthCheck());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateHttpHealthCheckRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateHttpHealthCheckRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateHttpHealthCheckRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateHttpHealthCheckRequest, String>() {
                            @Override
                            public String extract(UpdateHttpHealthCheckRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "httpHealthCheckResource",
                                      request.getHttpHealthCheckResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteHttpHealthCheckRequest, Operation> deleteCallable;
  private final UnaryCallable<GetHttpHealthCheckRequest, HttpHealthCheck> getCallable;
  private final UnaryCallable<InsertHttpHealthCheckRequest, Operation> insertCallable;
  private final UnaryCallable<ListHttpHealthChecksRequest, HttpHealthCheckList> listCallable;
  private final UnaryCallable<ListHttpHealthChecksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchHttpHealthCheckRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateHttpHealthCheckRequest, Operation> updateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHttpHealthChecksStub create(HttpHealthChecksStubSettings settings)
      throws IOException {
    return new HttpJsonHttpHealthChecksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHttpHealthChecksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHttpHealthChecksStub(
        HttpHealthChecksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHttpHealthChecksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHttpHealthChecksStub(
        HttpHealthChecksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHttpHealthChecksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpHealthChecksStub(
      HttpHealthChecksStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHttpHealthChecksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHttpHealthChecksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpHealthChecksStub(
      HttpHealthChecksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteHttpHealthCheckRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteHttpHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHttpHealthCheckRequest, HttpHealthCheck> getTransportSettings =
        HttpJsonCallSettings.<GetHttpHealthCheckRequest, HttpHealthCheck>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertHttpHealthCheckRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertHttpHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListHttpHealthChecksRequest, HttpHealthCheckList> listTransportSettings =
        HttpJsonCallSettings.<ListHttpHealthChecksRequest, HttpHealthCheckList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchHttpHealthCheckRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchHttpHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateHttpHealthCheckRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateHttpHealthCheckRequest, Operation>newBuilder()
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

  public UnaryCallable<DeleteHttpHealthCheckRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetHttpHealthCheckRequest, HttpHealthCheck> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertHttpHealthCheckRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListHttpHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListHttpHealthChecksRequest, HttpHealthCheckList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchHttpHealthCheckRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<UpdateHttpHealthCheckRequest, Operation> updateCallable() {
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
