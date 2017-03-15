/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Stackdriver Logging API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>============= LoggingClient =============
 *
 * <p>Service Description: Service for ingesting and querying logs.
 *
 * <p>Sample for LoggingClient:
 *
 * <pre>
 * <code>
 * try (LoggingClient loggingClient = LoggingClient.create()) {
 *   LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
 *   loggingClient.deleteLog(logName);
 * }
 * </code>
 * </pre>
 *
 * ============ ConfigClient ============
 *
 * <p>Service Description: Service for configuring sinks used to export log entries outside of
 * Stackdriver Logging.
 *
 * <p>Sample for ConfigClient:
 *
 * <pre>
 * <code>
 * try (ConfigClient configClient = ConfigClient.create()) {
 *   SinkNameOneof sinkName = SinkNameOneof.from(SinkName.create("[PROJECT]", "[SINK]"));
 *   LogSink response = configClient.getSink(sinkName);
 * }
 * </code>
 * </pre>
 *
 * ============= MetricsClient =============
 *
 * <p>Service Description: Service for configuring logs-based metrics.
 *
 * <p>Sample for MetricsClient:
 *
 * <pre>
 * <code>
 * try (MetricsClient metricsClient = MetricsClient.create()) {
 *   MetricNameOneof metricName = MetricNameOneof.from(MetricName.create("[PROJECT]", "[METRIC]"));
 *   LogMetric response = metricsClient.getLogMetric(metricName);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.logging.spi.v2;
