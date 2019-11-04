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

/**
 * A client for Google Compute Engine – High-performance, scalable virtual machines.
 *
 * <p>Here's a simple usage example for using google-cloud from App/Compute Engine. This example
 * shows how to create a snapshot from an existing disk. For the complete source code see <a
 * href="https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/compute/snippets/CreateSnapshot.java">
 * CreateSnapshot.java</a>.
 *
 * <pre>{@code
 * Compute compute = ComputeOptions.getDefaultInstance().getService();
 * DiskId diskId = DiskId.of("us-central1-a", "disk-name");
 * Disk disk = compute.getDisk(diskId, Compute.DiskOption.fields());
 * if (disk != null) {
 *   String snapshotName = "disk-name-snapshot";
 *   Operation operation = disk.createSnapshot(snapshotName);
 *   operation = operation.waitFor();
 *   if (operation.getErrors() == null) {
 *     // use snapshot
 *     Snapshot snapshot = compute.getSnapshot(snapshotName);
 *   }
 * }
 * }</pre>
 *
 * <p>This second example shows how to create a virtual machine instance. Complete source code can
 * be found at <a
 * href="https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/compute/snippets/CreateInstance.java">
 * CreateInstance.java</a>.
 *
 * <pre>{@code
 * Compute compute = ComputeOptions.getDefaultInstance().getService();
 * ImageId imageId = ImageId.of("debian-cloud", "debian-8-jessie-v20160329");
 * NetworkId networkId = NetworkId.of("default");
 * AttachedDisk attachedDisk = AttachedDisk.of(AttachedDisk.CreateDiskConfiguration.of(imageId));
 * NetworkInterface networkInterface = NetworkInterface.of(networkId);
 * InstanceId instanceId = InstanceId.of("us-central1-a", "instance-name");
 * MachineTypeId machineTypeId = MachineTypeId.of("us-central1-a", "n1-standard-1");
 * Operation operation =
 *     compute.create(InstanceInfo.of(instanceId, machineTypeId, attachedDisk, networkInterface));
 * operation = operation.waitFor();
 * if (operation.getErrors() == null) {
 *   // use instance
 *   Instance instance = compute.getInstance(instanceId);
 * }
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/compute/">Google Cloud Compute</a>
 */
package com.google.cloud.compute.deprecated;
