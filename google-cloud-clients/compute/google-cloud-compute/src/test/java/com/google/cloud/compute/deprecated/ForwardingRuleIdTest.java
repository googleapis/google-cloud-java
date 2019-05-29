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

public class ForwardingRuleIdTest {

  private static final String PROJECT = "project";
  private static final String REGION = "region";
  private static final String NAME = "rule";
  private static final String GLOBAL_URL =
      "https://www.googleapis.com/compute/v1/projects/project/global/forwardingRules/rule";
  private static final String REGION_URL =
      "https://www.googleapis.com/compute/v1/projects/"
          + "project/regions/region/forwardingRules/rule";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    GlobalForwardingRuleId forwardingRuleId = GlobalForwardingRuleId.of(PROJECT, NAME);
    assertEquals(PROJECT, forwardingRuleId.getProject());
    assertEquals(NAME, forwardingRuleId.getRule());
    assertEquals(GLOBAL_URL, forwardingRuleId.getSelfLink());
    assertEquals(ForwardingRuleId.Type.GLOBAL, forwardingRuleId.getType());
    forwardingRuleId = GlobalForwardingRuleId.of(NAME);
    assertNull(forwardingRuleId.getProject());
    assertEquals(NAME, forwardingRuleId.getRule());
    assertEquals(ForwardingRuleId.Type.GLOBAL, forwardingRuleId.getType());
    RegionForwardingRuleId regionForwardingRuleId =
        RegionForwardingRuleId.of(PROJECT, REGION, NAME);
    assertEquals(PROJECT, regionForwardingRuleId.getProject());
    assertEquals(REGION, regionForwardingRuleId.getRegion());
    assertEquals(NAME, regionForwardingRuleId.getRule());
    assertEquals(REGION_URL, regionForwardingRuleId.getSelfLink());
    assertEquals(ForwardingRuleId.Type.REGION, regionForwardingRuleId.getType());
    regionForwardingRuleId = RegionForwardingRuleId.of(RegionId.of(PROJECT, REGION), NAME);
    assertEquals(PROJECT, regionForwardingRuleId.getProject());
    assertEquals(REGION, regionForwardingRuleId.getRegion());
    assertEquals(NAME, regionForwardingRuleId.getRule());
    assertEquals(REGION_URL, regionForwardingRuleId.getSelfLink());
    assertEquals(ForwardingRuleId.Type.REGION, regionForwardingRuleId.getType());
    regionForwardingRuleId = RegionForwardingRuleId.of(REGION, NAME);
    assertNull(regionForwardingRuleId.getProject());
    assertEquals(REGION, regionForwardingRuleId.getRegion());
    assertEquals(NAME, regionForwardingRuleId.getRule());
    assertEquals(ForwardingRuleId.Type.REGION, regionForwardingRuleId.getType());
  }

  @Test
  public void testToAndFromUrlGlobal() {
    GlobalForwardingRuleId forwardingRuleId = GlobalForwardingRuleId.of(PROJECT, NAME);
    compareGlobalForwardingRuleId(
        forwardingRuleId, GlobalForwardingRuleId.fromUrl(forwardingRuleId.getSelfLink()));
    RegionForwardingRuleId regionForwardingRuleId =
        RegionForwardingRuleId.of(PROJECT, REGION, NAME);
    compareRegionForwardingRuleId(
        regionForwardingRuleId,
        RegionForwardingRuleId.fromUrl(regionForwardingRuleId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid global forwarding rule URL");
    GlobalForwardingRuleId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testToAndFromUrlRegion() {
    RegionForwardingRuleId regionForwardingRuleId =
        RegionForwardingRuleId.of(PROJECT, REGION, NAME);
    compareRegionForwardingRuleId(
        regionForwardingRuleId,
        RegionForwardingRuleId.fromUrl(regionForwardingRuleId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid region forwarding rule URL");
    RegionForwardingRuleId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    GlobalForwardingRuleId forwardingRuleId = GlobalForwardingRuleId.of(PROJECT, NAME);
    assertSame(forwardingRuleId, forwardingRuleId.setProjectId(PROJECT));
    compareGlobalForwardingRuleId(
        forwardingRuleId, GlobalForwardingRuleId.of(NAME).setProjectId(PROJECT));
    RegionForwardingRuleId regionForwardingRuleId =
        RegionForwardingRuleId.of(PROJECT, REGION, NAME);
    assertSame(regionForwardingRuleId, regionForwardingRuleId.setProjectId(PROJECT));
    compareRegionForwardingRuleId(
        regionForwardingRuleId, RegionForwardingRuleId.of(REGION, NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(
        GlobalForwardingRuleId.matchesUrl(GlobalForwardingRuleId.of(PROJECT, NAME).getSelfLink()));
    assertFalse(GlobalForwardingRuleId.matchesUrl("notMatchingUrl"));
    assertTrue(
        RegionForwardingRuleId.matchesUrl(
            RegionForwardingRuleId.of(PROJECT, REGION, NAME).getSelfLink()));
    assertFalse(RegionForwardingRuleId.matchesUrl("notMatchingUrl"));
  }

  private void compareGlobalForwardingRuleId(
      GlobalForwardingRuleId expected, GlobalForwardingRuleId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getRule(), expected.getRule());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }

  private void compareRegionForwardingRuleId(
      RegionForwardingRuleId expected, RegionForwardingRuleId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getRegion(), expected.getRegion());
    assertEquals(expected.getRule(), expected.getRule());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
