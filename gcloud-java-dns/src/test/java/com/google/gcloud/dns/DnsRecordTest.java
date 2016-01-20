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

import org.junit.BeforeClass;
import org.junit.Test;

import org.easymock.EasyMock;

public class DnsRecordTest {

  private static final String NAME = "example.com.";
  private static final Integer TTL = 3600;
  private static final DnsRecord.DnsRecordType TYPE = DnsRecord.DnsRecordType.AAAA;
  private static final Long ZONE_ID = 12L;
  private static final String ZONE_NAME = "name";
  // the following is initialized in @BeforeClass setUp()
  private static DnsRecord record;
  private static ManagedZoneInfo managedZoneInfoMock;

  @BeforeClass
  public static void setUp() {
    managedZoneInfoMock = EasyMock.createMock(ManagedZoneInfo.class);
    EasyMock.expect(managedZoneInfoMock.id()).andReturn(ZONE_ID);
    EasyMock.expect(managedZoneInfoMock.name()).andReturn(ZONE_NAME);
    EasyMock.replay(managedZoneInfoMock);
    record = DnsRecord.builder()
            .name(NAME)
            .ttl(TTL)
            .managedZone(managedZoneInfoMock)
            .build();
  }

  @Test
  public void testDefaultDnsRecord() {
    DnsRecord record = DnsRecord.builder().build();
    assertEquals(0, record.rrdatas().size());
  }

  @Test
  public void testBuilder() {

    assertEquals(NAME, record.name());
    assertEquals(TTL, record.ttl());

    assertEquals(ZONE_ID, record.zoneId()); // this was never assigned
    assertEquals(ZONE_NAME, record.zoneName());
    assertEquals(0, record.rrdatas().size());
    // verify that one can add records to the record set
    String testingRecord = "Testing record";
    String anotherTestingRecord = "Another record 123";
    String differentName = ZONE_NAME + "something";
    DnsRecord anotherRecord = record.toBuilder()
            .add(testingRecord)
            .add(anotherTestingRecord)
            .managedZone(differentName)
            .build();
    assertEquals(2, anotherRecord.rrdatas().size());
    assertEquals(differentName, anotherRecord.zoneName());
    assertTrue(anotherRecord.rrdatas().contains(testingRecord));
    assertTrue(anotherRecord.rrdatas().contains(anotherTestingRecord));
  }

  @Test
  public void testValidTtl() {
    try {
      DnsRecord.builder().ttl(-1);
      fail("A negative value is not acceptable for ttl.");
    } catch (IllegalArgumentException e) {
      // expected
    }
    DnsRecord.builder().ttl(0);
    DnsRecord.builder().ttl(Integer.MAX_VALUE);
  }

  @Test
  public void testEqualsAndNotEquals() {
    DnsRecord clone = record.toBuilder().build();
    assertEquals(clone, record);
    clone = record.toBuilder().add("another record").build();
    final String differentName = "totally different name";
    clone = record.toBuilder().name(differentName).build();
    assertNotEquals(clone, record);
    clone = record.toBuilder().ttl(record.ttl() + 1).build();
    assertNotEquals(clone, record);
    clone = record.toBuilder().type(DnsRecord.DnsRecordType.TXT).build();
    assertNotEquals(clone, record);
    ManagedZoneInfo anotherMock = EasyMock.createMock(ManagedZoneInfo.class);
    EasyMock.expect(anotherMock.id()).andReturn(ZONE_ID + 1);
    EasyMock.expect(anotherMock.name()).andReturn(ZONE_NAME + "more text");
    EasyMock.replay(anotherMock);
    clone = record.toBuilder().managedZone(anotherMock).build();
    assertNotEquals(clone, record);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = record.hashCode();
    DnsRecord clone = record.toBuilder().build();
    assertEquals(clone.hashCode(), hash);
  }

  @Test
  public void testDifferentHashCodeOnDifferent() {
    int hash = record.hashCode();
    final String differentName = "totally different name";
    DnsRecord clone = record.toBuilder().name(differentName).build();
    assertNotEquals(differentName, record.name());
    assertNotEquals(clone.hashCode(), hash);
    DnsRecord anotherClone = record.toBuilder().add("another record").build();
    assertNotEquals(anotherClone.hashCode(), hash);
  }

}
