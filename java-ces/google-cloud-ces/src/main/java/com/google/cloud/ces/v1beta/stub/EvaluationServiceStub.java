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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EvaluationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EvaluationServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runEvaluationOperationCallable()");
  }

  public UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: runEvaluationCallable()");
  }

  public UnaryCallable<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadEvaluationAudioCallable()");
  }

  public UnaryCallable<CreateEvaluationRequest, Evaluation> createEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEvaluationCallable()");
  }

  public OperationCallable<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateEvaluationOperationCallable()");
  }

  public UnaryCallable<GenerateEvaluationRequest, Operation> generateEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: generateEvaluationCallable()");
  }

  public OperationCallable<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importEvaluationsOperationCallable()");
  }

  public UnaryCallable<ImportEvaluationsRequest, Operation> importEvaluationsCallable() {
    throw new UnsupportedOperationException("Not implemented: importEvaluationsCallable()");
  }

  public UnaryCallable<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createEvaluationDatasetCallable()");
  }

  public UnaryCallable<UpdateEvaluationRequest, Evaluation> updateEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEvaluationCallable()");
  }

  public UnaryCallable<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEvaluationDatasetCallable()");
  }

  public UnaryCallable<DeleteEvaluationRequest, Empty> deleteEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEvaluationCallable()");
  }

  public UnaryCallable<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEvaluationResultCallable()");
  }

  public UnaryCallable<DeleteEvaluationDatasetRequest, Empty> deleteEvaluationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEvaluationDatasetCallable()");
  }

  public OperationCallable<DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEvaluationRunOperationCallable()");
  }

  public UnaryCallable<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEvaluationRunCallable()");
  }

  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationCallable()");
  }

  public UnaryCallable<GetEvaluationResultRequest, EvaluationResult> getEvaluationResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationResultCallable()");
  }

  public UnaryCallable<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationDatasetCallable()");
  }

  public UnaryCallable<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationRunCallable()");
  }

  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> listEvaluationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationsCallable()");
  }

  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEvaluationResultsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationResultsCallable()");
  }

  public UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEvaluationDatasetsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationDatasetsCallable()");
  }

  public UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsPagedResponse>
      listEvaluationRunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationRunsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationRunsCallable()");
  }

  public UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEvaluationExpectationsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEvaluationExpectationsCallable()");
  }

  public UnaryCallable<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationExpectationCallable()");
  }

  public UnaryCallable<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEvaluationExpectationCallable()");
  }

  public UnaryCallable<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEvaluationExpectationCallable()");
  }

  public UnaryCallable<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEvaluationExpectationCallable()");
  }

  public UnaryCallable<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createScheduledEvaluationRunCallable()");
  }

  public UnaryCallable<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunCallable() {
    throw new UnsupportedOperationException("Not implemented: getScheduledEvaluationRunCallable()");
  }

  public UnaryCallable<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listScheduledEvaluationRunsPagedCallable()");
  }

  public UnaryCallable<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listScheduledEvaluationRunsCallable()");
  }

  public UnaryCallable<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateScheduledEvaluationRunCallable()");
  }

  public UnaryCallable<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteScheduledEvaluationRunCallable()");
  }

  public UnaryCallable<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceCallable() {
    throw new UnsupportedOperationException("Not implemented: testPersonaVoiceCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
