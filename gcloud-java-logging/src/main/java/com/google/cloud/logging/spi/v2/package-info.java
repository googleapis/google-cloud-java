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

/*
 * EDITING INSTRUCTIONS
 * This file was automatically generated. For the short term, the process for
 * refreshing this file will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, additional documentation should be added between
 * "manual edit" demarcations.
 *
 * Other generated files allow additional edits - see the editing instructions
 * in those files for more details.
 *
 * Happy editing!
 */

/**
 * A client to Google Cloud Logging API.
 *
 * The interfaces provided are listed below, along with a usage sample
 *
 * ===================
 * LoggingServiceV2Api
 * ===================
 *
 * Service Description: Service for ingesting and querying logs.
 *
 * Sample for LoggingServiceV2Api:
 * <pre>
 * <code>
 * try (LoggingServiceV2Api loggingServiceV2Api = LoggingServiceV2Api.createWithDefaults()) {
 *   String formattedLogName = LoggingServiceV2Api.formatLogName("[PROJECT]", "[LOG]");
 *   loggingServiceV2Api.deleteLog(formattedLogName);
 * }
 * </code>
 * </pre>
 *
 * ==================
 * ConfigServiceV2Api
 * ==================
 *
 * Service Description:
 *
 * Sample for ConfigServiceV2Api:
 * <pre>
 * <code>
 * try (ConfigServiceV2Api configServiceV2Api = ConfigServiceV2Api.createWithDefaults()) {
 *   String formattedProjectName = ConfigServiceV2Api.formatProjectName("[PROJECT]");
 *   ListSinksResponse response = configServiceV2Api.listSinks(formattedProjectName);
 * }
 * </code>
 * </pre>
 *
 * ===================
 * MetricsServiceV2Api
 * ===================
 *
 * Service Description:
 *
 * Sample for MetricsServiceV2Api:
 * <pre>
 * <code>
 * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.createWithDefaults()) {
 *   String formattedProjectName = MetricsServiceV2Api.formatProjectName("[PROJECT]");
 *   ListLogMetricsResponse response = metricsServiceV2Api.listLogMetrics(formattedProjectName);
 * }
 * </code>
 * </pre>
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
package com.google.cloud.logging.spi.v2;
