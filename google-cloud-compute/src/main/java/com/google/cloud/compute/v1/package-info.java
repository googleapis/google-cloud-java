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
 * The interfaces provided are listed below, along with usage samples.
 *
 * =====================
 * AcceleratorTypeClient
 * =====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for AcceleratorTypeClient:
 * <pre>
 * <code>
 * try (AcceleratorTypeClient acceleratorTypeClient = AcceleratorTypeClient.create()) {
 *   ProjectZoneAcceleratorTypeName acceleratorType = ProjectZoneAcceleratorTypeName.of("[PROJECT]", "[ZONE]", "[ACCELERATOR_TYPE]");
 *   AcceleratorType response = acceleratorTypeClient.getAcceleratorType(acceleratorType);
 * }
 * </code>
 * </pre>
 *
 * =============
 * AddressClient
 * =============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for AddressClient:
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
 * ================
 * AutoscalerClient
 * ================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for AutoscalerClient:
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
 * ===================
 * BackendBucketClient
 * ===================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for BackendBucketClient:
 * <pre>
 * <code>
 * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
 *   ProjectBackendBucketName backendBucket = ProjectBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
 *   String requestId = "";
 *   Operation response = backendBucketClient.deleteBackendBucket(backendBucket, requestId);
 * }
 * </code>
 * </pre>
 *
 * ====================
 * BackendServiceClient
 * ====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for BackendServiceClient:
 * <pre>
 * <code>
 * try (BackendServiceClient backendServiceClient = BackendServiceClient.create()) {
 *   String requestId = "";
 *   ProjectBackendServiceName backendService = ProjectBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
 *   Operation response = backendServiceClient.deleteBackendService(requestId, backendService);
 * }
 * </code>
 * </pre>
 *
 * ==============
 * DiskTypeClient
 * ==============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for DiskTypeClient:
 * <pre>
 * <code>
 * try (DiskTypeClient diskTypeClient = DiskTypeClient.create()) {
 *   ProjectZoneDiskTypeName diskType = ProjectZoneDiskTypeName.of("[PROJECT]", "[ZONE]", "[DISK_TYPE]");
 *   DiskType response = diskTypeClient.getDiskType(diskType);
 * }
 * </code>
 * </pre>
 *
 * ==========
 * DiskClient
 * ==========
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for DiskClient:
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
 * ==============
 * FirewallClient
 * ==============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for FirewallClient:
 * <pre>
 * <code>
 * try (FirewallClient firewallClient = FirewallClient.create()) {
 *   ProjectFirewallName firewall = ProjectFirewallName.of("[PROJECT]", "[FIREWALL]");
 *   String requestId = "";
 *   Operation response = firewallClient.deleteFirewall(firewall, requestId);
 * }
 * </code>
 * </pre>
 *
 * ====================
 * ForwardingRuleClient
 * ====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for ForwardingRuleClient:
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
 * ===================
 * GlobalAddressClient
 * ===================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for GlobalAddressClient:
 * <pre>
 * <code>
 * try (GlobalAddressClient globalAddressClient = GlobalAddressClient.create()) {
 *   ProjectAddressName address = ProjectAddressName.of("[PROJECT]", "[ADDRESS]");
 *   String requestId = "";
 *   Operation response = globalAddressClient.deleteGlobalAddress(address, requestId);
 * }
 * </code>
 * </pre>
 *
 * ==========================
 * GlobalForwardingRuleClient
 * ==========================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for GlobalForwardingRuleClient:
 * <pre>
 * <code>
 * try (GlobalForwardingRuleClient globalForwardingRuleClient = GlobalForwardingRuleClient.create()) {
 *   String requestId = "";
 *   ProjectForwardingRuleName forwardingRule = ProjectForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
 *   Operation response = globalForwardingRuleClient.deleteGlobalForwardingRule(requestId, forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * =====================
 * GlobalOperationClient
 * =====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for GlobalOperationClient:
 * <pre>
 * <code>
 * try (GlobalOperationClient globalOperationClient = GlobalOperationClient.create()) {
 *   ProjectOperationName operation = ProjectOperationName.of("[PROJECT]", "[OPERATION]");
 *   globalOperationClient.deleteGlobalOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * =================
 * HealthCheckClient
 * =================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for HealthCheckClient:
 * <pre>
 * <code>
 * try (HealthCheckClient healthCheckClient = HealthCheckClient.create()) {
 *   String requestId = "";
 *   ProjectHealthCheckName healthCheck = ProjectHealthCheckName.of("[PROJECT]", "[HEALTH_CHECK]");
 *   Operation response = healthCheckClient.deleteHealthCheck(requestId, healthCheck);
 * }
 * </code>
 * </pre>
 *
 * =====================
 * HttpHealthCheckClient
 * =====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for HttpHealthCheckClient:
 * <pre>
 * <code>
 * try (HttpHealthCheckClient httpHealthCheckClient = HttpHealthCheckClient.create()) {
 *   String requestId = "";
 *   ProjectHttpHealthCheckName httpHealthCheck = ProjectHttpHealthCheckName.of("[PROJECT]", "[HTTP_HEALTH_CHECK]");
 *   Operation response = httpHealthCheckClient.deleteHttpHealthCheck(requestId, httpHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * ======================
 * HttpsHealthCheckClient
 * ======================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for HttpsHealthCheckClient:
 * <pre>
 * <code>
 * try (HttpsHealthCheckClient httpsHealthCheckClient = HttpsHealthCheckClient.create()) {
 *   ProjectHttpsHealthCheckName httpsHealthCheck = ProjectHttpsHealthCheckName.of("[PROJECT]", "[HTTPS_HEALTH_CHECK]");
 *   String requestId = "";
 *   Operation response = httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck, requestId);
 * }
 * </code>
 * </pre>
 *
 * ===========
 * ImageClient
 * ===========
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for ImageClient:
 * <pre>
 * <code>
 * try (ImageClient imageClient = ImageClient.create()) {
 *   ProjectImageName image = ProjectImageName.of("[PROJECT]", "[IMAGE]");
 *   String requestId = "";
 *   Operation response = imageClient.deleteImage(image, requestId);
 * }
 * </code>
 * </pre>
 *
 * ==========================
 * InstanceGroupManagerClient
 * ==========================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InstanceGroupManagerClient:
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
 * ===================
 * InstanceGroupClient
 * ===================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InstanceGroupClient:
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
 * ======================
 * InstanceTemplateClient
 * ======================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InstanceTemplateClient:
 * <pre>
 * <code>
 * try (InstanceTemplateClient instanceTemplateClient = InstanceTemplateClient.create()) {
 *   ProjectInstanceTemplateName instanceTemplate = ProjectInstanceTemplateName.of("[PROJECT]", "[INSTANCE_TEMPLATE]");
 *   String requestId = "";
 *   Operation response = instanceTemplateClient.deleteInstanceTemplate(instanceTemplate, requestId);
 * }
 * </code>
 * </pre>
 *
 * ==============
 * InstanceClient
 * ==============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InstanceClient:
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
 * ============================
 * InterconnectAttachmentClient
 * ============================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InterconnectAttachmentClient:
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
 * ==========================
 * InterconnectLocationClient
 * ==========================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InterconnectLocationClient:
 * <pre>
 * <code>
 * try (InterconnectLocationClient interconnectLocationClient = InterconnectLocationClient.create()) {
 *   ProjectInterconnectLocationName interconnectLocation = ProjectInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");
 *   InterconnectLocation response = interconnectLocationClient.getInterconnectLocation(interconnectLocation);
 * }
 * </code>
 * </pre>
 *
 * ==================
 * InterconnectClient
 * ==================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for InterconnectClient:
 * <pre>
 * <code>
 * try (InterconnectClient interconnectClient = InterconnectClient.create()) {
 *   String requestId = "";
 *   ProjectInterconnectName interconnect = ProjectInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
 *   Operation response = interconnectClient.deleteInterconnect(requestId, interconnect);
 * }
 * </code>
 * </pre>
 *
 * =============
 * LicenseClient
 * =============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for LicenseClient:
 * <pre>
 * <code>
 * try (LicenseClient licenseClient = LicenseClient.create()) {
 *   ProjectLicenseName license = ProjectLicenseName.of("[PROJECT]", "[LICENSE]");
 *   License response = licenseClient.getLicense(license);
 * }
 * </code>
 * </pre>
 *
 * =================
 * MachineTypeClient
 * =================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for MachineTypeClient:
 * <pre>
 * <code>
 * try (MachineTypeClient machineTypeClient = MachineTypeClient.create()) {
 *   ProjectZoneMachineTypeName machineType = ProjectZoneMachineTypeName.of("[PROJECT]", "[ZONE]", "[MACHINE_TYPE]");
 *   MachineType response = machineTypeClient.getMachineType(machineType);
 * }
 * </code>
 * </pre>
 *
 * =============
 * NetworkClient
 * =============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for NetworkClient:
 * <pre>
 * <code>
 * try (NetworkClient networkClient = NetworkClient.create()) {
 *   String requestId = "";
 *   ProjectNetworkName network = ProjectNetworkName.of("[PROJECT]", "[NETWORK]");
 *   NetworksAddPeeringRequest networksAddPeeringRequestResource = NetworksAddPeeringRequest.newBuilder().build();
 *   Operation response = networkClient.addPeeringNetwork(requestId, network, networksAddPeeringRequestResource);
 * }
 * </code>
 * </pre>
 *
 * =============
 * ProjectClient
 * =============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for ProjectClient:
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
 * ======================
 * RegionAutoscalerClient
 * ======================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionAutoscalerClient:
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
 * ==========================
 * RegionBackendServiceClient
 * ==========================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionBackendServiceClient:
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
 * ======================
 * RegionCommitmentClient
 * ======================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionCommitmentClient:
 * <pre>
 * <code>
 * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
 *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
 *   Commitment response = regionCommitmentClient.getRegionCommitment(commitment);
 * }
 * </code>
 * </pre>
 *
 * ================================
 * RegionInstanceGroupManagerClient
 * ================================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionInstanceGroupManagerClient:
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
 * =========================
 * RegionInstanceGroupClient
 * =========================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionInstanceGroupClient:
 * <pre>
 * <code>
 * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
 *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
 *   InstanceGroup response = regionInstanceGroupClient.getRegionInstanceGroup(instanceGroup);
 * }
 * </code>
 * </pre>
 *
 * =====================
 * RegionOperationClient
 * =====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionOperationClient:
 * <pre>
 * <code>
 * try (RegionOperationClient regionOperationClient = RegionOperationClient.create()) {
 *   ProjectRegionOperationName operation = ProjectRegionOperationName.of("[PROJECT]", "[REGION]", "[OPERATION]");
 *   regionOperationClient.deleteRegionOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * ============
 * RegionClient
 * ============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RegionClient:
 * <pre>
 * <code>
 * try (RegionClient regionClient = RegionClient.create()) {
 *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
 *   Region response = regionClient.getRegion(region);
 * }
 * </code>
 * </pre>
 *
 * ============
 * RouterClient
 * ============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RouterClient:
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
 * ===========
 * RouteClient
 * ===========
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for RouteClient:
 * <pre>
 * <code>
 * try (RouteClient routeClient = RouteClient.create()) {
 *   ProjectRouteName route = ProjectRouteName.of("[PROJECT]", "[ROUTE]");
 *   String requestId = "";
 *   Operation response = routeClient.deleteRoute(route, requestId);
 * }
 * </code>
 * </pre>
 *
 * ==============
 * SnapshotClient
 * ==============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for SnapshotClient:
 * <pre>
 * <code>
 * try (SnapshotClient snapshotClient = SnapshotClient.create()) {
 *   String requestId = "";
 *   ProjectSnapshotName snapshot = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
 *   Operation response = snapshotClient.deleteSnapshot(requestId, snapshot);
 * }
 * </code>
 * </pre>
 *
 * ====================
 * SslCertificateClient
 * ====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for SslCertificateClient:
 * <pre>
 * <code>
 * try (SslCertificateClient sslCertificateClient = SslCertificateClient.create()) {
 *   ProjectSslCertificateName sslCertificate = ProjectSslCertificateName.of("[PROJECT]", "[SSL_CERTIFICATE]");
 *   String requestId = "";
 *   Operation response = sslCertificateClient.deleteSslCertificate(sslCertificate, requestId);
 * }
 * </code>
 * </pre>
 *
 * ================
 * SubnetworkClient
 * ================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for SubnetworkClient:
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
 * =====================
 * TargetHttpProxyClient
 * =====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetHttpProxyClient:
 * <pre>
 * <code>
 * try (TargetHttpProxyClient targetHttpProxyClient = TargetHttpProxyClient.create()) {
 *   String requestId = "";
 *   ProjectTargetHttpProxyName targetHttpProxy = ProjectTargetHttpProxyName.of("[PROJECT]", "[TARGET_HTTP_PROXY]");
 *   Operation response = targetHttpProxyClient.deleteTargetHttpProxy(requestId, targetHttpProxy);
 * }
 * </code>
 * </pre>
 *
 * ======================
 * TargetHttpsProxyClient
 * ======================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetHttpsProxyClient:
 * <pre>
 * <code>
 * try (TargetHttpsProxyClient targetHttpsProxyClient = TargetHttpsProxyClient.create()) {
 *   ProjectTargetHttpsProxyName targetHttpsProxy = ProjectTargetHttpsProxyName.of("[PROJECT]", "[TARGET_HTTPS_PROXY]");
 *   String requestId = "";
 *   Operation response = targetHttpsProxyClient.deleteTargetHttpsProxy(targetHttpsProxy, requestId);
 * }
 * </code>
 * </pre>
 *
 * ====================
 * TargetInstanceClient
 * ====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetInstanceClient:
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
 * ================
 * TargetPoolClient
 * ================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetPoolClient:
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
 * ====================
 * TargetSslProxyClient
 * ====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetSslProxyClient:
 * <pre>
 * <code>
 * try (TargetSslProxyClient targetSslProxyClient = TargetSslProxyClient.create()) {
 *   ProjectTargetSslProxyName targetSslProxy = ProjectTargetSslProxyName.of("[PROJECT]", "[TARGET_SSL_PROXY]");
 *   String requestId = "";
 *   Operation response = targetSslProxyClient.deleteTargetSslProxy(targetSslProxy, requestId);
 * }
 * </code>
 * </pre>
 *
 * ====================
 * TargetTcpProxyClient
 * ====================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetTcpProxyClient:
 * <pre>
 * <code>
 * try (TargetTcpProxyClient targetTcpProxyClient = TargetTcpProxyClient.create()) {
 *   String requestId = "";
 *   ProjectTargetTcpProxyName targetTcpProxy = ProjectTargetTcpProxyName.of("[PROJECT]", "[TARGET_TCP_PROXY]");
 *   Operation response = targetTcpProxyClient.deleteTargetTcpProxy(requestId, targetTcpProxy);
 * }
 * </code>
 * </pre>
 *
 * ======================
 * TargetVpnGatewayClient
 * ======================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for TargetVpnGatewayClient:
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
 * ============
 * UrlMapClient
 * ============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for UrlMapClient:
 * <pre>
 * <code>
 * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
 *   ProjectUrlMapName urlMap = ProjectUrlMapName.of("[PROJECT]", "[URL_MAP]");
 *   String requestId = "";
 *   Operation response = urlMapClient.deleteUrlMap(urlMap, requestId);
 * }
 * </code>
 * </pre>
 *
 * ===============
 * VpnTunnelClient
 * ===============
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for VpnTunnelClient:
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
 * ===================
 * ZoneOperationClient
 * ===================
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for ZoneOperationClient:
 * <pre>
 * <code>
 * try (ZoneOperationClient zoneOperationClient = ZoneOperationClient.create()) {
 *   ProjectZoneOperationName operation = ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");
 *   zoneOperationClient.deleteZoneOperation(operation);
 * }
 * </code>
 * </pre>
 *
 * ==========
 * ZoneClient
 * ==========
 *
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * Sample for ZoneClient:
 * <pre>
 * <code>
 * try (ZoneClient zoneClient = ZoneClient.create()) {
 *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
 *   Zone response = zoneClient.getZone(zone);
 * }
 * </code>
 * </pre>
 *
 */

package com.google.cloud.compute.v1;