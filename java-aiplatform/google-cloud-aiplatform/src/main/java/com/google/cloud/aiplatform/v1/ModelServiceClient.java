/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.stub.ModelServiceStub;
import com.google.cloud.aiplatform.v1.stub.ModelServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing Vertex AI's machine learning Models.
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
 * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
 *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
 *   Model response = modelServiceClient.getModel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ModelServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> UploadModel</td>
 *      <td><p> Uploads a Model artifact into Vertex AI.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadModelAsync(UploadModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> uploadModelAsync(LocationName parent, Model model)
 *           <li><p> uploadModelAsync(String parent, Model model)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadModelOperationCallable()
 *           <li><p> uploadModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetModel</td>
 *      <td><p> Gets a Model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getModel(GetModelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getModel(ModelName name)
 *           <li><p> getModel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModels</td>
 *      <td><p> Lists Models in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModels(ListModelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModels(LocationName parent)
 *           <li><p> listModels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listModelsPagedCallable()
 *           <li><p> listModelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModelVersions</td>
 *      <td><p> Lists versions of the specified model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModelVersions(ListModelVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModelVersions(ModelName name)
 *           <li><p> listModelVersions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listModelVersionsPagedCallable()
 *           <li><p> listModelVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateModel</td>
 *      <td><p> Updates a Model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateModel(UpdateModelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateModel(Model model, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExplanationDataset</td>
 *      <td><p> Incrementally update the dataset used for an examples model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExplanationDatasetAsync(UpdateExplanationDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateExplanationDatasetAsync(ModelName model)
 *           <li><p> updateExplanationDatasetAsync(String model)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExplanationDatasetOperationCallable()
 *           <li><p> updateExplanationDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteModel</td>
 *      <td><p> Deletes a Model.
 * <p>  A model cannot be deleted if any [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource has a [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the model in its [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models] field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteModelAsync(DeleteModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteModelAsync(ModelName name)
 *           <li><p> deleteModelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteModelOperationCallable()
 *           <li><p> deleteModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteModelVersion</td>
 *      <td><p> Deletes a Model version.
 * <p>  Model version can only be deleted if there are no [DeployedModels][google.cloud.aiplatform.v1.DeployedModel] created from it. Deleting the only version in the Model is not allowed. Use [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for deleting the Model instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteModelVersionAsync(DeleteModelVersionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteModelVersionAsync(ModelName name)
 *           <li><p> deleteModelVersionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteModelVersionOperationCallable()
 *           <li><p> deleteModelVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MergeVersionAliases</td>
 *      <td><p> Merges a set of aliases for a Model version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> mergeVersionAliases(MergeVersionAliasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> mergeVersionAliases(ModelName name, List&lt;String&gt; versionAliases)
 *           <li><p> mergeVersionAliases(String name, List&lt;String&gt; versionAliases)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> mergeVersionAliasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportModel</td>
 *      <td><p> Exports a trained, exportable Model to a location specified by the user. A Model is considered to be exportable if it has at least one [supported export format][google.cloud.aiplatform.v1.Model.supported_export_formats].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportModelAsync(ExportModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportModelAsync(ModelName name, ExportModelRequest.OutputConfig outputConfig)
 *           <li><p> exportModelAsync(String name, ExportModelRequest.OutputConfig outputConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportModelOperationCallable()
 *           <li><p> exportModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CopyModel</td>
 *      <td><p> Copies an already existing Vertex AI Model into the specified Location. The source Model must exist in the same Project. When copying custom Models, the users themselves are responsible for [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as well as making sure that any resources (e.g. files) it depends on remain accessible.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> copyModelAsync(CopyModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> copyModelAsync(LocationName parent, ModelName sourceModel)
 *           <li><p> copyModelAsync(LocationName parent, String sourceModel)
 *           <li><p> copyModelAsync(String parent, ModelName sourceModel)
 *           <li><p> copyModelAsync(String parent, String sourceModel)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> copyModelOperationCallable()
 *           <li><p> copyModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportModelEvaluation</td>
 *      <td><p> Imports an externally generated ModelEvaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importModelEvaluation(ImportModelEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importModelEvaluation(ModelName parent, ModelEvaluation modelEvaluation)
 *           <li><p> importModelEvaluation(String parent, ModelEvaluation modelEvaluation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importModelEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchImportModelEvaluationSlices</td>
 *      <td><p> Imports a list of externally generated ModelEvaluationSlice.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchImportModelEvaluationSlices(BatchImportModelEvaluationSlicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchImportModelEvaluationSlices(ModelEvaluationName parent, List&lt;ModelEvaluationSlice&gt; modelEvaluationSlices)
 *           <li><p> batchImportModelEvaluationSlices(String parent, List&lt;ModelEvaluationSlice&gt; modelEvaluationSlices)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchImportModelEvaluationSlicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchImportEvaluatedAnnotations</td>
 *      <td><p> Imports a list of externally generated EvaluatedAnnotations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchImportEvaluatedAnnotations(BatchImportEvaluatedAnnotationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchImportEvaluatedAnnotations(ModelEvaluationSliceName parent, List&lt;EvaluatedAnnotation&gt; evaluatedAnnotations)
 *           <li><p> batchImportEvaluatedAnnotations(String parent, List&lt;EvaluatedAnnotation&gt; evaluatedAnnotations)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchImportEvaluatedAnnotationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetModelEvaluation</td>
 *      <td><p> Gets a ModelEvaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getModelEvaluation(GetModelEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getModelEvaluation(ModelEvaluationName name)
 *           <li><p> getModelEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getModelEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModelEvaluations</td>
 *      <td><p> Lists ModelEvaluations in a Model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModelEvaluations(ListModelEvaluationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModelEvaluations(ModelName parent)
 *           <li><p> listModelEvaluations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listModelEvaluationsPagedCallable()
 *           <li><p> listModelEvaluationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetModelEvaluationSlice</td>
 *      <td><p> Gets a ModelEvaluationSlice.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getModelEvaluationSlice(GetModelEvaluationSliceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getModelEvaluationSlice(ModelEvaluationSliceName name)
 *           <li><p> getModelEvaluationSlice(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getModelEvaluationSliceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModelEvaluationSlices</td>
 *      <td><p> Lists ModelEvaluationSlices in a ModelEvaluation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModelEvaluationSlices(ListModelEvaluationSlicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModelEvaluationSlices(ModelEvaluationName parent)
 *           <li><p> listModelEvaluationSlices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listModelEvaluationSlicesPagedCallable()
 *           <li><p> listModelEvaluationSlicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
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
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ModelServiceSettings to
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
 * ModelServiceSettings modelServiceSettings =
 *     ModelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
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
 * ModelServiceSettings modelServiceSettings =
 *     ModelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ModelServiceClient implements BackgroundResource {
  private final ModelServiceSettings settings;
  private final ModelServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ModelServiceClient with default settings. */
  public static final ModelServiceClient create() throws IOException {
    return create(ModelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ModelServiceClient create(ModelServiceSettings settings) throws IOException {
    return new ModelServiceClient(settings);
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ModelServiceSettings).
   */
  public static final ModelServiceClient create(ModelServiceStub stub) {
    return new ModelServiceClient(stub);
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ModelServiceClient(ModelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ModelServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ModelServiceClient(ModelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ModelServiceSettings getSettings() {
    return settings;
  }

  public ModelServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into Vertex AI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Model model = Model.newBuilder().build();
   *   UploadModelResponse response = modelServiceClient.uploadModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to upload the Model.
   *     Format: `projects/{project}/locations/{location}`
   * @param model Required. The Model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelAsync(
      LocationName parent, Model model) {
    UploadModelRequest request =
        UploadModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .build();
    return uploadModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into Vertex AI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Model model = Model.newBuilder().build();
   *   UploadModelResponse response = modelServiceClient.uploadModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to upload the Model.
   *     Format: `projects/{project}/locations/{location}`
   * @param model Required. The Model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelAsync(
      String parent, Model model) {
    UploadModelRequest request =
        UploadModelRequest.newBuilder().setParent(parent).setModel(model).build();
    return uploadModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into Vertex AI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UploadModelRequest request =
   *       UploadModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setParentModel("parentModel998431903")
   *           .setModelId("modelId1226956324")
   *           .setModel(Model.newBuilder().build())
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   UploadModelResponse response = modelServiceClient.uploadModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelAsync(
      UploadModelRequest request) {
    return uploadModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into Vertex AI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UploadModelRequest request =
   *       UploadModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setParentModel("parentModel998431903")
   *           .setModelId("modelId1226956324")
   *           .setModel(Model.newBuilder().build())
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   OperationFuture<UploadModelResponse, UploadModelOperationMetadata> future =
   *       modelServiceClient.uploadModelOperationCallable().futureCall(request);
   *   // Do something.
   *   UploadModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationCallable() {
    return stub.uploadModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a Model artifact into Vertex AI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UploadModelRequest request =
   *       UploadModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setParentModel("parentModel998431903")
   *           .setModelId("modelId1226956324")
   *           .setModel(Model.newBuilder().build())
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.uploadModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadModelRequest, Operation> uploadModelCallable() {
    return stub.uploadModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   Model response = modelServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   *     <p>In order to retrieve a specific version of the model, also provide the version ID or
   *     version alias. Example:
   *     `projects/{project}/locations/{location}/models/{model}{@literal @}2` or
   *     `projects/{project}/locations/{location}/models/{model}{@literal @}golden` If no version ID
   *     or alias is specified, the "default" version will be returned. The "default" version alias
   *     is created for the first version of the model, and can be moved to other versions later on.
   *     There will be exactly one default version.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(ModelName name) {
    GetModelRequest request =
        GetModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   Model response = modelServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   *     <p>In order to retrieve a specific version of the model, also provide the version ID or
   *     version alias. Example:
   *     `projects/{project}/locations/{location}/models/{model}{@literal @}2` or
   *     `projects/{project}/locations/{location}/models/{model}{@literal @}golden` If no version ID
   *     or alias is specified, the "default" version will be returned. The "default" version alias
   *     is created for the first version of the model, and can be moved to other versions later on.
   *     There will be exactly one default version.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(String name) {
    GetModelRequest request = GetModelRequest.newBuilder().setName(name).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   Model response = modelServiceClient.getModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(GetModelRequest request) {
    return getModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.getModelCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return stub.getModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Model element : modelServiceClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Models from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(LocationName parent) {
    ListModelsRequest request =
        ListModelsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Model element : modelServiceClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Models from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(String parent) {
    ListModelsRequest request = ListModelsRequest.newBuilder().setParent(parent).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Model element : modelServiceClient.listModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(ListModelsRequest request) {
    return listModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.listModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Model element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return stub.listModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Models in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListModelsResponse response = modelServiceClient.listModelsCallable().call(request);
   *     for (Model element : response.getModelsList()) {
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
  public final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return stub.listModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions of the specified model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   for (Model element : modelServiceClient.listModelVersions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the model to list versions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelVersionsPagedResponse listModelVersions(ModelName name) {
    ListModelVersionsRequest request =
        ListModelVersionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listModelVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions of the specified model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   for (Model element : modelServiceClient.listModelVersions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the model to list versions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelVersionsPagedResponse listModelVersions(String name) {
    ListModelVersionsRequest request = ListModelVersionsRequest.newBuilder().setName(name).build();
    return listModelVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions of the specified model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelVersionsRequest request =
   *       ListModelVersionsRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Model element : modelServiceClient.listModelVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelVersionsPagedResponse listModelVersions(ListModelVersionsRequest request) {
    return listModelVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions of the specified model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelVersionsRequest request =
   *       ListModelVersionsRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Model> future =
   *       modelServiceClient.listModelVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Model element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelVersionsRequest, ListModelVersionsPagedResponse>
      listModelVersionsPagedCallable() {
    return stub.listModelVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists versions of the specified model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelVersionsRequest request =
   *       ListModelVersionsRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListModelVersionsResponse response =
   *         modelServiceClient.listModelVersionsCallable().call(request);
   *     for (Model element : response.getModelsList()) {
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
  public final UnaryCallable<ListModelVersionsRequest, ListModelVersionsResponse>
      listModelVersionsCallable() {
    return stub.listModelVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   Model model = Model.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Model response = modelServiceClient.updateModel(model, updateMask);
   * }
   * }</pre>
   *
   * @param model Required. The Model which replaces the resource on the server. When Model
   *     Versioning is enabled, the model.name will be used to determine whether to update the model
   *     or model version. 1. model.name with the {@literal @} value, e.g. models/123{@literal @}1,
   *     refers to a version specific update. 2. model.name without the {@literal @} value, e.g.
   *     models/123, refers to a model update. 3. model.name with {@literal @}-, e.g.
   *     models/123{@literal @}-, refers to a model update. 4. Supported model fields: display_name,
   *     description; supported version-specific fields: version_description. Labels are supported
   *     in both scenarios. Both the model labels and the version labels are merged when a model is
   *     returned. When updating labels, if the request is for model-specific update, model label
   *     gets updated. Otherwise, version labels get updated. 5. A model name or model version name
   *     fields update mismatch will cause a precondition error. 6. One request cannot update both
   *     the model and the version fields. You must update them separately.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see [google.protobuf.FieldMask][google.protobuf.FieldMask].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model updateModel(Model model, FieldMask updateMask) {
    UpdateModelRequest request =
        UpdateModelRequest.newBuilder().setModel(model).setUpdateMask(updateMask).build();
    return updateModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setModel(Model.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Model response = modelServiceClient.updateModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model updateModel(UpdateModelRequest request) {
    return updateModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setModel(Model.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.updateModelCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return stub.updateModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally update the dataset used for an examples model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName model = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   UpdateExplanationDatasetResponse response =
   *       modelServiceClient.updateExplanationDatasetAsync(model).get();
   * }
   * }</pre>
   *
   * @param model Required. The resource name of the Model to update. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          UpdateExplanationDatasetResponse, UpdateExplanationDatasetOperationMetadata>
      updateExplanationDatasetAsync(ModelName model) {
    UpdateExplanationDatasetRequest request =
        UpdateExplanationDatasetRequest.newBuilder()
            .setModel(model == null ? null : model.toString())
            .build();
    return updateExplanationDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally update the dataset used for an examples model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String model = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   UpdateExplanationDatasetResponse response =
   *       modelServiceClient.updateExplanationDatasetAsync(model).get();
   * }
   * }</pre>
   *
   * @param model Required. The resource name of the Model to update. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          UpdateExplanationDatasetResponse, UpdateExplanationDatasetOperationMetadata>
      updateExplanationDatasetAsync(String model) {
    UpdateExplanationDatasetRequest request =
        UpdateExplanationDatasetRequest.newBuilder().setModel(model).build();
    return updateExplanationDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally update the dataset used for an examples model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateExplanationDatasetRequest request =
   *       UpdateExplanationDatasetRequest.newBuilder()
   *           .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setExamples(Examples.newBuilder().build())
   *           .build();
   *   UpdateExplanationDatasetResponse response =
   *       modelServiceClient.updateExplanationDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          UpdateExplanationDatasetResponse, UpdateExplanationDatasetOperationMetadata>
      updateExplanationDatasetAsync(UpdateExplanationDatasetRequest request) {
    return updateExplanationDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally update the dataset used for an examples model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateExplanationDatasetRequest request =
   *       UpdateExplanationDatasetRequest.newBuilder()
   *           .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setExamples(Examples.newBuilder().build())
   *           .build();
   *   OperationFuture<UpdateExplanationDatasetResponse, UpdateExplanationDatasetOperationMetadata>
   *       future =
   *           modelServiceClient.updateExplanationDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   UpdateExplanationDatasetResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateExplanationDatasetRequest,
          UpdateExplanationDatasetResponse,
          UpdateExplanationDatasetOperationMetadata>
      updateExplanationDatasetOperationCallable() {
    return stub.updateExplanationDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Incrementally update the dataset used for an examples model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateExplanationDatasetRequest request =
   *       UpdateExplanationDatasetRequest.newBuilder()
   *           .setModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setExamples(Examples.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelServiceClient.updateExplanationDatasetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExplanationDatasetRequest, Operation>
      updateExplanationDatasetCallable() {
    return stub.updateExplanationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model.
   *
   * <p>A model cannot be deleted if any [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource
   * has a [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the model in its
   * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   modelServiceClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelAsync(ModelName name) {
    DeleteModelRequest request =
        DeleteModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model.
   *
   * <p>A model cannot be deleted if any [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource
   * has a [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the model in its
   * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   modelServiceClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Model resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelAsync(String name) {
    DeleteModelRequest request = DeleteModelRequest.newBuilder().setName(name).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model.
   *
   * <p>A model cannot be deleted if any [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource
   * has a [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the model in its
   * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   modelServiceClient.deleteModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelAsync(
      DeleteModelRequest request) {
    return deleteModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model.
   *
   * <p>A model cannot be deleted if any [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource
   * has a [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the model in its
   * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       modelServiceClient.deleteModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationCallable() {
    return stub.deleteModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model.
   *
   * <p>A model cannot be deleted if any [Endpoint][google.cloud.aiplatform.v1.Endpoint] resource
   * has a [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] based on the model in its
   * [deployed_models][google.cloud.aiplatform.v1.Endpoint.deployed_models] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.deleteModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return stub.deleteModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model version.
   *
   * <p>Model version can only be deleted if there are no
   * [DeployedModels][google.cloud.aiplatform.v1.DeployedModel] created from it. Deleting the only
   * version in the Model is not allowed. Use
   * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for deleting the Model
   * instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   modelServiceClient.deleteModelVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the model version to be deleted, with a version ID explicitly
   *     included.
   *     <p>Example: `projects/{project}/locations/{location}/models/{model}{@literal @}1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelVersionAsync(
      ModelName name) {
    DeleteModelVersionRequest request =
        DeleteModelVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteModelVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model version.
   *
   * <p>Model version can only be deleted if there are no
   * [DeployedModels][google.cloud.aiplatform.v1.DeployedModel] created from it. Deleting the only
   * version in the Model is not allowed. Use
   * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for deleting the Model
   * instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   modelServiceClient.deleteModelVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the model version to be deleted, with a version ID explicitly
   *     included.
   *     <p>Example: `projects/{project}/locations/{location}/models/{model}{@literal @}1234`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelVersionAsync(
      String name) {
    DeleteModelVersionRequest request =
        DeleteModelVersionRequest.newBuilder().setName(name).build();
    return deleteModelVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model version.
   *
   * <p>Model version can only be deleted if there are no
   * [DeployedModels][google.cloud.aiplatform.v1.DeployedModel] created from it. Deleting the only
   * version in the Model is not allowed. Use
   * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for deleting the Model
   * instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelVersionRequest request =
   *       DeleteModelVersionRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   modelServiceClient.deleteModelVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelVersionAsync(
      DeleteModelVersionRequest request) {
    return deleteModelVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model version.
   *
   * <p>Model version can only be deleted if there are no
   * [DeployedModels][google.cloud.aiplatform.v1.DeployedModel] created from it. Deleting the only
   * version in the Model is not allowed. Use
   * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for deleting the Model
   * instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelVersionRequest request =
   *       DeleteModelVersionRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       modelServiceClient.deleteModelVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelVersionRequest, Empty, DeleteOperationMetadata>
      deleteModelVersionOperationCallable() {
    return stub.deleteModelVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Model version.
   *
   * <p>Model version can only be deleted if there are no
   * [DeployedModels][google.cloud.aiplatform.v1.DeployedModel] created from it. Deleting the only
   * version in the Model is not allowed. Use
   * [DeleteModel][google.cloud.aiplatform.v1.ModelService.DeleteModel] for deleting the Model
   * instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteModelVersionRequest request =
   *       DeleteModelVersionRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelServiceClient.deleteModelVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteModelVersionRequest, Operation> deleteModelVersionCallable() {
    return stub.deleteModelVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a set of aliases for a Model version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   List<String> versionAliases = new ArrayList<>();
   *   Model response = modelServiceClient.mergeVersionAliases(name, versionAliases);
   * }
   * }</pre>
   *
   * @param name Required. The name of the model version to merge aliases, with a version ID
   *     explicitly included.
   *     <p>Example: `projects/{project}/locations/{location}/models/{model}{@literal @}1234`
   * @param versionAliases Required. The set of version aliases to merge. The alias should be at
   *     most 128 characters, and match `[a-z][a-zA-Z0-9-]{0,126}[a-z-0-9]`. Add the `-` prefix to
   *     an alias means removing that alias from the version. `-` is NOT counted in the 128
   *     characters. Example: `-golden` means removing the `golden` alias from the version.
   *     <p>There is NO ordering in aliases, which means 1) The aliases returned from GetModel API
   *     might not have the exactly same order from this MergeVersionAliases API. 2) Adding and
   *     deleting the same alias in the request is not recommended, and the 2 operations will be
   *     cancelled out.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model mergeVersionAliases(ModelName name, List<String> versionAliases) {
    MergeVersionAliasesRequest request =
        MergeVersionAliasesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllVersionAliases(versionAliases)
            .build();
    return mergeVersionAliases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a set of aliases for a Model version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   List<String> versionAliases = new ArrayList<>();
   *   Model response = modelServiceClient.mergeVersionAliases(name, versionAliases);
   * }
   * }</pre>
   *
   * @param name Required. The name of the model version to merge aliases, with a version ID
   *     explicitly included.
   *     <p>Example: `projects/{project}/locations/{location}/models/{model}{@literal @}1234`
   * @param versionAliases Required. The set of version aliases to merge. The alias should be at
   *     most 128 characters, and match `[a-z][a-zA-Z0-9-]{0,126}[a-z-0-9]`. Add the `-` prefix to
   *     an alias means removing that alias from the version. `-` is NOT counted in the 128
   *     characters. Example: `-golden` means removing the `golden` alias from the version.
   *     <p>There is NO ordering in aliases, which means 1) The aliases returned from GetModel API
   *     might not have the exactly same order from this MergeVersionAliases API. 2) Adding and
   *     deleting the same alias in the request is not recommended, and the 2 operations will be
   *     cancelled out.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model mergeVersionAliases(String name, List<String> versionAliases) {
    MergeVersionAliasesRequest request =
        MergeVersionAliasesRequest.newBuilder()
            .setName(name)
            .addAllVersionAliases(versionAliases)
            .build();
    return mergeVersionAliases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a set of aliases for a Model version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   MergeVersionAliasesRequest request =
   *       MergeVersionAliasesRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .addAllVersionAliases(new ArrayList<String>())
   *           .build();
   *   Model response = modelServiceClient.mergeVersionAliases(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model mergeVersionAliases(MergeVersionAliasesRequest request) {
    return mergeVersionAliasesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges a set of aliases for a Model version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   MergeVersionAliasesRequest request =
   *       MergeVersionAliasesRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .addAllVersionAliases(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Model> future =
   *       modelServiceClient.mergeVersionAliasesCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MergeVersionAliasesRequest, Model> mergeVersionAliasesCallable() {
    return stub.mergeVersionAliasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExportModelRequest.OutputConfig outputConfig =
   *       ExportModelRequest.OutputConfig.newBuilder().build();
   *   ExportModelResponse response = modelServiceClient.exportModelAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model to export. The resource name may contain
   *     version id or version alias to specify the version, if no version is specified, the default
   *     version will be exported.
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelResponse, ExportModelOperationMetadata> exportModelAsync(
      ModelName name, ExportModelRequest.OutputConfig outputConfig) {
    ExportModelRequest request =
        ExportModelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOutputConfig(outputConfig)
            .build();
    return exportModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   ExportModelRequest.OutputConfig outputConfig =
   *       ExportModelRequest.OutputConfig.newBuilder().build();
   *   ExportModelResponse response = modelServiceClient.exportModelAsync(name, outputConfig).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model to export. The resource name may contain
   *     version id or version alias to specify the version, if no version is specified, the default
   *     version will be exported.
   * @param outputConfig Required. The desired output location and configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelResponse, ExportModelOperationMetadata> exportModelAsync(
      String name, ExportModelRequest.OutputConfig outputConfig) {
    ExportModelRequest request =
        ExportModelRequest.newBuilder().setName(name).setOutputConfig(outputConfig).build();
    return exportModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportModelRequest.OutputConfig.newBuilder().build())
   *           .build();
   *   ExportModelResponse response = modelServiceClient.exportModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelResponse, ExportModelOperationMetadata> exportModelAsync(
      ExportModelRequest request) {
    return exportModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportModelRequest.OutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportModelResponse, ExportModelOperationMetadata> future =
   *       modelServiceClient.exportModelOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationCallable() {
    return stub.exportModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a trained, exportable Model to a location specified by the user. A Model is considered
   * to be exportable if it has at least one [supported export
   * format][google.cloud.aiplatform.v1.Model.supported_export_formats].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ExportModelRequest request =
   *       ExportModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setOutputConfig(ExportModelRequest.OutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.exportModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    return stub.exportModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ModelName sourceModel = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   CopyModelResponse response = modelServiceClient.copyModelAsync(parent, sourceModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to copy the Model. Format:
   *     `projects/{project}/locations/{location}`
   * @param sourceModel Required. The resource name of the Model to copy. That Model must be in the
   *     same Project. Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CopyModelResponse, CopyModelOperationMetadata> copyModelAsync(
      LocationName parent, ModelName sourceModel) {
    CopyModelRequest request =
        CopyModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceModel(sourceModel == null ? null : sourceModel.toString())
            .build();
    return copyModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String sourceModel = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   CopyModelResponse response = modelServiceClient.copyModelAsync(parent, sourceModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to copy the Model. Format:
   *     `projects/{project}/locations/{location}`
   * @param sourceModel Required. The resource name of the Model to copy. That Model must be in the
   *     same Project. Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CopyModelResponse, CopyModelOperationMetadata> copyModelAsync(
      LocationName parent, String sourceModel) {
    CopyModelRequest request =
        CopyModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceModel(sourceModel)
            .build();
    return copyModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ModelName sourceModel = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   CopyModelResponse response = modelServiceClient.copyModelAsync(parent, sourceModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to copy the Model. Format:
   *     `projects/{project}/locations/{location}`
   * @param sourceModel Required. The resource name of the Model to copy. That Model must be in the
   *     same Project. Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CopyModelResponse, CopyModelOperationMetadata> copyModelAsync(
      String parent, ModelName sourceModel) {
    CopyModelRequest request =
        CopyModelRequest.newBuilder()
            .setParent(parent)
            .setSourceModel(sourceModel == null ? null : sourceModel.toString())
            .build();
    return copyModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String sourceModel = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   CopyModelResponse response = modelServiceClient.copyModelAsync(parent, sourceModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location into which to copy the Model. Format:
   *     `projects/{project}/locations/{location}`
   * @param sourceModel Required. The resource name of the Model to copy. That Model must be in the
   *     same Project. Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CopyModelResponse, CopyModelOperationMetadata> copyModelAsync(
      String parent, String sourceModel) {
    CopyModelRequest request =
        CopyModelRequest.newBuilder().setParent(parent).setSourceModel(sourceModel).build();
    return copyModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   CopyModelRequest request =
   *       CopyModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   CopyModelResponse response = modelServiceClient.copyModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CopyModelResponse, CopyModelOperationMetadata> copyModelAsync(
      CopyModelRequest request) {
    return copyModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   CopyModelRequest request =
   *       CopyModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   OperationFuture<CopyModelResponse, CopyModelOperationMetadata> future =
   *       modelServiceClient.copyModelOperationCallable().futureCall(request);
   *   // Do something.
   *   CopyModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CopyModelRequest, CopyModelResponse, CopyModelOperationMetadata>
      copyModelOperationCallable() {
    return stub.copyModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies an already existing Vertex AI Model into the specified Location. The source Model must
   * exist in the same Project. When copying custom Models, the users themselves are responsible for
   * [Model.metadata][google.cloud.aiplatform.v1.Model.metadata] content to be region-agnostic, as
   * well as making sure that any resources (e.g. files) it depends on remain accessible.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   CopyModelRequest request =
   *       CopyModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceModel(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = modelServiceClient.copyModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CopyModelRequest, Operation> copyModelCallable() {
    return stub.copyModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an externally generated ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ModelEvaluation modelEvaluation = ModelEvaluation.newBuilder().build();
   *   ModelEvaluation response = modelServiceClient.importModelEvaluation(parent, modelEvaluation);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent model resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @param modelEvaluation Required. Model evaluation resource to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation importModelEvaluation(
      ModelName parent, ModelEvaluation modelEvaluation) {
    ImportModelEvaluationRequest request =
        ImportModelEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModelEvaluation(modelEvaluation)
            .build();
    return importModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an externally generated ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   ModelEvaluation modelEvaluation = ModelEvaluation.newBuilder().build();
   *   ModelEvaluation response = modelServiceClient.importModelEvaluation(parent, modelEvaluation);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent model resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}`
   * @param modelEvaluation Required. Model evaluation resource to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation importModelEvaluation(
      String parent, ModelEvaluation modelEvaluation) {
    ImportModelEvaluationRequest request =
        ImportModelEvaluationRequest.newBuilder()
            .setParent(parent)
            .setModelEvaluation(modelEvaluation)
            .build();
    return importModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an externally generated ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ImportModelEvaluationRequest request =
   *       ImportModelEvaluationRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setModelEvaluation(ModelEvaluation.newBuilder().build())
   *           .build();
   *   ModelEvaluation response = modelServiceClient.importModelEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation importModelEvaluation(ImportModelEvaluationRequest request) {
    return importModelEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an externally generated ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ImportModelEvaluationRequest request =
   *       ImportModelEvaluationRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setModelEvaluation(ModelEvaluation.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       modelServiceClient.importModelEvaluationCallable().futureCall(request);
   *   // Do something.
   *   ModelEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportModelEvaluationRequest, ModelEvaluation>
      importModelEvaluationCallable() {
    return stub.importModelEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationName parent =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
   *   List<ModelEvaluationSlice> modelEvaluationSlices = new ArrayList<>();
   *   BatchImportModelEvaluationSlicesResponse response =
   *       modelServiceClient.batchImportModelEvaluationSlices(parent, modelEvaluationSlices);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent ModelEvaluation resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @param modelEvaluationSlices Required. Model evaluation slice resource to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchImportModelEvaluationSlicesResponse batchImportModelEvaluationSlices(
      ModelEvaluationName parent, List<ModelEvaluationSlice> modelEvaluationSlices) {
    BatchImportModelEvaluationSlicesRequest request =
        BatchImportModelEvaluationSlicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllModelEvaluationSlices(modelEvaluationSlices)
            .build();
    return batchImportModelEvaluationSlices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]").toString();
   *   List<ModelEvaluationSlice> modelEvaluationSlices = new ArrayList<>();
   *   BatchImportModelEvaluationSlicesResponse response =
   *       modelServiceClient.batchImportModelEvaluationSlices(parent, modelEvaluationSlices);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent ModelEvaluation resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @param modelEvaluationSlices Required. Model evaluation slice resource to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchImportModelEvaluationSlicesResponse batchImportModelEvaluationSlices(
      String parent, List<ModelEvaluationSlice> modelEvaluationSlices) {
    BatchImportModelEvaluationSlicesRequest request =
        BatchImportModelEvaluationSlicesRequest.newBuilder()
            .setParent(parent)
            .addAllModelEvaluationSlices(modelEvaluationSlices)
            .build();
    return batchImportModelEvaluationSlices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   BatchImportModelEvaluationSlicesRequest request =
   *       BatchImportModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .addAllModelEvaluationSlices(new ArrayList<ModelEvaluationSlice>())
   *           .build();
   *   BatchImportModelEvaluationSlicesResponse response =
   *       modelServiceClient.batchImportModelEvaluationSlices(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchImportModelEvaluationSlicesResponse batchImportModelEvaluationSlices(
      BatchImportModelEvaluationSlicesRequest request) {
    return batchImportModelEvaluationSlicesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   BatchImportModelEvaluationSlicesRequest request =
   *       BatchImportModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .addAllModelEvaluationSlices(new ArrayList<ModelEvaluationSlice>())
   *           .build();
   *   ApiFuture<BatchImportModelEvaluationSlicesResponse> future =
   *       modelServiceClient.batchImportModelEvaluationSlicesCallable().futureCall(request);
   *   // Do something.
   *   BatchImportModelEvaluationSlicesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchImportModelEvaluationSlicesRequest, BatchImportModelEvaluationSlicesResponse>
      batchImportModelEvaluationSlicesCallable() {
    return stub.batchImportModelEvaluationSlicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated EvaluatedAnnotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationSliceName parent =
   *       ModelEvaluationSliceName.of(
   *           "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]");
   *   List<EvaluatedAnnotation> evaluatedAnnotations = new ArrayList<>();
   *   BatchImportEvaluatedAnnotationsResponse response =
   *       modelServiceClient.batchImportEvaluatedAnnotations(parent, evaluatedAnnotations);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent ModelEvaluationSlice resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
   * @param evaluatedAnnotations Required. Evaluated annotations resource to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchImportEvaluatedAnnotationsResponse batchImportEvaluatedAnnotations(
      ModelEvaluationSliceName parent, List<EvaluatedAnnotation> evaluatedAnnotations) {
    BatchImportEvaluatedAnnotationsRequest request =
        BatchImportEvaluatedAnnotationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllEvaluatedAnnotations(evaluatedAnnotations)
            .build();
    return batchImportEvaluatedAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated EvaluatedAnnotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent =
   *       ModelEvaluationSliceName.of(
   *               "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *           .toString();
   *   List<EvaluatedAnnotation> evaluatedAnnotations = new ArrayList<>();
   *   BatchImportEvaluatedAnnotationsResponse response =
   *       modelServiceClient.batchImportEvaluatedAnnotations(parent, evaluatedAnnotations);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent ModelEvaluationSlice resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
   * @param evaluatedAnnotations Required. Evaluated annotations resource to be imported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchImportEvaluatedAnnotationsResponse batchImportEvaluatedAnnotations(
      String parent, List<EvaluatedAnnotation> evaluatedAnnotations) {
    BatchImportEvaluatedAnnotationsRequest request =
        BatchImportEvaluatedAnnotationsRequest.newBuilder()
            .setParent(parent)
            .addAllEvaluatedAnnotations(evaluatedAnnotations)
            .build();
    return batchImportEvaluatedAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated EvaluatedAnnotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   BatchImportEvaluatedAnnotationsRequest request =
   *       BatchImportEvaluatedAnnotationsRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationSliceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *                   .toString())
   *           .addAllEvaluatedAnnotations(new ArrayList<EvaluatedAnnotation>())
   *           .build();
   *   BatchImportEvaluatedAnnotationsResponse response =
   *       modelServiceClient.batchImportEvaluatedAnnotations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchImportEvaluatedAnnotationsResponse batchImportEvaluatedAnnotations(
      BatchImportEvaluatedAnnotationsRequest request) {
    return batchImportEvaluatedAnnotationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of externally generated EvaluatedAnnotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   BatchImportEvaluatedAnnotationsRequest request =
   *       BatchImportEvaluatedAnnotationsRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationSliceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *                   .toString())
   *           .addAllEvaluatedAnnotations(new ArrayList<EvaluatedAnnotation>())
   *           .build();
   *   ApiFuture<BatchImportEvaluatedAnnotationsResponse> future =
   *       modelServiceClient.batchImportEvaluatedAnnotationsCallable().futureCall(request);
   *   // Do something.
   *   BatchImportEvaluatedAnnotationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchImportEvaluatedAnnotationsRequest, BatchImportEvaluatedAnnotationsResponse>
      batchImportEvaluatedAnnotationsCallable() {
    return stub.batchImportEvaluatedAnnotationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationName name =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
   *   ModelEvaluation response = modelServiceClient.getModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluation resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(ModelEvaluationName name) {
    GetModelEvaluationRequest request =
        GetModelEvaluationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]").toString();
   *   ModelEvaluation response = modelServiceClient.getModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluation resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(String name) {
    GetModelEvaluationRequest request =
        GetModelEvaluationRequest.newBuilder().setName(name).build();
    return getModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationRequest request =
   *       GetModelEvaluationRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ModelEvaluation response = modelServiceClient.getModelEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluation getModelEvaluation(GetModelEvaluationRequest request) {
    return getModelEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationRequest request =
   *       GetModelEvaluationRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       modelServiceClient.getModelEvaluationCallable().futureCall(request);
   *   // Do something.
   *   ModelEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationCallable() {
    return stub.getModelEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   for (ModelEvaluation element : modelServiceClient.listModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Model to list the ModelEvaluations from.
   *     Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(ModelName parent) {
    ListModelEvaluationsRequest request =
        ListModelEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listModelEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   for (ModelEvaluation element : modelServiceClient.listModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Model to list the ModelEvaluations from.
   *     Format: `projects/{project}/locations/{location}/models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(String parent) {
    ListModelEvaluationsRequest request =
        ListModelEvaluationsRequest.newBuilder().setParent(parent).build();
    return listModelEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (ModelEvaluation element :
   *       modelServiceClient.listModelEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationsPagedResponse listModelEvaluations(
      ListModelEvaluationsRequest request) {
    return listModelEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelEvaluation> future =
   *       modelServiceClient.listModelEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ModelEvaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable() {
    return stub.listModelEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluations in a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationsRequest request =
   *       ListModelEvaluationsRequest.newBuilder()
   *           .setParent(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListModelEvaluationsResponse response =
   *         modelServiceClient.listModelEvaluationsCallable().call(request);
   *     for (ModelEvaluation element : response.getModelEvaluationsList()) {
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
  public final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable() {
    return stub.listModelEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationSliceName name =
   *       ModelEvaluationSliceName.of(
   *           "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]");
   *   ModelEvaluationSlice response = modelServiceClient.getModelEvaluationSlice(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluationSlice resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluationSlice getModelEvaluationSlice(ModelEvaluationSliceName name) {
    GetModelEvaluationSliceRequest request =
        GetModelEvaluationSliceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getModelEvaluationSlice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name =
   *       ModelEvaluationSliceName.of(
   *               "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *           .toString();
   *   ModelEvaluationSlice response = modelServiceClient.getModelEvaluationSlice(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelEvaluationSlice resource. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluationSlice getModelEvaluationSlice(String name) {
    GetModelEvaluationSliceRequest request =
        GetModelEvaluationSliceRequest.newBuilder().setName(name).build();
    return getModelEvaluationSlice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationSliceRequest request =
   *       GetModelEvaluationSliceRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationSliceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *                   .toString())
   *           .build();
   *   ModelEvaluationSlice response = modelServiceClient.getModelEvaluationSlice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelEvaluationSlice getModelEvaluationSlice(
      GetModelEvaluationSliceRequest request) {
    return getModelEvaluationSliceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelEvaluationSlice.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelEvaluationSliceRequest request =
   *       GetModelEvaluationSliceRequest.newBuilder()
   *           .setName(
   *               ModelEvaluationSliceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]", "[SLICE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ModelEvaluationSlice> future =
   *       modelServiceClient.getModelEvaluationSliceCallable().futureCall(request);
   *   // Do something.
   *   ModelEvaluationSlice response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceCallable() {
    return stub.getModelEvaluationSliceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelEvaluationName parent =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]");
   *   for (ModelEvaluationSlice element :
   *       modelServiceClient.listModelEvaluationSlices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ModelEvaluation to list the
   *     ModelEvaluationSlices from. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationSlicesPagedResponse listModelEvaluationSlices(
      ModelEvaluationName parent) {
    ListModelEvaluationSlicesRequest request =
        ListModelEvaluationSlicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listModelEvaluationSlices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String parent =
   *       ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]").toString();
   *   for (ModelEvaluationSlice element :
   *       modelServiceClient.listModelEvaluationSlices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ModelEvaluation to list the
   *     ModelEvaluationSlices from. Format:
   *     `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationSlicesPagedResponse listModelEvaluationSlices(String parent) {
    ListModelEvaluationSlicesRequest request =
        ListModelEvaluationSlicesRequest.newBuilder().setParent(parent).build();
    return listModelEvaluationSlices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationSlicesRequest request =
   *       ListModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (ModelEvaluationSlice element :
   *       modelServiceClient.listModelEvaluationSlices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelEvaluationSlicesPagedResponse listModelEvaluationSlices(
      ListModelEvaluationSlicesRequest request) {
    return listModelEvaluationSlicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationSlicesRequest request =
   *       ListModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelEvaluationSlice> future =
   *       modelServiceClient.listModelEvaluationSlicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ModelEvaluationSlice element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesPagedCallable() {
    return stub.listModelEvaluationSlicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelEvaluationSlices in a ModelEvaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelEvaluationSlicesRequest request =
   *       ListModelEvaluationSlicesRequest.newBuilder()
   *           .setParent(
   *               ModelEvaluationName.of("[PROJECT]", "[LOCATION]", "[MODEL]", "[EVALUATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListModelEvaluationSlicesResponse response =
   *         modelServiceClient.listModelEvaluationSlicesCallable().call(request);
   *     for (ModelEvaluationSlice element : response.getModelEvaluationSlicesList()) {
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
  public final UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesCallable() {
    return stub.listModelEvaluationSlicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : modelServiceClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       modelServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = modelServiceClient.listLocationsCallable().call(request);
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
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = modelServiceClient.getLocation(request);
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
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = modelServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = modelServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = modelServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = modelServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = modelServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = modelServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       modelServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListModelsPagedResponse
      extends AbstractPagedListResponse<
          ListModelsRequest,
          ListModelsResponse,
          Model,
          ListModelsPage,
          ListModelsFixedSizeCollection> {

    public static ApiFuture<ListModelsPagedResponse> createAsync(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ApiFuture<ListModelsResponse> futureResponse) {
      ApiFuture<ListModelsPage> futurePage =
          ListModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListModelsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListModelsPagedResponse(ListModelsPage page) {
      super(page, ListModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelsPage
      extends AbstractPage<ListModelsRequest, ListModelsResponse, Model, ListModelsPage> {

    private ListModelsPage(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ListModelsResponse response) {
      super(context, response);
    }

    private static ListModelsPage createEmptyPage() {
      return new ListModelsPage(null, null);
    }

    @Override
    protected ListModelsPage createPage(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ListModelsResponse response) {
      return new ListModelsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelsPage> createPageAsync(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ApiFuture<ListModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelsRequest,
          ListModelsResponse,
          Model,
          ListModelsPage,
          ListModelsFixedSizeCollection> {

    private ListModelsFixedSizeCollection(List<ListModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelsFixedSizeCollection createEmptyCollection() {
      return new ListModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelsFixedSizeCollection createCollection(
        List<ListModelsPage> pages, int collectionSize) {
      return new ListModelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListModelVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListModelVersionsRequest,
          ListModelVersionsResponse,
          Model,
          ListModelVersionsPage,
          ListModelVersionsFixedSizeCollection> {

    public static ApiFuture<ListModelVersionsPagedResponse> createAsync(
        PageContext<ListModelVersionsRequest, ListModelVersionsResponse, Model> context,
        ApiFuture<ListModelVersionsResponse> futureResponse) {
      ApiFuture<ListModelVersionsPage> futurePage =
          ListModelVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListModelVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListModelVersionsPagedResponse(ListModelVersionsPage page) {
      super(page, ListModelVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelVersionsPage
      extends AbstractPage<
          ListModelVersionsRequest, ListModelVersionsResponse, Model, ListModelVersionsPage> {

    private ListModelVersionsPage(
        PageContext<ListModelVersionsRequest, ListModelVersionsResponse, Model> context,
        ListModelVersionsResponse response) {
      super(context, response);
    }

    private static ListModelVersionsPage createEmptyPage() {
      return new ListModelVersionsPage(null, null);
    }

    @Override
    protected ListModelVersionsPage createPage(
        PageContext<ListModelVersionsRequest, ListModelVersionsResponse, Model> context,
        ListModelVersionsResponse response) {
      return new ListModelVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelVersionsPage> createPageAsync(
        PageContext<ListModelVersionsRequest, ListModelVersionsResponse, Model> context,
        ApiFuture<ListModelVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelVersionsRequest,
          ListModelVersionsResponse,
          Model,
          ListModelVersionsPage,
          ListModelVersionsFixedSizeCollection> {

    private ListModelVersionsFixedSizeCollection(
        List<ListModelVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelVersionsFixedSizeCollection createEmptyCollection() {
      return new ListModelVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelVersionsFixedSizeCollection createCollection(
        List<ListModelVersionsPage> pages, int collectionSize) {
      return new ListModelVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListModelEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ModelEvaluation,
          ListModelEvaluationsPage,
          ListModelEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListModelEvaluationsPagedResponse> createAsync(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ApiFuture<ListModelEvaluationsResponse> futureResponse) {
      ApiFuture<ListModelEvaluationsPage> futurePage =
          ListModelEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListModelEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListModelEvaluationsPagedResponse(ListModelEvaluationsPage page) {
      super(page, ListModelEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelEvaluationsPage
      extends AbstractPage<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ModelEvaluation,
          ListModelEvaluationsPage> {

    private ListModelEvaluationsPage(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ListModelEvaluationsResponse response) {
      super(context, response);
    }

    private static ListModelEvaluationsPage createEmptyPage() {
      return new ListModelEvaluationsPage(null, null);
    }

    @Override
    protected ListModelEvaluationsPage createPage(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ListModelEvaluationsResponse response) {
      return new ListModelEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelEvaluationsPage> createPageAsync(
        PageContext<ListModelEvaluationsRequest, ListModelEvaluationsResponse, ModelEvaluation>
            context,
        ApiFuture<ListModelEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelEvaluationsRequest,
          ListModelEvaluationsResponse,
          ModelEvaluation,
          ListModelEvaluationsPage,
          ListModelEvaluationsFixedSizeCollection> {

    private ListModelEvaluationsFixedSizeCollection(
        List<ListModelEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListModelEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelEvaluationsFixedSizeCollection createCollection(
        List<ListModelEvaluationsPage> pages, int collectionSize) {
      return new ListModelEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListModelEvaluationSlicesPagedResponse
      extends AbstractPagedListResponse<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ModelEvaluationSlice,
          ListModelEvaluationSlicesPage,
          ListModelEvaluationSlicesFixedSizeCollection> {

    public static ApiFuture<ListModelEvaluationSlicesPagedResponse> createAsync(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ApiFuture<ListModelEvaluationSlicesResponse> futureResponse) {
      ApiFuture<ListModelEvaluationSlicesPage> futurePage =
          ListModelEvaluationSlicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListModelEvaluationSlicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListModelEvaluationSlicesPagedResponse(ListModelEvaluationSlicesPage page) {
      super(page, ListModelEvaluationSlicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelEvaluationSlicesPage
      extends AbstractPage<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ModelEvaluationSlice,
          ListModelEvaluationSlicesPage> {

    private ListModelEvaluationSlicesPage(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ListModelEvaluationSlicesResponse response) {
      super(context, response);
    }

    private static ListModelEvaluationSlicesPage createEmptyPage() {
      return new ListModelEvaluationSlicesPage(null, null);
    }

    @Override
    protected ListModelEvaluationSlicesPage createPage(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ListModelEvaluationSlicesResponse response) {
      return new ListModelEvaluationSlicesPage(context, response);
    }

    @Override
    public ApiFuture<ListModelEvaluationSlicesPage> createPageAsync(
        PageContext<
                ListModelEvaluationSlicesRequest,
                ListModelEvaluationSlicesResponse,
                ModelEvaluationSlice>
            context,
        ApiFuture<ListModelEvaluationSlicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelEvaluationSlicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelEvaluationSlicesRequest,
          ListModelEvaluationSlicesResponse,
          ModelEvaluationSlice,
          ListModelEvaluationSlicesPage,
          ListModelEvaluationSlicesFixedSizeCollection> {

    private ListModelEvaluationSlicesFixedSizeCollection(
        List<ListModelEvaluationSlicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelEvaluationSlicesFixedSizeCollection createEmptyCollection() {
      return new ListModelEvaluationSlicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelEvaluationSlicesFixedSizeCollection createCollection(
        List<ListModelEvaluationSlicesPage> pages, int collectionSize) {
      return new ListModelEvaluationSlicesFixedSizeCollection(pages, collectionSize);
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
