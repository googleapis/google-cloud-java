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
 * A client to Google Compute Engine API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>====================== AcceleratorTypesClient ======================
 *
 * <p>Service Description: Services
 *
 * <p>The AcceleratorTypes API.
 *
 * <p>Sample for AcceleratorTypesClient:
 *
 * <pre>
 * <code>
 * try (AcceleratorTypesClient acceleratorTypesClient = AcceleratorTypesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String acceleratorType = "";
 *   AcceleratorType response = acceleratorTypesClient.get(project, zone, acceleratorType);
 * }
 * </code>
 * </pre>
 *
 * =============== AddressesClient ===============
 *
 * <p>Service Description: The Addresses API.
 *
 * <p>Sample for AddressesClient:
 *
 * <pre>
 * <code>
 * try (AddressesClient addressesClient = AddressesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String address = "";
 *   Operation response = addressesClient.delete(project, region, address);
 * }
 * </code>
 * </pre>
 *
 * ================= AutoscalersClient =================
 *
 * <p>Service Description: The Autoscalers API.
 *
 * <p>Sample for AutoscalersClient:
 *
 * <pre>
 * <code>
 * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String autoscaler = "";
 *   Operation response = autoscalersClient.delete(project, zone, autoscaler);
 * }
 * </code>
 * </pre>
 *
 * ==================== BackendBucketsClient ====================
 *
 * <p>Service Description: The BackendBuckets API.
 *
 * <p>Sample for BackendBucketsClient:
 *
 * <pre>
 * <code>
 * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
 *   String project = "";
 *   String backendBucket = "";
 *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
 *   Operation response = backendBucketsClient.addSignedUrlKey(project, backendBucket, signedUrlKeyResource);
 * }
 * </code>
 * </pre>
 *
 * ===================== BackendServicesClient =====================
 *
 * <p>Service Description: The BackendServices API.
 *
 * <p>Sample for BackendServicesClient:
 *
 * <pre>
 * <code>
 * try (BackendServicesClient backendServicesClient = BackendServicesClient.create()) {
 *   String project = "";
 *   String backendService = "";
 *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
 *   Operation response = backendServicesClient.addSignedUrlKey(project, backendService, signedUrlKeyResource);
 * }
 * </code>
 * </pre>
 *
 * =============== DiskTypesClient ===============
 *
 * <p>Service Description: The DiskTypes API.
 *
 * <p>Sample for DiskTypesClient:
 *
 * <pre>
 * <code>
 * try (DiskTypesClient diskTypesClient = DiskTypesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String diskType = "";
 *   DiskType response = diskTypesClient.get(project, zone, diskType);
 * }
 * </code>
 * </pre>
 *
 * =========== DisksClient ===========
 *
 * <p>Service Description: The Disks API.
 *
 * <p>Sample for DisksClient:
 *
 * <pre>
 * <code>
 * try (DisksClient disksClient = DisksClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String disk = "";
 *   DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource = DisksAddResourcePoliciesRequest.newBuilder().build();
 *   Operation response = disksClient.addResourcePolicies(project, zone, disk, disksAddResourcePoliciesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ========================= ExternalVpnGatewaysClient =========================
 *
 * <p>Service Description: The ExternalVpnGateways API.
 *
 * <p>Sample for ExternalVpnGatewaysClient:
 *
 * <pre>
 * <code>
 * try (ExternalVpnGatewaysClient externalVpnGatewaysClient = ExternalVpnGatewaysClient.create()) {
 *   String project = "";
 *   String externalVpnGateway = "";
 *   Operation response = externalVpnGatewaysClient.delete(project, externalVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * =============== FirewallsClient ===============
 *
 * <p>Service Description: The Firewalls API.
 *
 * <p>Sample for FirewallsClient:
 *
 * <pre>
 * <code>
 * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
 *   String project = "";
 *   String firewall = "";
 *   Operation response = firewallsClient.delete(project, firewall);
 * }
 * </code>
 * </pre>
 *
 * ===================== ForwardingRulesClient =====================
 *
 * <p>Service Description: The ForwardingRules API.
 *
 * <p>Sample for ForwardingRulesClient:
 *
 * <pre>
 * <code>
 * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String forwardingRule = "";
 *   Operation response = forwardingRulesClient.delete(project, region, forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * ===================== GlobalAddressesClient =====================
 *
 * <p>Service Description: The GlobalAddresses API.
 *
 * <p>Sample for GlobalAddressesClient:
 *
 * <pre>
 * <code>
 * try (GlobalAddressesClient globalAddressesClient = GlobalAddressesClient.create()) {
 *   String project = "";
 *   String address = "";
 *   Operation response = globalAddressesClient.delete(project, address);
 * }
 * </code>
 * </pre>
 *
 * =========================== GlobalForwardingRulesClient ===========================
 *
 * <p>Service Description: The GlobalForwardingRules API.
 *
 * <p>Sample for GlobalForwardingRulesClient:
 *
 * <pre>
 * <code>
 * try (GlobalForwardingRulesClient globalForwardingRulesClient = GlobalForwardingRulesClient.create()) {
 *   String project = "";
 *   String forwardingRule = "";
 *   Operation response = globalForwardingRulesClient.delete(project, forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * ================================= GlobalNetworkEndpointGroupsClient
 * =================================
 *
 * <p>Service Description: The GlobalNetworkEndpointGroups API.
 *
 * <p>Sample for GlobalNetworkEndpointGroupsClient:
 *
 * <pre>
 * <code>
 * try (GlobalNetworkEndpointGroupsClient globalNetworkEndpointGroupsClient = GlobalNetworkEndpointGroupsClient.create()) {
 *   String project = "";
 *   String networkEndpointGroup = "";
 *   GlobalNetworkEndpointGroupsAttachEndpointsRequest globalNetworkEndpointGroupsAttachEndpointsRequestResource = GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
 *   Operation response = globalNetworkEndpointGroupsClient.attachNetworkEndpoints(project, networkEndpointGroup, globalNetworkEndpointGroupsAttachEndpointsRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ====================== GlobalOperationsClient ======================
 *
 * <p>Service Description: The GlobalOperations API.
 *
 * <p>Sample for GlobalOperationsClient:
 *
 * <pre>
 * <code>
 * try (GlobalOperationsClient globalOperationsClient = GlobalOperationsClient.create()) {
 *   String project = "";
 *   String operation = "";
 *   DeleteGlobalOperationResponse response = globalOperationsClient.delete(project, operation);
 * }
 * </code>
 * </pre>
 *
 * ================================== GlobalOrganizationOperationsClient
 * ==================================
 *
 * <p>Service Description: The GlobalOrganizationOperations API.
 *
 * <p>Sample for GlobalOrganizationOperationsClient:
 *
 * <pre>
 * <code>
 * try (GlobalOrganizationOperationsClient globalOrganizationOperationsClient = GlobalOrganizationOperationsClient.create()) {
 *   String operation = "";
 *   DeleteGlobalOrganizationOperationResponse response = globalOrganizationOperationsClient.delete(operation);
 * }
 * </code>
 * </pre>
 *
 * ================== HealthChecksClient ==================
 *
 * <p>Service Description: The HealthChecks API.
 *
 * <p>Sample for HealthChecksClient:
 *
 * <pre>
 * <code>
 * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
 *   String project = "";
 *   String healthCheck = "";
 *   Operation response = healthChecksClient.delete(project, healthCheck);
 * }
 * </code>
 * </pre>
 *
 * ============ ImagesClient ============
 *
 * <p>Service Description: The Images API.
 *
 * <p>Sample for ImagesClient:
 *
 * <pre>
 * <code>
 * try (ImagesClient imagesClient = ImagesClient.create()) {
 *   String project = "";
 *   String image = "";
 *   Operation response = imagesClient.delete(project, image);
 * }
 * </code>
 * </pre>
 *
 * =========================== InstanceGroupManagersClient ===========================
 *
 * <p>Service Description: The InstanceGroupManagers API.
 *
 * <p>Sample for InstanceGroupManagersClient:
 *
 * <pre>
 * <code>
 * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String instanceGroupManager = "";
 *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupManagersClient.abandonInstances(project, zone, instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ==================== InstanceGroupsClient ====================
 *
 * <p>Service Description: The InstanceGroups API.
 *
 * <p>Sample for InstanceGroupsClient:
 *
 * <pre>
 * <code>
 * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String instanceGroup = "";
 *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupsClient.addInstances(project, zone, instanceGroup, instanceGroupsAddInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ======================= InstanceTemplatesClient =======================
 *
 * <p>Service Description: The InstanceTemplates API.
 *
 * <p>Sample for InstanceTemplatesClient:
 *
 * <pre>
 * <code>
 * try (InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create()) {
 *   String project = "";
 *   String instanceTemplate = "";
 *   Operation response = instanceTemplatesClient.delete(project, instanceTemplate);
 * }
 * </code>
 * </pre>
 *
 * =============== InstancesClient ===============
 *
 * <p>Service Description: The Instances API.
 *
 * <p>Sample for InstancesClient:
 *
 * <pre>
 * <code>
 * try (InstancesClient instancesClient = InstancesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String instance = "";
 *   String networkInterface = "";
 *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
 *   Operation response = instancesClient.addAccessConfig(project, zone, instance, networkInterface, accessConfigResource);
 * }
 * </code>
 * </pre>
 *
 * ============================= InterconnectAttachmentsClient =============================
 *
 * <p>Service Description: The InterconnectAttachments API.
 *
 * <p>Sample for InterconnectAttachmentsClient:
 *
 * <pre>
 * <code>
 * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String interconnectAttachment = "";
 *   Operation response = interconnectAttachmentsClient.delete(project, region, interconnectAttachment);
 * }
 * </code>
 * </pre>
 *
 * =========================== InterconnectLocationsClient ===========================
 *
 * <p>Service Description: The InterconnectLocations API.
 *
 * <p>Sample for InterconnectLocationsClient:
 *
 * <pre>
 * <code>
 * try (InterconnectLocationsClient interconnectLocationsClient = InterconnectLocationsClient.create()) {
 *   String project = "";
 *   String interconnectLocation = "";
 *   InterconnectLocation response = interconnectLocationsClient.get(project, interconnectLocation);
 * }
 * </code>
 * </pre>
 *
 * =================== InterconnectsClient ===================
 *
 * <p>Service Description: The Interconnects API.
 *
 * <p>Sample for InterconnectsClient:
 *
 * <pre>
 * <code>
 * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
 *   String project = "";
 *   String interconnect = "";
 *   Operation response = interconnectsClient.delete(project, interconnect);
 * }
 * </code>
 * </pre>
 *
 * ================== LicenseCodesClient ==================
 *
 * <p>Service Description: The LicenseCodes API.
 *
 * <p>Sample for LicenseCodesClient:
 *
 * <pre>
 * <code>
 * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
 *   String project = "";
 *   String licenseCode = "";
 *   LicenseCode response = licenseCodesClient.get(project, licenseCode);
 * }
 * </code>
 * </pre>
 *
 * ============== LicensesClient ==============
 *
 * <p>Service Description: The Licenses API.
 *
 * <p>Sample for LicensesClient:
 *
 * <pre>
 * <code>
 * try (LicensesClient licensesClient = LicensesClient.create()) {
 *   String project = "";
 *   String license = "";
 *   Operation response = licensesClient.delete(project, license);
 * }
 * </code>
 * </pre>
 *
 * ================== MachineTypesClient ==================
 *
 * <p>Service Description: The MachineTypes API.
 *
 * <p>Sample for MachineTypesClient:
 *
 * <pre>
 * <code>
 * try (MachineTypesClient machineTypesClient = MachineTypesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String machineType = "";
 *   MachineType response = machineTypesClient.get(project, zone, machineType);
 * }
 * </code>
 * </pre>
 *
 * =========================== NetworkEndpointGroupsClient ===========================
 *
 * <p>Service Description: The NetworkEndpointGroups API.
 *
 * <p>Sample for NetworkEndpointGroupsClient:
 *
 * <pre>
 * <code>
 * try (NetworkEndpointGroupsClient networkEndpointGroupsClient = NetworkEndpointGroupsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String networkEndpointGroup = "";
 *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
 *   Operation response = networkEndpointGroupsClient.attachNetworkEndpoints(project, zone, networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ============== NetworksClient ==============
 *
 * <p>Service Description: The Networks API.
 *
 * <p>Sample for NetworksClient:
 *
 * <pre>
 * <code>
 * try (NetworksClient networksClient = NetworksClient.create()) {
 *   String project = "";
 *   String network = "";
 *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
 *   Operation response = networksClient.addPeering(project, network, networksAddPeeringRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ================ NodeGroupsClient ================
 *
 * <p>Service Description: The NodeGroups API.
 *
 * <p>Sample for NodeGroupsClient:
 *
 * <pre>
 * <code>
 * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String nodeGroup = "";
 *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
 *   Operation response = nodeGroupsClient.addNodes(project, zone, nodeGroup, nodeGroupsAddNodesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * =================== NodeTemplatesClient ===================
 *
 * <p>Service Description: The NodeTemplates API.
 *
 * <p>Sample for NodeTemplatesClient:
 *
 * <pre>
 * <code>
 * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String nodeTemplate = "";
 *   Operation response = nodeTemplatesClient.delete(project, region, nodeTemplate);
 * }
 * </code>
 * </pre>
 *
 * =============== NodeTypesClient ===============
 *
 * <p>Service Description: The NodeTypes API.
 *
 * <p>Sample for NodeTypesClient:
 *
 * <pre>
 * <code>
 * try (NodeTypesClient nodeTypesClient = NodeTypesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String nodeType = "";
 *   NodeType response = nodeTypesClient.get(project, zone, nodeType);
 * }
 * </code>
 * </pre>
 *
 * ====================== PacketMirroringsClient ======================
 *
 * <p>Service Description: The PacketMirrorings API.
 *
 * <p>Sample for PacketMirroringsClient:
 *
 * <pre>
 * <code>
 * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String packetMirroring = "";
 *   Operation response = packetMirroringsClient.delete(project, region, packetMirroring);
 * }
 * </code>
 * </pre>
 *
 * ============== ProjectsClient ==============
 *
 * <p>Service Description: The Projects API.
 *
 * <p>Sample for ProjectsClient:
 *
 * <pre>
 * <code>
 * try (ProjectsClient projectsClient = ProjectsClient.create()) {
 *   String project = "";
 *   Operation response = projectsClient.disableXpnHost(project);
 * }
 * </code>
 * </pre>
 *
 * ======================= RegionAutoscalersClient =======================
 *
 * <p>Service Description: The RegionAutoscalers API.
 *
 * <p>Sample for RegionAutoscalersClient:
 *
 * <pre>
 * <code>
 * try (RegionAutoscalersClient regionAutoscalersClient = RegionAutoscalersClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String autoscaler = "";
 *   Operation response = regionAutoscalersClient.delete(project, region, autoscaler);
 * }
 * </code>
 * </pre>
 *
 * =========================== RegionBackendServicesClient ===========================
 *
 * <p>Service Description: The RegionBackendServices API.
 *
 * <p>Sample for RegionBackendServicesClient:
 *
 * <pre>
 * <code>
 * try (RegionBackendServicesClient regionBackendServicesClient = RegionBackendServicesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String backendService = "";
 *   Operation response = regionBackendServicesClient.delete(project, region, backendService);
 * }
 * </code>
 * </pre>
 *
 * ======================= RegionCommitmentsClient =======================
 *
 * <p>Service Description: The RegionCommitments API.
 *
 * <p>Sample for RegionCommitmentsClient:
 *
 * <pre>
 * <code>
 * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String commitment = "";
 *   Commitment response = regionCommitmentsClient.get(project, region, commitment);
 * }
 * </code>
 * </pre>
 *
 * ===================== RegionDiskTypesClient =====================
 *
 * <p>Service Description: The RegionDiskTypes API.
 *
 * <p>Sample for RegionDiskTypesClient:
 *
 * <pre>
 * <code>
 * try (RegionDiskTypesClient regionDiskTypesClient = RegionDiskTypesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String diskType = "";
 *   DiskType response = regionDiskTypesClient.get(project, region, diskType);
 * }
 * </code>
 * </pre>
 *
 * ================= RegionDisksClient =================
 *
 * <p>Service Description: The RegionDisks API.
 *
 * <p>Sample for RegionDisksClient:
 *
 * <pre>
 * <code>
 * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String disk = "";
 *   RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource = RegionDisksAddResourcePoliciesRequest.newBuilder().build();
 *   Operation response = regionDisksClient.addResourcePolicies(project, region, disk, regionDisksAddResourcePoliciesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * =============================== RegionHealthCheckServicesClient ===============================
 *
 * <p>Service Description: The RegionHealthCheckServices API.
 *
 * <p>Sample for RegionHealthCheckServicesClient:
 *
 * <pre>
 * <code>
 * try (RegionHealthCheckServicesClient regionHealthCheckServicesClient = RegionHealthCheckServicesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String healthCheckService = "";
 *   Operation response = regionHealthCheckServicesClient.delete(project, region, healthCheckService);
 * }
 * </code>
 * </pre>
 *
 * ======================== RegionHealthChecksClient ========================
 *
 * <p>Service Description: The RegionHealthChecks API.
 *
 * <p>Sample for RegionHealthChecksClient:
 *
 * <pre>
 * <code>
 * try (RegionHealthChecksClient regionHealthChecksClient = RegionHealthChecksClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String healthCheck = "";
 *   Operation response = regionHealthChecksClient.delete(project, region, healthCheck);
 * }
 * </code>
 * </pre>
 *
 * ================================= RegionInstanceGroupManagersClient
 * =================================
 *
 * <p>Service Description: The RegionInstanceGroupManagers API.
 *
 * <p>Sample for RegionInstanceGroupManagersClient:
 *
 * <pre>
 * <code>
 * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String instanceGroupManager = "";
 *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = regionInstanceGroupManagersClient.abandonInstances(project, region, instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ========================== RegionInstanceGroupsClient ==========================
 *
 * <p>Service Description: The RegionInstanceGroups API.
 *
 * <p>Sample for RegionInstanceGroupsClient:
 *
 * <pre>
 * <code>
 * try (RegionInstanceGroupsClient regionInstanceGroupsClient = RegionInstanceGroupsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String instanceGroup = "";
 *   InstanceGroup response = regionInstanceGroupsClient.get(project, region, instanceGroup);
 * }
 * </code>
 * </pre>
 *
 * ================================= RegionNetworkEndpointGroupsClient
 * =================================
 *
 * <p>Service Description: The RegionNetworkEndpointGroups API.
 *
 * <p>Sample for RegionNetworkEndpointGroupsClient:
 *
 * <pre>
 * <code>
 * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient = RegionNetworkEndpointGroupsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String networkEndpointGroup = "";
 *   Operation response = regionNetworkEndpointGroupsClient.delete(project, region, networkEndpointGroup);
 * }
 * </code>
 * </pre>
 *
 * ================================= RegionNotificationEndpointsClient
 * =================================
 *
 * <p>Service Description: The RegionNotificationEndpoints API.
 *
 * <p>Sample for RegionNotificationEndpointsClient:
 *
 * <pre>
 * <code>
 * try (RegionNotificationEndpointsClient regionNotificationEndpointsClient = RegionNotificationEndpointsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String notificationEndpoint = "";
 *   Operation response = regionNotificationEndpointsClient.delete(project, region, notificationEndpoint);
 * }
 * </code>
 * </pre>
 *
 * ====================== RegionOperationsClient ======================
 *
 * <p>Service Description: The RegionOperations API.
 *
 * <p>Sample for RegionOperationsClient:
 *
 * <pre>
 * <code>
 * try (RegionOperationsClient regionOperationsClient = RegionOperationsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String operation = "";
 *   DeleteRegionOperationResponse response = regionOperationsClient.delete(project, region, operation);
 * }
 * </code>
 * </pre>
 *
 * =========================== RegionSslCertificatesClient ===========================
 *
 * <p>Service Description: The RegionSslCertificates API.
 *
 * <p>Sample for RegionSslCertificatesClient:
 *
 * <pre>
 * <code>
 * try (RegionSslCertificatesClient regionSslCertificatesClient = RegionSslCertificatesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String sslCertificate = "";
 *   Operation response = regionSslCertificatesClient.delete(project, region, sslCertificate);
 * }
 * </code>
 * </pre>
 *
 * ============================= RegionTargetHttpProxiesClient =============================
 *
 * <p>Service Description: The RegionTargetHttpProxies API.
 *
 * <p>Sample for RegionTargetHttpProxiesClient:
 *
 * <pre>
 * <code>
 * try (RegionTargetHttpProxiesClient regionTargetHttpProxiesClient = RegionTargetHttpProxiesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetHttpProxy = "";
 *   Operation response = regionTargetHttpProxiesClient.delete(project, region, targetHttpProxy);
 * }
 * </code>
 * </pre>
 *
 * ============================== RegionTargetHttpsProxiesClient ==============================
 *
 * <p>Service Description: The RegionTargetHttpsProxies API.
 *
 * <p>Sample for RegionTargetHttpsProxiesClient:
 *
 * <pre>
 * <code>
 * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetHttpsProxy = "";
 *   Operation response = regionTargetHttpsProxiesClient.delete(project, region, targetHttpsProxy);
 * }
 * </code>
 * </pre>
 *
 * =================== RegionUrlMapsClient ===================
 *
 * <p>Service Description: The RegionUrlMaps API.
 *
 * <p>Sample for RegionUrlMapsClient:
 *
 * <pre>
 * <code>
 * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String urlMap = "";
 *   Operation response = regionUrlMapsClient.delete(project, region, urlMap);
 * }
 * </code>
 * </pre>
 *
 * ============= RegionsClient =============
 *
 * <p>Service Description: The Regions API.
 *
 * <p>Sample for RegionsClient:
 *
 * <pre>
 * <code>
 * try (RegionsClient regionsClient = RegionsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   Region response = regionsClient.get(project, region);
 * }
 * </code>
 * </pre>
 *
 * ================== ReservationsClient ==================
 *
 * <p>Service Description: The Reservations API.
 *
 * <p>Sample for ReservationsClient:
 *
 * <pre>
 * <code>
 * try (ReservationsClient reservationsClient = ReservationsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String reservation = "";
 *   Operation response = reservationsClient.delete(project, zone, reservation);
 * }
 * </code>
 * </pre>
 *
 * ====================== ResourcePoliciesClient ======================
 *
 * <p>Service Description: The ResourcePolicies API.
 *
 * <p>Sample for ResourcePoliciesClient:
 *
 * <pre>
 * <code>
 * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String resourcePolicy = "";
 *   Operation response = resourcePoliciesClient.delete(project, region, resourcePolicy);
 * }
 * </code>
 * </pre>
 *
 * ============= RoutersClient =============
 *
 * <p>Service Description: The Routers API.
 *
 * <p>Sample for RoutersClient:
 *
 * <pre>
 * <code>
 * try (RoutersClient routersClient = RoutersClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String router = "";
 *   Operation response = routersClient.delete(project, region, router);
 * }
 * </code>
 * </pre>
 *
 * ============ RoutesClient ============
 *
 * <p>Service Description: The Routes API.
 *
 * <p>Sample for RoutesClient:
 *
 * <pre>
 * <code>
 * try (RoutesClient routesClient = RoutesClient.create()) {
 *   String project = "";
 *   String route = "";
 *   Operation response = routesClient.delete(project, route);
 * }
 * </code>
 * </pre>
 *
 * ====================== SecurityPoliciesClient ======================
 *
 * <p>Service Description: The SecurityPolicies API.
 *
 * <p>Sample for SecurityPoliciesClient:
 *
 * <pre>
 * <code>
 * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
 *   String project = "";
 *   String securityPolicy = "";
 *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
 *   Operation response = securityPoliciesClient.addRule(project, securityPolicy, securityPolicyRuleResource);
 * }
 * </code>
 * </pre>
 *
 * =============== SnapshotsClient ===============
 *
 * <p>Service Description: The Snapshots API.
 *
 * <p>Sample for SnapshotsClient:
 *
 * <pre>
 * <code>
 * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
 *   String project = "";
 *   String snapshot = "";
 *   Operation response = snapshotsClient.delete(project, snapshot);
 * }
 * </code>
 * </pre>
 *
 * ===================== SslCertificatesClient =====================
 *
 * <p>Service Description: The SslCertificates API.
 *
 * <p>Sample for SslCertificatesClient:
 *
 * <pre>
 * <code>
 * try (SslCertificatesClient sslCertificatesClient = SslCertificatesClient.create()) {
 *   String project = "";
 *   String sslCertificate = "";
 *   Operation response = sslCertificatesClient.delete(project, sslCertificate);
 * }
 * </code>
 * </pre>
 *
 * ================= SslPoliciesClient =================
 *
 * <p>Service Description: The SslPolicies API.
 *
 * <p>Sample for SslPoliciesClient:
 *
 * <pre>
 * <code>
 * try (SslPoliciesClient sslPoliciesClient = SslPoliciesClient.create()) {
 *   String project = "";
 *   String sslPolicy = "";
 *   Operation response = sslPoliciesClient.delete(project, sslPolicy);
 * }
 * </code>
 * </pre>
 *
 * ================= SubnetworksClient =================
 *
 * <p>Service Description: The Subnetworks API.
 *
 * <p>Sample for SubnetworksClient:
 *
 * <pre>
 * <code>
 * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String subnetwork = "";
 *   Operation response = subnetworksClient.delete(project, region, subnetwork);
 * }
 * </code>
 * </pre>
 *
 * ======================= TargetGrpcProxiesClient =======================
 *
 * <p>Service Description: The TargetGrpcProxies API.
 *
 * <p>Sample for TargetGrpcProxiesClient:
 *
 * <pre>
 * <code>
 * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
 *   String project = "";
 *   String targetGrpcProxy = "";
 *   Operation response = targetGrpcProxiesClient.delete(project, targetGrpcProxy);
 * }
 * </code>
 * </pre>
 *
 * ======================= TargetHttpProxiesClient =======================
 *
 * <p>Service Description: The TargetHttpProxies API.
 *
 * <p>Sample for TargetHttpProxiesClient:
 *
 * <pre>
 * <code>
 * try (TargetHttpProxiesClient targetHttpProxiesClient = TargetHttpProxiesClient.create()) {
 *   String project = "";
 *   String targetHttpProxy = "";
 *   Operation response = targetHttpProxiesClient.delete(project, targetHttpProxy);
 * }
 * </code>
 * </pre>
 *
 * ======================== TargetHttpsProxiesClient ========================
 *
 * <p>Service Description: The TargetHttpsProxies API.
 *
 * <p>Sample for TargetHttpsProxiesClient:
 *
 * <pre>
 * <code>
 * try (TargetHttpsProxiesClient targetHttpsProxiesClient = TargetHttpsProxiesClient.create()) {
 *   String project = "";
 *   String targetHttpsProxy = "";
 *   Operation response = targetHttpsProxiesClient.delete(project, targetHttpsProxy);
 * }
 * </code>
 * </pre>
 *
 * ===================== TargetInstancesClient =====================
 *
 * <p>Service Description: The TargetInstances API.
 *
 * <p>Sample for TargetInstancesClient:
 *
 * <pre>
 * <code>
 * try (TargetInstancesClient targetInstancesClient = TargetInstancesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String targetInstance = "";
 *   Operation response = targetInstancesClient.delete(project, zone, targetInstance);
 * }
 * </code>
 * </pre>
 *
 * ================= TargetPoolsClient =================
 *
 * <p>Service Description: The TargetPools API.
 *
 * <p>Sample for TargetPoolsClient:
 *
 * <pre>
 * <code>
 * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetPool = "";
 *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
 *   Operation response = targetPoolsClient.addHealthCheck(project, region, targetPool, targetPoolsAddHealthCheckRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ====================== TargetSslProxiesClient ======================
 *
 * <p>Service Description: The TargetSslProxies API.
 *
 * <p>Sample for TargetSslProxiesClient:
 *
 * <pre>
 * <code>
 * try (TargetSslProxiesClient targetSslProxiesClient = TargetSslProxiesClient.create()) {
 *   String project = "";
 *   String targetSslProxy = "";
 *   Operation response = targetSslProxiesClient.delete(project, targetSslProxy);
 * }
 * </code>
 * </pre>
 *
 * ====================== TargetTcpProxiesClient ======================
 *
 * <p>Service Description: The TargetTcpProxies API.
 *
 * <p>Sample for TargetTcpProxiesClient:
 *
 * <pre>
 * <code>
 * try (TargetTcpProxiesClient targetTcpProxiesClient = TargetTcpProxiesClient.create()) {
 *   String project = "";
 *   String targetTcpProxy = "";
 *   Operation response = targetTcpProxiesClient.delete(project, targetTcpProxy);
 * }
 * </code>
 * </pre>
 *
 * ======================= TargetVpnGatewaysClient =======================
 *
 * <p>Service Description: The TargetVpnGateways API.
 *
 * <p>Sample for TargetVpnGatewaysClient:
 *
 * <pre>
 * <code>
 * try (TargetVpnGatewaysClient targetVpnGatewaysClient = TargetVpnGatewaysClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetVpnGateway = "";
 *   Operation response = targetVpnGatewaysClient.delete(project, region, targetVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * ============= UrlMapsClient =============
 *
 * <p>Service Description: The UrlMaps API.
 *
 * <p>Sample for UrlMapsClient:
 *
 * <pre>
 * <code>
 * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
 *   String project = "";
 *   String urlMap = "";
 *   Operation response = urlMapsClient.delete(project, urlMap);
 * }
 * </code>
 * </pre>
 *
 * ================= VpnGatewaysClient =================
 *
 * <p>Service Description: The VpnGateways API.
 *
 * <p>Sample for VpnGatewaysClient:
 *
 * <pre>
 * <code>
 * try (VpnGatewaysClient vpnGatewaysClient = VpnGatewaysClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String vpnGateway = "";
 *   Operation response = vpnGatewaysClient.delete(project, region, vpnGateway);
 * }
 * </code>
 * </pre>
 *
 * ================ VpnTunnelsClient ================
 *
 * <p>Service Description: The VpnTunnels API.
 *
 * <p>Sample for VpnTunnelsClient:
 *
 * <pre>
 * <code>
 * try (VpnTunnelsClient vpnTunnelsClient = VpnTunnelsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String vpnTunnel = "";
 *   Operation response = vpnTunnelsClient.delete(project, region, vpnTunnel);
 * }
 * </code>
 * </pre>
 *
 * ==================== ZoneOperationsClient ====================
 *
 * <p>Service Description: The ZoneOperations API.
 *
 * <p>Sample for ZoneOperationsClient:
 *
 * <pre>
 * <code>
 * try (ZoneOperationsClient zoneOperationsClient = ZoneOperationsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String operation = "";
 *   DeleteZoneOperationResponse response = zoneOperationsClient.delete(project, zone, operation);
 * }
 * </code>
 * </pre>
 *
 * =========== ZonesClient ===========
 *
 * <p>Service Description: The Zones API.
 *
 * <p>Sample for ZonesClient:
 *
 * <pre>
 * <code>
 * try (ZonesClient zonesClient = ZonesClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   Zone response = zonesClient.get(project, zone);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.compute.v1;

import javax.annotation.Generated;
