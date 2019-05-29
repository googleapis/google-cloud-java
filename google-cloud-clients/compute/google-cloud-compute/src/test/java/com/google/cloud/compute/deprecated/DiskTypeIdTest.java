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

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DiskTypeIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String DISK_TYPE = "diskType";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/diskTypes/diskType";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    DiskTypeId diskTypeId = DiskTypeId.of(PROJECT, ZONE, DISK_TYPE);
    assertEquals(PROJECT, diskTypeId.getProject());
    assertEquals(ZONE, diskTypeId.getZone());
    assertEquals(DISK_TYPE, diskTypeId.getType());
    assertEquals(URL, diskTypeId.getSelfLink());
    diskTypeId = DiskTypeId.of(ZONE, DISK_TYPE);
    assertNull(diskTypeId.getProject());
    assertEquals(ZONE, diskTypeId.getZone());
    assertEquals(DISK_TYPE, diskTypeId.getType());
  }

  @Test
  public void testToAndFromUrl() {
    DiskTypeId diskTypeId = DiskTypeId.of(PROJECT, ZONE, DISK_TYPE);
    assertSame(diskTypeId, diskTypeId.setProjectId(PROJECT));
    compareDiskTypeId(diskTypeId, DiskTypeId.fromUrl(diskTypeId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid disk type URL");
    DiskTypeId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    DiskTypeId diskTypeId = DiskTypeId.of(PROJECT, ZONE, DISK_TYPE);
    assertSame(diskTypeId, diskTypeId.setProjectId(PROJECT));
    compareDiskTypeId(diskTypeId, DiskTypeId.of(ZONE, DISK_TYPE).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(DiskTypeId.matchesUrl(DiskTypeId.of(PROJECT, ZONE, DISK_TYPE).getSelfLink()));
    assertFalse(DiskTypeId.matchesUrl("notMatchingUrl"));
  }

  private void compareDiskTypeId(DiskTypeId expected, DiskTypeId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getZone(), expected.getZone());
    assertEquals(expected.getType(), expected.getType());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
