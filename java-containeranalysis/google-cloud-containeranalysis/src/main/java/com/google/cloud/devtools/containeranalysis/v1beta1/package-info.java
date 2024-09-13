/*
 * Copyright 2024 Google LLC
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
 * A client to Container Analysis API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ContainerAnalysisV1Beta1Client =======================
 *
 * <p>Service Description: Retrieves analysis results of Cloud components such as Docker container
 * images. The Container Analysis API is an implementation of the [Grafeas](https://grafeas.io) API.
 *
 * <p>Analysis results are stored as a series of occurrences. An `Occurrence` contains information
 * about a specific analysis instance on a resource. An occurrence refers to a `Note`. A note
 * contains details describing the analysis and is generally stored in a separate project, called a
 * `Provider`. Multiple occurrences can refer to the same note.
 *
 * <p>For example, an SSL vulnerability could affect multiple images. In this case, there would be
 * one note for the vulnerability and an occurrence for each image with the vulnerability referring
 * to that note.
 *
 * <p>Sample for ContainerAnalysisV1Beta1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create()) {
 *   ResourceName resource =
 *       new ResourceName() {
 *         {@literal @}Override
 *         public Map<String, String> getFieldValuesMap() {
 *           Map<String, String> fieldValuesMap = new HashMap<>();
 *           fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
 *           return fieldValuesMap;
 *         }
 *
 *         {@literal @}Override
 *         public String getFieldValue(String fieldName) {
 *           return getFieldValuesMap().get(fieldName);
 *         }
 *
 *         {@literal @}Override
 *         public String toString() {
 *           return "projects/project-8432/notes/note-8432";
 *         }
 *       };
 *   Policy policy = Policy.newBuilder().build();
 *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource, policy);
 * }
 * }</pre>
 *
 * <p>======================= GrafeasV1Beta1Client =======================
 *
 * <p>Service Description: [Grafeas](grafeas.io) API.
 *
 * <p>Retrieves analysis results of Cloud components such as Docker container images.
 *
 * <p>Analysis results are stored as a series of occurrences. An `Occurrence` contains information
 * about a specific analysis instance on a resource. An occurrence refers to a `Note`. A note
 * contains details describing the analysis and is generally stored in a separate project, called a
 * `Provider`. Multiple occurrences can refer to the same note.
 *
 * <p>For example, an SSL vulnerability could affect multiple images. In this case, there would be
 * one note for the vulnerability and an occurrence for each image with the vulnerability referring
 * to that note.
 *
 * <p>Sample for GrafeasV1Beta1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GrafeasV1Beta1Client grafeasV1Beta1Client = GrafeasV1Beta1Client.create()) {
 *   GetOccurrenceRequest request =
 *       GetOccurrenceRequest.newBuilder().setName("name3373707").build();
 *   Occurrence response = grafeasV1Beta1Client.getOccurrence(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.devtools.containeranalysis.v1beta1;

import javax.annotation.Generated;
