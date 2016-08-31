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

package com.google.cloud.dns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.math.BigInteger;

public class ProjectInfoTest {

  private static final String ID = "project-id-123";
  private static final BigInteger NUMBER = new BigInteger("123");
  private static final ProjectInfo.Quota QUOTA = new ProjectInfo.Quota(1, 2, 3, 4, 5, 6);
  private static final ProjectInfo PROJECT_INFO = ProjectInfo.builder()
      .id(ID).number(NUMBER).quota(QUOTA).build();

  @Test
  public void testBuilder() {
    ProjectInfo withId = ProjectInfo.builder().id(ID).build();
    assertEquals(ID, withId.id());
    assertNull(withId.number());
    assertNull(withId.quota());
    ProjectInfo withNumber = ProjectInfo.builder().number(NUMBER).build();
    assertEquals(NUMBER, withNumber.number());
    assertNull(withNumber.quota());
    assertNull(withNumber.id());
    ProjectInfo withQuota = ProjectInfo.builder().quota(QUOTA).build();
    assertEquals(QUOTA, withQuota.quota());
    assertNull(withQuota.id());
    assertNull(withQuota.number());
    assertEquals(QUOTA, PROJECT_INFO.quota());
    assertEquals(NUMBER, PROJECT_INFO.number());
    assertEquals(ID, PROJECT_INFO.id());
  }

  @Test
  public void testQuotaConstructor() {
    assertEquals(1, QUOTA.zones());
    assertEquals(2, QUOTA.resourceRecordsPerRrset());
    assertEquals(3, QUOTA.rrsetAdditionsPerChange());
    assertEquals(4, QUOTA.rrsetDeletionsPerChange());
    assertEquals(5, QUOTA.rrsetsPerZone());
    assertEquals(6, QUOTA.totalRrdataSizePerChange());
  }

  @Test
  public void testEqualsAndNotEqualsQuota() {
    ProjectInfo.Quota clone = new ProjectInfo.Quota(6, 5, 4, 3, 2, 1);
    assertNotEquals(QUOTA, clone);
    clone = ProjectInfo.Quota.fromPb(QUOTA.toPb());
    assertEquals(QUOTA, clone);
  }

  @Test
  public void testSameHashCodeOnEqualsQuota() {
    ProjectInfo.Quota clone = ProjectInfo.Quota.fromPb(QUOTA.toPb());
    assertEquals(QUOTA, clone);
    assertEquals(QUOTA.hashCode(), clone.hashCode());
  }

  @Test
  public void testEqualsAndNotEquals() {
    ProjectInfo clone = ProjectInfo.builder().build();
    assertNotEquals(PROJECT_INFO, clone);
    clone = ProjectInfo.builder().id(PROJECT_INFO.id()).number(PROJECT_INFO.number()).build();
    assertNotEquals(PROJECT_INFO, clone);
    clone = ProjectInfo.builder().id(PROJECT_INFO.id()).quota(PROJECT_INFO.quota()).build();
    assertNotEquals(PROJECT_INFO, clone);
    clone = ProjectInfo.builder().number(PROJECT_INFO.number()).quota(PROJECT_INFO.quota()).build();
    assertNotEquals(PROJECT_INFO, clone);
    clone = ProjectInfo.fromPb(PROJECT_INFO.toPb());
    assertEquals(PROJECT_INFO, clone);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    ProjectInfo clone = ProjectInfo.fromPb(PROJECT_INFO.toPb());
    assertEquals(PROJECT_INFO, clone);
    assertEquals(PROJECT_INFO.hashCode(), clone.hashCode());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(PROJECT_INFO, ProjectInfo.fromPb(PROJECT_INFO.toPb()));
    ProjectInfo partial = ProjectInfo.builder().id(ID).build();
    assertEquals(partial, ProjectInfo.fromPb(partial.toPb()));
    partial = ProjectInfo.builder().number(NUMBER).build();
    assertEquals(partial, ProjectInfo.fromPb(partial.toPb()));
    partial = ProjectInfo.builder().quota(QUOTA).build();
    assertEquals(partial, ProjectInfo.fromPb(partial.toPb()));
    assertNotEquals(PROJECT_INFO, partial);
  }

  @Test
  public void testToAndFromPbQuota() {
    assertEquals(QUOTA, ProjectInfo.Quota.fromPb(QUOTA.toPb()));
    ProjectInfo.Quota wrong = new ProjectInfo.Quota(5, 6, 3, 6, 2, 1);
    assertNotEquals(QUOTA, ProjectInfo.Quota.fromPb(wrong.toPb()));
  }
}
