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

public class SnapshotIdTest {

  private static final String PROJECT = "project";
  private static final String NAME = "snapshot";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/global/snapshots/snapshot";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    SnapshotId snapshotId = SnapshotId.of(PROJECT, NAME);
    assertEquals(PROJECT, snapshotId.getProject());
    assertEquals(NAME, snapshotId.getSnapshot());
    assertEquals(URL, snapshotId.getSelfLink());
    snapshotId = SnapshotId.of(NAME);
    assertNull(snapshotId.getProject());
    assertEquals(NAME, snapshotId.getSnapshot());
  }

  @Test
  public void testToAndFromUrl() {
    SnapshotId snapshotId = SnapshotId.of(PROJECT, NAME);
    compareSnapshotId(snapshotId, SnapshotId.fromUrl(snapshotId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid snapshot URL");
    SnapshotId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    SnapshotId snapshotId = SnapshotId.of(PROJECT, NAME);
    assertSame(snapshotId, snapshotId.setProjectId(PROJECT));
    compareSnapshotId(snapshotId, SnapshotId.of(NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(SnapshotId.matchesUrl(SnapshotId.of(PROJECT, NAME).getSelfLink()));
    assertFalse(SnapshotId.matchesUrl("notMatchingUrl"));
  }

  private void compareSnapshotId(SnapshotId expected, SnapshotId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getSnapshot(), expected.getSnapshot());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
