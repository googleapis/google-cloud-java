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

import com.google.cloud.compute.Compute;
import com.google.cloud.compute.ComputeOptions;
import com.google.cloud.compute.Disk;
import com.google.cloud.compute.DiskId;
import com.google.cloud.compute.Operation;
import com.google.cloud.compute.Operation.OperationError;
import com.google.cloud.compute.Operation.OperationWarning;
import com.google.cloud.compute.Snapshot;

import java.util.List;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a snapshot of a disk if the disk
 * exists.
 */
public class CreateSnapshot {

  public static void main(String... args) throws InterruptedException {
    final Compute compute = ComputeOptions.defaultInstance().service();
    DiskId diskId = DiskId.of("us-central1-a", "disk-name");
    Disk disk = compute.getDisk(diskId, Compute.DiskOption.fields());
    if (disk != null) {
      final String snapshotName = "disk-name-snapshot";
      Operation operation = disk.createSnapshot(snapshotName);
      operation.whenDone(new Operation.CompletionCallback() {
        @Override
        public void success(Operation operation) {
          // use snapshot
          Snapshot snapshot = compute.getSnapshot(snapshotName);
        }

        @Override
        public void error(List<OperationError> errors, List<OperationWarning> warnings) {
          // inspect errors
          throw new RuntimeException("Snaphsot creation failed");
        }
      });
    }
  }
}
