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

import static com.google.cloud.compute.v1.RegionOperationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionOperationRequest;
import com.google.cloud.compute.v1.DeleteRegionOperationResponse;
import com.google.cloud.compute.v1.GetRegionOperationRequest;
import com.google.cloud.compute.v1.ListRegionOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitRegionOperationRequest;
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
public class HttpJsonRegionOperationsStub extends RegionOperationsStub {

  @InternalApi
  public static final ApiMethodDescriptor<
          DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteRegionOperationRequest, DeleteRegionOperationResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations/{operation}",
                          new FieldsExtractor<DeleteRegionOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionOperationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionOperationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionOperationRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionOperationRequest, String>() {
                            @Override
                            public String extract(DeleteRegionOperationRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteRegionOperationResponse>newBuilder()
                      .setDefaultInstance(DeleteRegionOperationResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionOperationRequest, Operation>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations/{operation}",
                          new FieldsExtractor<GetRegionOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetRegionOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionOperationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionOperationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionOperationRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionOperationRequest, String>() {
                            @Override
                            public String extract(GetRegionOperationRequest request) {
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
  public static final ApiMethodDescriptor<ListRegionOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations",
                          new FieldsExtractor<ListRegionOperationsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionOperationsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionOperationsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionOperationsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionOperationsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionOperationsRequest> serializer =
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
                          new FieldsExtractor<ListRegionOperationsRequest, String>() {
                            @Override
                            public String extract(ListRegionOperationsRequest request) {
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
  public static final ApiMethodDescriptor<WaitRegionOperationRequest, Operation>
      waitMethodDescriptor =
          ApiMethodDescriptor.<WaitRegionOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations.Wait")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WaitRegionOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations/{operation}/wait",
                          new FieldsExtractor<WaitRegionOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(WaitRegionOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<WaitRegionOperationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              WaitRegionOperationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                WaitRegionOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<WaitRegionOperationRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<WaitRegionOperationRequest, String>() {
                            @Override
                            public String extract(WaitRegionOperationRequest request) {
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

  private final UnaryCallable<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetRegionOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListRegionOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListRegionOperationsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<WaitRegionOperationRequest, Operation> waitCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionOperationsStub create(RegionOperationsStubSettings settings)
      throws IOException {
    return new HttpJsonRegionOperationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionOperationsStub(
        RegionOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionOperationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionOperationsStub(
        RegionOperationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionOperationsStub(
      RegionOperationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionOperationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionOperationsStub(
      RegionOperationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteRegionOperationRequest, DeleteRegionOperationResponse>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetRegionOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionOperationsRequest, OperationList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionOperationsRequest, OperationList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<WaitRegionOperationRequest, Operation> waitTransportSettings =
        HttpJsonCallSettings.<WaitRegionOperationRequest, Operation>newBuilder()
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

  public UnaryCallable<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  public UnaryCallable<ListRegionOperationsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionOperationsRequest, OperationList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<WaitRegionOperationRequest, Operation> waitCallable() {
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
