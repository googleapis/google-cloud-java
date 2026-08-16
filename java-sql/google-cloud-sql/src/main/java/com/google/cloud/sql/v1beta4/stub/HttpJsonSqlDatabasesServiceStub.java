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

package com.google.cloud.sql.v1beta4.stub;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1beta4.Database;
import com.google.cloud.sql.v1beta4.DatabasesListResponse;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlDatabasesDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesGetRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesInsertRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesListRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesUpdateRequest;
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
 * REST stub implementation for the SqlDatabasesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSqlDatabasesServiceStub extends SqlDatabasesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SqlDatabasesDeleteRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<SqlDatabasesDeleteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlDatabasesDeleteRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesDeleteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesDeleteRequest> serializer =
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

  private static final ApiMethodDescriptor<SqlDatabasesGetRequest, Database> getMethodDescriptor =
      ApiMethodDescriptor.<SqlDatabasesGetRequest, Database>newBuilder()
          .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SqlDatabasesGetRequest>newBuilder()
                  .setPath(
                      "/sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SqlDatabasesGetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "database", request.getDatabase());
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SqlDatabasesGetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Database>newBuilder()
                  .setDefaultInstance(Database.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SqlDatabasesInsertRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<SqlDatabasesInsertRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlDatabasesInsertRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/databases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlDatabasesListRequest, DatabasesListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor.<SqlDatabasesListRequest, DatabasesListResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlDatabasesListRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/databases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DatabasesListResponse>newBuilder()
                      .setDefaultInstance(DatabasesListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlDatabasesUpdateRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<SqlDatabasesUpdateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlDatabasesUpdateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SqlDatabasesUpdateRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<SqlDatabasesUpdateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Update")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlDatabasesUpdateRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "database", request.getDatabase());
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlDatabasesUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("body", request.getBody(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SqlDatabasesDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlDatabasesGetRequest, Database> getCallable;
  private final UnaryCallable<SqlDatabasesInsertRequest, Operation> insertCallable;
  private final UnaryCallable<SqlDatabasesListRequest, DatabasesListResponse> listCallable;
  private final UnaryCallable<SqlDatabasesUpdateRequest, Operation> patchCallable;
  private final UnaryCallable<SqlDatabasesUpdateRequest, Operation> updateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PATCH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");
  private static final PathTemplate UPDATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");

  public static final HttpJsonSqlDatabasesServiceStub create(
      SqlDatabasesServiceStubSettings settings) throws IOException {
    return new HttpJsonSqlDatabasesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSqlDatabasesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSqlDatabasesServiceStub(
        SqlDatabasesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSqlDatabasesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSqlDatabasesServiceStub(
        SqlDatabasesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSqlDatabasesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlDatabasesServiceStub(
      SqlDatabasesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSqlDatabasesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSqlDatabasesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlDatabasesServiceStub(
      SqlDatabasesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SqlDatabasesDeleteRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<SqlDatabasesDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlDatabasesGetRequest, Database> getTransportSettings =
        HttpJsonCallSettings.<SqlDatabasesGetRequest, Database>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlDatabasesInsertRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<SqlDatabasesInsertRequest, Operation>newBuilder()
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
    HttpJsonCallSettings<SqlDatabasesListRequest, DatabasesListResponse> listTransportSettings =
        HttpJsonCallSettings.<SqlDatabasesListRequest, DatabasesListResponse>newBuilder()
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
    HttpJsonCallSettings<SqlDatabasesUpdateRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<SqlDatabasesUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return PATCH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlDatabasesUpdateRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<SqlDatabasesUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return UPDATE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
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
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);

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
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SqlDatabasesDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesGetRequest, Database> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesInsertRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesListRequest, DatabasesListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesUpdateRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesUpdateRequest, Operation> updateCallable() {
    return updateCallable;
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
