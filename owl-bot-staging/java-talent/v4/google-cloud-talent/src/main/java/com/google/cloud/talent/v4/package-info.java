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
 * <p>======================= CompanyServiceClient =======================
 *
 * <p>Service Description: A service that handles company management, including CRUD and
 * enumeration.
 *
 * <p>Sample for CompanyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
 *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   Company company = Company.newBuilder().build();
 *   Company response = companyServiceClient.createCompany(parent, company);
 * }
 * }</pre>
 *
 * <p>======================= CompletionClient =======================
 *
 * <p>Service Description: A service handles auto completion.
 *
 * <p>Sample for CompletionClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CompletionClient completionClient = CompletionClient.create()) {
 *   CompleteQueryRequest request =
 *       CompleteQueryRequest.newBuilder()
 *           .setTenant(TenantName.of("[PROJECT]", "[TENANT]").toString())
 *           .setQuery("query107944136")
 *           .addAllLanguageCodes(new ArrayList<String>())
 *           .setPageSize(883849137)
 *           .setCompany(CompanyName.of("[PROJECT]", "[TENANT]", "[COMPANY]").toString())
 *           .build();
 *   CompleteQueryResponse response = completionClient.completeQuery(request);
 * }
 * }</pre>
 *
 * <p>======================= EventServiceClient =======================
 *
 * <p>Service Description: A service handles client event report.
 *
 * <p>Sample for EventServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
 *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   ClientEvent clientEvent = ClientEvent.newBuilder().build();
 *   ClientEvent response = eventServiceClient.createClientEvent(parent, clientEvent);
 * }
 * }</pre>
 *
 * <p>======================= JobServiceClient =======================
 *
 * <p>Service Description: A service handles job management, including job CRUD, enumeration and
 * search.
 *
 * <p>Sample for JobServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
 *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   Job job = Job.newBuilder().build();
 *   Job response = jobServiceClient.createJob(parent, job);
 * }
 * }</pre>
 *
 * <p>======================= TenantServiceClient =======================
 *
 * <p>Service Description: A service that handles tenant management, including CRUD and enumeration.
 *
 * <p>Sample for TenantServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Tenant tenant = Tenant.newBuilder().build();
 *   Tenant response = tenantServiceClient.createTenant(parent, tenant);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.talent.v4;

import javax.annotation.Generated;
