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

import org.easymock.EasyMock;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class DnsRecordTest {

  private static final String NAME = "example.com.";
  private static final Integer TTL = 3600;
  private static final DnsRecord.DnsRecordType TYPE = DnsRecord.DnsRecordType.AAAA;
  private static final ManagedZoneInfo MANAGED_ZONE_INFO_MOCK
          = EasyMock.createMock(ManagedZoneInfo.class);
  private static final Long PARENT_ID = 12L;
  private static final String PARENT_NAME = "name";
  static {
    EasyMock.expect(MANAGED_ZONE_INFO_MOCK.id()).andReturn(PARENT_ID);
    EasyMock.expect(MANAGED_ZONE_INFO_MOCK.name()).andReturn(PARENT_NAME);
    EasyMock.replay(MANAGED_ZONE_INFO_MOCK);
  }
  private static final DnsRecord RECORD = DnsRecord.builder()
          .name(NAME)
          .ttl(TTL)
          .managedZone(MANAGED_ZONE_INFO_MOCK)
          .build();
  private static final Integer DEFAULT_TTL = 86400;

  @Test
  public void testDefaultDnsRecord() {
    DnsRecord record = DnsRecord.builder().build();
    assertEquals(DEFAULT_TTL, record.ttl());
    assertEquals(0, record.rrdatas().size());
  }

  @Test
  public void testBuilder() {

    assertEquals(NAME, RECORD.name());
    assertEquals(TTL, RECORD.ttl());

    assertEquals(PARENT_ID, RECORD.parentId()); // this was never assigned
    assertEquals(PARENT_NAME, RECORD.parentName());
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
      // ok
    }
    try {
      DnsRecord.builder().ttl(0);
    } catch (IllegalArgumentException e) {
      fail("0 is a valid value.");
    }
    try {
      DnsRecord.builder().ttl(Integer.MAX_VALUE);
    } catch (Exception e) {
      fail("Large numbers should be ok too.");
    }
  }

}
