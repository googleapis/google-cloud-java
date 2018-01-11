/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.AttachedDisk.CreateDiskConfiguration;
import com.google.cloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.AttachedDisk.ScratchDiskConfiguration;
import com.google.cloud.compute.NetworkInterface.AccessConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.List;

public class SerializationTest extends BaseSerializationTest {

  private static final Compute COMPUTE = ComputeOptions.newBuilder().setProjectId("p").build().getService();
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final String VALID_DISK_SIZE = "10GB-10TB";
  private static final Long DEFAULT_DISK_SIZE_GB = 10L;
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
  private static final DiskType DISK_TYPE = DiskType.newBuilder()
      .setDiskTypeId(DISK_TYPE_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setValidDiskSize(VALID_DISK_SIZE)
      .setDefaultDiskSizeGb(DEFAULT_DISK_SIZE_GB)
      .build();
  private static final MachineTypeId MACHINE_TYPE_ID = MachineTypeId.of("project", "zone", "type");
  private static final Integer GUEST_CPUS = 1;
  private static final Integer MEMORY_MB = 2;
  private static final List<Integer> SCRATCH_DISKS = ImmutableList.of(3);
  private static final Integer MAXIMUM_PERSISTENT_DISKS = 4;
  private static final Long MAXIMUM_PERSISTENT_DISKS_SIZE_GB = 5L;
  private static final MachineType MACHINE_TYPE = MachineType.newBuilder()
      .setMachineTypeId(MACHINE_TYPE_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setCpus(GUEST_CPUS)
      .setMemoryMb(MEMORY_MB)
      .setScratchDisksSizeGb(SCRATCH_DISKS)
      .setMaximumPersistentDisks(MAXIMUM_PERSISTENT_DISKS)
      .setMaximumPersistentDisksSizeGb(MAXIMUM_PERSISTENT_DISKS_SIZE_GB)
      .build();
  private static final RegionId REGION_ID = RegionId.of("project", "region");
  private static final Region.Status REGION_STATUS = Region.Status.DOWN;
  private static final ZoneId ZONE_ID1 = ZoneId.of("project", "zone1");
  private static final ZoneId ZONE_ID2 = ZoneId.of("project", "zone2");
  private static final List<ZoneId> ZONES = ImmutableList.of(ZONE_ID1, ZONE_ID2);
  private static final Region.Quota QUOTA1 =
      new Region.Quota("METRIC1", 2, 1);
  private static final Region.Quota QUOTA2 =
      new Region.Quota("METRIC2", 4, 3);
  private static final List<Region.Quota> QUOTAS = ImmutableList.of(QUOTA1, QUOTA2);
  private static final Region REGION = Region.builder()
      .setRegionId(REGION_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setStatus(REGION_STATUS)
      .setZones(ZONES)
      .setQuotas(QUOTAS)
      .build();
  private static final ZoneId ZONE_ID = ZoneId.of("project", "zone");
  private static final Zone.Status ZONE_STATUS = Zone.Status.DOWN;
  private static final Zone ZONE = Zone.builder()
      .setZoneId(ZONE_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setStatus(ZONE_STATUS)
      .setRegion(REGION_ID)
      .build();
  private static final DeprecationStatus<MachineTypeId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, MACHINE_TYPE_ID);
  private static final LicenseId LICENSE_ID = LicenseId.of("project", "license");
  private static final Boolean CHARGES_USE_FEE = true;
  private static final License LICENSE = new License(LICENSE_ID, CHARGES_USE_FEE);
  private static final GlobalOperationId GLOBAL_OPERATION_ID =
      GlobalOperationId.of("project", "op");
  private static final ZoneOperationId ZONE_OPERATION_ID =
      ZoneOperationId.of("project", "zone", "op");
  private static final RegionOperationId REGION_OPERATION_ID =
      RegionOperationId.of("project", "region", "op");
  private static final Operation GLOBAL_OPERATION =
      new Operation.Builder(COMPUTE).setOperationId(GLOBAL_OPERATION_ID).build();
  private static final Operation ZONE_OPERATION =
      new Operation.Builder(COMPUTE).setOperationId(ZONE_OPERATION_ID).build();
  private static final Operation REGION_OPERATION =
      new Operation.Builder(COMPUTE).setOperationId(REGION_OPERATION_ID).build();
  private static final InstanceId INSTANCE_ID = InstanceId.of("project", "zone", "instance");
  private static final GlobalForwardingRuleId GLOBAL_FORWARDING_RULE_ID =
      GlobalForwardingRuleId.of("project", "rule");
  private static final RegionForwardingRuleId REGION_FORWARDING_RULE_ID =
      RegionForwardingRuleId.of("project", "region", "rule");
  private static final GlobalAddressId GLOBAL_ADDRESS_ID = GlobalAddressId.of("project", "address");
  private static final RegionAddressId REGION_ADDRESS_ID =
      RegionAddressId.of("project", "region", "address");
  private static final AddressInfo.InstanceUsage INSTANCE_USAGE =
      new AddressInfo.InstanceUsage(INSTANCE_ID);
  private static final AddressInfo.GlobalForwardingUsage GLOBAL_FORWARDING_USAGE =
      new AddressInfo.GlobalForwardingUsage(ImmutableList.of(GLOBAL_FORWARDING_RULE_ID));
  private static final AddressInfo.RegionForwardingUsage REGION_FORWARDING_USAGE =
      new AddressInfo.RegionForwardingUsage(ImmutableList.of(REGION_FORWARDING_RULE_ID));
  private static final AddressInfo ADDRESS_INFO = AddressInfo.newBuilder(REGION_ADDRESS_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setUsage(INSTANCE_USAGE)
      .build();
  private static final Address ADDRESS = new Address.Builder(COMPUTE, REGION_ADDRESS_ID).build();
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final SnapshotId SNAPSHOT_ID = SnapshotId.of("project", "snapshot");
  private static final SnapshotInfo SNAPSHOT_INFO = SnapshotInfo.of(SNAPSHOT_ID, DISK_ID);
  private static final Snapshot SNAPSHOT =
      new Snapshot.Builder(COMPUTE, SNAPSHOT_ID, DISK_ID).build();
  private static final ImageId IMAGE_ID = ImageId.of("project", "image");
  private static final DiskImageConfiguration DISK_IMAGE_CONFIGURATION =
      DiskImageConfiguration.of(DISK_ID);
  private static final StorageImageConfiguration STORAGE_IMAGE_CONFIGURATION =
      StorageImageConfiguration.of("gs:/bucket/file");
  private static final ImageInfo IMAGE_INFO = ImageInfo.of(IMAGE_ID, DISK_IMAGE_CONFIGURATION);
  private static final Image IMAGE =
      new Image.Builder(COMPUTE, IMAGE_ID, DISK_IMAGE_CONFIGURATION).build();
  private static final StandardDiskConfiguration STANDARD_DISK_CONFIGURATION =
      StandardDiskConfiguration.of(DISK_TYPE_ID);
  private static final ImageDiskConfiguration IMAGE_DISK_CONFIGURATION =
      ImageDiskConfiguration.of(IMAGE_ID);
  private static final SnapshotDiskConfiguration SNAPSHOT_DISK_CONFIGURATION =
      SnapshotDiskConfiguration.of(SNAPSHOT_ID);
  private static final DiskInfo DISK_INFO = DiskInfo.of(DISK_ID, STANDARD_DISK_CONFIGURATION);
  private static final Disk DISK =
      new Disk.Builder(COMPUTE, DISK_ID, STANDARD_DISK_CONFIGURATION).build();
  private static final SubnetworkId SUBNETWORK_ID =
      SubnetworkId.of("project", "region", "subnetwork");
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final SubnetworkInfo SUBNETWORK_INFO =
      SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, "192.168.0.0/16");
  private static final Subnetwork SUBNETWORK =
      new Subnetwork.Builder(COMPUTE, SUBNETWORK_ID, NETWORK_ID, "192.168.0.0/16").build();
  private static final StandardNetworkConfiguration STANDARD_NETWORK_CONFIGURATION =
      StandardNetworkConfiguration.of("192.168.0.0/16");
  private static final SubnetNetworkConfiguration SUBNET_NETWORK_CONFIGURATION =
      SubnetNetworkConfiguration.of(false);
  private static final NetworkInfo NETWORK_INFO =
      NetworkInfo.of(NETWORK_ID, STANDARD_NETWORK_CONFIGURATION);
  private static final Network NETWORK =
      new Network.Builder(COMPUTE, NETWORK_ID, STANDARD_NETWORK_CONFIGURATION).build();
  private static final AccessConfig ACCESS_CONFIG = AccessConfig.of("192.168.1.1");
  private static final NetworkInterface NETWORK_INTERFACE = NetworkInterface.newBuilder(NETWORK_ID)
      .setAccessConfigurations(ACCESS_CONFIG)
      .build();
  private static final CreateDiskConfiguration CREATE_DISK_CONFIGURATION =
      CreateDiskConfiguration.of(IMAGE_ID);
  private static final PersistentDiskConfiguration PERSISTENT_DISK_CONFIGURATION =
      PersistentDiskConfiguration.of(DISK_ID);
  private static final ScratchDiskConfiguration SCRATCH_DISK_CONFIGURATION =
      ScratchDiskConfiguration.of(DISK_TYPE_ID);
  private static final AttachedDisk ATTACHED_DISK = AttachedDisk.of(CREATE_DISK_CONFIGURATION);
  private static final Tags TAGS = Tags.of("tag1", "tag2");
  private static final Metadata METADATA = Metadata.of(ImmutableMap.of("key1", "val1"));
  private static final ServiceAccount SERVICE_ACCOUNT = ServiceAccount.of("email");
  private static final SchedulingOptions SCHEDULING_OPTIONS = SchedulingOptions.preemptible();
  private static final InstanceInfo INSTANCE_INFO =
      InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE_ID, ATTACHED_DISK, NETWORK_INTERFACE);
  private static final Instance INSTANCE =
      new Instance.Builder(COMPUTE, INSTANCE_ID, MACHINE_TYPE_ID, ATTACHED_DISK, NETWORK_INTERFACE)
          .build();
  private static final Compute.DiskTypeOption DISK_TYPE_OPTION =
      Compute.DiskTypeOption.fields();
  private static final Compute.DiskTypeFilter DISK_TYPE_FILTER =
      Compute.DiskTypeFilter.equals(Compute.DiskTypeField.SELF_LINK, "selfLink");
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_OPTION =
      Compute.DiskTypeListOption.filter(DISK_TYPE_FILTER);
  private static final Compute.DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_OPTION =
      Compute.DiskTypeAggregatedListOption.filter(DISK_TYPE_FILTER);
  private static final Compute.MachineTypeOption MACHINE_TYPE_OPTION =
      Compute.MachineTypeOption.fields();
  private static final Compute.MachineTypeFilter MACHINE_TYPE_FILTER =
      Compute.MachineTypeFilter.equals(Compute.MachineTypeField.SELF_LINK, "selfLink");
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_OPTION =
      Compute.MachineTypeListOption.filter(MACHINE_TYPE_FILTER);
  private static final Compute.MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_OPTION =
      Compute.MachineTypeAggregatedListOption.filter(MACHINE_TYPE_FILTER);
  private static final Compute.RegionOption REGION_OPTION = Compute.RegionOption.fields();
  private static final Compute.RegionFilter REGION_FILTER =
      Compute.RegionFilter.equals(Compute.RegionField.SELF_LINK, "selfLink");
  private static final Compute.RegionListOption REGION_LIST_OPTION =
      Compute.RegionListOption.filter(REGION_FILTER);
  private static final Compute.ZoneOption ZONE_OPTION = Compute.ZoneOption.fields();
  private static final Compute.ZoneFilter ZONE_FILTER =
      Compute.ZoneFilter.equals(Compute.ZoneField.SELF_LINK, "selfLink");
  private static final Compute.ZoneListOption ZONE_LIST_OPTION =
      Compute.ZoneListOption.filter(ZONE_FILTER);
  private static final Compute.LicenseOption LICENSE_OPTION = Compute.LicenseOption.fields();
  private static final Compute.OperationOption OPERATION_OPTION = Compute.OperationOption.fields();
  private static final Compute.OperationFilter OPERATION_FILTER =
      Compute.OperationFilter.equals(Compute.OperationField.SELF_LINK, "selfLink");
  private static final Compute.OperationListOption OPERATION_LIST_OPTION =
      Compute.OperationListOption.filter(OPERATION_FILTER);
  private static final Compute.AddressOption ADDRESS_OPTION = Compute.AddressOption.fields();
  private static final Compute.AddressFilter ADDRESS_FILTER =
      Compute.AddressFilter.equals(Compute.AddressField.SELF_LINK, "selfLink");
  private static final Compute.AddressListOption ADDRESS_LIST_OPTION =
      Compute.AddressListOption.filter(ADDRESS_FILTER);
  private static final Compute.AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_OPTION =
      Compute.AddressAggregatedListOption.filter(ADDRESS_FILTER);
  private static final Compute.SnapshotOption SNAPSHOT_OPTION = Compute.SnapshotOption.fields();
  private static final Compute.SnapshotFilter SNAPSHOT_FILTER =
      Compute.SnapshotFilter.equals(Compute.SnapshotField.SELF_LINK, "selfLink");
  private static final Compute.SnapshotListOption SNAPSHOT_LIST_OPTION =
      Compute.SnapshotListOption.filter(SNAPSHOT_FILTER);
  private static final Compute.ImageOption IMAGE_OPTION = Compute.ImageOption.fields();
  private static final Compute.ImageFilter IMAGE_FILTER =
      Compute.ImageFilter.equals(Compute.ImageField.SELF_LINK, "selfLink");
  private static final Compute.ImageListOption IMAGE_LIST_OPTION =
      Compute.ImageListOption.filter(IMAGE_FILTER);
  private static final Compute.DiskOption DISK_OPTION = Compute.DiskOption.fields();
  private static final Compute.DiskFilter DISK_FILTER =
      Compute.DiskFilter.equals(Compute.DiskField.SELF_LINK, "selfLink");
  private static final Compute.DiskListOption DISK_LIST_OPTION =
      Compute.DiskListOption.filter(DISK_FILTER);
  private static final Compute.DiskAggregatedListOption DISK_AGGREGATED_LIST_OPTION =
      Compute.DiskAggregatedListOption.filter(DISK_FILTER);
  private static final Compute.SubnetworkOption SUBNETWORK_OPTION =
      Compute.SubnetworkOption.fields();
  private static final Compute.SubnetworkFilter SUBNETWORK_FILTER =
      Compute.SubnetworkFilter.equals(Compute.SubnetworkField.SELF_LINK, "selfLink");
  private static final Compute.SubnetworkListOption SUBNETWORK_LIST_OPTION =
      Compute.SubnetworkListOption.filter(SUBNETWORK_FILTER);
  private static final Compute.SubnetworkAggregatedListOption SUBNETWORK_AGGREGATED_LIST_OPTION =
      Compute.SubnetworkAggregatedListOption.filter(SUBNETWORK_FILTER);
  private static final Compute.NetworkOption NETWORK_OPTION =
      Compute.NetworkOption.fields();
  private static final Compute.NetworkFilter NETWORK_FILTER =
      Compute.NetworkFilter.equals(Compute.NetworkField.SELF_LINK, "selfLink");
  private static final Compute.NetworkListOption NETWORK_LIST_OPTION =
      Compute.NetworkListOption.filter(NETWORK_FILTER);
  private static final Compute.InstanceOption INSTANCE_OPTION =
      Compute.InstanceOption.fields();
  private static final Compute.InstanceFilter INSTANCE_FILTER =
      Compute.InstanceFilter.equals(Compute.InstanceField.SELF_LINK, "selfLink");
  private static final Compute.InstanceListOption INSTANCE_LIST_OPTION =
      Compute.InstanceListOption.filter(INSTANCE_FILTER);
  private static final Compute.InstanceAggregatedListOption INSTANCE_AGGREGATED_LIST_OPTION =
      Compute.InstanceAggregatedListOption.filter(INSTANCE_FILTER);

  @Override
  protected Serializable[] serializableObjects() {
    ComputeOptions options = ComputeOptions.newBuilder()
        .setProjectId("p1")
        .setCredentials(NoCredentials.getInstance())
        .build();
    ComputeOptions otherOptions = options.toBuilder()
        .setProjectId("p2")
        .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
        .build();
    return new Serializable[]{DISK_TYPE_ID, DISK_TYPE, MACHINE_TYPE_ID, MACHINE_TYPE, REGION_ID,
        REGION, ZONE_ID, ZONE, LICENSE_ID, LICENSE, DEPRECATION_STATUS, GLOBAL_OPERATION_ID,
        REGION_OPERATION_ID, ZONE_OPERATION_ID, GLOBAL_OPERATION, REGION_OPERATION, ZONE_OPERATION,
        INSTANCE_ID, REGION_FORWARDING_RULE_ID, GLOBAL_FORWARDING_RULE_ID, GLOBAL_ADDRESS_ID,
        REGION_ADDRESS_ID, INSTANCE_USAGE, GLOBAL_FORWARDING_USAGE, REGION_FORWARDING_USAGE,
        ADDRESS_INFO, ADDRESS, DISK_ID, SNAPSHOT_ID, SNAPSHOT_INFO, SNAPSHOT, IMAGE_ID,
        DISK_IMAGE_CONFIGURATION, STORAGE_IMAGE_CONFIGURATION, IMAGE_INFO, IMAGE,
        STANDARD_DISK_CONFIGURATION, IMAGE_DISK_CONFIGURATION, SNAPSHOT_DISK_CONFIGURATION,
        DISK_INFO, DISK, SUBNETWORK_ID, NETWORK_ID, SUBNETWORK_INFO, SUBNETWORK,
        STANDARD_NETWORK_CONFIGURATION, SUBNET_NETWORK_CONFIGURATION, NETWORK_INFO, NETWORK,
        ACCESS_CONFIG, NETWORK_INTERFACE, CREATE_DISK_CONFIGURATION, PERSISTENT_DISK_CONFIGURATION,
        SCRATCH_DISK_CONFIGURATION, ATTACHED_DISK, TAGS, METADATA, SERVICE_ACCOUNT,
        SCHEDULING_OPTIONS, INSTANCE_INFO, INSTANCE, DISK_TYPE_OPTION, DISK_TYPE_FILTER,
        DISK_TYPE_LIST_OPTION, DISK_TYPE_AGGREGATED_LIST_OPTION, MACHINE_TYPE_OPTION,
        MACHINE_TYPE_FILTER, MACHINE_TYPE_LIST_OPTION, MACHINE_TYPE_AGGREGATED_LIST_OPTION,
        REGION_OPTION, REGION_FILTER, REGION_LIST_OPTION, ZONE_OPTION, ZONE_FILTER,
        ZONE_LIST_OPTION, LICENSE_OPTION, OPERATION_OPTION, OPERATION_FILTER, OPERATION_LIST_OPTION,
        ADDRESS_OPTION, ADDRESS_FILTER, ADDRESS_LIST_OPTION, ADDRESS_AGGREGATED_LIST_OPTION,
        SNAPSHOT_OPTION, SNAPSHOT_FILTER, SNAPSHOT_LIST_OPTION, IMAGE_OPTION, IMAGE_FILTER,
        IMAGE_LIST_OPTION, DISK_OPTION, DISK_FILTER, DISK_LIST_OPTION, DISK_AGGREGATED_LIST_OPTION,
        SUBNETWORK_OPTION, SUBNETWORK_FILTER, SUBNETWORK_LIST_OPTION,
        SUBNETWORK_AGGREGATED_LIST_OPTION, NETWORK_OPTION, NETWORK_FILTER, NETWORK_LIST_OPTION,
        INSTANCE_OPTION, INSTANCE_FILTER, INSTANCE_LIST_OPTION, INSTANCE_AGGREGATED_LIST_OPTION,
        options, otherOptions};
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
