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

/**
 * A client to Gemini Enterprise for Customer Experience API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AgentServiceClient =======================
 *
 * <p>Service Description: The service that manages agent-related resources in Gemini Enterprise for
 * Customer Engagement (CES).
 *
 * <p>Sample for AgentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
 *   AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
 *   App response = agentServiceClient.getApp(name);
 * }
 * }</pre>
 *
 * <p>======================= SessionServiceClient =======================
 *
 * <p>Service Description: Session service provides APIs for interacting with CES agents.
 *
 * <p>Sample for SessionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
 *   RunSessionRequest request =
 *       RunSessionRequest.newBuilder()
 *           .setConfig(SessionConfig.newBuilder().build())
 *           .addAllInputs(new ArrayList<SessionInput>())
 *           .build();
 *   RunSessionResponse response = sessionServiceClient.runSession(request);
 * }
 * }</pre>
 *
 * <p>======================= ToolServiceClient =======================
 *
 * <p>Service Description: Tool service provides APIs for interacting with CES tools.
 *
 * <p>Sample for ToolServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ToolServiceClient toolServiceClient = ToolServiceClient.create()) {
 *   ExecuteToolRequest request =
 *       ExecuteToolRequest.newBuilder()
 *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
 *           .setArgs(Struct.newBuilder().build())
 *           .build();
 *   ExecuteToolResponse response = toolServiceClient.executeTool(request);
 * }
 * }</pre>
 *
 * <p>======================= WidgetServiceClient =======================
 *
 * <p>Service Description: Provides APIs for widgets to interact with CES APIs.
 *
 * <p>Sample for WidgetServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (WidgetServiceClient widgetServiceClient = WidgetServiceClient.create()) {
 *   GenerateChatTokenRequest request =
 *       GenerateChatTokenRequest.newBuilder()
 *           .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[SESSION]").toString())
 *           .setDeployment(
 *               DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
 *           .setRecaptchaToken("recaptchaToken1978277202")
 *           .build();
 *   GenerateChatTokenResponse response = widgetServiceClient.generateChatToken(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.ces.v1;

import javax.annotation.Generated;
