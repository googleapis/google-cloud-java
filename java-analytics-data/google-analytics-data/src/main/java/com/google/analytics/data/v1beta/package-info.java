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
 * <p>======================= BetaAnalyticsDataClient =======================
 *
 * <p>Service Description: Google Analytics reporting data service.
 *
 * <p>Sample for BetaAnalyticsDataClient:
 *
 * <pre>{@code
 * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
 *   RunPivotReportRequest request =
 *       RunPivotReportRequest.newBuilder()
 *           .setProperty("property-993141291")
 *           .addAllDimensions(new ArrayList<Dimension>())
 *           .addAllMetrics(new ArrayList<Metric>())
 *           .addAllDateRanges(new ArrayList<DateRange>())
 *           .addAllPivots(new ArrayList<Pivot>())
 *           .setDimensionFilter(FilterExpression.newBuilder().build())
 *           .setMetricFilter(FilterExpression.newBuilder().build())
 *           .setCurrencyCode("currencyCode1004773790")
 *           .setCohortSpec(CohortSpec.newBuilder().build())
 *           .setKeepEmptyRows(true)
 *           .setReturnPropertyQuota(true)
 *           .build();
 *   RunPivotReportResponse response = betaAnalyticsDataClient.runPivotReport(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.analytics.data.v1beta;

import javax.annotation.Generated;
