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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DnsRecordTest {

  private static final String NAME = "example.com.";
  private static final Integer TTL = 3600;
  private static final DnsRecord.DnsRecordType TYPE = DnsRecord.DnsRecordType.AAAA;
  private static final DnsRecord record = DnsRecord.builder(NAME, TYPE)
          .ttl(TTL)
          .build();

  @Test
  public void testDefaultDnsRecord() {
    DnsRecord record = DnsRecord.builder(NAME, TYPE).build();
    assertEquals(0, record.records().size());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, record.name());
    assertEquals(TTL, record.ttl());
    assertEquals(0, record.records().size());
    // verify that one can add records to the record set
    String testingRecord = "Testing record";
    String anotherTestingRecord = "Another record 123";
    DnsRecord anotherRecord = record.toBuilder()
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
      DnsRecord.builder(NAME, TYPE).ttl(-1);
      fail("A negative value is not acceptable for ttl.");
    } catch (IllegalArgumentException e) {
      // expected
    }
    DnsRecord.builder(NAME, TYPE).ttl(0);
    DnsRecord.builder(NAME, TYPE).ttl(Integer.MAX_VALUE);
  }

  @Test
  public void testEqualsAndNotEquals() {
    DnsRecord clone = record.toBuilder().build();
    assertEquals(clone, record);
    clone = record.toBuilder().addRecord("another record").build();
    assertNotEquals(clone, record);
    final String differentName = "totally different name";
    clone = record.toBuilder().name(differentName).build();
    assertNotEquals(clone, record);
    clone = record.toBuilder().ttl(record.ttl() + 1).build();
    assertNotEquals(clone, record);
    clone = record.toBuilder().type(DnsRecord.DnsRecordType.TXT).build();
    assertNotEquals(clone, record);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = record.hashCode();
    DnsRecord clone = record.toBuilder().build();
    assertEquals(clone.hashCode(), hash);
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(record, DnsRecord.fromPb(record.toPb()));
    DnsRecord partial = DnsRecord.builder(NAME, TYPE).build();
    assertEquals(partial, DnsRecord.fromPb(partial.toPb()));
    partial = DnsRecord.builder(NAME, TYPE).addRecord("test").build();
    assertEquals(partial, DnsRecord.fromPb(partial.toPb()));
    partial = DnsRecord.builder(NAME, TYPE).ttl(15).build();
    assertEquals(partial, DnsRecord.fromPb(partial.toPb()));
  }

  @Test
  public void testToBuilder() {
    assertEquals(record, record.toBuilder().build());
    DnsRecord partial = DnsRecord.builder(NAME, TYPE).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = DnsRecord.builder(NAME, TYPE).addRecord("test").build();
    assertEquals(partial, partial.toBuilder().build());
    partial = DnsRecord.builder(NAME, TYPE).ttl(15).build();
    assertEquals(partial, partial.toBuilder().build());
  }
}