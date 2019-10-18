/*
 * Copyright 2019 Google LLC
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
 * A client to Compute Engine API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>===================== AcceleratorTypeClient =====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for AcceleratorTypeClient:
 *
 * <pre>
 * <code>
 * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
 *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
 *   AcceleratorType response = acceleratorTypeClient.getAcceleratorType(acceleratorType);
 * }
 * </code>
 * </pre>
 *
 * ============= AddressClient =============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for AddressClient:
 *
 * <pre>
 * <code>
 * try (AddressClient addressClient = AddressClient.create()) {
 *   ProjectRegionAddressName address = ProjectRegionAddressName.of("[PROJECT]", "[REGION]", "[ADDRESS]");
 *   Operation response = addressClient.deleteAddress(address);
 * }
 * </code>
 * </pre>
 *
 * ================ AutoscalerClient ================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for AutoscalerClient:
 *
 * <pre>
 * <code>
 * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
 *   ProjectZoneAutoscalerName autoscaler = ProjectZoneAutoscalerName.of("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
 *   Operation response = autoscalerClient.deleteAutoscaler(autoscaler);
 * }
 * </code>
 * </pre>
 *
 * =================== BackendBucketClient ===================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for BackendBucketClient:
 *
 * <pre>
 * <code>
 * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
 *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
 *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
 *   Operation response = backendBucketClient.addSignedUrlKeyBackendBucket(backendBucket, signedUrlKeyResource);
 * }
 * </code>
 * </pre>
 *
 * ==================== BackendServiceClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for BackendServiceClient:
 *
 * <pre>
 * <code>
 * try (BackendServiceClient backendServiceClient = BackendServiceClient.create()) {
 *   ProjectGlobalBackendServiceName backendService = ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
 *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
 *   Operation response = backendServiceClient.addSignedUrlKeyBackendService(backendService, signedUrlKeyResource);
 * }
 * </code>
 * </pre>
 *
 * ============== DiskTypeClient ==============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for DiskTypeClient:
 *
 * <pre>
 * <code>
 * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
 *   ProjectZoneDiskTypeName diskType = ProjectZoneDiskTypeName.of("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
 *   DiskType response = diskTypeClient.getDiskType(diskType);
 * }
 * </code>
 * </pre>
 *
 * ========== DiskClient ==========
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for DiskClient:
 *
 * <pre>
 * <code>
 * try (DiskClient diskClient = DiskClient.create()) {
 *   ProjectZoneDiskName disk = ProjectZoneDiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
 *   DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource = DisksAddResourcePoliciesRequest.newBuilder().build();
 *   Operation response = diskClient.addResourcePoliciesDisk(disk, disksAddResourcePoliciesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ======================== ExternalVpnGatewayClient ========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ExternalVpnGatewayClient:
 *
 * <pre>
 * <code>
 * try (ExternalVpnGatewayClient externalVpnGatewayClient = ExternalVpnGatewayClient.create()) {
 *   ProjectGlobalExternalVpnGatewayName externalVpnGateway = ProjectGlobalExternalVpnGatewayName.of("[PROJECT]", "[EXTERNAL_VPN_GATEWAY]");
 *   Operation response = externalVpnGatewayClient.deleteExternalVpnGateway(externalVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * ============== FirewallClient ==============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for FirewallClient:
 *
 * <pre>
 * <code>
 * try (FirewallClient firewallClient = FirewallClient.create()) {
 *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
 *   Operation response = firewallClient.deleteFirewall(firewall);
 * }
 * </code>
 * </pre>
 *
 * ==================== ForwardingRuleClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ForwardingRuleClient:
 *
 * <pre>
 * <code>
 * try (ForwardingRuleClient forwardingRuleClient = ForwardingRuleClient.create()) {
 *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
 *   Operation response = forwardingRuleClient.deleteForwardingRule(forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * =================== GlobalAddressClient ===================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for GlobalAddressClient:
 *
 * <pre>
 * <code>
 * try (GlobalAddressClient globalAddressClient = GlobalAddressClient.create()) {
 *   ProjectGlobalAddressName address = ProjectGlobalAddressName.of("[PROJECT]", "[ADDRESS]");
 *   Operation response = globalAddressClient.deleteGlobalAddress(address);
 * }
 * </code>
 * </pre>
 *
 * ========================== GlobalForwardingRuleClient ==========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for GlobalForwardingRuleClient:
 *
 * <pre>
 * <code>
 * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
 *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
 *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * ===================== GlobalOperationClient =====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for GlobalOperationClient:
 *
 * <pre>
 * <code>
 * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
 *   ProjectGlobalOperationName operation = ProjectGlobalOperationName.of("[PROJECT]", "[OPERATION]");
 *   globalOperationClient.deleteGlobalOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * ================= HealthCheckClient =================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for HealthCheckClient:
 *
 * <pre>
 * <code>
 * try (HealthCheckClient healthCheckClient = HealthCheckClient.create()) {
 *   ProjectGlobalHealthCheckName healthCheck = ProjectGlobalHealthCheckName.of("[PROJECT]", "[HEALTH_CHECK]");
 *   Operation response = healthCheckClient.deleteHealthCheck(healthCheck);
 * }
 * </code>
 * </pre>
 *
 * ===================== HttpHealthCheckClient =====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for HttpHealthCheckClient:
 *
 * <pre>
 * <code>
 * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
 *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
 *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(httpHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * ====================== HttpsHealthCheckClient ======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for HttpsHealthCheckClient:
 *
 * <pre>
 * <code>
 * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
 *   ProjectGlobalHttpsHealthCheckName httpsHealthCheck = ProjectGlobalHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
 *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * =========== ImageClient ===========
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ImageClient:
 *
 * <pre>
 * <code>
 * try (ImageClient imageClient = ImageClient.create()) {
 *   ProjectGlobalImageName image = ProjectGlobalImageName.of("[PROJECT]", "[IMAGE]");
 *   Operation response = imageClient.deleteImage(image);
 * }
 * </code>
 * </pre>
 *
 * ========================== InstanceGroupManagerClient ==========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InstanceGroupManagerClient:
 *
 * <pre>
 * <code>
 * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
 *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
 *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * =================== InstanceGroupClient ===================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InstanceGroupClient:
 *
 * <pre>
 * <code>
 * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
 *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
 *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupClient.addInstancesInstanceGroup(instanceGroup, instanceGroupsAddInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ====================== InstanceTemplateClient ======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InstanceTemplateClient:
 *
 * <pre>
 * <code>
 * try (InstanceTemplateClient instanceTemplateClient = InstanceTemplateClient.create()) {
 *   ProjectGlobalInstanceTemplateName instanceTemplate = ProjectGlobalInstanceTemplateName.of("[PROJECT]", "[INSTANCE_TEMPLATE]");
 *   Operation response = instanceTemplateClient.deleteInstanceTemplate(instanceTemplate);
 * }
 * </code>
 * </pre>
 *
 * ============== InstanceClient ==============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InstanceClient:
 *
 * <pre>
 * <code>
 * try (InstanceClient instanceClient = InstanceClient.create()) {
 *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
 *   String networkInterface = "";
 *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
 *   Operation response = instanceClient.addAccessConfigInstance(instance, networkInterface, accessConfigResource);
 * }
 * </code>
 * </pre>
 *
 * ============================ InterconnectAttachmentClient ============================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InterconnectAttachmentClient:
 *
 * <pre>
 * <code>
 * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
 *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
 *   Operation response = interconnectAttachmentClient.deleteInterconnectAttachment(interconnectAttachment);
 * }
 * </code>
 * </pre>
 *
 * ========================== InterconnectLocationClient ==========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InterconnectLocationClient:
 *
 * <pre>
 * <code>
 * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
 *   ProjectGlobalInterconnectLocationName interconnectLocation = ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
 *   InterconnectLocation response = interconnectLocationClient.getInterconnectLocation(interconnectLocation);
 * }
 * </code>
 * </pre>
 *
 * ================== InterconnectClient ==================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for InterconnectClient:
 *
 * <pre>
 * <code>
 * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
 *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
 *   Operation response = interconnectClient.deleteInterconnect(interconnect);
 * }
 * </code>
 * </pre>
 *
 * ================= LicenseCodeClient =================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for LicenseCodeClient:
 *
 * <pre>
 * <code>
 * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
 *   ProjectGlobalLicenseCodeName licenseCode = ProjectGlobalLicenseCodeName.of("[PROJECT]", "[LICENSE_CODE]");
 *   LicenseCode response = licenseCodeClient.getLicenseCode(licenseCode);
 * }
 * </code>
 * </pre>
 *
 * ============= LicenseClient =============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for LicenseClient:
 *
 * <pre>
 * <code>
 * try (LicenseClient licenseClient = LicenseClient.create()) {
 *   ProjectGlobalLicenseName license = ProjectGlobalLicenseName.of("[PROJECT]", "[LICENSE]");
 *   Operation response = licenseClient.deleteLicense(license);
 * }
 * </code>
 * </pre>
 *
 * ================= MachineTypeClient =================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for MachineTypeClient:
 *
 * <pre>
 * <code>
 * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
 *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
 *   MachineType response = machineTypeClient.getMachineType(machineType);
 * }
 * </code>
 * </pre>
 *
 * ========================== NetworkEndpointGroupClient ==========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for NetworkEndpointGroupClient:
 *
 * <pre>
 * <code>
 * try (NetworkEndpointGroupClient networkEndpointGroupClient = NetworkEndpointGroupClient.create()) {
 *   ProjectZoneNetworkEndpointGroupName networkEndpointGroup = ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
 *   NetworkEndpointGroupsAttachEndpointsRequest networkEndpointGroupsAttachEndpointsRequestResource = NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();
 *   Operation response = networkEndpointGroupClient.attachNetworkEndpointsNetworkEndpointGroup(networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ============= NetworkClient =============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for NetworkClient:
 *
 * <pre>
 * <code>
 * try (NetworkClient networkClient = NetworkClient.create()) {
 *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
 *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
 *   Operation response = networkClient.addPeeringNetwork(network, networksAddPeeringRequestResource);
 * }
 * </code>
 * </pre>
 *
 * =============== NodeGroupClient ===============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for NodeGroupClient:
 *
 * <pre>
 * <code>
 * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
 *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
 *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
 *   Operation response = nodeGroupClient.addNodesNodeGroup(nodeGroup, nodeGroupsAddNodesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ================== NodeTemplateClient ==================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for NodeTemplateClient:
 *
 * <pre>
 * <code>
 * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
 *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
 *   Operation response = nodeTemplateClient.deleteNodeTemplate(nodeTemplate);
 * }
 * </code>
 * </pre>
 *
 * ============== NodeTypeClient ==============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for NodeTypeClient:
 *
 * <pre>
 * <code>
 * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
 *   ProjectZoneNodeTypeName nodeType = ProjectZoneNodeTypeName.of("[PROJECT]", "[ZONE]", "[NODE_TYPE]");
 *   NodeType response = nodeTypeClient.getNodeType(nodeType);
 * }
 * </code>
 * </pre>
 *
 * ============= ProjectClient =============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ProjectClient:
 *
 * <pre>
 * <code>
 * try (ProjectClient projectClient = ProjectClient.create()) {
 *   ProjectName project = ProjectName.of("[PROJECT]");
 *   Operation response = projectClient.disableXpnHostProject(project);
 * }
 * </code>
 * </pre>
 *
 * ====================== RegionAutoscalerClient ======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionAutoscalerClient:
 *
 * <pre>
 * <code>
 * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
 *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
 *   Operation response = regionAutoscalerClient.deleteRegionAutoscaler(autoscaler);
 * }
 * </code>
 * </pre>
 *
 * ========================== RegionBackendServiceClient ==========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionBackendServiceClient:
 *
 * <pre>
 * <code>
 * try (RegionBackendServiceClient regionBackendServiceClient = RegionBackendServiceClient.create()) {
 *   ProjectRegionBackendServiceName backendService = ProjectRegionBackendServiceName.of("[PROJECT]", "[REGION]", "[BACKEND_SERVICE]");
 *   Operation response = regionBackendServiceClient.deleteRegionBackendService(backendService);
 * }
 * </code>
 * </pre>
 *
 * ====================== RegionCommitmentClient ======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionCommitmentClient:
 *
 * <pre>
 * <code>
 * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
 *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
 *   Commitment response = regionCommitmentClient.getRegionCommitment(commitment);
 * }
 * </code>
 * </pre>
 *
 * ==================== RegionDiskTypeClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionDiskTypeClient:
 *
 * <pre>
 * <code>
 * try (RegionDiskTypeClient regionDiskTypeClient = RegionDiskTypeClient.create()) {
 *   ProjectRegionDiskTypeName diskType = ProjectRegionDiskTypeName.of("[PROJECT]", "[REGION]", "[DISK_TYPE]");
 *   DiskType response = regionDiskTypeClient.getRegionDiskType(diskType);
 * }
 * </code>
 * </pre>
 *
 * ================ RegionDiskClient ================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionDiskClient:
 *
 * <pre>
 * <code>
 * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
 *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
 *   RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource = RegionDisksAddResourcePoliciesRequest.newBuilder().build();
 *   Operation response = regionDiskClient.addResourcePoliciesRegionDisk(disk, regionDisksAddResourcePoliciesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ======================= RegionHealthCheckClient =======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionHealthCheckClient:
 *
 * <pre>
 * <code>
 * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
 *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
 *   Operation response = regionHealthCheckClient.deleteRegionHealthCheck(healthCheck);
 * }
 * </code>
 * </pre>
 *
 * ================================ RegionInstanceGroupManagerClient
 * ================================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionInstanceGroupManagerClient:
 *
 * <pre>
 * <code>
 * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
 *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
 *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ========================= RegionInstanceGroupClient =========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionInstanceGroupClient:
 *
 * <pre>
 * <code>
 * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
 *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
 *   InstanceGroup response = regionInstanceGroupClient.getRegionInstanceGroup(instanceGroup);
 * }
 * </code>
 * </pre>
 *
 * ===================== RegionOperationClient =====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionOperationClient:
 *
 * <pre>
 * <code>
 * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
 *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
 *   regionOperationClient.deleteRegionOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * ========================== RegionSslCertificateClient ==========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionSslCertificateClient:
 *
 * <pre>
 * <code>
 * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
 *   ProjectRegionSslCertificateName sslCertificate = ProjectRegionSslCertificateName.of("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
 *   Operation response = regionSslCertificateClient.deleteRegionSslCertificate(sslCertificate);
 * }
 * </code>
 * </pre>
 *
 * =========================== RegionTargetHttpProxyClient ===========================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionTargetHttpProxyClient:
 *
 * <pre>
 * <code>
 * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
 *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
 *   Operation response = regionTargetHttpProxyClient.deleteRegionTargetHttpProxy(targetHttpProxy);
 * }
 * </code>
 * </pre>
 *
 * ============================ RegionTargetHttpsProxyClient ============================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionTargetHttpsProxyClient:
 *
 * <pre>
 * <code>
 * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
 *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
 *   Operation response = regionTargetHttpsProxyClient.deleteRegionTargetHttpsProxy(targetHttpsProxy);
 * }
 * </code>
 * </pre>
 *
 * ================== RegionUrlMapClient ==================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionUrlMapClient:
 *
 * <pre>
 * <code>
 * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
 *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
 *   String requestId = "";
 *   Operation response = regionUrlMapClient.deleteRegionUrlMap(urlMap, requestId);
 * }
 * </code>
 * </pre>
 *
 * ============ RegionClient ============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RegionClient:
 *
 * <pre>
 * <code>
 * try (RegionClient regionClient = RegionClient.create()) {
 *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
 *   Region response = regionClient.getRegion(region);
 * }
 * </code>
 * </pre>
 *
 * ================= ReservationClient =================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ReservationClient:
 *
 * <pre>
 * <code>
 * try (ReservationClient reservationClient = ReservationClient.create()) {
 *   ProjectZoneReservationName reservation = ProjectZoneReservationName.of("[PROJECT]", "[ZONE]", "[RESERVATION]");
 *   Operation response = reservationClient.deleteReservation(reservation);
 * }
 * </code>
 * </pre>
 *
 * ==================== ResourcePolicyClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ResourcePolicyClient:
 *
 * <pre>
 * <code>
 * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
 *   ProjectRegionResourcePolicyName resourcePolicy = ProjectRegionResourcePolicyName.of("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
 *   Operation response = resourcePolicyClient.deleteResourcePolicy(resourcePolicy);
 * }
 * </code>
 * </pre>
 *
 * ============ RouterClient ============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RouterClient:
 *
 * <pre>
 * <code>
 * try (RouterClient routerClient = RouterClient.create()) {
 *   ProjectRegionRouterName router = ProjectRegionRouterName.of("[PROJECT]", "[REGION]", "[ROUTER]");
 *   Operation response = routerClient.deleteRouter(router);
 * }
 * </code>
 * </pre>
 *
 * =========== RouteClient ===========
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for RouteClient:
 *
 * <pre>
 * <code>
 * try (RouteClient routeClient = RouteClient.create()) {
 *   ProjectGlobalRouteName route = ProjectGlobalRouteName.of("[PROJECT]", "[ROUTE]");
 *   Operation response = routeClient.deleteRoute(route);
 * }
 * </code>
 * </pre>
 *
 * ==================== SecurityPolicyClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for SecurityPolicyClient:
 *
 * <pre>
 * <code>
 * try (SecurityPolicyClient securityPolicyClient = SecurityPolicyClient.create()) {
 *   ProjectGlobalSecurityPolicyName securityPolicy = ProjectGlobalSecurityPolicyName.of("[PROJECT]", "[SECURITY_POLICY]");
 *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
 *   Operation response = securityPolicyClient.addRuleSecurityPolicy(securityPolicy, securityPolicyRuleResource);
 * }
 * </code>
 * </pre>
 *
 * ============== SnapshotClient ==============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for SnapshotClient:
 *
 * <pre>
 * <code>
 * try (SnapshotClient snapshotClient = SnapshotClient.create()) {
 *   ProjectGlobalSnapshotName snapshot = ProjectGlobalSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
 *   Operation response = snapshotClient.deleteSnapshot(snapshot);
 * }
 * </code>
 * </pre>
 *
 * ==================== SslCertificateClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for SslCertificateClient:
 *
 * <pre>
 * <code>
 * try (SslCertificateClient sslCertificateClient = SslCertificateClient.create()) {
 *   ProjectGlobalSslCertificateName sslCertificate = ProjectGlobalSslCertificateName.of("[PROJECT]", "[SSL_CERTIFICATE]");
 *   Operation response = sslCertificateClient.deleteSslCertificate(sslCertificate);
 * }
 * </code>
 * </pre>
 *
 * =============== SslPolicyClient ===============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for SslPolicyClient:
 *
 * <pre>
 * <code>
 * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
 *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
 *   Operation response = sslPolicyClient.deleteSslPolicy(sslPolicy);
 * }
 * </code>
 * </pre>
 *
 * ================ SubnetworkClient ================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for SubnetworkClient:
 *
 * <pre>
 * <code>
 * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
 *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
 *   Operation response = subnetworkClient.deleteSubnetwork(subnetwork);
 * }
 * </code>
 * </pre>
 *
 * ===================== TargetHttpProxyClient =====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetHttpProxyClient:
 *
 * <pre>
 * <code>
 * try (TargetHttpProxyClient targetHttpProxyClient = TargetHttpProxyClient.create()) {
 *   ProjectGlobalTargetHttpProxyName targetHttpProxy = ProjectGlobalTargetHttpProxyName.of("[PROJECT]", "[TARGET_HTTP_PROXY]");
 *   Operation response = targetHttpProxyClient.deleteTargetHttpProxy(targetHttpProxy);
 * }
 * </code>
 * </pre>
 *
 * ====================== TargetHttpsProxyClient ======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetHttpsProxyClient:
 *
 * <pre>
 * <code>
 * try (TargetHttpsProxyClient targetHttpsProxyClient = TargetHttpsProxyClient.create()) {
 *   ProjectGlobalTargetHttpsProxyName targetHttpsProxy = ProjectGlobalTargetHttpsProxyName.of("[PROJECT]", "[TARGET_HTTPS_PROXY]");
 *   Operation response = targetHttpsProxyClient.deleteTargetHttpsProxy(targetHttpsProxy);
 * }
 * </code>
 * </pre>
 *
 * ==================== TargetInstanceClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetInstanceClient:
 *
 * <pre>
 * <code>
 * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
 *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
 *   Operation response = targetInstanceClient.deleteTargetInstance(targetInstance);
 * }
 * </code>
 * </pre>
 *
 * ================ TargetPoolClient ================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetPoolClient:
 *
 * <pre>
 * <code>
 * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
 *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
 *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
 *   Operation response = targetPoolClient.addHealthCheckTargetPool(targetPool, targetPoolsAddHealthCheckRequestResource);
 * }
 * </code>
 * </pre>
 *
 * ==================== TargetSslProxyClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetSslProxyClient:
 *
 * <pre>
 * <code>
 * try (TargetSslProxyClient targetSslProxyClient = TargetSslProxyClient.create()) {
 *   ProjectGlobalTargetSslProxyName targetSslProxy = ProjectGlobalTargetSslProxyName.of("[PROJECT]", "[TARGET_SSL_PROXY]");
 *   Operation response = targetSslProxyClient.deleteTargetSslProxy(targetSslProxy);
 * }
 * </code>
 * </pre>
 *
 * ==================== TargetTcpProxyClient ====================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetTcpProxyClient:
 *
 * <pre>
 * <code>
 * try (TargetTcpProxyClient targetTcpProxyClient = TargetTcpProxyClient.create()) {
 *   ProjectGlobalTargetTcpProxyName targetTcpProxy = ProjectGlobalTargetTcpProxyName.of("[PROJECT]", "[TARGET_TCP_PROXY]");
 *   Operation response = targetTcpProxyClient.deleteTargetTcpProxy(targetTcpProxy);
 * }
 * </code>
 * </pre>
 *
 * ====================== TargetVpnGatewayClient ======================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for TargetVpnGatewayClient:
 *
 * <pre>
 * <code>
 * try (TargetVpnGatewayClient targetVpnGatewayClient = TargetVpnGatewayClient.create()) {
 *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
 *   Operation response = targetVpnGatewayClient.deleteTargetVpnGateway(targetVpnGateway);
 * }
 * </code>
 * </pre>
 *
 * ============ UrlMapClient ============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for UrlMapClient:
 *
 * <pre>
 * <code>
 * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
 *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
 *   Operation response = urlMapClient.deleteUrlMap(urlMap);
 * }
 * </code>
 * </pre>
 *
 * ================ VpnGatewayClient ================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for VpnGatewayClient:
 *
 * <pre>
 * <code>
 * try (VpnGatewayClient vpnGatewayClient = VpnGatewayClient.create()) {
 *   ProjectRegionVpnGatewayName vpnGateway = ProjectRegionVpnGatewayName.of("[PROJECT]", "[REGION]", "[VPN_GATEWAY]");
 *   Operation response = vpnGatewayClient.deleteVpnGateway(vpnGateway);
 * }
 * </code>
 * </pre>
 *
 * =============== VpnTunnelClient ===============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for VpnTunnelClient:
 *
 * <pre>
 * <code>
 * try (VpnTunnelClient vpnTunnelClient = VpnTunnelClient.create()) {
 *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
 *   Operation response = vpnTunnelClient.deleteVpnTunnel(vpnTunnel);
 * }
 * </code>
 * </pre>
 *
 * =================== ZoneOperationClient ===================
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ZoneOperationClient:
 *
 * <pre>
 * <code>
 * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
 *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
 *   zoneOperationClient.deleteZoneOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * ========== ZoneClient ==========
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for ZoneClient:
 *
 * <pre>
 * <code>
 * try (ZoneClient zoneClient = ZoneClient.create()) {
 *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
 *   Zone response = zoneClient.getZone(zone);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.compute.v1;

import javax.annotation.Generated;
