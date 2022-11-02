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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient.ListWorkflowTemplatesPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest;
import com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse;
import com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest;
import com.google.cloud.dataproc.v1.WorkflowMetadata;
import com.google.cloud.dataproc.v1.WorkflowTemplate;
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
 * REST stub implementation for the WorkflowTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonWorkflowTemplateServiceStub extends WorkflowTemplateServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(WorkflowMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/CreateWorkflowTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkflowTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/workflowTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/regions/*}/workflowTemplates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("template", request.getTemplate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowTemplate>newBuilder()
                      .setDefaultInstance(WorkflowTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWorkflowTemplateRequest, WorkflowTemplate>
      getWorkflowTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/GetWorkflowTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkflowTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/workflowTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/regions/*/workflowTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "version", request.getVersion());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowTemplate>newBuilder()
                      .setDefaultInstance(WorkflowTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateMethodDescriptor =
          ApiMethodDescriptor.<InstantiateWorkflowTemplateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/InstantiateWorkflowTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InstantiateWorkflowTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/workflowTemplates/*}:instantiate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InstantiateWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/regions/*/workflowTemplates/*}:instantiate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InstantiateWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InstantiateWorkflowTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateMethodDescriptor =
          ApiMethodDescriptor.<InstantiateInlineWorkflowTemplateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/InstantiateInlineWorkflowTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InstantiateInlineWorkflowTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/workflowTemplates:instantiateInline",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InstantiateInlineWorkflowTemplateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/regions/*}/workflowTemplates:instantiateInline")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InstantiateInlineWorkflowTemplateRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("template", request.getTemplate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InstantiateInlineWorkflowTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/UpdateWorkflowTemplate")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWorkflowTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{template.name=projects/*/locations/*/workflowTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "template.name", request.getTemplate().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{template.name=projects/*/regions/*/workflowTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("template", request.getTemplate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WorkflowTemplate>newBuilder()
                      .setDefaultInstance(WorkflowTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
      listWorkflowTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/ListWorkflowTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkflowTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/workflowTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/regions/*}/workflowTemplates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkflowTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkflowTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListWorkflowTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWorkflowTemplateRequest, Empty>
      deleteWorkflowTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkflowTemplateRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/DeleteWorkflowTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkflowTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/workflowTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/regions/*/workflowTemplates/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkflowTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "version", request.getVersion());
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

  private final UnaryCallable<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateCallable;
  private final UnaryCallable<GetWorkflowTemplateRequest, WorkflowTemplate>
      getWorkflowTemplateCallable;
  private final UnaryCallable<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateCallable;
  private final OperationCallable<InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateWorkflowTemplateOperationCallable;
  private final UnaryCallable<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateCallable;
  private final OperationCallable<InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateInlineWorkflowTemplateOperationCallable;
  private final UnaryCallable<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateCallable;
  private final UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
      listWorkflowTemplatesCallable;
  private final UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesPagedResponse>
      listWorkflowTemplatesPagedCallable;
  private final UnaryCallable<DeleteWorkflowTemplateRequest, Empty> deleteWorkflowTemplateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWorkflowTemplateServiceStub create(
      WorkflowTemplateServiceStubSettings settings) throws IOException {
    return new HttpJsonWorkflowTemplateServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWorkflowTemplateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWorkflowTemplateServiceStub(
        WorkflowTemplateServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWorkflowTemplateServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWorkflowTemplateServiceStub(
        WorkflowTemplateServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWorkflowTemplateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWorkflowTemplateServiceStub(
      WorkflowTemplateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWorkflowTemplateServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWorkflowTemplateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWorkflowTemplateServiceStub(
      WorkflowTemplateServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateWorkflowTemplateRequest, WorkflowTemplate>
        createWorkflowTemplateTransportSettings =
            HttpJsonCallSettings.<CreateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
                .setMethodDescriptor(createWorkflowTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetWorkflowTemplateRequest, WorkflowTemplate>
        getWorkflowTemplateTransportSettings =
            HttpJsonCallSettings.<GetWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
                .setMethodDescriptor(getWorkflowTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InstantiateWorkflowTemplateRequest, Operation>
        instantiateWorkflowTemplateTransportSettings =
            HttpJsonCallSettings.<InstantiateWorkflowTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(instantiateWorkflowTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InstantiateInlineWorkflowTemplateRequest, Operation>
        instantiateInlineWorkflowTemplateTransportSettings =
            HttpJsonCallSettings.<InstantiateInlineWorkflowTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(instantiateInlineWorkflowTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateWorkflowTemplateRequest, WorkflowTemplate>
        updateWorkflowTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
                .setMethodDescriptor(updateWorkflowTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
        listWorkflowTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>newBuilder()
                .setMethodDescriptor(listWorkflowTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteWorkflowTemplateRequest, Empty>
        deleteWorkflowTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteWorkflowTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteWorkflowTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createWorkflowTemplateCallable =
        callableFactory.createUnaryCallable(
            createWorkflowTemplateTransportSettings,
            settings.createWorkflowTemplateSettings(),
            clientContext);
    this.getWorkflowTemplateCallable =
        callableFactory.createUnaryCallable(
            getWorkflowTemplateTransportSettings,
            settings.getWorkflowTemplateSettings(),
            clientContext);
    this.instantiateWorkflowTemplateCallable =
        callableFactory.createUnaryCallable(
            instantiateWorkflowTemplateTransportSettings,
            settings.instantiateWorkflowTemplateSettings(),
            clientContext);
    this.instantiateWorkflowTemplateOperationCallable =
        callableFactory.createOperationCallable(
            instantiateWorkflowTemplateTransportSettings,
            settings.instantiateWorkflowTemplateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.instantiateInlineWorkflowTemplateCallable =
        callableFactory.createUnaryCallable(
            instantiateInlineWorkflowTemplateTransportSettings,
            settings.instantiateInlineWorkflowTemplateSettings(),
            clientContext);
    this.instantiateInlineWorkflowTemplateOperationCallable =
        callableFactory.createOperationCallable(
            instantiateInlineWorkflowTemplateTransportSettings,
            settings.instantiateInlineWorkflowTemplateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateWorkflowTemplateCallable =
        callableFactory.createUnaryCallable(
            updateWorkflowTemplateTransportSettings,
            settings.updateWorkflowTemplateSettings(),
            clientContext);
    this.listWorkflowTemplatesCallable =
        callableFactory.createUnaryCallable(
            listWorkflowTemplatesTransportSettings,
            settings.listWorkflowTemplatesSettings(),
            clientContext);
    this.listWorkflowTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listWorkflowTemplatesTransportSettings,
            settings.listWorkflowTemplatesSettings(),
            clientContext);
    this.deleteWorkflowTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteWorkflowTemplateTransportSettings,
            settings.deleteWorkflowTemplateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createWorkflowTemplateMethodDescriptor);
    methodDescriptors.add(getWorkflowTemplateMethodDescriptor);
    methodDescriptors.add(instantiateWorkflowTemplateMethodDescriptor);
    methodDescriptors.add(instantiateInlineWorkflowTemplateMethodDescriptor);
    methodDescriptors.add(updateWorkflowTemplateMethodDescriptor);
    methodDescriptors.add(listWorkflowTemplatesMethodDescriptor);
    methodDescriptors.add(deleteWorkflowTemplateMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateCallable() {
    return createWorkflowTemplateCallable;
  }

  @Override
  public UnaryCallable<GetWorkflowTemplateRequest, WorkflowTemplate> getWorkflowTemplateCallable() {
    return getWorkflowTemplateCallable;
  }

  @Override
  public UnaryCallable<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateCallable() {
    return instantiateWorkflowTemplateCallable;
  }

  @Override
  public OperationCallable<InstantiateWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateWorkflowTemplateOperationCallable() {
    return instantiateWorkflowTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateCallable() {
    return instantiateInlineWorkflowTemplateCallable;
  }

  @Override
  public OperationCallable<InstantiateInlineWorkflowTemplateRequest, Empty, WorkflowMetadata>
      instantiateInlineWorkflowTemplateOperationCallable() {
    return instantiateInlineWorkflowTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateCallable() {
    return updateWorkflowTemplateCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
      listWorkflowTemplatesCallable() {
    return listWorkflowTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListWorkflowTemplatesRequest, ListWorkflowTemplatesPagedResponse>
      listWorkflowTemplatesPagedCallable() {
    return listWorkflowTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkflowTemplateRequest, Empty> deleteWorkflowTemplateCallable() {
    return deleteWorkflowTemplateCallable;
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
