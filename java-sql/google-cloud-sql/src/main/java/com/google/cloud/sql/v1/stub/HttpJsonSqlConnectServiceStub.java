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

package com.google.cloud.sql.v1.stub;

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
import com.google.cloud.sql.v1.ConnectSettings;
import com.google.cloud.sql.v1.GenerateEphemeralCertRequest;
import com.google.cloud.sql.v1.GenerateEphemeralCertResponse;
import com.google.cloud.sql.v1.GetConnectSettingsRequest;
import com.google.cloud.sql.v1.ResolveConnectSettingsRequest;
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
 * REST stub implementation for the SqlConnectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonSqlConnectServiceStub extends SqlConnectServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetConnectSettingsRequest, ConnectSettings>
      getConnectSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetConnectSettingsRequest, ConnectSettings>newBuilder()
              .setFullMethodName("google.cloud.sql.v1.SqlConnectService/GetConnectSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{project}/instances/{instance}/connectSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "readTime", request.getReadTime());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectSettings>newBuilder()
                      .setDefaultInstance(ConnectSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsMethodDescriptor =
          ApiMethodDescriptor.<ResolveConnectSettingsRequest, ConnectSettings>newBuilder()
              .setFullMethodName("google.cloud.sql.v1.SqlConnectService/ResolveConnectSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResolveConnectSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/locations/{location}/dns/{dnsName}:resolveConnectSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResolveConnectSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "dnsName", request.getDnsName());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResolveConnectSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectSettings>newBuilder()
                      .setDefaultInstance(ConnectSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1.SqlConnectService/GenerateEphemeralCert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateEphemeralCertRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{project}/instances/{instance}:generateEphemeralCert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateEphemeralCertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateEphemeralCertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearInstance().clearProject().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateEphemeralCertResponse>newBuilder()
                      .setDefaultInstance(GenerateEphemeralCertResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetConnectSettingsRequest, ConnectSettings>
      getConnectSettingsCallable;
  private final UnaryCallable<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsCallable;
  private final UnaryCallable<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSqlConnectServiceStub create(SqlConnectServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSqlConnectServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSqlConnectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSqlConnectServiceStub(
        SqlConnectServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSqlConnectServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSqlConnectServiceStub(
        SqlConnectServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSqlConnectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlConnectServiceStub(
      SqlConnectServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSqlConnectServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSqlConnectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlConnectServiceStub(
      SqlConnectServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetConnectSettingsRequest, ConnectSettings>
        getConnectSettingsTransportSettings =
            HttpJsonCallSettings.<GetConnectSettingsRequest, ConnectSettings>newBuilder()
                .setMethodDescriptor(getConnectSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResolveConnectSettingsRequest, ConnectSettings>
        resolveConnectSettingsTransportSettings =
            HttpJsonCallSettings.<ResolveConnectSettingsRequest, ConnectSettings>newBuilder()
                .setMethodDescriptor(resolveConnectSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("dns_name", String.valueOf(request.getDnsName()));
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
        generateEphemeralCertTransportSettings =
            HttpJsonCallSettings
                .<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>newBuilder()
                .setMethodDescriptor(generateEphemeralCertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();

    this.getConnectSettingsCallable =
        callableFactory.createUnaryCallable(
            getConnectSettingsTransportSettings,
            settings.getConnectSettingsSettings(),
            clientContext);
    this.resolveConnectSettingsCallable =
        callableFactory.createUnaryCallable(
            resolveConnectSettingsTransportSettings,
            settings.resolveConnectSettingsSettings(),
            clientContext);
    this.generateEphemeralCertCallable =
        callableFactory.createUnaryCallable(
            generateEphemeralCertTransportSettings,
            settings.generateEphemeralCertSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getConnectSettingsMethodDescriptor);
    methodDescriptors.add(resolveConnectSettingsMethodDescriptor);
    methodDescriptors.add(generateEphemeralCertMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetConnectSettingsRequest, ConnectSettings> getConnectSettingsCallable() {
    return getConnectSettingsCallable;
  }

  @Override
  public UnaryCallable<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsCallable() {
    return resolveConnectSettingsCallable;
  }

  @Override
  public UnaryCallable<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertCallable() {
    return generateEphemeralCertCallable;
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
