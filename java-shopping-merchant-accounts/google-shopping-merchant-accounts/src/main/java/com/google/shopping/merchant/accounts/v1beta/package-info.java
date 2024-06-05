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
 * A client to Merchant API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AccountTaxServiceClient =======================
 *
 * <p>Service Description: Manages account level tax setting data.
 *
 * <p>This API defines the following resource model:
 *
 * <p>- [AccountTax][google.shopping.merchant.accounts.v1main.AccountTax]
 *
 * <p>Sample for AccountTaxServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountTaxServiceClient accountTaxServiceClient = AccountTaxServiceClient.create()) {
 *   AccountTaxName name = AccountTaxName.of("[ACCOUNT]", "[TAX]");
 *   AccountTax response = accountTaxServiceClient.getAccountTax(name);
 * }
 * }</pre>
 *
 * <p>======================= AccountIssueServiceClient =======================
 *
 * <p>Service Description: Service to support `AccountIssueService` API.
 *
 * <p>Sample for AccountIssueServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountIssueServiceClient accountIssueServiceClient = AccountIssueServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   for (AccountIssue element :
 *       accountIssueServiceClient.listAccountIssues(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= AccountsServiceClient =======================
 *
 * <p>Service Description: Service to support Accounts API.
 *
 * <p>Sample for AccountsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
 *   AccountName name = AccountName.of("[ACCOUNT]");
 *   Account response = accountsServiceClient.getAccount(name);
 * }
 * }</pre>
 *
 * <p>======================= BusinessIdentityServiceClient =======================
 *
 * <p>Service Description: Service to support [business
 * identity](https://support.google.com/merchants/answer/12564247) API.
 *
 * <p>Sample for BusinessIdentityServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BusinessIdentityServiceClient businessIdentityServiceClient =
 *     BusinessIdentityServiceClient.create()) {
 *   BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");
 *   BusinessIdentity response = businessIdentityServiceClient.getBusinessIdentity(name);
 * }
 * }</pre>
 *
 * <p>======================= BusinessInfoServiceClient =======================
 *
 * <p>Service Description: Service to support business info API.
 *
 * <p>Sample for BusinessInfoServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
 *   BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");
 *   BusinessInfo response = businessInfoServiceClient.getBusinessInfo(name);
 * }
 * }</pre>
 *
 * <p>======================= EmailPreferencesServiceClient =======================
 *
 * <p>Service Description: Service to support the `EmailPreferences` API.
 *
 * <p>This service only permits retrieving and updating email preferences for the authenticated
 * user.
 *
 * <p>Sample for EmailPreferencesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
 *     EmailPreferencesServiceClient.create()) {
 *   EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");
 *   EmailPreferences response = emailPreferencesServiceClient.getEmailPreferences(name);
 * }
 * }</pre>
 *
 * <p>======================= HomepageServiceClient =======================
 *
 * <p>Service Description: Service to support an API for a store's homepage.
 *
 * <p>Sample for HomepageServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
 *   HomepageName name = HomepageName.of("[ACCOUNT]");
 *   Homepage response = homepageServiceClient.getHomepage(name);
 * }
 * }</pre>
 *
 * <p>======================= OnlineReturnPolicyServiceClient =======================
 *
 * <p>Service Description: The service facilitates the management of a merchant's remorse return
 * policy configuration, encompassing return policies for both ads and free listings ## programs.
 * This API defines the following resource model:
 *
 * <p>[OnlineReturnPolicy][google.shopping.merchant.accounts.v1.OnlineReturnPolicy]
 *
 * <p>Sample for OnlineReturnPolicyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OnlineReturnPolicyServiceClient onlineReturnPolicyServiceClient =
 *     OnlineReturnPolicyServiceClient.create()) {
 *   OnlineReturnPolicyName name = OnlineReturnPolicyName.of("[ACCOUNT]", "[RETURN_POLICY]");
 *   OnlineReturnPolicy response = onlineReturnPolicyServiceClient.getOnlineReturnPolicy(name);
 * }
 * }</pre>
 *
 * <p>======================= ProgramsServiceClient =======================
 *
 * <p>Service Description: Service for program management.
 *
 * <p>Programs provide a mechanism for adding functionality to merchant accounts. A typical example
 * of this is the [Free product
 * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
 * program, which enables products from a merchant's store to be shown across Google for free.
 *
 * <p>This service exposes methods to retrieve a merchant's participation in all available programs,
 * in addition to methods for explicitly enabling or disabling participation in each program.
 *
 * <p>Sample for ProgramsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
 *   ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
 *   Program response = programsServiceClient.getProgram(name);
 * }
 * }</pre>
 *
 * <p>======================= RegionsServiceClient =======================
 *
 * <p>Service Description: Manages regions configuration.
 *
 * <p>This API defines the following resource model:
 *
 * <p>- [Region][google.shopping.merchant.accounts.v1main.Region]
 *
 * <p>Sample for RegionsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionsServiceClient regionsServiceClient = RegionsServiceClient.create()) {
 *   RegionName name = RegionName.of("[ACCOUNT]", "[REGION]");
 *   Region response = regionsServiceClient.getRegion(name);
 * }
 * }</pre>
 *
 * <p>======================= ShippingSettingsServiceClient =======================
 *
 * <p>Service Description: Service to get method call shipping setting information per Merchant API
 * method.
 *
 * <p>Sample for ShippingSettingsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
 *     ShippingSettingsServiceClient.create()) {
 *   ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");
 *   ShippingSettings response = shippingSettingsServiceClient.getShippingSettings(name);
 * }
 * }</pre>
 *
 * <p>======================= TermsOfServiceServiceClient =======================
 *
 * <p>Service Description: Service to support `TermsOfService` API.
 *
 * <p>Sample for TermsOfServiceServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TermsOfServiceServiceClient termsOfServiceServiceClient =
 *     TermsOfServiceServiceClient.create()) {
 *   TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
 *   TermsOfService response = termsOfServiceServiceClient.getTermsOfService(name);
 * }
 * }</pre>
 *
 * <p>======================= TermsOfServiceAgreementStateServiceClient =======================
 *
 * <p>Service Description: Service to support `TermsOfServiceAgreementState` API.
 *
 * <p>Sample for TermsOfServiceAgreementStateServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TermsOfServiceAgreementStateServiceClient termsOfServiceAgreementStateServiceClient =
 *     TermsOfServiceAgreementStateServiceClient.create()) {
 *   TermsOfServiceAgreementStateName name =
 *       TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");
 *   TermsOfServiceAgreementState response =
 *       termsOfServiceAgreementStateServiceClient.getTermsOfServiceAgreementState(name);
 * }
 * }</pre>
 *
 * <p>======================= UserServiceClient =======================
 *
 * <p>Service Description: Service to support user API.
 *
 * <p>Sample for UserServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
 *   UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");
 *   User response = userServiceClient.getUser(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.merchant.accounts.v1beta;

import javax.annotation.Generated;
