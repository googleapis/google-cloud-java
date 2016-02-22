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

package com.google.gcloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DiskTypeIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String DISK_TYPE = "diskType";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/diskTypes/diskType";

  @Test
  public void testOf() {
    DiskTypeId diskTypeId = DiskTypeId.of(PROJECT, ZONE, DISK_TYPE);
    assertEquals(PROJECT, diskTypeId.project());
    assertEquals(ZONE, diskTypeId.zone());
    assertEquals(DISK_TYPE, diskTypeId.diskType());
    assertEquals(URL, diskTypeId.toUrl());
    diskTypeId = DiskTypeId.of(ZONE, DISK_TYPE);
    assertNull(diskTypeId.project());
    assertEquals(ZONE, diskTypeId.zone());
    assertEquals(DISK_TYPE, diskTypeId.diskType());
  }

  @Test
  public void testToAndFromUrl() {
    DiskTypeId diskTypeId = DiskTypeId.of(PROJECT, ZONE, DISK_TYPE);
    compareDiskTypeId(diskTypeId, DiskTypeId.fromUrl(diskTypeId.toUrl()));
  }

  @Test
  public void testSetProjectId() {
    DiskTypeId diskTypeId = DiskTypeId.of(PROJECT, ZONE, DISK_TYPE);
    compareDiskTypeId(diskTypeId, DiskTypeId.of(ZONE, DISK_TYPE).setProjectId(PROJECT));
  }

  private void compareDiskTypeId(DiskTypeId expected, DiskTypeId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.zone(), expected.zone());
    assertEquals(expected.diskType(), expected.diskType());
    assertEquals(expected.toUrl(), expected.toUrl());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
