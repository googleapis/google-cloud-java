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
import com.google.cloud.compute.v1.CreateSnapshotDiskHttpRequest;
import com.google.cloud.compute.v1.DiskClient;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectZoneDiskName;
import com.google.cloud.compute.v1.Snapshot;
import java.io.IOException;

/**
 * A snippet for Google Cloud Compute Engine showing how to create a snapshot of a disk if the disk
 * exists.
 */
public class CreateSnapshot {
  private static final String DISK_NAME = "test-disk";
  private static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String ZONE = "us-central1-a";
  private static final ProjectZoneDiskName PROJECT_ZONE_DISK_NAME =
      ProjectZoneDiskName.of(DISK_NAME, DEFAULT_PROJECT, ZONE);

  public static void main(String... args) throws IOException {
    Snapshot snapshotResource = Snapshot.newBuilder().setName("test-snapshot").build();
    CreateSnapshotDiskHttpRequest diskHttpRequest =
        CreateSnapshotDiskHttpRequest.newBuilder()
            .setDisk(PROJECT_ZONE_DISK_NAME.toString())
            .setGuestFlush(Boolean.FALSE)
            .setSnapshotResource(snapshotResource)
            .build();
    try (DiskClient diskClient = DiskClient.create()) {
      Operation snapshotDisk = diskClient.createSnapshotDisk(diskHttpRequest);
      if (snapshotDisk.getError() == null) {
        System.out.println("Snapshot was successfully created");
      } else {
        // inspect operation.getErrors()
        throw new RuntimeException("Snapshot creation failed");
      }
    }
  }
}
