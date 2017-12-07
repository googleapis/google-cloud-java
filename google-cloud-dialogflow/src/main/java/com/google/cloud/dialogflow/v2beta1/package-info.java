/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Dialogflow API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>============ AgentsClient ============
 *
 * <p>Service Description: Manages conversational agents.
 *
 * <p>Refer to [documentation](https://dialogflow.com/docs/agents) for more details # about agents.
 *
 * <p>Standard methods.
 *
 * <p>Sample for AgentsClient:
 *
 * <pre>
 * <code>
 * try (AgentsClient agentsClient = AgentsClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Agent response = agentsClient.getAgent(parent);
 * }
 * </code>
 * </pre>
 *
 * ============== ContextsClient ==============
 *
 * <p>Service Description: Manages contexts.
 *
 * <p>Refer to [documentation](https://dialogflow.com/docs/contexts) for more # details about
 * contexts.
 *
 * <p>Standard methods.
 *
 * <p>Sample for ContextsClient:
 *
 * <pre>
 * <code>
 * try (ContextsClient contextsClient = ContextsClient.create()) {
 *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
 *   Context response = contextsClient.getContext(name);
 * }
 * </code>
 * </pre>
 *
 * ================= EntityTypesClient =================
 *
 * <p>Service Description: Manages agent entity types.
 *
 * <p>Refer to [documentation](https://dialogflow.com/docs/entities) for more # details about entity
 * types.
 *
 * <p>Standard methods.
 *
 * <p>Sample for EntityTypesClient:
 *
 * <pre>
 * <code>
 * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
 *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
 *   EntityType response = entityTypesClient.getEntityType(name);
 * }
 * </code>
 * </pre>
 *
 * ============= IntentsClient =============
 *
 * <p>Service Description: Manages agent intents.
 *
 * <p>Refer to [documentation](https://dialogflow.com/docs/intents) for more # details about agent
 * intents.
 *
 * <p>Standard methods.
 *
 * <p>Sample for IntentsClient:
 *
 * <pre>
 * <code>
 * try (IntentsClient intentsClient = IntentsClient.create()) {
 *   IntentName name = IntentName.of("[PROJECT]", "[INTENT]");
 *   Intent response = intentsClient.getIntent(name);
 * }
 * </code>
 * </pre>
 *
 * ======================== SessionEntityTypesClient ========================
 *
 * <p>Service Description: Manages session entity types.
 *
 * <p>Session entity types can be redefined on a session level, allowing for specific concepts, like
 * a user's playlists.
 *
 * <p>Standard methods.
 *
 * <p>Sample for SessionEntityTypesClient:
 *
 * <pre>
 * <code>
 * try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
 *   SessionEntityTypeName name = SessionEntityTypeName.of("[PROJECT]", "[SESSION]", "[ENTITY_TYPE]");
 *   SessionEntityType response = sessionEntityTypesClient.getSessionEntityType(name);
 * }
 * </code>
 * </pre>
 *
 * ============== SessionsClient ==============
 *
 * <p>Service Description: Manages user sessions.
 *
 * <p>Custom methods.
 *
 * <p>Sample for SessionsClient:
 *
 * <pre>
 * <code>
 * try (SessionsClient sessionsClient = SessionsClient.create()) {
 *   SessionName session = SessionName.of("[PROJECT]", "[SESSION]");
 *   QueryInput queryInput = QueryInput.newBuilder().build();
 *   DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.dialogflow.v2beta1;
