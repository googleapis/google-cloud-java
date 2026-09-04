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

package com.google.cloud.chronicle.v1.stub;

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
import com.google.cloud.chronicle.v1.BatchGetDashboardChartsRequest;
import com.google.cloud.chronicle.v1.BatchGetDashboardChartsResponse;
import com.google.cloud.chronicle.v1.DashboardChart;
import com.google.cloud.chronicle.v1.GetDashboardChartRequest;
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
 * REST stub implementation for the DashboardChartService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonDashboardChartServiceStub extends DashboardChartServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDashboardChartRequest, DashboardChart>
      getDashboardChartMethodDescriptor =
          ApiMethodDescriptor.<GetDashboardChartRequest, DashboardChart>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardChartService/GetDashboardChart")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDashboardChartRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dashboardCharts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDashboardChartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDashboardChartRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DashboardChart>newBuilder()
                      .setDefaultInstance(DashboardChart.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardChartService/BatchGetDashboardCharts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetDashboardChartsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dashboardCharts:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDashboardChartsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDashboardChartsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetDashboardChartsResponse>newBuilder()
                      .setDefaultInstance(BatchGetDashboardChartsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDashboardChartRequest, DashboardChart> getDashboardChartCallable;
  private final UnaryCallable<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDashboardChartServiceStub create(
      DashboardChartServiceStubSettings settings) throws IOException {
    return new HttpJsonDashboardChartServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDashboardChartServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDashboardChartServiceStub(
        DashboardChartServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDashboardChartServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDashboardChartServiceStub(
        DashboardChartServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDashboardChartServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDashboardChartServiceStub(
      DashboardChartServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDashboardChartServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDashboardChartServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDashboardChartServiceStub(
      DashboardChartServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDashboardChartRequest, DashboardChart>
        getDashboardChartTransportSettings =
            HttpJsonCallSettings.<GetDashboardChartRequest, DashboardChart>newBuilder()
                .setMethodDescriptor(getDashboardChartMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
        batchGetDashboardChartsTransportSettings =
            HttpJsonCallSettings
                .<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>newBuilder()
                .setMethodDescriptor(batchGetDashboardChartsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getDashboardChartCallable =
        callableFactory.createUnaryCallable(
            getDashboardChartTransportSettings,
            settings.getDashboardChartSettings(),
            clientContext);
    this.batchGetDashboardChartsCallable =
        callableFactory.createUnaryCallable(
            batchGetDashboardChartsTransportSettings,
            settings.batchGetDashboardChartsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDashboardChartMethodDescriptor);
    methodDescriptors.add(batchGetDashboardChartsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDashboardChartRequest, DashboardChart> getDashboardChartCallable() {
    return getDashboardChartCallable;
  }

  @Override
  public UnaryCallable<BatchGetDashboardChartsRequest, BatchGetDashboardChartsResponse>
      batchGetDashboardChartsCallable() {
    return batchGetDashboardChartsCallable;
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
