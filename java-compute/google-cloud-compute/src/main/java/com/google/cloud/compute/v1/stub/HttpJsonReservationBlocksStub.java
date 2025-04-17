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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ReservationBlocksClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetReservationBlockRequest;
import com.google.cloud.compute.v1.ListReservationBlocksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PerformMaintenanceReservationBlockRequest;
import com.google.cloud.compute.v1.ReservationBlocksGetResponse;
import com.google.cloud.compute.v1.ReservationBlocksListResponse;
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
 * REST stub implementation for the ReservationBlocks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonReservationBlocksStub extends ReservationBlocksStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<GetReservationBlockRequest, ReservationBlocksGetResponse>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetReservationBlockRequest, ReservationBlocksGetResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ReservationBlocks/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReservationBlockRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{reservation}/reservationBlocks/{reservationBlock}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationBlockRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "reservation", request.getReservation());
                            serializer.putPathParam(
                                fields, "reservationBlock", request.getReservationBlock());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReservationBlockRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationBlocksGetResponse>newBuilder()
                      .setDefaultInstance(ReservationBlocksGetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListReservationBlocksRequest, ReservationBlocksListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListReservationBlocksRequest, ReservationBlocksListResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ReservationBlocks/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReservationBlocksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{reservation}/reservationBlocks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationBlocksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "reservation", request.getReservation());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReservationBlocksRequest> serializer =
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationBlocksListResponse>newBuilder()
                      .setDefaultInstance(ReservationBlocksListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PerformMaintenanceReservationBlockRequest, Operation>
      performMaintenanceMethodDescriptor =
          ApiMethodDescriptor.<PerformMaintenanceReservationBlockRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ReservationBlocks/PerformMaintenance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PerformMaintenanceReservationBlockRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{reservation}/reservationBlocks/{reservationBlock}/performMaintenance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PerformMaintenanceReservationBlockRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "reservation", request.getReservation());
                            serializer.putPathParam(
                                fields, "reservationBlock", request.getReservationBlock());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PerformMaintenanceReservationBlockRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "reservationsBlocksPerformMaintenanceRequestResource",
                                      request
                                          .getReservationsBlocksPerformMaintenanceRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PerformMaintenanceReservationBlockRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<GetReservationBlockRequest, ReservationBlocksGetResponse> getCallable;
  private final UnaryCallable<ListReservationBlocksRequest, ReservationBlocksListResponse>
      listCallable;
  private final UnaryCallable<ListReservationBlocksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PerformMaintenanceReservationBlockRequest, Operation>
      performMaintenanceCallable;
  private final OperationCallable<PerformMaintenanceReservationBlockRequest, Operation, Operation>
      performMaintenanceOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReservationBlocksStub create(ReservationBlocksStubSettings settings)
      throws IOException {
    return new HttpJsonReservationBlocksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReservationBlocksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReservationBlocksStub(
        ReservationBlocksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonReservationBlocksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReservationBlocksStub(
        ReservationBlocksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReservationBlocksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReservationBlocksStub(
      ReservationBlocksStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReservationBlocksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReservationBlocksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReservationBlocksStub(
      ReservationBlocksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<GetReservationBlockRequest, ReservationBlocksGetResponse>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetReservationBlockRequest, ReservationBlocksGetResponse>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("reservation", String.valueOf(request.getReservation()));
                      builder.add(
                          "reservation_block", String.valueOf(request.getReservationBlock()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListReservationBlocksRequest, ReservationBlocksListResponse>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListReservationBlocksRequest, ReservationBlocksListResponse>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("reservation", String.valueOf(request.getReservation()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PerformMaintenanceReservationBlockRequest, Operation>
        performMaintenanceTransportSettings =
            HttpJsonCallSettings.<PerformMaintenanceReservationBlockRequest, Operation>newBuilder()
                .setMethodDescriptor(performMaintenanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("reservation", String.valueOf(request.getReservation()));
                      builder.add(
                          "reservation_block", String.valueOf(request.getReservationBlock()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.performMaintenanceCallable =
        callableFactory.createUnaryCallable(
            performMaintenanceTransportSettings,
            settings.performMaintenanceSettings(),
            clientContext);
    this.performMaintenanceOperationCallable =
        callableFactory.createOperationCallable(
            performMaintenanceTransportSettings,
            settings.performMaintenanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(performMaintenanceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetReservationBlockRequest, ReservationBlocksGetResponse> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListReservationBlocksRequest, ReservationBlocksListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListReservationBlocksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PerformMaintenanceReservationBlockRequest, Operation>
      performMaintenanceCallable() {
    return performMaintenanceCallable;
  }

  @Override
  public OperationCallable<PerformMaintenanceReservationBlockRequest, Operation, Operation>
      performMaintenanceOperationCallable() {
    return performMaintenanceOperationCallable;
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
