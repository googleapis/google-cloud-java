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
import com.google.cloud.sql.v1beta4.BackupRun;
import com.google.cloud.sql.v1beta4.BackupRunsListResponse;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlBackupRunsDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlBackupRunsGetRequest;
import com.google.cloud.sql.v1beta4.SqlBackupRunsInsertRequest;
import com.google.cloud.sql.v1beta4.SqlBackupRunsListRequest;
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
 * REST stub implementation for the SqlBackupRunsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSqlBackupRunsServiceStub extends SqlBackupRunsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SqlBackupRunsDeleteRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<SqlBackupRunsDeleteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlBackupRunsService/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlBackupRunsDeleteRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/backupRuns/{id}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlBackupRunsDeleteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "id", request.getId());
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlBackupRunsDeleteRequest> serializer =
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

  private static final ApiMethodDescriptor<SqlBackupRunsGetRequest, BackupRun> getMethodDescriptor =
      ApiMethodDescriptor.<SqlBackupRunsGetRequest, BackupRun>newBuilder()
          .setFullMethodName("google.cloud.sql.v1beta4.SqlBackupRunsService/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SqlBackupRunsGetRequest>newBuilder()
                  .setPath(
                      "/sql/v1beta4/projects/{project}/instances/{instance}/backupRuns/{id}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SqlBackupRunsGetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "id", request.getId());
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SqlBackupRunsGetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<BackupRun>newBuilder()
                  .setDefaultInstance(BackupRun.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SqlBackupRunsInsertRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<SqlBackupRunsInsertRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlBackupRunsService/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlBackupRunsInsertRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/backupRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlBackupRunsInsertRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlBackupRunsInsertRequest> serializer =
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

  private static final ApiMethodDescriptor<SqlBackupRunsListRequest, BackupRunsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor.<SqlBackupRunsListRequest, BackupRunsListResponse>newBuilder()
              .setFullMethodName("google.cloud.sql.v1beta4.SqlBackupRunsService/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SqlBackupRunsListRequest>newBuilder()
                      .setPath(
                          "/sql/v1beta4/projects/{project}/instances/{instance}/backupRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SqlBackupRunsListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SqlBackupRunsListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupRunsListResponse>newBuilder()
                      .setDefaultInstance(BackupRunsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SqlBackupRunsDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlBackupRunsGetRequest, BackupRun> getCallable;
  private final UnaryCallable<SqlBackupRunsInsertRequest, Operation> insertCallable;
  private final UnaryCallable<SqlBackupRunsListRequest, BackupRunsListResponse> listCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/backupRuns/{id}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/backupRuns/{id}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");

  public static final HttpJsonSqlBackupRunsServiceStub create(
      SqlBackupRunsServiceStubSettings settings) throws IOException {
    return new HttpJsonSqlBackupRunsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSqlBackupRunsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSqlBackupRunsServiceStub(
        SqlBackupRunsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSqlBackupRunsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSqlBackupRunsServiceStub(
        SqlBackupRunsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSqlBackupRunsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlBackupRunsServiceStub(
      SqlBackupRunsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSqlBackupRunsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSqlBackupRunsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSqlBackupRunsServiceStub(
      SqlBackupRunsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SqlBackupRunsDeleteRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<SqlBackupRunsDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("id", String.valueOf(request.getId()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("id", String.valueOf(request.getId()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlBackupRunsGetRequest, BackupRun> getTransportSettings =
        HttpJsonCallSettings.<SqlBackupRunsGetRequest, BackupRun>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("id", String.valueOf(request.getId()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("id", String.valueOf(request.getId()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<SqlBackupRunsInsertRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<SqlBackupRunsInsertRequest, Operation>newBuilder()
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
    HttpJsonCallSettings<SqlBackupRunsListRequest, BackupRunsListResponse> listTransportSettings =
        HttpJsonCallSettings.<SqlBackupRunsListRequest, BackupRunsListResponse>newBuilder()
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
  public UnaryCallable<SqlBackupRunsDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlBackupRunsGetRequest, BackupRun> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlBackupRunsInsertRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlBackupRunsListRequest, BackupRunsListResponse> listCallable() {
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
