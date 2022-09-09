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

package com.google.cloud.bigquery.migration.v2.stub;

import static com.google.cloud.bigquery.migration.v2.MigrationServiceClient.ListMigrationSubtasksPagedResponse;
import static com.google.cloud.bigquery.migration.v2.MigrationServiceClient.ListMigrationWorkflowsPagedResponse;

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
import com.google.cloud.bigquery.migration.v2.CreateMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2.DeleteMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2.GetMigrationSubtaskRequest;
import com.google.cloud.bigquery.migration.v2.GetMigrationWorkflowRequest;
import com.google.cloud.bigquery.migration.v2.ListMigrationSubtasksRequest;
import com.google.cloud.bigquery.migration.v2.ListMigrationSubtasksResponse;
import com.google.cloud.bigquery.migration.v2.ListMigrationWorkflowsRequest;
import com.google.cloud.bigquery.migration.v2.ListMigrationWorkflowsResponse;
import com.google.cloud.bigquery.migration.v2.MigrationSubtask;
import com.google.cloud.bigquery.migration.v2.MigrationWorkflow;
import com.google.cloud.bigquery.migration.v2.StartMigrationWorkflowRequest;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the MigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonMigrationServiceStub extends MigrationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowMethodDescriptor =
          ApiMethodDescriptor.<CreateMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/CreateMigrationWorkflow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMigrationWorkflowRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/workflows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "migrationWorkflow", request.getMigrationWorkflow(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MigrationWorkflow>newBuilder()
                      .setDefaultInstance(MigrationWorkflow.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowMethodDescriptor =
          ApiMethodDescriptor.<GetMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/GetMigrationWorkflow")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMigrationWorkflowRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/workflows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MigrationWorkflow>newBuilder()
                      .setDefaultInstance(MigrationWorkflow.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/ListMigrationWorkflows")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMigrationWorkflowsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/workflows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMigrationWorkflowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMigrationWorkflowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMigrationWorkflowsResponse>newBuilder()
                      .setDefaultInstance(ListMigrationWorkflowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowMethodDescriptor =
          ApiMethodDescriptor.<DeleteMigrationWorkflowRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/DeleteMigrationWorkflow")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMigrationWorkflowRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/workflows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StartMigrationWorkflowRequest, Empty>
      startMigrationWorkflowMethodDescriptor =
          ApiMethodDescriptor.<StartMigrationWorkflowRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/StartMigrationWorkflow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartMigrationWorkflowRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/workflows/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartMigrationWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskMethodDescriptor =
          ApiMethodDescriptor.<GetMigrationSubtaskRequest, MigrationSubtask>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/GetMigrationSubtask")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMigrationSubtaskRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/workflows/*/subtasks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMigrationSubtaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMigrationSubtaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MigrationSubtask>newBuilder()
                      .setDefaultInstance(MigrationSubtask.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksMethodDescriptor =
          ApiMethodDescriptor
              .<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.migration.v2.MigrationService/ListMigrationSubtasks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMigrationSubtasksRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/workflows/*}/subtasks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMigrationSubtasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMigrationSubtasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMigrationSubtasksResponse>newBuilder()
                      .setDefaultInstance(ListMigrationSubtasksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowCallable;
  private final UnaryCallable<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowCallable;
  private final UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsCallable;
  private final UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsPagedCallable;
  private final UnaryCallable<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowCallable;
  private final UnaryCallable<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowCallable;
  private final UnaryCallable<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskCallable;
  private final UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksCallable;
  private final UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMigrationServiceStub create(MigrationServiceStubSettings settings)
      throws IOException {
    return new HttpJsonMigrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMigrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMigrationServiceStub(
        MigrationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMigrationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMigrationServiceStub(
        MigrationServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMigrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMigrationServiceStub(
      MigrationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMigrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMigrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMigrationServiceStub(
      MigrationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateMigrationWorkflowRequest, MigrationWorkflow>
        createMigrationWorkflowTransportSettings =
            HttpJsonCallSettings.<CreateMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
                .setMethodDescriptor(createMigrationWorkflowMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetMigrationWorkflowRequest, MigrationWorkflow>
        getMigrationWorkflowTransportSettings =
            HttpJsonCallSettings.<GetMigrationWorkflowRequest, MigrationWorkflow>newBuilder()
                .setMethodDescriptor(getMigrationWorkflowMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
        listMigrationWorkflowsTransportSettings =
            HttpJsonCallSettings
                .<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>newBuilder()
                .setMethodDescriptor(listMigrationWorkflowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteMigrationWorkflowRequest, Empty>
        deleteMigrationWorkflowTransportSettings =
            HttpJsonCallSettings.<DeleteMigrationWorkflowRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMigrationWorkflowMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<StartMigrationWorkflowRequest, Empty>
        startMigrationWorkflowTransportSettings =
            HttpJsonCallSettings.<StartMigrationWorkflowRequest, Empty>newBuilder()
                .setMethodDescriptor(startMigrationWorkflowMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetMigrationSubtaskRequest, MigrationSubtask>
        getMigrationSubtaskTransportSettings =
            HttpJsonCallSettings.<GetMigrationSubtaskRequest, MigrationSubtask>newBuilder()
                .setMethodDescriptor(getMigrationSubtaskMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
        listMigrationSubtasksTransportSettings =
            HttpJsonCallSettings
                .<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>newBuilder()
                .setMethodDescriptor(listMigrationSubtasksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            createMigrationWorkflowTransportSettings,
            settings.createMigrationWorkflowSettings(),
            clientContext);
    this.getMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            getMigrationWorkflowTransportSettings,
            settings.getMigrationWorkflowSettings(),
            clientContext);
    this.listMigrationWorkflowsCallable =
        callableFactory.createUnaryCallable(
            listMigrationWorkflowsTransportSettings,
            settings.listMigrationWorkflowsSettings(),
            clientContext);
    this.listMigrationWorkflowsPagedCallable =
        callableFactory.createPagedCallable(
            listMigrationWorkflowsTransportSettings,
            settings.listMigrationWorkflowsSettings(),
            clientContext);
    this.deleteMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            deleteMigrationWorkflowTransportSettings,
            settings.deleteMigrationWorkflowSettings(),
            clientContext);
    this.startMigrationWorkflowCallable =
        callableFactory.createUnaryCallable(
            startMigrationWorkflowTransportSettings,
            settings.startMigrationWorkflowSettings(),
            clientContext);
    this.getMigrationSubtaskCallable =
        callableFactory.createUnaryCallable(
            getMigrationSubtaskTransportSettings,
            settings.getMigrationSubtaskSettings(),
            clientContext);
    this.listMigrationSubtasksCallable =
        callableFactory.createUnaryCallable(
            listMigrationSubtasksTransportSettings,
            settings.listMigrationSubtasksSettings(),
            clientContext);
    this.listMigrationSubtasksPagedCallable =
        callableFactory.createPagedCallable(
            listMigrationSubtasksTransportSettings,
            settings.listMigrationSubtasksSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createMigrationWorkflowMethodDescriptor);
    methodDescriptors.add(getMigrationWorkflowMethodDescriptor);
    methodDescriptors.add(listMigrationWorkflowsMethodDescriptor);
    methodDescriptors.add(deleteMigrationWorkflowMethodDescriptor);
    methodDescriptors.add(startMigrationWorkflowMethodDescriptor);
    methodDescriptors.add(getMigrationSubtaskMethodDescriptor);
    methodDescriptors.add(listMigrationSubtasksMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowCallable() {
    return createMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowCallable() {
    return getMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsResponse>
      listMigrationWorkflowsCallable() {
    return listMigrationWorkflowsCallable;
  }

  @Override
  public UnaryCallable<ListMigrationWorkflowsRequest, ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsPagedCallable() {
    return listMigrationWorkflowsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteMigrationWorkflowRequest, Empty> deleteMigrationWorkflowCallable() {
    return deleteMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowCallable() {
    return startMigrationWorkflowCallable;
  }

  @Override
  public UnaryCallable<GetMigrationSubtaskRequest, MigrationSubtask> getMigrationSubtaskCallable() {
    return getMigrationSubtaskCallable;
  }

  @Override
  public UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksResponse>
      listMigrationSubtasksCallable() {
    return listMigrationSubtasksCallable;
  }

  @Override
  public UnaryCallable<ListMigrationSubtasksRequest, ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksPagedCallable() {
    return listMigrationSubtasksPagedCallable;
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
