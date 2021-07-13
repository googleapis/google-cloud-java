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
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.AttachedDisk.Type;
import com.google.cloud.compute.v1.AttachedDiskInitializeParams;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.NetworkInterface;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;

/** A snippet for Google Cloud Compute Engine showing how to create a virtual machine instance. */
public class CreateInstance {
  private static final String ZONE = "us-central1-a";
  private static final String DEFAULT_IMAGE =
      "https://www.googleapis.com/compute/v1/projects/debian-cloud/global/images/debian-7-wheezy-v20150710";
  private static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();

  public static void main(String... args) throws IOException {
    try (InstancesClient instancesClient = InstancesClient.create()) {
      String machineType = String.format("zones/%s/machineTypes/%s", ZONE, "n1-standard-1");
      AttachedDisk disk =
          AttachedDisk.newBuilder()
              .setBoot(true)
              .setAutoDelete(true)
              .setType(Type.PERSISTENT)
              .setInitializeParams(
                  AttachedDiskInitializeParams.newBuilder().setSourceImage(DEFAULT_IMAGE).build())
              .build();
      NetworkInterface networkInterface = NetworkInterface.newBuilder().setName("default").build();
      Instance instanceResource =
          Instance.newBuilder()
              .setName("instance-name")
              .setMachineType(machineType)
              .addDisks(disk)
              .addNetworkInterfaces(networkInterface)
              .build();
      Operation response = instancesClient.insert(DEFAULT_PROJECT, ZONE, instanceResource);
      if (response.getError() == null) {
        System.out.println("Instance was created successfully");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Instance creation failed");
      }
    }
  }
}
