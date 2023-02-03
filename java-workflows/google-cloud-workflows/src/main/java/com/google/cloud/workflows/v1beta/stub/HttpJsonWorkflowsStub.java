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

package com.google.cloud.workflows.v1beta.stub;

import static com.google.cloud.workflows.v1beta.WorkflowsClient.ListWorkflowsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workflows.v1beta.CreateWorkflowRequest;
import com.google.cloud.workflows.v1beta.DeleteWorkflowRequest;
import com.google.cloud.workflows.v1beta.GetWorkflowRequest;
import com.google.cloud.workflows.v1beta.ListWorkflowsRequest;
import com.google.cloud.workflows.v1beta.ListWorkflowsResponse;
import com.google.cloud.workflows.v1beta.OperationMetadata;
import com.google.cloud.workflows.v1beta.UpdateWorkflowRequest;
import com.google.cloud.workflows.v1beta.Workflow;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the Workflows service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonWorkflowsStub extends WorkflowsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Workflow.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListWorkflowsRequest, ListWorkflowsResponse>
      listWorkflowsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkflowsRequest, ListWorkflowsResponse>newBuilder()
              .setFullMethodName("google.cloud.workflows.v1beta.Workflows/ListWorkflows")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkflowsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/workflows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkflowsResponse>newBuilder()
                      .setDefaultInstance(ListWorkflowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWorkflowRequest, Workflow>
      getWorkflowMethodDescriptor =
          ApiMethodDescriptor.<GetWorkflowRequest, Workflow>newBuilder()
              .setFullMethodName("google.cloud.workflows.v1beta.Workflows/GetWorkflow")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkflowRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workflows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Workflow>newBuilder()
                      .setDefaultInstance(Workflow.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateWorkflowRequest, Operation>
      createWorkflowMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkflowRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workflows.v1beta.Workflows/CreateWorkflow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkflowRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/workflows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "workflowId", request.getWorkflowId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workflow", request.getWorkflow(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkflowRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteWorkflowRequest, Operation>
      deleteWorkflowMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkflowRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workflows.v1beta.Workflows/DeleteWorkflow")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkflowRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/workflows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowRequest> serializer =
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
              .setOperationSnapshotFactory(
                  (DeleteWorkflowRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateWorkflowRequest, Operation>
      updateWorkflowMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkflowRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workflows.v1beta.Workflows/UpdateWorkflow")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkflowRequest>newBuilder()
                      .setPath(
                          "/v1beta/{workflow.name=projects/*/locations/*/workflows/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "workflow.name", request.getWorkflow().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkflowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workflow", request.getWorkflow(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateWorkflowRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable;
  private final UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable;
  private final UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable;
  private final UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable;
  private final OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable;
  private final UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable;
  private final OperationCallable<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationCallable;
  private final UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable;
  private final OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWorkflowsStub create(WorkflowsStubSettings settings)
      throws IOException {
    return new HttpJsonWorkflowsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWorkflowsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonWorkflowsStub(
        WorkflowsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWorkflowsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWorkflowsStub(
        WorkflowsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWorkflowsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWorkflowsStub(WorkflowsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWorkflowsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWorkflowsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWorkflowsStub(
      WorkflowsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListWorkflowsRequest, ListWorkflowsResponse>
        listWorkflowsTransportSettings =
            HttpJsonCallSettings.<ListWorkflowsRequest, ListWorkflowsResponse>newBuilder()
                .setMethodDescriptor(listWorkflowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetWorkflowRequest, Workflow> getWorkflowTransportSettings =
        HttpJsonCallSettings.<GetWorkflowRequest, Workflow>newBuilder()
            .setMethodDescriptor(getWorkflowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateWorkflowRequest, Operation> createWorkflowTransportSettings =
        HttpJsonCallSettings.<CreateWorkflowRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkflowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteWorkflowRequest, Operation> deleteWorkflowTransportSettings =
        HttpJsonCallSettings.<DeleteWorkflowRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkflowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateWorkflowRequest, Operation> updateWorkflowTransportSettings =
        HttpJsonCallSettings.<UpdateWorkflowRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkflowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listWorkflowsCallable =
        callableFactory.createUnaryCallable(
            listWorkflowsTransportSettings, settings.listWorkflowsSettings(), clientContext);
    this.listWorkflowsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkflowsTransportSettings, settings.listWorkflowsSettings(), clientContext);
    this.getWorkflowCallable =
        callableFactory.createUnaryCallable(
            getWorkflowTransportSettings, settings.getWorkflowSettings(), clientContext);
    this.createWorkflowCallable =
        callableFactory.createUnaryCallable(
            createWorkflowTransportSettings, settings.createWorkflowSettings(), clientContext);
    this.createWorkflowOperationCallable =
        callableFactory.createOperationCallable(
            createWorkflowTransportSettings,
            settings.createWorkflowOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteWorkflowCallable =
        callableFactory.createUnaryCallable(
            deleteWorkflowTransportSettings, settings.deleteWorkflowSettings(), clientContext);
    this.deleteWorkflowOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkflowTransportSettings,
            settings.deleteWorkflowOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateWorkflowCallable =
        callableFactory.createUnaryCallable(
            updateWorkflowTransportSettings, settings.updateWorkflowSettings(), clientContext);
    this.updateWorkflowOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkflowTransportSettings,
            settings.updateWorkflowOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listWorkflowsMethodDescriptor);
    methodDescriptors.add(getWorkflowMethodDescriptor);
    methodDescriptors.add(createWorkflowMethodDescriptor);
    methodDescriptors.add(deleteWorkflowMethodDescriptor);
    methodDescriptors.add(updateWorkflowMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListWorkflowsRequest, ListWorkflowsResponse> listWorkflowsCallable() {
    return listWorkflowsCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowsRequest, ListWorkflowsPagedResponse>
      listWorkflowsPagedCallable() {
    return listWorkflowsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkflowRequest, Workflow> getWorkflowCallable() {
    return getWorkflowCallable;
  }

  @Override
  public UnaryCallable<CreateWorkflowRequest, Operation> createWorkflowCallable() {
    return createWorkflowCallable;
  }

  @Override
  public OperationCallable<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationCallable() {
    return createWorkflowOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkflowRequest, Operation> deleteWorkflowCallable() {
    return deleteWorkflowCallable;
  }

  @Override
  public OperationCallable<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationCallable() {
    return deleteWorkflowOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkflowRequest, Operation> updateWorkflowCallable() {
    return updateWorkflowCallable;
  }

  @Override
  public OperationCallable<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationCallable() {
    return updateWorkflowOperationCallable;
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
