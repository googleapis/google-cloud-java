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

package com.google.cloud.compute;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class InstanceTest {

  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final InstanceId INSTANCE_ID = InstanceId.of("project", "zone", "instance");
  private static final InstanceInfo.Status STATUS = InstanceInfo.Status.RUNNING;
  private static final String STATUS_MESSAGE = "statusMessage";
  private static final Tags TAGS = Tags.newBuilder()
      .setValues("tag1", "tag2")
      .setFingerprint("fingerprint")
      .build();
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
      .setFingerprint("fingerprint")
      .build();
  private static final ServiceAccount SERVICE_ACCOUNT =
      ServiceAccount.of("email", ImmutableList.of("scope1"));
  private static final List<ServiceAccount> SERVICE_ACCOUNTS =
      ImmutableList.of(SERVICE_ACCOUNT);
  private static final SchedulingOptions SCHEDULING_OPTIONS = SchedulingOptions.preemptible();
  private static final String CPU_PLATFORM = "cpuPlatform";

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Instance instance;
  private Instance expectedInstance;

  private void initializeExpectedInstance(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedInstance = new Instance.Builder(serviceMockReturnsOptions, INSTANCE_ID, MACHINE_TYPE,
        ATTACHED_DISK, NETWORK_INTERFACE)
            .setGeneratedId(GENERATED_ID)
            .setCreationTimestamp(CREATION_TIMESTAMP)
            .setDescription(DESCRIPTION)
            .setStatus(STATUS)
            .setStatusMessage(STATUS_MESSAGE)
            .setTags(TAGS)
            .setCanIpForward(CAN_IP_FORWARD)
            .setMetadata(METADATA)
            .setServiceAccounts(SERVICE_ACCOUNTS)
            .setSchedulingOptions(SCHEDULING_OPTIONS)
            .setCpuPlatform(CPU_PLATFORM)
            .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeInstance() {
    instance = new Instance.Builder(compute, INSTANCE_ID, MACHINE_TYPE,
        ATTACHED_DISK, NETWORK_INTERFACE)
            .setGeneratedId(GENERATED_ID)
            .setCreationTimestamp(CREATION_TIMESTAMP)
            .setDescription(DESCRIPTION)
            .setStatus(STATUS)
            .setStatusMessage(STATUS_MESSAGE)
            .setTags(TAGS)
            .setCanIpForward(CAN_IP_FORWARD)
            .setMetadata(METADATA)
            .setServiceAccounts(SERVICE_ACCOUNTS)
            .setSchedulingOptions(SCHEDULING_OPTIONS)
            .setCpuPlatform(CPU_PLATFORM)
            .build();
  }

  @Test
  public void testToBuilder() {
    initializeExpectedInstance(8);
    compareInstance(expectedInstance, expectedInstance.toBuilder().build());
    Instance newInstance = expectedInstance.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", newInstance.getDescription());
    newInstance = newInstance.toBuilder().setDescription("description").build();
    compareInstance(expectedInstance, newInstance);
  }

  @Test
  public void testToBuilderIncomplete() {
    initializeExpectedInstance(5);
    InstanceInfo instanceInfo =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    Instance instance =
        new Instance(serviceMockReturnsOptions, new InstanceInfo.BuilderImpl(instanceInfo));
    compareInstance(instance, instance.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedInstance(2);
    assertEquals(GENERATED_ID, expectedInstance.getGeneratedId());
    assertEquals(INSTANCE_ID, expectedInstance.getInstanceId());
    assertEquals(CREATION_TIMESTAMP, expectedInstance.getCreationTimestamp());
    assertEquals(DESCRIPTION, expectedInstance.getDescription());
    assertEquals(STATUS, expectedInstance.getStatus());
    assertEquals(STATUS_MESSAGE, expectedInstance.getStatusMessage());
    assertEquals(TAGS, expectedInstance.getTags());
    assertEquals(MACHINE_TYPE, expectedInstance.getMachineType());
    assertEquals(CAN_IP_FORWARD, expectedInstance.canIpForward());
    assertEquals(NETWORK_INTERFACES, expectedInstance.getNetworkInterfaces());
    assertEquals(ATTACHED_DISKS, expectedInstance.getAttachedDisks());
    assertEquals(METADATA, expectedInstance.getMetadata());
    assertEquals(SERVICE_ACCOUNTS, expectedInstance.getServiceAccounts());
    assertEquals(SCHEDULING_OPTIONS, expectedInstance.getSchedulingOptions());
    assertEquals(CPU_PLATFORM, expectedInstance.getCpuPlatform());
    assertSame(serviceMockReturnsOptions, expectedInstance.getCompute());
    InstanceInfo instanceInfo =
        InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE, ATTACHED_DISK, NETWORK_INTERFACE);
    Instance instance =
        new Instance(serviceMockReturnsOptions, new InstanceInfo.BuilderImpl(instanceInfo));
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
    assertSame(serviceMockReturnsOptions, instance.getCompute());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedInstance(8);
    compareInstance(expectedInstance,
        Instance.fromPb(serviceMockReturnsOptions, expectedInstance.toPb()));
    Instance instance = new Instance.Builder(serviceMockReturnsOptions, INSTANCE_ID, MACHINE_TYPE,
        ATTACHED_DISK, NETWORK_INTERFACE).build();
    compareInstance(instance, Instance.fromPb(serviceMockReturnsOptions, instance.toPb()));
  }

  @Test
  public void testDeleteOperation() {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.deleteInstance(INSTANCE_ID)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteInstance(INSTANCE_ID)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedInstance(1);
    Compute.InstanceOption[] expectedOptions = {Compute.InstanceOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getInstance(INSTANCE_ID, expectedOptions)).andReturn(expectedInstance);
    replay(compute);
    initializeInstance();
    assertTrue(instance.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedInstance(1);
    Compute.InstanceOption[] expectedOptions = {Compute.InstanceOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getInstance(INSTANCE_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertFalse(instance.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedInstance(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getInstance(INSTANCE_ID)).andReturn(expectedInstance);
    replay(compute);
    initializeInstance();
    Instance updatedInstance = instance.reload();
    compareInstance(expectedInstance, updatedInstance);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getInstance(INSTANCE_ID)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedInstance(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getInstance(INSTANCE_ID,
        Compute.InstanceOption.fields())).andReturn(expectedInstance);
    replay(compute);
    initializeInstance();
    Instance updateInstance = instance.reload(Compute.InstanceOption.fields());
    compareInstance(expectedInstance, updateInstance);
    verify(compute);
  }

  @Test
  public void testAddAccessConfig() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.of("192.168.1.1");
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.addAccessConfig(INSTANCE_ID, "nic0", accessConfig)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.addAccessConfig("nic0", accessConfig));
  }

  @Test
  public void testAddAccessConfig_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.of("192.168.1.1");
    expect(compute.addAccessConfig(INSTANCE_ID, "nic0", accessConfig)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.addAccessConfig("nic0", accessConfig));
  }

  @Test
  public void testAddAccessConfigWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.of("192.168.1.1");
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.addAccessConfig(
        INSTANCE_ID, "nic0", accessConfig, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation,
        instance.addAccessConfig("nic0", accessConfig, Compute.OperationOption.fields()));
  }

  @Test
  public void testAttachDisk() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.attachDisk(INSTANCE_ID, configuration)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.attachDisk(configuration));
  }

  @Test
  public void testAttachDisk_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    expect(compute.attachDisk(INSTANCE_ID, configuration)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.attachDisk(configuration));
  }

  @Test
  public void testAttachDiskWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.attachDisk(INSTANCE_ID, configuration, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.attachDisk(configuration, Compute.OperationOption.fields()));
  }

  @Test
  public void testAttachDiskName() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.attachDisk(INSTANCE_ID, "dev0", configuration)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.attachDisk("dev0", configuration));
  }

  @Test
  public void testAttachDiskName_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    expect(compute.attachDisk(INSTANCE_ID, "dev0", configuration)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.attachDisk("dev0", configuration));
  }

  @Test
  public void testAttachDiskNameWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.attachDisk(INSTANCE_ID, "dev0", configuration, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation,
        instance.attachDisk("dev0", configuration, Compute.OperationOption.fields()));
  }

  @Test
  public void testAttachDiskNameIndex() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.attachDisk(INSTANCE_ID, "dev0", configuration, 1)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.attachDisk("dev0", configuration, 1));
  }

  @Test
  public void testAttachDiskNameIndex_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    expect(compute.attachDisk(INSTANCE_ID, "dev0", configuration, 1)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.attachDisk("dev0", configuration, 1));
  }

  @Test
  public void testAttachDiskNameIndexWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    AttachedDisk.PersistentDiskConfiguration configuration =
        AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.attachDisk(
        INSTANCE_ID, "dev0", configuration, 1, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation,
        instance.attachDisk("dev0", configuration, 1, Compute.OperationOption.fields()));
  }

  @Test
  public void testDeleteAccessConfig() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.deleteAccessConfig(INSTANCE_ID, "nic0", "NAT")).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.deleteAccessConfig("nic0", "NAT"));
  }

  @Test
  public void testDeleteAccessConfig_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteAccessConfig(INSTANCE_ID, "nic0", "NAT")).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.deleteAccessConfig("nic0", "NAT"));
  }

  @Test
  public void testDeleteAccessConfigWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.deleteAccessConfig(
        INSTANCE_ID, "nic0", "NAT", Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation,
        instance.deleteAccessConfig("nic0", "NAT", Compute.OperationOption.fields()));
  }

  @Test
  public void testDetachDisk() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.detachDisk(INSTANCE_ID, "dev0")).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.detachDisk("dev0"));
  }

  @Test
  public void testDetachDisk_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.detachDisk(INSTANCE_ID, "dev0")).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.detachDisk("dev0"));
  }

  @Test
  public void testDetachDiskWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.detachDisk(INSTANCE_ID, "dev0", Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.detachDisk("dev0", Compute.OperationOption.fields()));
  }

  @Test
  public void testGetSerialPortOutputWithNumber() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSerialPortOutput(INSTANCE_ID, 2)).andReturn("output");
    replay(compute);
    initializeInstance();
    assertSame("output", instance.getSerialPortOutput(2));
  }

  @Test
  public void testGetSerialPortOutput() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSerialPortOutput(INSTANCE_ID)).andReturn("output");
    replay(compute);
    initializeInstance();
    assertSame("output", instance.getSerialPortOutput());
  }

  @Test
  public void testResetOperation() {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.reset(INSTANCE_ID)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.reset());
  }

  @Test
  public void testResetNull() {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.reset(INSTANCE_ID)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.reset());
  }

  @Test
  public void testSetDiskAutodelete() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.setDiskAutoDelete(INSTANCE_ID, "dev0", true)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setDiskAutoDelete("dev0", true));
  }

  @Test
  public void testSetDiskAutodelete_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.setDiskAutoDelete(INSTANCE_ID, "dev0", false)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setDiskAutoDelete("dev0", false));
  }

  @Test
  public void testSetDiskAutodeleteWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.setDiskAutoDelete(INSTANCE_ID, "dev0", true, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation,
        instance.setDiskAutoDelete("dev0", true, Compute.OperationOption.fields()));
  }

  @Test
  public void testSetMachineType() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.setMachineType(INSTANCE_ID, MACHINE_TYPE)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setMachineType(MACHINE_TYPE));
  }

  @Test
  public void testSetMachineType_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.setMachineType(INSTANCE_ID, MACHINE_TYPE)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setMachineType(MACHINE_TYPE));
  }

  @Test
  public void testSetMachineTypeWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.setMachineType(INSTANCE_ID, MACHINE_TYPE, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setMachineType(MACHINE_TYPE, Compute.OperationOption.fields()));
  }

  @Test
  public void testSetMetadata() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    Metadata metadata = Metadata.newBuilder().add("k", "v").setFingerprint("fingerprint").build();
    expect(compute.setMetadata(INSTANCE_ID, metadata)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setMetadata(metadata));
  }

  @Test
  public void testSetMetadata_Null() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Metadata metadata = Metadata.newBuilder().add("k", "v").setFingerprint("fingerprint").build();
    expect(compute.setMetadata(INSTANCE_ID, metadata)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setMetadata(metadata));
  }

  @Test
  public void testSetMetadataWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    Metadata metadata = Metadata.newBuilder().add("k", "v").setFingerprint("fingerprint").build();
    expect(compute.setMetadata(INSTANCE_ID, metadata, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setMetadata(metadata, Compute.OperationOption.fields()));
  }

  @Test
  public void testSetMetadataFromMap() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    Map<String, String> metadataMap = ImmutableMap.of("k", "v");
    Metadata metadata =
        Metadata.newBuilder().setValues(metadataMap).setFingerprint("fingerprint").build();
    expect(compute.setMetadata(INSTANCE_ID, metadata)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setMetadata(metadataMap));
  }

  @Test
  public void testSetMetadataFromMap_Null() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Map<String, String> metadataMap = ImmutableMap.of("k", "v");
    Metadata metadata =
        Metadata.newBuilder().setValues(metadataMap).setFingerprint("fingerprint").build();
    expect(compute.setMetadata(INSTANCE_ID, metadata)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setMetadata(metadataMap));
  }

  @Test
  public void testSetMetadataFromMapWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    Map<String, String> metadataMap = ImmutableMap.of("k", "v");
    Metadata metadata =
        Metadata.newBuilder().setValues(metadataMap).setFingerprint("fingerprint").build();
    expect(compute.setMetadata(INSTANCE_ID, metadata, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setMetadata(metadataMap, Compute.OperationOption.fields()));
  }

  @Test
  public void testSetSchedulingOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    expect(compute.setSchedulingOptions(INSTANCE_ID, schedulingOptions)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setSchedulingOptions(schedulingOptions));
  }

  @Test
  public void testSetSchedulingOptions_Null() throws Exception {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    expect(compute.setSchedulingOptions(INSTANCE_ID, schedulingOptions)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setSchedulingOptions(schedulingOptions));
  }

  @Test
  public void testSetSchedulingOptionsWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    expect(compute.setSchedulingOptions(
        INSTANCE_ID, schedulingOptions, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation,
        instance.setSchedulingOptions(schedulingOptions, Compute.OperationOption.fields()));
  }

  @Test
  public void testSetTags() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    Tags tags = Tags.newBuilder().setValues("v1", "v2").setFingerprint("fingerprint").build();
    expect(compute.setTags(INSTANCE_ID, tags)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setTags(tags));
  }

  @Test
  public void testSetTags_Null() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Tags tags = Tags.newBuilder().setValues("v1", "v2").setFingerprint("fingerprint").build();
    expect(compute.setTags(INSTANCE_ID, tags)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setTags(tags));
  }

  @Test
  public void testSetTagsWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    Tags tags = Tags.newBuilder().setValues("v1", "v2").setFingerprint("fingerprint").build();
    expect(compute.setTags(INSTANCE_ID, tags, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setTags(tags, Compute.OperationOption.fields()));
  }

  @Test
  public void testSetTagsFromList() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    List<String> tagList = ImmutableList.of("v1", "v2");
    Tags tags = Tags.newBuilder().setValues(tagList).setFingerprint("fingerprint").build();
    expect(compute.setTags(INSTANCE_ID, tags)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setTags(tagList));
  }

  @Test
  public void testSetTagsFromList_Null() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    List<String> tagList = ImmutableList.of("v1", "v2");
    Tags tags = Tags.newBuilder().setValues(tagList).setFingerprint("fingerprint").build();
    expect(compute.setTags(INSTANCE_ID, tags)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.setTags(tagList));
  }

  @Test
  public void testSetTagsFromListWithOptions() throws Exception {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    List<String> tagList = ImmutableList.of("v1", "v2");
    Tags tags = Tags.newBuilder().setValues(tagList).setFingerprint("fingerprint").build();
    expect(compute.setTags(INSTANCE_ID, tags, Compute.OperationOption.fields()))
        .andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.setTags(tagList, Compute.OperationOption.fields()));
  }

  @Test
  public void testStartOperation() {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.start(INSTANCE_ID)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.start());
  }

  @Test
  public void testStartNull() {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.start(INSTANCE_ID)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.start());
  }

  @Test
  public void testStopOperation() {
    initializeExpectedInstance(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "op"))
        .build();
    expect(compute.stop(INSTANCE_ID)).andReturn(operation);
    replay(compute);
    initializeInstance();
    assertSame(operation, instance.stop());
  }

  @Test
  public void testStopNull() {
    initializeExpectedInstance(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.stop(INSTANCE_ID)).andReturn(null);
    replay(compute);
    initializeInstance();
    assertNull(instance.stop());
  }

  public void compareInstance(Instance expected, Instance value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompute().getOptions(), value.getCompute().getOptions());
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
