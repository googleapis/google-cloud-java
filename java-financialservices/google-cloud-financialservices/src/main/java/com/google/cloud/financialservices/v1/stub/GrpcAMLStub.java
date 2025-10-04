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

package com.google.cloud.financialservices.v1.stub;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.financialservices.v1.BacktestResult;
import com.google.cloud.financialservices.v1.CreateBacktestResultRequest;
import com.google.cloud.financialservices.v1.CreateDatasetRequest;
import com.google.cloud.financialservices.v1.CreateEngineConfigRequest;
import com.google.cloud.financialservices.v1.CreateInstanceRequest;
import com.google.cloud.financialservices.v1.CreateModelRequest;
import com.google.cloud.financialservices.v1.CreatePredictionResultRequest;
import com.google.cloud.financialservices.v1.Dataset;
import com.google.cloud.financialservices.v1.DeleteBacktestResultRequest;
import com.google.cloud.financialservices.v1.DeleteDatasetRequest;
import com.google.cloud.financialservices.v1.DeleteEngineConfigRequest;
import com.google.cloud.financialservices.v1.DeleteInstanceRequest;
import com.google.cloud.financialservices.v1.DeleteModelRequest;
import com.google.cloud.financialservices.v1.DeletePredictionResultRequest;
import com.google.cloud.financialservices.v1.EngineConfig;
import com.google.cloud.financialservices.v1.EngineVersion;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataResponse;
import com.google.cloud.financialservices.v1.ExportModelMetadataRequest;
import com.google.cloud.financialservices.v1.ExportModelMetadataResponse;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.GetBacktestResultRequest;
import com.google.cloud.financialservices.v1.GetDatasetRequest;
import com.google.cloud.financialservices.v1.GetEngineConfigRequest;
import com.google.cloud.financialservices.v1.GetEngineVersionRequest;
import com.google.cloud.financialservices.v1.GetInstanceRequest;
import com.google.cloud.financialservices.v1.GetModelRequest;
import com.google.cloud.financialservices.v1.GetPredictionResultRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.Instance;
import com.google.cloud.financialservices.v1.ListBacktestResultsRequest;
import com.google.cloud.financialservices.v1.ListBacktestResultsResponse;
import com.google.cloud.financialservices.v1.ListDatasetsRequest;
import com.google.cloud.financialservices.v1.ListDatasetsResponse;
import com.google.cloud.financialservices.v1.ListEngineConfigsRequest;
import com.google.cloud.financialservices.v1.ListEngineConfigsResponse;
import com.google.cloud.financialservices.v1.ListEngineVersionsRequest;
import com.google.cloud.financialservices.v1.ListEngineVersionsResponse;
import com.google.cloud.financialservices.v1.ListInstancesRequest;
import com.google.cloud.financialservices.v1.ListInstancesResponse;
import com.google.cloud.financialservices.v1.ListModelsRequest;
import com.google.cloud.financialservices.v1.ListModelsResponse;
import com.google.cloud.financialservices.v1.ListPredictionResultsRequest;
import com.google.cloud.financialservices.v1.ListPredictionResultsResponse;
import com.google.cloud.financialservices.v1.Model;
import com.google.cloud.financialservices.v1.OperationMetadata;
import com.google.cloud.financialservices.v1.PredictionResult;
import com.google.cloud.financialservices.v1.UpdateBacktestResultRequest;
import com.google.cloud.financialservices.v1.UpdateDatasetRequest;
import com.google.cloud.financialservices.v1.UpdateEngineConfigRequest;
import com.google.cloud.financialservices.v1.UpdateInstanceRequest;
import com.google.cloud.financialservices.v1.UpdateModelRequest;
import com.google.cloud.financialservices.v1.UpdatePredictionResultRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AML service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAMLStub extends AMLStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.financialservices.v1.AML/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesMethodDescriptor =
          MethodDescriptor.<ImportRegisteredPartiesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ImportRegisteredParties")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportRegisteredPartiesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesMethodDescriptor =
          MethodDescriptor.<ExportRegisteredPartiesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ExportRegisteredParties")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportRegisteredPartiesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.financialservices.v1.AML/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDatasetRequest, Operation>
      updateDatasetMethodDescriptor =
          MethodDescriptor.<UpdateDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          MethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      MethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.financialservices.v1.AML/GetModel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateModelRequest, Operation> createModelMethodDescriptor =
      MethodDescriptor.<CreateModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.financialservices.v1.AML/CreateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateModelRequest, Operation> updateModelMethodDescriptor =
      MethodDescriptor.<UpdateModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ExportModelMetadataRequest, Operation>
      exportModelMetadataMethodDescriptor =
          MethodDescriptor.<ExportModelMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ExportModelMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportModelMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteModelRequest, Operation> deleteModelMethodDescriptor =
      MethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsMethodDescriptor =
          MethodDescriptor.<ListEngineConfigsRequest, ListEngineConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListEngineConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEngineConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEngineConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEngineConfigRequest, EngineConfig>
      getEngineConfigMethodDescriptor =
          MethodDescriptor.<GetEngineConfigRequest, EngineConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetEngineConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEngineConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EngineConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEngineConfigRequest, Operation>
      createEngineConfigMethodDescriptor =
          MethodDescriptor.<CreateEngineConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateEngineConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEngineConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEngineConfigRequest, Operation>
      updateEngineConfigMethodDescriptor =
          MethodDescriptor.<UpdateEngineConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateEngineConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEngineConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataMethodDescriptor =
          MethodDescriptor.<ExportEngineConfigMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ExportEngineConfigMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportEngineConfigMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEngineConfigRequest, Operation>
      deleteEngineConfigMethodDescriptor =
          MethodDescriptor.<DeleteEngineConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteEngineConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEngineConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEngineVersionRequest, EngineVersion>
      getEngineVersionMethodDescriptor =
          MethodDescriptor.<GetEngineVersionRequest, EngineVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetEngineVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEngineVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EngineVersion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsMethodDescriptor =
          MethodDescriptor.<ListEngineVersionsRequest, ListEngineVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListEngineVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEngineVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEngineVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsMethodDescriptor =
          MethodDescriptor.<ListPredictionResultsRequest, ListPredictionResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListPredictionResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPredictionResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPredictionResultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPredictionResultRequest, PredictionResult>
      getPredictionResultMethodDescriptor =
          MethodDescriptor.<GetPredictionResultRequest, PredictionResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetPredictionResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPredictionResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PredictionResult.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePredictionResultRequest, Operation>
      createPredictionResultMethodDescriptor =
          MethodDescriptor.<CreatePredictionResultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreatePredictionResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePredictionResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePredictionResultRequest, Operation>
      updatePredictionResultMethodDescriptor =
          MethodDescriptor.<UpdatePredictionResultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdatePredictionResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePredictionResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataMethodDescriptor =
          MethodDescriptor.<ExportPredictionResultMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.financialservices.v1.AML/ExportPredictionResultMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportPredictionResultMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePredictionResultRequest, Operation>
      deletePredictionResultMethodDescriptor =
          MethodDescriptor.<DeletePredictionResultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeletePredictionResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePredictionResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsMethodDescriptor =
          MethodDescriptor.<ListBacktestResultsRequest, ListBacktestResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListBacktestResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBacktestResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBacktestResultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBacktestResultRequest, BacktestResult>
      getBacktestResultMethodDescriptor =
          MethodDescriptor.<GetBacktestResultRequest, BacktestResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetBacktestResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBacktestResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BacktestResult.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBacktestResultRequest, Operation>
      createBacktestResultMethodDescriptor =
          MethodDescriptor.<CreateBacktestResultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateBacktestResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBacktestResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBacktestResultRequest, Operation>
      updateBacktestResultMethodDescriptor =
          MethodDescriptor.<UpdateBacktestResultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateBacktestResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBacktestResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataMethodDescriptor =
          MethodDescriptor.<ExportBacktestResultMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.financialservices.v1.AML/ExportBacktestResultMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportBacktestResultMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBacktestResultRequest, Operation>
      deleteBacktestResultMethodDescriptor =
          MethodDescriptor.<DeleteBacktestResultRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteBacktestResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBacktestResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesCallable;
  private final OperationCallable<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationCallable;
  private final UnaryCallable<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesCallable;
  private final OperationCallable<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable;
  private final OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable;
  private final UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable;
  private final OperationCallable<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationCallable;
  private final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable;
  private final OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable;
  private final UnaryCallable<UpdateModelRequest, Operation> updateModelCallable;
  private final OperationCallable<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationCallable;
  private final UnaryCallable<ExportModelMetadataRequest, Operation> exportModelMetadataCallable;
  private final OperationCallable<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable;
  private final UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsCallable;
  private final UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsPagedResponse>
      listEngineConfigsPagedCallable;
  private final UnaryCallable<GetEngineConfigRequest, EngineConfig> getEngineConfigCallable;
  private final UnaryCallable<CreateEngineConfigRequest, Operation> createEngineConfigCallable;
  private final OperationCallable<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationCallable;
  private final UnaryCallable<UpdateEngineConfigRequest, Operation> updateEngineConfigCallable;
  private final OperationCallable<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationCallable;
  private final UnaryCallable<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataCallable;
  private final OperationCallable<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationCallable;
  private final UnaryCallable<DeleteEngineConfigRequest, Operation> deleteEngineConfigCallable;
  private final OperationCallable<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationCallable;
  private final UnaryCallable<GetEngineVersionRequest, EngineVersion> getEngineVersionCallable;
  private final UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsCallable;
  private final UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsPagedResponse>
      listEngineVersionsPagedCallable;
  private final UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsCallable;
  private final UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsPagedResponse>
      listPredictionResultsPagedCallable;
  private final UnaryCallable<GetPredictionResultRequest, PredictionResult>
      getPredictionResultCallable;
  private final UnaryCallable<CreatePredictionResultRequest, Operation>
      createPredictionResultCallable;
  private final OperationCallable<
          CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationCallable;
  private final UnaryCallable<UpdatePredictionResultRequest, Operation>
      updatePredictionResultCallable;
  private final OperationCallable<
          UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationCallable;
  private final UnaryCallable<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataCallable;
  private final OperationCallable<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationCallable;
  private final UnaryCallable<DeletePredictionResultRequest, Operation>
      deletePredictionResultCallable;
  private final OperationCallable<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationCallable;
  private final UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsCallable;
  private final UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsPagedResponse>
      listBacktestResultsPagedCallable;
  private final UnaryCallable<GetBacktestResultRequest, BacktestResult> getBacktestResultCallable;
  private final UnaryCallable<CreateBacktestResultRequest, Operation> createBacktestResultCallable;
  private final OperationCallable<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationCallable;
  private final UnaryCallable<UpdateBacktestResultRequest, Operation> updateBacktestResultCallable;
  private final OperationCallable<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationCallable;
  private final UnaryCallable<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataCallable;
  private final OperationCallable<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationCallable;
  private final UnaryCallable<DeleteBacktestResultRequest, Operation> deleteBacktestResultCallable;
  private final OperationCallable<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAMLStub create(AMLStubSettings settings) throws IOException {
    return new GrpcAMLStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAMLStub create(ClientContext clientContext) throws IOException {
    return new GrpcAMLStub(AMLStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAMLStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAMLStub(AMLStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAMLStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAMLStub(AMLStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAMLCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAMLStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAMLStub(
      AMLStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportRegisteredPartiesRequest, Operation>
        importRegisteredPartiesTransportSettings =
            GrpcCallSettings.<ImportRegisteredPartiesRequest, Operation>newBuilder()
                .setMethodDescriptor(importRegisteredPartiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExportRegisteredPartiesRequest, Operation>
        exportRegisteredPartiesTransportSettings =
            GrpcCallSettings.<ExportRegisteredPartiesRequest, Operation>newBuilder()
                .setMethodDescriptor(exportRegisteredPartiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetRequest, Operation> updateDatasetTransportSettings =
        GrpcCallSettings.<UpdateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset.name", String.valueOf(request.getDataset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        GrpcCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetModelRequest, Model> getModelTransportSettings =
        GrpcCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        GrpcCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateModelRequest, Operation> updateModelTransportSettings =
        GrpcCallSettings.<UpdateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model.name", String.valueOf(request.getModel().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportModelMetadataRequest, Operation> exportModelMetadataTransportSettings =
        GrpcCallSettings.<ExportModelMetadataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportModelMetadataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model", String.valueOf(request.getModel()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        GrpcCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEngineConfigsRequest, ListEngineConfigsResponse>
        listEngineConfigsTransportSettings =
            GrpcCallSettings.<ListEngineConfigsRequest, ListEngineConfigsResponse>newBuilder()
                .setMethodDescriptor(listEngineConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEngineConfigRequest, EngineConfig> getEngineConfigTransportSettings =
        GrpcCallSettings.<GetEngineConfigRequest, EngineConfig>newBuilder()
            .setMethodDescriptor(getEngineConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEngineConfigRequest, Operation> createEngineConfigTransportSettings =
        GrpcCallSettings.<CreateEngineConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createEngineConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEngineConfigRequest, Operation> updateEngineConfigTransportSettings =
        GrpcCallSettings.<UpdateEngineConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEngineConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "engine_config.name", String.valueOf(request.getEngineConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportEngineConfigMetadataRequest, Operation>
        exportEngineConfigMetadataTransportSettings =
            GrpcCallSettings.<ExportEngineConfigMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportEngineConfigMetadataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("engine_config", String.valueOf(request.getEngineConfig()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEngineConfigRequest, Operation> deleteEngineConfigTransportSettings =
        GrpcCallSettings.<DeleteEngineConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEngineConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEngineVersionRequest, EngineVersion> getEngineVersionTransportSettings =
        GrpcCallSettings.<GetEngineVersionRequest, EngineVersion>newBuilder()
            .setMethodDescriptor(getEngineVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEngineVersionsRequest, ListEngineVersionsResponse>
        listEngineVersionsTransportSettings =
            GrpcCallSettings.<ListEngineVersionsRequest, ListEngineVersionsResponse>newBuilder()
                .setMethodDescriptor(listEngineVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPredictionResultsRequest, ListPredictionResultsResponse>
        listPredictionResultsTransportSettings =
            GrpcCallSettings
                .<ListPredictionResultsRequest, ListPredictionResultsResponse>newBuilder()
                .setMethodDescriptor(listPredictionResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPredictionResultRequest, PredictionResult>
        getPredictionResultTransportSettings =
            GrpcCallSettings.<GetPredictionResultRequest, PredictionResult>newBuilder()
                .setMethodDescriptor(getPredictionResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreatePredictionResultRequest, Operation>
        createPredictionResultTransportSettings =
            GrpcCallSettings.<CreatePredictionResultRequest, Operation>newBuilder()
                .setMethodDescriptor(createPredictionResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePredictionResultRequest, Operation>
        updatePredictionResultTransportSettings =
            GrpcCallSettings.<UpdatePredictionResultRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePredictionResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "prediction_result.name",
                          String.valueOf(request.getPredictionResult().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExportPredictionResultMetadataRequest, Operation>
        exportPredictionResultMetadataTransportSettings =
            GrpcCallSettings.<ExportPredictionResultMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportPredictionResultMetadataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "prediction_result", String.valueOf(request.getPredictionResult()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePredictionResultRequest, Operation>
        deletePredictionResultTransportSettings =
            GrpcCallSettings.<DeletePredictionResultRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePredictionResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListBacktestResultsRequest, ListBacktestResultsResponse>
        listBacktestResultsTransportSettings =
            GrpcCallSettings.<ListBacktestResultsRequest, ListBacktestResultsResponse>newBuilder()
                .setMethodDescriptor(listBacktestResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBacktestResultRequest, BacktestResult> getBacktestResultTransportSettings =
        GrpcCallSettings.<GetBacktestResultRequest, BacktestResult>newBuilder()
            .setMethodDescriptor(getBacktestResultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBacktestResultRequest, Operation> createBacktestResultTransportSettings =
        GrpcCallSettings.<CreateBacktestResultRequest, Operation>newBuilder()
            .setMethodDescriptor(createBacktestResultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBacktestResultRequest, Operation> updateBacktestResultTransportSettings =
        GrpcCallSettings.<UpdateBacktestResultRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBacktestResultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "backtest_result.name",
                      String.valueOf(request.getBacktestResult().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportBacktestResultMetadataRequest, Operation>
        exportBacktestResultMetadataTransportSettings =
            GrpcCallSettings.<ExportBacktestResultMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportBacktestResultMetadataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("backtest_result", String.valueOf(request.getBacktestResult()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteBacktestResultRequest, Operation> deleteBacktestResultTransportSettings =
        GrpcCallSettings.<DeleteBacktestResultRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBacktestResultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.importRegisteredPartiesCallable =
        callableFactory.createUnaryCallable(
            importRegisteredPartiesTransportSettings,
            settings.importRegisteredPartiesSettings(),
            clientContext);
    this.importRegisteredPartiesOperationCallable =
        callableFactory.createOperationCallable(
            importRegisteredPartiesTransportSettings,
            settings.importRegisteredPartiesOperationSettings(),
            clientContext,
            operationsStub);
    this.exportRegisteredPartiesCallable =
        callableFactory.createUnaryCallable(
            exportRegisteredPartiesTransportSettings,
            settings.exportRegisteredPartiesSettings(),
            clientContext);
    this.exportRegisteredPartiesOperationCallable =
        callableFactory.createOperationCallable(
            exportRegisteredPartiesTransportSettings,
            settings.exportRegisteredPartiesOperationSettings(),
            clientContext,
            operationsStub);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.createDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetTransportSettings,
            settings.createDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDatasetCallable =
        callableFactory.createUnaryCallable(
            updateDatasetTransportSettings, settings.updateDatasetSettings(), clientContext);
    this.updateDatasetOperationCallable =
        callableFactory.createOperationCallable(
            updateDatasetTransportSettings,
            settings.updateDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.deleteDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetTransportSettings,
            settings.deleteDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.createModelCallable =
        callableFactory.createUnaryCallable(
            createModelTransportSettings, settings.createModelSettings(), clientContext);
    this.createModelOperationCallable =
        callableFactory.createOperationCallable(
            createModelTransportSettings,
            settings.createModelOperationSettings(),
            clientContext,
            operationsStub);
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
    this.updateModelOperationCallable =
        callableFactory.createOperationCallable(
            updateModelTransportSettings,
            settings.updateModelOperationSettings(),
            clientContext,
            operationsStub);
    this.exportModelMetadataCallable =
        callableFactory.createUnaryCallable(
            exportModelMetadataTransportSettings,
            settings.exportModelMetadataSettings(),
            clientContext);
    this.exportModelMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportModelMetadataTransportSettings,
            settings.exportModelMetadataOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.deleteModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelTransportSettings,
            settings.deleteModelOperationSettings(),
            clientContext,
            operationsStub);
    this.listEngineConfigsCallable =
        callableFactory.createUnaryCallable(
            listEngineConfigsTransportSettings,
            settings.listEngineConfigsSettings(),
            clientContext);
    this.listEngineConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listEngineConfigsTransportSettings,
            settings.listEngineConfigsSettings(),
            clientContext);
    this.getEngineConfigCallable =
        callableFactory.createUnaryCallable(
            getEngineConfigTransportSettings, settings.getEngineConfigSettings(), clientContext);
    this.createEngineConfigCallable =
        callableFactory.createUnaryCallable(
            createEngineConfigTransportSettings,
            settings.createEngineConfigSettings(),
            clientContext);
    this.createEngineConfigOperationCallable =
        callableFactory.createOperationCallable(
            createEngineConfigTransportSettings,
            settings.createEngineConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEngineConfigCallable =
        callableFactory.createUnaryCallable(
            updateEngineConfigTransportSettings,
            settings.updateEngineConfigSettings(),
            clientContext);
    this.updateEngineConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateEngineConfigTransportSettings,
            settings.updateEngineConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.exportEngineConfigMetadataCallable =
        callableFactory.createUnaryCallable(
            exportEngineConfigMetadataTransportSettings,
            settings.exportEngineConfigMetadataSettings(),
            clientContext);
    this.exportEngineConfigMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportEngineConfigMetadataTransportSettings,
            settings.exportEngineConfigMetadataOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEngineConfigCallable =
        callableFactory.createUnaryCallable(
            deleteEngineConfigTransportSettings,
            settings.deleteEngineConfigSettings(),
            clientContext);
    this.deleteEngineConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteEngineConfigTransportSettings,
            settings.deleteEngineConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.getEngineVersionCallable =
        callableFactory.createUnaryCallable(
            getEngineVersionTransportSettings, settings.getEngineVersionSettings(), clientContext);
    this.listEngineVersionsCallable =
        callableFactory.createUnaryCallable(
            listEngineVersionsTransportSettings,
            settings.listEngineVersionsSettings(),
            clientContext);
    this.listEngineVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listEngineVersionsTransportSettings,
            settings.listEngineVersionsSettings(),
            clientContext);
    this.listPredictionResultsCallable =
        callableFactory.createUnaryCallable(
            listPredictionResultsTransportSettings,
            settings.listPredictionResultsSettings(),
            clientContext);
    this.listPredictionResultsPagedCallable =
        callableFactory.createPagedCallable(
            listPredictionResultsTransportSettings,
            settings.listPredictionResultsSettings(),
            clientContext);
    this.getPredictionResultCallable =
        callableFactory.createUnaryCallable(
            getPredictionResultTransportSettings,
            settings.getPredictionResultSettings(),
            clientContext);
    this.createPredictionResultCallable =
        callableFactory.createUnaryCallable(
            createPredictionResultTransportSettings,
            settings.createPredictionResultSettings(),
            clientContext);
    this.createPredictionResultOperationCallable =
        callableFactory.createOperationCallable(
            createPredictionResultTransportSettings,
            settings.createPredictionResultOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePredictionResultCallable =
        callableFactory.createUnaryCallable(
            updatePredictionResultTransportSettings,
            settings.updatePredictionResultSettings(),
            clientContext);
    this.updatePredictionResultOperationCallable =
        callableFactory.createOperationCallable(
            updatePredictionResultTransportSettings,
            settings.updatePredictionResultOperationSettings(),
            clientContext,
            operationsStub);
    this.exportPredictionResultMetadataCallable =
        callableFactory.createUnaryCallable(
            exportPredictionResultMetadataTransportSettings,
            settings.exportPredictionResultMetadataSettings(),
            clientContext);
    this.exportPredictionResultMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportPredictionResultMetadataTransportSettings,
            settings.exportPredictionResultMetadataOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePredictionResultCallable =
        callableFactory.createUnaryCallable(
            deletePredictionResultTransportSettings,
            settings.deletePredictionResultSettings(),
            clientContext);
    this.deletePredictionResultOperationCallable =
        callableFactory.createOperationCallable(
            deletePredictionResultTransportSettings,
            settings.deletePredictionResultOperationSettings(),
            clientContext,
            operationsStub);
    this.listBacktestResultsCallable =
        callableFactory.createUnaryCallable(
            listBacktestResultsTransportSettings,
            settings.listBacktestResultsSettings(),
            clientContext);
    this.listBacktestResultsPagedCallable =
        callableFactory.createPagedCallable(
            listBacktestResultsTransportSettings,
            settings.listBacktestResultsSettings(),
            clientContext);
    this.getBacktestResultCallable =
        callableFactory.createUnaryCallable(
            getBacktestResultTransportSettings,
            settings.getBacktestResultSettings(),
            clientContext);
    this.createBacktestResultCallable =
        callableFactory.createUnaryCallable(
            createBacktestResultTransportSettings,
            settings.createBacktestResultSettings(),
            clientContext);
    this.createBacktestResultOperationCallable =
        callableFactory.createOperationCallable(
            createBacktestResultTransportSettings,
            settings.createBacktestResultOperationSettings(),
            clientContext,
            operationsStub);
    this.updateBacktestResultCallable =
        callableFactory.createUnaryCallable(
            updateBacktestResultTransportSettings,
            settings.updateBacktestResultSettings(),
            clientContext);
    this.updateBacktestResultOperationCallable =
        callableFactory.createOperationCallable(
            updateBacktestResultTransportSettings,
            settings.updateBacktestResultOperationSettings(),
            clientContext,
            operationsStub);
    this.exportBacktestResultMetadataCallable =
        callableFactory.createUnaryCallable(
            exportBacktestResultMetadataTransportSettings,
            settings.exportBacktestResultMetadataSettings(),
            clientContext);
    this.exportBacktestResultMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportBacktestResultMetadataTransportSettings,
            settings.exportBacktestResultMetadataOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBacktestResultCallable =
        callableFactory.createUnaryCallable(
            deleteBacktestResultTransportSettings,
            settings.deleteBacktestResultSettings(),
            clientContext);
    this.deleteBacktestResultOperationCallable =
        callableFactory.createOperationCallable(
            deleteBacktestResultTransportSettings,
            settings.deleteBacktestResultOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesCallable() {
    return importRegisteredPartiesCallable;
  }

  @Override
  public OperationCallable<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationCallable() {
    return importRegisteredPartiesOperationCallable;
  }

  @Override
  public UnaryCallable<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesCallable() {
    return exportRegisteredPartiesCallable;
  }

  @Override
  public OperationCallable<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationCallable() {
    return exportRegisteredPartiesOperationCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable() {
    return createDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    return updateDatasetCallable;
  }

  @Override
  public OperationCallable<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationCallable() {
    return updateDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable() {
    return deleteDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
  }

  @Override
  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return createModelCallable;
  }

  @Override
  public OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable() {
    return createModelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateModelRequest, Operation> updateModelCallable() {
    return updateModelCallable;
  }

  @Override
  public OperationCallable<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationCallable() {
    return updateModelOperationCallable;
  }

  @Override
  public UnaryCallable<ExportModelMetadataRequest, Operation> exportModelMetadataCallable() {
    return exportModelMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationCallable() {
    return exportModelMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return deleteModelCallable;
  }

  @Override
  public OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable() {
    return deleteModelOperationCallable;
  }

  @Override
  public UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsCallable() {
    return listEngineConfigsCallable;
  }

  @Override
  public UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsPagedResponse>
      listEngineConfigsPagedCallable() {
    return listEngineConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEngineConfigRequest, EngineConfig> getEngineConfigCallable() {
    return getEngineConfigCallable;
  }

  @Override
  public UnaryCallable<CreateEngineConfigRequest, Operation> createEngineConfigCallable() {
    return createEngineConfigCallable;
  }

  @Override
  public OperationCallable<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationCallable() {
    return createEngineConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEngineConfigRequest, Operation> updateEngineConfigCallable() {
    return updateEngineConfigCallable;
  }

  @Override
  public OperationCallable<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationCallable() {
    return updateEngineConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataCallable() {
    return exportEngineConfigMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationCallable() {
    return exportEngineConfigMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEngineConfigRequest, Operation> deleteEngineConfigCallable() {
    return deleteEngineConfigCallable;
  }

  @Override
  public OperationCallable<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationCallable() {
    return deleteEngineConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetEngineVersionRequest, EngineVersion> getEngineVersionCallable() {
    return getEngineVersionCallable;
  }

  @Override
  public UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsCallable() {
    return listEngineVersionsCallable;
  }

  @Override
  public UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsPagedResponse>
      listEngineVersionsPagedCallable() {
    return listEngineVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsCallable() {
    return listPredictionResultsCallable;
  }

  @Override
  public UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsPagedResponse>
      listPredictionResultsPagedCallable() {
    return listPredictionResultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPredictionResultRequest, PredictionResult> getPredictionResultCallable() {
    return getPredictionResultCallable;
  }

  @Override
  public UnaryCallable<CreatePredictionResultRequest, Operation> createPredictionResultCallable() {
    return createPredictionResultCallable;
  }

  @Override
  public OperationCallable<CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationCallable() {
    return createPredictionResultOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePredictionResultRequest, Operation> updatePredictionResultCallable() {
    return updatePredictionResultCallable;
  }

  @Override
  public OperationCallable<UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationCallable() {
    return updatePredictionResultOperationCallable;
  }

  @Override
  public UnaryCallable<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataCallable() {
    return exportPredictionResultMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationCallable() {
    return exportPredictionResultMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePredictionResultRequest, Operation> deletePredictionResultCallable() {
    return deletePredictionResultCallable;
  }

  @Override
  public OperationCallable<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationCallable() {
    return deletePredictionResultOperationCallable;
  }

  @Override
  public UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsCallable() {
    return listBacktestResultsCallable;
  }

  @Override
  public UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsPagedResponse>
      listBacktestResultsPagedCallable() {
    return listBacktestResultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBacktestResultRequest, BacktestResult> getBacktestResultCallable() {
    return getBacktestResultCallable;
  }

  @Override
  public UnaryCallable<CreateBacktestResultRequest, Operation> createBacktestResultCallable() {
    return createBacktestResultCallable;
  }

  @Override
  public OperationCallable<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationCallable() {
    return createBacktestResultOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBacktestResultRequest, Operation> updateBacktestResultCallable() {
    return updateBacktestResultCallable;
  }

  @Override
  public OperationCallable<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationCallable() {
    return updateBacktestResultOperationCallable;
  }

  @Override
  public UnaryCallable<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataCallable() {
    return exportBacktestResultMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationCallable() {
    return exportBacktestResultMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBacktestResultRequest, Operation> deleteBacktestResultCallable() {
    return deleteBacktestResultCallable;
  }

  @Override
  public OperationCallable<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationCallable() {
    return deleteBacktestResultOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
