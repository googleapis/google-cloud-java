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
 * A client to Google Analytics Data API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= BetaAnalyticsDataClient =======================
 *
 * <p>Service Description: Google Analytics reporting data service.
 *
 * <p>Sample for BetaAnalyticsDataClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
 *   RunReportRequest request =
 *       RunReportRequest.newBuilder()
 *           .setProperty("property-993141291")
 *           .addAllDimensions(new ArrayList<Dimension>())
 *           .addAllMetrics(new ArrayList<Metric>())
 *           .addAllDateRanges(new ArrayList<DateRange>())
 *           .setDimensionFilter(FilterExpression.newBuilder().build())
 *           .setMetricFilter(FilterExpression.newBuilder().build())
 *           .setOffset(-1019779949)
 *           .setLimit(102976443)
 *           .addAllMetricAggregations(new ArrayList<MetricAggregation>())
 *           .addAllOrderBys(new ArrayList<OrderBy>())
 *           .setCurrencyCode("currencyCode1004773790")
 *           .setCohortSpec(CohortSpec.newBuilder().build())
 *           .setKeepEmptyRows(true)
 *           .setReturnPropertyQuota(true)
 *           .build();
 *   RunReportResponse response = betaAnalyticsDataClient.runReport(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.analytics.data.v1beta;

import javax.annotation.Generated;
