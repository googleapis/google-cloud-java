/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCasesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.BatchDeleteTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.CalculateCoverageRequest;
import com.google.cloud.dialogflow.cx.v3.CalculateCoverageResponse;
import com.google.cloud.dialogflow.cx.v3.CreateTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.GetTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsResponse;
import com.google.cloud.dialogflow.cx.v3.ListTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseMetadata;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseResponse;
import com.google.cloud.dialogflow.cx.v3.TestCase;
import com.google.cloud.dialogflow.cx.v3.UpdateTestCaseRequest;
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
 * gRPC stub implementation for the TestCases service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTestCasesStub extends TestCasesStub {
  private static final MethodDescriptor<ListTestCasesRequest, ListTestCasesResponse>
      listTestCasesMethodDescriptor =
          MethodDescriptor.<ListTestCasesRequest, ListTestCasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/ListTestCases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTestCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTestCasesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteTestCasesRequest, Empty>
      batchDeleteTestCasesMethodDescriptor =
          MethodDescriptor.<BatchDeleteTestCasesRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/BatchDeleteTestCases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteTestCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTestCaseRequest, TestCase> getTestCaseMethodDescriptor =
      MethodDescriptor.<GetTestCaseRequest, TestCase>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/GetTestCase")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTestCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TestCase.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTestCaseRequest, TestCase>
      createTestCaseMethodDescriptor =
          MethodDescriptor.<CreateTestCaseRequest, TestCase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/CreateTestCase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTestCaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TestCase.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTestCaseRequest, TestCase>
      updateTestCaseMethodDescriptor =
          MethodDescriptor.<UpdateTestCaseRequest, TestCase>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/UpdateTestCase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTestCaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TestCase.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunTestCaseRequest, Operation> runTestCaseMethodDescriptor =
      MethodDescriptor.<RunTestCaseRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/RunTestCase")
          .setRequestMarshaller(ProtoUtils.marshaller(RunTestCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchRunTestCasesRequest, Operation>
      batchRunTestCasesMethodDescriptor =
          MethodDescriptor.<BatchRunTestCasesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/BatchRunTestCases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRunTestCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageMethodDescriptor =
          MethodDescriptor.<CalculateCoverageRequest, CalculateCoverageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/CalculateCoverage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CalculateCoverageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CalculateCoverageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportTestCasesRequest, Operation>
      importTestCasesMethodDescriptor =
          MethodDescriptor.<ImportTestCasesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/ImportTestCases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportTestCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportTestCasesRequest, Operation>
      exportTestCasesMethodDescriptor =
          MethodDescriptor.<ExportTestCasesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/ExportTestCases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportTestCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsMethodDescriptor =
          MethodDescriptor.<ListTestCaseResultsRequest, ListTestCaseResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.TestCases/ListTestCaseResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTestCaseResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTestCaseResultsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> listTestCasesCallable;
  private final UnaryCallable<ListTestCasesRequest, ListTestCasesPagedResponse>
      listTestCasesPagedCallable;
  private final UnaryCallable<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesCallable;
  private final UnaryCallable<GetTestCaseRequest, TestCase> getTestCaseCallable;
  private final UnaryCallable<CreateTestCaseRequest, TestCase> createTestCaseCallable;
  private final UnaryCallable<UpdateTestCaseRequest, TestCase> updateTestCaseCallable;
  private final UnaryCallable<RunTestCaseRequest, Operation> runTestCaseCallable;
  private final OperationCallable<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationCallable;
  private final UnaryCallable<BatchRunTestCasesRequest, Operation> batchRunTestCasesCallable;
  private final OperationCallable<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationCallable;
  private final UnaryCallable<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageCallable;
  private final UnaryCallable<ImportTestCasesRequest, Operation> importTestCasesCallable;
  private final OperationCallable<
          ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationCallable;
  private final UnaryCallable<ExportTestCasesRequest, Operation> exportTestCasesCallable;
  private final OperationCallable<
          ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationCallable;
  private final UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsCallable;
  private final UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsPagedResponse>
      listTestCaseResultsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTestCasesStub create(TestCasesStubSettings settings) throws IOException {
    return new GrpcTestCasesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTestCasesStub create(ClientContext clientContext) throws IOException {
    return new GrpcTestCasesStub(TestCasesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTestCasesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTestCasesStub(
        TestCasesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTestCasesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTestCasesStub(TestCasesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTestCasesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTestCasesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTestCasesStub(
      TestCasesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListTestCasesRequest, ListTestCasesResponse> listTestCasesTransportSettings =
        GrpcCallSettings.<ListTestCasesRequest, ListTestCasesResponse>newBuilder()
            .setMethodDescriptor(listTestCasesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTestCasesRequest>() {
                  @Override
                  public Map<String, String> extract(ListTestCasesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesTransportSettings =
        GrpcCallSettings.<BatchDeleteTestCasesRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteTestCasesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchDeleteTestCasesRequest>() {
                  @Override
                  public Map<String, String> extract(BatchDeleteTestCasesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTestCaseRequest, TestCase> getTestCaseTransportSettings =
        GrpcCallSettings.<GetTestCaseRequest, TestCase>newBuilder()
            .setMethodDescriptor(getTestCaseMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTestCaseRequest>() {
                  @Override
                  public Map<String, String> extract(GetTestCaseRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTestCaseRequest, TestCase> createTestCaseTransportSettings =
        GrpcCallSettings.<CreateTestCaseRequest, TestCase>newBuilder()
            .setMethodDescriptor(createTestCaseMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTestCaseRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTestCaseRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateTestCaseRequest, TestCase> updateTestCaseTransportSettings =
        GrpcCallSettings.<UpdateTestCaseRequest, TestCase>newBuilder()
            .setMethodDescriptor(updateTestCaseMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateTestCaseRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateTestCaseRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("test_case.name", String.valueOf(request.getTestCase().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RunTestCaseRequest, Operation> runTestCaseTransportSettings =
        GrpcCallSettings.<RunTestCaseRequest, Operation>newBuilder()
            .setMethodDescriptor(runTestCaseMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RunTestCaseRequest>() {
                  @Override
                  public Map<String, String> extract(RunTestCaseRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchRunTestCasesRequest, Operation> batchRunTestCasesTransportSettings =
        GrpcCallSettings.<BatchRunTestCasesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchRunTestCasesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchRunTestCasesRequest>() {
                  @Override
                  public Map<String, String> extract(BatchRunTestCasesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CalculateCoverageRequest, CalculateCoverageResponse>
        calculateCoverageTransportSettings =
            GrpcCallSettings.<CalculateCoverageRequest, CalculateCoverageResponse>newBuilder()
                .setMethodDescriptor(calculateCoverageMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CalculateCoverageRequest>() {
                      @Override
                      public Map<String, String> extract(CalculateCoverageRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("agent", String.valueOf(request.getAgent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ImportTestCasesRequest, Operation> importTestCasesTransportSettings =
        GrpcCallSettings.<ImportTestCasesRequest, Operation>newBuilder()
            .setMethodDescriptor(importTestCasesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ImportTestCasesRequest>() {
                  @Override
                  public Map<String, String> extract(ImportTestCasesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportTestCasesRequest, Operation> exportTestCasesTransportSettings =
        GrpcCallSettings.<ExportTestCasesRequest, Operation>newBuilder()
            .setMethodDescriptor(exportTestCasesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportTestCasesRequest>() {
                  @Override
                  public Map<String, String> extract(ExportTestCasesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
        listTestCaseResultsTransportSettings =
            GrpcCallSettings.<ListTestCaseResultsRequest, ListTestCaseResultsResponse>newBuilder()
                .setMethodDescriptor(listTestCaseResultsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListTestCaseResultsRequest>() {
                      @Override
                      public Map<String, String> extract(ListTestCaseResultsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.listTestCasesCallable =
        callableFactory.createUnaryCallable(
            listTestCasesTransportSettings, settings.listTestCasesSettings(), clientContext);
    this.listTestCasesPagedCallable =
        callableFactory.createPagedCallable(
            listTestCasesTransportSettings, settings.listTestCasesSettings(), clientContext);
    this.batchDeleteTestCasesCallable =
        callableFactory.createUnaryCallable(
            batchDeleteTestCasesTransportSettings,
            settings.batchDeleteTestCasesSettings(),
            clientContext);
    this.getTestCaseCallable =
        callableFactory.createUnaryCallable(
            getTestCaseTransportSettings, settings.getTestCaseSettings(), clientContext);
    this.createTestCaseCallable =
        callableFactory.createUnaryCallable(
            createTestCaseTransportSettings, settings.createTestCaseSettings(), clientContext);
    this.updateTestCaseCallable =
        callableFactory.createUnaryCallable(
            updateTestCaseTransportSettings, settings.updateTestCaseSettings(), clientContext);
    this.runTestCaseCallable =
        callableFactory.createUnaryCallable(
            runTestCaseTransportSettings, settings.runTestCaseSettings(), clientContext);
    this.runTestCaseOperationCallable =
        callableFactory.createOperationCallable(
            runTestCaseTransportSettings,
            settings.runTestCaseOperationSettings(),
            clientContext,
            operationsStub);
    this.batchRunTestCasesCallable =
        callableFactory.createUnaryCallable(
            batchRunTestCasesTransportSettings,
            settings.batchRunTestCasesSettings(),
            clientContext);
    this.batchRunTestCasesOperationCallable =
        callableFactory.createOperationCallable(
            batchRunTestCasesTransportSettings,
            settings.batchRunTestCasesOperationSettings(),
            clientContext,
            operationsStub);
    this.calculateCoverageCallable =
        callableFactory.createUnaryCallable(
            calculateCoverageTransportSettings,
            settings.calculateCoverageSettings(),
            clientContext);
    this.importTestCasesCallable =
        callableFactory.createUnaryCallable(
            importTestCasesTransportSettings, settings.importTestCasesSettings(), clientContext);
    this.importTestCasesOperationCallable =
        callableFactory.createOperationCallable(
            importTestCasesTransportSettings,
            settings.importTestCasesOperationSettings(),
            clientContext,
            operationsStub);
    this.exportTestCasesCallable =
        callableFactory.createUnaryCallable(
            exportTestCasesTransportSettings, settings.exportTestCasesSettings(), clientContext);
    this.exportTestCasesOperationCallable =
        callableFactory.createOperationCallable(
            exportTestCasesTransportSettings,
            settings.exportTestCasesOperationSettings(),
            clientContext,
            operationsStub);
    this.listTestCaseResultsCallable =
        callableFactory.createUnaryCallable(
            listTestCaseResultsTransportSettings,
            settings.listTestCaseResultsSettings(),
            clientContext);
    this.listTestCaseResultsPagedCallable =
        callableFactory.createPagedCallable(
            listTestCaseResultsTransportSettings,
            settings.listTestCaseResultsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> listTestCasesCallable() {
    return listTestCasesCallable;
  }

  @Override
  public UnaryCallable<ListTestCasesRequest, ListTestCasesPagedResponse>
      listTestCasesPagedCallable() {
    return listTestCasesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesCallable() {
    return batchDeleteTestCasesCallable;
  }

  @Override
  public UnaryCallable<GetTestCaseRequest, TestCase> getTestCaseCallable() {
    return getTestCaseCallable;
  }

  @Override
  public UnaryCallable<CreateTestCaseRequest, TestCase> createTestCaseCallable() {
    return createTestCaseCallable;
  }

  @Override
  public UnaryCallable<UpdateTestCaseRequest, TestCase> updateTestCaseCallable() {
    return updateTestCaseCallable;
  }

  @Override
  public UnaryCallable<RunTestCaseRequest, Operation> runTestCaseCallable() {
    return runTestCaseCallable;
  }

  @Override
  public OperationCallable<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationCallable() {
    return runTestCaseOperationCallable;
  }

  @Override
  public UnaryCallable<BatchRunTestCasesRequest, Operation> batchRunTestCasesCallable() {
    return batchRunTestCasesCallable;
  }

  @Override
  public OperationCallable<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationCallable() {
    return batchRunTestCasesOperationCallable;
  }

  @Override
  public UnaryCallable<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageCallable() {
    return calculateCoverageCallable;
  }

  @Override
  public UnaryCallable<ImportTestCasesRequest, Operation> importTestCasesCallable() {
    return importTestCasesCallable;
  }

  @Override
  public OperationCallable<ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationCallable() {
    return importTestCasesOperationCallable;
  }

  @Override
  public UnaryCallable<ExportTestCasesRequest, Operation> exportTestCasesCallable() {
    return exportTestCasesCallable;
  }

  @Override
  public OperationCallable<ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationCallable() {
    return exportTestCasesOperationCallable;
  }

  @Override
  public UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsCallable() {
    return listTestCaseResultsCallable;
  }

  @Override
  public UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsPagedResponse>
      listTestCaseResultsPagedCallable() {
    return listTestCaseResultsPagedCallable;
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
