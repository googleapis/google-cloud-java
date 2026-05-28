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
 * A client to Google Health API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DataPointsServiceClient =======================
 *
 * <p>Service Description: Data Points Service exposing the user's health and fitness measured and
 * derived data.
 *
 * <p>Sample for DataPointsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
 *   DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");
 *   DataPoint response = dataPointsServiceClient.getDataPoint(name);
 * }
 * }</pre>
 *
 * <p>======================= DataSubscriptionServiceClient =======================
 *
 * <p>Service Description: Data Subscription Service that allows clients (e.g., Fitbit 3P
 * applications, internal Fitbit Services) to manage their subscriber endpoints. This service
 * provides CRUD APIs for subscribers, and also offers functionalities for subscriber verification
 * and statistics.
 *
 * <p>Sample for DataSubscriptionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
 *     DataSubscriptionServiceClient.create()) {
 *   SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
 *   CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
 *   String subscriptionId = "subscriptionId1478790936";
 *   Subscription response =
 *       dataSubscriptionServiceClient.createSubscription(parent, subscription, subscriptionId);
 * }
 * }</pre>
 *
 * <p>======================= HealthProfileServiceClient =======================
 *
 * <p>Service Description: Health Profile Service
 *
 * <p>Sample for HealthProfileServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HealthProfileServiceClient healthProfileServiceClient =
 *     HealthProfileServiceClient.create()) {
 *   ProfileName name = ProfileName.of("[USER]");
 *   Profile response = healthProfileServiceClient.getProfile(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.devicesandservices.health.v4;

import javax.annotation.Generated;
