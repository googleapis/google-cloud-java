/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Stackdriver Monitoring Dashboards API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DashboardsServiceClient =======================
 *
 * <p>Service Description: Manages Stackdriver dashboards. A dashboard is an arrangement of data
 * display widgets in a specific layout.
 *
 * <p>Sample for DashboardsServiceClient:
 *
 * <pre>
 * <code>
 * try (DashboardsServiceClient dashboardsServiceClient = DashboardsServiceClient.create()) {
 *   String parent = "";
 *   Dashboard dashboard = Dashboard.newBuilder().build();
 *   CreateDashboardRequest request = CreateDashboardRequest.newBuilder()
 *     .setParent(parent)
 *     .setDashboard(dashboard)
 *     .build();
 *   Dashboard response = dashboardsServiceClient.createDashboard(request);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.monitoring.dashboard.v1;

import javax.annotation.Generated;
