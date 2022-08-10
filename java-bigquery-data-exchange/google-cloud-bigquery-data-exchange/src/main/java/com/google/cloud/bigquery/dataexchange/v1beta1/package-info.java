/*
 * Copyright 2022 Google LLC
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
 * A client to Analytics Hub API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AnalyticsHubServiceClient =======================
 *
 * <p>Service Description: The AnalyticsHubService API facilitates data sharing within and across
 * organizations. It allows data providers to publish Listings --- a discoverable and searchable SKU
 * representing a dataset. Data consumers can subscribe to Listings. Upon subscription, AnalyticsHub
 * provisions a "Linked Datasets" surfacing the data in the consumer's project.
 *
 * <p>Sample for AnalyticsHubServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
 *   DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
 *   DataExchange response = analyticsHubServiceClient.getDataExchange(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.bigquery.dataexchange.v1beta1;

import javax.annotation.Generated;
