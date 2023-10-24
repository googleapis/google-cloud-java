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
 * A client to Cloud Quotas API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CloudQuotasClient =======================
 *
 * <p>Service Description: The Cloud Quotas API is an infrastructure service for Google Cloud that
 * lets service consumers list and manage their resource usage limits.
 *
 * <p>- List/Get the metadata and current status of the quotas for a service. - Create/Update quota
 * preferencess that declare the preferred quota values. - Check the status of a quota preference
 * request. - List/Get pending and historical quota preference.
 *
 * <p>Sample for CloudQuotasClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
 *   QuotaInfoName name =
 *       QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
 *           "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");
 *   QuotaInfo response = cloudQuotasClient.getQuotaInfo(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.api.cloudquotas.v1;

import javax.annotation.Generated;
