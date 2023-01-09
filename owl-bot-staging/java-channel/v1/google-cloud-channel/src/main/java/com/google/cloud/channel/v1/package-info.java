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
 * A client to Cloud Channel API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CloudChannelReportsServiceClient =======================
 *
 * <p>Service Description: CloudChannelReportsService lets Google Cloud resellers and distributors
 * retrieve and combine a variety of data in Cloud Channel for multiple products (Google Cloud
 * Platform (GCP), Google Voice, and Google Workspace.)
 *
 * <p>Sample for CloudChannelReportsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
 *     CloudChannelReportsServiceClient.create()) {
 *   RunReportJobRequest request =
 *       RunReportJobRequest.newBuilder()
 *           .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
 *           .setDateRange(DateRange.newBuilder().build())
 *           .setFilter("filter-1274492040")
 *           .setLanguageCode("languageCode-2092349083")
 *           .build();
 *   RunReportJobResponse response =
 *       cloudChannelReportsServiceClient.runReportJobAsync(request).get();
 * }
 * }</pre>
 *
 * <p>======================= CloudChannelServiceClient =======================
 *
 * <p>Service Description: CloudChannelService lets Google cloud resellers and distributors manage
 * their customers, channel partners, entitlements, and reports.
 *
 * <p>Using this service: 1. Resellers and distributors can manage a customer entity. 2.
 * Distributors can register an authorized reseller in their channel and provide them with delegated
 * admin access. 3. Resellers and distributors can manage customer entitlements.
 *
 * <p>CloudChannelService exposes the following resources: -
 * [Customer][google.cloud.channel.v1.Customer]s: An entity-usually an enterprise-managed by a
 * reseller or distributor.
 *
 * <p>- [Entitlement][google.cloud.channel.v1.Entitlement]s: An entity that provides a customer with
 * the means to use a service. Entitlements are created or updated as a result of a successful
 * fulfillment.
 *
 * <p>- [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: An entity that identifies
 * links between distributors and their indirect resellers in a channel.
 *
 * <p>Sample for CloudChannelServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
 *   CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
 *   Customer response = cloudChannelServiceClient.getCustomer(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.channel.v1;

import javax.annotation.Generated;
