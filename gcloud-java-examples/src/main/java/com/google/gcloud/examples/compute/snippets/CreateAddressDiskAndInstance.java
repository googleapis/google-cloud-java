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

package com.google.gcloud.examples.compute.snippets;

import com.google.gcloud.compute.Address;
import com.google.gcloud.compute.AddressInfo;
import com.google.gcloud.compute.AttachedDisk;
import com.google.gcloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.gcloud.compute.Compute;
import com.google.gcloud.compute.ComputeOptions;
import com.google.gcloud.compute.DiskId;
import com.google.gcloud.compute.DiskInfo;
import com.google.gcloud.compute.ImageDiskConfiguration;
import com.google.gcloud.compute.ImageId;
import com.google.gcloud.compute.InstanceId;
import com.google.gcloud.compute.InstanceInfo;
import com.google.gcloud.compute.MachineTypeId;
import com.google.gcloud.compute.NetworkId;
import com.google.gcloud.compute.NetworkInterface;
import com.google.gcloud.compute.NetworkInterface.AccessConfig;
import com.google.gcloud.compute.Operation;
import com.google.gcloud.compute.RegionAddressId;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a disk and an address. The
 * snippet also shows how to create a virtual machine instance using the created disk and address.
 */
public class CreateAddressDiskAndInstance {

  public static void main(String... args) throws InterruptedException {
    // Create a service object
    // Credentials are inferred from the environment.
    Compute compute = ComputeOptions.defaultInstance().service();

    // Create an external region address
    RegionAddressId addressId = RegionAddressId.of("us-central1", "test-address");
    Operation operation = compute.create(AddressInfo.of(addressId));
    // Wait for operation to complete
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // Check operation errors
    operation = operation.reload();
    if (operation.errors() == null) {
      System.out.println("Address " + addressId + " was successfully created");
    } else {
      // inspect operation.errors()
      throw new RuntimeException("Address creation failed");
    }

    // Create a persistent disk
    ImageId imageId = ImageId.of("debian-cloud", "debian-8-jessie-v20160329");
    DiskId diskId = DiskId.of("us-central1-a", "test-disk");
    ImageDiskConfiguration diskConfiguration = ImageDiskConfiguration.of(imageId);
    DiskInfo disk = DiskInfo.of(diskId, diskConfiguration);
    operation = compute.create(disk);
    // Wait for operation to complete
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // Check operation errors
    operation = operation.reload();
    if (operation.errors() == null) {
      System.out.println("Disk " + diskId + " was successfully created");
    } else {
      // inspect operation.errors()
      throw new RuntimeException("Disk creation failed");
    }

    // Create a virtual machine instance
    Address externalIp = compute.getAddress(addressId);
    InstanceId instanceId = InstanceId.of("us-central1-a", "test-instance");
    NetworkId networkId = NetworkId.of("default");
    PersistentDiskConfiguration attachConfiguration =
        PersistentDiskConfiguration.builder(diskId).boot(true).build();
    AttachedDisk attachedDisk = AttachedDisk.of("dev0", attachConfiguration);
    NetworkInterface networkInterface = NetworkInterface.builder(networkId)
        .accessConfigurations(AccessConfig.of(externalIp.address()))
        .build();
    MachineTypeId machineTypeId = MachineTypeId.of("us-central1-a", "n1-standard-1");
    InstanceInfo instance =
        InstanceInfo.of(instanceId, machineTypeId, attachedDisk, networkInterface);
    operation = compute.create(instance);
    // Wait for operation to complete
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // Check operation errors
    operation = operation.reload();
    if (operation.errors() == null) {
      System.out.println("Instance " + instanceId + " was successfully created");
    } else {
      // inspect operation.errors()
      throw new RuntimeException("Instance creation failed");
    }
  }
}
