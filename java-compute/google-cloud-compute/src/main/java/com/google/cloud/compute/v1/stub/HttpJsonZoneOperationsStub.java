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

import static com.google.cloud.compute.v1.ZoneOperationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteZoneOperationRequest;
import com.google.cloud.compute.v1.DeleteZoneOperationResponse;
import com.google.cloud.compute.v1.GetZoneOperationRequest;
import com.google.cloud.compute.v1.ListZoneOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitZoneOperationRequest;
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
public class HttpJsonZoneOperationsStub extends ZoneOperationsStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteZoneOperationRequest, DeleteZoneOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteZoneOperationRequest, DeleteZoneOperationResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneOperations.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteZoneOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/operations/{operation}",
                          new FieldsExtractor<DeleteZoneOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteZoneOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteZoneOperationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteZoneOperationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteZoneOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteZoneOperationRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteZoneOperationRequest, String>() {
                            @Override
                            public String extract(DeleteZoneOperationRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteZoneOperationResponse>newBuilder()
                      .setDefaultInstance(DeleteZoneOperationResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetZoneOperationRequest, Operation> getMethodDescriptor =
      ApiMethodDescriptor.<GetZoneOperationRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.ZoneOperations.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetZoneOperationRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/operations/{operation}",
                      new FieldsExtractor<GetZoneOperationRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetZoneOperationRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetZoneOperationRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "operation", request.getOperation());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetZoneOperationRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetZoneOperationRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetZoneOperationRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetZoneOperationRequest, String>() {
                        @Override
                        public String extract(GetZoneOperationRequest request) {
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
  public static final ApiMethodDescriptor<ListZoneOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListZoneOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneOperations.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListZoneOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/operations",
                          new FieldsExtractor<ListZoneOperationsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListZoneOperationsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListZoneOperationsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListZoneOperationsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListZoneOperationsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListZoneOperationsRequest> serializer =
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
                          new FieldsExtractor<ListZoneOperationsRequest, String>() {
                            @Override
                            public String extract(ListZoneOperationsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OperationList>newBuilder()
                      .setDefaultInstance(OperationList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<WaitZoneOperationRequest, Operation>
      waitMethodDescriptor =
          ApiMethodDescriptor.<WaitZoneOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneOperations.Wait")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WaitZoneOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/operations/{operation}/wait",
                          new FieldsExtractor<WaitZoneOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(WaitZoneOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<WaitZoneOperationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              WaitZoneOperationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                WaitZoneOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<WaitZoneOperationRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<WaitZoneOperationRequest, String>() {
                            @Override
                            public String extract(WaitZoneOperationRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteZoneOperationRequest, DeleteZoneOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetZoneOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListZoneOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListZoneOperationsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<WaitZoneOperationRequest, Operation> waitCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonZoneOperationsStub create(ZoneOperationsStubSettings settings)
      throws IOException {
    return new HttpJsonZoneOperationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonZoneOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonZoneOperationsStub(
        ZoneOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonZoneOperationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonZoneOperationsStub(
        ZoneOperationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonZoneOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonZoneOperationsStub(
      ZoneOperationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonZoneOperationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonZoneOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonZoneOperationsStub(
      ZoneOperationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteZoneOperationRequest, DeleteZoneOperationResponse>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteZoneOperationRequest, DeleteZoneOperationResponse>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetZoneOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetZoneOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListZoneOperationsRequest, OperationList> listTransportSettings =
        HttpJsonCallSettings.<ListZoneOperationsRequest, OperationList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<WaitZoneOperationRequest, Operation> waitTransportSettings =
        HttpJsonCallSettings.<WaitZoneOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(waitMethodDescriptor)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.waitCallable =
        callableFactory.createUnaryCallable(
            waitTransportSettings, settings.waitSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteZoneOperationRequest, DeleteZoneOperationResponse> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetZoneOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  public UnaryCallable<ListZoneOperationsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListZoneOperationsRequest, OperationList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<WaitZoneOperationRequest, Operation> waitCallable() {
    return waitCallable;
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
