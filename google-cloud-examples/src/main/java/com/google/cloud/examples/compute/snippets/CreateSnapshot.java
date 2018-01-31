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

import com.google.cloud.compute.deprecated.Compute;
import com.google.cloud.compute.deprecated.ComputeOptions;
import com.google.cloud.compute.deprecated.Disk;
import com.google.cloud.compute.deprecated.DiskId;
import com.google.cloud.compute.deprecated.Operation;
import com.google.cloud.compute.deprecated.Snapshot;

import java.util.concurrent.TimeoutException;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a snapshot of a disk if the disk
 * exists.
 */
public class CreateSnapshot {

  public static void main(String... args) throws InterruptedException, TimeoutException {
    Compute compute = ComputeOptions.getDefaultInstance().getService();
    DiskId diskId = DiskId.of("us-central1-a", "disk-name");
    Disk disk = compute.getDisk(diskId, Compute.DiskOption.fields());
    if (disk != null) {
      String snapshotName = "disk-name-snapshot";
      Operation operation = disk.createSnapshot(snapshotName);
      operation = operation.waitFor();
      if (operation.getErrors() == null) {
        // use snapshot
        Snapshot snapshot = compute.getSnapshot(snapshotName);
      }
    }
  }
}
