/*
 * Copyright 2018 Google LLC
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
 * A client to Stackdriver Monitoring API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>================== GroupServiceClient ==================
 *
 * <p>Service Description: The Group API lets you inspect and manage your
 * [groups](google.monitoring.v3.Group).
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
 * <pre>
 * <code>
 * try (GroupServiceClient groupServiceClient = GroupServiceClient.create()) {
 *   GroupName name = GroupName.of("[PROJECT]", "[GROUP]");
 *   Group response = groupServiceClient.getGroup(name);
 * }
 * </code>
 * </pre>
 *
 * =================== MetricServiceClient ===================
 *
 * <p>Service Description: Manages metric descriptors, monitored resource descriptors, and time
 * series data.
 *
 * <p>Sample for MetricServiceClient:
 *
 * <pre>
 * <code>
 * try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
 *   MonitoredResourceDescriptorName name = MonitoredResourceDescriptorName.of("[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
 *   MonitoredResourceDescriptor response = metricServiceClient.getMonitoredResourceDescriptor(name);
 * }
 * </code>
 * </pre>
 *
 * ======================== UptimeCheckServiceClient ========================
 *
 * <p>Service Description: The UptimeCheckService API is used to manage (list, create, delete, edit)
 * uptime check configurations in the Stackdriver Monitoring product. An uptime check is a piece of
 * configuration that determines which resources and services to monitor for availability. These
 * configurations can also be configured interactively by navigating to the [Cloud Console]
 * (http://console.cloud.google.com), selecting the appropriate project, clicking on "Monitoring" on
 * the left-hand side to navigate to Stackdriver, and then clicking on "Uptime".
 *
 * <p>Sample for UptimeCheckServiceClient:
 *
 * <pre>
 * <code>
 * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
 *   String formattedName = UptimeCheckConfigName.of("[PROJECT]", "[UPTIME_CHECK_CONFIG]").toString();
 *   UptimeCheckConfig response = uptimeCheckServiceClient.getUptimeCheckConfig(formattedName);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.monitoring.v3;
