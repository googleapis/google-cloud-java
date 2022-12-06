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

package com.google.cloud.storageinsights.v1.stub;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.CreateReportConfigRequest;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportDetailRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportDetailsRequest;
import com.google.cloud.storageinsights.v1.ListReportDetailsResponse;
import com.google.cloud.storageinsights.v1.ReportConfig;
import com.google.cloud.storageinsights.v1.ReportDetail;
import com.google.cloud.storageinsights.v1.UpdateReportConfigRequest;
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
 * REST stub implementation for the StorageInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonStorageInsightsStub extends StorageInsightsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListReportConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reportConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReportConfigsResponse>newBuilder()
                      .setDefaultInstance(ListReportConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReportConfigRequest, ReportConfig>
      getReportConfigMethodDescriptor =
          ApiMethodDescriptor.<GetReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetReportConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReportConfigRequest, ReportConfig>
      createReportConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/CreateReportConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reportConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reportConfig", request.getReportConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReportConfigRequest, ReportConfig>
      updateReportConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/UpdateReportConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{reportConfig.name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "reportConfig.name", request.getReportConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reportConfig", request.getReportConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReportConfigRequest, Empty>
      deleteReportConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteReportConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/DeleteReportConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsMethodDescriptor =
          ApiMethodDescriptor.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListReportDetails")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportDetailsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/reportConfigs/*}/reportDetails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReportDetailsResponse>newBuilder()
                      .setDefaultInstance(ListReportDetailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReportDetailRequest, ReportDetail>
      getReportDetailMethodDescriptor =
          ApiMethodDescriptor.<GetReportDetailRequest, ReportDetail>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetReportDetail")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReportDetailRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*/reportDetails/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportDetailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportDetailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportDetail>newBuilder()
                      .setDefaultInstance(ReportDetail.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable;
  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable;
  private final UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable;
  private final UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable;
  private final UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable;
  private final UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable;
  private final UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable;
  private final UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable;
  private final UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonStorageInsightsStub create(StorageInsightsStubSettings settings)
      throws IOException {
    return new HttpJsonStorageInsightsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStorageInsightsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStorageInsightsStub(
        StorageInsightsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStorageInsightsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStorageInsightsStub(
        StorageInsightsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStorageInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageInsightsStub(
      StorageInsightsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStorageInsightsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStorageInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageInsightsStub(
      StorageInsightsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListReportConfigsRequest, ListReportConfigsResponse>
        listReportConfigsTransportSettings =
            HttpJsonCallSettings.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
                .setMethodDescriptor(listReportConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigTransportSettings =
        HttpJsonCallSettings.<GetReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(getReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateReportConfigRequest, ReportConfig>
        createReportConfigTransportSettings =
            HttpJsonCallSettings.<CreateReportConfigRequest, ReportConfig>newBuilder()
                .setMethodDescriptor(createReportConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateReportConfigRequest, ReportConfig>
        updateReportConfigTransportSettings =
            HttpJsonCallSettings.<UpdateReportConfigRequest, ReportConfig>newBuilder()
                .setMethodDescriptor(updateReportConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigTransportSettings =
        HttpJsonCallSettings.<DeleteReportConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListReportDetailsRequest, ListReportDetailsResponse>
        listReportDetailsTransportSettings =
            HttpJsonCallSettings.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
                .setMethodDescriptor(listReportDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailTransportSettings =
        HttpJsonCallSettings.<GetReportDetailRequest, ReportDetail>newBuilder()
            .setMethodDescriptor(getReportDetailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listReportConfigsCallable =
        callableFactory.createUnaryCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.listReportConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.getReportConfigCallable =
        callableFactory.createUnaryCallable(
            getReportConfigTransportSettings, settings.getReportConfigSettings(), clientContext);
    this.createReportConfigCallable =
        callableFactory.createUnaryCallable(
            createReportConfigTransportSettings,
            settings.createReportConfigSettings(),
            clientContext);
    this.updateReportConfigCallable =
        callableFactory.createUnaryCallable(
            updateReportConfigTransportSettings,
            settings.updateReportConfigSettings(),
            clientContext);
    this.deleteReportConfigCallable =
        callableFactory.createUnaryCallable(
            deleteReportConfigTransportSettings,
            settings.deleteReportConfigSettings(),
            clientContext);
    this.listReportDetailsCallable =
        callableFactory.createUnaryCallable(
            listReportDetailsTransportSettings,
            settings.listReportDetailsSettings(),
            clientContext);
    this.listReportDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listReportDetailsTransportSettings,
            settings.listReportDetailsSettings(),
            clientContext);
    this.getReportDetailCallable =
        callableFactory.createUnaryCallable(
            getReportDetailTransportSettings, settings.getReportDetailSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listReportConfigsMethodDescriptor);
    methodDescriptors.add(getReportConfigMethodDescriptor);
    methodDescriptors.add(createReportConfigMethodDescriptor);
    methodDescriptors.add(updateReportConfigMethodDescriptor);
    methodDescriptors.add(deleteReportConfigMethodDescriptor);
    methodDescriptors.add(listReportDetailsMethodDescriptor);
    methodDescriptors.add(getReportDetailMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    return listReportConfigsCallable;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    return listReportConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    return getReportConfigCallable;
  }

  @Override
  public UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable() {
    return createReportConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable() {
    return updateReportConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable() {
    return deleteReportConfigCallable;
  }

  @Override
  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable() {
    return listReportDetailsCallable;
  }

  @Override
  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable() {
    return listReportDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable() {
    return getReportDetailCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
