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
 * <p>======================= HubServiceClient =======================
 *
 * <p>Service Description: Network Connectivity Center is a hub-and-spoke abstraction for network
 * connectivity management in Google Cloud. It reduces operational complexity through a simple,
 * centralized connectivity management model.
 *
 * <p>Sample for HubServiceClient:
 *
 * <pre>{@code
 * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
 *   HubName name = HubName.of("[PROJECT]", "[HUB]");
 *   Hub response = hubServiceClient.getHub(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.networkconnectivity.v1alpha1;

import javax.annotation.Generated;
