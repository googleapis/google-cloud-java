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

/**
 * A client to Data Analytics API with Gemini
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ContextRetrievalServiceClient =======================
 *
 * <p>Service Description: Service to ask a natural language question with a provided project,
 * returns BigQuery tables that are relevant to the question within the project scope that is
 * accessible to the user, along with contextual data including table schema information as well as
 * sample values.
 *
 * <p>Sample for ContextRetrievalServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContextRetrievalServiceClient contextRetrievalServiceClient =
 *     ContextRetrievalServiceClient.create()) {
 *   RetrieveBigQueryTableContextRequest request =
 *       RetrieveBigQueryTableContextRequest.newBuilder()
 *           .setProject("project-309310695")
 *           .setParent("parent-995424086")
 *           .setQuery("query107944136")
 *           .addAllDirectLookup(new ArrayList<DirectLookup>())
 *           .build();
 *   RetrieveBigQueryTableContextResponse response =
 *       contextRetrievalServiceClient.retrieveBigQueryTableContext(request);
 * }
 * }</pre>
 *
 * <p>======================= DataAgentServiceClient =======================
 *
 * <p>Service Description: Service describing handlers for resources.
 *
 * <p>Sample for DataAgentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
 *   DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
 *   DataAgent response = dataAgentServiceClient.getDataAgent(name);
 * }
 * }</pre>
 *
 * <p>======================= DataChatServiceClient =======================
 *
 * <p>Service Description: Service to ask a natural language question on top of BigQuery and
 * LookerStudio datasources to get back streamed responses of various kinds to help provide a rich
 * conversational answer.
 *
 * <p>Sample for DataChatServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataChatServiceClient dataChatServiceClient = DataChatServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Conversation conversation = Conversation.newBuilder().build();
 *   String conversationId = "conversationId-1676095234";
 *   Conversation response =
 *       dataChatServiceClient.createConversation(parent, conversation, conversationId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.geminidataanalytics.v1beta;

import javax.annotation.Generated;
