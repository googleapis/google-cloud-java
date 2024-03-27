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

/**
 * A client to Google Chat API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ChatServiceClient =======================
 *
 * <p>Service Description: Enables developers to build Chat apps and integrations on Google Chat
 * Platform.
 *
 * <p>Sample for ChatServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
 *   SpaceName parent = SpaceName.of("[SPACE]");
 *   Message message = Message.newBuilder().build();
 *   String messageId = "messageId-1440013438";
 *   Message response = chatServiceClient.createMessage(parent, message, messageId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.chat.v1;

import javax.annotation.Generated;
