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
 * A client to Chronicle API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= BigQueryExportServiceClient =======================
 *
 * <p>Service Description: Service for managing BigQuery export configurations for Chronicle
 * instances.
 *
 * <p>Sample for BigQueryExportServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BigQueryExportServiceClient bigQueryExportServiceClient =
 *     BigQueryExportServiceClient.create()) {
 *   BigQueryExportName name = BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   BigQueryExport response = bigQueryExportServiceClient.getBigQueryExport(name);
 * }
 * }</pre>
 *
 * <p>======================= DashboardChartServiceClient =======================
 *
 * <p>Service Description: A service providing functionality for managing dashboards' charts.
 *
 * <p>Sample for DashboardChartServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DashboardChartServiceClient dashboardChartServiceClient =
 *     DashboardChartServiceClient.create()) {
 *   DashboardChartName name =
 *       DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]");
 *   DashboardChart response = dashboardChartServiceClient.getDashboardChart(name);
 * }
 * }</pre>
 *
 * <p>======================= DashboardQueryServiceClient =======================
 *
 * <p>Service Description: A service providing functionality for managing dashboards' queries.
 *
 * <p>Sample for DashboardQueryServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DashboardQueryServiceClient dashboardQueryServiceClient =
 *     DashboardQueryServiceClient.create()) {
 *   DashboardQueryName name =
 *       DashboardQueryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[QUERY]");
 *   DashboardQuery response = dashboardQueryServiceClient.getDashboardQuery(name);
 * }
 * }</pre>
 *
 * <p>======================= DataAccessControlServiceClient =======================
 *
 * <p>Service Description: DataAccessControlService exposes resources and endpoints related to data
 * access control.
 *
 * <p>Sample for DataAccessControlServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataAccessControlServiceClient dataAccessControlServiceClient =
 *     DataAccessControlServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
 *   String dataAccessLabelId = "dataAccessLabelId1775298977";
 *   DataAccessLabel response =
 *       dataAccessControlServiceClient.createDataAccessLabel(
 *           parent, dataAccessLabel, dataAccessLabelId);
 * }
 * }</pre>
 *
 * <p>======================= DataTableServiceClient =======================
 *
 * <p>Service Description: DataTableManager provides an interface for managing data tables.
 *
 * <p>Sample for DataTableServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   DataTable dataTable = DataTable.newBuilder().build();
 *   String dataTableId = "dataTableId1260854911";
 *   DataTable response = dataTableServiceClient.createDataTable(parent, dataTable, dataTableId);
 * }
 * }</pre>
 *
 * <p>======================= EntityServiceClient =======================
 *
 * <p>Service Description: EntityService contains apis for finding entities.
 *
 * <p>Sample for EntityServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
 *   WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
 *   Watchlist response = entityServiceClient.getWatchlist(name);
 * }
 * }</pre>
 *
 * <p>======================= FeaturedContentNativeDashboardServiceClient =======================
 *
 * <p>Service Description: This service provides functionality for managing
 * FeaturedContentNativeDashboard.
 *
 * <p>Sample for FeaturedContentNativeDashboardServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
 *     FeaturedContentNativeDashboardServiceClient.create()) {
 *   FeaturedContentNativeDashboardName name =
 *       FeaturedContentNativeDashboardName.of(
 *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");
 *   FeaturedContentNativeDashboard response =
 *       featuredContentNativeDashboardServiceClient.getFeaturedContentNativeDashboard(name);
 * }
 * }</pre>
 *
 * <p>======================= InstanceServiceClient =======================
 *
 * <p>Service Description: InstanceService provides the entry interface for the Chronicle API.
 *
 * <p>Sample for InstanceServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstanceServiceClient instanceServiceClient = InstanceServiceClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = instanceServiceClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>======================= NativeDashboardServiceClient =======================
 *
 * <p>Service Description: A service providing functionality for managing native dashboards.
 *
 * <p>Sample for NativeDashboardServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NativeDashboardServiceClient nativeDashboardServiceClient =
 *     NativeDashboardServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
 *   NativeDashboard response =
 *       nativeDashboardServiceClient.createNativeDashboard(parent, nativeDashboard);
 * }
 * }</pre>
 *
 * <p>======================= ReferenceListServiceClient =======================
 *
 * <p>Service Description: ReferenceListService provides an interface for managing reference lists.
 *
 * <p>Sample for ReferenceListServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReferenceListServiceClient referenceListServiceClient =
 *     ReferenceListServiceClient.create()) {
 *   ReferenceListName name =
 *       ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");
 *   ReferenceList response = referenceListServiceClient.getReferenceList(name);
 * }
 * }</pre>
 *
 * <p>======================= RuleServiceClient =======================
 *
 * <p>Service Description: RuleService provides interface for user-created rules.
 *
 * <p>Sample for RuleServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RuleServiceClient ruleServiceClient = RuleServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Rule rule = Rule.newBuilder().build();
 *   Rule response = ruleServiceClient.createRule(parent, rule);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.chronicle.v1;

import javax.annotation.Generated;
