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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ErrorGroupServiceClient =======================
 *
 * <p>Service Description: Service for retrieving and updating individual error groups.
 *
 * <p>Sample for ErrorGroupServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ErrorGroupServiceClient errorGroupServiceClient = ErrorGroupServiceClient.create()) {
 *   ErrorGroupName groupName = ErrorGroupName.of("[PROJECT]", "[GROUP]");
 *   ErrorGroup response = errorGroupServiceClient.getGroup(groupName);
 * }
 * }</pre>
 *
 * <p>======================= ErrorStatsServiceClient =======================
 *
 * <p>Service Description: An API for retrieving and managing error statistics as well as data for
 * individual events.
 *
 * <p>Sample for ErrorStatsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
 *   ProjectName projectName = ProjectName.of("[PROJECT]");
 *   DeleteEventsResponse response = errorStatsServiceClient.deleteEvents(projectName);
 * }
 * }</pre>
 *
 * <p>======================= ReportErrorsServiceClient =======================
 *
 * <p>Service Description: An API for reporting error events.
 *
 * <p>Sample for ReportErrorsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReportErrorsServiceClient reportErrorsServiceClient = ReportErrorsServiceClient.create()) {
 *   ProjectName projectName = ProjectName.of("[PROJECT]");
 *   ReportedErrorEvent event = ReportedErrorEvent.newBuilder().build();
 *   ReportErrorEventResponse response =
 *       reportErrorsServiceClient.reportErrorEvent(projectName, event);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.devtools.clouderrorreporting.v1beta1;

import javax.annotation.Generated;
