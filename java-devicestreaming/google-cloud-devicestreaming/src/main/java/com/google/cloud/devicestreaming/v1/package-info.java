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
 * A client to Device Streaming API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DirectAccessServiceClient =======================
 *
 * <p>Service Description: A service for allocating Android devices and interacting with the
 * live-allocated devices.
 *
 * <p>Each Session will wait for available capacity, at a higher priority over Test Execution. When
 * allocated, the session will be exposed through a stream for integration.
 *
 * <p>DirectAccessService is currently available as a preview to select developers. You can register
 * today on behalf of you and your team at
 * https://developer.android.com/studio/preview/android-device-streaming
 *
 * <p>Sample for DirectAccessServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   DeviceSession deviceSession = DeviceSession.newBuilder().build();
 *   String deviceSessionId = "deviceSessionId-544276325";
 *   DeviceSession response =
 *       directAccessServiceClient.createDeviceSession(parent, deviceSession, deviceSessionId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.devicestreaming.v1;

import javax.annotation.Generated;
