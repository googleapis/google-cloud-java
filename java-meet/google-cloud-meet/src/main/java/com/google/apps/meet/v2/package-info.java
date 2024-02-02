/*
 * Copyright 2023 Google LLC
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
 * A client to Google Meet API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SpacesServiceClient =======================
 *
 * <p>Service Description: REST API for services dealing with spaces.
 *
 * <p>Sample for SpacesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
 *   Space space = Space.newBuilder().build();
 *   Space response = spacesServiceClient.createSpace(space);
 * }
 * }</pre>
 *
 * <p>======================= ConferenceRecordsServiceClient =======================
 *
 * <p>Service Description: REST API for services dealing with conference records.
 *
 * <p>Sample for ConferenceRecordsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
 *     ConferenceRecordsServiceClient.create()) {
 *   ConferenceRecordName name = ConferenceRecordName.of("[CONFERENCE_RECORD]");
 *   ConferenceRecord response = conferenceRecordsServiceClient.getConferenceRecord(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.apps.meet.v2;

import javax.annotation.Generated;
