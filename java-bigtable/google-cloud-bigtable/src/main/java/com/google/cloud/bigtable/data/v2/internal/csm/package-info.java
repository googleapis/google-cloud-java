/*
 * Copyright 2026 Google LLC
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
 * Clientside metrics apis
 *
 * <p>Bigtable clientside metrics are implemented using Opentelemetry. However unlike most libraries
 * that use Opentelemetry, the Bigtable client bundles its own exporter that is on by default. The
 * metrics collected are exported to Cloud Monitoring.
 *
 * <p>There are 3 types of metrics that are collected:
 *
 * <ul>
 *   <li>Table based metrics - these metrics are meant to be the clientside counterpart of the
 *       serverside bigtable_table metrics. The are tied to Table-bound RPCs.
 *   <li>Client based metrics - these metrics are internal and used to monitor the e2e health of the
 *       client. They are tied to the bigtable_client resource.
 *   <li>Client based gRPC metrics - these are metrics collected by the underlying gRPC library and
 *       are exported using the bigtable_client resource
 * </ul>
 *
 * <p>The client will attach relevant attributes to the measurement when it is being recorded. There
 * are 2 types of attributes: resource and metric. Some of the table based resource attributes are
 * dynamic and are extracted from an RPC response. To facilitate this, the resource attributes will
 * be sent into Opentelemetry as metric attributes and then during export, the attributes will be
 * split between the monitored resource and metric labels.
 *
 * <p>Client based metrics use a schema that's mostly static, however some of the attributes are
 * slow to resolve. The resolution of those attributes will be deferred until the export phase in
 * the Exporter. While the non-expensive ones will be sent as metric attributes same as table based
 * metrics
 *
 * <p>Client based gRPC metrics are recorded by gRPC and don't have access to the any Bigtable
 * attributes. All of the Bigtable attributes will be filled in by the Exporter.
 *
 * <p>To make this manageable, attributes from different sources are encapsulated by POJOs and are
 * plumbed to the RpcTracer and the Exporter. The metrics themselves are wrapped in typesafe
 * classes. Each metric has its own class which will have a metric specific record method. In
 * addition the metric classes will extend a schema specific class (ie AbstractClientMetric). The
 * schema specific class will serve 2 use cases:
 *
 * <ul>
 *   <li>During the record phase, createResourceAttrs method, will ensure all of the resource
 *       attributes are captured as metric attributes.
 *   <li>During the export phase, createMonitoredResource and createMetricLabels methods are used to
 *       extract a MonitoredResource and Metric labels.
 * </ul>
 */
package com.google.cloud.bigtable.data.v2.internal.csm;
