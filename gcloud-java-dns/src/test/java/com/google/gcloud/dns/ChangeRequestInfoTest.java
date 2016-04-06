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

package com.google.gcloud.dns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.dns.model.Change;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

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
  private static final RecordSet RECORD1 = RecordSet.builder(NAME1, TYPE1).build();
  private static final RecordSet RECORD2 = RecordSet.builder(NAME2, TYPE2).build();
  private static final RecordSet RECORD3 = RecordSet.builder(NAME3, TYPE3).build();
  private static final List<RecordSet> ADDITIONS = ImmutableList.of(RECORD1, RECORD2);
  private static final List<RecordSet> DELETIONS = ImmutableList.of(RECORD3);
  private static final ChangeRequestInfo CHANGE = ChangeRequest.builder()
      .add(RECORD1)
      .add(RECORD2)
      .delete(RECORD3)
      .startTimeMillis(START_TIME_MILLIS)
      .status(STATUS)
      .generatedId(GENERATED_ID)
      .build();

  @Test
  public void testEmptyBuilder() {
    ChangeRequestInfo cr = ChangeRequest.builder().build();
    assertNotNull(cr.deletions());
    assertTrue(cr.deletions().isEmpty());
    assertNotNull(cr.additions());
    assertTrue(cr.additions().isEmpty());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, CHANGE.generatedId());
    assertEquals(STATUS, CHANGE.status());
    assertEquals(START_TIME_MILLIS, CHANGE.startTimeMillis());
    assertEquals(ADDITIONS, CHANGE.additions());
    assertEquals(DELETIONS, CHANGE.deletions());
    List<RecordSet> recordList = ImmutableList.of(RECORD1);
    ChangeRequestInfo another = CHANGE.toBuilder().additions(recordList).build();
    assertEquals(recordList, another.additions());
    assertEquals(CHANGE.deletions(), another.deletions());
    another = CHANGE.toBuilder().deletions(recordList).build();
    assertEquals(recordList, another.deletions());
    assertEquals(CHANGE.additions(), another.additions());
  }

  @Test
  public void testEqualsAndNotEquals() {
    ChangeRequestInfo clone = CHANGE.toBuilder().build();
    assertEquals(CHANGE, clone);
    clone = ChangeRequest.fromPb(CHANGE.toPb());
    assertEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().generatedId("some-other-id").build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().startTimeMillis(CHANGE.startTimeMillis() + 1).build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().add(RECORD3).build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().delete(RECORD1).build();
    assertNotEquals(CHANGE, clone);
    ChangeRequestInfo empty = ChangeRequest.builder().build();
    assertNotEquals(CHANGE, empty);
    assertEquals(empty, ChangeRequest.builder().build());
  }

  @Test
  public void testSameHashCodeOnEquals() {
    ChangeRequestInfo clone = CHANGE.toBuilder().build();
    assertEquals(CHANGE, clone);
    assertEquals(CHANGE.hashCode(), clone.hashCode());
    ChangeRequestInfo empty = ChangeRequest.builder().build();
    assertEquals(empty.hashCode(), ChangeRequest.builder().build().hashCode());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(CHANGE, ChangeRequest.fromPb(CHANGE.toPb()));
    ChangeRequestInfo partial = ChangeRequest.builder().build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().generatedId(GENERATED_ID).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().add(RECORD1).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().delete(RECORD1).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().additions(ADDITIONS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().deletions(DELETIONS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().startTimeMillis(START_TIME_MILLIS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().status(STATUS).build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
  }

  @Test
  public void testToBuilder() {
    assertEquals(CHANGE, CHANGE.toBuilder().build());
    ChangeRequestInfo partial = ChangeRequest.builder().build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().generatedId(GENERATED_ID).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().add(RECORD1).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().delete(RECORD1).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().additions(ADDITIONS).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().deletions(DELETIONS).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().startTimeMillis(START_TIME_MILLIS).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().status(STATUS).build();
    assertEquals(partial, partial.toBuilder().build());
  }

  @Test
  public void testClearAdditions() {
    ChangeRequestInfo clone = CHANGE.toBuilder().clearAdditions().build();
    assertTrue(clone.additions().isEmpty());
    assertFalse(clone.deletions().isEmpty());
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
    assertEquals(CHANGE.additions().size() + 1, clone.additions().size());
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
    assertEquals(CHANGE.deletions().size() + 1, clone.deletions().size());
  }

  @Test
  public void testClearDeletions() {
    ChangeRequestInfo clone = CHANGE.toBuilder().clearDeletions().build();
    assertTrue(clone.deletions().isEmpty());
    assertFalse(clone.additions().isEmpty());
  }

  @Test
  public void testRemoveAddition() {
    ChangeRequestInfo clone = CHANGE.toBuilder().removeAddition(RECORD1).build();
    assertTrue(clone.additions().contains(RECORD2));
    assertFalse(clone.additions().contains(RECORD1));
    assertTrue(clone.deletions().contains(RECORD3));
    clone = CHANGE.toBuilder().removeAddition(RECORD2).removeAddition(RECORD1).build();
    assertFalse(clone.additions().contains(RECORD2));
    assertFalse(clone.additions().contains(RECORD1));
    assertTrue(clone.additions().isEmpty());
    assertTrue(clone.deletions().contains(RECORD3));
  }

  @Test
  public void testRemoveDeletion() {
    ChangeRequestInfo clone = CHANGE.toBuilder().removeDeletion(RECORD3).build();
    assertTrue(clone.deletions().isEmpty());
  }

  @Test
  public void testDateParsing() {
    String startTime = "2016-01-26T18:33:43.512Z"; // obtained from service
    Change change = CHANGE.toPb().setStartTime(startTime);
    ChangeRequestInfo converted = ChangeRequest.fromPb(change);
    assertNotNull(converted.startTimeMillis());
    assertEquals(change, converted.toPb());
    assertEquals(change.getStartTime(), converted.toPb().getStartTime());
  }
}
