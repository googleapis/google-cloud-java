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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1.Operation;
import com.google.cloud.sql.v1.SqlSslCertsDeleteRequest;
import com.google.cloud.sql.v1.SqlSslCertsGetRequest;
import com.google.cloud.sql.v1.SqlSslCertsInsertRequest;
import com.google.cloud.sql.v1.SqlSslCertsListRequest;
import com.google.cloud.sql.v1.SslCert;
import com.google.cloud.sql.v1.SslCertsInsertResponse;
import com.google.cloud.sql.v1.SslCertsListResponse;
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
 * REST stub implementation for the SqlSslCertsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonSqlSslCertsServiceStub extends SqlSslCertsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SqlSslCertsDeleteRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<SqlSslCertsDeleteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1.SqlSslCertsService/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlSslCertsDeleteRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlSslCertsDeleteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "sha1Fingerprint", request.getSha1Fingerprint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlSslCertsDeleteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlSslCertsGetRequest, SslCert> getMethodDescriptor =
      ApiMethodDescriptor.<SqlSslCertsGetRequest, SslCert>newBuilder()
          .setFullMethodName("google.cloud.sql.v1.SqlSslCertsService/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SqlSslCertsGetRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SqlSslCertsGetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(
                            fields, "sha1Fingerprint", request.getSha1Fingerprint());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SqlSslCertsGetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<SslCert>newBuilder()
                  .setDefaultInstance(SslCert.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SqlSslCertsInsertRequest, SslCertsInsertResponse>
      insertMethodDescriptor =
          ApiMethodDescriptor.<SqlSslCertsInsertRequest, SslCertsInsertResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1.SqlSslCertsService/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlSslCertsInsertRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{project}/instances/{instance}/sslCerts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlSslCertsInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlSslCertsInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertsInsertResponse>newBuilder()
                      .setDefaultInstance(SslCertsInsertResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlSslCertsListRequest, SslCertsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor.<SqlSslCertsListRequest, SslCertsListResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1.SqlSslCertsService/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlSslCertsListRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{project}/instances/{instance}/sslCerts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlSslCertsListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlSslCertsListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslCertsListResponse>newBuilder()
                      .setDefaultInstance(SslCertsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SqlSslCertsDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlSslCertsGetRequest, SslCert> getCallable;
  private final UnaryCallable<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertCallable;
  private final UnaryCallable<SqlSslCertsListRequest, SslCertsListResponse> listCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/sslCerts/{sha1_fingerprint}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/sslCerts/{sha1_fingerprint}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");

  public static final HttpJsonSqlSslCertsServiceStub create(SqlSslCertsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSqlSslCertsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSqlSslCertsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSqlSslCertsServiceStub(
        SqlSslCertsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSqlSslCertsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSqlSslCertsServiceStub(
        SqlSslCertsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSqlSslCertsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlSslCertsServiceStub(
      SqlSslCertsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSqlSslCertsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSqlSslCertsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlSslCertsServiceStub(
      SqlSslCertsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SqlSslCertsDeleteRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<SqlSslCertsDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlSslCertsGetRequest, SslCert> getTransportSettings =
        HttpJsonCallSettings.<SqlSslCertsGetRequest, SslCert>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "sha1_fingerprint", String.valueOf(request.getSha1Fingerprint()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertTransportSettings =
        HttpJsonCallSettings.<SqlSslCertsInsertRequest, SslCertsInsertResponse>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlSslCertsListRequest, SslCertsListResponse> listTransportSettings =
        HttpJsonCallSettings.<SqlSslCertsListRequest, SslCertsListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SqlSslCertsDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlSslCertsGetRequest, SslCert> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlSslCertsListRequest, SslCertsListResponse> listCallable() {
    return listCallable;
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
