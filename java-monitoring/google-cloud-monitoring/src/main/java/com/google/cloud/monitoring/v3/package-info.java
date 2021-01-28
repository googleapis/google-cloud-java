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
 * <p>======================= AlertPolicyServiceClient =======================
 *
 * <p>Service Description: The AlertPolicyService API is used to manage (list, create, delete, edit)
 * alert policies in Stackdriver Monitoring. An alerting policy is a description of the conditions
 * under which some aspect of your system is considered to be "unhealthy" and the ways to notify
 * people or services about this state. In addition to using this API, alert policies can also be
 * managed through [Stackdriver Monitoring](https://cloud.google.com/monitoring/docs/), which can be
 * reached by clicking the "Monitoring" tab in [Cloud Console](https://console.cloud.google.com/).
 *
 * <p>Sample for AlertPolicyServiceClient:
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
 * <p>======================= MetricServiceClient =======================
 *
 * <p>Service Description: Manages metric descriptors, monitored resource descriptors, and time
 * series data.
 *
 * <p>Sample for MetricServiceClient:
 *
 * <p>======================= NotificationChannelServiceClient =======================
 *
 * <p>Service Description: The Notification Channel API provides access to configuration that
 * controls how messages related to incidents are sent.
 *
 * <p>Sample for NotificationChannelServiceClient:
 *
 * <p>======================= ServiceMonitoringServiceClient =======================
 *
 * <p>Service Description: The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
 * managing and querying aspects of a workspace's services. These include the `Service`'s monitored
 * resources, its Service-Level Objectives, and a taxonomy of categorized Health Metrics.
 *
 * <p>Sample for ServiceMonitoringServiceClient:
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
 */
@Generated("by gapic-generator-java")
package com.google.cloud.monitoring.v3;

import javax.annotation.Generated;
