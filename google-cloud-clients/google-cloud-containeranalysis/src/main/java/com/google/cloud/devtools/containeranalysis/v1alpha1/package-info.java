/*
 * Copyright 2018 Google LLC
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
 * A client to Container Analysis API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ContainerAnalysisClient =======================
 *
 * <p>Service Description: Retrieves the results of vulnerability scanning of cloud components such
 * as container images. The Container Analysis API is an implementation of the [Grafeas](grafeas.io)
 * API.
 *
 * <p>The vulnerability results are stored as a series of Occurrences. An `Occurrence` contains
 * information about a specific vulnerability in a resource. An `Occurrence` references a `Note`. A
 * `Note` contains details about the vulnerability and is stored in a stored in a separate project.
 * Multiple `Occurrences` can reference the same `Note`. For example, an SSL vulnerability could
 * affect multiple packages in an image. In this case, there would be one `Note` for the
 * vulnerability and an `Occurrence` for each package with the vulnerability referencing that
 * `Note`.
 *
 * <p>Sample for ContainerAnalysisClient:
 *
 * <pre>
 * <code>
 * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
 *   String formattedName = ContainerAnalysisClient.formatOccurrenceName("[PROJECT]", "[OCCURRENCE]");
 *   Occurrence response = containerAnalysisClient.getOccurrence(formattedName);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.devtools.containeranalysis.v1alpha1;
