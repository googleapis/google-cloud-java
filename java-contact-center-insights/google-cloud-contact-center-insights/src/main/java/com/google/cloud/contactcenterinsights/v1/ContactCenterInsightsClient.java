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

package com.google.cloud.contactcenterinsights.v1;

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
import com.google.cloud.contactcenterinsights.v1.stub.ContactCenterInsightsStub;
import com.google.cloud.contactcenterinsights.v1.stub.ContactCenterInsightsStubSettings;
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
 * Service Description: An API that lets users analyze and explore their business conversation data.
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
 * try (ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Conversation conversation = Conversation.newBuilder().build();
 *   String conversationId = "conversationId-1676095234";
 *   Conversation response =
 *       contactCenterInsightsClient.createConversation(parent, conversation, conversationId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContactCenterInsightsClient object to clean up
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
 *      <td><p> CreateConversation</td>
 *      <td><p> Creates a conversation. Note that this method does not support audio transcription or redaction. Use `conversations.upload` instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConversation(CreateConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createConversation(LocationName parent, Conversation conversation, String conversationId)
 *           <li><p> createConversation(String parent, Conversation conversation, String conversationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UploadConversation</td>
 *      <td><p> Create a long-running conversation upload operation. This method differs from `CreateConversation` by allowing audio transcription and optional DLP redaction.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadConversationAsync(UploadConversationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadConversationOperationCallable()
 *           <li><p> uploadConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConversation</td>
 *      <td><p> Updates a conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConversation(UpdateConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConversation(Conversation conversation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConversation</td>
 *      <td><p> Gets a conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConversation(GetConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConversation(ConversationName name)
 *           <li><p> getConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConversations</td>
 *      <td><p> Lists conversations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConversations(ListConversationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConversations(LocationName parent)
 *           <li><p> listConversations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConversationsPagedCallable()
 *           <li><p> listConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConversation</td>
 *      <td><p> Deletes a conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConversation(DeleteConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConversation(ConversationName name)
 *           <li><p> deleteConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnalysis</td>
 *      <td><p> Creates an analysis. The long running operation is done when the analysis has completed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnalysisAsync(CreateAnalysisRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAnalysisAsync(ConversationName parent, Analysis analysis)
 *           <li><p> createAnalysisAsync(String parent, Analysis analysis)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnalysisOperationCallable()
 *           <li><p> createAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnalysis</td>
 *      <td><p> Gets an analysis.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnalysis(GetAnalysisRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnalysis(AnalysisName name)
 *           <li><p> getAnalysis(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalyses</td>
 *      <td><p> Lists analyses.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalyses(ListAnalysesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalyses(ConversationName parent)
 *           <li><p> listAnalyses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalysesPagedCallable()
 *           <li><p> listAnalysesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAnalysis</td>
 *      <td><p> Deletes an analysis.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAnalysis(DeleteAnalysisRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAnalysis(AnalysisName name)
 *           <li><p> deleteAnalysis(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkAnalyzeConversations</td>
 *      <td><p> Analyzes multiple conversations in a single request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkAnalyzeConversationsAsync(BulkAnalyzeConversationsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> bulkAnalyzeConversationsAsync(LocationName parent, String filter, float analysisPercentage)
 *           <li><p> bulkAnalyzeConversationsAsync(String parent, String filter, float analysisPercentage)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkAnalyzeConversationsOperationCallable()
 *           <li><p> bulkAnalyzeConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkDeleteConversations</td>
 *      <td><p> Deletes multiple conversations in a single request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkDeleteConversationsAsync(BulkDeleteConversationsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> bulkDeleteConversationsAsync(LocationName parent, String filter)
 *           <li><p> bulkDeleteConversationsAsync(String parent, String filter)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkDeleteConversationsOperationCallable()
 *           <li><p> bulkDeleteConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IngestConversations</td>
 *      <td><p> Imports conversations and processes them according to the user's configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> ingestConversationsAsync(IngestConversationsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> ingestConversationsAsync(LocationName parent)
 *           <li><p> ingestConversationsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ingestConversationsOperationCallable()
 *           <li><p> ingestConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportInsightsData</td>
 *      <td><p> Export insights data to a destination defined in the request body.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportInsightsDataAsync(ExportInsightsDataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportInsightsDataAsync(LocationName parent)
 *           <li><p> exportInsightsDataAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportInsightsDataOperationCallable()
 *           <li><p> exportInsightsDataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIssueModel</td>
 *      <td><p> Creates an issue model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIssueModelAsync(CreateIssueModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIssueModelAsync(LocationName parent, IssueModel issueModel)
 *           <li><p> createIssueModelAsync(String parent, IssueModel issueModel)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIssueModelOperationCallable()
 *           <li><p> createIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIssueModel</td>
 *      <td><p> Updates an issue model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIssueModel(UpdateIssueModelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateIssueModel(IssueModel issueModel, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIssueModel</td>
 *      <td><p> Gets an issue model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIssueModel(GetIssueModelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIssueModel(IssueModelName name)
 *           <li><p> getIssueModel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIssueModels</td>
 *      <td><p> Lists issue models.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIssueModels(ListIssueModelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIssueModels(LocationName parent)
 *           <li><p> listIssueModels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIssueModelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIssueModel</td>
 *      <td><p> Deletes an issue model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIssueModelAsync(DeleteIssueModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIssueModelAsync(IssueModelName name)
 *           <li><p> deleteIssueModelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIssueModelOperationCallable()
 *           <li><p> deleteIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeployIssueModel</td>
 *      <td><p> Deploys an issue model. Returns an error if a model is already deployed. An issue model can only be used in analysis after it has been deployed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deployIssueModelAsync(DeployIssueModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deployIssueModelAsync(IssueModelName name)
 *           <li><p> deployIssueModelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deployIssueModelOperationCallable()
 *           <li><p> deployIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeployIssueModel</td>
 *      <td><p> Undeploys an issue model. An issue model can not be used in analysis after it has been undeployed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeployIssueModelAsync(UndeployIssueModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> undeployIssueModelAsync(IssueModelName name)
 *           <li><p> undeployIssueModelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeployIssueModelOperationCallable()
 *           <li><p> undeployIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportIssueModel</td>
 *      <td><p> Exports an issue model to the provided destination.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportIssueModelAsync(ExportIssueModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportIssueModelAsync(IssueModelName name)
 *           <li><p> exportIssueModelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportIssueModelOperationCallable()
 *           <li><p> exportIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportIssueModel</td>
 *      <td><p> Imports an issue model from a Cloud Storage bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importIssueModelAsync(ImportIssueModelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importIssueModelAsync(LocationName parent)
 *           <li><p> importIssueModelAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importIssueModelOperationCallable()
 *           <li><p> importIssueModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIssue</td>
 *      <td><p> Gets an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIssue(GetIssueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIssue(IssueName name)
 *           <li><p> getIssue(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIssues</td>
 *      <td><p> Lists issues.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIssues(ListIssuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIssues(IssueModelName parent)
 *           <li><p> listIssues(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIssuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIssue</td>
 *      <td><p> Updates an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIssue(UpdateIssueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateIssue(Issue issue, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIssue</td>
 *      <td><p> Deletes an issue.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIssue(DeleteIssueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteIssue(IssueName name)
 *           <li><p> deleteIssue(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIssueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CalculateIssueModelStats</td>
 *      <td><p> Gets an issue model's statistics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> calculateIssueModelStats(CalculateIssueModelStatsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> calculateIssueModelStats(IssueModelName issueModel)
 *           <li><p> calculateIssueModelStats(String issueModel)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> calculateIssueModelStatsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePhraseMatcher</td>
 *      <td><p> Creates a phrase matcher.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPhraseMatcher(CreatePhraseMatcherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPhraseMatcher(LocationName parent, PhraseMatcher phraseMatcher)
 *           <li><p> createPhraseMatcher(String parent, PhraseMatcher phraseMatcher)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPhraseMatcherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPhraseMatcher</td>
 *      <td><p> Gets a phrase matcher.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPhraseMatcher(GetPhraseMatcherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPhraseMatcher(PhraseMatcherName name)
 *           <li><p> getPhraseMatcher(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPhraseMatcherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPhraseMatchers</td>
 *      <td><p> Lists phrase matchers.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPhraseMatchers(ListPhraseMatchersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPhraseMatchers(LocationName parent)
 *           <li><p> listPhraseMatchers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPhraseMatchersPagedCallable()
 *           <li><p> listPhraseMatchersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePhraseMatcher</td>
 *      <td><p> Deletes a phrase matcher.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePhraseMatcher(DeletePhraseMatcherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePhraseMatcher(PhraseMatcherName name)
 *           <li><p> deletePhraseMatcher(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePhraseMatcherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePhraseMatcher</td>
 *      <td><p> Updates a phrase matcher.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePhraseMatcher(UpdatePhraseMatcherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePhraseMatcher(PhraseMatcher phraseMatcher, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePhraseMatcherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CalculateStats</td>
 *      <td><p> Gets conversation statistics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> calculateStats(CalculateStatsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> calculateStats(LocationName location)
 *           <li><p> calculateStats(String location)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> calculateStatsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSettings</td>
 *      <td><p> Gets project-level settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSettings(GetSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSettings(SettingsName name)
 *           <li><p> getSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSettings</td>
 *      <td><p> Updates project-level settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSettings(UpdateSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSettings(Settings settings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnalysisRule</td>
 *      <td><p> Creates a analysis rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnalysisRule(CreateAnalysisRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAnalysisRule(LocationName parent, AnalysisRule analysisRule)
 *           <li><p> createAnalysisRule(String parent, AnalysisRule analysisRule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnalysisRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnalysisRule</td>
 *      <td><p> Get a analysis rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnalysisRule(GetAnalysisRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnalysisRule(AnalysisRuleName name)
 *           <li><p> getAnalysisRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnalysisRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalysisRules</td>
 *      <td><p> Lists analysis rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalysisRules(ListAnalysisRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalysisRules(LocationName parent)
 *           <li><p> listAnalysisRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalysisRulesPagedCallable()
 *           <li><p> listAnalysisRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAnalysisRule</td>
 *      <td><p> Updates a analysis rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAnalysisRule(UpdateAnalysisRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAnalysisRule(AnalysisRule analysisRule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAnalysisRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAnalysisRule</td>
 *      <td><p> Deletes a analysis rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAnalysisRule(DeleteAnalysisRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAnalysisRule(AnalysisRuleName name)
 *           <li><p> deleteAnalysisRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAnalysisRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEncryptionSpec</td>
 *      <td><p> Gets location-level encryption key specification.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEncryptionSpec(GetEncryptionSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEncryptionSpec(EncryptionSpecName name)
 *           <li><p> getEncryptionSpec(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEncryptionSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InitializeEncryptionSpec</td>
 *      <td><p> Initializes a location-level encryption key specification. An error will result if the location has resources already created before the initialization. After the encryption specification is initialized at a location, it is immutable and all newly created resources under the location will be encrypted with the existing specification.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> initializeEncryptionSpecAsync(InitializeEncryptionSpecRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> initializeEncryptionSpecAsync(EncryptionSpec encryptionSpec)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> initializeEncryptionSpecOperationCallable()
 *           <li><p> initializeEncryptionSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateView</td>
 *      <td><p> Creates a view.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createView(CreateViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createView(LocationName parent, View view)
 *           <li><p> createView(String parent, View view)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetView</td>
 *      <td><p> Gets a view.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getView(GetViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getView(ViewName name)
 *           <li><p> getView(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListViews</td>
 *      <td><p> Lists views.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listViews(ListViewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listViews(LocationName parent)
 *           <li><p> listViews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listViewsPagedCallable()
 *           <li><p> listViewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateView</td>
 *      <td><p> Updates a view.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateView(UpdateViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateView(View view, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteView</td>
 *      <td><p> Deletes a view.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteView(DeleteViewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteView(ViewName name)
 *           <li><p> deleteView(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteViewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryMetrics</td>
 *      <td><p> Query metrics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryMetricsAsync(QueryMetricsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryMetricsOperationCallable()
 *           <li><p> queryMetricsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateQaQuestion</td>
 *      <td><p> Create a QaQuestion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createQaQuestion(CreateQaQuestionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createQaQuestion(QaScorecardRevisionName parent, QaQuestion qaQuestion, String qaQuestionId)
 *           <li><p> createQaQuestion(String parent, QaQuestion qaQuestion, String qaQuestionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createQaQuestionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetQaQuestion</td>
 *      <td><p> Gets a QaQuestion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getQaQuestion(GetQaQuestionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getQaQuestion(QaQuestionName name)
 *           <li><p> getQaQuestion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getQaQuestionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateQaQuestion</td>
 *      <td><p> Updates a QaQuestion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateQaQuestion(UpdateQaQuestionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateQaQuestion(QaQuestion qaQuestion, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateQaQuestionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteQaQuestion</td>
 *      <td><p> Deletes a QaQuestion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteQaQuestion(DeleteQaQuestionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteQaQuestion(QaQuestionName name)
 *           <li><p> deleteQaQuestion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteQaQuestionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListQaQuestions</td>
 *      <td><p> Lists QaQuestions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listQaQuestions(ListQaQuestionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listQaQuestions(QaScorecardRevisionName parent)
 *           <li><p> listQaQuestions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listQaQuestionsPagedCallable()
 *           <li><p> listQaQuestionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateQaScorecard</td>
 *      <td><p> Create a QaScorecard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createQaScorecard(CreateQaScorecardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createQaScorecard(LocationName parent, QaScorecard qaScorecard, String qaScorecardId)
 *           <li><p> createQaScorecard(String parent, QaScorecard qaScorecard, String qaScorecardId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createQaScorecardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetQaScorecard</td>
 *      <td><p> Gets a QaScorecard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getQaScorecard(GetQaScorecardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getQaScorecard(QaScorecardName name)
 *           <li><p> getQaScorecard(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getQaScorecardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateQaScorecard</td>
 *      <td><p> Updates a QaScorecard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateQaScorecard(UpdateQaScorecardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateQaScorecard(QaScorecard qaScorecard, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateQaScorecardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteQaScorecard</td>
 *      <td><p> Deletes a QaScorecard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteQaScorecard(DeleteQaScorecardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteQaScorecard(QaScorecardName name)
 *           <li><p> deleteQaScorecard(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteQaScorecardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListQaScorecards</td>
 *      <td><p> Lists QaScorecards.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listQaScorecards(ListQaScorecardsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listQaScorecards(LocationName parent)
 *           <li><p> listQaScorecards(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listQaScorecardsPagedCallable()
 *           <li><p> listQaScorecardsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateQaScorecardRevision</td>
 *      <td><p> Creates a QaScorecardRevision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createQaScorecardRevision(CreateQaScorecardRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createQaScorecardRevision(QaScorecardName parent, QaScorecardRevision qaScorecardRevision, String qaScorecardRevisionId)
 *           <li><p> createQaScorecardRevision(String parent, QaScorecardRevision qaScorecardRevision, String qaScorecardRevisionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createQaScorecardRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetQaScorecardRevision</td>
 *      <td><p> Gets a QaScorecardRevision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getQaScorecardRevision(GetQaScorecardRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getQaScorecardRevision(QaScorecardRevisionName name)
 *           <li><p> getQaScorecardRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getQaScorecardRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TuneQaScorecardRevision</td>
 *      <td><p> Fine tune one or more QaModels.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> tuneQaScorecardRevisionAsync(TuneQaScorecardRevisionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> tuneQaScorecardRevisionAsync(QaScorecardRevisionName parent, String filter, boolean validateOnly)
 *           <li><p> tuneQaScorecardRevisionAsync(String parent, String filter, boolean validateOnly)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> tuneQaScorecardRevisionOperationCallable()
 *           <li><p> tuneQaScorecardRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeployQaScorecardRevision</td>
 *      <td><p> Deploy a QaScorecardRevision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deployQaScorecardRevision(DeployQaScorecardRevisionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deployQaScorecardRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeployQaScorecardRevision</td>
 *      <td><p> Undeploy a QaScorecardRevision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeployQaScorecardRevision(UndeployQaScorecardRevisionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeployQaScorecardRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteQaScorecardRevision</td>
 *      <td><p> Deletes a QaScorecardRevision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteQaScorecardRevision(DeleteQaScorecardRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteQaScorecardRevision(QaScorecardRevisionName name)
 *           <li><p> deleteQaScorecardRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteQaScorecardRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListQaScorecardRevisions</td>
 *      <td><p> Lists all revisions under the parent QaScorecard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listQaScorecardRevisions(ListQaScorecardRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listQaScorecardRevisions(QaScorecardName parent)
 *           <li><p> listQaScorecardRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listQaScorecardRevisionsPagedCallable()
 *           <li><p> listQaScorecardRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFeedbackLabel</td>
 *      <td><p> Create feedback label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFeedbackLabel(CreateFeedbackLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFeedbackLabel(ConversationName parent, FeedbackLabel feedbackLabel, String feedbackLabelId)
 *           <li><p> createFeedbackLabel(String parent, FeedbackLabel feedbackLabel, String feedbackLabelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFeedbackLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFeedbackLabels</td>
 *      <td><p> List feedback labels.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFeedbackLabels(ListFeedbackLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFeedbackLabels(ConversationName parent)
 *           <li><p> listFeedbackLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFeedbackLabelsPagedCallable()
 *           <li><p> listFeedbackLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFeedbackLabel</td>
 *      <td><p> Get feedback label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFeedbackLabel(GetFeedbackLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFeedbackLabel(FeedbackLabelName name)
 *           <li><p> getFeedbackLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFeedbackLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFeedbackLabel</td>
 *      <td><p> Update feedback label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFeedbackLabel(UpdateFeedbackLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFeedbackLabel(FeedbackLabel feedbackLabel, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFeedbackLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFeedbackLabel</td>
 *      <td><p> Delete feedback label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFeedbackLabel(DeleteFeedbackLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteFeedbackLabel(FeedbackLabelName name)
 *           <li><p> deleteFeedbackLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFeedbackLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAllFeedbackLabels</td>
 *      <td><p> List all feedback labels by project number.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAllFeedbackLabels(ListAllFeedbackLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAllFeedbackLabels(LocationName parent)
 *           <li><p> listAllFeedbackLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAllFeedbackLabelsPagedCallable()
 *           <li><p> listAllFeedbackLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkUploadFeedbackLabels</td>
 *      <td><p> Upload feedback labels in bulk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkUploadFeedbackLabelsAsync(BulkUploadFeedbackLabelsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> bulkUploadFeedbackLabelsAsync(LocationName parent)
 *           <li><p> bulkUploadFeedbackLabelsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkUploadFeedbackLabelsOperationCallable()
 *           <li><p> bulkUploadFeedbackLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkDownloadFeedbackLabels</td>
 *      <td><p> Download feedback labels in bulk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkDownloadFeedbackLabelsAsync(BulkDownloadFeedbackLabelsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> bulkDownloadFeedbackLabelsAsync(LocationName parent)
 *           <li><p> bulkDownloadFeedbackLabelsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkDownloadFeedbackLabelsOperationCallable()
 *           <li><p> bulkDownloadFeedbackLabelsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ContactCenterInsightsSettings
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
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     ContactCenterInsightsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create(contactCenterInsightsSettings);
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
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     ContactCenterInsightsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create(contactCenterInsightsSettings);
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
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     ContactCenterInsightsSettings.newHttpJsonBuilder().build();
 * ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create(contactCenterInsightsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContactCenterInsightsClient implements BackgroundResource {
  private final ContactCenterInsightsSettings settings;
  private final ContactCenterInsightsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ContactCenterInsightsClient with default settings. */
  public static final ContactCenterInsightsClient create() throws IOException {
    return create(ContactCenterInsightsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContactCenterInsightsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContactCenterInsightsClient create(ContactCenterInsightsSettings settings)
      throws IOException {
    return new ContactCenterInsightsClient(settings);
  }

  /**
   * Constructs an instance of ContactCenterInsightsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ContactCenterInsightsSettings).
   */
  public static final ContactCenterInsightsClient create(ContactCenterInsightsStub stub) {
    return new ContactCenterInsightsClient(stub);
  }

  /**
   * Constructs an instance of ContactCenterInsightsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ContactCenterInsightsClient(ContactCenterInsightsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContactCenterInsightsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ContactCenterInsightsClient(ContactCenterInsightsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ContactCenterInsightsSettings getSettings() {
    return settings;
  }

  public ContactCenterInsightsStub getStub() {
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
   * Creates a conversation. Note that this method does not support audio transcription or
   * redaction. Use `conversations.upload` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Conversation conversation = Conversation.newBuilder().build();
   *   String conversationId = "conversationId-1676095234";
   *   Conversation response =
   *       contactCenterInsightsClient.createConversation(parent, conversation, conversationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @param conversation Required. The conversation resource to create.
   * @param conversationId A unique ID for the new conversation. This ID will become the final
   *     component of the conversation's resource name. If no ID is specified, a server-generated ID
   *     will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(
      LocationName parent, Conversation conversation, String conversationId) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversation(conversation)
            .setConversationId(conversationId)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation. Note that this method does not support audio transcription or
   * redaction. Use `conversations.upload` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Conversation conversation = Conversation.newBuilder().build();
   *   String conversationId = "conversationId-1676095234";
   *   Conversation response =
   *       contactCenterInsightsClient.createConversation(parent, conversation, conversationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @param conversation Required. The conversation resource to create.
   * @param conversationId A unique ID for the new conversation. This ID will become the final
   *     component of the conversation's resource name. If no ID is specified, a server-generated ID
   *     will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(
      String parent, Conversation conversation, String conversationId) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent)
            .setConversation(conversation)
            .setConversationId(conversationId)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation. Note that this method does not support audio transcription or
   * redaction. Use `conversations.upload` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .build();
   *   Conversation response = contactCenterInsightsClient.createConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(CreateConversationRequest request) {
    return createConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation. Note that this method does not support audio transcription or
   * redaction. Use `conversations.upload` instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.createConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    return stub.createConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a long-running conversation upload operation. This method differs from
   * `CreateConversation` by allowing audio transcription and optional DLP redaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UploadConversationRequest request =
   *       UploadConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .setRedactionConfig(RedactionConfig.newBuilder().build())
   *           .setSpeechConfig(SpeechConfig.newBuilder().build())
   *           .build();
   *   Conversation response = contactCenterInsightsClient.uploadConversationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Conversation, UploadConversationMetadata> uploadConversationAsync(
      UploadConversationRequest request) {
    return uploadConversationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a long-running conversation upload operation. This method differs from
   * `CreateConversation` by allowing audio transcription and optional DLP redaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UploadConversationRequest request =
   *       UploadConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .setRedactionConfig(RedactionConfig.newBuilder().build())
   *           .setSpeechConfig(SpeechConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Conversation, UploadConversationMetadata> future =
   *       contactCenterInsightsClient.uploadConversationOperationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationCallable() {
    return stub.uploadConversationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a long-running conversation upload operation. This method differs from
   * `CreateConversation` by allowing audio transcription and optional DLP redaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UploadConversationRequest request =
   *       UploadConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .setRedactionConfig(RedactionConfig.newBuilder().build())
   *           .setSpeechConfig(SpeechConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.uploadConversationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadConversationRequest, Operation> uploadConversationCallable() {
    return stub.uploadConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   Conversation conversation = Conversation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Conversation response =
   *       contactCenterInsightsClient.updateConversation(conversation, updateMask);
   * }
   * }</pre>
   *
   * @param conversation Required. The new values for the conversation.
   * @param updateMask The list of fields to be updated. All possible fields can be updated by
   *     passing `&#42;`, or a subset of the following updateable fields can be provided:
   *     <ul>
   *       <li>`agent_id`
   *       <li>`language_code`
   *       <li>`labels`
   *       <li>`metadata`
   *       <li>`quality_metadata`
   *       <li>`call_metadata`
   *       <li>`start_time`
   *       <li>`expire_time` or `ttl`
   *       <li>`data_source.gcs_source.audio_uri` or `data_source.dialogflow_source.audio_uri`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation updateConversation(Conversation conversation, FieldMask updateMask) {
    UpdateConversationRequest request =
        UpdateConversationRequest.newBuilder()
            .setConversation(conversation)
            .setUpdateMask(updateMask)
            .build();
    return updateConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateConversationRequest request =
   *       UpdateConversationRequest.newBuilder()
   *           .setConversation(Conversation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Conversation response = contactCenterInsightsClient.updateConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation updateConversation(UpdateConversationRequest request) {
    return updateConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateConversationRequest request =
   *       UpdateConversationRequest.newBuilder()
   *           .setConversation(Conversation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.updateConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable() {
    return stub.updateConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   Conversation response = contactCenterInsightsClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(ConversationName name) {
    GetConversationRequest request =
        GetConversationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       ConversationName.ofProjectLocationConversationName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *           .toString();
   *   Conversation response = contactCenterInsightsClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(String name) {
    GetConversationRequest request = GetConversationRequest.newBuilder().setName(name).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   Conversation response = contactCenterInsightsClient.getConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(GetConversationRequest request) {
    return getConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.getConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return stub.getConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Conversation element :
   *       contactCenterInsightsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(LocationName parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Conversation element :
   *       contactCenterInsightsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(String parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder().setParent(parent).build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   for (Conversation element :
   *       contactCenterInsightsClient.listConversations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(ListConversationsRequest request) {
    return listConversationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.listConversationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Conversation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return stub.listConversationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListConversationsResponse response =
   *         contactCenterInsightsClient.listConversationsCallable().call(request);
   *     for (Conversation element : response.getConversationsList()) {
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
  public final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return stub.listConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   contactCenterInsightsClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(ConversationName name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       ConversationName.ofProjectLocationConversationName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *           .toString();
   *   contactCenterInsightsClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(String name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder().setName(name).build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   contactCenterInsightsClient.deleteConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(DeleteConversationRequest request) {
    deleteConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteConversationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    return stub.deleteConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   Analysis analysis = Analysis.newBuilder().build();
   *   Analysis response = contactCenterInsightsClient.createAnalysisAsync(parent, analysis).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis.
   * @param analysis Required. The analysis to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, CreateAnalysisOperationMetadata> createAnalysisAsync(
      ConversationName parent, Analysis analysis) {
    CreateAnalysisRequest request =
        CreateAnalysisRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnalysis(analysis)
            .build();
    return createAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectLocationConversationName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *           .toString();
   *   Analysis analysis = Analysis.newBuilder().build();
   *   Analysis response = contactCenterInsightsClient.createAnalysisAsync(parent, analysis).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis.
   * @param analysis Required. The analysis to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, CreateAnalysisOperationMetadata> createAnalysisAsync(
      String parent, Analysis analysis) {
    CreateAnalysisRequest request =
        CreateAnalysisRequest.newBuilder().setParent(parent).setAnalysis(analysis).build();
    return createAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .build();
   *   Analysis response = contactCenterInsightsClient.createAnalysisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, CreateAnalysisOperationMetadata> createAnalysisAsync(
      CreateAnalysisRequest request) {
    return createAnalysisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .build();
   *   OperationFuture<Analysis, CreateAnalysisOperationMetadata> future =
   *       contactCenterInsightsClient.createAnalysisOperationCallable().futureCall(request);
   *   // Do something.
   *   Analysis response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationCallable() {
    return stub.createAnalysisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.createAnalysisCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    return stub.createAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisName name =
   *       AnalysisName.ofProjectLocationConversationAnalysisName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");
   *   Analysis response = contactCenterInsightsClient.getAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(AnalysisName name) {
    GetAnalysisRequest request =
        GetAnalysisRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       AnalysisName.ofProjectLocationConversationAnalysisName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *           .toString();
   *   Analysis response = contactCenterInsightsClient.getAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(String name) {
    GetAnalysisRequest request = GetAnalysisRequest.newBuilder().setName(name).build();
    return getAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetAnalysisRequest request =
   *       GetAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.ofProjectLocationConversationAnalysisName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   Analysis response = contactCenterInsightsClient.getAnalysis(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(GetAnalysisRequest request) {
    return getAnalysisCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetAnalysisRequest request =
   *       GetAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.ofProjectLocationConversationAnalysisName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Analysis> future =
   *       contactCenterInsightsClient.getAnalysisCallable().futureCall(request);
   *   // Do something.
   *   Analysis response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    return stub.getAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   for (Analysis element : contactCenterInsightsClient.listAnalyses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analyses.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(ConversationName parent) {
    ListAnalysesRequest request =
        ListAnalysesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectLocationConversationName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *           .toString();
   *   for (Analysis element : contactCenterInsightsClient.listAnalyses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analyses.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(String parent) {
    ListAnalysesRequest request = ListAnalysesRequest.newBuilder().setParent(parent).build();
    return listAnalyses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Analysis element : contactCenterInsightsClient.listAnalyses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(ListAnalysesRequest request) {
    return listAnalysesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Analysis> future =
   *       contactCenterInsightsClient.listAnalysesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Analysis element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse>
      listAnalysesPagedCallable() {
    return stub.listAnalysesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAnalysesResponse response =
   *         contactCenterInsightsClient.listAnalysesCallable().call(request);
   *     for (Analysis element : response.getAnalysesList()) {
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
  public final UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    return stub.listAnalysesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisName name =
   *       AnalysisName.ofProjectLocationConversationAnalysisName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");
   *   contactCenterInsightsClient.deleteAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysis(AnalysisName name) {
    DeleteAnalysisRequest request =
        DeleteAnalysisRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       AnalysisName.ofProjectLocationConversationAnalysisName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *           .toString();
   *   contactCenterInsightsClient.deleteAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysis(String name) {
    DeleteAnalysisRequest request = DeleteAnalysisRequest.newBuilder().setName(name).build();
    deleteAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.ofProjectLocationConversationAnalysisName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   contactCenterInsightsClient.deleteAnalysis(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysis(DeleteAnalysisRequest request) {
    deleteAnalysisCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.ofProjectLocationConversationAnalysisName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteAnalysisCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnalysisRequest, Empty> deleteAnalysisCallable() {
    return stub.deleteAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String filter = "filter-1274492040";
   *   float analysisPercentage = 1609757661;
   *   BulkAnalyzeConversationsResponse response =
   *       contactCenterInsightsClient
   *           .bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to create analyses in.
   * @param filter Required. Filter used to select the subset of conversations to analyze.
   * @param analysisPercentage Required. Percentage of selected conversation to analyze, between [0,
   *     100].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkAnalyzeConversationsResponse, BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsAsync(LocationName parent, String filter, float analysisPercentage) {
    BulkAnalyzeConversationsRequest request =
        BulkAnalyzeConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .setAnalysisPercentage(analysisPercentage)
            .build();
    return bulkAnalyzeConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String filter = "filter-1274492040";
   *   float analysisPercentage = 1609757661;
   *   BulkAnalyzeConversationsResponse response =
   *       contactCenterInsightsClient
   *           .bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to create analyses in.
   * @param filter Required. Filter used to select the subset of conversations to analyze.
   * @param analysisPercentage Required. Percentage of selected conversation to analyze, between [0,
   *     100].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkAnalyzeConversationsResponse, BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsAsync(String parent, String filter, float analysisPercentage) {
    BulkAnalyzeConversationsRequest request =
        BulkAnalyzeConversationsRequest.newBuilder()
            .setParent(parent)
            .setFilter(filter)
            .setAnalysisPercentage(analysisPercentage)
            .build();
    return bulkAnalyzeConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkAnalyzeConversationsRequest request =
   *       BulkAnalyzeConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setAnalysisPercentage(1609757661)
   *           .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
   *           .build();
   *   BulkAnalyzeConversationsResponse response =
   *       contactCenterInsightsClient.bulkAnalyzeConversationsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkAnalyzeConversationsResponse, BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsAsync(BulkAnalyzeConversationsRequest request) {
    return bulkAnalyzeConversationsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkAnalyzeConversationsRequest request =
   *       BulkAnalyzeConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setAnalysisPercentage(1609757661)
   *           .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
   *           .build();
   *   OperationFuture<BulkAnalyzeConversationsResponse, BulkAnalyzeConversationsMetadata> future =
   *       contactCenterInsightsClient
   *           .bulkAnalyzeConversationsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BulkAnalyzeConversationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationCallable() {
    return stub.bulkAnalyzeConversationsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkAnalyzeConversationsRequest request =
   *       BulkAnalyzeConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setAnalysisPercentage(1609757661)
   *           .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.bulkAnalyzeConversationsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsCallable() {
    return stub.bulkAnalyzeConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String filter = "filter-1274492040";
   *   BulkDeleteConversationsResponse response =
   *       contactCenterInsightsClient.bulkDeleteConversationsAsync(parent, filter).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to delete conversations from. Format:
   *     projects/{project}/locations/{location}
   * @param filter Filter used to select the subset of conversations to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkDeleteConversationsResponse, BulkDeleteConversationsMetadata>
      bulkDeleteConversationsAsync(LocationName parent, String filter) {
    BulkDeleteConversationsRequest request =
        BulkDeleteConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return bulkDeleteConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String filter = "filter-1274492040";
   *   BulkDeleteConversationsResponse response =
   *       contactCenterInsightsClient.bulkDeleteConversationsAsync(parent, filter).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to delete conversations from. Format:
   *     projects/{project}/locations/{location}
   * @param filter Filter used to select the subset of conversations to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkDeleteConversationsResponse, BulkDeleteConversationsMetadata>
      bulkDeleteConversationsAsync(String parent, String filter) {
    BulkDeleteConversationsRequest request =
        BulkDeleteConversationsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return bulkDeleteConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkDeleteConversationsRequest request =
   *       BulkDeleteConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setMaxDeleteCount(1611707510)
   *           .setForce(true)
   *           .build();
   *   BulkDeleteConversationsResponse response =
   *       contactCenterInsightsClient.bulkDeleteConversationsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkDeleteConversationsResponse, BulkDeleteConversationsMetadata>
      bulkDeleteConversationsAsync(BulkDeleteConversationsRequest request) {
    return bulkDeleteConversationsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkDeleteConversationsRequest request =
   *       BulkDeleteConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setMaxDeleteCount(1611707510)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<BulkDeleteConversationsResponse, BulkDeleteConversationsMetadata> future =
   *       contactCenterInsightsClient
   *           .bulkDeleteConversationsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BulkDeleteConversationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationCallable() {
    return stub.bulkDeleteConversationsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes multiple conversations in a single request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkDeleteConversationsRequest request =
   *       BulkDeleteConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setMaxDeleteCount(1611707510)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.bulkDeleteConversationsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsCallable() {
    return stub.bulkDeleteConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports conversations and processes them according to the user's configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IngestConversationsResponse response =
   *       contactCenterInsightsClient.ingestConversationsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new conversations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsAsync(LocationName parent) {
    IngestConversationsRequest request =
        IngestConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return ingestConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports conversations and processes them according to the user's configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IngestConversationsResponse response =
   *       contactCenterInsightsClient.ingestConversationsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new conversations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsAsync(String parent) {
    IngestConversationsRequest request =
        IngestConversationsRequest.newBuilder().setParent(parent).build();
    return ingestConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports conversations and processes them according to the user's configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IngestConversationsRequest request =
   *       IngestConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversationConfig(
   *               IngestConversationsRequest.ConversationConfig.newBuilder().build())
   *           .setRedactionConfig(RedactionConfig.newBuilder().build())
   *           .setSpeechConfig(SpeechConfig.newBuilder().build())
   *           .setSampleSize(153230710)
   *           .build();
   *   IngestConversationsResponse response =
   *       contactCenterInsightsClient.ingestConversationsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsAsync(IngestConversationsRequest request) {
    return ingestConversationsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports conversations and processes them according to the user's configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IngestConversationsRequest request =
   *       IngestConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversationConfig(
   *               IngestConversationsRequest.ConversationConfig.newBuilder().build())
   *           .setRedactionConfig(RedactionConfig.newBuilder().build())
   *           .setSpeechConfig(SpeechConfig.newBuilder().build())
   *           .setSampleSize(153230710)
   *           .build();
   *   OperationFuture<IngestConversationsResponse, IngestConversationsMetadata> future =
   *       contactCenterInsightsClient.ingestConversationsOperationCallable().futureCall(request);
   *   // Do something.
   *   IngestConversationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationCallable() {
    return stub.ingestConversationsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports conversations and processes them according to the user's configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IngestConversationsRequest request =
   *       IngestConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversationConfig(
   *               IngestConversationsRequest.ConversationConfig.newBuilder().build())
   *           .setRedactionConfig(RedactionConfig.newBuilder().build())
   *           .setSpeechConfig(SpeechConfig.newBuilder().build())
   *           .setSampleSize(153230710)
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.ingestConversationsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IngestConversationsRequest, Operation> ingestConversationsCallable() {
    return stub.ingestConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExportInsightsDataResponse response =
   *       contactCenterInsightsClient.exportInsightsDataAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to export data from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataAsync(LocationName parent) {
    ExportInsightsDataRequest request =
        ExportInsightsDataRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return exportInsightsDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExportInsightsDataResponse response =
   *       contactCenterInsightsClient.exportInsightsDataAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to export data from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataAsync(String parent) {
    ExportInsightsDataRequest request =
        ExportInsightsDataRequest.newBuilder().setParent(parent).build();
    return exportInsightsDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportInsightsDataRequest request =
   *       ExportInsightsDataRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setKmsKey("kmsKey-1127483058")
   *           .build();
   *   ExportInsightsDataResponse response =
   *       contactCenterInsightsClient.exportInsightsDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataAsync(ExportInsightsDataRequest request) {
    return exportInsightsDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportInsightsDataRequest request =
   *       ExportInsightsDataRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setKmsKey("kmsKey-1127483058")
   *           .build();
   *   OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata> future =
   *       contactCenterInsightsClient.exportInsightsDataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportInsightsDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationCallable() {
    return stub.exportInsightsDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportInsightsDataRequest request =
   *       ExportInsightsDataRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setKmsKey("kmsKey-1127483058")
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.exportInsightsDataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportInsightsDataRequest, Operation> exportInsightsDataCallable() {
    return stub.exportInsightsDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IssueModel issueModel = IssueModel.newBuilder().build();
   *   IssueModel response =
   *       contactCenterInsightsClient.createIssueModelAsync(parent, issueModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @param issueModel Required. The issue model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueModel, CreateIssueModelMetadata> createIssueModelAsync(
      LocationName parent, IssueModel issueModel) {
    CreateIssueModelRequest request =
        CreateIssueModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIssueModel(issueModel)
            .build();
    return createIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IssueModel issueModel = IssueModel.newBuilder().build();
   *   IssueModel response =
   *       contactCenterInsightsClient.createIssueModelAsync(parent, issueModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @param issueModel Required. The issue model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueModel, CreateIssueModelMetadata> createIssueModelAsync(
      String parent, IssueModel issueModel) {
    CreateIssueModelRequest request =
        CreateIssueModelRequest.newBuilder().setParent(parent).setIssueModel(issueModel).build();
    return createIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateIssueModelRequest request =
   *       CreateIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .build();
   *   IssueModel response = contactCenterInsightsClient.createIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueModel, CreateIssueModelMetadata> createIssueModelAsync(
      CreateIssueModelRequest request) {
    return createIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateIssueModelRequest request =
   *       CreateIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .build();
   *   OperationFuture<IssueModel, CreateIssueModelMetadata> future =
   *       contactCenterInsightsClient.createIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   IssueModel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationCallable() {
    return stub.createIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateIssueModelRequest request =
   *       CreateIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.createIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIssueModelRequest, Operation> createIssueModelCallable() {
    return stub.createIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModel issueModel = IssueModel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IssueModel response = contactCenterInsightsClient.updateIssueModel(issueModel, updateMask);
   * }
   * }</pre>
   *
   * @param issueModel Required. The new values for the issue model.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel updateIssueModel(IssueModel issueModel, FieldMask updateMask) {
    UpdateIssueModelRequest request =
        UpdateIssueModelRequest.newBuilder()
            .setIssueModel(issueModel)
            .setUpdateMask(updateMask)
            .build();
    return updateIssueModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueModelRequest request =
   *       UpdateIssueModelRequest.newBuilder()
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IssueModel response = contactCenterInsightsClient.updateIssueModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel updateIssueModel(UpdateIssueModelRequest request) {
    return updateIssueModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueModelRequest request =
   *       UpdateIssueModelRequest.newBuilder()
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IssueModel> future =
   *       contactCenterInsightsClient.updateIssueModelCallable().futureCall(request);
   *   // Do something.
   *   IssueModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIssueModelRequest, IssueModel> updateIssueModelCallable() {
    return stub.updateIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   IssueModel response = contactCenterInsightsClient.getIssueModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel getIssueModel(IssueModelName name) {
    GetIssueModelRequest request =
        GetIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIssueModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   IssueModel response = contactCenterInsightsClient.getIssueModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel getIssueModel(String name) {
    GetIssueModelRequest request = GetIssueModelRequest.newBuilder().setName(name).build();
    return getIssueModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueModelRequest request =
   *       GetIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   IssueModel response = contactCenterInsightsClient.getIssueModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel getIssueModel(GetIssueModelRequest request) {
    return getIssueModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueModelRequest request =
   *       GetIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<IssueModel> future =
   *       contactCenterInsightsClient.getIssueModelCallable().futureCall(request);
   *   // Do something.
   *   IssueModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable() {
    return stub.getIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListIssueModelsResponse response = contactCenterInsightsClient.listIssueModels(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueModelsResponse listIssueModels(LocationName parent) {
    ListIssueModelsRequest request =
        ListIssueModelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIssueModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListIssueModelsResponse response = contactCenterInsightsClient.listIssueModels(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueModelsResponse listIssueModels(String parent) {
    ListIssueModelsRequest request = ListIssueModelsRequest.newBuilder().setParent(parent).build();
    return listIssueModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssueModelsRequest request =
   *       ListIssueModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ListIssueModelsResponse response = contactCenterInsightsClient.listIssueModels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueModelsResponse listIssueModels(ListIssueModelsRequest request) {
    return listIssueModelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssueModelsRequest request =
   *       ListIssueModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ListIssueModelsResponse> future =
   *       contactCenterInsightsClient.listIssueModelsCallable().futureCall(request);
   *   // Do something.
   *   ListIssueModelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsCallable() {
    return stub.listIssueModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   contactCenterInsightsClient.deleteIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIssueModelMetadata> deleteIssueModelAsync(
      IssueModelName name) {
    DeleteIssueModelRequest request =
        DeleteIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   contactCenterInsightsClient.deleteIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIssueModelMetadata> deleteIssueModelAsync(String name) {
    DeleteIssueModelRequest request = DeleteIssueModelRequest.newBuilder().setName(name).build();
    return deleteIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueModelRequest request =
   *       DeleteIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   contactCenterInsightsClient.deleteIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIssueModelMetadata> deleteIssueModelAsync(
      DeleteIssueModelRequest request) {
    return deleteIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueModelRequest request =
   *       DeleteIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteIssueModelMetadata> future =
   *       contactCenterInsightsClient.deleteIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationCallable() {
    return stub.deleteIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueModelRequest request =
   *       DeleteIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.deleteIssueModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIssueModelRequest, Operation> deleteIssueModelCallable() {
    return stub.deleteIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   DeployIssueModelResponse response =
   *       contactCenterInsightsClient.deployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to deploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelAsync(IssueModelName name) {
    DeployIssueModelRequest request =
        DeployIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   DeployIssueModelResponse response =
   *       contactCenterInsightsClient.deployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to deploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelAsync(String name) {
    DeployIssueModelRequest request = DeployIssueModelRequest.newBuilder().setName(name).build();
    return deployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployIssueModelRequest request =
   *       DeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   DeployIssueModelResponse response =
   *       contactCenterInsightsClient.deployIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelAsync(DeployIssueModelRequest request) {
    return deployIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployIssueModelRequest request =
   *       DeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata> future =
   *       contactCenterInsightsClient.deployIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployIssueModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationCallable() {
    return stub.deployIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployIssueModelRequest request =
   *       DeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.deployIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployIssueModelRequest, Operation> deployIssueModelCallable() {
    return stub.deployIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   UndeployIssueModelResponse response =
   *       contactCenterInsightsClient.undeployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to undeploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelAsync(IssueModelName name) {
    UndeployIssueModelRequest request =
        UndeployIssueModelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   UndeployIssueModelResponse response =
   *       contactCenterInsightsClient.undeployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to undeploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelAsync(String name) {
    UndeployIssueModelRequest request =
        UndeployIssueModelRequest.newBuilder().setName(name).build();
    return undeployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployIssueModelRequest request =
   *       UndeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   UndeployIssueModelResponse response =
   *       contactCenterInsightsClient.undeployIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelAsync(UndeployIssueModelRequest request) {
    return undeployIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployIssueModelRequest request =
   *       UndeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata> future =
   *       contactCenterInsightsClient.undeployIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeployIssueModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationCallable() {
    return stub.undeployIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployIssueModelRequest request =
   *       UndeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.undeployIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployIssueModelRequest, Operation> undeployIssueModelCallable() {
    return stub.undeployIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an issue model to the provided destination.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   ExportIssueModelResponse response =
   *       contactCenterInsightsClient.exportIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to export.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelAsync(IssueModelName name) {
    ExportIssueModelRequest request =
        ExportIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return exportIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an issue model to the provided destination.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   ExportIssueModelResponse response =
   *       contactCenterInsightsClient.exportIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to export.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelAsync(String name) {
    ExportIssueModelRequest request = ExportIssueModelRequest.newBuilder().setName(name).build();
    return exportIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an issue model to the provided destination.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportIssueModelRequest request =
   *       ExportIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ExportIssueModelResponse response =
   *       contactCenterInsightsClient.exportIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelAsync(ExportIssueModelRequest request) {
    return exportIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an issue model to the provided destination.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportIssueModelRequest request =
   *       ExportIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<ExportIssueModelResponse, ExportIssueModelMetadata> future =
   *       contactCenterInsightsClient.exportIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportIssueModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationCallable() {
    return stub.exportIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports an issue model to the provided destination.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportIssueModelRequest request =
   *       ExportIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.exportIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportIssueModelRequest, Operation> exportIssueModelCallable() {
    return stub.exportIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an issue model from a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportIssueModelResponse response =
   *       contactCenterInsightsClient.importIssueModelAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelAsync(LocationName parent) {
    ImportIssueModelRequest request =
        ImportIssueModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return importIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an issue model from a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ImportIssueModelResponse response =
   *       contactCenterInsightsClient.importIssueModelAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelAsync(String parent) {
    ImportIssueModelRequest request =
        ImportIssueModelRequest.newBuilder().setParent(parent).build();
    return importIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an issue model from a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ImportIssueModelRequest request =
   *       ImportIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCreateNewModel(true)
   *           .build();
   *   ImportIssueModelResponse response =
   *       contactCenterInsightsClient.importIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelAsync(ImportIssueModelRequest request) {
    return importIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an issue model from a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ImportIssueModelRequest request =
   *       ImportIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCreateNewModel(true)
   *           .build();
   *   OperationFuture<ImportIssueModelResponse, ImportIssueModelMetadata> future =
   *       contactCenterInsightsClient.importIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportIssueModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationCallable() {
    return stub.importIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an issue model from a Cloud Storage bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ImportIssueModelRequest request =
   *       ImportIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCreateNewModel(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.importIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportIssueModelRequest, Operation> importIssueModelCallable() {
    return stub.importIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");
   *   Issue response = contactCenterInsightsClient.getIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(IssueName name) {
    GetIssueRequest request =
        GetIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString();
   *   Issue response = contactCenterInsightsClient.getIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(String name) {
    GetIssueRequest request = GetIssueRequest.newBuilder().setName(name).build();
    return getIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueRequest request =
   *       GetIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
   *           .build();
   *   Issue response = contactCenterInsightsClient.getIssue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(GetIssueRequest request) {
    return getIssueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueRequest request =
   *       GetIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
   *           .build();
   *   ApiFuture<Issue> future = contactCenterInsightsClient.getIssueCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    return stub.getIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   ListIssuesResponse response = contactCenterInsightsClient.listIssues(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesResponse listIssues(IssueModelName parent) {
    ListIssuesRequest request =
        ListIssuesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   ListIssuesResponse response = contactCenterInsightsClient.listIssues(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesResponse listIssues(String parent) {
    ListIssuesRequest request = ListIssuesRequest.newBuilder().setParent(parent).build();
    return listIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ListIssuesResponse response = contactCenterInsightsClient.listIssues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesResponse listIssues(ListIssuesRequest request) {
    return listIssuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<ListIssuesResponse> future =
   *       contactCenterInsightsClient.listIssuesCallable().futureCall(request);
   *   // Do something.
   *   ListIssuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    return stub.listIssuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   Issue issue = Issue.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Issue response = contactCenterInsightsClient.updateIssue(issue, updateMask);
   * }
   * }</pre>
   *
   * @param issue Required. The new values for the issue.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue updateIssue(Issue issue, FieldMask updateMask) {
    UpdateIssueRequest request =
        UpdateIssueRequest.newBuilder().setIssue(issue).setUpdateMask(updateMask).build();
    return updateIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Issue response = contactCenterInsightsClient.updateIssue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue updateIssue(UpdateIssueRequest request) {
    return updateIssueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Issue> future =
   *       contactCenterInsightsClient.updateIssueCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIssueRequest, Issue> updateIssueCallable() {
    return stub.updateIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");
   *   contactCenterInsightsClient.deleteIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIssue(IssueName name) {
    DeleteIssueRequest request =
        DeleteIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString();
   *   contactCenterInsightsClient.deleteIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIssue(String name) {
    DeleteIssueRequest request = DeleteIssueRequest.newBuilder().setName(name).build();
    deleteIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueRequest request =
   *       DeleteIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
   *           .build();
   *   contactCenterInsightsClient.deleteIssue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIssue(DeleteIssueRequest request) {
    deleteIssueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueRequest request =
   *       DeleteIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteIssueCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIssueRequest, Empty> deleteIssueCallable() {
    return stub.deleteIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   CalculateIssueModelStatsResponse response =
   *       contactCenterInsightsClient.calculateIssueModelStats(issueModel);
   * }
   * }</pre>
   *
   * @param issueModel Required. The resource name of the issue model to query against.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateIssueModelStatsResponse calculateIssueModelStats(
      IssueModelName issueModel) {
    CalculateIssueModelStatsRequest request =
        CalculateIssueModelStatsRequest.newBuilder()
            .setIssueModel(issueModel == null ? null : issueModel.toString())
            .build();
    return calculateIssueModelStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   CalculateIssueModelStatsResponse response =
   *       contactCenterInsightsClient.calculateIssueModelStats(issueModel);
   * }
   * }</pre>
   *
   * @param issueModel Required. The resource name of the issue model to query against.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateIssueModelStatsResponse calculateIssueModelStats(String issueModel) {
    CalculateIssueModelStatsRequest request =
        CalculateIssueModelStatsRequest.newBuilder().setIssueModel(issueModel).build();
    return calculateIssueModelStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateIssueModelStatsRequest request =
   *       CalculateIssueModelStatsRequest.newBuilder()
   *           .setIssueModel(
   *               IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   CalculateIssueModelStatsResponse response =
   *       contactCenterInsightsClient.calculateIssueModelStats(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateIssueModelStatsResponse calculateIssueModelStats(
      CalculateIssueModelStatsRequest request) {
    return calculateIssueModelStatsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateIssueModelStatsRequest request =
   *       CalculateIssueModelStatsRequest.newBuilder()
   *           .setIssueModel(
   *               IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<CalculateIssueModelStatsResponse> future =
   *       contactCenterInsightsClient.calculateIssueModelStatsCallable().futureCall(request);
   *   // Do something.
   *   CalculateIssueModelStatsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsCallable() {
    return stub.calculateIssueModelStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
   *   PhraseMatcher response =
   *       contactCenterInsightsClient.createPhraseMatcher(parent, phraseMatcher);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher. Required. The location to
   *     create a phrase matcher for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;` or `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param phraseMatcher Required. The phrase matcher resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher createPhraseMatcher(LocationName parent, PhraseMatcher phraseMatcher) {
    CreatePhraseMatcherRequest request =
        CreatePhraseMatcherRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPhraseMatcher(phraseMatcher)
            .build();
    return createPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
   *   PhraseMatcher response =
   *       contactCenterInsightsClient.createPhraseMatcher(parent, phraseMatcher);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher. Required. The location to
   *     create a phrase matcher for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;` or `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param phraseMatcher Required. The phrase matcher resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher createPhraseMatcher(String parent, PhraseMatcher phraseMatcher) {
    CreatePhraseMatcherRequest request =
        CreatePhraseMatcherRequest.newBuilder()
            .setParent(parent)
            .setPhraseMatcher(phraseMatcher)
            .build();
    return createPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreatePhraseMatcherRequest request =
   *       CreatePhraseMatcherRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .build();
   *   PhraseMatcher response = contactCenterInsightsClient.createPhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher createPhraseMatcher(CreatePhraseMatcherRequest request) {
    return createPhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreatePhraseMatcherRequest request =
   *       CreatePhraseMatcherRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.createPhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   PhraseMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherCallable() {
    return stub.createPhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");
   *   PhraseMatcher response = contactCenterInsightsClient.getPhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher getPhraseMatcher(PhraseMatcherName name) {
    GetPhraseMatcherRequest request =
        GetPhraseMatcherRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString();
   *   PhraseMatcher response = contactCenterInsightsClient.getPhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher getPhraseMatcher(String name) {
    GetPhraseMatcherRequest request = GetPhraseMatcherRequest.newBuilder().setName(name).build();
    return getPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetPhraseMatcherRequest request =
   *       GetPhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   PhraseMatcher response = contactCenterInsightsClient.getPhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher getPhraseMatcher(GetPhraseMatcherRequest request) {
    return getPhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetPhraseMatcherRequest request =
   *       GetPhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.getPhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   PhraseMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherCallable() {
    return stub.getPhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PhraseMatcher element :
   *       contactCenterInsightsClient.listPhraseMatchers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseMatchersPagedResponse listPhraseMatchers(LocationName parent) {
    ListPhraseMatchersRequest request =
        ListPhraseMatchersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPhraseMatchers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PhraseMatcher element :
   *       contactCenterInsightsClient.listPhraseMatchers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseMatchersPagedResponse listPhraseMatchers(String parent) {
    ListPhraseMatchersRequest request =
        ListPhraseMatchersRequest.newBuilder().setParent(parent).build();
    return listPhraseMatchers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListPhraseMatchersRequest request =
   *       ListPhraseMatchersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PhraseMatcher element :
   *       contactCenterInsightsClient.listPhraseMatchers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseMatchersPagedResponse listPhraseMatchers(
      ListPhraseMatchersRequest request) {
    return listPhraseMatchersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListPhraseMatchersRequest request =
   *       ListPhraseMatchersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.listPhraseMatchersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PhraseMatcher element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersPagedResponse>
      listPhraseMatchersPagedCallable() {
    return stub.listPhraseMatchersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListPhraseMatchersRequest request =
   *       ListPhraseMatchersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPhraseMatchersResponse response =
   *         contactCenterInsightsClient.listPhraseMatchersCallable().call(request);
   *     for (PhraseMatcher element : response.getPhraseMatchersList()) {
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
  public final UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersCallable() {
    return stub.listPhraseMatchersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");
   *   contactCenterInsightsClient.deletePhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseMatcher(PhraseMatcherName name) {
    DeletePhraseMatcherRequest request =
        DeletePhraseMatcherRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString();
   *   contactCenterInsightsClient.deletePhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseMatcher(String name) {
    DeletePhraseMatcherRequest request =
        DeletePhraseMatcherRequest.newBuilder().setName(name).build();
    deletePhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeletePhraseMatcherRequest request =
   *       DeletePhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   contactCenterInsightsClient.deletePhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseMatcher(DeletePhraseMatcherRequest request) {
    deletePhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeletePhraseMatcherRequest request =
   *       DeletePhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deletePhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherCallable() {
    return stub.deletePhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PhraseMatcher response =
   *       contactCenterInsightsClient.updatePhraseMatcher(phraseMatcher, updateMask);
   * }
   * }</pre>
   *
   * @param phraseMatcher Required. The new values for the phrase matcher.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher updatePhraseMatcher(
      PhraseMatcher phraseMatcher, FieldMask updateMask) {
    UpdatePhraseMatcherRequest request =
        UpdatePhraseMatcherRequest.newBuilder()
            .setPhraseMatcher(phraseMatcher)
            .setUpdateMask(updateMask)
            .build();
    return updatePhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdatePhraseMatcherRequest request =
   *       UpdatePhraseMatcherRequest.newBuilder()
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PhraseMatcher response = contactCenterInsightsClient.updatePhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher updatePhraseMatcher(UpdatePhraseMatcherRequest request) {
    return updatePhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdatePhraseMatcherRequest request =
   *       UpdatePhraseMatcherRequest.newBuilder()
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.updatePhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   PhraseMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherCallable() {
    return stub.updatePhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CalculateStatsResponse response = contactCenterInsightsClient.calculateStats(location);
   * }
   * }</pre>
   *
   * @param location Required. The location of the conversations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateStatsResponse calculateStats(LocationName location) {
    CalculateStatsRequest request =
        CalculateStatsRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .build();
    return calculateStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CalculateStatsResponse response = contactCenterInsightsClient.calculateStats(location);
   * }
   * }</pre>
   *
   * @param location Required. The location of the conversations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateStatsResponse calculateStats(String location) {
    CalculateStatsRequest request =
        CalculateStatsRequest.newBuilder().setLocation(location).build();
    return calculateStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateStatsRequest request =
   *       CalculateStatsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   CalculateStatsResponse response = contactCenterInsightsClient.calculateStats(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateStatsResponse calculateStats(CalculateStatsRequest request) {
    return calculateStatsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateStatsRequest request =
   *       CalculateStatsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<CalculateStatsResponse> future =
   *       contactCenterInsightsClient.calculateStatsCallable().futureCall(request);
   *   // Do something.
   *   CalculateStatsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CalculateStatsRequest, CalculateStatsResponse>
      calculateStatsCallable() {
    return stub.calculateStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");
   *   Settings response = contactCenterInsightsClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = SettingsName.of("[PROJECT]", "[LOCATION]").toString();
   *   Settings response = contactCenterInsightsClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Settings response = contactCenterInsightsClient.getSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(GetSettingsRequest request) {
    return getSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Settings> future =
   *       contactCenterInsightsClient.getSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return stub.getSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   Settings settings = Settings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Settings response = contactCenterInsightsClient.updateSettings(settings, updateMask);
   * }
   * }</pre>
   *
   * @param settings Required. The new settings values.
   * @param updateMask Required. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Settings response = contactCenterInsightsClient.updateSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(UpdateSettingsRequest request) {
    return updateSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Settings> future =
   *       contactCenterInsightsClient.updateSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
   *   AnalysisRule response = contactCenterInsightsClient.createAnalysisRule(parent, analysisRule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis rule. Required. The location to
   *     create a analysis rule for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;` or `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param analysisRule Required. The analysis rule resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule createAnalysisRule(LocationName parent, AnalysisRule analysisRule) {
    CreateAnalysisRuleRequest request =
        CreateAnalysisRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnalysisRule(analysisRule)
            .build();
    return createAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
   *   AnalysisRule response = contactCenterInsightsClient.createAnalysisRule(parent, analysisRule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis rule. Required. The location to
   *     create a analysis rule for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;` or `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param analysisRule Required. The analysis rule resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule createAnalysisRule(String parent, AnalysisRule analysisRule) {
    CreateAnalysisRuleRequest request =
        CreateAnalysisRuleRequest.newBuilder()
            .setParent(parent)
            .setAnalysisRule(analysisRule)
            .build();
    return createAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRuleRequest request =
   *       CreateAnalysisRuleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAnalysisRule(AnalysisRule.newBuilder().build())
   *           .build();
   *   AnalysisRule response = contactCenterInsightsClient.createAnalysisRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule createAnalysisRule(CreateAnalysisRuleRequest request) {
    return createAnalysisRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRuleRequest request =
   *       CreateAnalysisRuleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAnalysisRule(AnalysisRule.newBuilder().build())
   *           .build();
   *   ApiFuture<AnalysisRule> future =
   *       contactCenterInsightsClient.createAnalysisRuleCallable().futureCall(request);
   *   // Do something.
   *   AnalysisRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleCallable() {
    return stub.createAnalysisRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");
   *   AnalysisRule response = contactCenterInsightsClient.getAnalysisRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnalysisRule to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule getAnalysisRule(AnalysisRuleName name) {
    GetAnalysisRuleRequest request =
        GetAnalysisRuleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString();
   *   AnalysisRule response = contactCenterInsightsClient.getAnalysisRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnalysisRule to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule getAnalysisRule(String name) {
    GetAnalysisRuleRequest request = GetAnalysisRuleRequest.newBuilder().setName(name).build();
    return getAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetAnalysisRuleRequest request =
   *       GetAnalysisRuleRequest.newBuilder()
   *           .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
   *           .build();
   *   AnalysisRule response = contactCenterInsightsClient.getAnalysisRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule getAnalysisRule(GetAnalysisRuleRequest request) {
    return getAnalysisRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetAnalysisRuleRequest request =
   *       GetAnalysisRuleRequest.newBuilder()
   *           .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
   *           .build();
   *   ApiFuture<AnalysisRule> future =
   *       contactCenterInsightsClient.getAnalysisRuleCallable().futureCall(request);
   *   // Do something.
   *   AnalysisRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleCallable() {
    return stub.getAnalysisRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analysis rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AnalysisRule element :
   *       contactCenterInsightsClient.listAnalysisRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysisRulesPagedResponse listAnalysisRules(LocationName parent) {
    ListAnalysisRulesRequest request =
        ListAnalysisRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalysisRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analysis rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AnalysisRule element :
   *       contactCenterInsightsClient.listAnalysisRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysisRulesPagedResponse listAnalysisRules(String parent) {
    ListAnalysisRulesRequest request =
        ListAnalysisRulesRequest.newBuilder().setParent(parent).build();
    return listAnalysisRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analysis rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysisRulesRequest request =
   *       ListAnalysisRulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AnalysisRule element :
   *       contactCenterInsightsClient.listAnalysisRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysisRulesPagedResponse listAnalysisRules(ListAnalysisRulesRequest request) {
    return listAnalysisRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analysis rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysisRulesRequest request =
   *       ListAnalysisRulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AnalysisRule> future =
   *       contactCenterInsightsClient.listAnalysisRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AnalysisRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesPagedResponse>
      listAnalysisRulesPagedCallable() {
    return stub.listAnalysisRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analysis rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysisRulesRequest request =
   *       ListAnalysisRulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAnalysisRulesResponse response =
   *         contactCenterInsightsClient.listAnalysisRulesCallable().call(request);
   *     for (AnalysisRule element : response.getAnalysisRulesList()) {
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
  public final UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
      listAnalysisRulesCallable() {
    return stub.listAnalysisRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AnalysisRule response =
   *       contactCenterInsightsClient.updateAnalysisRule(analysisRule, updateMask);
   * }
   * }</pre>
   *
   * @param analysisRule Required. The new analysis rule.
   * @param updateMask Optional. The list of fields to be updated. If the update_mask is not
   *     provided, the update will be applied to all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule updateAnalysisRule(AnalysisRule analysisRule, FieldMask updateMask) {
    UpdateAnalysisRuleRequest request =
        UpdateAnalysisRuleRequest.newBuilder()
            .setAnalysisRule(analysisRule)
            .setUpdateMask(updateMask)
            .build();
    return updateAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateAnalysisRuleRequest request =
   *       UpdateAnalysisRuleRequest.newBuilder()
   *           .setAnalysisRule(AnalysisRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AnalysisRule response = contactCenterInsightsClient.updateAnalysisRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalysisRule updateAnalysisRule(UpdateAnalysisRuleRequest request) {
    return updateAnalysisRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateAnalysisRuleRequest request =
   *       UpdateAnalysisRuleRequest.newBuilder()
   *           .setAnalysisRule(AnalysisRule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AnalysisRule> future =
   *       contactCenterInsightsClient.updateAnalysisRuleCallable().futureCall(request);
   *   // Do something.
   *   AnalysisRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleCallable() {
    return stub.updateAnalysisRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");
   *   contactCenterInsightsClient.deleteAnalysisRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysisRule(AnalysisRuleName name) {
    DeleteAnalysisRuleRequest request =
        DeleteAnalysisRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString();
   *   contactCenterInsightsClient.deleteAnalysisRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysisRule(String name) {
    DeleteAnalysisRuleRequest request =
        DeleteAnalysisRuleRequest.newBuilder().setName(name).build();
    deleteAnalysisRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteAnalysisRuleRequest request =
   *       DeleteAnalysisRuleRequest.newBuilder()
   *           .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
   *           .build();
   *   contactCenterInsightsClient.deleteAnalysisRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysisRule(DeleteAnalysisRuleRequest request) {
    deleteAnalysisRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a analysis rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteAnalysisRuleRequest request =
   *       DeleteAnalysisRuleRequest.newBuilder()
   *           .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteAnalysisRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleCallable() {
    return stub.deleteAnalysisRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   EncryptionSpecName name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]");
   *   EncryptionSpec response = contactCenterInsightsClient.getEncryptionSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the encryption spec resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionSpec getEncryptionSpec(EncryptionSpecName name) {
    GetEncryptionSpecRequest request =
        GetEncryptionSpecRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEncryptionSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString();
   *   EncryptionSpec response = contactCenterInsightsClient.getEncryptionSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the encryption spec resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionSpec getEncryptionSpec(String name) {
    GetEncryptionSpecRequest request = GetEncryptionSpecRequest.newBuilder().setName(name).build();
    return getEncryptionSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetEncryptionSpecRequest request =
   *       GetEncryptionSpecRequest.newBuilder()
   *           .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   EncryptionSpec response = contactCenterInsightsClient.getEncryptionSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionSpec getEncryptionSpec(GetEncryptionSpecRequest request) {
    return getEncryptionSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetEncryptionSpecRequest request =
   *       GetEncryptionSpecRequest.newBuilder()
   *           .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<EncryptionSpec> future =
   *       contactCenterInsightsClient.getEncryptionSpecCallable().futureCall(request);
   *   // Do something.
   *   EncryptionSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecCallable() {
    return stub.getEncryptionSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will result if the location
   * has resources already created before the initialization. After the encryption specification is
   * initialized at a location, it is immutable and all newly created resources under the location
   * will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   EncryptionSpec encryptionSpec = EncryptionSpec.newBuilder().build();
   *   InitializeEncryptionSpecResponse response =
   *       contactCenterInsightsClient.initializeEncryptionSpecAsync(encryptionSpec).get();
   * }
   * }</pre>
   *
   * @param encryptionSpec Required. The encryption spec used for CMEK encryption. It is required
   *     that the kms key is in the same region as the endpoint. The same key will be used for all
   *     provisioned resources, if encryption is available. If the `kms_key_name` field is left
   *     empty, no encryption will be enforced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InitializeEncryptionSpecResponse, InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecAsync(EncryptionSpec encryptionSpec) {
    InitializeEncryptionSpecRequest request =
        InitializeEncryptionSpecRequest.newBuilder().setEncryptionSpec(encryptionSpec).build();
    return initializeEncryptionSpecAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will result if the location
   * has resources already created before the initialization. After the encryption specification is
   * initialized at a location, it is immutable and all newly created resources under the location
   * will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   InitializeEncryptionSpecRequest request =
   *       InitializeEncryptionSpecRequest.newBuilder()
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   InitializeEncryptionSpecResponse response =
   *       contactCenterInsightsClient.initializeEncryptionSpecAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InitializeEncryptionSpecResponse, InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecAsync(InitializeEncryptionSpecRequest request) {
    return initializeEncryptionSpecOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will result if the location
   * has resources already created before the initialization. After the encryption specification is
   * initialized at a location, it is immutable and all newly created resources under the location
   * will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   InitializeEncryptionSpecRequest request =
   *       InitializeEncryptionSpecRequest.newBuilder()
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   OperationFuture<InitializeEncryptionSpecResponse, InitializeEncryptionSpecMetadata> future =
   *       contactCenterInsightsClient
   *           .initializeEncryptionSpecOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   InitializeEncryptionSpecResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationCallable() {
    return stub.initializeEncryptionSpecOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will result if the location
   * has resources already created before the initialization. After the encryption specification is
   * initialized at a location, it is immutable and all newly created resources under the location
   * will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   InitializeEncryptionSpecRequest request =
   *       InitializeEncryptionSpecRequest.newBuilder()
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.initializeEncryptionSpecCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecCallable() {
    return stub.initializeEncryptionSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   View view = View.newBuilder().build();
   *   View response = contactCenterInsightsClient.createView(parent, view);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the view. Required. The location to create a
   *     view for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;` or
   *     `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param view Required. The view resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View createView(LocationName parent, View view) {
    CreateViewRequest request =
        CreateViewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setView(view)
            .build();
    return createView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   View view = View.newBuilder().build();
   *   View response = contactCenterInsightsClient.createView(parent, view);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the view. Required. The location to create a
   *     view for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;` or
   *     `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param view Required. The view resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View createView(String parent, View view) {
    CreateViewRequest request =
        CreateViewRequest.newBuilder().setParent(parent).setView(view).build();
    return createView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateViewRequest request =
   *       CreateViewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setView(View.newBuilder().build())
   *           .build();
   *   View response = contactCenterInsightsClient.createView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View createView(CreateViewRequest request) {
    return createViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateViewRequest request =
   *       CreateViewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setView(View.newBuilder().build())
   *           .build();
   *   ApiFuture<View> future = contactCenterInsightsClient.createViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateViewRequest, View> createViewCallable() {
    return stub.createViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");
   *   View response = contactCenterInsightsClient.getView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(ViewName name) {
    GetViewRequest request =
        GetViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString();
   *   View response = contactCenterInsightsClient.getView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(String name) {
    GetViewRequest request = GetViewRequest.newBuilder().setName(name).build();
    return getView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   View response = contactCenterInsightsClient.getView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(GetViewRequest request) {
    return getViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   ApiFuture<View> future = contactCenterInsightsClient.getViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetViewRequest, View> getViewCallable() {
    return stub.getViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (View element : contactCenterInsightsClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the views.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(LocationName parent) {
    ListViewsRequest request =
        ListViewsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (View element : contactCenterInsightsClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the views.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(String parent) {
    ListViewsRequest request = ListViewsRequest.newBuilder().setParent(parent).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (View element : contactCenterInsightsClient.listViews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(ListViewsRequest request) {
    return listViewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<View> future =
   *       contactCenterInsightsClient.listViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (View element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return stub.listViewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListViewsResponse response = contactCenterInsightsClient.listViewsCallable().call(request);
   *     for (View element : response.getViewsList()) {
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
  public final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return stub.listViewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   View view = View.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   View response = contactCenterInsightsClient.updateView(view, updateMask);
   * }
   * }</pre>
   *
   * @param view Required. The new view.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View updateView(View view, FieldMask updateMask) {
    UpdateViewRequest request =
        UpdateViewRequest.newBuilder().setView(view).setUpdateMask(updateMask).build();
    return updateView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateViewRequest request =
   *       UpdateViewRequest.newBuilder()
   *           .setView(View.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   View response = contactCenterInsightsClient.updateView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View updateView(UpdateViewRequest request) {
    return updateViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateViewRequest request =
   *       UpdateViewRequest.newBuilder()
   *           .setView(View.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<View> future = contactCenterInsightsClient.updateViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateViewRequest, View> updateViewCallable() {
    return stub.updateViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");
   *   contactCenterInsightsClient.deleteView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(ViewName name) {
    DeleteViewRequest request =
        DeleteViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString();
   *   contactCenterInsightsClient.deleteView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(String name) {
    DeleteViewRequest request = DeleteViewRequest.newBuilder().setName(name).build();
    deleteView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteViewRequest request =
   *       DeleteViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   contactCenterInsightsClient.deleteView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(DeleteViewRequest request) {
    deleteViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteViewRequest request =
   *       DeleteViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteViewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    return stub.deleteViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QueryMetricsRequest request =
   *       QueryMetricsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .setMeasureMask(FieldMask.newBuilder().build())
   *           .build();
   *   QueryMetricsResponse response = contactCenterInsightsClient.queryMetricsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<QueryMetricsResponse, QueryMetricsMetadata> queryMetricsAsync(
      QueryMetricsRequest request) {
    return queryMetricsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QueryMetricsRequest request =
   *       QueryMetricsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .setMeasureMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<QueryMetricsResponse, QueryMetricsMetadata> future =
   *       contactCenterInsightsClient.queryMetricsOperationCallable().futureCall(request);
   *   // Do something.
   *   QueryMetricsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationCallable() {
    return stub.queryMetricsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query metrics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QueryMetricsRequest request =
   *       QueryMetricsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .setMeasureMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.queryMetricsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryMetricsRequest, Operation> queryMetricsCallable() {
    return stub.queryMetricsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardRevisionName parent =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
   *   QaQuestion qaQuestion = QaQuestion.newBuilder().build();
   *   String qaQuestionId = "qaQuestionId1774614993";
   *   QaQuestion response =
   *       contactCenterInsightsClient.createQaQuestion(parent, qaQuestion, qaQuestionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the QaQuestion.
   * @param qaQuestion Required. The QaQuestion to create.
   * @param qaQuestionId Optional. A unique ID for the new question. This ID will become the final
   *     component of the question's resource name. If no ID is specified, a server-generated ID
   *     will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion createQaQuestion(
      QaScorecardRevisionName parent, QaQuestion qaQuestion, String qaQuestionId) {
    CreateQaQuestionRequest request =
        CreateQaQuestionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQaQuestion(qaQuestion)
            .setQaQuestionId(qaQuestionId)
            .build();
    return createQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *           .toString();
   *   QaQuestion qaQuestion = QaQuestion.newBuilder().build();
   *   String qaQuestionId = "qaQuestionId1774614993";
   *   QaQuestion response =
   *       contactCenterInsightsClient.createQaQuestion(parent, qaQuestion, qaQuestionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the QaQuestion.
   * @param qaQuestion Required. The QaQuestion to create.
   * @param qaQuestionId Optional. A unique ID for the new question. This ID will become the final
   *     component of the question's resource name. If no ID is specified, a server-generated ID
   *     will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion createQaQuestion(
      String parent, QaQuestion qaQuestion, String qaQuestionId) {
    CreateQaQuestionRequest request =
        CreateQaQuestionRequest.newBuilder()
            .setParent(parent)
            .setQaQuestion(qaQuestion)
            .setQaQuestionId(qaQuestionId)
            .build();
    return createQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateQaQuestionRequest request =
   *       CreateQaQuestionRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setQaQuestion(QaQuestion.newBuilder().build())
   *           .setQaQuestionId("qaQuestionId1774614993")
   *           .build();
   *   QaQuestion response = contactCenterInsightsClient.createQaQuestion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion createQaQuestion(CreateQaQuestionRequest request) {
    return createQaQuestionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateQaQuestionRequest request =
   *       CreateQaQuestionRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setQaQuestion(QaQuestion.newBuilder().build())
   *           .setQaQuestionId("qaQuestionId1774614993")
   *           .build();
   *   ApiFuture<QaQuestion> future =
   *       contactCenterInsightsClient.createQaQuestionCallable().futureCall(request);
   *   // Do something.
   *   QaQuestion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateQaQuestionRequest, QaQuestion> createQaQuestionCallable() {
    return stub.createQaQuestionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaQuestionName name =
   *       QaQuestionName.of(
   *           "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");
   *   QaQuestion response = contactCenterInsightsClient.getQaQuestion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaQuestion to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion getQaQuestion(QaQuestionName name) {
    GetQaQuestionRequest request =
        GetQaQuestionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       QaQuestionName.of(
   *               "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
   *           .toString();
   *   QaQuestion response = contactCenterInsightsClient.getQaQuestion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaQuestion to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion getQaQuestion(String name) {
    GetQaQuestionRequest request = GetQaQuestionRequest.newBuilder().setName(name).build();
    return getQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetQaQuestionRequest request =
   *       GetQaQuestionRequest.newBuilder()
   *           .setName(
   *               QaQuestionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[QA_SCORECARD]",
   *                       "[REVISION]",
   *                       "[QA_QUESTION]")
   *                   .toString())
   *           .build();
   *   QaQuestion response = contactCenterInsightsClient.getQaQuestion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion getQaQuestion(GetQaQuestionRequest request) {
    return getQaQuestionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetQaQuestionRequest request =
   *       GetQaQuestionRequest.newBuilder()
   *           .setName(
   *               QaQuestionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[QA_SCORECARD]",
   *                       "[REVISION]",
   *                       "[QA_QUESTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<QaQuestion> future =
   *       contactCenterInsightsClient.getQaQuestionCallable().futureCall(request);
   *   // Do something.
   *   QaQuestion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetQaQuestionRequest, QaQuestion> getQaQuestionCallable() {
    return stub.getQaQuestionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaQuestion qaQuestion = QaQuestion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   QaQuestion response = contactCenterInsightsClient.updateQaQuestion(qaQuestion, updateMask);
   * }
   * }</pre>
   *
   * @param qaQuestion Required. The QaQuestion to update.
   * @param updateMask Required. The list of fields to be updated. All possible fields can be
   *     updated by passing `&#42;`, or a subset of the following updateable fields can be provided:
   *     <ul>
   *       <li>`abbreviation`
   *       <li>`answer_choices`
   *       <li>`answer_instructions`
   *       <li>`order`
   *       <li>`question_body`
   *       <li>`tags`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion updateQaQuestion(QaQuestion qaQuestion, FieldMask updateMask) {
    UpdateQaQuestionRequest request =
        UpdateQaQuestionRequest.newBuilder()
            .setQaQuestion(qaQuestion)
            .setUpdateMask(updateMask)
            .build();
    return updateQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateQaQuestionRequest request =
   *       UpdateQaQuestionRequest.newBuilder()
   *           .setQaQuestion(QaQuestion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   QaQuestion response = contactCenterInsightsClient.updateQaQuestion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaQuestion updateQaQuestion(UpdateQaQuestionRequest request) {
    return updateQaQuestionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateQaQuestionRequest request =
   *       UpdateQaQuestionRequest.newBuilder()
   *           .setQaQuestion(QaQuestion.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<QaQuestion> future =
   *       contactCenterInsightsClient.updateQaQuestionCallable().futureCall(request);
   *   // Do something.
   *   QaQuestion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionCallable() {
    return stub.updateQaQuestionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaQuestionName name =
   *       QaQuestionName.of(
   *           "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");
   *   contactCenterInsightsClient.deleteQaQuestion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaQuestion to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaQuestion(QaQuestionName name) {
    DeleteQaQuestionRequest request =
        DeleteQaQuestionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       QaQuestionName.of(
   *               "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
   *           .toString();
   *   contactCenterInsightsClient.deleteQaQuestion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaQuestion to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaQuestion(String name) {
    DeleteQaQuestionRequest request = DeleteQaQuestionRequest.newBuilder().setName(name).build();
    deleteQaQuestion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteQaQuestionRequest request =
   *       DeleteQaQuestionRequest.newBuilder()
   *           .setName(
   *               QaQuestionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[QA_SCORECARD]",
   *                       "[REVISION]",
   *                       "[QA_QUESTION]")
   *                   .toString())
   *           .build();
   *   contactCenterInsightsClient.deleteQaQuestion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaQuestion(DeleteQaQuestionRequest request) {
    deleteQaQuestionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaQuestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteQaQuestionRequest request =
   *       DeleteQaQuestionRequest.newBuilder()
   *           .setName(
   *               QaQuestionName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[QA_SCORECARD]",
   *                       "[REVISION]",
   *                       "[QA_QUESTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteQaQuestionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteQaQuestionRequest, Empty> deleteQaQuestionCallable() {
    return stub.deleteQaQuestionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaQuestions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardRevisionName parent =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
   *   for (QaQuestion element : contactCenterInsightsClient.listQaQuestions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the questions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaQuestionsPagedResponse listQaQuestions(QaScorecardRevisionName parent) {
    ListQaQuestionsRequest request =
        ListQaQuestionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listQaQuestions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaQuestions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *           .toString();
   *   for (QaQuestion element : contactCenterInsightsClient.listQaQuestions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the questions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaQuestionsPagedResponse listQaQuestions(String parent) {
    ListQaQuestionsRequest request = ListQaQuestionsRequest.newBuilder().setParent(parent).build();
    return listQaQuestions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaQuestions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaQuestionsRequest request =
   *       ListQaQuestionsRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (QaQuestion element : contactCenterInsightsClient.listQaQuestions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaQuestionsPagedResponse listQaQuestions(ListQaQuestionsRequest request) {
    return listQaQuestionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaQuestions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaQuestionsRequest request =
   *       ListQaQuestionsRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<QaQuestion> future =
   *       contactCenterInsightsClient.listQaQuestionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QaQuestion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsPagedResponse>
      listQaQuestionsPagedCallable() {
    return stub.listQaQuestionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaQuestions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaQuestionsRequest request =
   *       ListQaQuestionsRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListQaQuestionsResponse response =
   *         contactCenterInsightsClient.listQaQuestionsCallable().call(request);
   *     for (QaQuestion element : response.getQaQuestionsList()) {
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
  public final UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsResponse>
      listQaQuestionsCallable() {
    return stub.listQaQuestionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   QaScorecard qaScorecard = QaScorecard.newBuilder().build();
   *   String qaScorecardId = "qaScorecardId167098669";
   *   QaScorecard response =
   *       contactCenterInsightsClient.createQaScorecard(parent, qaScorecard, qaScorecardId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the QaScorecard.
   * @param qaScorecard Required. The QaScorecard to create.
   * @param qaScorecardId Optional. A unique ID for the new QaScorecard. This ID will become the
   *     final component of the QaScorecard's resource name. If no ID is specified, a
   *     server-generated ID will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard createQaScorecard(
      LocationName parent, QaScorecard qaScorecard, String qaScorecardId) {
    CreateQaScorecardRequest request =
        CreateQaScorecardRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQaScorecard(qaScorecard)
            .setQaScorecardId(qaScorecardId)
            .build();
    return createQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   QaScorecard qaScorecard = QaScorecard.newBuilder().build();
   *   String qaScorecardId = "qaScorecardId167098669";
   *   QaScorecard response =
   *       contactCenterInsightsClient.createQaScorecard(parent, qaScorecard, qaScorecardId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the QaScorecard.
   * @param qaScorecard Required. The QaScorecard to create.
   * @param qaScorecardId Optional. A unique ID for the new QaScorecard. This ID will become the
   *     final component of the QaScorecard's resource name. If no ID is specified, a
   *     server-generated ID will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard createQaScorecard(
      String parent, QaScorecard qaScorecard, String qaScorecardId) {
    CreateQaScorecardRequest request =
        CreateQaScorecardRequest.newBuilder()
            .setParent(parent)
            .setQaScorecard(qaScorecard)
            .setQaScorecardId(qaScorecardId)
            .build();
    return createQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateQaScorecardRequest request =
   *       CreateQaScorecardRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQaScorecard(QaScorecard.newBuilder().build())
   *           .setQaScorecardId("qaScorecardId167098669")
   *           .build();
   *   QaScorecard response = contactCenterInsightsClient.createQaScorecard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard createQaScorecard(CreateQaScorecardRequest request) {
    return createQaScorecardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateQaScorecardRequest request =
   *       CreateQaScorecardRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQaScorecard(QaScorecard.newBuilder().build())
   *           .setQaScorecardId("qaScorecardId167098669")
   *           .build();
   *   ApiFuture<QaScorecard> future =
   *       contactCenterInsightsClient.createQaScorecardCallable().futureCall(request);
   *   // Do something.
   *   QaScorecard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateQaScorecardRequest, QaScorecard> createQaScorecardCallable() {
    return stub.createQaScorecardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
   *   QaScorecard response = contactCenterInsightsClient.getQaScorecard(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecard to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard getQaScorecard(QaScorecardName name) {
    GetQaScorecardRequest request =
        GetQaScorecardRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString();
   *   QaScorecard response = contactCenterInsightsClient.getQaScorecard(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecard to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard getQaScorecard(String name) {
    GetQaScorecardRequest request = GetQaScorecardRequest.newBuilder().setName(name).build();
    return getQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetQaScorecardRequest request =
   *       GetQaScorecardRequest.newBuilder()
   *           .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .build();
   *   QaScorecard response = contactCenterInsightsClient.getQaScorecard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard getQaScorecard(GetQaScorecardRequest request) {
    return getQaScorecardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetQaScorecardRequest request =
   *       GetQaScorecardRequest.newBuilder()
   *           .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .build();
   *   ApiFuture<QaScorecard> future =
   *       contactCenterInsightsClient.getQaScorecardCallable().futureCall(request);
   *   // Do something.
   *   QaScorecard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetQaScorecardRequest, QaScorecard> getQaScorecardCallable() {
    return stub.getQaScorecardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecard qaScorecard = QaScorecard.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   QaScorecard response = contactCenterInsightsClient.updateQaScorecard(qaScorecard, updateMask);
   * }
   * }</pre>
   *
   * @param qaScorecard Required. The QaScorecard to update.
   * @param updateMask Required. The list of fields to be updated. All possible fields can be
   *     updated by passing `&#42;`, or a subset of the following updateable fields can be provided:
   *     <ul>
   *       <li>`description`
   *       <li>`display_name`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard updateQaScorecard(QaScorecard qaScorecard, FieldMask updateMask) {
    UpdateQaScorecardRequest request =
        UpdateQaScorecardRequest.newBuilder()
            .setQaScorecard(qaScorecard)
            .setUpdateMask(updateMask)
            .build();
    return updateQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateQaScorecardRequest request =
   *       UpdateQaScorecardRequest.newBuilder()
   *           .setQaScorecard(QaScorecard.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   QaScorecard response = contactCenterInsightsClient.updateQaScorecard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecard updateQaScorecard(UpdateQaScorecardRequest request) {
    return updateQaScorecardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateQaScorecardRequest request =
   *       UpdateQaScorecardRequest.newBuilder()
   *           .setQaScorecard(QaScorecard.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<QaScorecard> future =
   *       contactCenterInsightsClient.updateQaScorecardCallable().futureCall(request);
   *   // Do something.
   *   QaScorecard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardCallable() {
    return stub.updateQaScorecardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
   *   contactCenterInsightsClient.deleteQaScorecard(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecard to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaScorecard(QaScorecardName name) {
    DeleteQaScorecardRequest request =
        DeleteQaScorecardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString();
   *   contactCenterInsightsClient.deleteQaScorecard(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecard to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaScorecard(String name) {
    DeleteQaScorecardRequest request = DeleteQaScorecardRequest.newBuilder().setName(name).build();
    deleteQaScorecard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteQaScorecardRequest request =
   *       DeleteQaScorecardRequest.newBuilder()
   *           .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setForce(true)
   *           .build();
   *   contactCenterInsightsClient.deleteQaScorecard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaScorecard(DeleteQaScorecardRequest request) {
    deleteQaScorecardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteQaScorecardRequest request =
   *       DeleteQaScorecardRequest.newBuilder()
   *           .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteQaScorecardCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteQaScorecardRequest, Empty> deleteQaScorecardCallable() {
    return stub.deleteQaScorecardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaScorecards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (QaScorecard element :
   *       contactCenterInsightsClient.listQaScorecards(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the scorecards.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaScorecardsPagedResponse listQaScorecards(LocationName parent) {
    ListQaScorecardsRequest request =
        ListQaScorecardsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listQaScorecards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaScorecards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (QaScorecard element :
   *       contactCenterInsightsClient.listQaScorecards(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the scorecards.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaScorecardsPagedResponse listQaScorecards(String parent) {
    ListQaScorecardsRequest request =
        ListQaScorecardsRequest.newBuilder().setParent(parent).build();
    return listQaScorecards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaScorecards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaScorecardsRequest request =
   *       ListQaScorecardsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (QaScorecard element :
   *       contactCenterInsightsClient.listQaScorecards(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaScorecardsPagedResponse listQaScorecards(ListQaScorecardsRequest request) {
    return listQaScorecardsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaScorecards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaScorecardsRequest request =
   *       ListQaScorecardsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<QaScorecard> future =
   *       contactCenterInsightsClient.listQaScorecardsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QaScorecard element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsPagedResponse>
      listQaScorecardsPagedCallable() {
    return stub.listQaScorecardsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QaScorecards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaScorecardsRequest request =
   *       ListQaScorecardsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListQaScorecardsResponse response =
   *         contactCenterInsightsClient.listQaScorecardsCallable().call(request);
   *     for (QaScorecard element : response.getQaScorecardsList()) {
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
  public final UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsResponse>
      listQaScorecardsCallable() {
    return stub.listQaScorecardsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
   *   QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
   *   String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";
   *   QaScorecardRevision response =
   *       contactCenterInsightsClient.createQaScorecardRevision(
   *           parent, qaScorecardRevision, qaScorecardRevisionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the QaScorecardRevision.
   * @param qaScorecardRevision Required. The QaScorecardRevision to create.
   * @param qaScorecardRevisionId Optional. A unique ID for the new QaScorecardRevision. This ID
   *     will become the final component of the QaScorecardRevision's resource name. If no ID is
   *     specified, a server-generated ID will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision createQaScorecardRevision(
      QaScorecardName parent,
      QaScorecardRevision qaScorecardRevision,
      String qaScorecardRevisionId) {
    CreateQaScorecardRevisionRequest request =
        CreateQaScorecardRevisionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQaScorecardRevision(qaScorecardRevision)
            .setQaScorecardRevisionId(qaScorecardRevisionId)
            .build();
    return createQaScorecardRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString();
   *   QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
   *   String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";
   *   QaScorecardRevision response =
   *       contactCenterInsightsClient.createQaScorecardRevision(
   *           parent, qaScorecardRevision, qaScorecardRevisionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the QaScorecardRevision.
   * @param qaScorecardRevision Required. The QaScorecardRevision to create.
   * @param qaScorecardRevisionId Optional. A unique ID for the new QaScorecardRevision. This ID
   *     will become the final component of the QaScorecardRevision's resource name. If no ID is
   *     specified, a server-generated ID will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision createQaScorecardRevision(
      String parent, QaScorecardRevision qaScorecardRevision, String qaScorecardRevisionId) {
    CreateQaScorecardRevisionRequest request =
        CreateQaScorecardRevisionRequest.newBuilder()
            .setParent(parent)
            .setQaScorecardRevision(qaScorecardRevision)
            .setQaScorecardRevisionId(qaScorecardRevisionId)
            .build();
    return createQaScorecardRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateQaScorecardRevisionRequest request =
   *       CreateQaScorecardRevisionRequest.newBuilder()
   *           .setParent(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setQaScorecardRevision(QaScorecardRevision.newBuilder().build())
   *           .setQaScorecardRevisionId("qaScorecardRevisionId1384099944")
   *           .build();
   *   QaScorecardRevision response = contactCenterInsightsClient.createQaScorecardRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision createQaScorecardRevision(
      CreateQaScorecardRevisionRequest request) {
    return createQaScorecardRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateQaScorecardRevisionRequest request =
   *       CreateQaScorecardRevisionRequest.newBuilder()
   *           .setParent(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setQaScorecardRevision(QaScorecardRevision.newBuilder().build())
   *           .setQaScorecardRevisionId("qaScorecardRevisionId1384099944")
   *           .build();
   *   ApiFuture<QaScorecardRevision> future =
   *       contactCenterInsightsClient.createQaScorecardRevisionCallable().futureCall(request);
   *   // Do something.
   *   QaScorecardRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionCallable() {
    return stub.createQaScorecardRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardRevisionName name =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
   *   QaScorecardRevision response = contactCenterInsightsClient.getQaScorecardRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecardRevision to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision getQaScorecardRevision(QaScorecardRevisionName name) {
    GetQaScorecardRevisionRequest request =
        GetQaScorecardRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getQaScorecardRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *           .toString();
   *   QaScorecardRevision response = contactCenterInsightsClient.getQaScorecardRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecardRevision to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision getQaScorecardRevision(String name) {
    GetQaScorecardRevisionRequest request =
        GetQaScorecardRevisionRequest.newBuilder().setName(name).build();
    return getQaScorecardRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetQaScorecardRevisionRequest request =
   *       GetQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   QaScorecardRevision response = contactCenterInsightsClient.getQaScorecardRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision getQaScorecardRevision(GetQaScorecardRevisionRequest request) {
    return getQaScorecardRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetQaScorecardRevisionRequest request =
   *       GetQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<QaScorecardRevision> future =
   *       contactCenterInsightsClient.getQaScorecardRevisionCallable().futureCall(request);
   *   // Do something.
   *   QaScorecardRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionCallable() {
    return stub.getQaScorecardRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fine tune one or more QaModels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardRevisionName parent =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
   *   String filter = "filter-1274492040";
   *   boolean validateOnly = true;
   *   TuneQaScorecardRevisionResponse response =
   *       contactCenterInsightsClient
   *           .tuneQaScorecardRevisionAsync(parent, filter, validateOnly)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new fine tuning job instance.
   * @param filter Required. Filter for selecting the feedback labels that needs to be used for
   *     training. This filter can be used to limit the feedback labels used for tuning to a
   *     feedback labels created or updated for a specific time-window etc.
   * @param validateOnly Optional. Run in validate only mode, no fine tuning will actually run. Data
   *     quality validations like training data distributions will run. Even when set to false, the
   *     data quality validations will still run but once the validations complete we will proceed
   *     with the fine tune, if applicable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TuneQaScorecardRevisionResponse, TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionAsync(
          QaScorecardRevisionName parent, String filter, boolean validateOnly) {
    TuneQaScorecardRevisionRequest request =
        TuneQaScorecardRevisionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .setValidateOnly(validateOnly)
            .build();
    return tuneQaScorecardRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fine tune one or more QaModels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *           .toString();
   *   String filter = "filter-1274492040";
   *   boolean validateOnly = true;
   *   TuneQaScorecardRevisionResponse response =
   *       contactCenterInsightsClient
   *           .tuneQaScorecardRevisionAsync(parent, filter, validateOnly)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new fine tuning job instance.
   * @param filter Required. Filter for selecting the feedback labels that needs to be used for
   *     training. This filter can be used to limit the feedback labels used for tuning to a
   *     feedback labels created or updated for a specific time-window etc.
   * @param validateOnly Optional. Run in validate only mode, no fine tuning will actually run. Data
   *     quality validations like training data distributions will run. Even when set to false, the
   *     data quality validations will still run but once the validations complete we will proceed
   *     with the fine tune, if applicable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TuneQaScorecardRevisionResponse, TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionAsync(String parent, String filter, boolean validateOnly) {
    TuneQaScorecardRevisionRequest request =
        TuneQaScorecardRevisionRequest.newBuilder()
            .setParent(parent)
            .setFilter(filter)
            .setValidateOnly(validateOnly)
            .build();
    return tuneQaScorecardRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fine tune one or more QaModels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   TuneQaScorecardRevisionRequest request =
   *       TuneQaScorecardRevisionRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setValidateOnly(true)
   *           .build();
   *   TuneQaScorecardRevisionResponse response =
   *       contactCenterInsightsClient.tuneQaScorecardRevisionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TuneQaScorecardRevisionResponse, TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionAsync(TuneQaScorecardRevisionRequest request) {
    return tuneQaScorecardRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fine tune one or more QaModels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   TuneQaScorecardRevisionRequest request =
   *       TuneQaScorecardRevisionRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TuneQaScorecardRevisionResponse, TuneQaScorecardRevisionMetadata> future =
   *       contactCenterInsightsClient
   *           .tuneQaScorecardRevisionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TuneQaScorecardRevisionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationCallable() {
    return stub.tuneQaScorecardRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fine tune one or more QaModels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   TuneQaScorecardRevisionRequest request =
   *       TuneQaScorecardRevisionRequest.newBuilder()
   *           .setParent(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.tuneQaScorecardRevisionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionCallable() {
    return stub.tuneQaScorecardRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploy a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployQaScorecardRevisionRequest request =
   *       DeployQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   QaScorecardRevision response = contactCenterInsightsClient.deployQaScorecardRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision deployQaScorecardRevision(
      DeployQaScorecardRevisionRequest request) {
    return deployQaScorecardRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploy a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployQaScorecardRevisionRequest request =
   *       DeployQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<QaScorecardRevision> future =
   *       contactCenterInsightsClient.deployQaScorecardRevisionCallable().futureCall(request);
   *   // Do something.
   *   QaScorecardRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionCallable() {
    return stub.deployQaScorecardRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploy a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployQaScorecardRevisionRequest request =
   *       UndeployQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   QaScorecardRevision response =
   *       contactCenterInsightsClient.undeployQaScorecardRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QaScorecardRevision undeployQaScorecardRevision(
      UndeployQaScorecardRevisionRequest request) {
    return undeployQaScorecardRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploy a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployQaScorecardRevisionRequest request =
   *       UndeployQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<QaScorecardRevision> future =
   *       contactCenterInsightsClient.undeployQaScorecardRevisionCallable().futureCall(request);
   *   // Do something.
   *   QaScorecardRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionCallable() {
    return stub.undeployQaScorecardRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardRevisionName name =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
   *   contactCenterInsightsClient.deleteQaScorecardRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecardRevision to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaScorecardRevision(QaScorecardRevisionName name) {
    DeleteQaScorecardRevisionRequest request =
        DeleteQaScorecardRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteQaScorecardRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *           .toString();
   *   contactCenterInsightsClient.deleteQaScorecardRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the QaScorecardRevision to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaScorecardRevision(String name) {
    DeleteQaScorecardRevisionRequest request =
        DeleteQaScorecardRevisionRequest.newBuilder().setName(name).build();
    deleteQaScorecardRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteQaScorecardRevisionRequest request =
   *       DeleteQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   contactCenterInsightsClient.deleteQaScorecardRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteQaScorecardRevision(DeleteQaScorecardRevisionRequest request) {
    deleteQaScorecardRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a QaScorecardRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteQaScorecardRevisionRequest request =
   *       DeleteQaScorecardRevisionRequest.newBuilder()
   *           .setName(
   *               QaScorecardRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteQaScorecardRevisionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionCallable() {
    return stub.deleteQaScorecardRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions under the parent QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
   *   for (QaScorecardRevision element :
   *       contactCenterInsightsClient.listQaScorecardRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the scorecard revisions. To list all revisions
   *     of all scorecards, substitute the QaScorecard ID with a '-' character.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaScorecardRevisionsPagedResponse listQaScorecardRevisions(
      QaScorecardName parent) {
    ListQaScorecardRevisionsRequest request =
        ListQaScorecardRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listQaScorecardRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions under the parent QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString();
   *   for (QaScorecardRevision element :
   *       contactCenterInsightsClient.listQaScorecardRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the scorecard revisions. To list all revisions
   *     of all scorecards, substitute the QaScorecard ID with a '-' character.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaScorecardRevisionsPagedResponse listQaScorecardRevisions(String parent) {
    ListQaScorecardRevisionsRequest request =
        ListQaScorecardRevisionsRequest.newBuilder().setParent(parent).build();
    return listQaScorecardRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions under the parent QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaScorecardRevisionsRequest request =
   *       ListQaScorecardRevisionsRequest.newBuilder()
   *           .setParent(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (QaScorecardRevision element :
   *       contactCenterInsightsClient.listQaScorecardRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQaScorecardRevisionsPagedResponse listQaScorecardRevisions(
      ListQaScorecardRevisionsRequest request) {
    return listQaScorecardRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions under the parent QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaScorecardRevisionsRequest request =
   *       ListQaScorecardRevisionsRequest.newBuilder()
   *           .setParent(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<QaScorecardRevision> future =
   *       contactCenterInsightsClient.listQaScorecardRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QaScorecardRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsPagedCallable() {
    return stub.listQaScorecardRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions under the parent QaScorecard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListQaScorecardRevisionsRequest request =
   *       ListQaScorecardRevisionsRequest.newBuilder()
   *           .setParent(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListQaScorecardRevisionsResponse response =
   *         contactCenterInsightsClient.listQaScorecardRevisionsCallable().call(request);
   *     for (QaScorecardRevision element : response.getQaScorecardRevisionsList()) {
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
  public final UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
      listQaScorecardRevisionsCallable() {
    return stub.listQaScorecardRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
   *   String feedbackLabelId = "feedbackLabelId-1251198998";
   *   FeedbackLabel response =
   *       contactCenterInsightsClient.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the feedback label.
   * @param feedbackLabel Required. The feedback label to create.
   * @param feedbackLabelId Optional. The ID of the feedback label to create. If one is not
   *     specified it will be generated by the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel createFeedbackLabel(
      ConversationName parent, FeedbackLabel feedbackLabel, String feedbackLabelId) {
    CreateFeedbackLabelRequest request =
        CreateFeedbackLabelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFeedbackLabel(feedbackLabel)
            .setFeedbackLabelId(feedbackLabelId)
            .build();
    return createFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectLocationConversationName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *           .toString();
   *   FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
   *   String feedbackLabelId = "feedbackLabelId-1251198998";
   *   FeedbackLabel response =
   *       contactCenterInsightsClient.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the feedback label.
   * @param feedbackLabel Required. The feedback label to create.
   * @param feedbackLabelId Optional. The ID of the feedback label to create. If one is not
   *     specified it will be generated by the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel createFeedbackLabel(
      String parent, FeedbackLabel feedbackLabel, String feedbackLabelId) {
    CreateFeedbackLabelRequest request =
        CreateFeedbackLabelRequest.newBuilder()
            .setParent(parent)
            .setFeedbackLabel(feedbackLabel)
            .setFeedbackLabelId(feedbackLabelId)
            .build();
    return createFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateFeedbackLabelRequest request =
   *       CreateFeedbackLabelRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setFeedbackLabelId("feedbackLabelId-1251198998")
   *           .setFeedbackLabel(FeedbackLabel.newBuilder().build())
   *           .build();
   *   FeedbackLabel response = contactCenterInsightsClient.createFeedbackLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel createFeedbackLabel(CreateFeedbackLabelRequest request) {
    return createFeedbackLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateFeedbackLabelRequest request =
   *       CreateFeedbackLabelRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setFeedbackLabelId("feedbackLabelId-1251198998")
   *           .setFeedbackLabel(FeedbackLabel.newBuilder().build())
   *           .build();
   *   ApiFuture<FeedbackLabel> future =
   *       contactCenterInsightsClient.createFeedbackLabelCallable().futureCall(request);
   *   // Do something.
   *   FeedbackLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelCallable() {
    return stub.createFeedbackLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List feedback labels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   for (FeedbackLabel element :
   *       contactCenterInsightsClient.listFeedbackLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the feedback labels.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedbackLabelsPagedResponse listFeedbackLabels(ConversationName parent) {
    ListFeedbackLabelsRequest request =
        ListFeedbackLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeedbackLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List feedback labels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectLocationConversationName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *           .toString();
   *   for (FeedbackLabel element :
   *       contactCenterInsightsClient.listFeedbackLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the feedback labels.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedbackLabelsPagedResponse listFeedbackLabels(String parent) {
    ListFeedbackLabelsRequest request =
        ListFeedbackLabelsRequest.newBuilder().setParent(parent).build();
    return listFeedbackLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List feedback labels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListFeedbackLabelsRequest request =
   *       ListFeedbackLabelsRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FeedbackLabel element :
   *       contactCenterInsightsClient.listFeedbackLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedbackLabelsPagedResponse listFeedbackLabels(
      ListFeedbackLabelsRequest request) {
    return listFeedbackLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List feedback labels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListFeedbackLabelsRequest request =
   *       ListFeedbackLabelsRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FeedbackLabel> future =
   *       contactCenterInsightsClient.listFeedbackLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FeedbackLabel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsPagedCallable() {
    return stub.listFeedbackLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List feedback labels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListFeedbackLabelsRequest request =
   *       ListFeedbackLabelsRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFeedbackLabelsResponse response =
   *         contactCenterInsightsClient.listFeedbackLabelsCallable().call(request);
   *     for (FeedbackLabel element : response.getFeedbackLabelsList()) {
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
  public final UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
      listFeedbackLabelsCallable() {
    return stub.listFeedbackLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   FeedbackLabelName name =
   *       FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");
   *   FeedbackLabel response = contactCenterInsightsClient.getFeedbackLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feedback label to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel getFeedbackLabel(FeedbackLabelName name) {
    GetFeedbackLabelRequest request =
        GetFeedbackLabelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
   *           .toString();
   *   FeedbackLabel response = contactCenterInsightsClient.getFeedbackLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feedback label to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel getFeedbackLabel(String name) {
    GetFeedbackLabelRequest request = GetFeedbackLabelRequest.newBuilder().setName(name).build();
    return getFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetFeedbackLabelRequest request =
   *       GetFeedbackLabelRequest.newBuilder()
   *           .setName(
   *               FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
   *                   .toString())
   *           .build();
   *   FeedbackLabel response = contactCenterInsightsClient.getFeedbackLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel getFeedbackLabel(GetFeedbackLabelRequest request) {
    return getFeedbackLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetFeedbackLabelRequest request =
   *       GetFeedbackLabelRequest.newBuilder()
   *           .setName(
   *               FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FeedbackLabel> future =
   *       contactCenterInsightsClient.getFeedbackLabelCallable().futureCall(request);
   *   // Do something.
   *   FeedbackLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelCallable() {
    return stub.getFeedbackLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FeedbackLabel response =
   *       contactCenterInsightsClient.updateFeedbackLabel(feedbackLabel, updateMask);
   * }
   * }</pre>
   *
   * @param feedbackLabel Required. The feedback label to update.
   * @param updateMask Required. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel updateFeedbackLabel(
      FeedbackLabel feedbackLabel, FieldMask updateMask) {
    UpdateFeedbackLabelRequest request =
        UpdateFeedbackLabelRequest.newBuilder()
            .setFeedbackLabel(feedbackLabel)
            .setUpdateMask(updateMask)
            .build();
    return updateFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateFeedbackLabelRequest request =
   *       UpdateFeedbackLabelRequest.newBuilder()
   *           .setFeedbackLabel(FeedbackLabel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FeedbackLabel response = contactCenterInsightsClient.updateFeedbackLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedbackLabel updateFeedbackLabel(UpdateFeedbackLabelRequest request) {
    return updateFeedbackLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateFeedbackLabelRequest request =
   *       UpdateFeedbackLabelRequest.newBuilder()
   *           .setFeedbackLabel(FeedbackLabel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<FeedbackLabel> future =
   *       contactCenterInsightsClient.updateFeedbackLabelCallable().futureCall(request);
   *   // Do something.
   *   FeedbackLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelCallable() {
    return stub.updateFeedbackLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   FeedbackLabelName name =
   *       FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");
   *   contactCenterInsightsClient.deleteFeedbackLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feedback label to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeedbackLabel(FeedbackLabelName name) {
    DeleteFeedbackLabelRequest request =
        DeleteFeedbackLabelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
   *           .toString();
   *   contactCenterInsightsClient.deleteFeedbackLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feedback label to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeedbackLabel(String name) {
    DeleteFeedbackLabelRequest request =
        DeleteFeedbackLabelRequest.newBuilder().setName(name).build();
    deleteFeedbackLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteFeedbackLabelRequest request =
   *       DeleteFeedbackLabelRequest.newBuilder()
   *           .setName(
   *               FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
   *                   .toString())
   *           .build();
   *   contactCenterInsightsClient.deleteFeedbackLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeedbackLabel(DeleteFeedbackLabelRequest request) {
    deleteFeedbackLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete feedback label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteFeedbackLabelRequest request =
   *       DeleteFeedbackLabelRequest.newBuilder()
   *           .setName(
   *               FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteFeedbackLabelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelCallable() {
    return stub.deleteFeedbackLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all feedback labels by project number.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FeedbackLabel element :
   *       contactCenterInsightsClient.listAllFeedbackLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of all feedback labels per project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllFeedbackLabelsPagedResponse listAllFeedbackLabels(LocationName parent) {
    ListAllFeedbackLabelsRequest request =
        ListAllFeedbackLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAllFeedbackLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all feedback labels by project number.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FeedbackLabel element :
   *       contactCenterInsightsClient.listAllFeedbackLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of all feedback labels per project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllFeedbackLabelsPagedResponse listAllFeedbackLabels(String parent) {
    ListAllFeedbackLabelsRequest request =
        ListAllFeedbackLabelsRequest.newBuilder().setParent(parent).build();
    return listAllFeedbackLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all feedback labels by project number.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAllFeedbackLabelsRequest request =
   *       ListAllFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (FeedbackLabel element :
   *       contactCenterInsightsClient.listAllFeedbackLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllFeedbackLabelsPagedResponse listAllFeedbackLabels(
      ListAllFeedbackLabelsRequest request) {
    return listAllFeedbackLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all feedback labels by project number.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAllFeedbackLabelsRequest request =
   *       ListAllFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<FeedbackLabel> future =
   *       contactCenterInsightsClient.listAllFeedbackLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FeedbackLabel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsPagedCallable() {
    return stub.listAllFeedbackLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all feedback labels by project number.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAllFeedbackLabelsRequest request =
   *       ListAllFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAllFeedbackLabelsResponse response =
   *         contactCenterInsightsClient.listAllFeedbackLabelsCallable().call(request);
   *     for (FeedbackLabel element : response.getFeedbackLabelsList()) {
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
  public final UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
      listAllFeedbackLabelsCallable() {
    return stub.listAllFeedbackLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BulkUploadFeedbackLabelsResponse response =
   *       contactCenterInsightsClient.bulkUploadFeedbackLabelsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new feedback labels.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkUploadFeedbackLabelsResponse, BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsAsync(LocationName parent) {
    BulkUploadFeedbackLabelsRequest request =
        BulkUploadFeedbackLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return bulkUploadFeedbackLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BulkUploadFeedbackLabelsResponse response =
   *       contactCenterInsightsClient.bulkUploadFeedbackLabelsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new feedback labels.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkUploadFeedbackLabelsResponse, BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsAsync(String parent) {
    BulkUploadFeedbackLabelsRequest request =
        BulkUploadFeedbackLabelsRequest.newBuilder().setParent(parent).build();
    return bulkUploadFeedbackLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkUploadFeedbackLabelsRequest request =
   *       BulkUploadFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   BulkUploadFeedbackLabelsResponse response =
   *       contactCenterInsightsClient.bulkUploadFeedbackLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkUploadFeedbackLabelsResponse, BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsAsync(BulkUploadFeedbackLabelsRequest request) {
    return bulkUploadFeedbackLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkUploadFeedbackLabelsRequest request =
   *       BulkUploadFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<BulkUploadFeedbackLabelsResponse, BulkUploadFeedbackLabelsMetadata> future =
   *       contactCenterInsightsClient
   *           .bulkUploadFeedbackLabelsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BulkUploadFeedbackLabelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationCallable() {
    return stub.bulkUploadFeedbackLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkUploadFeedbackLabelsRequest request =
   *       BulkUploadFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.bulkUploadFeedbackLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsCallable() {
    return stub.bulkUploadFeedbackLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Download feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BulkDownloadFeedbackLabelsResponse response =
   *       contactCenterInsightsClient.bulkDownloadFeedbackLabelsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new feedback labels.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BulkDownloadFeedbackLabelsResponse, BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsAsync(LocationName parent) {
    BulkDownloadFeedbackLabelsRequest request =
        BulkDownloadFeedbackLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return bulkDownloadFeedbackLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Download feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BulkDownloadFeedbackLabelsResponse response =
   *       contactCenterInsightsClient.bulkDownloadFeedbackLabelsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for new feedback labels.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BulkDownloadFeedbackLabelsResponse, BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsAsync(String parent) {
    BulkDownloadFeedbackLabelsRequest request =
        BulkDownloadFeedbackLabelsRequest.newBuilder().setParent(parent).build();
    return bulkDownloadFeedbackLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Download feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkDownloadFeedbackLabelsRequest request =
   *       BulkDownloadFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setMaxDownloadCount(-1858155821)
   *           .setConversationFilter("conversationFilter1283909083")
   *           .addAllTemplateQaScorecardId(new ArrayList<String>())
   *           .build();
   *   BulkDownloadFeedbackLabelsResponse response =
   *       contactCenterInsightsClient.bulkDownloadFeedbackLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BulkDownloadFeedbackLabelsResponse, BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsAsync(BulkDownloadFeedbackLabelsRequest request) {
    return bulkDownloadFeedbackLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Download feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkDownloadFeedbackLabelsRequest request =
   *       BulkDownloadFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setMaxDownloadCount(-1858155821)
   *           .setConversationFilter("conversationFilter1283909083")
   *           .addAllTemplateQaScorecardId(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BulkDownloadFeedbackLabelsResponse, BulkDownloadFeedbackLabelsMetadata>
   *       future =
   *           contactCenterInsightsClient
   *               .bulkDownloadFeedbackLabelsOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   BulkDownloadFeedbackLabelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationCallable() {
    return stub.bulkDownloadFeedbackLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Download feedback labels in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   BulkDownloadFeedbackLabelsRequest request =
   *       BulkDownloadFeedbackLabelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setMaxDownloadCount(-1858155821)
   *           .setConversationFilter("conversationFilter1283909083")
   *           .addAllTemplateQaScorecardId(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.bulkDownloadFeedbackLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsCallable() {
    return stub.bulkDownloadFeedbackLabelsCallable();
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

  public static class ListConversationsPagedResponse
      extends AbstractPagedListResponse<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage,
          ListConversationsFixedSizeCollection> {

    public static ApiFuture<ListConversationsPagedResponse> createAsync(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ApiFuture<ListConversationsResponse> futureResponse) {
      ApiFuture<ListConversationsPage> futurePage =
          ListConversationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationsPagedResponse(ListConversationsPage page) {
      super(page, ListConversationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationsPage
      extends AbstractPage<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage> {

    private ListConversationsPage(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ListConversationsResponse response) {
      super(context, response);
    }

    private static ListConversationsPage createEmptyPage() {
      return new ListConversationsPage(null, null);
    }

    @Override
    protected ListConversationsPage createPage(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ListConversationsResponse response) {
      return new ListConversationsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationsPage> createPageAsync(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ApiFuture<ListConversationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage,
          ListConversationsFixedSizeCollection> {

    private ListConversationsFixedSizeCollection(
        List<ListConversationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationsFixedSizeCollection createEmptyCollection() {
      return new ListConversationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationsFixedSizeCollection createCollection(
        List<ListConversationsPage> pages, int collectionSize) {
      return new ListConversationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnalysesPagedResponse
      extends AbstractPagedListResponse<
          ListAnalysesRequest,
          ListAnalysesResponse,
          Analysis,
          ListAnalysesPage,
          ListAnalysesFixedSizeCollection> {

    public static ApiFuture<ListAnalysesPagedResponse> createAsync(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ApiFuture<ListAnalysesResponse> futureResponse) {
      ApiFuture<ListAnalysesPage> futurePage =
          ListAnalysesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalysesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalysesPagedResponse(ListAnalysesPage page) {
      super(page, ListAnalysesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalysesPage
      extends AbstractPage<ListAnalysesRequest, ListAnalysesResponse, Analysis, ListAnalysesPage> {

    private ListAnalysesPage(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ListAnalysesResponse response) {
      super(context, response);
    }

    private static ListAnalysesPage createEmptyPage() {
      return new ListAnalysesPage(null, null);
    }

    @Override
    protected ListAnalysesPage createPage(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ListAnalysesResponse response) {
      return new ListAnalysesPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalysesPage> createPageAsync(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ApiFuture<ListAnalysesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalysesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalysesRequest,
          ListAnalysesResponse,
          Analysis,
          ListAnalysesPage,
          ListAnalysesFixedSizeCollection> {

    private ListAnalysesFixedSizeCollection(List<ListAnalysesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalysesFixedSizeCollection createEmptyCollection() {
      return new ListAnalysesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalysesFixedSizeCollection createCollection(
        List<ListAnalysesPage> pages, int collectionSize) {
      return new ListAnalysesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPhraseMatchersPagedResponse
      extends AbstractPagedListResponse<
          ListPhraseMatchersRequest,
          ListPhraseMatchersResponse,
          PhraseMatcher,
          ListPhraseMatchersPage,
          ListPhraseMatchersFixedSizeCollection> {

    public static ApiFuture<ListPhraseMatchersPagedResponse> createAsync(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ApiFuture<ListPhraseMatchersResponse> futureResponse) {
      ApiFuture<ListPhraseMatchersPage> futurePage =
          ListPhraseMatchersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPhraseMatchersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPhraseMatchersPagedResponse(ListPhraseMatchersPage page) {
      super(page, ListPhraseMatchersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPhraseMatchersPage
      extends AbstractPage<
          ListPhraseMatchersRequest,
          ListPhraseMatchersResponse,
          PhraseMatcher,
          ListPhraseMatchersPage> {

    private ListPhraseMatchersPage(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ListPhraseMatchersResponse response) {
      super(context, response);
    }

    private static ListPhraseMatchersPage createEmptyPage() {
      return new ListPhraseMatchersPage(null, null);
    }

    @Override
    protected ListPhraseMatchersPage createPage(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ListPhraseMatchersResponse response) {
      return new ListPhraseMatchersPage(context, response);
    }

    @Override
    public ApiFuture<ListPhraseMatchersPage> createPageAsync(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ApiFuture<ListPhraseMatchersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPhraseMatchersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPhraseMatchersRequest,
          ListPhraseMatchersResponse,
          PhraseMatcher,
          ListPhraseMatchersPage,
          ListPhraseMatchersFixedSizeCollection> {

    private ListPhraseMatchersFixedSizeCollection(
        List<ListPhraseMatchersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPhraseMatchersFixedSizeCollection createEmptyCollection() {
      return new ListPhraseMatchersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPhraseMatchersFixedSizeCollection createCollection(
        List<ListPhraseMatchersPage> pages, int collectionSize) {
      return new ListPhraseMatchersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnalysisRulesPagedResponse
      extends AbstractPagedListResponse<
          ListAnalysisRulesRequest,
          ListAnalysisRulesResponse,
          AnalysisRule,
          ListAnalysisRulesPage,
          ListAnalysisRulesFixedSizeCollection> {

    public static ApiFuture<ListAnalysisRulesPagedResponse> createAsync(
        PageContext<ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule> context,
        ApiFuture<ListAnalysisRulesResponse> futureResponse) {
      ApiFuture<ListAnalysisRulesPage> futurePage =
          ListAnalysisRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalysisRulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalysisRulesPagedResponse(ListAnalysisRulesPage page) {
      super(page, ListAnalysisRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalysisRulesPage
      extends AbstractPage<
          ListAnalysisRulesRequest,
          ListAnalysisRulesResponse,
          AnalysisRule,
          ListAnalysisRulesPage> {

    private ListAnalysisRulesPage(
        PageContext<ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule> context,
        ListAnalysisRulesResponse response) {
      super(context, response);
    }

    private static ListAnalysisRulesPage createEmptyPage() {
      return new ListAnalysisRulesPage(null, null);
    }

    @Override
    protected ListAnalysisRulesPage createPage(
        PageContext<ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule> context,
        ListAnalysisRulesResponse response) {
      return new ListAnalysisRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalysisRulesPage> createPageAsync(
        PageContext<ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule> context,
        ApiFuture<ListAnalysisRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalysisRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalysisRulesRequest,
          ListAnalysisRulesResponse,
          AnalysisRule,
          ListAnalysisRulesPage,
          ListAnalysisRulesFixedSizeCollection> {

    private ListAnalysisRulesFixedSizeCollection(
        List<ListAnalysisRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalysisRulesFixedSizeCollection createEmptyCollection() {
      return new ListAnalysisRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalysisRulesFixedSizeCollection createCollection(
        List<ListAnalysisRulesPage> pages, int collectionSize) {
      return new ListAnalysisRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListViewsPagedResponse
      extends AbstractPagedListResponse<
          ListViewsRequest, ListViewsResponse, View, ListViewsPage, ListViewsFixedSizeCollection> {

    public static ApiFuture<ListViewsPagedResponse> createAsync(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      ApiFuture<ListViewsPage> futurePage =
          ListViewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListViewsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListViewsPagedResponse(ListViewsPage page) {
      super(page, ListViewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListViewsPage
      extends AbstractPage<ListViewsRequest, ListViewsResponse, View, ListViewsPage> {

    private ListViewsPage(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ListViewsResponse response) {
      super(context, response);
    }

    private static ListViewsPage createEmptyPage() {
      return new ListViewsPage(null, null);
    }

    @Override
    protected ListViewsPage createPage(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ListViewsResponse response) {
      return new ListViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListViewsPage> createPageAsync(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListViewsRequest, ListViewsResponse, View, ListViewsPage, ListViewsFixedSizeCollection> {

    private ListViewsFixedSizeCollection(List<ListViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListViewsFixedSizeCollection createEmptyCollection() {
      return new ListViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListViewsFixedSizeCollection createCollection(
        List<ListViewsPage> pages, int collectionSize) {
      return new ListViewsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListQaQuestionsPagedResponse
      extends AbstractPagedListResponse<
          ListQaQuestionsRequest,
          ListQaQuestionsResponse,
          QaQuestion,
          ListQaQuestionsPage,
          ListQaQuestionsFixedSizeCollection> {

    public static ApiFuture<ListQaQuestionsPagedResponse> createAsync(
        PageContext<ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion> context,
        ApiFuture<ListQaQuestionsResponse> futureResponse) {
      ApiFuture<ListQaQuestionsPage> futurePage =
          ListQaQuestionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListQaQuestionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListQaQuestionsPagedResponse(ListQaQuestionsPage page) {
      super(page, ListQaQuestionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListQaQuestionsPage
      extends AbstractPage<
          ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion, ListQaQuestionsPage> {

    private ListQaQuestionsPage(
        PageContext<ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion> context,
        ListQaQuestionsResponse response) {
      super(context, response);
    }

    private static ListQaQuestionsPage createEmptyPage() {
      return new ListQaQuestionsPage(null, null);
    }

    @Override
    protected ListQaQuestionsPage createPage(
        PageContext<ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion> context,
        ListQaQuestionsResponse response) {
      return new ListQaQuestionsPage(context, response);
    }

    @Override
    public ApiFuture<ListQaQuestionsPage> createPageAsync(
        PageContext<ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion> context,
        ApiFuture<ListQaQuestionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListQaQuestionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListQaQuestionsRequest,
          ListQaQuestionsResponse,
          QaQuestion,
          ListQaQuestionsPage,
          ListQaQuestionsFixedSizeCollection> {

    private ListQaQuestionsFixedSizeCollection(
        List<ListQaQuestionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListQaQuestionsFixedSizeCollection createEmptyCollection() {
      return new ListQaQuestionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListQaQuestionsFixedSizeCollection createCollection(
        List<ListQaQuestionsPage> pages, int collectionSize) {
      return new ListQaQuestionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListQaScorecardsPagedResponse
      extends AbstractPagedListResponse<
          ListQaScorecardsRequest,
          ListQaScorecardsResponse,
          QaScorecard,
          ListQaScorecardsPage,
          ListQaScorecardsFixedSizeCollection> {

    public static ApiFuture<ListQaScorecardsPagedResponse> createAsync(
        PageContext<ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard> context,
        ApiFuture<ListQaScorecardsResponse> futureResponse) {
      ApiFuture<ListQaScorecardsPage> futurePage =
          ListQaScorecardsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListQaScorecardsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListQaScorecardsPagedResponse(ListQaScorecardsPage page) {
      super(page, ListQaScorecardsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListQaScorecardsPage
      extends AbstractPage<
          ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard, ListQaScorecardsPage> {

    private ListQaScorecardsPage(
        PageContext<ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard> context,
        ListQaScorecardsResponse response) {
      super(context, response);
    }

    private static ListQaScorecardsPage createEmptyPage() {
      return new ListQaScorecardsPage(null, null);
    }

    @Override
    protected ListQaScorecardsPage createPage(
        PageContext<ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard> context,
        ListQaScorecardsResponse response) {
      return new ListQaScorecardsPage(context, response);
    }

    @Override
    public ApiFuture<ListQaScorecardsPage> createPageAsync(
        PageContext<ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard> context,
        ApiFuture<ListQaScorecardsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListQaScorecardsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListQaScorecardsRequest,
          ListQaScorecardsResponse,
          QaScorecard,
          ListQaScorecardsPage,
          ListQaScorecardsFixedSizeCollection> {

    private ListQaScorecardsFixedSizeCollection(
        List<ListQaScorecardsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListQaScorecardsFixedSizeCollection createEmptyCollection() {
      return new ListQaScorecardsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListQaScorecardsFixedSizeCollection createCollection(
        List<ListQaScorecardsPage> pages, int collectionSize) {
      return new ListQaScorecardsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListQaScorecardRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          QaScorecardRevision,
          ListQaScorecardRevisionsPage,
          ListQaScorecardRevisionsFixedSizeCollection> {

    public static ApiFuture<ListQaScorecardRevisionsPagedResponse> createAsync(
        PageContext<
                ListQaScorecardRevisionsRequest,
                ListQaScorecardRevisionsResponse,
                QaScorecardRevision>
            context,
        ApiFuture<ListQaScorecardRevisionsResponse> futureResponse) {
      ApiFuture<ListQaScorecardRevisionsPage> futurePage =
          ListQaScorecardRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListQaScorecardRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListQaScorecardRevisionsPagedResponse(ListQaScorecardRevisionsPage page) {
      super(page, ListQaScorecardRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListQaScorecardRevisionsPage
      extends AbstractPage<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          QaScorecardRevision,
          ListQaScorecardRevisionsPage> {

    private ListQaScorecardRevisionsPage(
        PageContext<
                ListQaScorecardRevisionsRequest,
                ListQaScorecardRevisionsResponse,
                QaScorecardRevision>
            context,
        ListQaScorecardRevisionsResponse response) {
      super(context, response);
    }

    private static ListQaScorecardRevisionsPage createEmptyPage() {
      return new ListQaScorecardRevisionsPage(null, null);
    }

    @Override
    protected ListQaScorecardRevisionsPage createPage(
        PageContext<
                ListQaScorecardRevisionsRequest,
                ListQaScorecardRevisionsResponse,
                QaScorecardRevision>
            context,
        ListQaScorecardRevisionsResponse response) {
      return new ListQaScorecardRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListQaScorecardRevisionsPage> createPageAsync(
        PageContext<
                ListQaScorecardRevisionsRequest,
                ListQaScorecardRevisionsResponse,
                QaScorecardRevision>
            context,
        ApiFuture<ListQaScorecardRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListQaScorecardRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          QaScorecardRevision,
          ListQaScorecardRevisionsPage,
          ListQaScorecardRevisionsFixedSizeCollection> {

    private ListQaScorecardRevisionsFixedSizeCollection(
        List<ListQaScorecardRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListQaScorecardRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListQaScorecardRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListQaScorecardRevisionsFixedSizeCollection createCollection(
        List<ListQaScorecardRevisionsPage> pages, int collectionSize) {
      return new ListQaScorecardRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeedbackLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListFeedbackLabelsRequest,
          ListFeedbackLabelsResponse,
          FeedbackLabel,
          ListFeedbackLabelsPage,
          ListFeedbackLabelsFixedSizeCollection> {

    public static ApiFuture<ListFeedbackLabelsPagedResponse> createAsync(
        PageContext<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel> context,
        ApiFuture<ListFeedbackLabelsResponse> futureResponse) {
      ApiFuture<ListFeedbackLabelsPage> futurePage =
          ListFeedbackLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeedbackLabelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeedbackLabelsPagedResponse(ListFeedbackLabelsPage page) {
      super(page, ListFeedbackLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeedbackLabelsPage
      extends AbstractPage<
          ListFeedbackLabelsRequest,
          ListFeedbackLabelsResponse,
          FeedbackLabel,
          ListFeedbackLabelsPage> {

    private ListFeedbackLabelsPage(
        PageContext<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel> context,
        ListFeedbackLabelsResponse response) {
      super(context, response);
    }

    private static ListFeedbackLabelsPage createEmptyPage() {
      return new ListFeedbackLabelsPage(null, null);
    }

    @Override
    protected ListFeedbackLabelsPage createPage(
        PageContext<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel> context,
        ListFeedbackLabelsResponse response) {
      return new ListFeedbackLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListFeedbackLabelsPage> createPageAsync(
        PageContext<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel> context,
        ApiFuture<ListFeedbackLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeedbackLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeedbackLabelsRequest,
          ListFeedbackLabelsResponse,
          FeedbackLabel,
          ListFeedbackLabelsPage,
          ListFeedbackLabelsFixedSizeCollection> {

    private ListFeedbackLabelsFixedSizeCollection(
        List<ListFeedbackLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeedbackLabelsFixedSizeCollection createEmptyCollection() {
      return new ListFeedbackLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeedbackLabelsFixedSizeCollection createCollection(
        List<ListFeedbackLabelsPage> pages, int collectionSize) {
      return new ListFeedbackLabelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAllFeedbackLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          FeedbackLabel,
          ListAllFeedbackLabelsPage,
          ListAllFeedbackLabelsFixedSizeCollection> {

    public static ApiFuture<ListAllFeedbackLabelsPagedResponse> createAsync(
        PageContext<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>
            context,
        ApiFuture<ListAllFeedbackLabelsResponse> futureResponse) {
      ApiFuture<ListAllFeedbackLabelsPage> futurePage =
          ListAllFeedbackLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAllFeedbackLabelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAllFeedbackLabelsPagedResponse(ListAllFeedbackLabelsPage page) {
      super(page, ListAllFeedbackLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAllFeedbackLabelsPage
      extends AbstractPage<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          FeedbackLabel,
          ListAllFeedbackLabelsPage> {

    private ListAllFeedbackLabelsPage(
        PageContext<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>
            context,
        ListAllFeedbackLabelsResponse response) {
      super(context, response);
    }

    private static ListAllFeedbackLabelsPage createEmptyPage() {
      return new ListAllFeedbackLabelsPage(null, null);
    }

    @Override
    protected ListAllFeedbackLabelsPage createPage(
        PageContext<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>
            context,
        ListAllFeedbackLabelsResponse response) {
      return new ListAllFeedbackLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListAllFeedbackLabelsPage> createPageAsync(
        PageContext<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>
            context,
        ApiFuture<ListAllFeedbackLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAllFeedbackLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          FeedbackLabel,
          ListAllFeedbackLabelsPage,
          ListAllFeedbackLabelsFixedSizeCollection> {

    private ListAllFeedbackLabelsFixedSizeCollection(
        List<ListAllFeedbackLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAllFeedbackLabelsFixedSizeCollection createEmptyCollection() {
      return new ListAllFeedbackLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAllFeedbackLabelsFixedSizeCollection createCollection(
        List<ListAllFeedbackLabelsPage> pages, int collectionSize) {
      return new ListAllFeedbackLabelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
