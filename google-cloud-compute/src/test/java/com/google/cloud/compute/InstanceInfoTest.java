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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class InstanceInfoTest {

  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final InstanceId INSTANCE_ID = InstanceId.of("project", "zone", "instance");
  private static final InstanceInfo.Status STATUS = InstanceInfo.Status.RUNNING;
  private static final String STATUS_MESSAGE = "statusMessage";
  private static final Tags TAGS = Tags.of("tag1", "tag2");
  private static final MachineTypeId MACHINE_TYPE = MachineTypeId.of("project", "zone", "type");
  private static final Boolean CAN_IP_FORWARD = true;
  private static final NetworkInterface NETWORK_INTERFACE =
      NetworkInterface.of(NetworkId.of("project", "network"));
  private static final List<NetworkInterface> NETWORK_INTERFACES =
      ImmutableList.of(NETWORK_INTERFACE);
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final AttachedDisk ATTACHED_DISK =
      AttachedDisk.of(AttachedDisk.PersistentDiskConfiguration.of(DISK_ID));
  private static final List<AttachedDisk> ATTACHED_DISKS = ImmutableList.of(ATTACHED_DISK);
  private static final Metadata METADATA = Metadata.newBuilder()
      .add("key1", "value1")
      .add("key2", "value2")
      .build();
  private static final ServiceAccount SERVICE_ACCOUNT =
      ServiceAccount.of("email", ImmutableList.of("scope1"));
  private static final List<ServiceAccount> SERVICE_ACCOUNTS = ImmutableList.of(SERVICE_ACCOUNT);
  private static final SchedulingOptions SCHEDULING_OPTIONS = SchedulingOptions.preemptible();
  private static final String CPU_PLATFORM = "cpuPlatform";
  private static final InstanceInfo INSTANCE_INFO =
      InstanceInfo.newBuilder(INSTANCE_ID, MACHINE_TYPE)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setStatus(STATUS)
          .setStatusMessage(STATUS_MESSAGE)
          .setTags(TAGS)
          .setCanIpForward(CAN_IP_FORWARD)
          .setNetworkInterfaces(NETWORK_INTERFACES)
          .setAttachedDisks(ATTACHED_DISKS)
          .setMetadata(METADATA)
          .setServiceAccounts(SERVICE_ACCOUNTS)
          .setSchedulingOptions(SCHEDULING_OPTIONS)
          .setCpuPlatform(CPU_PLATFORM)
          .build();

  @Test
  public void testToBuilder() {
    compareInstanceInfo(INSTANCE_INFO, INSTANCE_INFO.toBuilder().build());
    InstanceInfo instance = INSTANCE_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", instance.getDescription());
    instance = instance.toBuilder().setDescription(DESCRIPTION).build();
    compareInstanceInfo(INSTANCE_INFO, instance);
  }

  @Test
  public void testToBuilderIncomplete() {
    InstanceInfo instanceInfo = InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK,
        NETWORK_INTERFACE);
    assertEquals(instanceInfo, instanceInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, INSTANCE_INFO.getGeneratedId());
    assertEquals(INSTANCE_ID, INSTANCE_INFO.getInstanceId());
    assertEquals(CREATION_TIMESTAMP, INSTANCE_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, INSTANCE_INFO.getDescription());
    assertEquals(STATUS, INSTANCE_INFO.getStatus());
    assertEquals(STATUS_MESSAGE, INSTANCE_INFO.getStatusMessage());
    assertEquals(TAGS, INSTANCE_INFO.getTags());
    assertEquals(MACHINE_TYPE, INSTANCE_INFO.getMachineType());
    assertEquals(CAN_IP_FORWARD, INSTANCE_INFO.canIpForward());
    assertEquals(NETWORK_INTERFACES, INSTANCE_INFO.getNetworkInterfaces());
    assertEquals(ATTACHED_DISKS, INSTANCE_INFO.getAttachedDisks());
    assertEquals(METADATA, INSTANCE_INFO.getMetadata());
    assertEquals(SERVICE_ACCOUNTS, INSTANCE_INFO.getServiceAccounts());
    assertEquals(SCHEDULING_OPTIONS, INSTANCE_INFO.getSchedulingOptions());
    assertEquals(CPU_PLATFORM, INSTANCE_INFO.getCpuPlatform());
    InstanceInfo instanceInfo = InstanceInfo.newBuilder(INSTANCE_ID, MACHINE_TYPE)
        .setGeneratedId(GENERATED_ID)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setTags(TAGS)
        .setCanIpForward(CAN_IP_FORWARD)
        .setNetworkInterfaces(NETWORK_INTERFACE)
        .setAttachedDisks(ATTACHED_DISK)
        .setMetadata(METADATA)
        .setServiceAccounts(SERVICE_ACCOUNTS)
        .setSchedulingOptions(SCHEDULING_OPTIONS)
        .setCpuPlatform(CPU_PLATFORM)
        .build();
    compareInstanceInfo(INSTANCE_INFO, instanceInfo);
  }

  @Test
  public void testOf() {
    InstanceInfo instance =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    assertNull(instance.getGeneratedId());
    assertEquals(INSTANCE_ID, instance.getInstanceId());
    assertNull(instance.getCreationTimestamp());
    assertNull(instance.getDescription());
    assertNull(instance.getStatus());
    assertNull(instance.getStatusMessage());
    assertNull(instance.getTags());
    assertEquals(MACHINE_TYPE, instance.getMachineType());
    assertNull(instance.canIpForward());
    assertEquals(NETWORK_INTERFACES, instance.getNetworkInterfaces());
    assertEquals(ATTACHED_DISKS, instance.getAttachedDisks());
    assertNull(instance.getMetadata());
    assertNull(instance.getServiceAccounts());
    assertNull(instance.getSchedulingOptions());
    assertNull(instance.getCpuPlatform());
  }

  @Test
  public void testToAndFromPb() {
    compareInstanceInfo(INSTANCE_INFO, InstanceInfo.fromPb(INSTANCE_INFO.toPb()));
    InstanceInfo instance =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    compareInstanceInfo(instance, InstanceInfo.fromPb(instance.toPb()));
  }

  @Test
  public void testSetProjectId() {
    InstanceInfo instance = InstanceInfo.of(
        InstanceId.of("zone", "instance"),
        MachineTypeId.of("zone", "type"),
        AttachedDisk.of(AttachedDisk.PersistentDiskConfiguration.of(DiskId.of("zone", "disk"))),
        NetworkInterface.of(NetworkId.of("project", "network")));
    InstanceInfo instanceWithProject =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    compareInstanceInfo(instanceWithProject, instance.setProjectId("project"));
  }

  public void compareInstanceInfo(InstanceInfo expected, InstanceInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getInstanceId(), value.getInstanceId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getStatusMessage(), value.getStatusMessage());
    assertEquals(expected.getTags(), value.getTags());
    assertEquals(expected.getMachineType(), value.getMachineType());
    assertEquals(expected.canIpForward(), value.canIpForward());
    assertEquals(expected.getNetworkInterfaces(), value.getNetworkInterfaces());
    assertEquals(expected.getAttachedDisks(), value.getAttachedDisks());
    assertEquals(expected.getMetadata(), value.getMetadata());
    assertEquals(expected.getServiceAccounts(), value.getServiceAccounts());
    assertEquals(expected.getSchedulingOptions(), value.getSchedulingOptions());
    assertEquals(expected.getCpuPlatform(), value.getCpuPlatform());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
