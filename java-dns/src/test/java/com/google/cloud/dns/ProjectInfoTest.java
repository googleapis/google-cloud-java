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

package com.google.cloud.dns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import org.junit.Test;

public class ProjectInfoTest {

  private static final String ID = "project-id-123";
  private static final BigInteger NUMBER = new BigInteger("123");
  private static final ProjectInfo.Quota QUOTA = new ProjectInfo.Quota(1, 2, 3, 4, 5, 6);
  private static final ProjectInfo PROJECT_INFO =
      ProjectInfo.newBuilder().setId(ID).setNumber(NUMBER).setQuota(QUOTA).build();

  @Test
  public void testBuilder() {
    ProjectInfo withId = ProjectInfo.newBuilder().setId(ID).build();
    assertEquals(ID, withId.getId());
    assertNull(withId.getNumber());
    assertNull(withId.getQuota());
    ProjectInfo withNumber = ProjectInfo.newBuilder().setNumber(NUMBER).build();
    assertEquals(NUMBER, withNumber.getNumber());
    assertNull(withNumber.getQuota());
    assertNull(withNumber.getId());
    ProjectInfo withQuota = ProjectInfo.newBuilder().setQuota(QUOTA).build();
    assertEquals(QUOTA, withQuota.getQuota());
    assertNull(withQuota.getId());
    assertNull(withQuota.getNumber());
    assertEquals(QUOTA, PROJECT_INFO.getQuota());
    assertEquals(NUMBER, PROJECT_INFO.getNumber());
    assertEquals(ID, PROJECT_INFO.getId());
  }

  @Test
  public void testQuotaConstructor() {
    assertEquals(1, QUOTA.getZones());
    assertEquals(2, QUOTA.getResourceRecordsPerRrset());
    assertEquals(3, QUOTA.getRrsetAdditionsPerChange());
    assertEquals(4, QUOTA.getRrsetDeletionsPerChange());
    assertEquals(5, QUOTA.getRrsetsPerZone());
    assertEquals(6, QUOTA.getTotalRrdataSizePerChange());
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
    ProjectInfo clone = ProjectInfo.newBuilder().build();
    assertNotEquals(PROJECT_INFO, clone);
    clone =
        ProjectInfo.newBuilder()
            .setId(PROJECT_INFO.getId())
            .setNumber(PROJECT_INFO.getNumber())
            .build();
    assertNotEquals(PROJECT_INFO, clone);
    clone =
        ProjectInfo.newBuilder()
            .setId(PROJECT_INFO.getId())
            .setQuota(PROJECT_INFO.getQuota())
            .build();
    assertNotEquals(PROJECT_INFO, clone);
    clone =
        ProjectInfo.newBuilder()
            .setNumber(PROJECT_INFO.getNumber())
            .setQuota(PROJECT_INFO.getQuota())
            .build();
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
    ProjectInfo partial = ProjectInfo.newBuilder().setId(ID).build();
    assertEquals(partial, ProjectInfo.fromPb(partial.toPb()));
    partial = ProjectInfo.newBuilder().setNumber(NUMBER).build();
    assertEquals(partial, ProjectInfo.fromPb(partial.toPb()));
    partial = ProjectInfo.newBuilder().setQuota(QUOTA).build();
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
