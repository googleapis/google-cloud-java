/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.monitoring.dashboard.v1.stub;

import static com.google.cloud.monitoring.dashboard.v1.DashboardsServiceClient.ListDashboardsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DashboardsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDashboardsServiceStub extends DashboardsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDashboardRequest, Dashboard>
      createDashboardMethodDescriptor =
          ApiMethodDescriptor.<CreateDashboardRequest, Dashboard>newBuilder()
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/CreateDashboard")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/dashboards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dashboard", request.getDashboard(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dashboard>newBuilder()
                      .setDefaultInstance(Dashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDashboardsRequest, ListDashboardsResponse>
      listDashboardsMethodDescriptor =
          ApiMethodDescriptor.<ListDashboardsRequest, ListDashboardsResponse>newBuilder()
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/ListDashboards")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDashboardsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/dashboards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDashboardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDashboardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDashboardsResponse>newBuilder()
                      .setDefaultInstance(ListDashboardsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDashboardRequest, Dashboard>
      getDashboardMethodDescriptor =
          ApiMethodDescriptor.<GetDashboardRequest, Dashboard>newBuilder()
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/GetDashboard")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/dashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dashboard>newBuilder()
                      .setDefaultInstance(Dashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDashboardRequest, Empty>
      deleteDashboardMethodDescriptor =
          ApiMethodDescriptor.<DeleteDashboardRequest, Empty>newBuilder()
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/DeleteDashboard")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/dashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDashboardRequest, Dashboard>
      updateDashboardMethodDescriptor =
          ApiMethodDescriptor.<UpdateDashboardRequest, Dashboard>newBuilder()
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/UpdateDashboard")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{dashboard.name=projects/*/dashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dashboard.name", request.getDashboard().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDashboardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dashboard", request.getDashboard(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dashboard>newBuilder()
                      .setDefaultInstance(Dashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDashboardRequest, Dashboard> createDashboardCallable;
  private final UnaryCallable<ListDashboardsRequest, ListDashboardsResponse> listDashboardsCallable;
  private final UnaryCallable<ListDashboardsRequest, ListDashboardsPagedResponse>
      listDashboardsPagedCallable;
  private final UnaryCallable<GetDashboardRequest, Dashboard> getDashboardCallable;
  private final UnaryCallable<DeleteDashboardRequest, Empty> deleteDashboardCallable;
  private final UnaryCallable<UpdateDashboardRequest, Dashboard> updateDashboardCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDashboardsServiceStub create(DashboardsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDashboardsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDashboardsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDashboardsServiceStub(
        DashboardsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDashboardsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDashboardsServiceStub(
        DashboardsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDashboardsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDashboardsServiceStub(
      DashboardsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDashboardsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDashboardsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDashboardsServiceStub(
      DashboardsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDashboardRequest, Dashboard> createDashboardTransportSettings =
        HttpJsonCallSettings.<CreateDashboardRequest, Dashboard>newBuilder()
            .setMethodDescriptor(createDashboardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDashboardsRequest, ListDashboardsResponse>
        listDashboardsTransportSettings =
            HttpJsonCallSettings.<ListDashboardsRequest, ListDashboardsResponse>newBuilder()
                .setMethodDescriptor(listDashboardsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDashboardRequest, Dashboard> getDashboardTransportSettings =
        HttpJsonCallSettings.<GetDashboardRequest, Dashboard>newBuilder()
            .setMethodDescriptor(getDashboardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDashboardRequest, Empty> deleteDashboardTransportSettings =
        HttpJsonCallSettings.<DeleteDashboardRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDashboardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDashboardRequest, Dashboard> updateDashboardTransportSettings =
        HttpJsonCallSettings.<UpdateDashboardRequest, Dashboard>newBuilder()
            .setMethodDescriptor(updateDashboardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createDashboardCallable =
        callableFactory.createUnaryCallable(
            createDashboardTransportSettings, settings.createDashboardSettings(), clientContext);
    this.listDashboardsCallable =
        callableFactory.createUnaryCallable(
            listDashboardsTransportSettings, settings.listDashboardsSettings(), clientContext);
    this.listDashboardsPagedCallable =
        callableFactory.createPagedCallable(
            listDashboardsTransportSettings, settings.listDashboardsSettings(), clientContext);
    this.getDashboardCallable =
        callableFactory.createUnaryCallable(
            getDashboardTransportSettings, settings.getDashboardSettings(), clientContext);
    this.deleteDashboardCallable =
        callableFactory.createUnaryCallable(
            deleteDashboardTransportSettings, settings.deleteDashboardSettings(), clientContext);
    this.updateDashboardCallable =
        callableFactory.createUnaryCallable(
            updateDashboardTransportSettings, settings.updateDashboardSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDashboardMethodDescriptor);
    methodDescriptors.add(listDashboardsMethodDescriptor);
    methodDescriptors.add(getDashboardMethodDescriptor);
    methodDescriptors.add(deleteDashboardMethodDescriptor);
    methodDescriptors.add(updateDashboardMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDashboardRequest, Dashboard> createDashboardCallable() {
    return createDashboardCallable;
  }

  @Override
  public UnaryCallable<ListDashboardsRequest, ListDashboardsResponse> listDashboardsCallable() {
    return listDashboardsCallable;
  }

  @Override
  public UnaryCallable<ListDashboardsRequest, ListDashboardsPagedResponse>
      listDashboardsPagedCallable() {
    return listDashboardsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDashboardRequest, Dashboard> getDashboardCallable() {
    return getDashboardCallable;
  }

  @Override
  public UnaryCallable<DeleteDashboardRequest, Empty> deleteDashboardCallable() {
    return deleteDashboardCallable;
  }

  @Override
  public UnaryCallable<UpdateDashboardRequest, Dashboard> updateDashboardCallable() {
    return updateDashboardCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
