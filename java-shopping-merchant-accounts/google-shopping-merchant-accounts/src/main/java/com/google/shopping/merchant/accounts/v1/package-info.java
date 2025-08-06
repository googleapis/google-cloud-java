/*
 * Copyright 2025 Google LLC
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
 * <p>======================= AccountRelationshipsServiceClient =======================
 *
 * <p>Service Description: Service to support AccountRelationship API.
 *
 * <p>Sample for AccountRelationshipsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
 *     AccountRelationshipsServiceClient.create()) {
 *   AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");
 *   AccountRelationship response = accountRelationshipsServiceClient.getAccountRelationship(name);
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
 * <p>======================= AccountServicesServiceClient =======================
 *
 * <p>Service Description: Service to support AccountService API.
 *
 * <p>Sample for AccountServicesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountServicesServiceClient accountServicesServiceClient =
 *     AccountServicesServiceClient.create()) {
 *   AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
 *   AccountService response = accountServicesServiceClient.getAccountService(name);
 * }
 * }</pre>
 *
 * <p>======================= AutofeedSettingsServiceClient =======================
 *
 * <p>Service Description: Service to support
 * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
 *
 * <p>Sample for AutofeedSettingsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
 *     AutofeedSettingsServiceClient.create()) {
 *   AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");
 *   AutofeedSettings response = autofeedSettingsServiceClient.getAutofeedSettings(name);
 * }
 * }</pre>
 *
 * <p>======================= AutomaticImprovementsServiceClient =======================
 *
 * <p>Service Description: Service to manage the automatic improvements of an account. The automatic
 * improvements of the account can be used to automatically update products, improve images and
 * shipping.
 *
 * <p>Sample for AutomaticImprovementsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
 *     AutomaticImprovementsServiceClient.create()) {
 *   AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");
 *   AutomaticImprovements response =
 *       automaticImprovementsServiceClient.getAutomaticImprovements(name);
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
 * <p>======================= CheckoutSettingsServiceClient =======================
 *
 * <p>Service Description: Service for supporting [checkout
 * settings](https://support.google.com/merchants/answer/13945960).
 *
 * <p>Sample for CheckoutSettingsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
 *     CheckoutSettingsServiceClient.create()) {
 *   CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
 *   CheckoutSettings response = checkoutSettingsServiceClient.getCheckoutSettings(name);
 * }
 * }</pre>
 *
 * <p>======================= DeveloperRegistrationServiceClient =======================
 *
 * <p>Service Description: Service to access Developer Registration.
 *
 * <p>Sample for DeveloperRegistrationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeveloperRegistrationServiceClient developerRegistrationServiceClient =
 *     DeveloperRegistrationServiceClient.create()) {
 *   RegisterGcpRequest request =
 *       RegisterGcpRequest.newBuilder()
 *           .setName(DeveloperRegistrationName.of("[ACCOUNT]").toString())
 *           .setDeveloperEmail("developerEmail251249138")
 *           .build();
 *   DeveloperRegistration response = developerRegistrationServiceClient.registerGcp(request);
 * }
 * }</pre>
 *
 * <p>======================= EmailPreferencesServiceClient =======================
 *
 * <p>Service Description: Service to support the `EmailPreferences` API.
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
 * <p>======================= GbpAccountsServiceClient =======================
 *
 * <p>Service Description: The service facilitates the management of a merchant's Google Business
 * Profile (GBP) account settings. This API defines the following resource model: -
 * [GbpAccount][google.shopping.merchant.accounts.v1.GbpAccount]
 *
 * <p>Sample for GbpAccountsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GbpAccountsServiceClient gbpAccountsServiceClient = GbpAccountsServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   LinkGbpAccountResponse response = gbpAccountsServiceClient.linkGbpAccount(parent);
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
 * <p>======================= LfpProvidersServiceClient =======================
 *
 * <p>Service Description: The service facilitates the management of a merchant's LFP provider
 * settings. This API defines the following resource model: -
 * [LfpProvider][google.shopping.merchant.accounts.v1.LfpProvider]
 *
 * <p>Sample for LfpProvidersServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
 *   LfpProviderName name =
 *       LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");
 *   LinkLfpProviderResponse response = lfpProvidersServiceClient.linkLfpProvider(name);
 * }
 * }</pre>
 *
 * <p>======================= OmnichannelSettingsServiceClient =======================
 *
 * <p>Service Description: The service facilitates the management of a merchant's omnichannel
 * settings. ## This API defines the following resource model:
 *
 * <p>[OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
 *
 * <p>Sample for OmnichannelSettingsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
 *     OmnichannelSettingsServiceClient.create()) {
 *   OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
 *   OmnichannelSetting response = omnichannelSettingsServiceClient.getOmnichannelSetting(name);
 * }
 * }</pre>
 *
 * <p>======================= OnlineReturnPolicyServiceClient =======================
 *
 * <p>Service Description: The service facilitates the management of a business's remorse return
 * policy configuration, encompassing return policies for both ads and free listings ## programs.
 * This API defines the following resource model:
 *
 * <p>[OnlineReturnPolicy](/merchant/api/reference/rpc/google.shopping.merchant.accounts.v1#google.shopping.merchant.accounts.v1.OnlineReturnPolicy)
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
 * of this is the [Free product listings](https://support.google.com/merchants/answer/13889434)
 * program, which enables products from a merchant's store to be shown across Google for free.
 *
 * <p>This service exposes methods to retrieve a business's participation in all available programs,
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
 * <p>- [Region][google.shopping.merchant.accounts.v1.Region]
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
package com.google.shopping.merchant.accounts.v1;

import javax.annotation.Generated;
