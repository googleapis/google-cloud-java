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
 * <p>======================= AcceleratorTypesClient =======================
 *
 * <p>Service Description: Services
 *
 * <p>The AcceleratorTypes API.
 *
 * <p>Sample for AcceleratorTypesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AcceleratorTypesClient acceleratorTypesClient = AcceleratorTypesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String acceleratorType = "acceleratorType-82462651";
 *   AcceleratorType response = acceleratorTypesClient.get(project, zone, acceleratorType);
 * }
 * }</pre>
 *
 * <p>======================= AddressesClient =======================
 *
 * <p>Service Description: The Addresses API.
 *
 * <p>Sample for AddressesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AddressesClient addressesClient = AddressesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String address = "address-1147692044";
 *   Address response = addressesClient.get(project, region, address);
 * }
 * }</pre>
 *
 * <p>======================= AutoscalersClient =======================
 *
 * <p>Service Description: The Autoscalers API.
 *
 * <p>Sample for AutoscalersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String autoscaler = "autoscaler517258967";
 *   Autoscaler response = autoscalersClient.get(project, zone, autoscaler);
 * }
 * }</pre>
 *
 * <p>======================= BackendBucketsClient =======================
 *
 * <p>Service Description: The BackendBuckets API.
 *
 * <p>Sample for BackendBucketsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
 *   String project = "project-309310695";
 *   String backendBucket = "backendBucket713751966";
 *   BackendBucket response = backendBucketsClient.get(project, backendBucket);
 * }
 * }</pre>
 *
 * <p>======================= BackendServicesClient =======================
 *
 * <p>Service Description: The BackendServices API.
 *
 * <p>Sample for BackendServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
 *   String project = "project-309310695";
 *   String backendService = "backendService-1884714623";
 *   BackendService response = backendServicesClient.get(project, backendService);
 * }
 * }</pre>
 *
 * <p>======================= DiskTypesClient =======================
 *
 * <p>Service Description: The DiskTypes API.
 *
 * <p>Sample for DiskTypesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String diskType = "diskType279771767";
 *   DiskType response = diskTypesClient.get(project, zone, diskType);
 * }
 * }</pre>
 *
 * <p>======================= DisksClient =======================
 *
 * <p>Service Description: The Disks API.
 *
 * <p>Sample for DisksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DisksClient disksClient = DisksClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String disk = "disk3083677";
 *   Disk response = disksClient.get(project, zone, disk);
 * }
 * }</pre>
 *
 * <p>======================= ExternalVpnGatewaysClient =======================
 *
 * <p>Service Description: The ExternalVpnGateways API.
 *
 * <p>Sample for ExternalVpnGatewaysClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
 *   String project = "project-309310695";
 *   String externalVpnGateway = "externalVpnGateway-1140582181";
 *   ExternalVpnGateway response = externalVpnGatewaysClient.get(project, externalVpnGateway);
 * }
 * }</pre>
 *
 * <p>======================= FirewallPoliciesClient =======================
 *
 * <p>Service Description: The FirewallPolicies API.
 *
 * <p>Sample for FirewallPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
 *   String firewallPolicy = "firewallPolicy1819692626";
 *   FirewallPolicy response = firewallPoliciesClient.get(firewallPolicy);
 * }
 * }</pre>
 *
 * <p>======================= FirewallsClient =======================
 *
 * <p>Service Description: The Firewalls API.
 *
 * <p>Sample for FirewallsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
 *   String project = "project-309310695";
 *   String firewall = "firewall-562725632";
 *   Firewall response = firewallsClient.get(project, firewall);
 * }
 * }</pre>
 *
 * <p>======================= ForwardingRulesClient =======================
 *
 * <p>Service Description: The ForwardingRules API.
 *
 * <p>Sample for ForwardingRulesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String forwardingRule = "forwardingRule-1429104743";
 *   ForwardingRule response = forwardingRulesClient.get(project, region, forwardingRule);
 * }
 * }</pre>
 *
 * <p>======================= GlobalAddressesClient =======================
 *
 * <p>Service Description: The GlobalAddresses API.
 *
 * <p>Sample for GlobalAddressesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
 *   String project = "project-309310695";
 *   String address = "address-1147692044";
 *   Address response = globalAddressesClient.get(project, address);
 * }
 * }</pre>
 *
 * <p>======================= GlobalForwardingRulesClient =======================
 *
 * <p>Service Description: The GlobalForwardingRules API.
 *
 * <p>Sample for GlobalForwardingRulesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GlobalForwardingRulesClient globalForwardingRulesClient =
 *     GlobalForwardingRulesClient.create()) {
 *   String project = "project-309310695";
 *   String forwardingRule = "forwardingRule-1429104743";
 *   ForwardingRule response = globalForwardingRulesClient.get(project, forwardingRule);
 * }
 * }</pre>
 *
 * <p>======================= GlobalNetworkEndpointGroupsClient =======================
 *
 * <p>Service Description: The GlobalNetworkEndpointGroups API.
 *
 * <p>Sample for GlobalNetworkEndpointGroupsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient =
 *     GlobalNetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       globalNetworkEndpointGroupsClient.get(project, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>======================= GlobalOperationsClient =======================
 *
 * <p>Service Description: The GlobalOperations API.
 *
 * <p>Sample for GlobalOperationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GlobalOperationsClient globalOperationsClient = GlobalOperationsClient.create()) {
 *   String project = "project-309310695";
 *   String operation = "operation1662702951";
 *   DeleteGlobalOperationResponse response = globalOperationsClient.delete(project, operation);
 * }
 * }</pre>
 *
 * <p>======================= GlobalOrganizationOperationsClient =======================
 *
 * <p>Service Description: The GlobalOrganizationOperations API.
 *
 * <p>Sample for GlobalOrganizationOperationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient =
 *     GlobalOrganizationOperationsClient.create()) {
 *   String operation = "operation1662702951";
 *   DeleteGlobalOrganizationOperationResponse response =
 *       globalOrganizationOperationsClient.delete(operation);
 * }
 * }</pre>
 *
 * <p>======================= GlobalPublicDelegatedPrefixesClient =======================
 *
 * <p>Service Description: The GlobalPublicDelegatedPrefixes API.
 *
 * <p>Sample for GlobalPublicDelegatedPrefixesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
 *     GlobalPublicDelegatedPrefixesClient.create()) {
 *   String project = "project-309310695";
 *   String publicDelegatedPrefix = "publicDelegatedPrefix-663003832";
 *   PublicDelegatedPrefix response =
 *       globalPublicDelegatedPrefixesClient.get(project, publicDelegatedPrefix);
 * }
 * }</pre>
 *
 * <p>======================= HealthChecksClient =======================
 *
 * <p>Service Description: The HealthChecks API.
 *
 * <p>Sample for HealthChecksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
 *   String project = "project-309310695";
 *   String healthCheck = "healthCheck-1938093044";
 *   HealthCheck response = healthChecksClient.get(project, healthCheck);
 * }
 * }</pre>
 *
 * <p>======================= ImageFamilyViewsClient =======================
 *
 * <p>Service Description: The ImageFamilyViews API.
 *
 * <p>Sample for ImageFamilyViewsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ImageFamilyViewsClient imageFamilyViewsClient = ImageFamilyViewsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String family = "family-1281860764";
 *   ImageFamilyView response = imageFamilyViewsClient.get(project, zone, family);
 * }
 * }</pre>
 *
 * <p>======================= ImagesClient =======================
 *
 * <p>Service Description: The Images API.
 *
 * <p>Sample for ImagesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ImagesClient imagesClient = ImagesClient.create()) {
 *   String project = "project-309310695";
 *   String image = "image100313435";
 *   Image response = imagesClient.get(project, image);
 * }
 * }</pre>
 *
 * <p>======================= InstanceGroupManagersClient =======================
 *
 * <p>Service Description: The InstanceGroupManagers API.
 *
 * <p>Sample for InstanceGroupManagersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstanceGroupManagersClient instanceGroupManagersClient =
 *     InstanceGroupManagersClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String instanceGroupManager = "instanceGroupManager-388242077";
 *   InstanceGroupManager response =
 *       instanceGroupManagersClient.get(project, zone, instanceGroupManager);
 * }
 * }</pre>
 *
 * <p>======================= InstanceGroupsClient =======================
 *
 * <p>Service Description: The InstanceGroups API.
 *
 * <p>Sample for InstanceGroupsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String instanceGroup = "instanceGroup-1404696854";
 *   InstanceGroup response = instanceGroupsClient.get(project, zone, instanceGroup);
 * }
 * }</pre>
 *
 * <p>======================= InstanceTemplatesClient =======================
 *
 * <p>Service Description: The InstanceTemplates API.
 *
 * <p>Sample for InstanceTemplatesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
 *   String project = "project-309310695";
 *   String instanceTemplate = "instanceTemplate1009541167";
 *   InstanceTemplate response = instanceTemplatesClient.get(project, instanceTemplate);
 * }
 * }</pre>
 *
 * <p>======================= InstancesClient =======================
 *
 * <p>Service Description: The Instances API.
 *
 * <p>Sample for InstancesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstancesClient instancesClient = InstancesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String instance = "instance555127957";
 *   Instance response = instancesClient.get(project, zone, instance);
 * }
 * }</pre>
 *
 * <p>======================= InterconnectAttachmentsClient =======================
 *
 * <p>Service Description: The InterconnectAttachments API.
 *
 * <p>Sample for InterconnectAttachmentsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
 *     InterconnectAttachmentsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String interconnectAttachment = "interconnectAttachment1869250641";
 *   InterconnectAttachment response =
 *       interconnectAttachmentsClient.get(project, region, interconnectAttachment);
 * }
 * }</pre>
 *
 * <p>======================= InterconnectLocationsClient =======================
 *
 * <p>Service Description: The InterconnectLocations API.
 *
 * <p>Sample for InterconnectLocationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InterconnectLocationsClient interconnectLocationsClient =
 *     InterconnectLocationsClient.create()) {
 *   String project = "project-309310695";
 *   String interconnectLocation = "interconnectLocation220117603";
 *   InterconnectLocation response =
 *       interconnectLocationsClient.get(project, interconnectLocation);
 * }
 * }</pre>
 *
 * <p>======================= InterconnectsClient =======================
 *
 * <p>Service Description: The Interconnects API.
 *
 * <p>Sample for InterconnectsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
 *   String project = "project-309310695";
 *   String interconnect = "interconnect-849140594";
 *   Interconnect response = interconnectsClient.get(project, interconnect);
 * }
 * }</pre>
 *
 * <p>======================= LicenseCodesClient =======================
 *
 * <p>Service Description: The LicenseCodes API.
 *
 * <p>Sample for LicenseCodesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
 *   String project = "project-309310695";
 *   String licenseCode = "licenseCode-641557042";
 *   LicenseCode response = licenseCodesClient.get(project, licenseCode);
 * }
 * }</pre>
 *
 * <p>======================= LicensesClient =======================
 *
 * <p>Service Description: The Licenses API.
 *
 * <p>Sample for LicensesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LicensesClient licensesClient = LicensesClient.create()) {
 *   String project = "project-309310695";
 *   String license = "license166757441";
 *   License response = licensesClient.get(project, license);
 * }
 * }</pre>
 *
 * <p>======================= MachineImagesClient =======================
 *
 * <p>Service Description: The MachineImages API.
 *
 * <p>Sample for MachineImagesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MachineImagesClient machineImagesClient = MachineImagesClient.create()) {
 *   String project = "project-309310695";
 *   String machineImage = "machineImage1817774420";
 *   MachineImage response = machineImagesClient.get(project, machineImage);
 * }
 * }</pre>
 *
 * <p>======================= MachineTypesClient =======================
 *
 * <p>Service Description: The MachineTypes API.
 *
 * <p>Sample for MachineTypesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String machineType = "machineType-218117087";
 *   MachineType response = machineTypesClient.get(project, zone, machineType);
 * }
 * }</pre>
 *
 * <p>======================= NetworkEdgeSecurityServicesClient =======================
 *
 * <p>Service Description: The NetworkEdgeSecurityServices API.
 *
 * <p>Sample for NetworkEdgeSecurityServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworkEdgeSecurityServicesClient networkEdgeSecurityServicesClient =
 *     NetworkEdgeSecurityServicesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String networkEdgeSecurityService = "networkEdgeSecurityService-1390253366";
 *   NetworkEdgeSecurityService response =
 *       networkEdgeSecurityServicesClient.get(project, region, networkEdgeSecurityService);
 * }
 * }</pre>
 *
 * <p>======================= NetworkEndpointGroupsClient =======================
 *
 * <p>Service Description: The NetworkEndpointGroups API.
 *
 * <p>Sample for NetworkEndpointGroupsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworkEndpointGroupsClient networkEndpointGroupsClient =
 *     NetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       networkEndpointGroupsClient.get(project, zone, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>======================= NetworkFirewallPoliciesClient =======================
 *
 * <p>Service Description: The NetworkFirewallPolicies API.
 *
 * <p>Sample for NetworkFirewallPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
 *     NetworkFirewallPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String firewallPolicy = "firewallPolicy1819692626";
 *   FirewallPolicy response = networkFirewallPoliciesClient.get(project, firewallPolicy);
 * }
 * }</pre>
 *
 * <p>======================= NetworksClient =======================
 *
 * <p>Service Description: The Networks API.
 *
 * <p>Sample for NetworksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworksClient networksClient = NetworksClient.create()) {
 *   String project = "project-309310695";
 *   String network = "network1843485230";
 *   Network response = networksClient.get(project, network);
 * }
 * }</pre>
 *
 * <p>======================= NodeGroupsClient =======================
 *
 * <p>Service Description: The NodeGroups API.
 *
 * <p>Sample for NodeGroupsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String nodeGroup = "nodeGroup443599261";
 *   NodeGroup response = nodeGroupsClient.get(project, zone, nodeGroup);
 * }
 * }</pre>
 *
 * <p>======================= NodeTemplatesClient =======================
 *
 * <p>Service Description: The NodeTemplates API.
 *
 * <p>Sample for NodeTemplatesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String nodeTemplate = "nodeTemplate2118368412";
 *   NodeTemplate response = nodeTemplatesClient.get(project, region, nodeTemplate);
 * }
 * }</pre>
 *
 * <p>======================= NodeTypesClient =======================
 *
 * <p>Service Description: The NodeTypes API.
 *
 * <p>Sample for NodeTypesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NodeTypesClient nodeTypesClient = NodeTypesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String nodeType = "nodeType1123082332";
 *   NodeType response = nodeTypesClient.get(project, zone, nodeType);
 * }
 * }</pre>
 *
 * <p>======================= PacketMirroringsClient =======================
 *
 * <p>Service Description: The PacketMirrorings API.
 *
 * <p>Sample for PacketMirroringsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String packetMirroring = "packetMirroring1405520923";
 *   PacketMirroring response = packetMirroringsClient.get(project, region, packetMirroring);
 * }
 * }</pre>
 *
 * <p>======================= ProjectsClient =======================
 *
 * <p>Service Description: The Projects API.
 *
 * <p>Sample for ProjectsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProjectsClient projectsClient = ProjectsClient.create()) {
 *   String project = "project-309310695";
 *   Project response = projectsClient.get(project);
 * }
 * }</pre>
 *
 * <p>======================= PublicAdvertisedPrefixesClient =======================
 *
 * <p>Service Description: The PublicAdvertisedPrefixes API.
 *
 * <p>Sample for PublicAdvertisedPrefixesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
 *     PublicAdvertisedPrefixesClient.create()) {
 *   String project = "project-309310695";
 *   String publicAdvertisedPrefix = "publicAdvertisedPrefix1506440856";
 *   PublicAdvertisedPrefix response =
 *       publicAdvertisedPrefixesClient.get(project, publicAdvertisedPrefix);
 * }
 * }</pre>
 *
 * <p>======================= PublicDelegatedPrefixesClient =======================
 *
 * <p>Service Description: The PublicDelegatedPrefixes API.
 *
 * <p>Sample for PublicDelegatedPrefixesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PublicDelegatedPrefixesClient publicDelegatedPrefixesClient =
 *     PublicDelegatedPrefixesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String publicDelegatedPrefix = "publicDelegatedPrefix-663003832";
 *   PublicDelegatedPrefix response =
 *       publicDelegatedPrefixesClient.get(project, region, publicDelegatedPrefix);
 * }
 * }</pre>
 *
 * <p>======================= RegionAutoscalersClient =======================
 *
 * <p>Service Description: The RegionAutoscalers API.
 *
 * <p>Sample for RegionAutoscalersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String autoscaler = "autoscaler517258967";
 *   Autoscaler response = regionAutoscalersClient.get(project, region, autoscaler);
 * }
 * }</pre>
 *
 * <p>======================= RegionBackendServicesClient =======================
 *
 * <p>Service Description: The RegionBackendServices API.
 *
 * <p>Sample for RegionBackendServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionBackendServicesClient regionBackendServicesClient =
 *     RegionBackendServicesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String backendService = "backendService-1884714623";
 *   BackendService response = regionBackendServicesClient.get(project, region, backendService);
 * }
 * }</pre>
 *
 * <p>======================= RegionCommitmentsClient =======================
 *
 * <p>Service Description: The RegionCommitments API.
 *
 * <p>Sample for RegionCommitmentsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String commitment = "commitment1019005717";
 *   Commitment response = regionCommitmentsClient.get(project, region, commitment);
 * }
 * }</pre>
 *
 * <p>======================= RegionDiskTypesClient =======================
 *
 * <p>Service Description: The RegionDiskTypes API.
 *
 * <p>Sample for RegionDiskTypesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionDiskTypesClient regionDiskTypesClient = RegionDiskTypesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String diskType = "diskType279771767";
 *   DiskType response = regionDiskTypesClient.get(project, region, diskType);
 * }
 * }</pre>
 *
 * <p>======================= RegionDisksClient =======================
 *
 * <p>Service Description: The RegionDisks API.
 *
 * <p>Sample for RegionDisksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String disk = "disk3083677";
 *   Disk response = regionDisksClient.get(project, region, disk);
 * }
 * }</pre>
 *
 * <p>======================= RegionHealthCheckServicesClient =======================
 *
 * <p>Service Description: The RegionHealthCheckServices API.
 *
 * <p>Sample for RegionHealthCheckServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient =
 *     RegionHealthCheckServicesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String healthCheckService = "healthCheckService-917902071";
 *   HealthCheckService response =
 *       regionHealthCheckServicesClient.get(project, region, healthCheckService);
 * }
 * }</pre>
 *
 * <p>======================= RegionHealthChecksClient =======================
 *
 * <p>Service Description: The RegionHealthChecks API.
 *
 * <p>Sample for RegionHealthChecksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String healthCheck = "healthCheck-1938093044";
 *   HealthCheck response = regionHealthChecksClient.get(project, region, healthCheck);
 * }
 * }</pre>
 *
 * <p>======================= RegionInstanceGroupManagersClient =======================
 *
 * <p>Service Description: The RegionInstanceGroupManagers API.
 *
 * <p>Sample for RegionInstanceGroupManagersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient =
 *     RegionInstanceGroupManagersClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String instanceGroupManager = "instanceGroupManager-388242077";
 *   InstanceGroupManager response =
 *       regionInstanceGroupManagersClient.get(project, region, instanceGroupManager);
 * }
 * }</pre>
 *
 * <p>======================= RegionInstanceGroupsClient =======================
 *
 * <p>Service Description: The RegionInstanceGroups API.
 *
 * <p>Sample for RegionInstanceGroupsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
 *     RegionInstanceGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String instanceGroup = "instanceGroup-1404696854";
 *   InstanceGroup response = regionInstanceGroupsClient.get(project, region, instanceGroup);
 * }
 * }</pre>
 *
 * <p>======================= RegionInstancesClient =======================
 *
 * <p>Service Description: The RegionInstances API.
 *
 * <p>Sample for RegionInstancesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionInstancesClient regionInstancesClient = RegionInstancesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   BulkInsertInstanceResource bulkInsertInstanceResourceResource =
 *       BulkInsertInstanceResource.newBuilder().build();
 *   Operation response =
 *       regionInstancesClient
 *           .bulkInsertAsync(project, region, bulkInsertInstanceResourceResource)
 *           .get();
 * }
 * }</pre>
 *
 * <p>======================= RegionNetworkEndpointGroupsClient =======================
 *
 * <p>Service Description: The RegionNetworkEndpointGroups API.
 *
 * <p>Sample for RegionNetworkEndpointGroupsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       regionNetworkEndpointGroupsClient.get(project, region, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>======================= RegionNetworkFirewallPoliciesClient =======================
 *
 * <p>Service Description: The RegionNetworkFirewallPolicies API.
 *
 * <p>Sample for RegionNetworkFirewallPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
 *     RegionNetworkFirewallPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String firewallPolicy = "firewallPolicy1819692626";
 *   FirewallPolicy response =
 *       regionNetworkFirewallPoliciesClient.get(project, region, firewallPolicy);
 * }
 * }</pre>
 *
 * <p>======================= RegionNotificationEndpointsClient =======================
 *
 * <p>Service Description: The RegionNotificationEndpoints API.
 *
 * <p>Sample for RegionNotificationEndpointsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient =
 *     RegionNotificationEndpointsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String notificationEndpoint = "notificationEndpoint-354029664";
 *   NotificationEndpoint response =
 *       regionNotificationEndpointsClient.get(project, region, notificationEndpoint);
 * }
 * }</pre>
 *
 * <p>======================= RegionOperationsClient =======================
 *
 * <p>Service Description: The RegionOperations API.
 *
 * <p>Sample for RegionOperationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String operation = "operation1662702951";
 *   DeleteRegionOperationResponse response =
 *       regionOperationsClient.delete(project, region, operation);
 * }
 * }</pre>
 *
 * <p>======================= RegionSecurityPoliciesClient =======================
 *
 * <p>Service Description: The RegionSecurityPolicies API.
 *
 * <p>Sample for RegionSecurityPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
 *     RegionSecurityPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String securityPolicy = "securityPolicy-788621166";
 *   SecurityPolicy response = regionSecurityPoliciesClient.get(project, region, securityPolicy);
 * }
 * }</pre>
 *
 * <p>======================= RegionSslCertificatesClient =======================
 *
 * <p>Service Description: The RegionSslCertificates API.
 *
 * <p>Sample for RegionSslCertificatesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionSslCertificatesClient regionSslCertificatesClient =
 *     RegionSslCertificatesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String sslCertificate = "sslCertificate-1304941589";
 *   SslCertificate response = regionSslCertificatesClient.get(project, region, sslCertificate);
 * }
 * }</pre>
 *
 * <p>======================= RegionSslPoliciesClient =======================
 *
 * <p>Service Description: The RegionSslPolicies API.
 *
 * <p>Sample for RegionSslPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionSslPoliciesClient regionSslPoliciesClient = RegionSslPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String sslPolicy = "sslPolicy618174046";
 *   SslPolicy response = regionSslPoliciesClient.get(project, region, sslPolicy);
 * }
 * }</pre>
 *
 * <p>======================= RegionTargetHttpProxiesClient =======================
 *
 * <p>Service Description: The RegionTargetHttpProxies API.
 *
 * <p>Sample for RegionTargetHttpProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionTargetHttpProxiesClient regionTargetHttpProxiesClient =
 *     RegionTargetHttpProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetHttpProxy = "targetHttpProxy-1944074187";
 *   TargetHttpProxy response =
 *       regionTargetHttpProxiesClient.get(project, region, targetHttpProxy);
 * }
 * }</pre>
 *
 * <p>======================= RegionTargetHttpsProxiesClient =======================
 *
 * <p>Service Description: The RegionTargetHttpsProxies API.
 *
 * <p>Sample for RegionTargetHttpsProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
 *     RegionTargetHttpsProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetHttpsProxy = "targetHttpsProxy833943732";
 *   TargetHttpsProxy response =
 *       regionTargetHttpsProxiesClient.get(project, region, targetHttpsProxy);
 * }
 * }</pre>
 *
 * <p>======================= RegionTargetTcpProxiesClient =======================
 *
 * <p>Service Description: The RegionTargetTcpProxies API.
 *
 * <p>Sample for RegionTargetTcpProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionTargetTcpProxiesClient regionTargetTcpProxiesClient =
 *     RegionTargetTcpProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetTcpProxy = "targetTcpProxy-337144898";
 *   TargetTcpProxy response = regionTargetTcpProxiesClient.get(project, region, targetTcpProxy);
 * }
 * }</pre>
 *
 * <p>======================= RegionUrlMapsClient =======================
 *
 * <p>Service Description: The RegionUrlMaps API.
 *
 * <p>Sample for RegionUrlMapsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String urlMap = "urlMap-836780691";
 *   UrlMap response = regionUrlMapsClient.get(project, region, urlMap);
 * }
 * }</pre>
 *
 * <p>======================= RegionsClient =======================
 *
 * <p>Service Description: The Regions API.
 *
 * <p>Sample for RegionsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RegionsClient regionsClient = RegionsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   Region response = regionsClient.get(project, region);
 * }
 * }</pre>
 *
 * <p>======================= ReservationsClient =======================
 *
 * <p>Service Description: The Reservations API.
 *
 * <p>Sample for ReservationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String reservation = "reservation-1563081780";
 *   Reservation response = reservationsClient.get(project, zone, reservation);
 * }
 * }</pre>
 *
 * <p>======================= ResourcePoliciesClient =======================
 *
 * <p>Service Description: The ResourcePolicies API.
 *
 * <p>Sample for ResourcePoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String resourcePolicy = "resourcePolicy-130903328";
 *   ResourcePolicy response = resourcePoliciesClient.get(project, region, resourcePolicy);
 * }
 * }</pre>
 *
 * <p>======================= RoutersClient =======================
 *
 * <p>Service Description: The Routers API.
 *
 * <p>Sample for RoutersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RoutersClient routersClient = RoutersClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String router = "router-925132983";
 *   Router response = routersClient.get(project, region, router);
 * }
 * }</pre>
 *
 * <p>======================= RoutesClient =======================
 *
 * <p>Service Description: The Routes API.
 *
 * <p>Sample for RoutesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RoutesClient routesClient = RoutesClient.create()) {
 *   String project = "project-309310695";
 *   String route = "route108704329";
 *   Route response = routesClient.get(project, route);
 * }
 * }</pre>
 *
 * <p>======================= SecurityPoliciesClient =======================
 *
 * <p>Service Description: The SecurityPolicies API.
 *
 * <p>Sample for SecurityPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String securityPolicy = "securityPolicy-788621166";
 *   SecurityPolicy response = securityPoliciesClient.get(project, securityPolicy);
 * }
 * }</pre>
 *
 * <p>======================= ServiceAttachmentsClient =======================
 *
 * <p>Service Description: The ServiceAttachments API.
 *
 * <p>Sample for ServiceAttachmentsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ServiceAttachmentsClient serviceAttachmentsClient = ServiceAttachmentsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String serviceAttachment = "serviceAttachment-398467656";
 *   ServiceAttachment response = serviceAttachmentsClient.get(project, region, serviceAttachment);
 * }
 * }</pre>
 *
 * <p>======================= SnapshotsClient =======================
 *
 * <p>Service Description: The Snapshots API.
 *
 * <p>Sample for SnapshotsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
 *   String project = "project-309310695";
 *   String snapshot = "snapshot284874180";
 *   Snapshot response = snapshotsClient.get(project, snapshot);
 * }
 * }</pre>
 *
 * <p>======================= SslCertificatesClient =======================
 *
 * <p>Service Description: The SslCertificates API.
 *
 * <p>Sample for SslCertificatesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
 *   String project = "project-309310695";
 *   String sslCertificate = "sslCertificate-1304941589";
 *   SslCertificate response = sslCertificatesClient.get(project, sslCertificate);
 * }
 * }</pre>
 *
 * <p>======================= SslPoliciesClient =======================
 *
 * <p>Service Description: The SslPolicies API.
 *
 * <p>Sample for SslPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String sslPolicy = "sslPolicy618174046";
 *   SslPolicy response = sslPoliciesClient.get(project, sslPolicy);
 * }
 * }</pre>
 *
 * <p>======================= SubnetworksClient =======================
 *
 * <p>Service Description: The Subnetworks API.
 *
 * <p>Sample for SubnetworksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String subnetwork = "subnetwork-1302785042";
 *   Subnetwork response = subnetworksClient.get(project, region, subnetwork);
 * }
 * }</pre>
 *
 * <p>======================= TargetGrpcProxiesClient =======================
 *
 * <p>Service Description: The TargetGrpcProxies API.
 *
 * <p>Sample for TargetGrpcProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetGrpcProxy = "targetGrpcProxy1045500511";
 *   TargetGrpcProxy response = targetGrpcProxiesClient.get(project, targetGrpcProxy);
 * }
 * }</pre>
 *
 * <p>======================= TargetHttpProxiesClient =======================
 *
 * <p>Service Description: The TargetHttpProxies API.
 *
 * <p>Sample for TargetHttpProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetHttpProxy = "targetHttpProxy-1944074187";
 *   TargetHttpProxy response = targetHttpProxiesClient.get(project, targetHttpProxy);
 * }
 * }</pre>
 *
 * <p>======================= TargetHttpsProxiesClient =======================
 *
 * <p>Service Description: The TargetHttpsProxies API.
 *
 * <p>Sample for TargetHttpsProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetHttpsProxy = "targetHttpsProxy833943732";
 *   TargetHttpsProxy response = targetHttpsProxiesClient.get(project, targetHttpsProxy);
 * }
 * }</pre>
 *
 * <p>======================= TargetInstancesClient =======================
 *
 * <p>Service Description: The TargetInstances API.
 *
 * <p>Sample for TargetInstancesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String targetInstance = "targetInstance-1036957370";
 *   TargetInstance response = targetInstancesClient.get(project, zone, targetInstance);
 * }
 * }</pre>
 *
 * <p>======================= TargetPoolsClient =======================
 *
 * <p>Service Description: The TargetPools API.
 *
 * <p>Sample for TargetPoolsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetPool = "targetPool486493517";
 *   TargetPool response = targetPoolsClient.get(project, region, targetPool);
 * }
 * }</pre>
 *
 * <p>======================= TargetSslProxiesClient =======================
 *
 * <p>Service Description: The TargetSslProxies API.
 *
 * <p>Sample for TargetSslProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetSslProxy = "targetSslProxy-879314829";
 *   TargetSslProxy response = targetSslProxiesClient.get(project, targetSslProxy);
 * }
 * }</pre>
 *
 * <p>======================= TargetTcpProxiesClient =======================
 *
 * <p>Service Description: The TargetTcpProxies API.
 *
 * <p>Sample for TargetTcpProxiesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetTcpProxiesClient targetTcpProxiesClient = TargetTcpProxiesClient.create()) {
 *   String project = "project-309310695";
 *   String targetTcpProxy = "targetTcpProxy-337144898";
 *   TargetTcpProxy response = targetTcpProxiesClient.get(project, targetTcpProxy);
 * }
 * }</pre>
 *
 * <p>======================= TargetVpnGatewaysClient =======================
 *
 * <p>Service Description: The TargetVpnGateways API.
 *
 * <p>Sample for TargetVpnGatewaysClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetVpnGateway = "targetVpnGateway935274273";
 *   TargetVpnGateway response = targetVpnGatewaysClient.get(project, region, targetVpnGateway);
 * }
 * }</pre>
 *
 * <p>======================= UrlMapsClient =======================
 *
 * <p>Service Description: The UrlMaps API.
 *
 * <p>Sample for UrlMapsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
 *   String project = "project-309310695";
 *   String urlMap = "urlMap-836780691";
 *   UrlMap response = urlMapsClient.get(project, urlMap);
 * }
 * }</pre>
 *
 * <p>======================= VpnGatewaysClient =======================
 *
 * <p>Service Description: The VpnGateways API.
 *
 * <p>Sample for VpnGatewaysClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String vpnGateway = "vpnGateway1920916144";
 *   VpnGateway response = vpnGatewaysClient.get(project, region, vpnGateway);
 * }
 * }</pre>
 *
 * <p>======================= VpnTunnelsClient =======================
 *
 * <p>Service Description: The VpnTunnels API.
 *
 * <p>Sample for VpnTunnelsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String vpnTunnel = "vpnTunnel452443772";
 *   VpnTunnel response = vpnTunnelsClient.get(project, region, vpnTunnel);
 * }
 * }</pre>
 *
 * <p>======================= ZoneOperationsClient =======================
 *
 * <p>Service Description: The ZoneOperations API.
 *
 * <p>Sample for ZoneOperationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ZoneOperationsClient zoneOperationsClient = ZoneOperationsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String operation = "operation1662702951";
 *   DeleteZoneOperationResponse response = zoneOperationsClient.delete(project, zone, operation);
 * }
 * }</pre>
 *
 * <p>======================= ZonesClient =======================
 *
 * <p>Service Description: The Zones API.
 *
 * <p>Sample for ZonesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ZonesClient zonesClient = ZonesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   Zone response = zonesClient.get(project, zone);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.compute.v1;

import javax.annotation.Generated;
