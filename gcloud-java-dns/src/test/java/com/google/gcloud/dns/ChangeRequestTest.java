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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class ChangeRequestTest {

  private static final String ID = "cr-id-1";
  private static final Long START_TIME_MILLIS = 12334567890L;
  private static final ChangeRequest.Status STATUS = ChangeRequest.Status.PENDING;
  private static final String NAME1 = "dns1";
  private static final DnsRecord.Type TYPE1 = DnsRecord.Type.A;
  private static final String NAME2 = "dns2";
  private static final DnsRecord.Type TYPE2 = DnsRecord.Type.AAAA;
  private static final String NAME3 = "dns3";
  private static final DnsRecord.Type TYPE3 = DnsRecord.Type.MX;
  private static final DnsRecord RECORD1 = DnsRecord.builder(NAME1, TYPE1).build();
  private static final DnsRecord RECORD2 = DnsRecord.builder(NAME2, TYPE2).build();
  private static final DnsRecord RECORD3 = DnsRecord.builder(NAME3, TYPE3).build();
  private static final List<DnsRecord> ADDITIONS = ImmutableList.of(RECORD1, RECORD2);
  private static final List<DnsRecord> DELETIONS = ImmutableList.of(RECORD3);
  private static final ChangeRequest CHANGE = ChangeRequest.builder()
      .add(RECORD1)
      .add(RECORD2)
      .delete(RECORD3)
      .startTimeMillis(START_TIME_MILLIS)
      .status(STATUS)
      .id(ID)
      .build();

  @Test
  public void testEmptyBuilder() {
    ChangeRequest cr = ChangeRequest.builder().build();
    assertNotNull(cr.deletions());
    assertTrue(cr.deletions().isEmpty());
    assertNotNull(cr.additions());
    assertTrue(cr.additions().isEmpty());
  }

  @Test
  public void testBuilder() {
    assertEquals(ID, CHANGE.id());
    assertEquals(STATUS, CHANGE.status());
    assertEquals(START_TIME_MILLIS, CHANGE.startTimeMillis());
    assertEquals(ADDITIONS, CHANGE.additions());
    assertEquals(DELETIONS, CHANGE.deletions());
    List<DnsRecord> recordList = ImmutableList.of(RECORD1);
    ChangeRequest another = CHANGE.toBuilder().additions(recordList).build();
    assertEquals(recordList, another.additions());
    assertEquals(CHANGE.deletions(), another.deletions());
    another = CHANGE.toBuilder().deletions(recordList).build();
    assertEquals(recordList, another.deletions());
    assertEquals(CHANGE.additions(), another.additions());
  }

  @Test
  public void testEqualsAndNotEquals() {
    ChangeRequest clone = CHANGE.toBuilder().build();
    assertEquals(CHANGE, clone);
    clone = ChangeRequest.fromPb(CHANGE.toPb());
    assertEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().id("some-other-id").build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().startTimeMillis(CHANGE.startTimeMillis() + 1).build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().add(RECORD3).build();
    assertNotEquals(CHANGE, clone);
    clone = CHANGE.toBuilder().delete(RECORD1).build();
    assertNotEquals(CHANGE, clone);
    ChangeRequest empty = ChangeRequest.builder().build();
    assertNotEquals(CHANGE, empty);
    assertEquals(empty, ChangeRequest.builder().build());
  }

  @Test
  public void testSameHashCodeOnEquals() {
    ChangeRequest clone = CHANGE.toBuilder().build();
    assertEquals(CHANGE, clone);
    assertEquals(CHANGE.hashCode(), clone.hashCode());
    ChangeRequest empty = ChangeRequest.builder().build();
    assertEquals(empty.hashCode(), ChangeRequest.builder().build().hashCode());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(CHANGE, ChangeRequest.fromPb(CHANGE.toPb()));
    ChangeRequest partial = ChangeRequest.builder().build();
    assertEquals(partial, ChangeRequest.fromPb(partial.toPb()));
    partial = ChangeRequest.builder().id(ID).build();
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
    ChangeRequest partial = ChangeRequest.builder().build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ChangeRequest.builder().id(ID).build();
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
    ChangeRequest clone = CHANGE.toBuilder().clearAdditions().build();
    assertTrue(clone.additions().isEmpty());
    assertFalse(clone.deletions().isEmpty());
  }

  @Test
  public void testAddAddition() {
    try {
      CHANGE.toBuilder().add(null).build();
      fail("Should not be able to add null DnsRecord.");
    } catch (NullPointerException e) {
      // expected
    }
    ChangeRequest clone = CHANGE.toBuilder().add(RECORD1).build();
    assertEquals(CHANGE.additions().size() + 1, clone.additions().size());
  }

  @Test
  public void testAddDeletion() {
    try {
      ChangeRequest clone = CHANGE.toBuilder().delete(null).build();
      fail("Should not be able to delete null DnsRecord.");
    } catch (NullPointerException e) {
      // expected
    }
    ChangeRequest clone = CHANGE.toBuilder().delete(RECORD1).build();
    assertEquals(CHANGE.deletions().size() + 1, clone.deletions().size());
  }

  @Test
  public void testClearDeletions() {
    ChangeRequest clone = CHANGE.toBuilder().clearDeletions().build();
    assertTrue(clone.deletions().isEmpty());
    assertFalse(clone.additions().isEmpty());
  }

  @Test
  public void testRemoveAddition() {
    ChangeRequest clone = CHANGE.toBuilder().removeAddition(RECORD1).build();
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
    ChangeRequest clone = CHANGE.toBuilder().removeDeletion(RECORD3).build();
    assertFalse(clone.deletions().contains(RECORD3));
    assertTrue(clone.deletions().isEmpty());
  }

  @Test
  public void testDateParsing() {
    String startTime = "2016-01-26T18:33:43.512Z"; // obtained from service
    com.google.api.services.dns.model.Change change = CHANGE.toPb().setStartTime(startTime);
    ChangeRequest converted = ChangeRequest.fromPb(change);
    assertNotNull(converted.startTimeMillis());
    assertEquals(change, converted.toPb());
    assertEquals(change.getStartTime(), converted.toPb().getStartTime());
  }

  @Test
  public void testStatusTranslation() {
    assertEquals(ChangeRequest.Status.DONE, ChangeRequest.Status.translate("done"));
    assertEquals(ChangeRequest.Status.PENDING, ChangeRequest.Status.translate("pending"));
    try {
      ChangeRequest.Status.translate("another");
      fail("Such a status does not exist.");
    } catch (IllegalArgumentException e) {
      // expected
    }
  }
}
