/*
 * Copyright 2018 Google LLC
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
 *   String requestId = "";
 *   Operation response = addressClient.deleteAddress(address, requestId);
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
 *   String requestId = "";
 *   Operation response = autoscalerClient.deleteAutoscaler(autoscaler, requestId);
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
 *   String requestId = "";
 *   Operation response = backendBucketClient.deleteBackendBucket(backendBucket, requestId);
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
 *   String requestId = "";
 *   ProjectGlobalBackendServiceName backendService = ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
 *   Operation response = backendServiceClient.deleteBackendService(requestId, backendService);
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
 *   String requestId = "";
 *   Boolean guestFlush = false;
 *   Snapshot snapshotResource = Snapshot.newBuilder().build();
 *   Operation response = diskClient.createSnapshotDisk(disk, requestId, guestFlush, snapshotResource);
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
 *   String requestId = "";
 *   Operation response = firewallClient.deleteFirewall(firewall, requestId);
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
 *   String requestId = "";
 *   ProjectRegionForwardingRuleName forwardingRule = ProjectRegionForwardingRuleName.of("[PROJECT]", "[REGION]", "[FORWARDING_RULE]");
 *   Operation response = forwardingRuleClient.deleteForwardingRule(requestId, forwardingRule);
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
 *   String requestId = "";
 *   Operation response = globalAddressClient.deleteGlobalAddress(address, requestId);
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
 *   String requestId = "";
 *   ProjectGlobalForwardingRuleName forwardingRule = ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
 *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(requestId, forwardingRule);
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
 *   String requestId = "";
 *   ProjectGlobalHealthCheckName healthCheck = ProjectGlobalHealthCheckName.of("[PROJECT]", "[HEALTH_CHECK]");
 *   Operation response = healthCheckClient.deleteHealthCheck(requestId, healthCheck);
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
 *   String requestId = "";
 *   ProjectGlobalHttpHealthCheckName httpHealthCheck = ProjectGlobalHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
 *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(requestId, httpHealthCheck);
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
 *   String requestId = "";
 *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck, requestId);
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
 *   String requestId = "";
 *   Operation response = imageClient.deleteImage(image, requestId);
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
 *   String requestId = "";
 *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
 *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(requestId, instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
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
 *   String requestId = "";
 *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
 *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupClient.addInstancesInstanceGroup(requestId, instanceGroup, instanceGroupsAddInstancesRequestResource);
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
 *   String requestId = "";
 *   Operation response = instanceTemplateClient.deleteInstanceTemplate(instanceTemplate, requestId);
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
 *   String requestId = "";
 *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
 *   Operation response = instanceClient.addAccessConfigInstance(instance, networkInterface, requestId, accessConfigResource);
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
 *   String requestId = "";
 *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
 *   Operation response = interconnectAttachmentClient.deleteInterconnectAttachment(requestId, interconnectAttachment);
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
 *   String requestId = "";
 *   ProjectGlobalInterconnectName interconnect = ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
 *   Operation response = interconnectClient.deleteInterconnect(requestId, interconnect);
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
 *   String requestId = "";
 *   Operation response = licenseClient.deleteLicense(license, requestId);
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
 * ============= NetworkClient =============
 *
 * <p>Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>Sample for NetworkClient:
 *
 * <pre>
 * <code>
 * try (NetworkClient networkClient = NetworkClient.create()) {
 *   String requestId = "";
 *   ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
 *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
 *   Operation response = networkClient.addPeeringNetwork(requestId, network, networksAddPeeringRequestResource);
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
 *   String requestId = "";
 *   ProjectName project = ProjectName.of("[PROJECT]");
 *   Operation response = projectClient.disableXpnHostProject(requestId, project);
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
 *   String requestId = "";
 *   Operation response = regionAutoscalerClient.deleteRegionAutoscaler(autoscaler, requestId);
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
 *   String requestId = "";
 *   ProjectRegionBackendServiceName backendService = ProjectRegionBackendServiceName.of("[PROJECT]", "[REGION]", "[BACKEND_SERVICE]");
 *   Operation response = regionBackendServiceClient.deleteRegionBackendService(requestId, backendService);
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
 *   String requestId = "";
 *   Snapshot snapshotResource = Snapshot.newBuilder().build();
 *   Operation response = regionDiskClient.createSnapshotRegionDisk(disk, requestId, snapshotResource);
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
 *   String requestId = "";
 *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
 *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManager(requestId, instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
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
 *   String requestId = "";
 *   Operation response = routerClient.deleteRouter(router, requestId);
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
 *   String requestId = "";
 *   Operation response = routeClient.deleteRoute(route, requestId);
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
 *   String requestId = "";
 *   ProjectGlobalSnapshotName snapshot = ProjectGlobalSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
 *   Operation response = snapshotClient.deleteSnapshot(requestId, snapshot);
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
 *   String requestId = "";
 *   Operation response = sslCertificateClient.deleteSslCertificate(sslCertificate, requestId);
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
 *   String requestId = "";
 *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
 *   Operation response = sslPolicyClient.deleteSslPolicy(requestId, sslPolicy);
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
 *   String requestId = "";
 *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
 *   Operation response = subnetworkClient.deleteSubnetwork(requestId, subnetwork);
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
 *   String requestId = "";
 *   ProjectGlobalTargetHttpProxyName targetHttpProxy = ProjectGlobalTargetHttpProxyName.of("[PROJECT]", "[TARGET_HTTP_PROXY]");
 *   Operation response = targetHttpProxyClient.deleteTargetHttpProxy(requestId, targetHttpProxy);
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
 *   String requestId = "";
 *   Operation response = targetHttpsProxyClient.deleteTargetHttpsProxy(targetHttpsProxy, requestId);
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
 *   String requestId = "";
 *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
 *   Operation response = targetInstanceClient.deleteTargetInstance(requestId, targetInstance);
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
 *   String requestId = "";
 *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
 *   Operation response = targetPoolClient.addHealthCheckTargetPool(targetPool, requestId, targetPoolsAddHealthCheckRequestResource);
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
 *   String requestId = "";
 *   Operation response = targetSslProxyClient.deleteTargetSslProxy(targetSslProxy, requestId);
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
 *   String requestId = "";
 *   ProjectGlobalTargetTcpProxyName targetTcpProxy = ProjectGlobalTargetTcpProxyName.of("[PROJECT]", "[TARGET_TCP_PROXY]");
 *   Operation response = targetTcpProxyClient.deleteTargetTcpProxy(requestId, targetTcpProxy);
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
 *   String requestId = "";
 *   ProjectRegionTargetVpnGatewayName targetVpnGateway = ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
 *   Operation response = targetVpnGatewayClient.deleteTargetVpnGateway(requestId, targetVpnGateway);
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
 *   String requestId = "";
 *   Operation response = urlMapClient.deleteUrlMap(urlMap, requestId);
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
 *   String requestId = "";
 *   ProjectRegionVpnTunnelName vpnTunnel = ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");
 *   Operation response = vpnTunnelClient.deleteVpnTunnel(requestId, vpnTunnel);
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
package com.google.cloud.compute.v1;
