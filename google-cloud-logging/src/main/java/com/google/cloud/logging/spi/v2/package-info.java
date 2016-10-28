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
 * A client to Stackdriver Logging API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=================== LoggingServiceV2Api ===================
 *
 * <p>Service Description: Service for ingesting and querying logs.
 *
 * <p>Sample for LoggingServiceV2Api:
 *
 * <pre>
 * <code>
 * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.create()) {
 *   String formattedLogName = LoggingServiceV2Api.formatLogName("[PROJECT]", "[LOG]");
 *   loggingServiceV2Api.deleteLog(formattedLogName);
 * }
 * </code>
 * </pre>
 *
 * ================== ConfigServiceV2Api ==================
 *
 * <p>Service Description: Service for configuring sinks used to export log entries outside
 * Stackdriver Logging.
 *
 * <p>Sample for ConfigServiceV2Api:
 *
 * <pre>
 * <code>
 * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.create()) {
 *   String formattedSinkName = ConfigServiceV2Api.formatSinkName("[PROJECT]", "[SINK]");
 *   LogSink response = configServiceV2Api.getSink(formattedSinkName);
 * }
 * </code>
 * </pre>
 *
 * =================== MetricsServiceV2Api ===================
 *
 * <p>Service Description: Service for configuring logs-based metrics.
 *
 * <p>Sample for MetricsServiceV2Api:
 *
 * <pre>
 * <code>
 * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
 *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
 *   LogMetric response = metricsServiceV2Api.getLogMetric(formattedMetricName);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.logging.spi.v2;
