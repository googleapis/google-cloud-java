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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient.ListEvaluationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateEvaluationMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateEvaluationRequest;
import com.google.cloud.discoveryengine.v1alpha.Evaluation;
import com.google.cloud.discoveryengine.v1alpha.GetEvaluationRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationResultsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationResultsResponse;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EvaluationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEvaluationServiceStub extends EvaluationServiceStub {
  private static final MethodDescriptor<GetEvaluationRequest, Evaluation>
      getEvaluationMethodDescriptor =
          MethodDescriptor.<GetEvaluationRequest, Evaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.EvaluationService/GetEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Evaluation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsMethodDescriptor =
          MethodDescriptor.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.EvaluationService/ListEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEvaluationRequest, Operation>
      createEvaluationMethodDescriptor =
          MethodDescriptor.<CreateEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.EvaluationService/CreateEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsMethodDescriptor =
          MethodDescriptor.<ListEvaluationResultsRequest, ListEvaluationResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.EvaluationService/ListEvaluationResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationResultsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable;
  private final UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable;
  private final OperationCallable<CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
      createEvaluationOperationCallable;
  private final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable;
  private final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEvaluationServiceStub create(EvaluationServiceStubSettings settings)
      throws IOException {
    return new GrpcEvaluationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEvaluationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEvaluationServiceStub(
        EvaluationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEvaluationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEvaluationServiceStub(
        EvaluationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEvaluationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEvaluationServiceStub(
      EvaluationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcEvaluationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEvaluationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEvaluationServiceStub(
      EvaluationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetEvaluationRequest, Evaluation> getEvaluationTransportSettings =
        GrpcCallSettings.<GetEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(getEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEvaluationsRequest, ListEvaluationsResponse>
        listEvaluationsTransportSettings =
            GrpcCallSettings.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateEvaluationRequest, Operation> createEvaluationTransportSettings =
        GrpcCallSettings.<CreateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(createEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
        listEvaluationResultsTransportSettings =
            GrpcCallSettings
                .<ListEvaluationResultsRequest, ListEvaluationResultsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("evaluation", String.valueOf(request.getEvaluation()));
                      return builder.build();
                    })
                .build();

    this.getEvaluationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationTransportSettings, settings.getEvaluationSettings(), clientContext);
    this.listEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.createEvaluationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationTransportSettings, settings.createEvaluationSettings(), clientContext);
    this.createEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createEvaluationTransportSettings,
            settings.createEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.listEvaluationResultsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationResultsTransportSettings,
            settings.listEvaluationResultsSettings(),
            clientContext);
    this.listEvaluationResultsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationResultsTransportSettings,
            settings.listEvaluationResultsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return getEvaluationCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> listEvaluationsCallable() {
    return listEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return listEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    return createEvaluationCallable;
  }

  @Override
  public OperationCallable<CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
      createEvaluationOperationCallable() {
    return createEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable() {
    return listEvaluationResultsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable() {
    return listEvaluationResultsPagedCallable;
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
