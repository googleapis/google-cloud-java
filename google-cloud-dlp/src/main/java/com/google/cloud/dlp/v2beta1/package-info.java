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
 * A client to DLP API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>================ DlpServiceClient ================
 *
 * <p>Service Description: The DLP API is a service that allows clients to detect the presence of
 * Personally Identifiable Information (PII) and other privacy-sensitive data in user-supplied,
 * unstructured data streams, like text blocks or images. The service also includes methods for
 * sensitive data redaction and scheduling of data scans on Google Cloud Platform based data sets.
 *
 * <p>Sample for DlpServiceClient:
 *
 * <pre>
 * <code>
 * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
 *   DeidentifyConfig deidentifyConfig = DeidentifyConfig.newBuilder().build();
 *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
 *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
 *   DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(deidentifyConfig, inspectConfig, items);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.dlp.v2beta1;
