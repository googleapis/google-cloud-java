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

package com.google.cloud.examples.compute.snippets;

import com.google.cloud.compute.AttachedDisk;
import com.google.cloud.compute.Compute;
import com.google.cloud.compute.ComputeOptions;
import com.google.cloud.compute.ImageId;
import com.google.cloud.compute.Instance;
import com.google.cloud.compute.InstanceId;
import com.google.cloud.compute.InstanceInfo;
import com.google.cloud.compute.MachineTypeId;
import com.google.cloud.compute.NetworkId;
import com.google.cloud.compute.NetworkInterface;
import com.google.cloud.compute.Operation;

import java.util.concurrent.TimeoutException;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a virtual machine instance.
 */
public class CreateInstance {

  public static void main(String... args) throws InterruptedException, TimeoutException {
    Compute compute = ComputeOptions.defaultInstance().service();
    ImageId imageId = ImageId.of("debian-cloud", "debian-8-jessie-v20160329");
    NetworkId networkId = NetworkId.of("default");
    AttachedDisk attachedDisk = AttachedDisk.of(AttachedDisk.CreateDiskConfiguration.of(imageId));
    NetworkInterface networkInterface = NetworkInterface.of(networkId);
    InstanceId instanceId = InstanceId.of("us-central1-a", "instance-name");
    MachineTypeId machineTypeId = MachineTypeId.of("us-central1-a", "n1-standard-1");
    Operation operation =
        compute.create(InstanceInfo.of(instanceId, machineTypeId, attachedDisk, networkInterface));
    operation = operation.waitFor();
    if (operation.getErrors() == null) {
      // use instance
      Instance instance = compute.getInstance(instanceId);
    }
  }
}
