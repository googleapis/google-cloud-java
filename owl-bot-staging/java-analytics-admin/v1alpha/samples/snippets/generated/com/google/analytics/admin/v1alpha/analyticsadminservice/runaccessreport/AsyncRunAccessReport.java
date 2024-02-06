/*
 * Copyright 2023 Google LLC
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

package com.google.analytics.admin.v1alpha.samples;

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_RunAccessReport_async]
import com.google.analytics.admin.v1alpha.AccessDateRange;
import com.google.analytics.admin.v1alpha.AccessDimension;
import com.google.analytics.admin.v1alpha.AccessFilterExpression;
import com.google.analytics.admin.v1alpha.AccessMetric;
import com.google.analytics.admin.v1alpha.AccessOrderBy;
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.RunAccessReportRequest;
import com.google.analytics.admin.v1alpha.RunAccessReportResponse;
import com.google.api.core.ApiFuture;
import java.util.ArrayList;

public class AsyncRunAccessReport {

  public static void main(String[] args) throws Exception {
    asyncRunAccessReport();
  }

  public static void asyncRunAccessReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      RunAccessReportRequest request =
          RunAccessReportRequest.newBuilder()
              .setEntity("entity-1298275357")
              .addAllDimensions(new ArrayList<AccessDimension>())
              .addAllMetrics(new ArrayList<AccessMetric>())
              .addAllDateRanges(new ArrayList<AccessDateRange>())
              .setDimensionFilter(AccessFilterExpression.newBuilder().build())
              .setMetricFilter(AccessFilterExpression.newBuilder().build())
              .setOffset(-1019779949)
              .setLimit(102976443)
              .setTimeZone("timeZone-2077180903")
              .addAllOrderBys(new ArrayList<AccessOrderBy>())
              .setReturnEntityQuota(true)
              .setIncludeAllUsers(true)
              .setExpandGroups(true)
              .build();
      ApiFuture<RunAccessReportResponse> future =
          analyticsAdminServiceClient.runAccessReportCallable().futureCall(request);
      // Do something.
      RunAccessReportResponse response = future.get();
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_RunAccessReport_async]
