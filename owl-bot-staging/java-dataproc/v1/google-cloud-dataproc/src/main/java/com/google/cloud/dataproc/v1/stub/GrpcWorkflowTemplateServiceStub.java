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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the WorkflowTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcWorkflowTemplateServiceStub extends WorkflowTemplateServiceStub {
  private static final MethodDescriptor<CreateWorkflowTemplateRequest, WorkflowTemplate>
      createWorkflowTemplateMethodDescriptor =
          MethodDescriptor.<CreateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/CreateWorkflowTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkflowTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkflowTemplateRequest, WorkflowTemplate>
      getWorkflowTemplateMethodDescriptor =
          MethodDescriptor.<GetWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/GetWorkflowTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkflowTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InstantiateWorkflowTemplateRequest, Operation>
      instantiateWorkflowTemplateMethodDescriptor =
          MethodDescriptor.<InstantiateWorkflowTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/InstantiateWorkflowTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InstantiateWorkflowTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InstantiateInlineWorkflowTemplateRequest, Operation>
      instantiateInlineWorkflowTemplateMethodDescriptor =
          MethodDescriptor.<InstantiateInlineWorkflowTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/InstantiateInlineWorkflowTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      InstantiateInlineWorkflowTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkflowTemplateRequest, WorkflowTemplate>
      updateWorkflowTemplateMethodDescriptor =
          MethodDescriptor.<UpdateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/UpdateWorkflowTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkflowTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkflowTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
      listWorkflowTemplatesMethodDescriptor =
          MethodDescriptor.<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/ListWorkflowTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkflowTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkflowTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkflowTemplateRequest, Empty>
      deleteWorkflowTemplateMethodDescriptor =
          MethodDescriptor.<DeleteWorkflowTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.WorkflowTemplateService/DeleteWorkflowTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkflowTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWorkflowTemplateServiceStub create(
      WorkflowTemplateServiceStubSettings settings) throws IOException {
    return new GrpcWorkflowTemplateServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWorkflowTemplateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcWorkflowTemplateServiceStub(
        WorkflowTemplateServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWorkflowTemplateServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWorkflowTemplateServiceStub(
        WorkflowTemplateServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWorkflowTemplateServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWorkflowTemplateServiceStub(
      WorkflowTemplateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcWorkflowTemplateServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWorkflowTemplateServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWorkflowTemplateServiceStub(
      WorkflowTemplateServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateWorkflowTemplateRequest, WorkflowTemplate>
        createWorkflowTemplateTransportSettings =
            GrpcCallSettings.<CreateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
                .setMethodDescriptor(createWorkflowTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetWorkflowTemplateRequest, WorkflowTemplate>
        getWorkflowTemplateTransportSettings =
            GrpcCallSettings.<GetWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
                .setMethodDescriptor(getWorkflowTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<InstantiateWorkflowTemplateRequest, Operation>
        instantiateWorkflowTemplateTransportSettings =
            GrpcCallSettings.<InstantiateWorkflowTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(instantiateWorkflowTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<InstantiateInlineWorkflowTemplateRequest, Operation>
        instantiateInlineWorkflowTemplateTransportSettings =
            GrpcCallSettings.<InstantiateInlineWorkflowTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(instantiateInlineWorkflowTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkflowTemplateRequest, WorkflowTemplate>
        updateWorkflowTemplateTransportSettings =
            GrpcCallSettings.<UpdateWorkflowTemplateRequest, WorkflowTemplate>newBuilder()
                .setMethodDescriptor(updateWorkflowTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("template.name", String.valueOf(request.getTemplate().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>
        listWorkflowTemplatesTransportSettings =
            GrpcCallSettings
                .<ListWorkflowTemplatesRequest, ListWorkflowTemplatesResponse>newBuilder()
                .setMethodDescriptor(listWorkflowTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkflowTemplateRequest, Empty> deleteWorkflowTemplateTransportSettings =
        GrpcCallSettings.<DeleteWorkflowTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkflowTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
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
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
