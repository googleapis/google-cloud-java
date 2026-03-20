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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.VertexRagDataServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.VertexRagDataServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing user data for RAG.
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
 * try (VertexRagDataServiceClient vertexRagDataServiceClient =
 *     VertexRagDataServiceClient.create()) {
 *   RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
 *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VertexRagDataServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRagCorpus</td>
 *      <td><p> Creates a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRagCorpusAsync(CreateRagCorpusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRagCorpusAsync(LocationName parent, RagCorpus ragCorpus)
 *           <li><p> createRagCorpusAsync(String parent, RagCorpus ragCorpus)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRagCorpusOperationCallable()
 *           <li><p> createRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRagCorpus</td>
 *      <td><p> Updates a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRagCorpusAsync(UpdateRagCorpusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRagCorpusAsync(RagCorpus ragCorpus)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRagCorpusOperationCallable()
 *           <li><p> updateRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagCorpus</td>
 *      <td><p> Gets a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagCorpus(GetRagCorpusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagCorpus(RagCorpusName name)
 *           <li><p> getRagCorpus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRagCorpora</td>
 *      <td><p> Lists RagCorpora in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRagCorpora(ListRagCorporaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRagCorpora(LocationName parent)
 *           <li><p> listRagCorpora(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRagCorporaPagedCallable()
 *           <li><p> listRagCorporaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRagCorpus</td>
 *      <td><p> Deletes a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRagCorpusAsync(DeleteRagCorpusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRagCorpusAsync(RagCorpusName name)
 *           <li><p> deleteRagCorpusAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRagCorpusOperationCallable()
 *           <li><p> deleteRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UploadRagFile</td>
 *      <td><p> Upload a file into a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadRagFile(UploadRagFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> uploadRagFile(RagCorpusName parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig)
 *           <li><p> uploadRagFile(String parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadRagFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportRagFiles</td>
 *      <td><p> Import files from Google Cloud Storage or Google Drive into a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importRagFilesAsync(ImportRagFilesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importRagFilesAsync(RagCorpusName parent, ImportRagFilesConfig importRagFilesConfig)
 *           <li><p> importRagFilesAsync(String parent, ImportRagFilesConfig importRagFilesConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importRagFilesOperationCallable()
 *           <li><p> importRagFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagFile</td>
 *      <td><p> Gets a RagFile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagFile(GetRagFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagFile(RagFileName name)
 *           <li><p> getRagFile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRagFiles</td>
 *      <td><p> Lists RagFiles in a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRagFiles(ListRagFilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRagFiles(RagCorpusName parent)
 *           <li><p> listRagFiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRagFilesPagedCallable()
 *           <li><p> listRagFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRagFile</td>
 *      <td><p> Deletes a RagFile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRagFileAsync(DeleteRagFileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRagFileAsync(RagFileName name)
 *           <li><p> deleteRagFileAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRagFileOperationCallable()
 *           <li><p> deleteRagFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRagEngineConfig</td>
 *      <td><p> Updates a RagEngineConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRagEngineConfigAsync(UpdateRagEngineConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRagEngineConfigAsync(RagEngineConfig ragEngineConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRagEngineConfigOperationCallable()
 *           <li><p> updateRagEngineConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagEngineConfig</td>
 *      <td><p> Gets a RagEngineConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagEngineConfig(GetRagEngineConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagEngineConfig(RagEngineConfigName name)
 *           <li><p> getRagEngineConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagEngineConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRagDataSchema</td>
 *      <td><p> Creates a RagDataSchema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRagDataSchema(CreateRagDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRagDataSchema(RagCorpusName parent, RagDataSchema ragDataSchema, String ragDataSchemaId)
 *           <li><p> createRagDataSchema(String parent, RagDataSchema ragDataSchema, String ragDataSchemaId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRagDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateRagDataSchemas</td>
 *      <td><p> Batch Create one or more RagDataSchemas</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateRagDataSchemasAsync(BatchCreateRagDataSchemasRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateRagDataSchemasOperationCallable()
 *           <li><p> batchCreateRagDataSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagDataSchema</td>
 *      <td><p> Gets a RagDataSchema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagDataSchema(GetRagDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagDataSchema(RagDataSchemaName name)
 *           <li><p> getRagDataSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRagDataSchemas</td>
 *      <td><p> Lists RagDataSchemas in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRagDataSchemas(ListRagDataSchemasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRagDataSchemas(RagCorpusName parent)
 *           <li><p> listRagDataSchemas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRagDataSchemasPagedCallable()
 *           <li><p> listRagDataSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRagDataSchema</td>
 *      <td><p> Deletes a RagDataSchema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRagDataSchema(DeleteRagDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRagDataSchema(RagDataSchemaName name)
 *           <li><p> deleteRagDataSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRagDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteRagDataSchemas</td>
 *      <td><p> Batch Deletes one or more RagDataSchemas</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteRagDataSchemasAsync(BatchDeleteRagDataSchemasRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteRagDataSchemasOperationCallable()
 *           <li><p> batchDeleteRagDataSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRagMetadata</td>
 *      <td><p> Creates a RagMetadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRagMetadata(CreateRagMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRagMetadata(RagFileName parent, RagMetadata ragMetadata, String ragMetadataId)
 *           <li><p> createRagMetadata(String parent, RagMetadata ragMetadata, String ragMetadataId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRagMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateRagMetadata</td>
 *      <td><p> Batch Create one or more RagMetadatas</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateRagMetadataAsync(BatchCreateRagMetadataRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateRagMetadataOperationCallable()
 *           <li><p> batchCreateRagMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRagMetadata</td>
 *      <td><p> Updates a RagMetadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRagMetadata(UpdateRagMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRagMetadata(RagMetadata ragMetadata)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRagMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagMetadata</td>
 *      <td><p> Gets a RagMetadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagMetadata(GetRagMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagMetadata(RagMetadataName name)
 *           <li><p> getRagMetadata(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRagMetadata</td>
 *      <td><p> Lists RagMetadata in a RagFile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRagMetadata(ListRagMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRagMetadata(RagFileName parent)
 *           <li><p> listRagMetadata(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRagMetadataPagedCallable()
 *           <li><p> listRagMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRagMetadata</td>
 *      <td><p> Deletes a RagMetadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRagMetadata(DeleteRagMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRagMetadata(RagMetadataName name)
 *           <li><p> deleteRagMetadata(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRagMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteRagMetadata</td>
 *      <td><p> Batch Deletes one or more RagMetadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteRagMetadataAsync(BatchDeleteRagMetadataRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteRagMetadataOperationCallable()
 *           <li><p> batchDeleteRagMetadataCallable()
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
 * <p>This class can be customized by passing in a custom instance of VertexRagDataServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VertexRagDataServiceSettings vertexRagDataServiceSettings =
 *     VertexRagDataServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VertexRagDataServiceClient vertexRagDataServiceClient =
 *     VertexRagDataServiceClient.create(vertexRagDataServiceSettings);
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
 * VertexRagDataServiceSettings vertexRagDataServiceSettings =
 *     VertexRagDataServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VertexRagDataServiceClient vertexRagDataServiceClient =
 *     VertexRagDataServiceClient.create(vertexRagDataServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VertexRagDataServiceClient implements BackgroundResource {
  private final VertexRagDataServiceSettings settings;
  private final VertexRagDataServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of VertexRagDataServiceClient with default settings. */
  public static final VertexRagDataServiceClient create() throws IOException {
    return create(VertexRagDataServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VertexRagDataServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VertexRagDataServiceClient create(VertexRagDataServiceSettings settings)
      throws IOException {
    return new VertexRagDataServiceClient(settings);
  }

  /**
   * Constructs an instance of VertexRagDataServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(VertexRagDataServiceSettings).
   */
  public static final VertexRagDataServiceClient create(VertexRagDataServiceStub stub) {
    return new VertexRagDataServiceClient(stub);
  }

  /**
   * Constructs an instance of VertexRagDataServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected VertexRagDataServiceClient(VertexRagDataServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VertexRagDataServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected VertexRagDataServiceClient(VertexRagDataServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final VertexRagDataServiceSettings getSettings() {
    return settings;
  }

  public VertexRagDataServiceStub getStub() {
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
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RagCorpus ragCorpus = RagCorpus.newBuilder().build();
   *   RagCorpus response = vertexRagDataServiceClient.createRagCorpusAsync(parent, ragCorpus).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the RagCorpus in. Format:
   *     `projects/{project}/locations/{location}`
   * @param ragCorpus Required. The RagCorpus to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> createRagCorpusAsync(
      LocationName parent, RagCorpus ragCorpus) {
    CreateRagCorpusRequest request =
        CreateRagCorpusRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRagCorpus(ragCorpus)
            .build();
    return createRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RagCorpus ragCorpus = RagCorpus.newBuilder().build();
   *   RagCorpus response = vertexRagDataServiceClient.createRagCorpusAsync(parent, ragCorpus).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the RagCorpus in. Format:
   *     `projects/{project}/locations/{location}`
   * @param ragCorpus Required. The RagCorpus to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> createRagCorpusAsync(
      String parent, RagCorpus ragCorpus) {
    CreateRagCorpusRequest request =
        CreateRagCorpusRequest.newBuilder().setParent(parent).setRagCorpus(ragCorpus).build();
    return createRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagCorpusRequest request =
   *       CreateRagCorpusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRagCorpus(RagCorpus.newBuilder().build())
   *           .build();
   *   RagCorpus response = vertexRagDataServiceClient.createRagCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> createRagCorpusAsync(
      CreateRagCorpusRequest request) {
    return createRagCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagCorpusRequest request =
   *       CreateRagCorpusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRagCorpus(RagCorpus.newBuilder().build())
   *           .build();
   *   OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> future =
   *       vertexRagDataServiceClient.createRagCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   RagCorpus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationCallable() {
    return stub.createRagCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagCorpusRequest request =
   *       CreateRagCorpusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRagCorpus(RagCorpus.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.createRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRagCorpusRequest, Operation> createRagCorpusCallable() {
    return stub.createRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpus ragCorpus = RagCorpus.newBuilder().build();
   *   RagCorpus response = vertexRagDataServiceClient.updateRagCorpusAsync(ragCorpus).get();
   * }
   * }</pre>
   *
   * @param ragCorpus Required. The RagCorpus which replaces the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, UpdateRagCorpusOperationMetadata> updateRagCorpusAsync(
      RagCorpus ragCorpus) {
    UpdateRagCorpusRequest request =
        UpdateRagCorpusRequest.newBuilder().setRagCorpus(ragCorpus).build();
    return updateRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagCorpusRequest request =
   *       UpdateRagCorpusRequest.newBuilder().setRagCorpus(RagCorpus.newBuilder().build()).build();
   *   RagCorpus response = vertexRagDataServiceClient.updateRagCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, UpdateRagCorpusOperationMetadata> updateRagCorpusAsync(
      UpdateRagCorpusRequest request) {
    return updateRagCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagCorpusRequest request =
   *       UpdateRagCorpusRequest.newBuilder().setRagCorpus(RagCorpus.newBuilder().build()).build();
   *   OperationFuture<RagCorpus, UpdateRagCorpusOperationMetadata> future =
   *       vertexRagDataServiceClient.updateRagCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   RagCorpus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateRagCorpusRequest, RagCorpus, UpdateRagCorpusOperationMetadata>
      updateRagCorpusOperationCallable() {
    return stub.updateRagCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagCorpusRequest request =
   *       UpdateRagCorpusRequest.newBuilder().setRagCorpus(RagCorpus.newBuilder().build()).build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.updateRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRagCorpusRequest, Operation> updateRagCorpusCallable() {
    return stub.updateRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagCorpus getRagCorpus(RagCorpusName name) {
    GetRagCorpusRequest request =
        GetRagCorpusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRagCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagCorpus getRagCorpus(String name) {
    GetRagCorpusRequest request = GetRagCorpusRequest.newBuilder().setName(name).build();
    return getRagCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagCorpusRequest request =
   *       GetRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .build();
   *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagCorpus getRagCorpus(GetRagCorpusRequest request) {
    return getRagCorpusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagCorpusRequest request =
   *       GetRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .build();
   *   ApiFuture<RagCorpus> future =
   *       vertexRagDataServiceClient.getRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   RagCorpus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagCorpusRequest, RagCorpus> getRagCorpusCallable() {
    return stub.getRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RagCorpus element : vertexRagDataServiceClient.listRagCorpora(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the RagCorpora.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagCorporaPagedResponse listRagCorpora(LocationName parent) {
    ListRagCorporaRequest request =
        ListRagCorporaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRagCorpora(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RagCorpus element : vertexRagDataServiceClient.listRagCorpora(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the RagCorpora.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagCorporaPagedResponse listRagCorpora(String parent) {
    ListRagCorporaRequest request = ListRagCorporaRequest.newBuilder().setParent(parent).build();
    return listRagCorpora(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagCorporaRequest request =
   *       ListRagCorporaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RagCorpus element : vertexRagDataServiceClient.listRagCorpora(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagCorporaPagedResponse listRagCorpora(ListRagCorporaRequest request) {
    return listRagCorporaPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagCorporaRequest request =
   *       ListRagCorporaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RagCorpus> future =
   *       vertexRagDataServiceClient.listRagCorporaPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RagCorpus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRagCorporaRequest, ListRagCorporaPagedResponse>
      listRagCorporaPagedCallable() {
    return stub.listRagCorporaPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagCorporaRequest request =
   *       ListRagCorporaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRagCorporaResponse response =
   *         vertexRagDataServiceClient.listRagCorporaCallable().call(request);
   *     for (RagCorpus element : response.getRagCorporaList()) {
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
  public final UnaryCallable<ListRagCorporaRequest, ListRagCorporaResponse>
      listRagCorporaCallable() {
    return stub.listRagCorporaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   vertexRagDataServiceClient.deleteRagCorpusAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagCorpusAsync(
      RagCorpusName name) {
    DeleteRagCorpusRequest request =
        DeleteRagCorpusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   vertexRagDataServiceClient.deleteRagCorpusAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagCorpusAsync(String name) {
    DeleteRagCorpusRequest request = DeleteRagCorpusRequest.newBuilder().setName(name).build();
    return deleteRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagCorpusRequest request =
   *       DeleteRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setForce(true)
   *           .setForceDelete(true)
   *           .build();
   *   vertexRagDataServiceClient.deleteRagCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagCorpusAsync(
      DeleteRagCorpusRequest request) {
    return deleteRagCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagCorpusRequest request =
   *       DeleteRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setForce(true)
   *           .setForceDelete(true)
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       vertexRagDataServiceClient.deleteRagCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationCallable() {
    return stub.deleteRagCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagCorpusRequest request =
   *       DeleteRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setForce(true)
   *           .setForceDelete(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.deleteRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRagCorpusRequest, Operation> deleteRagCorpusCallable() {
    return stub.deleteRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   RagFile ragFile = RagFile.newBuilder().build();
   *   UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();
   *   UploadRagFileResponse response =
   *       vertexRagDataServiceClient.uploadRagFile(parent, ragFile, uploadRagFileConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to upload the file.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param ragFile Required. The RagFile to upload.
   * @param uploadRagFileConfig Required. The config for the RagFiles to be uploaded into the
   *     RagCorpus.
   *     [VertexRagDataService.UploadRagFile][google.cloud.aiplatform.v1beta1.VertexRagDataService.UploadRagFile].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadRagFileResponse uploadRagFile(
      RagCorpusName parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig) {
    UploadRagFileRequest request =
        UploadRagFileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRagFile(ragFile)
            .setUploadRagFileConfig(uploadRagFileConfig)
            .build();
    return uploadRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   RagFile ragFile = RagFile.newBuilder().build();
   *   UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();
   *   UploadRagFileResponse response =
   *       vertexRagDataServiceClient.uploadRagFile(parent, ragFile, uploadRagFileConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to upload the file.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param ragFile Required. The RagFile to upload.
   * @param uploadRagFileConfig Required. The config for the RagFiles to be uploaded into the
   *     RagCorpus.
   *     [VertexRagDataService.UploadRagFile][google.cloud.aiplatform.v1beta1.VertexRagDataService.UploadRagFile].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadRagFileResponse uploadRagFile(
      String parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig) {
    UploadRagFileRequest request =
        UploadRagFileRequest.newBuilder()
            .setParent(parent)
            .setRagFile(ragFile)
            .setUploadRagFileConfig(uploadRagFileConfig)
            .build();
    return uploadRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UploadRagFileRequest request =
   *       UploadRagFileRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setRagFile(RagFile.newBuilder().build())
   *           .setUploadRagFileConfig(UploadRagFileConfig.newBuilder().build())
   *           .build();
   *   UploadRagFileResponse response = vertexRagDataServiceClient.uploadRagFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadRagFileResponse uploadRagFile(UploadRagFileRequest request) {
    return uploadRagFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UploadRagFileRequest request =
   *       UploadRagFileRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setRagFile(RagFile.newBuilder().build())
   *           .setUploadRagFileConfig(UploadRagFileConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<UploadRagFileResponse> future =
   *       vertexRagDataServiceClient.uploadRagFileCallable().futureCall(request);
   *   // Do something.
   *   UploadRagFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileCallable() {
    return stub.uploadRagFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();
   *   ImportRagFilesResponse response =
   *       vertexRagDataServiceClient.importRagFilesAsync(parent, importRagFilesConfig).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to import files. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param importRagFilesConfig Required. The config for the RagFiles to be synced and imported
   *     into the RagCorpus.
   *     [VertexRagDataService.ImportRagFiles][google.cloud.aiplatform.v1beta1.VertexRagDataService.ImportRagFiles].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesAsync(RagCorpusName parent, ImportRagFilesConfig importRagFilesConfig) {
    ImportRagFilesRequest request =
        ImportRagFilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setImportRagFilesConfig(importRagFilesConfig)
            .build();
    return importRagFilesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();
   *   ImportRagFilesResponse response =
   *       vertexRagDataServiceClient.importRagFilesAsync(parent, importRagFilesConfig).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to import files. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param importRagFilesConfig Required. The config for the RagFiles to be synced and imported
   *     into the RagCorpus.
   *     [VertexRagDataService.ImportRagFiles][google.cloud.aiplatform.v1beta1.VertexRagDataService.ImportRagFiles].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesAsync(String parent, ImportRagFilesConfig importRagFilesConfig) {
    ImportRagFilesRequest request =
        ImportRagFilesRequest.newBuilder()
            .setParent(parent)
            .setImportRagFilesConfig(importRagFilesConfig)
            .build();
    return importRagFilesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ImportRagFilesRequest request =
   *       ImportRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setImportRagFilesConfig(ImportRagFilesConfig.newBuilder().build())
   *           .build();
   *   ImportRagFilesResponse response =
   *       vertexRagDataServiceClient.importRagFilesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesAsync(ImportRagFilesRequest request) {
    return importRagFilesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ImportRagFilesRequest request =
   *       ImportRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setImportRagFilesConfig(ImportRagFilesConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata> future =
   *       vertexRagDataServiceClient.importRagFilesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportRagFilesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationCallable() {
    return stub.importRagFilesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ImportRagFilesRequest request =
   *       ImportRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setImportRagFilesConfig(ImportRagFilesConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.importRagFilesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportRagFilesRequest, Operation> importRagFilesCallable() {
    return stub.importRagFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
   *   RagFile response = vertexRagDataServiceClient.getRagFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagFile getRagFile(RagFileName name) {
    GetRagFileRequest request =
        GetRagFileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString();
   *   RagFile response = vertexRagDataServiceClient.getRagFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagFile getRagFile(String name) {
    GetRagFileRequest request = GetRagFileRequest.newBuilder().setName(name).build();
    return getRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagFileRequest request =
   *       GetRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   RagFile response = vertexRagDataServiceClient.getRagFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagFile getRagFile(GetRagFileRequest request) {
    return getRagFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagFileRequest request =
   *       GetRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RagFile> future =
   *       vertexRagDataServiceClient.getRagFileCallable().futureCall(request);
   *   // Do something.
   *   RagFile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagFileRequest, RagFile> getRagFileCallable() {
    return stub.getRagFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   for (RagFile element : vertexRagDataServiceClient.listRagFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus from which to list the RagFiles.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagFilesPagedResponse listRagFiles(RagCorpusName parent) {
    ListRagFilesRequest request =
        ListRagFilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRagFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   for (RagFile element : vertexRagDataServiceClient.listRagFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus from which to list the RagFiles.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagFilesPagedResponse listRagFiles(String parent) {
    ListRagFilesRequest request = ListRagFilesRequest.newBuilder().setParent(parent).build();
    return listRagFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagFilesRequest request =
   *       ListRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RagFile element : vertexRagDataServiceClient.listRagFiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagFilesPagedResponse listRagFiles(ListRagFilesRequest request) {
    return listRagFilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagFilesRequest request =
   *       ListRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RagFile> future =
   *       vertexRagDataServiceClient.listRagFilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RagFile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRagFilesRequest, ListRagFilesPagedResponse>
      listRagFilesPagedCallable() {
    return stub.listRagFilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagFilesRequest request =
   *       ListRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRagFilesResponse response =
   *         vertexRagDataServiceClient.listRagFilesCallable().call(request);
   *     for (RagFile element : response.getRagFilesList()) {
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
  public final UnaryCallable<ListRagFilesRequest, ListRagFilesResponse> listRagFilesCallable() {
    return stub.listRagFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
   *   vertexRagDataServiceClient.deleteRagFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagFileAsync(
      RagFileName name) {
    DeleteRagFileRequest request =
        DeleteRagFileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRagFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString();
   *   vertexRagDataServiceClient.deleteRagFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagFileAsync(String name) {
    DeleteRagFileRequest request = DeleteRagFileRequest.newBuilder().setName(name).build();
    return deleteRagFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagFileRequest request =
   *       DeleteRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setForceDelete(true)
   *           .build();
   *   vertexRagDataServiceClient.deleteRagFileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagFileAsync(
      DeleteRagFileRequest request) {
    return deleteRagFileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagFileRequest request =
   *       DeleteRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setForceDelete(true)
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       vertexRagDataServiceClient.deleteRagFileOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationCallable() {
    return stub.deleteRagFileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagFileRequest request =
   *       DeleteRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setForceDelete(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.deleteRagFileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRagFileRequest, Operation> deleteRagFileCallable() {
    return stub.deleteRagFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagEngineConfig ragEngineConfig = RagEngineConfig.newBuilder().build();
   *   RagEngineConfig response =
   *       vertexRagDataServiceClient.updateRagEngineConfigAsync(ragEngineConfig).get();
   * }
   * }</pre>
   *
   * @param ragEngineConfig Required. The updated RagEngineConfig.
   *     <p>NOTE: Downgrading your RagManagedDb's ComputeTier could temporarily increase request
   *     latencies until the operation is fully complete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagEngineConfig, UpdateRagEngineConfigOperationMetadata>
      updateRagEngineConfigAsync(RagEngineConfig ragEngineConfig) {
    UpdateRagEngineConfigRequest request =
        UpdateRagEngineConfigRequest.newBuilder().setRagEngineConfig(ragEngineConfig).build();
    return updateRagEngineConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagEngineConfigRequest request =
   *       UpdateRagEngineConfigRequest.newBuilder()
   *           .setRagEngineConfig(RagEngineConfig.newBuilder().build())
   *           .build();
   *   RagEngineConfig response =
   *       vertexRagDataServiceClient.updateRagEngineConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagEngineConfig, UpdateRagEngineConfigOperationMetadata>
      updateRagEngineConfigAsync(UpdateRagEngineConfigRequest request) {
    return updateRagEngineConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagEngineConfigRequest request =
   *       UpdateRagEngineConfigRequest.newBuilder()
   *           .setRagEngineConfig(RagEngineConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<RagEngineConfig, UpdateRagEngineConfigOperationMetadata> future =
   *       vertexRagDataServiceClient.updateRagEngineConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   RagEngineConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateRagEngineConfigRequest, RagEngineConfig, UpdateRagEngineConfigOperationMetadata>
      updateRagEngineConfigOperationCallable() {
    return stub.updateRagEngineConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagEngineConfigRequest request =
   *       UpdateRagEngineConfigRequest.newBuilder()
   *           .setRagEngineConfig(RagEngineConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.updateRagEngineConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRagEngineConfigRequest, Operation>
      updateRagEngineConfigCallable() {
    return stub.updateRagEngineConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagEngineConfigName name = RagEngineConfigName.of("[PROJECT]", "[LOCATION]");
   *   RagEngineConfig response = vertexRagDataServiceClient.getRagEngineConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagEngineConfig resource. Format:
   *     `projects/{project}/locations/{location}/ragEngineConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagEngineConfig getRagEngineConfig(RagEngineConfigName name) {
    GetRagEngineConfigRequest request =
        GetRagEngineConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRagEngineConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name = RagEngineConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   RagEngineConfig response = vertexRagDataServiceClient.getRagEngineConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagEngineConfig resource. Format:
   *     `projects/{project}/locations/{location}/ragEngineConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagEngineConfig getRagEngineConfig(String name) {
    GetRagEngineConfigRequest request =
        GetRagEngineConfigRequest.newBuilder().setName(name).build();
    return getRagEngineConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagEngineConfigRequest request =
   *       GetRagEngineConfigRequest.newBuilder()
   *           .setName(RagEngineConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   RagEngineConfig response = vertexRagDataServiceClient.getRagEngineConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagEngineConfig getRagEngineConfig(GetRagEngineConfigRequest request) {
    return getRagEngineConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagEngineConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagEngineConfigRequest request =
   *       GetRagEngineConfigRequest.newBuilder()
   *           .setName(RagEngineConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<RagEngineConfig> future =
   *       vertexRagDataServiceClient.getRagEngineConfigCallable().futureCall(request);
   *   // Do something.
   *   RagEngineConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagEngineConfigRequest, RagEngineConfig>
      getRagEngineConfigCallable() {
    return stub.getRagEngineConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   RagDataSchema ragDataSchema = RagDataSchema.newBuilder().build();
   *   String ragDataSchemaId = "ragDataSchemaId-1094185826";
   *   RagDataSchema response =
   *       vertexRagDataServiceClient.createRagDataSchema(parent, ragDataSchema, ragDataSchemaId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus to create the RagDataSchema in.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param ragDataSchema Required. The RagDataSchema to create.
   * @param ragDataSchemaId Optional. The ID to use for the RagDataSchema, which will become the
   *     final component of the RagDataSchema's resource name if the user chooses to specify.
   *     Otherwise, RagDataSchema id will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagDataSchema createRagDataSchema(
      RagCorpusName parent, RagDataSchema ragDataSchema, String ragDataSchemaId) {
    CreateRagDataSchemaRequest request =
        CreateRagDataSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRagDataSchema(ragDataSchema)
            .setRagDataSchemaId(ragDataSchemaId)
            .build();
    return createRagDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   RagDataSchema ragDataSchema = RagDataSchema.newBuilder().build();
   *   String ragDataSchemaId = "ragDataSchemaId-1094185826";
   *   RagDataSchema response =
   *       vertexRagDataServiceClient.createRagDataSchema(parent, ragDataSchema, ragDataSchemaId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus to create the RagDataSchema in.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param ragDataSchema Required. The RagDataSchema to create.
   * @param ragDataSchemaId Optional. The ID to use for the RagDataSchema, which will become the
   *     final component of the RagDataSchema's resource name if the user chooses to specify.
   *     Otherwise, RagDataSchema id will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagDataSchema createRagDataSchema(
      String parent, RagDataSchema ragDataSchema, String ragDataSchemaId) {
    CreateRagDataSchemaRequest request =
        CreateRagDataSchemaRequest.newBuilder()
            .setParent(parent)
            .setRagDataSchema(ragDataSchema)
            .setRagDataSchemaId(ragDataSchemaId)
            .build();
    return createRagDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagDataSchemaRequest request =
   *       CreateRagDataSchemaRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setRagDataSchema(RagDataSchema.newBuilder().build())
   *           .setRagDataSchemaId("ragDataSchemaId-1094185826")
   *           .build();
   *   RagDataSchema response = vertexRagDataServiceClient.createRagDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagDataSchema createRagDataSchema(CreateRagDataSchemaRequest request) {
    return createRagDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagDataSchemaRequest request =
   *       CreateRagDataSchemaRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setRagDataSchema(RagDataSchema.newBuilder().build())
   *           .setRagDataSchemaId("ragDataSchemaId-1094185826")
   *           .build();
   *   ApiFuture<RagDataSchema> future =
   *       vertexRagDataServiceClient.createRagDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   RagDataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRagDataSchemaRequest, RagDataSchema>
      createRagDataSchemaCallable() {
    return stub.createRagDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Create one or more RagDataSchemas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchCreateRagDataSchemasRequest request =
   *       BatchCreateRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .addAllRequests(new ArrayList<CreateRagDataSchemaRequest>())
   *           .build();
   *   BatchCreateRagDataSchemasResponse response =
   *       vertexRagDataServiceClient.batchCreateRagDataSchemasAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchCreateRagDataSchemasResponse, BatchCreateRagDataSchemasOperationMetadata>
      batchCreateRagDataSchemasAsync(BatchCreateRagDataSchemasRequest request) {
    return batchCreateRagDataSchemasOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Create one or more RagDataSchemas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchCreateRagDataSchemasRequest request =
   *       BatchCreateRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .addAllRequests(new ArrayList<CreateRagDataSchemaRequest>())
   *           .build();
   *   OperationFuture<BatchCreateRagDataSchemasResponse, BatchCreateRagDataSchemasOperationMetadata>
   *       future =
   *           vertexRagDataServiceClient
   *               .batchCreateRagDataSchemasOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   BatchCreateRagDataSchemasResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchCreateRagDataSchemasRequest,
          BatchCreateRagDataSchemasResponse,
          BatchCreateRagDataSchemasOperationMetadata>
      batchCreateRagDataSchemasOperationCallable() {
    return stub.batchCreateRagDataSchemasOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Create one or more RagDataSchemas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchCreateRagDataSchemasRequest request =
   *       BatchCreateRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .addAllRequests(new ArrayList<CreateRagDataSchemaRequest>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.batchCreateRagDataSchemasCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateRagDataSchemasRequest, Operation>
      batchCreateRagDataSchemasCallable() {
    return stub.batchCreateRagDataSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagDataSchemaName name =
   *       RagDataSchemaName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]");
   *   RagDataSchema response = vertexRagDataServiceClient.getRagDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagDataSchema resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragDataSchemas/{rag_data_schema}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagDataSchema getRagDataSchema(RagDataSchemaName name) {
    GetRagDataSchemaRequest request =
        GetRagDataSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRagDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagDataSchemaName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]")
   *           .toString();
   *   RagDataSchema response = vertexRagDataServiceClient.getRagDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagDataSchema resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragDataSchemas/{rag_data_schema}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagDataSchema getRagDataSchema(String name) {
    GetRagDataSchemaRequest request = GetRagDataSchemaRequest.newBuilder().setName(name).build();
    return getRagDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagDataSchemaRequest request =
   *       GetRagDataSchemaRequest.newBuilder()
   *           .setName(
   *               RagDataSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   RagDataSchema response = vertexRagDataServiceClient.getRagDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagDataSchema getRagDataSchema(GetRagDataSchemaRequest request) {
    return getRagDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagDataSchemaRequest request =
   *       GetRagDataSchemaRequest.newBuilder()
   *           .setName(
   *               RagDataSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RagDataSchema> future =
   *       vertexRagDataServiceClient.getRagDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   RagDataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagDataSchemaRequest, RagDataSchema> getRagDataSchemaCallable() {
    return stub.getRagDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagDataSchemas in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   for (RagDataSchema element :
   *       vertexRagDataServiceClient.listRagDataSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus from which to list the
   *     RagDataSchemas. Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagDataSchemasPagedResponse listRagDataSchemas(RagCorpusName parent) {
    ListRagDataSchemasRequest request =
        ListRagDataSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRagDataSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagDataSchemas in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   for (RagDataSchema element :
   *       vertexRagDataServiceClient.listRagDataSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus from which to list the
   *     RagDataSchemas. Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagDataSchemasPagedResponse listRagDataSchemas(String parent) {
    ListRagDataSchemasRequest request =
        ListRagDataSchemasRequest.newBuilder().setParent(parent).build();
    return listRagDataSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagDataSchemas in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagDataSchemasRequest request =
   *       ListRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RagDataSchema element :
   *       vertexRagDataServiceClient.listRagDataSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagDataSchemasPagedResponse listRagDataSchemas(
      ListRagDataSchemasRequest request) {
    return listRagDataSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagDataSchemas in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagDataSchemasRequest request =
   *       ListRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RagDataSchema> future =
   *       vertexRagDataServiceClient.listRagDataSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RagDataSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRagDataSchemasRequest, ListRagDataSchemasPagedResponse>
      listRagDataSchemasPagedCallable() {
    return stub.listRagDataSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagDataSchemas in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagDataSchemasRequest request =
   *       ListRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRagDataSchemasResponse response =
   *         vertexRagDataServiceClient.listRagDataSchemasCallable().call(request);
   *     for (RagDataSchema element : response.getRagDataSchemasList()) {
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
  public final UnaryCallable<ListRagDataSchemasRequest, ListRagDataSchemasResponse>
      listRagDataSchemasCallable() {
    return stub.listRagDataSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagDataSchemaName name =
   *       RagDataSchemaName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]");
   *   vertexRagDataServiceClient.deleteRagDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagDataSchema resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragDataSchemas/{rag_data_schema}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRagDataSchema(RagDataSchemaName name) {
    DeleteRagDataSchemaRequest request =
        DeleteRagDataSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteRagDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagDataSchemaName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]")
   *           .toString();
   *   vertexRagDataServiceClient.deleteRagDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagDataSchema resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragDataSchemas/{rag_data_schema}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRagDataSchema(String name) {
    DeleteRagDataSchemaRequest request =
        DeleteRagDataSchemaRequest.newBuilder().setName(name).build();
    deleteRagDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagDataSchemaRequest request =
   *       DeleteRagDataSchemaRequest.newBuilder()
   *           .setName(
   *               RagDataSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   vertexRagDataServiceClient.deleteRagDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRagDataSchema(DeleteRagDataSchemaRequest request) {
    deleteRagDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagDataSchema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagDataSchemaRequest request =
   *       DeleteRagDataSchemaRequest.newBuilder()
   *           .setName(
   *               RagDataSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       vertexRagDataServiceClient.deleteRagDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRagDataSchemaRequest, Empty> deleteRagDataSchemaCallable() {
    return stub.deleteRagDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Deletes one or more RagDataSchemas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchDeleteRagDataSchemasRequest request =
   *       BatchDeleteRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   vertexRagDataServiceClient.batchDeleteRagDataSchemasAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> batchDeleteRagDataSchemasAsync(
      BatchDeleteRagDataSchemasRequest request) {
    return batchDeleteRagDataSchemasOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Deletes one or more RagDataSchemas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchDeleteRagDataSchemasRequest request =
   *       BatchDeleteRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       vertexRagDataServiceClient
   *           .batchDeleteRagDataSchemasOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchDeleteRagDataSchemasRequest, Empty, DeleteOperationMetadata>
      batchDeleteRagDataSchemasOperationCallable() {
    return stub.batchDeleteRagDataSchemasOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Deletes one or more RagDataSchemas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchDeleteRagDataSchemasRequest request =
   *       BatchDeleteRagDataSchemasRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.batchDeleteRagDataSchemasCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteRagDataSchemasRequest, Operation>
      batchDeleteRagDataSchemasCallable() {
    return stub.batchDeleteRagDataSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagFileName parent = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
   *   RagMetadata ragMetadata = RagMetadata.newBuilder().build();
   *   String ragMetadataId = "ragMetadataId-818296094";
   *   RagMetadata response =
   *       vertexRagDataServiceClient.createRagMetadata(parent, ragMetadata, ragMetadataId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this metadata will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @param ragMetadata Required. The metadata to create.
   * @param ragMetadataId Optional. The ID to use for the metadata, which will become the final
   *     component of the metadata's resource name if the user chooses to specify. Otherwise,
   *     metadata id will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata createRagMetadata(
      RagFileName parent, RagMetadata ragMetadata, String ragMetadataId) {
    CreateRagMetadataRequest request =
        CreateRagMetadataRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRagMetadata(ragMetadata)
            .setRagMetadataId(ragMetadataId)
            .build();
    return createRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent =
   *       RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString();
   *   RagMetadata ragMetadata = RagMetadata.newBuilder().build();
   *   String ragMetadataId = "ragMetadataId-818296094";
   *   RagMetadata response =
   *       vertexRagDataServiceClient.createRagMetadata(parent, ragMetadata, ragMetadataId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this metadata will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @param ragMetadata Required. The metadata to create.
   * @param ragMetadataId Optional. The ID to use for the metadata, which will become the final
   *     component of the metadata's resource name if the user chooses to specify. Otherwise,
   *     metadata id will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata createRagMetadata(
      String parent, RagMetadata ragMetadata, String ragMetadataId) {
    CreateRagMetadataRequest request =
        CreateRagMetadataRequest.newBuilder()
            .setParent(parent)
            .setRagMetadata(ragMetadata)
            .setRagMetadataId(ragMetadataId)
            .build();
    return createRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagMetadataRequest request =
   *       CreateRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setRagMetadata(RagMetadata.newBuilder().build())
   *           .setRagMetadataId("ragMetadataId-818296094")
   *           .build();
   *   RagMetadata response = vertexRagDataServiceClient.createRagMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata createRagMetadata(CreateRagMetadataRequest request) {
    return createRagMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagMetadataRequest request =
   *       CreateRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setRagMetadata(RagMetadata.newBuilder().build())
   *           .setRagMetadataId("ragMetadataId-818296094")
   *           .build();
   *   ApiFuture<RagMetadata> future =
   *       vertexRagDataServiceClient.createRagMetadataCallable().futureCall(request);
   *   // Do something.
   *   RagMetadata response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRagMetadataRequest, RagMetadata> createRagMetadataCallable() {
    return stub.createRagMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Create one or more RagMetadatas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchCreateRagMetadataRequest request =
   *       BatchCreateRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateRagMetadataRequest>())
   *           .build();
   *   BatchCreateRagMetadataResponse response =
   *       vertexRagDataServiceClient.batchCreateRagMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchCreateRagMetadataResponse, BatchCreateRagMetadataOperationMetadata>
      batchCreateRagMetadataAsync(BatchCreateRagMetadataRequest request) {
    return batchCreateRagMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Create one or more RagMetadatas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchCreateRagMetadataRequest request =
   *       BatchCreateRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateRagMetadataRequest>())
   *           .build();
   *   OperationFuture<BatchCreateRagMetadataResponse, BatchCreateRagMetadataOperationMetadata>
   *       future =
   *           vertexRagDataServiceClient
   *               .batchCreateRagMetadataOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   BatchCreateRagMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchCreateRagMetadataRequest,
          BatchCreateRagMetadataResponse,
          BatchCreateRagMetadataOperationMetadata>
      batchCreateRagMetadataOperationCallable() {
    return stub.batchCreateRagMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Create one or more RagMetadatas
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchCreateRagMetadataRequest request =
   *       BatchCreateRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateRagMetadataRequest>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.batchCreateRagMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateRagMetadataRequest, Operation>
      batchCreateRagMetadataCallable() {
    return stub.batchCreateRagMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagMetadata ragMetadata = RagMetadata.newBuilder().build();
   *   RagMetadata response = vertexRagDataServiceClient.updateRagMetadata(ragMetadata);
   * }
   * }</pre>
   *
   * @param ragMetadata Required. The RagMetadata which replaces the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata updateRagMetadata(RagMetadata ragMetadata) {
    UpdateRagMetadataRequest request =
        UpdateRagMetadataRequest.newBuilder().setRagMetadata(ragMetadata).build();
    return updateRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagMetadataRequest request =
   *       UpdateRagMetadataRequest.newBuilder()
   *           .setRagMetadata(RagMetadata.newBuilder().build())
   *           .build();
   *   RagMetadata response = vertexRagDataServiceClient.updateRagMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata updateRagMetadata(UpdateRagMetadataRequest request) {
    return updateRagMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UpdateRagMetadataRequest request =
   *       UpdateRagMetadataRequest.newBuilder()
   *           .setRagMetadata(RagMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<RagMetadata> future =
   *       vertexRagDataServiceClient.updateRagMetadataCallable().futureCall(request);
   *   // Do something.
   *   RagMetadata response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRagMetadataRequest, RagMetadata> updateRagMetadataCallable() {
    return stub.updateRagMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagMetadataName name =
   *       RagMetadataName.of(
   *           "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]");
   *   RagMetadata response = vertexRagDataServiceClient.getRagMetadata(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagMetadata resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}/ragMetadata/{rag_metadata}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata getRagMetadata(RagMetadataName name) {
    GetRagMetadataRequest request =
        GetRagMetadataRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagMetadataName.of(
   *               "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]")
   *           .toString();
   *   RagMetadata response = vertexRagDataServiceClient.getRagMetadata(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagMetadata resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}/ragMetadata/{rag_metadata}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata getRagMetadata(String name) {
    GetRagMetadataRequest request = GetRagMetadataRequest.newBuilder().setName(name).build();
    return getRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagMetadataRequest request =
   *       GetRagMetadataRequest.newBuilder()
   *           .setName(
   *               RagMetadataName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]")
   *                   .toString())
   *           .build();
   *   RagMetadata response = vertexRagDataServiceClient.getRagMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagMetadata getRagMetadata(GetRagMetadataRequest request) {
    return getRagMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagMetadataRequest request =
   *       GetRagMetadataRequest.newBuilder()
   *           .setName(
   *               RagMetadataName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RagMetadata> future =
   *       vertexRagDataServiceClient.getRagMetadataCallable().futureCall(request);
   *   // Do something.
   *   RagMetadata response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagMetadataRequest, RagMetadata> getRagMetadataCallable() {
    return stub.getRagMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagMetadata in a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagFileName parent = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
   *   for (RagMetadata element : vertexRagDataServiceClient.listRagMetadata(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagFile from which to list the RagMetadata.
   *     Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagMetadataPagedResponse listRagMetadata(RagFileName parent) {
    ListRagMetadataRequest request =
        ListRagMetadataRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagMetadata in a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent =
   *       RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString();
   *   for (RagMetadata element : vertexRagDataServiceClient.listRagMetadata(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagFile from which to list the RagMetadata.
   *     Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagMetadataPagedResponse listRagMetadata(String parent) {
    ListRagMetadataRequest request = ListRagMetadataRequest.newBuilder().setParent(parent).build();
    return listRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagMetadata in a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagMetadataRequest request =
   *       ListRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RagMetadata element : vertexRagDataServiceClient.listRagMetadata(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagMetadataPagedResponse listRagMetadata(ListRagMetadataRequest request) {
    return listRagMetadataPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagMetadata in a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagMetadataRequest request =
   *       ListRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RagMetadata> future =
   *       vertexRagDataServiceClient.listRagMetadataPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RagMetadata element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRagMetadataRequest, ListRagMetadataPagedResponse>
      listRagMetadataPagedCallable() {
    return stub.listRagMetadataPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagMetadata in a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagMetadataRequest request =
   *       ListRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRagMetadataResponse response =
   *         vertexRagDataServiceClient.listRagMetadataCallable().call(request);
   *     for (RagMetadata element : response.getRagMetadataList()) {
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
  public final UnaryCallable<ListRagMetadataRequest, ListRagMetadataResponse>
      listRagMetadataCallable() {
    return stub.listRagMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagMetadataName name =
   *       RagMetadataName.of(
   *           "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]");
   *   vertexRagDataServiceClient.deleteRagMetadata(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagMetadata resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}/ragMetadata/{rag_metadata}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRagMetadata(RagMetadataName name) {
    DeleteRagMetadataRequest request =
        DeleteRagMetadataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagMetadataName.of(
   *               "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]")
   *           .toString();
   *   vertexRagDataServiceClient.deleteRagMetadata(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagMetadata resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}/ragMetadata/{rag_metadata}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRagMetadata(String name) {
    DeleteRagMetadataRequest request = DeleteRagMetadataRequest.newBuilder().setName(name).build();
    deleteRagMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagMetadataRequest request =
   *       DeleteRagMetadataRequest.newBuilder()
   *           .setName(
   *               RagMetadataName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]")
   *                   .toString())
   *           .build();
   *   vertexRagDataServiceClient.deleteRagMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRagMetadata(DeleteRagMetadataRequest request) {
    deleteRagMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagMetadataRequest request =
   *       DeleteRagMetadataRequest.newBuilder()
   *           .setName(
   *               RagMetadataName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]", "[RAG_METADATA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       vertexRagDataServiceClient.deleteRagMetadataCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRagMetadataRequest, Empty> deleteRagMetadataCallable() {
    return stub.deleteRagMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Deletes one or more RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchDeleteRagMetadataRequest request =
   *       BatchDeleteRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   vertexRagDataServiceClient.batchDeleteRagMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> batchDeleteRagMetadataAsync(
      BatchDeleteRagMetadataRequest request) {
    return batchDeleteRagMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Deletes one or more RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchDeleteRagMetadataRequest request =
   *       BatchDeleteRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       vertexRagDataServiceClient.batchDeleteRagMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchDeleteRagMetadataRequest, Empty, DeleteOperationMetadata>
      batchDeleteRagMetadataOperationCallable() {
    return stub.batchDeleteRagMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch Deletes one or more RagMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   BatchDeleteRagMetadataRequest request =
   *       BatchDeleteRagMetadataRequest.newBuilder()
   *           .setParent(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.batchDeleteRagMetadataCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteRagMetadataRequest, Operation>
      batchDeleteRagMetadataCallable() {
    return stub.batchDeleteRagMetadataCallable();
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vertexRagDataServiceClient.listLocations(request).iterateAll()) {
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vertexRagDataServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         vertexRagDataServiceClient.listLocationsCallable().call(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vertexRagDataServiceClient.getLocation(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       vertexRagDataServiceClient.getLocationCallable().futureCall(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = vertexRagDataServiceClient.setIamPolicy(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       vertexRagDataServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = vertexRagDataServiceClient.getIamPolicy(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       vertexRagDataServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = vertexRagDataServiceClient.testIamPermissions(request);
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
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       vertexRagDataServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListRagCorporaPagedResponse
      extends AbstractPagedListResponse<
          ListRagCorporaRequest,
          ListRagCorporaResponse,
          RagCorpus,
          ListRagCorporaPage,
          ListRagCorporaFixedSizeCollection> {

    public static ApiFuture<ListRagCorporaPagedResponse> createAsync(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ApiFuture<ListRagCorporaResponse> futureResponse) {
      ApiFuture<ListRagCorporaPage> futurePage =
          ListRagCorporaPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRagCorporaPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRagCorporaPagedResponse(ListRagCorporaPage page) {
      super(page, ListRagCorporaFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRagCorporaPage
      extends AbstractPage<
          ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus, ListRagCorporaPage> {

    private ListRagCorporaPage(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ListRagCorporaResponse response) {
      super(context, response);
    }

    private static ListRagCorporaPage createEmptyPage() {
      return new ListRagCorporaPage(null, null);
    }

    @Override
    protected ListRagCorporaPage createPage(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ListRagCorporaResponse response) {
      return new ListRagCorporaPage(context, response);
    }

    @Override
    public ApiFuture<ListRagCorporaPage> createPageAsync(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ApiFuture<ListRagCorporaResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRagCorporaFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRagCorporaRequest,
          ListRagCorporaResponse,
          RagCorpus,
          ListRagCorporaPage,
          ListRagCorporaFixedSizeCollection> {

    private ListRagCorporaFixedSizeCollection(List<ListRagCorporaPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRagCorporaFixedSizeCollection createEmptyCollection() {
      return new ListRagCorporaFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRagCorporaFixedSizeCollection createCollection(
        List<ListRagCorporaPage> pages, int collectionSize) {
      return new ListRagCorporaFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRagFilesPagedResponse
      extends AbstractPagedListResponse<
          ListRagFilesRequest,
          ListRagFilesResponse,
          RagFile,
          ListRagFilesPage,
          ListRagFilesFixedSizeCollection> {

    public static ApiFuture<ListRagFilesPagedResponse> createAsync(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ApiFuture<ListRagFilesResponse> futureResponse) {
      ApiFuture<ListRagFilesPage> futurePage =
          ListRagFilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRagFilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRagFilesPagedResponse(ListRagFilesPage page) {
      super(page, ListRagFilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRagFilesPage
      extends AbstractPage<ListRagFilesRequest, ListRagFilesResponse, RagFile, ListRagFilesPage> {

    private ListRagFilesPage(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ListRagFilesResponse response) {
      super(context, response);
    }

    private static ListRagFilesPage createEmptyPage() {
      return new ListRagFilesPage(null, null);
    }

    @Override
    protected ListRagFilesPage createPage(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ListRagFilesResponse response) {
      return new ListRagFilesPage(context, response);
    }

    @Override
    public ApiFuture<ListRagFilesPage> createPageAsync(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ApiFuture<ListRagFilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRagFilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRagFilesRequest,
          ListRagFilesResponse,
          RagFile,
          ListRagFilesPage,
          ListRagFilesFixedSizeCollection> {

    private ListRagFilesFixedSizeCollection(List<ListRagFilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRagFilesFixedSizeCollection createEmptyCollection() {
      return new ListRagFilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRagFilesFixedSizeCollection createCollection(
        List<ListRagFilesPage> pages, int collectionSize) {
      return new ListRagFilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRagDataSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListRagDataSchemasRequest,
          ListRagDataSchemasResponse,
          RagDataSchema,
          ListRagDataSchemasPage,
          ListRagDataSchemasFixedSizeCollection> {

    public static ApiFuture<ListRagDataSchemasPagedResponse> createAsync(
        PageContext<ListRagDataSchemasRequest, ListRagDataSchemasResponse, RagDataSchema> context,
        ApiFuture<ListRagDataSchemasResponse> futureResponse) {
      ApiFuture<ListRagDataSchemasPage> futurePage =
          ListRagDataSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRagDataSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRagDataSchemasPagedResponse(ListRagDataSchemasPage page) {
      super(page, ListRagDataSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRagDataSchemasPage
      extends AbstractPage<
          ListRagDataSchemasRequest,
          ListRagDataSchemasResponse,
          RagDataSchema,
          ListRagDataSchemasPage> {

    private ListRagDataSchemasPage(
        PageContext<ListRagDataSchemasRequest, ListRagDataSchemasResponse, RagDataSchema> context,
        ListRagDataSchemasResponse response) {
      super(context, response);
    }

    private static ListRagDataSchemasPage createEmptyPage() {
      return new ListRagDataSchemasPage(null, null);
    }

    @Override
    protected ListRagDataSchemasPage createPage(
        PageContext<ListRagDataSchemasRequest, ListRagDataSchemasResponse, RagDataSchema> context,
        ListRagDataSchemasResponse response) {
      return new ListRagDataSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListRagDataSchemasPage> createPageAsync(
        PageContext<ListRagDataSchemasRequest, ListRagDataSchemasResponse, RagDataSchema> context,
        ApiFuture<ListRagDataSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRagDataSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRagDataSchemasRequest,
          ListRagDataSchemasResponse,
          RagDataSchema,
          ListRagDataSchemasPage,
          ListRagDataSchemasFixedSizeCollection> {

    private ListRagDataSchemasFixedSizeCollection(
        List<ListRagDataSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRagDataSchemasFixedSizeCollection createEmptyCollection() {
      return new ListRagDataSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRagDataSchemasFixedSizeCollection createCollection(
        List<ListRagDataSchemasPage> pages, int collectionSize) {
      return new ListRagDataSchemasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRagMetadataPagedResponse
      extends AbstractPagedListResponse<
          ListRagMetadataRequest,
          ListRagMetadataResponse,
          RagMetadata,
          ListRagMetadataPage,
          ListRagMetadataFixedSizeCollection> {

    public static ApiFuture<ListRagMetadataPagedResponse> createAsync(
        PageContext<ListRagMetadataRequest, ListRagMetadataResponse, RagMetadata> context,
        ApiFuture<ListRagMetadataResponse> futureResponse) {
      ApiFuture<ListRagMetadataPage> futurePage =
          ListRagMetadataPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRagMetadataPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRagMetadataPagedResponse(ListRagMetadataPage page) {
      super(page, ListRagMetadataFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRagMetadataPage
      extends AbstractPage<
          ListRagMetadataRequest, ListRagMetadataResponse, RagMetadata, ListRagMetadataPage> {

    private ListRagMetadataPage(
        PageContext<ListRagMetadataRequest, ListRagMetadataResponse, RagMetadata> context,
        ListRagMetadataResponse response) {
      super(context, response);
    }

    private static ListRagMetadataPage createEmptyPage() {
      return new ListRagMetadataPage(null, null);
    }

    @Override
    protected ListRagMetadataPage createPage(
        PageContext<ListRagMetadataRequest, ListRagMetadataResponse, RagMetadata> context,
        ListRagMetadataResponse response) {
      return new ListRagMetadataPage(context, response);
    }

    @Override
    public ApiFuture<ListRagMetadataPage> createPageAsync(
        PageContext<ListRagMetadataRequest, ListRagMetadataResponse, RagMetadata> context,
        ApiFuture<ListRagMetadataResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRagMetadataFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRagMetadataRequest,
          ListRagMetadataResponse,
          RagMetadata,
          ListRagMetadataPage,
          ListRagMetadataFixedSizeCollection> {

    private ListRagMetadataFixedSizeCollection(
        List<ListRagMetadataPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRagMetadataFixedSizeCollection createEmptyCollection() {
      return new ListRagMetadataFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRagMetadataFixedSizeCollection createCollection(
        List<ListRagMetadataPage> pages, int collectionSize) {
      return new ListRagMetadataFixedSizeCollection(pages, collectionSize);
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
