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
  private static final ManagedZoneInfo MANAGED_ZONE_INFO_MOCK =
          EasyMock.createMock(ManagedZoneInfo.class);
  private static final Long ZONE_ID = 12L;
  private static final String ZONE_NAME = "name";

  static {
    EasyMock.expect(MANAGED_ZONE_INFO_MOCK.id()).andReturn(ZONE_ID);
    EasyMock.expect(MANAGED_ZONE_INFO_MOCK.name()).andReturn(ZONE_NAME);
    EasyMock.replay(MANAGED_ZONE_INFO_MOCK);
  }

  private static final DnsRecord RECORD = DnsRecord.builder()
          .name(NAME)
          .ttl(TTL)
          .managedZone(MANAGED_ZONE_INFO_MOCK)
          .build();

  @Test
  public void testDefaultDnsRecord() {
    DnsRecord record = DnsRecord.builder().build();
    assertEquals(0, record.rrdatas().size());
  }

  @Test
  public void testBuilder() {

    assertEquals(NAME, RECORD.name());
    assertEquals(TTL, RECORD.ttl());

    assertEquals(ZONE_ID, RECORD.zoneId()); // this was never assigned
    assertEquals(ZONE_NAME, RECORD.zoneName());
    assertEquals(0, RECORD.rrdatas().size());
    // verify that one can add records to the record set
    String testingRecord = "Testing record";
    String anotherTestingRecord = "Another record 123";
    DnsRecord anotherRecord = RECORD.toBuilder()
            .add(testingRecord)
            .add(anotherTestingRecord)
            .build();
    assertEquals(2, anotherRecord.rrdatas().size());
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
    DnsRecord clone = RECORD.toBuilder().build();
    assertEquals(clone, RECORD);
    clone = RECORD.toBuilder().add("another record").build();
    final String differentName = "totally different name";
    clone = RECORD.toBuilder().name(differentName).build();
    assertNotEquals(clone, RECORD);
    clone = RECORD.toBuilder().ttl(RECORD.ttl() + 1).build();
    assertNotEquals(clone, RECORD);
    clone = RECORD.toBuilder().type(DnsRecord.DnsRecordType.TXT).build();
    assertNotEquals(clone, RECORD);
    ManagedZoneInfo anotherMock = EasyMock.createMock(ManagedZoneInfo.class);
    EasyMock.expect(anotherMock.id()).andReturn(ZONE_ID + 1);
    EasyMock.expect(anotherMock.name()).andReturn(ZONE_NAME + "more text");
    EasyMock.replay(anotherMock);
    clone = RECORD.toBuilder().managedZone(anotherMock).build();
    assertNotEquals(clone, RECORD);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = RECORD.hashCode();
    DnsRecord clone = RECORD.toBuilder().build();
    assertEquals(clone.hashCode(), hash);
  }

  @Test
  public void testDifferentHashCodeOnDifferent() {
    int hash = RECORD.hashCode();
    final String differentName = "totally different name";
    DnsRecord clone = RECORD.toBuilder().name(differentName).build();
    assertNotEquals(differentName, RECORD.name());
    assertNotEquals(clone.hashCode(), hash);
    DnsRecord anotherClone = RECORD.toBuilder().add("another record").build();
    assertNotEquals(anotherClone.hashCode(), hash);
  }

}
