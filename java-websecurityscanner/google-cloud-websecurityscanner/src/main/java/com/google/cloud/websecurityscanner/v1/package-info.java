/*
 * Copyright 2020 Google LLC
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
 * <p>======================= WebSecurityScannerClient =======================
 *
 * <p>Service Description: Web Security Scanner Service identifies security vulnerabilities in web
 * applications hosted on Google Cloud. It crawls your application, and attempts to exercise as many
 * user inputs and event handlers as possible.
 *
 * <p>Sample for WebSecurityScannerClient:
 *
 * <pre>{@code
 * try (WebSecurityScannerClient webSecurityScannerClient = WebSecurityScannerClient.create()) {
 *   CreateScanConfigRequest request =
 *       CreateScanConfigRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setScanConfig(ScanConfig.newBuilder().build())
 *           .build();
 *   ScanConfig response = webSecurityScannerClient.createScanConfig(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.websecurityscanner.v1;

import javax.annotation.Generated;
