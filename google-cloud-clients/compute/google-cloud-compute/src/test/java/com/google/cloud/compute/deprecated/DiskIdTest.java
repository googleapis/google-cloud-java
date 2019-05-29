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

public class DiskIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String NAME = "disk";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    DiskId diskId = DiskId.of(PROJECT, ZONE, NAME);
    assertEquals(PROJECT, diskId.getProject());
    assertEquals(ZONE, diskId.getZone());
    assertEquals(NAME, diskId.getDisk());
    assertEquals(URL, diskId.getSelfLink());
    diskId = DiskId.of(ZONE, NAME);
    assertNull(diskId.getProject());
    assertEquals(ZONE, diskId.getZone());
    assertEquals(NAME, diskId.getDisk());
    diskId = DiskId.of(ZoneId.of(ZONE), NAME);
    assertNull(diskId.getProject());
    assertEquals(ZONE, diskId.getZone());
    assertEquals(NAME, diskId.getDisk());
  }

  @Test
  public void testToAndFromUrl() {
    DiskId diskId = DiskId.of(PROJECT, ZONE, NAME);
    compareDiskId(diskId, DiskId.fromUrl(diskId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid disk URL");
    DiskId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    DiskId diskId = DiskId.of(PROJECT, ZONE, NAME);
    assertSame(diskId, diskId.setProjectId(PROJECT));
    compareDiskId(diskId, DiskId.of(ZONE, NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(DiskId.matchesUrl(DiskId.of(PROJECT, ZONE, NAME).getSelfLink()));
    assertFalse(DiskId.matchesUrl("notMatchingUrl"));
  }

  private void compareDiskId(DiskId expected, DiskId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getZone(), expected.getZone());
    assertEquals(expected.getDisk(), expected.getDisk());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
