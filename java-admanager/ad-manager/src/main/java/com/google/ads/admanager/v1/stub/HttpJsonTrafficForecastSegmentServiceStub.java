/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.TrafficForecastSegmentServiceClient.ListTrafficForecastSegmentsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.BatchCreateTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.BatchUpdateTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.BatchUpdateTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.CreateTrafficForecastSegmentRequest;
import com.google.ads.admanager.v1.GetTrafficForecastSegmentRequest;
import com.google.ads.admanager.v1.ListTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.ListTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.TrafficForecastSegment;
import com.google.ads.admanager.v1.UpdateTrafficForecastSegmentRequest;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TrafficForecastSegmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonTrafficForecastSegmentServiceStub extends TrafficForecastSegmentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentMethodDescriptor =
          ApiMethodDescriptor.<GetTrafficForecastSegmentRequest, TrafficForecastSegment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TrafficForecastSegmentService/GetTrafficForecastSegment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTrafficForecastSegmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/trafficForecastSegments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTrafficForecastSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTrafficForecastSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TrafficForecastSegment>newBuilder()
                      .setDefaultInstance(TrafficForecastSegment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
      listTrafficForecastSegmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TrafficForecastSegmentService/ListTrafficForecastSegments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTrafficForecastSegmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/trafficForecastSegments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTrafficForecastSegmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTrafficForecastSegmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTrafficForecastSegmentsResponse>newBuilder()
                      .setDefaultInstance(ListTrafficForecastSegmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentMethodDescriptor =
          ApiMethodDescriptor
              .<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TrafficForecastSegmentService/CreateTrafficForecastSegment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTrafficForecastSegmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/trafficForecastSegments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTrafficForecastSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTrafficForecastSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "trafficForecastSegment",
                                      request.getTrafficForecastSegment(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TrafficForecastSegment>newBuilder()
                      .setDefaultInstance(TrafficForecastSegment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateTrafficForecastSegmentsRequest,
                  BatchCreateTrafficForecastSegmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TrafficForecastSegmentService/BatchCreateTrafficForecastSegments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchCreateTrafficForecastSegmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/trafficForecastSegments:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTrafficForecastSegmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTrafficForecastSegmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchCreateTrafficForecastSegmentsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateTrafficForecastSegmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TrafficForecastSegmentService/UpdateTrafficForecastSegment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTrafficForecastSegmentRequest>newBuilder()
                      .setPath(
                          "/v1/{trafficForecastSegment.name=networks/*/trafficForecastSegments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTrafficForecastSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "trafficForecastSegment.name",
                                request.getTrafficForecastSegment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTrafficForecastSegmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "trafficForecastSegment",
                                      request.getTrafficForecastSegment(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TrafficForecastSegment>newBuilder()
                      .setDefaultInstance(TrafficForecastSegment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateTrafficForecastSegmentsRequest,
                  BatchUpdateTrafficForecastSegmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.TrafficForecastSegmentService/BatchUpdateTrafficForecastSegments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchUpdateTrafficForecastSegmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/trafficForecastSegments:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateTrafficForecastSegmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateTrafficForecastSegmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchUpdateTrafficForecastSegmentsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateTrafficForecastSegmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentCallable;
  private final UnaryCallable<
          ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
      listTrafficForecastSegmentsCallable;
  private final UnaryCallable<
          ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsPagedCallable;
  private final UnaryCallable<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentCallable;
  private final UnaryCallable<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsCallable;
  private final UnaryCallable<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentCallable;
  private final UnaryCallable<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTrafficForecastSegmentServiceStub create(
      TrafficForecastSegmentServiceStubSettings settings) throws IOException {
    return new HttpJsonTrafficForecastSegmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTrafficForecastSegmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTrafficForecastSegmentServiceStub(
        TrafficForecastSegmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTrafficForecastSegmentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTrafficForecastSegmentServiceStub(
        TrafficForecastSegmentServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTrafficForecastSegmentServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonTrafficForecastSegmentServiceStub(
      TrafficForecastSegmentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTrafficForecastSegmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTrafficForecastSegmentServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonTrafficForecastSegmentServiceStub(
      TrafficForecastSegmentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
        getTrafficForecastSegmentTransportSettings =
            HttpJsonCallSettings
                .<GetTrafficForecastSegmentRequest, TrafficForecastSegment>newBuilder()
                .setMethodDescriptor(getTrafficForecastSegmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
        listTrafficForecastSegmentsTransportSettings =
            HttpJsonCallSettings
                .<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
                    newBuilder()
                .setMethodDescriptor(listTrafficForecastSegmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
        createTrafficForecastSegmentTransportSettings =
            HttpJsonCallSettings
                .<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>newBuilder()
                .setMethodDescriptor(createTrafficForecastSegmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
        batchCreateTrafficForecastSegmentsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateTrafficForecastSegmentsRequest,
                    BatchCreateTrafficForecastSegmentsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateTrafficForecastSegmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
        updateTrafficForecastSegmentTransportSettings =
            HttpJsonCallSettings
                .<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>newBuilder()
                .setMethodDescriptor(updateTrafficForecastSegmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "traffic_forecast_segment.name",
                          String.valueOf(request.getTrafficForecastSegment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
        batchUpdateTrafficForecastSegmentsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateTrafficForecastSegmentsRequest,
                    BatchUpdateTrafficForecastSegmentsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateTrafficForecastSegmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getTrafficForecastSegmentCallable =
        callableFactory.createUnaryCallable(
            getTrafficForecastSegmentTransportSettings,
            settings.getTrafficForecastSegmentSettings(),
            clientContext);
    this.listTrafficForecastSegmentsCallable =
        callableFactory.createUnaryCallable(
            listTrafficForecastSegmentsTransportSettings,
            settings.listTrafficForecastSegmentsSettings(),
            clientContext);
    this.listTrafficForecastSegmentsPagedCallable =
        callableFactory.createPagedCallable(
            listTrafficForecastSegmentsTransportSettings,
            settings.listTrafficForecastSegmentsSettings(),
            clientContext);
    this.createTrafficForecastSegmentCallable =
        callableFactory.createUnaryCallable(
            createTrafficForecastSegmentTransportSettings,
            settings.createTrafficForecastSegmentSettings(),
            clientContext);
    this.batchCreateTrafficForecastSegmentsCallable =
        callableFactory.createUnaryCallable(
            batchCreateTrafficForecastSegmentsTransportSettings,
            settings.batchCreateTrafficForecastSegmentsSettings(),
            clientContext);
    this.updateTrafficForecastSegmentCallable =
        callableFactory.createUnaryCallable(
            updateTrafficForecastSegmentTransportSettings,
            settings.updateTrafficForecastSegmentSettings(),
            clientContext);
    this.batchUpdateTrafficForecastSegmentsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateTrafficForecastSegmentsTransportSettings,
            settings.batchUpdateTrafficForecastSegmentsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTrafficForecastSegmentMethodDescriptor);
    methodDescriptors.add(listTrafficForecastSegmentsMethodDescriptor);
    methodDescriptors.add(createTrafficForecastSegmentMethodDescriptor);
    methodDescriptors.add(batchCreateTrafficForecastSegmentsMethodDescriptor);
    methodDescriptors.add(updateTrafficForecastSegmentMethodDescriptor);
    methodDescriptors.add(batchUpdateTrafficForecastSegmentsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentCallable() {
    return getTrafficForecastSegmentCallable;
  }

  @Override
  public UnaryCallable<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
      listTrafficForecastSegmentsCallable() {
    return listTrafficForecastSegmentsCallable;
  }

  @Override
  public UnaryCallable<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsPagedCallable() {
    return listTrafficForecastSegmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentCallable() {
    return createTrafficForecastSegmentCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsCallable() {
    return batchCreateTrafficForecastSegmentsCallable;
  }

  @Override
  public UnaryCallable<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentCallable() {
    return updateTrafficForecastSegmentCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsCallable() {
    return batchUpdateTrafficForecastSegmentsCallable;
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
