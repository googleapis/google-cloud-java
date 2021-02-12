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
 * <p>======================= SecurityCenterClient =======================
 *
 * <p>Service Description: V1 APIs for Security Center service.
 *
 * <p>Sample for SecurityCenterClient:
 *
 * <pre>{@code
 * try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
 *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
 *   Source source = Source.newBuilder().build();
 *   Source response = securityCenterClient.createSource(parent, source);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.securitycenter.v1;

import javax.annotation.Generated;
