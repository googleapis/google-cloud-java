/*
 * Copyright 2020 Google LLC
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
 * <p>=========== PagesClient ===========
 *
 * <p>Service Description: Service for managing [Pages][google.cloud.dialogflow.cx.v3beta1.Page].
 *
 * <p>Sample for PagesClient:
 *
 * <pre>
 * <code>
 * try (PagesClient pagesClient = PagesClient.create()) {
 *   PageName name = PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]");
 *   Page response = pagesClient.getPage(name);
 * }
 * </code>
 * </pre>
 *
 * =========== FlowsClient ===========
 *
 * <p>Service Description: Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
 *
 * <p>Sample for FlowsClient:
 *
 * <pre>
 * <code>
 * try (FlowsClient flowsClient = FlowsClient.create()) {
 *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
 *   Flow flow = Flow.newBuilder().build();
 *   Flow response = flowsClient.createFlow(parent, flow);
 * }
 * </code>
 * </pre>
 *
 * ============ AgentsClient ============
 *
 * <p>Service Description: Service for managing [Agents][google.cloud.dialogflow.cx.v3beta1.Agent].
 *
 * <p>Sample for AgentsClient:
 *
 * <pre>
 * <code>
 * try (AgentsClient agentsClient = AgentsClient.create()) {
 *   AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
 *   Agent response = agentsClient.getAgent(name);
 * }
 * </code>
 * </pre>
 *
 * ================= EntityTypesClient =================
 *
 * <p>Service Description: Service for managing
 * [EntityTypes][google.cloud.dialogflow.cx.v3beta1.EntityType].
 *
 * <p>Sample for EntityTypesClient:
 *
 * <pre>
 * <code>
 * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
 *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENTITY_TYPE]");
 *   EntityType response = entityTypesClient.getEntityType(name);
 * }
 * </code>
 * </pre>
 *
 * ================== EnvironmentsClient ==================
 *
 * <p>Service Description: Service for managing
 * [Environments][google.cloud.dialogflow.cx.v3beta1.Environment].
 *
 * <p>Sample for EnvironmentsClient:
 *
 * <pre>
 * <code>
 * try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
 *   EnvironmentName name = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
 *   Environment response = environmentsClient.getEnvironment(name);
 * }
 * </code>
 * </pre>
 *
 * ============= IntentsClient =============
 *
 * <p>Service Description: Service for managing
 * [Intents][google.cloud.dialogflow.cx.v3beta1.Intent].
 *
 * <p>Sample for IntentsClient:
 *
 * <pre>
 * <code>
 * try (IntentsClient intentsClient = IntentsClient.create()) {
 *   IntentName name = IntentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[INTENT]");
 *   Intent response = intentsClient.getIntent(name);
 * }
 * </code>
 * </pre>
 *
 * ======================== SessionEntityTypesClient ========================
 *
 * <p>Service Description: Service for managing
 * [SessionEntityTypes][google.cloud.dialogflow.cx.v3beta1.SessionEntityType].
 *
 * <p>Sample for SessionEntityTypesClient:
 *
 * <pre>
 * <code>
 * try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
 *   SessionEntityTypeName name = SessionEntityTypeName.ofProjectLocationAgentSessionEntityTypeName("[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]", "[ENTITY_TYPE]");
 *   SessionEntityType response = sessionEntityTypesClient.getSessionEntityType(name);
 * }
 * </code>
 * </pre>
 *
 * ============== SessionsClient ==============
 *
 * <p>Service Description: A session represents an interaction with a user. You retrieve user input
 * and pass it to the [DetectIntent][google.cloud.dialogflow.cx.v3beta1.Sessions.DetectIntent]
 * method to determine user intent and respond.
 *
 * <p>Sample for SessionsClient:
 *
 * <pre>
 * <code>
 * try (SessionsClient sessionsClient = SessionsClient.create()) {
 *   SessionName session = SessionName.ofProjectLocationAgentSessionName("[PROJECT]", "[LOCATION]", "[AGENT]", "[SESSION]");
 *   QueryInput queryInput = QueryInput.newBuilder().build();
 *   DetectIntentRequest request = DetectIntentRequest.newBuilder()
 *     .setSession(session.toString())
 *     .setQueryInput(queryInput)
 *     .build();
 *   DetectIntentResponse response = sessionsClient.detectIntent(request);
 * }
 * </code>
 * </pre>
 *
 * =========================== TransitionRouteGroupsClient ===========================
 *
 * <p>Service Description: Service for managing
 * [TransitionRouteGroups][google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup].
 *
 * <p>Sample for TransitionRouteGroupsClient:
 *
 * <pre>
 * <code>
 * try (TransitionRouteGroupsClient transitionRouteGroupsClient = TransitionRouteGroupsClient.create()) {
 *   TransitionRouteGroupName name = TransitionRouteGroupName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[TRANSITION_ROUTE_GROUP]");
 *   TransitionRouteGroup response = transitionRouteGroupsClient.getTransitionRouteGroup(name);
 * }
 * </code>
 * </pre>
 *
 * ============== VersionsClient ==============
 *
 * <p>Service Description: Service for managing
 * [Versions][google.cloud.dialogflow.cx.v3beta1.Version].
 *
 * <p>Sample for VersionsClient:
 *
 * <pre>
 * <code>
 * try (VersionsClient versionsClient = VersionsClient.create()) {
 *   VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[VERSION]");
 *   Version response = versionsClient.getVersion(name);
 * }
 * </code>
 * </pre>
 *
 * ============== WebhooksClient ==============
 *
 * <p>Service Description: Service for managing
 * [Webhooks][google.cloud.dialogflow.cx.v3beta1.Webhook].
 *
 * <p>Sample for WebhooksClient:
 *
 * <pre>
 * <code>
 * try (WebhooksClient webhooksClient = WebhooksClient.create()) {
 *   WebhookName name = WebhookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[WEBHOOK]");
 *   Webhook response = webhooksClient.getWebhook(name);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.dialogflow.cx.v3beta1;

import javax.annotation.Generated;
