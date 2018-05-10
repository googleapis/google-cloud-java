/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationMetadata;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationResult;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for DLP API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcDlpServiceStub extends DlpServiceStub {

  private static final MethodDescriptor<InspectContentRequest, InspectContentResponse>
      inspectContentMethodDescriptor =
          MethodDescriptor.<InspectContentRequest, InspectContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/InspectContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InspectContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InspectContentResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<RedactContentRequest, RedactContentResponse>
      redactContentMethodDescriptor =
          MethodDescriptor.<RedactContentRequest, RedactContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/RedactContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RedactContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RedactContentResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentMethodDescriptor =
          MethodDescriptor.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/DeidentifyContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeidentifyContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DeidentifyContentResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<AnalyzeDataSourceRiskRequest, Operation>
      analyzeDataSourceRiskMethodDescriptor =
          MethodDescriptor.<AnalyzeDataSourceRiskRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/AnalyzeDataSourceRisk")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeDataSourceRiskRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateInspectOperationRequest, Operation>
      createInspectOperationMethodDescriptor =
          MethodDescriptor.<CreateInspectOperationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/CreateInspectOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInspectOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsMethodDescriptor =
          MethodDescriptor.<ListInspectFindingsRequest, ListInspectFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/ListInspectFindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInspectFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInspectFindingsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesMethodDescriptor =
          MethodDescriptor.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/ListInfoTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInfoTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInfoTypesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesMethodDescriptor =
          MethodDescriptor.<ListRootCategoriesRequest, ListRootCategoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2beta1.DlpService/ListRootCategories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRootCategoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRootCategoriesResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable;
  private final UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable;
  private final UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable;
  private final UnaryCallable<AnalyzeDataSourceRiskRequest, Operation>
      analyzeDataSourceRiskCallable;
  private final OperationCallable<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationCallable;
  private final UnaryCallable<CreateInspectOperationRequest, Operation>
      createInspectOperationCallable;
  private final OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationCallable;
  private final UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable;
  private final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable;
  private final UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDlpServiceStub create(DlpServiceStubSettings settings)
      throws IOException {
    return new GrpcDlpServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDlpServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcDlpServiceStub(DlpServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDlpServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDlpServiceStub(
        DlpServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDlpServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDlpServiceStub(DlpServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDlpServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDlpServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDlpServiceStub(
      DlpServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<InspectContentRequest, InspectContentResponse>
        inspectContentTransportSettings =
            GrpcCallSettings.<InspectContentRequest, InspectContentResponse>newBuilder()
                .setMethodDescriptor(inspectContentMethodDescriptor)
                .build();
    GrpcCallSettings<RedactContentRequest, RedactContentResponse> redactContentTransportSettings =
        GrpcCallSettings.<RedactContentRequest, RedactContentResponse>newBuilder()
            .setMethodDescriptor(redactContentMethodDescriptor)
            .build();
    GrpcCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentTransportSettings =
            GrpcCallSettings.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
                .setMethodDescriptor(deidentifyContentMethodDescriptor)
                .build();
    GrpcCallSettings<AnalyzeDataSourceRiskRequest, Operation>
        analyzeDataSourceRiskTransportSettings =
            GrpcCallSettings.<AnalyzeDataSourceRiskRequest, Operation>newBuilder()
                .setMethodDescriptor(analyzeDataSourceRiskMethodDescriptor)
                .build();
    GrpcCallSettings<CreateInspectOperationRequest, Operation>
        createInspectOperationTransportSettings =
            GrpcCallSettings.<CreateInspectOperationRequest, Operation>newBuilder()
                .setMethodDescriptor(createInspectOperationMethodDescriptor)
                .build();
    GrpcCallSettings<ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsTransportSettings =
            GrpcCallSettings.<ListInspectFindingsRequest, ListInspectFindingsResponse>newBuilder()
                .setMethodDescriptor(listInspectFindingsMethodDescriptor)
                .build();
    GrpcCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesTransportSettings =
        GrpcCallSettings.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
            .setMethodDescriptor(listInfoTypesMethodDescriptor)
            .build();
    GrpcCallSettings<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesTransportSettings =
            GrpcCallSettings.<ListRootCategoriesRequest, ListRootCategoriesResponse>newBuilder()
                .setMethodDescriptor(listRootCategoriesMethodDescriptor)
                .build();

    this.inspectContentCallable =
        callableFactory.createUnaryCallable(
            inspectContentTransportSettings, settings.inspectContentSettings(), clientContext);
    this.redactContentCallable =
        callableFactory.createUnaryCallable(
            redactContentTransportSettings, settings.redactContentSettings(), clientContext);
    this.deidentifyContentCallable =
        callableFactory.createUnaryCallable(
            deidentifyContentTransportSettings,
            settings.deidentifyContentSettings(),
            clientContext);
    this.analyzeDataSourceRiskCallable =
        callableFactory.createUnaryCallable(
            analyzeDataSourceRiskTransportSettings,
            settings.analyzeDataSourceRiskSettings(),
            clientContext);
    this.analyzeDataSourceRiskOperationCallable =
        callableFactory.createOperationCallable(
            analyzeDataSourceRiskTransportSettings,
            settings.analyzeDataSourceRiskOperationSettings(),
            clientContext,
            this.operationsStub);
    this.createInspectOperationCallable =
        callableFactory.createUnaryCallable(
            createInspectOperationTransportSettings,
            settings.createInspectOperationSettings(),
            clientContext);
    this.createInspectOperationOperationCallable =
        callableFactory.createOperationCallable(
            createInspectOperationTransportSettings,
            settings.createInspectOperationOperationSettings(),
            clientContext,
            this.operationsStub);
    this.listInspectFindingsCallable =
        callableFactory.createUnaryCallable(
            listInspectFindingsTransportSettings,
            settings.listInspectFindingsSettings(),
            clientContext);
    this.listInfoTypesCallable =
        callableFactory.createUnaryCallable(
            listInfoTypesTransportSettings, settings.listInfoTypesSettings(), clientContext);
    this.listRootCategoriesCallable =
        callableFactory.createUnaryCallable(
            listRootCategoriesTransportSettings,
            settings.listRootCategoriesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable() {
    return inspectContentCallable;
  }

  public UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable() {
    return redactContentCallable;
  }

  public UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    return deidentifyContentCallable;
  }

  public OperationCallable<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationCallable() {
    return analyzeDataSourceRiskOperationCallable;
  }

  public UnaryCallable<AnalyzeDataSourceRiskRequest, Operation> analyzeDataSourceRiskCallable() {
    return analyzeDataSourceRiskCallable;
  }

  public OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationCallable() {
    return createInspectOperationOperationCallable;
  }

  public UnaryCallable<CreateInspectOperationRequest, Operation> createInspectOperationCallable() {
    return createInspectOperationCallable;
  }

  public UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable() {
    return listInspectFindingsCallable;
  }

  public UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return listInfoTypesCallable;
  }

  public UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable() {
    return listRootCategoriesCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
