/*
 * Copyright 2020 Google LLC
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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AgentsClient =======================
 *
 * <p>Service Description: Service for managing [Agents][google.cloud.dialogflow.v2.Agent].
 *
 * <p>Sample for AgentsClient:
 *
 * <pre>{@code
 * try (AgentsClient agentsClient = AgentsClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Agent response = agentsClient.getAgent(parent);
 * }
 * }</pre>
 *
 * <p>======================= ContextsClient =======================
 *
 * <p>Service Description: Service for managing [Contexts][google.cloud.dialogflow.v2.Context].
 *
 * <p>Sample for ContextsClient:
 *
 * <pre>{@code
 * try (ContextsClient contextsClient = ContextsClient.create()) {
 *   ContextName name =
 *       ContextName.ofProjectSessionContextName("[PROJECT]", "[SESSION]", "[CONTEXT]");
 *   Context response = contextsClient.getContext(name);
 * }
 * }</pre>
 *
 * <p>======================= EntityTypesClient =======================
 *
 * <p>Service Description: Service for managing
 * [EntityTypes][google.cloud.dialogflow.v2.EntityType].
 *
 * <p>Sample for EntityTypesClient:
 *
 * <pre>{@code
 * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
 *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
 *   EntityType response = entityTypesClient.getEntityType(name);
 * }
 * }</pre>
 *
 * <p>======================= EnvironmentsClient =======================
 *
 * <p>Service Description: Service for managing
 * [Environments][google.cloud.dialogflow.v2.Environment].
 *
 * <p>Sample for EnvironmentsClient:
 *
 * <pre>{@code
 * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
 *   ListEnvironmentsRequest request =
 *       ListEnvironmentsRequest.newBuilder()
 *           .setParent(EnvironmentName.of("[PROJECT]", "[ENVIRONMENT]").toString())
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (Environment element : environmentsClient.listEnvironments(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= IntentsClient =======================
 *
 * <p>Service Description: Service for managing [Intents][google.cloud.dialogflow.v2.Intent].
 *
 * <p>Sample for IntentsClient:
 *
 * <pre>{@code
 * try (IntentsClient intentsClient = IntentsClient.create()) {
 *   IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
 *   Intent response = intentsClient.getIntent(name);
 * }
 * }</pre>
 *
 * <p>======================= SessionsClient =======================
 *
 * <p>Service Description: A service used for session interactions.
 *
 * <p>For more information, see the [API interactions
 * guide](https://cloud.google.com/dialogflow/docs/api-overview).
 *
 * <p>Sample for SessionsClient:
 *
 * <pre>{@code
 * try (SessionsClient sessionsClient = SessionsClient.create()) {
 *   SessionName session = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
 *   QueryInput queryInput = QueryInput.newBuilder().build();
 *   DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
 * }
 * }</pre>
 *
 * <p>======================= SessionEntityTypesClient =======================
 *
 * <p>Service Description: Service for managing
 * [SessionEntityTypes][google.cloud.dialogflow.v2.SessionEntityType].
 *
 * <p>Sample for SessionEntityTypesClient:
 *
 * <pre>{@code
 * try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
 *   SessionEntityTypeName name =
 *       SessionEntityTypeName.ofProjectSessionEntityTypeName(
 *           "[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
 *   SessionEntityType response = sessionEntityTypesClient.getSessionEntityType(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.dialogflow.v2;

import javax.annotation.Generated;
