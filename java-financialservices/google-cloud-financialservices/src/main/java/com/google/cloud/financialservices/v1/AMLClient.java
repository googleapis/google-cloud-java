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

package com.google.cloud.financialservices.v1;

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
import com.google.cloud.financialservices.v1.stub.AMLStub;
import com.google.cloud.financialservices.v1.stub.AMLStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The AML (Anti Money Laundering) service allows users to perform REST
 * operations on aml.
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
 * try (AMLClient aMLClient = AMLClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = aMLClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AMLClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListInstances</td>
 *      <td><p> Lists instances.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInstances(ListInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInstances(LocationName parent)
 *           <li><p> listInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInstancesPagedCallable()
 *           <li><p> listInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInstance</td>
 *      <td><p> Gets an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInstance(GetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInstance(InstanceName name)
 *           <li><p> getInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInstance</td>
 *      <td><p> Creates an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInstanceAsync(CreateInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInstanceAsync(LocationName parent, Instance instance, String instanceId)
 *           <li><p> createInstanceAsync(String parent, Instance instance, String instanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInstanceOperationCallable()
 *           <li><p> createInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInstance</td>
 *      <td><p> Updates the parameters of a single Instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInstanceAsync(UpdateInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInstanceAsync(Instance instance, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInstanceOperationCallable()
 *           <li><p> updateInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInstance</td>
 *      <td><p> Deletes an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInstanceAsync(DeleteInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInstanceAsync(InstanceName name)
 *           <li><p> deleteInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInstanceOperationCallable()
 *           <li><p> deleteInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportRegisteredParties</td>
 *      <td><p> Imports the list of registered parties. See [Create and manage instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties) for information on the input schema and response for this method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importRegisteredPartiesAsync(ImportRegisteredPartiesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importRegisteredPartiesAsync(InstanceName name, ImportRegisteredPartiesRequest.UpdateMode mode, LineOfBusiness lineOfBusiness, List&lt;String&gt; partyTables)
 *           <li><p> importRegisteredPartiesAsync(String name, ImportRegisteredPartiesRequest.UpdateMode mode, LineOfBusiness lineOfBusiness, List&lt;String&gt; partyTables)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importRegisteredPartiesOperationCallable()
 *           <li><p> importRegisteredPartiesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportRegisteredParties</td>
 *      <td><p> Exports the list of registered parties. See [Create and manage instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties) for information on the output schema for this method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportRegisteredPartiesAsync(ExportRegisteredPartiesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportRegisteredPartiesAsync(InstanceName name, BigQueryDestination dataset, LineOfBusiness lineOfBusiness)
 *           <li><p> exportRegisteredPartiesAsync(String name, BigQueryDestination dataset, LineOfBusiness lineOfBusiness)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportRegisteredPartiesOperationCallable()
 *           <li><p> exportRegisteredPartiesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatasets</td>
 *      <td><p> Lists datasets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatasets(ListDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatasets(InstanceName parent)
 *           <li><p> listDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatasetsPagedCallable()
 *           <li><p> listDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataset</td>
 *      <td><p> Gets a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataset(GetDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataset(DatasetName name)
 *           <li><p> getDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataset</td>
 *      <td><p> Creates a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatasetAsync(CreateDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatasetAsync(InstanceName parent, Dataset dataset, String datasetId)
 *           <li><p> createDatasetAsync(String parent, Dataset dataset, String datasetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatasetOperationCallable()
 *           <li><p> createDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataset</td>
 *      <td><p> Updates the parameters of a single Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatasetAsync(UpdateDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDatasetAsync(Dataset dataset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatasetOperationCallable()
 *           <li><p> updateDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataset</td>
 *      <td><p> Deletes a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDatasetAsync(DeleteDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetAsync(DatasetName name)
 *           <li><p> deleteDatasetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatasetOperationCallable()
 *           <li><p> deleteDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModels</td>
 *      <td><p> Lists models.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModels(ListModelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModels(InstanceName parent)
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
 *      <td><p> GetModel</td>
 *      <td><p> Gets a model.</td>
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
 *      <td><p> CreateModel</td>
 *      <td><p> Creates a model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createModelAsync(CreateModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createModelAsync(InstanceName parent, Model model, String modelId)
 *           <li><p> createModelAsync(String parent, Model model, String modelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createModelOperationCallable()
 *           <li><p> createModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateModel</td>
 *      <td><p> Updates the parameters of a single Model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateModelAsync(UpdateModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateModelAsync(Model model, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateModelOperationCallable()
 *           <li><p> updateModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportModelMetadata</td>
 *      <td><p> Export governance information for a Model resource. For information on the exported fields, see [AML output data model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportModelMetadataAsync(ExportModelMetadataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportModelMetadataAsync(ModelName model, BigQueryDestination structuredMetadataDestination)
 *           <li><p> exportModelMetadataAsync(String model, BigQueryDestination structuredMetadataDestination)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportModelMetadataOperationCallable()
 *           <li><p> exportModelMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteModel</td>
 *      <td><p> Deletes a model.</td>
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
 *      <td><p> ListEngineConfigs</td>
 *      <td><p> Lists engine configs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEngineConfigs(ListEngineConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEngineConfigs(InstanceName parent)
 *           <li><p> listEngineConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEngineConfigsPagedCallable()
 *           <li><p> listEngineConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEngineConfig</td>
 *      <td><p> Gets an engine config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEngineConfig(GetEngineConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEngineConfig(EngineConfigName name)
 *           <li><p> getEngineConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEngineConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEngineConfig</td>
 *      <td><p> Creates an engine config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEngineConfigAsync(CreateEngineConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEngineConfigAsync(InstanceName parent, EngineConfig engineConfig, String engineConfigId)
 *           <li><p> createEngineConfigAsync(String parent, EngineConfig engineConfig, String engineConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEngineConfigOperationCallable()
 *           <li><p> createEngineConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEngineConfig</td>
 *      <td><p> Updates the parameters of a single EngineConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEngineConfigAsync(UpdateEngineConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEngineConfigAsync(EngineConfig engineConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEngineConfigOperationCallable()
 *           <li><p> updateEngineConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportEngineConfigMetadata</td>
 *      <td><p> Export governance information for an EngineConfig resource. For information on the exported fields, see [AML output data model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportEngineConfigMetadataAsync(ExportEngineConfigMetadataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportEngineConfigMetadataAsync(EngineConfigName engineConfig, BigQueryDestination structuredMetadataDestination)
 *           <li><p> exportEngineConfigMetadataAsync(String engineConfig, BigQueryDestination structuredMetadataDestination)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportEngineConfigMetadataOperationCallable()
 *           <li><p> exportEngineConfigMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEngineConfig</td>
 *      <td><p> Deletes an engine config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEngineConfigAsync(DeleteEngineConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEngineConfigAsync(EngineConfigName name)
 *           <li><p> deleteEngineConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEngineConfigOperationCallable()
 *           <li><p> deleteEngineConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEngineVersion</td>
 *      <td><p> Gets a single EngineVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEngineVersion(GetEngineVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEngineVersion(EngineVersionName name)
 *           <li><p> getEngineVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEngineVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEngineVersions</td>
 *      <td><p> Lists EngineVersions for given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEngineVersions(ListEngineVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEngineVersions(InstanceName parent)
 *           <li><p> listEngineVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEngineVersionsPagedCallable()
 *           <li><p> listEngineVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPredictionResults</td>
 *      <td><p> List PredictionResults.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPredictionResults(ListPredictionResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPredictionResults(InstanceName parent)
 *           <li><p> listPredictionResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPredictionResultsPagedCallable()
 *           <li><p> listPredictionResultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPredictionResult</td>
 *      <td><p> Gets a PredictionResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPredictionResult(GetPredictionResultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPredictionResult(PredictionResultName name)
 *           <li><p> getPredictionResult(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPredictionResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePredictionResult</td>
 *      <td><p> Create a PredictionResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPredictionResultAsync(CreatePredictionResultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPredictionResultAsync(InstanceName parent, PredictionResult predictionResult, String predictionResultId)
 *           <li><p> createPredictionResultAsync(String parent, PredictionResult predictionResult, String predictionResultId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPredictionResultOperationCallable()
 *           <li><p> createPredictionResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePredictionResult</td>
 *      <td><p> Updates the parameters of a single PredictionResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePredictionResultAsync(UpdatePredictionResultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePredictionResultAsync(PredictionResult predictionResult, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePredictionResultOperationCallable()
 *           <li><p> updatePredictionResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportPredictionResultMetadata</td>
 *      <td><p> Export governance information for a PredictionResult resource. For information on the exported fields, see [AML output data model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportPredictionResultMetadataAsync(ExportPredictionResultMetadataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportPredictionResultMetadataAsync(PredictionResultName predictionResult, BigQueryDestination structuredMetadataDestination)
 *           <li><p> exportPredictionResultMetadataAsync(String predictionResult, BigQueryDestination structuredMetadataDestination)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportPredictionResultMetadataOperationCallable()
 *           <li><p> exportPredictionResultMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePredictionResult</td>
 *      <td><p> Deletes a PredictionResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePredictionResultAsync(DeletePredictionResultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePredictionResultAsync(PredictionResultName name)
 *           <li><p> deletePredictionResultAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePredictionResultOperationCallable()
 *           <li><p> deletePredictionResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBacktestResults</td>
 *      <td><p> List BacktestResults.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBacktestResults(ListBacktestResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBacktestResults(InstanceName parent)
 *           <li><p> listBacktestResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBacktestResultsPagedCallable()
 *           <li><p> listBacktestResultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBacktestResult</td>
 *      <td><p> Gets a BacktestResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBacktestResult(GetBacktestResultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBacktestResult(BacktestResultName name)
 *           <li><p> getBacktestResult(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBacktestResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBacktestResult</td>
 *      <td><p> Create a BacktestResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBacktestResultAsync(CreateBacktestResultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBacktestResultAsync(InstanceName parent, BacktestResult backtestResult, String backtestResultId)
 *           <li><p> createBacktestResultAsync(String parent, BacktestResult backtestResult, String backtestResultId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBacktestResultOperationCallable()
 *           <li><p> createBacktestResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBacktestResult</td>
 *      <td><p> Updates the parameters of a single BacktestResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBacktestResultAsync(UpdateBacktestResultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBacktestResultAsync(BacktestResult backtestResult, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBacktestResultOperationCallable()
 *           <li><p> updateBacktestResultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportBacktestResultMetadata</td>
 *      <td><p> Export governance information for a BacktestResult resource. For information on the exported fields, see [AML output data model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportBacktestResultMetadataAsync(ExportBacktestResultMetadataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportBacktestResultMetadataAsync(BacktestResultName backtestResult, BigQueryDestination structuredMetadataDestination)
 *           <li><p> exportBacktestResultMetadataAsync(String backtestResult, BigQueryDestination structuredMetadataDestination)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportBacktestResultMetadataOperationCallable()
 *           <li><p> exportBacktestResultMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBacktestResult</td>
 *      <td><p> Deletes a BacktestResult.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBacktestResultAsync(DeleteBacktestResultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBacktestResultAsync(BacktestResultName name)
 *           <li><p> deleteBacktestResultAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBacktestResultOperationCallable()
 *           <li><p> deleteBacktestResultCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AMLSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AMLSettings aMLSettings =
 *     AMLSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AMLClient aMLClient = AMLClient.create(aMLSettings);
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
 * AMLSettings aMLSettings = AMLSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AMLClient aMLClient = AMLClient.create(aMLSettings);
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
 * AMLSettings aMLSettings = AMLSettings.newHttpJsonBuilder().build();
 * AMLClient aMLClient = AMLClient.create(aMLSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AMLClient implements BackgroundResource {
  private final AMLSettings settings;
  private final AMLStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AMLClient with default settings. */
  public static final AMLClient create() throws IOException {
    return create(AMLSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AMLClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AMLClient create(AMLSettings settings) throws IOException {
    return new AMLClient(settings);
  }

  /**
   * Constructs an instance of AMLClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AMLSettings).
   */
  public static final AMLClient create(AMLStub stub) {
    return new AMLClient(stub);
  }

  /**
   * Constructs an instance of AMLClient, using the given settings. This is protected so that it is
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AMLClient(AMLSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AMLStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AMLClient(AMLStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AMLSettings getSettings() {
    return settings;
  }

  public AMLStub getStub() {
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
   * Lists instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : aMLClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Instance is the location for that Instance. Every
   *     location has exactly one instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : aMLClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Instance is the location for that Instance. Every
   *     location has exactly one instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : aMLClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future = aMLClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = aMLClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = aMLClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = aMLClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = aMLClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future = aMLClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = aMLClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Instance is the location for that Instance. Every
   *     location has exactly one instance.
   * @param instance Required. The instance that will be created.
   * @param instanceId Required. The resource id of the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      LocationName parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = aMLClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Instance is the location for that Instance. Every
   *     location has exactly one instance.
   * @param instance Required. The instance that will be created.
   * @param instanceId Required. The resource id of the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Instance response = aMLClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       aMLClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = aMLClient.updateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance Required. The new value of the instance fields that will be updated according
   *     to the update_mask
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Instance resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      Instance instance, FieldMask updateMask) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setUpdateMask(updateMask).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Instance response = aMLClient.updateInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       aMLClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   aMLClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   aMLClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   aMLClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       aMLClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
   * for information on the input schema and response for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ImportRegisteredPartiesRequest.UpdateMode mode =
   *       ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
   *   LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
   *   List<String> partyTables = new ArrayList<>();
   *   ImportRegisteredPartiesResponse response =
   *       aMLClient.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
   * }
   * }</pre>
   *
   * @param name Required. The full path to the Instance resource in this API. format:
   *     "projects/{project}/locations/{location}/instances/{instance}"
   * @param mode Required. Mode of the request.
   * @param lineOfBusiness Required. LineOfBusiness for the specified registered parties.
   * @param partyTables Optional. List of BigQuery tables. Union of tables will be taken if there is
   *     more than one table. VPC-SC restrictions apply. format:
   *     "bq://{project}.{bqDatasetID}.{bqTableID}" Use of `datasets` is preferred over the latter
   *     due to its simplicity and the reduced risk of errors `party_tables` and `datasets` must not
   *     be provided at the same time
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesAsync(
          InstanceName name,
          ImportRegisteredPartiesRequest.UpdateMode mode,
          LineOfBusiness lineOfBusiness,
          List<String> partyTables) {
    ImportRegisteredPartiesRequest request =
        ImportRegisteredPartiesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setMode(mode)
            .setLineOfBusiness(lineOfBusiness)
            .addAllPartyTables(partyTables)
            .build();
    return importRegisteredPartiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
   * for information on the input schema and response for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   ImportRegisteredPartiesRequest.UpdateMode mode =
   *       ImportRegisteredPartiesRequest.UpdateMode.forNumber(0);
   *   LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
   *   List<String> partyTables = new ArrayList<>();
   *   ImportRegisteredPartiesResponse response =
   *       aMLClient.importRegisteredPartiesAsync(name, mode, lineOfBusiness, partyTables).get();
   * }
   * }</pre>
   *
   * @param name Required. The full path to the Instance resource in this API. format:
   *     "projects/{project}/locations/{location}/instances/{instance}"
   * @param mode Required. Mode of the request.
   * @param lineOfBusiness Required. LineOfBusiness for the specified registered parties.
   * @param partyTables Optional. List of BigQuery tables. Union of tables will be taken if there is
   *     more than one table. VPC-SC restrictions apply. format:
   *     "bq://{project}.{bqDatasetID}.{bqTableID}" Use of `datasets` is preferred over the latter
   *     due to its simplicity and the reduced risk of errors `party_tables` and `datasets` must not
   *     be provided at the same time
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesAsync(
          String name,
          ImportRegisteredPartiesRequest.UpdateMode mode,
          LineOfBusiness lineOfBusiness,
          List<String> partyTables) {
    ImportRegisteredPartiesRequest request =
        ImportRegisteredPartiesRequest.newBuilder()
            .setName(name)
            .setMode(mode)
            .setLineOfBusiness(lineOfBusiness)
            .addAllPartyTables(partyTables)
            .build();
    return importRegisteredPartiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
   * for information on the input schema and response for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ImportRegisteredPartiesRequest request =
   *       ImportRegisteredPartiesRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllPartyTables(new ArrayList<String>())
   *           .setValidateOnly(true)
   *           .setLineOfBusiness(LineOfBusiness.forNumber(0))
   *           .build();
   *   ImportRegisteredPartiesResponse response =
   *       aMLClient.importRegisteredPartiesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesAsync(ImportRegisteredPartiesRequest request) {
    return importRegisteredPartiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
   * for information on the input schema and response for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ImportRegisteredPartiesRequest request =
   *       ImportRegisteredPartiesRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllPartyTables(new ArrayList<String>())
   *           .setValidateOnly(true)
   *           .setLineOfBusiness(LineOfBusiness.forNumber(0))
   *           .build();
   *   OperationFuture<ImportRegisteredPartiesResponse, OperationMetadata> future =
   *       aMLClient.importRegisteredPartiesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportRegisteredPartiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationCallable() {
    return stub.importRegisteredPartiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#import-registered-parties)
   * for information on the input schema and response for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ImportRegisteredPartiesRequest request =
   *       ImportRegisteredPartiesRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllPartyTables(new ArrayList<String>())
   *           .setValidateOnly(true)
   *           .setLineOfBusiness(LineOfBusiness.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.importRegisteredPartiesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesCallable() {
    return stub.importRegisteredPartiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
   * for information on the output schema for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
   *   LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
   *   ExportRegisteredPartiesResponse response =
   *       aMLClient.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
   * }
   * }</pre>
   *
   * @param name Required. The full path to the Instance resource in this API. format:
   *     "projects/{project}/locations/{location}/instances/{instance}"
   * @param dataset Required. The location to output the RegisteredParties.
   * @param lineOfBusiness Required. LineOfBusiness to get RegisteredParties from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesAsync(
          InstanceName name, BigQueryDestination dataset, LineOfBusiness lineOfBusiness) {
    ExportRegisteredPartiesRequest request =
        ExportRegisteredPartiesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDataset(dataset)
            .setLineOfBusiness(lineOfBusiness)
            .build();
    return exportRegisteredPartiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
   * for information on the output schema for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   BigQueryDestination dataset = BigQueryDestination.newBuilder().build();
   *   LineOfBusiness lineOfBusiness = LineOfBusiness.forNumber(0);
   *   ExportRegisteredPartiesResponse response =
   *       aMLClient.exportRegisteredPartiesAsync(name, dataset, lineOfBusiness).get();
   * }
   * }</pre>
   *
   * @param name Required. The full path to the Instance resource in this API. format:
   *     "projects/{project}/locations/{location}/instances/{instance}"
   * @param dataset Required. The location to output the RegisteredParties.
   * @param lineOfBusiness Required. LineOfBusiness to get RegisteredParties from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesAsync(
          String name, BigQueryDestination dataset, LineOfBusiness lineOfBusiness) {
    ExportRegisteredPartiesRequest request =
        ExportRegisteredPartiesRequest.newBuilder()
            .setName(name)
            .setDataset(dataset)
            .setLineOfBusiness(lineOfBusiness)
            .build();
    return exportRegisteredPartiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
   * for information on the output schema for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportRegisteredPartiesRequest request =
   *       ExportRegisteredPartiesRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataset(BigQueryDestination.newBuilder().build())
   *           .setLineOfBusiness(LineOfBusiness.forNumber(0))
   *           .build();
   *   ExportRegisteredPartiesResponse response =
   *       aMLClient.exportRegisteredPartiesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesAsync(ExportRegisteredPartiesRequest request) {
    return exportRegisteredPartiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
   * for information on the output schema for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportRegisteredPartiesRequest request =
   *       ExportRegisteredPartiesRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataset(BigQueryDestination.newBuilder().build())
   *           .setLineOfBusiness(LineOfBusiness.forNumber(0))
   *           .build();
   *   OperationFuture<ExportRegisteredPartiesResponse, OperationMetadata> future =
   *       aMLClient.exportRegisteredPartiesOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportRegisteredPartiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationCallable() {
    return stub.exportRegisteredPartiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the list of registered parties. See [Create and manage
   * instances](https://cloud.google.com/financial-services/anti-money-laundering/docs/create-and-manage-instances#export-registered-parties)
   * for information on the output schema for this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportRegisteredPartiesRequest request =
   *       ExportRegisteredPartiesRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataset(BigQueryDestination.newBuilder().build())
   *           .setLineOfBusiness(LineOfBusiness.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.exportRegisteredPartiesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesCallable() {
    return stub.exportRegisteredPartiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Dataset element : aMLClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Dataset is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(InstanceName parent) {
    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Dataset element : aMLClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Dataset is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(String parent) {
    ListDatasetsRequest request = ListDatasetsRequest.newBuilder().setParent(parent).build();
    return listDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Dataset element : aMLClient.listDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(ListDatasetsRequest request) {
    return listDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Dataset> future = aMLClient.listDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable() {
    return stub.listDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDatasetsResponse response = aMLClient.listDatasetsCallable().call(request);
   *     for (Dataset element : response.getDatasetsList()) {
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
  public final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return stub.listDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");
   *   Dataset response = aMLClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString();
   *   Dataset response = aMLClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
   *                   .toString())
   *           .build();
   *   Dataset response = aMLClient.getDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(GetDatasetRequest request) {
    return getDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Dataset> future = aMLClient.getDatasetCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return stub.getDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Dataset dataset = Dataset.newBuilder().build();
   *   String datasetId = "datasetId-345342029";
   *   Dataset response = aMLClient.createDatasetAsync(parent, dataset, datasetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Dataset is the Instance.
   * @param dataset Required. The dataset that will be created.
   * @param datasetId Required. The resource id of the dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, OperationMetadata> createDatasetAsync(
      InstanceName parent, Dataset dataset, String datasetId) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .setDatasetId(datasetId)
            .build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Dataset dataset = Dataset.newBuilder().build();
   *   String datasetId = "datasetId-345342029";
   *   Dataset response = aMLClient.createDatasetAsync(parent, dataset, datasetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Dataset is the Instance.
   * @param dataset Required. The dataset that will be created.
   * @param datasetId Required. The resource id of the dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, OperationMetadata> createDatasetAsync(
      String parent, Dataset dataset, String datasetId) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent)
            .setDataset(dataset)
            .setDatasetId(datasetId)
            .build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDatasetId("datasetId-345342029")
   *           .setDataset(Dataset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Dataset response = aMLClient.createDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, OperationMetadata> createDatasetAsync(
      CreateDatasetRequest request) {
    return createDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDatasetId("datasetId-345342029")
   *           .setDataset(Dataset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Dataset, OperationMetadata> future =
   *       aMLClient.createDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable() {
    return stub.createDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDatasetId("datasetId-345342029")
   *           .setDataset(Dataset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.createDatasetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return stub.createDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   Dataset dataset = Dataset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Dataset response = aMLClient.updateDatasetAsync(dataset, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataset Required. The new value of the dataset fields that will be updated according to
   *     the update_mask.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Dataset resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, OperationMetadata> updateDatasetAsync(
      Dataset dataset, FieldMask updateMask) {
    UpdateDatasetRequest request =
        UpdateDatasetRequest.newBuilder().setDataset(dataset).setUpdateMask(updateMask).build();
    return updateDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataset(Dataset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Dataset response = aMLClient.updateDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, OperationMetadata> updateDatasetAsync(
      UpdateDatasetRequest request) {
    return updateDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataset(Dataset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Dataset, OperationMetadata> future =
   *       aMLClient.updateDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationCallable() {
    return stub.updateDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataset(Dataset.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.updateDatasetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    return stub.updateDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]");
   *   aMLClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatasetAsync(DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]").toString();
   *   aMLClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Dataset.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatasetAsync(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   aMLClient.deleteDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatasetAsync(
      DeleteDatasetRequest request) {
    return deleteDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       aMLClient.deleteDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable() {
    return stub.deleteDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(
   *               DatasetName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[DATASET]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.deleteDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return stub.deleteDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Model element : aMLClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Model is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(InstanceName parent) {
    ListModelsRequest request =
        ListModelsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Model element : aMLClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Model is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(String parent) {
    ListModelsRequest request = ListModelsRequest.newBuilder().setParent(parent).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Model element : aMLClient.listModels(request).iterateAll()) {
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
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Model> future = aMLClient.listModelsPagedCallable().futureCall(request);
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
   * Lists models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListModelsResponse response = aMLClient.listModelsCallable().call(request);
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
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
   *   Model response = aMLClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(ModelName name) {
    GetModelRequest request =
        GetModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString();
   *   Model response = aMLClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(String name) {
    GetModelRequest request = GetModelRequest.newBuilder().setName(name).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .build();
   *   Model response = aMLClient.getModel(request);
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
   * Gets a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Model> future = aMLClient.getModelCallable().futureCall(request);
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
   * Creates a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Model model = Model.newBuilder().build();
   *   String modelId = "modelId1226956324";
   *   Model response = aMLClient.createModelAsync(parent, model, modelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Model is the Instance.
   * @param model Required. The Model that will be created.
   * @param modelId Required. The resource id of the Model
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> createModelAsync(
      InstanceName parent, Model model, String modelId) {
    CreateModelRequest request =
        CreateModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setModelId(modelId)
            .build();
    return createModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Model model = Model.newBuilder().build();
   *   String modelId = "modelId1226956324";
   *   Model response = aMLClient.createModelAsync(parent, model, modelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Model is the Instance.
   * @param model Required. The Model that will be created.
   * @param modelId Required. The resource id of the Model
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> createModelAsync(
      String parent, Model model, String modelId) {
    CreateModelRequest request =
        CreateModelRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setModelId(modelId)
            .build();
    return createModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setModelId("modelId1226956324")
   *           .setModel(Model.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Model response = aMLClient.createModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> createModelAsync(
      CreateModelRequest request) {
    return createModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setModelId("modelId1226956324")
   *           .setModel(Model.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Model, OperationMetadata> future =
   *       aMLClient.createModelOperationCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable() {
    return stub.createModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setModelId("modelId1226956324")
   *           .setModel(Model.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.createModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return stub.createModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   Model model = Model.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Model response = aMLClient.updateModelAsync(model, updateMask).get();
   * }
   * }</pre>
   *
   * @param model Required. The new value of the Model fields that will be updated according to the
   *     update_mask.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Model resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> updateModelAsync(
      Model model, FieldMask updateMask) {
    UpdateModelRequest request =
        UpdateModelRequest.newBuilder().setModel(model).setUpdateMask(updateMask).build();
    return updateModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setModel(Model.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Model response = aMLClient.updateModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, OperationMetadata> updateModelAsync(
      UpdateModelRequest request) {
    return updateModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setModel(Model.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Model, OperationMetadata> future =
   *       aMLClient.updateModelOperationCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationCallable() {
    return stub.updateModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateModelRequest request =
   *       UpdateModelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setModel(Model.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.updateModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateModelRequest, Operation> updateModelCallable() {
    return stub.updateModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a Model resource. For information on the exported fields, see
   * [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ModelName model = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportModelMetadataResponse response =
   *       aMLClient.exportModelMetadataAsync(model, structuredMetadataDestination).get();
   * }
   * }</pre>
   *
   * @param model Required. The resource name of the Model.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataAsync(ModelName model, BigQueryDestination structuredMetadataDestination) {
    ExportModelMetadataRequest request =
        ExportModelMetadataRequest.newBuilder()
            .setModel(model == null ? null : model.toString())
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportModelMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a Model resource. For information on the exported fields, see
   * [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String model =
   *       ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString();
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportModelMetadataResponse response =
   *       aMLClient.exportModelMetadataAsync(model, structuredMetadataDestination).get();
   * }
   * }</pre>
   *
   * @param model Required. The resource name of the Model.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataAsync(String model, BigQueryDestination structuredMetadataDestination) {
    ExportModelMetadataRequest request =
        ExportModelMetadataRequest.newBuilder()
            .setModel(model)
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportModelMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a Model resource. For information on the exported fields, see
   * [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportModelMetadataRequest request =
   *       ExportModelMetadataRequest.newBuilder()
   *           .setModel(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ExportModelMetadataResponse response = aMLClient.exportModelMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataAsync(ExportModelMetadataRequest request) {
    return exportModelMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a Model resource. For information on the exported fields, see
   * [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportModelMetadataRequest request =
   *       ExportModelMetadataRequest.newBuilder()
   *           .setModel(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportModelMetadataResponse, OperationMetadata> future =
   *       aMLClient.exportModelMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportModelMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationCallable() {
    return stub.exportModelMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a Model resource. For information on the exported fields, see
   * [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#model).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportModelMetadataRequest request =
   *       ExportModelMetadataRequest.newBuilder()
   *           .setModel(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.exportModelMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportModelMetadataRequest, Operation> exportModelMetadataCallable() {
    return stub.exportModelMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]");
   *   aMLClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteModelAsync(ModelName name) {
    DeleteModelRequest request =
        DeleteModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name = ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString();
   *   aMLClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteModelAsync(String name) {
    DeleteModelRequest request = DeleteModelRequest.newBuilder().setName(name).build();
    return deleteModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   aMLClient.deleteModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteModelAsync(
      DeleteModelRequest request) {
    return deleteModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       aMLClient.deleteModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable() {
    return stub.deleteModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(
   *               ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.deleteModelCallable().futureCall(request);
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
   * Lists engine configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (EngineConfig element : aMLClient.listEngineConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the EngineConfig is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEngineConfigsPagedResponse listEngineConfigs(InstanceName parent) {
    ListEngineConfigsRequest request =
        ListEngineConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEngineConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists engine configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (EngineConfig element : aMLClient.listEngineConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the EngineConfig is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEngineConfigsPagedResponse listEngineConfigs(String parent) {
    ListEngineConfigsRequest request =
        ListEngineConfigsRequest.newBuilder().setParent(parent).build();
    return listEngineConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists engine configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListEngineConfigsRequest request =
   *       ListEngineConfigsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EngineConfig element : aMLClient.listEngineConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEngineConfigsPagedResponse listEngineConfigs(ListEngineConfigsRequest request) {
    return listEngineConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists engine configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListEngineConfigsRequest request =
   *       ListEngineConfigsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EngineConfig> future =
   *       aMLClient.listEngineConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EngineConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsPagedResponse>
      listEngineConfigsPagedCallable() {
    return stub.listEngineConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists engine configs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListEngineConfigsRequest request =
   *       ListEngineConfigsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEngineConfigsResponse response = aMLClient.listEngineConfigsCallable().call(request);
   *     for (EngineConfig element : response.getEngineConfigsList()) {
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
  public final UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsCallable() {
    return stub.listEngineConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   EngineConfigName name =
   *       EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
   *   EngineConfig response = aMLClient.getEngineConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EngineConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EngineConfig getEngineConfig(EngineConfigName name) {
    GetEngineConfigRequest request =
        GetEngineConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEngineConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *           .toString();
   *   EngineConfig response = aMLClient.getEngineConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EngineConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EngineConfig getEngineConfig(String name) {
    GetEngineConfigRequest request = GetEngineConfigRequest.newBuilder().setName(name).build();
    return getEngineConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetEngineConfigRequest request =
   *       GetEngineConfigRequest.newBuilder()
   *           .setName(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .build();
   *   EngineConfig response = aMLClient.getEngineConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EngineConfig getEngineConfig(GetEngineConfigRequest request) {
    return getEngineConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetEngineConfigRequest request =
   *       GetEngineConfigRequest.newBuilder()
   *           .setName(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EngineConfig> future = aMLClient.getEngineConfigCallable().futureCall(request);
   *   // Do something.
   *   EngineConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEngineConfigRequest, EngineConfig> getEngineConfigCallable() {
    return stub.getEngineConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   EngineConfig engineConfig = EngineConfig.newBuilder().build();
   *   String engineConfigId = "engineConfigId451461215";
   *   EngineConfig response =
   *       aMLClient.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the EngineConfig is the Instance.
   * @param engineConfig Required. The EngineConfig that will be created.
   * @param engineConfigId Required. The resource id of the EngineConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EngineConfig, OperationMetadata> createEngineConfigAsync(
      InstanceName parent, EngineConfig engineConfig, String engineConfigId) {
    CreateEngineConfigRequest request =
        CreateEngineConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEngineConfig(engineConfig)
            .setEngineConfigId(engineConfigId)
            .build();
    return createEngineConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   EngineConfig engineConfig = EngineConfig.newBuilder().build();
   *   String engineConfigId = "engineConfigId451461215";
   *   EngineConfig response =
   *       aMLClient.createEngineConfigAsync(parent, engineConfig, engineConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the EngineConfig is the Instance.
   * @param engineConfig Required. The EngineConfig that will be created.
   * @param engineConfigId Required. The resource id of the EngineConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EngineConfig, OperationMetadata> createEngineConfigAsync(
      String parent, EngineConfig engineConfig, String engineConfigId) {
    CreateEngineConfigRequest request =
        CreateEngineConfigRequest.newBuilder()
            .setParent(parent)
            .setEngineConfig(engineConfig)
            .setEngineConfigId(engineConfigId)
            .build();
    return createEngineConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateEngineConfigRequest request =
   *       CreateEngineConfigRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setEngineConfigId("engineConfigId451461215")
   *           .setEngineConfig(EngineConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   EngineConfig response = aMLClient.createEngineConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EngineConfig, OperationMetadata> createEngineConfigAsync(
      CreateEngineConfigRequest request) {
    return createEngineConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateEngineConfigRequest request =
   *       CreateEngineConfigRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setEngineConfigId("engineConfigId451461215")
   *           .setEngineConfig(EngineConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<EngineConfig, OperationMetadata> future =
   *       aMLClient.createEngineConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   EngineConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationCallable() {
    return stub.createEngineConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateEngineConfigRequest request =
   *       CreateEngineConfigRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setEngineConfigId("engineConfigId451461215")
   *           .setEngineConfig(EngineConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.createEngineConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEngineConfigRequest, Operation> createEngineConfigCallable() {
    return stub.createEngineConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   EngineConfig engineConfig = EngineConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EngineConfig response = aMLClient.updateEngineConfigAsync(engineConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param engineConfig Required. The new value of the EngineConfig fields that will be updated
   *     according to the update_mask.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     EngineConfig resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EngineConfig, OperationMetadata> updateEngineConfigAsync(
      EngineConfig engineConfig, FieldMask updateMask) {
    UpdateEngineConfigRequest request =
        UpdateEngineConfigRequest.newBuilder()
            .setEngineConfig(engineConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateEngineConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateEngineConfigRequest request =
   *       UpdateEngineConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEngineConfig(EngineConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   EngineConfig response = aMLClient.updateEngineConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EngineConfig, OperationMetadata> updateEngineConfigAsync(
      UpdateEngineConfigRequest request) {
    return updateEngineConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateEngineConfigRequest request =
   *       UpdateEngineConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEngineConfig(EngineConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<EngineConfig, OperationMetadata> future =
   *       aMLClient.updateEngineConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   EngineConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationCallable() {
    return stub.updateEngineConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateEngineConfigRequest request =
   *       UpdateEngineConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEngineConfig(EngineConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.updateEngineConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEngineConfigRequest, Operation> updateEngineConfigCallable() {
    return stub.updateEngineConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for an EngineConfig resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   EngineConfigName engineConfig =
   *       EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportEngineConfigMetadataResponse response =
   *       aMLClient
   *           .exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination)
   *           .get();
   * }
   * }</pre>
   *
   * @param engineConfig Required. The resource name of the EngineConfig.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataAsync(
          EngineConfigName engineConfig, BigQueryDestination structuredMetadataDestination) {
    ExportEngineConfigMetadataRequest request =
        ExportEngineConfigMetadataRequest.newBuilder()
            .setEngineConfig(engineConfig == null ? null : engineConfig.toString())
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportEngineConfigMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for an EngineConfig resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String engineConfig =
   *       EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *           .toString();
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportEngineConfigMetadataResponse response =
   *       aMLClient
   *           .exportEngineConfigMetadataAsync(engineConfig, structuredMetadataDestination)
   *           .get();
   * }
   * }</pre>
   *
   * @param engineConfig Required. The resource name of the EngineConfig.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataAsync(
          String engineConfig, BigQueryDestination structuredMetadataDestination) {
    ExportEngineConfigMetadataRequest request =
        ExportEngineConfigMetadataRequest.newBuilder()
            .setEngineConfig(engineConfig)
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportEngineConfigMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for an EngineConfig resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportEngineConfigMetadataRequest request =
   *       ExportEngineConfigMetadataRequest.newBuilder()
   *           .setEngineConfig(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ExportEngineConfigMetadataResponse response =
   *       aMLClient.exportEngineConfigMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataAsync(ExportEngineConfigMetadataRequest request) {
    return exportEngineConfigMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for an EngineConfig resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportEngineConfigMetadataRequest request =
   *       ExportEngineConfigMetadataRequest.newBuilder()
   *           .setEngineConfig(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportEngineConfigMetadataResponse, OperationMetadata> future =
   *       aMLClient.exportEngineConfigMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportEngineConfigMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationCallable() {
    return stub.exportEngineConfigMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for an EngineConfig resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#engine-config).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportEngineConfigMetadataRequest request =
   *       ExportEngineConfigMetadataRequest.newBuilder()
   *           .setEngineConfig(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       aMLClient.exportEngineConfigMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataCallable() {
    return stub.exportEngineConfigMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   EngineConfigName name =
   *       EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]");
   *   aMLClient.deleteEngineConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EngineConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEngineConfigAsync(
      EngineConfigName name) {
    DeleteEngineConfigRequest request =
        DeleteEngineConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEngineConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       EngineConfigName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *           .toString();
   *   aMLClient.deleteEngineConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EngineConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEngineConfigAsync(String name) {
    DeleteEngineConfigRequest request =
        DeleteEngineConfigRequest.newBuilder().setName(name).build();
    return deleteEngineConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteEngineConfigRequest request =
   *       DeleteEngineConfigRequest.newBuilder()
   *           .setName(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   aMLClient.deleteEngineConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEngineConfigAsync(
      DeleteEngineConfigRequest request) {
    return deleteEngineConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteEngineConfigRequest request =
   *       DeleteEngineConfigRequest.newBuilder()
   *           .setName(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       aMLClient.deleteEngineConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationCallable() {
    return stub.deleteEngineConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an engine config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteEngineConfigRequest request =
   *       DeleteEngineConfigRequest.newBuilder()
   *           .setName(
   *               EngineConfigName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_CONFIG]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.deleteEngineConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEngineConfigRequest, Operation> deleteEngineConfigCallable() {
    return stub.deleteEngineConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single EngineVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   EngineVersionName name =
   *       EngineVersionName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]");
   *   EngineVersion response = aMLClient.getEngineVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EngineVersion
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EngineVersion getEngineVersion(EngineVersionName name) {
    GetEngineVersionRequest request =
        GetEngineVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEngineVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single EngineVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       EngineVersionName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
   *           .toString();
   *   EngineVersion response = aMLClient.getEngineVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EngineVersion
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EngineVersion getEngineVersion(String name) {
    GetEngineVersionRequest request = GetEngineVersionRequest.newBuilder().setName(name).build();
    return getEngineVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single EngineVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetEngineVersionRequest request =
   *       GetEngineVersionRequest.newBuilder()
   *           .setName(
   *               EngineVersionName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
   *                   .toString())
   *           .build();
   *   EngineVersion response = aMLClient.getEngineVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EngineVersion getEngineVersion(GetEngineVersionRequest request) {
    return getEngineVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single EngineVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetEngineVersionRequest request =
   *       GetEngineVersionRequest.newBuilder()
   *           .setName(
   *               EngineVersionName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[ENGINE_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EngineVersion> future = aMLClient.getEngineVersionCallable().futureCall(request);
   *   // Do something.
   *   EngineVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEngineVersionRequest, EngineVersion> getEngineVersionCallable() {
    return stub.getEngineVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EngineVersions for given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (EngineVersion element : aMLClient.listEngineVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the EngineVersion is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEngineVersionsPagedResponse listEngineVersions(InstanceName parent) {
    ListEngineVersionsRequest request =
        ListEngineVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEngineVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EngineVersions for given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (EngineVersion element : aMLClient.listEngineVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the EngineVersion is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEngineVersionsPagedResponse listEngineVersions(String parent) {
    ListEngineVersionsRequest request =
        ListEngineVersionsRequest.newBuilder().setParent(parent).build();
    return listEngineVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EngineVersions for given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListEngineVersionsRequest request =
   *       ListEngineVersionsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EngineVersion element : aMLClient.listEngineVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEngineVersionsPagedResponse listEngineVersions(
      ListEngineVersionsRequest request) {
    return listEngineVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EngineVersions for given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListEngineVersionsRequest request =
   *       ListEngineVersionsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EngineVersion> future =
   *       aMLClient.listEngineVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EngineVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsPagedResponse>
      listEngineVersionsPagedCallable() {
    return stub.listEngineVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EngineVersions for given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListEngineVersionsRequest request =
   *       ListEngineVersionsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEngineVersionsResponse response = aMLClient.listEngineVersionsCallable().call(request);
   *     for (EngineVersion element : response.getEngineVersionsList()) {
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
  public final UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsCallable() {
    return stub.listEngineVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List PredictionResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (PredictionResult element : aMLClient.listPredictionResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the PredictionResult is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionResultsPagedResponse listPredictionResults(InstanceName parent) {
    ListPredictionResultsRequest request =
        ListPredictionResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPredictionResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List PredictionResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (PredictionResult element : aMLClient.listPredictionResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the PredictionResult is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionResultsPagedResponse listPredictionResults(String parent) {
    ListPredictionResultsRequest request =
        ListPredictionResultsRequest.newBuilder().setParent(parent).build();
    return listPredictionResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List PredictionResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListPredictionResultsRequest request =
   *       ListPredictionResultsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PredictionResult element : aMLClient.listPredictionResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPredictionResultsPagedResponse listPredictionResults(
      ListPredictionResultsRequest request) {
    return listPredictionResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List PredictionResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListPredictionResultsRequest request =
   *       ListPredictionResultsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PredictionResult> future =
   *       aMLClient.listPredictionResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PredictionResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsPagedResponse>
      listPredictionResultsPagedCallable() {
    return stub.listPredictionResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List PredictionResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListPredictionResultsRequest request =
   *       ListPredictionResultsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPredictionResultsResponse response =
   *         aMLClient.listPredictionResultsCallable().call(request);
   *     for (PredictionResult element : response.getPredictionResultsList()) {
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
  public final UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsCallable() {
    return stub.listPredictionResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   PredictionResultName name =
   *       PredictionResultName.of(
   *           "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
   *   PredictionResult response = aMLClient.getPredictionResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PredictionResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionResult getPredictionResult(PredictionResultName name) {
    GetPredictionResultRequest request =
        GetPredictionResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPredictionResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       PredictionResultName.of(
   *               "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *           .toString();
   *   PredictionResult response = aMLClient.getPredictionResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PredictionResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionResult getPredictionResult(String name) {
    GetPredictionResultRequest request =
        GetPredictionResultRequest.newBuilder().setName(name).build();
    return getPredictionResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetPredictionResultRequest request =
   *       GetPredictionResultRequest.newBuilder()
   *           .setName(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .build();
   *   PredictionResult response = aMLClient.getPredictionResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictionResult getPredictionResult(GetPredictionResultRequest request) {
    return getPredictionResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetPredictionResultRequest request =
   *       GetPredictionResultRequest.newBuilder()
   *           .setName(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PredictionResult> future =
   *       aMLClient.getPredictionResultCallable().futureCall(request);
   *   // Do something.
   *   PredictionResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPredictionResultRequest, PredictionResult>
      getPredictionResultCallable() {
    return stub.getPredictionResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   PredictionResult predictionResult = PredictionResult.newBuilder().build();
   *   String predictionResultId = "predictionResultId62892999";
   *   PredictionResult response =
   *       aMLClient.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the PredictionResult is the Instance.
   * @param predictionResult Required. The PredictionResult that will be created.
   * @param predictionResultId Required. The resource id of the PredictionResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PredictionResult, OperationMetadata> createPredictionResultAsync(
      InstanceName parent, PredictionResult predictionResult, String predictionResultId) {
    CreatePredictionResultRequest request =
        CreatePredictionResultRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPredictionResult(predictionResult)
            .setPredictionResultId(predictionResultId)
            .build();
    return createPredictionResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   PredictionResult predictionResult = PredictionResult.newBuilder().build();
   *   String predictionResultId = "predictionResultId62892999";
   *   PredictionResult response =
   *       aMLClient.createPredictionResultAsync(parent, predictionResult, predictionResultId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the PredictionResult is the Instance.
   * @param predictionResult Required. The PredictionResult that will be created.
   * @param predictionResultId Required. The resource id of the PredictionResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PredictionResult, OperationMetadata> createPredictionResultAsync(
      String parent, PredictionResult predictionResult, String predictionResultId) {
    CreatePredictionResultRequest request =
        CreatePredictionResultRequest.newBuilder()
            .setParent(parent)
            .setPredictionResult(predictionResult)
            .setPredictionResultId(predictionResultId)
            .build();
    return createPredictionResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreatePredictionResultRequest request =
   *       CreatePredictionResultRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPredictionResultId("predictionResultId62892999")
   *           .setPredictionResult(PredictionResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PredictionResult response = aMLClient.createPredictionResultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PredictionResult, OperationMetadata> createPredictionResultAsync(
      CreatePredictionResultRequest request) {
    return createPredictionResultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreatePredictionResultRequest request =
   *       CreatePredictionResultRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPredictionResultId("predictionResultId62892999")
   *           .setPredictionResult(PredictionResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PredictionResult, OperationMetadata> future =
   *       aMLClient.createPredictionResultOperationCallable().futureCall(request);
   *   // Do something.
   *   PredictionResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationCallable() {
    return stub.createPredictionResultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreatePredictionResultRequest request =
   *       CreatePredictionResultRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPredictionResultId("predictionResultId62892999")
   *           .setPredictionResult(PredictionResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.createPredictionResultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePredictionResultRequest, Operation>
      createPredictionResultCallable() {
    return stub.createPredictionResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   PredictionResult predictionResult = PredictionResult.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PredictionResult response =
   *       aMLClient.updatePredictionResultAsync(predictionResult, updateMask).get();
   * }
   * }</pre>
   *
   * @param predictionResult Required. The new value of the PredictionResult fields that will be
   *     updated according to the update_mask.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     PredictionResult resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PredictionResult, OperationMetadata> updatePredictionResultAsync(
      PredictionResult predictionResult, FieldMask updateMask) {
    UpdatePredictionResultRequest request =
        UpdatePredictionResultRequest.newBuilder()
            .setPredictionResult(predictionResult)
            .setUpdateMask(updateMask)
            .build();
    return updatePredictionResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdatePredictionResultRequest request =
   *       UpdatePredictionResultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPredictionResult(PredictionResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PredictionResult response = aMLClient.updatePredictionResultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PredictionResult, OperationMetadata> updatePredictionResultAsync(
      UpdatePredictionResultRequest request) {
    return updatePredictionResultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdatePredictionResultRequest request =
   *       UpdatePredictionResultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPredictionResult(PredictionResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PredictionResult, OperationMetadata> future =
   *       aMLClient.updatePredictionResultOperationCallable().futureCall(request);
   *   // Do something.
   *   PredictionResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationCallable() {
    return stub.updatePredictionResultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdatePredictionResultRequest request =
   *       UpdatePredictionResultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPredictionResult(PredictionResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.updatePredictionResultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePredictionResultRequest, Operation>
      updatePredictionResultCallable() {
    return stub.updatePredictionResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a PredictionResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   PredictionResultName predictionResult =
   *       PredictionResultName.of(
   *           "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportPredictionResultMetadataResponse response =
   *       aMLClient
   *           .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
   *           .get();
   * }
   * }</pre>
   *
   * @param predictionResult Required. The resource name of the PredictionResult.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportPredictionResultMetadataResponse, OperationMetadata>
      exportPredictionResultMetadataAsync(
          PredictionResultName predictionResult,
          BigQueryDestination structuredMetadataDestination) {
    ExportPredictionResultMetadataRequest request =
        ExportPredictionResultMetadataRequest.newBuilder()
            .setPredictionResult(predictionResult == null ? null : predictionResult.toString())
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportPredictionResultMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a PredictionResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String predictionResult =
   *       PredictionResultName.of(
   *               "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *           .toString();
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportPredictionResultMetadataResponse response =
   *       aMLClient
   *           .exportPredictionResultMetadataAsync(predictionResult, structuredMetadataDestination)
   *           .get();
   * }
   * }</pre>
   *
   * @param predictionResult Required. The resource name of the PredictionResult.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportPredictionResultMetadataResponse, OperationMetadata>
      exportPredictionResultMetadataAsync(
          String predictionResult, BigQueryDestination structuredMetadataDestination) {
    ExportPredictionResultMetadataRequest request =
        ExportPredictionResultMetadataRequest.newBuilder()
            .setPredictionResult(predictionResult)
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportPredictionResultMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a PredictionResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportPredictionResultMetadataRequest request =
   *       ExportPredictionResultMetadataRequest.newBuilder()
   *           .setPredictionResult(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ExportPredictionResultMetadataResponse response =
   *       aMLClient.exportPredictionResultMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportPredictionResultMetadataResponse, OperationMetadata>
      exportPredictionResultMetadataAsync(ExportPredictionResultMetadataRequest request) {
    return exportPredictionResultMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a PredictionResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportPredictionResultMetadataRequest request =
   *       ExportPredictionResultMetadataRequest.newBuilder()
   *           .setPredictionResult(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportPredictionResultMetadataResponse, OperationMetadata> future =
   *       aMLClient.exportPredictionResultMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportPredictionResultMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationCallable() {
    return stub.exportPredictionResultMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a PredictionResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#prediction-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportPredictionResultMetadataRequest request =
   *       ExportPredictionResultMetadataRequest.newBuilder()
   *           .setPredictionResult(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       aMLClient.exportPredictionResultMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataCallable() {
    return stub.exportPredictionResultMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   PredictionResultName name =
   *       PredictionResultName.of(
   *           "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]");
   *   aMLClient.deletePredictionResultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PredictionResult.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePredictionResultAsync(
      PredictionResultName name) {
    DeletePredictionResultRequest request =
        DeletePredictionResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePredictionResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       PredictionResultName.of(
   *               "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *           .toString();
   *   aMLClient.deletePredictionResultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PredictionResult.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePredictionResultAsync(String name) {
    DeletePredictionResultRequest request =
        DeletePredictionResultRequest.newBuilder().setName(name).build();
    return deletePredictionResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeletePredictionResultRequest request =
   *       DeletePredictionResultRequest.newBuilder()
   *           .setName(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   aMLClient.deletePredictionResultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePredictionResultAsync(
      DeletePredictionResultRequest request) {
    return deletePredictionResultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeletePredictionResultRequest request =
   *       DeletePredictionResultRequest.newBuilder()
   *           .setName(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       aMLClient.deletePredictionResultOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationCallable() {
    return stub.deletePredictionResultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PredictionResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeletePredictionResultRequest request =
   *       DeletePredictionResultRequest.newBuilder()
   *           .setName(
   *               PredictionResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[PREDICTION_RESULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.deletePredictionResultCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePredictionResultRequest, Operation>
      deletePredictionResultCallable() {
    return stub.deletePredictionResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BacktestResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (BacktestResult element : aMLClient.listBacktestResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the BacktestResult is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBacktestResultsPagedResponse listBacktestResults(InstanceName parent) {
    ListBacktestResultsRequest request =
        ListBacktestResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBacktestResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BacktestResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (BacktestResult element : aMLClient.listBacktestResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the BacktestResult is the Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBacktestResultsPagedResponse listBacktestResults(String parent) {
    ListBacktestResultsRequest request =
        ListBacktestResultsRequest.newBuilder().setParent(parent).build();
    return listBacktestResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BacktestResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListBacktestResultsRequest request =
   *       ListBacktestResultsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BacktestResult element : aMLClient.listBacktestResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBacktestResultsPagedResponse listBacktestResults(
      ListBacktestResultsRequest request) {
    return listBacktestResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BacktestResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListBacktestResultsRequest request =
   *       ListBacktestResultsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BacktestResult> future =
   *       aMLClient.listBacktestResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BacktestResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsPagedResponse>
      listBacktestResultsPagedCallable() {
    return stub.listBacktestResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BacktestResults.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListBacktestResultsRequest request =
   *       ListBacktestResultsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBacktestResultsResponse response =
   *         aMLClient.listBacktestResultsCallable().call(request);
   *     for (BacktestResult element : response.getBacktestResultsList()) {
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
  public final UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsCallable() {
    return stub.listBacktestResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   BacktestResultName name =
   *       BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
   *   BacktestResult response = aMLClient.getBacktestResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BacktestResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BacktestResult getBacktestResult(BacktestResultName name) {
    GetBacktestResultRequest request =
        GetBacktestResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBacktestResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *           .toString();
   *   BacktestResult response = aMLClient.getBacktestResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BacktestResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BacktestResult getBacktestResult(String name) {
    GetBacktestResultRequest request = GetBacktestResultRequest.newBuilder().setName(name).build();
    return getBacktestResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetBacktestResultRequest request =
   *       GetBacktestResultRequest.newBuilder()
   *           .setName(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .build();
   *   BacktestResult response = aMLClient.getBacktestResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BacktestResult getBacktestResult(GetBacktestResultRequest request) {
    return getBacktestResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetBacktestResultRequest request =
   *       GetBacktestResultRequest.newBuilder()
   *           .setName(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BacktestResult> future = aMLClient.getBacktestResultCallable().futureCall(request);
   *   // Do something.
   *   BacktestResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBacktestResultRequest, BacktestResult> getBacktestResultCallable() {
    return stub.getBacktestResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   BacktestResult backtestResult = BacktestResult.newBuilder().build();
   *   String backtestResultId = "backtestResultId-2045569231";
   *   BacktestResult response =
   *       aMLClient.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the BacktestResult is the Instance.
   * @param backtestResult Required. The BacktestResult that will be created.
   * @param backtestResultId Required. The resource id of the BacktestResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BacktestResult, OperationMetadata> createBacktestResultAsync(
      InstanceName parent, BacktestResult backtestResult, String backtestResultId) {
    CreateBacktestResultRequest request =
        CreateBacktestResultRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBacktestResult(backtestResult)
            .setBacktestResultId(backtestResultId)
            .build();
    return createBacktestResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   BacktestResult backtestResult = BacktestResult.newBuilder().build();
   *   String backtestResultId = "backtestResultId-2045569231";
   *   BacktestResult response =
   *       aMLClient.createBacktestResultAsync(parent, backtestResult, backtestResultId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the BacktestResult is the Instance.
   * @param backtestResult Required. The BacktestResult that will be created.
   * @param backtestResultId Required. The resource id of the BacktestResult
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BacktestResult, OperationMetadata> createBacktestResultAsync(
      String parent, BacktestResult backtestResult, String backtestResultId) {
    CreateBacktestResultRequest request =
        CreateBacktestResultRequest.newBuilder()
            .setParent(parent)
            .setBacktestResult(backtestResult)
            .setBacktestResultId(backtestResultId)
            .build();
    return createBacktestResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateBacktestResultRequest request =
   *       CreateBacktestResultRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setBacktestResultId("backtestResultId-2045569231")
   *           .setBacktestResult(BacktestResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BacktestResult response = aMLClient.createBacktestResultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BacktestResult, OperationMetadata> createBacktestResultAsync(
      CreateBacktestResultRequest request) {
    return createBacktestResultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateBacktestResultRequest request =
   *       CreateBacktestResultRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setBacktestResultId("backtestResultId-2045569231")
   *           .setBacktestResult(BacktestResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BacktestResult, OperationMetadata> future =
   *       aMLClient.createBacktestResultOperationCallable().futureCall(request);
   *   // Do something.
   *   BacktestResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationCallable() {
    return stub.createBacktestResultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   CreateBacktestResultRequest request =
   *       CreateBacktestResultRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setBacktestResultId("backtestResultId-2045569231")
   *           .setBacktestResult(BacktestResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.createBacktestResultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBacktestResultRequest, Operation>
      createBacktestResultCallable() {
    return stub.createBacktestResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   BacktestResult backtestResult = BacktestResult.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BacktestResult response =
   *       aMLClient.updateBacktestResultAsync(backtestResult, updateMask).get();
   * }
   * }</pre>
   *
   * @param backtestResult Required. The new value of the BacktestResult fields that will be updated
   *     according to the update_mask.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     BacktestResult resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BacktestResult, OperationMetadata> updateBacktestResultAsync(
      BacktestResult backtestResult, FieldMask updateMask) {
    UpdateBacktestResultRequest request =
        UpdateBacktestResultRequest.newBuilder()
            .setBacktestResult(backtestResult)
            .setUpdateMask(updateMask)
            .build();
    return updateBacktestResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateBacktestResultRequest request =
   *       UpdateBacktestResultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBacktestResult(BacktestResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BacktestResult response = aMLClient.updateBacktestResultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BacktestResult, OperationMetadata> updateBacktestResultAsync(
      UpdateBacktestResultRequest request) {
    return updateBacktestResultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateBacktestResultRequest request =
   *       UpdateBacktestResultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBacktestResult(BacktestResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BacktestResult, OperationMetadata> future =
   *       aMLClient.updateBacktestResultOperationCallable().futureCall(request);
   *   // Do something.
   *   BacktestResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationCallable() {
    return stub.updateBacktestResultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   UpdateBacktestResultRequest request =
   *       UpdateBacktestResultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBacktestResult(BacktestResult.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.updateBacktestResultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBacktestResultRequest, Operation>
      updateBacktestResultCallable() {
    return stub.updateBacktestResultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a BacktestResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   BacktestResultName backtestResult =
   *       BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportBacktestResultMetadataResponse response =
   *       aMLClient
   *           .exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination)
   *           .get();
   * }
   * }</pre>
   *
   * @param backtestResult Required. The resource name of the BacktestResult.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportBacktestResultMetadataResponse, OperationMetadata>
      exportBacktestResultMetadataAsync(
          BacktestResultName backtestResult, BigQueryDestination structuredMetadataDestination) {
    ExportBacktestResultMetadataRequest request =
        ExportBacktestResultMetadataRequest.newBuilder()
            .setBacktestResult(backtestResult == null ? null : backtestResult.toString())
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportBacktestResultMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a BacktestResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String backtestResult =
   *       BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *           .toString();
   *   BigQueryDestination structuredMetadataDestination = BigQueryDestination.newBuilder().build();
   *   ExportBacktestResultMetadataResponse response =
   *       aMLClient
   *           .exportBacktestResultMetadataAsync(backtestResult, structuredMetadataDestination)
   *           .get();
   * }
   * }</pre>
   *
   * @param backtestResult Required. The resource name of the BacktestResult.
   * @param structuredMetadataDestination Required. BigQuery output where the metadata will be
   *     written.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportBacktestResultMetadataResponse, OperationMetadata>
      exportBacktestResultMetadataAsync(
          String backtestResult, BigQueryDestination structuredMetadataDestination) {
    ExportBacktestResultMetadataRequest request =
        ExportBacktestResultMetadataRequest.newBuilder()
            .setBacktestResult(backtestResult)
            .setStructuredMetadataDestination(structuredMetadataDestination)
            .build();
    return exportBacktestResultMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a BacktestResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportBacktestResultMetadataRequest request =
   *       ExportBacktestResultMetadataRequest.newBuilder()
   *           .setBacktestResult(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ExportBacktestResultMetadataResponse response =
   *       aMLClient.exportBacktestResultMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportBacktestResultMetadataResponse, OperationMetadata>
      exportBacktestResultMetadataAsync(ExportBacktestResultMetadataRequest request) {
    return exportBacktestResultMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a BacktestResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportBacktestResultMetadataRequest request =
   *       ExportBacktestResultMetadataRequest.newBuilder()
   *           .setBacktestResult(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportBacktestResultMetadataResponse, OperationMetadata> future =
   *       aMLClient.exportBacktestResultMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportBacktestResultMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationCallable() {
    return stub.exportBacktestResultMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export governance information for a BacktestResult resource. For information on the exported
   * fields, see [AML output data
   * model](https://cloud.google.com/financial-services/anti-money-laundering/docs/reference/schemas/aml-output-data-model#backtest-results).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ExportBacktestResultMetadataRequest request =
   *       ExportBacktestResultMetadataRequest.newBuilder()
   *           .setBacktestResult(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       aMLClient.exportBacktestResultMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataCallable() {
    return stub.exportBacktestResultMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   BacktestResultName name =
   *       BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]");
   *   aMLClient.deleteBacktestResultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BacktestResult.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBacktestResultAsync(
      BacktestResultName name) {
    DeleteBacktestResultRequest request =
        DeleteBacktestResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBacktestResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   String name =
   *       BacktestResultName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *           .toString();
   *   aMLClient.deleteBacktestResultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BacktestResult.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBacktestResultAsync(String name) {
    DeleteBacktestResultRequest request =
        DeleteBacktestResultRequest.newBuilder().setName(name).build();
    return deleteBacktestResultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteBacktestResultRequest request =
   *       DeleteBacktestResultRequest.newBuilder()
   *           .setName(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   aMLClient.deleteBacktestResultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBacktestResultAsync(
      DeleteBacktestResultRequest request) {
    return deleteBacktestResultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteBacktestResultRequest request =
   *       DeleteBacktestResultRequest.newBuilder()
   *           .setName(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       aMLClient.deleteBacktestResultOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationCallable() {
    return stub.deleteBacktestResultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BacktestResult.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   DeleteBacktestResultRequest request =
   *       DeleteBacktestResultRequest.newBuilder()
   *           .setName(
   *               BacktestResultName.of(
   *                       "[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[BACKTEST_RESULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = aMLClient.deleteBacktestResultCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBacktestResultRequest, Operation>
      deleteBacktestResultCallable() {
    return stub.deleteBacktestResultCallable();
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
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : aMLClient.listLocations(request).iterateAll()) {
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
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = aMLClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = aMLClient.listLocationsCallable().call(request);
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
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = aMLClient.getLocation(request);
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
   * try (AMLClient aMLClient = AMLClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = aMLClient.getLocationCallable().futureCall(request);
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    public static ApiFuture<ListDatasetsPagedResponse> createAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      ApiFuture<ListDatasetsPage> futurePage =
          ListDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatasetsPagedResponse(ListDatasetsPage page) {
      super(page, ListDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatasetsPage
      extends AbstractPage<ListDatasetsRequest, ListDatasetsResponse, Dataset, ListDatasetsPage> {

    private ListDatasetsPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      super(context, response);
    }

    private static ListDatasetsPage createEmptyPage() {
      return new ListDatasetsPage(null, null);
    }

    @Override
    protected ListDatasetsPage createPage(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ListDatasetsResponse response) {
      return new ListDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatasetsPage> createPageAsync(
        PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> context,
        ApiFuture<ListDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatasetsRequest,
          ListDatasetsResponse,
          Dataset,
          ListDatasetsPage,
          ListDatasetsFixedSizeCollection> {

    private ListDatasetsFixedSizeCollection(List<ListDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatasetsFixedSizeCollection createCollection(
        List<ListDatasetsPage> pages, int collectionSize) {
      return new ListDatasetsFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListEngineConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListEngineConfigsRequest,
          ListEngineConfigsResponse,
          EngineConfig,
          ListEngineConfigsPage,
          ListEngineConfigsFixedSizeCollection> {

    public static ApiFuture<ListEngineConfigsPagedResponse> createAsync(
        PageContext<ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig> context,
        ApiFuture<ListEngineConfigsResponse> futureResponse) {
      ApiFuture<ListEngineConfigsPage> futurePage =
          ListEngineConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEngineConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEngineConfigsPagedResponse(ListEngineConfigsPage page) {
      super(page, ListEngineConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEngineConfigsPage
      extends AbstractPage<
          ListEngineConfigsRequest,
          ListEngineConfigsResponse,
          EngineConfig,
          ListEngineConfigsPage> {

    private ListEngineConfigsPage(
        PageContext<ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig> context,
        ListEngineConfigsResponse response) {
      super(context, response);
    }

    private static ListEngineConfigsPage createEmptyPage() {
      return new ListEngineConfigsPage(null, null);
    }

    @Override
    protected ListEngineConfigsPage createPage(
        PageContext<ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig> context,
        ListEngineConfigsResponse response) {
      return new ListEngineConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListEngineConfigsPage> createPageAsync(
        PageContext<ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig> context,
        ApiFuture<ListEngineConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEngineConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEngineConfigsRequest,
          ListEngineConfigsResponse,
          EngineConfig,
          ListEngineConfigsPage,
          ListEngineConfigsFixedSizeCollection> {

    private ListEngineConfigsFixedSizeCollection(
        List<ListEngineConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEngineConfigsFixedSizeCollection createEmptyCollection() {
      return new ListEngineConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEngineConfigsFixedSizeCollection createCollection(
        List<ListEngineConfigsPage> pages, int collectionSize) {
      return new ListEngineConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEngineVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListEngineVersionsRequest,
          ListEngineVersionsResponse,
          EngineVersion,
          ListEngineVersionsPage,
          ListEngineVersionsFixedSizeCollection> {

    public static ApiFuture<ListEngineVersionsPagedResponse> createAsync(
        PageContext<ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion> context,
        ApiFuture<ListEngineVersionsResponse> futureResponse) {
      ApiFuture<ListEngineVersionsPage> futurePage =
          ListEngineVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEngineVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEngineVersionsPagedResponse(ListEngineVersionsPage page) {
      super(page, ListEngineVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEngineVersionsPage
      extends AbstractPage<
          ListEngineVersionsRequest,
          ListEngineVersionsResponse,
          EngineVersion,
          ListEngineVersionsPage> {

    private ListEngineVersionsPage(
        PageContext<ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion> context,
        ListEngineVersionsResponse response) {
      super(context, response);
    }

    private static ListEngineVersionsPage createEmptyPage() {
      return new ListEngineVersionsPage(null, null);
    }

    @Override
    protected ListEngineVersionsPage createPage(
        PageContext<ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion> context,
        ListEngineVersionsResponse response) {
      return new ListEngineVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListEngineVersionsPage> createPageAsync(
        PageContext<ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion> context,
        ApiFuture<ListEngineVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEngineVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEngineVersionsRequest,
          ListEngineVersionsResponse,
          EngineVersion,
          ListEngineVersionsPage,
          ListEngineVersionsFixedSizeCollection> {

    private ListEngineVersionsFixedSizeCollection(
        List<ListEngineVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEngineVersionsFixedSizeCollection createEmptyCollection() {
      return new ListEngineVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEngineVersionsFixedSizeCollection createCollection(
        List<ListEngineVersionsPage> pages, int collectionSize) {
      return new ListEngineVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPredictionResultsPagedResponse
      extends AbstractPagedListResponse<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          PredictionResult,
          ListPredictionResultsPage,
          ListPredictionResultsFixedSizeCollection> {

    public static ApiFuture<ListPredictionResultsPagedResponse> createAsync(
        PageContext<ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>
            context,
        ApiFuture<ListPredictionResultsResponse> futureResponse) {
      ApiFuture<ListPredictionResultsPage> futurePage =
          ListPredictionResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPredictionResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPredictionResultsPagedResponse(ListPredictionResultsPage page) {
      super(page, ListPredictionResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPredictionResultsPage
      extends AbstractPage<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          PredictionResult,
          ListPredictionResultsPage> {

    private ListPredictionResultsPage(
        PageContext<ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>
            context,
        ListPredictionResultsResponse response) {
      super(context, response);
    }

    private static ListPredictionResultsPage createEmptyPage() {
      return new ListPredictionResultsPage(null, null);
    }

    @Override
    protected ListPredictionResultsPage createPage(
        PageContext<ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>
            context,
        ListPredictionResultsResponse response) {
      return new ListPredictionResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListPredictionResultsPage> createPageAsync(
        PageContext<ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>
            context,
        ApiFuture<ListPredictionResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPredictionResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          PredictionResult,
          ListPredictionResultsPage,
          ListPredictionResultsFixedSizeCollection> {

    private ListPredictionResultsFixedSizeCollection(
        List<ListPredictionResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPredictionResultsFixedSizeCollection createEmptyCollection() {
      return new ListPredictionResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPredictionResultsFixedSizeCollection createCollection(
        List<ListPredictionResultsPage> pages, int collectionSize) {
      return new ListPredictionResultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBacktestResultsPagedResponse
      extends AbstractPagedListResponse<
          ListBacktestResultsRequest,
          ListBacktestResultsResponse,
          BacktestResult,
          ListBacktestResultsPage,
          ListBacktestResultsFixedSizeCollection> {

    public static ApiFuture<ListBacktestResultsPagedResponse> createAsync(
        PageContext<ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>
            context,
        ApiFuture<ListBacktestResultsResponse> futureResponse) {
      ApiFuture<ListBacktestResultsPage> futurePage =
          ListBacktestResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBacktestResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBacktestResultsPagedResponse(ListBacktestResultsPage page) {
      super(page, ListBacktestResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBacktestResultsPage
      extends AbstractPage<
          ListBacktestResultsRequest,
          ListBacktestResultsResponse,
          BacktestResult,
          ListBacktestResultsPage> {

    private ListBacktestResultsPage(
        PageContext<ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>
            context,
        ListBacktestResultsResponse response) {
      super(context, response);
    }

    private static ListBacktestResultsPage createEmptyPage() {
      return new ListBacktestResultsPage(null, null);
    }

    @Override
    protected ListBacktestResultsPage createPage(
        PageContext<ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>
            context,
        ListBacktestResultsResponse response) {
      return new ListBacktestResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListBacktestResultsPage> createPageAsync(
        PageContext<ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>
            context,
        ApiFuture<ListBacktestResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBacktestResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBacktestResultsRequest,
          ListBacktestResultsResponse,
          BacktestResult,
          ListBacktestResultsPage,
          ListBacktestResultsFixedSizeCollection> {

    private ListBacktestResultsFixedSizeCollection(
        List<ListBacktestResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBacktestResultsFixedSizeCollection createEmptyCollection() {
      return new ListBacktestResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBacktestResultsFixedSizeCollection createCollection(
        List<ListBacktestResultsPage> pages, int collectionSize) {
      return new ListBacktestResultsFixedSizeCollection(pages, collectionSize);
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
