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

package com.google.cloud.examples.compute.snippets;

import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressClient;
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.AttachedDiskInitializeParams;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskClient;
import com.google.cloud.compute.v1.InsertDiskHttpRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceClient;
import com.google.cloud.compute.v1.NetworkInterface;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectZoneMachineTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
import java.io.IOException;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a disk and an address. The
 * snippet also shows how to create a virtual machine instance using the created disk and address.
 */
public class CreateAddressDiskAndInstance {
  private static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String ZONE = "us-central1-a";
  private static final String ADDRESS_NAME = "test-address";
  private static final String DEFAULT_IMAGE =
      "https://www.googleapis.com/compute/v1/projects/debian-cloud/global/images/debian-7-wheezy-v20150710";
  private static final String FORMATTED_ZONE = ProjectZoneName.format(DEFAULT_PROJECT, ZONE);
  private static final String REGION = "us-central1";

  public static void main(String... args) throws IOException {
    try (AddressClient addressClient = AddressClient.create()) {
      ProjectRegionName projectRegionName = ProjectRegionName.of(DEFAULT_PROJECT, REGION);
      Address address = Address.newBuilder().setName(ADDRESS_NAME).build();
      Operation operation = addressClient.insertAddress(projectRegionName, address);
      if (operation.getError() == null) {
        System.out.println("Address " + ADDRESS_NAME + " was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Address creation failed");
      }
    }
    // Create a persistent disk
    try (DiskClient diskClient = DiskClient.create()) {
      Disk diskResource =
          Disk.newBuilder()
              .setName("test-disk")
              .setSourceImageId("debian-8-jessie-v20160329")
              .setSizeGb("10")
              .build();
      InsertDiskHttpRequest request =
          InsertDiskHttpRequest.newBuilder()
              .setZone(FORMATTED_ZONE)
              .setDiskResource(diskResource)
              .build();
      Operation response = diskClient.insertDisk(request);
      if (response.getError() == null) {
        System.out.println("Disk " + diskResource.getName() + " was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Disk creation failed");
      }
    }
    // Create a virtual machine instance
    try (InstanceClient instanceClient = InstanceClient.create()) {
      String machineType =
          ProjectZoneMachineTypeName.of("n1-standard-1", DEFAULT_PROJECT, ZONE).toString();
      AttachedDisk disk =
          AttachedDisk.newBuilder()
              .setBoot(true)
              .setAutoDelete(true)
              .setType("PERSISTENT")
              .setDiskSizeGb("10")
              .setInitializeParams(
                  AttachedDiskInitializeParams.newBuilder().setSourceImage(DEFAULT_IMAGE).build())
              .build();
      NetworkInterface networkInterface = NetworkInterface.newBuilder().setName("default").build();
      Instance instanceResource =
          Instance.newBuilder()
              .setName("test-instance")
              .setMachineType(machineType)
              .addDisks(disk)
              .addNetworkInterfaces(networkInterface)
              .build();
      Operation response = instanceClient.insertInstance(FORMATTED_ZONE, instanceResource);
      if (response.getError() == null) {
        System.out.println("Instance " + instanceResource.getName() + " was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Instance creation failed");
      }
    }
  }
}
