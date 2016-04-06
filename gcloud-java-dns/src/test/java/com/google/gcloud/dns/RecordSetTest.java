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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class RecordSetTest {

  private static final String NAME = "example.com.";
  private static final Integer TTL = 3600;
  private static final TimeUnit UNIT = TimeUnit.HOURS;
  private static final Integer UNIT_TTL = 1;
  private static final RecordSet.Type TYPE = RecordSet.Type.AAAA;
  private static final RecordSet recordSet = RecordSet.builder(NAME, TYPE)
      .ttl(UNIT_TTL, UNIT)
      .build();

  @Test
  public void testDefaultDnsRecord() {
    RecordSet recordSet = RecordSet.builder(NAME, TYPE).build();
    assertEquals(0, recordSet.records().size());
    assertEquals(TYPE, recordSet.type());
    assertEquals(NAME, recordSet.name());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, recordSet.name());
    assertEquals(TTL, recordSet.ttl());
    assertEquals(TYPE, recordSet.type());
    assertEquals(0, recordSet.records().size());
    // verify that one can add records to the record set
    String testingRecord = "Testing recordSet";
    String anotherTestingRecord = "Another recordSet 123";
    RecordSet anotherRecord = recordSet.toBuilder()
        .addRecord(testingRecord)
        .addRecord(anotherTestingRecord)
        .build();
    assertEquals(2, anotherRecord.records().size());
    assertTrue(anotherRecord.records().contains(testingRecord));
    assertTrue(anotherRecord.records().contains(anotherTestingRecord));
  }

  @Test
  public void testValidTtl() {
    try {
      RecordSet.builder(NAME, TYPE).ttl(-1, TimeUnit.SECONDS);
      fail("A negative value is not acceptable for ttl.");
    } catch (IllegalArgumentException e) {
      // expected
    }
    RecordSet.builder(NAME, TYPE).ttl(0, TimeUnit.SECONDS);
    RecordSet.builder(NAME, TYPE).ttl(Integer.MAX_VALUE, TimeUnit.SECONDS);
    try {
      RecordSet.builder(NAME, TYPE).ttl(Integer.MAX_VALUE, TimeUnit.HOURS);
      fail("This value is too large for int.");
    } catch (IllegalArgumentException e) {
      // expected
    }
    RecordSet record = RecordSet.builder(NAME, TYPE).ttl(UNIT_TTL, UNIT).build();
    assertEquals(TTL, record.ttl());
  }

  @Test
  public void testEqualsAndNotEquals() {
    RecordSet clone = recordSet.toBuilder().build();
    assertEquals(recordSet, clone);
    clone = recordSet.toBuilder().addRecord("another recordSet").build();
    assertNotEquals(recordSet, clone);
    String differentName = "totally different name";
    clone = recordSet.toBuilder().name(differentName).build();
    assertNotEquals(recordSet, clone);
    clone = recordSet.toBuilder().ttl(recordSet.ttl() + 1, TimeUnit.SECONDS).build();
    assertNotEquals(recordSet, clone);
    clone = recordSet.toBuilder().type(RecordSet.Type.TXT).build();
    assertNotEquals(recordSet, clone);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = recordSet.hashCode();
    RecordSet clone = recordSet.toBuilder().build();
    assertEquals(clone.hashCode(), hash);
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(recordSet, RecordSet.fromPb(recordSet.toPb()));
    RecordSet partial = RecordSet.builder(NAME, TYPE).build();
    assertEquals(partial, RecordSet.fromPb(partial.toPb()));
    partial = RecordSet.builder(NAME, TYPE).addRecord("test").build();
    assertEquals(partial, RecordSet.fromPb(partial.toPb()));
    partial = RecordSet.builder(NAME, TYPE).ttl(15, TimeUnit.SECONDS).build();
    assertEquals(partial, RecordSet.fromPb(partial.toPb()));
  }

  @Test
  public void testToBuilder() {
    assertEquals(recordSet, recordSet.toBuilder().build());
    RecordSet partial = RecordSet.builder(NAME, TYPE).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = RecordSet.builder(NAME, TYPE).addRecord("test").build();
    assertEquals(partial, partial.toBuilder().build());
    partial = RecordSet.builder(NAME, TYPE).ttl(15, TimeUnit.SECONDS).build();
    assertEquals(partial, partial.toBuilder().build());
  }

  @Test
  public void clearRecordSet() {
    // make sure that we are starting not empty
    RecordSet clone =
        recordSet.toBuilder().addRecord("record").addRecord("another").build();
    assertNotEquals(0, clone.records().size());
    clone = clone.toBuilder().clearRecords().build();
    assertEquals(0, clone.records().size());
    clone.toPb(); // verify that pb allows it
  }

  @Test
  public void removeFromRecordSet() {
    String recordString = "record";
    // make sure that we are starting not empty
    RecordSet clone = recordSet.toBuilder().addRecord(recordString).build();
    assertNotEquals(0, clone.records().size());
    clone = clone.toBuilder().removeRecord(recordString).build();
    assertEquals(0, clone.records().size());
  }
}
