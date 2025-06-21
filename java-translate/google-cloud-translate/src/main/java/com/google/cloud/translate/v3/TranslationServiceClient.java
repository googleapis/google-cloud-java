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

package com.google.cloud.translate.v3;

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
import com.google.cloud.translate.v3.stub.TranslationServiceStub;
import com.google.cloud.translate.v3.stub.TranslationServiceStubSettings;
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
 * Service Description: Provides natural language translation operations.
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
 * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String targetLanguageCode = "targetLanguageCode-106414698";
 *   List<String> contents = new ArrayList<>();
 *   TranslateTextResponse response =
 *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TranslationServiceClient object to clean up resources
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
 *      <td><p> TranslateText</td>
 *      <td><p> Translates input text and returns translated text.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> translateText(TranslateTextRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> translateText(LocationName parent, String targetLanguageCode, List&lt;String&gt; contents)
 *           <li><p> translateText(String parent, String targetLanguageCode, List&lt;String&gt; contents)
 *           <li><p> translateText(LocationName parent, String model, String mimeType, String sourceLanguageCode, String targetLanguageCode, List&lt;String&gt; contents)
 *           <li><p> translateText(String parent, String model, String mimeType, String sourceLanguageCode, String targetLanguageCode, List&lt;String&gt; contents)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> translateTextCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RomanizeText</td>
 *      <td><p> Romanize input text written in non-Latin scripts to Latin text.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> romanizeText(RomanizeTextRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> romanizeText(LocationName parent, List&lt;String&gt; contents)
 *           <li><p> romanizeText(String parent, List&lt;String&gt; contents)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> romanizeTextCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DetectLanguage</td>
 *      <td><p> Detects the language of text within a request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> detectLanguage(DetectLanguageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> detectLanguage(LocationName parent, String model, String mimeType, String content)
 *           <li><p> detectLanguage(String parent, String model, String mimeType, String content)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> detectLanguageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSupportedLanguages</td>
 *      <td><p> Returns a list of supported languages for translation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSupportedLanguages(GetSupportedLanguagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSupportedLanguages(LocationName parent, String model, String displayLanguageCode)
 *           <li><p> getSupportedLanguages(String parent, String model, String displayLanguageCode)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSupportedLanguagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TranslateDocument</td>
 *      <td><p> Translates documents in synchronous mode.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> translateDocument(TranslateDocumentRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> translateDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchTranslateText</td>
 *      <td><p> Translates a large volume of text in asynchronous batch mode. This function provides real-time output as the inputs are being processed. If caller cancels a request, the partial results (for an input file, it's all or nothing) may still be available on the specified output location.
 * <p>  This call returns immediately and you can use google.longrunning.Operation.name to poll the status of the call.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchTranslateTextAsync(BatchTranslateTextRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchTranslateTextOperationCallable()
 *           <li><p> batchTranslateTextCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchTranslateDocument</td>
 *      <td><p> Translates a large volume of document in asynchronous batch mode. This function provides real-time output as the inputs are being processed. If caller cancels a request, the partial results (for an input file, it's all or nothing) may still be available on the specified output location.
 * <p>  This call returns immediately and you can use google.longrunning.Operation.name to poll the status of the call.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchTranslateDocumentAsync(BatchTranslateDocumentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> batchTranslateDocumentAsync(LocationName parent, String sourceLanguageCode, List&lt;String&gt; targetLanguageCodes, List&lt;BatchDocumentInputConfig&gt; inputConfigs, BatchDocumentOutputConfig outputConfig)
 *           <li><p> batchTranslateDocumentAsync(String parent, String sourceLanguageCode, List&lt;String&gt; targetLanguageCodes, List&lt;BatchDocumentInputConfig&gt; inputConfigs, BatchDocumentOutputConfig outputConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchTranslateDocumentOperationCallable()
 *           <li><p> batchTranslateDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGlossary</td>
 *      <td><p> Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project doesn't exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGlossaryAsync(CreateGlossaryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGlossaryAsync(LocationName parent, Glossary glossary)
 *           <li><p> createGlossaryAsync(String parent, Glossary glossary)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGlossaryOperationCallable()
 *           <li><p> createGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGlossary</td>
 *      <td><p> Updates a glossary. A LRO is used since the update can be async if the glossary's entry file is updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGlossaryAsync(UpdateGlossaryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryAsync(Glossary glossary, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryOperationCallable()
 *           <li><p> updateGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGlossaries</td>
 *      <td><p> Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGlossaries(ListGlossariesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGlossaries(LocationName parent)
 *           <li><p> listGlossaries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGlossariesPagedCallable()
 *           <li><p> listGlossariesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGlossary</td>
 *      <td><p> Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGlossary(GetGlossaryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGlossary(GlossaryName name)
 *           <li><p> getGlossary(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGlossary</td>
 *      <td><p> Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns NOT_FOUND, if the glossary doesn't exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGlossaryAsync(DeleteGlossaryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryAsync(GlossaryName name)
 *           <li><p> deleteGlossaryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryOperationCallable()
 *           <li><p> deleteGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGlossaryEntry</td>
 *      <td><p> Gets a single glossary entry by the given id.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGlossaryEntry(GetGlossaryEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGlossaryEntry(GlossaryEntryName name)
 *           <li><p> getGlossaryEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGlossaryEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGlossaryEntries</td>
 *      <td><p> List the entries for the glossary.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGlossaryEntries(ListGlossaryEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGlossaryEntries(GlossaryName parent)
 *           <li><p> listGlossaryEntries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGlossaryEntriesPagedCallable()
 *           <li><p> listGlossaryEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGlossaryEntry</td>
 *      <td><p> Creates a glossary entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGlossaryEntry(CreateGlossaryEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createGlossaryEntry(GlossaryName parent, GlossaryEntry glossaryEntry)
 *           <li><p> createGlossaryEntry(String parent, GlossaryEntry glossaryEntry)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGlossaryEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGlossaryEntry</td>
 *      <td><p> Updates a glossary entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGlossaryEntry(UpdateGlossaryEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGlossaryEntry(GlossaryEntry glossaryEntry)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGlossaryEntry</td>
 *      <td><p> Deletes a single entry from the glossary</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGlossaryEntry(DeleteGlossaryEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteGlossaryEntry(GlossaryEntryName name)
 *           <li><p> deleteGlossaryEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataset</td>
 *      <td><p> Creates a Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatasetAsync(CreateDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatasetAsync(LocationName parent, Dataset dataset)
 *           <li><p> createDatasetAsync(String parent, Dataset dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatasetOperationCallable()
 *           <li><p> createDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataset</td>
 *      <td><p> Gets a Dataset.</td>
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
 *      <td><p> ListDatasets</td>
 *      <td><p> Lists datasets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatasets(ListDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatasets(LocationName parent)
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
 *      <td><p> DeleteDataset</td>
 *      <td><p> Deletes a dataset and all of its contents.</td>
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
 *      <td><p> CreateAdaptiveMtDataset</td>
 *      <td><p> Creates an Adaptive MT dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAdaptiveMtDataset(CreateAdaptiveMtDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAdaptiveMtDataset(LocationName parent, AdaptiveMtDataset adaptiveMtDataset)
 *           <li><p> createAdaptiveMtDataset(String parent, AdaptiveMtDataset adaptiveMtDataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAdaptiveMtDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAdaptiveMtDataset</td>
 *      <td><p> Deletes an Adaptive MT dataset, including all its entries and associated metadata.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAdaptiveMtDataset(DeleteAdaptiveMtDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAdaptiveMtDataset(AdaptiveMtDatasetName name)
 *           <li><p> deleteAdaptiveMtDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAdaptiveMtDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAdaptiveMtDataset</td>
 *      <td><p> Gets the Adaptive MT dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdaptiveMtDataset(GetAdaptiveMtDatasetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdaptiveMtDataset(AdaptiveMtDatasetName name)
 *           <li><p> getAdaptiveMtDataset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdaptiveMtDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdaptiveMtDatasets</td>
 *      <td><p> Lists all Adaptive MT datasets for which the caller has read permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtDatasets(ListAdaptiveMtDatasetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtDatasets(LocationName parent)
 *           <li><p> listAdaptiveMtDatasets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtDatasetsPagedCallable()
 *           <li><p> listAdaptiveMtDatasetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AdaptiveMtTranslate</td>
 *      <td><p> Translate text using Adaptive MT.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> adaptiveMtTranslate(AdaptiveMtTranslateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> adaptiveMtTranslate(LocationName parent, List&lt;String&gt; content)
 *           <li><p> adaptiveMtTranslate(String parent, List&lt;String&gt; content)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> adaptiveMtTranslateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAdaptiveMtFile</td>
 *      <td><p> Gets and AdaptiveMtFile</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdaptiveMtFile(GetAdaptiveMtFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdaptiveMtFile(AdaptiveMtFileName name)
 *           <li><p> getAdaptiveMtFile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdaptiveMtFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAdaptiveMtFile</td>
 *      <td><p> Deletes an AdaptiveMtFile along with its sentences.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAdaptiveMtFile(DeleteAdaptiveMtFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAdaptiveMtFile(AdaptiveMtFileName name)
 *           <li><p> deleteAdaptiveMtFile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAdaptiveMtFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportAdaptiveMtFile</td>
 *      <td><p> Imports an AdaptiveMtFile and adds all of its sentences into the AdaptiveMtDataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importAdaptiveMtFile(ImportAdaptiveMtFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importAdaptiveMtFile(AdaptiveMtDatasetName parent)
 *           <li><p> importAdaptiveMtFile(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importAdaptiveMtFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdaptiveMtFiles</td>
 *      <td><p> Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtFiles(ListAdaptiveMtFilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtFiles(AdaptiveMtDatasetName parent)
 *           <li><p> listAdaptiveMtFiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtFilesPagedCallable()
 *           <li><p> listAdaptiveMtFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdaptiveMtSentences</td>
 *      <td><p> Lists all AdaptiveMtSentences under a given file/dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtSentences(ListAdaptiveMtSentencesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtSentences(AdaptiveMtFileName parent)
 *           <li><p> listAdaptiveMtSentences(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdaptiveMtSentencesPagedCallable()
 *           <li><p> listAdaptiveMtSentencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportData</td>
 *      <td><p> Import sentence pairs into translation Dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importDataAsync(ImportDataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importDataAsync(String dataset, DatasetInputConfig inputConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importDataOperationCallable()
 *           <li><p> importDataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportData</td>
 *      <td><p> Exports dataset's data to the provided output location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportDataAsync(ExportDataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportDataAsync(String dataset, DatasetOutputConfig outputConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportDataOperationCallable()
 *           <li><p> exportDataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExamples</td>
 *      <td><p> Lists sentence pairs in the dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExamples(ListExamplesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExamples(DatasetName parent)
 *           <li><p> listExamples(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExamplesPagedCallable()
 *           <li><p> listExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateModel</td>
 *      <td><p> Creates a Model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createModelAsync(CreateModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createModelAsync(LocationName parent, Model model)
 *           <li><p> createModelAsync(String parent, Model model)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createModelOperationCallable()
 *           <li><p> createModelCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TranslationServiceSettings to
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newHttpJsonBuilder().build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TranslationServiceClient implements BackgroundResource {
  private final TranslationServiceSettings settings;
  private final TranslationServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TranslationServiceClient with default settings. */
  public static final TranslationServiceClient create() throws IOException {
    return create(TranslationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TranslationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TranslationServiceClient create(TranslationServiceSettings settings)
      throws IOException {
    return new TranslationServiceClient(settings);
  }

  /**
   * Constructs an instance of TranslationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TranslationServiceSettings).
   */
  public static final TranslationServiceClient create(TranslationServiceStub stub) {
    return new TranslationServiceClient(stub);
  }

  /**
   * Constructs an instance of TranslationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TranslationServiceClient(TranslationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TranslationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TranslationServiceClient(TranslationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TranslationServiceSettings getSettings() {
    return settings;
  }

  public TranslationServiceStub getStub() {
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
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param targetLanguageCode Required. The ISO-639 language code to use for translation of the
   *     input text, set to one of the language codes listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages).
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30,000 codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      LocationName parent, String targetLanguageCode, List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param targetLanguageCode Required. The ISO-639 language code to use for translation of the
   *     input text, set to one of the language codes listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages).
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30,000 codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      String parent, String targetLanguageCode, List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent)
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(
   *           parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The `model` type requested for this translation.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>- Translation LLM models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/translation-llm`,
   *     <p>For global (non-regionalized) requests, use `location-id` `global`. For example,
   *     `projects/{project-number-or-id}/locations/global/models/general/nmt`.
   *     <p>If not provided, the default Google model (NMT) will be used
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param sourceLanguageCode Optional. The ISO-639 language code of the input text if known, for
   *     example, "en-US" or "sr-Latn". Supported language codes are listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages). If the source language isn't
   *     specified, the API attempts to identify the source language automatically and returns the
   *     source language within the response.
   * @param targetLanguageCode Required. The ISO-639 language code to use for translation of the
   *     input text, set to one of the language codes listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages).
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30,000 codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      LocationName parent,
      String model,
      String mimeType,
      String sourceLanguageCode,
      String targetLanguageCode,
      List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setMimeType(mimeType)
            .setSourceLanguageCode(sourceLanguageCode)
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(
   *           parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The `model` type requested for this translation.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>- Translation LLM models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/translation-llm`,
   *     <p>For global (non-regionalized) requests, use `location-id` `global`. For example,
   *     `projects/{project-number-or-id}/locations/global/models/general/nmt`.
   *     <p>If not provided, the default Google model (NMT) will be used
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param sourceLanguageCode Optional. The ISO-639 language code of the input text if known, for
   *     example, "en-US" or "sr-Latn". Supported language codes are listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages). If the source language isn't
   *     specified, the API attempts to identify the source language automatically and returns the
   *     source language within the response.
   * @param targetLanguageCode Required. The ISO-639 language code to use for translation of the
   *     input text, set to one of the language codes listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages).
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30,000 codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      String parent,
      String model,
      String mimeType,
      String sourceLanguageCode,
      String targetLanguageCode,
      List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setMimeType(mimeType)
            .setSourceLanguageCode(sourceLanguageCode)
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateTextRequest request =
   *       TranslateTextRequest.newBuilder()
   *           .addAllContents(new ArrayList<String>())
   *           .setMimeType("mimeType-1392120434")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .setTransliterationConfig(TransliterationConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   TranslateTextResponse response = translationServiceClient.translateText(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(TranslateTextRequest request) {
    return translateTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateTextRequest request =
   *       TranslateTextRequest.newBuilder()
   *           .addAllContents(new ArrayList<String>())
   *           .setMimeType("mimeType-1392120434")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .setTransliterationConfig(TransliterationConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<TranslateTextResponse> future =
   *       translationServiceClient.translateTextCallable().futureCall(request);
   *   // Do something.
   *   TranslateTextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable() {
    return stub.translateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Romanize input text written in non-Latin scripts to Latin text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<String> contents = new ArrayList<>();
   *   RomanizeTextResponse response = translationServiceClient.romanizeText(parent, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}` or
   *     `projects/{project-number-or-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   * @param contents Required. The content of the input in string format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RomanizeTextResponse romanizeText(LocationName parent, List<String> contents) {
    RomanizeTextRequest request =
        RomanizeTextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllContents(contents)
            .build();
    return romanizeText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Romanize input text written in non-Latin scripts to Latin text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<String> contents = new ArrayList<>();
   *   RomanizeTextResponse response = translationServiceClient.romanizeText(parent, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}` or
   *     `projects/{project-number-or-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   * @param contents Required. The content of the input in string format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RomanizeTextResponse romanizeText(String parent, List<String> contents) {
    RomanizeTextRequest request =
        RomanizeTextRequest.newBuilder().setParent(parent).addAllContents(contents).build();
    return romanizeText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Romanize input text written in non-Latin scripts to Latin text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   RomanizeTextRequest request =
   *       RomanizeTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllContents(new ArrayList<String>())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .build();
   *   RomanizeTextResponse response = translationServiceClient.romanizeText(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RomanizeTextResponse romanizeText(RomanizeTextRequest request) {
    return romanizeTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Romanize input text written in non-Latin scripts to Latin text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   RomanizeTextRequest request =
   *       RomanizeTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllContents(new ArrayList<String>())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .build();
   *   ApiFuture<RomanizeTextResponse> future =
   *       translationServiceClient.romanizeTextCallable().futureCall(request);
   *   // Do something.
   *   RomanizeTextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RomanizeTextRequest, RomanizeTextResponse> romanizeTextCallable() {
    return stub.romanizeTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String content = "content951530617";
   *   DetectLanguageResponse response =
   *       translationServiceClient.detectLanguage(parent, model, mimeType, content);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}` or
   *     `projects/{project-number-or-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Only models within the same region (has same location-id) can be used. Otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The language detection model to be used.
   *     <p>Format:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/{model-id}`
   *     <p>Only one language detection model is currently supported:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/default`.
   *     <p>If not specified, the default model is used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param content The content of the input stored as a string.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(
      LocationName parent, String model, String mimeType, String content) {
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setMimeType(mimeType)
            .setContent(content)
            .build();
    return detectLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String content = "content951530617";
   *   DetectLanguageResponse response =
   *       translationServiceClient.detectLanguage(parent, model, mimeType, content);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}` or
   *     `projects/{project-number-or-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Only models within the same region (has same location-id) can be used. Otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The language detection model to be used.
   *     <p>Format:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/{model-id}`
   *     <p>Only one language detection model is currently supported:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/default`.
   *     <p>If not specified, the default model is used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param content The content of the input stored as a string.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(
      String parent, String model, String mimeType, String content) {
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setMimeType(mimeType)
            .setContent(content)
            .build();
    return detectLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DetectLanguageRequest request =
   *       DetectLanguageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setMimeType("mimeType-1392120434")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   DetectLanguageResponse response = translationServiceClient.detectLanguage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(DetectLanguageRequest request) {
    return detectLanguageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DetectLanguageRequest request =
   *       DetectLanguageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setMimeType("mimeType-1392120434")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<DetectLanguageResponse> future =
   *       translationServiceClient.detectLanguageCallable().futureCall(request);
   *   // Do something.
   *   DetectLanguageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageCallable() {
    return stub.detectLanguageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String displayLanguageCode = "displayLanguageCode-1457478841";
   *   SupportedLanguages response =
   *       translationServiceClient.getSupportedLanguages(parent, model, displayLanguageCode);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for AutoML models.
   *     <p>Only models within the same region (have same location-id) can be used, otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. Get supported languages of this model.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general NMT model.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, then display names are not returned in a
   *     response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      LocationName parent, String model, String displayLanguageCode) {
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setDisplayLanguageCode(displayLanguageCode)
            .build();
    return getSupportedLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String displayLanguageCode = "displayLanguageCode-1457478841";
   *   SupportedLanguages response =
   *       translationServiceClient.getSupportedLanguages(parent, model, displayLanguageCode);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for AutoML models.
   *     <p>Only models within the same region (have same location-id) can be used, otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. Get supported languages of this model.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general NMT model.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, then display names are not returned in a
   *     response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      String parent, String model, String displayLanguageCode) {
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setDisplayLanguageCode(displayLanguageCode)
            .build();
    return getSupportedLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetSupportedLanguagesRequest request =
   *       GetSupportedLanguagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayLanguageCode("displayLanguageCode-1457478841")
   *           .setModel("model104069929")
   *           .build();
   *   SupportedLanguages response = translationServiceClient.getSupportedLanguages(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(GetSupportedLanguagesRequest request) {
    return getSupportedLanguagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetSupportedLanguagesRequest request =
   *       GetSupportedLanguagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayLanguageCode("displayLanguageCode-1457478841")
   *           .setModel("model104069929")
   *           .build();
   *   ApiFuture<SupportedLanguages> future =
   *       translationServiceClient.getSupportedLanguagesCallable().futureCall(request);
   *   // Do something.
   *   SupportedLanguages response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesCallable() {
    return stub.getSupportedLanguagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates documents in synchronous mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateDocumentRequest request =
   *       TranslateDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setDocumentInputConfig(DocumentInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .setCustomizedAttribution("customizedAttribution557650238")
   *           .setIsTranslateNativePdfOnly(true)
   *           .setEnableShadowRemovalNativePdf(true)
   *           .setEnableRotationCorrection(true)
   *           .build();
   *   TranslateDocumentResponse response = translationServiceClient.translateDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateDocumentResponse translateDocument(TranslateDocumentRequest request) {
    return translateDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates documents in synchronous mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateDocumentRequest request =
   *       TranslateDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setDocumentInputConfig(DocumentInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .setCustomizedAttribution("customizedAttribution557650238")
   *           .setIsTranslateNativePdfOnly(true)
   *           .setEnableShadowRemovalNativePdf(true)
   *           .setEnableRotationCorrection(true)
   *           .build();
   *   ApiFuture<TranslateDocumentResponse> future =
   *       translationServiceClient.translateDocumentCallable().futureCall(request);
   *   // Do something.
   *   TranslateDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentCallable() {
    return stub.translateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of text in asynchronous batch mode. This function provides real-time
   * output as the inputs are being processed. If caller cancels a request, the partial results (for
   * an input file, it's all or nothing) may still be available on the specified output location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateTextRequest request =
   *       BatchTranslateTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .putAllModels(new HashMap<String, String>())
   *           .addAllInputConfigs(new ArrayList<InputConfig>())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   BatchTranslateResponse response =
   *       translationServiceClient.batchTranslateTextAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextAsync(BatchTranslateTextRequest request) {
    return batchTranslateTextOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of text in asynchronous batch mode. This function provides real-time
   * output as the inputs are being processed. If caller cancels a request, the partial results (for
   * an input file, it's all or nothing) may still be available on the specified output location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateTextRequest request =
   *       BatchTranslateTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .putAllModels(new HashMap<String, String>())
   *           .addAllInputConfigs(new ArrayList<InputConfig>())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<BatchTranslateResponse, BatchTranslateMetadata> future =
   *       translationServiceClient.batchTranslateTextOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchTranslateResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationCallable() {
    return stub.batchTranslateTextOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of text in asynchronous batch mode. This function provides real-time
   * output as the inputs are being processed. If caller cancels a request, the partial results (for
   * an input file, it's all or nothing) may still be available on the specified output location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateTextRequest request =
   *       BatchTranslateTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .putAllModels(new HashMap<String, String>())
   *           .addAllInputConfigs(new ArrayList<InputConfig>())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.batchTranslateTextCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchTranslateTextRequest, Operation> batchTranslateTextCallable() {
    return stub.batchTranslateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   List<String> targetLanguageCodes = new ArrayList<>();
   *   List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
   *   BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();
   *   BatchTranslateDocumentResponse response =
   *       translationServiceClient
   *           .batchTranslateDocumentAsync(
   *               parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Location to make a regional call.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>The `global` location is not supported for batch translation.
   *     <p>Only AutoML Translation models or glossaries within the same region (have the same
   *     location-id) can be used, otherwise an INVALID_ARGUMENT (400) error is returned.
   * @param sourceLanguageCode Required. The ISO-639 language code of the input document if known,
   *     for example, "en-US" or "sr-Latn". Supported language codes are listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages).
   * @param targetLanguageCodes Required. The ISO-639 language code to use for translation of the
   *     input document. Specify up to 10 language codes here. Supported language codes are listed
   *     in [Language Support](https://cloud.google.com/translate/docs/languages).
   * @param inputConfigs Required. Input configurations. The total number of files matched should be
   *     &lt;= 100. The total content size to translate should be &lt;= 100M Unicode codepoints. The
   *     files must use UTF-8 encoding.
   * @param outputConfig Required. Output configuration. If 2 input configs match to the same file
   *     (that is, same input path), we don't generate output for duplicate inputs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata>
      batchTranslateDocumentAsync(
          LocationName parent,
          String sourceLanguageCode,
          List<String> targetLanguageCodes,
          List<BatchDocumentInputConfig> inputConfigs,
          BatchDocumentOutputConfig outputConfig) {
    BatchTranslateDocumentRequest request =
        BatchTranslateDocumentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceLanguageCode(sourceLanguageCode)
            .addAllTargetLanguageCodes(targetLanguageCodes)
            .addAllInputConfigs(inputConfigs)
            .setOutputConfig(outputConfig)
            .build();
    return batchTranslateDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   List<String> targetLanguageCodes = new ArrayList<>();
   *   List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
   *   BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();
   *   BatchTranslateDocumentResponse response =
   *       translationServiceClient
   *           .batchTranslateDocumentAsync(
   *               parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Location to make a regional call.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>The `global` location is not supported for batch translation.
   *     <p>Only AutoML Translation models or glossaries within the same region (have the same
   *     location-id) can be used, otherwise an INVALID_ARGUMENT (400) error is returned.
   * @param sourceLanguageCode Required. The ISO-639 language code of the input document if known,
   *     for example, "en-US" or "sr-Latn". Supported language codes are listed in [Language
   *     Support](https://cloud.google.com/translate/docs/languages).
   * @param targetLanguageCodes Required. The ISO-639 language code to use for translation of the
   *     input document. Specify up to 10 language codes here. Supported language codes are listed
   *     in [Language Support](https://cloud.google.com/translate/docs/languages).
   * @param inputConfigs Required. Input configurations. The total number of files matched should be
   *     &lt;= 100. The total content size to translate should be &lt;= 100M Unicode codepoints. The
   *     files must use UTF-8 encoding.
   * @param outputConfig Required. Output configuration. If 2 input configs match to the same file
   *     (that is, same input path), we don't generate output for duplicate inputs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata>
      batchTranslateDocumentAsync(
          String parent,
          String sourceLanguageCode,
          List<String> targetLanguageCodes,
          List<BatchDocumentInputConfig> inputConfigs,
          BatchDocumentOutputConfig outputConfig) {
    BatchTranslateDocumentRequest request =
        BatchTranslateDocumentRequest.newBuilder()
            .setParent(parent)
            .setSourceLanguageCode(sourceLanguageCode)
            .addAllTargetLanguageCodes(targetLanguageCodes)
            .addAllInputConfigs(inputConfigs)
            .setOutputConfig(outputConfig)
            .build();
    return batchTranslateDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateDocumentRequest request =
   *       BatchTranslateDocumentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .addAllInputConfigs(new ArrayList<BatchDocumentInputConfig>())
   *           .setOutputConfig(BatchDocumentOutputConfig.newBuilder().build())
   *           .putAllModels(new HashMap<String, String>())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllFormatConversions(new HashMap<String, String>())
   *           .setCustomizedAttribution("customizedAttribution557650238")
   *           .setEnableShadowRemovalNativePdf(true)
   *           .setEnableRotationCorrection(true)
   *           .build();
   *   BatchTranslateDocumentResponse response =
   *       translationServiceClient.batchTranslateDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata>
      batchTranslateDocumentAsync(BatchTranslateDocumentRequest request) {
    return batchTranslateDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateDocumentRequest request =
   *       BatchTranslateDocumentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .addAllInputConfigs(new ArrayList<BatchDocumentInputConfig>())
   *           .setOutputConfig(BatchDocumentOutputConfig.newBuilder().build())
   *           .putAllModels(new HashMap<String, String>())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllFormatConversions(new HashMap<String, String>())
   *           .setCustomizedAttribution("customizedAttribution557650238")
   *           .setEnableShadowRemovalNativePdf(true)
   *           .setEnableRotationCorrection(true)
   *           .build();
   *   OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata> future =
   *       translationServiceClient.batchTranslateDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchTranslateDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationCallable() {
    return stub.batchTranslateDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateDocumentRequest request =
   *       BatchTranslateDocumentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .addAllInputConfigs(new ArrayList<BatchDocumentInputConfig>())
   *           .setOutputConfig(BatchDocumentOutputConfig.newBuilder().build())
   *           .putAllModels(new HashMap<String, String>())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllFormatConversions(new HashMap<String, String>())
   *           .setCustomizedAttribution("customizedAttribution557650238")
   *           .setEnableShadowRemovalNativePdf(true)
   *           .setEnableRotationCorrection(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.batchTranslateDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentCallable() {
    return stub.batchTranslateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(parent, glossary).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name.
   * @param glossary Required. The glossary to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      LocationName parent, Glossary glossary) {
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGlossary(glossary)
            .build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Glossary glossary = Glossary.newBuilder().build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(parent, glossary).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name.
   * @param glossary Required. The glossary to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      String parent, Glossary glossary) {
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder().setParent(parent).setGlossary(glossary).build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossary(Glossary.newBuilder().build())
   *           .build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      CreateGlossaryRequest request) {
    return createGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossary(Glossary.newBuilder().build())
   *           .build();
   *   OperationFuture<Glossary, CreateGlossaryMetadata> future =
   *       translationServiceClient.createGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationCallable() {
    return stub.createGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossary(Glossary.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.createGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return stub.createGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary. A LRO is used since the update can be async if the glossary's entry file is
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   Glossary glossary = Glossary.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Glossary response = translationServiceClient.updateGlossaryAsync(glossary, updateMask).get();
   * }
   * }</pre>
   *
   * @param glossary Required. The glossary entry to update.
   * @param updateMask The list of fields to be updated. Currently only `display_name` and
   *     'input_config'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, UpdateGlossaryMetadata> updateGlossaryAsync(
      Glossary glossary, FieldMask updateMask) {
    UpdateGlossaryRequest request =
        UpdateGlossaryRequest.newBuilder().setGlossary(glossary).setUpdateMask(updateMask).build();
    return updateGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary. A LRO is used since the update can be async if the glossary's entry file is
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   UpdateGlossaryRequest request =
   *       UpdateGlossaryRequest.newBuilder()
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Glossary response = translationServiceClient.updateGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, UpdateGlossaryMetadata> updateGlossaryAsync(
      UpdateGlossaryRequest request) {
    return updateGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary. A LRO is used since the update can be async if the glossary's entry file is
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   UpdateGlossaryRequest request =
   *       UpdateGlossaryRequest.newBuilder()
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Glossary, UpdateGlossaryMetadata> future =
   *       translationServiceClient.updateGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGlossaryRequest, Glossary, UpdateGlossaryMetadata>
      updateGlossaryOperationCallable() {
    return stub.updateGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary. A LRO is used since the update can be async if the glossary's entry file is
   * updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   UpdateGlossaryRequest request =
   *       UpdateGlossaryRequest.newBuilder()
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.updateGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable() {
    return stub.updateGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Glossary element : translationServiceClient.listGlossaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(LocationName parent) {
    ListGlossariesRequest request =
        ListGlossariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Glossary element : translationServiceClient.listGlossaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(String parent) {
    ListGlossariesRequest request = ListGlossariesRequest.newBuilder().setParent(parent).build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Glossary element : translationServiceClient.listGlossaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(ListGlossariesRequest request) {
    return listGlossariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Glossary> future =
   *       translationServiceClient.listGlossariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Glossary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    return stub.listGlossariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListGlossariesResponse response =
   *         translationServiceClient.listGlossariesCallable().call(request);
   *     for (Glossary element : response.getGlossariesList()) {
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
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesCallable() {
    return stub.listGlossariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   Glossary response = translationServiceClient.getGlossary(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GlossaryName name) {
    GetGlossaryRequest request =
        GetGlossaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   Glossary response = translationServiceClient.getGlossary(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(String name) {
    GetGlossaryRequest request = GetGlossaryRequest.newBuilder().setName(name).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetGlossaryRequest request =
   *       GetGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   Glossary response = translationServiceClient.getGlossary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GetGlossaryRequest request) {
    return getGlossaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetGlossaryRequest request =
   *       GetGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   ApiFuture<Glossary> future =
   *       translationServiceClient.getGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return stub.getGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      GlossaryName name) {
    DeleteGlossaryRequest request =
        DeleteGlossaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      String name) {
    DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder().setName(name).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      DeleteGlossaryRequest request) {
    return deleteGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> future =
   *       translationServiceClient.deleteGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   DeleteGlossaryResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationCallable() {
    return stub.deleteGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.deleteGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    return stub.deleteGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single glossary entry by the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryEntryName name =
   *       GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]");
   *   GlossaryEntry response = translationServiceClient.getGlossaryEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the glossary entry to get
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry getGlossaryEntry(GlossaryEntryName name) {
    GetGlossaryEntryRequest request =
        GetGlossaryEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single glossary entry by the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name =
   *       GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
   *           .toString();
   *   GlossaryEntry response = translationServiceClient.getGlossaryEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the glossary entry to get
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry getGlossaryEntry(String name) {
    GetGlossaryEntryRequest request = GetGlossaryEntryRequest.newBuilder().setName(name).build();
    return getGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single glossary entry by the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetGlossaryEntryRequest request =
   *       GetGlossaryEntryRequest.newBuilder()
   *           .setName(
   *               GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
   *                   .toString())
   *           .build();
   *   GlossaryEntry response = translationServiceClient.getGlossaryEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry getGlossaryEntry(GetGlossaryEntryRequest request) {
    return getGlossaryEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single glossary entry by the given id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetGlossaryEntryRequest request =
   *       GetGlossaryEntryRequest.newBuilder()
   *           .setName(
   *               GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GlossaryEntry> future =
   *       translationServiceClient.getGlossaryEntryCallable().futureCall(request);
   *   // Do something.
   *   GlossaryEntry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlossaryEntryRequest, GlossaryEntry> getGlossaryEntryCallable() {
    return stub.getGlossaryEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the entries for the glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   for (GlossaryEntry element :
   *       translationServiceClient.listGlossaryEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent glossary resource name for listing the glossary's entries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryEntriesPagedResponse listGlossaryEntries(GlossaryName parent) {
    ListGlossaryEntriesRequest request =
        ListGlossaryEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGlossaryEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the entries for the glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   for (GlossaryEntry element :
   *       translationServiceClient.listGlossaryEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent glossary resource name for listing the glossary's entries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryEntriesPagedResponse listGlossaryEntries(String parent) {
    ListGlossaryEntriesRequest request =
        ListGlossaryEntriesRequest.newBuilder().setParent(parent).build();
    return listGlossaryEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the entries for the glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossaryEntriesRequest request =
   *       ListGlossaryEntriesRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GlossaryEntry element :
   *       translationServiceClient.listGlossaryEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryEntriesPagedResponse listGlossaryEntries(
      ListGlossaryEntriesRequest request) {
    return listGlossaryEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the entries for the glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossaryEntriesRequest request =
   *       ListGlossaryEntriesRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GlossaryEntry> future =
   *       translationServiceClient.listGlossaryEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GlossaryEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossaryEntriesRequest, ListGlossaryEntriesPagedResponse>
      listGlossaryEntriesPagedCallable() {
    return stub.listGlossaryEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the entries for the glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossaryEntriesRequest request =
   *       ListGlossaryEntriesRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGlossaryEntriesResponse response =
   *         translationServiceClient.listGlossaryEntriesCallable().call(request);
   *     for (GlossaryEntry element : response.getGlossaryEntriesList()) {
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
  public final UnaryCallable<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
      listGlossaryEntriesCallable() {
    return stub.listGlossaryEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();
   *   GlossaryEntry response = translationServiceClient.createGlossaryEntry(parent, glossaryEntry);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the glossary to create the entry under.
   * @param glossaryEntry Required. The glossary entry to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry createGlossaryEntry(GlossaryName parent, GlossaryEntry glossaryEntry) {
    CreateGlossaryEntryRequest request =
        CreateGlossaryEntryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGlossaryEntry(glossaryEntry)
            .build();
    return createGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();
   *   GlossaryEntry response = translationServiceClient.createGlossaryEntry(parent, glossaryEntry);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the glossary to create the entry under.
   * @param glossaryEntry Required. The glossary entry to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry createGlossaryEntry(String parent, GlossaryEntry glossaryEntry) {
    CreateGlossaryEntryRequest request =
        CreateGlossaryEntryRequest.newBuilder()
            .setParent(parent)
            .setGlossaryEntry(glossaryEntry)
            .build();
    return createGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryEntryRequest request =
   *       CreateGlossaryEntryRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setGlossaryEntry(GlossaryEntry.newBuilder().build())
   *           .build();
   *   GlossaryEntry response = translationServiceClient.createGlossaryEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry createGlossaryEntry(CreateGlossaryEntryRequest request) {
    return createGlossaryEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryEntryRequest request =
   *       CreateGlossaryEntryRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setGlossaryEntry(GlossaryEntry.newBuilder().build())
   *           .build();
   *   ApiFuture<GlossaryEntry> future =
   *       translationServiceClient.createGlossaryEntryCallable().futureCall(request);
   *   // Do something.
   *   GlossaryEntry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGlossaryEntryRequest, GlossaryEntry>
      createGlossaryEntryCallable() {
    return stub.createGlossaryEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryEntry glossaryEntry = GlossaryEntry.newBuilder().build();
   *   GlossaryEntry response = translationServiceClient.updateGlossaryEntry(glossaryEntry);
   * }
   * }</pre>
   *
   * @param glossaryEntry Required. The glossary entry to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry updateGlossaryEntry(GlossaryEntry glossaryEntry) {
    UpdateGlossaryEntryRequest request =
        UpdateGlossaryEntryRequest.newBuilder().setGlossaryEntry(glossaryEntry).build();
    return updateGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   UpdateGlossaryEntryRequest request =
   *       UpdateGlossaryEntryRequest.newBuilder()
   *           .setGlossaryEntry(GlossaryEntry.newBuilder().build())
   *           .build();
   *   GlossaryEntry response = translationServiceClient.updateGlossaryEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryEntry updateGlossaryEntry(UpdateGlossaryEntryRequest request) {
    return updateGlossaryEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a glossary entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   UpdateGlossaryEntryRequest request =
   *       UpdateGlossaryEntryRequest.newBuilder()
   *           .setGlossaryEntry(GlossaryEntry.newBuilder().build())
   *           .build();
   *   ApiFuture<GlossaryEntry> future =
   *       translationServiceClient.updateGlossaryEntryCallable().futureCall(request);
   *   // Do something.
   *   GlossaryEntry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGlossaryEntryRequest, GlossaryEntry>
      updateGlossaryEntryCallable() {
    return stub.updateGlossaryEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entry from the glossary
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryEntryName name =
   *       GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]");
   *   translationServiceClient.deleteGlossaryEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the glossary entry to delete
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryEntry(GlossaryEntryName name) {
    DeleteGlossaryEntryRequest request =
        DeleteGlossaryEntryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entry from the glossary
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name =
   *       GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
   *           .toString();
   *   translationServiceClient.deleteGlossaryEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the glossary entry to delete
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryEntry(String name) {
    DeleteGlossaryEntryRequest request =
        DeleteGlossaryEntryRequest.newBuilder().setName(name).build();
    deleteGlossaryEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entry from the glossary
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryEntryRequest request =
   *       DeleteGlossaryEntryRequest.newBuilder()
   *           .setName(
   *               GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
   *                   .toString())
   *           .build();
   *   translationServiceClient.deleteGlossaryEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryEntry(DeleteGlossaryEntryRequest request) {
    deleteGlossaryEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single entry from the glossary
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryEntryRequest request =
   *       DeleteGlossaryEntryRequest.newBuilder()
   *           .setName(
   *               GlossaryEntryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_ENTRY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       translationServiceClient.deleteGlossaryEntryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlossaryEntryRequest, Empty> deleteGlossaryEntryCallable() {
    return stub.deleteGlossaryEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = translationServiceClient.createDatasetAsync(parent, dataset).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name.
   * @param dataset Required. The Dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetMetadata> createDatasetAsync(
      LocationName parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataset(dataset)
            .build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Dataset dataset = Dataset.newBuilder().build();
   *   Dataset response = translationServiceClient.createDatasetAsync(parent, dataset).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name.
   * @param dataset Required. The Dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetMetadata> createDatasetAsync(
      String parent, Dataset dataset) {
    CreateDatasetRequest request =
        CreateDatasetRequest.newBuilder().setParent(parent).setDataset(dataset).build();
    return createDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   Dataset response = translationServiceClient.createDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, CreateDatasetMetadata> createDatasetAsync(
      CreateDatasetRequest request) {
    return createDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   OperationFuture<Dataset, CreateDatasetMetadata> future =
   *       translationServiceClient.createDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetMetadata>
      createDatasetOperationCallable() {
    return stub.createDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateDatasetRequest request =
   *       CreateDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(Dataset.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.createDatasetCallable().futureCall(request);
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
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   Dataset response = translationServiceClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(DatasetName name) {
    GetDatasetRequest request =
        GetDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   Dataset response = translationServiceClient.getDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the dataset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dataset getDataset(String name) {
    GetDatasetRequest request = GetDatasetRequest.newBuilder().setName(name).build();
    return getDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   Dataset response = translationServiceClient.getDataset(request);
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
   * Gets a Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetDatasetRequest request =
   *       GetDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Dataset> future = translationServiceClient.getDatasetCallable().futureCall(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Dataset element : translationServiceClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent project. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatasetsPagedResponse listDatasets(LocationName parent) {
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Dataset element : translationServiceClient.listDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent project. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}`
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Dataset element : translationServiceClient.listDatasets(request).iterateAll()) {
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Dataset> future =
   *       translationServiceClient.listDatasetsPagedCallable().futureCall(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListDatasetsRequest request =
   *       ListDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatasetsResponse response =
   *         translationServiceClient.listDatasetsCallable().call(request);
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
   * Deletes a dataset and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   translationServiceClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the dataset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteDatasetMetadata> deleteDatasetAsync(DatasetName name) {
    DeleteDatasetRequest request =
        DeleteDatasetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   translationServiceClient.deleteDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the dataset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteDatasetMetadata> deleteDatasetAsync(String name) {
    DeleteDatasetRequest request = DeleteDatasetRequest.newBuilder().setName(name).build();
    return deleteDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   translationServiceClient.deleteDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteDatasetMetadata> deleteDatasetAsync(
      DeleteDatasetRequest request) {
    return deleteDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteDatasetMetadata> future =
   *       translationServiceClient.deleteDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatasetRequest, Empty, DeleteDatasetMetadata>
      deleteDatasetOperationCallable() {
    return stub.deleteDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a dataset and all of its contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteDatasetRequest request =
   *       DeleteDatasetRequest.newBuilder()
   *           .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.deleteDatasetCallable().futureCall(request);
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
   * Creates an Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AdaptiveMtDataset adaptiveMtDataset = AdaptiveMtDataset.newBuilder().build();
   *   AdaptiveMtDataset response =
   *       translationServiceClient.createAdaptiveMtDataset(parent, adaptiveMtDataset);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent project. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}`
   * @param adaptiveMtDataset Required. The AdaptiveMtDataset to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtDataset createAdaptiveMtDataset(
      LocationName parent, AdaptiveMtDataset adaptiveMtDataset) {
    CreateAdaptiveMtDatasetRequest request =
        CreateAdaptiveMtDatasetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdaptiveMtDataset(adaptiveMtDataset)
            .build();
    return createAdaptiveMtDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AdaptiveMtDataset adaptiveMtDataset = AdaptiveMtDataset.newBuilder().build();
   *   AdaptiveMtDataset response =
   *       translationServiceClient.createAdaptiveMtDataset(parent, adaptiveMtDataset);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent project. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}`
   * @param adaptiveMtDataset Required. The AdaptiveMtDataset to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtDataset createAdaptiveMtDataset(
      String parent, AdaptiveMtDataset adaptiveMtDataset) {
    CreateAdaptiveMtDatasetRequest request =
        CreateAdaptiveMtDatasetRequest.newBuilder()
            .setParent(parent)
            .setAdaptiveMtDataset(adaptiveMtDataset)
            .build();
    return createAdaptiveMtDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateAdaptiveMtDatasetRequest request =
   *       CreateAdaptiveMtDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAdaptiveMtDataset(AdaptiveMtDataset.newBuilder().build())
   *           .build();
   *   AdaptiveMtDataset response = translationServiceClient.createAdaptiveMtDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtDataset createAdaptiveMtDataset(CreateAdaptiveMtDatasetRequest request) {
    return createAdaptiveMtDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateAdaptiveMtDatasetRequest request =
   *       CreateAdaptiveMtDatasetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAdaptiveMtDataset(AdaptiveMtDataset.newBuilder().build())
   *           .build();
   *   ApiFuture<AdaptiveMtDataset> future =
   *       translationServiceClient.createAdaptiveMtDatasetCallable().futureCall(request);
   *   // Do something.
   *   AdaptiveMtDataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetCallable() {
    return stub.createAdaptiveMtDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Adaptive MT dataset, including all its entries and associated metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtDatasetName name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   translationServiceClient.deleteAdaptiveMtDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the dataset. In the form of
   *     `projects/{project-number-or-id}/locations/{location-id}/adaptiveMtDatasets/{adaptive-mt-dataset-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdaptiveMtDataset(AdaptiveMtDatasetName name) {
    DeleteAdaptiveMtDatasetRequest request =
        DeleteAdaptiveMtDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAdaptiveMtDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Adaptive MT dataset, including all its entries and associated metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   translationServiceClient.deleteAdaptiveMtDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the dataset. In the form of
   *     `projects/{project-number-or-id}/locations/{location-id}/adaptiveMtDatasets/{adaptive-mt-dataset-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdaptiveMtDataset(String name) {
    DeleteAdaptiveMtDatasetRequest request =
        DeleteAdaptiveMtDatasetRequest.newBuilder().setName(name).build();
    deleteAdaptiveMtDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Adaptive MT dataset, including all its entries and associated metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteAdaptiveMtDatasetRequest request =
   *       DeleteAdaptiveMtDatasetRequest.newBuilder()
   *           .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   translationServiceClient.deleteAdaptiveMtDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdaptiveMtDataset(DeleteAdaptiveMtDatasetRequest request) {
    deleteAdaptiveMtDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Adaptive MT dataset, including all its entries and associated metadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteAdaptiveMtDatasetRequest request =
   *       DeleteAdaptiveMtDatasetRequest.newBuilder()
   *           .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       translationServiceClient.deleteAdaptiveMtDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetCallable() {
    return stub.deleteAdaptiveMtDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtDatasetName name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   AdaptiveMtDataset response = translationServiceClient.getAdaptiveMtDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the dataset. In the form of
   *     `projects/{project-number-or-id}/locations/{location-id}/adaptiveMtDatasets/{adaptive-mt-dataset-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtDataset getAdaptiveMtDataset(AdaptiveMtDatasetName name) {
    GetAdaptiveMtDatasetRequest request =
        GetAdaptiveMtDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAdaptiveMtDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   AdaptiveMtDataset response = translationServiceClient.getAdaptiveMtDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the dataset. In the form of
   *     `projects/{project-number-or-id}/locations/{location-id}/adaptiveMtDatasets/{adaptive-mt-dataset-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtDataset getAdaptiveMtDataset(String name) {
    GetAdaptiveMtDatasetRequest request =
        GetAdaptiveMtDatasetRequest.newBuilder().setName(name).build();
    return getAdaptiveMtDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetAdaptiveMtDatasetRequest request =
   *       GetAdaptiveMtDatasetRequest.newBuilder()
   *           .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   AdaptiveMtDataset response = translationServiceClient.getAdaptiveMtDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtDataset getAdaptiveMtDataset(GetAdaptiveMtDatasetRequest request) {
    return getAdaptiveMtDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Adaptive MT dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetAdaptiveMtDatasetRequest request =
   *       GetAdaptiveMtDatasetRequest.newBuilder()
   *           .setName(AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<AdaptiveMtDataset> future =
   *       translationServiceClient.getAdaptiveMtDatasetCallable().futureCall(request);
   *   // Do something.
   *   AdaptiveMtDataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetCallable() {
    return stub.getAdaptiveMtDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Adaptive MT datasets for which the caller has read permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AdaptiveMtDataset element :
   *       translationServiceClient.listAdaptiveMtDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list the Adaptive MT
   *     datasets. `projects/{project-number-or-id}/locations/{location-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtDatasetsPagedResponse listAdaptiveMtDatasets(LocationName parent) {
    ListAdaptiveMtDatasetsRequest request =
        ListAdaptiveMtDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdaptiveMtDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Adaptive MT datasets for which the caller has read permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AdaptiveMtDataset element :
   *       translationServiceClient.listAdaptiveMtDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list the Adaptive MT
   *     datasets. `projects/{project-number-or-id}/locations/{location-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtDatasetsPagedResponse listAdaptiveMtDatasets(String parent) {
    ListAdaptiveMtDatasetsRequest request =
        ListAdaptiveMtDatasetsRequest.newBuilder().setParent(parent).build();
    return listAdaptiveMtDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Adaptive MT datasets for which the caller has read permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtDatasetsRequest request =
   *       ListAdaptiveMtDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (AdaptiveMtDataset element :
   *       translationServiceClient.listAdaptiveMtDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtDatasetsPagedResponse listAdaptiveMtDatasets(
      ListAdaptiveMtDatasetsRequest request) {
    return listAdaptiveMtDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Adaptive MT datasets for which the caller has read permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtDatasetsRequest request =
   *       ListAdaptiveMtDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AdaptiveMtDataset> future =
   *       translationServiceClient.listAdaptiveMtDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdaptiveMtDataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsPagedResponse>
      listAdaptiveMtDatasetsPagedCallable() {
    return stub.listAdaptiveMtDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Adaptive MT datasets for which the caller has read permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtDatasetsRequest request =
   *       ListAdaptiveMtDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAdaptiveMtDatasetsResponse response =
   *         translationServiceClient.listAdaptiveMtDatasetsCallable().call(request);
   *     for (AdaptiveMtDataset element : response.getAdaptiveMtDatasetsList()) {
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
  public final UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
      listAdaptiveMtDatasetsCallable() {
    return stub.listAdaptiveMtDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translate text using Adaptive MT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<String> content = new ArrayList<>();
   *   AdaptiveMtTranslateResponse response =
   *       translationServiceClient.adaptiveMtTranslate(parent, content);
   * }
   * }</pre>
   *
   * @param parent Required. Location to make a regional call.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}`.
   * @param content Required. The content of the input in string format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtTranslateResponse adaptiveMtTranslate(
      LocationName parent, List<String> content) {
    AdaptiveMtTranslateRequest request =
        AdaptiveMtTranslateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllContent(content)
            .build();
    return adaptiveMtTranslate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translate text using Adaptive MT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<String> content = new ArrayList<>();
   *   AdaptiveMtTranslateResponse response =
   *       translationServiceClient.adaptiveMtTranslate(parent, content);
   * }
   * }</pre>
   *
   * @param parent Required. Location to make a regional call.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}`.
   * @param content Required. The content of the input in string format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtTranslateResponse adaptiveMtTranslate(
      String parent, List<String> content) {
    AdaptiveMtTranslateRequest request =
        AdaptiveMtTranslateRequest.newBuilder().setParent(parent).addAllContent(content).build();
    return adaptiveMtTranslate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translate text using Adaptive MT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtTranslateRequest request =
   *       AdaptiveMtTranslateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .addAllContent(new ArrayList<String>())
   *           .setReferenceSentenceConfig(
   *               AdaptiveMtTranslateRequest.ReferenceSentenceConfig.newBuilder().build())
   *           .setGlossaryConfig(AdaptiveMtTranslateRequest.GlossaryConfig.newBuilder().build())
   *           .build();
   *   AdaptiveMtTranslateResponse response = translationServiceClient.adaptiveMtTranslate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtTranslateResponse adaptiveMtTranslate(AdaptiveMtTranslateRequest request) {
    return adaptiveMtTranslateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translate text using Adaptive MT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtTranslateRequest request =
   *       AdaptiveMtTranslateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataset(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .addAllContent(new ArrayList<String>())
   *           .setReferenceSentenceConfig(
   *               AdaptiveMtTranslateRequest.ReferenceSentenceConfig.newBuilder().build())
   *           .setGlossaryConfig(AdaptiveMtTranslateRequest.GlossaryConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<AdaptiveMtTranslateResponse> future =
   *       translationServiceClient.adaptiveMtTranslateCallable().futureCall(request);
   *   // Do something.
   *   AdaptiveMtTranslateResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateCallable() {
    return stub.adaptiveMtTranslateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets and AdaptiveMtFile
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtFileName name =
   *       AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");
   *   AdaptiveMtFile response = translationServiceClient.getAdaptiveMtFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the file, in form of
   *     `projects/{project-number-or-id}/locations/{location_id}/adaptiveMtDatasets/{dataset}/adaptiveMtFiles/{file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtFile getAdaptiveMtFile(AdaptiveMtFileName name) {
    GetAdaptiveMtFileRequest request =
        GetAdaptiveMtFileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAdaptiveMtFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets and AdaptiveMtFile
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name =
   *       AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]").toString();
   *   AdaptiveMtFile response = translationServiceClient.getAdaptiveMtFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the file, in form of
   *     `projects/{project-number-or-id}/locations/{location_id}/adaptiveMtDatasets/{dataset}/adaptiveMtFiles/{file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtFile getAdaptiveMtFile(String name) {
    GetAdaptiveMtFileRequest request = GetAdaptiveMtFileRequest.newBuilder().setName(name).build();
    return getAdaptiveMtFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets and AdaptiveMtFile
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetAdaptiveMtFileRequest request =
   *       GetAdaptiveMtFileRequest.newBuilder()
   *           .setName(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .build();
   *   AdaptiveMtFile response = translationServiceClient.getAdaptiveMtFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdaptiveMtFile getAdaptiveMtFile(GetAdaptiveMtFileRequest request) {
    return getAdaptiveMtFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets and AdaptiveMtFile
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetAdaptiveMtFileRequest request =
   *       GetAdaptiveMtFileRequest.newBuilder()
   *           .setName(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AdaptiveMtFile> future =
   *       translationServiceClient.getAdaptiveMtFileCallable().futureCall(request);
   *   // Do something.
   *   AdaptiveMtFile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdaptiveMtFileRequest, AdaptiveMtFile> getAdaptiveMtFileCallable() {
    return stub.getAdaptiveMtFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdaptiveMtFile along with its sentences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtFileName name =
   *       AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");
   *   translationServiceClient.deleteAdaptiveMtFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the file to delete, in form of
   *     `projects/{project-number-or-id}/locations/{location_id}/adaptiveMtDatasets/{dataset}/adaptiveMtFiles/{file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdaptiveMtFile(AdaptiveMtFileName name) {
    DeleteAdaptiveMtFileRequest request =
        DeleteAdaptiveMtFileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAdaptiveMtFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdaptiveMtFile along with its sentences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name =
   *       AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]").toString();
   *   translationServiceClient.deleteAdaptiveMtFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the file to delete, in form of
   *     `projects/{project-number-or-id}/locations/{location_id}/adaptiveMtDatasets/{dataset}/adaptiveMtFiles/{file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdaptiveMtFile(String name) {
    DeleteAdaptiveMtFileRequest request =
        DeleteAdaptiveMtFileRequest.newBuilder().setName(name).build();
    deleteAdaptiveMtFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdaptiveMtFile along with its sentences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteAdaptiveMtFileRequest request =
   *       DeleteAdaptiveMtFileRequest.newBuilder()
   *           .setName(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .build();
   *   translationServiceClient.deleteAdaptiveMtFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdaptiveMtFile(DeleteAdaptiveMtFileRequest request) {
    deleteAdaptiveMtFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an AdaptiveMtFile along with its sentences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteAdaptiveMtFileRequest request =
   *       DeleteAdaptiveMtFileRequest.newBuilder()
   *           .setName(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       translationServiceClient.deleteAdaptiveMtFileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileCallable() {
    return stub.deleteAdaptiveMtFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an AdaptiveMtFile and adds all of its sentences into the AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtDatasetName parent =
   *       AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   ImportAdaptiveMtFileResponse response = translationServiceClient.importAdaptiveMtFile(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the file, in form of
   *     `projects/{project-number-or-id}/locations/{location_id}/adaptiveMtDatasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportAdaptiveMtFileResponse importAdaptiveMtFile(AdaptiveMtDatasetName parent) {
    ImportAdaptiveMtFileRequest request =
        ImportAdaptiveMtFileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return importAdaptiveMtFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an AdaptiveMtFile and adds all of its sentences into the AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   ImportAdaptiveMtFileResponse response = translationServiceClient.importAdaptiveMtFile(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the file, in form of
   *     `projects/{project-number-or-id}/locations/{location_id}/adaptiveMtDatasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportAdaptiveMtFileResponse importAdaptiveMtFile(String parent) {
    ImportAdaptiveMtFileRequest request =
        ImportAdaptiveMtFileRequest.newBuilder().setParent(parent).build();
    return importAdaptiveMtFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an AdaptiveMtFile and adds all of its sentences into the AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ImportAdaptiveMtFileRequest request =
   *       ImportAdaptiveMtFileRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ImportAdaptiveMtFileResponse response =
   *       translationServiceClient.importAdaptiveMtFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportAdaptiveMtFileResponse importAdaptiveMtFile(
      ImportAdaptiveMtFileRequest request) {
    return importAdaptiveMtFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an AdaptiveMtFile and adds all of its sentences into the AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ImportAdaptiveMtFileRequest request =
   *       ImportAdaptiveMtFileRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .build();
   *   ApiFuture<ImportAdaptiveMtFileResponse> future =
   *       translationServiceClient.importAdaptiveMtFileCallable().futureCall(request);
   *   // Do something.
   *   ImportAdaptiveMtFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileCallable() {
    return stub.importAdaptiveMtFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtDatasetName parent =
   *       AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   for (AdaptiveMtFile element :
   *       translationServiceClient.listAdaptiveMtFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list the Adaptive MT
   *     files. `projects/{project}/locations/{location}/adaptiveMtDatasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtFilesPagedResponse listAdaptiveMtFiles(AdaptiveMtDatasetName parent) {
    ListAdaptiveMtFilesRequest request =
        ListAdaptiveMtFilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdaptiveMtFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   for (AdaptiveMtFile element :
   *       translationServiceClient.listAdaptiveMtFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list the Adaptive MT
   *     files. `projects/{project}/locations/{location}/adaptiveMtDatasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtFilesPagedResponse listAdaptiveMtFiles(String parent) {
    ListAdaptiveMtFilesRequest request =
        ListAdaptiveMtFilesRequest.newBuilder().setParent(parent).build();
    return listAdaptiveMtFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtFilesRequest request =
   *       ListAdaptiveMtFilesRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AdaptiveMtFile element :
   *       translationServiceClient.listAdaptiveMtFiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtFilesPagedResponse listAdaptiveMtFiles(
      ListAdaptiveMtFilesRequest request) {
    return listAdaptiveMtFilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtFilesRequest request =
   *       ListAdaptiveMtFilesRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AdaptiveMtFile> future =
   *       translationServiceClient.listAdaptiveMtFilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdaptiveMtFile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesPagedResponse>
      listAdaptiveMtFilesPagedCallable() {
    return stub.listAdaptiveMtFilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtFilesRequest request =
   *       ListAdaptiveMtFilesRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtDatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAdaptiveMtFilesResponse response =
   *         translationServiceClient.listAdaptiveMtFilesCallable().call(request);
   *     for (AdaptiveMtFile element : response.getAdaptiveMtFilesList()) {
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
  public final UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
      listAdaptiveMtFilesCallable() {
    return stub.listAdaptiveMtFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtSentences under a given file/dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   AdaptiveMtFileName parent =
   *       AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]");
   *   for (AdaptiveMtSentence element :
   *       translationServiceClient.listAdaptiveMtSentences(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list the Adaptive MT
   *     files. The following format lists all sentences under a file.
   *     `projects/{project}/locations/{location}/adaptiveMtDatasets/{dataset}/adaptiveMtFiles/{file}`
   *     The following format lists all sentences within a dataset.
   *     `projects/{project}/locations/{location}/adaptiveMtDatasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtSentencesPagedResponse listAdaptiveMtSentences(
      AdaptiveMtFileName parent) {
    ListAdaptiveMtSentencesRequest request =
        ListAdaptiveMtSentencesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdaptiveMtSentences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtSentences under a given file/dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent =
   *       AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]").toString();
   *   for (AdaptiveMtSentence element :
   *       translationServiceClient.listAdaptiveMtSentences(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project from which to list the Adaptive MT
   *     files. The following format lists all sentences under a file.
   *     `projects/{project}/locations/{location}/adaptiveMtDatasets/{dataset}/adaptiveMtFiles/{file}`
   *     The following format lists all sentences within a dataset.
   *     `projects/{project}/locations/{location}/adaptiveMtDatasets/{dataset}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtSentencesPagedResponse listAdaptiveMtSentences(String parent) {
    ListAdaptiveMtSentencesRequest request =
        ListAdaptiveMtSentencesRequest.newBuilder().setParent(parent).build();
    return listAdaptiveMtSentences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtSentences under a given file/dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtSentencesRequest request =
   *       ListAdaptiveMtSentencesRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AdaptiveMtSentence element :
   *       translationServiceClient.listAdaptiveMtSentences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdaptiveMtSentencesPagedResponse listAdaptiveMtSentences(
      ListAdaptiveMtSentencesRequest request) {
    return listAdaptiveMtSentencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtSentences under a given file/dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtSentencesRequest request =
   *       ListAdaptiveMtSentencesRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AdaptiveMtSentence> future =
   *       translationServiceClient.listAdaptiveMtSentencesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdaptiveMtSentence element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesPagedResponse>
      listAdaptiveMtSentencesPagedCallable() {
    return stub.listAdaptiveMtSentencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all AdaptiveMtSentences under a given file/dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListAdaptiveMtSentencesRequest request =
   *       ListAdaptiveMtSentencesRequest.newBuilder()
   *           .setParent(
   *               AdaptiveMtFileName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[FILE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAdaptiveMtSentencesResponse response =
   *         translationServiceClient.listAdaptiveMtSentencesCallable().call(request);
   *     for (AdaptiveMtSentence element : response.getAdaptiveMtSentencesList()) {
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
  public final UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
      listAdaptiveMtSentencesCallable() {
    return stub.listAdaptiveMtSentencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import sentence pairs into translation Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String dataset = "dataset1443214456";
   *   DatasetInputConfig inputConfig = DatasetInputConfig.newBuilder().build();
   *   translationServiceClient.importDataAsync(dataset, inputConfig).get();
   * }
   * }</pre>
   *
   * @param dataset Required. Name of the dataset. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}/datasets/{dataset-id}`
   * @param inputConfig Required. The config for the input content.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportDataMetadata> importDataAsync(
      String dataset, DatasetInputConfig inputConfig) {
    ImportDataRequest request =
        ImportDataRequest.newBuilder().setDataset(dataset).setInputConfig(inputConfig).build();
    return importDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import sentence pairs into translation Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setInputConfig(DatasetInputConfig.newBuilder().build())
   *           .build();
   *   translationServiceClient.importDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportDataMetadata> importDataAsync(
      ImportDataRequest request) {
    return importDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import sentence pairs into translation Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setInputConfig(DatasetInputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, ImportDataMetadata> future =
   *       translationServiceClient.importDataOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportDataRequest, Empty, ImportDataMetadata>
      importDataOperationCallable() {
    return stub.importDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import sentence pairs into translation Dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ImportDataRequest request =
   *       ImportDataRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setInputConfig(DatasetInputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.importDataCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return stub.importDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String dataset = "dataset1443214456";
   *   DatasetOutputConfig outputConfig = DatasetOutputConfig.newBuilder().build();
   *   translationServiceClient.exportDataAsync(dataset, outputConfig).get();
   * }
   * }</pre>
   *
   * @param dataset Required. Name of the dataset. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}/datasets/{dataset-id}`
   * @param outputConfig Required. The config for the output content.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ExportDataMetadata> exportDataAsync(
      String dataset, DatasetOutputConfig outputConfig) {
    ExportDataRequest request =
        ExportDataRequest.newBuilder().setDataset(dataset).setOutputConfig(outputConfig).build();
    return exportDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setOutputConfig(DatasetOutputConfig.newBuilder().build())
   *           .build();
   *   translationServiceClient.exportDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ExportDataMetadata> exportDataAsync(
      ExportDataRequest request) {
    return exportDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setOutputConfig(DatasetOutputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Empty, ExportDataMetadata> future =
   *       translationServiceClient.exportDataOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportDataRequest, Empty, ExportDataMetadata>
      exportDataOperationCallable() {
    return stub.exportDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports dataset's data to the provided output location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ExportDataRequest request =
   *       ExportDataRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setOutputConfig(DatasetOutputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.exportDataCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return stub.exportDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sentence pairs in the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
   *   for (Example element : translationServiceClient.listExamples(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent dataset. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}/datasets/{dataset-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(DatasetName parent) {
    ListExamplesRequest request =
        ListExamplesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sentence pairs in the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString();
   *   for (Example element : translationServiceClient.listExamples(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent dataset. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}/datasets/{dataset-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(String parent) {
    ListExamplesRequest request = ListExamplesRequest.newBuilder().setParent(parent).build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sentence pairs in the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Example element : translationServiceClient.listExamples(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(ListExamplesRequest request) {
    return listExamplesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sentence pairs in the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Example> future =
   *       translationServiceClient.listExamplesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Example element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable() {
    return stub.listExamplesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sentence pairs in the dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListExamplesResponse response =
   *         translationServiceClient.listExamplesCallable().call(request);
   *     for (Example element : response.getExamplesList()) {
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
  public final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return stub.listExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Model model = Model.newBuilder().build();
   *   Model response = translationServiceClient.createModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name, in form of `projects/{project}/locations/{location}`
   * @param model Required. The Model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, CreateModelMetadata> createModelAsync(
      LocationName parent, Model model) {
    CreateModelRequest request =
        CreateModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .build();
    return createModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Model model = Model.newBuilder().build();
   *   Model response = translationServiceClient.createModelAsync(parent, model).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name, in form of `projects/{project}/locations/{location}`
   * @param model Required. The Model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, CreateModelMetadata> createModelAsync(
      String parent, Model model) {
    CreateModelRequest request =
        CreateModelRequest.newBuilder().setParent(parent).setModel(model).build();
    return createModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   Model response = translationServiceClient.createModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Model, CreateModelMetadata> createModelAsync(
      CreateModelRequest request) {
    return createModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   OperationFuture<Model, CreateModelMetadata> future =
   *       translationServiceClient.createModelOperationCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable() {
    return stub.createModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateModelRequest request =
   *       CreateModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel(Model.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.createModelCallable().futureCall(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Model element : translationServiceClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent project. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(LocationName parent) {
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Model element : translationServiceClient.listModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent project. In form of
   *     `projects/{project-number-or-id}/locations/{location-id}`
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Model element : translationServiceClient.listModels(request).iterateAll()) {
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Model> future =
   *       translationServiceClient.listModelsPagedCallable().futureCall(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListModelsResponse response = translationServiceClient.listModelsCallable().call(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   Model response = translationServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model to retrieve.
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   Model response = translationServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model to retrieve.
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   Model response = translationServiceClient.getModel(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Model> future = translationServiceClient.getModelCallable().futureCall(request);
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   translationServiceClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the model to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteModelMetadata> deleteModelAsync(ModelName name) {
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   translationServiceClient.deleteModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the model to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteModelMetadata> deleteModelAsync(String name) {
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   translationServiceClient.deleteModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteModelMetadata> deleteModelAsync(
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteModelMetadata> future =
   *       translationServiceClient.deleteModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelRequest, Empty, DeleteModelMetadata>
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteModelRequest request =
   *       DeleteModelRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.deleteModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return stub.deleteModelCallable();
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

  public static class ListGlossariesPagedResponse
      extends AbstractPagedListResponse<
          ListGlossariesRequest,
          ListGlossariesResponse,
          Glossary,
          ListGlossariesPage,
          ListGlossariesFixedSizeCollection> {

    public static ApiFuture<ListGlossariesPagedResponse> createAsync(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ApiFuture<ListGlossariesResponse> futureResponse) {
      ApiFuture<ListGlossariesPage> futurePage =
          ListGlossariesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGlossariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGlossariesPagedResponse(ListGlossariesPage page) {
      super(page, ListGlossariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlossariesPage
      extends AbstractPage<
          ListGlossariesRequest, ListGlossariesResponse, Glossary, ListGlossariesPage> {

    private ListGlossariesPage(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ListGlossariesResponse response) {
      super(context, response);
    }

    private static ListGlossariesPage createEmptyPage() {
      return new ListGlossariesPage(null, null);
    }

    @Override
    protected ListGlossariesPage createPage(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ListGlossariesResponse response) {
      return new ListGlossariesPage(context, response);
    }

    @Override
    public ApiFuture<ListGlossariesPage> createPageAsync(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ApiFuture<ListGlossariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlossariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlossariesRequest,
          ListGlossariesResponse,
          Glossary,
          ListGlossariesPage,
          ListGlossariesFixedSizeCollection> {

    private ListGlossariesFixedSizeCollection(List<ListGlossariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlossariesFixedSizeCollection createEmptyCollection() {
      return new ListGlossariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlossariesFixedSizeCollection createCollection(
        List<ListGlossariesPage> pages, int collectionSize) {
      return new ListGlossariesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGlossaryEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListGlossaryEntriesRequest,
          ListGlossaryEntriesResponse,
          GlossaryEntry,
          ListGlossaryEntriesPage,
          ListGlossaryEntriesFixedSizeCollection> {

    public static ApiFuture<ListGlossaryEntriesPagedResponse> createAsync(
        PageContext<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse, GlossaryEntry> context,
        ApiFuture<ListGlossaryEntriesResponse> futureResponse) {
      ApiFuture<ListGlossaryEntriesPage> futurePage =
          ListGlossaryEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGlossaryEntriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGlossaryEntriesPagedResponse(ListGlossaryEntriesPage page) {
      super(page, ListGlossaryEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlossaryEntriesPage
      extends AbstractPage<
          ListGlossaryEntriesRequest,
          ListGlossaryEntriesResponse,
          GlossaryEntry,
          ListGlossaryEntriesPage> {

    private ListGlossaryEntriesPage(
        PageContext<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse, GlossaryEntry> context,
        ListGlossaryEntriesResponse response) {
      super(context, response);
    }

    private static ListGlossaryEntriesPage createEmptyPage() {
      return new ListGlossaryEntriesPage(null, null);
    }

    @Override
    protected ListGlossaryEntriesPage createPage(
        PageContext<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse, GlossaryEntry> context,
        ListGlossaryEntriesResponse response) {
      return new ListGlossaryEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListGlossaryEntriesPage> createPageAsync(
        PageContext<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse, GlossaryEntry> context,
        ApiFuture<ListGlossaryEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlossaryEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlossaryEntriesRequest,
          ListGlossaryEntriesResponse,
          GlossaryEntry,
          ListGlossaryEntriesPage,
          ListGlossaryEntriesFixedSizeCollection> {

    private ListGlossaryEntriesFixedSizeCollection(
        List<ListGlossaryEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlossaryEntriesFixedSizeCollection createEmptyCollection() {
      return new ListGlossaryEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlossaryEntriesFixedSizeCollection createCollection(
        List<ListGlossaryEntriesPage> pages, int collectionSize) {
      return new ListGlossaryEntriesFixedSizeCollection(pages, collectionSize);
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

  public static class ListAdaptiveMtDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          AdaptiveMtDataset,
          ListAdaptiveMtDatasetsPage,
          ListAdaptiveMtDatasetsFixedSizeCollection> {

    public static ApiFuture<ListAdaptiveMtDatasetsPagedResponse> createAsync(
        PageContext<
                ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse, AdaptiveMtDataset>
            context,
        ApiFuture<ListAdaptiveMtDatasetsResponse> futureResponse) {
      ApiFuture<ListAdaptiveMtDatasetsPage> futurePage =
          ListAdaptiveMtDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdaptiveMtDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdaptiveMtDatasetsPagedResponse(ListAdaptiveMtDatasetsPage page) {
      super(page, ListAdaptiveMtDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdaptiveMtDatasetsPage
      extends AbstractPage<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          AdaptiveMtDataset,
          ListAdaptiveMtDatasetsPage> {

    private ListAdaptiveMtDatasetsPage(
        PageContext<
                ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse, AdaptiveMtDataset>
            context,
        ListAdaptiveMtDatasetsResponse response) {
      super(context, response);
    }

    private static ListAdaptiveMtDatasetsPage createEmptyPage() {
      return new ListAdaptiveMtDatasetsPage(null, null);
    }

    @Override
    protected ListAdaptiveMtDatasetsPage createPage(
        PageContext<
                ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse, AdaptiveMtDataset>
            context,
        ListAdaptiveMtDatasetsResponse response) {
      return new ListAdaptiveMtDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAdaptiveMtDatasetsPage> createPageAsync(
        PageContext<
                ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse, AdaptiveMtDataset>
            context,
        ApiFuture<ListAdaptiveMtDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdaptiveMtDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          AdaptiveMtDataset,
          ListAdaptiveMtDatasetsPage,
          ListAdaptiveMtDatasetsFixedSizeCollection> {

    private ListAdaptiveMtDatasetsFixedSizeCollection(
        List<ListAdaptiveMtDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdaptiveMtDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListAdaptiveMtDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdaptiveMtDatasetsFixedSizeCollection createCollection(
        List<ListAdaptiveMtDatasetsPage> pages, int collectionSize) {
      return new ListAdaptiveMtDatasetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAdaptiveMtFilesPagedResponse
      extends AbstractPagedListResponse<
          ListAdaptiveMtFilesRequest,
          ListAdaptiveMtFilesResponse,
          AdaptiveMtFile,
          ListAdaptiveMtFilesPage,
          ListAdaptiveMtFilesFixedSizeCollection> {

    public static ApiFuture<ListAdaptiveMtFilesPagedResponse> createAsync(
        PageContext<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>
            context,
        ApiFuture<ListAdaptiveMtFilesResponse> futureResponse) {
      ApiFuture<ListAdaptiveMtFilesPage> futurePage =
          ListAdaptiveMtFilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdaptiveMtFilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdaptiveMtFilesPagedResponse(ListAdaptiveMtFilesPage page) {
      super(page, ListAdaptiveMtFilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdaptiveMtFilesPage
      extends AbstractPage<
          ListAdaptiveMtFilesRequest,
          ListAdaptiveMtFilesResponse,
          AdaptiveMtFile,
          ListAdaptiveMtFilesPage> {

    private ListAdaptiveMtFilesPage(
        PageContext<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>
            context,
        ListAdaptiveMtFilesResponse response) {
      super(context, response);
    }

    private static ListAdaptiveMtFilesPage createEmptyPage() {
      return new ListAdaptiveMtFilesPage(null, null);
    }

    @Override
    protected ListAdaptiveMtFilesPage createPage(
        PageContext<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>
            context,
        ListAdaptiveMtFilesResponse response) {
      return new ListAdaptiveMtFilesPage(context, response);
    }

    @Override
    public ApiFuture<ListAdaptiveMtFilesPage> createPageAsync(
        PageContext<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>
            context,
        ApiFuture<ListAdaptiveMtFilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdaptiveMtFilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdaptiveMtFilesRequest,
          ListAdaptiveMtFilesResponse,
          AdaptiveMtFile,
          ListAdaptiveMtFilesPage,
          ListAdaptiveMtFilesFixedSizeCollection> {

    private ListAdaptiveMtFilesFixedSizeCollection(
        List<ListAdaptiveMtFilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdaptiveMtFilesFixedSizeCollection createEmptyCollection() {
      return new ListAdaptiveMtFilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdaptiveMtFilesFixedSizeCollection createCollection(
        List<ListAdaptiveMtFilesPage> pages, int collectionSize) {
      return new ListAdaptiveMtFilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAdaptiveMtSentencesPagedResponse
      extends AbstractPagedListResponse<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          AdaptiveMtSentence,
          ListAdaptiveMtSentencesPage,
          ListAdaptiveMtSentencesFixedSizeCollection> {

    public static ApiFuture<ListAdaptiveMtSentencesPagedResponse> createAsync(
        PageContext<
                ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse, AdaptiveMtSentence>
            context,
        ApiFuture<ListAdaptiveMtSentencesResponse> futureResponse) {
      ApiFuture<ListAdaptiveMtSentencesPage> futurePage =
          ListAdaptiveMtSentencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdaptiveMtSentencesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdaptiveMtSentencesPagedResponse(ListAdaptiveMtSentencesPage page) {
      super(page, ListAdaptiveMtSentencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdaptiveMtSentencesPage
      extends AbstractPage<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          AdaptiveMtSentence,
          ListAdaptiveMtSentencesPage> {

    private ListAdaptiveMtSentencesPage(
        PageContext<
                ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse, AdaptiveMtSentence>
            context,
        ListAdaptiveMtSentencesResponse response) {
      super(context, response);
    }

    private static ListAdaptiveMtSentencesPage createEmptyPage() {
      return new ListAdaptiveMtSentencesPage(null, null);
    }

    @Override
    protected ListAdaptiveMtSentencesPage createPage(
        PageContext<
                ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse, AdaptiveMtSentence>
            context,
        ListAdaptiveMtSentencesResponse response) {
      return new ListAdaptiveMtSentencesPage(context, response);
    }

    @Override
    public ApiFuture<ListAdaptiveMtSentencesPage> createPageAsync(
        PageContext<
                ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse, AdaptiveMtSentence>
            context,
        ApiFuture<ListAdaptiveMtSentencesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdaptiveMtSentencesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          AdaptiveMtSentence,
          ListAdaptiveMtSentencesPage,
          ListAdaptiveMtSentencesFixedSizeCollection> {

    private ListAdaptiveMtSentencesFixedSizeCollection(
        List<ListAdaptiveMtSentencesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdaptiveMtSentencesFixedSizeCollection createEmptyCollection() {
      return new ListAdaptiveMtSentencesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdaptiveMtSentencesFixedSizeCollection createCollection(
        List<ListAdaptiveMtSentencesPage> pages, int collectionSize) {
      return new ListAdaptiveMtSentencesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExamplesPagedResponse
      extends AbstractPagedListResponse<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    public static ApiFuture<ListExamplesPagedResponse> createAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      ApiFuture<ListExamplesPage> futurePage =
          ListExamplesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExamplesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExamplesPagedResponse(ListExamplesPage page) {
      super(page, ListExamplesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExamplesPage
      extends AbstractPage<ListExamplesRequest, ListExamplesResponse, Example, ListExamplesPage> {

    private ListExamplesPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      super(context, response);
    }

    private static ListExamplesPage createEmptyPage() {
      return new ListExamplesPage(null, null);
    }

    @Override
    protected ListExamplesPage createPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      return new ListExamplesPage(context, response);
    }

    @Override
    public ApiFuture<ListExamplesPage> createPageAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExamplesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    private ListExamplesFixedSizeCollection(List<ListExamplesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExamplesFixedSizeCollection createEmptyCollection() {
      return new ListExamplesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExamplesFixedSizeCollection createCollection(
        List<ListExamplesPage> pages, int collectionSize) {
      return new ListExamplesFixedSizeCollection(pages, collectionSize);
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
}
