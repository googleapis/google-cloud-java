/*
 * Copyright 2020 Google LLC
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
 * A client to Cloud Talent Solution API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================== ApplicationServiceClient ========================
 *
 * <p>Service Description: A service that handles application management, including CRUD and
 * enumeration.
 *
 * <p>Sample for ApplicationServiceClient:
 *
 * <pre>
 * <code>
 * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
 *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
 *   Application application = Application.newBuilder().build();
 *   Application response = applicationServiceClient.createApplication(parent, application);
 * }
 * </code>
 * </pre>
 *
 * ==================== CompanyServiceClient ====================
 *
 * <p>Service Description: A service that handles company management, including CRUD and
 * enumeration.
 *
 * <p>Sample for CompanyServiceClient:
 *
 * <pre>
 * <code>
 * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
 *   TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   Company company = Company.newBuilder().build();
 *   Company response = companyServiceClient.createCompany(parent, company);
 * }
 * </code>
 * </pre>
 *
 * ================ CompletionClient ================
 *
 * <p>Service Description: A service handles auto completion.
 *
 * <p>Sample for CompletionClient:
 *
 * <pre>
 * <code>
 * try (CompletionClient completionClient = CompletionClient.create()) {
 *   TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   String query = "";
 *   int pageSize = 0;
 *   CompleteQueryRequest request = CompleteQueryRequest.newBuilder()
 *     .setParent(parent.toString())
 *     .setQuery(query)
 *     .setPageSize(pageSize)
 *     .build();
 *   CompleteQueryResponse response = completionClient.completeQuery(request);
 * }
 * </code>
 * </pre>
 *
 * ================== EventServiceClient ==================
 *
 * <p>Service Description: A service handles client event report.
 *
 * <p>Sample for EventServiceClient:
 *
 * <pre>
 * <code>
 * try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
 *   TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   ClientEvent clientEvent = ClientEvent.newBuilder().build();
 *   ClientEvent response = eventServiceClient.createClientEvent(parent, clientEvent);
 * }
 * </code>
 * </pre>
 *
 * ================ JobServiceClient ================
 *
 * <p>Service Description: A service handles job management, including job CRUD, enumeration and
 * search.
 *
 * <p>Sample for JobServiceClient:
 *
 * <pre>
 * <code>
 * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
 *   TenantOrProjectName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   Job job = Job.newBuilder().build();
 *   Job response = jobServiceClient.createJob(parent, job);
 * }
 * </code>
 * </pre>
 *
 * ==================== ProfileServiceClient ====================
 *
 * <p>Service Description: A service that handles profile management, including profile CRUD,
 * enumeration and search.
 *
 * <p>Sample for ProfileServiceClient:
 *
 * <pre>
 * <code>
 * try (ProfileServiceClient profileServiceClient = ProfileServiceClient.create()) {
 *   TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
 *   Profile profile = Profile.newBuilder().build();
 *   Profile response = profileServiceClient.createProfile(parent, profile);
 * }
 * </code>
 * </pre>
 *
 * =================== TenantServiceClient ===================
 *
 * <p>Service Description: A service that handles tenant management, including CRUD and enumeration.
 *
 * <p>Sample for TenantServiceClient:
 *
 * <pre>
 * <code>
 * try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Tenant tenant = Tenant.newBuilder().build();
 *   Tenant response = tenantServiceClient.createTenant(parent, tenant);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.talent.v4beta1;

import javax.annotation.Generated;
