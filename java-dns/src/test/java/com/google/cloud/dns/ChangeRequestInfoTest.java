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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.dns.model.Change;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class ChangeRequestInfoTest {

  private static final String GENERATED_ID = "cr-id-1";
  private static final Long START_TIME_MILLIS = 12334567890L;
  private static final ChangeRequest.Status STATUS = ChangeRequest.Status.PENDING;
  private static final String NAME1 = "dns1";
  private static final RecordSet.Type TYPE1 = RecordSet.Type.A;
  private static final String NAME2 = "dns2";
  private static final RecordSet.Type TYPE2 = RecordSet.Type.AAAA;
  private static final String NAME3 = "dns3";
  private static final RecordSet.Type TYPE3 = RecordSet.Type.MX;
  private static final RecordSet RECORD1 = RecordSet.newBuilder(NAME1, TYPE1).build();
  private static final RecordSet RECORD2 = RecordSet.newBuilder(NAME2, TYPE2).build();
  private static final RecordSet RECORD3 = RecordSet.newBuilder(NAME3, TYPE3).build();
  private static final List<RecordSet> ADDITIONS = ImmutableList.of(RECORD1, RECORD2);
  private static final List<RecordSet> DELETIONS = ImmutableList.of(RECORD3);
  private static final ChangeRequestInfo CHANGE =
      ChangeRequest.newBuilder()
          .add(RECORD1)
          .add(RECORD2)
          .delete(RECORD3)
          .setStartTime(START_TIME_MILLIS)
          .setStatus(STATUS)
          .setGeneratedId(GENERATED_ID)
          .build();

  @Test
  public void testEmptyBuilder() {
    ChangeRequestInfo cr = ChangeRequest.newBuilder().build();
    assertNotNull(cr.getDeletions());
    assertTrue(cr.getDeletions().isEmpty());
    assertNotNull(cr.getAdditions());
    assertTrue(cr.getAdditions().isEmpty());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, CHANGE.getGeneratedId());
    assertEquals(STATUS, CHANGE.status());
    assertEquals(START_TIME_MILLIS, CHANGE.getStartTimeMillis());
    assertEquals(ADDITIONS, CHANGE.getAdditions());
    assertEquals(DELETIONS, CHANGE.getDeletions());
    List<RecordSet> recordList = ImmutableList.of(RECORD1);
    ChangeRequestInfo another = CHANGE.toBuilder().setAdditions(recordList).build();
    assertEquals(recordList, another.getAdditions());
    assertEquals(CHANGE.getDeletions(), another.getDeletions());
    another = CHANGE.toBuilder().setDeletions(recordList).build();
    assertEquals(recordList, another.getDeletions());
    assertEquals(CHANGE.getAdditions(), another.getAdditions());
  }

  @Test
  public void testEqualsAndNotEquals() {
    ChangeRequestInfo clone = CHANGE.toBuilder().build();
    assertEquals(CHANGE, clone);
    clone = ChangeRequest.fromPb(CHANGE.toPb());
    assertEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().setGeneratedId("some-other-id").build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().setStartTime(CHANGE.getStartTimeMillis() + 1).build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().add(RECORD3).build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().delete(RECORD1).build();
    assertNotEquals(CHANGE, clone);
    ChangeRequestInfo empty = ChangeRequest.newBuilder().build();
    assertNotEquals(CHANGE, empty);
    assertEquals(empty, ChangeRequest.newBuilder().build());
  }

  @Test
  public void testSameHashCodeOnEquals() {
    ChangeRequestInfo clone = CHANGE.toBuilder().build();
    assertEquals(CHANGE, clone);
    assertEquals(CHANGE.hashCode(), clone.hashCode());
    ChangeRequestInfo empty = ChangeRequest.newBuilder().build();
    assertEquals(empty.hashCode(), ChangeRequest.newBuilder().build().hashCode());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(CHANGE, ChangeRequest.fromPb(CHANGE.toPb()));
    ChangeRequestInfo partial = ChangeRequest.newBuilder().build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().setGeneratedId(GENERATED_ID).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().add(RECORD1).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().delete(RECORD1).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().setAdditions(ADDITIONS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().setDeletions(DELETIONS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().setStartTime(START_TIME_MILLIS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.newBuilder().setStatus(STATUS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
  }

  @Test
  public void testToBuilder() {
    assertEquals(CHANGE, CHANGE.toBuilder().build());
    ChangeRequestInfo partial = ChangeRequest.newBuilder().build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().setGeneratedId(GENERATED_ID).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().add(RECORD1).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().delete(RECORD1).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().setAdditions(ADDITIONS).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().setDeletions(DELETIONS).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().setStartTime(START_TIME_MILLIS).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.newBuilder().setStatus(STATUS).build();
    assertEquals(partial, partial.toBuilder().build());
  }

  @Test
  public void testClearAdditions() {
    ChangeRequestInfo clone = CHANGE.toBuilder().clearAdditions().build();
    assertTrue(clone.getAdditions().isEmpty());
    assertFalse(clone.getDeletions().isEmpty());
  }

  @Test
  public void testAddAddition() {
    try {
      CHANGE.toBuilder().add(null);
      fail("Should not be able to add null RecordSet.");
    } catch (NullPointerException e) {
      // expected
    }
    ChangeRequestInfo clone = CHANGE.toBuilder().add(RECORD1).build();
    assertEquals(CHANGE.getAdditions().size() + 1, clone.getAdditions().size());
  }

  @Test
  public void testAddDeletion() {
    try {
      CHANGE.toBuilder().delete(null);
      fail("Should not be able to delete null RecordSet.");
    } catch (NullPointerException e) {
      // expected
    }
    ChangeRequestInfo clone = CHANGE.toBuilder().delete(RECORD1).build();
    assertEquals(CHANGE.getDeletions().size() + 1, clone.getDeletions().size());
  }

  @Test
  public void testClearDeletions() {
    ChangeRequestInfo clone = CHANGE.toBuilder().clearDeletions().build();
    assertTrue(clone.getDeletions().isEmpty());
    assertFalse(clone.getAdditions().isEmpty());
  }

  @Test
  public void testRemoveAddition() {
    ChangeRequestInfo clone = CHANGE.toBuilder().removeAddition(RECORD1).build();
    assertTrue(clone.getAdditions().contains(RECORD2));
    assertFalse(clone.getAdditions().contains(RECORD1));
    assertTrue(clone.getDeletions().contains(RECORD3));
    clone = CHANGE.toBuilder().removeAddition(RECORD2).removeAddition(RECORD1).build();
    assertFalse(clone.getAdditions().contains(RECORD2));
    assertFalse(clone.getAdditions().contains(RECORD1));
    assertTrue(clone.getAdditions().isEmpty());
    assertTrue(clone.getDeletions().contains(RECORD3));
  }

  @Test
  public void testRemoveDeletion() {
    ChangeRequestInfo clone = CHANGE.toBuilder().removeDeletion(RECORD3).build();
    assertTrue(clone.getDeletions().isEmpty());
  }

  @Test
  public void testDateParsing() {
    String startTime = "2016-01-26T18:33:43.512Z"; // obtained from service
    Change change = CHANGE.toPb().setStartTime(startTime);
    ChangeRequestInfo converted = ChangeRequest.fromPb(change);
    assertNotNull(converted.getStartTimeMillis());
    assertEquals(change, converted.toPb());
    assertEquals(change.getStartTime(), converted.toPb().getStartTime());
  }
}
