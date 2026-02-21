/*
 * Copyright 2026 Google LLC
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
 * A client to Data Manager API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= IngestionServiceClient =======================
 *
 * <p>Service Description: Service for sending audience data to supported destinations.
 *
 * <p>Sample for IngestionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
 *   IngestAudienceMembersRequest request =
 *       IngestAudienceMembersRequest.newBuilder()
 *           .addAllDestinations(new ArrayList<Destination>())
 *           .addAllAudienceMembers(new ArrayList<AudienceMember>())
 *           .setConsent(Consent.newBuilder().build())
 *           .setValidateOnly(true)
 *           .setEncoding(Encoding.forNumber(0))
 *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
 *           .setTermsOfService(TermsOfService.newBuilder().build())
 *           .build();
 *   IngestAudienceMembersResponse response =
 *       ingestionServiceClient.ingestAudienceMembers(request);
 * }
 * }</pre>
 *
 * <p>======================= MarketingDataInsightsServiceClient =======================
 *
 * <p>Service Description: Service to return insights on marketing data.
 *
 * <p>This feature is only available to data partners.
 *
 * <p>Sample for MarketingDataInsightsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
 *     MarketingDataInsightsServiceClient.create()) {
 *   RetrieveInsightsRequest request =
 *       RetrieveInsightsRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setBaseline(Baseline.newBuilder().build())
 *           .setUserListId("userListId1381604868")
 *           .build();
 *   RetrieveInsightsResponse response =
 *       marketingDataInsightsServiceClient.retrieveInsights(request);
 * }
 * }</pre>
 *
 * <p>======================= PartnerLinkServiceClient =======================
 *
 * <p>Service Description: Service for managing partner links.
 *
 * <p>Sample for PartnerLinkServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
 *   PartnerLink partnerLink = PartnerLink.newBuilder().build();
 *   PartnerLink response = partnerLinkServiceClient.createPartnerLink(parent, partnerLink);
 * }
 * }</pre>
 *
 * <p>======================= UserListDirectLicenseServiceClient =======================
 *
 * <p>Service Description: Service for managing user list direct licenses. Delete is not a supported
 * operation for UserListDirectLicenses. Callers should update the license status to DISABLED to
 * instead to deactivate a license.
 *
 * <p>This feature is only available to data partners.
 *
 * <p>Sample for UserListDirectLicenseServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
 *     UserListDirectLicenseServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
 *   UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
 *   UserListDirectLicense response =
 *       userListDirectLicenseServiceClient.createUserListDirectLicense(
 *           parent, userListDirectLicense);
 * }
 * }</pre>
 *
 * <p>======================= UserListGlobalLicenseServiceClient =======================
 *
 * <p>Service Description: Service for managing user list global licenses. Delete is not a supported
 * operation for UserListGlobalLicenses. Callers should update the license status to DISABLED to
 * instead to deactivate a license.
 *
 * <p>This feature is only available to data partners.
 *
 * <p>Sample for UserListGlobalLicenseServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
 *     UserListGlobalLicenseServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
 *   UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
 *   UserListGlobalLicense response =
 *       userListGlobalLicenseServiceClient.createUserListGlobalLicense(
 *           parent, userListGlobalLicense);
 * }
 * }</pre>
 *
 * <p>======================= UserListServiceClient =======================
 *
 * <p>Service Description: Service for managing UserList resources.
 *
 * <p>Sample for UserListServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
 *   UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");
 *   UserList response = userListServiceClient.getUserList(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.ads.datamanager.v1;

import javax.annotation.Generated;
