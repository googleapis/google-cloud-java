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
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.v1.AcceleratorType;
import com.google.cloud.compute.v1.AcceleratorTypeClient;
import com.google.cloud.compute.v1.AcceleratorTypeSettings;
import com.google.cloud.compute.v1.AcceleratorTypesScopedList;
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressClient;
import com.google.cloud.compute.v1.AddressSettings;
import com.google.cloud.compute.v1.AddressesScopedList;
import com.google.cloud.compute.v1.Allowed;
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.AttachedDiskInitializeParams;
import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.AutoscalerClient;
import com.google.cloud.compute.v1.AutoscalerSettings;
import com.google.cloud.compute.v1.AutoscalersScopedList;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketClient;
import com.google.cloud.compute.v1.BackendBucketSettings;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.CreateSnapshotDiskHttpRequest;
import com.google.cloud.compute.v1.DeprecationStatus;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskClient;
import com.google.cloud.compute.v1.DiskSettings;
import com.google.cloud.compute.v1.DiskType;
import com.google.cloud.compute.v1.DiskTypeClient;
import com.google.cloud.compute.v1.DiskTypeClient.AggregatedListDiskTypesPagedResponse;
import com.google.cloud.compute.v1.DiskTypeSettings;
import com.google.cloud.compute.v1.DiskTypesScopedList;
import com.google.cloud.compute.v1.DisksAddResourcePoliciesRequest;
import com.google.cloud.compute.v1.DisksRemoveResourcePoliciesRequest;
import com.google.cloud.compute.v1.DisksResizeRequest;
import com.google.cloud.compute.v1.DisksScopedList;
import com.google.cloud.compute.v1.ExternalVpnGateway;
import com.google.cloud.compute.v1.ExternalVpnGatewayClient;
import com.google.cloud.compute.v1.ExternalVpnGatewayInterface;
import com.google.cloud.compute.v1.ExternalVpnGatewaySettings;
import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallClient;
import com.google.cloud.compute.v1.FirewallSettings;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleClient;
import com.google.cloud.compute.v1.ForwardingRuleSettings;
import com.google.cloud.compute.v1.ForwardingRulesScopedList;
import com.google.cloud.compute.v1.GetHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GlobalAddressClient;
import com.google.cloud.compute.v1.GlobalAddressSettings;
import com.google.cloud.compute.v1.GlobalForwardingRuleClient;
import com.google.cloud.compute.v1.GlobalForwardingRuleSettings;
import com.google.cloud.compute.v1.GlobalOperationClient;
import com.google.cloud.compute.v1.GlobalOperationSettings;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckClient;
import com.google.cloud.compute.v1.HealthCheckSettings;
import com.google.cloud.compute.v1.HealthChecksScopedList;
import com.google.cloud.compute.v1.HttpHealthCheck2;
import com.google.cloud.compute.v1.HttpHealthCheckClient;
import com.google.cloud.compute.v1.HttpHealthCheckSettings;
import com.google.cloud.compute.v1.HttpsHealthCheck2;
import com.google.cloud.compute.v1.HttpsHealthCheckClient;
import com.google.cloud.compute.v1.HttpsHealthCheckSettings;
import com.google.cloud.compute.v1.Image;
import com.google.cloud.compute.v1.ImageClient;
import com.google.cloud.compute.v1.ImageSettings;
import com.google.cloud.compute.v1.InsertHealthCheckHttpRequest;
import com.google.cloud.compute.v1.InsertTargetPoolHttpRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceClient;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupClient;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagerClient;
import com.google.cloud.compute.v1.InstanceGroupManagerSettings;
import com.google.cloud.compute.v1.InstanceGroupManagersScopedList;
import com.google.cloud.compute.v1.InstanceGroupSettings;
import com.google.cloud.compute.v1.InstanceGroupsListInstancesRequest;
import com.google.cloud.compute.v1.InstanceGroupsScopedList;
import com.google.cloud.compute.v1.InstanceGroupsSetNamedPortsRequest;
import com.google.cloud.compute.v1.InstanceSettings;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplateClient;
import com.google.cloud.compute.v1.InstanceTemplateSettings;
import com.google.cloud.compute.v1.InstanceWithNamedPorts;
import com.google.cloud.compute.v1.Interconnect;
import com.google.cloud.compute.v1.InterconnectAttachment;
import com.google.cloud.compute.v1.InterconnectAttachmentClient;
import com.google.cloud.compute.v1.InterconnectAttachmentSettings;
import com.google.cloud.compute.v1.InterconnectClient;
import com.google.cloud.compute.v1.InterconnectLocation;
import com.google.cloud.compute.v1.InterconnectLocationClient;
import com.google.cloud.compute.v1.InterconnectLocationSettings;
import com.google.cloud.compute.v1.InterconnectSettings;
import com.google.cloud.compute.v1.License;
import com.google.cloud.compute.v1.LicenseClient;
import com.google.cloud.compute.v1.LicenseSettings;
import com.google.cloud.compute.v1.ListDiskTypesHttpRequest;
import com.google.cloud.compute.v1.MachineType;
import com.google.cloud.compute.v1.MachineTypeClient;
import com.google.cloud.compute.v1.MachineTypeSettings;
import com.google.cloud.compute.v1.MachineTypesScopedList;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkClient;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupClient;
import com.google.cloud.compute.v1.NetworkEndpointGroupSettings;
import com.google.cloud.compute.v1.NetworkSettings;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupClient;
import com.google.cloud.compute.v1.NodeGroupSettings;
import com.google.cloud.compute.v1.NodeGroupsScopedList;
import com.google.cloud.compute.v1.NodeTemplate;
import com.google.cloud.compute.v1.NodeTemplateClient;
import com.google.cloud.compute.v1.NodeTemplateSettings;
import com.google.cloud.compute.v1.NodeTemplatesScopedList;
import com.google.cloud.compute.v1.NodeType;
import com.google.cloud.compute.v1.NodeTypeClient;
import com.google.cloud.compute.v1.NodeTypeSettings;
import com.google.cloud.compute.v1.NodeTypesScopedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationsScopedList;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectClient;
import com.google.cloud.compute.v1.ProjectGlobalBackendBucketName;
import com.google.cloud.compute.v1.ProjectGlobalFirewallName;
import com.google.cloud.compute.v1.ProjectGlobalHttpHealthCheckName;
import com.google.cloud.compute.v1.ProjectGlobalHttpsHealthCheckName;
import com.google.cloud.compute.v1.ProjectGlobalImageName;
import com.google.cloud.compute.v1.ProjectGlobalImageResourceName;
import com.google.cloud.compute.v1.ProjectGlobalLicenseName;
import com.google.cloud.compute.v1.ProjectGlobalLicenseResourceName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionAddressName;
import com.google.cloud.compute.v1.ProjectRegionDiskTypeName;
import com.google.cloud.compute.v1.ProjectRegionForwardingRuleName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionTargetPoolName;
import com.google.cloud.compute.v1.ProjectSettings;
import com.google.cloud.compute.v1.ProjectZoneDiskName;
import com.google.cloud.compute.v1.ProjectZoneDiskResourceName;
import com.google.cloud.compute.v1.ProjectZoneDiskTypeName;
import com.google.cloud.compute.v1.ProjectZoneInstanceGroupName;
import com.google.cloud.compute.v1.ProjectZoneMachineTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.Region;
import com.google.cloud.compute.v1.RegionAutoscalerClient;
import com.google.cloud.compute.v1.RegionAutoscalerSettings;
import com.google.cloud.compute.v1.RegionBackendServiceClient;
import com.google.cloud.compute.v1.RegionBackendServiceSettings;
import com.google.cloud.compute.v1.RegionClient;
import com.google.cloud.compute.v1.RegionCommitmentClient;
import com.google.cloud.compute.v1.RegionCommitmentSettings;
import com.google.cloud.compute.v1.RegionDiskClient;
import com.google.cloud.compute.v1.RegionDiskSettings;
import com.google.cloud.compute.v1.RegionSettings;
import com.google.cloud.compute.v1.SetBackupTargetPoolHttpRequest;
import com.google.cloud.compute.v1.Snapshot;
import com.google.cloud.compute.v1.TCPHealthCheck;
import com.google.cloud.compute.v1.TargetHttpProxiesScopedList;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyClient;
import com.google.cloud.compute.v1.TargetHttpProxySettings;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyClient;
import com.google.cloud.compute.v1.TargetHttpsProxySettings;
import com.google.cloud.compute.v1.TargetInstance;
import com.google.cloud.compute.v1.TargetInstanceClient;
import com.google.cloud.compute.v1.TargetInstanceSettings;
import com.google.cloud.compute.v1.TargetInstancesScopedList;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolClient;
import com.google.cloud.compute.v1.TargetPoolSettings;
import com.google.cloud.compute.v1.TargetPoolsAddHealthCheckRequest;
import com.google.cloud.compute.v1.TargetPoolsAddInstanceRequest;
import com.google.cloud.compute.v1.TargetPoolsScopedList;
import com.google.cloud.compute.v1.TargetReference;
import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyClient;
import com.google.cloud.compute.v1.TargetSslProxySettings;
import com.google.cloud.compute.v1.TargetTcpProxy;
import com.google.cloud.compute.v1.TargetTcpProxyClient;
import com.google.cloud.compute.v1.TargetTcpProxySettings;
import com.google.cloud.compute.v1.TargetVpnGateway;
import com.google.cloud.compute.v1.TargetVpnGatewayClient;
import com.google.cloud.compute.v1.TargetVpnGatewaySettings;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapClient;
import com.google.cloud.compute.v1.UrlMapSettings;
import com.google.cloud.compute.v1.UrlMapsScopedList;
import com.google.cloud.compute.v1.VpnGateway;
import com.google.cloud.compute.v1.VpnGatewayClient;
import com.google.cloud.compute.v1.VpnGatewaySettings;
import com.google.cloud.compute.v1.VpnTunnel;
import com.google.cloud.compute.v1.VpnTunnelClient;
import com.google.cloud.compute.v1.VpnTunnelSettings;
import com.google.cloud.compute.v1.Zone;
import com.google.cloud.compute.v1.ZoneClient;
import com.google.cloud.compute.v1.ZoneSettings;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITComputeTest {

  private static AcceleratorTypeClient acceleratorTypeClient;
  private static AcceleratorTypeSettings acceleratorTypeSettings;

  private static AddressClient addressClient;
  private static AddressSettings addressSettings;

  private static AutoscalerClient autoscalerClient;
  private static AutoscalerSettings autoscalerSettings;

  private static BackendBucketClient backendBucketClient;
  private static BackendBucketSettings backendBucketSettings;

  private static DiskClient diskClient;
  private static DiskSettings diskSettings;

  private static DiskTypeClient diskTypeClient;
  private static DiskTypeSettings diskTypeSettings;

  private static ExternalVpnGatewayClient externalVpnGatewayClient;
  private static ExternalVpnGatewaySettings externalVpnGatewaySettings;

  private static FirewallClient firewallClient;
  private static FirewallSettings firewallSettings;

  private static ForwardingRuleClient forwardingRuleClient;
  private static ForwardingRuleSettings forwardingRuleSettings;

  private static GlobalAddressClient globalAddressClient;
  private static GlobalAddressSettings globalAddressSettings;

  private static GlobalForwardingRuleClient globalForwardingRuleClient;
  private static GlobalForwardingRuleSettings globalForwardingRuleSettings;

  private static GlobalOperationClient globalOperationClient;
  private static GlobalOperationSettings globalOperationSettings;

  private static HealthCheckClient healthCheckClient;
  private static HealthCheckSettings healthCheckSettings;

  private static HttpHealthCheckClient httpHealthCheckClient;
  private static HttpHealthCheckSettings httpHealthCheckSettings;

  private static HttpsHealthCheckClient httpsHealthCheckClient;
  private static HttpsHealthCheckSettings httpsHealthCheckSettings;

  private static ImageClient imageClient;
  private static ImageSettings imageSettings;

  private static InstanceClient instanceClient;
  private static InstanceSettings instanceSettings;

  private static InstanceGroupClient instanceGroupClient;
  private static InstanceGroupSettings instanceGroupSettings;

  private static InstanceGroupManagerClient instanceGroupManagerClient;
  private static InstanceGroupManagerSettings instanceGroupManagerSettings;

  private static InstanceTemplateClient instanceTemplateClient;
  private static InstanceTemplateSettings instanceTemplateSettings;

  private static InterconnectAttachmentClient interconnectAttachmentClient;
  private static InterconnectAttachmentSettings interconnectAttachmentSettings;

  private static InterconnectClient interconnectClient;
  private static InterconnectSettings interconnectSettings;

  private static InterconnectLocationClient interconnectLocationClient;
  private static InterconnectLocationSettings interconnectLocationSettings;

  private static LicenseClient licenseClient;
  private static LicenseSettings licenseSettings;

  private static MachineTypeClient machineTypeClient;
  private static MachineTypeSettings machineTypeSettings;

  private static NetworkClient networkClient;
  private static NetworkSettings networkSettings;

  private static NetworkEndpointGroupClient networkEndpointGroupClient;
  private static NetworkEndpointGroupSettings networkEndpointGroupSettings;

  private static NodeGroupClient nodeGroupClient;
  private static NodeGroupSettings nodeGroupSettings;

  private static NodeTemplateClient nodeTemplateClient;
  private static NodeTemplateSettings nodeTemplateSettings;

  private static NodeTypeClient nodeTypeClient;
  private static NodeTypeSettings nodeTypeSettings;

  private static ProjectClient projectClient;
  private static ProjectSettings projectSettings;

  private static RegionAutoscalerClient regionAutoscalerClient;
  private static RegionAutoscalerSettings regionAutoscalerSettings;

  private static RegionBackendServiceClient regionBackendServiceClient;
  private static RegionBackendServiceSettings regionBackendServiceSettings;

  private static RegionClient regionClient;
  private static RegionSettings regionSettings;

  private static RegionCommitmentClient regionCommitmentClient;
  private static RegionCommitmentSettings regionCommitmentSettings;

  private static RegionDiskClient regionDiskClient;
  private static RegionDiskSettings regionDiskSettings;

  private static TargetHttpProxyClient targetHttpProxyClient;
  private static TargetHttpProxySettings targetHttpProxySettings;

  private static TargetHttpsProxyClient targetHttpsProxyClient;
  private static TargetHttpsProxySettings targetHttpsProxySettings;

  private static TargetInstanceClient targetInstanceClient;
  private static TargetInstanceSettings targetInstanceSettings;

  private static TargetPoolClient targetPoolClient;
  private static TargetPoolSettings targetPoolSettings;

  private static TargetSslProxyClient targetSslProxyClient;
  private static TargetSslProxySettings targetSslProxySettings;

  private static TargetTcpProxyClient targetTcpProxyClient;
  private static TargetTcpProxySettings targetTcpProxySettings;

  private static TargetVpnGatewayClient targetVpnGatewayClient;
  private static TargetVpnGatewaySettings targetVpnGatewaySettings;

  private static UrlMapClient urlMapClient;
  private static UrlMapSettings urlMapSettings;

  private static VpnGatewayClient vpnGatewayClient;
  private static VpnGatewaySettings vpnGatewaySettings;

  private static VpnTunnelClient vpnTunnelClient;
  private static VpnTunnelSettings vpnTunnelSettings;

  private static ZoneClient zoneClient;
  private static ZoneSettings zoneSettings;
  private static Storage storage;

  private static final Logger LOG = Logger.getLogger(ITComputeTest.class.getName());
  private static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String DEFAULT_IMAGE =
      "https://www.googleapis.com/compute/v1/projects/debian-cloud/global/images/debian-7-wheezy-v20150710";
  private static final String UID = UUID.randomUUID().toString();
  private static final String ZONE = "us-central1-a";
  private static final String DISK_TYPE = "local-ssd";
  private static final String REGION = "us-central1";
  private static final String PROJECT_LINK =
      String.format("https://www.googleapis.com/compute/v1/projects/%s", DEFAULT_PROJECT);
  private static final String REGION_LINK = String.format("%s/regions/%s", PROJECT_LINK, REGION);
  private static final String ZONE_SELF_LINK = String.format("%s/zones/%s", PROJECT_LINK, ZONE);
  private static final String STATUS = "UP";
  private static final String ID = UID.substring(0, 8);
  private static final String TARGET_POOL_NAME = "test-target-pool-" + ID;
  private static final String TARGET_POOL_SELF_LINK =
      String.format("%s/targetPools/%s", REGION_LINK, TARGET_POOL_NAME);
  private static final String SESSION_AFFINITY = "NONE";
  private static final String ADDRESS_NAME = "test-address-" + ID;
  private static final String ADDRESS_SELF_LINK =
      String.format("%s/addresses/%s", REGION_LINK, ADDRESS_NAME);
  private static final String GLOBAL_ADDRESS_LINK =
      String.format("%s/global/addresses/%s", PROJECT_LINK, ADDRESS_NAME);
  private static final String ADDRESS_TYPE = "EXTERNAL";
  private static final String ADDRESS_OPERATION_STATUS = "RESERVED";
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String BACKEND_BUCKET_NAME = "test-backend-bucket-" + ID;
  private static final String BACKEND_BUCKET_TARGET_LINK =
      String.format("%s/global/backendBuckets/%s", PROJECT_LINK, BACKEND_BUCKET_NAME);
  private static final String DISK_NAME = "test-disk-" + ID;
  private static final String DISK_SIZE = "1";
  private static final String DISK_SELF_LINK =
      String.format("%s/disks/%s", ZONE_SELF_LINK, DISK_NAME);
  private static final String EXTERNAL_VPN_GATEWAY_NAME = "external-test-vpn-gateway-" + ID;
  private static final String REDUNDANCY_TYPE = "SINGLE_IP_INTERNALLY_REDUNDANT";
  private static final String EXTERNAL_VPN_GATEWAY_DESCRIPTION = "ExternalVpnGateway";
  private static final String EXTERNAL_VPN_GATEWAY_TARGET_LINK =
      String.format("%s/global/externalVpnGateways/%s", PROJECT_LINK, EXTERNAL_VPN_GATEWAY_NAME);
  private static final List<ExternalVpnGatewayInterface> VPN_GATEWAY_INTERFACE =
      Arrays.asList(
          ExternalVpnGatewayInterface.newBuilder().setId(0).setIpAddress("8.8.8.8").build());
  private static final String FIREWALL_NAME = "firewall-test-" + ID;
  private static final String FIREWALL_DESCRIPTION = "firewall";
  private static final String DIRECTION = "INGRESS";
  private static final String IP_PROTOCOL = "TCP";
  private static final String FIREWALL_LINK =
      String.format("%s/global/firewalls/%s", PROJECT_LINK, FIREWALL_NAME);
  private static final int FIREWALL_PRIORITY = 1000;
  private static final List<Allowed> ALLOWEDS =
      Arrays.asList(Allowed.newBuilder().setIPProtocol(IP_PROTOCOL.toLowerCase()).build());
  private static final String FORWARDING_RULE_NAME = "forwarding-rule-us-east1-" + ID;
  private static final String FORWARDING_RULE_LINK =
      String.format("%s/forwardingRules/%s", REGION_LINK, FORWARDING_RULE_NAME);
  private static final String HEALTH_CHECK_NAME = "test-health-check-" + ID;
  private static final String HEALTH_CHECK_LINK =
      String.format("%s/global/healthChecks/%s", PROJECT_LINK, HEALTH_CHECK_NAME);
  private static final String HTTP_HEALTH_CHECK_2 = "test-http-health-check2-" + ID;
  private static final String HTTP_HEALTH_CHECK_LINK =
      String.format("%s/global/httpHealthChecks/%s", PROJECT_LINK, HTTP_HEALTH_CHECK_2);
  private static final String HTTPS_HEALTH_CHECK_2 = "test-https-health-check2-" + ID;
  private static final String HTTPS_HEALTH_CHECK_LINK =
      String.format("%s/global/httpsHealthChecks/%s", PROJECT_LINK, HTTPS_HEALTH_CHECK_2);
  private static final Integer PORT = 80;
  private static final Integer UNHEALTHY_THRESHOLD = 2;
  private static final String IMAGE_NAME = "test-image-" + ID;
  private static final String IMAGE_LINK =
      String.format("%s/global/images/%s", PROJECT_LINK, IMAGE_NAME);
  private static final String INSTANCE_GROUP = "test-instance-group-" + ID;
  private static final String INSTANCE_GROUP_LINK =
      String.format("%s/instanceGroups/%s", ZONE_SELF_LINK, INSTANCE_GROUP);
  private static final String LOCATION =
      String.format("%s/global/interconnectLocations/den-zone2-389", PROJECT_LINK);
  private static final String INTER_CONNECT = "test-inter-connect-" + ID;
  private static final String INTER_CONNECT_TYPE = "IT_PRIVATE";
  private static final String INTER_CONNECT_LINK_TYPE = "LINK_TYPE_ETHERNET_10G_LR";
  private static final Integer INTER_CONNECT_REQUESTED_LINK_COUNT = 1;
  private static final String INTER_CONNECT_LINK =
      String.format("%s/global/interconnects/%s", PROJECT_LINK, INTER_CONNECT);
  private static final String CUSTOMER_NAME = "customer";
  private static final String OPERATIONAL_STATUS = "OS_ACTIVE";
  private static final String LICENSE = "test-license-" + ID;
  private static final String LICENSE_LINK =
      String.format("%s/global/licenses/%s", PROJECT_LINK, LICENSE);
  private static final String MACHINE_TYPE = "n1-standard-1";
  private static final String MACHINE_TYPE_LINK =
      String.format("%s/machineTypes/%s", ZONE_SELF_LINK, MACHINE_TYPE);
  private static final String NETWORK_TIER = "PREMIUM";
  private static final String NETWORK = "test-network-" + ID;
  private static final ProjectName PROJECT_NAME = ProjectName.of(DEFAULT_PROJECT);
  private static final ProjectRegionTargetPoolName REGION_TARGET_POOL_NAME =
      ProjectRegionTargetPoolName.of(DEFAULT_PROJECT, REGION, TARGET_POOL_NAME);
  private static final ProjectRegionName PROJECT_REGION_NAME =
      ProjectRegionName.of(DEFAULT_PROJECT, REGION);
  private static final ProjectZoneName PROJECT_ZONE_NAME =
      ProjectZoneName.of(DEFAULT_PROJECT, ZONE);
  private static final ProjectZoneDiskName PROJECT_ZONE_DISK_NAME =
      ProjectZoneDiskName.of(DISK_NAME, DEFAULT_PROJECT, ZONE);
  private static final ProjectZoneDiskResourceName PROJECT_ZONE_DISK_RESOURCE_NAME =
      ProjectZoneDiskResourceName.of(DEFAULT_PROJECT, DISK_NAME, ZONE);
  private static final ProjectZoneInstanceGroupName INSTANCE_GROUP_NAME =
      ProjectZoneInstanceGroupName.of(INSTANCE_GROUP, DEFAULT_PROJECT, ZONE);
  private static final ProjectGlobalBackendBucketName PROJECT_BACKEND_BUCKET_NAME =
      ProjectGlobalBackendBucketName.of(BACKEND_BUCKET_NAME, DEFAULT_PROJECT);
  private static final ProjectGlobalFirewallName FIREWALL =
      ProjectGlobalFirewallName.of(FIREWALL_NAME, DEFAULT_PROJECT);
  private static final ProjectRegionForwardingRuleName PROJECT_REGION_FORWARDING_RULE_NAME =
      ProjectRegionForwardingRuleName.of(FORWARDING_RULE_NAME, DEFAULT_PROJECT, REGION);
  private static final ProjectGlobalHttpHealthCheckName HTTP_HEALTH_CHECK_NAME =
      ProjectGlobalHttpHealthCheckName.of(HTTP_HEALTH_CHECK_2, DEFAULT_PROJECT);
  private static final ProjectGlobalHttpsHealthCheckName HTTPS_HEALTH_CHECK_NAME =
      ProjectGlobalHttpsHealthCheckName.of(HTTPS_HEALTH_CHECK_2, DEFAULT_PROJECT);
  private static final ProjectGlobalImageName PROJECT_GLOBAL_IMAGE_NAME =
      ProjectGlobalImageName.of(IMAGE_NAME, DEFAULT_PROJECT);
  private static final ProjectGlobalImageResourceName IMAGE_RESOURCE_NAME =
      ProjectGlobalImageResourceName.of(DEFAULT_PROJECT, IMAGE_NAME);
  private static final ProjectGlobalLicenseName LICENSE_NAME =
      ProjectGlobalLicenseName.of(LICENSE, DEFAULT_PROJECT);
  private static final Address ADDRESS =
      Address.newBuilder()
          .setName(ADDRESS_NAME)
          .setNetworkTier(NETWORK_TIER)
          .setRegion(REGION_LINK)
          .build();
  private static final TCPHealthCheck TCP_HEALTH_CHECK =
      TCPHealthCheck.newBuilder().setPort(80).setProxyHeader("NONE").build();

  @Rule public Timeout globalTimeout = Timeout.seconds(1000);

  @BeforeClass
  public static void setUp() throws Exception {

    Credentials credentials =
        GoogleCredentials.getApplicationDefault()
            .createScoped(DiskTypeSettings.getDefaultServiceScopes());
    FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);

    /* create acceleratorTypeClient */
    acceleratorTypeSettings =
        AcceleratorTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    acceleratorTypeClient = AcceleratorTypeClient.create(acceleratorTypeSettings);

    /* create addressClient */
    addressSettings =
        AddressSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    addressClient = AddressClient.create(addressSettings);
    addressClient.insertAddress(PROJECT_REGION_NAME, ADDRESS);

    /* create autoscalerClient */
    autoscalerSettings =
        AutoscalerSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    autoscalerClient = AutoscalerClient.create(autoscalerSettings);

    /* create backendBucketClient */
    backendBucketSettings =
        BackendBucketSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    backendBucketClient = BackendBucketClient.create(backendBucketSettings);
    RemoteStorageHelper storageHelper = RemoteStorageHelper.create();
    storage = storageHelper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
    BackendBucket backendBucketResource =
        BackendBucket.newBuilder().setName(BACKEND_BUCKET_NAME).setBucketName(BUCKET).build();
    backendBucketClient.insertBackendBucket(PROJECT_NAME, backendBucketResource);

    /* create diskClient */
    diskSettings = DiskSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    diskClient = DiskClient.create(diskSettings);
    Disk diskResource =
        Disk.newBuilder().setName(DISK_NAME).setRegion(REGION_LINK).setSizeGb(DISK_SIZE).build();
    diskClient.insertDisk(PROJECT_ZONE_NAME, diskResource);

    /* create diskTypeClient */
    diskTypeSettings =
        DiskTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    diskTypeClient = DiskTypeClient.create(diskTypeSettings);

    /* create externalVpnGatewayClient */
    Thread.sleep(TimeUnit.MINUTES.toMillis(2));
    externalVpnGatewaySettings =
        ExternalVpnGatewaySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    externalVpnGatewayClient = ExternalVpnGatewayClient.create(externalVpnGatewaySettings);
    ExternalVpnGateway.Builder externalVpnGatewayResource =
        ExternalVpnGateway.newBuilder()
            .setName(EXTERNAL_VPN_GATEWAY_NAME)
            .setRedundancyType(REDUNDANCY_TYPE)
            .setDescription(EXTERNAL_VPN_GATEWAY_DESCRIPTION)
            .addAllInterfaces(VPN_GATEWAY_INTERFACE);
    externalVpnGatewayClient.insertExternalVpnGateway(
        PROJECT_NAME, externalVpnGatewayResource.build());

    /* create firewallClient */
    firewallSettings =
        FirewallSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    firewallClient = FirewallClient.create(firewallSettings);
    Firewall firewallResource =
        Firewall.newBuilder()
            .setName(FIREWALL_NAME)
            .setPriority(FIREWALL_PRIORITY)
            .setDescription(FIREWALL_DESCRIPTION)
            .addAllAllowed(ALLOWEDS)
            .build();
    firewallClient.insertFirewall(PROJECT_NAME, firewallResource);

    /* create targetPoolClient */
    targetPoolSettings =
        TargetPoolSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetPoolClient = TargetPoolClient.create(targetPoolSettings);
    TargetPool targetPool =
        TargetPool.newBuilder()
            .setName(TARGET_POOL_NAME)
            .setRegion(PROJECT_REGION_NAME.toString())
            .setSessionAffinity(SESSION_AFFINITY)
            .build();
    InsertTargetPoolHttpRequest request =
        InsertTargetPoolHttpRequest.newBuilder()
            .setTargetPoolResource(targetPool)
            .setRegion(PROJECT_REGION_NAME.toString())
            .setRequestId(UID)
            .build();
    ApiFuture<Operation> targetApiFuture =
        targetPoolClient.insertTargetPoolCallable().futureCall(request);

    /* create forwardingRuleClient */
    Thread.sleep(30000);
    forwardingRuleSettings =
        ForwardingRuleSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    forwardingRuleClient = ForwardingRuleClient.create(forwardingRuleSettings);
    ForwardingRule forwardingRule =
        ForwardingRule.newBuilder()
            .setName(FORWARDING_RULE_NAME)
            .setTarget(TARGET_POOL_SELF_LINK)
            .setIPProtocol(IP_PROTOCOL)
            .build();
    if (targetApiFuture.isDone()) {
      forwardingRuleClient.insertForwardingRule(PROJECT_REGION_NAME, forwardingRule);
    }

    /* create globalAddressClient */
    globalAddressSettings =
        GlobalAddressSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    globalAddressClient = GlobalAddressClient.create(globalAddressSettings);
    Address address =
        Address.newBuilder()
            .setName(ADDRESS_NAME)
            .setAddressType(ADDRESS_TYPE)
            .setRegion(PROJECT_REGION_NAME.toString())
            .build();
    globalAddressClient.insertGlobalAddress(PROJECT_NAME, address);
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));

    /* create globalForwardingRuleClient */
    globalForwardingRuleSettings =
        GlobalForwardingRuleSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    globalForwardingRuleClient = GlobalForwardingRuleClient.create(globalForwardingRuleSettings);

    /* create globalOperationClient */
    globalOperationSettings =
        GlobalOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    globalOperationClient = GlobalOperationClient.create(globalOperationSettings);

    /* create healthCheckClient */
    healthCheckSettings =
        HealthCheckSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    healthCheckClient = HealthCheckClient.create(healthCheckSettings);
    HealthCheck healthCheckResource =
        HealthCheck.newBuilder()
            .setName(HEALTH_CHECK_NAME)
            .setType(IP_PROTOCOL)
            .setTcpHealthCheck(TCP_HEALTH_CHECK)
            .setCheckIntervalSec(1)
            .setTimeoutSec(5)
            .setUnhealthyThreshold(UNHEALTHY_THRESHOLD)
            .build();
    InsertHealthCheckHttpRequest insertHealthCheckHttpRequest =
        InsertHealthCheckHttpRequest.newBuilder()
            .setProject(PROJECT_NAME.toString())
            .setHealthCheckResource(healthCheckResource)
            .build();
    ApiFuture<Operation> insertHealthCheckFuture =
        healthCheckClient.insertHealthCheckCallable().futureCall(insertHealthCheckHttpRequest);

    /* create httpHealthCheckClient */
    httpHealthCheckSettings =
        HttpHealthCheckSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    httpHealthCheckClient = HttpHealthCheckClient.create(httpHealthCheckSettings);
    HttpHealthCheck2 httpHealthCheckResource =
        HttpHealthCheck2.newBuilder()
            .setName(HTTP_HEALTH_CHECK_2)
            .setPort(PORT)
            .setUnhealthyThreshold(UNHEALTHY_THRESHOLD)
            .build();
    httpHealthCheckClient.insertHttpHealthCheck(PROJECT_NAME, httpHealthCheckResource);
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));

    /* create httpsHealthCheckClient */
    httpsHealthCheckSettings =
        HttpsHealthCheckSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    httpsHealthCheckClient = HttpsHealthCheckClient.create(httpsHealthCheckSettings);
    HttpsHealthCheck2 httpsHealthCheckResource =
        HttpsHealthCheck2.newBuilder()
            .setName(HTTPS_HEALTH_CHECK_2)
            .setPort(PORT)
            .setHealthyThreshold(UNHEALTHY_THRESHOLD)
            .build();
    httpsHealthCheckClient.insertHttpsHealthCheck(PROJECT_NAME, httpsHealthCheckResource);
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));

    /* create imageClient */
    imageSettings = ImageSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    imageClient = ImageClient.create(imageSettings);
    Image imageResource =
        Image.newBuilder().setName(IMAGE_NAME).setSourceDisk(DISK_SELF_LINK).build();
    imageClient.insertImage(Boolean.TRUE, PROJECT_NAME, imageResource);

    /* create instanceClient */
    instanceSettings =
        InstanceSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    instanceClient = InstanceClient.create(instanceSettings);

    /* create instanceGroupClient */
    instanceGroupSettings =
        InstanceGroupSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    instanceGroupClient = InstanceGroupClient.create(instanceGroupSettings);
    InstanceGroup instanceGroupResource =
        InstanceGroup.newBuilder().setName(INSTANCE_GROUP).build();
    instanceGroupClient.insertInstanceGroup(PROJECT_ZONE_NAME, instanceGroupResource);

    /* create instanceTemplateClient */
    instanceTemplateSettings =
        InstanceTemplateSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    instanceTemplateClient = InstanceTemplateClient.create(instanceTemplateSettings);

    /* create instanceGroupManagerClient */
    instanceGroupManagerSettings =
        InstanceGroupManagerSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    instanceGroupManagerClient = InstanceGroupManagerClient.create(instanceGroupManagerSettings);

    /* create interconnectAttachmentClient */
    interconnectAttachmentSettings =
        InterconnectAttachmentSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    interconnectAttachmentClient =
        InterconnectAttachmentClient.create(interconnectAttachmentSettings);

    /* create interconnectClient */
    interconnectSettings =
        InterconnectSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    interconnectClient = InterconnectClient.create(interconnectSettings);
    Interconnect interconnectResource =
        Interconnect.newBuilder()
            .setName(INTER_CONNECT)
            .setInterconnectType(INTER_CONNECT_TYPE)
            .setLinkType(INTER_CONNECT_LINK_TYPE)
            .setRequestedLinkCount(INTER_CONNECT_REQUESTED_LINK_COUNT)
            .setAdminEnabled(Boolean.TRUE)
            .setCustomerName(CUSTOMER_NAME)
            .setOperationalStatus(OPERATIONAL_STATUS)
            .setLocation(LOCATION)
            .build();
    interconnectClient.insertInterconnect(PROJECT_NAME, interconnectResource);
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));

    /* create interconnectLocationClient */
    interconnectLocationSettings =
        InterconnectLocationSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    interconnectLocationClient = InterconnectLocationClient.create(interconnectLocationSettings);

    /* create licenseClient */
    licenseSettings =
        LicenseSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    licenseClient = LicenseClient.create(licenseSettings);
    License license = License.newBuilder().setName(LICENSE).build();
    licenseClient.insertLicense(PROJECT_NAME, license);

    /* create machineTypeClient */
    machineTypeSettings =
        MachineTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    machineTypeClient = MachineTypeClient.create(machineTypeSettings);

    /* create networkClient */
    networkSettings =
        NetworkSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    networkClient = NetworkClient.create(networkSettings);
    Network networkResource = Network.newBuilder().setName(NETWORK).build();
    networkClient.insertNetwork(PROJECT_NAME, networkResource);
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));

    /* create networkEndpointGroupClient */
    networkEndpointGroupSettings =
        NetworkEndpointGroupSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    networkEndpointGroupClient = NetworkEndpointGroupClient.create(networkEndpointGroupSettings);

    /* create nodeTypeClient */
    nodeTypeSettings =
        NodeTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    nodeTypeClient = NodeTypeClient.create(nodeTypeSettings);

    /* create nodeTemplateClient */
    nodeTemplateSettings =
        NodeTemplateSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    nodeTemplateClient = NodeTemplateClient.create(nodeTemplateSettings);

    /* create nodeGroupClient */
    nodeGroupSettings =
        NodeGroupSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    nodeGroupClient = NodeGroupClient.create(nodeGroupSettings);

    /* create projectClient */
    projectSettings =
        ProjectSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    projectClient = ProjectClient.create(projectSettings);

    /* create regionAutoscalerClient */
    regionAutoscalerSettings =
        RegionAutoscalerSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionAutoscalerClient = RegionAutoscalerClient.create(regionAutoscalerSettings);

    /* create regionClient */
    regionSettings =
        RegionSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionClient = RegionClient.create(regionSettings);

    /* create regionBackendServiceClient */
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));
    regionBackendServiceSettings =
        RegionBackendServiceSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    regionBackendServiceClient = RegionBackendServiceClient.create(regionBackendServiceSettings);

    /* create regionCommitmentClient */
    regionCommitmentSettings =
        RegionCommitmentSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionCommitmentClient = RegionCommitmentClient.create(regionCommitmentSettings);

    /* create regionDiskClient */
    regionDiskSettings =
        RegionDiskSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionDiskClient = RegionDiskClient.create(regionDiskSettings);

    /* create targetHttpProxyClient */
    targetHttpProxySettings =
        TargetHttpProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetHttpProxyClient = TargetHttpProxyClient.create(targetHttpProxySettings);

    /* create targetHttpsProxyClient */
    targetHttpsProxySettings =
        TargetHttpsProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetHttpsProxyClient = TargetHttpsProxyClient.create(targetHttpsProxySettings);

    /* create targetInstanceClient */
    targetInstanceSettings =
        TargetInstanceSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetInstanceClient = TargetInstanceClient.create(targetInstanceSettings);

    /* targetSslProxyClient */
    targetSslProxySettings =
        TargetSslProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetSslProxyClient = TargetSslProxyClient.create(targetSslProxySettings);

    /* create targetTcpProxyClient */
    targetTcpProxySettings =
        TargetTcpProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetTcpProxyClient = TargetTcpProxyClient.create(targetTcpProxySettings);

    /* create targetVpnGatewayClient */
    targetVpnGatewaySettings =
        TargetVpnGatewaySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetVpnGatewayClient = TargetVpnGatewayClient.create(targetVpnGatewaySettings);

    /* create urlMapClient */
    urlMapSettings =
        UrlMapSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    urlMapClient = UrlMapClient.create(urlMapSettings);

    /* create vpnGatewayClient */
    vpnGatewaySettings =
        VpnGatewaySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    vpnGatewayClient = VpnGatewayClient.create(vpnGatewaySettings);

    /* create vpnTunnelClient */
    vpnTunnelSettings =
        VpnTunnelSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    vpnTunnelClient = VpnTunnelClient.create(vpnTunnelSettings);

    /* create zoneClient */
    zoneSettings = ZoneSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    zoneClient = ZoneClient.create(zoneSettings);
  }

  @AfterClass
  public static void tearDown() throws Exception {
    Thread.sleep(3000);
    acceleratorTypeClient.close();
    addressClient.deleteAddress(ADDRESS_SELF_LINK);
    addressClient.close();
    autoscalerClient.close();
    backendBucketClient.deleteBackendBucket(PROJECT_BACKEND_BUCKET_NAME);
    backendBucketClient.close();
    imageClient.deleteImage(PROJECT_GLOBAL_IMAGE_NAME);
    imageClient.close();
    Thread.sleep(30000);
    diskClient.deleteDisk(DISK_SELF_LINK);
    diskClient.close();
    diskTypeClient.close();
    externalVpnGatewayClient.close();
    firewallClient.deleteFirewall(FIREWALL);
    firewallClient.close();
    forwardingRuleClient.deleteForwardingRule(PROJECT_REGION_FORWARDING_RULE_NAME);
    forwardingRuleClient.close();
    globalAddressClient.close();
    globalForwardingRuleClient.close();
    globalOperationClient.close();
    healthCheckClient.close();
    httpHealthCheckClient.deleteHttpHealthCheck(HTTP_HEALTH_CHECK_NAME);
    httpHealthCheckClient.close();
    httpsHealthCheckClient.deleteHttpsHealthCheck(HTTPS_HEALTH_CHECK_NAME);
    httpsHealthCheckClient.close();
    instanceClient.close();
    instanceGroupClient.deleteInstanceGroup(INSTANCE_GROUP_NAME);
    instanceGroupClient.close();
    instanceTemplateClient.close();
    instanceGroupManagerClient.close();
    interconnectAttachmentClient.close();
    interconnectLocationClient.close();
    interconnectClient.close();
    licenseClient.deleteLicense(LICENSE_NAME);
    licenseClient.close();
    machineTypeClient.close();
    networkEndpointGroupClient.close();
    networkClient.close();
    nodeTemplateClient.close();
    nodeTypeClient.close();
    nodeGroupClient.close();
    projectClient.close();
    regionAutoscalerClient.close();
    regionClient.close();
    regionCommitmentClient.close();
    regionDiskClient.close();
    regionBackendServiceClient.close();
    targetHttpProxyClient.close();
    targetHttpsProxyClient.close();
    targetInstanceClient.close();
    Thread.sleep(30000);
    targetPoolClient.deleteTargetPool(REGION_TARGET_POOL_NAME);
    targetPoolClient.close();
    targetSslProxyClient.close();
    targetTcpProxyClient.close();
    targetVpnGatewayClient.close();
    urlMapClient.close();
    vpnGatewayClient.close();
    vpnTunnelClient.close();
    zoneClient.close();
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 10, TimeUnit.SECONDS);
      if (!wasDeleted && LOG.isLoggable(Level.WARNING)) {
        LOG.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void listAcceleratorTypesTest() {
    List<AcceleratorType> acceleratorTypes =
        Lists.newArrayList(
            acceleratorTypeClient.listAcceleratorTypes(PROJECT_ZONE_NAME).iterateAll());
    assertThat(acceleratorTypes).isNotNull();
    assertThat(acceleratorTypes.size()).isGreaterThan(0);
    assertThat(acceleratorTypes.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListAcceleratorTypesTest() {
    List<AcceleratorTypesScopedList> typesScopedLists =
        Lists.newArrayList(
            acceleratorTypeClient.aggregatedListAcceleratorTypes(PROJECT_NAME).iterateAll());
    assertThat(typesScopedLists).isNotNull();
    assertThat(typesScopedLists.size()).isGreaterThan(0);
    assertThat(typesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void getAddressesTest() {
    ProjectRegionAddressName projectRegionAddressName =
        ProjectRegionAddressName.of(ADDRESS_NAME, DEFAULT_PROJECT, REGION);
    Address address = addressClient.getAddress(projectRegionAddressName);
    assertThat(address).isNotNull();
    assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
    assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
    assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
    assertThat(address.getRegion()).isEqualTo(REGION_LINK);
    assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
    assertThat(address.getSelfLink()).isEqualTo(ADDRESS_SELF_LINK);
  }

  @Test
  public void listAddressesTest() {
    List<Address> addresses =
        Lists.newArrayList(addressClient.listAddresses(PROJECT_REGION_NAME).iterateAll());
    assertThat(addresses.size()).isGreaterThan(0);
    for (Address address : addresses) {
      if (ADDRESS_NAME.equals(address.getName())) {
        assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
        assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
        assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
        assertThat(address.getRegion()).isEqualTo(REGION_LINK);
        assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
        assertThat(address.getSelfLink()).isEqualTo(ADDRESS_SELF_LINK);
      }
    }
  }

  @Test
  public void aggregatedListAddressesTest() {
    List<AddressesScopedList> addressesScopedLists =
        Lists.newArrayList(addressClient.aggregatedListAddresses(PROJECT_NAME).iterateAll());
    for (AddressesScopedList addressesScopedList : addressesScopedLists) {
      List<Address> addresses = addressesScopedList.getAddressesList();
      if (addresses != null) {
        for (Address address : addresses) {
          if (ADDRESS_NAME.equals(address.getName())) {
            assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
            assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
            assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
            assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
          }
        }
      }
    }
  }

  @Test
  public void listAutoscalersTest() {
    List<Autoscaler> autoscalers =
        Lists.newArrayList(autoscalerClient.listAutoscalers(PROJECT_ZONE_NAME).iterateAll());
    assertNotNull(autoscalers);
    assertThat(autoscalers.size()).isEqualTo(0);
    assertThat(autoscalers.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListAutoscalersTest() {
    List<AutoscalersScopedList> autoscalersScopedLists =
        Lists.newArrayList(autoscalerClient.aggregatedListAutoscalers(PROJECT_NAME).iterateAll());
    assertNotNull(autoscalersScopedLists);
    assertThat(autoscalersScopedLists.size()).isGreaterThan(0);
    assertThat(autoscalersScopedLists.contains(null)).isFalse();
  }

  @Test
  public void getBackendBucketTest() {
    BackendBucket backendBucket = backendBucketClient.getBackendBucket(PROJECT_BACKEND_BUCKET_NAME);
    assertThat(backendBucket).isNotNull();
    assertThat(backendBucket.getName()).isEqualTo(BACKEND_BUCKET_NAME);
    assertThat(backendBucket.getBucketName()).isEqualTo(BUCKET);
    assertThat(backendBucket.getSelfLink()).isEqualTo(BACKEND_BUCKET_TARGET_LINK);
    assertThat(backendBucket.getEnableCdn()).isFalse();
  }

  @Test
  public void listBackendBucketsTest() {
    List<BackendBucket> backendBuckets =
        Lists.newArrayList(backendBucketClient.listBackendBuckets(PROJECT_NAME).iterateAll());
    assertThat(backendBuckets).isNotNull();
    assertThat(backendBuckets.size()).isGreaterThan(0);
    assertFalse(backendBuckets.contains(null));
    for (BackendBucket backendBucket : backendBuckets) {
      if (BUCKET.equals(backendBucket.getBucketName())) {
        assertThat(backendBucket.getName()).isEqualTo(BACKEND_BUCKET_NAME);
        assertThat(backendBucket.getBucketName()).isEqualTo(BUCKET);
        assertThat(backendBucket.getSelfLink()).isEqualTo(BACKEND_BUCKET_TARGET_LINK);
        assertThat(backendBucket.getEnableCdn()).isFalse();
      }
    }
  }

  @Test
  public void addResourcePoliciesDiskTest() {
    DisksAddResourcePoliciesRequest resourcePoliciesRequest =
        DisksAddResourcePoliciesRequest.newBuilder().build();
    Operation resourcePoliciesDisk =
        diskClient.addResourcePoliciesDisk(PROJECT_ZONE_DISK_NAME, resourcePoliciesRequest);
    assertThat(resourcePoliciesDisk).isNotNull();
    assertThat(resourcePoliciesDisk.getStatus()).isEqualTo("RUNNING");
    assertThat(resourcePoliciesDisk.getOperationType()).isEqualTo("addResourcePolicies");
    assertThat(resourcePoliciesDisk.getTargetLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(resourcePoliciesDisk.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void removeResourcePoliciesDiskTest() {
    DisksRemoveResourcePoliciesRequest resourcePoliciesRequest =
        DisksRemoveResourcePoliciesRequest.newBuilder().build();
    Operation resourcePoliciesDisk =
        diskClient.removeResourcePoliciesDisk(PROJECT_ZONE_DISK_NAME, resourcePoliciesRequest);
    assertThat(resourcePoliciesDisk).isNotNull();
    assertThat(resourcePoliciesDisk.getStatus()).isEqualTo("RUNNING");
    assertThat(resourcePoliciesDisk.getOperationType()).isEqualTo("removeResourcePolicies");
    assertThat(resourcePoliciesDisk.getTargetLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(resourcePoliciesDisk.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void aggregatedListDisksTest() {
    List<DisksScopedList> disksScopedLists =
        Lists.newArrayList(diskClient.aggregatedListDisks(PROJECT_NAME).iterateAll());
    for (DisksScopedList disksScopedList : disksScopedLists) {
      List<Disk> disks = disksScopedList.getDisksList();
      if (null != disks && disks.size() > 0) {
        for (Disk disk : disks) {
          if (DISK_NAME.equals(disk.getName())) {
            assertThat(disk.getName()).isEqualTo(DISK_NAME);
            assertThat(disk.getSizeGb()).isEqualTo(DISK_SIZE);
            assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
            assertThat(disk.getStatus()).isEqualTo("READY");
          }
        }
      }
    }
  }

  @Test
  public void createSnapshotDiskTest() {
    Snapshot snapshotResource =
        Snapshot.newBuilder().setName("test-snapshot-" + ID).setDiskSizeGb(DISK_SIZE).build();
    CreateSnapshotDiskHttpRequest diskHttpRequest =
        CreateSnapshotDiskHttpRequest.newBuilder()
            .setDisk(PROJECT_ZONE_DISK_NAME.toString())
            .setGuestFlush(Boolean.FALSE)
            .setSnapshotResource(snapshotResource)
            .build();
    Operation snapshotDisk = diskClient.createSnapshotDisk(diskHttpRequest);
    assertThat(snapshotDisk).isNotNull();
    assertThat(snapshotDisk.getStatus()).isEqualTo("RUNNING");
    assertThat(snapshotDisk.getOperationType()).isEqualTo("createSnapshot");
    assertThat(snapshotDisk.getTargetLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(snapshotDisk.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void getDiskTest() {
    Disk disk = diskClient.getDisk(PROJECT_ZONE_DISK_NAME);
    assertThat(disk).isNotNull();
    assertThat(disk.getName()).isEqualTo(DISK_NAME);
    assertThat(disk.getSizeGb()).isEqualTo(DISK_SIZE);
    assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(disk.getStatus()).isEqualTo("READY");
  }

  @Test
  public void getIamPolicyDiskTest() {
    Policy policy = diskClient.getIamPolicyDisk(PROJECT_ZONE_DISK_RESOURCE_NAME);
    assertThat(policy).isNotNull();
    assertThat(policy.getEtag()).isEqualTo("ACAB");
  }

  @Test
  public void resizeDiskTest() throws Exception {
    String diskSize = "2";
    DisksResizeRequest disksResizeRequestResource =
        DisksResizeRequest.newBuilder().setSizeGb(diskSize).build();
    Operation resizeDisk =
        diskClient.resizeDisk(PROJECT_ZONE_DISK_NAME, disksResizeRequestResource);
    Thread.sleep(2000);
    assertThat(resizeDisk).isNotNull();
    Disk disk = diskClient.getDisk(PROJECT_ZONE_DISK_NAME);
    assertThat(disk).isNotNull();
    assertThat(disk.getName()).isEqualTo(DISK_NAME);
    assertThat(disk.getSizeGb()).isEqualTo(diskSize);
    assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(disk.getStatus()).isEqualTo("READY");
  }

  @Test
  public void listDisksTest() {
    List<Disk> disks = Lists.newArrayList(diskClient.listDisks(PROJECT_ZONE_NAME).iterateAll());
    assertThat(disks).isNotNull();
    assertThat(disks.size()).isGreaterThan(0);
    for (Disk disk : disks) {
      if (DISK_NAME.equals(disk.getName())) {
        assertThat(disk.getName()).isEqualTo(DISK_NAME);
        assertThat(disk.getSizeGb()).isEqualTo(DISK_SIZE);
        assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
        assertThat(disk.getStatus()).isEqualTo("READY");
      }
    }
  }

  @Test
  public void testGetDiskType() {
    DiskType diskType =
        diskTypeClient.getDiskType(ProjectZoneDiskTypeName.of(DISK_TYPE, DEFAULT_PROJECT, ZONE));
    ProjectZoneDiskTypeName returnDiskName = ProjectZoneDiskTypeName.parse(diskType.getSelfLink());
    assertThat(returnDiskName.getZone()).isEqualTo(ZONE);
    assertThat(returnDiskName.getDiskType()).isEqualTo(DISK_TYPE);
    assertThat(diskType.getCreationTimestamp()).isNotNull();
    assertThat(diskType.getDescription()).isNotNull();
    assertThat(diskType.getValidDiskSize()).isNotNull();
    assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
  }

  @Test
  public void listExternalVpnGatewaysTest() {
    List<ExternalVpnGateway> vpnGateways =
        Lists.newArrayList(
            externalVpnGatewayClient.listExternalVpnGateways(PROJECT_NAME).iterateAll());
    assertThat(vpnGateways.size()).isGreaterThan(0);
    assertThat(vpnGateways.contains(null)).isFalse();
    for (ExternalVpnGateway vpnGateway : vpnGateways) {
      if (EXTERNAL_VPN_GATEWAY_NAME.equals(vpnGateway.getName())) {
        assertThat(vpnGateway.getName()).isEqualTo(EXTERNAL_VPN_GATEWAY_NAME);
        assertThat(vpnGateway.getRedundancyType()).isEqualTo(REDUNDANCY_TYPE);
        assertThat(vpnGateway.getSelfLink()).isEqualTo(EXTERNAL_VPN_GATEWAY_TARGET_LINK);
        assertThat(vpnGateway.getInterfacesList()).isEqualTo(VPN_GATEWAY_INTERFACE);
        assertThat(vpnGateway.getDescription()).isEqualTo(EXTERNAL_VPN_GATEWAY_DESCRIPTION);
      }
    }
  }

  @Test
  public void getFirewallTest() {
    Firewall firewall = firewallClient.getFirewall(FIREWALL);
    assertThat(firewall.getAllowedList()).isEqualTo(ALLOWEDS);
    assertThat(firewall.getDescription()).isEqualTo(FIREWALL_DESCRIPTION);
    assertThat(firewall.getDirection()).isEqualTo(DIRECTION);
    assertThat(firewall.getDisabled()).isFalse();
    assertThat(firewall.getPriority()).isEqualTo(FIREWALL_PRIORITY);
    assertThat(firewall.getSelfLink()).isEqualTo(FIREWALL_LINK);
  }

  @Test
  public void listFirewallsTest() {
    List<Firewall> firewalls =
        Lists.newArrayList(firewallClient.listFirewalls(PROJECT_NAME).iterateAll());
    for (Firewall firewall : firewalls) {
      if (FIREWALL_NAME.equals(firewall.getName())) {
        assertThat(firewall.getAllowedList()).isEqualTo(ALLOWEDS);
        assertThat(firewall.getDescription()).isEqualTo(FIREWALL_DESCRIPTION);
        assertThat(firewall.getDirection()).isEqualTo(DIRECTION);
        assertThat(firewall.getDisabled()).isFalse();
        assertThat(firewall.getPriority()).isEqualTo(FIREWALL_PRIORITY);
        assertThat(firewall.getSelfLink()).isEqualTo(FIREWALL_LINK);
      }
    }
  }

  @Test
  public void getForwardingRuleTest() throws Exception {
    Thread.sleep(50000);
    ForwardingRule forwardingRule =
        forwardingRuleClient.getForwardingRule(PROJECT_REGION_FORWARDING_RULE_NAME);
    assertThat(forwardingRule.getIPProtocol()).isEqualTo(IP_PROTOCOL);
    assertThat(forwardingRule.getName()).isEqualTo(FORWARDING_RULE_NAME);
    assertThat(forwardingRule.getNetworkTier()).isEqualTo(NETWORK_TIER);
    assertThat(forwardingRule.getRegion()).isEqualTo(REGION_LINK);
    assertThat(forwardingRule.getSelfLink()).isEqualTo(FORWARDING_RULE_LINK);
    assertThat(forwardingRule.getTarget()).isEqualTo(TARGET_POOL_SELF_LINK);
  }

  @Test
  public void listForwardingRulesTest() {
    List<ForwardingRule> forwardingRules =
        Lists.newArrayList(
            forwardingRuleClient.listForwardingRules(PROJECT_REGION_NAME).iterateAll());
    for (ForwardingRule forwardingRule : forwardingRules) {
      if (FORWARDING_RULE_NAME.equals(forwardingRule.getName())) {
        assertThat(forwardingRule.getIPProtocol()).isEqualTo(IP_PROTOCOL);
        assertThat(forwardingRule.getName()).isEqualTo(FORWARDING_RULE_NAME);
        assertThat(forwardingRule.getNetworkTier()).isEqualTo(NETWORK_TIER);
        assertThat(forwardingRule.getRegion()).isEqualTo(REGION_LINK);
        assertThat(forwardingRule.getSelfLink()).isEqualTo(FORWARDING_RULE_LINK);
        assertThat(forwardingRule.getTarget()).isEqualTo(TARGET_POOL_SELF_LINK);
      }
    }
  }

  @Test
  public void setTargetForwardingRuleTest() throws Exception {
    Thread.sleep(50000);
    TargetReference targetReferenceResource =
        TargetReference.newBuilder().setTarget(TARGET_POOL_SELF_LINK).build();
    Operation setTargetForwardingRule =
        forwardingRuleClient.setTargetForwardingRule(
            PROJECT_REGION_FORWARDING_RULE_NAME, targetReferenceResource);
    assertThat(setTargetForwardingRule.getOperationType()).isEqualTo("SetTarget");
    assertThat(setTargetForwardingRule.getRegion()).isEqualTo(REGION_LINK);
    assertThat(setTargetForwardingRule.getTargetLink()).isEqualTo(FORWARDING_RULE_LINK);
  }

  @Test
  public void aggregatedListForwardingRulesTest() {
    List<ForwardingRulesScopedList> forwardingRulesScopedLists =
        Lists.newArrayList(
            forwardingRuleClient.aggregatedListForwardingRules(PROJECT_NAME).iterateAll());
    assertThat(forwardingRulesScopedLists).isNotNull();
    assertThat(forwardingRulesScopedLists.size()).isGreaterThan(0);
    assertThat(forwardingRulesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listGlobalAddressesTest() {
    List<Address> addresses =
        Lists.newArrayList(globalAddressClient.listGlobalAddresses(PROJECT_NAME).iterateAll());
    for (Address address : addresses) {
      if (ADDRESS_NAME.equals(address.getName())) {
        assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
        assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
        assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
        assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
        assertThat(address.getSelfLink()).isEqualTo(GLOBAL_ADDRESS_LINK);
      }
    }
  }

  @Test
  public void listGlobalForwardingRulesTest() {
    List<ForwardingRule> forwardingRules =
        Lists.newArrayList(
            globalForwardingRuleClient.listGlobalForwardingRules(PROJECT_NAME).iterateAll());
    assertThat(forwardingRules).isNotNull();
    assertThat(forwardingRules.size()).isEqualTo(0);
    assertThat(forwardingRules.contains(null)).isFalse();
  }

  @Test
  public void listGlobalOperationsTest() {
    GlobalOperationClient.ListGlobalOperationsPagedResponse listGlobalOperations =
        globalOperationClient.listGlobalOperations(PROJECT_NAME);
    List<Operation> operations = Lists.newArrayList(listGlobalOperations.iterateAll());
    assertThat(operations).isNotNull();
    assertThat(operations.size()).isGreaterThan(0);
    assertThat(operations.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListGlobalOperationsTest() {
    List<OperationsScopedList> operationsScopedLists =
        Lists.newArrayList(
            globalOperationClient.aggregatedListGlobalOperations(PROJECT_NAME).iterateAll());
    assertThat(operationsScopedLists).isNotNull();
    assertThat(operationsScopedLists.size()).isGreaterThan(0);
    assertThat(operationsScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listHealthChecksTest() {
    List<HealthCheck> healthChecks =
        Lists.newArrayList(healthCheckClient.listHealthChecks(PROJECT_NAME).iterateAll());
    for (HealthCheck healthCheck : healthChecks) {
      if (HEALTH_CHECK_NAME.equals(healthCheck.getName())) {
        assertThat(healthCheck.getName()).isEqualTo(HEALTH_CHECK_NAME);
        assertThat(healthCheck.getSelfLink()).isEqualTo(HEALTH_CHECK_LINK);
        assertThat(healthCheck.getTcpHealthCheck()).isEqualTo(TCP_HEALTH_CHECK);
        assertThat(healthCheck.getType()).isEqualTo(IP_PROTOCOL);
      }
    }
  }

  @Test
  public void aggregatedListHealthChecksTest() {
    List<HealthChecksScopedList> scopedLists =
        Lists.newArrayList(healthCheckClient.aggregatedListHealthChecks(PROJECT_NAME).iterateAll());
    Iterator<HealthChecksScopedList> iterator = scopedLists.iterator();
    while (iterator.hasNext()) {
      List<HealthCheck> checkList = iterator.next().getHealthChecksList();
      if (null != checkList && checkList.size() > 0) {
        for (HealthCheck healthCheck : checkList) {
          if (HEALTH_CHECK_NAME.equals(healthCheck.getName())) {
            assertThat(healthCheck.getName()).isEqualTo(HEALTH_CHECK_NAME);
            assertThat(healthCheck.getSelfLink()).isEqualTo(HEALTH_CHECK_LINK);
            assertThat(healthCheck.getTcpHealthCheck()).isEqualTo(TCP_HEALTH_CHECK);
            assertThat(healthCheck.getType()).isEqualTo(IP_PROTOCOL);
          }
        }
      }
    }
  }

  @Test
  public void getHttpHealthCheckTest() throws Exception {
    Thread.sleep(60000);
    GetHttpHealthCheckHttpRequest request =
        GetHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(HTTP_HEALTH_CHECK_NAME.toString())
            .build();
    HttpHealthCheck2 httpHealthCheck = httpHealthCheckClient.getHttpHealthCheck(request);
    assertThat(httpHealthCheck.getName()).isEqualTo(HTTP_HEALTH_CHECK_2);
    assertThat(httpHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
    assertThat(httpHealthCheck.getPort()).isEqualTo(PORT);
    assertThat(httpHealthCheck.getSelfLink()).isEqualTo(HTTP_HEALTH_CHECK_LINK);
  }

  @Test
  public void listHttpHealthChecksTest() {
    List<HttpHealthCheck2> healthCheck2s =
        Lists.newArrayList(httpHealthCheckClient.listHttpHealthChecks(PROJECT_NAME).iterateAll());
    for (HttpHealthCheck2 httpHealthCheck : healthCheck2s) {
      if (HTTP_HEALTH_CHECK_2.equals(httpHealthCheck.getName())) {
        assertThat(httpHealthCheck.getName()).isEqualTo(HTTP_HEALTH_CHECK_2);
        assertThat(httpHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
        assertThat(httpHealthCheck.getPort()).isEqualTo(PORT);
        assertThat(httpHealthCheck.getSelfLink()).isEqualTo(HTTP_HEALTH_CHECK_LINK);
      }
    }
  }

  @Test
  public void getHttpsHealthCheckTest() throws Exception {
    Thread.sleep(60000);
    HttpsHealthCheck2 httpsHealthCheck =
        httpsHealthCheckClient.getHttpsHealthCheck(HTTPS_HEALTH_CHECK_NAME);
    assertThat(httpsHealthCheck.getName()).isEqualTo(HTTPS_HEALTH_CHECK_2);
    assertThat(httpsHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
    assertThat(httpsHealthCheck.getPort()).isEqualTo(PORT);
    assertThat(httpsHealthCheck.getSelfLink()).isEqualTo(HTTPS_HEALTH_CHECK_LINK);
  }

  @Test
  public void listHttpsHealthChecksTest() {
    List<HttpsHealthCheck2> httpsHealthCheck2s =
        Lists.newArrayList(httpsHealthCheckClient.listHttpsHealthChecks(PROJECT_NAME).iterateAll());
    for (HttpsHealthCheck2 httpsHealthCheck : httpsHealthCheck2s) {
      if (HTTPS_HEALTH_CHECK_2.equals(httpsHealthCheck.getName())) {
        assertThat(httpsHealthCheck.getName()).isEqualTo(HTTPS_HEALTH_CHECK_2);
        assertThat(httpsHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
        assertThat(httpsHealthCheck.getPort()).isEqualTo(PORT);
        assertThat(httpsHealthCheck.getSelfLink()).isEqualTo(HTTPS_HEALTH_CHECK_LINK);
      }
    }
  }

  @Test
  public void getImageTest() {
    Image image = imageClient.getImage(PROJECT_GLOBAL_IMAGE_NAME);
    assertThat(image).isNotNull();
    assertThat(image.getName()).isEqualTo(IMAGE_NAME);
    assertThat(image.getSelfLink()).isEqualTo(IMAGE_LINK);
    assertThat(image.getDiskSizeGb()).isEqualTo(DISK_SIZE);
  }

  @Test
  public void listImagesTest() {
    List<Image> images = Lists.newArrayList(imageClient.listImages(PROJECT_NAME).iterateAll());
    for (Image image : images) {
      if (IMAGE_NAME.equals(image.getName())) {
        assertThat(image.getName()).isEqualTo(IMAGE_NAME);
        assertThat(image.getSelfLink()).isEqualTo(IMAGE_LINK);
        assertThat(image.getDiskSizeGb()).isEqualTo(DISK_SIZE);
      }
    }
  }

  @Test
  public void getIamPolicyImageTest() {
    Policy policy = imageClient.getIamPolicyImage(IMAGE_RESOURCE_NAME);
    assertThat(policy).isNotNull();
    assertThat(policy.getEtag()).isEqualTo("ACAB");
  }

  @Test
  public void deprecateImageTest() {
    DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
    Operation deprecateImage =
        imageClient.deprecateImage(PROJECT_GLOBAL_IMAGE_NAME, deprecationStatusResource);
    assertThat(deprecateImage).isNotNull();
    assertThat(deprecateImage.getOperationType()).isEqualTo("deprecateImage");
    assertThat(deprecateImage.getStatus()).isEqualTo("DONE");
    assertThat(deprecateImage.getTargetLink()).isEqualTo(IMAGE_LINK);
  }

  @Test
  public void testInsertInstance() {
    String machineType =
        ProjectZoneMachineTypeName.of("n1-standard-1", DEFAULT_PROJECT, ZONE).toString();
    AttachedDisk disk =
        AttachedDisk.newBuilder()
            .setBoot(true)
            .setAutoDelete(true)
            .setType("PERSISTENT")
            .setInitializeParams(
                AttachedDiskInitializeParams.newBuilder().setSourceImage(DEFAULT_IMAGE).build())
            .build();
    Instance instance =
        Instance.newBuilder()
            .setName("mytestinstancetemplate")
            .setMachineType(machineType)
            .addDisks(disk)
            .build();
    try {
      instanceClient.insertInstance(ProjectZoneName.of(DEFAULT_PROJECT, ZONE), instance);
    } catch (InvalidArgumentException e) {
      // Expect a Bad Request HTTP 400 error, but it should NOT be because of a resource name
      // problem.
      assertThat(e.getMessage()).contains("Bad Request");
      assertThat(e.getCause().getMessage())
          .contains("Invalid value for field 'resource.networkInterfaces'");
      return;
    }

    fail("Expected HTTP Bad Request to be returned, but it was not returned.");
  }

  @Test
  public void testListDiskTypes() {
    Page<DiskType> diskPage = diskTypeClient.listDiskTypes(PROJECT_ZONE_NAME).getPage();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertThat(diskTypeIterator.hasNext()).isTrue();
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertThat(diskType.getSelfLink()).isNotNull();
      ProjectZoneDiskTypeName returnDiskName =
          ProjectZoneDiskTypeName.parse(diskType.getSelfLink());
      assertThat(returnDiskName.getZone()).isEqualTo(ZONE);
      assertThat(diskType.getCreationTimestamp()).isNotNull();
      assertThat(diskType.getDescription()).isNotNull();
      assertThat(diskType.getValidDiskSize()).isNotNull();
      assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
    }
  }

  @Test
  public void testListDiskTypesWithFilter() {
    ListDiskTypesHttpRequest request =
        ListDiskTypesHttpRequest.newBuilder()
            .setZone(PROJECT_ZONE_NAME.toString())
            .setFilter("(defaultDiskSizeGb = 375)")
            .build();
    Page<DiskType> diskPage = diskTypeClient.listDiskTypes(request).getPage();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertThat(diskTypeIterator.hasNext()).isTrue();
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertThat(diskType.getZone()).isNotNull();
      ProjectZoneName zoneName = ProjectZoneName.parse(diskType.getZone());
      assertThat(zoneName.getZone()).isEqualTo(ZONE);
      assertThat(diskType.getCreationTimestamp()).isNotNull();
      assertThat(diskType.getDescription()).isNotNull();
      assertThat(diskType.getValidDiskSize()).isNotNull();
      assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
    }
  }

  @Test
  public void testAggregatedListDiskTypes() {
    AggregatedListDiskTypesPagedResponse pagedListResponse =
        diskTypeClient.aggregatedListDiskTypes(PROJECT_NAME);
    List<DiskTypesScopedList> diskTypeScopedListIterator =
        Lists.newArrayList(pagedListResponse.iterateAll());
    List<DiskType> diskTypeIterator = new LinkedList<>();
    for (DiskTypesScopedList scopedList : diskTypeScopedListIterator) {
      diskTypeIterator.addAll(scopedList.getDiskTypesList());
    }
    assertThat(diskTypeIterator.size()).isGreaterThan(0);
    for (DiskType diskType : diskTypeIterator) {
      assertThat(diskType.getRegion() != null || diskType.getZone() != null).isTrue();
      if (diskType.getRegion() != null) {
        ProjectRegionDiskTypeName zoneName =
            ProjectRegionDiskTypeName.parse(diskType.getSelfLink());
        assertThat(zoneName.getDiskType()).isNotNull();
        assertThat(zoneName.getRegion()).isNotNull();
      } else {
        ProjectZoneDiskTypeName zoneName = ProjectZoneDiskTypeName.parse(diskType.getSelfLink());
        assertThat(zoneName.getDiskType()).isNotNull();
        assertThat(zoneName.getZone()).isNotNull();
      }
      assertThat(diskType.getCreationTimestamp()).isNotNull();
      assertThat(diskType.getDescription()).isNotNull();
      assertThat(diskType.getValidDiskSize()).isNotNull();
      assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
    }
  }

  @Test
  public void getInstanceGroupTest() {
    InstanceGroup instanceGroup = instanceGroupClient.getInstanceGroup(INSTANCE_GROUP_NAME);
    assertThat(instanceGroup).isNotNull();
    assertThat(instanceGroup.getName()).isEqualTo(INSTANCE_GROUP);
    assertThat(instanceGroup.getSelfLink()).isEqualTo(INSTANCE_GROUP_LINK);
    assertThat(instanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void listInstanceGroupsTest() {
    List<InstanceGroup> instanceGroups =
        Lists.newArrayList(instanceGroupClient.listInstanceGroups(PROJECT_ZONE_NAME).iterateAll());
    for (InstanceGroup instanceGroup : instanceGroups) {
      if (INSTANCE_GROUP.equals(instanceGroup.getName())) {
        assertThat(instanceGroup.getName()).isEqualTo(INSTANCE_GROUP);
        assertThat(instanceGroup.getSelfLink()).isEqualTo(INSTANCE_GROUP_LINK);
        assertThat(instanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
      }
    }
  }

  @Test
  public void listInstancesInstanceGroupsTest() {
    ProjectZoneInstanceGroupName instanceGroup =
        ProjectZoneInstanceGroupName.of(INSTANCE_GROUP, DEFAULT_PROJECT, ZONE);
    InstanceGroupsListInstancesRequest instancesRequest =
        InstanceGroupsListInstancesRequest.newBuilder().build();
    List<InstanceWithNamedPorts> instanceWithNamedPorts =
        Lists.newArrayList(
            instanceGroupClient
                .listInstancesInstanceGroups(instanceGroup, instancesRequest)
                .iterateAll());
    assertThat(instanceWithNamedPorts).isNotNull();
    assertThat(instanceWithNamedPorts.size()).isEqualTo(0);
    assertThat(instanceWithNamedPorts.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListInstanceGroupsTest() {
    List<InstanceGroupsScopedList> scopedLists =
        Lists.newArrayList(
            instanceGroupClient.aggregatedListInstanceGroups(PROJECT_NAME).iterateAll());
    for (InstanceGroupsScopedList instanceGroupsScopedList : scopedLists) {
      List<InstanceGroup> instanceGroups = instanceGroupsScopedList.getInstanceGroupsList();
      if (null != instanceGroups && instanceGroups.size() > 0) {
        for (InstanceGroup instanceGroup : instanceGroups) {
          if (INSTANCE_GROUP.equals(instanceGroup.getName())) {
            assertThat(instanceGroup.getName()).isEqualTo(INSTANCE_GROUP);
            assertThat(instanceGroup.getSelfLink()).isEqualTo(INSTANCE_GROUP_LINK);
            assertThat(instanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
          }
        }
      }
    }
  }

  @Test
  public void setNamedPortsInstanceGroupTest() {
    ProjectZoneInstanceGroupName instanceGroup =
        ProjectZoneInstanceGroupName.of(INSTANCE_GROUP, DEFAULT_PROJECT, ZONE);
    InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource =
        InstanceGroupsSetNamedPortsRequest.newBuilder().build();
    Operation portsInstanceGroup =
        instanceGroupClient.setNamedPortsInstanceGroup(
            instanceGroup, instanceGroupsSetNamedPortsRequestResource);
    assertNotNull(portsInstanceGroup);
    assertThat(portsInstanceGroup.getOperationType())
        .isEqualTo("compute.instanceGroups.setNamedPorts");
    assertThat(portsInstanceGroup.getStatus()).isEqualTo("DONE");
    assertThat(portsInstanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
    assertThat(portsInstanceGroup.getTargetLink()).isEqualTo(INSTANCE_GROUP_LINK);
  }

  @Test
  public void listTargetSslProxiesTest() {
    List<TargetSslProxy> targetSslProxies =
        Lists.newArrayList(targetSslProxyClient.listTargetSslProxies(PROJECT_NAME).iterateAll());
    assertThat(targetSslProxies.size()).isEqualTo(0);
    assertThat(targetSslProxies.contains(null)).isFalse();
  }

  @Test
  public void listTargetHttpProxiesTest() {
    List<TargetHttpProxy> targetHttpProxies =
        Lists.newArrayList(targetHttpProxyClient.listTargetHttpProxies(PROJECT_NAME).iterateAll());
    assertThat(targetHttpProxies.size()).isEqualTo(0);
    assertThat(targetHttpProxies.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListTargetHttpProxiesTest() {
    List<TargetHttpProxiesScopedList> targetHttpProxiesScopedLists =
        Lists.newArrayList(
            targetHttpProxyClient.aggregatedListTargetHttpProxies(PROJECT_NAME).iterateAll());
    assertThat(targetHttpProxiesScopedLists).isNotNull();
    assertThat(targetHttpProxiesScopedLists.size()).isGreaterThan(0);
    assertThat(targetHttpProxiesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listTargetHttpsProxiesTest() {
    List<TargetHttpsProxy> targetHttpsProxies =
        Lists.newArrayList(
            targetHttpsProxyClient.listTargetHttpsProxies(PROJECT_NAME).iterateAll());
    assertThat(targetHttpsProxies).isNotNull();
    assertThat(targetHttpsProxies.size()).isEqualTo(0);
    assertThat(targetHttpsProxies.contains(null)).isFalse();
  }

  @Test
  public void listTargetInstancesTest() {
    List<TargetInstance> targetInstances =
        Lists.newArrayList(
            targetInstanceClient.listTargetInstances(PROJECT_ZONE_NAME).iterateAll());
    assertThat(targetInstances).isNotNull();
    assertThat(targetInstances.size()).isEqualTo(0);
    assertThat(targetInstances.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListTargetInstancesTest() {
    List<TargetInstancesScopedList> targetInstancesScopedLists =
        Lists.newArrayList(
            targetInstanceClient.aggregatedListTargetInstances(PROJECT_NAME).iterateAll());
    assertNotNull(targetInstancesScopedLists);
    assertThat(targetInstancesScopedLists.size()).isGreaterThan(0);
    assertThat(targetInstancesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void getTargetPoolTest() {
    ProjectRegionTargetPoolName regionTargetPoolName =
        ProjectRegionTargetPoolName.of(DEFAULT_PROJECT, REGION, TARGET_POOL_NAME);
    TargetPool targetPool = targetPoolClient.getTargetPool(regionTargetPoolName);
    assertThat(targetPool).isNotNull();
    assertThat(targetPool.getName()).isEqualTo(TARGET_POOL_NAME);
    assertThat(targetPool.getRegion()).isEqualTo(REGION_LINK);
    assertThat(targetPool.getSelfLink()).isEqualTo(TARGET_POOL_SELF_LINK);
    assertThat(targetPool.getSessionAffinity()).isEqualTo(SESSION_AFFINITY);
  }

  @Test
  public void listTargetPoolsTest() {
    List<TargetPool> targetPools =
        Lists.newArrayList(targetPoolClient.listTargetPools(PROJECT_REGION_NAME).iterateAll());
    assertThat(targetPools).isNotNull();
    assertThat(targetPools.size()).isGreaterThan(0);
    assertThat(targetPools.contains(null)).isFalse();
    for (TargetPool targetPool : targetPools) {
      if (TARGET_POOL_NAME.equals(targetPool.getName())) {
        assertThat(targetPool.getName()).isEqualTo(TARGET_POOL_NAME);
        assertThat(targetPool.getRegion()).isEqualTo(REGION_LINK);
        assertThat(targetPool.getSelfLink()).isEqualTo(TARGET_POOL_SELF_LINK);
        assertThat(targetPool.getSessionAffinity()).isEqualTo(SESSION_AFFINITY);
      }
    }
  }

  @Test
  public void addInstanceTargetPoolTest() throws Exception {
    Thread.sleep(2000);
    TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource =
        TargetPoolsAddInstanceRequest.newBuilder().build();
    Operation instanceTargetPool =
        targetPoolClient.addInstanceTargetPool(
            REGION_TARGET_POOL_NAME, targetPoolsAddInstanceRequestResource);
    assertThat(instanceTargetPool).isNotNull();
    assertThat(instanceTargetPool.getOperationType()).isEqualTo("AddInstance");
    assertThat(instanceTargetPool.getRegion()).isEqualTo(REGION_LINK);
    assertThat(instanceTargetPool.getTargetLink()).isEqualTo(TARGET_POOL_SELF_LINK);
  }

  @Test
  public void setBackupTargetPoolTest() throws Exception {
    Thread.sleep(2000);
    TargetReference targetReferenceResource = TargetReference.newBuilder().build();
    SetBackupTargetPoolHttpRequest request =
        SetBackupTargetPoolHttpRequest.newBuilder()
            .setTargetPool(REGION_TARGET_POOL_NAME.toString())
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    Operation response = targetPoolClient.setBackupTargetPool(request);
    assertThat(response).isNotNull();
    assertThat(response.getOperationType()).isEqualTo("SetBackup");
    assertThat(response.getStatus()).isEqualTo("RUNNING");
    assertThat(response.getRegion()).isEqualTo(REGION_LINK);
    assertThat(response.getTargetLink()).isEqualTo(TARGET_POOL_SELF_LINK);
  }

  @Test
  public void aggregatedListTargetPoolsTest() {
    List<TargetPoolsScopedList> targetPoolsScopedLists =
        Lists.newArrayList(targetPoolClient.aggregatedListTargetPools(PROJECT_NAME).iterateAll());
    for (TargetPoolsScopedList targetPoolsScopedList : targetPoolsScopedLists) {
      List<TargetPool> targetPools = targetPoolsScopedList.getTargetPoolsList();
      if (targetPools != null) {
        for (TargetPool targetPool : targetPools) {
          if (TARGET_POOL_NAME.equals(targetPool.getName())) {
            assertThat(targetPool.getName()).isEqualTo(TARGET_POOL_NAME);
            assertThat(targetPool.getRegion()).isEqualTo(REGION_LINK);
            assertThat(targetPool.getSelfLink()).isEqualTo(TARGET_POOL_SELF_LINK);
            assertThat(targetPool.getSessionAffinity()).isEqualTo(SESSION_AFFINITY);
          }
        }
      }
    }
  }

  @Test
  public void addHealthCheckTargetPoolTest() {
    TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource =
        TargetPoolsAddHealthCheckRequest.newBuilder().build();
    Operation response =
        targetPoolClient.addHealthCheckTargetPool(
            REGION_TARGET_POOL_NAME, targetPoolsAddHealthCheckRequestResource);
    assertThat(response).isNotNull();
    assertThat(response.getOperationType()).isEqualTo("AddHealthCheck");
    assertThat(response.getStatus()).isEqualTo("DONE");
    assertThat(response.getRegion()).isEqualTo(REGION_LINK);
    assertThat(response.getTargetLink()).isEqualTo(TARGET_POOL_SELF_LINK);
  }

  @Test
  public void listTargetTcpProxiesTest() {
    List<TargetTcpProxy> proxies =
        Lists.newArrayList(targetTcpProxyClient.listTargetTcpProxies(PROJECT_NAME).iterateAll());
    assertThat(proxies).isNotNull();
    assertThat(proxies.size()).isEqualTo(0);
    assertThat(proxies.contains(null)).isFalse();
  }

  @Test
  public void listTargetVpnGatewaysTest() {
    List<TargetVpnGateway> targetVpnGateways =
        Lists.newArrayList(
            targetVpnGatewayClient.listTargetVpnGateways(PROJECT_REGION_NAME).iterateAll());
    assertNotNull(targetVpnGateways);
    assertThat(targetVpnGateways.size()).isEqualTo(0);
    assertThat(targetVpnGateways.contains(null)).isFalse();
  }

  @Test
  public void listUrlMapsTest() {
    List<UrlMap> urlMaps = Lists.newArrayList(urlMapClient.listUrlMaps(PROJECT_NAME).iterateAll());
    assertThat(urlMaps).isNotNull();
    assertThat(urlMaps.size()).isEqualTo(0);
    assertThat(urlMaps.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListUrlMapsTest() {
    List<UrlMapsScopedList> urlMapsScopedLists =
        Lists.newArrayList(urlMapClient.aggregatedListUrlMaps(PROJECT_NAME).iterateAll());
    assertThat(urlMapsScopedLists).isNotNull();
    assertThat(urlMapsScopedLists.size()).isGreaterThan(0);
    assertThat(urlMapsScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listVpnGatewaysTest() {
    Iterator<VpnGateway> vpnGatewayIterator =
        vpnGatewayClient.listVpnGateways(PROJECT_REGION_NAME).iterateAll().iterator();
    assertThat(vpnGatewayIterator).isNotNull();
  }

  @Test
  public void listVpnTunnelsTest() {
    List<VpnTunnel> vpnTunnels =
        Lists.newArrayList(vpnTunnelClient.listVpnTunnels(PROJECT_REGION_NAME).iterateAll());
    assertThat(vpnTunnels).isNotNull();
    assertThat(vpnTunnels.size()).isEqualTo(0);
    assertThat(vpnTunnels.contains(null)).isFalse();
  }

  @Test
  public void getZoneTest() {
    Zone zone = zoneClient.getZone(PROJECT_ZONE_NAME);
    assertThat(zone.getName()).isEqualTo(ZONE);
    assertThat(zone.getRegion()).isEqualTo(REGION_LINK);
    assertThat(zone.getSelfLink()).isEqualTo(ZONE_SELF_LINK);
    assertThat(zone.getStatus()).isEqualTo(STATUS);
    assertThat(zone.getDescription()).isEqualTo(ZONE);
  }

  @Test
  public void listZonesTest() {
    List<Zone> zones = Lists.newArrayList(zoneClient.listZones(PROJECT_NAME).iterateAll());
    for (Zone zone : zones) {
      if (ZONE.equals(zone.getName())) {
        assertThat(zone.getName()).isEqualTo(ZONE);
        assertThat(zone.getRegion()).isEqualTo(REGION_LINK);
        assertThat(zone.getSelfLink()).isEqualTo(ZONE_SELF_LINK);
        assertThat(zone.getStatus()).isEqualTo(STATUS);
        assertThat(zone.getDescription()).isEqualTo(ZONE);
      }
    }
  }

  @Test
  public void listInstanceTemplatesTest() {
    List<InstanceTemplate> templates =
        Lists.newArrayList(instanceTemplateClient.listInstanceTemplates(PROJECT_NAME).iterateAll());
    assertThat(templates).isNotNull();
    assertThat(templates.contains(null)).isFalse();
  }

  @Test
  public void listInstanceGroupManagersTest() {
    List<InstanceGroupManager> instanceGroupManagers =
        Lists.newArrayList(
            instanceGroupManagerClient.listInstanceGroupManagers(PROJECT_ZONE_NAME).iterateAll());
    assertThat(instanceGroupManagers).isNotNull();
    assertThat(instanceGroupManagers.size()).isEqualTo(0);
    assertThat(instanceGroupManagers.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListInstanceGroupManagersTest() {
    List<InstanceGroupManagersScopedList> managersScopedLists =
        Lists.newArrayList(
            instanceGroupManagerClient
                .aggregatedListInstanceGroupManagers(PROJECT_NAME)
                .iterateAll());
    assertThat(managersScopedLists).isNotNull();
    assertThat(managersScopedLists.size()).isGreaterThan(0);
    assertThat(managersScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listInterconnectsTest() {
    List<Interconnect> interconnects =
        Lists.newArrayList(interconnectClient.listInterconnects(PROJECT_NAME).iterateAll());
    for (Interconnect interconnect : interconnects) {
      if (INTER_CONNECT.equals(interconnect.getName())) {
        assertThat(interconnect.getCustomerName()).isEqualTo(CUSTOMER_NAME);
        assertThat(interconnect.getAdminEnabled()).isTrue();
        assertThat(interconnect.getInterconnectType()).isEqualTo(INTER_CONNECT_TYPE);
        assertThat(interconnect.getLinkType()).isEqualTo(INTER_CONNECT_LINK_TYPE);
        assertThat(interconnect.getName()).isEqualTo(INTER_CONNECT);
        assertThat(interconnect.getRequestedLinkCount())
            .isEqualTo(INTER_CONNECT_REQUESTED_LINK_COUNT);
        assertThat(interconnect.getSelfLink()).isEqualTo(INTER_CONNECT_LINK);
      }
    }
  }

  @Test
  public void listInterconnectAttachmentsTest() {
    List<InterconnectAttachment> attachments =
        Lists.newArrayList(
            interconnectAttachmentClient
                .listInterconnectAttachments(PROJECT_REGION_NAME)
                .iterateAll());
    assertThat(attachments).isNotNull();
    assertThat(attachments.size()).isEqualTo(0);
    assertThat(attachments.contains(null)).isFalse();
  }

  @Test
  public void listInterconnectLocationsTest() {
    List<InterconnectLocation> locations =
        Lists.newArrayList(
            interconnectLocationClient.listInterconnectLocations(PROJECT_NAME).iterateAll());
    assertThat(locations).isNotNull();
    assertThat(locations.size()).isGreaterThan(0);
    assertThat(locations.contains(null)).isFalse();
  }

  @Test
  public void getLicenseTest() {
    License license = licenseClient.getLicense(LICENSE_NAME);
    assertThat(license).isNotNull();
    assertThat(license.getChargesUseFee()).isFalse();
    assertThat(license.getName()).isEqualTo(LICENSE);
    assertThat(license.getSelfLink()).isEqualTo(LICENSE_LINK);
    assertThat(license.getTransferable()).isTrue();
  }

  @Test
  public void listLicensesTest() {
    List<License> licenses =
        Lists.newArrayList(licenseClient.listLicenses(PROJECT_NAME).iterateAll());
    for (License license : licenses) {
      if (LICENSE.equals(license.getName())) {
        assertThat(license.getChargesUseFee()).isFalse();
        assertThat(license.getName()).isEqualTo(LICENSE);
        assertThat(license.getSelfLink()).isEqualTo(LICENSE_LINK);
        assertThat(license.getTransferable()).isTrue();
      }
    }
  }

  @Test
  public void getIamPolicyLicenseTest() {
    ProjectGlobalLicenseResourceName licenseResourceName =
        ProjectGlobalLicenseResourceName.of(DEFAULT_PROJECT, LICENSE);
    Policy policy = licenseClient.getIamPolicyLicense(licenseResourceName);
    assertThat(policy).isNotNull();
    assertThat(policy.getEtag()).isEqualTo("ACAB");
  }

  @Test
  public void getMachineTypeTest() {
    ProjectZoneMachineTypeName machineTypeName =
        ProjectZoneMachineTypeName.of(MACHINE_TYPE, DEFAULT_PROJECT, ZONE);
    MachineType machineType = machineTypeClient.getMachineType(machineTypeName);
    assertThat(machineTypeName).isNotNull();
    assertThat(machineType.getIsSharedCpu()).isFalse();
    assertThat(machineType.getName()).isEqualTo(MACHINE_TYPE);
    assertThat(machineType.getSelfLink()).isEqualTo(MACHINE_TYPE_LINK);
    assertThat(machineType.getZone()).isEqualTo(ZONE);
  }

  @Test
  public void listMachineTypesTest() {
    List<MachineType> machineTypes =
        Lists.newArrayList(machineTypeClient.listMachineTypes(PROJECT_ZONE_NAME).iterateAll());
    for (MachineType machineType : machineTypes) {
      if (MACHINE_TYPE.equals(machineType.getName())) {
        assertThat(machineType.getIsSharedCpu()).isFalse();
        assertThat(machineType.getName()).isEqualTo(MACHINE_TYPE);
        assertThat(machineType.getSelfLink()).isEqualTo(MACHINE_TYPE_LINK);
        assertThat(machineType.getZone()).isEqualTo(ZONE);
      }
    }
  }

  @Test
  public void aggregatedListMachineTypesTest() {
    List<MachineTypesScopedList> scopedLists =
        Lists.newArrayList(machineTypeClient.aggregatedListMachineTypes(PROJECT_NAME).iterateAll());
    for (MachineTypesScopedList scopedList : scopedLists) {
      List<MachineType> machineTypes = scopedList.getMachineTypesList();
      if (null != machineTypes && machineTypes.size() > 0) {
        for (MachineType machineType : machineTypes) {
          if (null != machineType && MACHINE_TYPE.equals(machineType.getName())) {
            assertThat(machineType.getIsSharedCpu()).isFalse();
            assertThat(machineType.getName()).isEqualTo(MACHINE_TYPE);
          }
        }
      }
    }
  }

  @Test
  public void listNetworkTest() {
    List<Network> networks =
        Lists.newArrayList(networkClient.listNetworks(PROJECT_NAME).iterateAll());
    assertThat(networks).isNotNull();
    assertThat(networks.size()).isGreaterThan(0);
    assertThat(networks.contains(null)).isFalse();
  }

  @Test
  public void listNetworkEndpointGroupsTest() {
    List<NetworkEndpointGroup> networkEndpointGroups =
        Lists.newArrayList(
            networkEndpointGroupClient.listNetworkEndpointGroups(PROJECT_ZONE_NAME).iterateAll());
    assertThat(networkEndpointGroups).isNotNull();
    assertThat(networkEndpointGroups.contains(null)).isFalse();
  }

  @Test
  public void listNodeTypesTest() {
    List<NodeType> nodeTypes =
        Lists.newArrayList(nodeTypeClient.listNodeTypes(PROJECT_ZONE_NAME).iterateAll());
    assertThat(nodeTypes).isNotNull();
    assertThat(nodeTypes.size()).isGreaterThan(0);
    assertThat(nodeTypes.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListNodeTypesTest() {
    List<NodeTypesScopedList> nodeTypesScopedLists =
        Lists.newArrayList(nodeTypeClient.aggregatedListNodeTypes(PROJECT_NAME).iterateAll());
    assertThat(nodeTypesScopedLists).isNotNull();
    assertThat(nodeTypesScopedLists.size()).isGreaterThan(0);
    assertThat(nodeTypesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listNodeTemplatesTest() {
    List<NodeTemplate> nodeTemplates =
        Lists.newArrayList(nodeTemplateClient.listNodeTemplates(PROJECT_REGION_NAME).iterateAll());
    assertThat(nodeTemplates).isNotNull();
    assertThat(nodeTemplates.size()).isEqualTo(0);
    assertThat(nodeTemplates.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListNodeTemplatesTest() {
    List<NodeTemplatesScopedList> nodeTemplatesScopedLists =
        Lists.newArrayList(
            nodeTemplateClient.aggregatedListNodeTemplates(PROJECT_NAME).iterateAll());
    assertThat(nodeTemplatesScopedLists).isNotNull();
    assertThat(nodeTemplatesScopedLists.size()).isGreaterThan(0);
    assertThat(nodeTemplatesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listNodeGroupsTest() {
    List<NodeGroup> nodeGroups =
        Lists.newArrayList(nodeGroupClient.listNodeGroups(PROJECT_ZONE_NAME).iterateAll());
    assertThat(nodeGroups).isNotNull();
    assertThat(nodeGroups.size()).isEqualTo(0);
    assertThat(nodeGroups.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListNodeGroupsTest() {
    List<NodeGroupsScopedList> nodeGroupsScopedLists =
        Lists.newArrayList(nodeGroupClient.aggregatedListNodeGroups(PROJECT_NAME).iterateAll());
    assertThat(nodeGroupsScopedLists).isNotNull();
    assertThat(nodeGroupsScopedLists.size()).isGreaterThan(0);
    assertThat(nodeGroupsScopedLists.contains(null)).isFalse();
  }

  @Test
  public void getProjectTest() {
    Project project = projectClient.getProject(PROJECT_NAME);
    assertThat(project).isNotNull();
    assertThat(project.getSelfLink()).isEqualTo(PROJECT_LINK);
  }

  @Test
  public void listRegionAutoscalersTest() {
    List<Autoscaler> autoscalers =
        Lists.newArrayList(
            regionAutoscalerClient.listRegionAutoscalers(PROJECT_REGION_NAME).iterateAll());
    assertThat(autoscalers).isNotNull();
    assertThat(autoscalers.size()).isEqualTo(0);
    assertThat(autoscalers.contains(null)).isFalse();
  }

  @Test
  public void listRegionBackendServicesTest() {
    List<BackendService> backendServices =
        Lists.newArrayList(
            regionBackendServiceClient.listRegionBackendServices(PROJECT_REGION_NAME).iterateAll());
    assertThat(backendServices).isNotNull();
    assertThat(backendServices.size()).isEqualTo(0);
    assertThat(backendServices.contains(null)).isFalse();
  }

  @Test
  public void getRegionTest() {
    Region region = regionClient.getRegion(PROJECT_REGION_NAME);
    assertThat(region).isNotNull();
    assertThat(region.getName()).isEqualTo(REGION);
    assertThat(region.getSelfLink()).isEqualTo(REGION_LINK);
    assertThat(region.getStatus()).isEqualTo(STATUS);
  }

  @Test
  public void listRegionsTest() {
    List<Region> regions = Lists.newArrayList(regionClient.listRegions(PROJECT_NAME).iterateAll());
    assertThat(regions).isNotNull();
    assertThat(regions.size()).isGreaterThan(0);
    assertThat(regions.contains(null)).isFalse();
    for (Region region : regions) {
      if (REGION.equals(region.getName())) {
        assertThat(region.getName()).isEqualTo(REGION);
        assertThat(region.getSelfLink()).isEqualTo(REGION_LINK);
        assertThat(region.getStatus()).isEqualTo(STATUS);
      }
    }
  }

  @Test
  public void listRegionCommitmentsTest() {
    List<Commitment> commitments =
        Lists.newArrayList(
            regionCommitmentClient.listRegionCommitments(PROJECT_REGION_NAME).iterateAll());
    assertThat(commitments).isNotNull();
    assertThat(commitments.size()).isEqualTo(0);
    assertThat(commitments.contains(null)).isFalse();
  }
}
