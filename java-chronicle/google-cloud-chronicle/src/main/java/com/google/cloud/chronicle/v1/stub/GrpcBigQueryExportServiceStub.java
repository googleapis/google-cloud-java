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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.BigQueryExport;
import com.google.cloud.chronicle.v1.GetBigQueryExportRequest;
import com.google.cloud.chronicle.v1.ProvisionBigQueryExportRequest;
import com.google.cloud.chronicle.v1.UpdateBigQueryExportRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BigQueryExportService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcBigQueryExportServiceStub extends BigQueryExportServiceStub {
  private static final MethodDescriptor<GetBigQueryExportRequest, BigQueryExport>
      getBigQueryExportMethodDescriptor =
          MethodDescriptor.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.BigQueryExportService/GetBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportMethodDescriptor =
          MethodDescriptor.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.BigQueryExportService/UpdateBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ProvisionBigQueryExportRequest, BigQueryExport>
      provisionBigQueryExportMethodDescriptor =
          MethodDescriptor.<ProvisionBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.BigQueryExportService/ProvisionBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProvisionBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable;
  private final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable;
  private final UnaryCallable<ProvisionBigQueryExportRequest, BigQueryExport>
      provisionBigQueryExportCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBigQueryExportServiceStub create(
      BigQueryExportServiceStubSettings settings) throws IOException {
    return new GrpcBigQueryExportServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigQueryExportServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBigQueryExportServiceStub(
        BigQueryExportServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigQueryExportServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigQueryExportServiceStub(
        BigQueryExportServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigQueryExportServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigQueryExportServiceStub(
      BigQueryExportServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBigQueryExportServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigQueryExportServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigQueryExportServiceStub(
      BigQueryExportServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportTransportSettings =
        GrpcCallSettings.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
            .setMethodDescriptor(getBigQueryExportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportTransportSettings =
            GrpcCallSettings.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(updateBigQueryExportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "big_query_export.name",
                          String.valueOf(request.getBigQueryExport().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ProvisionBigQueryExportRequest, BigQueryExport>
        provisionBigQueryExportTransportSettings =
            GrpcCallSettings.<ProvisionBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(provisionBigQueryExportMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
