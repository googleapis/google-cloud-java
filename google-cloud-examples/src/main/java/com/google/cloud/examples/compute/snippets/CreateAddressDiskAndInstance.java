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
import com.google.cloud.compute.v1.AddressesClient;
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.AttachedDisk.Type;
import com.google.cloud.compute.v1.AttachedDiskInitializeParams;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DisksClient;
import com.google.cloud.compute.v1.InsertDiskRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.NetworkInterface;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a disk and an address. The
 * snippet also shows how to create a virtual machine instance using the created disk and address.
 */
public class CreateAddressDiskAndInstance {
  private static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String ZONE = "us-central1-a";
  private static final String REGION = "us-central1";
  private static final String ADDRESS_NAME = "test-address";

  // Setting image project and image family available in
  // https://cloud.google.com/compute/docs/images/os-details
  private static final String IMAGE_PROJECT = "debian-cloud";
  private static final String IMAGE_FAMILY = "debian-10";
  private static final String DEFAULT_IMAGE =
      String.format(
          "https://www.googleapis.com/compute/v1/projects/%s/global/images/%s",
          IMAGE_PROJECT, IMAGE_FAMILY);

  public static void main(String... args) throws IOException {
    try (AddressesClient addressClient = AddressesClient.create()) {
      Address address = Address.newBuilder().setName(ADDRESS_NAME).build();
      Operation operation = addressClient.insert(DEFAULT_PROJECT, REGION, address);
      if (operation.getError() == null) {
        System.out.println("Address " + ADDRESS_NAME + " was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Address creation failed");
      }
    }
    // Create a persistent disk
    try (DisksClient diskClient = DisksClient.create()) {
      Disk diskResource =
          Disk.newBuilder()
              .setName("test-disk")
              .setSourceImageId("debian-8-jessie-v20160329")
              .setSizeGb(10L)
              .build();
      InsertDiskRequest request =
          InsertDiskRequest.newBuilder()
              .setProject(DEFAULT_PROJECT)
              .setZone(ZONE)
              .setDiskResource(diskResource)
              .build();
      Operation response = diskClient.insert(request);
      if (response.getError() == null) {
        System.out.println("Disk " + diskResource.getName() + " was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Disk creation failed");
      }
    }
    // Create a virtual machine instance
    try (InstancesClient instanceClient = InstancesClient.create()) {
      String machineType = String.format("zones/%s/machineTypes/%s", ZONE, "n1-standard-1");

      AttachedDisk disk =
          AttachedDisk.newBuilder()
              .setBoot(true)
              .setAutoDelete(true)
              .setType(Type.PERSISTENT)
              .setDiskSizeGb(10L)
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
      Operation response = instanceClient.insert(DEFAULT_PROJECT, ZONE, instanceResource);
      if (response.getError() == null) {
        System.out.println("Instance " + instanceResource.getName() + " was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Instance creation failed");
      }
    }
  }
}
