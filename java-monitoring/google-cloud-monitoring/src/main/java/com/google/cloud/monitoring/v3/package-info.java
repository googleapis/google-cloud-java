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
 * A client to Cloud Monitoring API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AlertPolicyServiceClient =======================
 *
 * <p>Service Description: The AlertPolicyService API is used to manage (list, create, delete, edit)
 * alert policies in Cloud Monitoring. An alerting policy is a description of the conditions under
 * which some aspect of your system is considered to be "unhealthy" and the ways to notify people or
 * services about this state. In addition to using this API, alert policies can also be managed
 * through [Cloud Monitoring](https://cloud.google.com/monitoring/docs/), which can be reached by
 * clicking the "Monitoring" tab in [Cloud console](https://console.cloud.google.com/).
 *
 * <p>Sample for AlertPolicyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AlertPolicyServiceClient alertPolicyServiceClient = AlertPolicyServiceClient.create()) {
 *   AlertPolicyName name =
 *       AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]");
 *   AlertPolicy response = alertPolicyServiceClient.getAlertPolicy(name);
 * }
 * }</pre>
 *
 * <p>======================= GroupServiceClient =======================
 *
 * <p>Service Description: The Group API lets you inspect and manage your
 * [groups](#google.monitoring.v3.Group).
 *
 * <p>A group is a named filter that is used to identify a collection of monitored resources. Groups
 * are typically used to mirror the physical and/or logical topology of the environment. Because
 * group membership is computed dynamically, monitored resources that are started in the future are
 * automatically placed in matching groups. By using a group to name monitored resources in, for
 * example, an alert policy, the target of that alert policy is updated automatically as monitored
 * resources are added and removed from the infrastructure.
 *
 * <p>Sample for GroupServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
 *   GroupName name = GroupName.ofProjectGroupName("[PROJECT]", "[GROUP]");
 *   Group response = groupServiceClient.getGroup(name);
 * }
 * }</pre>
 *
 * <p>======================= MetricServiceClient =======================
 *
 * <p>Service Description: Manages metric descriptors, monitored resource descriptors, and time
 * series data.
 *
 * <p>Sample for MetricServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
 *   MonitoredResourceDescriptorName name =
 *       MonitoredResourceDescriptorName.ofProjectMonitoredResourceDescriptorName(
 *           "[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
 *   MonitoredResourceDescriptor response =
 *       metricServiceClient.getMonitoredResourceDescriptor(name);
 * }
 * }</pre>
 *
 * <p>======================= NotificationChannelServiceClient =======================
 *
 * <p>Service Description: The Notification Channel API provides access to configuration that
 * controls how messages related to incidents are sent.
 *
 * <p>Sample for NotificationChannelServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NotificationChannelServiceClient notificationChannelServiceClient =
 *     NotificationChannelServiceClient.create()) {
 *   NotificationChannelDescriptorName name =
 *       NotificationChannelDescriptorName.ofProjectChannelDescriptorName(
 *           "[PROJECT]", "[CHANNEL_DESCRIPTOR]");
 *   NotificationChannelDescriptor response =
 *       notificationChannelServiceClient.getNotificationChannelDescriptor(name);
 * }
 * }</pre>
 *
 * <p>======================= QueryServiceClient =======================
 *
 * <p>Service Description: The QueryService API is used to manage time series data in Stackdriver
 * Monitoring. Time series data is a collection of data points that describes the time-varying
 * values of a metric.
 *
 * <p>Sample for QueryServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (QueryServiceClient queryServiceClient = QueryServiceClient.create()) {
 *   QueryTimeSeriesRequest request =
 *       QueryTimeSeriesRequest.newBuilder()
 *           .setName("name3373707")
 *           .setQuery("query107944136")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (TimeSeriesData element : queryServiceClient.queryTimeSeries(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= ServiceMonitoringServiceClient =======================
 *
 * <p>Service Description: The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
 * managing and querying aspects of a workspace's services. These include the `Service`'s monitored
 * resources, its Service-Level Objectives, and a taxonomy of categorized Health Metrics.
 *
 * <p>Sample for ServiceMonitoringServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ServiceMonitoringServiceClient serviceMonitoringServiceClient =
 *     ServiceMonitoringServiceClient.create()) {
 *   FolderName parent = FolderName.of("[FOLDER]");
 *   Service service = Service.newBuilder().build();
 *   Service response = serviceMonitoringServiceClient.createService(parent, service);
 * }
 * }</pre>
 *
 * <p>======================= SnoozeServiceClient =======================
 *
 * <p>Service Description: The SnoozeService API is used to temporarily prevent an alert policy from
 * generating alerts. A Snooze is a description of the criteria under which one or more alert
 * policies should not fire alerts for the specified duration.
 *
 * <p>Sample for SnoozeServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Snooze snooze = Snooze.newBuilder().build();
 *   Snooze response = snoozeServiceClient.createSnooze(parent, snooze);
 * }
 * }</pre>
 *
 * <p>======================= UptimeCheckServiceClient =======================
 *
 * <p>Service Description: The UptimeCheckService API is used to manage (list, create, delete, edit)
 * Uptime check configurations in the Stackdriver Monitoring product. An Uptime check is a piece of
 * configuration that determines which resources and services to monitor for availability. These
 * configurations can also be configured interactively by navigating to the [Cloud Console]
 * (http://console.cloud.google.com), selecting the appropriate project, clicking on "Monitoring" on
 * the left-hand side to navigate to Stackdriver, and then clicking on "Uptime".
 *
 * <p>Sample for UptimeCheckServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
 *   UptimeCheckConfigName name =
 *       UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
 *           "[PROJECT]", "[UPTIME_CHECK_CONFIG]");
 *   UptimeCheckConfig response = uptimeCheckServiceClient.getUptimeCheckConfig(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.monitoring.v3;

import javax.annotation.Generated;
