/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
 * <p>Service Description: Agents are best described as Natural Language Understanding (NLU) modules
 * that transform user requests into actionable data. You can include agents in your app, product,
 * or service to determine user intent and respond to the user in a natural way.
 *
 * <p>After you create an agent, you can add [Intents][google.cloud.dialogflow.v2.Intents],
 * [Contexts][google.cloud.dialogflow.v2.Contexts], [Entity
 * Types][google.cloud.dialogflow.v2.EntityTypes],
 * [Webhooks][google.cloud.dialogflow.v2.WebhookRequest], and so on to manage the flow of a
 * conversation and match user input to predefined intents and actions.
 *
 * <p>You can create an agent using both Dialogflow Standard Edition and Dialogflow Enterprise
 * Edition. For details, see [Dialogflow
 * Editions](https://cloud.google.com/dialogflow/docs/editions).
 *
 * <p>You can save your agent for backup or versioning by exporting the agent by using the
 * [ExportAgent][google.cloud.dialogflow.v2.Agents.ExportAgent] method. You can import a saved agent
 * by using the [ImportAgent][google.cloud.dialogflow.v2.Agents.ImportAgent] method.
 *
 * <p>Dialogflow provides several [prebuilt
 * agents](https://cloud.google.com/dialogflow/docs/agents-prebuilt) for common conversation
 * scenarios such as determining a date and time, converting currency, and so on.
 *
 * <p>For more information about agents, see the [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/agents-overview).
 *
 * <p>Sample for AgentsClient:
 *
 * <pre>
 * <code>
 * try (AgentsClient agentsClient = AgentsClient.create()) {
 *   Agent agent = Agent.newBuilder().build();
 *   Agent response = agentsClient.setAgent(agent);
 * }
 * </code>
 * </pre>
 *
 * ============== ContextsClient ==============
 *
 * <p>Service Description: A context represents additional information included with user input or
 * with an intent returned by the Dialogflow API. Contexts are helpful for differentiating user
 * input which may be vague or have a different meaning depending on additional details from your
 * application such as user setting and preferences, previous user input, where the user is in your
 * application, geographic location, and so on.
 *
 * <p>You can include contexts as input parameters of a
 * [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
 * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) request, or
 * as output contexts included in the returned intent. Contexts expire when an intent is matched,
 * after the number of `DetectIntent` requests specified by the `lifespan_count` parameter, or after
 * 20 minutes if no intents are matched for a `DetectIntent` request.
 *
 * <p>For more information about contexts, see the [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/contexts-overview).
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
 * <p>Service Description: Entities are extracted from user input and represent parameters that are
 * meaningful to your application. For example, a date range, a proper name such as a geographic
 * location or landmark, and so on. Entities represent actionable data for your application.
 *
 * <p>When you define an entity, you can also include synonyms that all map to that entity. For
 * example, "soft drink", "soda", "pop", and so on.
 *
 * <p>There are three types of entities:
 *
 * <p>&#42; &#42;&#42;System&#42;&#42; - entities that are defined by the Dialogflow API for common
 * data types such as date, time, currency, and so on. A system entity is represented by the
 * `EntityType` type.
 *
 * <p>&#42; &#42;&#42;Developer&#42;&#42; - entities that are defined by you that represent
 * actionable data that is meaningful to your application. For example, you could define a
 * `pizza.sauce` entity for red or white pizza sauce, a `pizza.cheese` entity for the different
 * types of cheese on a pizza, a `pizza.topping` entity for different toppings, and so on. A
 * developer entity is represented by the `EntityType` type.
 *
 * <p>&#42; &#42;&#42;User&#42;&#42; - entities that are built for an individual user such as
 * favorites, preferences, playlists, and so on. A user entity is represented by the
 * [SessionEntityType][google.cloud.dialogflow.v2.SessionEntityType] type.
 *
 * <p>For more information about entity types, see the [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
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
 * <p>Service Description: An intent represents a mapping between input from a user and an action to
 * be taken by your application. When you pass user input to the
 * [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
 * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method, the
 * Dialogflow API analyzes the input and searches for a matching intent. If no match is found, the
 * Dialogflow API returns a fallback intent (`is_fallback` = true).
 *
 * <p>You can provide additional information for the Dialogflow API to use to match user input to an
 * intent by adding the following to your intent.
 *
 * <p>&#42; &#42;&#42;Contexts&#42;&#42; - provide additional context for intent analysis. For
 * example, if an intent is related to an object in your application that plays music, you can
 * provide a context to determine when to match the intent if the user input is "turn it off". You
 * can include a context that matches the intent when there is previous user input of "play music",
 * and not when there is previous user input of "turn on the light".
 *
 * <p>&#42; &#42;&#42;Events&#42;&#42; - allow for matching an intent by using an event name instead
 * of user input. Your application can provide an event name and related parameters to the
 * Dialogflow API to match an intent. For example, when your application starts, you can send a
 * welcome event with a user name parameter to the Dialogflow API to match an intent with a
 * personalized welcome message for the user.
 *
 * <p>&#42; &#42;&#42;Training phrases&#42;&#42; - provide examples of user input to train the
 * Dialogflow API agent to better match intents.
 *
 * <p>For more information about intents, see the [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/intents-overview).
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
 * <p>Service Description: Entities are extracted from user input and represent parameters that are
 * meaningful to your application. For example, a date range, a proper name such as a geographic
 * location or landmark, and so on. Entities represent actionable data for your application.
 *
 * <p>Session entity types are referred to as &#42;&#42;User&#42;&#42; entity types and are entities
 * that are built for an individual user such as favorites, preferences, playlists, and so on. You
 * can redefine a session entity type at the session level.
 *
 * <p>For more information about entity types, see the [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/entities-overview).
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
 * <p>Service Description: A session represents an interaction with a user. You retrieve user input
 * and pass it to the [DetectIntent][google.cloud.dialogflow.v2.Sessions.DetectIntent] (or
 * [StreamingDetectIntent][google.cloud.dialogflow.v2.Sessions.StreamingDetectIntent]) method to
 * determine user intent and respond.
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
package com.google.cloud.dialogflow.v2;
