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
 * <p>======================= DomainsClient =======================
 *
 * <p>Service Description: The Cloud Domains API enables management and configuration of domain
 * names.
 *
 * <p>Sample for DomainsClient:
 *
 * <pre>{@code
 * try (DomainsClient domainsClient = DomainsClient.create()) {
 *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String query = "query107944136";
 *   SearchDomainsResponse response = domainsClient.searchDomains(location, query);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.domains.v1beta1;

import javax.annotation.Generated;
