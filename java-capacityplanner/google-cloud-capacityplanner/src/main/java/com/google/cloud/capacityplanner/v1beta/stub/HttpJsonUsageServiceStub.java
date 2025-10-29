/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.capacityplanner.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageResponse;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesResponse;
import com.google.cloud.capacityplanner.v1beta.OperationMetadata;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the UsageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonUsageServiceStub extends UsageServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ExportForecastsResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ExportUsageHistoriesResponse.getDescriptor())
          .add(ExportReservationsUsageResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesMethodDescriptor =
          ApiMethodDescriptor.<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/QueryUsageHistories")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryUsageHistoriesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/usageHistories:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryUsageHistoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=organizations/*/locations/*}/usageHistories:query",
                          "/v1beta/{parent=folders/*/locations/*}/usageHistories:query")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryUsageHistoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryUsageHistoriesResponse>newBuilder()
                      .setDefaultInstance(QueryUsageHistoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryForecastsRequest, QueryForecastsResponse>
      queryForecastsMethodDescriptor =
          ApiMethodDescriptor.<QueryForecastsRequest, QueryForecastsResponse>newBuilder()
              .setFullMethodName("google.cloud.capacityplanner.v1beta.UsageService/QueryForecasts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryForecastsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/forecasts:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryForecastsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=organizations/*/locations/*}/forecasts:query",
                          "/v1beta/{parent=folders/*/locations/*}/forecasts:query")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryForecastsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryForecastsResponse>newBuilder()
                      .setDefaultInstance(QueryForecastsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsMethodDescriptor =
          ApiMethodDescriptor.<QueryReservationsRequest, QueryReservationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/QueryReservations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryReservationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/reservations:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryReservationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=organizations/*/locations/*}/reservations:query",
                          "/v1beta/{parent=folders/*/locations/*}/reservations:query")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryReservationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "aggregationMethod", request.getAggregationMethodValue());
                            serializer.putQueryParam(
                                fields, "cloudResourceType", request.getCloudResourceType());
                            serializer.putQueryParam(fields, "endDate", request.getEndDate());
                            serializer.putQueryParam(fields, "gpuType", request.getGpuType());
                            serializer.putQueryParam(
                                fields,
                                "includeUnapprovedReservations",
                                request.getIncludeUnapprovedReservations());
                            serializer.putQueryParam(
                                fields, "locationLevel", request.getLocationLevelValue());
                            serializer.putQueryParam(
                                fields, "machineFamily", request.getMachineFamily());
                            serializer.putQueryParam(
                                fields, "machineShape", request.getMachineShape());
                            serializer.putQueryParam(
                                fields, "ownershipType", request.getOwnershipTypeValue());
                            serializer.putQueryParam(
                                fields,
                                "reservationDataLevel",
                                request.getReservationDataLevelValue());
                            serializer.putQueryParam(
                                fields, "reservationType", request.getReservationTypeValue());
                            serializer.putQueryParam(
                                fields, "shareType", request.getShareTypeValue());
                            serializer.putQueryParam(fields, "startDate", request.getStartDate());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryReservationsResponse>newBuilder()
                      .setDefaultInstance(QueryReservationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportUsageHistoriesRequest, Operation>
      exportUsageHistoriesMethodDescriptor =
          ApiMethodDescriptor.<ExportUsageHistoriesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/ExportUsageHistories")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportUsageHistoriesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/usageHistories:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportUsageHistoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=organizations/*/locations/*}/usageHistories:export",
                          "/v1beta/{parent=folders/*/locations/*}/usageHistories:export")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportUsageHistoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportUsageHistoriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportForecastsRequest, Operation>
      exportForecastsMethodDescriptor =
          ApiMethodDescriptor.<ExportForecastsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.capacityplanner.v1beta.UsageService/ExportForecasts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportForecastsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/forecasts:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportForecastsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=organizations/*/locations/*}/forecasts:export",
                          "/v1beta/{parent=folders/*/locations/*}/forecasts:export")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportForecastsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportForecastsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageMethodDescriptor =
          ApiMethodDescriptor.<ExportReservationsUsageRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.capacityplanner.v1beta.UsageService/ExportReservationsUsage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportReservationsUsageRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/reservationsUsage:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportReservationsUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=organizations/*/locations/*}/reservationsUsage:export",
                          "/v1beta/{parent=folders/*/locations/*}/reservationsUsage:export")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportReservationsUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportReservationsUsageRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesCallable;
  private final UnaryCallable<QueryForecastsRequest, QueryForecastsResponse> queryForecastsCallable;
  private final UnaryCallable<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsCallable;
  private final UnaryCallable<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesCallable;
  private final OperationCallable<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationCallable;
  private final UnaryCallable<ExportForecastsRequest, Operation> exportForecastsCallable;
  private final OperationCallable<
          ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationCallable;
  private final UnaryCallable<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageCallable;
  private final OperationCallable<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUsageServiceStub create(UsageServiceStubSettings settings)
      throws IOException {
    return new HttpJsonUsageServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUsageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUsageServiceStub(
        UsageServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonUsageServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUsageServiceStub(
        UsageServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUsageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUsageServiceStub(UsageServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUsageServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUsageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUsageServiceStub(
      UsageServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
        queryUsageHistoriesTransportSettings =
            HttpJsonCallSettings
                .<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>newBuilder()
                .setMethodDescriptor(queryUsageHistoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<QueryForecastsRequest, QueryForecastsResponse>
        queryForecastsTransportSettings =
            HttpJsonCallSettings.<QueryForecastsRequest, QueryForecastsResponse>newBuilder()
                .setMethodDescriptor(queryForecastsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<QueryReservationsRequest, QueryReservationsResponse>
        queryReservationsTransportSettings =
            HttpJsonCallSettings.<QueryReservationsRequest, QueryReservationsResponse>newBuilder()
                .setMethodDescriptor(queryReservationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportUsageHistoriesRequest, Operation>
        exportUsageHistoriesTransportSettings =
            HttpJsonCallSettings.<ExportUsageHistoriesRequest, Operation>newBuilder()
                .setMethodDescriptor(exportUsageHistoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportForecastsRequest, Operation> exportForecastsTransportSettings =
        HttpJsonCallSettings.<ExportForecastsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportForecastsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportReservationsUsageRequest, Operation>
        exportReservationsUsageTransportSettings =
            HttpJsonCallSettings.<ExportReservationsUsageRequest, Operation>newBuilder()
                .setMethodDescriptor(exportReservationsUsageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.queryUsageHistoriesCallable =
        callableFactory.createUnaryCallable(
            queryUsageHistoriesTransportSettings,
            settings.queryUsageHistoriesSettings(),
            clientContext);
    this.queryForecastsCallable =
        callableFactory.createUnaryCallable(
            queryForecastsTransportSettings, settings.queryForecastsSettings(), clientContext);
    this.queryReservationsCallable =
        callableFactory.createUnaryCallable(
            queryReservationsTransportSettings,
            settings.queryReservationsSettings(),
            clientContext);
    this.exportUsageHistoriesCallable =
        callableFactory.createUnaryCallable(
            exportUsageHistoriesTransportSettings,
            settings.exportUsageHistoriesSettings(),
            clientContext);
    this.exportUsageHistoriesOperationCallable =
        callableFactory.createOperationCallable(
            exportUsageHistoriesTransportSettings,
            settings.exportUsageHistoriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportForecastsCallable =
        callableFactory.createUnaryCallable(
            exportForecastsTransportSettings, settings.exportForecastsSettings(), clientContext);
    this.exportForecastsOperationCallable =
        callableFactory.createOperationCallable(
            exportForecastsTransportSettings,
            settings.exportForecastsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportReservationsUsageCallable =
        callableFactory.createUnaryCallable(
            exportReservationsUsageTransportSettings,
            settings.exportReservationsUsageSettings(),
            clientContext);
    this.exportReservationsUsageOperationCallable =
        callableFactory.createOperationCallable(
            exportReservationsUsageTransportSettings,
            settings.exportReservationsUsageOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(queryUsageHistoriesMethodDescriptor);
    methodDescriptors.add(queryForecastsMethodDescriptor);
    methodDescriptors.add(queryReservationsMethodDescriptor);
    methodDescriptors.add(exportUsageHistoriesMethodDescriptor);
    methodDescriptors.add(exportForecastsMethodDescriptor);
    methodDescriptors.add(exportReservationsUsageMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesCallable() {
    return queryUsageHistoriesCallable;
  }

  @Override
  public UnaryCallable<QueryForecastsRequest, QueryForecastsResponse> queryForecastsCallable() {
    return queryForecastsCallable;
  }

  @Override
  public UnaryCallable<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsCallable() {
    return queryReservationsCallable;
  }

  @Override
  public UnaryCallable<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesCallable() {
    return exportUsageHistoriesCallable;
  }

  @Override
  public OperationCallable<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationCallable() {
    return exportUsageHistoriesOperationCallable;
  }

  @Override
  public UnaryCallable<ExportForecastsRequest, Operation> exportForecastsCallable() {
    return exportForecastsCallable;
  }

  @Override
  public OperationCallable<ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationCallable() {
    return exportForecastsOperationCallable;
  }

  @Override
  public UnaryCallable<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageCallable() {
    return exportReservationsUsageCallable;
  }

  @Override
  public OperationCallable<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationCallable() {
    return exportReservationsUsageOperationCallable;
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
