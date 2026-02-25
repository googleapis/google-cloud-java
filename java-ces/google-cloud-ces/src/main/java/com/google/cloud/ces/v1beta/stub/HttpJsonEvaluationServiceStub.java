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

package com.google.cloud.ces.v1beta.stub;

import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationDatasetsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationExpectationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationRunsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListScheduledEvaluationRunsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.CreateEvaluationRequest;
import com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationRunOperationMetadata;
import com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest;
import com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.Evaluation;
import com.google.cloud.ces.v1beta.EvaluationDataset;
import com.google.cloud.ces.v1beta.EvaluationExpectation;
import com.google.cloud.ces.v1beta.EvaluationResult;
import com.google.cloud.ces.v1beta.EvaluationRun;
import com.google.cloud.ces.v1beta.GenerateEvaluationOperationMetadata;
import com.google.cloud.ces.v1beta.GenerateEvaluationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationResultRequest;
import com.google.cloud.ces.v1beta.GetEvaluationRunRequest;
import com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.ImportEvaluationsOperationMetadata;
import com.google.cloud.ces.v1beta.ImportEvaluationsRequest;
import com.google.cloud.ces.v1beta.ImportEvaluationsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationResultsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationResultsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationRunsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationRunsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationsResponse;
import com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest;
import com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse;
import com.google.cloud.ces.v1beta.RunEvaluationOperationMetadata;
import com.google.cloud.ces.v1beta.RunEvaluationRequest;
import com.google.cloud.ces.v1beta.RunEvaluationResponse;
import com.google.cloud.ces.v1beta.ScheduledEvaluationRun;
import com.google.cloud.ces.v1beta.TestPersonaVoiceRequest;
import com.google.cloud.ces.v1beta.TestPersonaVoiceResponse;
import com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.UpdateEvaluationRequest;
import com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest;
import com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the EvaluationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEvaluationServiceStub extends EvaluationServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(GenerateEvaluationOperationMetadata.getDescriptor())
          .add(RunEvaluationOperationMetadata.getDescriptor())
          .add(ImportEvaluationsOperationMetadata.getDescriptor())
          .add(DeleteEvaluationRunOperationMetadata.getDescriptor())
          .add(Evaluation.getDescriptor())
          .add(ImportEvaluationsResponse.getDescriptor())
          .add(RunEvaluationResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<RunEvaluationRequest, Operation>
      runEvaluationMethodDescriptor =
          ApiMethodDescriptor.<RunEvaluationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/RunEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{app=projects/*/locations/*/apps/*}:runEvaluation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "app", request.getApp());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearApp().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RunEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioMethodDescriptor =
          ApiMethodDescriptor
              .<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/UploadEvaluationAudio")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UploadEvaluationAudioRequest>newBuilder()
                      .setPath(
                          "/v1beta/{app=projects/*/locations/*/apps/*}:uploadEvaluationAudio",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UploadEvaluationAudioRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "app", request.getApp());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UploadEvaluationAudioRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearApp().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UploadEvaluationAudioResponse>newBuilder()
                      .setDefaultInstance(UploadEvaluationAudioResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEvaluationRequest, Evaluation>
      createEvaluationMethodDescriptor =
          ApiMethodDescriptor.<CreateEvaluationRequest, Evaluation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/CreateEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "evaluationId", request.getEvaluationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("evaluation", request.getEvaluation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Evaluation>newBuilder()
                      .setDefaultInstance(Evaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateEvaluationRequest, Operation>
      generateEvaluationMethodDescriptor =
          ApiMethodDescriptor.<GenerateEvaluationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GenerateEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{conversation=projects/*/locations/*/apps/*/conversations/*}:generateEvaluation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "conversation", request.getConversation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearConversation().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GenerateEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportEvaluationsRequest, Operation>
      importEvaluationsMethodDescriptor =
          ApiMethodDescriptor.<ImportEvaluationsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ImportEvaluations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}:importEvaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportEvaluationsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/CreateEvaluationDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEvaluationDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluationDatasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "evaluationDatasetId", request.getEvaluationDatasetId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "evaluationDataset", request.getEvaluationDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationDataset>newBuilder()
                      .setDefaultInstance(EvaluationDataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEvaluationRequest, Evaluation>
      updateEvaluationMethodDescriptor =
          ApiMethodDescriptor.<UpdateEvaluationRequest, Evaluation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/UpdateEvaluation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{evaluation.name=projects/*/locations/*/apps/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "evaluation.name", request.getEvaluation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("evaluation", request.getEvaluation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Evaluation>newBuilder()
                      .setDefaultInstance(Evaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetMethodDescriptor =
          ApiMethodDescriptor.<UpdateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/UpdateEvaluationDataset")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEvaluationDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{evaluationDataset.name=projects/*/locations/*/apps/*/evaluationDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "evaluationDataset.name",
                                request.getEvaluationDataset().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "evaluationDataset", request.getEvaluationDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationDataset>newBuilder()
                      .setDefaultInstance(EvaluationDataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEvaluationRequest, Empty>
      deleteEvaluationMethodDescriptor =
          ApiMethodDescriptor.<DeleteEvaluationRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/DeleteEvaluation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<DeleteEvaluationResultRequest, Empty>
      deleteEvaluationResultMethodDescriptor =
          ApiMethodDescriptor.<DeleteEvaluationResultRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationResult")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEvaluationResultRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluations/*/results/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteEvaluationDatasetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEvaluationDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluationDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<DeleteEvaluationRunRequest, Operation>
      deleteEvaluationRunMethodDescriptor =
          ApiMethodDescriptor.<DeleteEvaluationRunRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationRun")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEvaluationRunRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluationRuns/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationRunRequest> serializer =
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
                  (DeleteEvaluationRunRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetEvaluationRequest, Evaluation>
      getEvaluationMethodDescriptor =
          ApiMethodDescriptor.<GetEvaluationRequest, Evaluation>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Evaluation>newBuilder()
                      .setDefaultInstance(Evaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultMethodDescriptor =
          ApiMethodDescriptor.<GetEvaluationResultRequest, EvaluationResult>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluationResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEvaluationResultRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluations/*/results/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationResult>newBuilder()
                      .setDefaultInstance(EvaluationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetMethodDescriptor =
          ApiMethodDescriptor.<GetEvaluationDatasetRequest, EvaluationDataset>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluationDataset")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEvaluationDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluationDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationDataset>newBuilder()
                      .setDefaultInstance(EvaluationDataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEvaluationRunRequest, EvaluationRun>
      getEvaluationRunMethodDescriptor =
          ApiMethodDescriptor.<GetEvaluationRunRequest, EvaluationRun>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluationRun")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEvaluationRunRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluationRuns/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationRun>newBuilder()
                      .setDefaultInstance(EvaluationRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsMethodDescriptor =
          ApiMethodDescriptor.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "evaluationFilter", request.getEvaluationFilter());
                            serializer.putQueryParam(
                                fields, "evaluationRunFilter", request.getEvaluationRunFilter());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(
                                fields, "lastTenResults", request.getLastTenResults());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEvaluationsResponse>newBuilder()
                      .setDefaultInstance(ListEvaluationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEvaluationResultsRequest, ListEvaluationResultsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluationResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEvaluationResultsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*/evaluations/*}/results",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationResultsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEvaluationResultsResponse>newBuilder()
                      .setDefaultInstance(ListEvaluationResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluationDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEvaluationDatasetsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluationDatasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationDatasetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEvaluationDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListEvaluationDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsMethodDescriptor =
          ApiMethodDescriptor.<ListEvaluationRunsRequest, ListEvaluationRunsResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluationRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEvaluationRunsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluationRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationRunsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEvaluationRunsResponse>newBuilder()
                      .setDefaultInstance(ListEvaluationRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/ListEvaluationExpectations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEvaluationExpectationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluationExpectations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationExpectationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationExpectationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEvaluationExpectationsResponse>newBuilder()
                      .setDefaultInstance(ListEvaluationExpectationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationMethodDescriptor =
          ApiMethodDescriptor.<GetEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/GetEvaluationExpectation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEvaluationExpectationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluationExpectations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationExpectation>newBuilder()
                      .setDefaultInstance(EvaluationExpectation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationMethodDescriptor =
          ApiMethodDescriptor
              .<CreateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/CreateEvaluationExpectation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEvaluationExpectationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/evaluationExpectations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "evaluationExpectationId",
                                request.getEvaluationExpectationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "evaluationExpectation",
                                      request.getEvaluationExpectation(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationExpectation>newBuilder()
                      .setDefaultInstance(EvaluationExpectation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/UpdateEvaluationExpectation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEvaluationExpectationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{evaluationExpectation.name=projects/*/locations/*/apps/*/evaluationExpectations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "evaluationExpectation.name",
                                request.getEvaluationExpectation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "evaluationExpectation",
                                      request.getEvaluationExpectation(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EvaluationExpectation>newBuilder()
                      .setDefaultInstance(EvaluationExpectation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationMethodDescriptor =
          ApiMethodDescriptor.<DeleteEvaluationExpectationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationExpectation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEvaluationExpectationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/evaluationExpectations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationExpectationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<
          CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunMethodDescriptor =
          ApiMethodDescriptor
              .<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/CreateScheduledEvaluationRun")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateScheduledEvaluationRunRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/scheduledEvaluationRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "scheduledEvaluationRunId",
                                request.getScheduledEvaluationRunId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "scheduledEvaluationRun",
                                      request.getScheduledEvaluationRun(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScheduledEvaluationRun>newBuilder()
                      .setDefaultInstance(ScheduledEvaluationRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunMethodDescriptor =
          ApiMethodDescriptor.<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/GetScheduledEvaluationRun")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetScheduledEvaluationRunRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/scheduledEvaluationRuns/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScheduledEvaluationRun>newBuilder()
                      .setDefaultInstance(ScheduledEvaluationRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsMethodDescriptor =
          ApiMethodDescriptor
              .<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/ListScheduledEvaluationRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScheduledEvaluationRunsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/apps/*}/scheduledEvaluationRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScheduledEvaluationRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScheduledEvaluationRunsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListScheduledEvaluationRunsResponse>newBuilder()
                      .setDefaultInstance(ListScheduledEvaluationRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/UpdateScheduledEvaluationRun")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateScheduledEvaluationRunRequest>newBuilder()
                      .setPath(
                          "/v1beta/{scheduledEvaluationRun.name=projects/*/locations/*/apps/*/scheduledEvaluationRuns/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "scheduledEvaluationRun.name",
                                request.getScheduledEvaluationRun().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "scheduledEvaluationRun",
                                      request.getScheduledEvaluationRun(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScheduledEvaluationRun>newBuilder()
                      .setDefaultInstance(ScheduledEvaluationRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunMethodDescriptor =
          ApiMethodDescriptor.<DeleteScheduledEvaluationRunRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/DeleteScheduledEvaluationRun")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteScheduledEvaluationRunRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/apps/*/scheduledEvaluationRuns/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScheduledEvaluationRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceMethodDescriptor =
          ApiMethodDescriptor.<TestPersonaVoiceRequest, TestPersonaVoiceResponse>newBuilder()
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/TestPersonaVoice")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestPersonaVoiceRequest>newBuilder()
                      .setPath(
                          "/v1beta/{app=projects/*/locations/*/apps/*}:testPersonaVoice",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestPersonaVoiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "app", request.getApp());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestPersonaVoiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearApp().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPersonaVoiceResponse>newBuilder()
                      .setDefaultInstance(TestPersonaVoiceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable;
  private final OperationCallable<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationCallable;
  private final UnaryCallable<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioCallable;
  private final UnaryCallable<CreateEvaluationRequest, Evaluation> createEvaluationCallable;
  private final UnaryCallable<GenerateEvaluationRequest, Operation> generateEvaluationCallable;
  private final OperationCallable<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationCallable;
  private final UnaryCallable<ImportEvaluationsRequest, Operation> importEvaluationsCallable;
  private final OperationCallable<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationCallable;
  private final UnaryCallable<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetCallable;
  private final UnaryCallable<UpdateEvaluationRequest, Evaluation> updateEvaluationCallable;
  private final UnaryCallable<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetCallable;
  private final UnaryCallable<DeleteEvaluationRequest, Empty> deleteEvaluationCallable;
  private final UnaryCallable<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultCallable;
  private final UnaryCallable<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetCallable;
  private final UnaryCallable<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunCallable;
  private final OperationCallable<
          DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationCallable;
  private final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable;
  private final UnaryCallable<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultCallable;
  private final UnaryCallable<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetCallable;
  private final UnaryCallable<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable;
  private final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable;
  private final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable;
  private final UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsCallable;
  private final UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsPagedCallable;
  private final UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsCallable;
  private final UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsPagedResponse>
      listEvaluationRunsPagedCallable;
  private final UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsCallable;
  private final UnaryCallable<
          ListEvaluationExpectationsRequest, ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsPagedCallable;
  private final UnaryCallable<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationCallable;
  private final UnaryCallable<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationCallable;
  private final UnaryCallable<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationCallable;
  private final UnaryCallable<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationCallable;
  private final UnaryCallable<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunCallable;
  private final UnaryCallable<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunCallable;
  private final UnaryCallable<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsCallable;
  private final UnaryCallable<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsPagedCallable;
  private final UnaryCallable<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunCallable;
  private final UnaryCallable<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunCallable;
  private final UnaryCallable<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEvaluationServiceStub create(EvaluationServiceStubSettings settings)
      throws IOException {
    return new HttpJsonEvaluationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEvaluationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEvaluationServiceStub(
        EvaluationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEvaluationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEvaluationServiceStub(
        EvaluationServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEvaluationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEvaluationServiceStub(
      EvaluationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonEvaluationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEvaluationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEvaluationServiceStub(
      EvaluationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1beta/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<RunEvaluationRequest, Operation> runEvaluationTransportSettings =
        HttpJsonCallSettings.<RunEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(runEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("app", String.valueOf(request.getApp()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
        uploadEvaluationAudioTransportSettings =
            HttpJsonCallSettings
                .<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>newBuilder()
                .setMethodDescriptor(uploadEvaluationAudioMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("app", String.valueOf(request.getApp()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEvaluationRequest, Evaluation> createEvaluationTransportSettings =
        HttpJsonCallSettings.<CreateEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(createEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateEvaluationRequest, Operation> generateEvaluationTransportSettings =
        HttpJsonCallSettings.<GenerateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(generateEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("conversation", String.valueOf(request.getConversation()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportEvaluationsRequest, Operation> importEvaluationsTransportSettings =
        HttpJsonCallSettings.<ImportEvaluationsRequest, Operation>newBuilder()
            .setMethodDescriptor(importEvaluationsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEvaluationDatasetRequest, EvaluationDataset>
        createEvaluationDatasetTransportSettings =
            HttpJsonCallSettings.<CreateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
                .setMethodDescriptor(createEvaluationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEvaluationRequest, Evaluation> updateEvaluationTransportSettings =
        HttpJsonCallSettings.<UpdateEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(updateEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("evaluation.name", String.valueOf(request.getEvaluation().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEvaluationDatasetRequest, EvaluationDataset>
        updateEvaluationDatasetTransportSettings =
            HttpJsonCallSettings.<UpdateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
                .setMethodDescriptor(updateEvaluationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "evaluation_dataset.name",
                          String.valueOf(request.getEvaluationDataset().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEvaluationRequest, Empty> deleteEvaluationTransportSettings =
        HttpJsonCallSettings.<DeleteEvaluationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEvaluationResultRequest, Empty>
        deleteEvaluationResultTransportSettings =
            HttpJsonCallSettings.<DeleteEvaluationResultRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEvaluationResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEvaluationDatasetRequest, Empty>
        deleteEvaluationDatasetTransportSettings =
            HttpJsonCallSettings.<DeleteEvaluationDatasetRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEvaluationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEvaluationRunRequest, Operation>
        deleteEvaluationRunTransportSettings =
            HttpJsonCallSettings.<DeleteEvaluationRunRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteEvaluationRunMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEvaluationRequest, Evaluation> getEvaluationTransportSettings =
        HttpJsonCallSettings.<GetEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(getEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEvaluationResultRequest, EvaluationResult>
        getEvaluationResultTransportSettings =
            HttpJsonCallSettings.<GetEvaluationResultRequest, EvaluationResult>newBuilder()
                .setMethodDescriptor(getEvaluationResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEvaluationDatasetRequest, EvaluationDataset>
        getEvaluationDatasetTransportSettings =
            HttpJsonCallSettings.<GetEvaluationDatasetRequest, EvaluationDataset>newBuilder()
                .setMethodDescriptor(getEvaluationDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunTransportSettings =
        HttpJsonCallSettings.<GetEvaluationRunRequest, EvaluationRun>newBuilder()
            .setMethodDescriptor(getEvaluationRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEvaluationsRequest, ListEvaluationsResponse>
        listEvaluationsTransportSettings =
            HttpJsonCallSettings.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
        listEvaluationResultsTransportSettings =
            HttpJsonCallSettings
                .<ListEvaluationResultsRequest, ListEvaluationResultsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
        listEvaluationDatasetsTransportSettings =
            HttpJsonCallSettings
                .<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationDatasetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
        listEvaluationRunsTransportSettings =
            HttpJsonCallSettings.<ListEvaluationRunsRequest, ListEvaluationRunsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationRunsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
        listEvaluationExpectationsTransportSettings =
            HttpJsonCallSettings
                .<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationExpectationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEvaluationExpectationRequest, EvaluationExpectation>
        getEvaluationExpectationTransportSettings =
            HttpJsonCallSettings
                .<GetEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
                .setMethodDescriptor(getEvaluationExpectationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEvaluationExpectationRequest, EvaluationExpectation>
        createEvaluationExpectationTransportSettings =
            HttpJsonCallSettings
                .<CreateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
                .setMethodDescriptor(createEvaluationExpectationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEvaluationExpectationRequest, EvaluationExpectation>
        updateEvaluationExpectationTransportSettings =
            HttpJsonCallSettings
                .<UpdateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
                .setMethodDescriptor(updateEvaluationExpectationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "evaluation_expectation.name",
                          String.valueOf(request.getEvaluationExpectation().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEvaluationExpectationRequest, Empty>
        deleteEvaluationExpectationTransportSettings =
            HttpJsonCallSettings.<DeleteEvaluationExpectationRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEvaluationExpectationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        createScheduledEvaluationRunTransportSettings =
            HttpJsonCallSettings
                .<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
                .setMethodDescriptor(createScheduledEvaluationRunMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        getScheduledEvaluationRunTransportSettings =
            HttpJsonCallSettings
                .<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
                .setMethodDescriptor(getScheduledEvaluationRunMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
        listScheduledEvaluationRunsTransportSettings =
            HttpJsonCallSettings
                .<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
                    newBuilder()
                .setMethodDescriptor(listScheduledEvaluationRunsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        updateScheduledEvaluationRunTransportSettings =
            HttpJsonCallSettings
                .<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
                .setMethodDescriptor(updateScheduledEvaluationRunMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "scheduled_evaluation_run.name",
                          String.valueOf(request.getScheduledEvaluationRun().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteScheduledEvaluationRunRequest, Empty>
        deleteScheduledEvaluationRunTransportSettings =
            HttpJsonCallSettings.<DeleteScheduledEvaluationRunRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteScheduledEvaluationRunMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
        testPersonaVoiceTransportSettings =
            HttpJsonCallSettings.<TestPersonaVoiceRequest, TestPersonaVoiceResponse>newBuilder()
                .setMethodDescriptor(testPersonaVoiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("app", String.valueOf(request.getApp()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.runEvaluationCallable =
        callableFactory.createUnaryCallable(
            runEvaluationTransportSettings, settings.runEvaluationSettings(), clientContext);
    this.runEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            runEvaluationTransportSettings,
            settings.runEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.uploadEvaluationAudioCallable =
        callableFactory.createUnaryCallable(
            uploadEvaluationAudioTransportSettings,
            settings.uploadEvaluationAudioSettings(),
            clientContext);
    this.createEvaluationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationTransportSettings, settings.createEvaluationSettings(), clientContext);
    this.generateEvaluationCallable =
        callableFactory.createUnaryCallable(
            generateEvaluationTransportSettings,
            settings.generateEvaluationSettings(),
            clientContext);
    this.generateEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            generateEvaluationTransportSettings,
            settings.generateEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importEvaluationsCallable =
        callableFactory.createUnaryCallable(
            importEvaluationsTransportSettings,
            settings.importEvaluationsSettings(),
            clientContext);
    this.importEvaluationsOperationCallable =
        callableFactory.createOperationCallable(
            importEvaluationsTransportSettings,
            settings.importEvaluationsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            createEvaluationDatasetTransportSettings,
            settings.createEvaluationDatasetSettings(),
            clientContext);
    this.updateEvaluationCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationTransportSettings, settings.updateEvaluationSettings(), clientContext);
    this.updateEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationDatasetTransportSettings,
            settings.updateEvaluationDatasetSettings(),
            clientContext);
    this.deleteEvaluationCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationTransportSettings, settings.deleteEvaluationSettings(), clientContext);
    this.deleteEvaluationResultCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationResultTransportSettings,
            settings.deleteEvaluationResultSettings(),
            clientContext);
    this.deleteEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationDatasetTransportSettings,
            settings.deleteEvaluationDatasetSettings(),
            clientContext);
    this.deleteEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationRunTransportSettings,
            settings.deleteEvaluationRunSettings(),
            clientContext);
    this.deleteEvaluationRunOperationCallable =
        callableFactory.createOperationCallable(
            deleteEvaluationRunTransportSettings,
            settings.deleteEvaluationRunOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getEvaluationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationTransportSettings, settings.getEvaluationSettings(), clientContext);
    this.getEvaluationResultCallable =
        callableFactory.createUnaryCallable(
            getEvaluationResultTransportSettings,
            settings.getEvaluationResultSettings(),
            clientContext);
    this.getEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            getEvaluationDatasetTransportSettings,
            settings.getEvaluationDatasetSettings(),
            clientContext);
    this.getEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            getEvaluationRunTransportSettings, settings.getEvaluationRunSettings(), clientContext);
    this.listEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
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
    this.listEvaluationDatasetsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationDatasetsTransportSettings,
            settings.listEvaluationDatasetsSettings(),
            clientContext);
    this.listEvaluationDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationDatasetsTransportSettings,
            settings.listEvaluationDatasetsSettings(),
            clientContext);
    this.listEvaluationRunsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationRunsTransportSettings,
            settings.listEvaluationRunsSettings(),
            clientContext);
    this.listEvaluationRunsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationRunsTransportSettings,
            settings.listEvaluationRunsSettings(),
            clientContext);
    this.listEvaluationExpectationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationExpectationsTransportSettings,
            settings.listEvaluationExpectationsSettings(),
            clientContext);
    this.listEvaluationExpectationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationExpectationsTransportSettings,
            settings.listEvaluationExpectationsSettings(),
            clientContext);
    this.getEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationExpectationTransportSettings,
            settings.getEvaluationExpectationSettings(),
            clientContext);
    this.createEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationExpectationTransportSettings,
            settings.createEvaluationExpectationSettings(),
            clientContext);
    this.updateEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationExpectationTransportSettings,
            settings.updateEvaluationExpectationSettings(),
            clientContext);
    this.deleteEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationExpectationTransportSettings,
            settings.deleteEvaluationExpectationSettings(),
            clientContext);
    this.createScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            createScheduledEvaluationRunTransportSettings,
            settings.createScheduledEvaluationRunSettings(),
            clientContext);
    this.getScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            getScheduledEvaluationRunTransportSettings,
            settings.getScheduledEvaluationRunSettings(),
            clientContext);
    this.listScheduledEvaluationRunsCallable =
        callableFactory.createUnaryCallable(
            listScheduledEvaluationRunsTransportSettings,
            settings.listScheduledEvaluationRunsSettings(),
            clientContext);
    this.listScheduledEvaluationRunsPagedCallable =
        callableFactory.createPagedCallable(
            listScheduledEvaluationRunsTransportSettings,
            settings.listScheduledEvaluationRunsSettings(),
            clientContext);
    this.updateScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            updateScheduledEvaluationRunTransportSettings,
            settings.updateScheduledEvaluationRunSettings(),
            clientContext);
    this.deleteScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            deleteScheduledEvaluationRunTransportSettings,
            settings.deleteScheduledEvaluationRunSettings(),
            clientContext);
    this.testPersonaVoiceCallable =
        callableFactory.createUnaryCallable(
            testPersonaVoiceTransportSettings, settings.testPersonaVoiceSettings(), clientContext);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(runEvaluationMethodDescriptor);
    methodDescriptors.add(uploadEvaluationAudioMethodDescriptor);
    methodDescriptors.add(createEvaluationMethodDescriptor);
    methodDescriptors.add(generateEvaluationMethodDescriptor);
    methodDescriptors.add(importEvaluationsMethodDescriptor);
    methodDescriptors.add(createEvaluationDatasetMethodDescriptor);
    methodDescriptors.add(updateEvaluationMethodDescriptor);
    methodDescriptors.add(updateEvaluationDatasetMethodDescriptor);
    methodDescriptors.add(deleteEvaluationMethodDescriptor);
    methodDescriptors.add(deleteEvaluationResultMethodDescriptor);
    methodDescriptors.add(deleteEvaluationDatasetMethodDescriptor);
    methodDescriptors.add(deleteEvaluationRunMethodDescriptor);
    methodDescriptors.add(getEvaluationMethodDescriptor);
    methodDescriptors.add(getEvaluationResultMethodDescriptor);
    methodDescriptors.add(getEvaluationDatasetMethodDescriptor);
    methodDescriptors.add(getEvaluationRunMethodDescriptor);
    methodDescriptors.add(listEvaluationsMethodDescriptor);
    methodDescriptors.add(listEvaluationResultsMethodDescriptor);
    methodDescriptors.add(listEvaluationDatasetsMethodDescriptor);
    methodDescriptors.add(listEvaluationRunsMethodDescriptor);
    methodDescriptors.add(listEvaluationExpectationsMethodDescriptor);
    methodDescriptors.add(getEvaluationExpectationMethodDescriptor);
    methodDescriptors.add(createEvaluationExpectationMethodDescriptor);
    methodDescriptors.add(updateEvaluationExpectationMethodDescriptor);
    methodDescriptors.add(deleteEvaluationExpectationMethodDescriptor);
    methodDescriptors.add(createScheduledEvaluationRunMethodDescriptor);
    methodDescriptors.add(getScheduledEvaluationRunMethodDescriptor);
    methodDescriptors.add(listScheduledEvaluationRunsMethodDescriptor);
    methodDescriptors.add(updateScheduledEvaluationRunMethodDescriptor);
    methodDescriptors.add(deleteScheduledEvaluationRunMethodDescriptor);
    methodDescriptors.add(testPersonaVoiceMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    return runEvaluationCallable;
  }

  @Override
  public OperationCallable<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationCallable() {
    return runEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioCallable() {
    return uploadEvaluationAudioCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationRequest, Evaluation> createEvaluationCallable() {
    return createEvaluationCallable;
  }

  @Override
  public UnaryCallable<GenerateEvaluationRequest, Operation> generateEvaluationCallable() {
    return generateEvaluationCallable;
  }

  @Override
  public OperationCallable<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationCallable() {
    return generateEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<ImportEvaluationsRequest, Operation> importEvaluationsCallable() {
    return importEvaluationsCallable;
  }

  @Override
  public OperationCallable<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationCallable() {
    return importEvaluationsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetCallable() {
    return createEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationRequest, Evaluation> updateEvaluationCallable() {
    return updateEvaluationCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetCallable() {
    return updateEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationRequest, Empty> deleteEvaluationCallable() {
    return deleteEvaluationCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultCallable() {
    return deleteEvaluationResultCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationDatasetRequest, Empty> deleteEvaluationDatasetCallable() {
    return deleteEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunCallable() {
    return deleteEvaluationRunCallable;
  }

  @Override
  public OperationCallable<DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationCallable() {
    return deleteEvaluationRunOperationCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return getEvaluationCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationResultRequest, EvaluationResult> getEvaluationResultCallable() {
    return getEvaluationResultCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetCallable() {
    return getEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunCallable() {
    return getEvaluationRunCallable;
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
  public UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsCallable() {
    return listEvaluationDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsPagedCallable() {
    return listEvaluationDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsCallable() {
    return listEvaluationRunsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsPagedResponse>
      listEvaluationRunsPagedCallable() {
    return listEvaluationRunsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsCallable() {
    return listEvaluationExpectationsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsPagedCallable() {
    return listEvaluationExpectationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationCallable() {
    return getEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationCallable() {
    return createEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationCallable() {
    return updateEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationCallable() {
    return deleteEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunCallable() {
    return createScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunCallable() {
    return getScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsCallable() {
    return listScheduledEvaluationRunsCallable;
  }

  @Override
  public UnaryCallable<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsPagedCallable() {
    return listScheduledEvaluationRunsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunCallable() {
    return updateScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunCallable() {
    return deleteScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceCallable() {
    return testPersonaVoiceCallable;
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
