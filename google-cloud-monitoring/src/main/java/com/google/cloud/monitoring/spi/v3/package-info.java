/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/**
 * A client to Stackdriver Monitoring API.
 *
 * <p>The interfaces provided are listed below, along with a usage sample
 *
 * <p>=============== GroupServiceApi ===============
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
 * <p>Sample for GroupServiceApi:
 *
 * <pre>
 * <code>
 * try (GroupServiceApi groupServiceApi = GroupServiceApi.create()) {
 *   String formattedName = GroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
 *   Group response = groupServiceApi.getGroup(formattedName);
 * }
 * </code>
 * </pre>
 *
 * ================ MetricServiceApi ================
 *
 * <p>Service Description: Manages metric descriptors, monitored resource descriptors, and time
 * series data.
 *
 * <p>Sample for MetricServiceApi:
 *
 * <pre>
 * <code>
 * try (MetricServiceApi metricServiceApi = MetricServiceApi.create()) {
 *   String formattedName = MetricServiceApi.formatMonitoredResourceDescriptorName("[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
 *   MonitoredResourceDescriptor response = metricServiceApi.getMonitoredResourceDescriptor(formattedName);
 * }
 * </code>
 * </pre>
 *
 * ========================== AgentTranslationServiceApi ==========================
 *
 * <p>Service Description: The AgentTranslation API allows `collectd`-based agents to write time
 * series data to Cloud Monitoring. See [google.monitoring.v3.MetricService.CreateTimeSeries]
 * instead.
 *
 * <p>Sample for AgentTranslationServiceApi:
 *
 * <pre>
 * <code>
 * try (AgentTranslationServiceApi agentTranslationServiceApi = AgentTranslationServiceApi.create()) {
 *   String formattedName = AgentTranslationServiceApi.formatProjectName("[PROJECT]");
 *   MonitoredResource resource = MonitoredResource.newBuilder().build();
 *   String collectdVersion = "";
 *   List&lt;CollectdPayload&gt; collectdPayloads = new ArrayList&lt;&gt;();
 *   agentTranslationServiceApi.createCollectdTimeSeries(formattedName, resource, collectdVersion, collectdPayloads);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.monitoring.spi.v3;
