/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.AttachedDisk.PersistentDiskConfiguration;

import org.junit.Test;

import java.util.List;

public class InstanceInfoTest {

  private static final String ID = "42";
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
      AttachedDisk.of(PersistentDiskConfiguration.of(DISK_ID));
  private static final List<AttachedDisk> ATTACHED_DISKS = ImmutableList.of(ATTACHED_DISK);
  private static final Metadata METADATA = Metadata.builder()
      .add("key1", "value1")
      .add("key2", "value2")
      .build();
  private static final ServiceAccount SERVICE_ACCOUNT =
      ServiceAccount.of("email", ImmutableList.of("scope1"));
  private static final List<ServiceAccount> SERVICE_ACCOUNTS = ImmutableList.of(SERVICE_ACCOUNT);
  private static final SchedulingOptions SCHEDULING_OPTIONS = SchedulingOptions.preemptible();
  private static final String CPU_PLATFORM = "cpuPlatform";
  private static final InstanceInfo INSTANCE_INFO = InstanceInfo.builder(INSTANCE_ID, MACHINE_TYPE)
      .id(ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(STATUS)
      .statusMessage(STATUS_MESSAGE)
      .tags(TAGS)
      .canIpForward(CAN_IP_FORWARD)
      .networkInterfaces(NETWORK_INTERFACES)
      .attachedDisks(ATTACHED_DISKS)
      .metadata(METADATA)
      .serviceAccounts(SERVICE_ACCOUNTS)
      .schedulingOptions(SCHEDULING_OPTIONS)
      .cpuPlatform(CPU_PLATFORM)
      .build();

  @Test
  public void testToBuilder() {
    compareInstanceInfo(INSTANCE_INFO, INSTANCE_INFO.toBuilder().build());
    InstanceInfo instance = INSTANCE_INFO.toBuilder().description("newDescription").build();
    assertEquals("newDescription", instance.description());
    instance = instance.toBuilder().description(DESCRIPTION).build();
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
    assertEquals(ID, INSTANCE_INFO.id());
    assertEquals(INSTANCE_ID, INSTANCE_INFO.instanceId());
    assertEquals(CREATION_TIMESTAMP, INSTANCE_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, INSTANCE_INFO.description());
    assertEquals(STATUS, INSTANCE_INFO.status());
    assertEquals(STATUS_MESSAGE, INSTANCE_INFO.statusMessage());
    assertEquals(TAGS, INSTANCE_INFO.tags());
    assertEquals(MACHINE_TYPE, INSTANCE_INFO.machineType());
    assertEquals(CAN_IP_FORWARD, INSTANCE_INFO.canIpForward());
    assertEquals(NETWORK_INTERFACES, INSTANCE_INFO.networkInterfaces());
    assertEquals(ATTACHED_DISKS, INSTANCE_INFO.attachedDisks());
    assertEquals(METADATA, INSTANCE_INFO.metadata());
    assertEquals(SERVICE_ACCOUNTS, INSTANCE_INFO.serviceAccounts());
    assertEquals(SCHEDULING_OPTIONS, INSTANCE_INFO.schedulingOptions());
    assertEquals(CPU_PLATFORM, INSTANCE_INFO.cpuPlatform());
    InstanceInfo instanceInfo = InstanceInfo.builder(INSTANCE_ID, MACHINE_TYPE)
        .id(ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .description(DESCRIPTION)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .tags(TAGS)
        .canIpForward(CAN_IP_FORWARD)
        .networkInterfaces(NETWORK_INTERFACE)
        .attachedDisks(ATTACHED_DISK)
        .metadata(METADATA)
        .serviceAccounts(SERVICE_ACCOUNTS)
        .schedulingOptions(SCHEDULING_OPTIONS)
        .cpuPlatform(CPU_PLATFORM)
        .build();
    compareInstanceInfo(INSTANCE_INFO, instanceInfo);
  }

  @Test
  public void testOf() {
    InstanceInfo instance =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    assertNull(instance.id());
    assertEquals(INSTANCE_ID, instance.instanceId());
    assertNull(instance.creationTimestamp());
    assertNull(instance.description());
    assertNull(instance.status());
    assertNull(instance.statusMessage());
    assertNull(instance.tags());
    assertEquals(MACHINE_TYPE, instance.machineType());
    assertNull(instance.canIpForward());
    assertEquals(NETWORK_INTERFACES, instance.networkInterfaces());
    assertEquals(ATTACHED_DISKS, instance.attachedDisks());
    assertNull(instance.metadata());
    assertNull(instance.serviceAccounts());
    assertNull(instance.schedulingOptions());
    assertNull(instance.cpuPlatform());
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
        AttachedDisk.of(PersistentDiskConfiguration.of(DiskId.of("zone", "disk"))),
        NetworkInterface.of(NetworkId.of("project", "network")));
    InstanceInfo instanceWithProject =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    compareInstanceInfo(instanceWithProject, instance.setProjectId("project"));
  }

  public void compareInstanceInfo(InstanceInfo expected, InstanceInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.id(), value.id());
    assertEquals(expected.instanceId(), value.instanceId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.statusMessage(), value.statusMessage());
    assertEquals(expected.tags(), value.tags());
    assertEquals(expected.machineType(), value.machineType());
    assertEquals(expected.canIpForward(), value.canIpForward());
    assertEquals(expected.networkInterfaces(), value.networkInterfaces());
    assertEquals(expected.attachedDisks(), value.attachedDisks());
    assertEquals(expected.metadata(), value.metadata());
    assertEquals(expected.serviceAccounts(), value.serviceAccounts());
    assertEquals(expected.schedulingOptions(), value.schedulingOptions());
    assertEquals(expected.cpuPlatform(), value.cpuPlatform());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
