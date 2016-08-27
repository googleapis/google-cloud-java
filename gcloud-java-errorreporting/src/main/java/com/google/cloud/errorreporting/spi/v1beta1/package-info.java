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
 * A client to Stackdriver Error Reporting API.
 *
 * The interfaces provided are listed below, along with a usage sample
 *
 * ====================
 * ErrorGroupServiceApi
 * ====================
 *
 * Service Description: Service for retrieving and updating individual error groups.
 *
 * Sample for ErrorGroupServiceApi:
 * <pre>
 * <code>
 * try (ErrorGroupServiceApi errorGroupServiceApi = ErrorGroupServiceApi.create()) {
 *   String formattedGroupName = ErrorGroupServiceApi.formatGroupName("[PROJECT]", "[GROUP]");
 *   ErrorGroup response = errorGroupServiceApi.getGroup(formattedGroupName);
 * }
 * </code>
 * </pre>
 *
 * ====================
 * ErrorStatsServiceApi
 * ====================
 *
 * Service Description: An API for retrieving and managing error statistics as well as data for
 * individual events.
 *
 * Sample for ErrorStatsServiceApi:
 * <pre>
 * <code>
 * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
 *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
 *   DeleteEventsResponse response = errorStatsServiceApi.deleteEvents(formattedProjectName);
 * }
 * </code>
 * </pre>
 *
 * ======================
 * ReportErrorsServiceApi
 * ======================
 *
 * Service Description: An API for reporting error events.
 *
 * Sample for ReportErrorsServiceApi:
 * <pre>
 * <code>
 * try (ReportErrorsServiceApi reportErrorsServiceApi = ReportErrorsServiceApi.create()) {
 *   String formattedProjectName = ReportErrorsServiceApi.formatProjectName("[PROJECT]");
 *   ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
 *   ReportErrorEventResponse response = reportErrorsServiceApi.reportErrorEvent(formattedProjectName, event);
 * }
 * </code>
 * </pre>
 *
 */
package com.google.cloud.errorreporting.spi.v1beta1;
