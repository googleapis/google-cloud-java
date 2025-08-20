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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationSlicesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelVersionCheckpointsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelVersionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelServiceClient.ListModelsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.BatchImportEvaluatedAnnotationsRequest;
import com.google.cloud.aiplatform.v1beta1.BatchImportEvaluatedAnnotationsResponse;
import com.google.cloud.aiplatform.v1beta1.BatchImportModelEvaluationSlicesRequest;
import com.google.cloud.aiplatform.v1beta1.BatchImportModelEvaluationSlicesResponse;
import com.google.cloud.aiplatform.v1beta1.CopyModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CopyModelRequest;
import com.google.cloud.aiplatform.v1beta1.CopyModelResponse;
import com.google.cloud.aiplatform.v1beta1.DeleteModelRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelVersionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportModelRequest;
import com.google.cloud.aiplatform.v1beta1.ExportModelResponse;
import com.google.cloud.aiplatform.v1beta1.GetModelEvaluationRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelEvaluationSliceRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelRequest;
import com.google.cloud.aiplatform.v1beta1.ImportModelEvaluationRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationSlicesRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationSlicesResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelEvaluationsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelVersionCheckpointsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelVersionCheckpointsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelVersionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelVersionsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelsResponse;
import com.google.cloud.aiplatform.v1beta1.MergeVersionAliasesRequest;
import com.google.cloud.aiplatform.v1beta1.Model;
import com.google.cloud.aiplatform.v1beta1.ModelEvaluation;
import com.google.cloud.aiplatform.v1beta1.ModelEvaluationSlice;
import com.google.cloud.aiplatform.v1beta1.RecommendSpecRequest;
import com.google.cloud.aiplatform.v1beta1.RecommendSpecResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateExplanationDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateExplanationDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateExplanationDatasetResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateModelRequest;
import com.google.cloud.aiplatform.v1beta1.UploadModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UploadModelRequest;
import com.google.cloud.aiplatform.v1beta1.UploadModelResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcModelServiceStub extends ModelServiceStub {
  private static final MethodDescriptor<UploadModelRequest, Operation> uploadModelMethodDescriptor =
      MethodDescriptor.<UploadModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/UploadModel")
          .setRequestMarshaller(ProtoUtils.marshaller(UploadModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      MethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/GetModel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListModelVersionsRequest, ListModelVersionsResponse>
      listModelVersionsMethodDescriptor =
          MethodDescriptor.<ListModelVersionsRequest, ListModelVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/ListModelVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsResponse>
      listModelVersionCheckpointsMethodDescriptor =
          MethodDescriptor
              .<ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/ListModelVersionCheckpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelVersionCheckpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelVersionCheckpointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateModelRequest, Model> updateModelMethodDescriptor =
      MethodDescriptor.<UpdateModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/UpdateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateExplanationDatasetRequest, Operation>
      updateExplanationDatasetMethodDescriptor =
          MethodDescriptor.<UpdateExplanationDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/UpdateExplanationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExplanationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteModelRequest, Operation> deleteModelMethodDescriptor =
      MethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/DeleteModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteModelVersionRequest, Operation>
      deleteModelVersionMethodDescriptor =
          MethodDescriptor.<DeleteModelVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/DeleteModelVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteModelVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MergeVersionAliasesRequest, Model>
      mergeVersionAliasesMethodDescriptor =
          MethodDescriptor.<MergeVersionAliasesRequest, Model>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/MergeVersionAliases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MergeVersionAliasesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportModelRequest, Operation> exportModelMethodDescriptor =
      MethodDescriptor.<ExportModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/ExportModel")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CopyModelRequest, Operation> copyModelMethodDescriptor =
      MethodDescriptor.<CopyModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/CopyModel")
          .setRequestMarshaller(ProtoUtils.marshaller(CopyModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ImportModelEvaluationRequest, ModelEvaluation>
      importModelEvaluationMethodDescriptor =
          MethodDescriptor.<ImportModelEvaluationRequest, ModelEvaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/ImportModelEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelEvaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
      batchImportModelEvaluationSlicesMethodDescriptor =
          MethodDescriptor
              .<BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/BatchImportModelEvaluationSlices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchImportModelEvaluationSlicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchImportModelEvaluationSlicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
      batchImportEvaluatedAnnotationsMethodDescriptor =
          MethodDescriptor
              .<BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/BatchImportEvaluatedAnnotations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchImportEvaluatedAnnotationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchImportEvaluatedAnnotationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationMethodDescriptor =
          MethodDescriptor.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/GetModelEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelEvaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsMethodDescriptor =
          MethodDescriptor.<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/ListModelEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceMethodDescriptor =
          MethodDescriptor.<GetModelEvaluationSliceRequest, ModelEvaluationSlice>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/GetModelEvaluationSlice")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelEvaluationSliceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ModelEvaluationSlice.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesMethodDescriptor =
          MethodDescriptor
              .<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelService/ListModelEvaluationSlices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationSlicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationSlicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RecommendSpecRequest, RecommendSpecResponse>
      recommendSpecMethodDescriptor =
          MethodDescriptor.<RecommendSpecRequest, RecommendSpecResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.ModelService/RecommendSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RecommendSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RecommendSpecResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<UploadModelRequest, Operation> uploadModelCallable;
  private final OperationCallable<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<ListModelVersionsRequest, ListModelVersionsResponse>
      listModelVersionsCallable;
  private final UnaryCallable<ListModelVersionsRequest, ListModelVersionsPagedResponse>
      listModelVersionsPagedCallable;
  private final UnaryCallable<
          ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsResponse>
      listModelVersionCheckpointsCallable;
  private final UnaryCallable<
          ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsPagedResponse>
      listModelVersionCheckpointsPagedCallable;
  private final UnaryCallable<UpdateModelRequest, Model> updateModelCallable;
  private final UnaryCallable<UpdateExplanationDatasetRequest, Operation>
      updateExplanationDatasetCallable;
  private final OperationCallable<
          UpdateExplanationDatasetRequest,
          UpdateExplanationDatasetResponse,
          UpdateExplanationDatasetOperationMetadata>
      updateExplanationDatasetOperationCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationCallable;
  private final UnaryCallable<DeleteModelVersionRequest, Operation> deleteModelVersionCallable;
  private final OperationCallable<DeleteModelVersionRequest, Empty, DeleteOperationMetadata>
      deleteModelVersionOperationCallable;
  private final UnaryCallable<MergeVersionAliasesRequest, Model> mergeVersionAliasesCallable;
  private final UnaryCallable<ExportModelRequest, Operation> exportModelCallable;
  private final OperationCallable<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationCallable;
  private final UnaryCallable<CopyModelRequest, Operation> copyModelCallable;
  private final OperationCallable<CopyModelRequest, CopyModelResponse, CopyModelOperationMetadata>
      copyModelOperationCallable;
  private final UnaryCallable<ImportModelEvaluationRequest, ModelEvaluation>
      importModelEvaluationCallable;
  private final UnaryCallable<
          BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
      batchImportModelEvaluationSlicesCallable;
  private final UnaryCallable<
          BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
      batchImportEvaluatedAnnotationsCallable;
  private final UnaryCallable<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationCallable;
  private final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable;
  private final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable;
  private final UnaryCallable<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceCallable;
  private final UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesCallable;
  private final UnaryCallable<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesPagedCallable;
  private final UnaryCallable<RecommendSpecRequest, RecommendSpecResponse> recommendSpecCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcModelServiceStub create(ModelServiceStubSettings settings)
      throws IOException {
    return new GrpcModelServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcModelServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcModelServiceStub(ModelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcModelServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcModelServiceStub(
        ModelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(ModelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcModelServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(
      ModelServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<UploadModelRequest, Operation> uploadModelTransportSettings =
        GrpcCallSettings.<UploadModelRequest, Operation>newBuilder()
            .setMethodDescriptor(uploadModelMethodDescriptor)
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
    GrpcCallSettings<ListModelVersionsRequest, ListModelVersionsResponse>
        listModelVersionsTransportSettings =
            GrpcCallSettings.<ListModelVersionsRequest, ListModelVersionsResponse>newBuilder()
                .setMethodDescriptor(listModelVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsResponse>
        listModelVersionCheckpointsTransportSettings =
            GrpcCallSettings
                .<ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsResponse>
                    newBuilder()
                .setMethodDescriptor(listModelVersionCheckpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateModelRequest, Model> updateModelTransportSettings =
        GrpcCallSettings.<UpdateModelRequest, Model>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model.name", String.valueOf(request.getModel().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateExplanationDatasetRequest, Operation>
        updateExplanationDatasetTransportSettings =
            GrpcCallSettings.<UpdateExplanationDatasetRequest, Operation>newBuilder()
                .setMethodDescriptor(updateExplanationDatasetMethodDescriptor)
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
    GrpcCallSettings<DeleteModelVersionRequest, Operation> deleteModelVersionTransportSettings =
        GrpcCallSettings.<DeleteModelVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MergeVersionAliasesRequest, Model> mergeVersionAliasesTransportSettings =
        GrpcCallSettings.<MergeVersionAliasesRequest, Model>newBuilder()
            .setMethodDescriptor(mergeVersionAliasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportModelRequest, Operation> exportModelTransportSettings =
        GrpcCallSettings.<ExportModelRequest, Operation>newBuilder()
            .setMethodDescriptor(exportModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CopyModelRequest, Operation> copyModelTransportSettings =
        GrpcCallSettings.<CopyModelRequest, Operation>newBuilder()
            .setMethodDescriptor(copyModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportModelEvaluationRequest, ModelEvaluation>
        importModelEvaluationTransportSettings =
            GrpcCallSettings.<ImportModelEvaluationRequest, ModelEvaluation>newBuilder()
                .setMethodDescriptor(importModelEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
        batchImportModelEvaluationSlicesTransportSettings =
            GrpcCallSettings
                .<BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
                    newBuilder()
                .setMethodDescriptor(batchImportModelEvaluationSlicesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
        batchImportEvaluatedAnnotationsTransportSettings =
            GrpcCallSettings
                .<BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
                    newBuilder()
                .setMethodDescriptor(batchImportEvaluatedAnnotationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationTransportSettings =
            GrpcCallSettings.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
                .setMethodDescriptor(getModelEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
        listModelEvaluationsTransportSettings =
            GrpcCallSettings.<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listModelEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
        getModelEvaluationSliceTransportSettings =
            GrpcCallSettings.<GetModelEvaluationSliceRequest, ModelEvaluationSlice>newBuilder()
                .setMethodDescriptor(getModelEvaluationSliceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
        listModelEvaluationSlicesTransportSettings =
            GrpcCallSettings
                .<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>newBuilder()
                .setMethodDescriptor(listModelEvaluationSlicesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RecommendSpecRequest, RecommendSpecResponse> recommendSpecTransportSettings =
        GrpcCallSettings.<RecommendSpecRequest, RecommendSpecResponse>newBuilder()
            .setMethodDescriptor(recommendSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.uploadModelCallable =
        callableFactory.createUnaryCallable(
            uploadModelTransportSettings, settings.uploadModelSettings(), clientContext);
    this.uploadModelOperationCallable =
        callableFactory.createOperationCallable(
            uploadModelTransportSettings,
            settings.uploadModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelVersionsCallable =
        callableFactory.createUnaryCallable(
            listModelVersionsTransportSettings,
            settings.listModelVersionsSettings(),
            clientContext);
    this.listModelVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listModelVersionsTransportSettings,
            settings.listModelVersionsSettings(),
            clientContext);
    this.listModelVersionCheckpointsCallable =
        callableFactory.createUnaryCallable(
            listModelVersionCheckpointsTransportSettings,
            settings.listModelVersionCheckpointsSettings(),
            clientContext);
    this.listModelVersionCheckpointsPagedCallable =
        callableFactory.createPagedCallable(
            listModelVersionCheckpointsTransportSettings,
            settings.listModelVersionCheckpointsSettings(),
            clientContext);
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
    this.updateExplanationDatasetCallable =
        callableFactory.createUnaryCallable(
            updateExplanationDatasetTransportSettings,
            settings.updateExplanationDatasetSettings(),
            clientContext);
    this.updateExplanationDatasetOperationCallable =
        callableFactory.createOperationCallable(
            updateExplanationDatasetTransportSettings,
            settings.updateExplanationDatasetOperationSettings(),
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
    this.deleteModelVersionCallable =
        callableFactory.createUnaryCallable(
            deleteModelVersionTransportSettings,
            settings.deleteModelVersionSettings(),
            clientContext);
    this.deleteModelVersionOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelVersionTransportSettings,
            settings.deleteModelVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.mergeVersionAliasesCallable =
        callableFactory.createUnaryCallable(
            mergeVersionAliasesTransportSettings,
            settings.mergeVersionAliasesSettings(),
            clientContext);
    this.exportModelCallable =
        callableFactory.createUnaryCallable(
            exportModelTransportSettings, settings.exportModelSettings(), clientContext);
    this.exportModelOperationCallable =
        callableFactory.createOperationCallable(
            exportModelTransportSettings,
            settings.exportModelOperationSettings(),
            clientContext,
            operationsStub);
    this.copyModelCallable =
        callableFactory.createUnaryCallable(
            copyModelTransportSettings, settings.copyModelSettings(), clientContext);
    this.copyModelOperationCallable =
        callableFactory.createOperationCallable(
            copyModelTransportSettings,
            settings.copyModelOperationSettings(),
            clientContext,
            operationsStub);
    this.importModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            importModelEvaluationTransportSettings,
            settings.importModelEvaluationSettings(),
            clientContext);
    this.batchImportModelEvaluationSlicesCallable =
        callableFactory.createUnaryCallable(
            batchImportModelEvaluationSlicesTransportSettings,
            settings.batchImportModelEvaluationSlicesSettings(),
            clientContext);
    this.batchImportEvaluatedAnnotationsCallable =
        callableFactory.createUnaryCallable(
            batchImportEvaluatedAnnotationsTransportSettings,
            settings.batchImportEvaluatedAnnotationsSettings(),
            clientContext);
    this.getModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            getModelEvaluationTransportSettings,
            settings.getModelEvaluationSettings(),
            clientContext);
    this.listModelEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listModelEvaluationsTransportSettings,
            settings.listModelEvaluationsSettings(),
            clientContext);
    this.listModelEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listModelEvaluationsTransportSettings,
            settings.listModelEvaluationsSettings(),
            clientContext);
    this.getModelEvaluationSliceCallable =
        callableFactory.createUnaryCallable(
            getModelEvaluationSliceTransportSettings,
            settings.getModelEvaluationSliceSettings(),
            clientContext);
    this.listModelEvaluationSlicesCallable =
        callableFactory.createUnaryCallable(
            listModelEvaluationSlicesTransportSettings,
            settings.listModelEvaluationSlicesSettings(),
            clientContext);
    this.listModelEvaluationSlicesPagedCallable =
        callableFactory.createPagedCallable(
            listModelEvaluationSlicesTransportSettings,
            settings.listModelEvaluationSlicesSettings(),
            clientContext);
    this.recommendSpecCallable =
        callableFactory.createUnaryCallable(
            recommendSpecTransportSettings, settings.recommendSpecSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<UploadModelRequest, Operation> uploadModelCallable() {
    return uploadModelCallable;
  }

  @Override
  public OperationCallable<UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationCallable() {
    return uploadModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
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
  public UnaryCallable<ListModelVersionsRequest, ListModelVersionsResponse>
      listModelVersionsCallable() {
    return listModelVersionsCallable;
  }

  @Override
  public UnaryCallable<ListModelVersionsRequest, ListModelVersionsPagedResponse>
      listModelVersionsPagedCallable() {
    return listModelVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsResponse>
      listModelVersionCheckpointsCallable() {
    return listModelVersionCheckpointsCallable;
  }

  @Override
  public UnaryCallable<ListModelVersionCheckpointsRequest, ListModelVersionCheckpointsPagedResponse>
      listModelVersionCheckpointsPagedCallable() {
    return listModelVersionCheckpointsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return updateModelCallable;
  }

  @Override
  public UnaryCallable<UpdateExplanationDatasetRequest, Operation>
      updateExplanationDatasetCallable() {
    return updateExplanationDatasetCallable;
  }

  @Override
  public OperationCallable<
          UpdateExplanationDatasetRequest,
          UpdateExplanationDatasetResponse,
          UpdateExplanationDatasetOperationMetadata>
      updateExplanationDatasetOperationCallable() {
    return updateExplanationDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return deleteModelCallable;
  }

  @Override
  public OperationCallable<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationCallable() {
    return deleteModelOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteModelVersionRequest, Operation> deleteModelVersionCallable() {
    return deleteModelVersionCallable;
  }

  @Override
  public OperationCallable<DeleteModelVersionRequest, Empty, DeleteOperationMetadata>
      deleteModelVersionOperationCallable() {
    return deleteModelVersionOperationCallable;
  }

  @Override
  public UnaryCallable<MergeVersionAliasesRequest, Model> mergeVersionAliasesCallable() {
    return mergeVersionAliasesCallable;
  }

  @Override
  public UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    return exportModelCallable;
  }

  @Override
  public OperationCallable<ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationCallable() {
    return exportModelOperationCallable;
  }

  @Override
  public UnaryCallable<CopyModelRequest, Operation> copyModelCallable() {
    return copyModelCallable;
  }

  @Override
  public OperationCallable<CopyModelRequest, CopyModelResponse, CopyModelOperationMetadata>
      copyModelOperationCallable() {
    return copyModelOperationCallable;
  }

  @Override
  public UnaryCallable<ImportModelEvaluationRequest, ModelEvaluation>
      importModelEvaluationCallable() {
    return importModelEvaluationCallable;
  }

  @Override
  public UnaryCallable<
          BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
      batchImportModelEvaluationSlicesCallable() {
    return batchImportModelEvaluationSlicesCallable;
  }

  @Override
  public UnaryCallable<
          BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
      batchImportEvaluatedAnnotationsCallable() {
    return batchImportEvaluatedAnnotationsCallable;
  }

  @Override
  public UnaryCallable<GetModelEvaluationRequest, ModelEvaluation> getModelEvaluationCallable() {
    return getModelEvaluationCallable;
  }

  @Override
  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable() {
    return listModelEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable() {
    return listModelEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceCallable() {
    return getModelEvaluationSliceCallable;
  }

  @Override
  public UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesCallable() {
    return listModelEvaluationSlicesCallable;
  }

  @Override
  public UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesPagedCallable() {
    return listModelEvaluationSlicesPagedCallable;
  }

  @Override
  public UnaryCallable<RecommendSpecRequest, RecommendSpecResponse> recommendSpecCallable() {
    return recommendSpecCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
