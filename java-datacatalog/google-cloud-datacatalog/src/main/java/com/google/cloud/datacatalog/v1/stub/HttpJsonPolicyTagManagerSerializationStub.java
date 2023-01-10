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

package com.google.cloud.datacatalog.v1.stub;

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
import com.google.cloud.datacatalog.v1.ExportTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ExportTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.ImportTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ImportTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest;
import com.google.cloud.datacatalog.v1.Taxonomy;
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
 * REST stub implementation for the PolicyTagManagerSerialization service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPolicyTagManagerSerializationStub extends PolicyTagManagerSerializationStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ReplaceTaxonomyRequest, Taxonomy>
      replaceTaxonomyMethodDescriptor =
          ApiMethodDescriptor.<ReplaceTaxonomyRequest, Taxonomy>newBuilder()
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.PolicyTagManagerSerialization/ReplaceTaxonomy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReplaceTaxonomyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/taxonomies/*}:replace",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceTaxonomyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Taxonomy>newBuilder()
                      .setDefaultInstance(Taxonomy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
      importTaxonomiesMethodDescriptor =
          ApiMethodDescriptor.<ImportTaxonomiesRequest, ImportTaxonomiesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.PolicyTagManagerSerialization/ImportTaxonomies")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportTaxonomiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/taxonomies:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImportTaxonomiesResponse>newBuilder()
                      .setDefaultInstance(ImportTaxonomiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
      exportTaxonomiesMethodDescriptor =
          ApiMethodDescriptor.<ExportTaxonomiesRequest, ExportTaxonomiesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.PolicyTagManagerSerialization/ExportTaxonomies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportTaxonomiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/taxonomies:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportTaxonomiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "serializedTaxonomies", request.getSerializedTaxonomies());
                            serializer.putQueryParam(
                                fields, "taxonomies", request.getTaxonomiesList());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExportTaxonomiesResponse>newBuilder()
                      .setDefaultInstance(ExportTaxonomiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ReplaceTaxonomyRequest, Taxonomy> replaceTaxonomyCallable;
  private final UnaryCallable<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
      importTaxonomiesCallable;
  private final UnaryCallable<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
      exportTaxonomiesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPolicyTagManagerSerializationStub create(
      PolicyTagManagerSerializationStubSettings settings) throws IOException {
    return new HttpJsonPolicyTagManagerSerializationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPolicyTagManagerSerializationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPolicyTagManagerSerializationStub(
        PolicyTagManagerSerializationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPolicyTagManagerSerializationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPolicyTagManagerSerializationStub(
        PolicyTagManagerSerializationStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPolicyTagManagerSerializationStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonPolicyTagManagerSerializationStub(
      PolicyTagManagerSerializationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPolicyTagManagerSerializationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPolicyTagManagerSerializationStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonPolicyTagManagerSerializationStub(
      PolicyTagManagerSerializationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ReplaceTaxonomyRequest, Taxonomy> replaceTaxonomyTransportSettings =
        HttpJsonCallSettings.<ReplaceTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(replaceTaxonomyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
        importTaxonomiesTransportSettings =
            HttpJsonCallSettings.<ImportTaxonomiesRequest, ImportTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(importTaxonomiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
        exportTaxonomiesTransportSettings =
            HttpJsonCallSettings.<ExportTaxonomiesRequest, ExportTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(exportTaxonomiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(replaceTaxonomyMethodDescriptor);
    methodDescriptors.add(importTaxonomiesMethodDescriptor);
    methodDescriptors.add(exportTaxonomiesMethodDescriptor);
    return methodDescriptors;
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
