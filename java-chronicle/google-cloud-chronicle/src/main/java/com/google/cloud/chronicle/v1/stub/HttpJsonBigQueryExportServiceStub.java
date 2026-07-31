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
import com.google.cloud.chronicle.v1.BigQueryExport;
import com.google.cloud.chronicle.v1.GetBigQueryExportRequest;
import com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest;
import com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest;
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
 * REST stub implementation for the BigQueryExportService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonBigQueryExportServiceStub extends BigQueryExportServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBigQueryExportRequest, BigQueryExport>
      getBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.BigQueryExportService/GetBigQueryExport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/bigQueryExport}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryExport>newBuilder()
                      .setDefaultInstance(BigQueryExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.BigQueryExportService/UpdateBigQueryExport")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v1/{bigQueryExport.name=projects/*/locations/*/instances/*/bigQueryExport}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "bigQueryExport.name",
                                request.getBigQueryExport().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bigQueryExport", request.getBigQueryExport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryExport>newBuilder()
                      .setDefaultInstance(BigQueryExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ProvisionBigQueryExportRequest, BigQueryExport>
      provisionBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<ProvisionBigQueryExportRequest, BigQueryExport>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.BigQueryExportService/ProvisionBigQueryExport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProvisionBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/bigQueryExport:provision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionBigQueryExportRequest> serializer =
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
                  ProtoMessageResponseParser.<BigQueryExport>newBuilder()
                      .setDefaultInstance(BigQueryExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable;
  private final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable;
  private final UnaryCallable<ProvisionBigQueryExportRequest, BigQueryExport>
      provisionBigQueryExportCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBigQueryExportServiceStub create(
      BigQueryExportServiceStubSettings settings) throws IOException {
    return new HttpJsonBigQueryExportServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBigQueryExportServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBigQueryExportServiceStub(
        BigQueryExportServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBigQueryExportServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBigQueryExportServiceStub(
        BigQueryExportServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBigQueryExportServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBigQueryExportServiceStub(
      BigQueryExportServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBigQueryExportServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBigQueryExportServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBigQueryExportServiceStub(
      BigQueryExportServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBigQueryExportRequest, BigQueryExport>
        getBigQueryExportTransportSettings =
            HttpJsonCallSettings.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(getBigQueryExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportTransportSettings =
            HttpJsonCallSettings.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(updateBigQueryExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "big_query_export.name",
                          String.valueOf(request.getBigQueryExport().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ProvisionBigQueryExportRequest, BigQueryExport>
        provisionBigQueryExportTransportSettings =
            HttpJsonCallSettings.<ProvisionBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(provisionBigQueryExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            getBigQueryExportTransportSettings,
            settings.getBigQueryExportSettings(),
            clientContext);
    this.updateBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            updateBigQueryExportTransportSettings,
            settings.updateBigQueryExportSettings(),
            clientContext);
    this.provisionBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            provisionBigQueryExportTransportSettings,
            settings.provisionBigQueryExportSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBigQueryExportMethodDescriptor);
    methodDescriptors.add(updateBigQueryExportMethodDescriptor);
    methodDescriptors.add(provisionBigQueryExportMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    return getBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport> updateBigQueryExportCallable() {
    return updateBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<ProvisionBigQueryExportRequest, BigQueryExport>
      provisionBigQueryExportCallable() {
    return provisionBigQueryExportCallable;
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
