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

package com.google.cloud.visionai.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.stub.WarehouseStub;
import com.google.cloud.visionai.v1.stub.WarehouseStubSettings;
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
 * Service Description: Service that manages media content + metadata for streaming.
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
 * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
 *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
 *   Asset asset = Asset.newBuilder().build();
 *   String assetId = "assetId-704776149";
 *   Asset response = warehouseClient.createAsset(parent, asset, assetId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WarehouseClient object to clean up resources such as
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
 *      <td><p> CreateAsset</td>
 *      <td><p> Creates an asset inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAsset(CreateAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAsset(CorpusName parent, Asset asset, String assetId)
 *           <li><p> createAsset(String parent, Asset asset, String assetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAsset</td>
 *      <td><p> Updates an asset inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsset(UpdateAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAsset(Asset asset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAsset</td>
 *      <td><p> Reads an asset inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAsset(GetAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAsset(AssetName name)
 *           <li><p> getAsset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAssets</td>
 *      <td><p> Lists an list of assets inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssets(ListAssetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAssets(CorpusName parent)
 *           <li><p> listAssets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssetsPagedCallable()
 *           <li><p> listAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAsset</td>
 *      <td><p> Deletes asset inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAssetAsync(DeleteAssetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAssetAsync(AssetName name)
 *           <li><p> deleteAssetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAssetOperationCallable()
 *           <li><p> deleteAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UploadAsset</td>
 *      <td><p> Upload asset by specifing the asset Cloud Storage uri. For video warehouse, it requires users who call this API have read access to the cloud storage file. Once it is uploaded, it can be retrieved by GenerateRetrievalUrl API which by default, only can retrieve cloud storage files from the same project of the warehouse. To allow retrieval cloud storage files that are in a separate project, it requires to find the vision ai service account (Go to IAM, check checkbox to show "Include Google-provided role grants", search for "Cloud Vision AI Service Agent") and grant the read access of the cloud storage files to that service account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadAssetAsync(UploadAssetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadAssetOperationCallable()
 *           <li><p> uploadAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateRetrievalUrl</td>
 *      <td><p> Generates a signed url for downloading the asset. For video warehouse, please see comment of UploadAsset about how to allow retrieval of cloud storage files in a different project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateRetrievalUrl(GenerateRetrievalUrlRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateRetrievalUrlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AnalyzeAsset</td>
 *      <td><p> Analyze asset to power search capability.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> analyzeAssetAsync(AnalyzeAssetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> analyzeAssetOperationCallable()
 *           <li><p> analyzeAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IndexAsset</td>
 *      <td><p> Index one asset for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> indexAssetAsync(IndexAssetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> indexAssetOperationCallable()
 *           <li><p> indexAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveIndexAsset</td>
 *      <td><p> Remove one asset's index data for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeIndexAssetAsync(RemoveIndexAssetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeIndexAssetOperationCallable()
 *           <li><p> removeIndexAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ViewIndexedAssets</td>
 *      <td><p> Lists assets inside an index.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> viewIndexedAssets(ViewIndexedAssetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> viewIndexedAssets(IndexName index)
 *           <li><p> viewIndexedAssets(String index)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> viewIndexedAssetsPagedCallable()
 *           <li><p> viewIndexedAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIndex</td>
 *      <td><p> Creates an Index under the corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIndexAsync(CreateIndexRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIndexAsync(CorpusName parent, Index index, String indexId)
 *           <li><p> createIndexAsync(String parent, Index index, String indexId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIndexOperationCallable()
 *           <li><p> createIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIndex</td>
 *      <td><p> Updates an Index under the corpus. Users can perform a metadata-only update or trigger a full index rebuild with different update_mask values.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIndexAsync(UpdateIndexRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateIndexAsync(Index index, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIndexOperationCallable()
 *           <li><p> updateIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIndex</td>
 *      <td><p> Gets the details of a single Index under a Corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIndex(GetIndexRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIndex(IndexName name)
 *           <li><p> getIndex(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIndexes</td>
 *      <td><p> List all Indexes in a given Corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIndexes(ListIndexesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIndexes(CorpusName parent)
 *           <li><p> listIndexes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIndexesPagedCallable()
 *           <li><p> listIndexesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIndex</td>
 *      <td><p> Delete a single Index. In order to delete an index, the caller must make sure that it is not deployed to any index endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIndexAsync(DeleteIndexRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIndexAsync(IndexName name)
 *           <li><p> deleteIndexAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIndexOperationCallable()
 *           <li><p> deleteIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCorpus</td>
 *      <td><p> Creates a corpus inside a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCorpusAsync(CreateCorpusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCorpusAsync(String parent, Corpus corpus)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCorpusOperationCallable()
 *           <li><p> createCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCorpus</td>
 *      <td><p> Gets corpus details inside a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCorpus(GetCorpusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCorpus(CorpusName name)
 *           <li><p> getCorpus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCorpus</td>
 *      <td><p> Updates a corpus in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCorpus(UpdateCorpusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCorpus(Corpus corpus, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCorpora</td>
 *      <td><p> Lists all corpora in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCorpora(ListCorporaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCorpora(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCorporaPagedCallable()
 *           <li><p> listCorporaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCorpus</td>
 *      <td><p> Deletes a corpus only if its empty. Returns empty response.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCorpus(DeleteCorpusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCorpus(CorpusName name)
 *           <li><p> deleteCorpus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AnalyzeCorpus</td>
 *      <td><p> Analyzes a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> analyzeCorpusAsync(AnalyzeCorpusRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> analyzeCorpusOperationCallable()
 *           <li><p> analyzeCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataSchema</td>
 *      <td><p> Creates data schema inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataSchema(CreateDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataSchema(CorpusName parent, DataSchema dataSchema)
 *           <li><p> createDataSchema(String parent, DataSchema dataSchema)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataSchema</td>
 *      <td><p> Updates data schema inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataSchema(UpdateDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataSchema(DataSchema dataSchema, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataSchema</td>
 *      <td><p> Gets data schema inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataSchema(GetDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataSchema(DataSchemaName name)
 *           <li><p> getDataSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataSchema</td>
 *      <td><p> Deletes data schema inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataSchema(DeleteDataSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataSchema(DataSchemaName name)
 *           <li><p> deleteDataSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataSchemas</td>
 *      <td><p> Lists a list of data schemas inside corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataSchemas(ListDataSchemasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataSchemas(CorpusName parent)
 *           <li><p> listDataSchemas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataSchemasPagedCallable()
 *           <li><p> listDataSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnnotation</td>
 *      <td><p> Creates annotation inside asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnnotation(CreateAnnotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAnnotation(AssetName parent, Annotation annotation, String annotationId)
 *           <li><p> createAnnotation(String parent, Annotation annotation, String annotationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnnotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnnotation</td>
 *      <td><p> Reads annotation inside asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnnotation(GetAnnotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnnotation(AnnotationName name)
 *           <li><p> getAnnotation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnnotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnnotations</td>
 *      <td><p> Lists a list of annotations inside asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnnotations(ListAnnotationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnnotations(AssetName parent)
 *           <li><p> listAnnotations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnnotationsPagedCallable()
 *           <li><p> listAnnotationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAnnotation</td>
 *      <td><p> Updates annotation inside asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAnnotation(UpdateAnnotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAnnotation(Annotation annotation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAnnotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAnnotation</td>
 *      <td><p> Deletes annotation inside asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAnnotation(DeleteAnnotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAnnotation(AnnotationName name)
 *           <li><p> deleteAnnotation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAnnotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IngestAsset</td>
 *      <td><p> Ingests data for the asset. It is not allowed to ingest a data chunk which is already expired according to TTL. This method is only available via the gRPC API (not HTTP since bi-directional streaming is not supported via HTTP).</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ingestAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ClipAsset</td>
 *      <td><p> Generates clips for downloading. The api takes in a time range, and generates a clip of the first content available after start_time and before end_time, which may overflow beyond these bounds. Returned clips are truncated if the total size of the clips are larger than 100MB.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> clipAsset(ClipAssetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> clipAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateHlsUri</td>
 *      <td><p> Generates a uri for an HLS manifest. The api takes in a collection of time ranges, and generates a URI for an HLS manifest that covers all the requested time ranges.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateHlsUri(GenerateHlsUriRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateHlsUriCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportAssets</td>
 *      <td><p> Imports assets (images plus annotations) from a meta file on cloud storage. Each row in the meta file is corresponding to an image (specified by a cloud storage uri) and its annotations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importAssetsAsync(ImportAssetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importAssetsOperationCallable()
 *           <li><p> importAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSearchConfig</td>
 *      <td><p> Creates a search configuration inside a corpus.
 * <p>  Please follow the rules below to create a valid CreateSearchConfigRequest. --- General Rules --- 1. Request.search_config_id must not be associated with an existing    SearchConfig. 2. Request must contain at least one non-empty search_criteria_property or    facet_property. 3. mapped_fields must not be empty, and must map to existing UGA keys. 4. All mapped_fields must be of the same type. 5. All mapped_fields must share the same granularity. 6. All mapped_fields must share the same semantic SearchConfig match    options. For property-specific rules, please reference the comments for FacetProperty and SearchCriteriaProperty.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSearchConfig(CreateSearchConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSearchConfig(CorpusName parent, SearchConfig searchConfig, String searchConfigId)
 *           <li><p> createSearchConfig(String parent, SearchConfig searchConfig, String searchConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSearchConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSearchConfig</td>
 *      <td><p> Updates a search configuration inside a corpus.
 * <p>  Please follow the rules below to create a valid UpdateSearchConfigRequest. --- General Rules --- 1. Request.search_configuration.name must already exist. 2. Request must contain at least one non-empty search_criteria_property or facet_property. 3. mapped_fields must not be empty, and must map to existing UGA keys. 4. All mapped_fields must be of the same type. 5. All mapped_fields must share the same granularity. 6. All mapped_fields must share the same semantic SearchConfig match    options. For property-specific rules, please reference the comments for FacetProperty and SearchCriteriaProperty.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSearchConfig(UpdateSearchConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSearchConfig(SearchConfig searchConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSearchConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSearchConfig</td>
 *      <td><p> Gets a search configuration inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSearchConfig(GetSearchConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSearchConfig(SearchConfigName name)
 *           <li><p> getSearchConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSearchConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSearchConfig</td>
 *      <td><p> Deletes a search configuration inside a corpus.
 * <p>  For a DeleteSearchConfigRequest to be valid, Request.search_configuration.name must already exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSearchConfig(DeleteSearchConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSearchConfig(SearchConfigName name)
 *           <li><p> deleteSearchConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSearchConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSearchConfigs</td>
 *      <td><p> Lists all search configurations inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSearchConfigs(ListSearchConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSearchConfigs(CorpusName parent)
 *           <li><p> listSearchConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSearchConfigsPagedCallable()
 *           <li><p> listSearchConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSearchHypernym</td>
 *      <td><p> Creates a SearchHypernym inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSearchHypernym(CreateSearchHypernymRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSearchHypernym(CorpusName parent, SearchHypernym searchHypernym, String searchHypernymId)
 *           <li><p> createSearchHypernym(String parent, SearchHypernym searchHypernym, String searchHypernymId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSearchHypernymCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSearchHypernym</td>
 *      <td><p> Updates a SearchHypernym inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSearchHypernym(UpdateSearchHypernymRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSearchHypernym(SearchHypernym searchHypernym, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSearchHypernymCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSearchHypernym</td>
 *      <td><p> Gets a SearchHypernym inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSearchHypernym(GetSearchHypernymRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSearchHypernym(SearchHypernymName name)
 *           <li><p> getSearchHypernym(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSearchHypernymCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSearchHypernym</td>
 *      <td><p> Deletes a SearchHypernym inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSearchHypernym(DeleteSearchHypernymRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSearchHypernym(SearchHypernymName name)
 *           <li><p> deleteSearchHypernym(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSearchHypernymCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSearchHypernyms</td>
 *      <td><p> Lists SearchHypernyms inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSearchHypernyms(ListSearchHypernymsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSearchHypernyms(CorpusName parent)
 *           <li><p> listSearchHypernyms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSearchHypernymsPagedCallable()
 *           <li><p> listSearchHypernymsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchAssets</td>
 *      <td><p> Search media asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAssets(SearchAssetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchAssetsPagedCallable()
 *           <li><p> searchAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchIndexEndpoint</td>
 *      <td><p> Search a deployed index endpoint (IMAGE corpus type only).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchIndexEndpoint(SearchIndexEndpointRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchIndexEndpointPagedCallable()
 *           <li><p> searchIndexEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIndexEndpoint</td>
 *      <td><p> Creates an IndexEndpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIndexEndpointAsync(CreateIndexEndpointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIndexEndpointAsync(LocationName parent, IndexEndpoint indexEndpoint, String indexEndpointId)
 *           <li><p> createIndexEndpointAsync(String parent, IndexEndpoint indexEndpoint, String indexEndpointId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIndexEndpointOperationCallable()
 *           <li><p> createIndexEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIndexEndpoint</td>
 *      <td><p> Gets an IndexEndpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIndexEndpoint(GetIndexEndpointRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIndexEndpoint(IndexEndpointName name)
 *           <li><p> getIndexEndpoint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIndexEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIndexEndpoints</td>
 *      <td><p> Lists all IndexEndpoints in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIndexEndpoints(ListIndexEndpointsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIndexEndpoints(LocationName parent)
 *           <li><p> listIndexEndpoints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIndexEndpointsPagedCallable()
 *           <li><p> listIndexEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIndexEndpoint</td>
 *      <td><p> Updates an IndexEndpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIndexEndpointAsync(UpdateIndexEndpointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateIndexEndpointAsync(IndexEndpoint indexEndpoint, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIndexEndpointOperationCallable()
 *           <li><p> updateIndexEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIndexEndpoint</td>
 *      <td><p> Deletes an IndexEndpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIndexEndpointAsync(DeleteIndexEndpointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIndexEndpointAsync(IndexEndpointName name)
 *           <li><p> deleteIndexEndpointAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIndexEndpointOperationCallable()
 *           <li><p> deleteIndexEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeployIndex</td>
 *      <td><p> Deploys an Index to IndexEndpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deployIndexAsync(DeployIndexRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deployIndexOperationCallable()
 *           <li><p> deployIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeployIndex</td>
 *      <td><p> Undeploys an Index from IndexEndpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeployIndexAsync(UndeployIndexRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeployIndexOperationCallable()
 *           <li><p> undeployIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCollection</td>
 *      <td><p> Creates a collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCollectionAsync(CreateCollectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCollectionAsync(CorpusName parent, Collection collection, String collectionId)
 *           <li><p> createCollectionAsync(String parent, Collection collection, String collectionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCollectionOperationCallable()
 *           <li><p> createCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCollection</td>
 *      <td><p> Deletes a collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCollectionAsync(DeleteCollectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCollectionAsync(CollectionName name)
 *           <li><p> deleteCollectionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCollectionOperationCallable()
 *           <li><p> deleteCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCollection</td>
 *      <td><p> Gets a collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCollection(GetCollectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCollection(CollectionName name)
 *           <li><p> getCollection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCollection</td>
 *      <td><p> Updates a collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCollection(UpdateCollectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCollection(Collection collection, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCollections</td>
 *      <td><p> Lists collections inside a corpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCollections(ListCollectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCollections(CorpusName parent)
 *           <li><p> listCollections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCollectionsPagedCallable()
 *           <li><p> listCollectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddCollectionItem</td>
 *      <td><p> Adds an item into a Collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addCollectionItem(AddCollectionItemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> addCollectionItem(CollectionItem item)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addCollectionItemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveCollectionItem</td>
 *      <td><p> Removes an item from a collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeCollectionItem(RemoveCollectionItemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> removeCollectionItem(CollectionItem item)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeCollectionItemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ViewCollectionItems</td>
 *      <td><p> View items inside a collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> viewCollectionItems(ViewCollectionItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> viewCollectionItems(CollectionName collection)
 *           <li><p> viewCollectionItems(String collection)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> viewCollectionItemsPagedCallable()
 *           <li><p> viewCollectionItemsCallable()
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
 * <p>This class can be customized by passing in a custom instance of WarehouseSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WarehouseSettings warehouseSettings =
 *     WarehouseSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WarehouseClient warehouseClient = WarehouseClient.create(warehouseSettings);
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
 * WarehouseSettings warehouseSettings =
 *     WarehouseSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WarehouseClient warehouseClient = WarehouseClient.create(warehouseSettings);
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
 * WarehouseSettings warehouseSettings = WarehouseSettings.newHttpJsonBuilder().build();
 * WarehouseClient warehouseClient = WarehouseClient.create(warehouseSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WarehouseClient implements BackgroundResource {
  private final WarehouseSettings settings;
  private final WarehouseStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of WarehouseClient with default settings. */
  public static final WarehouseClient create() throws IOException {
    return create(WarehouseSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WarehouseClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WarehouseClient create(WarehouseSettings settings) throws IOException {
    return new WarehouseClient(settings);
  }

  /**
   * Constructs an instance of WarehouseClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(WarehouseSettings).
   */
  public static final WarehouseClient create(WarehouseStub stub) {
    return new WarehouseClient(stub);
  }

  /**
   * Constructs an instance of WarehouseClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected WarehouseClient(WarehouseSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WarehouseStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected WarehouseClient(WarehouseStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final WarehouseSettings getSettings() {
    return settings;
  }

  public WarehouseStub getStub() {
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
   * Creates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   Asset asset = Asset.newBuilder().build();
   *   String assetId = "assetId-704776149";
   *   Asset response = warehouseClient.createAsset(parent, asset, assetId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this asset will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param asset Required. The asset to create.
   * @param assetId Optional. The ID to use for the asset, which will become the final component of
   *     the asset's resource name if user choose to specify. Otherwise, asset id will be generated
   *     by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset createAsset(CorpusName parent, Asset asset, String assetId) {
    CreateAssetRequest request =
        CreateAssetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAsset(asset)
            .setAssetId(assetId)
            .build();
    return createAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   Asset asset = Asset.newBuilder().build();
   *   String assetId = "assetId-704776149";
   *   Asset response = warehouseClient.createAsset(parent, asset, assetId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this asset will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param asset Required. The asset to create.
   * @param assetId Optional. The ID to use for the asset, which will become the final component of
   *     the asset's resource name if user choose to specify. Otherwise, asset id will be generated
   *     by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset createAsset(String parent, Asset asset, String assetId) {
    CreateAssetRequest request =
        CreateAssetRequest.newBuilder()
            .setParent(parent)
            .setAsset(asset)
            .setAssetId(assetId)
            .build();
    return createAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setAsset(Asset.newBuilder().build())
   *           .setAssetId("assetId-704776149")
   *           .build();
   *   Asset response = warehouseClient.createAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset createAsset(CreateAssetRequest request) {
    return createAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setAsset(Asset.newBuilder().build())
   *           .setAssetId("assetId-704776149")
   *           .build();
   *   ApiFuture<Asset> future = warehouseClient.createAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssetRequest, Asset> createAssetCallable() {
    return stub.createAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   Asset asset = Asset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Asset response = warehouseClient.updateAsset(asset, updateMask);
   * }
   * }</pre>
   *
   * @param asset Required. The asset to update.
   *     <p>The asset's `name` field is used to identify the asset to be updated. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}`
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset updateAsset(Asset asset, FieldMask updateMask) {
    UpdateAssetRequest request =
        UpdateAssetRequest.newBuilder().setAsset(asset).setUpdateMask(updateMask).build();
    return updateAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setAsset(Asset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Asset response = warehouseClient.updateAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset updateAsset(UpdateAssetRequest request) {
    return updateAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateAssetRequest request =
   *       UpdateAssetRequest.newBuilder()
   *           .setAsset(Asset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Asset> future = warehouseClient.updateAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable() {
    return stub.updateAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
   *   Asset response = warehouseClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the asset to retrieve. Format:
   *     projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(AssetName name) {
    GetAssetRequest request =
        GetAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString();
   *   Asset response = warehouseClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the asset to retrieve. Format:
   *     projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(String name) {
    GetAssetRequest request = GetAssetRequest.newBuilder().setName(name).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   Asset response = warehouseClient.getAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(GetAssetRequest request) {
    return getAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads an asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<Asset> future = warehouseClient.getAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return stub.getAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an list of assets inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   for (Asset element : warehouseClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of assets. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(CorpusName parent) {
    ListAssetsRequest request =
        ListAssetsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an list of assets inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   for (Asset element : warehouseClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of assets. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(String parent) {
    ListAssetsRequest request = ListAssetsRequest.newBuilder().setParent(parent).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an list of assets inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Asset element : warehouseClient.listAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return listAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an list of assets inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Asset> future = warehouseClient.listAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Asset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return stub.listAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists an list of assets inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAssetsResponse response = warehouseClient.listAssetsCallable().call(request);
   *     for (Asset element : response.getAssetsList()) {
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
  public final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return stub.listAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
   *   warehouseClient.deleteAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the asset to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteAssetMetadata> deleteAssetAsync(AssetName name) {
    DeleteAssetRequest request =
        DeleteAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString();
   *   warehouseClient.deleteAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the asset to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteAssetMetadata> deleteAssetAsync(String name) {
    DeleteAssetRequest request = DeleteAssetRequest.newBuilder().setName(name).build();
    return deleteAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   warehouseClient.deleteAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteAssetMetadata> deleteAssetAsync(
      DeleteAssetRequest request) {
    return deleteAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteAssetMetadata> future =
   *       warehouseClient.deleteAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAssetRequest, Empty, DeleteAssetMetadata>
      deleteAssetOperationCallable() {
    return stub.deleteAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes asset inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.deleteAssetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    return stub.deleteAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload asset by specifing the asset Cloud Storage uri. For video warehouse, it requires users
   * who call this API have read access to the cloud storage file. Once it is uploaded, it can be
   * retrieved by GenerateRetrievalUrl API which by default, only can retrieve cloud storage files
   * from the same project of the warehouse. To allow retrieval cloud storage files that are in a
   * separate project, it requires to find the vision ai service account (Go to IAM, check checkbox
   * to show "Include Google-provided role grants", search for "Cloud Vision AI Service Agent") and
   * grant the read access of the cloud storage files to that service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UploadAssetRequest request =
   *       UploadAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setAssetSource(AssetSource.newBuilder().build())
   *           .build();
   *   UploadAssetResponse response = warehouseClient.uploadAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UploadAssetResponse, UploadAssetMetadata> uploadAssetAsync(
      UploadAssetRequest request) {
    return uploadAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload asset by specifing the asset Cloud Storage uri. For video warehouse, it requires users
   * who call this API have read access to the cloud storage file. Once it is uploaded, it can be
   * retrieved by GenerateRetrievalUrl API which by default, only can retrieve cloud storage files
   * from the same project of the warehouse. To allow retrieval cloud storage files that are in a
   * separate project, it requires to find the vision ai service account (Go to IAM, check checkbox
   * to show "Include Google-provided role grants", search for "Cloud Vision AI Service Agent") and
   * grant the read access of the cloud storage files to that service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UploadAssetRequest request =
   *       UploadAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setAssetSource(AssetSource.newBuilder().build())
   *           .build();
   *   OperationFuture<UploadAssetResponse, UploadAssetMetadata> future =
   *       warehouseClient.uploadAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   UploadAssetResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UploadAssetRequest, UploadAssetResponse, UploadAssetMetadata>
      uploadAssetOperationCallable() {
    return stub.uploadAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload asset by specifing the asset Cloud Storage uri. For video warehouse, it requires users
   * who call this API have read access to the cloud storage file. Once it is uploaded, it can be
   * retrieved by GenerateRetrievalUrl API which by default, only can retrieve cloud storage files
   * from the same project of the warehouse. To allow retrieval cloud storage files that are in a
   * separate project, it requires to find the vision ai service account (Go to IAM, check checkbox
   * to show "Include Google-provided role grants", search for "Cloud Vision AI Service Agent") and
   * grant the read access of the cloud storage files to that service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UploadAssetRequest request =
   *       UploadAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setAssetSource(AssetSource.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.uploadAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadAssetRequest, Operation> uploadAssetCallable() {
    return stub.uploadAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a signed url for downloading the asset. For video warehouse, please see comment of
   * UploadAsset about how to allow retrieval of cloud storage files in a different project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GenerateRetrievalUrlRequest request =
   *       GenerateRetrievalUrlRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   GenerateRetrievalUrlResponse response = warehouseClient.generateRetrievalUrl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateRetrievalUrlResponse generateRetrievalUrl(
      GenerateRetrievalUrlRequest request) {
    return generateRetrievalUrlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a signed url for downloading the asset. For video warehouse, please see comment of
   * UploadAsset about how to allow retrieval of cloud storage files in a different project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GenerateRetrievalUrlRequest request =
   *       GenerateRetrievalUrlRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<GenerateRetrievalUrlResponse> future =
   *       warehouseClient.generateRetrievalUrlCallable().futureCall(request);
   *   // Do something.
   *   GenerateRetrievalUrlResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateRetrievalUrlRequest, GenerateRetrievalUrlResponse>
      generateRetrievalUrlCallable() {
    return stub.generateRetrievalUrlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyze asset to power search capability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnalyzeAssetRequest request =
   *       AnalyzeAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   AnalyzeAssetResponse response = warehouseClient.analyzeAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnalyzeAssetResponse, AnalyzeAssetMetadata> analyzeAssetAsync(
      AnalyzeAssetRequest request) {
    return analyzeAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyze asset to power search capability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnalyzeAssetRequest request =
   *       AnalyzeAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   OperationFuture<AnalyzeAssetResponse, AnalyzeAssetMetadata> future =
   *       warehouseClient.analyzeAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   AnalyzeAssetResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AnalyzeAssetRequest, AnalyzeAssetResponse, AnalyzeAssetMetadata>
      analyzeAssetOperationCallable() {
    return stub.analyzeAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyze asset to power search capability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnalyzeAssetRequest request =
   *       AnalyzeAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.analyzeAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnalyzeAssetRequest, Operation> analyzeAssetCallable() {
    return stub.analyzeAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Index one asset for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexAssetRequest request =
   *       IndexAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   IndexAssetResponse response = warehouseClient.indexAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexAssetResponse, IndexAssetMetadata> indexAssetAsync(
      IndexAssetRequest request) {
    return indexAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Index one asset for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexAssetRequest request =
   *       IndexAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   OperationFuture<IndexAssetResponse, IndexAssetMetadata> future =
   *       warehouseClient.indexAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   IndexAssetResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<IndexAssetRequest, IndexAssetResponse, IndexAssetMetadata>
      indexAssetOperationCallable() {
    return stub.indexAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Index one asset for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexAssetRequest request =
   *       IndexAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.indexAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IndexAssetRequest, Operation> indexAssetCallable() {
    return stub.indexAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove one asset's index data for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   RemoveIndexAssetRequest request =
   *       RemoveIndexAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   RemoveIndexAssetResponse response = warehouseClient.removeIndexAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetAsync(RemoveIndexAssetRequest request) {
    return removeIndexAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove one asset's index data for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   RemoveIndexAssetRequest request =
   *       RemoveIndexAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   OperationFuture<RemoveIndexAssetResponse, RemoveIndexAssetMetadata> future =
   *       warehouseClient.removeIndexAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   RemoveIndexAssetResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveIndexAssetRequest, RemoveIndexAssetResponse, RemoveIndexAssetMetadata>
      removeIndexAssetOperationCallable() {
    return stub.removeIndexAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove one asset's index data for search. Supported corpus type: Corpus.Type.VIDEO_ON_DEMAND
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   RemoveIndexAssetRequest request =
   *       RemoveIndexAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.removeIndexAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveIndexAssetRequest, Operation> removeIndexAssetCallable() {
    return stub.removeIndexAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets inside an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexName index = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
   *   for (IndexedAsset element : warehouseClient.viewIndexedAssets(index).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param index Required. The index that owns this collection of assets. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewIndexedAssetsPagedResponse viewIndexedAssets(IndexName index) {
    ViewIndexedAssetsRequest request =
        ViewIndexedAssetsRequest.newBuilder()
            .setIndex(index == null ? null : index.toString())
            .build();
    return viewIndexedAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets inside an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String index =
   *       IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString();
   *   for (IndexedAsset element : warehouseClient.viewIndexedAssets(index).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param index Required. The index that owns this collection of assets. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewIndexedAssetsPagedResponse viewIndexedAssets(String index) {
    ViewIndexedAssetsRequest request =
        ViewIndexedAssetsRequest.newBuilder().setIndex(index).build();
    return viewIndexedAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets inside an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ViewIndexedAssetsRequest request =
   *       ViewIndexedAssetsRequest.newBuilder()
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (IndexedAsset element : warehouseClient.viewIndexedAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewIndexedAssetsPagedResponse viewIndexedAssets(ViewIndexedAssetsRequest request) {
    return viewIndexedAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets inside an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ViewIndexedAssetsRequest request =
   *       ViewIndexedAssetsRequest.newBuilder()
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<IndexedAsset> future =
   *       warehouseClient.viewIndexedAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IndexedAsset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsPagedResponse>
      viewIndexedAssetsPagedCallable() {
    return stub.viewIndexedAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets inside an index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ViewIndexedAssetsRequest request =
   *       ViewIndexedAssetsRequest.newBuilder()
   *           .setIndex(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ViewIndexedAssetsResponse response =
   *         warehouseClient.viewIndexedAssetsCallable().call(request);
   *     for (IndexedAsset element : response.getIndexedAssetsList()) {
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
  public final UnaryCallable<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse>
      viewIndexedAssetsCallable() {
    return stub.viewIndexedAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index under the corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   Index index = Index.newBuilder().build();
   *   String indexId = "indexId1943291277";
   *   Index response = warehouseClient.createIndexAsync(parent, index, indexId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for the parent. The resource name of the Corpus under which this
   *     index is created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param index Required. The index being created.
   * @param indexId Optional. The ID for the index. This will become the final resource name for the
   *     index. If the user does not specify this value, it will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, CreateIndexMetadata> createIndexAsync(
      CorpusName parent, Index index, String indexId) {
    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIndex(index)
            .setIndexId(indexId)
            .build();
    return createIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index under the corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   Index index = Index.newBuilder().build();
   *   String indexId = "indexId1943291277";
   *   Index response = warehouseClient.createIndexAsync(parent, index, indexId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for the parent. The resource name of the Corpus under which this
   *     index is created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param index Required. The index being created.
   * @param indexId Optional. The ID for the index. This will become the final resource name for the
   *     index. If the user does not specify this value, it will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, CreateIndexMetadata> createIndexAsync(
      String parent, Index index, String indexId) {
    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setParent(parent)
            .setIndex(index)
            .setIndexId(indexId)
            .build();
    return createIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index under the corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setIndexId("indexId1943291277")
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   Index response = warehouseClient.createIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, CreateIndexMetadata> createIndexAsync(
      CreateIndexRequest request) {
    return createIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index under the corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setIndexId("indexId1943291277")
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   OperationFuture<Index, CreateIndexMetadata> future =
   *       warehouseClient.createIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIndexRequest, Index, CreateIndexMetadata>
      createIndexOperationCallable() {
    return stub.createIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Index under the corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setIndexId("indexId1943291277")
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.createIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return stub.createIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index under the corpus. Users can perform a metadata-only update or trigger a full
   * index rebuild with different update_mask values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   Index index = Index.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Index response = warehouseClient.updateIndexAsync(index, updateMask).get();
   * }
   * }</pre>
   *
   * @param index Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Index resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field of the resource will be overwritten if it is in the
   *     mask. Empty field mask is not allowed. If the mask is "&#42;", it triggers a full update of
   *     the index, and also a whole rebuild of index data.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, UpdateIndexMetadata> updateIndexAsync(
      Index index, FieldMask updateMask) {
    UpdateIndexRequest request =
        UpdateIndexRequest.newBuilder().setIndex(index).setUpdateMask(updateMask).build();
    return updateIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index under the corpus. Users can perform a metadata-only update or trigger a full
   * index rebuild with different update_mask values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateIndexRequest request =
   *       UpdateIndexRequest.newBuilder()
   *           .setIndex(Index.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Index response = warehouseClient.updateIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, UpdateIndexMetadata> updateIndexAsync(
      UpdateIndexRequest request) {
    return updateIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index under the corpus. Users can perform a metadata-only update or trigger a full
   * index rebuild with different update_mask values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateIndexRequest request =
   *       UpdateIndexRequest.newBuilder()
   *           .setIndex(Index.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Index, UpdateIndexMetadata> future =
   *       warehouseClient.updateIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateIndexRequest, Index, UpdateIndexMetadata>
      updateIndexOperationCallable() {
    return stub.updateIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Index under the corpus. Users can perform a metadata-only update or trigger a full
   * index rebuild with different update_mask values.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateIndexRequest request =
   *       UpdateIndexRequest.newBuilder()
   *           .setIndex(Index.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.updateIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable() {
    return stub.updateIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Index under a Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
   *   Index response = warehouseClient.getIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Index resource. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(IndexName name) {
    GetIndexRequest request =
        GetIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Index under a Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString();
   *   Index response = warehouseClient.getIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the Index resource. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(String name) {
    GetIndexRequest request = GetIndexRequest.newBuilder().setName(name).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Index under a Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   Index response = warehouseClient.getIndex(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(GetIndexRequest request) {
    return getIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Index under a Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Index> future = warehouseClient.getIndexCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return stub.getIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Indexes in a given Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   for (Index element : warehouseClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent corpus that owns this collection of indexes. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(CorpusName parent) {
    ListIndexesRequest request =
        ListIndexesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Indexes in a given Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   for (Index element : warehouseClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent corpus that owns this collection of indexes. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(String parent) {
    ListIndexesRequest request = ListIndexesRequest.newBuilder().setParent(parent).build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Indexes in a given Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Index element : warehouseClient.listIndexes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(ListIndexesRequest request) {
    return listIndexesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Indexes in a given Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Index> future = warehouseClient.listIndexesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Index element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable() {
    return stub.listIndexesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Indexes in a given Corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIndexesResponse response = warehouseClient.listIndexesCallable().call(request);
   *     for (Index element : response.getIndexesList()) {
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
  public final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return stub.listIndexesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Index. In order to delete an index, the caller must make sure that it is not
   * deployed to any index endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
   *   warehouseClient.deleteIndexAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the index to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIndexMetadata> deleteIndexAsync(IndexName name) {
    DeleteIndexRequest request =
        DeleteIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Index. In order to delete an index, the caller must make sure that it is not
   * deployed to any index endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString();
   *   warehouseClient.deleteIndexAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the index to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/indexes/{index}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIndexMetadata> deleteIndexAsync(String name) {
    DeleteIndexRequest request = DeleteIndexRequest.newBuilder().setName(name).build();
    return deleteIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Index. In order to delete an index, the caller must make sure that it is not
   * deployed to any index endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   warehouseClient.deleteIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIndexMetadata> deleteIndexAsync(
      DeleteIndexRequest request) {
    return deleteIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Index. In order to delete an index, the caller must make sure that it is not
   * deployed to any index endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteIndexMetadata> future =
   *       warehouseClient.deleteIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIndexRequest, Empty, DeleteIndexMetadata>
      deleteIndexOperationCallable() {
    return stub.deleteIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Index. In order to delete an index, the caller must make sure that it is not
   * deployed to any index endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.deleteIndexCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    return stub.deleteIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a corpus inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = "parent-995424086";
   *   Corpus corpus = Corpus.newBuilder().build();
   *   Corpus response = warehouseClient.createCorpusAsync(parent, corpus).get();
   * }
   * }</pre>
   *
   * @param parent Required. Form: `projects/{project_number}/locations/{location_id}`
   * @param corpus Required. The corpus to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Corpus, CreateCorpusMetadata> createCorpusAsync(
      String parent, Corpus corpus) {
    CreateCorpusRequest request =
        CreateCorpusRequest.newBuilder().setParent(parent).setCorpus(corpus).build();
    return createCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a corpus inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateCorpusRequest request =
   *       CreateCorpusRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCorpus(Corpus.newBuilder().build())
   *           .build();
   *   Corpus response = warehouseClient.createCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Corpus, CreateCorpusMetadata> createCorpusAsync(
      CreateCorpusRequest request) {
    return createCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a corpus inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateCorpusRequest request =
   *       CreateCorpusRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCorpus(Corpus.newBuilder().build())
   *           .build();
   *   OperationFuture<Corpus, CreateCorpusMetadata> future =
   *       warehouseClient.createCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   Corpus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCorpusRequest, Corpus, CreateCorpusMetadata>
      createCorpusOperationCallable() {
    return stub.createCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a corpus inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateCorpusRequest request =
   *       CreateCorpusRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCorpus(Corpus.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.createCorpusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCorpusRequest, Operation> createCorpusCallable() {
    return stub.createCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets corpus details inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   Corpus response = warehouseClient.getCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the corpus to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Corpus getCorpus(CorpusName name) {
    GetCorpusRequest request =
        GetCorpusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets corpus details inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   Corpus response = warehouseClient.getCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the corpus to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Corpus getCorpus(String name) {
    GetCorpusRequest request = GetCorpusRequest.newBuilder().setName(name).build();
    return getCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets corpus details inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetCorpusRequest request =
   *       GetCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   Corpus response = warehouseClient.getCorpus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Corpus getCorpus(GetCorpusRequest request) {
    return getCorpusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets corpus details inside a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetCorpusRequest request =
   *       GetCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   ApiFuture<Corpus> future = warehouseClient.getCorpusCallable().futureCall(request);
   *   // Do something.
   *   Corpus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCorpusRequest, Corpus> getCorpusCallable() {
    return stub.getCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a corpus in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   Corpus corpus = Corpus.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Corpus response = warehouseClient.updateCorpus(corpus, updateMask);
   * }
   * }</pre>
   *
   * @param corpus Required. The corpus which replaces the resource on the server.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Corpus updateCorpus(Corpus corpus, FieldMask updateMask) {
    UpdateCorpusRequest request =
        UpdateCorpusRequest.newBuilder().setCorpus(corpus).setUpdateMask(updateMask).build();
    return updateCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a corpus in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateCorpusRequest request =
   *       UpdateCorpusRequest.newBuilder()
   *           .setCorpus(Corpus.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Corpus response = warehouseClient.updateCorpus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Corpus updateCorpus(UpdateCorpusRequest request) {
    return updateCorpusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a corpus in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateCorpusRequest request =
   *       UpdateCorpusRequest.newBuilder()
   *           .setCorpus(Corpus.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Corpus> future = warehouseClient.updateCorpusCallable().futureCall(request);
   *   // Do something.
   *   Corpus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCorpusRequest, Corpus> updateCorpusCallable() {
    return stub.updateCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all corpora in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Corpus element : warehouseClient.listCorpora(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list corpora.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCorporaPagedResponse listCorpora(String parent) {
    ListCorporaRequest request = ListCorporaRequest.newBuilder().setParent(parent).build();
    return listCorpora(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all corpora in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListCorporaRequest request =
   *       ListCorporaRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Corpus element : warehouseClient.listCorpora(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCorporaPagedResponse listCorpora(ListCorporaRequest request) {
    return listCorporaPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all corpora in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListCorporaRequest request =
   *       ListCorporaRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Corpus> future = warehouseClient.listCorporaPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Corpus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCorporaRequest, ListCorporaPagedResponse>
      listCorporaPagedCallable() {
    return stub.listCorporaPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all corpora in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListCorporaRequest request =
   *       ListCorporaRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListCorporaResponse response = warehouseClient.listCorporaCallable().call(request);
   *     for (Corpus element : response.getCorporaList()) {
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
  public final UnaryCallable<ListCorporaRequest, ListCorporaResponse> listCorporaCallable() {
    return stub.listCorporaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a corpus only if its empty. Returns empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   warehouseClient.deleteCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the corpus to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCorpus(CorpusName name) {
    DeleteCorpusRequest request =
        DeleteCorpusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a corpus only if its empty. Returns empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   warehouseClient.deleteCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the corpus to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCorpus(String name) {
    DeleteCorpusRequest request = DeleteCorpusRequest.newBuilder().setName(name).build();
    deleteCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a corpus only if its empty. Returns empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteCorpusRequest request =
   *       DeleteCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   warehouseClient.deleteCorpus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCorpus(DeleteCorpusRequest request) {
    deleteCorpusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a corpus only if its empty. Returns empty response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteCorpusRequest request =
   *       DeleteCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   ApiFuture<Empty> future = warehouseClient.deleteCorpusCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCorpusRequest, Empty> deleteCorpusCallable() {
    return stub.deleteCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnalyzeCorpusRequest request =
   *       AnalyzeCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   AnalyzeCorpusResponse response = warehouseClient.analyzeCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AnalyzeCorpusResponse, AnalyzeCorpusMetadata> analyzeCorpusAsync(
      AnalyzeCorpusRequest request) {
    return analyzeCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnalyzeCorpusRequest request =
   *       AnalyzeCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   OperationFuture<AnalyzeCorpusResponse, AnalyzeCorpusMetadata> future =
   *       warehouseClient.analyzeCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   AnalyzeCorpusResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AnalyzeCorpusRequest, AnalyzeCorpusResponse, AnalyzeCorpusMetadata>
      analyzeCorpusOperationCallable() {
    return stub.analyzeCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnalyzeCorpusRequest request =
   *       AnalyzeCorpusRequest.newBuilder()
   *           .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.analyzeCorpusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnalyzeCorpusRequest, Operation> analyzeCorpusCallable() {
    return stub.analyzeCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   DataSchema dataSchema = DataSchema.newBuilder().build();
   *   DataSchema response = warehouseClient.createDataSchema(parent, dataSchema);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data schema will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param dataSchema Required. The data schema to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema createDataSchema(CorpusName parent, DataSchema dataSchema) {
    CreateDataSchemaRequest request =
        CreateDataSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataSchema(dataSchema)
            .build();
    return createDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   DataSchema dataSchema = DataSchema.newBuilder().build();
   *   DataSchema response = warehouseClient.createDataSchema(parent, dataSchema);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data schema will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param dataSchema Required. The data schema to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema createDataSchema(String parent, DataSchema dataSchema) {
    CreateDataSchemaRequest request =
        CreateDataSchemaRequest.newBuilder().setParent(parent).setDataSchema(dataSchema).build();
    return createDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateDataSchemaRequest request =
   *       CreateDataSchemaRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setDataSchema(DataSchema.newBuilder().build())
   *           .build();
   *   DataSchema response = warehouseClient.createDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema createDataSchema(CreateDataSchemaRequest request) {
    return createDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateDataSchemaRequest request =
   *       CreateDataSchemaRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setDataSchema(DataSchema.newBuilder().build())
   *           .build();
   *   ApiFuture<DataSchema> future = warehouseClient.createDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   DataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataSchemaRequest, DataSchema> createDataSchemaCallable() {
    return stub.createDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DataSchema dataSchema = DataSchema.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataSchema response = warehouseClient.updateDataSchema(dataSchema, updateMask);
   * }
   * }</pre>
   *
   * @param dataSchema Required. The data schema's `name` field is used to identify the data schema
   *     to be updated. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/dataSchemas/{data_schema}`
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema updateDataSchema(DataSchema dataSchema, FieldMask updateMask) {
    UpdateDataSchemaRequest request =
        UpdateDataSchemaRequest.newBuilder()
            .setDataSchema(dataSchema)
            .setUpdateMask(updateMask)
            .build();
    return updateDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateDataSchemaRequest request =
   *       UpdateDataSchemaRequest.newBuilder()
   *           .setDataSchema(DataSchema.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataSchema response = warehouseClient.updateDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema updateDataSchema(UpdateDataSchemaRequest request) {
    return updateDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateDataSchemaRequest request =
   *       UpdateDataSchemaRequest.newBuilder()
   *           .setDataSchema(DataSchema.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataSchema> future = warehouseClient.updateDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   DataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataSchemaRequest, DataSchema> updateDataSchemaCallable() {
    return stub.updateDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DataSchemaName name =
   *       DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");
   *   DataSchema response = warehouseClient.getDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data schema to retrieve. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}/dataSchemas/{data_schema_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema getDataSchema(DataSchemaName name) {
    GetDataSchemaRequest request =
        GetDataSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
   *           .toString();
   *   DataSchema response = warehouseClient.getDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data schema to retrieve. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}/dataSchemas/{data_schema_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema getDataSchema(String name) {
    GetDataSchemaRequest request = GetDataSchemaRequest.newBuilder().setName(name).build();
    return getDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetDataSchemaRequest request =
   *       GetDataSchemaRequest.newBuilder()
   *           .setName(
   *               DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   DataSchema response = warehouseClient.getDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSchema getDataSchema(GetDataSchemaRequest request) {
    return getDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetDataSchemaRequest request =
   *       GetDataSchemaRequest.newBuilder()
   *           .setName(
   *               DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataSchema> future = warehouseClient.getDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   DataSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataSchemaRequest, DataSchema> getDataSchemaCallable() {
    return stub.getDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DataSchemaName name =
   *       DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");
   *   warehouseClient.deleteDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data schema to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}/dataSchemas/{data_schema_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataSchema(DataSchemaName name) {
    DeleteDataSchemaRequest request =
        DeleteDataSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
   *           .toString();
   *   warehouseClient.deleteDataSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data schema to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}/dataSchemas/{data_schema_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataSchema(String name) {
    DeleteDataSchemaRequest request = DeleteDataSchemaRequest.newBuilder().setName(name).build();
    deleteDataSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteDataSchemaRequest request =
   *       DeleteDataSchemaRequest.newBuilder()
   *           .setName(
   *               DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   warehouseClient.deleteDataSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataSchema(DeleteDataSchemaRequest request) {
    deleteDataSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes data schema inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteDataSchemaRequest request =
   *       DeleteDataSchemaRequest.newBuilder()
   *           .setName(
   *               DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = warehouseClient.deleteDataSchemaCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataSchemaRequest, Empty> deleteDataSchemaCallable() {
    return stub.deleteDataSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of data schemas inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   for (DataSchema element : warehouseClient.listDataSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of data schemas. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSchemasPagedResponse listDataSchemas(CorpusName parent) {
    ListDataSchemasRequest request =
        ListDataSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of data schemas inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   for (DataSchema element : warehouseClient.listDataSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of data schemas. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSchemasPagedResponse listDataSchemas(String parent) {
    ListDataSchemasRequest request = ListDataSchemasRequest.newBuilder().setParent(parent).build();
    return listDataSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of data schemas inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListDataSchemasRequest request =
   *       ListDataSchemasRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataSchema element : warehouseClient.listDataSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSchemasPagedResponse listDataSchemas(ListDataSchemasRequest request) {
    return listDataSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of data schemas inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListDataSchemasRequest request =
   *       ListDataSchemasRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataSchema> future =
   *       warehouseClient.listDataSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataSchemasRequest, ListDataSchemasPagedResponse>
      listDataSchemasPagedCallable() {
    return stub.listDataSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of data schemas inside corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListDataSchemasRequest request =
   *       ListDataSchemasRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDataSchemasResponse response = warehouseClient.listDataSchemasCallable().call(request);
   *     for (DataSchema element : response.getDataSchemasList()) {
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
  public final UnaryCallable<ListDataSchemasRequest, ListDataSchemasResponse>
      listDataSchemasCallable() {
    return stub.listDataSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
   *   Annotation annotation = Annotation.newBuilder().build();
   *   String annotationId = "annotationId251782314";
   *   Annotation response = warehouseClient.createAnnotation(parent, annotation, annotationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this annotation will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}/assets/{asset_id}`
   * @param annotation Required. The annotation to create.
   * @param annotationId Optional. The ID to use for the annotation, which will become the final
   *     component of the annotation's resource name if user choose to specify. Otherwise,
   *     annotation id will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation createAnnotation(
      AssetName parent, Annotation annotation, String annotationId) {
    CreateAnnotationRequest request =
        CreateAnnotationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnnotation(annotation)
            .setAnnotationId(annotationId)
            .build();
    return createAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent =
   *       AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString();
   *   Annotation annotation = Annotation.newBuilder().build();
   *   String annotationId = "annotationId251782314";
   *   Annotation response = warehouseClient.createAnnotation(parent, annotation, annotationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this annotation will be created. Format:
   *     `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}/assets/{asset_id}`
   * @param annotation Required. The annotation to create.
   * @param annotationId Optional. The ID to use for the annotation, which will become the final
   *     component of the annotation's resource name if user choose to specify. Otherwise,
   *     annotation id will be generated by system.
   *     <p>This value should be up to 63 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation createAnnotation(
      String parent, Annotation annotation, String annotationId) {
    CreateAnnotationRequest request =
        CreateAnnotationRequest.newBuilder()
            .setParent(parent)
            .setAnnotation(annotation)
            .setAnnotationId(annotationId)
            .build();
    return createAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateAnnotationRequest request =
   *       CreateAnnotationRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setAnnotationId("annotationId251782314")
   *           .build();
   *   Annotation response = warehouseClient.createAnnotation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation createAnnotation(CreateAnnotationRequest request) {
    return createAnnotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateAnnotationRequest request =
   *       CreateAnnotationRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setAnnotationId("annotationId251782314")
   *           .build();
   *   ApiFuture<Annotation> future = warehouseClient.createAnnotationCallable().futureCall(request);
   *   // Do something.
   *   Annotation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnnotationRequest, Annotation> createAnnotationCallable() {
    return stub.createAnnotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnnotationName name =
   *       AnnotationName.of(
   *           "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");
   *   Annotation response = warehouseClient.getAnnotation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the annotation to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation getAnnotation(AnnotationName name) {
    GetAnnotationRequest request =
        GetAnnotationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       AnnotationName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
   *           .toString();
   *   Annotation response = warehouseClient.getAnnotation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the annotation to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation getAnnotation(String name) {
    GetAnnotationRequest request = GetAnnotationRequest.newBuilder().setName(name).build();
    return getAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetAnnotationRequest request =
   *       GetAnnotationRequest.newBuilder()
   *           .setName(
   *               AnnotationName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
   *                   .toString())
   *           .build();
   *   Annotation response = warehouseClient.getAnnotation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation getAnnotation(GetAnnotationRequest request) {
    return getAnnotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetAnnotationRequest request =
   *       GetAnnotationRequest.newBuilder()
   *           .setName(
   *               AnnotationName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Annotation> future = warehouseClient.getAnnotationCallable().futureCall(request);
   *   // Do something.
   *   Annotation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    return stub.getAnnotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of annotations inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
   *   for (Annotation element : warehouseClient.listAnnotations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent, which owns this collection of annotations. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(AssetName parent) {
    ListAnnotationsRequest request =
        ListAnnotationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of annotations inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent =
   *       AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString();
   *   for (Annotation element : warehouseClient.listAnnotations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The parent, which owns this collection of annotations. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(String parent) {
    ListAnnotationsRequest request = ListAnnotationsRequest.newBuilder().setParent(parent).build();
    return listAnnotations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of annotations inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListAnnotationsRequest request =
   *       ListAnnotationsRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Annotation element : warehouseClient.listAnnotations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnnotationsPagedResponse listAnnotations(ListAnnotationsRequest request) {
    return listAnnotationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of annotations inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListAnnotationsRequest request =
   *       ListAnnotationsRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Annotation> future =
   *       warehouseClient.listAnnotationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Annotation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    return stub.listAnnotationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a list of annotations inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListAnnotationsRequest request =
   *       ListAnnotationsRequest.newBuilder()
   *           .setParent(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAnnotationsResponse response = warehouseClient.listAnnotationsCallable().call(request);
   *     for (Annotation element : response.getAnnotationsList()) {
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
  public final UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsCallable() {
    return stub.listAnnotationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   Annotation annotation = Annotation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Annotation response = warehouseClient.updateAnnotation(annotation, updateMask);
   * }
   * }</pre>
   *
   * @param annotation Required. The annotation to update. The annotation's `name` field is used to
   *     identify the annotation to be updated. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}`
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation updateAnnotation(Annotation annotation, FieldMask updateMask) {
    UpdateAnnotationRequest request =
        UpdateAnnotationRequest.newBuilder()
            .setAnnotation(annotation)
            .setUpdateMask(updateMask)
            .build();
    return updateAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateAnnotationRequest request =
   *       UpdateAnnotationRequest.newBuilder()
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Annotation response = warehouseClient.updateAnnotation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation updateAnnotation(UpdateAnnotationRequest request) {
    return updateAnnotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateAnnotationRequest request =
   *       UpdateAnnotationRequest.newBuilder()
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Annotation> future = warehouseClient.updateAnnotationCallable().futureCall(request);
   *   // Do something.
   *   Annotation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAnnotationRequest, Annotation> updateAnnotationCallable() {
    return stub.updateAnnotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AnnotationName name =
   *       AnnotationName.of(
   *           "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");
   *   warehouseClient.deleteAnnotation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the annotation to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotation(AnnotationName name) {
    DeleteAnnotationRequest request =
        DeleteAnnotationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       AnnotationName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
   *           .toString();
   *   warehouseClient.deleteAnnotation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the annotation to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotation(String name) {
    DeleteAnnotationRequest request = DeleteAnnotationRequest.newBuilder().setName(name).build();
    deleteAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteAnnotationRequest request =
   *       DeleteAnnotationRequest.newBuilder()
   *           .setName(
   *               AnnotationName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
   *                   .toString())
   *           .build();
   *   warehouseClient.deleteAnnotation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnnotation(DeleteAnnotationRequest request) {
    deleteAnnotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes annotation inside asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteAnnotationRequest request =
   *       DeleteAnnotationRequest.newBuilder()
   *           .setName(
   *               AnnotationName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = warehouseClient.deleteAnnotationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnnotationRequest, Empty> deleteAnnotationCallable() {
    return stub.deleteAnnotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ingests data for the asset. It is not allowed to ingest a data chunk which is already expired
   * according to TTL. This method is only available via the gRPC API (not HTTP since bi-directional
   * streaming is not supported via HTTP).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   BidiStream<IngestAssetRequest, IngestAssetResponse> bidiStream =
   *       warehouseClient.ingestAssetCallable().call();
   *   IngestAssetRequest request = IngestAssetRequest.newBuilder().build();
   *   bidiStream.send(request);
   *   for (IngestAssetResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse>
      ingestAssetCallable() {
    return stub.ingestAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates clips for downloading. The api takes in a time range, and generates a clip of the
   * first content available after start_time and before end_time, which may overflow beyond these
   * bounds. Returned clips are truncated if the total size of the clips are larger than 100MB.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ClipAssetRequest request =
   *       ClipAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setTemporalPartition(Partition.TemporalPartition.newBuilder().build())
   *           .build();
   *   ClipAssetResponse response = warehouseClient.clipAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClipAssetResponse clipAsset(ClipAssetRequest request) {
    return clipAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates clips for downloading. The api takes in a time range, and generates a clip of the
   * first content available after start_time and before end_time, which may overflow beyond these
   * bounds. Returned clips are truncated if the total size of the clips are larger than 100MB.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ClipAssetRequest request =
   *       ClipAssetRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .setTemporalPartition(Partition.TemporalPartition.newBuilder().build())
   *           .build();
   *   ApiFuture<ClipAssetResponse> future = warehouseClient.clipAssetCallable().futureCall(request);
   *   // Do something.
   *   ClipAssetResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ClipAssetRequest, ClipAssetResponse> clipAssetCallable() {
    return stub.clipAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a uri for an HLS manifest. The api takes in a collection of time ranges, and
   * generates a URI for an HLS manifest that covers all the requested time ranges.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GenerateHlsUriRequest request =
   *       GenerateHlsUriRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .addAllTemporalPartitions(new ArrayList<Partition.TemporalPartition>())
   *           .setLiveViewEnabled(true)
   *           .build();
   *   GenerateHlsUriResponse response = warehouseClient.generateHlsUri(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateHlsUriResponse generateHlsUri(GenerateHlsUriRequest request) {
    return generateHlsUriCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a uri for an HLS manifest. The api takes in a collection of time ranges, and
   * generates a URI for an HLS manifest that covers all the requested time ranges.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GenerateHlsUriRequest request =
   *       GenerateHlsUriRequest.newBuilder()
   *           .setName(
   *               AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
   *           .addAllTemporalPartitions(new ArrayList<Partition.TemporalPartition>())
   *           .setLiveViewEnabled(true)
   *           .build();
   *   ApiFuture<GenerateHlsUriResponse> future =
   *       warehouseClient.generateHlsUriCallable().futureCall(request);
   *   // Do something.
   *   GenerateHlsUriResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateHlsUriRequest, GenerateHlsUriResponse>
      generateHlsUriCallable() {
    return stub.generateHlsUriCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports assets (images plus annotations) from a meta file on cloud storage. Each row in the
   * meta file is corresponding to an image (specified by a cloud storage uri) and its annotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ImportAssetsRequest request =
   *       ImportAssetsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   ImportAssetsResponse response = warehouseClient.importAssetsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportAssetsResponse, ImportAssetsMetadata> importAssetsAsync(
      ImportAssetsRequest request) {
    return importAssetsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports assets (images plus annotations) from a meta file on cloud storage. Each row in the
   * meta file is corresponding to an image (specified by a cloud storage uri) and its annotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ImportAssetsRequest request =
   *       ImportAssetsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   OperationFuture<ImportAssetsResponse, ImportAssetsMetadata> future =
   *       warehouseClient.importAssetsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportAssetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportAssetsRequest, ImportAssetsResponse, ImportAssetsMetadata>
      importAssetsOperationCallable() {
    return stub.importAssetsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports assets (images plus annotations) from a meta file on cloud storage. Each row in the
   * meta file is corresponding to an image (specified by a cloud storage uri) and its annotations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ImportAssetsRequest request =
   *       ImportAssetsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.importAssetsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportAssetsRequest, Operation> importAssetsCallable() {
    return stub.importAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid CreateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_config_id must not be associated with an existing SearchConfig. 2.
   * Request must contain at least one non-empty search_criteria_property or facet_property. 3.
   * mapped_fields must not be empty, and must map to existing UGA keys. 4. All mapped_fields must
   * be of the same type. 5. All mapped_fields must share the same granularity. 6. All mapped_fields
   * must share the same semantic SearchConfig match options. For property-specific rules, please
   * reference the comments for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   SearchConfig searchConfig = SearchConfig.newBuilder().build();
   *   String searchConfigId = "searchConfigId1576297925";
   *   SearchConfig response =
   *       warehouseClient.createSearchConfig(parent, searchConfig, searchConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this search configuration will be created.
   *     Format: `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param searchConfig Required. The search config to create.
   * @param searchConfigId Required. ID to use for the new search config. Will become the final
   *     component of the SearchConfig's resource name. This value should be up to 63 characters,
   *     and valid characters are /[a-z][0-9]-_/. The first character must be a letter, the last
   *     could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig createSearchConfig(
      CorpusName parent, SearchConfig searchConfig, String searchConfigId) {
    CreateSearchConfigRequest request =
        CreateSearchConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSearchConfig(searchConfig)
            .setSearchConfigId(searchConfigId)
            .build();
    return createSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid CreateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_config_id must not be associated with an existing SearchConfig. 2.
   * Request must contain at least one non-empty search_criteria_property or facet_property. 3.
   * mapped_fields must not be empty, and must map to existing UGA keys. 4. All mapped_fields must
   * be of the same type. 5. All mapped_fields must share the same granularity. 6. All mapped_fields
   * must share the same semantic SearchConfig match options. For property-specific rules, please
   * reference the comments for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   SearchConfig searchConfig = SearchConfig.newBuilder().build();
   *   String searchConfigId = "searchConfigId1576297925";
   *   SearchConfig response =
   *       warehouseClient.createSearchConfig(parent, searchConfig, searchConfigId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this search configuration will be created.
   *     Format: `projects/{project_number}/locations/{location_id}/corpora/{corpus_id}`
   * @param searchConfig Required. The search config to create.
   * @param searchConfigId Required. ID to use for the new search config. Will become the final
   *     component of the SearchConfig's resource name. This value should be up to 63 characters,
   *     and valid characters are /[a-z][0-9]-_/. The first character must be a letter, the last
   *     could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig createSearchConfig(
      String parent, SearchConfig searchConfig, String searchConfigId) {
    CreateSearchConfigRequest request =
        CreateSearchConfigRequest.newBuilder()
            .setParent(parent)
            .setSearchConfig(searchConfig)
            .setSearchConfigId(searchConfigId)
            .build();
    return createSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid CreateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_config_id must not be associated with an existing SearchConfig. 2.
   * Request must contain at least one non-empty search_criteria_property or facet_property. 3.
   * mapped_fields must not be empty, and must map to existing UGA keys. 4. All mapped_fields must
   * be of the same type. 5. All mapped_fields must share the same granularity. 6. All mapped_fields
   * must share the same semantic SearchConfig match options. For property-specific rules, please
   * reference the comments for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateSearchConfigRequest request =
   *       CreateSearchConfigRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setSearchConfig(SearchConfig.newBuilder().build())
   *           .setSearchConfigId("searchConfigId1576297925")
   *           .build();
   *   SearchConfig response = warehouseClient.createSearchConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig createSearchConfig(CreateSearchConfigRequest request) {
    return createSearchConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid CreateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_config_id must not be associated with an existing SearchConfig. 2.
   * Request must contain at least one non-empty search_criteria_property or facet_property. 3.
   * mapped_fields must not be empty, and must map to existing UGA keys. 4. All mapped_fields must
   * be of the same type. 5. All mapped_fields must share the same granularity. 6. All mapped_fields
   * must share the same semantic SearchConfig match options. For property-specific rules, please
   * reference the comments for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateSearchConfigRequest request =
   *       CreateSearchConfigRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setSearchConfig(SearchConfig.newBuilder().build())
   *           .setSearchConfigId("searchConfigId1576297925")
   *           .build();
   *   ApiFuture<SearchConfig> future =
   *       warehouseClient.createSearchConfigCallable().futureCall(request);
   *   // Do something.
   *   SearchConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSearchConfigRequest, SearchConfig> createSearchConfigCallable() {
    return stub.createSearchConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid UpdateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_configuration.name must already exist. 2. Request must contain at least
   * one non-empty search_criteria_property or facet_property. 3. mapped_fields must not be empty,
   * and must map to existing UGA keys. 4. All mapped_fields must be of the same type. 5. All
   * mapped_fields must share the same granularity. 6. All mapped_fields must share the same
   * semantic SearchConfig match options. For property-specific rules, please reference the comments
   * for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchConfig searchConfig = SearchConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SearchConfig response = warehouseClient.updateSearchConfig(searchConfig, updateMask);
   * }
   * }</pre>
   *
   * @param searchConfig Required. The search configuration to update.
   *     <p>The search configuration's `name` field is used to identify the resource to be updated.
   *     Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchConfigs/{search_config}`
   * @param updateMask The list of fields to be updated. If left unset, all field paths will be
   *     updated/overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig updateSearchConfig(SearchConfig searchConfig, FieldMask updateMask) {
    UpdateSearchConfigRequest request =
        UpdateSearchConfigRequest.newBuilder()
            .setSearchConfig(searchConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid UpdateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_configuration.name must already exist. 2. Request must contain at least
   * one non-empty search_criteria_property or facet_property. 3. mapped_fields must not be empty,
   * and must map to existing UGA keys. 4. All mapped_fields must be of the same type. 5. All
   * mapped_fields must share the same granularity. 6. All mapped_fields must share the same
   * semantic SearchConfig match options. For property-specific rules, please reference the comments
   * for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateSearchConfigRequest request =
   *       UpdateSearchConfigRequest.newBuilder()
   *           .setSearchConfig(SearchConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SearchConfig response = warehouseClient.updateSearchConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig updateSearchConfig(UpdateSearchConfigRequest request) {
    return updateSearchConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a search configuration inside a corpus.
   *
   * <p>Please follow the rules below to create a valid UpdateSearchConfigRequest. --- General Rules
   * --- 1. Request.search_configuration.name must already exist. 2. Request must contain at least
   * one non-empty search_criteria_property or facet_property. 3. mapped_fields must not be empty,
   * and must map to existing UGA keys. 4. All mapped_fields must be of the same type. 5. All
   * mapped_fields must share the same granularity. 6. All mapped_fields must share the same
   * semantic SearchConfig match options. For property-specific rules, please reference the comments
   * for FacetProperty and SearchCriteriaProperty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateSearchConfigRequest request =
   *       UpdateSearchConfigRequest.newBuilder()
   *           .setSearchConfig(SearchConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchConfig> future =
   *       warehouseClient.updateSearchConfigCallable().futureCall(request);
   *   // Do something.
   *   SearchConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSearchConfigRequest, SearchConfig> updateSearchConfigCallable() {
    return stub.updateSearchConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a search configuration inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchConfigName name =
   *       SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");
   *   SearchConfig response = warehouseClient.getSearchConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the search configuration to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchConfigs/{search_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig getSearchConfig(SearchConfigName name) {
    GetSearchConfigRequest request =
        GetSearchConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a search configuration inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
   *           .toString();
   *   SearchConfig response = warehouseClient.getSearchConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the search configuration to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchConfigs/{search_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig getSearchConfig(String name) {
    GetSearchConfigRequest request = GetSearchConfigRequest.newBuilder().setName(name).build();
    return getSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a search configuration inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetSearchConfigRequest request =
   *       GetSearchConfigRequest.newBuilder()
   *           .setName(
   *               SearchConfigName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
   *                   .toString())
   *           .build();
   *   SearchConfig response = warehouseClient.getSearchConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchConfig getSearchConfig(GetSearchConfigRequest request) {
    return getSearchConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a search configuration inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetSearchConfigRequest request =
   *       GetSearchConfigRequest.newBuilder()
   *           .setName(
   *               SearchConfigName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SearchConfig> future =
   *       warehouseClient.getSearchConfigCallable().futureCall(request);
   *   // Do something.
   *   SearchConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSearchConfigRequest, SearchConfig> getSearchConfigCallable() {
    return stub.getSearchConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a search configuration inside a corpus.
   *
   * <p>For a DeleteSearchConfigRequest to be valid, Request.search_configuration.name must already
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchConfigName name =
   *       SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");
   *   warehouseClient.deleteSearchConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the search configuration to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchConfigs/{search_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchConfig(SearchConfigName name) {
    DeleteSearchConfigRequest request =
        DeleteSearchConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a search configuration inside a corpus.
   *
   * <p>For a DeleteSearchConfigRequest to be valid, Request.search_configuration.name must already
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
   *           .toString();
   *   warehouseClient.deleteSearchConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the search configuration to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchConfigs/{search_config}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchConfig(String name) {
    DeleteSearchConfigRequest request =
        DeleteSearchConfigRequest.newBuilder().setName(name).build();
    deleteSearchConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a search configuration inside a corpus.
   *
   * <p>For a DeleteSearchConfigRequest to be valid, Request.search_configuration.name must already
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteSearchConfigRequest request =
   *       DeleteSearchConfigRequest.newBuilder()
   *           .setName(
   *               SearchConfigName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
   *                   .toString())
   *           .build();
   *   warehouseClient.deleteSearchConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchConfig(DeleteSearchConfigRequest request) {
    deleteSearchConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a search configuration inside a corpus.
   *
   * <p>For a DeleteSearchConfigRequest to be valid, Request.search_configuration.name must already
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteSearchConfigRequest request =
   *       DeleteSearchConfigRequest.newBuilder()
   *           .setName(
   *               SearchConfigName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = warehouseClient.deleteSearchConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSearchConfigRequest, Empty> deleteSearchConfigCallable() {
    return stub.deleteSearchConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all search configurations inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   for (SearchConfig element : warehouseClient.listSearchConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of search configurations.
   *     Format: `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchConfigsPagedResponse listSearchConfigs(CorpusName parent) {
    ListSearchConfigsRequest request =
        ListSearchConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSearchConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all search configurations inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   for (SearchConfig element : warehouseClient.listSearchConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of search configurations.
   *     Format: `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchConfigsPagedResponse listSearchConfigs(String parent) {
    ListSearchConfigsRequest request =
        ListSearchConfigsRequest.newBuilder().setParent(parent).build();
    return listSearchConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all search configurations inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListSearchConfigsRequest request =
   *       ListSearchConfigsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SearchConfig element : warehouseClient.listSearchConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchConfigsPagedResponse listSearchConfigs(ListSearchConfigsRequest request) {
    return listSearchConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all search configurations inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListSearchConfigsRequest request =
   *       ListSearchConfigsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SearchConfig> future =
   *       warehouseClient.listSearchConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsPagedResponse>
      listSearchConfigsPagedCallable() {
    return stub.listSearchConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all search configurations inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListSearchConfigsRequest request =
   *       ListSearchConfigsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSearchConfigsResponse response =
   *         warehouseClient.listSearchConfigsCallable().call(request);
   *     for (SearchConfig element : response.getSearchConfigsList()) {
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
  public final UnaryCallable<ListSearchConfigsRequest, ListSearchConfigsResponse>
      listSearchConfigsCallable() {
    return stub.listSearchConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
   *   String searchHypernymId = "searchHypernymId-314707559";
   *   SearchHypernym response =
   *       warehouseClient.createSearchHypernym(parent, searchHypernym, searchHypernymId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this SearchHypernym will be created. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @param searchHypernym Required. The SearchHypernym to create.
   * @param searchHypernymId Optional. The search hypernym id. If omitted, a random UUID will be
   *     generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym createSearchHypernym(
      CorpusName parent, SearchHypernym searchHypernym, String searchHypernymId) {
    CreateSearchHypernymRequest request =
        CreateSearchHypernymRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSearchHypernym(searchHypernym)
            .setSearchHypernymId(searchHypernymId)
            .build();
    return createSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
   *   String searchHypernymId = "searchHypernymId-314707559";
   *   SearchHypernym response =
   *       warehouseClient.createSearchHypernym(parent, searchHypernym, searchHypernymId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this SearchHypernym will be created. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @param searchHypernym Required. The SearchHypernym to create.
   * @param searchHypernymId Optional. The search hypernym id. If omitted, a random UUID will be
   *     generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym createSearchHypernym(
      String parent, SearchHypernym searchHypernym, String searchHypernymId) {
    CreateSearchHypernymRequest request =
        CreateSearchHypernymRequest.newBuilder()
            .setParent(parent)
            .setSearchHypernym(searchHypernym)
            .setSearchHypernymId(searchHypernymId)
            .build();
    return createSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateSearchHypernymRequest request =
   *       CreateSearchHypernymRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setSearchHypernym(SearchHypernym.newBuilder().build())
   *           .setSearchHypernymId("searchHypernymId-314707559")
   *           .build();
   *   SearchHypernym response = warehouseClient.createSearchHypernym(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym createSearchHypernym(CreateSearchHypernymRequest request) {
    return createSearchHypernymCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateSearchHypernymRequest request =
   *       CreateSearchHypernymRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setSearchHypernym(SearchHypernym.newBuilder().build())
   *           .setSearchHypernymId("searchHypernymId-314707559")
   *           .build();
   *   ApiFuture<SearchHypernym> future =
   *       warehouseClient.createSearchHypernymCallable().futureCall(request);
   *   // Do something.
   *   SearchHypernym response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSearchHypernymRequest, SearchHypernym>
      createSearchHypernymCallable() {
    return stub.createSearchHypernymCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SearchHypernym response = warehouseClient.updateSearchHypernym(searchHypernym, updateMask);
   * }
   * }</pre>
   *
   * @param searchHypernym Required. The SearchHypernym to update. The search hypernym's `name`
   *     field is used to identify the search hypernym to be updated. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchHypernyms/{search_hypernym}`
   * @param updateMask The list of fields to be updated. If left unset, all field paths will be
   *     updated/overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym updateSearchHypernym(
      SearchHypernym searchHypernym, FieldMask updateMask) {
    UpdateSearchHypernymRequest request =
        UpdateSearchHypernymRequest.newBuilder()
            .setSearchHypernym(searchHypernym)
            .setUpdateMask(updateMask)
            .build();
    return updateSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateSearchHypernymRequest request =
   *       UpdateSearchHypernymRequest.newBuilder()
   *           .setSearchHypernym(SearchHypernym.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SearchHypernym response = warehouseClient.updateSearchHypernym(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym updateSearchHypernym(UpdateSearchHypernymRequest request) {
    return updateSearchHypernymCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateSearchHypernymRequest request =
   *       UpdateSearchHypernymRequest.newBuilder()
   *           .setSearchHypernym(SearchHypernym.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchHypernym> future =
   *       warehouseClient.updateSearchHypernymCallable().futureCall(request);
   *   // Do something.
   *   SearchHypernym response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSearchHypernymRequest, SearchHypernym>
      updateSearchHypernymCallable() {
    return stub.updateSearchHypernymCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchHypernymName name =
   *       SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");
   *   SearchHypernym response = warehouseClient.getSearchHypernym(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchHypernym to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchHypernyms/{search_hypernym}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym getSearchHypernym(SearchHypernymName name) {
    GetSearchHypernymRequest request =
        GetSearchHypernymRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
   *           .toString();
   *   SearchHypernym response = warehouseClient.getSearchHypernym(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchHypernym to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchHypernyms/{search_hypernym}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym getSearchHypernym(String name) {
    GetSearchHypernymRequest request = GetSearchHypernymRequest.newBuilder().setName(name).build();
    return getSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetSearchHypernymRequest request =
   *       GetSearchHypernymRequest.newBuilder()
   *           .setName(
   *               SearchHypernymName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
   *                   .toString())
   *           .build();
   *   SearchHypernym response = warehouseClient.getSearchHypernym(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHypernym getSearchHypernym(GetSearchHypernymRequest request) {
    return getSearchHypernymCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetSearchHypernymRequest request =
   *       GetSearchHypernymRequest.newBuilder()
   *           .setName(
   *               SearchHypernymName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SearchHypernym> future =
   *       warehouseClient.getSearchHypernymCallable().futureCall(request);
   *   // Do something.
   *   SearchHypernym response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSearchHypernymRequest, SearchHypernym> getSearchHypernymCallable() {
    return stub.getSearchHypernymCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchHypernymName name =
   *       SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");
   *   warehouseClient.deleteSearchHypernym(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchHypernym to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchHypernyms/{search_hypernym}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchHypernym(SearchHypernymName name) {
    DeleteSearchHypernymRequest request =
        DeleteSearchHypernymRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
   *           .toString();
   *   warehouseClient.deleteSearchHypernym(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SearchHypernym to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/searchHypernyms/{search_hypernym}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchHypernym(String name) {
    DeleteSearchHypernymRequest request =
        DeleteSearchHypernymRequest.newBuilder().setName(name).build();
    deleteSearchHypernym(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteSearchHypernymRequest request =
   *       DeleteSearchHypernymRequest.newBuilder()
   *           .setName(
   *               SearchHypernymName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
   *                   .toString())
   *           .build();
   *   warehouseClient.deleteSearchHypernym(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSearchHypernym(DeleteSearchHypernymRequest request) {
    deleteSearchHypernymCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a SearchHypernym inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteSearchHypernymRequest request =
   *       DeleteSearchHypernymRequest.newBuilder()
   *           .setName(
   *               SearchHypernymName.of(
   *                       "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = warehouseClient.deleteSearchHypernymCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSearchHypernymRequest, Empty> deleteSearchHypernymCallable() {
    return stub.deleteSearchHypernymCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SearchHypernyms inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   for (SearchHypernym element : warehouseClient.listSearchHypernyms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of SearchHypernyms. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchHypernymsPagedResponse listSearchHypernyms(CorpusName parent) {
    ListSearchHypernymsRequest request =
        ListSearchHypernymsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSearchHypernyms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SearchHypernyms inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   for (SearchHypernym element : warehouseClient.listSearchHypernyms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of SearchHypernyms. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchHypernymsPagedResponse listSearchHypernyms(String parent) {
    ListSearchHypernymsRequest request =
        ListSearchHypernymsRequest.newBuilder().setParent(parent).build();
    return listSearchHypernyms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SearchHypernyms inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListSearchHypernymsRequest request =
   *       ListSearchHypernymsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SearchHypernym element : warehouseClient.listSearchHypernyms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSearchHypernymsPagedResponse listSearchHypernyms(
      ListSearchHypernymsRequest request) {
    return listSearchHypernymsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SearchHypernyms inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListSearchHypernymsRequest request =
   *       ListSearchHypernymsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SearchHypernym> future =
   *       warehouseClient.listSearchHypernymsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchHypernym element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsPagedResponse>
      listSearchHypernymsPagedCallable() {
    return stub.listSearchHypernymsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SearchHypernyms inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListSearchHypernymsRequest request =
   *       ListSearchHypernymsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSearchHypernymsResponse response =
   *         warehouseClient.listSearchHypernymsCallable().call(request);
   *     for (SearchHypernym element : response.getSearchHypernymsList()) {
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
  public final UnaryCallable<ListSearchHypernymsRequest, ListSearchHypernymsResponse>
      listSearchHypernymsCallable() {
    return stub.listSearchHypernymsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search media asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchAssetsRequest request =
   *       SearchAssetsRequest.newBuilder()
   *           .setCorpus(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setContentTimeRanges(DateTimeRangeArray.newBuilder().build())
   *           .addAllCriteria(new ArrayList<Criteria>())
   *           .addAllFacetSelections(new ArrayList<FacetGroup>())
   *           .addAllResultAnnotationKeys(new ArrayList<String>())
   *           .setSearchQuery("searchQuery-552137728")
   *           .build();
   *   for (SearchResultItem element : warehouseClient.searchAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAssetsPagedResponse searchAssets(SearchAssetsRequest request) {
    return searchAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search media asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchAssetsRequest request =
   *       SearchAssetsRequest.newBuilder()
   *           .setCorpus(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setContentTimeRanges(DateTimeRangeArray.newBuilder().build())
   *           .addAllCriteria(new ArrayList<Criteria>())
   *           .addAllFacetSelections(new ArrayList<FacetGroup>())
   *           .addAllResultAnnotationKeys(new ArrayList<String>())
   *           .setSearchQuery("searchQuery-552137728")
   *           .build();
   *   ApiFuture<SearchResultItem> future =
   *       warehouseClient.searchAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchResultItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchAssetsRequest, SearchAssetsPagedResponse>
      searchAssetsPagedCallable() {
    return stub.searchAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search media asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchAssetsRequest request =
   *       SearchAssetsRequest.newBuilder()
   *           .setCorpus(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setContentTimeRanges(DateTimeRangeArray.newBuilder().build())
   *           .addAllCriteria(new ArrayList<Criteria>())
   *           .addAllFacetSelections(new ArrayList<FacetGroup>())
   *           .addAllResultAnnotationKeys(new ArrayList<String>())
   *           .setSearchQuery("searchQuery-552137728")
   *           .build();
   *   while (true) {
   *     SearchAssetsResponse response = warehouseClient.searchAssetsCallable().call(request);
   *     for (SearchResultItem element : response.getSearchResultItemsList()) {
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
  public final UnaryCallable<SearchAssetsRequest, SearchAssetsResponse> searchAssetsCallable() {
    return stub.searchAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search a deployed index endpoint (IMAGE corpus type only).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchIndexEndpointRequest request =
   *       SearchIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .addAllCriteria(new ArrayList<Criteria>())
   *           .addAllExclusionCriteria(new ArrayList<Criteria>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SearchResultItem element : warehouseClient.searchIndexEndpoint(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchIndexEndpointPagedResponse searchIndexEndpoint(
      SearchIndexEndpointRequest request) {
    return searchIndexEndpointPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search a deployed index endpoint (IMAGE corpus type only).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchIndexEndpointRequest request =
   *       SearchIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .addAllCriteria(new ArrayList<Criteria>())
   *           .addAllExclusionCriteria(new ArrayList<Criteria>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SearchResultItem> future =
   *       warehouseClient.searchIndexEndpointPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchResultItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointPagedResponse>
      searchIndexEndpointPagedCallable() {
    return stub.searchIndexEndpointPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search a deployed index endpoint (IMAGE corpus type only).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   SearchIndexEndpointRequest request =
   *       SearchIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .addAllCriteria(new ArrayList<Criteria>())
   *           .addAllExclusionCriteria(new ArrayList<Criteria>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchIndexEndpointResponse response =
   *         warehouseClient.searchIndexEndpointCallable().call(request);
   *     for (SearchResultItem element : response.getSearchResultItemsList()) {
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
  public final UnaryCallable<SearchIndexEndpointRequest, SearchIndexEndpointResponse>
      searchIndexEndpointCallable() {
    return stub.searchIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
   *   String indexEndpointId = "indexEndpointId-250889214";
   *   IndexEndpoint response =
   *       warehouseClient.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project}/locations/{location}`
   * @param indexEndpoint Required. The resource being created.
   * @param indexEndpointId Optional. The ID to use for the IndexEndpoint, which will become the
   *     final component of the IndexEndpoint's resource name if the user specifies it. Otherwise,
   *     IndexEndpoint id will be autogenerated.
   *     <p>This value should be up to 63 characters, and valid characters are a-z, 0-9 and dash
   *     (-). The first character must be a letter, the last must be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, CreateIndexEndpointMetadata> createIndexEndpointAsync(
      LocationName parent, IndexEndpoint indexEndpoint, String indexEndpointId) {
    CreateIndexEndpointRequest request =
        CreateIndexEndpointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIndexEndpoint(indexEndpoint)
            .setIndexEndpointId(indexEndpointId)
            .build();
    return createIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
   *   String indexEndpointId = "indexEndpointId-250889214";
   *   IndexEndpoint response =
   *       warehouseClient.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project}/locations/{location}`
   * @param indexEndpoint Required. The resource being created.
   * @param indexEndpointId Optional. The ID to use for the IndexEndpoint, which will become the
   *     final component of the IndexEndpoint's resource name if the user specifies it. Otherwise,
   *     IndexEndpoint id will be autogenerated.
   *     <p>This value should be up to 63 characters, and valid characters are a-z, 0-9 and dash
   *     (-). The first character must be a letter, the last must be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, CreateIndexEndpointMetadata> createIndexEndpointAsync(
      String parent, IndexEndpoint indexEndpoint, String indexEndpointId) {
    CreateIndexEndpointRequest request =
        CreateIndexEndpointRequest.newBuilder()
            .setParent(parent)
            .setIndexEndpoint(indexEndpoint)
            .setIndexEndpointId(indexEndpointId)
            .build();
    return createIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateIndexEndpointRequest request =
   *       CreateIndexEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndexEndpointId("indexEndpointId-250889214")
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .build();
   *   IndexEndpoint response = warehouseClient.createIndexEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, CreateIndexEndpointMetadata> createIndexEndpointAsync(
      CreateIndexEndpointRequest request) {
    return createIndexEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateIndexEndpointRequest request =
   *       CreateIndexEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndexEndpointId("indexEndpointId-250889214")
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .build();
   *   OperationFuture<IndexEndpoint, CreateIndexEndpointMetadata> future =
   *       warehouseClient.createIndexEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   IndexEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointMetadata>
      createIndexEndpointOperationCallable() {
    return stub.createIndexEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateIndexEndpointRequest request =
   *       CreateIndexEndpointRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIndexEndpointId("indexEndpointId-250889214")
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       warehouseClient.createIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    return stub.createIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   IndexEndpoint response = warehouseClient.getIndexEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the IndexEndpoint resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint getIndexEndpoint(IndexEndpointName name) {
    GetIndexEndpointRequest request =
        GetIndexEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIndexEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   IndexEndpoint response = warehouseClient.getIndexEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the IndexEndpoint resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint getIndexEndpoint(String name) {
    GetIndexEndpointRequest request = GetIndexEndpointRequest.newBuilder().setName(name).build();
    return getIndexEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetIndexEndpointRequest request =
   *       GetIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   IndexEndpoint response = warehouseClient.getIndexEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IndexEndpoint getIndexEndpoint(GetIndexEndpointRequest request) {
    return getIndexEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetIndexEndpointRequest request =
   *       GetIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<IndexEndpoint> future =
   *       warehouseClient.getIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   IndexEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    return stub.getIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all IndexEndpoints in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (IndexEndpoint element : warehouseClient.listIndexEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexEndpointsPagedResponse listIndexEndpoints(LocationName parent) {
    ListIndexEndpointsRequest request =
        ListIndexEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIndexEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all IndexEndpoints in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (IndexEndpoint element : warehouseClient.listIndexEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexEndpointsPagedResponse listIndexEndpoints(String parent) {
    ListIndexEndpointsRequest request =
        ListIndexEndpointsRequest.newBuilder().setParent(parent).build();
    return listIndexEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all IndexEndpoints in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListIndexEndpointsRequest request =
   *       ListIndexEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (IndexEndpoint element : warehouseClient.listIndexEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexEndpointsPagedResponse listIndexEndpoints(
      ListIndexEndpointsRequest request) {
    return listIndexEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all IndexEndpoints in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListIndexEndpointsRequest request =
   *       ListIndexEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<IndexEndpoint> future =
   *       warehouseClient.listIndexEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IndexEndpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    return stub.listIndexEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all IndexEndpoints in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListIndexEndpointsRequest request =
   *       ListIndexEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListIndexEndpointsResponse response =
   *         warehouseClient.listIndexEndpointsCallable().call(request);
   *     for (IndexEndpoint element : response.getIndexEndpointsList()) {
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
  public final UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    return stub.listIndexEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IndexEndpoint response =
   *       warehouseClient.updateIndexEndpointAsync(indexEndpoint, updateMask).get();
   * }
   * }</pre>
   *
   * @param indexEndpoint Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     IndexEndpoint resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field of the resource will be overwritten if it is
   *     in the mask. Empty field mask is not allowed. If the mask is "&#42;", then this is a full
   *     replacement of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, UpdateIndexEndpointMetadata> updateIndexEndpointAsync(
      IndexEndpoint indexEndpoint, FieldMask updateMask) {
    UpdateIndexEndpointRequest request =
        UpdateIndexEndpointRequest.newBuilder()
            .setIndexEndpoint(indexEndpoint)
            .setUpdateMask(updateMask)
            .build();
    return updateIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateIndexEndpointRequest request =
   *       UpdateIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IndexEndpoint response = warehouseClient.updateIndexEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IndexEndpoint, UpdateIndexEndpointMetadata> updateIndexEndpointAsync(
      UpdateIndexEndpointRequest request) {
    return updateIndexEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateIndexEndpointRequest request =
   *       UpdateIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<IndexEndpoint, UpdateIndexEndpointMetadata> future =
   *       warehouseClient.updateIndexEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   IndexEndpoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateIndexEndpointRequest, IndexEndpoint, UpdateIndexEndpointMetadata>
      updateIndexEndpointOperationCallable() {
    return stub.updateIndexEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateIndexEndpointRequest request =
   *       UpdateIndexEndpointRequest.newBuilder()
   *           .setIndexEndpoint(IndexEndpoint.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       warehouseClient.updateIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIndexEndpointRequest, Operation> updateIndexEndpointCallable() {
    return stub.updateIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
   *   warehouseClient.deleteIndexEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIndexEndpointMetadata> deleteIndexEndpointAsync(
      IndexEndpointName name) {
    DeleteIndexEndpointRequest request =
        DeleteIndexEndpointRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString();
   *   warehouseClient.deleteIndexEndpointAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIndexEndpointMetadata> deleteIndexEndpointAsync(
      String name) {
    DeleteIndexEndpointRequest request =
        DeleteIndexEndpointRequest.newBuilder().setName(name).build();
    return deleteIndexEndpointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteIndexEndpointRequest request =
   *       DeleteIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   warehouseClient.deleteIndexEndpointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIndexEndpointMetadata> deleteIndexEndpointAsync(
      DeleteIndexEndpointRequest request) {
    return deleteIndexEndpointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteIndexEndpointRequest request =
   *       DeleteIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteIndexEndpointMetadata> future =
   *       warehouseClient.deleteIndexEndpointOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteIndexEndpointMetadata>
      deleteIndexEndpointOperationCallable() {
    return stub.deleteIndexEndpointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteIndexEndpointRequest request =
   *       DeleteIndexEndpointRequest.newBuilder()
   *           .setName(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       warehouseClient.deleteIndexEndpointCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    return stub.deleteIndexEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index to IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeployIndexRequest request =
   *       DeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   DeployIndexResponse response = warehouseClient.deployIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIndexResponse, DeployIndexMetadata> deployIndexAsync(
      DeployIndexRequest request) {
    return deployIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index to IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeployIndexRequest request =
   *       DeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   OperationFuture<DeployIndexResponse, DeployIndexMetadata> future =
   *       warehouseClient.deployIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployIndexResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexMetadata>
      deployIndexOperationCallable() {
    return stub.deployIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an Index to IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeployIndexRequest request =
   *       DeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .setDeployedIndex(DeployedIndex.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.deployIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    return stub.deployIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UndeployIndexRequest request =
   *       UndeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   UndeployIndexResponse response = warehouseClient.undeployIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIndexResponse, UndeployIndexMetadata> undeployIndexAsync(
      UndeployIndexRequest request) {
    return undeployIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UndeployIndexRequest request =
   *       UndeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   OperationFuture<UndeployIndexResponse, UndeployIndexMetadata> future =
   *       warehouseClient.undeployIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeployIndexResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeployIndexRequest, UndeployIndexResponse, UndeployIndexMetadata>
      undeployIndexOperationCallable() {
    return stub.undeployIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an Index from IndexEndpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UndeployIndexRequest request =
   *       UndeployIndexRequest.newBuilder()
   *           .setIndexEndpoint(
   *               IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.undeployIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    return stub.undeployIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   Collection collection = Collection.newBuilder().build();
   *   String collectionId = "collectionId1636075609";
   *   Collection response =
   *       warehouseClient.createCollectionAsync(parent, collection, collectionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this collection will be created. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @param collection Required. The collection resource to be created.
   * @param collectionId Optional. The ID to use for the collection, which will become the final
   *     component of the resource name if user choose to specify. Otherwise, collection id will be
   *     generated by system.
   *     <p>This value should be up to 55 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collection, CreateCollectionMetadata> createCollectionAsync(
      CorpusName parent, Collection collection, String collectionId) {
    CreateCollectionRequest request =
        CreateCollectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCollection(collection)
            .setCollectionId(collectionId)
            .build();
    return createCollectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   Collection collection = Collection.newBuilder().build();
   *   String collectionId = "collectionId1636075609";
   *   Collection response =
   *       warehouseClient.createCollectionAsync(parent, collection, collectionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this collection will be created. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @param collection Required. The collection resource to be created.
   * @param collectionId Optional. The ID to use for the collection, which will become the final
   *     component of the resource name if user choose to specify. Otherwise, collection id will be
   *     generated by system.
   *     <p>This value should be up to 55 characters, and valid characters are /[a-z][0-9]-/. The
   *     first character must be a letter, the last could be a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collection, CreateCollectionMetadata> createCollectionAsync(
      String parent, Collection collection, String collectionId) {
    CreateCollectionRequest request =
        CreateCollectionRequest.newBuilder()
            .setParent(parent)
            .setCollection(collection)
            .setCollectionId(collectionId)
            .build();
    return createCollectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateCollectionRequest request =
   *       CreateCollectionRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setCollection(Collection.newBuilder().build())
   *           .setCollectionId("collectionId1636075609")
   *           .build();
   *   Collection response = warehouseClient.createCollectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collection, CreateCollectionMetadata> createCollectionAsync(
      CreateCollectionRequest request) {
    return createCollectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateCollectionRequest request =
   *       CreateCollectionRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setCollection(Collection.newBuilder().build())
   *           .setCollectionId("collectionId1636075609")
   *           .build();
   *   OperationFuture<Collection, CreateCollectionMetadata> future =
   *       warehouseClient.createCollectionOperationCallable().futureCall(request);
   *   // Do something.
   *   Collection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCollectionRequest, Collection, CreateCollectionMetadata>
      createCollectionOperationCallable() {
    return stub.createCollectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CreateCollectionRequest request =
   *       CreateCollectionRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setCollection(Collection.newBuilder().build())
   *           .setCollectionId("collectionId1636075609")
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.createCollectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable() {
    return stub.createCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CollectionName name =
   *       CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
   *   warehouseClient.deleteCollectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the collection to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCollectionMetadata> deleteCollectionAsync(
      CollectionName name) {
    DeleteCollectionRequest request =
        DeleteCollectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCollectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *           .toString();
   *   warehouseClient.deleteCollectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the collection to delete. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCollectionMetadata> deleteCollectionAsync(String name) {
    DeleteCollectionRequest request = DeleteCollectionRequest.newBuilder().setName(name).build();
    return deleteCollectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteCollectionRequest request =
   *       DeleteCollectionRequest.newBuilder()
   *           .setName(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .build();
   *   warehouseClient.deleteCollectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCollectionMetadata> deleteCollectionAsync(
      DeleteCollectionRequest request) {
    return deleteCollectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteCollectionRequest request =
   *       DeleteCollectionRequest.newBuilder()
   *           .setName(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteCollectionMetadata> future =
   *       warehouseClient.deleteCollectionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationCallable() {
    return stub.deleteCollectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   DeleteCollectionRequest request =
   *       DeleteCollectionRequest.newBuilder()
   *           .setName(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = warehouseClient.deleteCollectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    return stub.deleteCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CollectionName name =
   *       CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
   *   Collection response = warehouseClient.getCollection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the collection to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collection getCollection(CollectionName name) {
    GetCollectionRequest request =
        GetCollectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String name =
   *       CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *           .toString();
   *   Collection response = warehouseClient.getCollection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the collection to retrieve. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collection getCollection(String name) {
    GetCollectionRequest request = GetCollectionRequest.newBuilder().setName(name).build();
    return getCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetCollectionRequest request =
   *       GetCollectionRequest.newBuilder()
   *           .setName(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .build();
   *   Collection response = warehouseClient.getCollection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collection getCollection(GetCollectionRequest request) {
    return getCollectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   GetCollectionRequest request =
   *       GetCollectionRequest.newBuilder()
   *           .setName(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Collection> future = warehouseClient.getCollectionCallable().futureCall(request);
   *   // Do something.
   *   Collection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable() {
    return stub.getCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   Collection collection = Collection.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Collection response = warehouseClient.updateCollection(collection, updateMask);
   * }
   * }</pre>
   *
   * @param collection Required. The collection to update.
   *     <p>The collection's `name` field is used to identify the collection to be updated. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @param updateMask The list of fields to be updated. - Unset `update_mask` or set `update_mask`
   *     to be a single "&#42;" only will update all updatable fields with the value provided in
   *     `collection`. - To update `display_name` value to empty string, set it in the `collection`
   *     to empty string, and set `update_mask` with "display_name". Same applies to other updatable
   *     string fields in the `collection`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collection updateCollection(Collection collection, FieldMask updateMask) {
    UpdateCollectionRequest request =
        UpdateCollectionRequest.newBuilder()
            .setCollection(collection)
            .setUpdateMask(updateMask)
            .build();
    return updateCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateCollectionRequest request =
   *       UpdateCollectionRequest.newBuilder()
   *           .setCollection(Collection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Collection response = warehouseClient.updateCollection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collection updateCollection(UpdateCollectionRequest request) {
    return updateCollectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   UpdateCollectionRequest request =
   *       UpdateCollectionRequest.newBuilder()
   *           .setCollection(Collection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Collection> future = warehouseClient.updateCollectionCallable().futureCall(request);
   *   // Do something.
   *   Collection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCollectionRequest, Collection> updateCollectionCallable() {
    return stub.updateCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists collections inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
   *   for (Collection element : warehouseClient.listCollections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent corpus. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionsPagedResponse listCollections(CorpusName parent) {
    ListCollectionsRequest request =
        ListCollectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCollections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists collections inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString();
   *   for (Collection element : warehouseClient.listCollections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent corpus. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionsPagedResponse listCollections(String parent) {
    ListCollectionsRequest request = ListCollectionsRequest.newBuilder().setParent(parent).build();
    return listCollections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists collections inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListCollectionsRequest request =
   *       ListCollectionsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Collection element : warehouseClient.listCollections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionsPagedResponse listCollections(ListCollectionsRequest request) {
    return listCollectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists collections inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListCollectionsRequest request =
   *       ListCollectionsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Collection> future =
   *       warehouseClient.listCollectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Collection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable() {
    return stub.listCollectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists collections inside a corpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ListCollectionsRequest request =
   *       ListCollectionsRequest.newBuilder()
   *           .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCollectionsResponse response = warehouseClient.listCollectionsCallable().call(request);
   *     for (Collection element : response.getCollectionsList()) {
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
  public final UnaryCallable<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsCallable() {
    return stub.listCollectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an item into a Collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CollectionItem item = CollectionItem.newBuilder().build();
   *   AddCollectionItemResponse response = warehouseClient.addCollectionItem(item);
   * }
   * }</pre>
   *
   * @param item Required. The item to be added.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddCollectionItemResponse addCollectionItem(CollectionItem item) {
    AddCollectionItemRequest request = AddCollectionItemRequest.newBuilder().setItem(item).build();
    return addCollectionItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an item into a Collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AddCollectionItemRequest request =
   *       AddCollectionItemRequest.newBuilder()
   *           .setItem(CollectionItem.newBuilder().build())
   *           .build();
   *   AddCollectionItemResponse response = warehouseClient.addCollectionItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddCollectionItemResponse addCollectionItem(AddCollectionItemRequest request) {
    return addCollectionItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an item into a Collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   AddCollectionItemRequest request =
   *       AddCollectionItemRequest.newBuilder()
   *           .setItem(CollectionItem.newBuilder().build())
   *           .build();
   *   ApiFuture<AddCollectionItemResponse> future =
   *       warehouseClient.addCollectionItemCallable().futureCall(request);
   *   // Do something.
   *   AddCollectionItemResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddCollectionItemRequest, AddCollectionItemResponse>
      addCollectionItemCallable() {
    return stub.addCollectionItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an item from a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CollectionItem item = CollectionItem.newBuilder().build();
   *   RemoveCollectionItemResponse response = warehouseClient.removeCollectionItem(item);
   * }
   * }</pre>
   *
   * @param item Required. The item to be removed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveCollectionItemResponse removeCollectionItem(CollectionItem item) {
    RemoveCollectionItemRequest request =
        RemoveCollectionItemRequest.newBuilder().setItem(item).build();
    return removeCollectionItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an item from a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   RemoveCollectionItemRequest request =
   *       RemoveCollectionItemRequest.newBuilder()
   *           .setItem(CollectionItem.newBuilder().build())
   *           .build();
   *   RemoveCollectionItemResponse response = warehouseClient.removeCollectionItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveCollectionItemResponse removeCollectionItem(
      RemoveCollectionItemRequest request) {
    return removeCollectionItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an item from a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   RemoveCollectionItemRequest request =
   *       RemoveCollectionItemRequest.newBuilder()
   *           .setItem(CollectionItem.newBuilder().build())
   *           .build();
   *   ApiFuture<RemoveCollectionItemResponse> future =
   *       warehouseClient.removeCollectionItemCallable().futureCall(request);
   *   // Do something.
   *   RemoveCollectionItemResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveCollectionItemRequest, RemoveCollectionItemResponse>
      removeCollectionItemCallable() {
    return stub.removeCollectionItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View items inside a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   CollectionName collection =
   *       CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
   *   for (CollectionItem element : warehouseClient.viewCollectionItems(collection).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param collection Required. The collection to view. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewCollectionItemsPagedResponse viewCollectionItems(CollectionName collection) {
    ViewCollectionItemsRequest request =
        ViewCollectionItemsRequest.newBuilder()
            .setCollection(collection == null ? null : collection.toString())
            .build();
    return viewCollectionItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View items inside a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   String collection =
   *       CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *           .toString();
   *   for (CollectionItem element : warehouseClient.viewCollectionItems(collection).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param collection Required. The collection to view. Format:
   *     `projects/{project_number}/locations/{location}/corpora/{corpus}/collections/{collection}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewCollectionItemsPagedResponse viewCollectionItems(String collection) {
    ViewCollectionItemsRequest request =
        ViewCollectionItemsRequest.newBuilder().setCollection(collection).build();
    return viewCollectionItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View items inside a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ViewCollectionItemsRequest request =
   *       ViewCollectionItemsRequest.newBuilder()
   *           .setCollection(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CollectionItem element : warehouseClient.viewCollectionItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ViewCollectionItemsPagedResponse viewCollectionItems(
      ViewCollectionItemsRequest request) {
    return viewCollectionItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View items inside a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ViewCollectionItemsRequest request =
   *       ViewCollectionItemsRequest.newBuilder()
   *           .setCollection(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CollectionItem> future =
   *       warehouseClient.viewCollectionItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CollectionItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsPagedResponse>
      viewCollectionItemsPagedCallable() {
    return stub.viewCollectionItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * View items inside a collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
   *   ViewCollectionItemsRequest request =
   *       ViewCollectionItemsRequest.newBuilder()
   *           .setCollection(
   *               CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ViewCollectionItemsResponse response =
   *         warehouseClient.viewCollectionItemsCallable().call(request);
   *     for (CollectionItem element : response.getItemsList()) {
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
  public final UnaryCallable<ViewCollectionItemsRequest, ViewCollectionItemsResponse>
      viewCollectionItemsCallable() {
    return stub.viewCollectionItemsCallable();
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

  public static class ListAssetsPagedResponse
      extends AbstractPagedListResponse<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    public static ApiFuture<ListAssetsPagedResponse> createAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      ApiFuture<ListAssetsPage> futurePage =
          ListAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAssetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAssetsPagedResponse(ListAssetsPage page) {
      super(page, ListAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssetsPage
      extends AbstractPage<ListAssetsRequest, ListAssetsResponse, Asset, ListAssetsPage> {

    private ListAssetsPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      super(context, response);
    }

    private static ListAssetsPage createEmptyPage() {
      return new ListAssetsPage(null, null);
    }

    @Override
    protected ListAssetsPage createPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      return new ListAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssetsPage> createPageAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    private ListAssetsFixedSizeCollection(List<ListAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssetsFixedSizeCollection createEmptyCollection() {
      return new ListAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssetsFixedSizeCollection createCollection(
        List<ListAssetsPage> pages, int collectionSize) {
      return new ListAssetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ViewIndexedAssetsPagedResponse
      extends AbstractPagedListResponse<
          ViewIndexedAssetsRequest,
          ViewIndexedAssetsResponse,
          IndexedAsset,
          ViewIndexedAssetsPage,
          ViewIndexedAssetsFixedSizeCollection> {

    public static ApiFuture<ViewIndexedAssetsPagedResponse> createAsync(
        PageContext<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset> context,
        ApiFuture<ViewIndexedAssetsResponse> futureResponse) {
      ApiFuture<ViewIndexedAssetsPage> futurePage =
          ViewIndexedAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ViewIndexedAssetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ViewIndexedAssetsPagedResponse(ViewIndexedAssetsPage page) {
      super(page, ViewIndexedAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ViewIndexedAssetsPage
      extends AbstractPage<
          ViewIndexedAssetsRequest,
          ViewIndexedAssetsResponse,
          IndexedAsset,
          ViewIndexedAssetsPage> {

    private ViewIndexedAssetsPage(
        PageContext<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset> context,
        ViewIndexedAssetsResponse response) {
      super(context, response);
    }

    private static ViewIndexedAssetsPage createEmptyPage() {
      return new ViewIndexedAssetsPage(null, null);
    }

    @Override
    protected ViewIndexedAssetsPage createPage(
        PageContext<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset> context,
        ViewIndexedAssetsResponse response) {
      return new ViewIndexedAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ViewIndexedAssetsPage> createPageAsync(
        PageContext<ViewIndexedAssetsRequest, ViewIndexedAssetsResponse, IndexedAsset> context,
        ApiFuture<ViewIndexedAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ViewIndexedAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ViewIndexedAssetsRequest,
          ViewIndexedAssetsResponse,
          IndexedAsset,
          ViewIndexedAssetsPage,
          ViewIndexedAssetsFixedSizeCollection> {

    private ViewIndexedAssetsFixedSizeCollection(
        List<ViewIndexedAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ViewIndexedAssetsFixedSizeCollection createEmptyCollection() {
      return new ViewIndexedAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ViewIndexedAssetsFixedSizeCollection createCollection(
        List<ViewIndexedAssetsPage> pages, int collectionSize) {
      return new ViewIndexedAssetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIndexesPagedResponse
      extends AbstractPagedListResponse<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    public static ApiFuture<ListIndexesPagedResponse> createAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      ApiFuture<ListIndexesPage> futurePage =
          ListIndexesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListIndexesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListIndexesPagedResponse(ListIndexesPage page) {
      super(page, ListIndexesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexesPage
      extends AbstractPage<ListIndexesRequest, ListIndexesResponse, Index, ListIndexesPage> {

    private ListIndexesPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      super(context, response);
    }

    private static ListIndexesPage createEmptyPage() {
      return new ListIndexesPage(null, null);
    }

    @Override
    protected ListIndexesPage createPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      return new ListIndexesPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexesPage> createPageAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    private ListIndexesFixedSizeCollection(List<ListIndexesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexesFixedSizeCollection createEmptyCollection() {
      return new ListIndexesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexesFixedSizeCollection createCollection(
        List<ListIndexesPage> pages, int collectionSize) {
      return new ListIndexesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCorporaPagedResponse
      extends AbstractPagedListResponse<
          ListCorporaRequest,
          ListCorporaResponse,
          Corpus,
          ListCorporaPage,
          ListCorporaFixedSizeCollection> {

    public static ApiFuture<ListCorporaPagedResponse> createAsync(
        PageContext<ListCorporaRequest, ListCorporaResponse, Corpus> context,
        ApiFuture<ListCorporaResponse> futureResponse) {
      ApiFuture<ListCorporaPage> futurePage =
          ListCorporaPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListCorporaPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListCorporaPagedResponse(ListCorporaPage page) {
      super(page, ListCorporaFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCorporaPage
      extends AbstractPage<ListCorporaRequest, ListCorporaResponse, Corpus, ListCorporaPage> {

    private ListCorporaPage(
        PageContext<ListCorporaRequest, ListCorporaResponse, Corpus> context,
        ListCorporaResponse response) {
      super(context, response);
    }

    private static ListCorporaPage createEmptyPage() {
      return new ListCorporaPage(null, null);
    }

    @Override
    protected ListCorporaPage createPage(
        PageContext<ListCorporaRequest, ListCorporaResponse, Corpus> context,
        ListCorporaResponse response) {
      return new ListCorporaPage(context, response);
    }

    @Override
    public ApiFuture<ListCorporaPage> createPageAsync(
        PageContext<ListCorporaRequest, ListCorporaResponse, Corpus> context,
        ApiFuture<ListCorporaResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCorporaFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCorporaRequest,
          ListCorporaResponse,
          Corpus,
          ListCorporaPage,
          ListCorporaFixedSizeCollection> {

    private ListCorporaFixedSizeCollection(List<ListCorporaPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCorporaFixedSizeCollection createEmptyCollection() {
      return new ListCorporaFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCorporaFixedSizeCollection createCollection(
        List<ListCorporaPage> pages, int collectionSize) {
      return new ListCorporaFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListDataSchemasRequest,
          ListDataSchemasResponse,
          DataSchema,
          ListDataSchemasPage,
          ListDataSchemasFixedSizeCollection> {

    public static ApiFuture<ListDataSchemasPagedResponse> createAsync(
        PageContext<ListDataSchemasRequest, ListDataSchemasResponse, DataSchema> context,
        ApiFuture<ListDataSchemasResponse> futureResponse) {
      ApiFuture<ListDataSchemasPage> futurePage =
          ListDataSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataSchemasPagedResponse(ListDataSchemasPage page) {
      super(page, ListDataSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataSchemasPage
      extends AbstractPage<
          ListDataSchemasRequest, ListDataSchemasResponse, DataSchema, ListDataSchemasPage> {

    private ListDataSchemasPage(
        PageContext<ListDataSchemasRequest, ListDataSchemasResponse, DataSchema> context,
        ListDataSchemasResponse response) {
      super(context, response);
    }

    private static ListDataSchemasPage createEmptyPage() {
      return new ListDataSchemasPage(null, null);
    }

    @Override
    protected ListDataSchemasPage createPage(
        PageContext<ListDataSchemasRequest, ListDataSchemasResponse, DataSchema> context,
        ListDataSchemasResponse response) {
      return new ListDataSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListDataSchemasPage> createPageAsync(
        PageContext<ListDataSchemasRequest, ListDataSchemasResponse, DataSchema> context,
        ApiFuture<ListDataSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataSchemasRequest,
          ListDataSchemasResponse,
          DataSchema,
          ListDataSchemasPage,
          ListDataSchemasFixedSizeCollection> {

    private ListDataSchemasFixedSizeCollection(
        List<ListDataSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataSchemasFixedSizeCollection createEmptyCollection() {
      return new ListDataSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataSchemasFixedSizeCollection createCollection(
        List<ListDataSchemasPage> pages, int collectionSize) {
      return new ListDataSchemasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnnotationsPagedResponse
      extends AbstractPagedListResponse<
          ListAnnotationsRequest,
          ListAnnotationsResponse,
          Annotation,
          ListAnnotationsPage,
          ListAnnotationsFixedSizeCollection> {

    public static ApiFuture<ListAnnotationsPagedResponse> createAsync(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ApiFuture<ListAnnotationsResponse> futureResponse) {
      ApiFuture<ListAnnotationsPage> futurePage =
          ListAnnotationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnnotationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnnotationsPagedResponse(ListAnnotationsPage page) {
      super(page, ListAnnotationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnnotationsPage
      extends AbstractPage<
          ListAnnotationsRequest, ListAnnotationsResponse, Annotation, ListAnnotationsPage> {

    private ListAnnotationsPage(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ListAnnotationsResponse response) {
      super(context, response);
    }

    private static ListAnnotationsPage createEmptyPage() {
      return new ListAnnotationsPage(null, null);
    }

    @Override
    protected ListAnnotationsPage createPage(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ListAnnotationsResponse response) {
      return new ListAnnotationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnnotationsPage> createPageAsync(
        PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> context,
        ApiFuture<ListAnnotationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnnotationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnnotationsRequest,
          ListAnnotationsResponse,
          Annotation,
          ListAnnotationsPage,
          ListAnnotationsFixedSizeCollection> {

    private ListAnnotationsFixedSizeCollection(
        List<ListAnnotationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnnotationsFixedSizeCollection createEmptyCollection() {
      return new ListAnnotationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnnotationsFixedSizeCollection createCollection(
        List<ListAnnotationsPage> pages, int collectionSize) {
      return new ListAnnotationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSearchConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListSearchConfigsRequest,
          ListSearchConfigsResponse,
          SearchConfig,
          ListSearchConfigsPage,
          ListSearchConfigsFixedSizeCollection> {

    public static ApiFuture<ListSearchConfigsPagedResponse> createAsync(
        PageContext<ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig> context,
        ApiFuture<ListSearchConfigsResponse> futureResponse) {
      ApiFuture<ListSearchConfigsPage> futurePage =
          ListSearchConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSearchConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSearchConfigsPagedResponse(ListSearchConfigsPage page) {
      super(page, ListSearchConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSearchConfigsPage
      extends AbstractPage<
          ListSearchConfigsRequest,
          ListSearchConfigsResponse,
          SearchConfig,
          ListSearchConfigsPage> {

    private ListSearchConfigsPage(
        PageContext<ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig> context,
        ListSearchConfigsResponse response) {
      super(context, response);
    }

    private static ListSearchConfigsPage createEmptyPage() {
      return new ListSearchConfigsPage(null, null);
    }

    @Override
    protected ListSearchConfigsPage createPage(
        PageContext<ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig> context,
        ListSearchConfigsResponse response) {
      return new ListSearchConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListSearchConfigsPage> createPageAsync(
        PageContext<ListSearchConfigsRequest, ListSearchConfigsResponse, SearchConfig> context,
        ApiFuture<ListSearchConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSearchConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSearchConfigsRequest,
          ListSearchConfigsResponse,
          SearchConfig,
          ListSearchConfigsPage,
          ListSearchConfigsFixedSizeCollection> {

    private ListSearchConfigsFixedSizeCollection(
        List<ListSearchConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSearchConfigsFixedSizeCollection createEmptyCollection() {
      return new ListSearchConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSearchConfigsFixedSizeCollection createCollection(
        List<ListSearchConfigsPage> pages, int collectionSize) {
      return new ListSearchConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSearchHypernymsPagedResponse
      extends AbstractPagedListResponse<
          ListSearchHypernymsRequest,
          ListSearchHypernymsResponse,
          SearchHypernym,
          ListSearchHypernymsPage,
          ListSearchHypernymsFixedSizeCollection> {

    public static ApiFuture<ListSearchHypernymsPagedResponse> createAsync(
        PageContext<ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>
            context,
        ApiFuture<ListSearchHypernymsResponse> futureResponse) {
      ApiFuture<ListSearchHypernymsPage> futurePage =
          ListSearchHypernymsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSearchHypernymsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSearchHypernymsPagedResponse(ListSearchHypernymsPage page) {
      super(page, ListSearchHypernymsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSearchHypernymsPage
      extends AbstractPage<
          ListSearchHypernymsRequest,
          ListSearchHypernymsResponse,
          SearchHypernym,
          ListSearchHypernymsPage> {

    private ListSearchHypernymsPage(
        PageContext<ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>
            context,
        ListSearchHypernymsResponse response) {
      super(context, response);
    }

    private static ListSearchHypernymsPage createEmptyPage() {
      return new ListSearchHypernymsPage(null, null);
    }

    @Override
    protected ListSearchHypernymsPage createPage(
        PageContext<ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>
            context,
        ListSearchHypernymsResponse response) {
      return new ListSearchHypernymsPage(context, response);
    }

    @Override
    public ApiFuture<ListSearchHypernymsPage> createPageAsync(
        PageContext<ListSearchHypernymsRequest, ListSearchHypernymsResponse, SearchHypernym>
            context,
        ApiFuture<ListSearchHypernymsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSearchHypernymsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSearchHypernymsRequest,
          ListSearchHypernymsResponse,
          SearchHypernym,
          ListSearchHypernymsPage,
          ListSearchHypernymsFixedSizeCollection> {

    private ListSearchHypernymsFixedSizeCollection(
        List<ListSearchHypernymsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSearchHypernymsFixedSizeCollection createEmptyCollection() {
      return new ListSearchHypernymsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSearchHypernymsFixedSizeCollection createCollection(
        List<ListSearchHypernymsPage> pages, int collectionSize) {
      return new ListSearchHypernymsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAssetsPagedResponse
      extends AbstractPagedListResponse<
          SearchAssetsRequest,
          SearchAssetsResponse,
          SearchResultItem,
          SearchAssetsPage,
          SearchAssetsFixedSizeCollection> {

    public static ApiFuture<SearchAssetsPagedResponse> createAsync(
        PageContext<SearchAssetsRequest, SearchAssetsResponse, SearchResultItem> context,
        ApiFuture<SearchAssetsResponse> futureResponse) {
      ApiFuture<SearchAssetsPage> futurePage =
          SearchAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchAssetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchAssetsPagedResponse(SearchAssetsPage page) {
      super(page, SearchAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAssetsPage
      extends AbstractPage<
          SearchAssetsRequest, SearchAssetsResponse, SearchResultItem, SearchAssetsPage> {

    private SearchAssetsPage(
        PageContext<SearchAssetsRequest, SearchAssetsResponse, SearchResultItem> context,
        SearchAssetsResponse response) {
      super(context, response);
    }

    private static SearchAssetsPage createEmptyPage() {
      return new SearchAssetsPage(null, null);
    }

    @Override
    protected SearchAssetsPage createPage(
        PageContext<SearchAssetsRequest, SearchAssetsResponse, SearchResultItem> context,
        SearchAssetsResponse response) {
      return new SearchAssetsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAssetsPage> createPageAsync(
        PageContext<SearchAssetsRequest, SearchAssetsResponse, SearchResultItem> context,
        ApiFuture<SearchAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAssetsRequest,
          SearchAssetsResponse,
          SearchResultItem,
          SearchAssetsPage,
          SearchAssetsFixedSizeCollection> {

    private SearchAssetsFixedSizeCollection(List<SearchAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAssetsFixedSizeCollection createEmptyCollection() {
      return new SearchAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAssetsFixedSizeCollection createCollection(
        List<SearchAssetsPage> pages, int collectionSize) {
      return new SearchAssetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchIndexEndpointPagedResponse
      extends AbstractPagedListResponse<
          SearchIndexEndpointRequest,
          SearchIndexEndpointResponse,
          SearchResultItem,
          SearchIndexEndpointPage,
          SearchIndexEndpointFixedSizeCollection> {

    public static ApiFuture<SearchIndexEndpointPagedResponse> createAsync(
        PageContext<SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>
            context,
        ApiFuture<SearchIndexEndpointResponse> futureResponse) {
      ApiFuture<SearchIndexEndpointPage> futurePage =
          SearchIndexEndpointPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchIndexEndpointPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchIndexEndpointPagedResponse(SearchIndexEndpointPage page) {
      super(page, SearchIndexEndpointFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchIndexEndpointPage
      extends AbstractPage<
          SearchIndexEndpointRequest,
          SearchIndexEndpointResponse,
          SearchResultItem,
          SearchIndexEndpointPage> {

    private SearchIndexEndpointPage(
        PageContext<SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>
            context,
        SearchIndexEndpointResponse response) {
      super(context, response);
    }

    private static SearchIndexEndpointPage createEmptyPage() {
      return new SearchIndexEndpointPage(null, null);
    }

    @Override
    protected SearchIndexEndpointPage createPage(
        PageContext<SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>
            context,
        SearchIndexEndpointResponse response) {
      return new SearchIndexEndpointPage(context, response);
    }

    @Override
    public ApiFuture<SearchIndexEndpointPage> createPageAsync(
        PageContext<SearchIndexEndpointRequest, SearchIndexEndpointResponse, SearchResultItem>
            context,
        ApiFuture<SearchIndexEndpointResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchIndexEndpointFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchIndexEndpointRequest,
          SearchIndexEndpointResponse,
          SearchResultItem,
          SearchIndexEndpointPage,
          SearchIndexEndpointFixedSizeCollection> {

    private SearchIndexEndpointFixedSizeCollection(
        List<SearchIndexEndpointPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchIndexEndpointFixedSizeCollection createEmptyCollection() {
      return new SearchIndexEndpointFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchIndexEndpointFixedSizeCollection createCollection(
        List<SearchIndexEndpointPage> pages, int collectionSize) {
      return new SearchIndexEndpointFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIndexEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListIndexEndpointsRequest,
          ListIndexEndpointsResponse,
          IndexEndpoint,
          ListIndexEndpointsPage,
          ListIndexEndpointsFixedSizeCollection> {

    public static ApiFuture<ListIndexEndpointsPagedResponse> createAsync(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ApiFuture<ListIndexEndpointsResponse> futureResponse) {
      ApiFuture<ListIndexEndpointsPage> futurePage =
          ListIndexEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIndexEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIndexEndpointsPagedResponse(ListIndexEndpointsPage page) {
      super(page, ListIndexEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexEndpointsPage
      extends AbstractPage<
          ListIndexEndpointsRequest,
          ListIndexEndpointsResponse,
          IndexEndpoint,
          ListIndexEndpointsPage> {

    private ListIndexEndpointsPage(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ListIndexEndpointsResponse response) {
      super(context, response);
    }

    private static ListIndexEndpointsPage createEmptyPage() {
      return new ListIndexEndpointsPage(null, null);
    }

    @Override
    protected ListIndexEndpointsPage createPage(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ListIndexEndpointsResponse response) {
      return new ListIndexEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexEndpointsPage> createPageAsync(
        PageContext<ListIndexEndpointsRequest, ListIndexEndpointsResponse, IndexEndpoint> context,
        ApiFuture<ListIndexEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexEndpointsRequest,
          ListIndexEndpointsResponse,
          IndexEndpoint,
          ListIndexEndpointsPage,
          ListIndexEndpointsFixedSizeCollection> {

    private ListIndexEndpointsFixedSizeCollection(
        List<ListIndexEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListIndexEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexEndpointsFixedSizeCollection createCollection(
        List<ListIndexEndpointsPage> pages, int collectionSize) {
      return new ListIndexEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCollectionsPagedResponse
      extends AbstractPagedListResponse<
          ListCollectionsRequest,
          ListCollectionsResponse,
          Collection,
          ListCollectionsPage,
          ListCollectionsFixedSizeCollection> {

    public static ApiFuture<ListCollectionsPagedResponse> createAsync(
        PageContext<ListCollectionsRequest, ListCollectionsResponse, Collection> context,
        ApiFuture<ListCollectionsResponse> futureResponse) {
      ApiFuture<ListCollectionsPage> futurePage =
          ListCollectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCollectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCollectionsPagedResponse(ListCollectionsPage page) {
      super(page, ListCollectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCollectionsPage
      extends AbstractPage<
          ListCollectionsRequest, ListCollectionsResponse, Collection, ListCollectionsPage> {

    private ListCollectionsPage(
        PageContext<ListCollectionsRequest, ListCollectionsResponse, Collection> context,
        ListCollectionsResponse response) {
      super(context, response);
    }

    private static ListCollectionsPage createEmptyPage() {
      return new ListCollectionsPage(null, null);
    }

    @Override
    protected ListCollectionsPage createPage(
        PageContext<ListCollectionsRequest, ListCollectionsResponse, Collection> context,
        ListCollectionsResponse response) {
      return new ListCollectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListCollectionsPage> createPageAsync(
        PageContext<ListCollectionsRequest, ListCollectionsResponse, Collection> context,
        ApiFuture<ListCollectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCollectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCollectionsRequest,
          ListCollectionsResponse,
          Collection,
          ListCollectionsPage,
          ListCollectionsFixedSizeCollection> {

    private ListCollectionsFixedSizeCollection(
        List<ListCollectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCollectionsFixedSizeCollection createEmptyCollection() {
      return new ListCollectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCollectionsFixedSizeCollection createCollection(
        List<ListCollectionsPage> pages, int collectionSize) {
      return new ListCollectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ViewCollectionItemsPagedResponse
      extends AbstractPagedListResponse<
          ViewCollectionItemsRequest,
          ViewCollectionItemsResponse,
          CollectionItem,
          ViewCollectionItemsPage,
          ViewCollectionItemsFixedSizeCollection> {

    public static ApiFuture<ViewCollectionItemsPagedResponse> createAsync(
        PageContext<ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>
            context,
        ApiFuture<ViewCollectionItemsResponse> futureResponse) {
      ApiFuture<ViewCollectionItemsPage> futurePage =
          ViewCollectionItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ViewCollectionItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ViewCollectionItemsPagedResponse(ViewCollectionItemsPage page) {
      super(page, ViewCollectionItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ViewCollectionItemsPage
      extends AbstractPage<
          ViewCollectionItemsRequest,
          ViewCollectionItemsResponse,
          CollectionItem,
          ViewCollectionItemsPage> {

    private ViewCollectionItemsPage(
        PageContext<ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>
            context,
        ViewCollectionItemsResponse response) {
      super(context, response);
    }

    private static ViewCollectionItemsPage createEmptyPage() {
      return new ViewCollectionItemsPage(null, null);
    }

    @Override
    protected ViewCollectionItemsPage createPage(
        PageContext<ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>
            context,
        ViewCollectionItemsResponse response) {
      return new ViewCollectionItemsPage(context, response);
    }

    @Override
    public ApiFuture<ViewCollectionItemsPage> createPageAsync(
        PageContext<ViewCollectionItemsRequest, ViewCollectionItemsResponse, CollectionItem>
            context,
        ApiFuture<ViewCollectionItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ViewCollectionItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ViewCollectionItemsRequest,
          ViewCollectionItemsResponse,
          CollectionItem,
          ViewCollectionItemsPage,
          ViewCollectionItemsFixedSizeCollection> {

    private ViewCollectionItemsFixedSizeCollection(
        List<ViewCollectionItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ViewCollectionItemsFixedSizeCollection createEmptyCollection() {
      return new ViewCollectionItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ViewCollectionItemsFixedSizeCollection createCollection(
        List<ViewCollectionItemsPage> pages, int collectionSize) {
      return new ViewCollectionItemsFixedSizeCollection(pages, collectionSize);
    }
  }
}
