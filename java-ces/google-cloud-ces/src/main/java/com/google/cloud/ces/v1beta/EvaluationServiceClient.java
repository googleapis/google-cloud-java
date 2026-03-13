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

package com.google.cloud.ces.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1beta.stub.EvaluationServiceStub;
import com.google.cloud.ces.v1beta.stub.EvaluationServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: EvaluationService exposes methods to perform evaluation for the CES app.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
 *   AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
 *   ByteString audioContent = ByteString.EMPTY;
 *   UploadEvaluationAudioResponse response =
 *       evaluationServiceClient.uploadEvaluationAudio(app, audioContent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EvaluationServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> RunEvaluation</td>
 *      <td><p> Runs an evaluation of the app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runEvaluationAsync(RunEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> runEvaluationAsync(AppName app)
 *           <li><p> runEvaluationAsync(String app)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runEvaluationOperationCallable()
 *           <li><p> runEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UploadEvaluationAudio</td>
 *      <td><p> Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud Storage bucket defined in 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and returns a transcript.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadEvaluationAudio(UploadEvaluationAudioRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> uploadEvaluationAudio(AppName app, ByteString audioContent)
 *           <li><p> uploadEvaluationAudio(String app, ByteString audioContent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadEvaluationAudioCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvaluation</td>
 *      <td><p> Creates an evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEvaluation(CreateEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEvaluation(AppName parent, Evaluation evaluation)
 *           <li><p> createEvaluation(String parent, Evaluation evaluation)
 *           <li><p> createEvaluation(AppName parent, Evaluation evaluation, String evaluationId)
 *           <li><p> createEvaluation(String parent, Evaluation evaluation, String evaluationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateEvaluation</td>
 *      <td><p> Creates a golden evaluation from a conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateEvaluationAsync(GenerateEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateEvaluationAsync(ConversationName conversation)
 *           <li><p> generateEvaluationAsync(String conversation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateEvaluationOperationCallable()
 *           <li><p> generateEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportEvaluations</td>
 *      <td><p> Imports evaluations into the app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importEvaluationsAsync(ImportEvaluationsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importEvaluationsAsync(AppName parent)
 *           <li><p> importEvaluationsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importEvaluationsOperationCallable()
 *           <li><p> importEvaluationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvaluationDataset</td>
 *      <td><p> Creates an evaluation dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEvaluationDataset(CreateEvaluationDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEvaluationDataset(AppName parent, EvaluationDataset evaluationDataset)
 *           <li><p> createEvaluationDataset(String parent, EvaluationDataset evaluationDataset)
 *           <li><p> createEvaluationDataset(AppName parent, EvaluationDataset evaluationDataset, String evaluationDatasetId)
 *           <li><p> createEvaluationDataset(String parent, EvaluationDataset evaluationDataset, String evaluationDatasetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEvaluationDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEvaluation</td>
 *      <td><p> Updates an evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEvaluation(UpdateEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEvaluation(Evaluation evaluation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEvaluationDataset</td>
 *      <td><p> Updates an evaluation dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEvaluationDataset(UpdateEvaluationDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEvaluationDataset(EvaluationDataset evaluationDataset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEvaluationDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvaluation</td>
 *      <td><p> Deletes an evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvaluation(DeleteEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEvaluation(EvaluationName name)
 *           <li><p> deleteEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvaluationResult</td>
 *      <td><p> Deletes an evaluation result.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvaluationResult(DeleteEvaluationResultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEvaluationResult(EvaluationResultName name)
 *           <li><p> deleteEvaluationResult(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvaluationDataset</td>
 *      <td><p> Deletes an evaluation dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvaluationDataset(DeleteEvaluationDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEvaluationDataset(EvaluationDatasetName name)
 *           <li><p> deleteEvaluationDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvaluationRun</td>
 *      <td><p> Deletes an evaluation run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvaluationRunAsync(DeleteEvaluationRunRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationRunAsync(EvaluationRunName name)
 *           <li><p> deleteEvaluationRunAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationRunOperationCallable()
 *           <li><p> deleteEvaluationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvaluation</td>
 *      <td><p> Gets details of the specified evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluation(GetEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluation(EvaluationName name)
 *           <li><p> getEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvaluationResult</td>
 *      <td><p> Gets details of the specified evaluation result.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluationResult(GetEvaluationResultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluationResult(EvaluationResultName name)
 *           <li><p> getEvaluationResult(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvaluationDataset</td>
 *      <td><p> Gets details of the specified evaluation dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluationDataset(GetEvaluationDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluationDataset(EvaluationDatasetName name)
 *           <li><p> getEvaluationDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvaluationRun</td>
 *      <td><p> Gets details of the specified evaluation run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluationRun(GetEvaluationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluationRun(EvaluationRunName name)
 *           <li><p> getEvaluationRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluations</td>
 *      <td><p> Lists all evaluations in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluations(ListEvaluationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluations(AppName parent)
 *           <li><p> listEvaluations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationsPagedCallable()
 *           <li><p> listEvaluationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluationResults</td>
 *      <td><p> Lists all evaluation results for a given evaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluationResults(ListEvaluationResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluationResults(EvaluationName parent)
 *           <li><p> listEvaluationResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationResultsPagedCallable()
 *           <li><p> listEvaluationResultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluationDatasets</td>
 *      <td><p> Lists all evaluation datasets in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluationDatasets(ListEvaluationDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluationDatasets(AppName parent)
 *           <li><p> listEvaluationDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationDatasetsPagedCallable()
 *           <li><p> listEvaluationDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluationRuns</td>
 *      <td><p> Lists all evaluation runs in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluationRuns(ListEvaluationRunsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluationRuns(AppName parent)
 *           <li><p> listEvaluationRuns(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationRunsPagedCallable()
 *           <li><p> listEvaluationRunsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluationExpectations</td>
 *      <td><p> Lists all evaluation expectations in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluationExpectations(ListEvaluationExpectationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluationExpectations(AppName parent)
 *           <li><p> listEvaluationExpectations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationExpectationsPagedCallable()
 *           <li><p> listEvaluationExpectationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvaluationExpectation</td>
 *      <td><p> Gets details of the specified evaluation expectation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluationExpectation(GetEvaluationExpectationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluationExpectation(EvaluationExpectationName name)
 *           <li><p> getEvaluationExpectation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationExpectationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvaluationExpectation</td>
 *      <td><p> Creates an evaluation expectation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEvaluationExpectation(CreateEvaluationExpectationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEvaluationExpectation(AppName parent, EvaluationExpectation evaluationExpectation)
 *           <li><p> createEvaluationExpectation(String parent, EvaluationExpectation evaluationExpectation)
 *           <li><p> createEvaluationExpectation(AppName parent, EvaluationExpectation evaluationExpectation, String evaluationExpectationId)
 *           <li><p> createEvaluationExpectation(String parent, EvaluationExpectation evaluationExpectation, String evaluationExpectationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEvaluationExpectationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEvaluationExpectation</td>
 *      <td><p> Updates an evaluation expectation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEvaluationExpectation(UpdateEvaluationExpectationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEvaluationExpectation(EvaluationExpectation evaluationExpectation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEvaluationExpectationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvaluationExpectation</td>
 *      <td><p> Deletes an evaluation expectation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvaluationExpectation(DeleteEvaluationExpectationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEvaluationExpectation(EvaluationExpectationName name)
 *           <li><p> deleteEvaluationExpectation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEvaluationExpectationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateScheduledEvaluationRun</td>
 *      <td><p> Creates a scheduled evaluation run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createScheduledEvaluationRun(CreateScheduledEvaluationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createScheduledEvaluationRun(AppName parent, ScheduledEvaluationRun scheduledEvaluationRun)
 *           <li><p> createScheduledEvaluationRun(String parent, ScheduledEvaluationRun scheduledEvaluationRun)
 *           <li><p> createScheduledEvaluationRun(AppName parent, ScheduledEvaluationRun scheduledEvaluationRun, String scheduledEvaluationRunId)
 *           <li><p> createScheduledEvaluationRun(String parent, ScheduledEvaluationRun scheduledEvaluationRun, String scheduledEvaluationRunId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createScheduledEvaluationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetScheduledEvaluationRun</td>
 *      <td><p> Gets details of the specified scheduled evaluation run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getScheduledEvaluationRun(GetScheduledEvaluationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getScheduledEvaluationRun(ScheduledEvaluationRunName name)
 *           <li><p> getScheduledEvaluationRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getScheduledEvaluationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListScheduledEvaluationRuns</td>
 *      <td><p> Lists all scheduled evaluation runs in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listScheduledEvaluationRuns(ListScheduledEvaluationRunsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listScheduledEvaluationRuns(AppName parent)
 *           <li><p> listScheduledEvaluationRuns(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listScheduledEvaluationRunsPagedCallable()
 *           <li><p> listScheduledEvaluationRunsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateScheduledEvaluationRun</td>
 *      <td><p> Updates a scheduled evaluation run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateScheduledEvaluationRun(UpdateScheduledEvaluationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateScheduledEvaluationRun(ScheduledEvaluationRun scheduledEvaluationRun, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateScheduledEvaluationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteScheduledEvaluationRun</td>
 *      <td><p> Deletes a scheduled evaluation run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteScheduledEvaluationRun(DeleteScheduledEvaluationRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteScheduledEvaluationRun(ScheduledEvaluationRunName name)
 *           <li><p> deleteScheduledEvaluationRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteScheduledEvaluationRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestPersonaVoice</td>
 *      <td><p> Tests the voice of a persona. Also accepts a default persona.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testPersonaVoice(TestPersonaVoiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testPersonaVoice(AppName app)
 *           <li><p> testPersonaVoice(String app)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testPersonaVoiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of EvaluationServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EvaluationServiceSettings evaluationServiceSettings =
 *     EvaluationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EvaluationServiceClient evaluationServiceClient =
 *     EvaluationServiceClient.create(evaluationServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EvaluationServiceSettings evaluationServiceSettings =
 *     EvaluationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EvaluationServiceClient evaluationServiceClient =
 *     EvaluationServiceClient.create(evaluationServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EvaluationServiceSettings evaluationServiceSettings =
 *     EvaluationServiceSettings.newHttpJsonBuilder().build();
 * EvaluationServiceClient evaluationServiceClient =
 *     EvaluationServiceClient.create(evaluationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EvaluationServiceClient implements BackgroundResource {
  private final EvaluationServiceSettings settings;
  private final EvaluationServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EvaluationServiceClient with default settings. */
  public static final EvaluationServiceClient create() throws IOException {
    return create(EvaluationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EvaluationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EvaluationServiceClient create(EvaluationServiceSettings settings)
      throws IOException {
    return new EvaluationServiceClient(settings);
  }

  /**
   * Constructs an instance of EvaluationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(EvaluationServiceSettings).
   */
  public static final EvaluationServiceClient create(EvaluationServiceStub stub) {
    return new EvaluationServiceClient(stub);
  }

  /**
   * Constructs an instance of EvaluationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EvaluationServiceClient(EvaluationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EvaluationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EvaluationServiceClient(EvaluationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EvaluationServiceSettings getSettings() {
    return settings;
  }

  public EvaluationServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an evaluation of the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   RunEvaluationResponse response = evaluationServiceClient.runEvaluationAsync(app).get();
   * }
   * }</pre>
   *
   * @param app Required. The app to evaluate. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationAsync(AppName app) {
    RunEvaluationRequest request =
        RunEvaluationRequest.newBuilder().setApp(app == null ? null : app.toString()).build();
    return runEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an evaluation of the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   RunEvaluationResponse response = evaluationServiceClient.runEvaluationAsync(app).get();
   * }
   * }</pre>
   *
   * @param app Required. The app to evaluate. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationAsync(String app) {
    RunEvaluationRequest request = RunEvaluationRequest.newBuilder().setApp(app).build();
    return runEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an evaluation of the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   RunEvaluationRequest request =
   *       RunEvaluationRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .addAllEvaluations(new ArrayList<String>())
   *           .setEvaluationDataset(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .setDisplayName("displayName1714148973")
   *           .setAppVersion(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .setConfig(EvaluationConfig.newBuilder().build())
   *           .setRunCount(-485221797)
   *           .addAllPersonaRunConfigs(new ArrayList<PersonaRunConfig>())
   *           .setOptimizationConfig(OptimizationConfig.newBuilder().build())
   *           .setScheduledEvaluationRun(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
   *           .setGenerateLatencyReport(true)
   *           .build();
   *   RunEvaluationResponse response = evaluationServiceClient.runEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationAsync(RunEvaluationRequest request) {
    return runEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an evaluation of the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   RunEvaluationRequest request =
   *       RunEvaluationRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .addAllEvaluations(new ArrayList<String>())
   *           .setEvaluationDataset(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .setDisplayName("displayName1714148973")
   *           .setAppVersion(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .setConfig(EvaluationConfig.newBuilder().build())
   *           .setRunCount(-485221797)
   *           .addAllPersonaRunConfigs(new ArrayList<PersonaRunConfig>())
   *           .setOptimizationConfig(OptimizationConfig.newBuilder().build())
   *           .setScheduledEvaluationRun(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
   *           .setGenerateLatencyReport(true)
   *           .build();
   *   OperationFuture<RunEvaluationResponse, RunEvaluationOperationMetadata> future =
   *       evaluationServiceClient.runEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   RunEvaluationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationCallable() {
    return stub.runEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an evaluation of the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   RunEvaluationRequest request =
   *       RunEvaluationRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .addAllEvaluations(new ArrayList<String>())
   *           .setEvaluationDataset(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .setDisplayName("displayName1714148973")
   *           .setAppVersion(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .setConfig(EvaluationConfig.newBuilder().build())
   *           .setRunCount(-485221797)
   *           .addAllPersonaRunConfigs(new ArrayList<PersonaRunConfig>())
   *           .setOptimizationConfig(OptimizationConfig.newBuilder().build())
   *           .setScheduledEvaluationRun(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .setGoldenRunMethod(GoldenRunMethod.forNumber(0))
   *           .setGenerateLatencyReport(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       evaluationServiceClient.runEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    return stub.runEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud Storage bucket
   * defined in 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and returns a
   * transcript.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   ByteString audioContent = ByteString.EMPTY;
   *   UploadEvaluationAudioResponse response =
   *       evaluationServiceClient.uploadEvaluationAudio(app, audioContent);
   * }
   * }</pre>
   *
   * @param app Required. The resource name of the App for which to upload the evaluation audio.
   *     Format: `projects/{project}/locations/{location}/apps/{app}`
   * @param audioContent Required. The raw audio bytes. The format of the audio must be
   *     single-channel LINEAR16 with a sample rate of 16kHz (default InputAudioConfig).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadEvaluationAudioResponse uploadEvaluationAudio(
      AppName app, ByteString audioContent) {
    UploadEvaluationAudioRequest request =
        UploadEvaluationAudioRequest.newBuilder()
            .setApp(app == null ? null : app.toString())
            .setAudioContent(audioContent)
            .build();
    return uploadEvaluationAudio(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud Storage bucket
   * defined in 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and returns a
   * transcript.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   ByteString audioContent = ByteString.EMPTY;
   *   UploadEvaluationAudioResponse response =
   *       evaluationServiceClient.uploadEvaluationAudio(app, audioContent);
   * }
   * }</pre>
   *
   * @param app Required. The resource name of the App for which to upload the evaluation audio.
   *     Format: `projects/{project}/locations/{location}/apps/{app}`
   * @param audioContent Required. The raw audio bytes. The format of the audio must be
   *     single-channel LINEAR16 with a sample rate of 16kHz (default InputAudioConfig).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadEvaluationAudioResponse uploadEvaluationAudio(
      String app, ByteString audioContent) {
    UploadEvaluationAudioRequest request =
        UploadEvaluationAudioRequest.newBuilder().setApp(app).setAudioContent(audioContent).build();
    return uploadEvaluationAudio(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud Storage bucket
   * defined in 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and returns a
   * transcript.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UploadEvaluationAudioRequest request =
   *       UploadEvaluationAudioRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAudioContent(ByteString.EMPTY)
   *           .build();
   *   UploadEvaluationAudioResponse response =
   *       evaluationServiceClient.uploadEvaluationAudio(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadEvaluationAudioResponse uploadEvaluationAudio(
      UploadEvaluationAudioRequest request) {
    return uploadEvaluationAudioCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads audio for use in Golden Evaluations. Stores the audio in the Cloud Storage bucket
   * defined in 'App.logging_settings.evaluation_audio_recording_config.gcs_bucket' and returns a
   * transcript.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UploadEvaluationAudioRequest request =
   *       UploadEvaluationAudioRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAudioContent(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<UploadEvaluationAudioResponse> future =
   *       evaluationServiceClient.uploadEvaluationAudioCallable().futureCall(request);
   *   // Do something.
   *   UploadEvaluationAudioResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioCallable() {
    return stub.uploadEvaluationAudioCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   Evaluation response = evaluationServiceClient.createEvaluation(parent, evaluation);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluation Required. The evaluation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation createEvaluation(AppName parent, Evaluation evaluation) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluation(evaluation)
            .build();
    return createEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   Evaluation response = evaluationServiceClient.createEvaluation(parent, evaluation);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluation Required. The evaluation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation createEvaluation(String parent, Evaluation evaluation) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder().setParent(parent).setEvaluation(evaluation).build();
    return createEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   String evaluationId = "evaluationId407318903";
   *   Evaluation response =
   *       evaluationServiceClient.createEvaluation(parent, evaluation, evaluationId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluation Required. The evaluation to create.
   * @param evaluationId Optional. The ID to use for the evaluation, which will become the final
   *     component of the evaluation's resource name. If not provided, a unique ID will be
   *     automatically assigned for the evaluation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation createEvaluation(
      AppName parent, Evaluation evaluation, String evaluationId) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluation(evaluation)
            .setEvaluationId(evaluationId)
            .build();
    return createEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   String evaluationId = "evaluationId407318903";
   *   Evaluation response =
   *       evaluationServiceClient.createEvaluation(parent, evaluation, evaluationId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluation Required. The evaluation to create.
   * @param evaluationId Optional. The ID to use for the evaluation, which will become the final
   *     component of the evaluation's resource name. If not provided, a unique ID will be
   *     automatically assigned for the evaluation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation createEvaluation(
      String parent, Evaluation evaluation, String evaluationId) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder()
            .setParent(parent)
            .setEvaluation(evaluation)
            .setEvaluationId(evaluationId)
            .build();
    return createEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEvaluationId("evaluationId407318903")
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .build();
   *   Evaluation response = evaluationServiceClient.createEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation createEvaluation(CreateEvaluationRequest request) {
    return createEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEvaluationId("evaluationId407318903")
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       evaluationServiceClient.createEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEvaluationRequest, Evaluation> createEvaluationCallable() {
    return stub.createEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a golden evaluation from a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ConversationName conversation =
   *       ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
   *   Evaluation response = evaluationServiceClient.generateEvaluationAsync(conversation).get();
   * }
   * }</pre>
   *
   * @param conversation Required. The conversation to create the golden evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/conversations/{conversation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationAsync(ConversationName conversation) {
    GenerateEvaluationRequest request =
        GenerateEvaluationRequest.newBuilder()
            .setConversation(conversation == null ? null : conversation.toString())
            .build();
    return generateEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a golden evaluation from a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String conversation =
   *       ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]").toString();
   *   Evaluation response = evaluationServiceClient.generateEvaluationAsync(conversation).get();
   * }
   * }</pre>
   *
   * @param conversation Required. The conversation to create the golden evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/conversations/{conversation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationAsync(String conversation) {
    GenerateEvaluationRequest request =
        GenerateEvaluationRequest.newBuilder().setConversation(conversation).build();
    return generateEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a golden evaluation from a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GenerateEvaluationRequest request =
   *       GenerateEvaluationRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   Evaluation response = evaluationServiceClient.generateEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationAsync(GenerateEvaluationRequest request) {
    return generateEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a golden evaluation from a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GenerateEvaluationRequest request =
   *       GenerateEvaluationRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Evaluation, GenerateEvaluationOperationMetadata> future =
   *       evaluationServiceClient.generateEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationCallable() {
    return stub.generateEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a golden evaluation from a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GenerateEvaluationRequest request =
   *       GenerateEvaluationRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       evaluationServiceClient.generateEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateEvaluationRequest, Operation> generateEvaluationCallable() {
    return stub.generateEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports evaluations into the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   ImportEvaluationsResponse response =
   *       evaluationServiceClient.importEvaluationsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The app to import the evaluations into. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsAsync(AppName parent) {
    ImportEvaluationsRequest request =
        ImportEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return importEvaluationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports evaluations into the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   ImportEvaluationsResponse response =
   *       evaluationServiceClient.importEvaluationsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The app to import the evaluations into. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsAsync(String parent) {
    ImportEvaluationsRequest request =
        ImportEvaluationsRequest.newBuilder().setParent(parent).build();
    return importEvaluationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports evaluations into the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ImportEvaluationsRequest request =
   *       ImportEvaluationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setImportOptions(ImportEvaluationsRequest.ImportOptions.newBuilder().build())
   *           .build();
   *   ImportEvaluationsResponse response =
   *       evaluationServiceClient.importEvaluationsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsAsync(ImportEvaluationsRequest request) {
    return importEvaluationsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports evaluations into the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ImportEvaluationsRequest request =
   *       ImportEvaluationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setImportOptions(ImportEvaluationsRequest.ImportOptions.newBuilder().build())
   *           .build();
   *   OperationFuture<ImportEvaluationsResponse, ImportEvaluationsOperationMetadata> future =
   *       evaluationServiceClient.importEvaluationsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportEvaluationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationCallable() {
    return stub.importEvaluationsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports evaluations into the app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ImportEvaluationsRequest request =
   *       ImportEvaluationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setImportOptions(ImportEvaluationsRequest.ImportOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       evaluationServiceClient.importEvaluationsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportEvaluationsRequest, Operation> importEvaluationsCallable() {
    return stub.importEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
   *   EvaluationDataset response =
   *       evaluationServiceClient.createEvaluationDataset(parent, evaluationDataset);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationDataset Required. The evaluation dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset createEvaluationDataset(
      AppName parent, EvaluationDataset evaluationDataset) {
    CreateEvaluationDatasetRequest request =
        CreateEvaluationDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluationDataset(evaluationDataset)
            .build();
    return createEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
   *   EvaluationDataset response =
   *       evaluationServiceClient.createEvaluationDataset(parent, evaluationDataset);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationDataset Required. The evaluation dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset createEvaluationDataset(
      String parent, EvaluationDataset evaluationDataset) {
    CreateEvaluationDatasetRequest request =
        CreateEvaluationDatasetRequest.newBuilder()
            .setParent(parent)
            .setEvaluationDataset(evaluationDataset)
            .build();
    return createEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
   *   String evaluationDatasetId = "evaluationDatasetId1149172695";
   *   EvaluationDataset response =
   *       evaluationServiceClient.createEvaluationDataset(
   *           parent, evaluationDataset, evaluationDatasetId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationDataset Required. The evaluation dataset to create.
   * @param evaluationDatasetId Optional. The ID to use for the evaluation dataset, which will
   *     become the final component of the evaluation dataset's resource name. If not provided, a
   *     unique ID will be automatically assigned for the evaluation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset createEvaluationDataset(
      AppName parent, EvaluationDataset evaluationDataset, String evaluationDatasetId) {
    CreateEvaluationDatasetRequest request =
        CreateEvaluationDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluationDataset(evaluationDataset)
            .setEvaluationDatasetId(evaluationDatasetId)
            .build();
    return createEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
   *   String evaluationDatasetId = "evaluationDatasetId1149172695";
   *   EvaluationDataset response =
   *       evaluationServiceClient.createEvaluationDataset(
   *           parent, evaluationDataset, evaluationDatasetId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationDataset Required. The evaluation dataset to create.
   * @param evaluationDatasetId Optional. The ID to use for the evaluation dataset, which will
   *     become the final component of the evaluation dataset's resource name. If not provided, a
   *     unique ID will be automatically assigned for the evaluation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset createEvaluationDataset(
      String parent, EvaluationDataset evaluationDataset, String evaluationDatasetId) {
    CreateEvaluationDatasetRequest request =
        CreateEvaluationDatasetRequest.newBuilder()
            .setParent(parent)
            .setEvaluationDataset(evaluationDataset)
            .setEvaluationDatasetId(evaluationDatasetId)
            .build();
    return createEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationDatasetRequest request =
   *       CreateEvaluationDatasetRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEvaluationDatasetId("evaluationDatasetId1149172695")
   *           .setEvaluationDataset(EvaluationDataset.newBuilder().build())
   *           .build();
   *   EvaluationDataset response = evaluationServiceClient.createEvaluationDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset createEvaluationDataset(CreateEvaluationDatasetRequest request) {
    return createEvaluationDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationDatasetRequest request =
   *       CreateEvaluationDatasetRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEvaluationDatasetId("evaluationDatasetId1149172695")
   *           .setEvaluationDataset(EvaluationDataset.newBuilder().build())
   *           .build();
   *   ApiFuture<EvaluationDataset> future =
   *       evaluationServiceClient.createEvaluationDatasetCallable().futureCall(request);
   *   // Do something.
   *   EvaluationDataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetCallable() {
    return stub.createEvaluationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Evaluation response = evaluationServiceClient.updateEvaluation(evaluation, updateMask);
   * }
   * }</pre>
   *
   * @param evaluation Required. The evaluation to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation updateEvaluation(Evaluation evaluation, FieldMask updateMask) {
    UpdateEvaluationRequest request =
        UpdateEvaluationRequest.newBuilder()
            .setEvaluation(evaluation)
            .setUpdateMask(updateMask)
            .build();
    return updateEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateEvaluationRequest request =
   *       UpdateEvaluationRequest.newBuilder()
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Evaluation response = evaluationServiceClient.updateEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation updateEvaluation(UpdateEvaluationRequest request) {
    return updateEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateEvaluationRequest request =
   *       UpdateEvaluationRequest.newBuilder()
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       evaluationServiceClient.updateEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEvaluationRequest, Evaluation> updateEvaluationCallable() {
    return stub.updateEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationDataset evaluationDataset = EvaluationDataset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EvaluationDataset response =
   *       evaluationServiceClient.updateEvaluationDataset(evaluationDataset, updateMask);
   * }
   * }</pre>
   *
   * @param evaluationDataset Required. The evaluation dataset to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset updateEvaluationDataset(
      EvaluationDataset evaluationDataset, FieldMask updateMask) {
    UpdateEvaluationDatasetRequest request =
        UpdateEvaluationDatasetRequest.newBuilder()
            .setEvaluationDataset(evaluationDataset)
            .setUpdateMask(updateMask)
            .build();
    return updateEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateEvaluationDatasetRequest request =
   *       UpdateEvaluationDatasetRequest.newBuilder()
   *           .setEvaluationDataset(EvaluationDataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EvaluationDataset response = evaluationServiceClient.updateEvaluationDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset updateEvaluationDataset(UpdateEvaluationDatasetRequest request) {
    return updateEvaluationDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateEvaluationDatasetRequest request =
   *       UpdateEvaluationDatasetRequest.newBuilder()
   *           .setEvaluationDataset(EvaluationDataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EvaluationDataset> future =
   *       evaluationServiceClient.updateEvaluationDatasetCallable().futureCall(request);
   *   // Do something.
   *   EvaluationDataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetCallable() {
    return stub.updateEvaluationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");
   *   evaluationServiceClient.deleteEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluation(EvaluationName name) {
    DeleteEvaluationRequest request =
        DeleteEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString();
   *   evaluationServiceClient.deleteEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluation(String name) {
    DeleteEvaluationRequest request = DeleteEvaluationRequest.newBuilder().setName(name).build();
    deleteEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationRequest request =
   *       DeleteEvaluationRequest.newBuilder()
   *           .setName(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   evaluationServiceClient.deleteEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluation(DeleteEvaluationRequest request) {
    deleteEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationRequest request =
   *       DeleteEvaluationRequest.newBuilder()
   *           .setName(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       evaluationServiceClient.deleteEvaluationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEvaluationRequest, Empty> deleteEvaluationCallable() {
    return stub.deleteEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationResultName name =
   *       EvaluationResultName.of(
   *           "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");
   *   evaluationServiceClient.deleteEvaluationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation result to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationResult(EvaluationResultName name) {
    DeleteEvaluationResultRequest request =
        DeleteEvaluationResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEvaluationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationResultName.of(
   *               "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
   *           .toString();
   *   evaluationServiceClient.deleteEvaluationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation result to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationResult(String name) {
    DeleteEvaluationResultRequest request =
        DeleteEvaluationResultRequest.newBuilder().setName(name).build();
    deleteEvaluationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationResultRequest request =
   *       DeleteEvaluationResultRequest.newBuilder()
   *           .setName(
   *               EvaluationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
   *                   .toString())
   *           .build();
   *   evaluationServiceClient.deleteEvaluationResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationResult(DeleteEvaluationResultRequest request) {
    deleteEvaluationResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationResultRequest request =
   *       DeleteEvaluationResultRequest.newBuilder()
   *           .setName(
   *               EvaluationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       evaluationServiceClient.deleteEvaluationResultCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEvaluationResultRequest, Empty>
      deleteEvaluationResultCallable() {
    return stub.deleteEvaluationResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationDatasetName name =
   *       EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");
   *   evaluationServiceClient.deleteEvaluationDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation dataset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationDataset(EvaluationDatasetName name) {
    DeleteEvaluationDatasetRequest request =
        DeleteEvaluationDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *           .toString();
   *   evaluationServiceClient.deleteEvaluationDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation dataset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationDataset(String name) {
    DeleteEvaluationDatasetRequest request =
        DeleteEvaluationDatasetRequest.newBuilder().setName(name).build();
    deleteEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationDatasetRequest request =
   *       DeleteEvaluationDatasetRequest.newBuilder()
   *           .setName(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   evaluationServiceClient.deleteEvaluationDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationDataset(DeleteEvaluationDatasetRequest request) {
    deleteEvaluationDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationDatasetRequest request =
   *       DeleteEvaluationDatasetRequest.newBuilder()
   *           .setName(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       evaluationServiceClient.deleteEvaluationDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetCallable() {
    return stub.deleteEvaluationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationRunName name =
   *       EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");
   *   evaluationServiceClient.deleteEvaluationRunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation run to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunAsync(EvaluationRunName name) {
    DeleteEvaluationRunRequest request =
        DeleteEvaluationRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEvaluationRunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]").toString();
   *   evaluationServiceClient.deleteEvaluationRunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation run to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunAsync(String name) {
    DeleteEvaluationRunRequest request =
        DeleteEvaluationRunRequest.newBuilder().setName(name).build();
    return deleteEvaluationRunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationRunRequest request =
   *       DeleteEvaluationRunRequest.newBuilder()
   *           .setName(
   *               EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   evaluationServiceClient.deleteEvaluationRunAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunAsync(DeleteEvaluationRunRequest request) {
    return deleteEvaluationRunOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationRunRequest request =
   *       DeleteEvaluationRunRequest.newBuilder()
   *           .setName(
   *               EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteEvaluationRunOperationMetadata> future =
   *       evaluationServiceClient.deleteEvaluationRunOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationCallable() {
    return stub.deleteEvaluationRunOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationRunRequest request =
   *       DeleteEvaluationRunRequest.newBuilder()
   *           .setName(
   *               EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       evaluationServiceClient.deleteEvaluationRunCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunCallable() {
    return stub.deleteEvaluationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");
   *   Evaluation response = evaluationServiceClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(EvaluationName name) {
    GetEvaluationRequest request =
        GetEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString();
   *   Evaluation response = evaluationServiceClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(String name) {
    GetEvaluationRequest request = GetEvaluationRequest.newBuilder().setName(name).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .build();
   *   Evaluation response = evaluationServiceClient.getEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(GetEvaluationRequest request) {
    return getEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       evaluationServiceClient.getEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return stub.getEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationResultName name =
   *       EvaluationResultName.of(
   *           "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]");
   *   EvaluationResult response = evaluationServiceClient.getEvaluationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation result to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationResult getEvaluationResult(EvaluationResultName name) {
    GetEvaluationResultRequest request =
        GetEvaluationResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEvaluationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationResultName.of(
   *               "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
   *           .toString();
   *   EvaluationResult response = evaluationServiceClient.getEvaluationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation result to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationResult getEvaluationResult(String name) {
    GetEvaluationResultRequest request =
        GetEvaluationResultRequest.newBuilder().setName(name).build();
    return getEvaluationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationResultRequest request =
   *       GetEvaluationResultRequest.newBuilder()
   *           .setName(
   *               EvaluationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
   *                   .toString())
   *           .build();
   *   EvaluationResult response = evaluationServiceClient.getEvaluationResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationResult getEvaluationResult(GetEvaluationResultRequest request) {
    return getEvaluationResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationResultRequest request =
   *       GetEvaluationResultRequest.newBuilder()
   *           .setName(
   *               EvaluationResultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]", "[EVALUATION_RESULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EvaluationResult> future =
   *       evaluationServiceClient.getEvaluationResultCallable().futureCall(request);
   *   // Do something.
   *   EvaluationResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultCallable() {
    return stub.getEvaluationResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationDatasetName name =
   *       EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]");
   *   EvaluationDataset response = evaluationServiceClient.getEvaluationDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation dataset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset getEvaluationDataset(EvaluationDatasetName name) {
    GetEvaluationDatasetRequest request =
        GetEvaluationDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationDatasetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *           .toString();
   *   EvaluationDataset response = evaluationServiceClient.getEvaluationDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation dataset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset getEvaluationDataset(String name) {
    GetEvaluationDatasetRequest request =
        GetEvaluationDatasetRequest.newBuilder().setName(name).build();
    return getEvaluationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationDatasetRequest request =
   *       GetEvaluationDatasetRequest.newBuilder()
   *           .setName(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .build();
   *   EvaluationDataset response = evaluationServiceClient.getEvaluationDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationDataset getEvaluationDataset(GetEvaluationDatasetRequest request) {
    return getEvaluationDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationDatasetRequest request =
   *       GetEvaluationDatasetRequest.newBuilder()
   *           .setName(
   *               EvaluationDatasetName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_DATASET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EvaluationDataset> future =
   *       evaluationServiceClient.getEvaluationDatasetCallable().futureCall(request);
   *   // Do something.
   *   EvaluationDataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetCallable() {
    return stub.getEvaluationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationRunName name =
   *       EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]");
   *   EvaluationRun response = evaluationServiceClient.getEvaluationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation run to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationRun getEvaluationRun(EvaluationRunName name) {
    GetEvaluationRunRequest request =
        GetEvaluationRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]").toString();
   *   EvaluationRun response = evaluationServiceClient.getEvaluationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation run to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationRun getEvaluationRun(String name) {
    GetEvaluationRunRequest request = GetEvaluationRunRequest.newBuilder().setName(name).build();
    return getEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationRunRequest request =
   *       GetEvaluationRunRequest.newBuilder()
   *           .setName(
   *               EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   EvaluationRun response = evaluationServiceClient.getEvaluationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationRun getEvaluationRun(GetEvaluationRunRequest request) {
    return getEvaluationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationRunRequest request =
   *       GetEvaluationRunRequest.newBuilder()
   *           .setName(
   *               EvaluationRunName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EvaluationRun> future =
   *       evaluationServiceClient.getEvaluationRunCallable().futureCall(request);
   *   // Do something.
   *   EvaluationRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunCallable() {
    return stub.getEvaluationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Evaluation element : evaluationServiceClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluations from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(AppName parent) {
    ListEvaluationsRequest request =
        ListEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Evaluation element : evaluationServiceClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluations from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(String parent) {
    ListEvaluationsRequest request = ListEvaluationsRequest.newBuilder().setParent(parent).build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setEvaluationFilter("evaluationFilter1361994196")
   *           .setEvaluationRunFilter("evaluationRunFilter299014663")
   *           .setOrderBy("orderBy-1207110587")
   *           .setLastTenResults(true)
   *           .build();
   *   for (Evaluation element : evaluationServiceClient.listEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(ListEvaluationsRequest request) {
    return listEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setEvaluationFilter("evaluationFilter1361994196")
   *           .setEvaluationRunFilter("evaluationRunFilter299014663")
   *           .setOrderBy("orderBy-1207110587")
   *           .setLastTenResults(true)
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       evaluationServiceClient.listEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Evaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return stub.listEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setEvaluationFilter("evaluationFilter1361994196")
   *           .setEvaluationRunFilter("evaluationRunFilter299014663")
   *           .setOrderBy("orderBy-1207110587")
   *           .setLastTenResults(true)
   *           .build();
   *   while (true) {
   *     ListEvaluationsResponse response =
   *         evaluationServiceClient.listEvaluationsCallable().call(request);
   *     for (Evaluation element : response.getEvaluationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable() {
    return stub.listEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation results for a given evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationName parent = EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]");
   *   for (EvaluationResult element :
   *       evaluationServiceClient.listEvaluationResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the evaluation to list evaluation results from. To
   *     filter by evaluation run, use `-` as the evaluation ID and specify the evaluation run ID in
   *     the filter. For example: `projects/{project}/locations/{location}/apps/{app}/evaluations/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationResultsPagedResponse listEvaluationResults(EvaluationName parent) {
    ListEvaluationResultsRequest request =
        ListEvaluationResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluationResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation results for a given evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent =
   *       EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString();
   *   for (EvaluationResult element :
   *       evaluationServiceClient.listEvaluationResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the evaluation to list evaluation results from. To
   *     filter by evaluation run, use `-` as the evaluation ID and specify the evaluation run ID in
   *     the filter. For example: `projects/{project}/locations/{location}/apps/{app}/evaluations/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationResultsPagedResponse listEvaluationResults(String parent) {
    ListEvaluationResultsRequest request =
        ListEvaluationResultsRequest.newBuilder().setParent(parent).build();
    return listEvaluationResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation results for a given evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationResultsRequest request =
   *       ListEvaluationResultsRequest.newBuilder()
   *           .setParent(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EvaluationResult element :
   *       evaluationServiceClient.listEvaluationResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationResultsPagedResponse listEvaluationResults(
      ListEvaluationResultsRequest request) {
    return listEvaluationResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation results for a given evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationResultsRequest request =
   *       ListEvaluationResultsRequest.newBuilder()
   *           .setParent(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EvaluationResult> future =
   *       evaluationServiceClient.listEvaluationResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EvaluationResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable() {
    return stub.listEvaluationResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation results for a given evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationResultsRequest request =
   *       ListEvaluationResultsRequest.newBuilder()
   *           .setParent(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEvaluationResultsResponse response =
   *         evaluationServiceClient.listEvaluationResultsCallable().call(request);
   *     for (EvaluationResult element : response.getEvaluationResultsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable() {
    return stub.listEvaluationResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation datasets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (EvaluationDataset element :
   *       evaluationServiceClient.listEvaluationDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluation datasets from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationDatasetsPagedResponse listEvaluationDatasets(AppName parent) {
    ListEvaluationDatasetsRequest request =
        ListEvaluationDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluationDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation datasets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (EvaluationDataset element :
   *       evaluationServiceClient.listEvaluationDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluation datasets from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationDatasetsPagedResponse listEvaluationDatasets(String parent) {
    ListEvaluationDatasetsRequest request =
        ListEvaluationDatasetsRequest.newBuilder().setParent(parent).build();
    return listEvaluationDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation datasets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationDatasetsRequest request =
   *       ListEvaluationDatasetsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EvaluationDataset element :
   *       evaluationServiceClient.listEvaluationDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationDatasetsPagedResponse listEvaluationDatasets(
      ListEvaluationDatasetsRequest request) {
    return listEvaluationDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation datasets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationDatasetsRequest request =
   *       ListEvaluationDatasetsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EvaluationDataset> future =
   *       evaluationServiceClient.listEvaluationDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EvaluationDataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsPagedCallable() {
    return stub.listEvaluationDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation datasets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationDatasetsRequest request =
   *       ListEvaluationDatasetsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEvaluationDatasetsResponse response =
   *         evaluationServiceClient.listEvaluationDatasetsCallable().call(request);
   *     for (EvaluationDataset element : response.getEvaluationDatasetsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsCallable() {
    return stub.listEvaluationDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (EvaluationRun element :
   *       evaluationServiceClient.listEvaluationRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluation runs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationRunsPagedResponse listEvaluationRuns(AppName parent) {
    ListEvaluationRunsRequest request =
        ListEvaluationRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluationRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (EvaluationRun element :
   *       evaluationServiceClient.listEvaluationRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluation runs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationRunsPagedResponse listEvaluationRuns(String parent) {
    ListEvaluationRunsRequest request =
        ListEvaluationRunsRequest.newBuilder().setParent(parent).build();
    return listEvaluationRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationRunsRequest request =
   *       ListEvaluationRunsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EvaluationRun element :
   *       evaluationServiceClient.listEvaluationRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationRunsPagedResponse listEvaluationRuns(
      ListEvaluationRunsRequest request) {
    return listEvaluationRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationRunsRequest request =
   *       ListEvaluationRunsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EvaluationRun> future =
   *       evaluationServiceClient.listEvaluationRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EvaluationRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsPagedResponse>
      listEvaluationRunsPagedCallable() {
    return stub.listEvaluationRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationRunsRequest request =
   *       ListEvaluationRunsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEvaluationRunsResponse response =
   *         evaluationServiceClient.listEvaluationRunsCallable().call(request);
   *     for (EvaluationRun element : response.getEvaluationRunsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsCallable() {
    return stub.listEvaluationRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation expectations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (EvaluationExpectation element :
   *       evaluationServiceClient.listEvaluationExpectations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluation expectations from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationExpectationsPagedResponse listEvaluationExpectations(AppName parent) {
    ListEvaluationExpectationsRequest request =
        ListEvaluationExpectationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluationExpectations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation expectations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (EvaluationExpectation element :
   *       evaluationServiceClient.listEvaluationExpectations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list evaluation expectations from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationExpectationsPagedResponse listEvaluationExpectations(String parent) {
    ListEvaluationExpectationsRequest request =
        ListEvaluationExpectationsRequest.newBuilder().setParent(parent).build();
    return listEvaluationExpectations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation expectations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationExpectationsRequest request =
   *       ListEvaluationExpectationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EvaluationExpectation element :
   *       evaluationServiceClient.listEvaluationExpectations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationExpectationsPagedResponse listEvaluationExpectations(
      ListEvaluationExpectationsRequest request) {
    return listEvaluationExpectationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation expectations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationExpectationsRequest request =
   *       ListEvaluationExpectationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EvaluationExpectation> future =
   *       evaluationServiceClient.listEvaluationExpectationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EvaluationExpectation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEvaluationExpectationsRequest, ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsPagedCallable() {
    return stub.listEvaluationExpectationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all evaluation expectations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationExpectationsRequest request =
   *       ListEvaluationExpectationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEvaluationExpectationsResponse response =
   *         evaluationServiceClient.listEvaluationExpectationsCallable().call(request);
   *     for (EvaluationExpectation element : response.getEvaluationExpectationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsCallable() {
    return stub.listEvaluationExpectationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationExpectationName name =
   *       EvaluationExpectationName.of(
   *           "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");
   *   EvaluationExpectation response = evaluationServiceClient.getEvaluationExpectation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation expectation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation getEvaluationExpectation(EvaluationExpectationName name) {
    GetEvaluationExpectationRequest request =
        GetEvaluationExpectationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationExpectationName.of(
   *               "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
   *           .toString();
   *   EvaluationExpectation response = evaluationServiceClient.getEvaluationExpectation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation expectation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation getEvaluationExpectation(String name) {
    GetEvaluationExpectationRequest request =
        GetEvaluationExpectationRequest.newBuilder().setName(name).build();
    return getEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationExpectationRequest request =
   *       GetEvaluationExpectationRequest.newBuilder()
   *           .setName(
   *               EvaluationExpectationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
   *                   .toString())
   *           .build();
   *   EvaluationExpectation response = evaluationServiceClient.getEvaluationExpectation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation getEvaluationExpectation(
      GetEvaluationExpectationRequest request) {
    return getEvaluationExpectationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationExpectationRequest request =
   *       GetEvaluationExpectationRequest.newBuilder()
   *           .setName(
   *               EvaluationExpectationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EvaluationExpectation> future =
   *       evaluationServiceClient.getEvaluationExpectationCallable().futureCall(request);
   *   // Do something.
   *   EvaluationExpectation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationCallable() {
    return stub.getEvaluationExpectationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
   *   EvaluationExpectation response =
   *       evaluationServiceClient.createEvaluationExpectation(parent, evaluationExpectation);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation expectation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationExpectation Required. The evaluation expectation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation createEvaluationExpectation(
      AppName parent, EvaluationExpectation evaluationExpectation) {
    CreateEvaluationExpectationRequest request =
        CreateEvaluationExpectationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluationExpectation(evaluationExpectation)
            .build();
    return createEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
   *   EvaluationExpectation response =
   *       evaluationServiceClient.createEvaluationExpectation(parent, evaluationExpectation);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation expectation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationExpectation Required. The evaluation expectation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation createEvaluationExpectation(
      String parent, EvaluationExpectation evaluationExpectation) {
    CreateEvaluationExpectationRequest request =
        CreateEvaluationExpectationRequest.newBuilder()
            .setParent(parent)
            .setEvaluationExpectation(evaluationExpectation)
            .build();
    return createEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
   *   String evaluationExpectationId = "evaluationExpectationId-31829349";
   *   EvaluationExpectation response =
   *       evaluationServiceClient.createEvaluationExpectation(
   *           parent, evaluationExpectation, evaluationExpectationId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation expectation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationExpectation Required. The evaluation expectation to create.
   * @param evaluationExpectationId Optional. The ID to use for the evaluation expectation, which
   *     will become the final component of the evaluation expectation's resource name. If not
   *     provided, a unique ID will be automatically assigned for the evaluation expectation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation createEvaluationExpectation(
      AppName parent, EvaluationExpectation evaluationExpectation, String evaluationExpectationId) {
    CreateEvaluationExpectationRequest request =
        CreateEvaluationExpectationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluationExpectation(evaluationExpectation)
            .setEvaluationExpectationId(evaluationExpectationId)
            .build();
    return createEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
   *   String evaluationExpectationId = "evaluationExpectationId-31829349";
   *   EvaluationExpectation response =
   *       evaluationServiceClient.createEvaluationExpectation(
   *           parent, evaluationExpectation, evaluationExpectationId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the evaluation expectation for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param evaluationExpectation Required. The evaluation expectation to create.
   * @param evaluationExpectationId Optional. The ID to use for the evaluation expectation, which
   *     will become the final component of the evaluation expectation's resource name. If not
   *     provided, a unique ID will be automatically assigned for the evaluation expectation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation createEvaluationExpectation(
      String parent, EvaluationExpectation evaluationExpectation, String evaluationExpectationId) {
    CreateEvaluationExpectationRequest request =
        CreateEvaluationExpectationRequest.newBuilder()
            .setParent(parent)
            .setEvaluationExpectation(evaluationExpectation)
            .setEvaluationExpectationId(evaluationExpectationId)
            .build();
    return createEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationExpectationRequest request =
   *       CreateEvaluationExpectationRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEvaluationExpectationId("evaluationExpectationId-31829349")
   *           .setEvaluationExpectation(EvaluationExpectation.newBuilder().build())
   *           .build();
   *   EvaluationExpectation response = evaluationServiceClient.createEvaluationExpectation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation createEvaluationExpectation(
      CreateEvaluationExpectationRequest request) {
    return createEvaluationExpectationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationExpectationRequest request =
   *       CreateEvaluationExpectationRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEvaluationExpectationId("evaluationExpectationId-31829349")
   *           .setEvaluationExpectation(EvaluationExpectation.newBuilder().build())
   *           .build();
   *   ApiFuture<EvaluationExpectation> future =
   *       evaluationServiceClient.createEvaluationExpectationCallable().futureCall(request);
   *   // Do something.
   *   EvaluationExpectation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationCallable() {
    return stub.createEvaluationExpectationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationExpectation evaluationExpectation = EvaluationExpectation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EvaluationExpectation response =
   *       evaluationServiceClient.updateEvaluationExpectation(evaluationExpectation, updateMask);
   * }
   * }</pre>
   *
   * @param evaluationExpectation Required. The evaluation expectation to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation updateEvaluationExpectation(
      EvaluationExpectation evaluationExpectation, FieldMask updateMask) {
    UpdateEvaluationExpectationRequest request =
        UpdateEvaluationExpectationRequest.newBuilder()
            .setEvaluationExpectation(evaluationExpectation)
            .setUpdateMask(updateMask)
            .build();
    return updateEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateEvaluationExpectationRequest request =
   *       UpdateEvaluationExpectationRequest.newBuilder()
   *           .setEvaluationExpectation(EvaluationExpectation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EvaluationExpectation response = evaluationServiceClient.updateEvaluationExpectation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EvaluationExpectation updateEvaluationExpectation(
      UpdateEvaluationExpectationRequest request) {
    return updateEvaluationExpectationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateEvaluationExpectationRequest request =
   *       UpdateEvaluationExpectationRequest.newBuilder()
   *           .setEvaluationExpectation(EvaluationExpectation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EvaluationExpectation> future =
   *       evaluationServiceClient.updateEvaluationExpectationCallable().futureCall(request);
   *   // Do something.
   *   EvaluationExpectation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationCallable() {
    return stub.updateEvaluationExpectationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationExpectationName name =
   *       EvaluationExpectationName.of(
   *           "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]");
   *   evaluationServiceClient.deleteEvaluationExpectation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation expectation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationExpectation(EvaluationExpectationName name) {
    DeleteEvaluationExpectationRequest request =
        DeleteEvaluationExpectationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       EvaluationExpectationName.of(
   *               "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
   *           .toString();
   *   evaluationServiceClient.deleteEvaluationExpectation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the evaluation expectation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationExpectation(String name) {
    DeleteEvaluationExpectationRequest request =
        DeleteEvaluationExpectationRequest.newBuilder().setName(name).build();
    deleteEvaluationExpectation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationExpectationRequest request =
   *       DeleteEvaluationExpectationRequest.newBuilder()
   *           .setName(
   *               EvaluationExpectationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   evaluationServiceClient.deleteEvaluationExpectation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvaluationExpectation(DeleteEvaluationExpectationRequest request) {
    deleteEvaluationExpectationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation expectation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteEvaluationExpectationRequest request =
   *       DeleteEvaluationExpectationRequest.newBuilder()
   *           .setName(
   *               EvaluationExpectationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[EVALUATION_EXPECTATION]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       evaluationServiceClient.deleteEvaluationExpectationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationCallable() {
    return stub.deleteEvaluationExpectationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the scheduled evaluation run for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param scheduledEvaluationRun Required. The scheduled evaluation run to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun createScheduledEvaluationRun(
      AppName parent, ScheduledEvaluationRun scheduledEvaluationRun) {
    CreateScheduledEvaluationRunRequest request =
        CreateScheduledEvaluationRunRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setScheduledEvaluationRun(scheduledEvaluationRun)
            .build();
    return createScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.createScheduledEvaluationRun(parent, scheduledEvaluationRun);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the scheduled evaluation run for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param scheduledEvaluationRun Required. The scheduled evaluation run to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun createScheduledEvaluationRun(
      String parent, ScheduledEvaluationRun scheduledEvaluationRun) {
    CreateScheduledEvaluationRunRequest request =
        CreateScheduledEvaluationRunRequest.newBuilder()
            .setParent(parent)
            .setScheduledEvaluationRun(scheduledEvaluationRun)
            .build();
    return createScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
   *   String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.createScheduledEvaluationRun(
   *           parent, scheduledEvaluationRun, scheduledEvaluationRunId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the scheduled evaluation run for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param scheduledEvaluationRun Required. The scheduled evaluation run to create.
   * @param scheduledEvaluationRunId Optional. The ID to use for the scheduled evaluation run, which
   *     will become the final component of the scheduled evaluation run's resource name. If not
   *     provided, a unique ID will be automatically assigned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun createScheduledEvaluationRun(
      AppName parent,
      ScheduledEvaluationRun scheduledEvaluationRun,
      String scheduledEvaluationRunId) {
    CreateScheduledEvaluationRunRequest request =
        CreateScheduledEvaluationRunRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setScheduledEvaluationRun(scheduledEvaluationRun)
            .setScheduledEvaluationRunId(scheduledEvaluationRunId)
            .build();
    return createScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
   *   String scheduledEvaluationRunId = "scheduledEvaluationRunId-434150723";
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.createScheduledEvaluationRun(
   *           parent, scheduledEvaluationRun, scheduledEvaluationRunId);
   * }
   * }</pre>
   *
   * @param parent Required. The app to create the scheduled evaluation run for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param scheduledEvaluationRun Required. The scheduled evaluation run to create.
   * @param scheduledEvaluationRunId Optional. The ID to use for the scheduled evaluation run, which
   *     will become the final component of the scheduled evaluation run's resource name. If not
   *     provided, a unique ID will be automatically assigned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun createScheduledEvaluationRun(
      String parent,
      ScheduledEvaluationRun scheduledEvaluationRun,
      String scheduledEvaluationRunId) {
    CreateScheduledEvaluationRunRequest request =
        CreateScheduledEvaluationRunRequest.newBuilder()
            .setParent(parent)
            .setScheduledEvaluationRun(scheduledEvaluationRun)
            .setScheduledEvaluationRunId(scheduledEvaluationRunId)
            .build();
    return createScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateScheduledEvaluationRunRequest request =
   *       CreateScheduledEvaluationRunRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setScheduledEvaluationRunId("scheduledEvaluationRunId-434150723")
   *           .setScheduledEvaluationRun(ScheduledEvaluationRun.newBuilder().build())
   *           .build();
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.createScheduledEvaluationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun createScheduledEvaluationRun(
      CreateScheduledEvaluationRunRequest request) {
    return createScheduledEvaluationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateScheduledEvaluationRunRequest request =
   *       CreateScheduledEvaluationRunRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setScheduledEvaluationRunId("scheduledEvaluationRunId-434150723")
   *           .setScheduledEvaluationRun(ScheduledEvaluationRun.newBuilder().build())
   *           .build();
   *   ApiFuture<ScheduledEvaluationRun> future =
   *       evaluationServiceClient.createScheduledEvaluationRunCallable().futureCall(request);
   *   // Do something.
   *   ScheduledEvaluationRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunCallable() {
    return stub.createScheduledEvaluationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ScheduledEvaluationRunName name =
   *       ScheduledEvaluationRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");
   *   ScheduledEvaluationRun response = evaluationServiceClient.getScheduledEvaluationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the scheduled evaluation run to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun getScheduledEvaluationRun(ScheduledEvaluationRunName name) {
    GetScheduledEvaluationRunRequest request =
        GetScheduledEvaluationRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       ScheduledEvaluationRunName.of(
   *               "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *           .toString();
   *   ScheduledEvaluationRun response = evaluationServiceClient.getScheduledEvaluationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the scheduled evaluation run to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun getScheduledEvaluationRun(String name) {
    GetScheduledEvaluationRunRequest request =
        GetScheduledEvaluationRunRequest.newBuilder().setName(name).build();
    return getScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetScheduledEvaluationRunRequest request =
   *       GetScheduledEvaluationRunRequest.newBuilder()
   *           .setName(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   ScheduledEvaluationRun response = evaluationServiceClient.getScheduledEvaluationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun getScheduledEvaluationRun(
      GetScheduledEvaluationRunRequest request) {
    return getScheduledEvaluationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetScheduledEvaluationRunRequest request =
   *       GetScheduledEvaluationRunRequest.newBuilder()
   *           .setName(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ScheduledEvaluationRun> future =
   *       evaluationServiceClient.getScheduledEvaluationRunCallable().futureCall(request);
   *   // Do something.
   *   ScheduledEvaluationRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunCallable() {
    return stub.getScheduledEvaluationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all scheduled evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (ScheduledEvaluationRun element :
   *       evaluationServiceClient.listScheduledEvaluationRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list scheduled evaluation runs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScheduledEvaluationRunsPagedResponse listScheduledEvaluationRuns(
      AppName parent) {
    ListScheduledEvaluationRunsRequest request =
        ListScheduledEvaluationRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listScheduledEvaluationRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all scheduled evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (ScheduledEvaluationRun element :
   *       evaluationServiceClient.listScheduledEvaluationRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list scheduled evaluation runs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScheduledEvaluationRunsPagedResponse listScheduledEvaluationRuns(String parent) {
    ListScheduledEvaluationRunsRequest request =
        ListScheduledEvaluationRunsRequest.newBuilder().setParent(parent).build();
    return listScheduledEvaluationRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all scheduled evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListScheduledEvaluationRunsRequest request =
   *       ListScheduledEvaluationRunsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ScheduledEvaluationRun element :
   *       evaluationServiceClient.listScheduledEvaluationRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScheduledEvaluationRunsPagedResponse listScheduledEvaluationRuns(
      ListScheduledEvaluationRunsRequest request) {
    return listScheduledEvaluationRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all scheduled evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListScheduledEvaluationRunsRequest request =
   *       ListScheduledEvaluationRunsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ScheduledEvaluationRun> future =
   *       evaluationServiceClient.listScheduledEvaluationRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ScheduledEvaluationRun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsPagedCallable() {
    return stub.listScheduledEvaluationRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all scheduled evaluation runs in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListScheduledEvaluationRunsRequest request =
   *       ListScheduledEvaluationRunsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListScheduledEvaluationRunsResponse response =
   *         evaluationServiceClient.listScheduledEvaluationRunsCallable().call(request);
   *     for (ScheduledEvaluationRun element : response.getScheduledEvaluationRunsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsCallable() {
    return stub.listScheduledEvaluationRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ScheduledEvaluationRun scheduledEvaluationRun = ScheduledEvaluationRun.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.updateScheduledEvaluationRun(scheduledEvaluationRun, updateMask);
   * }
   * }</pre>
   *
   * @param scheduledEvaluationRun Required. The scheduled evaluation run to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun updateScheduledEvaluationRun(
      ScheduledEvaluationRun scheduledEvaluationRun, FieldMask updateMask) {
    UpdateScheduledEvaluationRunRequest request =
        UpdateScheduledEvaluationRunRequest.newBuilder()
            .setScheduledEvaluationRun(scheduledEvaluationRun)
            .setUpdateMask(updateMask)
            .build();
    return updateScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateScheduledEvaluationRunRequest request =
   *       UpdateScheduledEvaluationRunRequest.newBuilder()
   *           .setScheduledEvaluationRun(ScheduledEvaluationRun.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ScheduledEvaluationRun response =
   *       evaluationServiceClient.updateScheduledEvaluationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScheduledEvaluationRun updateScheduledEvaluationRun(
      UpdateScheduledEvaluationRunRequest request) {
    return updateScheduledEvaluationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   UpdateScheduledEvaluationRunRequest request =
   *       UpdateScheduledEvaluationRunRequest.newBuilder()
   *           .setScheduledEvaluationRun(ScheduledEvaluationRun.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ScheduledEvaluationRun> future =
   *       evaluationServiceClient.updateScheduledEvaluationRunCallable().futureCall(request);
   *   // Do something.
   *   ScheduledEvaluationRun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunCallable() {
    return stub.updateScheduledEvaluationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ScheduledEvaluationRunName name =
   *       ScheduledEvaluationRunName.of(
   *           "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]");
   *   evaluationServiceClient.deleteScheduledEvaluationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the scheduled evaluation run to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteScheduledEvaluationRun(ScheduledEvaluationRunName name) {
    DeleteScheduledEvaluationRunRequest request =
        DeleteScheduledEvaluationRunRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name =
   *       ScheduledEvaluationRunName.of(
   *               "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *           .toString();
   *   evaluationServiceClient.deleteScheduledEvaluationRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the scheduled evaluation run to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteScheduledEvaluationRun(String name) {
    DeleteScheduledEvaluationRunRequest request =
        DeleteScheduledEvaluationRunRequest.newBuilder().setName(name).build();
    deleteScheduledEvaluationRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteScheduledEvaluationRunRequest request =
   *       DeleteScheduledEvaluationRunRequest.newBuilder()
   *           .setName(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   evaluationServiceClient.deleteScheduledEvaluationRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteScheduledEvaluationRun(DeleteScheduledEvaluationRunRequest request) {
    deleteScheduledEvaluationRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a scheduled evaluation run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   DeleteScheduledEvaluationRunRequest request =
   *       DeleteScheduledEvaluationRunRequest.newBuilder()
   *           .setName(
   *               ScheduledEvaluationRunName.of(
   *                       "[PROJECT]", "[LOCATION]", "[APP]", "[SCHEDULED_EVALUATION_RUN]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future =
   *       evaluationServiceClient.deleteScheduledEvaluationRunCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunCallable() {
    return stub.deleteScheduledEvaluationRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the voice of a persona. Also accepts a default persona.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   AppName app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   TestPersonaVoiceResponse response = evaluationServiceClient.testPersonaVoice(app);
   * }
   * }</pre>
   *
   * @param app Required. the resource name of the app to test the persona voice for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPersonaVoiceResponse testPersonaVoice(AppName app) {
    TestPersonaVoiceRequest request =
        TestPersonaVoiceRequest.newBuilder().setApp(app == null ? null : app.toString()).build();
    return testPersonaVoice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the voice of a persona. Also accepts a default persona.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String app = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   TestPersonaVoiceResponse response = evaluationServiceClient.testPersonaVoice(app);
   * }
   * }</pre>
   *
   * @param app Required. the resource name of the app to test the persona voice for. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPersonaVoiceResponse testPersonaVoice(String app) {
    TestPersonaVoiceRequest request = TestPersonaVoiceRequest.newBuilder().setApp(app).build();
    return testPersonaVoice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the voice of a persona. Also accepts a default persona.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   TestPersonaVoiceRequest request =
   *       TestPersonaVoiceRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPersonaId("personaId853188071")
   *           .setText("text3556653")
   *           .build();
   *   TestPersonaVoiceResponse response = evaluationServiceClient.testPersonaVoice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPersonaVoiceResponse testPersonaVoice(TestPersonaVoiceRequest request) {
    return testPersonaVoiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the voice of a persona. Also accepts a default persona.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   TestPersonaVoiceRequest request =
   *       TestPersonaVoiceRequest.newBuilder()
   *           .setApp(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPersonaId("personaId853188071")
   *           .setText("text3556653")
   *           .build();
   *   ApiFuture<TestPersonaVoiceResponse> future =
   *       evaluationServiceClient.testPersonaVoiceCallable().futureCall(request);
   *   // Do something.
   *   TestPersonaVoiceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceCallable() {
    return stub.testPersonaVoiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : evaluationServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       evaluationServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         evaluationServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = evaluationServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       evaluationServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationsPagedResponse> createAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      ApiFuture<ListEvaluationsPage> futurePage =
          ListEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationsPagedResponse(ListEvaluationsPage page) {
      super(page, ListEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationsPage
      extends AbstractPage<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation, ListEvaluationsPage> {

    private ListEvaluationsPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      super(context, response);
    }

    private static ListEvaluationsPage createEmptyPage() {
      return new ListEvaluationsPage(null, null);
    }

    @Override
    protected ListEvaluationsPage createPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      return new ListEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationsPage> createPageAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    private ListEvaluationsFixedSizeCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationsFixedSizeCollection createCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      return new ListEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationResultsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          EvaluationResult,
          ListEvaluationResultsPage,
          ListEvaluationResultsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationResultsPagedResponse> createAsync(
        PageContext<ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>
            context,
        ApiFuture<ListEvaluationResultsResponse> futureResponse) {
      ApiFuture<ListEvaluationResultsPage> futurePage =
          ListEvaluationResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationResultsPagedResponse(ListEvaluationResultsPage page) {
      super(page, ListEvaluationResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationResultsPage
      extends AbstractPage<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          EvaluationResult,
          ListEvaluationResultsPage> {

    private ListEvaluationResultsPage(
        PageContext<ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>
            context,
        ListEvaluationResultsResponse response) {
      super(context, response);
    }

    private static ListEvaluationResultsPage createEmptyPage() {
      return new ListEvaluationResultsPage(null, null);
    }

    @Override
    protected ListEvaluationResultsPage createPage(
        PageContext<ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>
            context,
        ListEvaluationResultsResponse response) {
      return new ListEvaluationResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationResultsPage> createPageAsync(
        PageContext<ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>
            context,
        ApiFuture<ListEvaluationResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          EvaluationResult,
          ListEvaluationResultsPage,
          ListEvaluationResultsFixedSizeCollection> {

    private ListEvaluationResultsFixedSizeCollection(
        List<ListEvaluationResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationResultsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationResultsFixedSizeCollection createCollection(
        List<ListEvaluationResultsPage> pages, int collectionSize) {
      return new ListEvaluationResultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          EvaluationDataset,
          ListEvaluationDatasetsPage,
          ListEvaluationDatasetsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationDatasetsPagedResponse> createAsync(
        PageContext<
                ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse, EvaluationDataset>
            context,
        ApiFuture<ListEvaluationDatasetsResponse> futureResponse) {
      ApiFuture<ListEvaluationDatasetsPage> futurePage =
          ListEvaluationDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationDatasetsPagedResponse(ListEvaluationDatasetsPage page) {
      super(page, ListEvaluationDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationDatasetsPage
      extends AbstractPage<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          EvaluationDataset,
          ListEvaluationDatasetsPage> {

    private ListEvaluationDatasetsPage(
        PageContext<
                ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse, EvaluationDataset>
            context,
        ListEvaluationDatasetsResponse response) {
      super(context, response);
    }

    private static ListEvaluationDatasetsPage createEmptyPage() {
      return new ListEvaluationDatasetsPage(null, null);
    }

    @Override
    protected ListEvaluationDatasetsPage createPage(
        PageContext<
                ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse, EvaluationDataset>
            context,
        ListEvaluationDatasetsResponse response) {
      return new ListEvaluationDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationDatasetsPage> createPageAsync(
        PageContext<
                ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse, EvaluationDataset>
            context,
        ApiFuture<ListEvaluationDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          EvaluationDataset,
          ListEvaluationDatasetsPage,
          ListEvaluationDatasetsFixedSizeCollection> {

    private ListEvaluationDatasetsFixedSizeCollection(
        List<ListEvaluationDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationDatasetsFixedSizeCollection createCollection(
        List<ListEvaluationDatasetsPage> pages, int collectionSize) {
      return new ListEvaluationDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationRunsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationRunsRequest,
          ListEvaluationRunsResponse,
          EvaluationRun,
          ListEvaluationRunsPage,
          ListEvaluationRunsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationRunsPagedResponse> createAsync(
        PageContext<ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun> context,
        ApiFuture<ListEvaluationRunsResponse> futureResponse) {
      ApiFuture<ListEvaluationRunsPage> futurePage =
          ListEvaluationRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationRunsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationRunsPagedResponse(ListEvaluationRunsPage page) {
      super(page, ListEvaluationRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationRunsPage
      extends AbstractPage<
          ListEvaluationRunsRequest,
          ListEvaluationRunsResponse,
          EvaluationRun,
          ListEvaluationRunsPage> {

    private ListEvaluationRunsPage(
        PageContext<ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun> context,
        ListEvaluationRunsResponse response) {
      super(context, response);
    }

    private static ListEvaluationRunsPage createEmptyPage() {
      return new ListEvaluationRunsPage(null, null);
    }

    @Override
    protected ListEvaluationRunsPage createPage(
        PageContext<ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun> context,
        ListEvaluationRunsResponse response) {
      return new ListEvaluationRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationRunsPage> createPageAsync(
        PageContext<ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun> context,
        ApiFuture<ListEvaluationRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationRunsRequest,
          ListEvaluationRunsResponse,
          EvaluationRun,
          ListEvaluationRunsPage,
          ListEvaluationRunsFixedSizeCollection> {

    private ListEvaluationRunsFixedSizeCollection(
        List<ListEvaluationRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationRunsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationRunsFixedSizeCollection createCollection(
        List<ListEvaluationRunsPage> pages, int collectionSize) {
      return new ListEvaluationRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationExpectationsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          EvaluationExpectation,
          ListEvaluationExpectationsPage,
          ListEvaluationExpectationsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationExpectationsPagedResponse> createAsync(
        PageContext<
                ListEvaluationExpectationsRequest,
                ListEvaluationExpectationsResponse,
                EvaluationExpectation>
            context,
        ApiFuture<ListEvaluationExpectationsResponse> futureResponse) {
      ApiFuture<ListEvaluationExpectationsPage> futurePage =
          ListEvaluationExpectationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationExpectationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationExpectationsPagedResponse(ListEvaluationExpectationsPage page) {
      super(page, ListEvaluationExpectationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationExpectationsPage
      extends AbstractPage<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          EvaluationExpectation,
          ListEvaluationExpectationsPage> {

    private ListEvaluationExpectationsPage(
        PageContext<
                ListEvaluationExpectationsRequest,
                ListEvaluationExpectationsResponse,
                EvaluationExpectation>
            context,
        ListEvaluationExpectationsResponse response) {
      super(context, response);
    }

    private static ListEvaluationExpectationsPage createEmptyPage() {
      return new ListEvaluationExpectationsPage(null, null);
    }

    @Override
    protected ListEvaluationExpectationsPage createPage(
        PageContext<
                ListEvaluationExpectationsRequest,
                ListEvaluationExpectationsResponse,
                EvaluationExpectation>
            context,
        ListEvaluationExpectationsResponse response) {
      return new ListEvaluationExpectationsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationExpectationsPage> createPageAsync(
        PageContext<
                ListEvaluationExpectationsRequest,
                ListEvaluationExpectationsResponse,
                EvaluationExpectation>
            context,
        ApiFuture<ListEvaluationExpectationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationExpectationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          EvaluationExpectation,
          ListEvaluationExpectationsPage,
          ListEvaluationExpectationsFixedSizeCollection> {

    private ListEvaluationExpectationsFixedSizeCollection(
        List<ListEvaluationExpectationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationExpectationsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationExpectationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationExpectationsFixedSizeCollection createCollection(
        List<ListEvaluationExpectationsPage> pages, int collectionSize) {
      return new ListEvaluationExpectationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListScheduledEvaluationRunsPagedResponse
      extends AbstractPagedListResponse<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ScheduledEvaluationRun,
          ListScheduledEvaluationRunsPage,
          ListScheduledEvaluationRunsFixedSizeCollection> {

    public static ApiFuture<ListScheduledEvaluationRunsPagedResponse> createAsync(
        PageContext<
                ListScheduledEvaluationRunsRequest,
                ListScheduledEvaluationRunsResponse,
                ScheduledEvaluationRun>
            context,
        ApiFuture<ListScheduledEvaluationRunsResponse> futureResponse) {
      ApiFuture<ListScheduledEvaluationRunsPage> futurePage =
          ListScheduledEvaluationRunsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListScheduledEvaluationRunsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListScheduledEvaluationRunsPagedResponse(ListScheduledEvaluationRunsPage page) {
      super(page, ListScheduledEvaluationRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScheduledEvaluationRunsPage
      extends AbstractPage<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ScheduledEvaluationRun,
          ListScheduledEvaluationRunsPage> {

    private ListScheduledEvaluationRunsPage(
        PageContext<
                ListScheduledEvaluationRunsRequest,
                ListScheduledEvaluationRunsResponse,
                ScheduledEvaluationRun>
            context,
        ListScheduledEvaluationRunsResponse response) {
      super(context, response);
    }

    private static ListScheduledEvaluationRunsPage createEmptyPage() {
      return new ListScheduledEvaluationRunsPage(null, null);
    }

    @Override
    protected ListScheduledEvaluationRunsPage createPage(
        PageContext<
                ListScheduledEvaluationRunsRequest,
                ListScheduledEvaluationRunsResponse,
                ScheduledEvaluationRun>
            context,
        ListScheduledEvaluationRunsResponse response) {
      return new ListScheduledEvaluationRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListScheduledEvaluationRunsPage> createPageAsync(
        PageContext<
                ListScheduledEvaluationRunsRequest,
                ListScheduledEvaluationRunsResponse,
                ScheduledEvaluationRun>
            context,
        ApiFuture<ListScheduledEvaluationRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScheduledEvaluationRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ScheduledEvaluationRun,
          ListScheduledEvaluationRunsPage,
          ListScheduledEvaluationRunsFixedSizeCollection> {

    private ListScheduledEvaluationRunsFixedSizeCollection(
        List<ListScheduledEvaluationRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScheduledEvaluationRunsFixedSizeCollection createEmptyCollection() {
      return new ListScheduledEvaluationRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScheduledEvaluationRunsFixedSizeCollection createCollection(
        List<ListScheduledEvaluationRunsPage> pages, int collectionSize) {
      return new ListScheduledEvaluationRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
