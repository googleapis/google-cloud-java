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

package com.google.cloud.datacatalog.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest;
import com.google.cloud.datacatalog.v1.Taxonomy;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PolicyTagManagerSerialization service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPolicyTagManagerSerializationStub extends PolicyTagManagerSerializationStub {
  private static final MethodDescriptor<ReplaceTaxonomyRequest, Taxonomy>
      replaceTaxonomyMethodDescriptor =
          MethodDescriptor.<ReplaceTaxonomyRequest, Taxonomy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.PolicyTagManagerSerialization/ReplaceTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReplaceTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Taxonomy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
      importTaxonomiesMethodDescriptor =
          MethodDescriptor.<ImportTaxonomiesRequest, ImportTaxonomiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.PolicyTagManagerSerialization/ImportTaxonomies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ImportTaxonomiesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
      exportTaxonomiesMethodDescriptor =
          MethodDescriptor.<ExportTaxonomiesRequest, ExportTaxonomiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.PolicyTagManagerSerialization/ExportTaxonomies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExportTaxonomiesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ReplaceTaxonomyRequest, Taxonomy> replaceTaxonomyCallable;
  private final UnaryCallable<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
      importTaxonomiesCallable;
  private final UnaryCallable<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
      exportTaxonomiesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPolicyTagManagerSerializationStub create(
      PolicyTagManagerSerializationStubSettings settings) throws IOException {
    return new GrpcPolicyTagManagerSerializationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPolicyTagManagerSerializationStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPolicyTagManagerSerializationStub(
        PolicyTagManagerSerializationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPolicyTagManagerSerializationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPolicyTagManagerSerializationStub(
        PolicyTagManagerSerializationStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcPolicyTagManagerSerializationStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPolicyTagManagerSerializationStub(
      PolicyTagManagerSerializationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPolicyTagManagerSerializationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPolicyTagManagerSerializationStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPolicyTagManagerSerializationStub(
      PolicyTagManagerSerializationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ReplaceTaxonomyRequest, Taxonomy> replaceTaxonomyTransportSettings =
        GrpcCallSettings.<ReplaceTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(replaceTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
        importTaxonomiesTransportSettings =
            GrpcCallSettings.<ImportTaxonomiesRequest, ImportTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(importTaxonomiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
        exportTaxonomiesTransportSettings =
            GrpcCallSettings.<ExportTaxonomiesRequest, ExportTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(exportTaxonomiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.replaceTaxonomyCallable =
        callableFactory.createUnaryCallable(
            replaceTaxonomyTransportSettings, settings.replaceTaxonomySettings(), clientContext);
    this.importTaxonomiesCallable =
        callableFactory.createUnaryCallable(
            importTaxonomiesTransportSettings, settings.importTaxonomiesSettings(), clientContext);
    this.exportTaxonomiesCallable =
        callableFactory.createUnaryCallable(
            exportTaxonomiesTransportSettings, settings.exportTaxonomiesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ReplaceTaxonomyRequest, Taxonomy> replaceTaxonomyCallable() {
    return replaceTaxonomyCallable;
  }

  @Override
  public UnaryCallable<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
      importTaxonomiesCallable() {
    return importTaxonomiesCallable;
  }

  @Override
  public UnaryCallable<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
      exportTaxonomiesCallable() {
    return exportTaxonomiesCallable;
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
